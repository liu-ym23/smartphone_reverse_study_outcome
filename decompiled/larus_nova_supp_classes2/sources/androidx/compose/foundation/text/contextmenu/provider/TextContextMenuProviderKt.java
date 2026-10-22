package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"LocalTextContextMenuDropdownProvider", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "getLocalTextContextMenuDropdownProvider", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTextContextMenuToolbarProvider", "getLocalTextContextMenuToolbarProvider", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextContextMenuProviderKt {
    private static final ProvidableCompositionLocal<TextContextMenuProvider> LocalTextContextMenuDropdownProvider = null;
    private static final ProvidableCompositionLocal<TextContextMenuProvider> LocalTextContextMenuToolbarProvider = null;

    private static final TextContextMenuProvider LocalTextContextMenuDropdownProvider$lambda$0() {
        return null;
    }

    private static final TextContextMenuProvider LocalTextContextMenuToolbarProvider$lambda$1() {
        return null;
    }

    public static /* synthetic */ TextContextMenuProvider a() {
        return LocalTextContextMenuDropdownProvider$lambda$0();
    }

    public static /* synthetic */ TextContextMenuProvider b() {
        return LocalTextContextMenuToolbarProvider$lambda$1();
    }

    static {
        LocalTextContextMenuDropdownProvider = CompositionLocalKt.compositionLocalOf$default(null, new h(), 1, null);
        LocalTextContextMenuToolbarProvider = CompositionLocalKt.compositionLocalOf$default(null, new i(), 1, null);
    }

    public static final ProvidableCompositionLocal<TextContextMenuProvider> getLocalTextContextMenuDropdownProvider() {
        return LocalTextContextMenuDropdownProvider;
    }

    public static final ProvidableCompositionLocal<TextContextMenuProvider> getLocalTextContextMenuToolbarProvider() {
        return LocalTextContextMenuToolbarProvider;
    }
}
