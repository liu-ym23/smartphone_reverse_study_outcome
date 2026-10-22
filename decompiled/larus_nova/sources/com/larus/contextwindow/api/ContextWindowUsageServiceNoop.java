package com.larus.contextwindow.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowUsageServiceNoop;", "Lcom/larus/contextwindow/api/IContextWindowUsageService;", "<init>", "()V", "evaluate", "Lcom/larus/contextwindow/api/ContextWindowEntryDecision;", "input", "Lcom/larus/contextwindow/api/ContextWindowEvaluationInput;", "createUsageIndicatorDrawable", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "decision", "createSlashUsageDescription", "", "open", "", "request", "Lcom/larus/contextwindow/api/ContextWindowEntryRequest;", "prefetchedSnapshot", "Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "getRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowUsageServiceNoop implements IContextWindowUsageService {
    public ContextWindowUsageServiceNoop() {
    }

    @Override // com.larus.contextwindow.api.IContextWindowUsageService
    public final Drawable a(Context r100, a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "decision");
        return null;
    }

    @Override // com.larus.contextwindow.api.IContextWindowUsageService
    public final boolean b(Context r100, ContextWindowEntryRequest r101, ContextWindowSnapshot r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        return false;
    }

    @Override // com.larus.contextwindow.api.IContextWindowUsageService
    public final q97.a c() {
        return null;
    }

    @Override // com.larus.contextwindow.api.IContextWindowUsageService
    public final String d(Context r100, a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "decision");
        return null;
    }

    @Override // com.larus.contextwindow.api.IContextWindowUsageService
    public final a e(v29.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return new a.C4197a(ContextWindowHiddenReason.SERVICE_UNAVAILABLE);
    }
}
