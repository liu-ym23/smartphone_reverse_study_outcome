package com.bytedance.dux.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import em4.n;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0003\u0007EFJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\r\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R*\u0010\"\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u001b8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010&\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\b\u001a\u0004\b(\u0010\n\"\u0004\b)\u0010\fR*\u0010.\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u001b8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R*\u00102\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015R.\u0010:\u001a\u0004\u0018\u0001032\b\u0010\u000f\u001a\u0004\u0018\u0001038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010@\u001a\u0004\u0018\u00010;2\b\u0010\u000f\u001a\u0004\u0018\u00010;8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/bytedance/dux/indicator/DuxBaseIndicator;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "", "setViewPager", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getLimitLargeFontScale", "()Z", "setLimitLargeFontScale", "(Z)V", "limitLargeFontScale", "", "value", "d", FaceService.girlLabel, "getDotsSize", "()F", "setDotsSize", "(F)V", "dotsSize", "e", "getDotsSpacing", "setDotsSpacing", "dotsSpacing", "", "f", "I", "getDotsColor", "()I", "setDotsColor", "(I)V", "dotsColor", ce.f26391f, "getDotsCornerRadius", "setDotsCornerRadius", "dotsCornerRadius", "h", "getDotsClickable", "setDotsClickable", "dotsClickable", RXScreenCaptureService.KEY_INDEX, "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeColor", ce.f26395j, "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsStrokeWidth", "Lcom/bytedance/dux/indicator/DuxBaseIndicator$b;", ce.f26396k, "Lcom/bytedance/dux/indicator/DuxBaseIndicator$b;", "getPager", "()Lcom/bytedance/dux/indicator/DuxBaseIndicator$b;", "setPager", "(Lcom/bytedance/dux/indicator/DuxBaseIndicator$b;)V", "pager", "Lcom/bytedance/dux/indicator/DuxBaseIndicator$c;", "l", "Lcom/bytedance/dux/indicator/DuxBaseIndicator$c;", "setPagerDataSetObserver", "(Lcom/bytedance/dux/indicator/DuxBaseIndicator$c;)V", "pagerDataSetObserver", "Lcom/bytedance/dux/indicator/DuxBaseIndicator$a;", "getCustom", "()Lcom/bytedance/dux/indicator/DuxBaseIndicator$a;", "custom", "b", "c", "dux_release"}, k = 1, mv = {1, 7, 1})
public abstract class DuxBaseIndicator extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f205184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f205185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<View> f205186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f205187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f205188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f205189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f205190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f205191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f205192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f205193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f205194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f205195l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f205196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f205197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f205198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f205199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f205200e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f205201f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f205202g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f205203h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f205204i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f205205j;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Float.compare(this.f205196a, r101.f205196a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f205197b, r101.f205197b) == 0) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f205198c, r101.f205198c) == true) goto L18;
            return false;
        L18:
            if (this.f205199d == r101.f205199d) goto L21;
            return false;
        L21:
            if (this.f205200e == r101.f205200e) goto L24;
            return false;
        L24:
            if (this.f205201f == r101.f205201f) goto L27;
            return false;
        L27:
            if (this.f205202g == r101.f205202g) goto L30;
            return false;
        L30:
            if (this.f205203h == r101.f205203h) goto L33;
            return false;
        L33:
            if (this.f205204i == r101.f205204i) goto L36;
            return false;
        L36:
            if (this.f205205j == r101.f205205j) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            return (((((((((((((((((Float.floatToIntBits(this.f205196a) * 31) + Float.floatToIntBits(this.f205197b)) * 31) + Arrays.hashCode(this.f205198c)) * 31) + this.f205199d) * 31) + this.f205200e) * 31) + this.f205201f) * 31) + this.f205202g) * 31) + this.f205203h) * 31) + this.f205204i) * 31) + this.f205205j;
        }

        public final String toString() {
            return "CustomDot(defaultSize=" + this.f205196a + ", defaultSpacing=" + this.f205197b + ", styleableId=" + Arrays.toString(this.f205198c) + ", dotsSizeId=" + this.f205199d + ", dotsSpacingId=" + this.f205200e + ", dotsColorId=" + this.f205201f + ", dotsCornerRadiusId=" + this.f205202g + ", dotsClickableId=" + this.f205203h + ", dotsStrokeColorId=" + this.f205204i + ", dotsStrokeWidthId=" + this.f205205j + ')';
        }

        public a(float r100, float r101, int[] r102) {
            Intrinsics.checkNotNullParameter(r102, "styleableId");
            this.f205196a = r100;
            this.f205197b = r101;
            this.f205198c = r102;
            this.f205199d = 3;
            this.f205200e = 4;
            this.f205201f = 1;
            this.f205202g = 2;
            this.f205203h = 0;
            this.f205204i = 5;
            this.f205205j = 6;
        }
    }

    public interface b {
        void a(int r100);

        boolean b();

        void c();

        void d(com.bytedance.dux.indicator.c r100);

        int getCount();

        int getCurrentItem();
    }

    public interface c {
        Function1<c, Unit> a();
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBaseIndicator f205206a;

        public d(DuxBaseIndicator r100) {
            this.f205206a = r100;
        }

        public final void a() {
            DuxBaseIndicator r100 = this.f205206a;
            boolean r101 = false;
            if (r100.f205194k == null) goto L15;
            int r102 = r100.f205186c.size();
            b r103 = r100.f205194k;
            Intrinsics.checkNotNull(r103);
            if (r102 >= r103.getCount()) goto L10;
            b r104 = r100.f205194k;
            Intrinsics.checkNotNull(r104);
            int r105 = r104.getCount() - r100.f205186c.size();
            int r106 = r100.f205186c.size();
            int r107 = 0;
        L8:
            if (r107 >= r105) goto L15;
            r100.b(r107 + r106);
            r107 = r107 + 1;
            goto L8
        L10:
            int r108 = r100.f205186c.size();
            b r109 = r100.f205194k;
            Intrinsics.checkNotNull(r109);
            if (r108 <= r109.getCount()) goto L15;
            int r110 = r100.f205186c.size();
            b r111 = r100.f205194k;
            Intrinsics.checkNotNull(r111);
            int r112 = r110 - r111.getCount();
            r100.f205186c.size();
            int r113 = 0;
        L13:
            if (r113 >= r112) goto L15;
            r100.h();
            r113 = r113 + 1;
        L15:
            this.f205206a.f();
            this.f205206a.g();
            DuxBaseIndicator r114 = this.f205206a;
            b r115 = r114.f205194k;
            if (r115 == null) goto L21;
            Intrinsics.checkNotNull(r115);
            if (r115.b() == false) goto L21;
            b r116 = r114.f205194k;
            Intrinsics.checkNotNull(r116);
            r116.c();
            com.bytedance.dux.indicator.a r117 = r114.c();
            b r118 = r114.f205194k;
            Intrinsics.checkNotNull(r118);
            r118.d(r117);
            b r119 = r114.f205194k;
            Intrinsics.checkNotNull(r119);
            r117.c(r119.getCurrentItem(), 0.0f);
        L21:
            b r120 = this.f205206a.getPager();
            if (r120 != null) goto L24;
        L26:
            if (r101 == false) goto L28;
            DuxBaseIndicator r121 = this.f205206a;
            Intrinsics.checkNotNullParameter(r121, "<this>");
            r121.setVisibility(4);
            return;
        L28:
            n.f(this.f205206a);
            return;
        L24:
            if (r120.getCount() != 1) goto L26;
            r101 = true;
            goto L26
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.dux.indicator.DuxBaseIndicator$setViewPager$2, reason: invalid class name */
    public final class AnonymousClass2 extends DataSetObserver implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBaseIndicator f205207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPager f205208b;

        @Override // com.bytedance.dux.indicator.DuxBaseIndicator.c
        public final Function1<c, Unit> a() {
            final ViewPager r100 = this.f205208b;
            return new DuxBaseIndicator$setViewPager$2$releaseAction$1(r100);
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            super.onChanged();
            this.f205207a.e();
        }

        public AnonymousClass2(DuxBaseIndicator r100, ViewPager r101) {
            this.f205207a = r100;
            this.f205208b = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.dux.indicator.DuxBaseIndicator$setViewPager$3, reason: invalid class name */
    public final class AnonymousClass3 implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DuxBaseIndicator$setViewPager$3$addOnPageChangeListener$1 f205209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPager f205210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DuxBaseIndicator f205211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Integer> f205212d;

        @Override // com.bytedance.dux.indicator.DuxBaseIndicator.b
        public final boolean b() {
            ViewPager r100 = this.f205210b;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            PagerAdapter r101 = r100.getAdapter();
            if (r101 == null) goto L5;
            int r102 = r101.getCount();
        L6:
            if (r102 <= 0) goto L9;
            return true;
        L9:
            return false;
        L5:
            r102 = 0;
            goto L6
        }

        @Override // com.bytedance.dux.indicator.DuxBaseIndicator.b
        public final void c() {
            DuxBaseIndicator$setViewPager$3$addOnPageChangeListener$1 r100 = this.f205209a;
            if (r100 == null) goto L6;
            this.f205210b.removeOnPageChangeListener(r100);
            return;
        }

        @Override // com.bytedance.dux.indicator.DuxBaseIndicator.b
        public final int getCount() {
            return this.f205212d.invoke().intValue();
        }

        @Override // com.bytedance.dux.indicator.DuxBaseIndicator.b
        public final int getCurrentItem() {
            return DuxBaseIndicator.a(this.f205211c, this.f205210b.getCurrentItem(), getCount());
        }

        @Override // com.bytedance.dux.indicator.DuxBaseIndicator.b
        public final void a(int r100) {
            this.f205210b.setCurrentItem(r100, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.viewpager.widget.ViewPager$OnPageChangeListener, com.bytedance.dux.indicator.DuxBaseIndicator$setViewPager$3$addOnPageChangeListener$1, java.lang.Object] */
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
        @Override // com.bytedance.dux.indicator.DuxBaseIndicator.b
        public final void d(final com.bytedance.dux.indicator.c r100) {
            Intrinsics.checkNotNullParameter(r100, "onPageChangeListenerHelper");
            final DuxBaseIndicator r101 = this.f205211c;
            ?? r102 = new DuxBaseIndicator$setViewPager$3$addOnPageChangeListener$1(r100, r101, this);
            this.f205209a = r102;
            ViewPager r103 = this.f205210b;
            Intrinsics.checkNotNull(r102);
            r103.addOnPageChangeListener(r102);
        }

        public AnonymousClass3(ViewPager r100, DuxBaseIndicator r101, Function0<Integer> r102) {
            this.f205210b = r100;
            this.f205211c = r101;
            this.f205212d = r102;
        }
    }

    public DuxBaseIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 0, 14);
    }

    public DuxBaseIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public DuxBaseIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public abstract void b(int r100);

    public abstract com.bytedance.dux.indicator.a c();

    public abstract void d(int r100);

    public abstract a getCustom();

    public abstract void h();

    public final void e() {
        if (this.f205194k != null) goto L5;
        return;
    L5:
        post(new d(this));
    }

    public final void f() {
        int r100 = this.f205186c.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        d(r101);
        r101 = r101 + 1;
        goto L3
    }

    public final void g() {
        b r100 = this.f205194k;
        if (r100 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r100);
        int r101 = r100.getCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        b r103 = this.f205194k;
        Intrinsics.checkNotNull(r103);
        if (r102 == r103.getCurrentItem()) goto L10;
        com.bytedance.dux.indicator.b.a((View) ListProtector.get(this.f205186c, r102), (int) this.f205187d);
    L10:
        r102 = r102 + 1;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    public final boolean getDotsClickable() {
        return this.f205191h;
    }

    public final int getDotsColor() {
        return this.f205189f;
    }

    public final float getDotsCornerRadius() {
        return this.f205190g;
    }

    public final float getDotsSize() {
        return this.f205187d;
    }

    public final float getDotsSpacing() {
        return this.f205188e;
    }

    public final int getDotsStrokeColor() {
        return this.f205192i;
    }

    public final float getDotsStrokeWidth() {
        return this.f205193j;
    }

    public final boolean getLimitLargeFontScale() {
        return this.f205184a;
    }

    public final b getPager() {
        return this.f205194k;
    }

    private final void setPagerDataSetObserver(c r100) {
        c r101 = this.f205195l;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        Function1<c, Unit> r102 = r101.a();
        c r103 = this.f205195l;
        Intrinsics.checkNotNull(r103);
        r102.invoke(r103);
    L5:
        this.f205195l = r100;
    }

    public final void setDotsClickable(boolean r100) {
        this.f205191h = r100;
    }

    public final void setDotsColor(int r100) {
        if (this.f205189f == r100) goto L6;
        this.f205189f = r100;
        f();
        return;
    }

    public final void setDotsCornerRadius(float r100) {
        if (this.f205190g != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f205190g = r100;
        f();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setDotsSize(float r100) {
        if (this.f205187d != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f205187d = r100;
        setDotsCornerRadius(r100 / 2);
        g();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setDotsSpacing(float r100) {
        int r101 = 0;
        if (this.f205188e != r100) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L19;
        this.f205188e = r100;
        b r103 = this.f205194k;
        if (r103 == null) goto L23;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getCurrentItem();
    L11:
        if (r101 >= r104) goto L24;
        View r105 = (View) ListProtector.get(this.f205186c, r101);
        int r106 = (int) this.f205188e;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
        if ((r107 instanceof FrameLayout.LayoutParams) == false) goto L15;
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;
    L16:
        if (r108 == null) goto L18;
        r108.setMarginStart(r106);
        r108.setMarginEnd(r106);
        r105.requestLayout();
    L18:
        r101 = r101 + 1;
        goto L11
    L15:
        r108 = null;
        goto L16
    L24:
        return;
    L23:
        return;
    L19:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setDotsStrokeColor(int r100) {
        if (this.f205192i == r100) goto L6;
        this.f205192i = r100;
        f();
        return;
    }

    public final void setDotsStrokeWidth(float r100) {
        if (this.f205193j != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        this.f205193j = r100;
        f();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setLimitLargeFontScale(boolean r100) {
        this.f205184a = r100;
    }

    public final void setPager(b r100) {
        b r101 = this.f205194k;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r101.c();
    L5:
        this.f205194k = r100;
    }

    @Deprecated(message = "需要 pageCount, 否则搭配banner的无限横划时可能出错", replaceWith = @ReplaceWith(expression = "setViewPager(ViewPager, Int) or setViewPager(ViewPager, () -> Int)", imports = {}))
    public final void setViewPager(ViewPager r100) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        PagerAdapter r101 = r100.getAdapter();
        if (r101 == null) goto L5;
        final int r102 = r101.getCount();
    L6:
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        Function0<Integer> r103 = new AnonymousClass1(r102);
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        Intrinsics.checkNotNullParameter(r103, "pageCount");
        if (r100.getAdapter() == null) goto L11;
        setPagerDataSetObserver(new AnonymousClass2(this, r100));
        PagerAdapter r104 = r100.getAdapter();
        Intrinsics.checkNotNull(r104);
        Object r105 = this.f205195l;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.database.DataSetObserver");
        r104.registerDataSetObserver((DataSetObserver) r105);
        setPager(new AnonymousClass3(r100, this, r103));
        e();
        return;
    L11:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    L5:
        r102 = 1;
        goto L6
    }

    public static final int a(DuxBaseIndicator r100, int r101, int r102) {
        r100.getClass();
        return r101 % r102;
    L5:
        e = move-exception;
        if ((e instanceof ArithmeticException) == false) goto L9;
        int r103 = em4.d.f473061a;
        em4.d.b(r100.f205185b, "不要乱除0呀 " + e.getMessage());
        return r101;
    L9:
        int r104 = em4.d.f473061a;
        em4.d.b(r100.f205185b, "抓住了一个Exception并ignore");
        return r101;
    }

    public DuxBaseIndicator(Context r100, AttributeSet r101, int r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205184a = r110;
        this.f205185b = "DuxBaseIndicator";
        this.f205186c = new ArrayList();
        this.f205187d = getCustom().f205196a;
        this.f205188e = getCustom().f205197b;
        this.f205189f = ContextCompat.getColor(r100, R.color.Primary);
        float r103 = 2;
        this.f205190g = this.f205187d / r103;
        this.f205191h = true;
        this.f205192i = ContextCompat.getColor(r100, R.color.LineReverse2);
        float r104 = (float) 0.5d;
        Resources r105 = Resources.getSystem();
        this.f205193j = TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()));
        if (r101 == null) goto L6;
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.limitLargeFontScale});
        this.f205184a = r106.getBoolean(0, this.f205184a);
        r106.recycle();
        TypedArray r107 = r100.obtainStyledAttributes(r101, getCustom().f205198c);
        setDotsSize(r107.getDimension(getCustom().f205199d, getCustom().f205196a));
        setDotsSpacing(r107.getDimension(getCustom().f205200e, getCustom().f205197b));
        setDotsColor(r107.getColor(getCustom().f205201f, ContextCompat.getColor(r100, R.color.Primary)));
        setDotsCornerRadius(r107.getDimension(getCustom().f205202g, this.f205187d / r103));
        this.f205191h = r107.getBoolean(getCustom().f205203h, true);
        setDotsStrokeColor(r107.getColor(getCustom().f205204i, ContextCompat.getColor(r100, R.color.LineReverse2)));
        int r108 = getCustom().f205205j;
        Resources r109 = Resources.getSystem();
        setDotsStrokeWidth(r107.getDimension(r108, TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()))));
        r107.recycle();
        return;
    }

    public /* synthetic */ DuxBaseIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102, false);
    }
}
