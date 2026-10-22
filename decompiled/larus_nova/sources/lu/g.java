package lu;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import bw.p;
import com.bytedance.android.gamecp.common.setting.LiveConfigSettingKeys;
import com.bytedance.android.gamecp.common.ui.r;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f510784a;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f510785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f510786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ju.b f510787c;

        public a(int r100, String r101, ju.b r102) {
            this.f510785a = r100;
            this.f510786b = r101;
            this.f510787c = r102;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            Handler r102 = g.f510784a;
            int r103 = this.f510785a;
            String r104 = this.f510786b;
            ju.b r105 = this.f510787c;
            if (r103 != 42201) goto L5;
            HashMap r106 = new HashMap();
            r106.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "cancel");
            int r107 = com.bytedance.android.gamecp.common.track.b.f56775a;
            com.bytedance.android.gamecp.common.track.b.g("livesdk_name_verification_popup_click", r106, new String[]{LogFilterName.PAGE_SOURCE_LOG, LogFilterName.ROOM});
        L10:
            ju.b r108 = this.f510787c;
            if (r108 == null) goto L13;
            r108.onVerifyResult(0);
        L13:
            hu.d.a(this.f510785a, "cancel");
            r100.dismiss();
            return;
        L5:
            HashMap r109 = new HashMap();
            r109.put("request_page", r104);
            if (r105 != null) goto L8;
            String r110 = "consume";
        L9:
            r109.put("popup_source", r110);
            r109.put("click_result", "cancel");
            int r111 = com.bytedance.android.gamecp.common.track.b.f56775a;
            com.bytedance.android.gamecp.common.track.b.g("livesdk_popup_for_identification_click", r109, new String[]{LogFilterName.PAGE_SOURCE_LOG, LogFilterName.ROOM});
            goto L10
        L8:
            r110 = PbRequest.SwitchType.RECHARGE;
            goto L9
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f510788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f510789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ju.b f510790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Activity f510791d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f510792e;

        public b(int r100, String r101, ju.b r102, Activity r103, int r104) {
            this.f510788a = r100;
            this.f510789b = r101;
            this.f510790c = r102;
            this.f510791d = r103;
            this.f510792e = r104;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r110, int r111) {
            Handler r112 = g.f510784a;
            int r113 = this.f510788a;
            String r100 = this.f510789b;
            ju.b r101 = this.f510790c;
            String r102 = "consume";
            if (r113 != 42201) goto L5;
            HashMap r114 = new HashMap();
            r114.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "confirm");
            int r103 = com.bytedance.android.gamecp.common.track.b.f56775a;
            com.bytedance.android.gamecp.common.track.b.g("livesdk_name_verification_popup_click", r114, new String[]{LogFilterName.PAGE_SOURCE_LOG, LogFilterName.ROOM});
        L10:
            hu.d.a(this.f510788a, "sure");
            Activity r104 = this.f510791d;
            int r115 = this.f510792e;
            String r105 = this.f510789b;
            ju.b r106 = this.f510790c;
            if (r106 == null) goto L14;
            r102 = PbRequest.SwitchType.RECHARGE;
        L14:
            f r107 = new f(r106, r104);
            if ((r115 & 1) == 0) goto L30;
            if ((r115 & 2) == 0) goto L30;
            if ((r104 instanceof sv.a) == false) goto L22;
            ((sv.a) r104).a();
        L22:
            if (GameCpTargetUtils.c() == true) goto L40;
        L38:
            r110.dismiss();
            return;
        L40:
            Uri r116 = UriProtector.parse(LiveConfigSettingKeys.DOUYIN_COMMON_CERTIFICATION_URL.getValue()).buildUpon().appendQueryParameter("request_page", r105).appendQueryParameter("request_code", String.valueOf(101)).build();     // Catch: Exception -> L27
            if (r116 == null) goto L38;
            com.bytedance.android.gamecp.host_api.a.b().getHostAction().handleSchema(r104, r116.toString(), new Bundle());     // Catch: Exception -> L27
        L27:
            e = move-exception;
            yr.b.d("MinorInterceptor", null, e);
        L30:
            if ((r115 & 2) == 0) goto L38;
            Bundle r108 = new Bundle();
            r108.putString("enter_from", "minor");
            r108.putString("request_page", r105);
            r108.putString("popup_source", r102);
            p r117 = com.bytedance.android.gamecp.host_api.a.b().getUserService();
            if (r117 != null) goto L34;
        L36:
            String r109 = null;
        L37:
            com.bytedance.android.gamecp.host_api.a.b().getLiveService().B0(r104, r109, r108, new h(r107), MapsKt.mapOf(TuplesKt.to("scene", "1")));
            goto L38
        L34:
            if (r117.user().isLogin() == false) goto L36;
            r109 = r117.user().a(r117.user().getCurrentUserId());
            goto L37
        L5:
            HashMap r118 = new HashMap();
            r118.put("request_page", r100);
            if (r101 != null) goto L8;
            Object r119 = "consume";
        L9:
            r118.put("popup_source", r119);
            r118.put("click_result", "confirm");
            int r120 = com.bytedance.android.gamecp.common.track.b.f56775a;
            com.bytedance.android.gamecp.common.track.b.g("livesdk_popup_for_identification_click", r118, new String[]{LogFilterName.PAGE_SOURCE_LOG, LogFilterName.ROOM});
            goto L10
        L8:
            r119 = PbRequest.SwitchType.RECHARGE;
            goto L9
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f510793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ju.b f510794b;

        public c(int r100, ju.b r101) {
            this.f510793a = r100;
            this.f510794b = r101;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            hu.d.a(this.f510793a, "cancel");
            ju.b r101 = this.f510794b;
            if (r101 == null) goto L6;
            r101.onVerifyResult(0);
            return;
        }
    }

    static {
    }

    public static void a(Activity r100, int r110, int r111, String r112, ju.b r113) {
        r.a r101 = new r.a();
        r101.f57139a = r100;
        r101.f57140b = 2;
        r101.f57141c = r100.getText(R.string.gamecp_warm_prompt);
        r101.f57142d = y0.i(R.string.gamecp_facedetect_notice);
        r101.f57143e = 17;
        String r102 = y0.i(R.string.gamecp_text_cancel);
        a r103 = new a(r111, r112, r113);
        r101.f57144f = r102;
        r101.f57145g = r103;
        String r104 = y0.i(R.string.gamecp_navigate_to_check);
        b r105 = new b(r111, r112, r113, r100, r110);
        r101.f57146h = r104;
        r101.f57147i = r105;
        r101.f57148j = new c(r111, r113);
        r r106 = new r(r101.f57139a, r101);
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r106);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
    }
}
