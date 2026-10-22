package com.bytedance.commerce.base.preview.view.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.util.Locale;

/* JADX INFO: loaded from: classes15.dex */
public class NumberIndicator extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f202868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f202869b;

    public class a implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NumberIndicator f202870a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }

        public a(NumberIndicator r100) {
            this.f202870a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            if (this.f202870a.f202868a.getAdapter() != null) goto L5;
            return;
        L5:
            if (this.f202870a.f202868a.getAdapter().getCount() <= 0) goto L10;
            this.f202870a.setText(String.format(Locale.getDefault(), "%s/%s", new Object[]{Integer.valueOf(r100 + 1), Integer.valueOf(this.f202870a.f202868a.getAdapter().getCount())}));
            return;
        }
    }

    public NumberIndicator(Context r100) {
        this(r100, null);
    }

    public void setViewPager(ViewPager r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getAdapter() == null) goto L8;
        this.f202868a = r100;
        r100.removeOnPageChangeListener(this.f202869b);
        this.f202868a.addOnPageChangeListener(this.f202869b);
        this.f202869b.onPageSelected(this.f202868a.getCurrentItem());
        return;
    }

    public NumberIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public NumberIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f202869b = new a(this);
        setTextColor(-1);
        setTextSize(18.0f);
    }
}
