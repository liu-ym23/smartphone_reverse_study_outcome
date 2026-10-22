package com.larksuite.component.card.component.text;

import android.content.res.Resources;
import android.text.Layout;
import android.text.TextUtils;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f283613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f283614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f283615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f283616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f283617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Layout.Alignment f283618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextUtils.TruncateAt f283619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f283620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f283621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f283622j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f283623k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f283624l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f283625m;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        return (((((((((((((((((((((this.f283613a * 31) + (this.f283615c ? 1 : 0)) * 31) + this.f283616d) * 31) + this.f283618f.ordinal()) * 31) + this.f283617e) * 31) + this.f283619g.ordinal()) * 31) + this.f283621i) * 31) + this.f283622j) * 31) + this.f283623k) * 31) + this.f283624l) * 31) + Float.floatToIntBits(this.f283620h)) * 31) + (this.f283625m ? 1 : 0);
    }

    public d() {
        this.f283613a = Integer.MAX_VALUE;
        this.f283614b = Integer.MAX_VALUE;
        Resources r100 = com.larksuite.framework.utils.b.f285948a.getResources();
        this.f283616d = (int) TypedValue.applyDimension(2, 14.0f, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()));
        this.f283618f = Layout.Alignment.ALIGN_NORMAL;
        this.f283619g = TextUtils.TruncateAt.END;
        Resources r101 = com.larksuite.framework.utils.b.f285948a.getResources();
        this.f283620h = TypedValue.applyDimension(1, 4.0f, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof d) == true) goto L5;
        return false;
    L5:
        d r101 = (d) r100;
        if (this.f283613a == r101.f283613a) goto L8;
        return false;
    L8:
        if (this.f283615c == r101.f283615c) goto L10;
        return false;
    L10:
        if (this.f283617e == r101.f283617e) goto L12;
        return false;
    L12:
        if (this.f283618f == r101.f283618f) goto L14;
        return false;
    L14:
        if (this.f283619g == r101.f283619g) goto L16;
        return false;
    L16:
        if (this.f283620h != r101.f283620h) goto L18;
        boolean r102 = true;
    L19:
        if (r102 == true) goto L21;
        return false;
    L21:
        if (this.f283621i == r101.f283621i) goto L23;
        return false;
    L23:
        if (this.f283622j == r101.f283622j) goto L25;
        return false;
    L25:
        if (this.f283623k == r101.f283623k) goto L27;
        return false;
    L27:
        if (this.f283624l == r101.f283624l) goto L29;
        return false;
    L29:
        if (this.f283616d == r101.f283616d) goto L31;
        return false;
    L31:
        if (this.f283625m != r101.f283625m) goto L45;
        return true;
    L45:
        return false;
    L18:
        r102 = false;
        goto L19
    }
}
