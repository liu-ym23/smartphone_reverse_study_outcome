package com.larus.bmhome.chat.mode;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.auth.ConversationMode;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.lynx.textra.PlatformFontCaps;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class l0 extends FrameLayout {
    public int A;
    public int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<String, Boolean, Unit> f307396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Float, Unit> f307397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f307398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f307399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f307400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f307401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f307402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f307403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f307404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Typeface f307405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Typeface f307406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<ConversationMode> f307407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<TextView> f307408m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<SimpleDraweeView> f307409n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f307410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f307411p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f307412q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f307413r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f307414s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f307415t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f307416u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f307417v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ValueAnimator f307418w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f307419x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f307420y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArgbEvaluator f307421z;

    public static final class a {
    }

    static {
    }

    public final float e() {
        return RangesKt.coerceAtLeast(this.f307407l.size() - 1, 0);
    }

    public final void a() {
        this.A = i(R.attr.larus_neutral_100, R.color.larus_neutral_100);
        this.B = i(R.attr.larus_neutral_70, R.color.larus_neutral_70);
        View r100 = this.f307401f;
        float[] r101 = new float[8];
        int r102 = 0;
    L3:
        if (r102 >= 8) goto L5;
        r101[r102] = c(100, 1.0f);
        r102 = r102 + 1;
        goto L3
    L5:
        com.larus.common_ui.venus.a.C4189a r103 = new com.larus.common_ui.venus.a.C4189a(r101, i(R.attr.larus_base_3, R.color.larus_base_3), this.f307399d, Color.argb((int) (255 * 0.04f), Color.red(-16777216), Color.green(-16777216), Color.blue(-16777216)), MediaPlayer.MEDIA_PLAYER_OPTION_TO_DECODE_FIRST_VIDEO_FRAME_TIME);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "params");
        Drawable r104 = r100.getBackground();
        if (r104 != null) goto L8;
    L21:
        com.larus.common_ui.venus.b.a(r100, r103);
        return;
    L8:
        if ((r104 instanceof LayerDrawable) == false) goto L21;
        Drawable r105 = ((LayerDrawable) r104).getDrawable(0);     // Catch: Throwable -> L20
        com.larus.common_ui.venus.a.C4189a r106 = null;
        if ((r105 instanceof com.larus.common_ui.venus.a) == false) goto L13;
        com.larus.common_ui.venus.a r107 = (com.larus.common_ui.venus.a) r105;     // Catch: Throwable -> L20
    L14:
        if (r107 == null) goto L17;
        r106 = r107.f327952a;     // Catch: Throwable -> L20
    L17:
        if (Intrinsics.areEqual(r106, r103) == true) goto L26;
        com.larus.common_ui.venus.b.a(r100, r103);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L13:
        r107 = null;
    L20:
        com.larus.common_ui.venus.b.a(r100, r103);
    }

    public final View getContentView() {
        return this.f307400e;
    }

    public final Function1<Float, Unit> getOnSlidePositionChanged() {
        return this.f307397b;
    }

    public final float d(float r100) {
        float r101 = RangesKt.coerceIn(r100, 0.0f, e());
        int r102 = (int) r101;
        int r103 = RangesKt.coerceAtMost(r102 + 1, (int) e());
        float r104 = r101 - r102;
        View r105 = this.f307404i.getChildAt(r102);
        View r106 = this.f307404i.getChildAt(r103);
        int r107 = c(120, this.f307398c);
        int r108 = 0;
        if (r105 == null) goto L5;
        int r109 = r105.getWidth();
    L6:
        if (r109 <= 0) goto L8;
        int r110 = (this.f307404i.getLeft() + r105.getLeft()) - this.f307399d;
    L9:
        if (r106 == null) goto L11;
        r108 = r106.getWidth();
    L11:
        if (r108 <= 0) goto L13;
        int r111 = (this.f307404i.getLeft() + r106.getLeft()) - this.f307399d;
    L15:
        return r110 + ((r111 - r110) * r104);
    L13:
        r111 = r103 * r107;
        goto L15
    L8:
        r110 = r102 * r107;
        goto L9
    L5:
        r109 = 0;
        goto L6
    }

    public final int h(float r100) {
        float r101 = RangesKt.coerceIn(r100, 0.0f, e());
        int r102 = (int) r101;
        int r103 = RangesKt.coerceAtMost(r102 + 1, (int) e());
        int r104 = c(120, this.f307398c);
        View r105 = this.f307404i.getChildAt(r102);
        Integer r106 = null;
        boolean r107 = false;
        if (r105 == null) goto L13;
        Integer r108 = Integer.valueOf(r105.getWidth());
        if (r108.intValue() <= 0) goto L7;
        boolean r109 = true;
    L8:
        if (r109 == true) goto L11;
        r108 = null;
    L11:
        if (r108 == null) goto L13;
        int r110 = r108.intValue();
    L14:
        View r111 = this.f307404i.getChildAt(r103);
        if (r111 == null) goto L24;
        Integer r112 = Integer.valueOf(r111.getWidth());
        if (r112.intValue() <= 0) goto L19;
        r107 = true;
    L19:
        if (r107 == false) goto L21;
        r106 = r112;
    L21:
        if (r106 == null) goto L24;
        r104 = r106.intValue();
    L24:
        return (int) ((r110 + ((r104 - r110) * (r101 - r102))) + 0.5f);
    L7:
        r109 = false;
    L13:
        r110 = r104;
        goto L14
    }

    public final void j(float r100) {
        Iterator<Integer> r101 = CollectionsKt.getIndices(this.f307407l).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        int r102 = ((IntIterator) r101).nextInt();
        Object r103 = this.f307421z.evaluate(RangesKt.coerceIn(1.0f - Math.abs(r102 - r100), 0.0f, 1.0f), Integer.valueOf(this.B), Integer.valueOf(this.A));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Int");
        int r104 = ((Integer) r103).intValue();
        TextView r105 = (TextView) CollectionsKt.getOrNull(this.f307408m, r102);
        if (r105 == null) goto L8;
        r105.setTextColor(r104);
    L8:
        SimpleDraweeView r106 = (SimpleDraweeView) CollectionsKt.getOrNull(this.f307409n, r102);
        if (r106 == null) goto L4;
        GenericDraweeHierarchy r107 = r106.getHierarchy();
        if (r107 == null) goto L4;
        r107.setActualImageColorFilter(new PorterDuffColorFilter(r104, PorterDuff.Mode.SRC_IN));
        goto L4
    }

    public final void k(float r100) {
        int r101 = Math.round(r100);
        if (r101 != this.f307412q) goto L5;
        return;
    L5:
        this.f307412q = r101;
        Iterator<Integer> r102 = CollectionsKt.getIndices(this.f307407l).iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        int r103 = ((IntIterator) r102).nextInt();
        if (r103 != r101) goto L11;
        boolean r104 = true;
    L12:
        TextView r105 = (TextView) ListProtector.get(this.f307408m, r103);
        if (r104 == false) goto L15;
        Typeface r106 = this.f307405j;
    L16:
        r105.setTypeface(r106);
        goto L7
    L15:
        r106 = this.f307406k;
        goto L16
    L11:
        r104 = false;
        goto L12
    }

    public final void setOnSlidePositionChanged(Function1<? super Float, Unit> r100) {
        this.f307397b = r100;
    }

    public final void setSelectedKey(String r100) {
        Iterator<ConversationMode> r101 = this.f307407l.iterator();
        boolean r102 = false;
        int r103 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r101.next().a(), r100) == true) goto L10;
        r103 = r103 + 1;
    L10:
        Integer r104 = Integer.valueOf(r103);
        if (r104.intValue() < 0) goto L13;
        r102 = true;
    L13:
        if (r102 == true) goto L16;
        r104 = null;
    L16:
        if (r104 == null) goto L24;
        int r105 = r104.intValue();
        this.f307411p = r105;
        float r106 = r105;
        k(r106);
        j(r106);
        TextView r107 = this.f307403h;
        String r108 = ((ConversationMode) ListProtector.get(this.f307407l, r105)).g();
        if (r108 != null) goto L20;
        r108 = "";
    L20:
        r107.setText(r108);
        return;
    L24:
        return;
    L9:
        r103 = -1;
        goto L10
    }

    public l0(Context r100, l r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "onModeSelected");
        super(r100);
        this.f307396a = r110;
        Integer r111 = Integer.valueOf(getResources().getConfiguration().screenWidthDp);
        if (r111.intValue() <= 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r111 = null;
    L10:
        if (r111 == null) goto L12;
        int r112 = r111.intValue();
    L13:
        float r113 = RangesKt.coerceAtMost(r112 / 390.0f, 1.0f);
        this.f307398c = r113;
        this.f307399d = c(3, r113);
        LayoutInflater.from(r100).inflate(R.layout.larus_mode_switch_view, this);
        int r102 = R.id.larus_mode_switch_container;
        if (((FrameLayout) ViewBindings.findChildViewById(this, R.id.larus_mode_switch_container)) == null) goto L40;
        r102 = R.id.larus_mode_switch_content;
        LinearLayout r114 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.larus_mode_switch_content);
        if (r114 == null) goto L40;
        r102 = R.id.larus_mode_switch_indicator;
        View r103 = ViewBindings.findChildViewById(this, R.id.larus_mode_switch_indicator);
        if (r103 == null) goto L40;
        r102 = R.id.larus_mode_switch_labels;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.larus_mode_switch_labels);
        if (r104 == null) goto L40;
        r102 = R.id.larus_mode_switch_welcome_icon;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(this, R.id.larus_mode_switch_welcome_icon);
        if (r105 == null) goto L40;
        r102 = R.id.larus_mode_switch_welcome_title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.larus_mode_switch_welcome_title);
        if (r106 == null) goto L40;
        this.f307400e = r114;
        this.f307401f = r103;
        this.f307402g = r105;
        this.f307403h = r106;
        this.f307404i = r104;
        int r107 = Build.VERSION.SDK_INT;
        if (r107 < 28) goto L28;
        Typeface r108 = Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 500, false);
    L29:
        this.f307405j = r108;
        if (r107 < 28) goto L32;
        Typeface r109 = Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 400, false);
    L33:
        this.f307406k = r109;
        this.f307407l = CollectionsKt.emptyList();
        this.f307408m = new ArrayList();
        this.f307409n = new ArrayList();
        this.f307412q = -1;
        this.f307419x = z2.f365865a.enableModeSwitchTitleIcon();
        this.f307421z = new ArgbEvaluator();
        r103.setStateListAnimator(null);
        if (r107 < 28) goto L36;
        Typeface r115 = Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 600, false);
    L37:
        r106.setTypeface(r115);
        a();
        return;
    L36:
        r115 = Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 1);
        goto L37
    L32:
        r109 = Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0);
        goto L33
    L28:
        r108 = Typeface.create("sans-serif-medium", 0);
    L40:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    L12:
        r112 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS;
        goto L13
    L5:
        r101 = false;
        goto L7
    }

    public final void b(float r100, Integer r101) {
        ViewGroup.LayoutParams r102 = this.f307401f.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        int r104 = h(r100) + (this.f307399d * 2);
        if (r103.width == r104) goto L5;
        r103.width = r104;
        this.f307401f.setLayoutParams(r103);
    L5:
        this.f307401f.setTranslationX(d(r100));
        if (r101 == null) goto L8;
        int r105 = r101.intValue();
    L14:
        l(r100, this.f307413r, r105);
        j(r100);
        int r106 = this.f307413r;
        int r107 = RangesKt.coerceIn(r105, 0, (int) e());
        float r108 = RangesKt.coerceIn(r100, 0.0f, e());
        if (r107 != r106) goto L24;
        float r109 = r106;
        if (r108 <= r109) goto L21;
        r107 = r106 + 1;
        goto L24
    L21:
        if (r108 >= r109) goto L23;
        r107 = r106 - 1;
        goto L24
    L23:
        r107 = r106;
    L24:
        int r110 = RangesKt.coerceIn(r107, 0, (int) e());
        float r111 = RangesKt.coerceIn(Math.abs(r108 - r106) / RangesKt.coerceAtLeast(Math.abs(r110 - r106), 1), 0.0f, 1.0f);
        if (r111 < 0.5f) goto L29;
        r106 = r110;
    L29:
        if (r106 == this.f307411p) goto L35;
        this.f307411p = r106;
        ConversationMode r112 = (ConversationMode) CollectionsKt.getOrNull(this.f307407l, r106);
        if (r112 == null) goto L35;
        String r113 = r112.a();
        if (r113 == null) goto L35;
        this.f307396a.invoke(r113, Boolean.valueOf(this.f307415t));
    L35:
        Function1<? super Float, Unit> r114 = this.f307397b;
        if (r114 == null) goto L39;
        r114.invoke(Float.valueOf(r111));
        return;
    L39:
        return;
    L8:
        r105 = this.f307413r;
        if (r100 <= r105) goto L12;
        r105 = r105 + 1;
        goto L14
    L12:
        if (r100 >= r105) goto L14;
        r105 = r105 - 1;
        goto L14
    }

    public final int c(int r100, float r101) {
        float r102 = r100 * r101;
        Resources r103 = getResources();
        return (int) ((r102 * WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density) + 0.5f);
    }

    public final void f(int r100, boolean r101) {
        final int r102 = this.f307410o;
        int r103 = RangesKt.coerceIn(r100, 0, (int) e());
        if (this.f307410o != r103) goto L5;
        return;
    L5:
        this.f307415t = r101;
        this.f307413r = r102;
        this.f307410o = r103;
        final float r104 = r103;
        int r105 = this.f307417v + 1;
        this.f307417v = r105;
        ValueAnimator r106 = this.f307418w;
        if (r106 == null) goto L8;
        r106.cancel();
    L8:
        this.f307416u = true;
        final float r107 = this.f307414s;
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r108.setDuration(150);
        r108.addUpdateListener(new i0(r107, r104, this, r102));
        r108.addListener(new m0(r105, this, r104));
        r108.start();
        this.f307418w = r108;
    }

    public final void g(String r100, boolean r101) {
        Iterator<ConversationMode> r102 = this.f307407l.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r102.next().a(), r100) == true) goto L10;
        r103 = r103 + 1;
    L10:
        Integer r104 = Integer.valueOf(r103);
        if (r104.intValue() < 0) goto L13;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L18;
        r104 = null;
    L18:
        if (r104 == null) goto L33;
        int r106 = r104.intValue();
        if (r101 == true) goto L22;
    L24:
        if (r101 == false) goto L26;
        f(r106, false);
        return;
    L26:
        this.f307417v++;
        ValueAnimator r107 = this.f307418w;
        if (r107 == null) goto L29;
        r107.cancel();
    L29:
        this.f307416u = false;
        this.f307410o = r106;
        this.f307411p = r106;
        this.f307413r = r106;
        float r108 = r106;
        this.f307414s = r108;
        this.f307415t = false;
        b(r108, null);
        this.f307403h.setAlpha(1.0f);
        return;
    L22:
        if (r106 != this.f307410o) goto L24;
        return;
    L33:
        return;
    L13:
        r105 = false;
        goto L15
    L9:
        r103 = -1;
        goto L10
    }

    public final int i(int r100, int r101) {
        int r102 = v19.c.b(r100, getContext(), r101);
        return ContextCompat.getColor(getContext(), r102);
    }

    public final void l(float r100, int r101, int r102) {
        float r103 = RangesKt.coerceIn(Math.abs(r100 - r101) / RangesKt.coerceAtLeast(Math.abs(r102 - r101), 1), 0.0f, 1.0f);
        if (r103 >= 0.5f) goto L5;
        float r104 = 1.0f - (r103 / 0.5f);
    L6:
        this.f307402g.setAlpha(r104);
        ImageView r105 = this.f307402g;
        int r106 = 8;
        if (this.f307419x == true) goto L9;
    L19:
        r105.setVisibility(r106);
        return;
    L9:
        if (this.f307420y == false) goto L19;
        if (r104 <= 0.0f) goto L19;
        ConversationMode r107 = (ConversationMode) CollectionsKt.getOrNull(this.f307407l, r101);
        if (r107 == null) goto L15;
        String r108 = r107.a();
    L17:
        if (Intrinsics.areEqual(r108, "office") == false) goto L19;
        r106 = 0;
        goto L19
    L15:
        r108 = null;
        goto L17
    L5:
        r104 = (r103 - 0.5f) / 0.5f;
        r101 = r102;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        ViewGroup.LayoutParams r105 = this.f307401f.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r105;
        if (this.f307416u == false) goto L5;
        float r107 = this.f307414s;
    L6:
        int r108 = h(r107) + (this.f307399d * 2);
        int r109 = RangesKt.coerceAtLeast(this.f307404i.getHeight(), c(44, this.f307398c)) + (this.f307399d * 2);
        if (r106.width == r108) goto L9;
    L10:
        r106.width = r108;
        r106.height = r109;
        this.f307401f.setLayoutParams(r106);
    L12:
        if (this.f307416u == true) goto L15;
        this.f307401f.setTranslationX(d(this.f307410o));
        k(this.f307411p);
        j(this.f307410o);
        return;
    L15:
        return;
    L9:
        if (r106.height == r109) goto L12;
    L5:
        r107 = this.f307410o;
        goto L6
    }
}
