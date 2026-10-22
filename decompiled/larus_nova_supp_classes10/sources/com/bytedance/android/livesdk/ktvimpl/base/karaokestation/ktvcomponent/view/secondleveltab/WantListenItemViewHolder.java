package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvMusicTagsView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.n;
import com.bytedance.android.live.ktv.common.util.w;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusShowUser;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/view/secondleveltab/WantListenItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/f;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class WantListenItemViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f {
    public static final /* synthetic */ int z = 0;
    public MusicPanel a;
    public final View b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final View j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final a x;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e y;

    public static final class a implements ic0.a {
        public final /* synthetic */ WantListenItemViewHolder a;

        public a(WantListenItemViewHolder r1) {
            this.a = r1;
        }

        public final void a(boolean r6) {
            WantListenItemViewHolder r0 = this.a;
            int r1 = WantListenItemViewHolder.z;
            r0.W3(r6);
            if (r6 == false) goto L5;
            int r2 = 2131918188;
        L6:
            f2.b(r2, 0);
            MusicPanel r3 = this.a.a;
            if (r3 == null) goto L11;
            KtvMusic r4 = r3.a;
            if (r4 == null) goto L11;
            r4.setFavorite(r6);
        L11:
            if (r6 == false) goto L20;
            WantListenItemViewHolder r7 = this.a;
            MusicPanel r5 = r7.a;
            if (r5 == null) goto L21;
            Rect r8 = new Rect();
            int[] r9 = new int[2];
            ((RecyclerView.ViewHolder) r7).itemView.getLocationInWindow(r9);
            View r10 = r7.U3();
            if (r10 == null) goto L17;
            r8.left = r9[0] + ((int) r10.getX());
            r8.top = r9[1] + ((int) r10.getY());
            r8.right = r8.left + r10.getWidth();
            r8.bottom = r8.top + r10.getHeight();
        L18:
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r5.v = r8;
            return;
        L17:
            r8.left = -1;
            r8.top = -1;
            r8.right = -1;
            r8.bottom = -1;
            goto L18
        L21:
            return;
        L20:
            return;
        L5:
            r2 = 2131918360;
            goto L6
        }
    }

    public final View U3() {
        return (View) this.v.getValue();
    }

    public final TextView V3() {
        return (TextView) this.w.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final Rect J3() {
        return new Rect(-1, -1, -1, -1);
    }

    public final void T3(MusicPanel r6) {
        if (r6 == null) goto L9;
        KtvMusic r2 = r6.a;
        if (r2 == null) goto L9;
        WantListenInfo r3 = r2.getWantListenInfo();
        if (r3 == null) goto L9;
        long r4 = r3.getWantListenCount().longValue();
    L11:
        if (r4 <= 0) goto L21;
        View r0 = this.j;
        if (r0 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r0);
    L15:
        KtvMusicTagsView r1 = (KtvMusicTagsView) this.s.getValue();
        if (r1 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r1);
    L18:
        TextView r5 = (TextView) this.l.getValue();
        if (r5 == null) goto L25;
        r5.setText(w.a(r6));
        return;
    L25:
        return;
    L21:
        View r7 = this.j;
        if (r7 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r7);
        return;
    L27:
        return;
    L9:
        r4 = 0;
        goto L11
    }

    public final void W3(boolean r3) {
        KtvUtilsKt.L(U3(), r3);
        View r0 = U3();
        if (r0 == null) goto L8;
        if (r3 == false) goto L6;
        int r1 = 2131252151;
    L7:
        r0.setBackgroundResource(r1);
        goto L8
    L6:
        r1 = KtvOrderSongThemeManager.a(103);
    L8:
        View r2 = U3();
        if (r2 == null) goto L15;
        if (r3 == false) goto L12;
        float r4 = 1.0f;
    L13:
        r2.setAlpha(r4);
        return;
    L12:
        r4 = 0.6f;
        goto L13
    }

    public final void X3(boolean r3) {
        if (r3 == false) goto L15;
        TextView r4 = V3();
        if (r4 == null) goto L6;
        KtvOrderSongThemeManager.c(r4, 102);
    L6:
        TextView r5 = V3();
        if (r5 == null) goto L9;
        r5.setText(s1.B(2131918626));
    L9:
        TextView r6 = V3();
        if (r6 == null) goto L12;
        r6.setTextColor(s1.h(2131107713));
    L12:
        TextView r7 = V3();
        if (r7 == null) goto L29;
        KtvOrderSongThemeManager.d(r7, 106);
        return;
    L29:
        return;
    L15:
        TextView r8 = V3();
        if (r8 == null) goto L18;
        r8.setBackgroundResource(2131249329);
    L18:
        String r9 = this.y.g();
        TextView r0 = V3();
        if (r0 != null) goto L21;
    L25:
        TextView r10 = V3();
        if (r10 == null) goto L31;
        r10.setTextColor(s1.h(2131107712));
        return;
    L31:
        return;
    L21:
        if (TextUtils.isEmpty(r9) == false) goto L24;
        r9 = s1.B(2131918625);
    L24:
        r0.setText(r9);
        goto L25
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final void v0(MusicPanel r5) {
        Intrinsics.checkNotNullParameter(r5, "music");
        MusicPanel r0 = this.a;
        if (r0 == null) goto L14;
        KtvMusic r1 = r0.a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getMId() == r5.a.getMId()) goto L10;
        return;
    L10:
        if (this.y.d(this.a) == false) goto L12;
        X3(false);
        return;
    L12:
        X3(true);
        return;
    }

    public WantListenItemViewHolder(final View r7, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.e r8) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        Intrinsics.checkNotNullParameter(r8, "songListViewCallback");
        super(r7);
        this.y = r8;
        View r9 = r7.findViewById(2131384878);
        this.b = r9;
        this.c = LazyKt.lazy(new WantListenItemViewHolder$rtChorusLiveIv$2(r7));
        this.d = LazyKt.lazy(new WantListenItemViewHolder$rtChorusAvatarFl$2(r7));
        this.e = LazyKt.lazy(new WantListenItemViewHolder$rtChorusAvatar1Iv$2(r7));
        this.f = LazyKt.lazy(new WantListenItemViewHolder$rtChorusAvatar2Iv$2(r7));
        this.g = LazyKt.lazy(new WantListenItemViewHolder$rtChorusJoinTv$2(r7));
        this.h = LazyKt.lazy(new WantListenItemViewHolder$rtChorusArrowIv$2(r7));
        this.i = LazyKt.lazy(new WantListenItemViewHolder$musicInfoLl$2(r7));
        this.j = r7.findViewById(2131392998);
        this.k = LazyKt.lazy(new WantListenItemViewHolder$wantListenIv$2(r7));
        this.l = LazyKt.lazy(new WantListenItemViewHolder$wantListenTv$2(r7));
        this.m = LazyKt.lazy(new WantListenItemViewHolder$musicCover$2(r7));
        this.n = LazyKt.lazy(new WantListenItemViewHolder$musicDuration$2(r7));
        Lazy r0 = LazyKt.lazy(new WantListenItemViewHolder$musicName$2(r7));
        this.o = r0;
        Lazy r1 = LazyKt.lazy(new WantListenItemViewHolder$musicScoreContainer$2(r7));
        this.p = r1;
        this.q = LazyKt.lazy(new WantListenItemViewHolder$musicScore$2(r7));
        Lazy r2 = LazyKt.lazy(new WantListenItemViewHolder$musicAuthor$2(r7));
        this.r = r2;
        Lazy r3 = LazyKt.lazy(new WantListenItemViewHolder$musicTags$2(r7));
        this.s = r3;
        Lazy r4 = LazyKt.lazy(new WantListenItemViewHolder$footerView$2(r7));
        this.t = r4;
        this.u = LazyKt.lazy(new WantListenItemViewHolder$contentContainer$2(r7));
        this.v = LazyKt.lazy(new WantListenItemViewHolder$favoriteView$2(r7));
        this.w = LazyKt.lazy(new WantListenItemViewHolder$selectMusicBtn$2(r7));
        TextView r10 = (TextView) r0.getValue();
        if (r10 == null) goto L5;
        KtvOrderSongThemeManager.d(r10, 10);
    L5:
        TextView r11 = (TextView) r2.getValue();
        if (r11 == null) goto L8;
        KtvOrderSongThemeManager.d(r11, 101);
    L8:
        TextView r12 = (TextView) r4.getValue();
        if (r12 == null) goto L11;
        KtvOrderSongThemeManager.d(r12, KtvOrderSongThemeManager.k);
    L11:
        KtvUtilsKt.b((TextView) r0.getValue());
        KtvUtilsKt.b((TextView) r2.getValue());
        LinearLayout r13 = (LinearLayout) r1.getValue();
        if (r13 == null) goto L14;
        r13.setVisibility(8);
    L14:
        KtvMusicTagsView r14 = (KtvMusicTagsView) r3.getValue();
        if (r14 == null) goto L17;
        r14.setVisibility(8);
    L17:
        View r15 = U3();
        if (r15 == null) goto L20;
        r15.setOnClickListener(new g(this));
    L20:
        TextView r16 = V3();
        if (r16 == null) goto L23;
        r16.setOnClickListener(x0.a(new WantListenItemViewHolder$bindClickListener$2(this)));
    L23:
        if (r9 == null) goto L25;
        r9.setOnClickListener(x0.a(new WantListenItemViewHolder$bindClickListener$3(this)));
    L25:
        this.x = new a(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final void G1(MusicPanel r18, TriggerType r19) {
        Intrinsics.checkNotNullParameter(r19, LocationMonitorConst.TYPE);
        MusicPanel r3 = this.a;
        py.k r4 = null;
        if (r3 == null) goto L5;
        KtvMusic r5 = r3.a;
    L6:
        if (r18 == null) goto L8;
        KtvMusic r6 = r18.a;
    L9:
        boolean r7 = Intrinsics.areEqual(r5, r6);
        this.a = r18;
        boolean r8 = false;
        String r9 = "";
        if (r7 == true) goto L83;
        if (r18 != null) goto L13;
    L23:
        TextView r10 = (TextView) this.t.getValue();
        if (r10 == null) goto L26;
        r10.setVisibility(8);
    L26:
        ConstraintLayout r11 = (ConstraintLayout) this.u.getValue();
        if (r11 == null) goto L29;
        r11.setVisibility(0);
    L29:
        TextView r12 = (TextView) this.o.getValue();
        if (r12 == null) goto L40;
        if (r18 == null) goto L38;
        KtvMusic r13 = r18.a;
        if (r13 == null) goto L38;
        String r14 = r13.getMTitle();
        if (r14 == null) goto L38;
        String r15 = StringsKt.trimStart(r14).toString();
        if (r15 == null) goto L38;
    L39:
        com.bytedance.android.live.ktv.common.util.a.f(r12, r15, this.y.b(), this.y.a());
    L38:
        r15 = "";
    L40:
        TextView r16 = (TextView) this.r.getValue();
        if (r16 == null) goto L52;
        if (r18 == null) goto L50;
        KtvMusic r17 = r18.a;
        if (r17 == null) goto L50;
        String r110 = r17.getMAuthor();
        if (r110 == null) goto L50;
        String r111 = StringsKt.trimStart(r110).toString();
        if (r111 == null) goto L50;
    L51:
        r16.setText(r111);
    L50:
        r111 = "";
    L52:
        TextView r20 = (TextView) this.r.getValue();
        if (r20 == null) goto L55;
        r20.setVisibility(0);
    L55:
        HSImageView r21 = (HSImageView) this.m.getValue();
        if (r18 == null) goto L60;
        KtvMusic r112 = r18.a;
        if (r112 == null) goto L60;
        String r113 = r112.getCoverUrl();
    L61:
        ImageLoader.bindImage(r21, r113, s1.f(28.0f), s1.f(28.0f));
        if (r18 == null) goto L66;
        KtvMusic r22 = r18.a;
        if (r22 == null) goto L66;
        long r114 = r22.getMDuration();
    L68:
        if (r114 <= 0) goto L79;
        TextView r23 = (TextView) this.n.getValue();
        if (r23 == null) goto L72;
        r23.setVisibility(0);
    L72:
        KtvMusic.a r24 = KtvMusic.Companion;
        if (r18 == null) goto L75;
        KtvMusic r115 = r18.a;
    L76:
        r24.getClass();
        long r116 = KtvMusic.a.a(r115);
        TextView r25 = (TextView) this.n.getValue();
        if (r25 == null) goto L83;
        StringCompanionObject r117 = StringCompanionObject.INSTANCE;
        long r118 = 60;
        r25.setText(String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r116 / r118), Long.valueOf(r116 % r118)}, 2)));
        goto L83
    L75:
        r115 = null;
        goto L76
    L79:
        TextView r26 = (TextView) this.n.getValue();
        if (r26 == null) goto L83;
        r26.setVisibility(8);
    L66:
        r114 = 0;
    L60:
        r113 = null;
        goto L61
    L13:
        if (r18.u != true) goto L23;
        if (this.y.e() == true) goto L19;
        TextView r1 = (TextView) this.t.getValue();
        if (r1 == null) goto L19;
        r1.setVisibility(0);
    L19:
        ConstraintLayout r2 = (ConstraintLayout) this.u.getValue();
        if (r2 == null) goto L195;
        r2.setVisibility(8);
        return;
    L195:
        return;
    L83:
        if (r19 == TriggerType.Manual) goto L85;
    L93:
        T3(r18);
    L95:
        if (KtvSettingHelper.t() == false) goto L176;
        if (r18 == null) goto L100;
        KtvMusic r27 = r18.a;
        if (r27 == null) goto L100;
        List r28 = r27.getRecommendRealTimeChorusInfos();
    L102:
        if (Lists.notEmpty(r28) == false) goto L176;
        View r29 = this.b;
        if (r29 == null) goto L106;
        UtilityKotlinExtentionsKt.w(r29);
    L106:
        String r30 = (String) KtvSettingHelper.h0.getValue();
        if (r30 == null) goto L117;
        String r31 = n.a(r30);
        if (r31 == null) goto L117;
        PipelineDraweeControllerBuilder r32 = Fresco.newDraweeControllerBuilder();
        HSImageView r119 = (HSImageView) this.c.getValue();
        if (r119 == null) goto L113;
        DraweeController r120 = r119.getController();
    L114:
        AbstractDraweeController r33 = r32.setOldController(r120).setUri(UriProtector.parse(r31)).setAutoPlayAnimations(true).setControllerListener(new h()).build();
        HSImageView r34 = (HSImageView) this.c.getValue();
        if (r34 == null) goto L117;
        r34.setController(r33);
        goto L117
    L113:
        r120 = null;
    L117:
        if (r18 == null) goto L123;
        KtvMusic r35 = r18.a;
        if (r35 == null) goto L123;
        List r36 = r35.getRecommendRealTimeChorusInfos();
        if (r36 == null) goto L123;
        RecommendRealTimeChorusInfo r37 = (RecommendRealTimeChorusInfo) CollectionsKt.getOrNull(r36, 0);
    L124:
        if (r37 == null) goto L159;
        List r38 = r37.getShowUsers();
        if (r38 == null) goto L159;
        HSImageView r121 = (HSImageView) this.e.getValue();
        RecommendRealTimeChorusShowUser r122 = (RecommendRealTimeChorusShowUser) CollectionsKt.getOrNull(r38, 0);
        if (r122 == null) goto L130;
        py.k r123 = r122.getAvatarThumb();
    L131:
        if (r121 == null) goto L134;
        if (r123 == null) goto L134;
        ImageUtil.loadRoundImage(r121, r123);
    L134:
        HSImageView r124 = (HSImageView) this.f.getValue();
        RecommendRealTimeChorusShowUser r125 = (RecommendRealTimeChorusShowUser) CollectionsKt.getOrNull(r38, 1);
        if (r125 == null) goto L137;
        r4 = r125.getAvatarThumb();
    L137:
        if (r124 == null) goto L141;
        if (r4 == null) goto L141;
        ImageUtil.loadRoundImage(r124, r4);
    L141:
        if (r38.size() != 0) goto L143;
    L153:
        HSImageView r39 = (HSImageView) this.e.getValue();
        if (r39 == null) goto L156;
        r39.setVisibility(0);
    L156:
        HSImageView r40 = (HSImageView) this.f.getValue();
        if (r40 == null) goto L159;
        r40.setVisibility(8);
        goto L159
    L143:
        if (r38.size() == 1) goto L153;
        if (r38.size() != 2) goto L159;
        HSImageView r41 = (HSImageView) this.e.getValue();
        if (r41 == null) goto L150;
        r41.setVisibility(0);
    L150:
        HSImageView r42 = (HSImageView) this.f.getValue();
        if (r42 == null) goto L159;
        r42.setVisibility(0);
        goto L159
    L130:
        r123 = null;
    L159:
        TextView r43 = (TextView) this.g.getValue();
        if (r43 == null) goto L167;
        if (r37 == null) goto L165;
        String r44 = r37.getDesc();
        if (r44 == null) goto L165;
    L166:
        r43.setText(r44);
    L165:
        r44 = "";
    L167:
        View r45 = this.b;
        if (r37 == null) goto L173;
        String r46 = r37.getDesc();
        if (r46 == null) goto L173;
        r9 = r46;
    L173:
        r3.c(r45, r9, true);
        LinearLayout r47 = (LinearLayout) this.i.getValue();
        if (r47 == null) goto L182;
        r47.setDividerDrawable(s1.m(2131249594));
    L182:
        View r48 = U3();
        if (r48 == null) goto L185;
        r48.setVisibility(0);
    L185:
        if (r18 == null) goto L191;
        KtvMusic r49 = r18.a;
        if (r49 == null) goto L191;
        if (r49.isFavorite() != true) goto L191;
        r8 = true;
    L191:
        W3(r8);
        if (r18 == null) goto L196;
        v0(r18);
        return;
    L196:
        return;
    L123:
        r37 = null;
    L100:
        r28 = null;
    L176:
        View r50 = this.b;
        if (r50 == null) goto L179;
        UtilityKotlinExtentionsKt.t(r50);
    L179:
        LinearLayout r51 = (LinearLayout) this.i.getValue();
        if (r51 == null) goto L182;
        r51.setDividerDrawable(s1.m(2131249595));
        goto L182
    L85:
        if (this.y.d(r18) == true) goto L93;
        MusicPanel r52 = this.a;
        if (r52 == null) goto L92;
        KtvMusic r53 = r52.a;
        WantListenInfo r54 = r53.getWantListenInfo();
        if (r54 != null) goto L91;
        r54 = new WantListenInfo();
    L91:
        r54.setWantListenCount(r54.getWantListenCount().longValue() + 1);
        Unit r126 = Unit.INSTANCE;
        r53.setWantListenInfo(r54);
    L92:
        T3(r18);
        goto L95
    L8:
        r6 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }
}
