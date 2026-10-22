package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.layer;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ch0.f;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.r2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.live.liveinteract.multianchor.model.MicDress;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.utils.j0;
import com.bytedance.android.live.liveinteract.utils.o1;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.live.liveinteract.view.SeatPosTagLabelTextView;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.config.KtvAudioVolumeAnimConfig;
import com.bytedance.android.livesdk.config.d9;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvRoomUserLabel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.adapter.KtvRoomSeatListAdapter;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import je0.d;
import jg0.e;
import kk0.g;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import py.k;
import py.t;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvRoomGuestMicSeatBasicLayer extends jg0.a<MultiLinkGuestViewBinder.a> implements e, LinkSucAnimationView.a, e6 {
    public ImageView e;
    public AnchorPauseTipsView f;
    public View g;
    public HSImageView h;
    public LinkPlayerInfo i;
    public MultiLinkGuestViewBinder.a j;
    public j22.c k;
    public boolean l;
    public FrameLayout m;
    public TextView n;
    public ImageView o;
    public SeatPosTagLabelTextView p;
    public final String q;
    public final KtvAudioVolumeAnimConfig r;
    public KtvRoomUserLabel s;
    public boolean t;
    public final KtvRoomSeatListAdapter.b u;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public b() {
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
            r3 = null;
        L5:
            AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
            if (r5 == null) goto L9;
            r5.stop();
            r5.jumpToFrame(1);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ KtvRoomGuestMicSeatBasicLayer a;

        public c(KtvRoomGuestMicSeatBasicLayer r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            KtvRoomGuestMicSeatBasicLayer.r(this.a);
        }
    }

    static {
    }

    public final void g() {
    }

    public final void h() {
    }

    public final void i() {
    }

    public final int o() {
        return 2131566311;
    }

    public final void A() {
        MultiLinkGuestViewBinder.a r0 = this.j;
        if (r0 == null) goto L29;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L30;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 == null) goto L31;
        n.f(r2);
        MultiLinkGuestViewBinder.a r3 = this.j;
        Intrinsics.checkNotNull(r3);
        boolean r4 = f.a(r3.k);
        if (n.h(r2) == true) goto L18;
        if (r4 == true) goto L18;
        if (n.f(r2) == false) goto L18;
        HSImageView r5 = this.h;
        if (r5 == null) goto L16;
        r5.setController(null);
    L16:
        s();
        return;
    L18:
        if (n.h(r2) == true) goto L33;
        if (r4 == false) goto L21;
        return;
    L21:
        if (n.f(r2) == true) goto L35;
        HSImageView r6 = this.h;
        if (r6 == null) goto L25;
        r6.setController(null);
    L25:
        HSImageView r7 = this.h;
        if (r7 == null) goto L36;
        r7.setVisibility(4);
        return;
    L36:
        return;
    L35:
        return;
    L33:
        return;
    L31:
        return;
    L30:
        return;
    }

    public final bd0.c f() {
        ImageView r1 = this.e;
        if (r1 == null) goto L5;
        int r2 = r1.getWidth();
    L6:
        ImageView r3 = this.e;
        if (r3 == null) goto L9;
        int r4 = r3.getHeight();
    L11:
        if (r2 <= 0) goto L15;
        if (r4 <= 0) goto L15;
        boolean r5 = false;
    L16:
        String r6 = null;
        if (r5 == false) goto L24;
        int[] r7 = new int[2];
        q().getLocationOnScreen(r7);
        float r12 = r7[0] + (q().getWidth() / 2.0f);
        float r13 = r7[1] + (q().getHeight() / 2.0f);
        ImageView r8 = this.e;
        LinkPlayerInfo r9 = this.i;
        if (r9 == null) goto L23;
        IBaseUser r10 = r9.getUser();
        if (r10 == null) goto L23;
        r6 = r10.getIdString();
    L23:
        bd0.c r11 = new bd0.c(r8, null, r6, true, r12, r13, null, false, null, null, null, null, 4032);
    L30:
        return r11;
    L24:
        ImageView r14 = this.e;
        LinkPlayerInfo r15 = this.i;
        if (r15 == null) goto L29;
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L29;
        r6 = r16.getIdString();
    L29:
        r11 = new bd0.c(r14, null, r6, false, 0.0f, 0.0f, null, false, null, null, null, null, 4088);
    L15:
        r5 = true;
        goto L16
    L9:
        r4 = 0;
        goto L11
    L5:
        r2 = 0;
        goto L6
    }

    public final void s() {
        LinkPlayerInfo r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasSpecialRadioEffect() != true) goto L53;
        HSImageView r1 = this.h;
        Animatable r2 = null;
        if (r1 == null) goto L12;
        DraweeController r3 = r1.getController();
        if (r3 == null) goto L12;
        Animatable r4 = r3.getAnimatable();
    L14:
        if (r4 != null) goto L34;
        LinkPlayerInfo r5 = this.i;
        if (r5 == null) goto L26;
        MicDress r6 = r5.micDress;
        if (r6 == null) goto L26;
        MicDress.VoiceWave r7 = r6.voiceWave;
        if (r7 == null) goto L26;
        k r8 = r7.mediumImg;
        if (r8 == null) goto L26;
        List r9 = r8.getUrls();
        if (r9 == null) goto L26;
        String r10 = (String) CollectionsKt.getOrNull(r9, 0);
    L27:
        if (r10 == null) goto L34;
        AbstractDraweeController r11 = Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(r10)).setControllerListener(new b()).setAutoPlayAnimations(false).build();
        HSImageView r12 = this.h;
        if (r12 == null) goto L31;
        r12.setController(r11);
    L31:
        HSImageView r13 = this.h;
        if (r13 == null) goto L34;
        r13.setVisibility(0);
    L26:
        r10 = null;
    L34:
        HSImageView r14 = this.h;
        if (r14 == null) goto L39;
        DraweeController r15 = r14.getController();
        if (r15 == null) goto L39;
        Animatable r16 = r15.getAnimatable();
    L41:
        if ((r16 instanceof AnimatedDrawable2) == false) goto L44;
        r2 = r16;
    L44:
        AnimatedDrawable2 r17 = (AnimatedDrawable2) r2;
        if (r17 == null) goto L52;
        HSImageView r18 = this.h;
        if (r18 == null) goto L49;
        r18.setVisibility(0);
    L49:
        r17.stop();
        r17.jumpToFrame(1);
        return;
    L52:
        return;
    L39:
        r16 = null;
    L12:
        r4 = null;
        goto L14
    }

    public final boolean t() {
        LinkPlayerInfo r0 = this.i;
        if (r0 == null) goto L7;
        MicPosTagInfo r1 = r0.micPosTagInfo;
        if (r1 == null) goto L7;
        long r3 = r1.getTagTypeId();
    L9:
        if (r3 <= 0) goto L19;
        LinkPlayerInfo r2 = this.i;
        if (r2 == null) goto L15;
        MicPosTagInfo r4 = r2.micPosTagInfo;
        if (r4 == null) goto L15;
        String r5 = r4.getPositionTagName();
    L17:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        return true;
    L15:
        r5 = null;
    L19:
        return false;
    L7:
        r3 = 0;
        goto L9
    }

    public final void v() {
        LinkPlayerInfo r0 = this.i;
        String r1 = null;
        if (r0 == null) goto L7;
        IBaseUser r2 = r0.getUser();
        if (r2 == null) goto L7;
        String r3 = r2.getIdString();
    L8:
        if (r3 != null) goto L10;
        KtvRoomUserLabel r4 = KtvRoomUserLabel.UNKNOWN;
    L11:
        this.s = r4;
        StringBuilder r5 = new StringBuilder("seat uid ");
        LinkPlayerInfo r6 = this.i;
        if (r6 == null) goto L16;
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L16;
        r1 = r7.getIdString();
    L16:
        r5.append(r1);
        r5.append(" label = ");
        r5.append(r4);
        ALogger.i("KtvRoomGuestMicSeatBasicLayer", r5.toString());
        int r8 = com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.layer.a.a[r4.ordinal()];
        if (r8 != 1) goto L19;
        FrameLayout r9 = this.m;
        if (r9 == null) goto L72;
        UtilityKotlinExtentionsKt.w(r9);
    L72:
        ImageView r10 = this.o;
        if (r10 == null) goto L75;
        UtilityKotlinExtentionsKt.t(r10);
    L75:
        SeatPosTagLabelTextView r11 = this.p;
        if (r11 == null) goto L78;
        SeatPosTagLabelTextView.x(r11, 8, this.i);
    L78:
        TextView r12 = this.n;
        if (r12 == null) goto L81;
        r12.setText(s1.B(2131919497));
    L81:
        TextView r13 = this.n;
        if (r13 == null) goto L92;
        UtilityKotlinExtentionsKt.w(r13);
        return;
    L92:
        return;
    L19:
        if (r8 == 2) goto L52;
        if (r8 == 3) goto L31;
        LinkPlayerInfo r14 = this.i;
        if (r14 != null) goto L25;
    L29:
        z();
        return;
    L25:
        if (r14.isBackground == true) goto L29;
        FrameLayout r15 = this.m;
        if (r15 == null) goto L29;
        UtilityKotlinExtentionsKt.t(r15);
        goto L29
    L31:
        if (t() == false) goto L36;
        FrameLayout r16 = this.m;
        if (r16 == null) goto L35;
        UtilityKotlinExtentionsKt.t(r16);
    L35:
        z();
        return;
    L36:
        FrameLayout r17 = this.m;
        if (r17 == null) goto L39;
        UtilityKotlinExtentionsKt.w(r17);
    L39:
        ImageView r18 = this.o;
        if (r18 == null) goto L42;
        UtilityKotlinExtentionsKt.t(r18);
    L42:
        TextView r19 = this.n;
        if (r19 == null) goto L45;
        UtilityKotlinExtentionsKt.w(r19);
    L45:
        SeatPosTagLabelTextView r20 = this.p;
        if (r20 == null) goto L48;
        SeatPosTagLabelTextView.x(r20, 8, this.i);
    L48:
        TextView r21 = this.n;
        if (r21 == null) goto L87;
        r21.setText(s1.B(2131919496));
        return;
    L87:
        return;
    L52:
        if (t() == false) goto L57;
        FrameLayout r22 = this.m;
        if (r22 == null) goto L56;
        UtilityKotlinExtentionsKt.t(r22);
    L56:
        z();
        return;
    L57:
        FrameLayout r23 = this.m;
        if (r23 == null) goto L60;
        UtilityKotlinExtentionsKt.w(r23);
    L60:
        ImageView r24 = this.o;
        if (r24 == null) goto L63;
        UtilityKotlinExtentionsKt.w(r24);
    L63:
        TextView r25 = this.n;
        if (r25 == null) goto L66;
        UtilityKotlinExtentionsKt.t(r25);
    L66:
        SeatPosTagLabelTextView r26 = this.p;
        if (r26 == null) goto L90;
        SeatPosTagLabelTextView.x(r26, 8, this.i);
        return;
    L90:
        return;
    L10:
        r4 = jc1.k.n(IKtvService.class).getUserKtvRoomLabel(r3);
    L7:
        r3 = null;
        goto L8
    }

    public final void w() {
        LinkPlayerInfo r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        HSImageView r1 = this.h;
        if (r1 == null) goto L10;
        r1.setController(null);
    L10:
        HSImageView r2 = this.h;
        if (r2 == null) goto L15;
        r2.setVisibility(4);
        return;
    L15:
        return;
    L5:
        if (r0.hasSpecialRadioEffect() != true) goto L7;
        s();
    }

    public final void x() {
        int r1 = s1.f(36.0f);
        int r0 = s1.f(36.0f);
        ImageView r2 = this.e;
        LinkPlayerInfo r3 = this.i;
        if (r3 == null) goto L7;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L7;
        k r5 = d.n(r4, AvatarType.AVATAR_THUMB.getValue());
    L8:
        a1.w(r2, r5, r1, r0);
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void z() {
        if (this.s != KtvRoomUserLabel.SINGER) goto L5;
    L63:
        SeatPosTagLabelTextView r0 = this.p;
        if (r0 == null) goto L70;
        SeatPosTagLabelTextView.x(r0, 8, this.i);
        return;
    L70:
        return;
    L5:
        if (this.t == false) goto L11;
        LinkPlayerInfo r1 = this.i;
        if (r1 == null) goto L63;
        if (r1.silenceStatus != 0) goto L63;
    L11:
        LinkPlayerInfo r2 = this.i;
        Unit r3 = null;
        if (r2 != null) goto L14;
    L33:
        LinkPlayerInfo r4 = this.i;
        if (r4 == null) goto L59;
        MicPosTagInfo r6 = r4.micPosTagInfo;
        if (r6 == null) goto L59;
        if (r6.getTagType() <= 0) goto L55;
        String r5 = r6.getPositionTagName();
        if (r5 == null) goto L55;
        if (r5.length() <= 0) goto L44;
        boolean r7 = true;
    L45:
        if (r7 != true) goto L55;
        SeatPosTagLabelTextView r8 = this.p;
        if (r8 != null) goto L49;
    L50:
        int r9 = j0.a;
        j0.d(r6);
    L51:
        SeatPosTagLabelTextView r10 = this.p;
        if (r10 == null) goto L54;
        SeatPosTagLabelTextView.x(r10, 0, this.i);
    L54:
        int r11 = j0.a;
        j0.c(this.p, r6, this.i, false, null, null, 56);
        r3 = Unit.INSTANCE;
    L58:
        if (r3 == null) goto L59;
        return;
    L49:
        if (r8.getVisibility() == 0) goto L51;
    L44:
        r7 = false;
    L55:
        SeatPosTagLabelTextView r12 = this.p;
        if (r12 == null) goto L58;
        SeatPosTagLabelTextView.x(r12, 8, this.i);
        r3 = Unit.INSTANCE;
    L59:
        SeatPosTagLabelTextView r13 = this.p;
        if (r13 == null) goto L69;
        SeatPosTagLabelTextView.x(r13, 8, this.i);
        Unit r14 = Unit.INSTANCE;
        return;
    L69:
        return;
    L14:
        if (r2.isKtvHost() != true) goto L33;
        if (((Boolean) h.G2.getValue(null, h.a[187(0xbb, float:2.62E-43)])).booleanValue() == false) goto L20;
        SeatPosTagLabelTextView r15 = this.p;
        if (r15 == null) goto L23;
        UtilityKotlinExtentionsKt.w(r15);
    L23:
        SeatPosTagLabelTextView r16 = this.p;
        if (r16 == null) goto L26;
        r16.setTextColor(-1);
    L26:
        SeatPosTagLabelTextView r17 = this.p;
        if (r17 == null) goto L29;
        r17.setText(s1.B(2131917659));
    L29:
        SeatPosTagLabelTextView r18 = this.p;
        if (r18 == null) goto L67;
        r18.setBackgroundResource(2131252145);
        return;
    L67:
        return;
    L20:
        SeatPosTagLabelTextView r19 = this.p;
        if (r19 == null) goto L23;
        SeatPosTagLabelTextView.x(r19, 0, this.i);
        goto L23
    }

    public static final void r(KtvRoomGuestMicSeatBasicLayer r1) {
        MultiLinkGuestViewBinder.a r0 = r1.j;
        if (r0 == null) goto L12;
        r1.u.getClass();
        Intrinsics.checkNotNullParameter(r0, "itemData");
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L13;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r2 == null) goto L14;
        g r3 = r2.getLinkMicSeatCallback();
        if (r3 == null) goto L15;
        r3.ac(r0.k.a);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super/*jg0.c*/.a(r3);
        this.e = (ImageView) q().findViewById(2131389564);
        this.f = q().findViewById(2131389641);
        this.g = q().findViewById(2131389580);
        this.h = q().findViewById(2131389896);
        if (n() != 0) goto L7;
        q().setOnClickListener(new c(this));
        ImageView r4 = this.e;
        if (r4 == null) goto L7;
        r4.setOnClickListener(x0.a(new KtvRoomGuestMicSeatBasicLayer$onCreate$2(this)));
    L7:
        AnchorPauseTipsView r5 = this.f;
        if (r5 == null) goto L10;
        r5.R5();
        AnchorPauseTipsView.U5(r5, 6.0f);
        r2.a(r5, r5.getLayoutParams().width / 2);
    L10:
        LinkPlayerInfo r6 = this.i;
        if (r6 != null) goto L13;
    L44:
        this.k = new j22.c(this.h);
        this.m = (FrameLayout) q().findViewById(2131377067);
        this.n = (TextView) q().findViewById(2131377070);
        this.o = (ImageView) q().findViewById(2131377066);
        this.p = q().findViewById(2131377069);
        return;
    L13:
        if (r6.hasSpecialRadioEffect() != true) goto L44;
        LinkPlayerInfo r7 = this.i;
        if (r7 == null) goto L22;
        MicDress r8 = r7.micDress;
        if (r8 == null) goto L22;
        MicDress.VoiceWave r9 = r8.voiceWave;
        if (r9 == null) goto L22;
        String r10 = r9.dressId;
        if (r10 == null) goto L22;
    L23:
        Long r11 = StringsKt.toLongOrNull(r10);
        if (r11 == null) goto L26;
        r11.longValue();
    L26:
        int r12 = dk0.b.a;
        LinkPlayerInfo r13 = this.i;
        String r0 = "";
        if (r13 == null) goto L32;
        IBaseUser r14 = r13.getUser();
        if (r14 == null) goto L32;
        String r15 = r14.getIdString();
        if (r15 == null) goto L32;
    L33:
        LinkPlayerInfo r1 = this.i;
        if (r1 == null) goto L43;
        MicDress r2 = r1.micDress;
        if (r2 == null) goto L43;
        MicDress.VoiceWave r16 = r2.voiceWave;
        if (r16 == null) goto L43;
        String r17 = r16.dressId;
        if (r17 == null) goto L43;
        r0 = r17;
    L43:
        dk0.b.a(r15, r0);
    L32:
        r15 = "";
    L22:
        r10 = BDLocationException.ERROR_TIMEOUT;
        goto L23
    }

    public final void c(d6 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof d6.a) == false) goto L18;
        wj0.b r4 = ((d6.a) r3).a;
        if (r4 == null) goto L19;
        TalkRoomBaseDynamicEmoji r0 = r4.b;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.isRandomEmoji != true) goto L21;
        KtvRoomSeatListAdapter.b r1 = this.u;
        w8 r5 = ag1.d.a(r4);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "emojiMessage");
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L22;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r2 == null) goto L23;
        g r6 = r2.getLinkMicSeatCallback();
        if (r6 == null) goto L24;
        r6.N0(r5);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L19:
        return;
    }

    public final void y(boolean r3) {
        this.t = r3;
        if (r3 == false) goto L26;
        LinkPlayerInfo r4 = this.i;
        if (r4 != null) goto L7;
    L8:
        AnchorPauseTipsView r5 = this.f;
        if (r5 == null) goto L11;
        UtilityKotlinExtentionsKt.w(r5);
    L11:
        FrameLayout r6 = this.m;
        if (r6 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r6);
    L14:
        TextView r7 = this.n;
        if (r7 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r7);
    L17:
        TextView r8 = this.n;
        if (r8 == null) goto L20;
        r8.setText(s1.B(2131918663));
    L20:
        ImageView r9 = this.o;
        if (r9 == null) goto L23;
        UtilityKotlinExtentionsKt.t(r9);
    L23:
        SeatPosTagLabelTextView r10 = this.p;
        if (r10 == null) goto L32;
        SeatPosTagLabelTextView.x(r10, 8, this.i);
        return;
    L32:
        return;
    L7:
        if (r4.silenceStatus != 0) goto L8;
        return;
    L26:
        AnchorPauseTipsView r11 = this.f;
        if (r11 == null) goto L29;
        UtilityKotlinExtentionsKt.t(r11);
    L29:
        v();
        z();
    }

    public KtvRoomGuestMicSeatBasicLayer(MicSeatScene r2, KtvRoomSeatListAdapter.b r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "guestItemClickListener");
        super(r2, null);
        this.u = r3;
        d9 r4 = vm2.k.a();
        if (TextUtils.isEmpty(r4.seatTalkEffect) == false) goto L5;
        r4.seatTalkEffect = d9.e;
    L5:
        this.q = r4.seatTalkEffect;
        this.r = vm2.d.a0();
    }

    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        u((MultiLinkGuestViewBinder.a) r1, r2);
    }

    public final void u(MultiLinkGuestViewBinder.a r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "itemData");
        this.j = r8;
        ILinkPlayerInfoBridge r10 = r8.k.a;
        if ((r10 instanceof LinkPlayerInfo) == true) goto L5;
        r10 = null;
    L5:
        LinkPlayerInfo r11 = (LinkPlayerInfo) r10;
        this.i = r11;
        String r1 = "";
        if (r11 == null) goto L29;
        ImageView r2 = this.e;
        int r3 = com.bytedance.android.live.liveinteract.chatroom.chatroom.util.e.a;
        Intrinsics.checkNotNullParameter(r11, "linkPlayerInfo");
        IBaseUser r4 = r11.getUser();
        if (r4 == null) goto L14;
        t r5 = r4.getUserAttr();
        if (r5 == null) goto L14;
        if (r5.isAdmin() != true) goto L14;
        String r6 = "管理 ";
    L16:
        if (r11.isHost() == false) goto L18;
        String r7 = "主持 ";
    L20:
        if (r11.getSilenceStatus() == 0) goto L22;
        String r12 = "麦克风关闭 ";
    L23:
        IBaseUser r13 = r11.getUser();
        if (r13 == null) goto L27;
        String r14 = r13.getNickName();
        if (r14 == null) goto L27;
    L28:
        r3.c(r2, r6 + r7 + r12 + r14, true);
    L27:
        r14 = "";
        goto L28
    L22:
        r12 = "";
        goto L23
    L18:
        r7 = "";
    L14:
        r6 = "";
    L29:
        x();
        LinkPlayerInfo r15 = this.i;
        Intrinsics.checkNotNull(r15);
        if (r15.silenceStatus == 0) goto L35;
        View r16 = this.g;
        if (r16 == null) goto L34;
        r16.setVisibility(0);
    L34:
        w();
    L38:
        A();
        LinkPlayerInfo r17 = this.i;
        if (r17 != null) goto L41;
    L62:
        z();
        v();
        LinkPlayerInfo r18 = this.i;
        if (r18 != null) goto L65;
    L67:
        boolean r19 = false;
    L68:
        y(r19);
        ViewGroup r20 = q();
        StringCompanionObject r21 = StringCompanionObject.INSTANCE;
        r3.a(r20, String.format(s1.B(2131918408), Arrays.copyOf(new Object[]{Integer.valueOf(r9)}, 1)));
        return;
    L65:
        if (r18.isBackground != true) goto L67;
        r19 = true;
        goto L68
    L41:
        if (r17.hasSpecialRadioEffect() != true) goto L62;
        if (this.l == true) goto L62;
        int r22 = dk0.b.a;
        LinkPlayerInfo r23 = this.i;
        if (r23 == null) goto L50;
        IBaseUser r24 = r23.getUser();
        if (r24 == null) goto L50;
        String r25 = r24.getIdString();
        if (r25 == null) goto L50;
    L51:
        LinkPlayerInfo r26 = this.i;
        if (r26 == null) goto L61;
        MicDress r27 = r26.micDress;
        if (r27 == null) goto L61;
        MicDress.VoiceWave r28 = r27.voiceWave;
        if (r28 == null) goto L61;
        String r29 = r28.dressId;
        if (r29 == null) goto L61;
        r1 = r29;
    L61:
        dk0.b.a(r25, r1);
        this.l = true;
    L50:
        r25 = "";
        goto L51
    L35:
        View r30 = this.g;
        if (r30 == null) goto L38;
        r30.setVisibility(8);
        goto L38
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [boolean] */
    public final void k(Object r9, int r10, Bundle r11) {
        MultiLinkGuestViewBinder.a r12 = (MultiLinkGuestViewBinder.a) r9;
        Intrinsics.checkNotNullParameter(r12, "itemData");
        Intrinsics.checkNotNullParameter(r11, "payload");
        this.j = r12;
        ch0.e r0 = r12.k;
        if (r0 == null) goto L5;
        ILinkPlayerInfoBridge r1 = r0.a;
    L6:
        this.i = (LinkPlayerInfo) r1;
        Iterator<String> r13 = r11.keySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L182;
        String r2 = r13.next();
        if (r2 == null) goto L8;
        boolean r3 = true;
        switch(r2.hashCode()) {
            case -1919610850: goto L180;
            case -1010189482: goto L171;
            case -703589172: goto L168;
            case -643953561: goto L48;
            case 1640944494: goto L45;
            case 2021952839: goto L16;
            default: goto L8;
        };
    L16:
        if (r2.equals("payload_key_silence_status_update") == false) goto L8;
        LinkPlayerInfo r4 = this.i;
        if (r4 == null) goto L20;
        int r5 = r4.silenceStatus;
    L21:
        if (r5 == 0) goto L26;
        View r6 = this.g;
        if (r6 == null) goto L25;
        r6.setVisibility(0);
    L25:
        w();
    L29:
        MultiLinkGuestViewBinder.a r7 = this.j;
        if (r7 == null) goto L8;
        ch0.e r8 = r7.k;
        if (r8 == null) goto L8;
        ILinkPlayerInfoBridge r14 = r8.a;
        if (r14 == null) goto L8;
        if (r14.isBackground() != true) goto L8;
        LinkPlayerInfo r15 = this.i;
        if (r15 != null) goto L40;
    L42:
        r3 = false;
    L43:
        y(r3);
        goto L8
    L40:
        if (r15.isBackground != true) goto L42;
    L26:
        View r16 = this.g;
        if (r16 == null) goto L29;
        r16.setVisibility(8);
        goto L29
    L20:
        r5 = -1;
        goto L21
    L45:
        if (r2.equals("payload_key_mic_dress") == false) goto L8;
        A();
        goto L8
    L48:
        if (r2.equals("payload_key_mic_talk_state") == false) goto L8;
        ?? r17 = f.a(r12.k);
        if (r12.k.a.getSilenceStatus() != 0) goto L51;
        if (r17 > 0) goto L53;
        MultiLinkGuestViewBinder.a r18 = this.j;
        if (r18 == null) goto L143;
        IVoiceLiveTheme r19 = ((tf0.e) r18).c;
    L144:
        if (r19 == null) goto L150;
        if (IVoiceLiveThemeKt.isVoiceAnimInvalid(r19) != true) goto L150;
        j22.c r20 = this.k;
        if (r20 == null) goto L8;
        r20.d = true;
    L150:
        MultiLinkGuestViewBinder.a r21 = this.j;
        if (r21 == null) goto L161;
        ch0.e r22 = r21.k;
        if (r22 == null) goto L161;
        ILinkPlayerInfoBridge r23 = r22.a;
        if (r23 == null) goto L161;
        if (n.f(r23) != true) goto L161;
        j22.c r24 = this.k;
        if (r24 == null) goto L8;
        r24.d = true;
    L161:
        HSImageView r25 = this.h;
        if (r25 == null) goto L164;
        r25.setController(null);
    L164:
        HSImageView r26 = this.h;
        if (r26 == null) goto L8;
        r26.setVisibility(4);
        goto L8
    L143:
        r19 = null;
        goto L144
    L53:
        HSImageView r27 = this.h;
        if (r27 == null) goto L56;
        r27.setVisibility(0);
    L56:
        MultiLinkGuestViewBinder.a r28 = this.j;
        if (r28 == null) goto L82;
        ch0.e r29 = r28.k;
        if (r29 == null) goto L82;
        ILinkPlayerInfoBridge r30 = r29.a;
        if (r30 == null) goto L82;
        if (n.f(r30) != true) goto L82;
        MultiLinkGuestViewBinder.a r31 = this.j;
        if (r31 == null) goto L75;
        ch0.e r32 = r31.k;
        if (r32 == null) goto L75;
        ILinkPlayerInfoBridge r33 = r32.a;
        if (r33 == null) goto L75;
        kd1.b r34 = r33.getMicDress();
        if (r34 == null) goto L75;
        kd1.c r35 = r34.getVoiceWave();
        if (r35 == null) goto L75;
        k r36 = kd1.d.a(r35, r17 == true ? 1 : 0);
    L76:
        j22.c r37 = this.k;
        if (r37 == null) goto L79;
        r37.f(r36);
    L79:
        HSImageView r38 = this.h;
        if (r38 == null) goto L8;
        r38.setVisibility(0);
    L75:
        r36 = null;
    L82:
        MultiLinkGuestViewBinder.a r39 = this.j;
        if (r39 == null) goto L85;
        IVoiceLiveTheme r40 = ((tf0.e) r39).c;
    L86:
        if (r40 != null) goto L87;
        PipelineDraweeControllerBuilder r41 = Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(vm2.d.t()));
        HSImageView r42 = this.h;
        if (r42 == null) goto L133;
        DraweeController r43 = r42.getController();
    L134:
        AbstractDraweeController r44 = r41.setOldController(r43).setAutoPlayAnimations(true).build();
        HSImageView r45 = this.h;
        if (r45 == null) goto L137;
        r45.setController(r44);
    L137:
        HSImageView r46 = this.h;
        if (r46 == null) goto L8;
        r46.setVisibility(0);
        goto L8
    L133:
        r43 = null;
        goto L134
    L87:
        String r47 = this.q;
        if (r39 == null) goto L90;
        IVoiceLiveTheme r48 = ((tf0.e) r39).c;
    L91:
        VoiceLiveTheme r49 = jm2.a.d((vh7.c) r48);
        if (r49 == null) goto L129;
        VoiceLiveTheme r50 = r49;
        LinkPlayerInfo r51 = this.i;
        if (r51 != null) goto L96;
    L108:
        LinkPlayerInfo r52 = this.i;
        if (r52 == null) goto L113;
        IBaseUser r53 = r52.getUser();
        if (r53 == null) goto L113;
        int r54 = r53.getGender();
    L115:
        if (r50.isVoiceAnimInvalid() != true) goto L119;
        k r55 = r50.getVolumeAnim(3, r17 == true ? 1 : 0, r54, o1.a());
        j22.c r56 = this.k;
        if (r56 == null) goto L125;
        r56.e(r55);
    L125:
        HSImageView r57 = this.h;
        if (r57 == null) goto L8;
        r57.setVisibility(0);
        goto L8
    L119:
        String r58 = this.r.a(r54, r17 == true ? 1 : 0);
        if (r58 == null) goto L122;
        r47 = r58;
    L122:
        j22.c r59 = this.k;
        if (r59 == null) goto L125;
        r59.d(r47);
    L113:
        r54 = 0;
        goto L115
    L96:
        if (r51.hasSpecialRadioEffect() != true) goto L108;
        j22.c r60 = this.k;
        if (r60 == null) goto L125;
        LinkPlayerInfo r61 = this.i;
        if (r61 == null) goto L106;
        MicDress r62 = r61.micDress;
        if (r62 == null) goto L106;
        MicDress.VoiceWave r63 = r62.voiceWave;
        if (r63 == null) goto L106;
        k r64 = r63.getAnimByState(r17 == true ? 1 : 0);
    L107:
        r60.f(r64);
    L106:
        r64 = null;
        goto L107
    L129:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme");
    L90:
        r48 = null;
        goto L91
    L85:
        r40 = null;
        goto L86
    L51:
        w();
        goto L8
    L168:
        if (r2.equals("payload_key_user_position") == false) goto L8;
        u(r12, r10);
        goto L8
    L171:
        if (r2.equals("payload_key_background_status_update") == false) goto L8;
        LinkPlayerInfo r65 = this.i;
        if (r65 != null) goto L175;
    L177:
        r3 = false;
    L178:
        y(r3);
        goto L8
    L175:
        if (r65.isBackground != true) goto L177;
    L180:
        if (r2.equals("payload_key_avatar_update") == false) goto L8;
        x();
        goto L8
    L182:
        v();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
