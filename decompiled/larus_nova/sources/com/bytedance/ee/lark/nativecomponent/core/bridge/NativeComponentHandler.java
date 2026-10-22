package com.bytedance.ee.lark.nativecomponent.core.bridge;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.p.e;
import com.bytedance.ee.lark.nativecomponent.core.debug.BridgeDebug;
import com.bytedance.ee.lark.nativecomponent.service.NativeRenderType;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.officewebview.webview_api.bridge.Status;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import ts5.d;

/* JADX INFO: loaded from: classes19.dex */
public final class NativeComponentHandler implements qxb.a<String, pxb.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f242814d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f242815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ks5.c f242816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BridgeDebug f242817c;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f242818a = null;

        static {
            int[] r100 = new int[NativeRenderType.values().length];
            r100[NativeRenderType.OVERLAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[NativeRenderType.SANDWICH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f242818a = r100;
        }
    }

    static {
    }

    @Override // qxb.a
    public final void shouldRunInUIThread() {
    }

    public final d f() {
        pxb.a r100 = this.f242816b.f505934b;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        txb.b r101 = r100.getServiceManager();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (d) r101.getService(d.class);
    }

    public final txb.a g() {
        pxb.a r100 = this.f242816b.f505934b;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        txb.b r101 = r100.getServiceManager();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (txb.a) r101.getService(txb.a.class);
    }

    public static sxb.a d(final ks5.b r110, JSONObject r111) {
        JSONObject r100 = r111.optJSONObject("style");
        if (r100 == null) goto L5;
        Function1<Double, Integer> r101 = new NativeComponentHandler$createOverlayNativeViewParams$1$converter$1(r110);
        int r102 = r101.invoke(Double.valueOf(r100.optDouble("width", AudioStats.AUDIO_AMPLITUDE_NONE))).intValue();
        int r103 = r101.invoke(Double.valueOf(r100.optDouble("height", AudioStats.AUDIO_AMPLITUDE_NONE))).intValue();
        int r104 = r101.invoke(Double.valueOf(r100.optDouble("left", AudioStats.AUDIO_AMPLITUDE_NONE))).intValue();
        int r112 = r101.invoke(Double.valueOf(r100.optDouble("top", AudioStats.AUDIO_AMPLITUDE_NONE))).intValue();
        int r113 = r102;
        int r114 = r103;
        int r115 = r104;
    L7:
        if (r111.optBoolean("autoSize") == false) goto L10;
        r110.f505921f.b();
    L10:
        return new sxb.a(r113, r114, r115, r112, r111.optInt("zIndex", 0), r111.optBoolean("fixed", false));
    L5:
        r113 = 0;
        r114 = 0;
        r115 = 0;
        r112 = 0;
        goto L7
    }

    public NativeComponentHandler(String r100, ks5.c r101, BridgeDebug r102) {
        Intrinsics.checkNotNullParameter(r100, "mHandlerName");
        Intrinsics.checkNotNullParameter(r101, "mNativeComponentWebViewContext");
        Intrinsics.checkNotNullParameter(r102, "mBridgeDebug");
        this.f242815a = r100;
        this.f242816b = r101;
        this.f242817c = r102;
    }

    @Override // qxb.a
    public final void a(Object r110, qxb.c r111, pxb.a r112) {
        String r100 = (String) r110;
        Intrinsics.checkNotNullParameter(r111, "callback");
        OPTrace r113 = gyb.a.a().subTrace(this.f242815a);
        OPMonitorCode r101 = new OPMonitorCode("client.open_platform.api.common", 10002, OPMonitorLevel.NORMAL, "native_receive_invoke");
        boolean r102 = false;
        String r103 = "";
        if (r100 != null) goto L48;
        String r104 = "";
        String r114 = r104;
    L17:
        String r105 = r103;
        r103 = r104;
    L18:
        boolean r106 = false;
    L19:
        OPMonitor r115 = new OPMonitor(r101);
        r115.addCategoryValue("api_name", this.f242815a);
        if (r100 == null) goto L22;
        int r107 = r100.length();
    L23:
        r115.addCategoryValue("param.length", Integer.valueOf(r107));
        r115.addCategoryValue("is_native_component", 1);
        r115.addCategoryValue("native_component_type", r105);
        r115.addCategoryValue("render_type", r103);
        if (TextUtils.isEmpty(r114) == true) goto L26;
        r115.addCategoryValue("native_component_method", r114);
    L26:
        r115.addCategoryValue("native_component_hide", Boolean.valueOf(r106));
        r115.flush(r113);
        if (r100 != null) goto L29;
    L30:
        r102 = true;
    L31:
        if (r102 == false) goto L33;
        c(this, null, c.f242825i, null, r111, Status.FAILURE, new JSONObject(), r113);
        this.f242816b.f505935c.i("NativeComponentHandler", "data is empty");
        return;
    L33:
        pxb.a r108 = this.f242816b.f505934b;
        Intrinsics.checkNotNullParameter(r108, "<this>");
        txb.b r109 = r108.getServiceManager();
        if (r109 == null) goto L36;
        ts5.b r116 = (ts5.b) r109.getService(ts5.b.class);
    L37:
        if (r116 != null) goto L51;
        this.f242816b.f505935c.e("NativeComponentHandler", "registerHandler, INativeComponentFactoryService is null, handlerName = " + this.f242815a);
        return;
    L51:
        JSONObject r117 = new JSONObject(r100);     // Catch: JSONException -> L44
        String r118 = r117.optString("type");     // Catch: JSONException -> L44
        Intrinsics.checkNotNull(r118);     // Catch: JSONException -> L44
        if (r116.s(r112, r118) != null) goto L42;
        this.f242816b.f505935c.e("NativeComponentHandler", "NativeComponentHandler handle, component: " + r118 + " not registered");     // Catch: JSONException -> L44
        c(this, null, c.f242823g, r117, r111, Status.FAILURE, r117, r113);     // Catch: JSONException -> L44
    L50:
        return;
    L42:
        e(r117, r111, r112, r113);     // Catch: JSONException -> L44
    L44:
        e = move-exception;
        this.f242816b.f505935c.i("NativeComponentHandler", "NativeComponentHandler error, handler = " + this.f242815a + " e: " + e);
        c(this, null, c.f242825i, null, r111, Status.FAILURE, new JSONObject(), r113);
        return;
    L36:
        r116 = null;
        goto L37
    L29:
        if (r100.length() != 0) goto L31;
    L22:
        r107 = 0;
        goto L23
    L48:
        JSONObject r119 = new JSONObject(r100);     // Catch: JSONException -> L14
        r105 = r119.optString("type");     // Catch: JSONException -> L14
        r114 = r119.optString(e.f25671s);     // Catch: JSONException -> L12
        r103 = r119.optString("finalRenderType");     // Catch: JSONException -> L47
        JSONObject r120 = r119.optJSONObject("data");     // Catch: JSONException -> L47
        if (r120 == null) goto L18;
        JSONObject r121 = r120.optJSONObject("style");     // Catch: JSONException -> L47
        if (r121 == null) goto L18;
        r106 = r121.optBoolean("hide");     // Catch: JSONException -> L47
    L13:
        r104 = r103;
        r103 = r105;
    L15:
        this.f242816b.f505935c.e("NativeComponentHandler", "monitorReceiveInvoke, json parse error");
    L12:
        r114 = "";
    L14:
        r104 = "";
        r114 = r104;
        goto L15
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v18 ??, still in use, count: 1, list:
          (r8v18 ?? I:ts5.e) from 0x0308: INVOKE (r5v47 ?? I:ks5.b) = (r5v46 ?? I:ts5.b), (r7v27 ?? I:ks5.c), (r8v18 ?? I:ts5.e) INTERFACE call: ts5.b.v(ks5.c, ts5.e):ks5.b A[Catch: JSONException -> 0x03f7, MD:(ks5.c, ts5.e):ks5.b (m)] (LINE:67109640)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final void e(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v18 ??, still in use, count: 1, list:
          (r8v18 ?? I:ts5.e) from 0x0308: INVOKE (r5v47 ?? I:ks5.b) = (r5v46 ?? I:ts5.b), (r7v27 ?? I:ks5.c), (r8v18 ?? I:ts5.e) INTERFACE call: ts5.b.v(ks5.c, ts5.e):ks5.b A[Catch: JSONException -> 0x03f7, MD:(ks5.c, ts5.e):ks5.b (m)] (LINE:67109640)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r23v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
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

    public static /* synthetic */ void c(NativeComponentHandler r100, String r110, c r111, JSONObject r112, qxb.c r113, Status r114, JSONObject r115, OPTrace r116) {
        r100.b(r110, r111, r112, r113, r114, r115, r116, null);
    }

    public final void b(String r110, c r111, JSONObject r112, qxb.c r113, Status r210, JSONObject r211, OPTrace r212, String r213) {
        rxb.c r100 = this.f242816b.f505935c;
        StringBuilder r101 = new StringBuilder("callbackResult, handleName = ");
        r101.append(this.f242815a);
        r101.append(" status = ");
        r101.append(r210);
        String r102 = "";
        if (r213 == null) goto L5;
        String r103 = ", eventName=".concat(r213);
    L6:
        r101.append(r103);
        r100.b("NativeComponentHandler", r110, r101.toString());
        OPMonitorCode r104 = new OPMonitorCode("client.open_platform.api.common", 10003, OPMonitorLevel.NORMAL, "native_callback_invoke");
        boolean r105 = false;
        if (r112 == null) goto L15;
        String r106 = r112.optString("type");
        String r107 = r112.optString(e.f25671s);
        JSONObject r108 = r112.optJSONObject("data");
        if (r108 == null) goto L13;
        JSONObject r109 = r108.optJSONObject("style");
        if (r109 == null) goto L13;
        boolean r114 = r109.optBoolean("hide");
    L14:
        r102 = r107;
        String r115 = r106;
    L16:
        OPMonitor r116 = new OPMonitor(r104);
        r116.addCategoryValue("errMsg", r111.f242830c);
        r116.addCategoryValue(LKBaseResponseModel.INNER_MSG_KEY, r111.f242830c);
        r116.addCategoryValue("errCode", Integer.valueOf(r111.f242828a));
        r116.addCategoryValue(LKBaseResponseModel.INNER_CODE_KEY, Integer.valueOf(r111.f242829b));
        Integer r117 = r111.f242831d;
        ts5.c r118 = null;
        if (r117 != null) goto L19;
    L27:
        String r119 = r111.f242832e;
        if (r119 != null) goto L30;
    L37:
        r116.setDuration(SystemClock.elapsedRealtime() - r212.createTime());
        r116.addCategoryValue("is_native_component", 1);
        r116.addCategoryValue("native_component_type", r115);
        if (TextUtils.isEmpty(r102) == true) goto L40;
        r116.addCategoryValue("native_component_method", r102);
    L40:
        r116.addCategoryValue("native_component_hide", Boolean.valueOf(r114));
        if (r210 != Status.SUCCESS) goto L43;
        r116.setResultTypeSuccess();
    L44:
        r116.flush(r212);
        OPTrace.Companion.getClass();
        r212.finish(new OPMonitor(OPTrace.BATCH_EVENT_NAME, OPTrace.access$getBATCH_MONITOR_CODE$cp()));
        pxb.a r120 = this.f242816b.f505934b;
        Intrinsics.checkNotNullParameter(r120, "<this>");
        txb.b r121 = r120.getServiceManager();
        if (r121 == null) goto L47;
        r118 = (ts5.c) r121.getService(ts5.c.class);
    L47:
        if (r118 == null) goto L54;
        List<ss5.a> r122 = r118.t();
        if (r122 == null) goto L54;
        Iterator<T> r123 = r122.iterator();
    L52:
        if (r123.hasNext() == false) goto L54;
        ((ss5.a) r123.next()).a();
    L54:
        r113.a(r210, r211);
        return;
    L43:
        r116.setResultTypeFail();
        goto L44
    L30:
        if (r119.length() <= 0) goto L32;
        r105 = true;
    L32:
        if (r105 == true) goto L35;
        r119 = null;
    L35:
        if (r119 == null) goto L37;
        r116.addCategoryValue(LKBaseResponseModel.ERROR_STRING_KEY, r119);
        goto L37
    L19:
        if (r117.intValue() <= 0) goto L21;
        boolean r124 = true;
    L22:
        if (r124 == true) goto L25;
        r117 = null;
    L25:
        if (r117 == null) goto L27;
        r116.addCategoryValue(LKBaseResponseModel.ERROR_NO_KEY, Integer.valueOf(r117.intValue()));
        goto L27
    L21:
        r124 = false;
    L13:
        r114 = false;
        goto L14
    L15:
        r115 = "";
        r114 = false;
        goto L16
    L5:
        r103 = "";
        goto L6
    }
}
