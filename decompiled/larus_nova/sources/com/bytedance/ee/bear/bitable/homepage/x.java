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
public final class x extends xuc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final uuc.a f213127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ad5.e> f213128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f213129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f213130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f213131f;

    public interface a {
        void V0(int r100, ad5.e r101);
    }

    public static final class b extends com.bytedance.ee.bear.widgets.n {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f213132c;

        @Override // com.bytedance.ee.bear.widgets.n, avc.a, avc.c, xuc.d
        public final void a(int r100, int r101) {
            super.a(r100, r101);
            int r102 = h18.e.f483540a;
            setTypeface(h18.e.b(this.f213132c, 1));
        }

        @Override // com.bytedance.ee.bear.widgets.n, avc.a, avc.c, xuc.d
        public final void b(int r100, int r101) {
            super.b(r100, r101);
            int r102 = h18.e.f483540a;
            setTypeface(h18.e.b(this.f213132c, 0));
        }

        public b(Context r100, String r101, int r102, int r110, c r111) {
            this.f213132c = r100;
            super(r100, r102, r110, r101, r111);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f213133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f213134b;

        public c(x r100, int r101) {
            this.f213133a = r100;
            this.f213134b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            x r101 = this.f213133a;
            int r102 = this.f213134b;
            r101.f213127b.onPageSelected(r102);
            if (r101.f213129d == null) goto L6;
            ad5.e r103 = (ad5.e) hu5.a.b(r101.f213128c, r102);
            a r104 = r101.f213129d;
            Intrinsics.checkNotNull(r103);
            r104.V0(r102, r103);
            return;
        }
    }

    @Override // xuc.a
    public final int a() {
        return this.f213128c.size();
    }

    @Override // xuc.a
    public final xuc.c b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        yuc.a r101 = new yuc.a(r100);
        r101.setMode(1);
        r101.setColors(new Integer[]{Integer.valueOf(r100.getResources().getColor(R.color.primary_fill_default))});
        r101.setLineHeight(com.bytedance.ee.util.ui.n.d(2));
        return r101;
    }

    @Override // xuc.a
    public final xuc.d c(Context r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = ((ad5.e) ListProtector.get(this.f213128c, r110)).f3021d;
        if (r101 != null) goto L5;
    L9:
        r101 = r100.getString(((ad5.e) ListProtector.get(this.f213128c, r110)).f3019b);
    L10:
        b r111 = new b(r100, r101, this.f213130e, this.f213131f, new c(this, r110));
        r111.setMaxLines(1);
        return r111;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L10;
        goto L9
    }

    public x(Context r100, wuc.a r101, List r102, a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "magicIndicator");
        Intrinsics.checkNotNullParameter(r102, "tabInfoList");
        this.f213127b = r101;
        this.f213128c = r102;
        this.f213129d = r103;
        Resources r104 = r100.getResources();
        this.f213130e = r104.getColor(R.color.text_title);
        this.f213131f = r104.getColor(R.color.text_caption);
    }
}
