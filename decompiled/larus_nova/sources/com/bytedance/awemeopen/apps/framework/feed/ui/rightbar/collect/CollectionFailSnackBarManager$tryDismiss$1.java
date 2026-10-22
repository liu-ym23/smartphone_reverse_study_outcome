package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class CollectionFailSnackBarManager$tryDismiss$1 extends Lambda implements Function0<Unit> {
    public static final CollectionFailSnackBarManager$tryDismiss$1 INSTANCE = null;

    static {
        INSTANCE = new CollectionFailSnackBarManager$tryDismiss$1();
    }

    public CollectionFailSnackBarManager$tryDismiss$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        wx3.a r100 = CollectionFailSnackBarManager.f196685b;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
