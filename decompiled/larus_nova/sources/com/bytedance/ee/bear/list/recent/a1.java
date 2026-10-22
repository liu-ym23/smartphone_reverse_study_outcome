package com.bytedance.ee.bear.list.recent;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f229262a = 0;

    public interface a {
        void S6(Document r100);

        void c2(Document r100);
    }

    static {
    }

    @JvmStatic
    public static final void a(Context r110, Document r111, ce5.a r112, CompositeDisposable r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r112, "userComponentAbility");
        int r100 = oj5.d.f523579b;
        oj5.d r101 = oj5.d.a.a(r111.O);
        if (r101 == null) goto L23;
        String r102 = r111.f227873d;
        if (r102 != null) goto L7;
        String r103 = "";
    L8:
        String r104 = r111.G1;
        if (r104 != null) goto L11;
        String r105 = "";
    L12:
        int r106 = r111.f227908y1;
        String r114 = r101.d();
        if (r114 != null) goto L15;
        String r107 = "";
    L16:
        Activity r115 = ContextsKt.requireActivity(r110);
        if ((r115 instanceof FragmentActivity) == false) goto L24;
        com.bytedance.ee.bear.contract.route.parcelable.a r108 = (com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6);
        FragmentActivity r109 = (FragmentActivity) r115;
        NetService r116 = r112.f23448c;
        if (r113 != null) goto L21;
        r113 = new CompositeDisposable();
    L21:
        r108.q(r107, r103, r105, r106, r109, r116, r113);
        return;
    L24:
        return;
    L15:
        r107 = r114;
        goto L16
    L11:
        r105 = r104;
        goto L12
    L7:
        r103 = r102;
        goto L8
    }

    @JvmStatic
    public static final void b(Context r100, Document r110, ce5.a r111, a r112, String r113, String r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r111, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r112, "handler");
        c(r100, r110, r111, r112, r113, r114, r115, true);
    }

    @JvmStatic
    public static final void c(Context r310, Document r311, ce5.a r312, a r313, String r314, String r315, boolean r316, boolean r317) {
        String r100 = r314;
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r311, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r312, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r313, "handler");
        Boolean r110 = AppInfoUtils.f();
        if (r110.booleanValue() == false) goto L5;
        String r101 = r310.getString(R.string.LarkCCM_Doubao_Drive_SingleDeleteConfirm_Title);
    L6:
        BearUDDialogBuilder r111 = new BearUDDialogBuilder(r310);
        Intrinsics.checkNotNull(r101);
        r111.i(r101);
        r111.f240192a.titleSize(16);
        r111.f240192a.titleGravity(GravityCompat.START);
        if (r110.booleanValue() == false) goto L10;
        String r102 = r310.getString(R.string.LarkCCM_Doubao_Drive_BatchDeleteConfirm_Desc);
        String r112 = "ListAnalysis";
        String r113 = MapController.ITEM_LAYER_TAG;
    L36:
        Intrinsics.checkNotNull(r102);
        r111.f(r102);
        r111.f240192a.messageTextSize(14);
        r111.f240192a.messageGravity(GravityCompat.START);
        r111.a(BearUDDialogBuilder.ActionBottomOrientation.VERTICAL);
        if (r317 == false) goto L44;
        BearUDDialogBuilder.a r103 = new BearUDDialogBuilder.a();
        r103.f240195a = R.id.ud_dialog_btn_primary;
        r103.f240198d = R.color.text_title;
        if (r110.booleanValue() == false) goto L41;
        int r104 = R.string.LarkCCM_Doubao_Drive_Remove_Button;
    L42:
        r103.f240196b = r104;
        r103.f240200f = new b1(r313, r311, r100);
        r111.d(r103);
    L52:
        BearUDDialogBuilder.a r114 = new BearUDDialogBuilder.a();
        r114.f240195a = R.id.ud_dialog_btn_secondary;
        r114.f240198d = R.color.function_danger_fill_default;
        if (r110.booleanValue() == false) goto L55;
        int r105 = R.string.LarkCCM_Doubao_Drive_Delete_Button;
    L56:
        r114.f240196b = r105;
        r114.f240200f = new c1(r311, r310, r313, r314, r315);
        r111.d(r114);
        BearUDDialogBuilder.a r106 = new BearUDDialogBuilder.a();
        r106.f240195a = R.id.ud_dialog_btn_secondary2;
        r106.f240198d = R.color.text_title;
        if (r110.booleanValue() == false) goto L59;
        int r107 = R.string.LarkCCM_Common_Cancel_Button;
    L60:
        r106.f240196b = r107;
        r106.f240200f = null;
        r111.d(r106);
        UDDialog r108 = r111.e();
        if (DialogLancet.shouldBlockDialogShow(r108) == false) goto L94;
        DialogLancet.handleBlockedDialogShow(r108);
    L65:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).s(r108);
        lc5.f.a r109 = lc5.f.f508440a;
        if (r100 != null) goto L68;
        String r115 = "";
    L69:
        lc5.w r116 = new lc5.w(r115, r311.f227873d, r311.getType(), r311.F);
        Intrinsics.checkNotNullParameter(r116, "param");
        JSONObject r117 = new JSONObject();     // Catch: Exception -> L74
        lc5.f.a.b(r109, new lc5.g(r117, r116.f508585a, r116.f508586b, r116.f508587c, r116.getType(), r116.f508589e, r116.f508590f, r116.f508591g, r116.f508592h));     // Catch: Exception -> L74
        r117.put("is_shared_folder", false);     // Catch: Exception -> L74
        r117.put("delete_content_type", r116.f508594j);     // Catch: Exception -> L74
        r117.put("delete_type", r116.f508595k);     // Catch: Exception -> L74
        r117.put(EventConstant.Key.MODULE, r116.f508585a);     // Catch: Exception -> L74
        com.bytedance.ee.bear.contract.d r118 = lc5.f.a.d();     // Catch: Exception -> L74
        if (r118 == null) goto L76;
        r118.i("ccm_space_delete_or_remove_view", r117);     // Catch: Exception -> L74
    L76:
        String r119 = r112;
    L78:
        if (r316 == false) goto L98;
        lc5.f.a r120 = lc5.f.f508440a;
        if (r100 != null) goto L82;
        r100 = "";
    L82:
        if (r316 == false) goto L84;
        String r121 = "more_btn";
    L85:
        Intrinsics.checkNotNullParameter(r311, r113);
        Intrinsics.checkNotNullParameter("delete", "click");
        Intrinsics.checkNotNullParameter("ccm_space_delete_or_remove_view", PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r121, "viewFrom");
        JSONObject r122 = new JSONObject();     // Catch: Exception -> L88
        lc5.f.a.b(r120, new lc5.g(r122, r100, "recent", r311.f227873d, r311.getType(), r311.F, "", "", ""));     // Catch: Exception -> L88
        r122.put("click", "delete");     // Catch: Exception -> L88
        r122.put(PickerReporterConstants.KEY.TARGET, "ccm_space_delete_or_remove_view");     // Catch: Exception -> L88
        r122.put(EventConstant.Key.MODULE, r100);     // Catch: Exception -> L88
        r122.put("view_from", r121);     // Catch: Exception -> L88
        tt5.a.b(r119, "report reportRightClickMenuClick, params: " + r122);     // Catch: Exception -> L88
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).a("ccm_space_right_click_menu_click", r122);     // Catch: Exception -> L88
        return;
    L88:
        e = move-exception;
        tt5.a.d(r119, e.getMessage());
        return;
    L84:
        r121 = "right_click";
        goto L85
    L98:
        return;
    L74:
        e = move-exception;
        r119 = r112;
        tt5.a.d(r119, e.getMessage());
        goto L78
    L68:
        r115 = r100;
        goto L69
    L94:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L91
    L64:
        DialogLancet.beforeDialogShow(r108);
        r108.show();
        DialogLancet.afterDialogShow(r108);
        goto L65
    L59:
        r107 = R.string.Lark_Legacy_Cancel;
        goto L60
    L55:
        r105 = R.string.LarkCCM_NewCM_Homepage_RecentList_DeleteContent_Button;
        goto L56
    L41:
        r104 = R.string.LarkCCM_NewCM_Homepage_RecentList_OnlyRemoveFromRecentList_Button;
        goto L42
    L44:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("lark.scs.legalhold.delete") == false) goto L46;
        int r123 = 60;
    L47:
        String r124 = String.valueOf(r123);
        if (r110.booleanValue() == false) goto L50;
        String r125 = r310.getString(R.string.LarkCCM_Doubao_Drive_BatchDeleteConfirm_Desc);
    L51:
        Intrinsics.checkNotNull(r125);
        r111.f(r125);
        goto L52
    L50:
        r125 = xo5.a.c(r310, R.string.Bitable_BaseWorkspace_DeletedContentSavedInTrashForNumDays_DayVar_Desc_Mob, "num", r124);
        goto L51
    L46:
        r123 = 30;
        goto L47
    L10:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("lark.scs.legalhold.delete") == false) goto L12;
        int r126 = 60;
    L13:
        String r127 = String.valueOf(r126);
        String r128 = r310.getString(R.string.LarkCCM_NewCM_Homepage_RecentList_DeleteContentOrOnlyRemoveIt_Desc);
        int r129 = r311.getType();
        r113 = MapController.ITEM_LAYER_TAG;
        if (r129 != 16) goto L34;
        int r130 = oj5.d.f523579b;
        oj5.d r131 = oj5.d.a.a(r311.O);
        if (r131 == null) goto L34;
        Integer r132 = r131.f();
        if (r132 != null) goto L20;
        r112 = "ListAnalysis";
    L27:
        boolean r133 = false;
    L28:
        if (r133 == true) goto L35;
        String r134 = r131.e();
        if (r134 != null) goto L32;
        r134 = "";
    L32:
        r102 = xo5.a.d(r310, R.string.LarkCCM_NewCM_DeleteDocsToTrash_DeletedContentGoToTargetWikiSpace_DayVar_Desc, MapsKt.mapOf(new Pair[]{TuplesKt.to("WikiSpaceName", r134), TuplesKt.to("num", r127)}));
    L35:
        r102 = xo5.a.d(r310, R.string.LarkCCM_NewCM_Homepage_RecentList_DeletedContentGoToTrash_DayVar_Desc, MapsKt.mapOf(new Pair[]{TuplesKt.to("OnlyRemoveFromList", r128), TuplesKt.to("num", r127)}));
        goto L36
    L20:
        r112 = "ListAnalysis";
        if (2 != r132.intValue()) goto L27;
        if (TextUtils.isEmpty(r131.c()) == true) goto L27;
        if (TextUtils.equals(r131.c(), r312.f23447b.f438138b) == false) goto L27;
        r133 = true;
    L34:
        r112 = "ListAnalysis";
        goto L35
    L12:
        r126 = 30;
        goto L13
    L5:
        r101 = xo5.a.c(r310, R.string.CreationMobile_ECM_DeleteConfirmTitle, "doc_name", com.bytedance.ee.bear.list.t0.g(r310, r311));
        goto L6
    }
}
