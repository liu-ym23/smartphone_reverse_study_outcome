package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.ScrollSwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiScrollTextView;
import com.larus.nova.R;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class WikItemLeafView extends FrameLayout implements com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f242221s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f242222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f242223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BearLottieView f242224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f242225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f242226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f242227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f242228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f242229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f242230i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WikiItemBackgroundView f242231j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout f242232k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f242233l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f242234m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f242235n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a f242236o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b f242237p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a f242238q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f242239r;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikItemLeafView f242240a;

        public a(WikItemLeafView r100) {
            this.f242240a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.ee.util.ui.h.a(400) == true) goto L5;
            return;
        L5:
            e r101 = this.f242240a.f242235n;
            if (r101 == null) goto L9;
            r101.a();
            return;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikItemLeafView f242241a;

        public b(WikItemLeafView r100) {
            this.f242241a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a r101 = this.f242241a.f242236o;
            if (r101 == null) goto L6;
            r101.a(r100.getId(), r100);
            return;
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikItemLeafView f242242a;

        public c(WikItemLeafView r100) {
            this.f242242a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a r101 = this.f242242a.f242236o;
            if (r101 == null) goto L6;
            r101.a(r100.getId(), r100);
            return;
        }
    }

    public class d implements com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikItemLeafView f242243a;

        public d(WikItemLeafView r100) {
            this.f242243a = r100;
        }

        @Override // com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout.d
        public final void a(com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout r100, boolean r101) {
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b r102 = this.f242243a.f242237p;
            if (r102 == null) goto L6;
            r102.a(r101);
            return;
        }
    }

    public interface e {
        void a();
    }

    public void d() {
        setMenuClickEnable(false);
        setItemEnable(false);
        setItemClickListener(null);
    }

    public void f() {
        setFocus(false);
        setItemClickListener(null);
        setSwipeMenuClickListener(null);
        setUserSwipeMenuListener(null);
        setSwipeMenuEnable(false);
        setMenuClickEnable(true);
        setItemEnable(true);
        i(R.id.swipe_menu_more, true);
        i(R.id.swipe_menu_add, true);
    }

    public float getItemHeightInDp() {
        return 48.0f;
    }

    public int getPressedGravityType() {
        return 16;
    }

    public int getPressedInnerMarginStart() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d
    public final void a() {
        this.f242232k.b();
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d
    public final void b() {
        this.f242232k.e();
    }

    public int getLayout() {
        int r100 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f241670f;
        return R.layout.wiki_tree_item_scroll_v2;
    }

    public int getPressedContainerHeight() {
        return this.f242222a.getMeasuredHeight();
    }

    public int getPressedContainerWidth() {
        return this.f242222a.getMeasuredWidth();
    }

    public String getTitle() {
        return this.f242230i.getText().toString();
    }

    public final void j() {
        boolean r100 = true;
        if (this.f242233l.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (this.f242234m.getVisibility() == 0) goto L10;
        r100 = false;
    L10:
        if (r101 == false) goto L14;
        if (r100 == false) goto L14;
        this.f242233l.setBackgroundResource(R.drawable.facade_round_left_m);
        this.f242234m.setBackgroundResource(R.drawable.facade_round_right_m);
        return;
    L14:
        if (r101 == false) goto L17;
        if (r100 == true) goto L17;
        this.f242233l.setBackgroundResource(R.drawable.facade_round_around_m);
        return;
    L17:
        if (r101 == true) goto L23;
        if (r100 == false) goto L24;
        this.f242234m.setBackgroundResource(R.drawable.facade_round_around_m);
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r101 = false;
        goto L7
    }

    public void e() {
        LayoutInflater.from(getContext()).inflate(getLayout(), this);
        this.f242223b = (FrameLayout) findViewById(R.id.header);
        this.f242222a = (LinearLayout) findViewById(R.id.container);
        this.f242224c = (BearLottieView) findViewById(R.id.loading);
        this.f242225d = (ImageView) findViewById(R.id.indicator);
        this.f242226e = (LinearLayout) findViewById(R.id.content);
        this.f242227f = (FrameLayout) findViewById(R.id.icon_container);
        ImageView r100 = (ImageView) findViewById(R.id.icon);
        this.f242228g = r100;
        r100.setImageResource(kac.a.b(R.drawable.ud_icon_file_doc_colorful));
        this.f242229h = (ImageView) findViewById(R.id.shortcut);
        this.f242230i = (TextView) findViewById(R.id.title);
        this.f242231j = (WikiItemBackgroundView) findViewById(R.id.background);
        this.f242232k = (com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout) findViewById(R.id.swipe_menu_layout);
        this.f242233l = (ImageView) findViewById(R.id.swipe_menu_more);
        this.f242234m = (ImageView) findViewById(R.id.swipe_menu_add);
        setFocus(false);
        this.f242225d.setImageDrawable(null);
        this.f242224c.setVisibility(8);
        this.f242232k.setSwipeEnable(false);
        j();
        this.f242226e.setOnClickListener(new a(this));
        this.f242233l.setOnClickListener(new b(this));
        this.f242234m.setOnClickListener(new c(this));
        this.f242232k.setOnUserSwipeMenuListener(new d(this));
    }

    public int getTitleColor() {
        return getResources().getColor(R.color.text_title);
    }

    public WikiItemBackgroundView getBackgroundView() {
        return this.f242231j;
    }

    public ImageView getIndicatorView() {
        return this.f242225d;
    }

    public ImageView getItemIcon() {
        return this.f242228g;
    }

    public WikItemLeafView(Context r100) {
        this(r100, null);
    }

    public void c(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.b r100) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.c.a(r100, this, this.f242226e);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        com.bytedance.ee.util.ui.m.a(new j(this));
    }

    public void setFocus(boolean r100) {
        this.f242239r = r100;
    }

    public void setIcon(Triple<Integer, Integer, Integer> r100) {
        FrameLayout r101 = this.f242227f;
        int r102 = 0;
        if (r100 == null) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        if (r100 == null) goto L19;
        Integer r104 = r100.getFirst();
        Integer r105 = r100.getSecond();
        Integer r106 = r100.getThird();
        ImageView r107 = this.f242229h;
        if (r105 != null) goto L11;
    L13:
        r102 = 8;
    L14:
        r107.setVisibility(r102);
        this.f242228g.setImageResource(r104.intValue());
        if (r106.intValue() != 0) goto L17;
        this.f242228g.setImageTintList(null);
        return;
    L17:
        com.bytedance.ee.util.ui.l.c(this.f242228g, r106.intValue());
        return;
    L11:
        if (r105.intValue() == 0) goto L13;
    L19:
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public void setIconPadding(int r100) {
        this.f242227f.setPadding(r100, r100, r100, r100);
    }

    public void setIconVisible(boolean r100) {
        FrameLayout r101 = this.f242227f;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setItemClickListener(e r100) {
        this.f242235n = r100;
    }

    public void setItemEnable(boolean r100) {
        if (r100 == false) goto L4;
        this.f242222a.setAlpha(1.0f);
        return;
    L4:
        this.f242222a.setAlpha(0.3f);
    }

    public void setMenuClickEnable(boolean r100) {
        h(R.id.swipe_menu_more, r100);
        h(R.id.swipe_menu_add, r100);
    }

    public void setScrollManager(com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r100) {
        this.f242238q = r100;
        com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout r101 = this.f242232k;
        if ((r101 instanceof ScrollSwipeMenuLayout) == false) goto L5;
        ((ScrollSwipeMenuLayout) r101).setScrollManager(r100);
    L5:
        setLayoutParams(new ViewGroup.LayoutParams(-2, com.bytedance.ee.util.ui.n.c(getItemHeightInDp())));
    }

    public void setSwipeMenuClickListener(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a r100) {
        this.f242236o = r100;
    }

    public void setSwipeMenuEnable(boolean r100) {
        this.f242232k.setSwipeEnable(r100);
    }

    public void setTitle(String r100) {
        TextView r101 = this.f242230i;
        boolean r102 = TextUtils.isEmpty(r100);
        CharSequence r103 = r100;
        if (r102 == false) goto L6;
        r103 = getResources().getText(R.string.Doc_Wiki_UntitledPage);
    L6:
        r101.setText(r103);
    }

    public void setTitleStyle(Typeface r100) {
        int r101 = h18.e.f483540a;
        Typeface r102 = h18.e.b(getContext(), r100.getStyle());
        this.f242230i.setTypeface(r102);
    }

    public void setUserSwipeMenuListener(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b r100) {
        this.f242237p = r100;
    }

    public WikItemLeafView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void g(int r100, int r101) {
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r101 > 8) goto L7;
        int r102 = (r100 - 1) * 12;
    L11:
        this.f242223b.setPadding(com.bytedance.ee.util.ui.n.d(r102 + 0), 0, 0, 0);
        int r103 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f241670f;
        TextView r104 = this.f242230i;
        int r105 = this.f242223b.getPaddingLeft();
        Intrinsics.checkNotNullParameter(r104, "title");
        if ((r104 instanceof WikiScrollTextView) == false) goto L15;
        WikiScrollTextView r106 = (WikiScrollTextView) r104;
        r106.getClass();
        r106.f241666a = r105 + com.bytedance.ee.util.ui.n.d(44);
        return;
    L15:
        return;
    L7:
        int r107 = 12 - ((r101 - 8) * 3);
        if (r107 >= 6) goto L10;
        r107 = 6;
    L10:
        r102 = ((r100 - 1) * r107) + 12;
        goto L11
    }

    public final void h(int r100, boolean r101) {
        int r102 = getResources().getColor(R.color.static_white);
        if (r100 != R.id.swipe_menu_more) goto L8;
        if (r101 == false) goto L6;
        this.f242233l.setImageTintList(ColorStateList.valueOf(r102));
        this.f242233l.setAlpha(1.0f);
        this.f242233l.setClickable(true);
        return;
    L6:
        this.f242233l.setImageTintList(ColorStateList.valueOf(r102));
        this.f242233l.setAlpha(0.5f);
        this.f242233l.setClickable(false);
        return;
    L8:
        if (r100 != R.id.swipe_menu_add) goto L15;
        if (r101 == false) goto L11;
        this.f242234m.setImageTintList(ColorStateList.valueOf(r102));
        this.f242234m.setAlpha(1.0f);
        this.f242234m.setClickable(true);
        return;
    L11:
        this.f242234m.setImageTintList(ColorStateList.valueOf(r102));
        this.f242234m.setAlpha(0.5f);
        this.f242234m.setClickable(false);
        return;
    }

    public void i(int r100, boolean r101) {
        if (r100 != R.id.swipe_menu_more) goto L9;
        ImageView r102 = this.f242233l;
        if (r101 == false) goto L7;
        r102.setVisibility(0);
    L14:
        j();
        return;
    L7:
        r102.setVisibility(8);
        goto L14
    L9:
        if (r100 != R.id.swipe_menu_add) goto L14;
        ImageView r103 = this.f242234m;
        if (r101 == false) goto L13;
        r103.setVisibility(0);
        goto L14
    L13:
        r103.setVisibility(8);
        goto L14
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r103 = this.f242238q;
        if (r103 == null) goto L8;
        int r104 = r103.a(getContext(), this);
        if (r102 >= r104) goto L9;
        setMeasuredDimension(r104, getMeasuredHeight());
        return;
    L9:
        return;
    }

    public WikItemLeafView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 0);
    }

    public WikItemLeafView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.f242239r = false;
        e();
    }
}
