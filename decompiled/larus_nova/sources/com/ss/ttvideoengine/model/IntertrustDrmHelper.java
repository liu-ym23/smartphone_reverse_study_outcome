package com.ss.ttvideoengine.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import el9.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class IntertrustDrmHelper {
    public static final int DRM_ERROR_INTERNAL = -600000;
    public static final int DRM_ERROR_TOKEN_PROCESS = -600001;
    public static final int DRM_RESULT_FAIL = -1;
    public static final int DRM_RESULT_LIB_UNLOAD = -1000;
    public static final int DRM_RESULT_OK = 0;
    public static final int DRM_RESULT_PLUGIN_UNLOAD = -1002;
    public static final int DRM_RESULT_ROOT_DEVICE = -1003;
    public static final int DRM_RESULT_TOKEN_TEMPLATE_INVALID = -1001;
    private static final String INTERTRUST_DRM_LISTENER_PATH = "com.ss.ttm.drm.intertrust.IntertrustDrmProxy$IntertrustDrmProxyListener";
    private static final String INTERTRUST_DRM_NETWORK_LISTENER_PATH = "com.ss.ttm.drm.intertrust.IntertrustDrmProxy$IntertrustDrmProxyNetworkClient";
    private static final String INTERTRUST_DRM_PATH = "com.ss.ttm.drm.intertrust.IntertrustDrmProxy";
    public static final int MSG_IS_ERROR = 1;
    public static final int MSG_IS_SUCCESS = 0;
    private static final String TAG = "IntertrustDrmHelper";
    public static final int URL_TYPE_DASH = 2;
    public static final int URL_TYPE_HLS = 1;
    public static final int URL_TYPE_SINGLE = 0;
    private Class<?> mDrmClass;
    private Object mDrmNetworkCallback;
    private Handler mHandler;
    private Object mInstance;
    private Object mIntertrustCallback;
    private IntertrustDrmHelperListener mListener;
    private TTVNetClient mNetworkSession;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.model.IntertrustDrmHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface IntertrustDrmHelperListener {
        void onError(Error r100);

        void onTokenProcessed(Error r100);
    }

    public class MyHandler extends Handler {
        private WeakReference<IntertrustDrmHelper> mHelper;
        final /* synthetic */ IntertrustDrmHelper this$0;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            IntertrustDrmHelper r101 = this.mHelper.get();
            if (r101 != null) goto L5;
            return;
        L5:
            IntertrustDrmHelperListener r102 = IntertrustDrmHelper.access$700(r101);
            if (r102 != null) goto L8;
            return;
        L8:
            int r103 = r100.what;
            if (r103 != 0) goto L11;
            r102.onTokenProcessed(null);
            return;
        L11:
            if (r103 != 1) goto L17;
            r102.onError((Error) r100.obj);
            return;
        }

        public MyHandler(IntertrustDrmHelper r100, IntertrustDrmHelper r101, Looper r102) {
            this.this$0 = r100;
            super(r102);
            this.mHelper = new WeakReference(r101);
        }
    }

    public class MyIntertrustListener implements InvocationHandler {
        final /* synthetic */ IntertrustDrmHelper this$0;

        private MyIntertrustListener(IntertrustDrmHelper r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ MyIntertrustListener(IntertrustDrmHelper r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            TTVideoEngineLog.d(IntertrustDrmHelper.TAG, "intertrust listener invoke");
            String r103 = r101.getName();
            if (r103.equals("onTokenProcessed") == false) goto L6;
            IntertrustDrmHelper.access$300(this.this$0);
            return null;
        L6:
            if (r103.equals(LynxVideoManagerLite.EVENT_ON_ERROR) == false) goto L25;
            Object r104 = r102[0];
            int r105 = -1;
            if (r104 == null) goto L10;
            int r106 = ((Integer) r104).intValue();
        L11:
            Object r107 = r102[1];
            if (r107 == null) goto L14;
            r105 = ((Integer) r107).intValue();
        L14:
            Object r108 = r102[2];
            if (r108 == null) goto L17;
            String r109 = r108.toString();
        L19:
            if (r106 != (-600000)) goto L22;
            r106 = Error.IntertrustDrmInternalError;
        L24:
            IntertrustDrmHelper.access$400(this.this$0, new Error(Error.IntertrustDRM, r106, r105, r109));
            return null;
        L22:
            if (r106 != (-600001)) goto L24;
            r106 = Error.IntertrustDrmTokenProcessError;
            goto L24
        L17:
            r109 = "";
            goto L19
        L10:
            r106 = -1;
            goto L11
        L25:
            TTVideoEngineLog.w(IntertrustDrmHelper.TAG, "invalid method name:".concat(r103));
            return null;
        }
    }

    public class MyNetworkListener implements InvocationHandler {
        final /* synthetic */ IntertrustDrmHelper this$0;

        private MyNetworkListener(IntertrustDrmHelper r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ MyNetworkListener(IntertrustDrmHelper r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r110, Object[] r111) throws Throwable {
            TTVideoEngineLog.d(IntertrustDrmHelper.TAG, "network listener invoke");
            String r101 = r110.getName();
            if (r101.equals("startTask") == false) goto L18;
            Object r102 = r111[0];
            if (r102 == null) goto L7;
            String r103 = r102.toString();
        L8:
            String r104 = r103;
            Object r105 = r111[1];
            if (r105 == null) goto L11;
            Map<String, String> r106 = (Map) r105;
        L12:
            Object r107 = r111[2];
            if (r107 == null) goto L15;
            JSONObject r108 = (JSONObject) r107;
        L16:
            IntertrustDrmHelper.access$200(this.this$0).startTask(r104, r106, r108, 0, new myNetClientListener(this.this$0));
        L21:
            return null;
        L15:
            r108 = null;
            goto L16
        L11:
            r106 = null;
            goto L12
        L7:
            r103 = "";
            goto L8
        L18:
            if (r101.equals("cancel") == false) goto L20;
            IntertrustDrmHelper.access$200(this.this$0).cancel();
            goto L21
        L20:
            TTVideoEngineLog.w(IntertrustDrmHelper.TAG, "invalid method name:".concat(r101));
            goto L21
        }
    }

    public class myNetClientListener implements TTVNetClient.RawCompletionListener {
        final /* synthetic */ IntertrustDrmHelper this$0;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        public myNetClientListener(IntertrustDrmHelper r100) {
            this.this$0 = r100;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper$myNetClientListener_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        @Override // com.ss.ttvideoengine.net.TTVNetClient.RawCompletionListener
        public void onCompletion(String r100, Error r101) {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                Method dump skipped, instruction units count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.model.IntertrustDrmHelper.myNetClientListener.onCompletion(java.lang.String, com.ss.ttvideoengine.utils.Error):void");
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private void _notifySuccess() {
        Message r100 = this.mHandler.obtainMessage(0);
        this.mHandler.sendMessage(r100);
    }

    public void release() {
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
            java.lang.String r0 = "method invoke failied:"
            java.lang.String r1 = "release enter"
            java.lang.String r2 = "IntertrustDrmHelper"
            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r2, r1)
            java.lang.Object r1 = r6.mInstance
            if (r1 != 0) goto Lf
            return
        Lf:
            java.lang.Class<?> r1 = r6.mDrmClass     // Catch: java.lang.reflect.InvocationTargetException -> L32 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L5c java.lang.ClassNotFoundException -> L73
            if (r1 != 0) goto L1b
            java.lang.String r1 = "com.ss.ttm.drm.intertrust.IntertrustDrmProxy"
            java.lang.Class r1 = INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L32 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L5c java.lang.ClassNotFoundException -> L73
            r6.mDrmClass = r1     // Catch: java.lang.reflect.InvocationTargetException -> L32 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L5c java.lang.ClassNotFoundException -> L73
        L1b:
            java.lang.Class<?> r1 = r6.mDrmClass     // Catch: java.lang.reflect.InvocationTargetException -> L32 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L5c java.lang.ClassNotFoundException -> L73
            java.lang.String r3 = "release"
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L32 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L5c java.lang.ClassNotFoundException -> L73
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L32 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L5c java.lang.ClassNotFoundException -> L73
            java.lang.Object r3 = r6.mInstance     // Catch: java.lang.reflect.InvocationTargetException -> L32 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L5c java.lang.ClassNotFoundException -> L73
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L32 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L5c java.lang.ClassNotFoundException -> L73
            r1.invoke(r3, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L32 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L5c java.lang.ClassNotFoundException -> L73
            r0 = 0
            r6.mInstance = r0
            return
        L32:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = r1.getLocalizedMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r2, r0)
            return
        L47:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = r1.getLocalizedMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r2, r0)
            return
        L5c:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "method not found:"
            r1.<init>(r3)
            java.lang.String r0 = r0.getLocalizedMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r2, r0)
            return
        L73:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "class not found:"
            r1.<init>(r3)
            java.lang.String r0 = r0.getLocalizedMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.model.IntertrustDrmHelper.release():void");
    }

    public int start() {
        TTVideoEngineLog.d(TAG, "start enter");
        if (this.mInstance != null) goto L23;
        return -1;
    L23:
    L20:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "class not found:" + e.getLocalizedMessage());
        return -1;
    L14:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method invoke failied:" + e.getLocalizedMessage());
        return -1;
    L17:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method not found:" + e.getLocalizedMessage());
        return -1;
    L11:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method invoke failied:" + e.getLocalizedMessage());
        return -1;
    L6:
        if (this.mDrmClass != null) goto L8;
        this.mDrmClass = INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(INTERTRUST_DRM_PATH);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L14 NoSuchMethodException -> L17 ClassNotFoundException -> L20
    L8:
    L10:
        return ((Integer) this.mDrmClass.getDeclaredMethod("start", new Class[0]).invoke(this.mInstance, new Object[0])).intValue();
    }

    public int stop() {
        TTVideoEngineLog.d(TAG, "stop enter");
        if (this.mInstance != null) goto L23;
        return -1;
    L23:
    L20:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "class not found:" + e.getLocalizedMessage());
        return -1;
    L14:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method invoke failied:" + e.getLocalizedMessage());
        return -1;
    L17:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method not found:" + e.getLocalizedMessage());
        return -1;
    L11:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method invoke failied:" + e.getLocalizedMessage());
        return -1;
    L6:
        if (this.mDrmClass != null) goto L8;
        this.mDrmClass = INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(INTERTRUST_DRM_PATH);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L14 NoSuchMethodException -> L17 ClassNotFoundException -> L20
    L8:
    L10:
        return ((Integer) this.mDrmClass.getDeclaredMethod("stop", new Class[0]).invoke(this.mInstance, new Object[0])).intValue();
    }

    public IntertrustDrmHelper() {
        this.mDrmClass = null;
        this.mInstance = null;
        this.mIntertrustCallback = null;
        this.mDrmNetworkCallback = null;
        this.mNetworkSession = null;
        this.mListener = null;
        this.mHandler = null;
        this.mNetworkSession = new TTHTTPNetwork();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private void _notifyError(Error r100) {
        Message r101 = this.mHandler.obtainMessage(1, r100);
        this.mHandler.sendMessage(r101);
    }

    public static /* synthetic */ TTVNetClient access$200(IntertrustDrmHelper r100) {
        return r100.mNetworkSession;
    }

    public static /* synthetic */ void access$300(IntertrustDrmHelper r100) {
        r100._notifySuccess();
    }

    public static /* synthetic */ Object access$500(IntertrustDrmHelper r100) {
        return r100.mInstance;
    }

    public static /* synthetic */ Class access$600(IntertrustDrmHelper r100) {
        return r100.mDrmClass;
    }

    public static /* synthetic */ IntertrustDrmHelperListener access$700(IntertrustDrmHelper r100) {
        return r100.mListener;
    }

    public void setListener(IntertrustDrmHelperListener r100) {
        this.mListener = r100;
    }

    public void setTokenUrlTemplate(String r100) {
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
            java.lang.String r0 = "method invoke failied:"
            java.lang.String r1 = "setTokenUrlTemplate enter"
            java.lang.String r2 = "IntertrustDrmHelper"
            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r2, r1)
            java.lang.Object r1 = r8.mInstance
            if (r1 != 0) goto Lf
            return
        Lf:
            java.lang.Class<?> r1 = r8.mDrmClass     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
            if (r1 != 0) goto L1b
            java.lang.String r1 = "com.ss.ttm.drm.intertrust.IntertrustDrmProxy"
            java.lang.Class r1 = INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
            r8.mDrmClass = r1     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
        L1b:
            java.lang.Class<?> r1 = r8.mDrmClass     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
            java.lang.String r3 = "setTokenUrlTemplate"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
            java.lang.Object r3 = r8.mInstance     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
            r4[r7] = r9     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
            r1.invoke(r3, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L36 java.lang.IllegalAccessException -> L4b java.lang.NoSuchMethodException -> L60 java.lang.ClassNotFoundException -> L77
            return
        L36:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r9 = r9.getLocalizedMessage()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r2, r9)
            return
        L4b:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r9 = r9.getLocalizedMessage()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r2, r9)
            return
        L60:
            r9 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "method not found:"
            r0.<init>(r1)
            java.lang.String r9 = r9.getLocalizedMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r2, r9)
            return
        L77:
            r9 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "class not found:"
            r0.<init>(r1)
            java.lang.String r9 = r9.getLocalizedMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            com.ss.ttvideoengine.utils.TTVideoEngineLog.e(r2, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.model.IntertrustDrmHelper.setTokenUrlTemplate(java.lang.String):void");
    }

    public static /* synthetic */ void access$400(IntertrustDrmHelper r100, Error r101) {
        r100._notifyError(r101);
    }

    public static /* synthetic */ Class access$602(IntertrustDrmHelper r100, Class r101) {
        r100.mDrmClass = r101;
        return r101;
    }

    public int init(Context r110, int r111) {
        TTVideoEngineLog.d(TAG, "init enter");
        Class<?> r100 = INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(INTERTRUST_DRM_PATH);     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
        this.mDrmClass = r100;     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
        this.mInstance = r100.newInstance();     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
        Class<?> r101 = INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(INTERTRUST_DRM_LISTENER_PATH);     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
        AnonymousClass1 r102 = null;
        this.mIntertrustCallback = Proxy.newProxyInstance(IntertrustDrmHelper.class.getClassLoader(), new Class[]{r101}, new MyIntertrustListener(this, r102));     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
        this.mDrmClass.getDeclaredMethod("setListener", new Class[]{r101}).invoke(this.mInstance, new Object[]{this.mIntertrustCallback});     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
        Class<?> r103 = INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(INTERTRUST_DRM_NETWORK_LISTENER_PATH);     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
        this.mDrmNetworkCallback = Proxy.newProxyInstance(IntertrustDrmHelper.class.getClassLoader(), new Class[]{r103}, new MyNetworkListener(this, r102));     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
        this.mDrmClass.getDeclaredMethod("setNetworkClient", new Class[]{r103}).invoke(this.mInstance, new Object[]{this.mDrmNetworkCallback});     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
        if (r111 != 0) goto L7;
        Object r112 = this.mDrmClass.getDeclaredMethod("init", new Class[]{Context.class}).invoke(this.mInstance, new Object[]{r110});     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
    L8:
        this.mHandler = new MyHandler(this, this, TTHelper.getLooper());
        return ((Integer) r112).intValue();
    L7:
        r112 = this.mDrmClass.getDeclaredMethod("init", new Class[]{Context.class, Integer.TYPE}).invoke(this.mInstance, new Object[]{r110, Integer.valueOf(r111)});     // Catch: InvocationTargetException -> L10 NoSuchMethodException -> L13 IllegalAccessException -> L16 InstantiationException -> L19 ClassNotFoundException -> L22
    L22:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "class not found:" + e.getLocalizedMessage());
        return -1002;
    L16:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "illegal access exception:" + e.getLocalizedMessage());
        return -1;
    L19:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "instance failed+" + e.getLocalizedMessage());
        return -1;
    L13:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method not found:" + e.getLocalizedMessage());
        return -1;
    L10:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "invoke failed:" + e.getLocalizedMessage());
        return -1;
    }

    public String makeUrl(String r110, int r111) {
        TTVideoEngineLog.d(TAG, "makeUrl enter");
        if (this.mInstance != null) goto L23;
        return null;
    L23:
    L20:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "class not found:" + e.getLocalizedMessage());
        return null;
    L14:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method invoke failied:" + e.getLocalizedMessage());
        return null;
    L17:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method not found:" + e.getLocalizedMessage());
        return null;
    L11:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method invoke failied:" + e.getLocalizedMessage());
        return null;
    L6:
        if (this.mDrmClass != null) goto L8;
        this.mDrmClass = INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(INTERTRUST_DRM_PATH);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L14 NoSuchMethodException -> L17 ClassNotFoundException -> L20
    L8:
    L10:
        return (String) this.mDrmClass.getDeclaredMethod("makeUrl", new Class[]{String.class, Integer.TYPE}).invoke(this.mInstance, new Object[]{r110, Integer.valueOf(r111)});
    }

    public int processToken(int r110, String r111, String r112) {
        TTVideoEngineLog.d(TAG, "processToken enter");
        if (this.mInstance != null) goto L23;
        return -1;
    L23:
    L20:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "class not found:" + e.getLocalizedMessage());
        return -1;
    L14:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method invoke failied:" + e.getLocalizedMessage());
        return -1;
    L17:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method not found:" + e.getLocalizedMessage());
        return -1;
    L11:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "method invoke failied:" + e.getLocalizedMessage());
        return -1;
    L6:
        if (this.mDrmClass != null) goto L8;
        this.mDrmClass = INVOKESTATIC_com_ss_ttvideoengine_model_IntertrustDrmHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(INTERTRUST_DRM_PATH);     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L14 NoSuchMethodException -> L17 ClassNotFoundException -> L20
    L8:
    L10:
        return ((Integer) this.mDrmClass.getDeclaredMethod("processToken", new Class[]{Integer.TYPE, String.class, String.class}).invoke(this.mInstance, new Object[]{Integer.valueOf(r110), r111, r112})).intValue();
    }
}
