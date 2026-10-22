package qh0;

import am2.x;
import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.MaybeSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.utils.s;
import com.bytedance.android.live.liveinteract.utils.t;
import com.bytedance.android.live.liveinteract.utils.u;
import com.bytedance.android.live.room.IMiddlewareLiveSDKService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.VcdAuthorizationSource;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.config.eb0;
import com.bytedance.android.livesdk.config.mb1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f532918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f532919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f532920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f532921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f532922e;

    public static final class a {
    }

    public static final class b implements OnBindPhoneListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f532923a;

        public b(h r100) {
            this.f532923a = r100;
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener
        public final void onBindPhone(boolean r100) {
            if (r100 == false) goto L5;
            f2.b(R.string.ttlive_interact_bind_success, 0);
            j0 r101 = j0.l();
            x r102 = new x();
            r102.f4352d = "guest_connection";
            r101.sendLog("livesdk_guest_connection_phone_bind_success", null, new Object[]{IRoom.class, r102});
            this.f532923a.f532921d.invoke();
            return;
        }
    }

    static {
    }

    public static String a(String r100) {
        int r101 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r101 != 1) goto L5;
        String r102 = "pk_room";
    L15:
        ALogger.i("ServerPermissionHandler", "source=" + r100 + ", enterFrom=" + r102);
        return r102;
    L5:
        if (r101 != 5) goto L7;
        r102 = "audio_chat_room";
        goto L15
    L7:
        if (r101 != 8) goto L9;
        r102 = "video_chatroom";
        goto L15
    L9:
        if (r101 == 12) goto L11;
        r102 = "guest_connection";
        goto L15
    L11:
        r102 = "video_friend_room";
        goto L15
    }

    public static void b(String r100) {
        ALogger.w("ServerPermissionHandler", r100.concat(" no valid activity."));
    }

    public final void c(Throwable r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if ((r110 instanceof ApiServerException) == false) goto L82;
        ApiServerException r100 = (ApiServerException) r110;
        switch(r100.getErrorCode()) {
            case 20048: goto L57;
            case 20089: goto L56;
            case 30010: goto L44;
            case 31002: goto L40;
            case 31009: goto L35;
            case 31011: goto L30;
            case 4002168: goto L29;
            case 4004091: goto L25;
            case 4004272: goto L12;
            case 4004277: goto L9;
            default: goto L68;
        };
    L12:
        Activity r111 = com.bytedance.android.live.core.utils.a.d();
        if (r111 == null) goto L24;
        HashMap r101 = new HashMap();
        String r102 = a("face_verify");
        j0.l().sendLog("livesdk_anchor_face_recognition_show", r101, new Object[0]);
        SpannableString r103 = new SpannableString(s1.B(R.string.ttlive_verify_at_now));
        r103.setSpan(new ForegroundColorSpan(s1.h(R.color.ttlive_core_hs_sys3)), 0, r103.length(), 33);
        c9.b r104 = new c9.b();
        r104.f112681a = r111;
        r104.f112682b = 2;
        r104.f112683c = R.layout.ttlive_dialog_room_center_face_authentication_layout;
        r104.f112696p = false;
        r104.f112685e = r111.getText(R.string.ttlive_verify_label);
        r104.f112686f = r104.f112681a.getText(R.string.ttlive_verify_face_auth);
        String r105 = s1.B(R.string.ttlive_cancel);
        q r106 = new q(r101);
        r104.f112690j = r105;
        r104.f112691k = r106;
        o r107 = new o(r102, r111, r101, this);
        r104.f112692l = r103;
        r104.f112693m = r107;
        c9 r108 = new c9(r104.f112681a, r104);
        mb1 r109 = eb0.f120113a.getValue();
        if (r109 == null) goto L20;
        if (r109.a() != true) goto L20;
        LinearLayout r112 = (LinearLayout) r108.f112670e.findViewById(R.id.room_center_content_sub_ll);
        CheckBox r113 = (CheckBox) r108.f112670e.findViewById(R.id.room_center_content_sub_cb);
        TextView r114 = (TextView) r108.f112670e.findViewById(R.id.room_center_content_sub_tv);
        SpannableString r115 = new SpannableString(s1.B(R.string.ttlive_agree_to_check));
        r115.setSpan(new r(r111), 3, 11, 33);
        r112.setVisibility(0);
        r113.setOnCheckedChangeListener(new p(this));
        r114.setText(r115);
        r114.setMovementMethod(LinkMovementMethod.getInstance());
        String r116 = s1.B(R.string.ttlive_agree_to_refuse);
        String r117 = s1.B(R.string.ttlive_agree_to_confrim);
        r108.f112676k.setText(r116);
        r108.f112677l.setText(r117);
        r108.f112676k.setTextSize(14.0f);
        r108.f112677l.setTextSize(14.0f);
    L20:
        if (DialogLancet.shouldBlockDialogShow(r108) == false) goto L77;
        DialogLancet.handleBlockedDialogShow(r108);
        return;
    L77:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L73
    L23:
        DialogLancet.beforeDialogShow(r108);
        r108.show();
        DialogLancet.afterDialogShow(r108);
        return;
    L24:
        b("showFaceVerifyDialog");
        return;
    L25:
        Activity r118 = com.bytedance.android.live.core.utils.a.d();
        if (r118 == null) goto L28;
        r100.setBlockNotice(true);
        ExceptionUtils.handleException(r118, r100);
        return;
    L28:
        b("onCheckPermissionFailed");
        return;
    L29:
        d(4002168);
        return;
    L30:
        this.f532922e.invoke();
        Activity r119 = com.bytedance.android.live.core.utils.a.d();
        if (r119 != null) goto L33;
    L34:
        b("handleBannedError");
        Unit r120 = Unit.INSTANCE;
        return;
    L33:
        if (((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getLatestBanRecord(13).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(r119)))).subscribe(new i(r119, this), j.f532926a) == null) goto L34;
        return;
    L35:
        Activity r121 = com.bytedance.android.live.core.utils.a.d();
        if (r121 == null) goto L39;
        IMiddlewareUserService r122 = (IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class);
        FragmentActivity r123 = ContextUtil.contextToFragmentActivity(r121);
        Intrinsics.checkNotNull(r123);
        if (((MaybeSubscribeProxy) r122.ensureVcdAuthorized(r123, VcdAuthorizationSource.LINK_IN_ROOM).observeOn(AndroidSchedulers.mainThread()).filter(n.f532930a).as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(r121)))).subscribe(new m(this)) == null) goto L39;
        return;
    L39:
        b("onVcdAuthorizationError");
        Unit r124 = Unit.INSTANCE;
        return;
    L40:
        Activity r125 = com.bytedance.android.live.core.utils.a.d();
        if (r125 == null) goto L43;
        ExceptionUtils.handleException(r125, r110);
        return;
    L43:
        b("onCheckPermissionFailed");
        return;
    L44:
        Activity r126 = com.bytedance.android.live.core.utils.a.d();
        if (r126 == null) goto L55;
        HashMap r127 = new HashMap();
        r127.put("verify_type", "realname");
        j0.l().sendLog("livesdk_guest_connection_verify_popup_show", r127, new Object[]{IRoom.class, x.class});
        com.bytedance.android.live.base.model.verify.c r128 = (com.bytedance.android.live.base.model.verify.c) GsonHelper.get().fromJson(r100.getExtra(), com.bytedance.android.live.base.model.verify.c.class);     // Catch: Exception -> L49
    L51:
        com.bytedance.android.live.base.model.verify.c r129 = r128;
        Activity r130 = ContextUtil.contextToActivity(r126);
        Bundle r131 = new Bundle();
        r131.putString("enter_from", a("real_name"));
        r131.putBoolean("use_new_cert_api", true);
        this.f532918a = new k(this);
        IMiddlewareLiveSDKService r132 = (IMiddlewareLiveSDKService) jc1.k.n(IMiddlewareLiveSDKService.class);
        String r133 = r100.getPrompt();
        if (r133 != null) goto L54;
        r133 = "";
    L54:
        r132.handleRealNameConflict(r130, 111, r129, r131, r133, this.f532918a);
        return;
    L49:
        e = move-exception;
        ALogger.e("ServerPermissionHandler", e);
        ALogger.d("ServerPermissionHandler", r100.getExtra());
        r128 = null;
        goto L51
    L55:
        b("onRealNameError");
        return;
    L56:
        d(20089);
        return;
    L57:
        Activity r134 = com.bytedance.android.live.core.utils.a.d();
        if (r134 == null) goto L67;
        HashMap r135 = new HashMap();
        r135.put("verify_type", "underage");
        j0.l().sendLog("livesdk_guest_connection_verify_popup_show", r135, new Object[]{IRoom.class, x.class});
        x0.d r136 = new x0.d();
        r136.f162243b = r134;
        r136.f162242a = 0;
        r136.f162252k = true;
        r136.f162244c = r136.f162243b.getText(R.string.ttlive_interact_underage_dialog_title);
        l r137 = new l(this);
        CharSequence r138 = r136.f162243b.getText(R.string.ttlive_know);
        x0.c[] r139 = r136.f162248g;
        x0.c r140 = r139[0];
        if (r140 != null) goto L62;
        r140 = new x0.c();
        r139[0] = r140;
    L62:
        r140.f162239a = r138;
        r140.f162240b = r137;
        x0 r141 = new x0(r136.f162243b, r136);
        if (DialogLancet.shouldBlockDialogShow(r141) == false) goto L75;
        DialogLancet.handleBlockedDialogShow(r141);
        return;
    L75:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L74
    L66:
        DialogLancet.beforeDialogShow(r141);
        r141.show();
        DialogLancet.afterDialogShow(r141);
        return;
    L67:
        b("onUnderageError");
        return;
    L68:
        Activity r142 = com.bytedance.android.live.core.utils.a.d();
        if (r142 == null) goto L71;
        ExceptionUtils.handleException(r142, r110);
        return;
    L71:
        b("onCheckPermissionFailed");
        return;
    L9:
        if (com.bytedance.android.live.core.utils.a.d() == null) goto L11;
        f2.c(r100.getPrompt(), 0);
        return;
    L11:
        b("handlePaidLiveLinkError");
        return;
    }

    public final void d(int r100) {
        Activity r101 = com.bytedance.android.live.core.utils.a.d();
        if (r101 == null) goto L11;
        int r102 = u.f78833a;
        Activity r103 = ContextUtil.contextToActivity(r101);
        b r104 = new b(this);
        Intrinsics.checkNotNullParameter("guest_connection", "source");
        Intrinsics.checkNotNullParameter(r104, "listener");
        HashMap r105 = new HashMap();
        r105.put("verify_type", "phone");
        j0.l().sendLog("livesdk_guest_connection_verify_popup_show", r105, new Object[]{IRoom.class, x.class});
        if (r103 == null) goto L16;
        x0.b r106 = new x0.b(r103, 0);
        r106.f162238a.f162252k = true;
        r106.m(R.string.ttlive_interact_bind_mobile_dialog_title);
        r106.i(0, R.string.ttlive_live_bind_mobile_dialog_cancel, s.f78826a);
        r106.i(1, R.string.ttlive_live_bind_mobile_dialog_sure, new t(r103, r100, r104));
        x0 r107 = r106.h();
        if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r107);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L10:
        DialogLancet.beforeDialogShow(r107);
        r107.show();
        DialogLancet.afterDialogShow(r107);
        return;
    L16:
        return;
    L11:
        b("onBindPhoneError");
    }

    public h(int r100, Function0 r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r101, "onCheckSuccess");
        Intrinsics.checkNotNullParameter(r102, "onCheckFailed");
        this.f532920c = r100;
        this.f532921d = r101;
        this.f532922e = r102;
    }
}
