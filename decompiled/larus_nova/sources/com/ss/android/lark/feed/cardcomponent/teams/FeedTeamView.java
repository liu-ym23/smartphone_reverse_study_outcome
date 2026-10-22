package com.ss.android.lark.feed.cardcomponent.teams;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.collection.SparseArrayCompat;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.FeedTeamInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0003FGHB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170*J\b\u0010+\u001a\u00020(H\u0002J\u0018\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0014J(\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0018\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0002J6\u00107\u001a\u00020(2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0*2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020 H\u0002J(\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020\u001a2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020 H\u0002J.\u0010?\u001a\u00020(2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0*2\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020 H\u0002J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0014J\u001c\u0010C\u001a\u00020(*\u00020$2\u0006\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020 H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0016j\b\u0012\u0004\u0012\u00020\u001a`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u0016j\b\u0012\u0004\u0012\u00020\"`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/teams/FeedTeamView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconSize", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "iconDrawable$delegate", "Lkotlin/Lazy;", "nameStartMargin", "namePaint", "Landroid/text/TextPaint;", "separatorPaint", "nameList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/biz/im/api/FeedTeamInfo;", "Lkotlin/collections/ArrayList;", "nameItems", "Lcom/ss/android/lark/feed/cardcomponent/teams/FeedTeamView$NameItem;", "allNameWidth", "separatorWidth", "separatorHeight", "separatorSpace", "separatorLeft", "", "textElements", "Lcom/ss/android/lark/feed/cardcomponent/teams/FeedTeamView$TextElement;", "separatorPath", "Landroid/graphics/Path;", "minNameWidth", "ellipsisWidth", "setTeams", "", "list", "", "refreshItems", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "calcElements", "width", "height", "addBreakItems", "items", "nameSpace", "textStartX", "textY", "separatorTop", "addSingleItem", MapController.ITEM_LAYER_TAG, "addFullyItems", "onDraw", "canvas", "Landroid/graphics/Canvas;", "addSeparator", "left", "top", "NameItem", "TextElement", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedTeamView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f420960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f420961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f420962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextPaint f420963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextPaint f420964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<FeedTeamInfo> f420965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<b> f420966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f420967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f420968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f420969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f420970k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f420971l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<c> f420972m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Path f420973n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f420974o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f420975p;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f420976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f420977b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f420976a, r101.f420976a) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.f420977b, r101.f420977b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f420976a.hashCode() * 31) + Float.floatToIntBits(this.f420977b);
        }

        public final String toString() {
            return "NameItem(text=" + this.f420976a + ", width=" + this.f420977b + ')';
        }

        public b(String r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f420976a = r100;
            this.f420977b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f420978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f420979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f420980c;

        public c(String r100, float r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f420978a = r100;
            this.f420979b = r101;
            this.f420980c = r102;
        }
    }

    static {
    }

    public FeedTeamView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FeedTeamView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Drawable getIconDrawable() {
        return (Drawable) this.f420961b.getValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        getIconDrawable().draw(r100);
        Iterator<T> r101 = this.f420972m.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        c r102 = (c) r101.next();
        r100.drawText(r102.f420978a, r102.f420979b, r102.f420980c, this.f420963d);
        goto L4
    L7:
        if (this.f420973n.isEmpty() == true) goto L11;
        r100.drawPath(this.f420973n, this.f420964e);
        return;
    }

    public final void setTeams(List<FeedTeamInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (Intrinsics.areEqual(this.f420965f, r100) == false) goto L5;
        return;
    L5:
        this.f420965f.clear();
        this.f420965f.addAll(r100);
        this.f420966g.clear();
        Iterator<FeedTeamInfo> r101 = this.f420965f.iterator();
        float r102 = 0.0f;
        int r103 = 0;
    L7:
        if (r101.hasNext() == false) goto L13;
        FeedTeamInfo r104 = r101.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        String r106 = r104.teamName;
        float r107 = this.f420963d.measureText(r106);
        r102 = r102 + r107;
        this.f420966g.add(new b(r106, r107));
        r103 = r105;
        goto L7
    L13:
        if (this.f420966g.size() <= 1) goto L15;
        r102 = r102 + ((this.f420966g.size() - 1) * this.f420970k);
    L15:
        this.f420967h = MathKt.roundToInt(r102);
        int r108 = getWidth();
        int r109 = getHeight();
        if (r108 <= 0) goto L19;
        if (r109 <= 0) goto L19;
        b(r108, r109);
    L19:
        requestLayout();
    }

    public final void b(int r210, int r211) {
        this.f420972m.clear();
        this.f420973n.reset();
        int r100 = getPaddingLeft();
        int r101 = 0;
        int r102 = RangesKt.coerceAtLeast((int) ((r211 - this.f420960a) / 2.0f), 0);
        int r103 = this.f420960a + r100;
        getIconDrawable().setBounds(r100, r102, r103, this.f420960a + r102);
        if (this.f420966g.isEmpty() == false) goto L5;
        return;
    L5:
        Paint.FontMetrics r104 = this.f420963d.getFontMetrics();
        float r105 = r104.bottom;
        float r106 = r104.top;
        float r107 = ((r211 - (r105 - r106)) / 2.0f) - r106;
        float r108 = r103 + this.f420962c;
        float r109 = (r210 - getPaddingRight()) - r108;
        if (this.f420966g.size() != 1) goto L13;
        b r110 = (b) CollectionsKt.first(this.f420966g);
        if (r110.f420977b <= r109) goto L10;
        String r111 = r110.f420976a.substring(0, this.f420963d.breakText(r110.f420976a, true, r109 - this.f420975p, null)) + 8230;
    L11:
        this.f420972m.add(new c(r111, r108, r107));
        return;
    L10:
        r111 = r110.f420976a;
        goto L11
    L13:
        float r112 = (r211 - this.f420969j) / 2.0f;
        if (this.f420967h > r109) goto L27;
        ArrayList<b> r113 = this.f420966g;
        Iterator<T> r114 = r113.iterator();
    L17:
        if (r114.hasNext() == false) goto L26;
        Object r115 = r114.next();
        int r116 = r101 + 1;
        if (r101 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        b r117 = (b) r115;
        this.f420972m.add(new c(r117.f420976a, r108, r107));
        if (r101 == CollectionsKt.getLastIndex(r113)) goto L25;
        float r118 = r108 + r117.f420977b;
        a(this.f420973n, this.f420971l + r118, r112);
        r108 = r118 + this.f420970k;
    L25:
        r101 = r116;
        goto L17
    L26:
        return;
    L27:
        ArrayList<b> r119 = this.f420966g;
        ArrayList r120 = new ArrayList();
        float r121 = this.f420970k + this.f420975p;
        Iterator<T> r122 = r119.iterator();
        float r123 = 0.0f;
        float r124 = r109;
        int r125 = 0;
        float r126 = 0.0f;
        int r127 = 0;
    L29:
        if (r122.hasNext() == false) goto L46;
        Object r128 = r122.next();
        int r129 = r127 + 1;
        if (r127 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        b r130 = (b) r128;
        float r131 = r123 + RangesKt.coerceAtMost(r130.f420977b, this.f420974o);
        if (r131 > r109) goto L46;
        if (r127 != CollectionsKt.getLastIndex(r119)) goto L39;
    L41:
        float r132 = r130.f420977b;
        if (r132 <= this.f420974o) goto L44;
        r120.add(Integer.valueOf(r127));
        r126 = r126 + r130.f420977b;
    L45:
        r123 = r131 + this.f420970k;
        r125 = r127;
        r127 = r129;
        goto L29
    L44:
        r124 = r124 - r132;
        goto L45
    L39:
        if ((r131 + r121) < r109) goto L41;
    L46:
        float r133 = r124 - (this.f420970k * r125);
        if (r125 >= CollectionsKt.getLastIndex(r119)) goto L50;
        r133 = r133 - r121;
    L50:
        if (r120.size() <= 1) goto L52;
        CollectionsKt.sortWith(r120, new com.ss.android.lark.feed.cardcomponent.teams.a(r119));
    L52:
        SparseArrayCompat r134 = new SparseArrayCompat(r120.size());
        Iterator r135 = r120.iterator();
        int r136 = 0;
    L54:
        if (r135.hasNext() == false) goto L66;
        Object r137 = r135.next();
        int r138 = r136 + 1;
        if (r136 >= 0) goto L58;
        CollectionsKt.throwIndexOverflow();
    L58:
        int r139 = ((Number) r137).intValue();
        b r140 = (b) ListProtector.get(r119, r139);
        float r141 = RangesKt.coerceAtLeast((r140.f420977b / r126) * r133, this.f420974o);
        float r142 = r140.f420977b;
        if (r141 >= r142) goto L63;
        String r143 = r140.f420976a.substring(0, this.f420963d.breakText(r140.f420976a, true, r141 - this.f420975p, null)) + 8230;
        r142 = this.f420963d.measureText(r143);
        Intrinsics.checkNotNullParameter(r143, "text");
        r134.put(r139, new b(r143, r142));
    L63:
        if (r136 == CollectionsKt.getLastIndex(r120)) goto L67;
        r126 = r126 - r140.f420977b;
        r133 = r133 - r142;
        r135 = r135;
        r136 = r138;
        r108 = r108;
    L67:
        Iterator<T> r144 = r119.iterator();
        float r145 = r108;
        int r146 = 0;
    L69:
        if (r144.hasNext() == false) goto L93;
        Object r147 = r144.next();
        int r148 = r146 + 1;
        if (r146 >= 0) goto L73;
        CollectionsKt.throwIndexOverflow();
    L73:
        b r149 = (b) r134.get(r146, (b) r147);
        this.f420972m.add(new c(r149.f420976a, r145, r107));
        float r150 = r145 + r149.f420977b;
        if (r146 == r125) goto L76;
        a(this.f420973n, this.f420971l + r150, r112);
        r145 = r150 + this.f420970k;
        r146 = r148;
        goto L69
    L76:
        if (r146 >= CollectionsKt.getLastIndex(r119)) goto L79;
        a(this.f420973n, this.f420971l + r150, r112);
        this.f420972m.add(new c("…", r150 + this.f420970k, r107));
        return;
    L79:
        return;
    L93:
        return;
    L66:
        r108 = r108;
        goto L67
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f420967h;
        if (View.MeasureSpec.getMode(r100) != 1073741824) goto L6;
        r102 = View.MeasureSpec.getSize(r100);
    L6:
        if (View.MeasureSpec.getMode(r101) != 1073741824) goto L9;
        int r103 = View.MeasureSpec.getSize(r101);
    L12:
        setMeasuredDimension(r102, r103);
        return;
    L9:
        if (this.f420966g.isEmpty() == false) goto L11;
        r103 = 0;
        goto L12
    L11:
        Paint.FontMetrics r104 = this.f420963d.getFontMetrics();
        r103 = (MathKt.roundToInt(r104.bottom - r104.top) + getPaddingTop()) + getPaddingBottom();
        goto L12
    }

    public FeedTeamView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f420960a = zz7.b.g(r100, 12);
        this.f420961b = LazyKt.lazy(new FeedTeamView$iconDrawable$2(r100));
        this.f420962c = zz7.b.g(r100, 8);
        TextPaint r103 = new TextPaint(1);
        r103.setColor(UDColorUtils.getColor(r100, R.color.text_title));
        r103.setTextSize(zz7.b.h(r100, 14));
        w08.a.a(r103, r100, 0);
        this.f420963d = r103;
        TextPaint r104 = new TextPaint(1);
        r104.setColor(UDColorUtils.getColor(r100, R.color.line_divider_default));
        this.f420964e = r104;
        this.f420965f = new ArrayList();
        this.f420966g = new ArrayList();
        int r105 = zz7.b.g(r100, 1);
        this.f420968i = r105;
        this.f420969j = zz7.b.g(r100, 8);
        int r106 = zz7.b.g(r100, 17);
        this.f420970k = r106;
        this.f420971l = (r106 - r105) / 2.0f;
        this.f420972m = new ArrayList();
        this.f420973n = new Path();
        this.f420974o = zz7.b.h(r100, 56);
        this.f420975p = r103.measureText("…");
    }

    public final void a(Path r100, float r101, float r110) {
        r100.addRect(r101, r110, r101 + this.f420968i, r110 + this.f420969j, Path.Direction.CCW);
    }

    public /* synthetic */ FeedTeamView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        b(r100, r101);
    }
}
