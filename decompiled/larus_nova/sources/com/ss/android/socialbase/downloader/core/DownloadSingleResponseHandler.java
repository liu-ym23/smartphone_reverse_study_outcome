package com.ss.android.socialbase.downloader.core;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.throttle.SmartThrottleInputStream;
import com.ss.android.socialbase.downloader.network.throttle.ThrottleInputStream;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadFileRandomAccess;
import java.io.InputStream;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadSingleResponseHandler {
    private static final int MIN_CACHE_TIME_MS = 1000;
    private static String TAG = "DownloadSingleResponseHandler";
    private IDownloadRunnableCallback mCallback;
    private volatile boolean mCanceled;
    private long mCurOffset;
    private IDownloadCache mDownloadCache;
    private long mDownloadChunkContentLen;
    private DownloadInfo mDownloadInfo;
    private IDownloadHttpConnection mHttpConnection;
    private boolean mIsFirstRead;
    private volatile boolean mNeedUpdateThrottleNetSpeed;
    private NetworkRetryStrategy mNetworkRetryStrategy;
    private volatile boolean mPaused;
    private DownloadSetting mSetting;

    private void cancelConnection() {
        if (this.mHttpConnection != null) goto L5;
        return;
    L5:
        DownloadComponentManager.submitIOTask(new AnonymousClass1(this), true);
    }

    private boolean isStoppedStatus() {
        if (this.mPaused == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mCanceled == true) goto L8;
        return false;
    }

    private void updateDB() {
        this.mDownloadInfo.updateRealDownloadTime(true);     // Catch: Exception -> L4
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void cancel() {
        if (this.mCanceled == false) goto L5;
        return;
    L5:
        this.mCanceled = true;
        cancelConnection();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 12841. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void handleResponse() throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0020: IGET (r0v107 ?? I:com.ss.android.socialbase.downloader.model.DownloadInfo) = (r30v0 'this' com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] (LINE:32) com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler.mDownloadInfo com.ss.android.socialbase.downloader.model.DownloadInfo in method: com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler.handleResponse():void, file: classes38.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler.handleResponse():void");
    }

    public void pause() {
        if (this.mPaused == false) goto L5;
        return;
    L5:
        this.mPaused = true;
        cancelConnection();
    }

    public long getCurOffset() {
        return this.mCurOffset;
    }

    public static /* synthetic */ IDownloadHttpConnection access$000(DownloadSingleResponseHandler r100) {
        return r100.mHttpConnection;
    }

    private byte[] readVerifyData(int r100) {
        DownloadFileRandomAccess r101 = new DownloadFileRandomAccess(new PolarisFileInputStreamWrapper(new PolarisFileWrapper(this.mDownloadInfo.getTempPath(), this.mDownloadInfo.getTempName())));     // Catch: Throwable -> L12
        r101.seek(this.mDownloadInfo.getCurBytes(), 0);     // Catch: Throwable -> L10
        byte[] r102 = new byte[r100];     // Catch: Throwable -> L10
        if (r101.read(r102, 0, r100) == r100) goto L29;
    L25:
        r101.close();     // Catch: Throwable -> L22
    L17:
        return null;
    L29:
        r101.close();     // Catch: Throwable -> L23
    L7:
        return r102;
    L10:
        th = th;
    L27:
        th.printStackTrace();     // Catch: Throwable -> L18
        if (r101 == null) goto L17;
    L18:
        th = move-exception;
        if (r101 != null) goto L33;
    L21:
        throw th;
    L33:
        r101.close();     // Catch: Throwable -> L24
    L12:
        th = th;
        r101 = null;
        goto L27
    }

    private InputStream updateThrottleForInputStream(InputStream r100) {
        if ((r100 instanceof ThrottleInputStream) == false) goto L5;
        ThrottleInputStream r101 = (ThrottleInputStream) r100;
    L6:
        r101.setThrottleNetSpeed(this.mDownloadInfo.getThrottleNetSpeed(), this.mDownloadInfo.getThrottleSmoothness());
        return r101;
    L5:
        r101 = new SmartThrottleInputStream(r100, (float) this.mSetting.optDouble(DownloadSettingKeys.THROTTLE_FACTOR_MIN, 0.10000000149011612d), (float) this.mSetting.optDouble(DownloadSettingKeys.THROTTLE_FACTOR_MAX, 0.699999988079071d));
        goto L6
    }

    public void setThrottleNetSpeed(long r100, int r101) {
        this.mDownloadInfo.setThrottleNetSpeed(r100, r101);
        this.mNeedUpdateThrottleNetSpeed = true;
    }

    private boolean checkDataEquals(byte[] r100, byte[] r101, int r102) {
        if (r100 != null) goto L5;
    L16:
        return true;
    L5:
        if (r100.length < r102) goto L16;
        if (r101 == null) goto L16;
        if (r101.length < r102) goto L16;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L16;
        if (r100[r103] != r101[r103]) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        return false;
    }

    public DownloadSingleResponseHandler(DownloadCommonParams r100, IDownloadHttpConnection r101, long r102, long r103, IDownloadRunnableCallback r104) {
        this.mIsFirstRead = true;
        this.mDownloadInfo = r100.mDownloadInfo;
        this.mDownloadCache = r100.mDownloadCache;
        this.mNetworkRetryStrategy = r100.mRetryStrategy;
        this.mSetting = r100.mSetting;
        this.mHttpConnection = r101;
        this.mCurOffset = r102;
        this.mDownloadChunkContentLen = r103;
        this.mCallback = r104;
    }
}
