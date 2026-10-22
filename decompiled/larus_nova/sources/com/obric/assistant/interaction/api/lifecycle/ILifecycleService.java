package com.obric.assistant.interaction.api.lifecycle;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/api/lifecycle/ILifecycleService;", "", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "start", "stop", "release", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILifecycleService {

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void init$default(ILifecycleService r100, Context r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.init(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
    }

    void init(Context r100);

    void release();

    void start();

    void stop();
}
