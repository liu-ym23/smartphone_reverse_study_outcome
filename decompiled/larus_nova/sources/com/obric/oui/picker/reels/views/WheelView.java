package com.obric.oui.picker.reels.views;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003fghB'\b\u0007\u0012\u0006\u0010`\u001a\u00020_\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010a\u0012\b\b\u0002\u0010c\u001a\u00020\u0014¢\u0006\u0004\bd\u0010eJ!\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R$\u0010&\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010.\u001a\u0004\u0018\u00010\u00142\b\u0010'\u001a\u0004\u0018\u00010\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R*\u00102\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0016\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR*\u00106\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010A\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0018\"\u0004\b@\u0010\u001aR$\u0010D\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\u0018\"\u0004\bC\u0010\u001aR$\u0010G\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010\u001aR$\u0010J\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010\u0018\"\u0004\bI\u0010\u001aR$\u0010P\u001a\u00020K2\u0006\u0010'\u001a\u00020K8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010S\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010\u0018\"\u0004\bR\u0010\u001aR$\u0010V\u001a\u00020K2\u0006\u0010'\u001a\u00020K8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010M\"\u0004\bU\u0010OR\u0011\u0010X\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\bW\u0010\u0018R$\u0010\\\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010\u0018\"\u0004\b[\u0010\u001aR\u0013\u0010^\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b]\u0010#¨\u0006i"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView;", "Landroid/widget/FrameLayout;", "", "", "entries", "", "setEntries", "([Ljava/lang/String;)V", "", "", "tag", "setTagText", "", "u", "Z", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "showDivider", "", BaseSwitches.V, "I", "getHighlightConorRadiusPx", "()I", "setHighlightConorRadiusPx", "(I)V", "highlightConorRadiusPx", "cyclic", "w", "isCyclic", "setCyclic", "x", "Ljava/lang/CharSequence;", "getWheelTagText", "()Ljava/lang/CharSequence;", "setWheelTagText", "(Ljava/lang/CharSequence;)V", "wheelTagText", "value", "y", "Ljava/lang/Integer;", "getTagGap", "()Ljava/lang/Integer;", "setTagGap", "(Ljava/lang/Integer;)V", "tagGap", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getSelectedTextColor", "setSelectedTextColor", "selectedTextColor", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getNormalTextColor", "setNormalTextColor", "normalTextColor", "Lcom/obric/oui/picker/reels/views/c;", "B", "Lcom/obric/oui/picker/reels/views/c;", "getOnWheelChangedListener", "()Lcom/obric/oui/picker/reels/views/c;", "setOnWheelChangedListener", "(Lcom/obric/oui/picker/reels/views/c;)V", "onWheelChangedListener", "getStartIndex", "setStartIndex", "startIndex", "getItemCount", "setItemCount", "itemCount", "getItemHeightPx", "setItemHeightPx", "itemHeightPx", "getSelectedItemHeightPx", "setSelectedItemHeightPx", "selectedItemHeightPx", "", "getTextSizePx", "()F", "setTextSizePx", "(F)V", "textSizePx", "getTextColor", "setTextColor", "textColor", "getSelectedTextSizePxProp", "setSelectedTextSizePxProp", "selectedTextSizePxProp", "getItemSize", "itemSize", "index", "getCurrentIndex", "setCurrentIndex", "currentIndex", "getCurrentItem", "currentItem", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class WheelView extends FrameLayout {
    public static final /* synthetic */ int C = 0;
    public int A;
    public com.obric.oui.picker.reels.views.c B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f402160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f402161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WheelLayoutManager f402162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f402163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f402164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f402165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f402166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f402167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f402168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f402169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f402170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f402171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f402172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f402173n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f402174o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f402175p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f402176q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f402177r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f402178s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f402179t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f402180u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f402181v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f402182w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f402183x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f402184y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f402185z;

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<CharSequence> f402186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WheelView f402187d;

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public final int a() {
            int r100 = this.f402186c.size();
            if (r100 != 0) goto L6;
            return 0;
        L6:
            WheelView r101 = this.f402187d;
            if (r101.f402182w == false) goto L10;
            return r100 * 1000;
        L10:
            return r100 + (r101.f() * 2);
        }

        public b(WheelView r100) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            this.f402187d = r100;
            this.f402186c = new ArrayList();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public final void c(RecyclerView.y r100, int r101) {
            final c r102 = (c) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            WheelView r103 = this.f402187d;
            int r104 = WheelView.C;
            int r105 = r103.b(r101);
            WheelView r106 = this.f402187d;
            if (r106.f402182w == false) goto L6;
            r102.f402188u.setAlpha(1.0f);
            r102.f402188u.setTextSize(0, this.f402187d.f402167h);
            r102.f402188u.setText((CharSequence) ListProtector.get(this.f402186c, r105));
            View r107 = r102.f401728a;
            final WheelView r108 = this.f402187d;
            r107.setOnClickListener(new g(r102, r108));
            return;
        L6:
            if (r106.g(r105) == false) goto L8;
            r102.f402188u.setAlpha(1.0f);
            r102.f402188u.setTextSize(0, this.f402187d.f402167h);
            r102.f402188u.setText((CharSequence) ListProtector.get(this.f402186c, r105));
            View r109 = r102.f401728a;
            final WheelView r110 = this.f402187d;
            r109.setOnClickListener(new h(r102, r110));
            return;
        L8:
            r102.f402188u.setAlpha(0.0f);
            r102.f402188u.setText("");
            r102.f401728a.setOnClickListener(null);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.y d(RecyclerView r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            TextView r102 = new TextView(r100.getContext());
            WheelView r103 = this.f402187d;
            r102.setId(R.id.text1);
            r102.setLayoutParams(new RecyclerView.LayoutParams(-1, r103.f402164e));
            r102.setGravity(17);
            r102.setTextSize(0, r103.f402167h);
            r102.setIncludeFontPadding(false);
            return new c(r102);
        }
    }

    public static final class c extends RecyclerView.y {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final TextView f402188u;

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f402188u = (TextView) r100.findViewById(R.id.text1);
        }
    }

    public static final class d extends RecyclerView.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WheelView f402189a;

        public d(WheelView r100) {
            this.f402189a = r100;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.o
        public final void a(RecyclerView r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "rv");
            boolean r112 = true;
            if (r111 == 0) goto L14;
            if (r111 != 1) goto L6;
            WheelView r113 = this.f402189a;
            r113.f402173n = true;
            r113.f402179t = false;
            r113.f402174o = false;
            int r114 = r113.e();
            if (r114 == (-1)) goto L58;
            int r115 = this.f402189a.b(r114);
            if (this.f402189a.g(r115) == false) goto L59;
            WheelView r100 = this.f402189a;
            r100.f402171l = r114;
            r100.f402172m = r115;
            return;
        L59:
            return;
        L58:
            return;
        L6:
            if (r111 != 2) goto L65;
            this.f402189a.f402179t = true;
            return;
        L65:
            return;
        L14:
            WheelView r116 = this.f402189a;
            r116.f402173n = false;
            r116.f402174o = false;
            int r101 = r116.f402177r;
            if (r101 == (-1)) goto L23;
            r116.f402177r = -1;
            int r117 = r116.e();
            if (r117 == (-1)) goto L23;
            int r118 = this.f402189a.b(r117);
            int r102 = this.f402189a.b(r101);
            if (this.f402189a.g(r102) == false) goto L23;
            if (r118 == r102) goto L23;
            this.f402189a.d(r101, true);
            return;
        L23:
            WheelView r119 = this.f402189a;
            if (r119.f402178s == false) goto L26;
            r119.f402178s = false;
        L44:
            r112 = false;
        L45:
            WheelView r120 = this.f402189a;
            if (r120.f402179t == false) goto L61;
            if (r112 == true) goto L62;
            r120.f402179t = false;
            int r121 = r120.e();
            if (r121 == (-1)) goto L63;
            int r122 = this.f402189a.b(r121);
            if (this.f402189a.g(r122) == false) goto L64;
            this.f402189a.getClass();
            com.obric.oui.picker.reels.views.c r123 = this.f402189a.getOnWheelChangedListener();
            if (r123 == null) goto L66;
            r123.a(r122);
            return;
        L66:
            return;
        L64:
            return;
        L63:
            return;
        L62:
            return;
        L61:
            return;
        L26:
            r119.f402160a.a0();
            WheelLayoutManager r103 = r119.f402162c;
            if (r103.f402155v != 0) goto L29;
        L39:
            int r104 = 0;
        L40:
            if (r104 == 0) goto L44;
            r119.f402178s = true;
            if (r104 == 0) goto L45;
            r119.f402174o = true;
            r119.f402160a.X(0, r104, new com.obric.oui.popover.b(), 400, false);
            goto L45
        L29:
            if (r103.u() == 0) goto L39;
            if (r103.A() <= 0) goto L39;
            float r105 = r103.f402156w / r103.f402155v;
            if (r103.f402158y == false) goto L37;
            int r106 = RangesKt.coerceIn(MathKt.roundToInt(r105), 0, r103.A() - 1);
        L38:
            r104 = MathKt.roundToInt((r106 * r103.f402155v) - r103.f402156w);
            goto L40
        L37:
            int r107 = r103.f402159z;
            r106 = RangesKt.coerceIn(MathKt.roundToInt(r105), r107, RangesKt.coerceAtLeast((r103.A() - r103.f402159z) - 1, r107));
            goto L38
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.o
        public final void b(RecyclerView r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "rv");
            WheelView r103 = this.f402189a;
            int r104 = WheelView.C;
            int r105 = r103.e();
            if (r105 != (-1)) goto L5;
            return;
        L5:
            if (r100.getScrollState() == 0) goto L25;
            WheelView r106 = this.f402189a;
            if (r106.f402173n == true) goto L9;
            return;
        L9:
            if (r106.f402174o == true) goto L27;
            int r107 = r106.b(r105);
            if (this.f402189a.g(r107) == false) goto L28;
            WheelView r108 = this.f402189a;
            if (r105 == r108.f402171l) goto L29;
            r108.f402171l = r105;
            bma.a.b(r108, 3);
            WheelView r109 = this.f402189a;
            int r110 = r109.f402172m;
            if (r107 == r110) goto L30;
            if (r110 < 0) goto L18;
            r109.f402163d.f402186c.size();
        L18:
            com.obric.oui.picker.reels.views.c r111 = this.f402189a.getOnWheelChangedListener();
            if (r111 == null) goto L22;
            r111.onChanged(r107);
        L22:
            this.f402189a.f402172m = r107;
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        L27:
            return;
        }
    }

    static {
    }

    public WheelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public WheelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static /* synthetic */ void a(WheelView r100) {
        m8589setItems$lambda6(r100);
    }

    public final void c() {
        int r100 = this.f402176q;
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if (this.f402163d.f402186c.size() != 0) goto L9;
        return;
    L9:
        if (this.f402160a.getChildCount() != 0) goto L11;
        return;
    L11:
        this.f402176q = -1;
        d(r100, false);
    }

    public final int e() {
        WheelLayoutManager r100 = this.f402162c;
        int r101 = 0;
        if (r100.f402155v != 0) goto L5;
    L11:
        int r102 = -1;
    L12:
        if (r102 == (-1)) goto L14;
        return r102;
    L14:
        int r103 = ((this.f402160a.getPaddingTop() + this.f402160a.getHeight()) - this.f402160a.getPaddingBottom()) / 2;
        int r104 = this.f402160a.getChildCount();
        View r105 = null;
        float r106 = Float.MAX_VALUE;
    L15:
        if (r101 >= r104) goto L23;
        r101 = r101 + 1;
        View r107 = this.f402160a.getChildAt(r101);
        if (r107 == null) goto L15;
        float r108 = Math.abs(((r107.getTop() + r107.getBottom()) / 2.0f) - r103);
        if (r108 >= r106) goto L15;
        r105 = r107;
        r106 = r108;
        goto L15
    L23:
        if (r105 != null) goto L26;
        return -1;
    L26:
        return this.f402160a.C(r105);
    L5:
        if (r100.A() == 0) goto L11;
        int r109 = MathKt.roundToInt(r100.f402156w / r100.f402155v);
        if (r100.f402158y == false) goto L10;
        r102 = RangesKt.coerceIn(r109, 0, r100.A() - 1);
        goto L12
    L10:
        int r110 = r100.f402159z;
        r102 = RangesKt.coerceIn(r109, r110, RangesKt.coerceAtLeast((r100.A() - r100.f402159z) - 1, r110));
        goto L12
    }

    public final int f() {
        return RangesKt.coerceAtLeast((this.f402166g + 2) / 2, 1);
    }

    public final int getItemSize() {
        return this.f402163d.f402186c.size();
    }

    public final void h() {
        int r100 = this.f402163d.f402186c.size();
        if (r100 != 0) goto L5;
        return;
    L5:
        int r101 = RangesKt.coerceIn(this.f402175p, 0, r100 - 1);
        if (this.f402182w == false) goto L8;
        int r102 = ((r100 * 1000) / 2) + r101;
    L9:
        this.f402176q = r102;
        if (this.f402160a.getChildCount() <= 0) goto L13;
        c();
        return;
    L13:
        return;
    L8:
        r102 = f() + r101;
        goto L9
    }

    public final int getCurrentIndex() {
        int r100 = e();
        if (r100 != (-1)) goto L5;
        return 0;
    L5:
        int r101 = b(r100);
        if (g(r101) == true) goto L8;
        return 0;
    L8:
        return r101;
    }

    public final CharSequence getCurrentItem() {
        int r100 = getCurrentIndex();
        return (CharSequence) CollectionsKt.getOrNull(this.f402163d.f402186c, r100);
    }

    public final int getHighlightConorRadiusPx() {
        return this.f402181v;
    }

    public final int getItemCount() {
        return this.f402166g;
    }

    public final int getItemHeightPx() {
        return this.f402164e;
    }

    public final int getNormalTextColor() {
        return this.A;
    }

    public final com.obric.oui.picker.reels.views.c getOnWheelChangedListener() {
        return this.B;
    }

    public final int getSelectedItemHeightPx() {
        return this.f402164e;
    }

    public final int getSelectedTextColor() {
        return this.f402185z;
    }

    public final float getSelectedTextSizePxProp() {
        return this.f402169j;
    }

    public final boolean getShowDivider() {
        return this.f402180u;
    }

    public final int getStartIndex() {
        return this.f402175p;
    }

    public final Integer getTagGap() {
        return this.f402184y;
    }

    public final int getTextColor() {
        return this.A;
    }

    public final float getTextSizePx() {
        return this.f402168i;
    }

    public final CharSequence getWheelTagText() {
        return this.f402183x;
    }

    /* JADX INFO: renamed from: setItems$lambda-6, reason: not valid java name */
    private static final void m8589setItems$lambda6(WheelView r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.requestLayout();
        if (r100.f402160a.getHeight() <= 0) goto L7;
        RecyclerView r101 = r100.f402160a;
        r101.setPadding(r101.getPaddingLeft(), 0, r100.f402160a.getPaddingRight(), 0);
    L7:
        if (r100.f402176q == (-1)) goto L9;
        r100.c();
        return;
    L9:
        r100.h();
    }

    public final int b(int r100) {
        int r101 = this.f402163d.f402186c.size();
        if (r101 != 0) goto L7;
        return -1;
    L7:
        if (this.f402182w == false) goto L12;
        int r102 = r100 % r101;
        if (r102 < 0) goto L14;
        return r102;
    L14:
        return r102 + r101;
    L12:
        return r100 - f();
    }

    public final boolean g(int r100) {
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (r100 >= this.f402163d.f402186c.size()) goto L9;
        return true;
    L9:
        return false;
    }

    public final void i(int r100) {
        int r101 = getCurrentIndex();
        l(r100, false);
        int r102 = this.f402163d.f402186c.size();
        if (r102 <= 0) goto L16;
        int r103 = RangesKt.coerceIn(r100, 0, r102 - 1);
        if (r101 == r103) goto L17;
        com.obric.oui.picker.reels.views.c r104 = this.B;
        if (r104 == null) goto L10;
        r104.onChanged(r103);
    L10:
        com.obric.oui.picker.reels.views.c r105 = this.B;
        if (r105 == null) goto L14;
        r105.a(r103);
    L14:
        this.f402172m = r103;
        return;
    L17:
        return;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f402170k = pla.d.n(this, 28);
        requestLayout();
    }

    public final void setCurrentIndex(int r100) {
        i(r100);
    }

    public final void setCyclic(boolean r100) {
        this.f402182w = r100;
        WheelLayoutManager r101 = this.f402162c;
        r101.f402158y = r100;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.f402159z = r102;
        requestLayout();
        return;
    L5:
        r102 = f();
        goto L6
    }

    public final void setEntries(List<String> r100) {
        if (r100 != null) goto L5;
        List<? extends CharSequence> r101 = null;
    L9:
        if (r101 != null) goto L11;
        r101 = CollectionsKt.emptyList();
    L11:
        k(r101, null);
        return;
    L5:
        List<String> r102 = r100;
        r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r101.add((String) r103.next());
        goto L7
    }

    public final void setHighlightConorRadiusPx(int r100) {
        this.f402181v = r100;
    }

    public final void setItemCount(int r100) {
        this.f402166g = r100;
        WheelLayoutManager r101 = this.f402162c;
        if (this.f402182w == false) goto L5;
        int r102 = 0;
    L6:
        r101.f402159z = r102;
        requestLayout();
        return;
    L5:
        r102 = f();
        goto L6
    }

    public final void setItemHeightPx(int r100) {
        this.f402164e = r100;
        this.f402163d.f401640a.a();
        requestLayout();
    }

    public final void setNormalTextColor(int r100) {
        this.A = r100;
        this.f402162c.f402151r = r100;
        this.f402160a.requestLayout();
    }

    public final void setOnWheelChangedListener(com.obric.oui.picker.reels.views.c r100) {
        this.B = r100;
    }

    public final void setSelectedItemHeightPx(int r100) {
        this.f402164e = r100;
        this.f402163d.f401640a.a();
        requestLayout();
    }

    public final void setSelectedTextColor(int r100) {
        this.f402185z = r100;
        this.f402162c.f402150q = r100;
        this.f402160a.requestLayout();
    }

    public final void setSelectedTextSizePxProp(float r100) {
        this.f402169j = r100;
        this.f402167h = Math.max(this.f402168i, r100);
        this.f402163d.f401640a.a();
        requestLayout();
    }

    public final void setShowDivider(boolean r100) {
        this.f402180u = r100;
    }

    public final void setStartIndex(int r100) {
        this.f402175p = r100;
        if (this.f402163d.f402186c.size() <= 0) goto L6;
        l(RangesKt.coerceIn(r100, 0, this.f402163d.f402186c.size() - 1), false);
        return;
    }

    public final void setTagGap(Integer r100) {
        this.f402184y = r100;
        requestLayout();
    }

    public final void setTagText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f402183x = r100;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        this.f402161b.setVisibility(8);
        return;
    L11:
        this.f402161b.setVisibility(0);
        this.f402161b.setText(this.f402183x);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void setTextColor(int r100) {
        setNormalTextColor(r100);
    }

    public final void setTextSizePx(float r100) {
        this.f402168i = r100;
        this.f402167h = Math.max(r100, this.f402169j);
        this.f402163d.f401640a.a();
        requestLayout();
    }

    public final void setWheelTagText(CharSequence r100) {
        this.f402183x = r100;
    }

    public final void setEntries(String... r100) {
        Intrinsics.checkNotNullParameter(r100, "entries");
        k(ArraysKt.toList(r100), null);
    }

    public final void d(final int r110, boolean r111) {
        this.f402160a.a0();
        if (r111 == false) goto L18;
        this.f402174o = true;
        this.f402177r = r110;
        WheelLayoutManager r112 = this.f402162c;
        if (r112.f402155v != 0) goto L7;
    L14:
        int r100 = 0;
    L15:
        if (r100 == 0) goto L20;
        if (r100 == 0) goto L21;
        this.f402174o = true;
        this.f402160a.X(0, r100, new com.obric.oui.popover.b(), 400, false);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        if (r112.A() == 0) goto L14;
        if (r112.f402158y == false) goto L12;
        int r113 = RangesKt.coerceIn(r110, 0, r112.A() - 1);
    L13:
        r100 = MathKt.roundToInt((r113 * r112.f402155v) - r112.f402156w);
        goto L15
    L12:
        int r101 = r112.f402159z;
        r113 = RangesKt.coerceIn(r110, r101, RangesKt.coerceAtLeast((r112.A() - r112.f402159z) - 1, r101));
        goto L13
    L18:
        this.f402174o = true;
        this.f402160a.W(r110);
        post(new com.obric.oui.picker.reels.views.d(this, r110));
    }

    public final void j(List<String> r100, int r101) {
        if (r100 != null) goto L4;
        List<? extends CharSequence> r102 = null;
    L9:
        if (r102 != null) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        k(r102, Integer.valueOf(r101));
        return;
    L4:
        List<String> r103 = r100;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        r104.add((String) r105.next());
        goto L6
    L8:
        r102 = r104;
        goto L9
    }

    public final void k(List<? extends CharSequence> r100, Integer r101) {
        this.f402177r = -1;
        if (r101 != null) goto L5;
        Integer r102 = null;
    L10:
        if (r102 == null) goto L13;
        this.f402175p = r102.intValue();
    L13:
        boolean r103 = !Intrinsics.areEqual(this.f402163d.f402186c, r100);
        if (r103 == false) goto L16;
        this.f402160a.a0();
        b r104 = this.f402163d;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        r104.f402186c.clear();
        r104.f402186c.addAll(r100);
        r104.f401640a.a();
    L16:
        TextView r105 = new TextView(getContext());
        r105.setTextSize(22.0f);
        TextPaint r106 = r105.getPaint();
        this.f402165f = 0.0f;
        Iterator<? extends CharSequence> r107 = r100.iterator();
    L18:
        if (r107.hasNext() == false) goto L22;
        float r108 = r106.measureText(r107.next().toString());
        if (r108 <= this.f402165f) goto L18;
        this.f402165f = r108;
        goto L18
    L22:
        ViewGroup.LayoutParams r109 = this.f402161b.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L29;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
        int r111 = (int) (this.f402165f / 2.0f);
        Integer r112 = this.f402184y;
        if (r112 != null) goto L27;
        int r113 = 0;
    L28:
        r110.setMarginStart(r111 + (r113 * 2));
        this.f402161b.setLayoutParams(r109);
        goto L29
    L27:
        r113 = r112.intValue();
    L29:
        if (r102 != null) goto L31;
    L41:
        post(new f(this));
        return;
    L31:
        if ((!r100.isEmpty()) == false) goto L41;
        if (r103 == false) goto L40;
        int r114 = r102.intValue();
        int r115 = r100.size();
        int r116 = RangesKt.coerceIn(r114, 0, r115 - 1);
        if (this.f402182w == false) goto L36;
        int r117 = (r115 * 1000) / 2;
    L37:
        this.f402176q = r117 + r116;
        if (this.f402160a.getChildCount() <= 0) goto L41;
        c();
        goto L41
    L36:
        r117 = f();
        goto L37
    L40:
        l(r102.intValue(), false);
        goto L41
    L5:
        int r118 = r101.intValue();
        if (r100.isEmpty() == true) goto L9;
        r118 = RangesKt.coerceIn(r118, 0, r100.size() - 1);
    L9:
        r102 = Integer.valueOf(r118);
        goto L10
    }

    public final void l(int r110, boolean r111) {
        this.f402176q = -1;
        this.f402177r = -1;
        int r100 = this.f402163d.f402186c.size();
        if (r100 != 0) goto L6;
        this.f402175p = r110;
        return;
    L6:
        boolean r101 = false;
        int r112 = RangesKt.coerceIn(r110, 0, r100 - 1);
        this.f402175p = r112;
        if (this.f402182w == false) goto L30;
        int r102 = e();
        if (this.f402160a.getChildCount() <= 0) goto L29;
        if (r102 == (-1)) goto L29;
        int r103 = this.f402163d.a();
        int r104 = (r102 - (r102 % r100)) + r112;
        Ref.IntRef r113 = new Ref.IntRef();
        r113.element = r104;
        Ref.IntRef r105 = new Ref.IntRef();
        r105.element = Math.abs(r104 - r102);
        int r106 = r104 - r100;
        if (r106 < 0) goto L15;
        if (r106 >= r103) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L20;
        int r108 = Math.abs(r106 - r102);
        if (r108 >= r105.element) goto L20;
        r113.element = r106;
        r105.element = r108;
    L20:
        int r109 = r104 + r100;
        if (r109 < 0) goto L24;
        if (r109 >= r103) goto L24;
        r101 = true;
    L24:
        if (r101 == false) goto L28;
        int r114 = Math.abs(r109 - r102);
        if (r114 >= r105.element) goto L28;
        r113.element = r109;
        r105.element = r114;
    L28:
        int r115 = r113.element;
    L31:
        d(r115, r111);
        return;
    L15:
        r107 = false;
    L29:
        r115 = r112 + ((r100 * 1000) / 2);
        goto L31
    L30:
        r115 = r112 + f();
        goto L31
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        View.MeasureSpec.makeMeasureSpec((((int) (((this.f402164e / ((float) Math.tan(0.5235988f))) * 2.0f) + this.f402164e)) + getPaddingTop()) + getPaddingBottom(), 1073741824);
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = Math.max((int) (this.f402165f + this.f402170k), getMinimumWidth());
        if (r102 == Integer.MIN_VALUE) goto L6;
        if (r102 == 1073741824) goto L7;
        r103 = r104;
    L7:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), r101);
        return;
    L6:
        r103 = Math.min(r104, r103);
        goto L7
    }

    public WheelView(Context r110, AttributeSet r111, int r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r210);
        WheelLayoutManager r100 = new WheelLayoutManager(r110);
        this.f402162c = r100;
        b r101 = new b(this);
        this.f402163d = r101;
        this.f402164e = pla.d.m(this, 50.0f);
        this.f402166g = 5;
        this.f402167h = pla.d.p(this, 22.0f);
        this.f402168i = pla.d.p(this, 22.0f);
        this.f402169j = pla.d.p(this, 22.0f);
        this.f402171l = -1;
        this.f402172m = -1;
        this.f402176q = -1;
        this.f402177r = -1;
        this.f402181v = pla.d.n(this, 8);
        this.f402185z = ContextCompat.getColor(r110, com.larus.nova.R.color.oui_accent_6_bg);
        this.A = ContextCompat.getColor(r110, com.larus.nova.R.color.oui_basic_text_1);
        d r102 = new d(this);
        this.f402170k = pla.d.n(this, 28);
        FrameLayout.inflate(r110, com.larus.nova.R.layout.o_wheel_view, this);
        setTagGap(Integer.valueOf(pla.d.n(this, 2)));
        RecyclerView r103 = (RecyclerView) findViewById(com.larus.nova.R.id.recycler);
        this.f402160a = r103;
        this.f402161b = (TextView) findViewById(com.larus.nova.R.id.tv_tag);
        r103.setLayoutManager(r100);
        r100.f402159z = f();
        r103.setAdapter(r101);
        r103.setClipToPadding(false);
        r103.setOverScrollMode(0);
        r103.j(r102);
        r103.getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
        TypedArray r104 = getContext().obtainStyledAttributes(r111, new int[]{com.larus.nova.R.attr.oui_wheelCyclic, com.larus.nova.R.attr.oui_wheelEntries, com.larus.nova.R.attr.oui_wheelHighlightColor, com.larus.nova.R.attr.oui_wheelHighlightConorRadius, com.larus.nova.R.attr.oui_wheelItemCount, com.larus.nova.R.attr.oui_wheelItemHeight, com.larus.nova.R.attr.oui_wheelItemWidth, com.larus.nova.R.attr.oui_wheelSelectedTextColor, com.larus.nova.R.attr.oui_wheelSelectedTextSize, com.larus.nova.R.attr.oui_wheelShowDivider, com.larus.nova.R.attr.oui_wheelStartIndex, com.larus.nova.R.attr.oui_wheelTextColor, com.larus.nova.R.attr.oui_wheelTextSize});
        boolean r105 = r104.getBoolean(0, false);
        int r106 = r104.getInt(10, 0);
        int r112 = r104.getInt(4, 5);
        int r107 = r104.getDimensionPixelOffset(5, pla.d.n(this, 50));
        int r113 = r104.getDimensionPixelSize(12, pla.d.m(this, 22.0f));
        int r114 = r104.getDimensionPixelSize(12, pla.d.m(this, 14.0f));
        int r108 = r104.getColor(11, ContextCompat.getColor(getContext(), com.larus.nova.R.color.oui_basic_text_1));
        int r109 = r104.getColor(7, ContextCompat.getColor(getContext(), com.larus.nova.R.color.oui_accent_6_bg));
        int r115 = r104.getDimensionPixelSize(8, pla.d.m(this, 22.0f));
        CharSequence[] r116 = r104.getTextArray(1);
        if (r116 != null) goto L5;
        ArrayList r117 = null;
    L8:
        r104.recycle();
        setCyclic(r105);
        this.f402175p = r106;
        this.f402166g = r112;
        this.f402164e = r107;
        float r118 = r113;
        this.f402168i = r118;
        float r119 = r115;
        this.f402169j = r119;
        this.f402167h = RangesKt.coerceAtLeast(r119, r118);
        setSelectedTextColor(r109);
        this.f402161b.setTextSize(0, r114);
        this.f402161b.setTextColor(r108);
        if (r117 == null) goto L11;
        k(r117, null);
        return;
    L11:
        h();
        return;
    L5:
        r117 = new ArrayList(r116.length);
        int r120 = r116.length;
        int r121 = 0;
    L6:
        if (r121 >= r120) goto L8;
        r117.add(r116[r121].toString());
        r121 = r121 + 1;
        goto L6
    }

    public /* synthetic */ WheelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
