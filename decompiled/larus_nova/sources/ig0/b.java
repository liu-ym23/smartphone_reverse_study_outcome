package ig0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.n;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.o;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.p;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.w;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: classes46.dex */
public class b extends jg0.a<MultiLinkGuestViewBinder.a> implements e6, LinkSucAnimationView.a, ke0.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MultiLinkGuestViewBinder.a f489699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SeatAnimationView f489700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f489701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final hg0.a f489702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f489703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SeatAnimEngineWrapper f489704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final o f489705k;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f489706a;

        public a(b r100) {
            this.f489706a = r100;
        }

        public final void a() {
            b r100 = this.f489706a;
            hg0.a r101 = r100.f489702h;
            View r102 = null;
            if (r101 == null) goto L7;
            g r103 = r101.ph(r100.f489701g);
            if (r103 == null) goto L7;
            View r104 = r103.m(R.id.ttlive_guest_avatar);
        L8:
            ImageView r105 = (ImageView) r104;
            if (r105 == null) goto L11;
            this.f489706a.t().setGuestAvatar(r105);
        L11:
            b r106 = this.f489706a;
            hg0.a r107 = r106.f489702h;
            if (r107 == null) goto L16;
            g r108 = r107.ph(r106.f489701g);
            if (r108 == null) goto L16;
            r102 = r108.m(R.id.ttlive_guest_name);
        L16:
            TextView r109 = (TextView) r102;
            if (r109 == null) goto L20;
            this.f489706a.t().setGuestName(r109);
            return;
        L20:
            return;
        L7:
            r104 = null;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: ig0.b$b, reason: collision with other inner class name */
    public static final class RunnableC6261b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f489707a;

        public RunnableC6261b(b r100) {
            this.f489707a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SeatAnimationView r100 = this.f489707a.t();     // Catch: Throwable -> L14
            if (r100 == null) goto L5;
            r100.setLinkSucCallback(this.f489707a);     // Catch: Throwable -> L14
        L5:
            SeatAnimationView r101 = this.f489707a.t();     // Catch: Throwable -> L14
            if (r101 == null) goto L8;
            r101.setEmojiCallback(this.f489707a);     // Catch: Throwable -> L14
        L8:
            b r102 = this.f489707a;     // Catch: Throwable -> L14
            if (r102.f489705k == null) goto L17;
            SeatAnimationView r103 = r102.t();     // Catch: Throwable -> L14
            if (r103 == null) goto L21;
            r103.setTaskChain(this.f489707a.f489705k);     // Catch: Throwable -> L14
            return;
        L21:
            return;
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    @Override // jg0.c, jg0.f
    public final void j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // jg0.c
    public int o() {
        return R.layout.ttlive_layer_multilink_seat_anim_stub;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView.a
    public final void g() {
        hg0.a r100 = this.f489702h;
        if (r100 == null) goto L8;
        g r101 = r100.ph(this.f489701g);
        if (r101 == null) goto L9;
        r101.g();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView.a
    public final void h() {
        hg0.a r100 = this.f489702h;
        if (r100 == null) goto L8;
        g r101 = r100.ph(this.f489701g);
        if (r101 == null) goto L9;
        r101.h();
        return;
    L9:
        return;
    }

    @Override // jg0.c
    public String p() {
        return VerticalNitaInflate.Tag.MultiLinkMicSeatAnimLayer.name();
    }

    public void r() {
        SeatAnimationView r100 = this.f489700f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L5:
        r100.post(new a(this));
    }

    public boolean s() {
        MultiLinkGuestViewBinder.a r100 = this.f489699e;
        if (r100 == null) goto L13;
        e r101 = r100.f75934k;
        if (r101 == null) goto L14;
        ILinkPlayerInfoBridge r102 = r101.f23724a;
        if (r102 != null) goto L9;
        return true;
    L9:
        if (r102.isEnlarged() != true) goto L16;
        return false;
    L16:
        return true;
    L14:
        return true;
    L13:
        return true;
    }

    public final SeatAnimationView t() {
        SeatAnimationView r100 = this.f489700f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L5:
        return r100;
    }

    @Override // jg0.c, jg0.f
    public void a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.a(r110);
        j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r100 = m.d().getVideoTalkRoomSubScene();
        if (r100 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r101 = r100.getValue();
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r102 = r101.t();
        if (r102 == null) goto L9;
        List<Integer> r103 = r102.f114799b;
    L10:
        j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r104 = m.d().getVideoTalkRoomSubScene();
        if (r104 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r105 = r104.getValue();
        if (r105 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r106 = r105.t();
        if (r106 == null) goto L17;
        Integer r107 = Integer.valueOf(r106.f114800c);
    L18:
        Boolean r108 = m.i().isAnchor();
        if (r108 == null) goto L21;
        boolean r109 = r108.booleanValue();
    L22:
        MicSeatScene r111 = this.f498952b;
        MicSeatScene r112 = MicSeatScene.AUDIO_LINK_LARGE;
        if (r111 != r112) goto L25;
        boolean r113 = true;
    L26:
        this.f489700f = (SeatAnimationView) q().findViewById(R.id.seat_anim_view);
        Integer r114 = je0.d.h();
        if (r114 != null) goto L30;
    L32:
        boolean r115 = r109;
    L33:
        MicSeatScene r116 = this.f498952b;
        if (r116 != MicSeatScene.AUDIO_LINK) goto L36;
    L58:
        SeatAnimationView r117 = this.f489700f;
        if (r117 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L61:
        r117.post(new c(this, r115, r113, r103, r107));
    L62:
        SeatAnimationView r118 = this.f489700f;
        if (r118 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L65:
        if (r118 == null) goto L68;
        r118.post(new RunnableC6261b(this));
        return;
    L68:
        return;
    L36:
        if (r116 == MicSeatScene.AUDIO_LINK_ANCHOR) goto L58;
        if (r116 == r112) goto L58;
        if (r116 == MicSeatScene.AUDIO_LINK_C_POSITION) goto L58;
        if (r116 == MicSeatScene.AUDIO_LINK_C_POSITION_V2) goto L58;
        if (r116 == MicSeatScene.AUDIO_LINK_HAMLET_AVATAR_C_POSITION) goto L58;
        if (r116 == MicSeatScene.AUDIO_LINK_HEAD_RADIO) goto L58;
        SeatAnimationView r119 = this.f489700f;
        if (r119 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L50:
        r119.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        if (this.f498952b != r112) goto L53;
        int r120 = s1.j(R.dimen.ttlive_voice_chat_guest_seat_effect_size_large);
    L54:
        SeatAnimationView r121 = this.f489700f;
        if (r121 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L57:
        r121.c(this.f489703i, this.f498952b, r113, r115, r120, r120);
        goto L62
    L53:
        r120 = 0;
        goto L54
    L30:
        if (r114.intValue() != 24) goto L32;
        r115 = false;
        goto L33
    L25:
        r113 = false;
        goto L26
    L21:
        r109 = false;
    L17:
        r107 = null;
    L9:
        r103 = null;
        goto L10
    }

    @Override // ke0.a
    public final void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        SeatAnimEngineWrapper r101 = this.f489704j;
        if (r101 == null) goto L22;
        SeatAnimManager r102 = r101.f75864a;
        if (r102 == null) goto L23;
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b) == false) goto L17;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b r103 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b) r100;
        String r104 = r103.f72215c;
        Map<String, SeatAnimationView> r105 = r102.f72201a;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        SeatAnimationView r107 = (SeatAnimationView) r106.get(r104.toString());
        if (r107 == null) goto L12;
        r107.b(r103);
        return;
    L12:
        if (r103.f72214b == false) goto L25;
        Function0<Unit> r108 = r103.f72221i;
        if (r108 == null) goto L26;
        Unit r109 = r108.invoke();
        return;
    L26:
        return;
    L25:
        return;
    L17:
        if ((r100 instanceof n) == false) goto L28;
        n r110 = (n) r100;
        String r111 = r110.f72334a.c();
        Map<String, SeatAnimationView> r112 = r102.f72201a;
        LinkedHashMap r113 = (LinkedHashMap) r112;
        SeatAnimationView r114 = (SeatAnimationView) r113.get(r111.toString());
        if (r114 == null) goto L29;
        r114.b(r110);
        return;
    L29:
        return;
    L28:
        return;
    L23:
        return;
    }

    public void c(d6 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        hg0.a r101 = this.f489702h;
        if (r101 == null) goto L8;
        g r102 = r101.ph(this.f489701g);
        if (r102 == null) goto L9;
        r102.c(r100);
        return;
    L9:
        return;
    }

    @Override // jg0.f
    public final void d(Object r110, int r210) {
        MultiLinkGuestViewBinder.a r100 = (MultiLinkGuestViewBinder.a) r110;
        Intrinsics.checkNotNullParameter(r100, "itemData");
        this.f489701g = r210;
        this.f489699e = r100;
        i<ILinkPlayerInfoBridge> r101 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        SeatAnimationView r102 = this.f489700f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L5:
        r102.setEnableShowKtvSeatAnimation(s());
        IBaseUser r103 = r100.f75934k.f23724a.getUser();
        if (r103 == null) goto L96;
        r();
        SeatAnimationView r104 = this.f489700f;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L11:
        r104.post(new d(this, r210));
        SeatAnimEngineWrapper r105 = this.f489704j;
        if (r105 == null) goto L20;
        String r106 = r103.getIdString();
        SeatAnimationView r107 = this.f489700f;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L16:
        Intrinsics.checkNotNullParameter(r106, "userId");
        Intrinsics.checkNotNullParameter(r107, "view");
        SeatAnimManager r108 = r105.f75864a;
        if (r108 == null) goto L20;
        r108.e(r106, r107);
    L20:
        if ((r101 instanceof y) == false) goto L83;
        y r109 = (y) r101;
        String r111 = r103.getIdString();
        r109.getClass();
        Intrinsics.checkNotNullParameter(r111, "userId");
        if (((ArrayList) r109.f76338y).contains(r111) == true) goto L83;
        SeatAnimEngineWrapper r112 = this.f489704j;
        if (r112 == null) goto L78;
        String r113 = r103.getIdString();
        int r114 = p.f72337a;
        ILinkPlayerInfoBridge r115 = r100.f75934k.f23724a;
        Intrinsics.checkNotNullParameter(r115, "guestInfo");
        IBaseUser r116 = r115.getUser();
        Intrinsics.checkNotNull(r116);
        String r117 = r116.getIdString();
        int r118 = r115.getApplyType();
        IBaseUser r119 = r115.getUser();
        if (r119 == null) goto L28;
        String r120 = r119.getRealNickName();
    L29:
        IBaseUser r121 = r115.getUser();
        if (r121 == null) goto L32;
        py.k r122 = r121.getAvatarThumbKt();
    L33:
        int r123 = r115.getApplyType();
        LinkApplyType r124 = LinkApplyType.MATCH;
        MultiLinkGuestViewBinder.a r125 = r100;
        if (r123 == r124.getValue()) goto L36;
    L38:
        IMatchEffect r126 = r115.getMatchEffect();
    L39:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.i r127 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.i(r117, new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.j(r118, r120, r122, r126));
        SeatAnimationView r128 = this.f489700f;
        if (r128 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L42:
        Intrinsics.checkNotNullParameter(r113, "userId");
        Intrinsics.checkNotNullParameter(r127, "event");
        SeatAnimManager r129 = r112.f75864a;
        if (r129 == null) goto L79;
        Intrinsics.checkNotNullParameter(r113, "userId");
        Intrinsics.checkNotNullParameter(r127, "event");
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.j r130 = r127.f72229b;
        if (r130 != null) goto L47;
    L50:
        za r131 = null;
        r127.f72229b = null;
        if (r128 == null) goto L55;
        LinkSucAnimationView.a r132 = r128.getLinkSucAnimCallback();
        if (r132 == null) goto L60;
        r132.h();
    L60:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.j r133 = r127.f72229b;
        if (r133 != null) goto L63;
    L73:
        if (r128 == null) goto L75;
        Intrinsics.checkNotNullParameter(r127, "event");
        r128.post(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.i(r128, r127));
    L80:
        String r134 = r103.getIdString();
        Intrinsics.checkNotNullParameter(r134, "userId");
        y r135 = r109;
        if (((ArrayList) r135.f76338y).contains(r134) == true) goto L84;
        ((ArrayList) r135.f76338y).add(r134);
    L84:
        SeatAnimEngineWrapper r136 = this.f489704j;
        if (r136 == null) goto L94;
        ch0.c r137 = r125.f75939p;
        if (r137 == null) goto L89;
        za r138 = r137.f23718a;
    L90:
        SeatAnimManager r139 = r136.f75864a;
        if (r139 == null) goto L95;
        r139.d(r138);
        return;
    L95:
        return;
    L89:
        r138 = r131;
        goto L90
    L94:
        return;
    L75:
        Map<String, SeatAnimationView> r140 = r129.f72201a;
        LinkedHashMap r141 = (LinkedHashMap) r140;
        SeatAnimationView r142 = (SeatAnimationView) r141.get(r113.toString());
        if (r142 == null) goto L80;
        Intrinsics.checkNotNullParameter(r127, "event");
        r142.post(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.i(r142, r127));
        goto L80
    L63:
        if (r133.f72233d != null) goto L73;
        if (r128 == null) goto L68;
        LinkSucAnimationView.a r143 = r128.getLinkSucAnimCallback();
        if (r143 == null) goto L73;
        r143.h();
        goto L73
    L68:
        Map<String, SeatAnimationView> r144 = r129.f72201a;
        LinkedHashMap r145 = (LinkedHashMap) r144;
        SeatAnimationView r146 = (SeatAnimationView) r145.get(r127.f72228a.toString());
        if (r146 == null) goto L73;
        LinkSucAnimationView.a r147 = r146.getLinkSucAnimCallback();
        if (r147 == null) goto L73;
        r147.h();
        goto L73
    L55:
        Map<String, SeatAnimationView> r148 = r129.f72201a;
        LinkedHashMap r149 = (LinkedHashMap) r148;
        SeatAnimationView r150 = (SeatAnimationView) r149.get(r127.f72228a.toString());
        if (r150 == null) goto L60;
        LinkSucAnimationView.a r151 = r150.getLinkSucAnimCallback();
        if (r151 == null) goto L60;
        r151.h();
        goto L60
    L47:
        if (r130.f72230a != r124.getValue()) goto L50;
        r131 = null;
    L79:
        r131 = null;
        goto L80
    L36:
        if (r115.getMatchEffect() != null) goto L38;
        r126 = (IMatchEffect) f.c(IMatchEffect.class);
        py.k r152 = qy.a.c();
        ArrayList r153 = new ArrayList();
        r153.add("https://lf1-webcastcdn-tos.huoshanstatic.com/obj/live-android/live_interact_fast_match_link_enter_guide.webp");
        r152.setUrls(r153);
        r126.setMatchEffect(r152);
        goto L39
    L32:
        r122 = null;
        goto L33
    L28:
        r120 = null;
        goto L29
    L78:
        r125 = r100;
        r109 = r109;
    L83:
        r125 = r100;
        r131 = null;
        goto L84
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(Object r100, int r101, Bundle r102) {
        u((MultiLinkGuestViewBinder.a) r100, r101, r102);
    }

    public void u(MultiLinkGuestViewBinder.a r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        Iterator<String> r103 = r102.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L35;
        String r104 = r103.next();
        if (r104 == null) goto L4;
        int r105 = r104.hashCode();
        if (r105 != (-715388833)) goto L11;
        if (r104.equals("payload_key_is_c_position_update") == false) goto L4;
    L31:
        SeatAnimationView r106 = this.f489700f;
        if (r106 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L34:
        r106.post(new d(this, r101));
        goto L4
    L11:
        if (r105 != (-703589172)) goto L13;
        if (r104.equals("payload_key_user_position") == false) goto L4;
    L13:
        if (r105 != 577182853) goto L4;
        if (r104.equals("payload_key_ktv_business_update") == false) goto L4;
        SeatAnimEngineWrapper r107 = this.f489704j;
        if (r107 == null) goto L4;
        ch0.c r108 = r100.f75939p;
        if (r108 == null) goto L22;
        za r109 = r108.f23718a;
    L23:
        SeatAnimManager r110 = r107.f75864a;
        if (r110 == null) goto L4;
        r110.d(r109);
        goto L4
    L22:
        r109 = null;
        goto L23
    }

    public b(hg0.a r100, int r101, SeatAnimEngineWrapper r102, MicSeatScene r103, xg0.a r104) {
        Intrinsics.checkNotNullParameter(r103, "scene");
        super(r103, r104);
        this.f489702h = r100;
        this.f489703i = r101;
        this.f489704j = r102;
        this.f489705k = null;
    }
}
