package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import com.bytedance.android.window.shop.repository.dto.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Observer<List<? extends p>> {
    public final /* synthetic */ ECWindowTabsSelectionJSbPluginExp a;

    public final void onComplete() {
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public a(ECWindowTabsSelectionJSbPluginExp r1) {
        this.a = r1;
    }

    public final void onNext(Object r2) {
        List r3 = (List) r2;
        Intrinsics.checkNotNullParameter(r3, "category");
        List r4 = r3;
        if (r4.isEmpty() == true) goto L9;
        ((ArrayList) this.a.b).clear();
        ((ArrayList) this.a.b).addAll(r4);
    L7:
        if ((!((ArrayList) this.a.c).isEmpty()) == false) goto L11;
        ((Runnable) ListProtector.remove(this.a.c, 0)).run();
        goto L7
    L11:
        return;
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.d = r2;
    }
}
