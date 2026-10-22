package com.bytedance.ee.bear.lark.sidebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.view.View;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes16.dex */
public final class j extends xc5.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f227529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<ad5.e> f227530g;

    public static final class a extends jp5.a {
        public a(Context r100) {
            super(r100);
        }

        @Override // jp5.a, android.view.View
        public final void onDraw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            r100.drawRoundRect(this.f499979l, getRoundRadius(), getRoundRadius(), this.f499976i);
        }

        @Override // jp5.a, xuc.c
        public final void onPageScrolled(int r100, float r101, int r102) {
            super.onPageScrolled(r100, r101, r102);
            List<zuc.a> r103 = this.f499977j;
            if (r103 != null) goto L5;
            return;
        L5:
            if (r103.isEmpty() == true) goto L10;
            zuc.a r104 = tuc.a.a(this.f499977j, r100);
            int r105 = r104.f573675d;
            int r106 = r104.f573676e;
            int r107 = (r105 + r106) / 2;
            this.f499979l.left = r107 - n.d(10);
            this.f499979l.right = r107 + n.d(10);
            invalidate();
            return;
        }
    }

    public static final class b extends com.bytedance.ee.bear.widgets.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Typeface f227531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Typeface f227532d;

        public final Typeface getBoldTypeface() {
            return this.f227532d;
        }

        public final Typeface getNormalTypeface() {
            return this.f227531c;
        }

        @Override // com.bytedance.ee.bear.widgets.b, avc.a, avc.c, xuc.d
        public final void a(int r100, int r101) {
            super.a(r100, r101);
            if (Intrinsics.areEqual(getTypeface(), this.f227532d) == true) goto L6;
            setTypeface(this.f227532d);
            return;
        }

        @Override // com.bytedance.ee.bear.widgets.b, avc.a, avc.c, xuc.d
        public final void b(int r100, int r101) {
            super.b(r100, r101);
            if (Intrinsics.areEqual(getTypeface(), this.f227531c) == true) goto L6;
            setTypeface(this.f227531c);
            return;
        }

        public b(Context r100, int r101, int r102, String r103, c r104) {
            Intrinsics.checkNotNull(r103);
            super(r100, r101, r102, r103, r104);
            this.f227531c = h18.e.b(r100, 0);
            this.f227532d = h18.e.b(r100, 1);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f227533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f227534b;

        public c(j r100, int r101) {
            this.f227533a = r100;
            this.f227534b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f227533a.f(this.f227534b);
        }
    }

    public final Context getContext() {
        return this.f227529f;
    }

    @Override // xc5.b, xuc.a
    public final xuc.c b(Context r100) {
        if (r100 == null) goto L9;
        a r101 = new a(r100);
        r101.setMode(1);
        Integer[] r102 = new Integer[1];
        Resources r103 = r100.getResources();
        if (r103 == null) goto L6;
        int r104 = r103.getColor(R.color.primary_fill_default);
    L7:
        r102[0] = Integer.valueOf(r104);
        r101.setColors(r102);
        r101.setLineHeight(n.d(3));
        r101.setXOffset(n.d(3));
        r101.setRoundRadius(n.d(4));
        return r101;
    L6:
        r104 = 0;
        goto L7
    L9:
        return null;
    }

    @Override // xc5.b
    public final int d(Context r100) {
        if (r100 == null) goto L6;
        Resources r101 = r100.getResources();
        if (r101 == null) goto L6;
        return r101.getColor(R.color.text_title);
    L6:
        return 0;
    }

    @Override // xc5.b
    public final int e(Context r100) {
        if (r100 == null) goto L6;
        Resources r101 = r100.getResources();
        if (r101 == null) goto L6;
        return r101.getColor(R.color.text_placeholder);
    L6:
        return 0;
    }

    @Override // xc5.b, xuc.a
    public final xuc.d c(Context r100, int r101) {
        if (r100 == null) goto L5;
        b r102 = new b(r100, d(r100), e(r100), r100.getString(((ad5.e) ListProtector.get(this.f227530g, r101)).f3019b), new c(this, r101));
        r102.setMaxLines(1);
        r102.setTextSize(2, 17.0f);
        r102.setPadding(n.d(17), 0, n.d(17), 0);
        return r102;
    L5:
        return null;
    }

    public j(Context r100, MagicIndicator r101, List r102, com.bytedance.ee.bear.lark.sidebar.a r103) {
        Intrinsics.checkNotNullParameter(r102, "tabInfoList");
        Intrinsics.checkNotNullParameter(r103, "listener");
        super(r100, r101, r102, r103);
        this.f227529f = r100;
        this.f227530g = r102;
    }
}
