package com.bytedance.ee.bear.bitable.homepage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class w extends xuc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final uuc.a f213112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ad5.e> f213113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f213114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f213115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f213116f;

    public interface a {
        void V0(int r100, ad5.e r101);
    }

    public static final class b extends yuc.a {
        public b(Context r100) {
            super(r100);
        }

        @Override // yuc.a, xuc.c
        public final void onPageScrolled(int r100, float r101, int r102) {
            super.onPageScrolled(r100, 0.0f, r102);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f213117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f213118b;

        public c(w r100, int r101) {
            this.f213117a = r100;
            this.f213118b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            w r101 = this.f213117a;
            int r102 = this.f213118b;
            r101.f213112b.onPageScrolled(r102, 0.0f, 0);
            r101.f213112b.onPageSelected(r102);
            if (r101.f213114d == null) goto L6;
            ad5.e r103 = (ad5.e) hu5.a.b(r101.f213113c, r102);
            a r104 = r101.f213114d;
            Intrinsics.checkNotNull(r103);
            r104.V0(r102, r103);
            return;
        }
    }

    @Override // xuc.a
    public final int a() {
        return this.f213113c.size();
    }

    @Override // xuc.a
    public final xuc.c b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b r101 = new b(r100);
        r101.setMode(1);
        r101.setColors(new Integer[]{Integer.valueOf(r100.getResources().getColor(R.color.primary_fill_default))});
        r101.setLineHeight(com.bytedance.ee.util.ui.n.d(2));
        return r101;
    }

    @Override // xuc.a
    public final xuc.d c(Context r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = this.f213115e;
        int r102 = this.f213116f;
        String r103 = ((ad5.e) ListProtector.get(this.f213113c, r110)).f3021d;
        if (r103 != null) goto L5;
    L9:
        r103 = r100.getString(((ad5.e) ListProtector.get(this.f213113c, r110)).f3019b);
    L10:
        com.bytedance.ee.bear.widgets.n r111 = new com.bytedance.ee.bear.widgets.n(r100, r101, r102, r103, new c(this, r110));
        r111.setMaxLines(1);
        return r111;
    L5:
        if ((!StringsKt.isBlank(r103)) == true) goto L8;
        r103 = null;
    L8:
        if (r103 != null) goto L10;
        goto L9
    }

    public w(Context r100, wuc.a r101, List r102, a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "magicIndicator");
        Intrinsics.checkNotNullParameter(r102, "tabInfoList");
        this.f213112b = r101;
        this.f213113c = r102;
        this.f213114d = r103;
        Resources r104 = r100.getResources();
        this.f213115e = r104.getColor(R.color.text_title);
        this.f213116f = r104.getColor(R.color.text_caption);
    }
}
