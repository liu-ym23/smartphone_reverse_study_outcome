package com.obric.assistant.cocreationreview.modules.searchqa;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.obric.assistant.cocreationreview.g f387552b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.assistant.cocreationreview.modules.searchqa.a f387553a;

    public static final class a {
    }

    static {
        f387552b = new com.obric.assistant.cocreationreview.g("cocreation_search_qa_data.db", "search_qa.database.observe");
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f387553a = new com.obric.assistant.cocreationreview.modules.searchqa.a(r100.getApplicationContext());
    }
}
