package com.larus.canvas.feature.component.logic.exit;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes26.dex */
public final class CanvasExitAnchorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f323351a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f323352b = null;

    static {
        f323351a = LazyKt.lazy(new a());
        f323352b = LazyKt.lazy(new b());
    }

    public static void a(String r100, String r101, boolean r102) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CanvasExitAnchorManager$notifyCanvasAnchorEvent$1(r100, r101, r102, null), 3, null);
    }
}
