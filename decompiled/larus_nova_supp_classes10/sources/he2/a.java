package he2;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.android.livesdk.config.ah;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pp1.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements c0.b {
    public DataCenter a;
    public View b;
    public final String c;
    public final Function1<String, Unit> d;

    /* JADX INFO: renamed from: he2.a$a, reason: collision with other inner class name */
    public static final class C0141a {
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    public final void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void dv(e r3) {
        Intrinsics.checkNotNullParameter(r3, "command");
        if ((r3 instanceof i) == false) goto L12;
        StringBuilder r0 = new StringBuilder("open bgm panel, ");
        i r4 = (i) r3;
        r0.append(r4.a);
        ALogger.d("ANCHOR_TASK", r0.toString());
        Object r5 = r4.a;
        if ((r5 instanceof DataCenter) == true) goto L7;
        r5 = null;
    L7:
        DataCenter r6 = (DataCenter) r5;
        if (r6 != null) goto L10;
        return;
    L10:
        this.a = r6;
        onClick(null);
        return;
    }

    public final void onClick(View r6) {
        if (((Boolean) ah.a.getValue()).booleanValue() == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e r7 = c.Q;
        Boolean r0 = Boolean.FALSE;
        r7.getClass();
        f.d(r7, r0);
        UIUtils.setViewVisibility(this.b, 8);
    L5:
        String r8 = this.c;
        if (r8.hashCode() == 3357525) goto L9;
    L11:
        String r9 = "interact";
    L12:
        Long r1 = KtvLoggerHelper.a;
        KtvLoggerHelper.L(j.b(this.a), j.e(this.a), j.a(this.a), r9, this.c);
        o r10 = m.i();
        if (r10 == null) goto L20;
        com.bytedance.live.datacontext.m r11 = r10.getRoom();
        if (r11 == null) goto L20;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L20;
        String r13 = r12.getOwnerUserIdString();
        if (r13 == null) goto L20;
    L21:
        o r2 = m.i();
        if (r2 == null) goto L28;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L28;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L28;
        long r5 = r4.getRoomId();
    L30:
        if (Intrinsics.areEqual(this.c, "more") == false) goto L32;
        String r14 = "more_panel";
    L33:
        Map<String, String> r15 = MapsKt.mapOf(new Pair[]{TuplesKt.to("anchor_id", r13), TuplesKt.to("room_id", String.valueOf(r5)), TuplesKt.to("live_type", KtvLoggerHelper.F()), TuplesKt.to("source", r14)});
        j0.l().sendLog("livesdk_live_music_icon_click", r15, new Object[]{IRoom.class});
        u r16 = m.d();
        if (r16 == null) goto L45;
        com.bytedance.live.datacontext.j r17 = r16.s();
        if (r17 == null) goto L45;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r18 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r17.getValue();
        if (r18 == null) goto L45;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r19 = r18.t();
        if (r19 == null) goto L45;
        if (r19.a != 10) goto L45;
        f2.b(2131911886, 0);
        return;
    L45:
        if (k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KSONG) == true) goto L47;
        return;
    L47:
        if (this.a == null) goto L55;
        Function1<String, Unit> r20 = this.d;
        if (r20 == null) goto L51;
        Unit r21 = (Unit) r20.invoke(this.c);
    L51:
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new b()).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("ToolbarKtvComponentBehavior");
        return;
    L55:
        return;
    L32:
        r14 = "interaction_button";
    L28:
        r5 = 0;
    L20:
        r13 = "";
        goto L21
    L9:
        if (r8.equals("more") == false) goto L11;
        r9 = "more";
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r2, Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "function");
        this.c = r2;
        this.d = r3;
    }

    public final void p4(View r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        this.a = r9;
        this.b = r8.findViewById(2131384095);
        if (((Boolean) ah.a.getValue()).booleanValue() == true) goto L5;
    L10:
        o r10 = m.i();
        if (r10 == null) goto L18;
        com.bytedance.live.datacontext.m r11 = r10.getRoom();
        if (r11 == null) goto L18;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L18;
        String r13 = r12.getOwnerUserIdString();
        if (r13 == null) goto L18;
    L19:
        o r0 = m.i();
        if (r0 == null) goto L26;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L26;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L26;
        long r3 = r2.getRoomId();
    L27:
        String r4 = k.n(IInteractService.class).getCurrentFunctionType();
        if (r4 != null) goto L30;
    L33:
        boolean r5 = true;
    L34:
        if (r5 == false) goto L36;
        String r6 = "live";
    L38:
        if (Intrinsics.areEqual(this.c, "more") == false) goto L40;
        String r7 = "more_panel";
    L41:
        Long r14 = KtvLoggerHelper.a;
        Map<String, String> r15 = MapsKt.mapOf(new Pair[]{TuplesKt.to("anchor_id", r13), TuplesKt.to("room_id", String.valueOf(r3)), TuplesKt.to("live_type", KtvLoggerHelper.F()), TuplesKt.to("function_type", r6), TuplesKt.to("source", r7)});
        j0.l().sendLog("livesdk_live_music_icon_show", r15, new Object[]{IRoom.class});
        return;
    L40:
        r7 = "interaction_button";
        goto L41
    L36:
        r6 = k.n(IInteractService.class).getCurrentFunctionType();
        goto L38
    L30:
        if (r4.length() == 0) goto L33;
        r5 = false;
    L26:
        r3 = 0;
    L18:
        r13 = "";
        goto L19
    L5:
        if (((Boolean) yo0.a.getValue()).booleanValue() == true) goto L10;
        if (((Boolean) c.Q.getValue()).booleanValue() == false) goto L9;
        UIUtils.setViewVisibility(this.b, 0);
        goto L10
    L9:
        UIUtils.setViewVisibility(this.b, 8);
        goto L10
    }
}
