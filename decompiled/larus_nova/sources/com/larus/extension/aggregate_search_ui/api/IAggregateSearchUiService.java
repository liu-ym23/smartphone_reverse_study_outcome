package com.larus.extension.aggregate_search_ui.api;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u007f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/api/IAggregateSearchUiService;", "", "createSearchFragment", "Landroidx/fragment/app/Fragment;", "openSearchActivity", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "keyword", "", "domain", "enterMethod", "previousPage", "filterEnable", "", "enableFadeTransition", "ext", "", "extras", "Landroid/os/Bundle;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/util/Map;Landroid/os/Bundle;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAggregateSearchUiService {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void openSearchActivity$default(IAggregateSearchUiService r100, Context r110, String r111, String r112, String r113, String r114, Boolean r115, boolean r116, Map r117, Bundle r118, int r119, Object r210) {
            if (r210 != null) goto L39;
            Bundle r101 = null;
            if ((r119 & 2) == 0) goto L7;
            String r102 = null;
        L9:
            if ((r119 & 4) == 0) goto L11;
            String r103 = null;
        L13:
            if ((r119 & 8) == 0) goto L15;
            String r104 = null;
        L17:
            if ((r119 & 16) == 0) goto L19;
            String r105 = null;
        L21:
            if ((r119 & 32) == 0) goto L23;
            Boolean r106 = null;
        L25:
            if ((r119 & 64) == 0) goto L27;
            boolean r107 = false;
        L29:
            if ((r119 & 128) == 0) goto L31;
            Map r108 = null;
        L33:
            if ((r119 & 256) != 0) goto L36;
            r101 = r118;
        L36:
            r100.openSearchActivity(r110, r102, r103, r104, r105, r106, r107, r108, r101);
            return;
        L31:
            r108 = r117;
            goto L33
        L27:
            r107 = r116;
            goto L29
        L23:
            r106 = r115;
            goto L25
        L19:
            r105 = r114;
            goto L21
        L15:
            r104 = r113;
            goto L17
        L11:
            r103 = r112;
            goto L13
        L7:
            r102 = r111;
            goto L9
        L39:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSearchActivity");
        }
    }

    Fragment createSearchFragment();

    void openSearchActivity(Context r100, String r101, String r102, String r103, String r104, Boolean r105, boolean r106, Map<String, String> r107, Bundle r108);
}
