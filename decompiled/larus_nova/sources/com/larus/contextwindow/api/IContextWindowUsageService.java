package com.larus.contextwindow.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import v29.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H'J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H'J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&¨\u0006\u0016"}, d2 = {"Lcom/larus/contextwindow/api/IContextWindowUsageService;", "", "evaluate", "Lcom/larus/contextwindow/api/ContextWindowEntryDecision;", "input", "Lcom/larus/contextwindow/api/ContextWindowEvaluationInput;", "createUsageIndicatorDrawable", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "decision", "createSlashUsageDescription", "", "open", "", "request", "Lcom/larus/contextwindow/api/ContextWindowEntryRequest;", "prefetchedSnapshot", "Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "getRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IContextWindowUsageService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f330273a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f330274a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<IContextWindowUsageService> f330275b = null;

        public a() {
        }

        static {
            f330274a = new a();
            f330275b = LazyKt.lazy(new d());
        }
    }

    static {
        f330273a = a.f330274a;
    }

    Drawable a(Context r100, com.larus.contextwindow.api.a.b r101);

    boolean b(Context r100, ContextWindowEntryRequest r101, ContextWindowSnapshot r102);

    q97.a c();

    String d(Context r100, com.larus.contextwindow.api.a.b r101);

    com.larus.contextwindow.api.a e(v29.a r100);
}
