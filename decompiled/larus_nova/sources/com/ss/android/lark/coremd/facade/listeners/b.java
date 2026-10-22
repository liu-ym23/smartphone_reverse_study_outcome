package com.ss.android.lark.coremd.facade.listeners;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.coremd.impl.parse.k;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.span.p;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements com.ss.android.lark.coremd.base.parse.f {
    public b() {
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
    public final void g(com.ss.android.lark.coremd.impl.parse.d r100, SpannableStringBuilder r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "charSequence");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "charSequence");
        if (DevEnvUtil.isDebugMode(r100.getContext()) == false) goto L6;
        Set<Class<? extends Object>> r102 = f.f419734a;
        f.b(r101, r100.getContext());
        float r103 = zz7.b.g(r100.getContext(), 12);
        SpannableStringBuilder r104 = new SpannableStringBuilder("(new text)");
        r104.setSpan(new a(r103, UIUtils.getColor(r100.getContext(), R.color.text_caption)), 0, 10, 33);
        r104.setSpan(new p(r104, "(new text)"), 0, 10, 33);
        int r105 = com.ss.android.lark.coremd.utils.b.f419965a;
        r101.append("\u2060");
        r101.append(r104);
        return;
    }
}
