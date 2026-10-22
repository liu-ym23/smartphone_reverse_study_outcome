package com.larus.reach.api;

import android.content.Context;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.List;
import kotlin.Metadata;
import ns9.c;
import ns9.g;
import ns9.h;
import ns9.i;
import ns9.j;
import ns9.t;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH&J0\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001d"}, d2 = {"Lcom/larus/reach/api/ReachBannerHost;", "", "canHandle", "", "request", "Lcom/larus/reach/api/ReachRequest;", "evaluate", "Lcom/larus/reach/api/ReachHostDecision;", "renderContext", "Landroid/content/Context;", "prepare", "content", "Lcom/larus/reach/api/ReachBannerRenderContent;", "resolveDisplayDecision", "Lcom/larus/reach/api/ReachHostDisplayDecision;", "currentEntries", "", "Lcom/larus/reach/api/ReachHostDisplayEntry;", "show", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/larus/reach/api/ReachDisplaySession;", "replace", "replacedReachUniqueId", "", "reason", "Lcom/larus/reach/api/ReachCloseReason;", "dismiss", "reachUniqueId", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ReachBannerHost {
    void a(t r100, g r101, c r102);

    h b(t r100, c r101);

    i c(t r100, List<j> r101);

    h d(t r100);

    Context e(t r100);

    boolean f(t r100);

    void g(String r100, ReachCloseReason r101);

    void h(t r100, g r101, c r102, String r103, ReachCloseReason r104);
}
