package com.bytedance.ee.bear.drive.core.fragment;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<unused var>", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class DrivePreviewOverlayContainerCoordinator$5 extends Lambda implements Function2<Object, Boolean, Unit> {
    public static final DrivePreviewOverlayContainerCoordinator$5 INSTANCE = null;

    static {
        INSTANCE = new DrivePreviewOverlayContainerCoordinator$5();
    }

    public DrivePreviewOverlayContainerCoordinator$5() {
        super(2);
    }

    public final void invoke(Object r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }
}
