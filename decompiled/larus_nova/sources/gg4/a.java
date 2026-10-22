package gg4;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f481114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f481115b;

    public final void a(int r100) {
        this.f481114a = r100;
        if (this.f481115b.getHeight() != 0) goto L5;
        return;
    L5:
        if (this.f481115b.getWidth() == 0) goto L11;
        int r101 = this.f481115b.getWidth();
        int r102 = this.f481115b.getHeight();
        if (this.f481114a <= 0) goto L12;
        this.f481115b.setClipToOutline(true);
        this.f481115b.setOutlineProvider(new b(this.f481114a, r101, r102));
        return;
    L12:
        return;
    }

    public a(ViewGroup r100, Context r101, AttributeSet r102, int r103) {
        this.f481115b = r100;
        TypedArray r104 = r101.getTheme().obtainStyledAttributes(r102, new int[]{R.attr.commerce_rdv_rounded_radius}, r103, 0);
        if (r104.hasValue(0) == false) goto L5;
        this.f481114a = r104.getDimensionPixelOffset(0, 0);
    L5:
        r104.recycle();
    }
}
