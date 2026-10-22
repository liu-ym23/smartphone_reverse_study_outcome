package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f416200a;

    public final TextView getTextView() {
        return this.f416200a;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        TextView r101 = new TextView(r100);
        this.f416200a = r101;
        addView(r101);
    }

    public final void setTextView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f416200a = r100;
    }
}
