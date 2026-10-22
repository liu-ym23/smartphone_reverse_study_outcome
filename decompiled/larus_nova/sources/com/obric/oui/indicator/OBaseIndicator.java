package com.obric.oui.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0004h\f\u0013iB'\b\u0007\u0012\u0006\u0010b\u001a\u00020a\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010c\u0012\b\b\u0002\u0010e\u001a\u00020\u0002¢\u0006\u0004\bf\u0010gJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007R\"\u0010\u0012\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R*\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR*\u0010*\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010.\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R*\u00102\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010%\u001a\u0004\b0\u0010'\"\u0004\b1\u0010)R*\u00106\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR*\u0010:\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010%\u001a\u0004\b8\u0010'\"\u0004\b9\u0010)R*\u0010>\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010%\u001a\u0004\b<\u0010'\"\u0004\b=\u0010)R*\u0010B\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\u001a\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\u001eR\"\u0010F\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010\r\u001a\u0004\bD\u0010\u000f\"\u0004\bE\u0010\u0011R*\u0010J\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010%\u001a\u0004\bH\u0010'\"\u0004\bI\u0010)R*\u0010N\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u001a\u001a\u0004\bL\u0010\u001c\"\u0004\bM\u0010\u001eR.\u0010V\u001a\u0004\u0018\u00010O2\b\u0010\u0018\u001a\u0004\u0018\u00010O8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR(\u0010\\\u001a\u0004\u0018\u00010W2\b\u0010\u0018\u001a\u0004\u0018\u00010W8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8&X¦\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_¨\u0006j"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator;", "Landroid/widget/FrameLayout;", "", "pageCount", "", "setManualPageCount", "currentItem", "setManualCurrentItem", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setViewPager", "", "b", "Z", "getInitialized", "()Z", "setInitialized", "(Z)V", "initialized", "c", "getPendingRefreshParentLayout", "setPendingRefreshParentLayout", "pendingRefreshParentLayout", "", "value", "h", FaceService.girlLabel, "getDotsWidth", "()F", "setDotsWidth", "(F)V", "dotsWidth", RXScreenCaptureService.KEY_INDEX, "getDotsHeight", "setDotsHeight", "dotsHeight", ce.f26395j, "I", "getLayoutHeight", "()I", "setLayoutHeight", "(I)V", "layoutHeight", ce.f26396k, "getVerticalSidePadding", "setVerticalSidePadding", "verticalSidePadding", "l", "getSidePadding", "setSidePadding", "sidePadding", "m", "getDotsSpacing", "setDotsSpacing", "dotsSpacing", OfficeSDKRequestTag.KEY_NEW_USER, "getType", "setType", "type", "o", "getDotsColor", "setDotsColor", "dotsColor", "p", "getDotsCornerRadius", "setDotsCornerRadius", "dotsCornerRadius", "q", "getDotsClickable", "setDotsClickable", "dotsClickable", "r", "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeColor", "s", "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsStrokeWidth", "Lcom/obric/oui/indicator/OBaseIndicator$c;", "t", "Lcom/obric/oui/indicator/OBaseIndicator$c;", "getPager", "()Lcom/obric/oui/indicator/OBaseIndicator$c;", "setPager", "(Lcom/obric/oui/indicator/OBaseIndicator$c;)V", "pager", "Lcom/obric/oui/indicator/OBaseIndicator$d;", "u", "Lcom/obric/oui/indicator/OBaseIndicator$d;", "setPagerDataSetObserver", "(Lcom/obric/oui/indicator/OBaseIndicator$d;)V", "pagerDataSetObserver", "Lcom/obric/oui/indicator/OBaseIndicator$a;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$a;", "custom", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class OBaseIndicator extends FrameLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f401177v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f401178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f401179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f401180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f401181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f401182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f401183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f401184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f401185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f401186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f401187j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f401188k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f401189l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f401190m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f401191n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f401192o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f401193p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f401194q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f401195r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f401196s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f401197t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public d f401198u;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f401199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f401200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f401201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f401202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f401203e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f401204f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f401205g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f401206h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f401207i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f401208j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f401209k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f401210l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f401211m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f401212n;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(Float.valueOf(this.f401199a), Float.valueOf(r101.f401199a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f401200b), Float.valueOf(r101.f401200b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f401201c), Float.valueOf(r101.f401201c)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f401202d, r101.f401202d) == true) goto L21;
            return false;
        L21:
            if (this.f401203e == r101.f401203e) goto L24;
            return false;
        L24:
            if (this.f401204f == r101.f401204f) goto L27;
            return false;
        L27:
            if (this.f401205g == r101.f401205g) goto L30;
            return false;
        L30:
            if (this.f401206h == r101.f401206h) goto L33;
            return false;
        L33:
            if (this.f401207i == r101.f401207i) goto L36;
            return false;
        L36:
            if (this.f401208j == r101.f401208j) goto L39;
            return false;
        L39:
            if (this.f401209k == r101.f401209k) goto L42;
            return false;
        L42:
            if (this.f401210l == r101.f401210l) goto L45;
            return false;
        L45:
            if (this.f401211m == r101.f401211m) goto L48;
            return false;
        L48:
            if (this.f401212n == r101.f401212n) goto L50;
            return false;
        L50:
            return true;
        }

        public final int hashCode() {
            return (((((((((((((((((((((((((Float.floatToIntBits(this.f401199a) * 31) + Float.floatToIntBits(this.f401200b)) * 31) + Float.floatToIntBits(this.f401201c)) * 31) + Arrays.hashCode(this.f401202d)) * 31) + this.f401203e) * 31) + this.f401204f) * 31) + this.f401205g) * 31) + this.f401206h) * 31) + this.f401207i) * 31) + this.f401208j) * 31) + this.f401209k) * 31) + this.f401210l) * 31) + this.f401211m) * 31) + this.f401212n;
        }

        public final String toString() {
            return "CustomDot(defaultWidth=" + this.f401199a + ", defaultHeight=" + this.f401200b + ", defaultSpacing=" + this.f401201c + ", styleableId=" + Arrays.toString(this.f401202d) + ", typeId=" + this.f401203e + ", layoutHeightId=" + this.f401204f + ", dotsWidthId=" + this.f401205g + ", dotsHeightId=" + this.f401206h + ", dotsSpacingId=" + this.f401207i + ", dotsColorId=" + this.f401208j + ", dotsCornerRadiusId=" + this.f401209k + ", dotsClickableId=" + this.f401210l + ", dotsStrokeColorId=" + this.f401211m + ", dotsStrokeWidthId=" + this.f401212n + ')';
        }

        public a(float r100, float r101, float r102, int[] r103) {
            Intrinsics.checkNotNullParameter(r103, "styleableId");
            this.f401199a = r100;
            this.f401200b = r101;
            this.f401201c = r102;
            this.f401202d = r103;
            this.f401203e = 13;
            this.f401204f = 9;
            this.f401205g = 7;
            this.f401206h = 3;
            this.f401207i = 4;
            this.f401208j = 1;
            this.f401209k = 2;
            this.f401210l = 0;
            this.f401211m = 5;
            this.f401212n = 6;
        }
    }

    public final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f401213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f401215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OBaseIndicator f401216d;

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final void c() {
            this.f401213a = null;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final boolean b() {
            if (this.f401214b <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final int getCount() {
            return this.f401214b;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final int getCurrentItem() {
            return this.f401215c;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final void a(int r100) {
            if (e(r100) == true) goto L5;
            return;
        L5:
            l r101 = this.f401213a;
            if (r101 != null) goto L8;
        L10:
            this.f401216d.h();
            return;
        L8:
            if (b() == false) goto L10;
            r101.b(this.f401215c, 0.0f);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final void d(l r100) {
            Intrinsics.checkNotNullParameter(r100, "onPageChangeListenerHelper");
            this.f401213a = r100;
        }

        public final boolean e(int r100) {
            int r101 = this.f401214b;
            if (r101 > 0) goto L9;
            if (r100 == 0) goto L9;
            String r102 = "ManualPager requires currentItem=0 when pageCount=" + this.f401214b + ", currentItem=" + r100;
            wma.b.h(this.f401216d.f401178a, r102);
            throw new IllegalArgumentException(r102);
        L9:
            if (r101 <= 0) goto L19;
            if (r100 < 0) goto L13;
            if (r100 >= r101) goto L13;
            boolean r103 = true;
        L14:
            if (r103 == true) goto L19;
            String r104 = "ManualPager requires currentItem in 0 until pageCount, currentItem=" + r100 + " pageCount=" + this.f401214b;
            wma.b.h(this.f401216d.f401178a, r104);
            throw new IllegalArgumentException(r104);
        L13:
            r103 = false;
        L19:
            if (this.f401215c != r100) goto L21;
            return false;
        L21:
            this.f401215c = r100;
            return true;
        }

        public b(OBaseIndicator r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            this.f401216d = r100;
            if (r101 <= 0) goto L12;
            if (r102 < 0) goto L7;
            if (r102 >= r101) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == true) goto L12;
            String r104 = "setManualPager requires currentItem in 0 until pageCount, currentItem=" + r102 + " pageCount=" + r101;
            wma.b.h(r100.f401178a, r104);
            throw new IllegalArgumentException(r104);
        L7:
            r103 = false;
        L12:
            this.f401214b = r101;
            this.f401215c = r102;
        }
    }

    public interface c {
        void a(int r100);

        boolean b();

        void c();

        void d(l r100);

        int getCount();

        int getCurrentItem();
    }

    public interface d {
        Function1<d, Unit> a();
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$2, reason: invalid class name */
    public final class AnonymousClass2 extends DataSetObserver implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBaseIndicator f401217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPager f401218b;

        @Override // com.obric.oui.indicator.OBaseIndicator.d
        public final Function1<d, Unit> a() {
            final ViewPager r100 = this.f401218b;
            return new OBaseIndicator$setViewPager$2$releaseAction$1(r100);
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            super.onChanged();
            this.f401217a.h();
        }

        public AnonymousClass2(OBaseIndicator r100, ViewPager r101) {
            this.f401217a = r100;
            this.f401218b = r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$3, reason: invalid class name */
    public final class AnonymousClass3 implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OBaseIndicator$setViewPager$3$addOnPageChangeListener$1 f401219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPager f401220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OBaseIndicator f401221c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Integer> f401222d;

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final boolean b() {
            ViewPager r100 = this.f401220b;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            PagerAdapter r101 = r100.getAdapter();
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            if (r102 <= 0) goto L9;
            return true;
        L9:
            return false;
        L5:
            r102 = r101.getCount();
            goto L6
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final void c() {
            OBaseIndicator$setViewPager$3$addOnPageChangeListener$1 r100 = this.f401219a;
            if (r100 == null) goto L7;
            this.f401220b.removeOnPageChangeListener(r100);
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final int getCount() {
            return this.f401222d.invoke().intValue();
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final int getCurrentItem() {
            return OBaseIndicator.a(this.f401221c, this.f401220b.getCurrentItem(), getCount());
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final void a(int r100) {
            this.f401220b.setCurrentItem(r100, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.viewpager.widget.ViewPager$OnPageChangeListener, com.obric.oui.indicator.OBaseIndicator$setViewPager$3$addOnPageChangeListener$1, java.lang.Object] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public final void d(final l r100) {
            Intrinsics.checkNotNullParameter(r100, "onPageChangeListenerHelper");
            final OBaseIndicator r101 = this.f401221c;
            ?? r102 = new OBaseIndicator$setViewPager$3$addOnPageChangeListener$1(r100, r101, this);
            this.f401219a = r102;
            ViewPager r103 = this.f401220b;
            Intrinsics.checkNotNull(r102);
            r103.addOnPageChangeListener(r102);
        }

        public AnonymousClass3(ViewPager r100, OBaseIndicator r101, Function0<Integer> r102) {
            this.f401220b = r100;
            this.f401221c = r101;
            this.f401222d = r102;
        }
    }

    public OBaseIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OBaseIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract j b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract a getCustom();

    public abstract void k();

    public final int g() {
        c r100 = this.f401197t;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getCount();
    }

    public final void h() {
        if (this.f401197t != null) goto L6;
        return;
    L6:
        if (this.f401179b == true) goto L9;
        this.f401181d = true;
        return;
    L9:
        post(new h(this));
    }

    public final void i() {
        if (this.f401179b == true) goto L6;
        this.f401182e = true;
        return;
    L6:
        this.f401182e = false;
        c();
    }

    public final void j() {
        if (this.f401179b == true) goto L6;
        this.f401184g = true;
        return;
    L6:
        this.f401184g = false;
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        post(new g(this));
    }

    public final boolean getDotsClickable() {
        return this.f401194q;
    }

    public final int getDotsColor() {
        return this.f401192o;
    }

    public final float getDotsCornerRadius() {
        return this.f401193p;
    }

    public final float getDotsHeight() {
        return this.f401186i;
    }

    public final float getDotsSpacing() {
        return this.f401190m;
    }

    public final int getDotsStrokeColor() {
        return this.f401195r;
    }

    public final float getDotsStrokeWidth() {
        return this.f401196s;
    }

    public final float getDotsWidth() {
        return this.f401185h;
    }

    public final boolean getInitialized() {
        return this.f401179b;
    }

    public final int getLayoutHeight() {
        return this.f401187j;
    }

    public final c getPager() {
        return this.f401197t;
    }

    public final boolean getPendingRefreshParentLayout() {
        return this.f401180c;
    }

    public final int getSidePadding() {
        return this.f401189l;
    }

    public final int getType() {
        return this.f401191n;
    }

    public final int getVerticalSidePadding() {
        return this.f401188k;
    }

    private final void setPagerDataSetObserver(d r100) {
        d r101 = this.f401198u;
        if (r101 == null) goto L9;
        Function1<d, Unit> r102 = r101.a();
        if (r102 == null) goto L9;
        d r103 = this.f401198u;
        Intrinsics.checkNotNull(r103);
        r102.invoke(r103);
    L9:
        this.f401198u = r100;
    }

    public final void setDotsClickable(boolean r100) {
        this.f401194q = r100;
    }

    public final void setDotsColor(int r100) {
        if (this.f401191n == 1) goto L5;
        this.f401192o = r100;
        i();
        return;
    L5:
        this.f401192o = 872415231;
        i();
    }

    public final void setDotsCornerRadius(float r100) {
        if (this.f401193p != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f401193p = r100;
        i();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setDotsHeight(float r100) {
        if (this.f401186i != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f401186i = r100;
        j();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setDotsSpacing(float r100) {
        if (this.f401190m != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L12;
        this.f401190m = r100;
        if (this.f401179b == true) goto L10;
        this.f401183f = true;
        return;
    L10:
        this.f401183f = false;
        e();
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setDotsStrokeColor(int r100) {
        if (this.f401195r == r100) goto L6;
        this.f401195r = r100;
        i();
        return;
    }

    public final void setDotsStrokeWidth(float r100) {
        if (this.f401196s != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f401196s = r100;
        i();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setDotsWidth(float r100) {
        if (this.f401185h != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f401185h = r100;
        j();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setInitialized(boolean r100) {
        this.f401179b = r100;
    }

    public final void setLayoutHeight(int r100) {
        if (this.f401187j == r100) goto L6;
        this.f401187j = r100;
        k();
        return;
    }

    public final void setManualCurrentItem(int r100) {
        c r101 = this.f401197t;
        if ((r101 instanceof b) == false) goto L5;
        b r102 = (b) r101;
    L6:
        if (r102 != null) goto L8;
        wma.b.h(this.f401178a, "setManualCurrentItem requires setManualPager before manual updates");
        throw new IllegalStateException("setManualCurrentItem requires setManualPager before manual updates");
    L8:
        if (r102.e(r100) == false) goto L18;
        l r103 = r102.f401213a;
        if (r103 != null) goto L12;
    L14:
        r102.f401216d.h();
        return;
    L12:
        if (r102.b() == false) goto L14;
        r103.b(r102.f401215c, 0.0f);
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setManualPageCount(int r100) {
        c r101 = this.f401197t;
        if ((r101 instanceof b) == false) goto L5;
        b r102 = (b) r101;
    L6:
        if (r102 == null) goto L34;
        if (r100 < 0) goto L32;
        if (r100 <= 0) goto L10;
    L14:
        boolean r103 = false;
        if (r100 <= 0) goto L26;
        int r104 = r102.f401215c;
        if (r104 < 0) goto L20;
        if (r104 >= r100) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == true) goto L26;
        String r106 = "setManualPageCount requires currentItem in 0 until pageCount, currentItem=" + r102.f401215c + " pageCount=" + r100;
        wma.b.h(r102.f401216d.f401178a, r106);
        throw new IllegalArgumentException(r106);
    L20:
        r105 = false;
    L26:
        if (r102.f401214b == r100) goto L29;
        r102.f401214b = r100;
        r103 = true;
    L29:
        if (r103 == false) goto L36;
        h();
        return;
    L36:
        return;
    L10:
        if (r102.f401215c == 0) goto L14;
        String r107 = "setManualPageCount requires currentItem=0 when pageCount=" + r100 + ", currentItem=" + r102.f401215c;
        wma.b.h(r102.f401216d.f401178a, r107);
        throw new IllegalArgumentException(r107);
    L32:
        String r108 = Intrinsics.stringPlus("setManualPageCount requires pageCount >= 0, pageCount=", Integer.valueOf(r100));
        wma.b.h(r102.f401216d.f401178a, r108);
        throw new IllegalArgumentException(r108);
    L34:
        wma.b.h(this.f401178a, "setManualPageCount requires setManualPager before manual updates");
        throw new IllegalStateException("setManualPageCount requires setManualPager before manual updates");
    L5:
        r102 = null;
        goto L6
    }

    public final void setManualPager(int r100) {
        setPagerDataSetObserver(null);
        setPager(new b(this, r100, 0));
        h();
    }

    public final void setPager(c r100) {
        c r101 = this.f401197t;
        if (r101 == null) goto L6;
        r101.c();
    L6:
        this.f401197t = r100;
    }

    public final void setPendingRefreshParentLayout(boolean r100) {
        this.f401180c = r100;
    }

    public final void setSidePadding(int r100) {
        if (this.f401189l == r100) goto L6;
        this.f401189l = r100;
        k();
        return;
    }

    public final void setType(int r100) {
        if (this.f401191n == r100) goto L6;
        this.f401191n = r100;
        k();
        i();
        return;
    }

    public final void setVerticalSidePadding(int r100) {
        if (this.f401188k == r100) goto L6;
        this.f401188k = r100;
        k();
        return;
    }

    @Deprecated(message = "需要 pageCount, 否则搭配banner的无限横划时可能出错", replaceWith = @ReplaceWith(expression = "setViewPager(ViewPager, Int) or setViewPager(ViewPager, () -> Int)", imports = {}))
    public final void setViewPager(ViewPager r100) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        PagerAdapter r101 = r100.getAdapter();
        if (r101 != null) goto L5;
        final int r102 = 1;
    L6:
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        Function0<Integer> r103 = new AnonymousClass1(r102);
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        Intrinsics.checkNotNullParameter(r103, "pageCount");
        if (r100.getAdapter() == null) goto L15;
        setPagerDataSetObserver(new AnonymousClass2(this, r100));
        PagerAdapter r104 = r100.getAdapter();
        Intrinsics.checkNotNull(r104);
        Object r105 = this.f401198u;
        if (r105 == null) goto L13;
        r104.registerDataSetObserver((DataSetObserver) r105);
        setPager(new AnonymousClass3(r100, this, r103));
        h();
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.database.DataSetObserver");
    L15:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    L5:
        r102 = r101.getCount();
        goto L6
    }

    public final void l(ViewPager2 r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        Function0<Integer> r102 = new OBaseIndicator$setViewPager2$1(r101);
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        Intrinsics.checkNotNullParameter(r102, "pageCount");
        if (r100.getAdapter() == null) goto L11;
        OCarouselIndicator r103 = (OCarouselIndicator) this;
        setPagerDataSetObserver(new OBaseIndicator$setViewPager2$2(r103, r100));
        RecyclerView.Adapter r104 = r100.getAdapter();
        Intrinsics.checkNotNull(r104);
        Object r105 = this.f401198u;
        if (r105 == null) goto L9;
        r104.registerAdapterDataObserver((RecyclerView.AdapterDataObserver) r105);
        setPager(new OBaseIndicator$setViewPager2$3(r100, r103, r102));
        h();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.AdapterDataObserver");
    L11:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    }

    public OBaseIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f401178a = "OBaseIndicator";
        this.f401185h = getCustom().f401199a;
        this.f401186i = getCustom().f401200b;
        this.f401187j = -2;
        this.f401188k = pla.d.n(this, 7);
        this.f401189l = pla.d.n(this, 10);
        this.f401190m = getCustom().f401201c;
        this.f401192o = ContextCompat.getColor(r100, R.color.oui_text_4);
        this.f401193p = this.f401186i / 2;
        this.f401194q = true;
        this.f401195r = ContextCompat.getColor(r100, R.color.Transparent);
        this.f401196s = pla.d.q(this, 0);
        if (r101 == null) goto L6;
        TypedArray r103 = r100.obtainStyledAttributes(r101, getCustom().f401202d);
        setType(r103.getInt(getCustom().f401203e, this.f401191n));
        setDotsWidth(r103.getDimension(getCustom().f401205g, this.f401185h));
        setDotsHeight(r103.getDimension(getCustom().f401206h, this.f401186i));
        setLayoutHeight(r103.getDimensionPixelSize(getCustom().f401204f, -2));
        setDotsSpacing(r103.getDimension(getCustom().f401207i, this.f401190m));
        setDotsColor(r103.getColor(getCustom().f401208j, this.f401192o));
        setDotsCornerRadius(r103.getDimension(getCustom().f401209k, this.f401193p));
        this.f401194q = r103.getBoolean(getCustom().f401210l, true);
        setDotsStrokeColor(r103.getColor(getCustom().f401211m, this.f401195r));
        setDotsStrokeWidth(r103.getDimension(getCustom().f401212n, this.f401196s));
        r103.recycle();
        return;
    }

    public static final int a(OBaseIndicator r100, int r101, int r102) {
        r100.getClass();
        if (r102 != 0) goto L13;
        wma.b.h(r100.f401178a, "mod num is 0");
        return r101;
    L13:
        return r101 % r102;
    L7:
        e = move-exception;
        if ((e instanceof ArithmeticException) == false) goto L11;
        wma.b.h(r100.f401178a, Intrinsics.stringPlus("不要乱除0呀 ", e.getMessage()));
        return r101;
    L11:
        wma.b.h(r100.f401178a, Intrinsics.stringPlus("抓住了一个Exception并ignore, ", e.getMessage()));
        return r101;
    }

    public /* synthetic */ OBaseIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
