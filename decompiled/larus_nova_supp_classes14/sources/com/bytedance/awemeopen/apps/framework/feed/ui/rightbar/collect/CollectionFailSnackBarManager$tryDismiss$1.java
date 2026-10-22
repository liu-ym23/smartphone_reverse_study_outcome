package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class CollectionFailSnackBarManager$tryDismiss$1 extends Lambda implements Function0<Unit> {
    public static final CollectionFailSnackBarManager$tryDismiss$1 INSTANCE = null;

    static {
        INSTANCE = new CollectionFailSnackBarManager$tryDismiss$1();
    }

    public CollectionFailSnackBarManager$tryDismiss$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1501invoke() {
        wx3.a r0 = CollectionFailSnackBarManager.b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1501invoke();
        return Unit.INSTANCE;
    }
}
