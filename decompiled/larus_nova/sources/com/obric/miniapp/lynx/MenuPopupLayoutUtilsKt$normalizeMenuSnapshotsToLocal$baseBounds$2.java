package com.obric.miniapp.lynx;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MenuPopupLayoutUtilsKt$normalizeMenuSnapshotsToLocal$baseBounds$2 extends FunctionReferenceImpl implements Function1<l4, c6> {
    public static final MenuPopupLayoutUtilsKt$normalizeMenuSnapshotsToLocal$baseBounds$2 INSTANCE = null;

    static {
        INSTANCE = new MenuPopupLayoutUtilsKt$normalizeMenuSnapshotsToLocal$baseBounds$2();
    }

    public MenuPopupLayoutUtilsKt$normalizeMenuSnapshotsToLocal$baseBounds$2() {
        super(1, MenuPopupLayoutUtilsKt.class, "toResolvedBounds", "toResolvedBounds(Lcom/obric/miniapp/lynx/MenuContentSnapshot;)Lcom/obric/miniapp/lynx/ResolvedMenuBounds;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c6 invoke2(l4 r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return MenuPopupLayoutUtilsKt.d(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ c6 invoke(l4 r100) {
        return invoke2(r100);
    }
}
