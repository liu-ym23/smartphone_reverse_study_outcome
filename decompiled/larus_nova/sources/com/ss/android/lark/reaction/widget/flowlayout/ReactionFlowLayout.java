package com.ss.android.lark.reaction.widget.flowlayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.ee.bear.middleground.comment.extension.addins.i;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.reaction.widget.flowlayout.reaction.ReactionTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionFlowLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f439365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f439366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f439367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f439368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f439369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f439370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ReactionTextView f439371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f439372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f439373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f439374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f439375k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f439376l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f439377m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f439378n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f439379o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f439380p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f439381q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Align f439382r;

    public static final enum Align extends Enum<Align> {
        public static final Align LEFT = null;
        public static final Align RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Align[] f439383a = null;

        static {
            Align r100 = new Align("LEFT", 0);
            LEFT = r100;
            Align r101 = new Align("RIGHT", 1);
            RIGHT = r101;
            f439383a = new Align[]{r100, r101};
        }

        public static Align[] values() {
            return (Align[]) f439383a.clone();
        }

        public static Align valueOf(String r100) {
            return (Align) r27.a.a(Align.class, r100);
        }

        public Align(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(String r100);
    }

    public interface b {
        void a(String r100);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f439384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f439385b;

        public c() {
            this.f439384a = 12.0f;
            this.f439385b = R.color.text_caption;
            TextUtils.TruncateAt r100 = TextUtils.TruncateAt.END;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f439386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReactionFlowLayout f439387b;

        public d(ReactionFlowLayout r100) {
            this.f439387b = r100;
        }
    }

    public interface e {
        void a();
    }

    public interface f {
        void a(String r100);
    }

    public void setNewReactionEnable(boolean r100) {
    }

    public void setReactionTopMargin(int r100) {
    }

    public f getReactionClickListener() {
        return this.f439374j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public ReactionFlowLayout(Context r100) {
        super(r100);
        this.f439366b = new c();
        this.f439367c = false;
        this.f439372h = Integer.MAX_VALUE;
        this.f439373i = true;
        this.f439377m = Integer.MIN_VALUE;
        this.f439378n = -1;
        this.f439379o = -1;
        this.f439381q = -1;
        this.f439382r = Align.LEFT;
        this.f439365a = v2c.a.c(getContext(), R.drawable.bubble_reaction_grey_bg);
    }

    public void setAlign(Align r100) {
        this.f439382r = r100;
    }

    public void setChildXOffset(int r100) {
        ReactionTextView r101 = this.f439371g;
        if (r101 == null) goto L5;
        r101.setTranslationX(r100);
    L5:
        this.f439368d = r100;
    }

    public void setChildYOffset(int r100) {
        ReactionTextView r101 = this.f439371g;
        if (r101 == null) goto L5;
        r101.setTranslationY(r100);
    L5:
        this.f439369e = r100;
    }

    public void setDisplayChangeEnable(boolean r100) {
        this.f439367c = r100;
    }

    public void setDivideLineColor(int r100) {
        this.f439377m = r100;
    }

    public void setExtendIconTint(int r100) {
        ReactionTextView r101 = this.f439371g;
        if (r101 == null) goto L6;
        r101.setExtendIconTint(r100);
        return;
    }

    public void setExtraLineHeight(int r100) {
        this.f439379o = r100;
    }

    public void setMaxNameCount(int r100) {
        this.f439372h = r100;
    }

    public void setOnReactionMoreTrigger(b r100) {
        this.f439376l = r100;
    }

    public void setOnReactionNameTrigger(a r100) {
        this.f439375k = r100;
    }

    public void setReactionClickListener(f r100) {
        this.f439374j = r100;
    }

    public void setReactionLeftMargin(int r100) {
        this.f439381q = r100;
    }

    public void setReactionMaxWidth(int r100) {
        this.f439370f = r100;
    }

    public void setReactionPaddings(int[] r100) {
        this.f439380p = r100;
    }

    public void setReactionResourceLoader(com.ss.android.lark.reaction.widget.flowlayout.reaction.e r100) {
        ReactionTextView r101 = this.f439371g;
        if (r101 == null) goto L6;
        r101.setReactionResourceLoader(r100);
        return;
    }

    public void setReactionTextSize(int r100) {
        this.f439366b.f439384a = r100;
    }

    public void setSeparatorWidth(int r100) {
        this.f439378n = r100;
    }

    public void setTagBackground(Drawable r100) {
        this.f439365a = r100;
    }

    public void setTagBackgroundColor(int r100) {
        Context r101 = getContext();
        Drawable r102 = v2c.a.c(r101, R.drawable.bubble_reaction_grey_bg);
        if (r100 != 0) goto L6;
    L8:
        int r103 = R.color.udtoken_reaction_bg_grey;
    L9:
        ((GradientDrawable) r102).setColor(UDColorUtils.getColor(r101, r103));
        this.f439365a = r102;
        return;
    L6:
        if (r100 != 1) goto L8;
        r103 = R.color.udtoken_reaction_bg_grey_float;
        goto L9
    }

    public void setTapAnimationEnabled(boolean r100) {
        this.f439373i = r100;
    }

    public void setTextColor(int r100) {
        this.f439366b.f439385b = r100;
    }

    public void setup(List<q2c.c> r100) {
        a(r100, false);
    }

    public ReactionFlowLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f439366b = new c();
        this.f439367c = false;
        this.f439372h = Integer.MAX_VALUE;
        this.f439373i = true;
        this.f439377m = Integer.MIN_VALUE;
        this.f439378n = -1;
        this.f439379o = -1;
        this.f439381q = -1;
        this.f439382r = Align.LEFT;
        this.f439365a = v2c.a.c(getContext(), R.drawable.bubble_reaction_grey_bg);
    }

    public final void a(List<q2c.c> r100, boolean r101) {
        b(r100, r101, -1, null);
    }

    public ReactionFlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f439366b = new c();
        this.f439367c = false;
        this.f439372h = Integer.MAX_VALUE;
        this.f439373i = true;
        this.f439377m = Integer.MIN_VALUE;
        this.f439378n = -1;
        this.f439379o = -1;
        this.f439381q = -1;
        this.f439382r = Align.LEFT;
        this.f439365a = v2c.a.c(getContext(), R.drawable.bubble_reaction_grey_bg);
    }

    public final void b(List r110, boolean r111, int r112, i r113) {
        if (r110 == null) goto L10;
        ArrayList r100 = new ArrayList(r110.size());
        Iterator r114 = r110.iterator();
    L6:
        if (r114.hasNext() == false) goto L12;
        q2c.c r101 = (q2c.c) r114.next();
        if (qsb.b.a().i7(r101.f531474a) == true) goto L6;
        r100.add(r101);
    L12:
        if (r100 != null) goto L14;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == true) goto L26;
        ReactionTextView r115 = this.f439371g;
        if (r115 != null) goto L22;
        return;
    L22:
        if (r115.getParent() == null) goto L24;
        ((ViewGroup) this.f439371g.getParent()).removeView(this.f439371g);
    L24:
        this.f439371g = null;
        return;
    L26:
        ReactionTextView r103 = this.f439371g;
        if (r103 != null) goto L29;
        ReactionTextView r104 = new ReactionTextView(getContext());
        this.f439371g = r104;
        addView(r104);
    L30:
        int[] r105 = this.f439380p;
        if (r105 == null) goto L40;
        int r106 = r105.length;
        int r107 = 0;
    L34:
        if (r107 >= r106) goto L40;
        int r108 = r105[r107];
        if (r108 == 0) goto L39;
        if (r108 == (-1)) goto L39;
        boolean r109 = true;
    L42:
        if (r109 == false) goto L44;
        ReactionTextView r116 = this.f439371g;
        int[] r117 = this.f439380p;
        r116.setPadding(r117[0], r117[1], r117[2], r117[3]);
    L44:
        ReactionTextView r118 = this.f439371g;
        int r119 = this.f439370f;
        if (r119 != 0) goto L47;
        r119 = v2c.a.a(getContext(), 315.0f);
    L47:
        r118.setMaxWidth(r119);
        if (this.f439367c == false) goto L50;
        this.f439371g.setTextSize(2, zz7.b.d().getMultiplier() * this.f439366b.f439384a);
    L51:
        this.f439371g.setTextColor(v2c.a.b(getContext(), this.f439366b.f439385b));
        if (this.f439382r != Align.RIGHT) goto L54;
        int r120 = GravityCompat.END;
    L55:
        this.f439371g.setGravity(r120);
        FrameLayout.LayoutParams r121 = new FrameLayout.LayoutParams(-2, -2);
        int r122 = this.f439381q;
        if (r122 == (-1)) goto L58;
        r121.leftMargin = r122;
    L58:
        int r123 = this.f439377m;
        if (r123 == Integer.MIN_VALUE) goto L61;
        this.f439371g.setDividerColor(r123);
    L61:
        int r124 = this.f439378n;
        if (r124 <= 0) goto L64;
        this.f439371g.setSeparatorWidth(r124);
    L64:
        int r125 = this.f439379o;
        if (r125 <= 0) goto L67;
        this.f439371g.setExtraLineHeight(r125);
    L67:
        this.f439371g.setLineBackground(this.f439365a);
        this.f439371g.setTranslationX(this.f439368d);
        this.f439371g.setTranslationY(this.f439369e);
        this.f439371g.setReactionClickListener(new p2c.a(this));
        this.f439371g.setOnContributorClickNew(new d(this));
        this.f439371g.setLayoutParams(r121);
        this.f439371g.setShownNamesNumberLimit(this.f439372h);
        this.f439371g.setEnableLongClick(r111);
        this.f439371g.setOnlyShowCount(false);
        this.f439371g.setTapAnimationEnabled(this.f439373i);
        if (r112 == 0) goto L77;
        if (r113 == null) goto L77;
        Drawable r126 = v2c.a.c(getContext(), r112);
        if (r126 == null) goto L77;
        if (r126.getIntrinsicWidth() <= 0) goto L77;
        if (r126.getIntrinsicHeight() <= 0) goto L77;
        ReactionTextView r127 = this.f439371g;
        r127.getClass();
        Intrinsics.checkNotNullParameter(r126, "extendIconDrawable");
        Intrinsics.checkNotNullParameter(r113, "extendIconClickListener");
        r127.f439405e = r126;
        r127.f439408h = r113;
        r127.f439406f = true;
    L77:
        this.f439371g.setReactionData(r100);
        return;
    L54:
        r120 = GravityCompat.START;
        goto L55
    L50:
        this.f439371g.setTextSize(2, this.f439366b.f439384a);
    L39:
        r107 = r107 + 1;
    L40:
        r109 = false;
        goto L42
    L29:
        r103.setVisibility(0);
        goto L30
    L14:
        if (r100.size() == 0) goto L16;
        r102 = true;
        goto L17
    L10:
        r100 = null;
        goto L12
    }
}
