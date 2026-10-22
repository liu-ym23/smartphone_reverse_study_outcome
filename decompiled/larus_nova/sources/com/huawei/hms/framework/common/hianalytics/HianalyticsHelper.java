package com.huawei.hms.framework.common.hianalytics;

import android.content.Context;
import android.provider.Settings;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.common.CommonActivityUtil;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.utils.HMSBIInitializer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class HianalyticsHelper {
    private static final String DEAULT_HA_SERVICE_TAG = "_default_config_tag";
    private static final String HWID_HA_SERVICE_TAG = "hms_hwid";
    private static final String TAG = "HianalyticsHelper";
    private static final int TYPE_MAINTF = 1;
    private static final String USER_EXPERIENCE_INVOLVED = "user_experience_involved";
    private static final int USER_EXPERIENCE_ON = 1;
    private static volatile HianalyticsHelper instance;
    private boolean bInstallWelink;
    private boolean bQuicReportable;
    private boolean bReportable;
    private HiAnalyticsInstance hInstance;
    private String haTag;
    private boolean hasHMSBI;
    private boolean hasHianalytics;
    private boolean isEnablePrivacyPolicy;
    private final int random;
    private ReportCallBack reportCallback;
    private ExecutorService reportExecutor;

    public static class HianalyticsRunnable implements Runnable {
        private final HianalyticsBaseData data;
        private final String event;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_framework_common_hianalytics_HianalyticsHelper$HianalyticsRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_framework_common_hianalytics_HianalyticsHelper$HianalyticsRunnable__run$___twin___() {
            HianalyticsHelper.getInstance().onEvent(this.data.get(), this.event);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_framework_common_hianalytics_HianalyticsHelper$HianalyticsRunnable_com_larus_apm_impl_protector_RunnableLancet_run(HianalyticsRunnable r100) {
            r100.com_huawei_hms_framework_common_hianalytics_HianalyticsHelper$HianalyticsRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public HianalyticsRunnable(HianalyticsBaseData r100, String r101) {
            this.data = r100;
            this.event = r101;
        }
    }

    public interface ReportCallBack {
        void onReport(int r100, String r101, LinkedHashMap<String, String> r102);
    }

    private HianalyticsHelper() {
        this.haTag = HWID_HA_SERVICE_TAG;
        this.hInstance = null;
        this.isEnablePrivacyPolicy = false;
        this.reportExecutor = ExecutorsUtils.newSingleThreadExecutor("report");
        this.bReportable = true;
        this.bQuicReportable = true;
        this.random = new SecureRandom().nextInt(1000);
        HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG);     // Catch: Throwable -> L5
        this.hasHianalytics = true;     // Catch: Throwable -> L5
    L7:
        if (this.hasHianalytics == true) goto L20;
        tryHMSBIInit(ContextHolder.getAppContext());
    L20:
    L15:
        this.bInstallWelink = false;
    L16:
        Logger.v(TAG, "this time the ha %s, mini %s", new Object[]{Boolean.valueOf(this.hasHianalytics), Boolean.valueOf(this.hasHMSBI)});
        return;
    L10:
        if (ContextHolder.getAppContext().getPackageManager().getPackageInfo("com.huawei.works", 0) == null) goto L12;
        boolean r100 = true;
    L13:
        this.bInstallWelink = r100;     // Catch: Exception -> L15
        goto L16
    L12:
        r100 = false;
    L5:
        Logger.i(TAG, "Hianalytics sdk not found");
        this.hasHianalytics = false;
        goto L7
    }

    public static HianalyticsHelper getInstance() {
        if (instance != null) goto L15;
        monitor-enter(HianalyticsHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new HianalyticsHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(HianalyticsHelper.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private boolean isHianalyticsOk() {
        if (this.hInstance == null) goto L5;
        return true;
    L5:
        if (HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG) == false) goto L7;
        this.hInstance = HiAnalyticsManager.getInstanceByTag(DEAULT_HA_SERVICE_TAG);
    L9:
        if (this.hInstance != null) goto L14;
        return false;
    L14:
        return true;
    L7:
        this.hInstance = HiAnalyticsManager.getInstanceByTag(this.haTag);
        goto L9
    }

    public ExecutorService getReportExecutor() {
        return this.reportExecutor;
    }

    public boolean inRate() {
        return this.bReportable;
    }

    private void tryHMSBIInit(Context r100) {
        if (r100 != null) goto L11;
        Logger.i(TAG, "the appContext hasn't init");
        return;
    L11:
        HMSBIInitializer.getInstance(r100).initBI();     // Catch: Throwable -> L8 NoClassDefFoundError -> L9
        this.hasHMSBI = true;     // Catch: Throwable -> L8 NoClassDefFoundError -> L9
    L14:
        return;
    L9:
        Logger.w(TAG, "maybe you need add base sdk!");
        return;
    L8:
        Logger.w(TAG, "the hms base has other error!");
    }

    public void enablePrivacyPolicy(boolean r100) {
        this.isEnablePrivacyPolicy = r100;
    }

    public boolean isEnableReport(Context r100) {
        return isEnableReport(r100, true, false);
    }

    public boolean isEnableReportNoSeed(Context r100) {
        return isEnableReport(r100, false, false);
    }

    public boolean isQuicEnableReport(Context r100) {
        return isEnableReport(r100, true, true);
    }

    public void onEvent(LinkedHashMap<String, String> r100) {
        onEvent(r100, HianalyticsBaseData.EVENT_ID);
    }

    public void setHaTag(String r100) {
        this.haTag = r100;
    }

    public void setQuicRate(int r100) {
        boolean r101 = true;
        if (r100 >= 0) goto L5;
    L15:
        this.bQuicReportable = true;
        return;
    L5:
        if (r100 >= 1000) goto L15;
        if (this.random >= r100) goto L10;
    L13:
        this.bQuicReportable = r101;
        return;
    L10:
        if (this.bInstallWelink == true) goto L13;
        r101 = false;
        goto L13
    }

    public void setRate(int r100) {
        boolean r101 = true;
        if (r100 >= 0) goto L5;
    L15:
        this.bReportable = true;
        return;
    L5:
        if (r100 >= 1000) goto L15;
        if (this.random >= r100) goto L10;
    L13:
        this.bReportable = r101;
        Logger.i(TAG, "bReportable = " + this.bReportable + ", inuser = " + this.bInstallWelink + ", rate = " + r100);
        return;
    L10:
        if (this.bInstallWelink == true) goto L13;
        r101 = false;
        goto L13
    }

    public void setReportCallback(ReportCallBack r100) {
        this.reportCallback = r100;
    }

    public void executeReportHa(HianalyticsBaseData r100, String r101) {
        getReportExecutor().execute(new HianalyticsRunnable(r100, r101));
    }

    public void onEvent(LinkedHashMap<String, String> r100, String r101) {
        onEvent(r100, r101, 1);
    }

    public void reportException(final Throwable r100, final String r101) {
        if (getInstance().isEnableReportNoSeed(ContextHolder.getAppContext()) == true) goto L5;
        return;
    L5:
        final String r102 = Thread.currentThread().getName();
        InitReport.reportWhenInit(new AnonymousClass1(this, r102, r100, r101));
    }

    private boolean isEnableReport(Context r100, boolean r101, boolean r102) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
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
            */
        /*
            this = this;
            java.lang.String r0 = "HianalyticsHelper"
            com.huawei.hms.framework.common.hianalytics.HianalyticsHelper$ReportCallBack r1 = r3.reportCallback
            r2 = 1
            if (r1 == 0) goto L8
            return r2
        L8:
            r1 = 0
            if (r5 == 0) goto L18
            if (r6 == 0) goto L11
            boolean r5 = r3.bQuicReportable
            if (r5 == 0) goto L17
        L11:
            if (r6 != 0) goto L18
            boolean r5 = r3.bReportable
            if (r5 != 0) goto L18
        L17:
            return r1
        L18:
            boolean r5 = r3.hasHMSBI
            if (r5 == 0) goto L1d
            return r2
        L1d:
            boolean r5 = r3.hasHianalytics
            if (r5 != 0) goto L22
            return r1
        L22:
            boolean r5 = r3.isEnablePrivacyPolicy
            if (r5 == 0) goto L2b
            boolean r4 = r3.isHianalyticsOk()
            return r4
        L2b:
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r5 = "user_experience_involved"
            r6 = -1
            int r4 = android.provider.Settings.Secure.getInt(r4, r5, r6)     // Catch: java.lang.Throwable -> L3d java.lang.IllegalStateException -> L43
            if (r4 != r2) goto L48
            boolean r4 = r3.isHianalyticsOk()     // Catch: java.lang.Throwable -> L3d java.lang.IllegalStateException -> L43
            return r4
        L3d:
            java.lang.String r4 = "the setting has other error"
            com.huawei.hms.framework.common.Logger.w(r0, r4)
            goto L48
        L43:
            java.lang.String r4 = "the setting has illegalStateException"
            com.huawei.hms.framework.common.Logger.w(r0, r4)
        L48:
            java.lang.String r4 = "user experience involved needs to be opened"
            com.huawei.hms.framework.common.Logger.i(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.isEnableReport(android.content.Context, boolean, boolean):boolean");
    }

    public void onEvent(LinkedHashMap<String, String> r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.put("in_user", "" + (this.bInstallWelink ? 1 : 0));
        if (CommonActivityUtil.getInstance().isRegistered() == false) goto L7;
        r100.put("foreground", "" + (CommonActivityUtil.getInstance().isForeground() ? 1 : 0));
    L7:
        Logger.v(TAG, "data = %s", new Object[]{r100});
        ReportCallBack r103 = this.reportCallback;
        if (r103 == null) goto L12;
        r103.onReport(r102, r101, r100);
        return;
    L12:
        if (this.hasHMSBI == false) goto L14;
        onNewEvent(ContextHolder.getAppContext(), r101, r100, r102);
    L18:
        if (this.hasHianalytics == true) goto L20;
        return;
    L20:
        HiAnalyticsInstance r104 = this.hInstance;
        if (r104 == null) goto L23;
        r104.onEvent(1, r101, r100);
        return;
    L23:
        Logger.e(TAG, "the ha has error,has init but is null!");
        return;
    L14:
        if (r102 != 0) goto L18;
        Logger.v(TAG, "the base sdk isn't exsit, and reportType is %s", new Object[]{Integer.valueOf(r102)});
    }

    private void onNewEvent(Context r100, String r101, Map r102, int r103) {
        if (r100 == null) goto L13;
        if (r102 == null) goto L15;
        Logger.v(TAG, "data = %s", new Object[]{r102});
        HiAnalyticsUtils.getInstance().onNewEvent(r100, r101, r102, r103);     // Catch: Throwable -> L8 NoSuchMethodError -> L9
    L16:
        return;
    L9:
        Logger.w(TAG, "may be you need upgrade stats sdk");
        return;
    L8:
        Logger.i(TAG, "the stats has other error,pls check it");
        return;
    L15:
        return;
    }

    public void reportData(Context r100, LinkedHashMap<String, String> r101, String r102, int r103) {
        if (isEnableReportNoSeed(r100) == true) goto L5;
        return;
    L5:
        onEvent(r101, r102, r103);
    }
}
