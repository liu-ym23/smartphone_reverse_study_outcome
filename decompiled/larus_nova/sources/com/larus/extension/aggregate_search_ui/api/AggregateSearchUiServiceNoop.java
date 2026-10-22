package com.larus.extension.aggregate_search_ui.api;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016Jo\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/api/AggregateSearchUiServiceNoop;", "Lcom/larus/extension/aggregate_search_ui/api/IAggregateSearchUiService;", "<init>", "()V", "createSearchFragment", "Landroidx/fragment/app/Fragment;", "openSearchActivity", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "keyword", "", "domain", "enterMethod", "previousPage", "filterEnable", "", "enableFadeTransition", "ext", "", "extras", "Landroid/os/Bundle;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/util/Map;Landroid/os/Bundle;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AggregateSearchUiServiceNoop implements IAggregateSearchUiService {
    public AggregateSearchUiServiceNoop() {
    }

    @Override // com.larus.extension.aggregate_search_ui.api.IAggregateSearchUiService
    public Fragment createSearchFragment() {
        return null;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.IAggregateSearchUiService
    public void openSearchActivity(Context r100, String r101, String r102, String r103, String r104, Boolean r105, boolean r106, Map<String, String> r107, Bundle r108) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
