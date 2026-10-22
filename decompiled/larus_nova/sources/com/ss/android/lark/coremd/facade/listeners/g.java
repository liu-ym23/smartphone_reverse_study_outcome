package com.ss.android.lark.coremd.facade.listeners;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.impl.parse.k;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.d0;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements com.ss.android.lark.coremd.base.parse.f {
    public g() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void d(k r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void f(k r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void a(s r100, Spannable r101) {
        com.ss.android.lark.coremd.base.parse.f.a.b(r100, r101);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void b(com.ss.android.lark.coremd.impl.parse.d r100, s r101) {
        com.ss.android.lark.coremd.base.parse.f.a.a(r100, r101);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void g(final com.ss.android.lark.coremd.impl.parse.d r100, SpannableStringBuilder r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "charSequence");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "charSequence");
        if (((Boolean) IMContextExtend.A.b(new MyAICursorLoadingListener$onParseEnd$showCursorLoading$1(r100))).booleanValue() == true) goto L5;
        return;
    L5:
        Set<Class<? extends Object>> r102 = f.f419734a;
        f.b(r101, r100.getContext());
        d0 r103 = new d0();
        int r104 = r101.length();
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r101.setSpan(r103, r104, r101.length(), 17);
    }
}
