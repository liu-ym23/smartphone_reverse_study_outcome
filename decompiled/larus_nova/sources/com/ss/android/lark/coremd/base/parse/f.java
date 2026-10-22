package com.ss.android.lark.coremd.base.parse;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface f {

    public static final class a {
        public static void a(com.ss.android.lark.coremd.impl.parse.d r100, v7b.s r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "node");
        }

        public static void b(v7b.s r100, Spannable r101) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r101, "futureResult");
        }
    }

    void a(v7b.s r100, Spannable r101);

    void b(com.ss.android.lark.coremd.impl.parse.d r100, v7b.s r101);

    void d(com.ss.android.lark.coremd.impl.parse.k r100);

    void f(com.ss.android.lark.coremd.impl.parse.k r100);

    void g(com.ss.android.lark.coremd.impl.parse.d r100, SpannableStringBuilder r101);
}
