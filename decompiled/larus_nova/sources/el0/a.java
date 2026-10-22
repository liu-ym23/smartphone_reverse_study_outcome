package el0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.livepkaudience.emoji.LinkPKAudienceInteractDynamicEmojiDialog;
import com.bytedance.android.live.livepkaudience.emoji.LinkPKAudienceInteractEmojiPanel;
import com.bytedance.android.live.livepkaudience.seat.PkDynamicEmojiTask;
import com.bytedance.android.live.livepkaudience.seat.PkSeatAnimationView;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.ui.LinkGuestSendGiftNoAnimationView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.config.ia1;
import com.bytedance.android.livesdk.config.n60;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends FrameLayout implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f472973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f472974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f472975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f472976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f472977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PkSeatAnimationView f472978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinkGuestSendGiftNoAnimationView f472979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f472980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f472981i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f472982j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f472983k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f472984l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f472985m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f472986n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g f472987o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.live.livepkaudience.seat.f f472988p;

    /* JADX INFO: renamed from: el0.a$a, reason: collision with other inner class name */
    public interface InterfaceC5784a {
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f472989a;

        public c(a r100) {
            this.f472989a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            g r101 = this.f472989a.getPresenter();
            if (r101 == null) goto L64;
            LinkPlayerInfo r102 = r101.d();
            if (r102 == null) goto L65;
            a r103 = this.f472989a;
            r103.getClass();
            if (((IRoomService) k.n(IRoomService.class)).isRecording() == true) goto L9;
        L11:
            long r104 = 0;
            String r105 = null;
            if (wt2.a.f(Boolean.valueOf(r103.f472982j)) == false) goto L21;
            RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r106 == null) goto L21;
            m<Integer> r107 = r106.getCleanMode();
            if (r107 == null) goto L21;
            if (r107.getValue().intValue() != 2) goto L21;
            ALogger.w("LinkPKAudienceInteractWindow", "rejected guest stub click for pure clean mode");
            return;
        L21:
            if (r103.f472981i == null) goto L73;
            g r108 = r103.f472987o;
            if (r108 == null) goto L29;
            LinkPlayerInfo r109 = r108.d();
            if (r109 == null) goto L29;
            r104 = n.b(r109);
        L29:
            if (r103.f472982j == true) goto L47;
            if (((IUserService) k.n(IUserService.class)).user().c() == false) goto L36;
            if (r103.b(r102) == false) goto L47;
        L36:
            if (r103.b(r102) == false) goto L45;
            int r110 = al0.c.f4120b;
            g r111 = r103.f472987o;
            if (r111 == null) goto L40;
            r105 = r111.f();
        L40:
            al0.c.d("oneself", r105, r104);
            tc0.c.h().G = "seat";
            int r112 = LinkPKAudienceInteractDynamicEmojiDialog.D;
            LinkPKAudienceInteractDynamicEmojiDialog r113 = LinkPKAudienceInteractDynamicEmojiDialog.a.a(r103.getContext(), r103.f472981i);
            if (DialogLancet.shouldBlockDialogShow(r113) == false) goto L60;
            DialogLancet.handleBlockedDialogShow(r113);
            return;
        L60:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L58
        L44:
            DialogLancet.beforeDialogShow(r113);
            r113.show();
            DialogLancet.afterDialogShow(r113);
            return;
        L45:
            r103.c(r102);
            return;
        L47:
            if (r103.f472983k == false) goto L56;
            int r114 = al0.c.f4120b;
            g r115 = r103.f472987o;
            if (r115 == null) goto L51;
            r105 = r115.f();
        L51:
            al0.c.d(SourceType.DEFAULT, r105, r104);
            int r116 = LinkPKAudienceInteractEmojiPanel.f81917v;
            Context r117 = r103.getContext();
            DataCenter r118 = r103.f472981i;
            boolean r119 = r103.f472982j;
            Intrinsics.checkNotNullParameter(r117, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r118, "dataCenter");
            Intrinsics.checkNotNullParameter(r102, "userInfo");
            Intrinsics.checkNotNullParameter("seat", "requestPage");
            LinkPKAudienceInteractEmojiPanel r120 = new LinkPKAudienceInteractEmojiPanel(r117, r118, r102, r119);
            Intrinsics.checkNotNullParameter("seat", "<set-?>");
            r120.f81898k = "seat";
            if (DialogLancet.shouldBlockDialogShow(r120) == false) goto L62;
            DialogLancet.handleBlockedDialogShow(r120);
            return;
        L62:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L59
        L55:
            DialogLancet.beforeDialogShow(r120);
            r120.show();
            DialogLancet.afterDialogShow(r120);
            return;
        L56:
            r103.c(r102);
            return;
        L73:
            return;
        L9:
            if (((IRoomService) k.n(IRoomService.class)).isClearRecord() == false) goto L11;
            return;
        L65:
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f472990a;

        public d(a r100) {
            this.f472990a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f472990a.getClass();
            DataCenter r101 = this.f472990a.f472981i;
            Long r102 = null;
            if (r101 == null) goto L5;
            Room r103 = (Room) r101.get("data_room", null);
        L6:
            g r104 = this.f472990a.getPresenter();
            if (r104 == null) goto L9;
            User r105 = r104.e();
        L11:
            if (n60.f120808a.getValue().booleanValue() == false) goto L28;
            RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r106 == null) goto L28;
            m<Integer> r107 = r106.getCleanMode();
            if (r107 == null) goto L28;
            Integer r108 = r107.getValue();
            if (r108 == null) goto L28;
            int r109 = r108.intValue();
            if (r109 == 2) goto L25;
            if (r109 == 3) goto L25;
            if (r109 == 13) goto L25;
            boolean r110 = false;
        L26:
            if (r110 != true) goto L28;
            return;
        L25:
            r110 = true;
        L28:
            HashMap r111 = new HashMap();
            IPkAudienceLinkOutService r112 = (IPkAudienceLinkOutService) k.n(IPkAudienceLinkOutService.class);
            g r113 = this.f472990a.getPresenter();
            if (r113 == null) goto L31;
            String r114 = r113.c();
        L33:
            if (r112.isNotSelfGuestByIId(r114) == false) goto L38;
            User r115 = ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getPkService().C();
            if (r115 == null) goto L37;
            r102 = Long.valueOf(r115.getLiveRoomId());
        L37:
            r111.put("opposite_room_id", String.valueOf(r102));
            r111.put("in_opposite_room", "1");
        L38:
            if (r103 == null) goto L42;
            if (r105 == null) goto L43;
            ((IInteractService) k.n(IInteractService.class)).showLynxGuestContributionRankList(this.f472990a.getContext(), this.f472990a.f472981i, r105, r103, r111);
            return;
        L43:
            return;
        L42:
            return;
        L31:
            r114 = null;
            goto L33
        L9:
            r105 = null;
            goto L11
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        g r100 = this.f472987o;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View.inflate(getContext(), R.layout.ttlive_pk_view_interact_guest_window, this);
        setOnClickListener(new c(this));
        DataCenter r100 = this.f472981i;
        int r101 = 0;
        if (r100 == null) goto L7;
        Boolean r102 = (Boolean) r100.get("data_is_anchor", Boolean.FALSE);
        if (r102 == null) goto L7;
        boolean r103 = r102.booleanValue();
    L8:
        this.f472982j = r103;
        this.f472974b = findViewById(R.id.offline_status);
        this.f472975c = (TextView) findViewById(R.id.online_name);
        this.f472980h = findViewById(R.id.iv_mute_icon);
        this.f472977e = findViewById(R.id.bg_container);
        this.f472978f = (PkSeatAnimationView) findViewById(R.id.seat_anim_view);
        this.f472976d = (TextView) findViewById(R.id.guest_debug_view);
        this.f472979g = (LinkGuestSendGiftNoAnimationView) findViewById(R.id.online_fans_ticket_count);
        PkSeatAnimationView r104 = this.f472978f;
        if (r104 == null) goto L24;
        View r105 = FrameLayout.inflate(r104.getContext(), R.layout.ttlive_view_audience_pk_seat_animation_view, r104);
        r104.f82231b = r105;
        HSImageView r106 = null;
        if (r105 == null) goto L13;
        DynamicEmojiView r107 = (DynamicEmojiView) r105.findViewById(R.id.dynamic_emoji_view);
    L14:
        r104.f82232c = r107;
        View r108 = r104.f82231b;
        if (r108 == null) goto L17;
        r106 = (HSImageView) r108.findViewById(R.id.emoji_mask_layer);
    L17:
        r104.f82233d = r106;
        com.bytedance.android.live.livepkaudience.seat.g r109 = new com.bytedance.android.live.livepkaudience.seat.g();
        r104.f82230a = r109;
        PkDynamicEmojiTask r110 = new PkDynamicEmojiTask(r109, r104.f82232c, r104.f82233d);
        com.bytedance.android.live.livepkaudience.seat.d r111 = r109.f82242b;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, "task");
        if (r111.f82237b != null) goto L20;
        r111.f82237b = r110;
        r111.f82238c = r110;
        goto L24
    L20:
        com.bytedance.android.live.livepkaudience.seat.a r112 = r111.f82238c;
        if (r112 == null) goto L23;
        r112.b(r110);
    L23:
        r111.f82238c = r110;
        goto L24
    L13:
        r107 = null;
    L24:
        g r113 = this.f472987o;
        if (r113 == null) goto L27;
        r113.a(this);
    L27:
        B3(true);
        PkSeatAnimationView r114 = this.f472978f;
        if (r114 == null) goto L41;
        com.bytedance.android.live.livepkaudience.seat.f r115 = this.f472988p;
        if (r115 == null) goto L41;
        g r116 = this.f472987o;
        if (r116 == null) goto L39;
        LinkPlayerInfo r117 = r116.d();
        if (r117 == null) goto L39;
        IBaseUser r118 = r117.getUser();
        if (r118 == null) goto L39;
        String r119 = r118.getIdString();
        if (r119 == null) goto L39;
    L40:
        Intrinsics.checkNotNullParameter(r119, "userId");
        Intrinsics.checkNotNullParameter(r114, "view");
        r115.f82240a.put(r119, r114);
    L39:
        r119 = "0";
    L41:
        LinkGuestSendGiftNoAnimationView r120 = this.f472979g;
        if (r120 != null) goto L44;
    L48:
        LinkGuestSendGiftNoAnimationView r121 = this.f472979g;
        if (r121 == null) goto L52;
        r121.setOnClickListener(new d(this));
        return;
    L52:
        return;
    L44:
        if (this.f472985m == true) goto L47;
        r101 = 8;
    L47:
        r120.setVisibility(r101);
    L7:
        r103 = false;
        goto L8
    }

    public final boolean getMIsBackGround() {
        return this.f472986n;
    }

    public final g getPresenter() {
        return this.f472987o;
    }

    @Override // el0.h
    public final void B3(boolean r100) {
        g r101 = this.f472987o;
        if (r101 == null) goto L5;
        LinkPlayerInfo r102 = r101.d();
    L6:
        boolean r103 = b(r102);
        View r104 = this.f472974b;
        if (r104 == null) goto L15;
        if (r100 == true) goto L12;
        if (r103 == true) goto L12;
        int r105 = 0;
    L13:
        r104.setVisibility(r105);
        return;
    L12:
        r105 = 4;
        goto L13
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // el0.h
    public final void Qb(LinkPlayerInfo r100) {
        if (r100 == null) goto L51;
        DataCenter r101 = this.f472981i;
        CharSequence r102 = null;
        if (r101 == null) goto L6;
        Boolean r103 = (Boolean) r101.get("data_pk_anchor_silence_status_change", Boolean.FALSE);
    L7:
        IBaseUser r104 = r100.getUser();
        if (r104 == null) goto L10;
        String r105 = r104.getRealNickName();
    L12:
        if (r105 == null) goto L14;
        int r106 = r105.length();
    L16:
        if (r106 < 10) goto L21;
        if (r105 == null) goto L19;
        r102 = r105.subSequence(0, 10);
    L19:
        r105 = Intrinsics.stringPlus((String) r102, "...");
    L21:
        if (TextUtils.isEmpty(r105) == false) goto L25;
        TextView r107 = this.f472975c;
        if (r107 == null) goto L31;
        UtilityKotlinExtentionsKt.z(r107, false);
    L31:
        i4(r100.getFanTicketDisplayStr());
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == true) goto L34;
    L38:
        int r108 = r100.silenceStatus;
        if (r108 != 3) goto L41;
    L47:
        View r109 = this.f472980h;
        if (r109 == null) goto L56;
        UtilityKotlinExtentionsKt.z(r109, true);
        return;
    L56:
        return;
    L41:
        if (r108 == 2) goto L47;
        if (r108 == 1) goto L47;
        View r110 = this.f472980h;
        if (r110 == null) goto L54;
        UtilityKotlinExtentionsKt.z(r110, false);
        return;
    L54:
        return;
    L34:
        if (this.f472983k == true) goto L38;
        View r111 = this.f472980h;
        if (r111 == null) goto L52;
        UtilityKotlinExtentionsKt.z(r111, true);
        return;
    L52:
        return;
    L25:
        TextView r112 = this.f472975c;
        if (r112 == null) goto L28;
        UtilityKotlinExtentionsKt.z(r112, true);
    L28:
        TextView r113 = this.f472975c;
        if (r113 == null) goto L31;
        r113.setText(r105);
        goto L31
    L14:
        r106 = 0;
        goto L16
    L10:
        r105 = null;
        goto L12
    L6:
        r103 = null;
        goto L7
    }

    public final void a(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        removeView(this.f472973a);
        this.f472973a = r100;
        ViewParent r101 = r100.getParent();
        if (r101 != null) goto L7;
    L9:
        r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r102 = Unit.INSTANCE;
        this.f472973a = r100;
        addView(r100, 0);
        return;
    L7:
        if ((r101 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r101).removeView(this.f472973a);
        goto L9
    }

    public final boolean b(LinkPlayerInfo r100) {
        if (r100 == null) goto L6;
        IBaseUser r101 = r100.getUser();
        if (r101 == null) goto L6;
        String r102 = r101.getIdString();
    L8:
        if (Intrinsics.areEqual(r102, ((IUserService) k.n(IUserService.class)).user().b().getIdString()) == false) goto L11;
        return true;
    L11:
        return false;
    L6:
        r102 = null;
        goto L8
    }

    public final void c(LinkPlayerInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        IBaseUser r101 = r100.getUser();
        if (r101 == null) goto L10;
        String r102 = r101.getIdString();
        if (r102 == null) goto L11;
        UserProfileEvent r103 = new UserProfileEvent(r102);
        r103.setClickUserPosition(UserProfileEvent.POSITION_LINKED_AUDIENCE);
        r103.interactLogLabel = "right_anchor";
        r103.setReportSource("anchor_linkmic");
        r103.setReportType(UserProfileEvent.DATA_TYPE_CARD_LINKED_AUDIENCE);
        r103.user = r100.getUser();
        DataCenter r104 = this.f472981i;
        if (r104 == null) goto L12;
        r104.put("cmd_show_user_profile", r103);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void e(boolean r100) {
        boolean r101 = true;
        if (r100 == false) goto L7;
        View r102 = this.f472980h;
        if (r102 == null) goto L22;
        UtilityKotlinExtentionsKt.z(r102, true);
        return;
    L22:
        return;
    L7:
        g r103 = this.f472987o;
        if (r103 == null) goto L24;
        LinkPlayerInfo r104 = r103.d();
        if (r104 == null) goto L25;
        View r105 = this.f472980h;
        if (r105 == null) goto L26;
        int r106 = r104.silenceStatus;
        if (r106 != 3) goto L16;
    L20:
        UtilityKotlinExtentionsKt.z(r105, r101);
        return;
    L16:
        if (r106 == 2) goto L20;
        if (r106 == 1) goto L20;
        r101 = false;
        goto L20
    L26:
        return;
    L25:
        return;
    }

    @Override // el0.h
    public final void i4(String r100) {
        LinkGuestSendGiftNoAnimationView r101 = this.f472979g;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final void setDebugText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (ia1.f120435a.getValue().booleanValue() == false) goto L11;
        TextView r101 = this.f472976d;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        TextView r102 = this.f472976d;
        if (r102 == null) goto L12;
        r102.setText(r100);
        return;
    L12:
        return;
    }

    public final void setIsBackGround(boolean r100) {
        this.f472986n = r100;
    }

    public final void setIsOpenSendGift(boolean r100) {
        this.f472985m = r100;
        LinkGuestSendGiftNoAnimationView r101 = this.f472979g;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public final void setIsSelfRoomWindow(boolean r100) {
        this.f472983k = r100;
    }

    public final void setMIsBackGround(boolean r100) {
        this.f472986n = r100;
    }

    @Override // el0.h
    public void setVisibility(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        setVisibility(r101);
        return;
    L4:
        r101 = 4;
        goto L5
    }

    public final void d(boolean r100, boolean r101) {
        this.f472983k = r101;
        View r102 = this.f472977e;
        if (r102 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r102, true);
    L5:
        int r103 = R.drawable.ttlive_pk_guest_empty_stream_icon;
        if (r100 == false) goto L12;
        View r104 = this.f472977e;
        if (r104 == null) goto L22;
        if (r101 == false) goto L11;
        r103 = R.drawable.ttlive_pk_self_audience_empty_stream_icon;
    L11:
        r104.setBackgroundResource(r103);
        return;
    L22:
        return;
    L12:
        View r105 = this.f472977e;
        if (r105 == null) goto L24;
        if (r101 == true) goto L16;
    L20:
        r105.setBackgroundResource(r103);
        return;
    L16:
        if (this.f472982j == false) goto L18;
    L19:
        r103 = R.drawable.ttlive_pk_self_empty_stream_icon;
        goto L20
    L18:
        if (((IUserService) k.n(IUserService.class)).user().c() == false) goto L20;
    }

    public a(FragmentActivity r100, g r101, InterfaceC5784a r102, DataCenter r103, com.bytedance.android.live.livepkaudience.seat.f r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f472987o = r101;
        this.f472988p = r104;
        this.f472981i = r103;
    }
}
