package com.larus.camera.impl.utils;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.larus.camera.impl.entity.EduIntentMode;
import com.larus.camera.impl.ui.component.generalonly.CameraTabTipsShowOrder;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.e6;

/* JADX INFO: loaded from: classes26.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f322776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f322777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f322778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f322779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f322780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f322781f;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f322782a = null;

        static {
            int[] r100 = new int[EduIntentMode.values().length];
            r100[EduIntentMode.COMMON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[EduIntentMode.SINGLE_QUESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[EduIntentMode.MULTI_QUESTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f322782a = r100;
        }
    }

    public i(com.larus.camera.impl.ui.base.f r100) {
        this.f322776a = r100;
    }

    public static String N0(String r100) {
        if (fx8.a.f479114e.contains(r100) == false) goto L6;
        return "edu";
    L6:
        if (fx8.a.f479111b.contains(r100) == false) goto L9;
        return "scan";
    L9:
        if (fx8.a.f479112c.contains(r100) == false) goto L11;
        return "health";
    L11:
        return "general";
    }

    public static String W0(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L6;
        return "select_photo";
    L6:
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == false) goto L8;
        return "take_photo";
    L8:
        return "null";
    }

    public static void M0(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "mobObject");
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L46;
        String r104 = r101.optString("canvas_type");
        Intrinsics.checkNotNull(r104);
        if (r104.length() <= 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        r100.put("canvas_type", r104);
    L15:
        String r106 = r101.optString("presentation_id");
        Intrinsics.checkNotNull(r106);
        if (r106.length() <= 0) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == false) goto L21;
        r100.put("presentation_id", r106);
    L21:
        String r108 = r101.optString("resource_id");
        Intrinsics.checkNotNull(r108);
        if (r108.length() <= 0) goto L24;
        boolean r109 = true;
    L25:
        if (r109 == false) goto L27;
        r100.put("resource_id", r108);
    L27:
        int r110 = r101.optInt("resource_type");
        if (r110 == 0) goto L30;
        r100.put("resource_type", r110);
    L30:
        String r111 = r101.optString("artifact_meta_id");
        Intrinsics.checkNotNull(r111);
        if (r111.length() <= 0) goto L33;
        boolean r112 = true;
    L34:
        if (r112 == false) goto L36;
        r100.put("artifact_meta_id", r111);
    L36:
        int r113 = r101.optInt("artifact_type");
        if (r113 == 0) goto L39;
        r100.put("artifact_type", r113);
    L39:
        String r114 = r101.optString("aippt_task_id");
        Intrinsics.checkNotNull(r114);
        if (r114.length() > 0) goto L43;
        r102 = false;
    L43:
        if (r102 == false) goto L47;
        r100.put("aippt_task_id", r114);
        return;
    L47:
        return;
    L33:
        r112 = false;
        goto L34
    L24:
        r109 = false;
        goto L25
    L18:
        r107 = false;
        goto L19
    L12:
        r105 = false;
        goto L13
    L46:
        return;
    L5:
        if (r101.optInt("is_ai_ppt", 0) != 1) goto L7;
        r103 = true;
        goto L8
    }

    public static void R0(String r100, String r101, String r102, ICameraEventExt r103) {
        Intrinsics.checkNotNullParameter("camera", "currentPage");
        Intrinsics.checkNotNullParameter(r100, "captureMode");
        Intrinsics.checkNotNullParameter(r101, "clickFrom");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        com.larus.platform.service.o r104 = com.larus.platform.service.o.f365780a;
        if (r103 != null) goto L5;
        JSONObject r105 = new JSONObject();
    L8:
        r105.put("camera_type", N0(r100));
        r105.put("current_page", "camera");
        int r106 = r.f322797j;
        r105.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r.a.a(r100));
        r105.put("enter_method", r102);
        r105.put("click_from", r101);
        e6.f552469a.getClass();
        r105.put("album_status", e6.a());
        if (r103 == null) goto L11;
        JSONObject r107 = r103.getExtraParams();
    L12:
        M0(r105, r107);
        Unit r108 = Unit.INSTANCE;
        r104.reportEvent("click_upload_entrance", r105);
        return;
    L11:
        r107 = null;
        goto L12
    L5:
        Intrinsics.checkNotNullParameter(r103, "$this$jsonObject");
        r105 = r103.clickCameraButtonEventExt();
        if (r105 != null) goto L8;
        r105 = new JSONObject();
        goto L8
    }

    public static void X0(String r100, String r101, ICameraEventExt r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        com.larus.platform.service.o r104 = com.larus.platform.service.o.f365780a;
        if (r102 != null) goto L5;
        JSONObject r105 = new JSONObject();
    L8:
        r105.put("camera_type", N0(r101));
        r105.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r100);
        r105.put("current_page", "camera");
        int r106 = r.f322797j;
        r105.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r.a.a(r101));
        if (r103 == null) goto L11;
        r105.put("intro_text_info", r103);
    L11:
        Unit r107 = Unit.INSTANCE;
        r104.reportEvent("camera_item_show", r105);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r102, "$this$jsonObject");
        r105 = r102.cameraItemShowEventExt();
        if (r105 != null) goto L8;
        r105 = new JSONObject();
        goto L8
    }

    public static void T0(String r100, String r101, String r102, String r103, ICameraEventExt r104) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "captureMode");
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        if (r104 != null) goto L5;
        JSONObject r106 = new JSONObject();
    L8:
        r106.put("current_page", r100);
        int r107 = r.f322797j;
        r106.put("current_tab", r.a.a(r101));
        if (o0.d(r102) == false) goto L12;
        r106.put("enter_method", r102);
    L12:
        if (o0.d(r103) == false) goto L14;
        r106.put("previous_page", r103);
    L14:
        Unit r108 = Unit.INSTANCE;
        r105.reportEvent(CheckPointType.ENTER_PAGE, r106);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r104, "$this$jsonObject");
        r106 = r104.enterPageEventExt();
        if (r106 != null) goto L8;
        r106 = new JSONObject();
        goto L8
    }

    public static void S0(String r100, boolean r101, String r102, Boolean r103, String r104, ICameraEventExt r105) {
        com.larus.platform.service.o r106 = com.larus.platform.service.o.f365780a;
        if (r105 != null) goto L5;
        JSONObject r107 = new JSONObject();
    L8:
        r107.put("camera_type", N0(r102));
        r107.put("current_page", r100);
        if (r101 == false) goto L11;
        String r108 = "slide";
    L12:
        r107.put("enter_method", r108);
        int r109 = r.f322797j;
        r107.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r.a.a(r102));
        r107.put("picture_from", W0(r103));
        JSONObject r110 = null;
        if (r105 == null) goto L17;
        JSONObject r111 = r105.getExtraParams();
        if (r111 == null) goto L17;
        Integer r112 = Integer.valueOf(r111.optInt("is_ai_doc", 0));
    L18:
        r107.put("is_ai_doc", r112);
        if (o0.d(r104) == false) goto L21;
        r107.put("click_from", r104);
    L21:
        if (r105 == null) goto L23;
        r110 = r105.getExtraParams();
    L23:
        M0(r107, r110);
        Unit r113 = Unit.INSTANCE;
        r106.reportEvent("enter_camera", r107);
        return;
    L17:
        r112 = null;
        goto L18
    L11:
        r108 = "click";
        goto L12
    L5:
        Intrinsics.checkNotNullParameter(r105, "$this$jsonObject");
        r107 = r105.enterCameraEventExt();
        if (r107 != null) goto L8;
        r107 = new JSONObject();
        goto L8
    }

    public final void U0(long r100, String r101, boolean r102, String r103, ICameraEventExt r104, Long r110) {
        Intrinsics.checkNotNullParameter(r101, "leaveReason");
        Intrinsics.checkNotNullParameter(r103, "captureMode");
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        if (r104 != null) goto L5;
        JSONObject r106 = new JSONObject();
    L8:
        r106.put("stay_time", r100);
        r106.put("leave_reason", r101);
        r106.put("camera_type", N0(r103));
        r106.put("current_page", "camera");
        if (r102 == false) goto L11;
        String r107 = "slide";
    L12:
        r106.put("enter_method", r107);
        int r108 = r.f322797j;
        r106.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r.a.a(r103));
        Integer r109 = this.f322777b;
        if (r109 == null) goto L20;
        CameraTabTipsShowOrder r111 = CameraTabTipsShowOrder.ORDER;
        if (r109.intValue() != r111.getType()) goto L17;
        r106.put("tips_type", r111.getMobStr());
        goto L20
    L17:
        CameraTabTipsShowOrder r112 = CameraTabTipsShowOrder.RANDOM;
        if (r109.intValue() != r112.getType()) goto L20;
        r106.put("tips_type", r112.getMobStr());
    L20:
        r106.put("tips_count", this.f322778c);
        x r113 = this.f322776a;
        JSONObject r114 = null;
        if (r113 == null) goto L23;
        String r115 = r113.a();
    L25:
        if (o0.d(r115) == false) goto L27;
        r106.put("click_from", r115);
    L27:
        if (r110 == null) goto L29;
        r106.put("video_time", r110.longValue());
    L29:
        if (r104 == null) goto L31;
        r114 = r104.getExtraParams();
    L31:
        M0(r106, r114);
        Unit r116 = Unit.INSTANCE;
        r105.reportEvent("leave_camera", r106);
        this.f322778c = 0;
        this.f322779d = 0;
        return;
    L23:
        r115 = null;
        goto L25
    L11:
        r107 = "click";
        goto L12
    L5:
        Intrinsics.checkNotNullParameter(r104, "$this$jsonObject");
        r106 = r104.leaveCameraEventExt();
        if (r106 != null) goto L8;
        r106 = new JSONObject();
        goto L8
    }

    public static void Q0(i r110, String r111, String r112, ICameraEventExt r113, Boolean r210, Integer r211, Boolean r212, int r213) {
        if ((r213 & 32) == 0) goto L5;
        String r100 = "camera_confirm";
    L7:
        if ((r213 & 64) == 0) goto L9;
        Integer r114 = null;
    L11:
        if ((r213 & 128) == 0) goto L13;
        Boolean r115 = null;
    L14:
        r110.getClass();
        Intrinsics.checkNotNullParameter("camera_action", "itemType");
        Intrinsics.checkNotNullParameter(r111, "buttonType");
        Intrinsics.checkNotNullParameter(r112, "captureMode");
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        O0(r110, "camera_action", r111, r100, r112, r113, r210, null, null, null, null, r110.f322780e, r110.f322781f, r114, r115, 10112);
        return;
    L13:
        r115 = r212;
        goto L14
    L9:
        r114 = r211;
        goto L11
    L5:
        r100 = null;
        goto L7
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
    public static void V0(long r100, String r101, boolean r102, boolean r103, String r104, ICameraEventExt r105, Boolean r106, Boolean r110, EduIntentMode r111) {
        Intrinsics.checkNotNullParameter(r101, "leaveReason");
        Intrinsics.checkNotNullParameter(r104, "captureMode");
        com.larus.platform.service.o r107 = com.larus.platform.service.o.f365780a;
        if (r105 != null) goto L5;
        JSONObject r108 = new JSONObject();
    L8:
        r108.put("stay_time", r100);
        r108.put("leave_reason", r101);
        r108.put("camera_type", N0(r104));
        r108.put("picture_from", W0(Boolean.valueOf(r102)));
        r108.put("current_page", "camera_confirm");
        if (r110 == null) goto L11;
        r108.put("change_range", r110.booleanValue() ? 1 : 0);
    L11:
        if (r103 == false) goto L13;
        String r109 = "slide";
    L14:
        r108.put("enter_method", r109);
        int r112 = r.f322797j;
        r108.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r.a.a(r104));
        if (r106 != null) goto L17;
    L21:
        if (r111 != null) goto L23;
        int r113 = -1;
    L25:
        if (r113 != 1) goto L27;
        String r114 = "0";
    L33:
        r108.put("if_edu_intention", r114);
        Unit r115 = Unit.INSTANCE;
        r107.reportEvent("leave_camera_confirm", r108);
        return;
    L27:
        if (r113 != 2) goto L29;
    L31:
        r114 = "1";
        goto L33
    L29:
        if (r113 == 3) goto L31;
        r114 = "-1";
        goto L33
    L23:
        r113 = a.f322782a[r111.ordinal()];
        goto L25
    L17:
        if (r106.booleanValue() == false) goto L19;
        String r116 = PriorityModule.SCENE_MULTI;
    L20:
        r108.put("search_type", r116);
        goto L21
    L19:
        r116 = "single";
        goto L20
    L13:
        r109 = "click";
        goto L14
    L5:
        Intrinsics.checkNotNullParameter(r105, "$this$jsonObject");
        r108 = r105.leaveCameraConfirmEventExt();
        if (r108 != null) goto L8;
        r108 = new JSONObject();
        goto L8
    }

    public static void P0(i r110, String r210, String r211, String r212, ICameraEventExt r213, String r214, String r215, String r216, String r217, int r218) {
        if ((r218 & 16) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r218 & 32) == 0) goto L9;
        String r112 = null;
    L11:
        if ((r218 & 64) == 0) goto L13;
        String r113 = null;
    L15:
        if ((r218 & 128) == 0) goto L17;
        String r114 = null;
    L18:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r210, "itemType");
        Intrinsics.checkNotNullParameter(r211, "buttonType");
        Intrinsics.checkNotNullParameter(r212, "captureMode");
        O0(r110, r210, r211, "camera", r212, r213, null, r111, r112, r113, r114, null, null, null, null, 64512);
        return;
    L17:
        r114 = r217;
        goto L18
    L13:
        r113 = r216;
        goto L15
    L9:
        r112 = r215;
        goto L11
    L5:
        r111 = r214;
        goto L7
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
    public static void O0(i r110, String r111, String r112, String r113, String r114, ICameraEventExt r115, Boolean r116, String r210, String r211, String r212, String r213, String r214, String r215, Integer r216, Boolean r217, int r218) {
        JSONObject r100 = null;
        if ((r218 & 128) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 256) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r218 & 512) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r218 & 2048) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r218 & 4096) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r218 & 16384) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r218 & 32768) == 0) goto L29;
        Boolean r107 = null;
    L30:
        r110.getClass();
        com.larus.platform.service.o r108 = com.larus.platform.service.o.f365780a;
        if (r115 != null) goto L33;
        JSONObject r117 = new JSONObject();
    L36:
        r117.put("camera_type", N0(r114));
        r117.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r111);
        r117.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r112);
        r117.put("current_page", r113);
        int r118 = r.f322797j;
        r117.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r.a.a(r114));
        if (r106 == null) goto L39;
        r117.put("item_rank", r106.intValue());
    L39:
        if (r107 == null) goto L41;
        r117.put("is_default", r107.booleanValue() ? 1 : 0);
    L41:
        if (r210 == null) goto L43;
        r117.put("to_camera_type", N0(r210));
        r117.put("to_tab", r.a.a(r210));
    L43:
        if (r116 != null) goto L45;
    L49:
        if (r101 == null) goto L51;
        r117.put("from_focus", r101);
    L51:
        if (r102 == null) goto L53;
        r117.put("to_focus", r102);
    L53:
        if (r103 == null) goto L55;
        r117.put("switch_method", r103);
    L55:
        if (r104 == null) goto L57;
        r117.put("content_type", r104);
    L57:
        if (r105 == null) goto L59;
        r117.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, r105);
    L59:
        if (r115 == null) goto L61;
        r100 = r115.getExtraParams();
    L61:
        M0(r117, r100);
        Unit r109 = Unit.INSTANCE;
        r108.reportEvent("click_camera_button", r117);
        return;
    L45:
        if (r116.booleanValue() == false) goto L47;
        String r119 = PriorityModule.SCENE_MULTI;
    L48:
        r117.put("search_type", r119);
        goto L49
    L47:
        r119 = "single";
        goto L48
    L33:
        Intrinsics.checkNotNullParameter(r115, "$this$jsonObject");
        r117 = r115.clickCameraButtonEventExt();
        if (r117 != null) goto L36;
        r117 = new JSONObject();
        goto L36
    L29:
        r107 = r217;
        goto L30
    L25:
        r106 = r216;
        goto L27
    L21:
        r105 = r215;
        goto L23
    L17:
        r104 = r214;
        goto L19
    L13:
        r103 = r213;
        goto L15
    L9:
        r102 = r212;
        goto L11
    L5:
        r101 = r211;
        goto L7
    }
}
