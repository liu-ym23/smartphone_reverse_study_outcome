package com.obric.assistant.settings;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J&\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/obric/assistant/settings/IObricSettingRouteService;", "", "jumpObricSettingPage", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "themeSource", "", "jumpMemorySettingPage", "jumpGlobalMemoryDataPage", "jumpVoicePrintManagementPage", "previousPage", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricSettingRouteService {
    void a(Context r100, String r101);

    void b(Context r100);

    void c(Context r100);

    void d(Context r100);
}
