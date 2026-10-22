package com.bytedance.android.shopping.store.moments.module.presenter;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.shopping.api.video.AVScene;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ ECStoreShortVideoPresenterNew a;
    public final /* synthetic */ Ref.BooleanRef b;

    public k(ECStoreShortVideoPresenterNew r1, Ref.BooleanRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Boolean r8 = (Boolean) r7;
        ECStoreShortVideoPresenterNew r9 = this.a;
        ViewGroup r0 = r9.k;
        if (r0 == null) goto L9;
        Ref.BooleanRef r1 = this.b;
        s83.f r2 = r9.g;
        Context r10 = r9.Y().c();
        ECStoreShortVideoPresenterNew r3 = this.a;
        String r4 = r3.x;
        String r5 = r3.y;
        Boolean r6 = (Boolean) r3.i0().isMute().getValue();
        if (r6 != null) goto L7;
        r6 = Boolean.TRUE;
    L7:
        r6.booleanValue();
        new ECStoreShortVideoPresenterNew$createVideo$res$1$$special$$inlined$apply$lambda$1(this);
        AVScene r11 = AVScene.CONTENT_DEFAULT;
        r2.a(r10, r4, r5, r0);
        r1.element = false;
        return;
    }
}
