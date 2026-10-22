package com.larus.bmhome.view.actionbar.custom.router;

import android.os.Bundle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.bot.utils.PinBotShortcutLinkProcessor;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes26.dex */
public final class d implements b {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        PinBotShortcutLinkProcessor.f296774a.getClass();
        Intrinsics.checkNotNullParameter(r100, "uriString");
        return StringsKt.contains$default(r100, "//flow/pin_shortcut", false, 2, null);
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean a(BaseContentWidget r100, String r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r101, "schemaUrl");
        Intrinsics.checkNotNullParameter(r110, "commonArgs");
        if (r100 == null) goto L9;
        LifecycleCoroutineScope r102 = LifecycleOwnerKt.getLifecycleScope(r100);
        if (r102 == null) goto L10;
        BuildersKt.launch$default(r102, null, null, new PinBotShortcutRouterProcessor$handleRoute$1(r101, r100, null), 3, null);
        return true;
    L10:
        return true;
    L9:
        return true;
    }
}
