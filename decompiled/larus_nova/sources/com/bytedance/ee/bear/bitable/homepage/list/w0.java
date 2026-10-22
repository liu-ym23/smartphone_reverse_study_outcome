package com.bytedance.ee.bear.bitable.homepage.list;

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
public final class w0 extends xuc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final uuc.a f212864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ad5.e> f212865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f212866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f212867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f212868f;

    public interface a {
        void V0(int r100, ad5.e r101);
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w0 f212869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f212870b;

        public b(w0 r100, int r101) {
            this.f212869a = r100;
            this.f212870b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            w0 r101 = this.f212869a;
            int r102 = this.f212870b;
            r101.f212864b.onPageScrolled(r102, 0.0f, 0);
            r101.f212864b.onPageSelected(r102);
            if (r101.f212866d == null) goto L6;
            ad5.e r103 = (ad5.e) hu5.a.b(r101.f212865c, r102);
            a r104 = r101.f212866d;
            Intrinsics.checkNotNull(r103);
            r104.V0(r102, r103);
            return;
        }
    }

    @Override // xuc.a
    public final xuc.c b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // xuc.a
    public final int a() {
        return this.f212865c.size();
    }

    @Override // xuc.a
    public final xuc.d c(Context r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = this.f212867e;
        int r101 = this.f212868f;
        String r102 = ((ad5.e) ListProtector.get(this.f212865c, r111)).f3021d;
        if (r102 != null) goto L5;
    L9:
        r102 = r110.getString(((ad5.e) ListProtector.get(this.f212865c, r111)).f3019b);
    L11:
        return new x0(r110, r100, r101, r102, ((ad5.e) ListProtector.get(this.f212865c, r111)).f3022e, ((ad5.e) ListProtector.get(this.f212865c, r111)).f3023f, new b(this, r111));
    L5:
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
        r102 = null;
    L8:
        if (r102 != null) goto L11;
        goto L9
    }

    public w0(Context r100, wuc.a r101, List r102, BitableHomeListFragment.d r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "magicIndicator");
        Intrinsics.checkNotNullParameter(r102, "tabInfoList");
        this.f212864b = r101;
        this.f212865c = r102;
        this.f212866d = r103;
        Resources r104 = r100.getResources();
        this.f212867e = r104.getColor(R.color.text_title);
        this.f212868f = r104.getColor(R.color.text_caption);
    }
}
