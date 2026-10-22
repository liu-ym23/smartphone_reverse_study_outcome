package com.larus.app.settings.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import t48.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/larus/app/settings/api/IAppSettingsHostService;", "", "isManualUpdateSupported", "", "checkForUpdate", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getAboutAppHostConfig", "Lcom/larus/app/settings/api/AboutAppHostConfig;", "getCustomAboutAppFragment", "Landroidx/fragment/app/Fragment;", "onAboutAppItemClicked", "semanticId", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAppSettingsHostService {
    Fragment a();

    a b();

    boolean c();

    void d(Context r100);

    void e(String r100);
}
