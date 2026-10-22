package com.larus.camera.impl.utils;

import android.os.SystemClock;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.ixigua.lib.track.TrackParams;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.entity.EduIntentMode;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class r extends i implements j0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f322797j = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ICameraEventExt f322798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f322799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f322800i;

    public static final class a {
        public static String a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "captureMode");
            switch(r100.hashCode()) {
                case -1332250801: goto L18;
                case -861871587: goto L14;
                case 358782896: goto L10;
                case 1556930703: goto L6;
                default: goto L21;
            };
        L21:
            return "general";
        L6:
            if (r100.equals("CAPTURE_MODE_EDU_GENERAL_PHOTO") == false) goto L21;
            return "qa_take_photos";
        L10:
            if (r100.equals("CAPTURE_MODE_EDU_CALCULATION_PHOTO") == false) goto L21;
            return "oral_calculation";
        L14:
            if (r100.equals("CAPTURE_MODE_EDU_ARTICLE_PHOTO") == false) goto L21;
            return "essay_report";
        L18:
            if (r100.equals("CAPTURE_MODE_EDU_HOMEWORK_PHOTO") == false) goto L21;
            return "check";
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f322801a = null;

        static {
            int[] r100 = new int[OutputParam.ResultType.values().length];
            r100[OutputParam.ResultType.PHOTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[OutputParam.ResultType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f322801a = r100;
        }
    }

    static {
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void O(Integer r100) {
        throw null;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void E0() {
        com.larus.platform.service.o r100 = com.larus.platform.service.o.f365780a;
        JSONObject r101 = new JSONObject();
        r101.put("current_page", "picture_crop");
        r101.put("previous_page", "camera_confirm");
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent(CheckPointType.ENTER_PAGE, r101);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void y() {
        this.f322778c++;
        FLogger.f375446a.i("CameraTracer", "autoRecordCameraTipsCount seeCount=" + this.f322778c);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void A0() {
        this.f322779d = SystemClock.elapsedRealtime();
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void C() {
        this.f322799h = SystemClock.elapsedRealtime();
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void C0(String r110) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.P0(this, "camera_action", "flash", r110, this.f322798g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void I(String r110) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.P0(this, "album_authorization", "authorize", r110, this.f322798g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void I0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "captureMode");
        U0(SystemClock.elapsedRealtime() - this.f322799h, "switch_tab", true, r100, this.f322798g, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void K(String r110) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.P0(this, "album_authorization", "unauthorize", r110, this.f322798g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void L(String r110) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.P0(this, "camera_action", "album", r110, this.f322798g, null, null, null, null, 240);
        i.R0(r110, "camera_page_icon", "camera_page_icon", this.f322798g);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void N(String r110) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.P0(this, "camera_action", "torch", r110, this.f322798g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "captureMode");
        i.X0("album_authorization", r100, this.f322798g, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.P0(this, "camera_action", ButtonColorBean.StateFocus, r110, this.f322798g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void f0(CaptureResultDetectLogic.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mobInfo");
        Intrinsics.checkNotNullParameter(r100, "mobInfo");
        JSONObject r101 = new JSONObject();
        r101.put("status", r100.f322700a);
        r101.put("duration", r100.f322701b);
        r101.put("error_msg", r100.f322705f);
        r101.put("pre_process_duration", r100.f322702c);
        r101.put("original_image_size", r100.f322703d);
        r101.put("compressed_image_size", r100.f322704e);
        com.larus.platform.service.o.f365780a.reportEvent("camera_capture_intent_detect", r101);
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("camera_capture_intent_detect", r101, null, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void o(String r110) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.P0(this, "camera_action", "select_photo", r110, this.f322798g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void z0(String r110) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.P0(this, "camera_action", "take", r110, this.f322798g, null, null, null, null, 240);
    }

    public r(ICameraEventExt r100, com.larus.camera.impl.ui.base.f r101) {
        super(r101);
        this.f322798g = r100;
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void D0(String r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.Q0(this, "confirm", r110, this.f322798g, r111, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void H0(boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "captureMode");
        U0(SystemClock.elapsedRealtime() - this.f322799h, "click_leave", r110, r111, this.f322798g, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void K0(boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "captureMode");
        U0(SystemClock.elapsedRealtime() - this.f322799h, "click_album", r110, r111, this.f322798g, null);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void T(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        Intrinsics.checkNotNullParameter(r111, "button");
        i.P0(this, "camera_action", r111, r110, this.f322798g, null, null, null, null, 240);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void V(String r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.Q0(this, "input_function_switch", r110, this.f322798g, r111, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void Y(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        Intrinsics.checkNotNullParameter(r111, "toCaptureMode");
        i.P0(this, "camera_action", "switch_tab", r110, this.f322798g, r111, null, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void a0(String r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.Q0(this, "download", r110, this.f322798g, r111, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void e0(String r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.Q0(this, "rotate", r110, this.f322798g, r111, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void k0(OutputParam.ResultType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "contentType");
        int r102 = b.f322801a[r100.ordinal()];
        if (r102 != 1) goto L5;
        String r103 = "pic";
    L10:
        this.f322780e = r103;
        if (r101 == false) goto L13;
        String r104 = "upload";
    L14:
        this.f322781f = r104;
        return;
    L13:
        r104 = "shoot";
        goto L14
    L5:
        if (r102 != 2) goto L8;
        r103 = "video";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void m(String r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == false) goto L5;
        String r100 = "single_question_mode";
    L6:
        i.Q0(this, r100, r110, this.f322798g, r111, null, null, 224);
        return;
    L5:
        r100 = "multi_question_mode";
        goto L6
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void m0(boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "captureMode");
        long r100 = SystemClock.elapsedRealtime() - this.f322799h;
        ICameraEventExt r112 = this.f322798g;
        if (this.f322779d <= 0) goto L5;
        Long r101 = Long.valueOf(SystemClock.elapsedRealtime() - this.f322779d);
    L6:
        U0(r100, "success", r110, r111, r112, r101);
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void o0(boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "captureMode");
        this.f322799h = SystemClock.elapsedRealtime();
        ICameraEventExt r100 = this.f322798g;
        Intrinsics.checkNotNullParameter(r111, "captureMode");
        x r101 = this.f322776a;
        if (r101 == null) goto L5;
        String r102 = r101.a();
    L6:
        if (r100 == null) goto L10;
        JSONObject r103 = r100.enterPageEventExt();
        if (r103 == null) goto L10;
        String r104 = r103.optString("current_page");
    L11:
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        r104 = "camera";
    L19:
        i.T0(r104, r111, r102, null, r100);
        Map<String, String> r106 = IAIChatRenderTraceService.f365896a.i();
        if (r106 == null) goto L22;
        String r107 = r106.get("key_current_page");
    L22:
        i.S0("camera", r110, r111, null, r102, r100);
        return;
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
    L10:
        r104 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void q(String r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.Q0(this, "input_icon", r110, this.f322798g, r111, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void r0(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        JSONObject r103 = new JSONObject();
        r103.put("camera_type", i.N0(r101));
        r103.put("success", r100);
        r103.put("picture_from", "takePhoto");
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("camera_validate_result", r103);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void v0(String r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.Q0(this, "retake", r110, this.f322798g, r111, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void x(String r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.Q0(this, "input", r110, this.f322798g, r111, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void D(boolean r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "captureMode");
        this.f322800i = SystemClock.elapsedRealtime();
        ICameraEventExt r100 = this.f322798g;
        Intrinsics.checkNotNullParameter(r112, "captureMode");
        x r101 = this.f322776a;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.a();
    L6:
        if (r111 == false) goto L8;
        r102 = "album";
    L8:
        i.T0("camera_confirm", r112, r103, r102, r100);
        i.S0("camera_confirm", r110, r112, Boolean.valueOf(r111), r103, r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void J(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("camera", "currentPage");
        Intrinsics.checkNotNullParameter(r100, "captureMode");
        Intrinsics.checkNotNullParameter(r101, "clickFrom");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        i.R0(r100, r101, r102, this.f322798g);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void J0(String r110, String r111, Boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        Intrinsics.checkNotNullParameter(r111, "button");
        i.Q0(this, r111, r110, this.f322798g, r112, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void M(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        Intrinsics.checkNotNullParameter(r111, "buttonType");
        Intrinsics.checkNotNullParameter(r112, "switchMethod");
        i.P0(this, "camera_action", r111, r110, this.f322798g, null, null, null, r112, 112);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void n0(String r110, Boolean r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        i.Q0(this, "modify_range", r110, this.f322798g, r111, Integer.valueOf(r112), null, 160);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void p(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        i.X0(r100, r101, this.f322798g, r102);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void w(String r110, String r111, Boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        Intrinsics.checkNotNullParameter(r111, "buttonType");
        i.Q0(this, r111, r110, this.f322798g, r112, null, null, 224);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void w0(boolean r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "captureMode");
        Intrinsics.checkNotNullParameter(r112, "leaveReason");
        U0(SystemClock.elapsedRealtime() - this.f322799h, r112, r110, r111, this.f322798g, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.camera.impl.utils.j0
    public final void c0(String r100, String r101, Integer r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        ICameraEventExt r104 = this.f322798g;
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        if (r104 != null) goto L5;
        JSONObject r106 = new JSONObject();
    L8:
        r106.put("camera_type", i.N0(r101));
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r100);
        r106.put("current_page", "camera_confirm");
        r106.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, a.a(r101));
        if (r102 == null) goto L11;
        r106.put("item_rank", r102.intValue());
    L11:
        if (r103 == null) goto L13;
        r106.put("is_default", r103.booleanValue() ? 1 : 0);
    L13:
        Unit r107 = Unit.INSTANCE;
        r105.reportEvent("camera_item_show", r106);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r104, "$this$jsonObject");
        r106 = r104.cameraItemShowEventExt();
        if (r106 != null) goto L8;
        r106 = new JSONObject();
        goto L8
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void i0(String r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "captureMode");
        Intrinsics.checkNotNullParameter(r101, "toast");
        Intrinsics.checkNotNullParameter(r100, "captureMode");
        Intrinsics.checkNotNullParameter(r101, "toast");
        com.larus.platform.service.o r104 = com.larus.platform.service.o.f365780a;
        JSONObject r105 = new JSONObject();
        r105.put("validate_scenario", "rejection_detection");
        r105.put("camera_type", "edu");
        r105.put(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT, r101);
        r105.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, a.a(r100));
        r105.put("success", r102 ? 1 : 0);
        r105.put("picture_from", i.W0(Boolean.valueOf(r103)));
        Unit r106 = Unit.INSTANCE;
        r104.reportEvent("camera_validate_result", r105);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void q0(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        Intrinsics.checkNotNullParameter(r103, "previousPage");
        i.T0(r100, r101, r102, r103, this.f322798g);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void Z(String r110, String r111, Boolean r112, Integer r113, Boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        Intrinsics.checkNotNullParameter(r111, "buttonType");
        i.Q0(this, r111, r110, this.f322798g, r112, r113, r114, 32);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void j0(String r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "captureMode");
        Intrinsics.checkNotNullParameter(r111, "zoomButtonType");
        i.P0(this, "camera_action", r111, r110, this.f322798g, null, r112, r113, r114, 16);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void n(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        JSONObject r106 = new JSONObject();
        r106.put("camera_type", "general");
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "camera_action");
        r106.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r100);
        r106.put("current_page", r101);
        if (r102 == null) goto L5;
        r106.put("bot_id", r102);
    L5:
        if (r103 == null) goto L7;
        r106.put("click_from", r103);
    L7:
        if (r104 == null) goto L9;
        r106.put("switch_method", r104);
    L9:
        String r107 = this.f322780e;
        if (r107 == null) goto L12;
        r106.put("content_type", r107);
    L12:
        String r108 = this.f322781f;
        if (r108 == null) goto L15;
        r106.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, r108);
    L15:
        ICameraEventExt r109 = this.f322798g;
        if (r109 == null) goto L18;
        JSONObject r110 = r109.getExtraParams();
    L19:
        i.M0(r106, r110);
        Unit r111 = Unit.INSTANCE;
        r105.reportEvent("click_camera_button", r106);
        return;
    L18:
        r110 = null;
        goto L19
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void F0(boolean r110, boolean r111, String r112, Boolean r113, Boolean r114, EduIntentMode r115) {
        Intrinsics.checkNotNullParameter(r112, "captureMode");
        i.V0(SystemClock.elapsedRealtime() - this.f322800i, "other", r110, r111, r112, this.f322798g, r113, r114, r115);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void U(String r100, String r101, String r102, String r103, JSONObject r104, by7.e r110) {
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.putOpt(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "edit_entrance");     // Catch: JSONException -> L13
        r104.put("current_page", r102);     // Catch: JSONException -> L13
        if (r100 == null) goto L6;
        r104.putOpt("button_name", r100);     // Catch: JSONException -> L13
    L6:
        r104.putOpt("show_from", "camera_confirm");     // Catch: JSONException -> L13
        if (r101 == null) goto L9;
        r104.put("bot_id", r101);     // Catch: JSONException -> L13
    L9:
        r104.put("enter_method", "click_camera_confirm_image_edit_button");     // Catch: JSONException -> L13
        if (o0.d(r103) == false) goto L15;
        r104.put("previous_page", r103);     // Catch: JSONException -> L13
    L15:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("image_edit_function_click");
        if (r110 == null) goto L18;
        r106.f21464b = r110;
    L18:
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L13:
        e = move-exception;
        FLogger.f375446a.e("CameraTracer", "error in mobImageEditFunctionShow " + e.getLocalizedMessage());
        goto L15
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void a(String r110, boolean r111, boolean r112, String r113, Boolean r114, Boolean r115, EduIntentMode r116) {
        Intrinsics.checkNotNullParameter(r110, "leaveReason");
        Intrinsics.checkNotNullParameter(r113, "captureMode");
        i.V0(SystemClock.elapsedRealtime() - this.f322800i, r110, r111, r112, r113, this.f322798g, r114, r115, r116);
    }

    @Override // com.larus.camera.impl.utils.j0
    public final void L0(String r100, String r101, String r102, String r103, String r104, String r105, String r106, JSONObject r107, by7.e r110) {
        Intrinsics.checkNotNullParameter(r107, "params");
        r107.putOpt(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r100);     // Catch: JSONException -> L16
        r107.put("current_page", r105);     // Catch: JSONException -> L16
        if (r101 == null) goto L6;
        r107.putOpt("button_name", r101);     // Catch: JSONException -> L16
    L6:
        if (r102 == null) goto L8;
        r107.putOpt("show_from", r102);     // Catch: JSONException -> L16
    L8:
        if (r103 == null) goto L10;
        r107.put("bot_id", r103);     // Catch: JSONException -> L16
    L10:
        if (r104 == null) goto L13;
        r107.put("enter_method", r104);     // Catch: JSONException -> L16
    L13:
        if (o0.d(r106) == false) goto L18;
        r107.put("previous_page", r106);     // Catch: JSONException -> L16
    L18:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("image_edit_function_show");
        if (r110 == null) goto L21;
        r109.f21464b = r110;
    L21:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L16:
        e = move-exception;
        FLogger.f375446a.e("CameraTracer", "error in mobImageEditFunctionShow " + e.getLocalizedMessage());
        goto L18
    }
}
