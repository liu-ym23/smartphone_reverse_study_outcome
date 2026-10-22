package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
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
import com.bytedance.android.live.ktv.common.util.w;
import com.bytedance.android.livesdk.config.d50;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.TriggerType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.PersonalSongInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusShowUser;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/SongListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/f;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SongListItemViewHolder extends RecyclerView.ViewHolder implements f {
    public static final /* synthetic */ int B = 0;
    public final e A;
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
    public final d50 m;
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
    public final Lazy x;
    public final Lazy y;
    public final a z;

    public final class a implements ic0.a {
        public final /* synthetic */ SongListItemViewHolder a;

        public a(SongListItemViewHolder r1) {
            this.a = r1;
        }

        public final void a(boolean r6) {
            SongListItemViewHolder r0 = this.a;
            int r1 = SongListItemViewHolder.B;
            r0.Y3(r6);
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
            SongListItemViewHolder r7 = this.a;
            MusicPanel r5 = r7.a;
            if (r5 == null) goto L21;
            Rect r8 = new Rect();
            int[] r9 = new int[2];
            ((RecyclerView.ViewHolder) r7).itemView.getLocationInWindow(r9);
            View r10 = r7.T3();
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

    public final View T3() {
        return (View) this.x.getValue();
    }

    public final TextView U3() {
        return (TextView) this.q.getValue();
    }

    public final TextView V3() {
        return (TextView) this.s.getValue();
    }

    public final TextView W3() {
        return (TextView) this.y.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final Rect J3() {
        Rect r0 = new Rect();
        int[] r1 = new int[2];
        ((RecyclerView.ViewHolder) this).itemView.getLocationInWindow(r1);
        TextView r2 = W3();
        if (r2 == null) goto L5;
        r0.left = r1[0] + ((int) r2.getX());
        r0.top = r1[1] + ((int) r2.getY());
        r0.right = r0.left + r2.getWidth();
        r0.bottom = r0.top + r2.getHeight();
    L6:
        return r0;
    L5:
        r0.left = -1;
        r0.top = -1;
        r0.right = -1;
        r0.bottom = -1;
        goto L6
    }

    public final void X3() {
        StringBuilder r0 = new StringBuilder("trySelectSong:");
        MusicPanel r1 = this.a;
        if (r1 == null) goto L7;
        KtvMusic r2 = r1.a;
        if (r2 == null) goto L7;
        String r3 = r2.getMTitle();
    L8:
        r0.append(r3);
        r0.append('-');
        MusicPanel r4 = this.a;
        if (r4 == null) goto L13;
        KtvMusic r5 = r4.a;
        if (r5 == null) goto L13;
        Object r6 = Long.valueOf(r5.getMId());
    L14:
        r0.append(r6);
        String r7 = r0.toString();
        ALogger.i(bb0.b.b(), r7 + ", invoke class :SongListItemViewHolder");
        if (this.A.d(this.a) == false) goto L20;
        Context r8 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        MusicPanel r9 = this.a;
        if (r8 == null) goto L28;
        if (r9 == null) goto L29;
        this.A.h(r8, r9, this);
        return;
    L29:
        return;
    L28:
        return;
    L20:
        MusicPanel r10 = this.a;
        if (r10 == null) goto L25;
        KtvMusic r11 = r10.a;
        if (r11 == null) goto L25;
        long r12 = r11.getMId();
    L26:
        com.bytedance.android.live.ktv.common.util.i.a(r12, -1);
        return;
    L25:
        r12 = 0;
    L13:
        r6 = "null";
    L7:
        r3 = null;
        goto L8
    }

    public final void Y3(boolean r3) {
        KtvUtilsKt.L(T3(), r3);
        View r0 = T3();
        if (r0 == null) goto L8;
        if (r3 == false) goto L6;
        int r1 = 2131252151;
    L7:
        r0.setBackgroundResource(r1);
        goto L8
    L6:
        r1 = KtvOrderSongThemeManager.a(103);
    L8:
        View r2 = T3();
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

    public final void Z3(boolean r3) {
        if (r3 == false) goto L18;
        TextView r4 = W3();
        if (r4 == null) goto L6;
        r4.setClickable(false);
    L6:
        TextView r5 = W3();
        if (r5 == null) goto L9;
        KtvOrderSongThemeManager.c(r5, 102);
    L9:
        TextView r6 = W3();
        if (r6 == null) goto L12;
        r6.setText(s1.B(2131918626));
    L12:
        TextView r7 = W3();
        if (r7 == null) goto L15;
        r7.setTextColor(s1.h(2131107713));
    L15:
        TextView r8 = W3();
        if (r8 == null) goto L35;
        KtvOrderSongThemeManager.d(r8, 106);
        return;
    L35:
        return;
    L18:
        TextView r9 = W3();
        if (r9 == null) goto L21;
        r9.setClickable(true);
    L21:
        TextView r10 = W3();
        if (r10 == null) goto L24;
        r10.setBackgroundResource(2131249329);
    L24:
        String r11 = this.A.g();
        TextView r0 = W3();
        if (r0 != null) goto L27;
    L31:
        TextView r12 = W3();
        if (r12 == null) goto L37;
        r12.setTextColor(s1.h(2131107712));
        return;
    L37:
        return;
    L27:
        if (TextUtils.isEmpty(r11) == false) goto L30;
        r11 = s1.B(2131918625);
    L30:
        r0.setText(r11);
        goto L31
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final void v0(MusicPanel r6) {
        Intrinsics.checkNotNullParameter(r6, "music");
        MusicPanel r0 = this.a;
        if (r0 == null) goto L30;
        KtvMusic r1 = r0.a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getMId() != r6.a.getMId()) goto L35;
        int r2 = r6.b;
        int r7 = r6.s;
        if (r2 != 1) goto L12;
        Z3(false);
        return;
    L12:
        if (r2 != 2) goto L14;
        TextView r3 = W3();
        if (r3 == null) goto L22;
        KtvOrderSongThemeManager.c(r3, 102);
    L22:
        TextView r4 = W3();
        if (r4 == null) goto L25;
        r4.setTextColor(s1.h(2131107713));
    L25:
        TextView r5 = W3();
        if (r5 == null) goto L33;
        r5.setText(s1.C(2131918371, new Object[]{Integer.valueOf(r7)}));
        return;
    L33:
        return;
    L14:
        if (r2 != 4) goto L16;
    L18:
        Z3(true);
        return;
    L16:
        if (r2 == 5) goto L18;
        return;
    L35:
        return;
    }

    public SongListItemViewHolder(final View r5, e r6) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        Intrinsics.checkNotNullParameter(r6, "songListViewCallback");
        super(r5);
        this.A = r6;
        View r7 = r5.findViewById(2131384878);
        this.b = r7;
        this.c = LazyKt.lazy(new SongListItemViewHolder$rtChorusLiveIv$2(r5));
        this.d = LazyKt.lazy(new SongListItemViewHolder$rtChorusAvatarFl$2(r5));
        this.e = LazyKt.lazy(new SongListItemViewHolder$rtChorusAvatar1Iv$2(r5));
        this.f = LazyKt.lazy(new SongListItemViewHolder$rtChorusAvatar2Iv$2(r5));
        this.g = LazyKt.lazy(new SongListItemViewHolder$rtChorusJoinTv$2(r5));
        this.h = LazyKt.lazy(new SongListItemViewHolder$rtChorusArrowIv$2(r5));
        this.i = LazyKt.lazy(new SongListItemViewHolder$musicInfoLl$2(r5));
        this.j = r5.findViewById(2131392998);
        this.k = LazyKt.lazy(new SongListItemViewHolder$wantListenIv$2(r5));
        this.l = LazyKt.lazy(new SongListItemViewHolder$wantListenTv$2(r5));
        this.m = d50.a;
        this.n = LazyKt.lazy(new SongListItemViewHolder$musicCover$2(r5));
        this.o = LazyKt.lazy(new SongListItemViewHolder$musicAudition$2(r5));
        this.p = LazyKt.lazy(new SongListItemViewHolder$musicDuration$2(r5));
        this.q = LazyKt.lazy(new SongListItemViewHolder$musicName$2(r5));
        this.r = LazyKt.lazy(new SongListItemViewHolder$musicScoreContainer$2(r5));
        this.s = LazyKt.lazy(new SongListItemViewHolder$musicScore$2(r5));
        Lazy r0 = LazyKt.lazy(new SongListItemViewHolder$musicAuthor$2(r5));
        this.t = r0;
        this.u = LazyKt.lazy(new SongListItemViewHolder$musicTags$2(r5));
        Lazy r1 = LazyKt.lazy(new SongListItemViewHolder$footerView$2(r5));
        this.v = r1;
        Lazy r2 = LazyKt.lazy(new SongListItemViewHolder$contentContainer$2(r5));
        this.w = r2;
        this.x = LazyKt.lazy(new SongListItemViewHolder$favoriteView$2(r5));
        this.y = LazyKt.lazy(new SongListItemViewHolder$selectMusicBtn$2(r5));
        TextView r8 = U3();
        if (r8 == null) goto L5;
        KtvOrderSongThemeManager.d(r8, 10);
    L5:
        TextView r9 = (TextView) r0.getValue();
        if (r9 == null) goto L8;
        KtvOrderSongThemeManager.d(r9, 101);
    L8:
        TextView r10 = V3();
        if (r10 == null) goto L11;
        KtvOrderSongThemeManager.d(r10, 101);
    L11:
        TextView r11 = (TextView) r1.getValue();
        if (r11 == null) goto L14;
        KtvOrderSongThemeManager.d(r11, KtvOrderSongThemeManager.k);
    L14:
        KtvUtilsKt.b(U3());
        KtvUtilsKt.b((TextView) r0.getValue());
        ConstraintLayout r12 = (ConstraintLayout) r2.getValue();
        if (r12 == null) goto L17;
        r12.setOnClickListener(new l(this));
    L17:
        View r13 = T3();
        if (r13 == null) goto L20;
        r13.setOnClickListener(x0.a(new SongListItemViewHolder$bindClickListener$2(this)));
    L20:
        TextView r14 = W3();
        if (r14 == null) goto L23;
        r14.setOnClickListener(x0.a(new SongListItemViewHolder$bindClickListener$3(this)));
    L23:
        if (r7 == null) goto L25;
        r7.setOnClickListener(x0.a(new SongListItemViewHolder$bindClickListener$4(this)));
    L25:
        this.z = new a(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final void G1(MusicPanel r21, TriggerType r22) {
        Intrinsics.checkNotNullParameter(r22, LocationMonitorConst.TYPE);
        MusicPanel r2 = this.a;
        if (r2 == null) goto L5;
        KtvMusic r3 = r2.a;
    L6:
        if (r21 == null) goto L8;
        KtvMusic r4 = r21.a;
    L9:
        boolean r5 = Intrinsics.areEqual(r3, r4);
        this.a = r21;
        boolean r6 = false;
        String r7 = "";
        if (r5 == true) goto L149;
        if (r21 != null) goto L13;
    L23:
        TextView r8 = (TextView) this.v.getValue();
        if (r8 == null) goto L26;
        r8.setVisibility(8);
    L26:
        ConstraintLayout r9 = (ConstraintLayout) this.w.getValue();
        if (r9 == null) goto L29;
        r9.setVisibility(0);
    L29:
        float r10 = 0.0f;
        if (r21 == null) goto L36;
        KtvMusic r11 = r21.a;
        if (r11 == null) goto L36;
        PersonalSongInfo r12 = r11.getPersonalSongInfo();
        if (r12 == null) goto L36;
        float r13 = (float) r12.getMidiScore();
    L38:
        if (r13 <= 0.0f) goto L80;
        TextView r14 = U3();
        if (r14 == null) goto L42;
        r14.setMaxWidth((int) s1.e(120.0f));
    L42:
        TextView r15 = V3();
        if (r15 == null) goto L46;
        StringBuilder r16 = new StringBuilder();
        DecimalFormat r17 = new DecimalFormat("0.#");
        r17.setRoundingMode(RoundingMode.FLOOR);
        r16.append(r17.format(Float.valueOf(r13)));
        r16.append(20998);
        r15.setText(r16.toString());
    L46:
        if (((Boolean) this.m.getValue()).booleanValue() == false) goto L65;
        if (r21 == null) goto L65;
        KtvMusic r18 = r21.a;
        if (r18 == null) goto L65;
        PersonalSongInfo r19 = r18.getPersonalSongInfo();
        if (r19 == null) goto L65;
        if (r19.isHighScoreSong().booleanValue() != true) goto L65;
        TextView r110 = V3();
        if (r110 == null) goto L62;
        TextPaint r111 = r110.getPaint();
        if (r111 == null) goto L62;
        TextView r112 = V3();
        if (r112 == null) goto L61;
        r10 = r112.getWidth();
    L61:
        r111.setShader(new LinearGradient(0.0f, 0.0f, r10, 0.0f, ColorProtector.parseColor("#C956FF"), ColorProtector.parseColor("#6E56FF"), Shader.TileMode.CLAMP));
    L62:
        LinearLayout r20 = (LinearLayout) this.r.getValue();
        if (r20 == null) goto L77;
        r20.setBackground(s1.m(2131249318));
    L77:
        LinearLayout r23 = (LinearLayout) this.r.getValue();
        if (r23 == null) goto L86;
        r23.setVisibility(0);
    L86:
        TextView r24 = U3();
        if (r24 == null) goto L97;
        if (r21 == null) goto L95;
        KtvMusic r25 = r21.a;
        if (r25 == null) goto L95;
        String r26 = r25.getMTitle();
        if (r26 == null) goto L95;
        String r27 = StringsKt.trimStart(r26).toString();
        if (r27 == null) goto L95;
    L96:
        r3.c(U3(), r27, false);
        Unit r28 = Unit.INSTANCE;
        com.bytedance.android.live.ktv.common.util.a.f(r24, r27, this.A.b(), this.A.a());
    L95:
        r27 = "";
    L97:
        TextView r29 = (TextView) this.t.getValue();
        if (r29 == null) goto L108;
        if (r21 == null) goto L106;
        KtvMusic r30 = r21.a;
        if (r30 == null) goto L106;
        String r31 = r30.getMAuthor();
        if (r31 == null) goto L106;
        String r32 = StringsKt.trimStart(r31).toString();
        if (r32 == null) goto L106;
    L107:
        r3.c((TextView) this.t.getValue(), r32, false);
        Unit r33 = Unit.INSTANCE;
        r29.setText(r32);
    L106:
        r32 = "";
    L108:
        TextView r34 = (TextView) this.t.getValue();
        if (r34 == null) goto L111;
        r34.setVisibility(0);
    L111:
        HSImageView r35 = (HSImageView) this.n.getValue();
        if (r21 == null) goto L116;
        KtvMusic r36 = r21.a;
        if (r36 == null) goto L116;
        String r37 = r36.getCoverUrl();
    L117:
        ImageLoader.bindImage(r35, r37, s1.f(28.0f), s1.f(28.0f));
        List r38 = com.bytedance.android.live.ktv.common.util.a.d(r21);
        if ((!r38.isEmpty()) == false) goto L125;
        KtvMusicTagsView r39 = (KtvMusicTagsView) this.u.getValue();
        if (r39 == null) goto L122;
        r39.setVisibility(0);
    L122:
        KtvMusicTagsView r40 = (KtvMusicTagsView) this.u.getValue();
        if (r40 == null) goto L128;
        int r41 = KtvMusicTagsView.a;
        r40.a(r38, false);
    L128:
        if (r21 == null) goto L132;
        KtvMusic r42 = r21.a;
        if (r42 == null) goto L132;
        long r43 = r42.getMDuration();
    L134:
        if (r43 <= 0) goto L146;
        TextView r44 = (TextView) this.p.getValue();
        if (r44 == null) goto L138;
        r44.setVisibility(0);
    L138:
        KtvMusic.a r45 = KtvMusic.Companion;
        if (r21 == null) goto L141;
        KtvMusic r46 = r21.a;
    L142:
        r45.getClass();
        long r47 = KtvMusic.a.a(r46);
        TextView r48 = (TextView) this.p.getValue();
        if (r48 == null) goto L145;
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        long r114 = 60;
        r48.setText(String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r47 / r114), Long.valueOf(r47 % r114)}, 2)));
    L145:
        KtvUtilsKt.M((TextView) this.p.getValue(), r47);
        goto L149
    L141:
        r46 = null;
        goto L142
    L146:
        TextView r49 = (TextView) this.p.getValue();
        if (r49 == null) goto L149;
        r49.setVisibility(8);
    L132:
        r43 = 0;
        goto L134
    L125:
        KtvMusicTagsView r50 = (KtvMusicTagsView) this.u.getValue();
        if (r50 == null) goto L128;
        r50.setVisibility(8);
    L116:
        r37 = null;
    L65:
        TextView r51 = V3();
        if (r51 == null) goto L74;
        TextPaint r52 = r51.getPaint();
        if (r52 == null) goto L74;
        TextView r115 = V3();
        if (r115 == null) goto L72;
        float r116 = r115.getWidth();
    L73:
        r52.setShader(new LinearGradient(0.0f, 0.0f, r116, 0.0f, ColorProtector.parseColor("#161823"), ColorProtector.parseColor("#161823"), Shader.TileMode.CLAMP));
        goto L74
    L72:
        r116 = 0.0f;
    L74:
        LinearLayout r53 = (LinearLayout) this.r.getValue();
        if (r53 == null) goto L77;
        r53.setBackground(s1.m(2131249327));
        goto L77
    L80:
        TextView r54 = U3();
        if (r54 == null) goto L83;
        r54.setMaxWidth((int) s1.e(150.0f));
    L83:
        LinearLayout r55 = (LinearLayout) this.r.getValue();
        if (r55 == null) goto L86;
        r55.setVisibility(8);
    L36:
        r13 = 0.0f;
        goto L38
    L13:
        if (r21.u != true) goto L23;
        if (this.A.e() == true) goto L19;
        TextView r1 = (TextView) this.v.getValue();
        if (r1 == null) goto L19;
        r1.setVisibility(0);
    L19:
        ConstraintLayout r56 = (ConstraintLayout) this.w.getValue();
        if (r56 == null) goto L292;
        r56.setVisibility(8);
        return;
    L292:
        return;
    L149:
        if (r21 == null) goto L155;
        KtvMusic r57 = r21.a;
        if (r57 == null) goto L155;
        WantListenInfo r58 = r57.getWantListenInfo();
        if (r58 == null) goto L155;
        long r59 = r58.getWantListenCount().longValue();
    L157:
        if (r59 <= 0) goto L167;
        View r60 = this.j;
        if (r60 == null) goto L161;
        UtilityKotlinExtentionsKt.w(r60);
    L161:
        KtvMusicTagsView r61 = (KtvMusicTagsView) this.u.getValue();
        if (r61 == null) goto L164;
        UtilityKotlinExtentionsKt.t(r61);
    L164:
        TextView r62 = (TextView) this.l.getValue();
        if (r62 == null) goto L170;
        r62.setText(w.a(r21));
    L170:
        if (r21 == null) goto L186;
        int r63 = r21.k;
        if (r63 != 200) goto L174;
        HSImageView r64 = (HSImageView) this.o.getValue();
        if (r64 == null) goto L185;
        r64.setVisibility(0);
    L185:
        ImageUtil.loadImage((HSImageView) this.o.getValue(), 2131251264, ImageView.ScaleType.CENTER_INSIDE);
        goto L186
    L174:
        if (r63 == 300) goto L178;
        HSImageView r65 = (HSImageView) this.o.getValue();
        if (r65 == null) goto L186;
        r65.setVisibility(8);
        goto L186
    L178:
        HSImageView r66 = (HSImageView) this.o.getValue();
        if (r66 == null) goto L181;
        r66.setVisibility(0);
    L181:
        ImageUtil.loadImage((HSImageView) this.o.getValue(), 2131251263, ImageView.ScaleType.CENTER_INSIDE);
    L186:
        View r67 = T3();
        if (r67 == null) goto L194;
        if (this.A.f() == false) goto L191;
        int r68 = 0;
    L192:
        r67.setVisibility(r68);
        goto L194
    L191:
        r68 = 8;
    L194:
        if (KtvSettingHelper.t() == false) goto L276;
        if (r21 == null) goto L199;
        KtvMusic r69 = r21.a;
        if (r69 == null) goto L199;
        List r70 = r69.getRecommendRealTimeChorusInfos();
    L201:
        if (Lists.notEmpty(r70) == false) goto L276;
        View r71 = this.b;
        if (r71 == null) goto L205;
        UtilityKotlinExtentionsKt.w(r71);
    L205:
        String r72 = (String) KtvSettingHelper.h0.getValue();
        if (r72 == null) goto L216;
        String r73 = com.bytedance.android.live.ktv.common.util.n.a(r72);
        if (r73 == null) goto L216;
        PipelineDraweeControllerBuilder r74 = Fresco.newDraweeControllerBuilder();
        HSImageView r75 = (HSImageView) this.c.getValue();
        if (r75 == null) goto L212;
        DraweeController r76 = r75.getController();
    L213:
        AbstractDraweeController r77 = r74.setOldController(r76).setUri(UriProtector.parse(r73)).setAutoPlayAnimations(true).setControllerListener(new m()).build();
        HSImageView r78 = (HSImageView) this.c.getValue();
        if (r78 == null) goto L216;
        r78.setController(r77);
        goto L216
    L212:
        r76 = null;
    L216:
        if (r21 == null) goto L222;
        KtvMusic r79 = r21.a;
        if (r79 == null) goto L222;
        List r80 = r79.getRecommendRealTimeChorusInfos();
        if (r80 == null) goto L222;
        RecommendRealTimeChorusInfo r81 = (RecommendRealTimeChorusInfo) CollectionsKt.getOrNull(r80, 0);
    L223:
        if (r81 == null) goto L259;
        List r82 = r81.getShowUsers();
        if (r82 == null) goto L259;
        HSImageView r83 = (HSImageView) this.e.getValue();
        RecommendRealTimeChorusShowUser r85 = (RecommendRealTimeChorusShowUser) CollectionsKt.getOrNull(r82, 0);
        if (r85 == null) goto L229;
        py.k r86 = r85.getAvatarThumb();
    L230:
        if (r83 == null) goto L233;
        if (r86 == null) goto L233;
        ImageUtil.loadRoundImage(r83, r86);
    L233:
        HSImageView r87 = (HSImageView) this.f.getValue();
        RecommendRealTimeChorusShowUser r88 = (RecommendRealTimeChorusShowUser) CollectionsKt.getOrNull(r82, 1);
        if (r88 == null) goto L236;
        py.k r89 = r88.getAvatarThumb();
    L237:
        if (r87 == null) goto L241;
        if (r89 == null) goto L241;
        ImageUtil.loadRoundImage(r87, r89);
    L241:
        if (r82.size() != 0) goto L243;
    L253:
        HSImageView r90 = (HSImageView) this.e.getValue();
        if (r90 == null) goto L256;
        r90.setVisibility(0);
    L256:
        HSImageView r91 = (HSImageView) this.f.getValue();
        if (r91 == null) goto L259;
        r91.setVisibility(8);
        goto L259
    L243:
        if (r82.size() == 1) goto L253;
        if (r82.size() != 2) goto L259;
        HSImageView r92 = (HSImageView) this.e.getValue();
        if (r92 == null) goto L250;
        r92.setVisibility(0);
    L250:
        HSImageView r93 = (HSImageView) this.f.getValue();
        if (r93 == null) goto L259;
        r93.setVisibility(0);
        goto L259
    L236:
        r89 = null;
        goto L237
    L229:
        r86 = null;
    L259:
        TextView r94 = (TextView) this.g.getValue();
        if (r94 == null) goto L267;
        if (r81 == null) goto L265;
        String r95 = r81.getDesc();
        if (r95 == null) goto L265;
    L266:
        r94.setText(r95);
    L265:
        r95 = "";
    L267:
        View r96 = this.b;
        if (r81 == null) goto L273;
        String r97 = r81.getDesc();
        if (r97 == null) goto L273;
        r7 = r97;
    L273:
        r3.c(r96, r7, true);
        LinearLayout r98 = (LinearLayout) this.i.getValue();
        if (r98 == null) goto L282;
        r98.setDividerDrawable(s1.m(2131249594));
    L282:
        if (r21 == null) goto L288;
        KtvMusic r99 = r21.a;
        if (r99 == null) goto L288;
        if (r99.isFavorite() != true) goto L288;
        r6 = true;
    L288:
        Y3(r6);
        if (r21 == null) goto L293;
        v0(r21);
        return;
    L293:
        return;
    L222:
        r81 = null;
    L199:
        r70 = null;
    L276:
        View r100 = this.b;
        if (r100 == null) goto L279;
        UtilityKotlinExtentionsKt.t(r100);
    L279:
        LinearLayout r101 = (LinearLayout) this.i.getValue();
        if (r101 == null) goto L282;
        r101.setDividerDrawable(s1.m(2131249595));
        goto L282
    L167:
        View r102 = this.j;
        if (r102 == null) goto L170;
        UtilityKotlinExtentionsKt.t(r102);
    L155:
        r59 = 0;
        goto L157
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }
}
