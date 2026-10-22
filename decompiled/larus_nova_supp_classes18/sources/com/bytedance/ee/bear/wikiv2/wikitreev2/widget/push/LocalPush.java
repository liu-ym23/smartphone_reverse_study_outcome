package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.bear.wikiv2.wikitreev2.c;
import com.bytedance.ee.bear.wikiv2.wikitreev2.d;
import com.bytedance.ee.bear.wikiv2.wikitreev2.e;
import com.bytedance.ee.bear.wikiv2.wikitreev2.f;
import com.bytedance.ee.bear.wikiv2.wikitreev2.g;
import com.bytedance.ee.bear.wikiv2.wikitreev2.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class LocalPush {
    public final b a;
    public final LocalPush$focusChangeObserver$1 b;
    public final LocalPush$titleChangeObserver$1 c;
    public final LocalPush$tokenChangeObserver$1 d;
    public final LocalPush$doFavoriteObserver$1 e;
    public final LocalPush$doPinObserver$1 f;
    public final LocalPush$doExploreFavoriteObserver$1 g;
    public final LocalPush$doDeleteObserver$1 h;
    public final LocalPush$doMoveObserver$1 i;
    public final LocalPush$doReloadObserver$1 j;

    public static final class a {
    }

    public interface b {
        void onDoExploreFavorite(com.bytedance.ee.bear.wikiv2.wikitreev2.b r1);

        void onDoFavorite(com.bytedance.ee.bear.wikiv2.wikitreev2.b r1);

        void onDoPin(d r1);

        void onDoReload(e r1);

        void onFocusChange(f r1);

        void onLocalDelete(com.bytedance.ee.bear.wikiv2.wikitreev2.a r1);

        void onLocalMove(c r1);

        void onTitleChange(g r1);

        void onTokenChange(h r1);
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush$focusChangeObserver$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush$titleChangeObserver$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush$tokenChangeObserver$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush$doFavoriteObserver$1] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush$doPinObserver$1] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush$doExploreFavoriteObserver$1] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush$doDeleteObserver$1] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush$doMoveObserver$1] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush$doReloadObserver$1] */
    public LocalPush(b r2) {
        Intrinsics.checkNotNullParameter(r2, "pushHandler");
        this.a = r2;
        this.b = new LocalPush$focusChangeObserver$1(this);
        this.c = new LocalPush$titleChangeObserver$1(this);
        this.d = new LocalPush$tokenChangeObserver$1(this);
        this.e = new LocalPush$doFavoriteObserver$1(this);
        this.f = new LocalPush$doPinObserver$1(this);
        this.g = new LocalPush$doExploreFavoriteObserver$1(this);
        this.h = new LocalPush$doDeleteObserver$1(this);
        this.i = new LocalPush$doMoveObserver$1(this);
        this.j = new LocalPush$doReloadObserver$1(this);
    }
}
