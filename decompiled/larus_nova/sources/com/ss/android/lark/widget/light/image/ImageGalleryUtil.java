package com.ss.android.lark.widget.light.image;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class ImageGalleryUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f446047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f446048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f446049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f446050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f446051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f446052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f446053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Rect> f446054i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Integer> f446055j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<Integer, Integer> f446056k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f446057l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f446058m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f446059n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f446060o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<String> f446061p;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Rect> f446062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Integer, Integer> f446063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Integer> f446064c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Size f446065d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f446062a, r101.f446062a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f446063b, r101.f446063b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f446064c, r101.f446064c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f446065d, r101.f446065d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f446062a.hashCode() * 31) + this.f446063b.hashCode()) * 31) + this.f446064c.hashCode()) * 31) + this.f446065d.hashCode();
        }

        public final String toString() {
            return "ImageGalleryInfo(outputRect=" + this.f446062a + ", lineNumber2lineStartIndex=" + this.f446063b + ", superLargeIndex=" + this.f446064c + ", size=" + this.f446065d + ')';
        }

        public b(List<Rect> r100, Map<Integer, Integer> r101, List<Integer> r102, Size r103) {
            Intrinsics.checkNotNullParameter(r100, "outputRect");
            Intrinsics.checkNotNullParameter(r101, "lineNumber2lineStartIndex");
            Intrinsics.checkNotNullParameter(r102, "superLargeIndex");
            Intrinsics.checkNotNullParameter(r103, "size");
            this.f446062a = r100;
            this.f446063b = r101;
            this.f446064c = r102;
            this.f446065d = r103;
        }
    }

    static {
    }

    public final void c() {
        int r100 = this.f446057l + 1;
        this.f446057l = r100;
        this.f446058m = this.f446047b;
        this.f446056k.put(Integer.valueOf(r100), Integer.valueOf(this.f446059n));
    }

    public final Context getContext() {
        return this.f446046a;
    }

    public ImageGalleryUtil(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f446046a = r100;
        if (DeviceUtils.isPad() == false) goto L5;
        float r101 = 140.0f;
    L6:
        int r102 = a(r101);
        this.f446047b = r102;
        this.f446048c = a(8.0f);
        this.f446049d = a(12.0f);
        if (DeviceUtils.isPad() == false) goto L9;
        float r103 = 60.0f;
    L10:
        this.f446050e = a(r103);
        this.f446051f = a(6.0f);
        if (DeviceUtils.isPad() == false) goto L13;
        float r104 = 120.0f;
    L14:
        this.f446052g = a(r104);
        this.f446053h = a(200.0f);
        this.f446054i = new ArrayList();
        this.f446055j = new ArrayList();
        this.f446056k = new LinkedHashMap();
        this.f446057l = 1;
        this.f446058m = r102;
        this.f446060o = LazyKt.lazy(new ImageGalleryUtil$textView$2(this));
        this.f446061p = new ArrayList();
        return;
    L13:
        r104 = 80.0f;
        goto L14
    L9:
        r103 = 40.0f;
        goto L10
    L5:
        r101 = 110.0f;
        goto L6
    }

    public final int a(float r100) {
        return UIUtils.dp2px(this.f446046a, r100);
    }

    public final int b(int r100) {
        int r101 = this.f446048c;
        int r102 = 1;
    L3:
        if (r102 >= r100) goto L10;
        Map<Integer, Integer> r103 = this.f446056k;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        Integer r105 = (Integer) r104.get(Integer.valueOf(r102));
        if (r105 == null) goto L9;
        int r106 = r105.intValue();
        if (r106 >= ((ArrayList) this.f446054i).size()) goto L9;
        Rect r107 = (Rect) ListProtector.get(this.f446054i, r106);
        int r108 = r101 + (RangesKt.coerceAtLeast(r107.height(), this.f446050e) + this.f446049d);
        String r109 = StringsKt.trim((String) ListProtector.get(this.f446061p, r106)).toString();
        int r110 = r107.width();
        ((TextView) this.f446060o.getValue()).setText(r109);
        ((TextView) this.f446060o.getValue()).measure(View.MeasureSpec.makeMeasureSpec(r110, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(MathKt.roundToInt(7.158278823333334E8d), 0));
        int r111 = ((TextView) this.f446060o.getValue()).getMeasuredHeight();
        r101 = r108 + (this.f446051f + r111);
    L9:
        r102 = r102 + 1;
        goto L3
    L10:
        return r101;
    }

    public final void e(Map<Integer, Rect> r100, int r101, int r102) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        if (r101 >= r102) goto L11;
        LinkedHashMap r103 = (LinkedHashMap) r100;
        Rect r104 = (Rect) r103.get(Integer.valueOf(r101));
        if (r104 == null) goto L10;
        ((Rect) ListProtector.get(this.f446054i, r101)).set(r104.left, r104.top, r104.right, r104.bottom);
    L10:
        r101 = r101 + 1;
        goto L5
    }

    public final void d(int r100, int r101, int r102, int r110, int r111, int r112) {
        boolean r103 = false;
        int r104 = 0;
    L3:
        if (r110 >= r102) goto L5;
        r104 = r104 + (RangesKt.coerceAtLeast(((Rect) ListProtector.get(this.f446054i, r110)).width(), this.f446050e) + this.f446048c);
        r110 = r110 + 1;
        goto L3
    L5:
        int r113 = b(r111);
        if ((r100 / r101) >= 0.3333333333333333d) goto L11;
        if (r100 <= this.f446053h) goto L11;
        r103 = true;
    L11:
        if (r103 == false) goto L13;
        int r105 = MathKt.roundToInt(((((double) r112) * 1.0d) / ((double) this.f446047b)) * ((double) this.f446052g));
        ((ArrayList) this.f446054i).add(new Rect(r104, r113, r105 + r104, r112 + r113));
        ((ArrayList) this.f446055j).add(Integer.valueOf(r102));
        return;
    L13:
        int r106 = MathKt.roundToInt((((double) (r100 * r112)) * 1.0d) / ((double) r101));
        ((ArrayList) this.f446054i).add(new Rect(r104, r113, r106 + r104, r112 + r113));
    }
}
