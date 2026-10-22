package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.n;
import com.bytedance.android.live.ktv.common.util.w;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonStackAvatarView;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.selected.view.MultiUserAvatarView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusShowUser;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.Lists;
import com.bytedance.live.datacontext.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/dialog/selected/KtvRoomSelectedMusicViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class KtvRoomSelectedMusicViewHolder extends RecyclerView.ViewHolder {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final View D;
    public MusicPanel E;
    public boolean F;
    public final boolean G;
    public final boolean a;
    public final boolean b;
    public final String c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final View s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MusicPanel a;

        public b(MusicPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            KtvMusic r10 = this.a.a;
            KtvContext.Companion.getClass();
            k<com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a> r0 = KtvContext.a.g().getOpenOpusPreViewDialog();
            com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a r7 = new com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a(r10.getMId(), r10.getOrderUserIdString(), false, "order_tab");
            r7.a = this.a;
            Unit r11 = Unit.INSTANCE;
            r0.post(r7);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ KtvRoomSelectedMusicViewHolder a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ wb0.a c;
        public final /* synthetic */ MusicPanel d;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r14, int r15) {
                c r16 = this.a;
                r16.c.b(r16.d);
                if (this.a.a.d4() == false) goto L6;
                String r17 = "anchor";
            L5:
                String r5 = r17;
                MusicPanel r18 = this.a.a.E;
                if (r18 == null) goto L18;
                KtvMusic r19 = r18.a;
                if (r19 == null) goto L18;
                String r110 = com.bytedance.android.live.ktv.common.util.a.b(r19);
            L20:
                if (r110 != null) goto L22;
            L25:
                boolean r3 = true;
            L26:
                if (r3 == false) goto L28;
                HashMap r10 = null;
            L29:
                Long r111 = KtvLoggerHelper.a;
                String r112 = this.a.d.a.getMTitle();
                if (r112 != null) goto L32;
                r112 = "";
            L32:
                long r2 = this.a.d.a.getMId();
                OrderInfo r4 = this.a.d.a.getOrderInfo();
                if (r4 == null) goto L39;
                InteractiveSongUserInfo r6 = r4.getTopUser();
                if (r6 == null) goto L39;
                String r7 = r6.getIdString();
                if (r7 == null) goto L39;
            L40:
                MusicPanel r8 = this.a.d;
                String r9 = r8.d;
                String r11 = r8.b();
                String r12 = this.a.d.a.getMAuthor();
                if (r12 != null) goto L43;
                String r13 = "";
            L44:
                KtvLoggerHelper.Y("delete", r112, r2, r7, r5, r9, r11, r13, Intrinsics.areEqual(this.a.d.A, Boolean.TRUE), r10, this.a.d);
                r14.dismiss();
                return;
            L43:
                r13 = r12;
            L39:
                r7 = "";
                goto L40
            L28:
                r10 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("song_type", r110)});
                goto L29
            L22:
                if (r110.length() == 0) goto L25;
                r3 = false;
            L18:
                r110 = null;
                goto L20
            L6:
                Integer r113 = (Integer) ((ge1.a) hd0.c.f()).b;
                if (r113 != null) goto L10;
            L11:
                r17 = "user";
                goto L5
            L10:
                if (r113.intValue() != 2) goto L11;
                r17 = "guest";
                goto L5
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                r1.dismiss();
            }
        }

        public c(KtvRoomSelectedMusicViewHolder r1, Ref.BooleanRef r2, wb0.a r3, MusicPanel r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (this.b.element == false) goto L5;
            int r0 = 2131918451;
        L6:
            x0.b r1 = new x0.b(r5.getContext(), 4);
            r1.a.k = false;
            r1.i(0, 2131915913, new a(this));
            r1.i(1, 2131915442, b.a);
            if (this.d.e == false) goto L9;
            r1.m(r0);
            r1.l(2131918518);
        L10:
            r1.n();
            return;
        L9:
            r1.l(r0);
            goto L10
        L5:
            r0 = 2131918517;
            goto L6
        }
    }

    static {
    }

    public final TextView V3() {
        return (TextView) this.q.getValue();
    }

    public final TextView W3() {
        return (TextView) this.r.getValue();
    }

    public final TextView X3() {
        return (TextView) this.i.getValue();
    }

    public final TextView Y3() {
        return (TextView) this.m.getValue();
    }

    public final TextView Z3() {
        return (TextView) this.e.getValue();
    }

    public final HSImageView a4() {
        return (HSImageView) this.d.getValue();
    }

    public final View b4() {
        return (View) this.g.getValue();
    }

    public final View getRemove() {
        return (View) this.f.getValue();
    }

    public void c4() {
        int r0 = KtvOrderSongThemeManager.a;
        KtvOrderSongThemeManager.c(this.D, KtvOrderSongThemeManager.p);
        TextView r1 = Y3();
        int r2 = KtvOrderSongThemeManager.a;
        KtvOrderSongThemeManager.d(r1, r2);
        Y3().setMaxWidth(s1.f(78.0f));
        KtvOrderSongThemeManager.d(X3(), 10);
        KtvOrderSongThemeManager.d(Z3(), r2);
    }

    public final void e4() {
        if (this.D.isSelected() == true) goto L5;
        String r0 = s1.B(2131918606);
    L6:
        r3.d(this.D, r0, false, true);
        return;
    L5:
        r0 = s1.B(2131918605);
        goto L6
    }

    public final boolean d4() {
        Boolean r0 = o3.f().isAnchor();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public KtvRoomSelectedMusicViewHolder(final View r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        KtvContext.Companion.getClass();
        this.a = KtvContext.a.k();
        this.b = KtvContext.a.j();
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L9;
        String r2 = r1.n();
        if (r2 == null) goto L9;
    L10:
        this.c = r2;
        this.d = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$singingIcon$2(r3));
        this.e = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$sequenceNum$2(r3));
        this.f = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$remove$2(r3));
        this.g = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$up$2(r3));
        this.h = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$musicCover$2(r3));
        this.i = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$musicName$2(r3));
        this.j = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$musicDuration$2(r3));
        this.k = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$musicAuthor$2(r3));
        this.l = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$musicUserAvatar$2(r3));
        this.m = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$musicUserName$2(r3));
        this.n = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$multiUserAvatar$2(r3));
        this.o = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$ktvCommonStackAvatarView$2(r3));
        this.p = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$multiUserCount$2(r3));
        this.q = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$joinMultiChorusBtn$2(r3));
        this.r = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$linkMic$2(r3));
        this.s = r3.findViewById(2131384878);
        this.t = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$rtChorusLiveIv$2(r3));
        this.u = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$rtChorusAvatarFl$2(r3));
        this.v = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$rtChorusAvatar1Iv$2(r3));
        this.w = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$rtChorusAvatar2Iv$2(r3));
        this.x = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$rtChorusJoinTv$2(r3));
        this.y = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$rtChorusArrowIv$2(r3));
        this.z = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$musicInfoLl$2(r3));
        this.A = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$wantListenContainer$2(r3));
        this.B = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$wantListenTv$2(r3));
        this.C = LazyKt.lazy(new KtvRoomSelectedMusicViewHolder$mvEntry$2(r3));
        this.D = r3.findViewById(2131381979);
        Lazy r4 = KtvCommonSettingHelper.a;
        this.G = KtvCommonSettingHelper.a(null);
        c4();
        return;
    L9:
        r2 = null;
        goto L10
    }

    public final void f4(boolean r2) {
        this.F = r2;
        if (r2 == false) goto L10;
        TextView r3 = V3();
        if (r3 == null) goto L7;
        r3.setText(s1.B(2131918426));
    L7:
        TextView r4 = V3();
        if (r4 == null) goto L17;
        r4.setBackground(s1.m(2131252427));
        return;
    L17:
        return;
    L10:
        TextView r5 = V3();
        if (r5 == null) goto L13;
        r5.setText(s1.B(2131918429));
    L13:
        TextView r6 = V3();
        if (r6 == null) goto L19;
        r6.setBackground(s1.m(2131252426));
        return;
    }

    public final void g4(boolean r2) {
        if (this.D.isShown() == true) goto L5;
        return;
    L5:
        if (this.D.isSelected() != r2) goto L9;
        this.D.setSelected(!r2);
        e4();
        return;
    }

    public final void U3(MusicPanel r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "music");
        String r2 = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        String r3 = r19.g();
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        HashMap r5 = r19.B;
        py.k r7 = null;
        if ((r5 instanceof HashMap) == true) goto L8;
        r5 = null;
    L8:
        int r6 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.a;
        Intrinsics.checkNotNullParameter(r3, "orderUid");
        Intrinsics.checkNotNullParameter(r2, "curUserId");
        ArrayList r8 = new ArrayList();
        if (r5 == null) goto L33;
        if (r5.containsKey(r3) != true) goto L17;
        if (r5.get(r3) == null) goto L17;
        Object r10 = r5.get(r3);
        Intrinsics.checkNotNull(r10);
        ListProtector.add(r8, 0, r10);
    L17:
        if (r5.containsKey(r2) == true) goto L19;
    L23:
        Iterator r9 = r5.entrySet().iterator();
    L25:
        if (r9.hasNext() == false) goto L33;
        Map.Entry r11 = (Map.Entry) r9.next();
        if (Intrinsics.areEqual((String) r11.getKey(), r3) == true) goto L25;
        if (Intrinsics.areEqual((String) r11.getKey(), r2) == true) goto L25;
        r8.add(r11.getValue());
        goto L25
    L19:
        if (r5.get(r2) == null) goto L23;
        if ((!Intrinsics.areEqual(r2, r3)) == false) goto L23;
        Object r12 = r5.get(r2);
        Intrinsics.checkNotNull(r12);
        ListProtector.add(r8, 1, r12);
    L33:
        if (MultiChorusContext.Companion.c() == true) goto L35;
    L37:
        boolean r13 = false;
    L38:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r14 = VideoChorusDataContext.Companion.a();
        if (r14 == null) goto L41;
        jd2.a r15 = r14.o();
    L42:
        if (r15 == null) goto L44;
        int r16 = r15.b;
    L45:
        ((HSImageView) this.l.getValue()).setVisibility(8);
        Y3().setVisibility(8);
        View r17 = (View) this.A.getValue();
        if (r17 == null) goto L48;
        UtilityKotlinExtentionsKt.t(r17);
    L48:
        MultiUserAvatarView r18 = (MultiUserAvatarView) this.n.getValue();
        if (r18 == null) goto L51;
        r18.setVisibility(8);
    L51:
        TextView r110 = (TextView) this.p.getValue();
        if (r110 == null) goto L54;
        r110.setVisibility(8);
    L54:
        RecyclerView r111 = (KtvCommonStackAvatarView) this.o.getValue();
        if (r111 == null) goto L57;
        r111.setVisibility(8);
    L57:
        if (r20 != 0) goto L78;
        if (r16 <= 1) goto L78;
        RecyclerView r21 = (KtvCommonStackAvatarView) this.o.getValue();
        if (r21 == null) goto L62;
        r21.setVisibility(0);
    L62:
        py.k r22 = qy.a.c();
        if (r15 == null) goto L66;
        Collection r23 = r15.c;
        if (r23 == null) goto L66;
    L67:
        List<? extends py.k> r112 = CollectionsKt.toMutableList(r23);
        r112.add(r22);
        KtvCommonStackAvatarView r113 = (KtvCommonStackAvatarView) this.o.getValue();
        if (r113 == null) goto L119;
        if (r15 == null) goto L72;
        String r24 = r15.a;
        if (r24 == null) goto L72;
    L73:
        String r114 = r24;
        if (r15 == null) goto L76;
        int r115 = r15.b;
    L77:
        r113.r(r112, r114, r115, r112.size(), "scene_video_chorus_ordered_list");
        goto L119
    L76:
        r115 = 0;
    L72:
        r24 = BDLocationException.ERROR_TIMEOUT;
    L119:
        if (KtvSettingHelper.t() == false) goto L199;
        KtvMusic r25 = r19.a;
        if (r25 == null) goto L123;
        List r26 = r25.getRecommendRealTimeChorusInfos();
    L125:
        if (Lists.notEmpty(r26) == false) goto L199;
        if (r13 == true) goto L199;
        View r27 = this.s;
        if (r27 == null) goto L130;
        UtilityKotlinExtentionsKt.w(r27);
    L130:
        String r28 = (String) KtvSettingHelper.h0.getValue();
        if (r28 == null) goto L141;
        String r29 = n.a(r28);
        if (r29 == null) goto L141;
        PipelineDraweeControllerBuilder r30 = Fresco.newDraweeControllerBuilder();
        HSImageView r31 = (HSImageView) this.t.getValue();
        if (r31 == null) goto L137;
        DraweeController r32 = r31.getController();
    L138:
        AbstractDraweeController r33 = r30.setOldController(r32).setUri(UriProtector.parse(r29)).setAutoPlayAnimations(true).setControllerListener(new e()).build();
        HSImageView r34 = (HSImageView) this.t.getValue();
        if (r34 == null) goto L141;
        r34.setController(r33);
        goto L141
    L137:
        r32 = null;
    L141:
        KtvMusic r1 = r19.a;
        if (r1 == null) goto L146;
        List r35 = r1.getRecommendRealTimeChorusInfos();
        if (r35 == null) goto L146;
        RecommendRealTimeChorusInfo r36 = (RecommendRealTimeChorusInfo) CollectionsKt.getOrNull(r35, 0);
    L147:
        if (r36 == null) goto L182;
        List r37 = r36.getShowUsers();
        if (r37 == null) goto L182;
        HSImageView r38 = (HSImageView) this.v.getValue();
        RecommendRealTimeChorusShowUser r39 = (RecommendRealTimeChorusShowUser) CollectionsKt.getOrNull(r37, 0);
        if (r39 == null) goto L153;
        py.k r40 = r39.getAvatarThumb();
    L154:
        if (r38 == null) goto L157;
        if (r40 == null) goto L157;
        ImageUtil.loadRoundImage(r38, r40);
    L157:
        HSImageView r41 = (HSImageView) this.w.getValue();
        RecommendRealTimeChorusShowUser r42 = (RecommendRealTimeChorusShowUser) CollectionsKt.getOrNull(r37, 1);
        if (r42 == null) goto L160;
        r7 = r42.getAvatarThumb();
    L160:
        if (r41 == null) goto L164;
        if (r7 == null) goto L164;
        ImageUtil.loadRoundImage(r41, r7);
    L164:
        if (r37.size() != 0) goto L166;
    L176:
        HSImageView r43 = (HSImageView) this.v.getValue();
        if (r43 == null) goto L179;
        r43.setVisibility(0);
    L179:
        HSImageView r44 = (HSImageView) this.w.getValue();
        if (r44 == null) goto L182;
        r44.setVisibility(8);
        goto L182
    L166:
        if (r37.size() == 1) goto L176;
        if (r37.size() != 2) goto L182;
        HSImageView r45 = (HSImageView) this.v.getValue();
        if (r45 == null) goto L173;
        r45.setVisibility(0);
    L173:
        HSImageView r46 = (HSImageView) this.w.getValue();
        if (r46 == null) goto L182;
        r46.setVisibility(0);
        goto L182
    L153:
        r40 = null;
    L182:
        TextView r47 = (TextView) this.x.getValue();
        if (r47 == null) goto L190;
        if (r36 == null) goto L188;
        String r48 = r36.getDesc();
        if (r48 == null) goto L188;
    L189:
        r47.setText(r48);
    L188:
        r48 = "";
    L190:
        View r49 = this.s;
        if (r36 == null) goto L196;
        String r50 = r36.getDesc();
        if (r50 == null) goto L196;
        r4 = r50;
    L196:
        r3.c(r49, r4, true);
        LinearLayout r51 = (LinearLayout) this.z.getValue();
        if (r51 == null) goto L213;
        r51.setDividerDrawable(s1.m(2131249594));
        return;
    L213:
        return;
    L146:
        r36 = null;
        goto L147
    L123:
        r26 = null;
    L199:
        View r52 = this.s;
        if (r52 == null) goto L202;
        UtilityKotlinExtentionsKt.t(r52);
    L202:
        LinearLayout r53 = (LinearLayout) this.z.getValue();
        if (r53 == null) goto L215;
        r53.setDividerDrawable(s1.m(2131249595));
        return;
    L215:
        return;
    L66:
        r23 = new ArrayList();
    L78:
        if (r13 == false) goto L93;
        MultiUserAvatarView r54 = (MultiUserAvatarView) this.n.getValue();
        if (r54 == null) goto L83;
        r54.setVisibility(0);
    L83:
        if (r8.size() <= 4) goto L90;
        TextView r55 = (TextView) this.p.getValue();
        if (r55 == null) goto L87;
        r55.setVisibility(0);
    L87:
        TextView r56 = (TextView) this.p.getValue();
        if (r56 == null) goto L90;
        r56.setText(s1.C(2131918436, new Object[]{Integer.valueOf(r8.size())}));
    L90:
        List<py.k> r57 = r8.subList(0, Math.min(4, r8.size()));
        MultiUserAvatarView r58 = (MultiUserAvatarView) this.n.getValue();
        if (r58 == null) goto L119;
        r58.a(r57, r8.size());
        goto L119
    L93:
        WantListenInfo r59 = r19.a.getWantListenInfo();
        if (r59 == null) goto L96;
        long r116 = r59.getWantListenCount().longValue();
    L98:
        if (r116 <= 0) goto L105;
        View r60 = (View) this.A.getValue();
        if (r60 == null) goto L102;
        UtilityKotlinExtentionsKt.w(r60);
    L102:
        TextView r61 = (TextView) this.B.getValue();
        if (r61 == null) goto L119;
        r61.setText(w.a(r19));
        goto L119
    L105:
        UtilityKotlinExtentionsKt.w((HSImageView) this.l.getValue());
        UtilityKotlinExtentionsKt.w(Y3());
        HSImageView r62 = (HSImageView) this.l.getValue();
        OrderInfo r63 = r19.a.getOrderInfo();
        if (r63 == null) goto L110;
        InteractiveSongUserInfo r64 = r63.getTopUser();
        if (r64 == null) goto L110;
        py.k r65 = r64.getAvatarThumbFlex();
    L111:
        a1.x(r62, r65, r62.getWidth(), r62.getHeight(), 2131251677);
        TextView r66 = Y3();
        OrderInfo r67 = r19.a.getOrderInfo();
        if (r67 == null) goto L116;
        InteractiveSongUserInfo r68 = r67.getTopUser();
        if (r68 == null) goto L116;
        String r69 = r68.getNickNameFlex();
    L117:
        r66.setText(r69);
    L116:
        r69 = null;
    L110:
        r65 = null;
        goto L111
    L96:
        r116 = 0;
        goto L98
    L44:
        r16 = 0;
        goto L45
    L41:
        r15 = null;
        goto L42
    L35:
        if (r8.size() <= 1) goto L37;
        r13 = true;
        goto L38
    }

    public final void T3(final MusicPanel r17, boolean r18, int r19, final wb0.a r20) {
        Intrinsics.checkNotNullParameter(r17, "music");
        Intrinsics.checkNotNullParameter(r20, "cb");
        this.E = r17;
        Intrinsics.checkNotNullParameter(r17, "music");
        Intrinsics.checkNotNullParameter(r20, "cb");
        String r4 = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        if (r17.D == false) goto L5;
    L13:
        this.F = true;
        TextView r5 = V3();
        if (r5 == null) goto L16;
        r5.setText(s1.B(2131918426));
    L16:
        TextView r6 = V3();
        if (r6 == null) goto L19;
        r6.setBackground(s1.m(2131252427));
    L19:
        TextView r7 = V3();
        if (r7 != null) goto L22;
    L37:
        ImageLoader.bindImage((HSImageView) this.h.getValue(), r17.a.getCoverUrl());
        String r8 = r17.a.getMTitle();
        String r9 = "";
        if (r8 != null) goto L40;
        r8 = "";
    L40:
        X3().setText(StringsKt.trimStart(r8).toString());
        String r10 = r17.a.getMAuthor();
        if (r10 == null) goto L44;
        r9 = r10;
    L44:
        TextView r11 = (TextView) this.k.getValue();
        if (r11 == null) goto L48;
        r11.setText(s1.C(2131918539, new Object[]{StringsKt.trimStart(r9).toString()}));
    L48:
        if (r17.a.getMDuration() <= 0) goto L56;
        TextView r12 = (TextView) this.j.getValue();
        if (r12 == null) goto L52;
        r12.setVisibility(0);
    L52:
        KtvMusic.a r13 = KtvMusic.Companion;
        KtvMusic r14 = r17.a;
        r13.getClass();
        long r15 = KtvMusic.a.a(r14);
        TextView r16 = (TextView) this.j.getValue();
        if (r16 == null) goto L55;
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        long r111 = 60;
        r16.setText(String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r15 / r111), Long.valueOf(r15 % r111)}, 2)));
    L55:
        KtvUtilsKt.M((TextView) this.j.getValue(), r15);
    L59:
        r3.n((HSImageView) this.l.getValue());
        U3(r17, r19);
        Ref.BooleanRef r21 = new Ref.BooleanRef();
        r21.element = false;
        if (r19 != 0) goto L65;
        if (r18 == true) goto L65;
        j.l.getClass();
        if (j.a() == true) goto L65;
        r17.b = 5;
        r21.element = true;
    L66:
        boolean r22 = r21.element;
        boolean r23 = KtvUtilsKt.j();
        boolean r112 = d4();
        getRemove().setVisibility(0);
        if (r22 == false) goto L84;
        Z3().setVisibility(4);
        b4().setVisibility(4);
        W3().setVisibility(8);
        a4().setController(Fresco.newDraweeControllerBuilder().setUri("asset://com.ss.android.ies.live.sdk/ttlive_ktv_singing.webp").setAutoPlayAnimations(true).build());
        a4().setVisibility(0);
        int r2 = KtvOrderSongThemeManager.a;
        KtvOrderSongThemeManager.c(getRemove(), KtvOrderSongThemeManager.n);
        this.D.setVisibility(0);
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L75;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r24 = r3.getKtvCoreViewModel();
        if (r24 == null) goto L75;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r25 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r24.getValue();
        if (r25 == null) goto L75;
        KtvRoomLyricsStateMachineConfig.d r26 = r25.getCurState();
    L76:
        View r113 = this.D;
        if ((r26 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L80;
    L82:
        boolean r27 = true;
    L83:
        r113.setSelected(r27);
        View r28 = this.D;
        Function1<View, Unit> r114 = new KtvRoomSelectedMusicViewHolder$updateState$1(this, r20, r17);
        Intrinsics.checkNotNullParameter(r114, "onClick");
        r28.setOnClickListener(new w0(r114, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION));
    L91:
        ViewGroup.LayoutParams r115 = null;
    L97:
        String r29 = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        if (r23 == true) goto L113;
        if (r112 == true) goto L113;
        b4().setVisibility(4);
        if (r17.a.isOrderedBy(r29.toString()) == false) goto L111;
        View r30 = getRemove();
        if (MultiChorusContext.Companion.c() == true) goto L105;
    L107:
        int r31 = 0;
    L108:
        r30.setVisibility(r31);
        if (r22 == false) goto L113;
        this.D.setVisibility(0);
        goto L113
    L105:
        if (jc0.a.c() == true) goto L107;
        r31 = 8;
        goto L108
    L111:
        getRemove().setVisibility(8);
        this.D.setVisibility(8);
    L113:
        if (getRemove().getVisibility() == 0) goto L115;
        TextView r32 = V3();
        if (r32 == null) goto L133;
        ViewGroup.LayoutParams r116 = r32.getLayoutParams();
    L134:
        if (r116 == null) goto L193;
        ConstraintLayout.LayoutParams r117 = (ConstraintLayout.LayoutParams) r116;
        ((ViewGroup.MarginLayoutParams) r117).rightMargin = s1.f(16.0f);
        TextView r33 = V3();
        if (r33 == null) goto L139;
        r33.setLayoutParams(r117);
    L139:
        if (this.D.getVisibility() != 0) goto L148;
        View r34 = this.D;
        if (r34 == null) goto L143;
        r115 = r34.getLayoutParams();
    L143:
        if (r115 == null) goto L146;
        ConstraintLayout.LayoutParams r118 = (ConstraintLayout.LayoutParams) r115;
        ((ViewGroup.MarginLayoutParams) r118).rightMargin = s1.f(80.0f);
        this.D.setLayoutParams(r118);
        goto L148
    L146:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L148:
        if (this.G == true) goto L150;
    L162:
        X3().setMaxWidth(s1.f(135.0f));
        if (b4().getVisibility() == 0) goto L172;
        if (this.D.getVisibility() == 0) goto L172;
        if (getRemove().getVisibility() != 0) goto L172;
        X3().setMaxWidth(s1.j(2131168839));
        TextView r35 = (TextView) this.k.getValue();
        if (r35 == null) goto L172;
        r35.setMaxWidth(s1.j(2131168837));
    L172:
        if (b4().getVisibility() == 0) goto L179;
        if (this.D.getVisibility() == 0) goto L179;
        if (getRemove().getVisibility() == 0) goto L179;
        X3().setMaxWidth(s1.j(2131168836));
    L179:
        if (W3().getVisibility() != 0) goto L182;
        X3().setMaxWidth(s1.j(2131168838));
    L182:
        if (V3().getVisibility() != 0) goto L184;
        X3().setMaxWidth(s1.f(110.0f));
    L184:
        X3().requestLayout();
        getRemove().setOnClickListener(new c(this, r21, r20, r17));
        final Ref.ObjectRef r36 = new Ref.ObjectRef();
        r36.element = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        TextView r37 = V3();
        if (r37 == null) goto L187;
        r37.setOnClickListener(new KtvRoomSelectedMusicViewHolder$bind$3(this, r17, r36, r20));
    L187:
        View r38 = this.s;
        if (r38 == null) goto L190;
        r38.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new KtvRoomSelectedMusicViewHolder$bind$4(r20, r17)));
    L190:
        r3.c(W3(), s1.B(2131918559), true);
        r3.c(getRemove(), s1.B(2131914425), true);
        r3.c(b4(), s1.B(2131918636), true);
        e4();
        return;
    L150:
        if (this.a == false) goto L162;
        if (this.b == true) goto L162;
        if (Intrinsics.areEqual(this.c, r17.g()) == false) goto L159;
        TextView r39 = (TextView) this.C.getValue();
        if (r39 == null) goto L158;
        r39.setVisibility(0);
    L158:
        ((TextView) this.C.getValue()).setOnClickListener(new b(r17));
        goto L162
    L159:
        TextView r40 = (TextView) this.C.getValue();
        if (r40 == null) goto L162;
        r40.setVisibility(8);
        goto L162
    L193:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L133:
        r116 = r115;
        goto L134
    L115:
        if (this.D.getVisibility() != 0) goto L117;
    L120:
        float r41 = 90.0f;
    L121:
        TextView r42 = V3();
        if (r42 == null) goto L124;
        r115 = r42.getLayoutParams();
    L124:
        if (r115 == null) goto L129;
        ConstraintLayout.LayoutParams r119 = (ConstraintLayout.LayoutParams) r115;
        ((ViewGroup.MarginLayoutParams) r119).rightMargin = s1.f(r41);
        TextView r43 = V3();
        if (r43 == null) goto L148;
        r43.setLayoutParams(r119);
        goto L148
    L129:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L117:
        if (b4().getVisibility() == 0) goto L120;
        r41 = 48.0f;
        goto L121
    L80:
        if ((r26 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L82;
        r27 = false;
    L75:
        r26 = null;
        goto L76
    L84:
        if (r18 == false) goto L92;
        this.D.setVisibility(8);
        Z3().setText(s1.B(2131918550));
        Z3().setVisibility(0);
        j r44 = j.l;
        TextView r120 = Z3();
        r44.getClass();
        j.h(r120);
        a4().setController(null);
        a4().setVisibility(4);
        int r45 = KtvOrderSongThemeManager.a;
        KtvOrderSongThemeManager.c(getRemove(), KtvOrderSongThemeManager.o);
        if (r23 == true) goto L90;
        if (r112 == true) goto L90;
        W3().setVisibility(8);
    L90:
        W3().setVisibility(0);
        com.bytedance.android.live.core.utils.a1.n(W3(), (int) t6.a(W3().getContext(), 17.0f));
        W3().setOnClickListener(new f(this, r20, r17));
        getRemove().setVisibility(8);
        b4().setVisibility(4);
        goto L91
    L92:
        Z3().setText(String.valueOf(r19 + 1));
        Z3().setVisibility(0);
        j r121 = j.l;
        TextView r122 = Z3();
        r121.getClass();
        j.h(r122);
        r115 = null;
        a4().setController(null);
        a4().setVisibility(4);
        this.D.setVisibility(8);
        W3().setVisibility(8);
        int r123 = KtvOrderSongThemeManager.a;
        KtvOrderSongThemeManager.c(getRemove(), KtvOrderSongThemeManager.o);
        if (r19 <= 1) goto L95;
        b4().setVisibility(0);
    L96:
        b4().setOnClickListener(new g(this, r19, r20, r17));
        goto L97
    L95:
        b4().setVisibility(4);
    L65:
        r21.element = false;
        goto L66
    L56:
        TextView r46 = (TextView) this.j.getValue();
        if (r46 == null) goto L59;
        r46.setVisibility(8);
        goto L59
    L22:
        if (jc0.a.c() == false) goto L24;
    L35:
        int r47 = 8;
    L36:
        r7.setVisibility(r47);
        goto L37
    L24:
        if (MultiChorusContext.Companion.c() == false) goto L35;
        if (ChorusContext.Companion.c() == true) goto L35;
        if (r17.a.isOrderedBy(r4.toString()) == true) goto L30;
    L34:
        r47 = 0;
        goto L36
    L30:
        if (d4() == true) goto L35;
        if (KtvUtilsKt.j() == false) goto L34;
    L5:
        if (r17.a.isOrderedBy(r4.toString()) == true) goto L13;
        this.F = false;
        TextView r48 = V3();
        if (r48 == null) goto L10;
        r48.setText(s1.B(2131918429));
    L10:
        TextView r49 = V3();
        if (r49 == null) goto L19;
        r49.setBackground(s1.m(2131252426));
        goto L19
    }
}
