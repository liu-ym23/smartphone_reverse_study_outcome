package fw8;

import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.view.actionbar.api.IActionBarFilter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ss8.d;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements IActionBarFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IActionBarFilter.FilterMode f479016c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final int getPriority() {
        return 500;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final String b() {
        return this.f479015b;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final IActionBarFilter.FilterMode getMode() {
        return this.f479016c;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "actionBarScopeId");
        this.f479014a = r100;
        Intrinsics.checkNotNullParameter(r100, "actionBarScopeId");
        this.f479015b = "applet_chat_action_bar_snapshot_".concat(r100);
        this.f479016c = IActionBarFilter.FilterMode.BLACKLIST;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final boolean a(z0 r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Intrinsics.areEqual(r101.f543428f.get("action_bar_scope_id"), this.f479014a) == false) goto L13;
        String r102 = r100.f295606b;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (StringsKt.startsWith$default(r102, "applet_chat_action_bar_", false, 2, null) != true) goto L9;
        r103 = true;
        goto L10
    L13:
        return false;
    }
}
