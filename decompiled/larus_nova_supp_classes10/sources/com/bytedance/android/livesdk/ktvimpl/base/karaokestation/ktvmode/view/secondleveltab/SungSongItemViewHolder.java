package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
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
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.TriggerType;
import com.bytedance.android.livesdk.message.model.ChallengeInfo;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.PersonalSongInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusShowUser;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/SungSongItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/f;", "a", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SungSongItemViewHolder extends RecyclerView.ViewHolder implements f {
    public static final /* synthetic */ int z = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
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
    public MusicPanel o;
    public final b p;
    public final View q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final e y;

    public static final class a {
    }

    public final class b implements ic0.a {
        public final /* synthetic */ SungSongItemViewHolder a;

        public b(SungSongItemViewHolder r1) {
            this.a = r1;
        }

        public final void a(boolean r6) {
            SungSongItemViewHolder r0 = this.a;
            int r1 = SungSongItemViewHolder.z;
            r0.X3(r6);
            if (r6 == false) goto L5;
            int r2 = 2131918188;
        L6:
            f2.b(r2, 0);
            MusicPanel r3 = this.a.o;
            if (r3 == null) goto L11;
            KtvMusic r4 = r3.a;
            if (r4 == null) goto L11;
            r4.setFavorite(r6);
        L11:
            if (r6 == false) goto L20;
            SungSongItemViewHolder r7 = this.a;
            MusicPanel r5 = r7.o;
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

    static {
    }

    public final TextView T3() {
        return (TextView) this.l.getValue();
    }

    public final View U3() {
        return (View) this.h.getValue();
    }

    public final TextView V3() {
        return (TextView) this.i.getValue();
    }

    public final TextView W3() {
        return (TextView) this.k.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final Rect J3() {
        Rect r0 = new Rect();
        int[] r1 = new int[2];
        ((RecyclerView.ViewHolder) this).itemView.getLocationInWindow(r1);
        TextView r2 = V3();
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

    public final void X3(boolean r3) {
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

    public final void Y3(boolean r3) {
        if (r3 == false) goto L18;
        TextView r4 = V3();
        if (r4 == null) goto L6;
        r4.setClickable(false);
    L6:
        TextView r5 = V3();
        if (r5 == null) goto L9;
        KtvOrderSongThemeManager.c(r5, 102);
    L9:
        TextView r6 = V3();
        if (r6 == null) goto L12;
        r6.setText(s1.B(2131918626));
    L12:
        TextView r7 = V3();
        if (r7 == null) goto L15;
        r7.setTextColor(s1.h(2131107713));
    L15:
        TextView r8 = V3();
        if (r8 == null) goto L35;
        KtvOrderSongThemeManager.d(r8, 106);
        return;
    L35:
        return;
    L18:
        TextView r9 = V3();
        if (r9 == null) goto L21;
        r9.setClickable(true);
    L21:
        TextView r10 = V3();
        if (r10 == null) goto L24;
        r10.setBackgroundResource(2131249329);
    L24:
        String r11 = this.y.g();
        TextView r0 = V3();
        if (r0 != null) goto L27;
    L31:
        TextView r12 = V3();
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
        MusicPanel r0 = this.o;
        if (r0 == null) goto L30;
        KtvMusic r1 = r0.a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getMId() != r6.a.getMId()) goto L35;
        int r2 = r6.b;
        int r7 = r6.s;
        if (r2 != 1) goto L12;
        Y3(false);
        return;
    L12:
        if (r2 != 2) goto L14;
        TextView r3 = V3();
        if (r3 == null) goto L22;
        KtvOrderSongThemeManager.c(r3, 102);
    L22:
        TextView r4 = V3();
        if (r4 == null) goto L25;
        r4.setTextColor(s1.h(2131107713));
    L25:
        TextView r5 = V3();
        if (r5 == null) goto L33;
        r5.setText(s1.C(2131918371, new Object[]{Integer.valueOf(r7)}));
        return;
    L33:
        return;
    L14:
        if (r2 != 4) goto L16;
    L18:
        Y3(true);
        return;
    L16:
        if (r2 == 5) goto L18;
        return;
    L35:
        return;
    }

    public SungSongItemViewHolder(e r5, final View r6) {
        Intrinsics.checkNotNullParameter(r5, "songListViewCallback");
        Intrinsics.checkNotNullParameter(r6, "itemView");
        super(r6);
        this.y = r5;
        this.a = LazyKt.lazy(new SungSongItemViewHolder$contentContainer$2(r6));
        this.b = LazyKt.lazy(new SungSongItemViewHolder$mainContent$2(r6));
        this.c = LazyKt.lazy(new SungSongItemViewHolder$musicCover$2(r6));
        this.d = LazyKt.lazy(new SungSongItemViewHolder$musicDuration$2(r6));
        Lazy r7 = LazyKt.lazy(new SungSongItemViewHolder$musicName$2(r6));
        this.e = r7;
        this.f = LazyKt.lazy(new SungSongItemViewHolder$userAvatar$2(r6));
        Lazy r0 = LazyKt.lazy(new SungSongItemViewHolder$userName$2(r6));
        this.g = r0;
        this.h = LazyKt.lazy(new SungSongItemViewHolder$favoriteView$2(r6));
        this.i = LazyKt.lazy(new SungSongItemViewHolder$selectMusicBtn$2(r6));
        Lazy r1 = LazyKt.lazy(new SungSongItemViewHolder$footerView$2(r6));
        this.j = r1;
        this.k = LazyKt.lazy(new SungSongItemViewHolder$tvPos$2(r6));
        this.l = LazyKt.lazy(new SungSongItemViewHolder$challengeResultTv$2(r6));
        this.m = LazyKt.lazy(new SungSongItemViewHolder$musicScoreContainer$2(r6));
        this.n = LazyKt.lazy(new SungSongItemViewHolder$musicScore$2(r6));
        this.p = new b(this);
        View r2 = r6.findViewById(2131384878);
        this.q = r2;
        this.r = LazyKt.lazy(new SungSongItemViewHolder$rtChorusLiveIv$2(r6));
        this.s = LazyKt.lazy(new SungSongItemViewHolder$rtChorusAvatarFl$2(r6));
        this.t = LazyKt.lazy(new SungSongItemViewHolder$rtChorusAvatar1Iv$2(r6));
        this.u = LazyKt.lazy(new SungSongItemViewHolder$rtChorusAvatar2Iv$2(r6));
        this.v = LazyKt.lazy(new SungSongItemViewHolder$rtChorusJoinTv$2(r6));
        this.w = LazyKt.lazy(new SungSongItemViewHolder$rtChorusArrowIv$2(r6));
        this.x = LazyKt.lazy(new SungSongItemViewHolder$musicInfoLl$2(r6));
        TextView r8 = (TextView) r7.getValue();
        if (r8 == null) goto L5;
        KtvOrderSongThemeManager.d(r8, 10);
    L5:
        TextView r9 = (TextView) r0.getValue();
        if (r9 == null) goto L8;
        KtvOrderSongThemeManager.d(r9, 101);
    L8:
        TextView r10 = (TextView) r0.getValue();
        if (r10 == null) goto L11;
        r10.setMaxWidth(s1.f(78.0f));
    L11:
        TextView r11 = W3();
        if (r11 == null) goto L14;
        KtvOrderSongThemeManager.d(r11, KtvOrderSongThemeManager.a);
    L14:
        TextView r12 = (TextView) r1.getValue();
        if (r12 == null) goto L17;
        KtvOrderSongThemeManager.d(r12, KtvOrderSongThemeManager.k);
    L17:
        KtvUtilsKt.b((TextView) r7.getValue());
        View r13 = U3();
        if (r13 == null) goto L20;
        r13.setOnClickListener(new o(this));
    L20:
        TextView r14 = V3();
        if (r14 == null) goto L23;
        r14.setOnClickListener(x0.a(new SungSongItemViewHolder$bindClickListener$2(this)));
    L23:
        if (r2 == null) goto L26;
        r2.setOnClickListener(x0.a(new SungSongItemViewHolder$bindClickListener$3(this)));
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f
    public final void G1(MusicPanel r23, TriggerType r24) {
        Intrinsics.checkNotNullParameter(r24, LocationMonitorConst.TYPE);
        MusicPanel r2 = this.o;
        py.k r3 = null;
        if (r2 == null) goto L5;
        KtvMusic r4 = r2.a;
    L6:
        if (r23 == null) goto L8;
        KtvMusic r5 = r23.a;
    L9:
        boolean r6 = Intrinsics.areEqual(r4, r5);
        this.o = r23;
        boolean r7 = false;
        if (r6 == false) goto L12;
    L291:
        View r8 = U3();
        if (r8 == null) goto L294;
        r8.setVisibility(0);
    L294:
        if (r23 == null) goto L300;
        KtvMusic r9 = r23.a;
        if (r9 == null) goto L300;
        if (r9.isFavorite() != true) goto L300;
        r7 = true;
    L300:
        X3(r7);
        if (r23 == null) goto L305;
        v0(r23);
        return;
    L305:
        return;
    L12:
        if (r23 != null) goto L14;
    L27:
        View r10 = ((RecyclerView.ViewHolder) this).itemView;
        TextView r11 = W3();
        if (r11 == null) goto L30;
        r11.setVisibility(0);
    L30:
        com.bytedance.android.livesdk.ktvimpl.base.util.j r12 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        TextView r13 = W3();
        r12.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.j.h(r13);
        TextView r14 = (TextView) this.j.getValue();
        if (r14 == null) goto L33;
        r14.setVisibility(8);
    L33:
        ConstraintLayout r15 = (ConstraintLayout) this.a.getValue();
        if (r15 == null) goto L36;
        r15.setVisibility(0);
    L36:
        String r16 = "";
        if (r23 == null) goto L69;
        KtvMusic r17 = r23.a;
        if (r17 == null) goto L69;
        TextView r18 = (TextView) this.e.getValue();
        if (r18 == null) goto L48;
        String r19 = r17.getMTitle();
        if (r19 == null) goto L46;
        String r110 = StringsKt.trimStart(r19).toString();
        if (r110 == null) goto L46;
    L47:
        com.bytedance.android.live.ktv.common.util.a.f(r18, r110, this.y.b(), this.y.a());
    L46:
        r110 = "";
    L48:
        HSImageView r20 = (HSImageView) this.f.getValue();
        if (r20 == null) goto L57;
        OrderInfo r111 = r23.a.getOrderInfo();
        if (r111 == null) goto L55;
        InteractiveSongUserInfo r112 = r111.getTopUser();
        if (r112 == null) goto L55;
        py.k r113 = r112.getAvatarThumbFlex();
    L56:
        a1.x(r20, r113, r20.getWidth(), r20.getHeight(), 2131251677);
    L55:
        r113 = null;
    L57:
        TextView r21 = (TextView) this.g.getValue();
        if (r21 == null) goto L68;
        OrderInfo r114 = r17.getOrderInfo();
        if (r114 == null) goto L66;
        InteractiveSongUserInfo r115 = r114.getTopUser();
        if (r115 == null) goto L66;
        String r116 = r115.getNickNameFlex();
        if (r116 == null) goto L66;
    L67:
        r21.setText(r116);
    L66:
        r116 = "";
    L68:
        ImageLoader.bindImage((HSImageView) this.c.getValue(), r17.getCoverUrl(), s1.f(28.0f), s1.f(28.0f));
    L69:
        TextView r22 = W3();
        if (r22 == null) goto L72;
        r22.setText(String.valueOf(getLayoutPosition() + 1));
    L72:
        com.bytedance.android.livesdk.ktvimpl.base.util.j.h(W3());
        if (r23 == null) goto L79;
        KtvMusic r25 = r23.a;
        if (r25 == null) goto L79;
        PersonalSongInfo r26 = r25.getPersonalSongInfo();
        if (r26 == null) goto L79;
        double r27 = r26.getMidiScore();
    L81:
        if (r27 <= 0.0f) goto L122;
        TextView r117 = (TextView) this.e.getValue();
        if (r117 == null) goto L85;
        r117.setMaxWidth((int) s1.e(110.0f));
    L85:
        TextView r118 = (TextView) this.n.getValue();
        if (r118 == null) goto L88;
        StringBuilder r119 = new StringBuilder();
        DecimalFormat r120 = new DecimalFormat("0.#");
        r120.setRoundingMode(RoundingMode.FLOOR);
        r119.append(r120.format(r27));
        r119.append(20998);
        r118.setText(r119.toString());
    L88:
        if (r23 == null) goto L107;
        KtvMusic r28 = r23.a;
        if (r28 == null) goto L107;
        PersonalSongInfo r29 = r28.getPersonalSongInfo();
        if (r29 == null) goto L107;
        if (r29.isHighScoreSong().booleanValue() != true) goto L107;
        TextView r30 = (TextView) this.n.getValue();
        if (r30 == null) goto L104;
        TextPaint r31 = r30.getPaint();
        if (r31 == null) goto L104;
        TextView r121 = (TextView) this.n.getValue();
        if (r121 == null) goto L102;
        float r122 = r121.getWidth();
    L103:
        r31.setShader(new LinearGradient(0.0f, 0.0f, r122, 0.0f, ColorProtector.parseColor("#C956FF"), ColorProtector.parseColor("#6E56FF"), Shader.TileMode.CLAMP));
        goto L104
    L102:
        r122 = 0.0f;
    L104:
        View r32 = (View) this.m.getValue();
        if (r32 == null) goto L119;
        r32.setBackground(r10.getResources().getDrawable(2131249318));
    L119:
        View r33 = (View) this.m.getValue();
        if (r33 == null) goto L129;
        r33.setVisibility(0);
    L129:
        if (r23 == null) goto L133;
        KtvMusic r34 = r23.a;
        if (r34 == null) goto L133;
        long r123 = r34.getMDuration();
    L135:
        if (r123 <= 0) goto L146;
        TextView r35 = (TextView) this.d.getValue();
        if (r35 == null) goto L139;
        r35.setVisibility(0);
    L139:
        KtvMusic.a r36 = KtvMusic.Companion;
        if (r23 == null) goto L142;
        KtvMusic r37 = r23.a;
    L143:
        r36.getClass();
        long r38 = KtvMusic.a.a(r37);
        TextView r124 = (TextView) this.d.getValue();
        if (r124 == null) goto L149;
        StringCompanionObject r125 = StringCompanionObject.INSTANCE;
        long r126 = 60;
        r124.setText(String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r38 / r126), Long.valueOf(r38 % r126)}, 2)));
    L149:
        TextView r39 = T3();
        if (r39 == null) goto L152;
        r39.setVisibility(8);
    L152:
        if (r23 == null) goto L204;
        KtvMusic r40 = r23.a;
        if (r40 == null) goto L204;
        ChallengeInfo r41 = r40.getChallengeInfo();
        if (r41 == null) goto L204;
        r41.getScore();
        int r42 = r41.getKtvChallengeType();
        KtvChallengeType r127 = KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI;
        if (r42 == r127.getValue()) goto L204;
        TextView r43 = T3();
        if (r43 == null) goto L162;
        r43.setVisibility(0);
    L162:
        View r44 = (View) this.m.getValue();
        if (r44 == null) goto L166;
        r44.setVisibility(8);
    L166:
        if (r41.isSuccess() == false) goto L173;
        TextView r45 = T3();
        if (r45 == null) goto L170;
        r45.setBackgroundResource(2131249299);
    L170:
        TextView r46 = T3();
        if (r46 == null) goto L179;
        r46.setTextColor(ColorProtector.parseColor("#F40A7E"));
    L179:
        int r47 = r41.getKtvChallengeType();
        if (r47 != KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue()) goto L188;
        Drawable r48 = s1.m(2131252024);
        r48.setBounds(0, 0, UtilityKotlinExtentionsKt.i(12), UtilityKotlinExtentionsKt.i(12));
        TextView r128 = T3();
        if (r128 == null) goto L184;
        r128.setCompoundDrawables(r48, null, null, null);
    L184:
        TextView r49 = T3();
        if (r49 == null) goto L204;
        r49.setText(String.valueOf((int) r41.getScore()));
        goto L204
    L188:
        if (r47 != r127.getValue()) goto L196;
        TextView r50 = T3();
        if (r50 == null) goto L192;
        r50.setCompoundDrawables(null, null, null, null);
    L192:
        TextView r51 = T3();
        if (r51 == null) goto L204;
        StringBuilder r129 = new StringBuilder();
        r129.append(r41.getScore());
        r129.append(20998);
        r51.setText(r129.toString());
        goto L204
    L196:
        if (r47 != KtvChallengeType.KTV_CHALLENGE_TYPE_LIKE.getValue()) goto L204;
        TextView r52 = T3();
        if (r52 == null) goto L200;
        r52.setCompoundDrawables(null, null, null, null);
    L200:
        TextView r53 = T3();
        if (r53 == null) goto L204;
        r53.setText("点赞" + ((int) r41.getScore()));
        goto L204
    L173:
        TextView r54 = T3();
        if (r54 == null) goto L176;
        r54.setBackgroundResource(2131249298);
    L176:
        TextView r55 = T3();
        if (r55 == null) goto L179;
        r55.setTextColor(ColorProtector.parseColor("#6A6A6A"));
    L204:
        if (KtvSettingHelper.t() == false) goto L285;
        if (r23 == null) goto L209;
        KtvMusic r56 = r23.a;
        if (r56 == null) goto L209;
        List r57 = r56.getRecommendRealTimeChorusInfos();
    L211:
        if (Lists.notEmpty(r57) == false) goto L285;
        View r58 = this.q;
        if (r58 == null) goto L215;
        UtilityKotlinExtentionsKt.w(r58);
    L215:
        String r59 = (String) KtvSettingHelper.h0.getValue();
        if (r59 == null) goto L226;
        String r60 = com.bytedance.android.live.ktv.common.util.n.a(r59);
        if (r60 == null) goto L226;
        PipelineDraweeControllerBuilder r61 = Fresco.newDraweeControllerBuilder();
        HSImageView r130 = (HSImageView) this.r.getValue();
        if (r130 == null) goto L222;
        DraweeController r131 = r130.getController();
    L223:
        AbstractDraweeController r62 = r61.setOldController(r131).setUri(UriProtector.parse(r60)).setAutoPlayAnimations(true).setControllerListener(new p()).build();
        HSImageView r63 = (HSImageView) this.r.getValue();
        if (r63 == null) goto L226;
        r63.setController(r62);
        goto L226
    L222:
        r131 = null;
    L226:
        if (r23 == null) goto L232;
        KtvMusic r64 = r23.a;
        if (r64 == null) goto L232;
        List r65 = r64.getRecommendRealTimeChorusInfos();
        if (r65 == null) goto L232;
        RecommendRealTimeChorusInfo r66 = (RecommendRealTimeChorusInfo) CollectionsKt.getOrNull(r65, 0);
    L233:
        if (r66 == null) goto L268;
        List r67 = r66.getShowUsers();
        if (r67 == null) goto L268;
        HSImageView r132 = (HSImageView) this.t.getValue();
        RecommendRealTimeChorusShowUser r133 = (RecommendRealTimeChorusShowUser) CollectionsKt.getOrNull(r67, 0);
        if (r133 == null) goto L239;
        py.k r134 = r133.getAvatarThumb();
    L240:
        if (r132 == null) goto L243;
        if (r134 == null) goto L243;
        ImageUtil.loadRoundImage(r132, r134);
    L243:
        HSImageView r135 = (HSImageView) this.u.getValue();
        RecommendRealTimeChorusShowUser r136 = (RecommendRealTimeChorusShowUser) CollectionsKt.getOrNull(r67, 1);
        if (r136 == null) goto L246;
        r3 = r136.getAvatarThumb();
    L246:
        if (r135 == null) goto L250;
        if (r3 == null) goto L250;
        ImageUtil.loadRoundImage(r135, r3);
    L250:
        if (r67.size() != 0) goto L252;
    L262:
        HSImageView r68 = (HSImageView) this.t.getValue();
        if (r68 == null) goto L265;
        r68.setVisibility(0);
    L265:
        HSImageView r69 = (HSImageView) this.u.getValue();
        if (r69 == null) goto L268;
        r69.setVisibility(8);
        goto L268
    L252:
        if (r67.size() == 1) goto L262;
        if (r67.size() != 2) goto L268;
        HSImageView r70 = (HSImageView) this.t.getValue();
        if (r70 == null) goto L259;
        r70.setVisibility(0);
    L259:
        HSImageView r71 = (HSImageView) this.u.getValue();
        if (r71 == null) goto L268;
        r71.setVisibility(0);
        goto L268
    L239:
        r134 = null;
    L268:
        TextView r72 = (TextView) this.v.getValue();
        if (r72 == null) goto L276;
        if (r66 == null) goto L274;
        String r73 = r66.getDesc();
        if (r73 == null) goto L274;
    L275:
        r72.setText(r73);
    L274:
        r73 = "";
    L276:
        View r74 = this.q;
        if (r66 == null) goto L282;
        String r75 = r66.getDesc();
        if (r75 == null) goto L282;
        r16 = r75;
    L282:
        r3.c(r74, r16, true);
        LinearLayout r76 = (LinearLayout) this.x.getValue();
        if (r76 == null) goto L291;
        r76.setDividerDrawable(s1.m(2131249594));
    L232:
        r66 = null;
    L209:
        r57 = null;
    L285:
        View r77 = this.q;
        if (r77 == null) goto L288;
        UtilityKotlinExtentionsKt.t(r77);
    L288:
        LinearLayout r78 = (LinearLayout) this.x.getValue();
        if (r78 == null) goto L291;
        r78.setDividerDrawable(s1.m(2131249595));
        goto L291
    L142:
        r37 = null;
        goto L143
    L146:
        TextView r79 = (TextView) this.d.getValue();
        if (r79 == null) goto L149;
        r79.setVisibility(8);
    L133:
        r123 = 0;
    L107:
        TextView r80 = (TextView) this.n.getValue();
        if (r80 == null) goto L116;
        TextPaint r81 = r80.getPaint();
        if (r81 == null) goto L116;
        TextView r137 = (TextView) this.n.getValue();
        if (r137 == null) goto L114;
        float r138 = r137.getWidth();
    L115:
        r81.setShader(new LinearGradient(0.0f, 0.0f, r138, 0.0f, ColorProtector.parseColor("#161823"), ColorProtector.parseColor("#161823"), Shader.TileMode.CLAMP));
        goto L116
    L114:
        r138 = 0.0f;
    L116:
        View r82 = (View) this.m.getValue();
        if (r82 == null) goto L119;
        r82.setBackground(r10.getResources().getDrawable(2131249327));
        goto L119
    L122:
        TextView r83 = (TextView) this.e.getValue();
        if (r83 == null) goto L125;
        r83.setMaxWidth((int) s1.e(140.0f));
    L125:
        View r85 = (View) this.m.getValue();
        if (r85 == null) goto L129;
        r85.setVisibility(8);
    L79:
        r27 = 0.0d;
        goto L81
    L14:
        if (r23.u != true) goto L27;
        TextView r1 = W3();
        if (r1 == null) goto L19;
        r1.setVisibility(8);
    L19:
        if (this.y.e() == true) goto L23;
        TextView r86 = (TextView) this.j.getValue();
        if (r86 == null) goto L23;
        r86.setVisibility(0);
    L23:
        ConstraintLayout r87 = (ConstraintLayout) this.a.getValue();
        if (r87 == null) goto L304;
        r87.setVisibility(8);
        return;
    L304:
        return;
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }
}
