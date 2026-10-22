package com.larus.bmhome.chat.component.input;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes25.dex */
public final class InjectInputServiceProxy<T extends Fragment> implements op8.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f300827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<T> f300828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final op8.f f300829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f300830d;

    public static final class a {
    }

    static {
    }

    @Override // op8.i
    public final void o8() {
        c(new s0());
    }

    @Override // op8.i
    public final void stopInput() {
        c(new u0());
    }

    @Override // op8.i
    public final void M2(final op8.i.a r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.INPUT_TYPE);
        c(new r0(r100));
    }

    public final void c(Function1<? super op8.e, Unit> r100) {
        Fragment r101 = this.f300830d;
        if (r101 != null) goto L5;
    L14:
        FLogger.f375446a.e("CameraInputServiceProxy", "[runInjectInputAbility] failed, cannot run before " + this.f300827a.getSimpleName() + " attached");
        return;
    L5:
        if (r101.isAdded() == false) goto L14;
        if (r101.getActivity() == null) goto L14;
        op8.e r102 = (op8.e) s1a.a.g(r101).getAbility(op8.e.class);
        if (r102 == null) goto L12;
        r100.invoke(r102);
        return;
    L12:
        FLogger.f375446a.e("CameraInputServiceProxy", "[runInjectInputAbility] failed, cannot get InjectInputAbility from ".concat(this.f300827a.getSimpleName()));
    }

    @Override // op8.i
    public final void a(final View r100, final MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "event");
        c(new t0(r100, r101));
    }

    public InjectInputServiceProxy(Class r100, Function0 r101, op8.c r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentClass");
        Intrinsics.checkNotNullParameter(r101, "fragmentFactory");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f300827a = r100;
        this.f300828b = r101;
        this.f300829c = r102;
    }

    @Override // op8.i
    public final Fragment b(Boolean r210, String r211, Map<String, String> r212) {
        this.f300830d = null;
        final T r100 = this.f300828b.invoke();     // Catch: Exception -> L99
        Bundle r110 = r100.getArguments();     // Catch: Exception -> L99
        if (r110 != null) goto L6;
        r110 = new Bundle();     // Catch: Exception -> L99
    L6:
        Bundle r101 = r110;
        if (r210 == null) goto L13;
        r101.putBoolean("inject_input", r210.booleanValue());     // Catch: Exception -> L10
    L10:
        e = e;
        final InjectInputServiceProxy<T> r102 = this;
    L101:
        FLogger.f375446a.e("CameraInputServiceProxy", "Failed to create fragment instance of ".concat(r102.f300827a.getSimpleName()), e);
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        r102.f300830d = null;
        return null;
    L13:
        if (r211 == null) goto L15;
        r101.putString("inject_input_scene", r211);     // Catch: Exception -> L10
    L15:
        String r103 = r212.get("bot_id");     // Catch: Exception -> L10
        if (r103 == null) goto L18;
        r101.putString("bot_id", r103);     // Catch: Exception -> L10
    L18:
        String r104 = r212.get("conversation_id");     // Catch: Exception -> L10
        if (r104 == null) goto L21;
        r101.putString("conversation_id", r104);     // Catch: Exception -> L10
        r101.putString("argConversationId", r104);     // Catch: Exception -> L10
    L21:
        String r105 = r212.get("enter_method");     // Catch: Exception -> L10
        if (r105 == null) goto L24;
        r101.putString("enter_method", r105);     // Catch: Exception -> L10
    L24:
        String r106 = r212.get("current_page");     // Catch: Exception -> L10
        if (r106 == null) goto L27;
        r101.putString("current_page", r106);     // Catch: Exception -> L10
    L27:
        String r107 = r212.get("click_from");     // Catch: Exception -> L10
        if (r107 == null) goto L30;
        r101.putString("click_from", r107);     // Catch: Exception -> L10
    L30:
        String r108 = r212.get("suggested_action_provider");     // Catch: Exception -> L10
        if (r108 == null) goto L33;
        r101.putString("suggested_action_provider", r108);     // Catch: Exception -> L10
    L33:
        String r109 = r212.get("inject_input_initial_text");     // Catch: Exception -> L10
        if (r109 == null) goto L36;
        r101.putString("inject_input_initial_text", r109);     // Catch: Exception -> L10
    L36:
        String r111 = r212.get("inject_input_initial_attachment_snapshot_id");     // Catch: Exception -> L10
        if (r111 == null) goto L39;
        r101.putString("inject_input_initial_attachment_snapshot_id", r111);     // Catch: Exception -> L10
    L39:
        String r112 = r212.get("inject_input_mobile_preview_host_enabled");     // Catch: Exception -> L10
        if (r112 == null) goto L44;
        Boolean r113 = StringsKt.toBooleanStrictOrNull(r112);     // Catch: Exception -> L10
        if (r113 == null) goto L44;
        r101.putBoolean("inject_input_mobile_preview_host_enabled", r113.booleanValue());     // Catch: Exception -> L10
    L44:
        String r114 = r212.get("inject_input_album_node_id");     // Catch: Exception -> L10
        if (r114 == null) goto L47;
        r101.putString("inject_input_album_node_id", r114);     // Catch: Exception -> L10
    L47:
        String r115 = r212.get("inject_input_upstream_album_node_id");     // Catch: Exception -> L10
        if (r115 == null) goto L50;
        r101.putString("inject_input_upstream_album_node_id", r115);     // Catch: Exception -> L10
    L50:
        String r116 = r212.get("inject_input_hide_album_entrance");     // Catch: Exception -> L10
        if (r116 == null) goto L55;
        Boolean r117 = StringsKt.toBooleanStrictOrNull(r116);     // Catch: Exception -> L10
        if (r117 == null) goto L55;
        r101.putBoolean("inject_input_hide_album_entrance", r117.booleanValue());     // Catch: Exception -> L10
    L55:
        String r118 = r212.get("inject_input_initial_attachment_uris");     // Catch: Exception -> L10
        if (r118 != null) goto L59;
    L93:
        r100.setArguments(r101);     // Catch: Exception -> L10
        r102 = this;
        r100.getLifecycle().addObserver(new InjectInputServiceProxy$createInputFragment$2(r102, r100));     // Catch: Exception -> L97
        r102.f300830d = r100;     // Catch: Exception -> L97
        return r100;
    L97:
        e = e;
        goto L101
    L59:
        if (r118.length() <= 0) goto L61;
        boolean r119 = true;
    L62:
        if (r119 == true) goto L65;
        r118 = null;
    L65:
        if (r118 == null) goto L93;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L80
        JSONArray r121 = new JSONArray(r118);     // Catch: Throwable -> L80
        ArrayList r122 = new ArrayList();     // Catch: Throwable -> L80
        int r123 = r121.length();     // Catch: Throwable -> L80
        int r124 = 0;
    L67:
        if (r124 >= r123) goto L78;
        String r125 = r121.optString(r124);     // Catch: Throwable -> L80
        if (r125.length() <= 0) goto L71;
        boolean r126 = true;
    L72:
        if (r126 == true) goto L75;
        r125 = null;
    L75:
        if (r125 == null) goto L77;
        r122.add(r125);     // Catch: Throwable -> L80
    L77:
        r124 = r124 + 1;     // Catch: Throwable -> L80
        goto L67
    L71:
        r126 = false;
        goto L72
    L78:
        Object r127 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L80
    L83:
        if (Result.m9455isFailureimpl(r127) == false) goto L85;
        r127 = null;
    L85:
        ArrayList<String> r128 = (ArrayList) r127;     // Catch: Exception -> L10
        if (r128 != null) goto L88;
    L90:
        r128 = null;
    L91:
        if (r128 == null) goto L93;
        r101.putStringArrayList("inject_input_initial_attachment_uris", r128);     // Catch: Exception -> L10
        goto L93
    L88:
        if ((!r128.isEmpty()) == false) goto L90;
    L80:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Exception -> L10
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L10
        goto L83
    L61:
        r119 = false;
    L99:
        e = e;
        r102 = this;
        goto L101
    }
}
