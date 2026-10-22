package com.bytedance.ug.sdk.luckycat.impl.manager;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/popup/f;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ug/sdk/luckycat/impl/popup/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class LuckyForestPreloadManager$onFeedFinishPreload$2 extends Lambda implements Function1<com.bytedance.ug.sdk.luckycat.impl.popup.f, Unit> {
    public static final LuckyForestPreloadManager$onFeedFinishPreload$2 INSTANCE = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ug.sdk.luckycat.impl.popup.f f271285a;

        public a(com.bytedance.ug.sdk.luckycat.impl.popup.f r100) {
            this.f271285a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CopyOnWriteArrayList<String> r100 = v.f271369a;     // Catch: Throwable -> L4
            v.a(this.f271285a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        INSTANCE = new LuckyForestPreloadManager$onFeedFinishPreload$2();
    }

    public LuckyForestPreloadManager$onFeedFinishPreload$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.ug.sdk.luckycat.impl.popup.f r100) {
        if (r100 == null) goto L6;
        Integer r101 = r100.b();
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
    L7:
        if (r102 <= 0) goto L9;
        v.f271370b.postDelayed(new a(r100), r102);
    L10:
        CopyOnWriteArrayList<String> r103 = v.f271369a;
        if (r100 == null) goto L15;
        com.bytedance.ug.sdk.luckycat.impl.popup.g r104 = r100.d();
        if (r104 == null) goto L15;
        String r105 = r104.b();
    L16:
        r103.add(r105);
        return;
    L15:
        r105 = null;
        goto L16
    L9:
        v.a(r100);
    L6:
        r102 = 0;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.ug.sdk.luckycat.impl.popup.f r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
