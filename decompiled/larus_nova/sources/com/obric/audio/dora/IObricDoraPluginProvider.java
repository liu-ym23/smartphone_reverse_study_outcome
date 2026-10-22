package com.obric.audio.dora;

import com.larus.audio.call.arch.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lcom/obric/audio/dora/IObricDoraPluginProvider;", "", "getDoraObricPlugin", "Lcom/larus/audio/call/arch/BaseLLMPlugin;", "Lcom/larus/audio/call/arch/ICommonPluginContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricDoraPluginProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f395404a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f395405a = null;

        static {
            f395405a = new a();
        }

        public a() {
        }
    }

    static {
        f395404a = a.f395405a;
    }

    DoraObricPlugin a(c r100);
}
