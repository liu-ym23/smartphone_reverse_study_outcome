package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push;

import com.bytedance.ee.bear.wikiv2.wikitreev2.c;
import com.bytedance.ee.bear.wikiv2.wikitreev2.d;
import com.bytedance.ee.bear.wikiv2.wikitreev2.e;
import com.bytedance.ee.bear.wikiv2.wikitreev2.f;
import com.bytedance.ee.bear.wikiv2.wikitreev2.g;
import com.bytedance.ee.bear.wikiv2.wikitreev2.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class LocalPush {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f242185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocalPush$focusChangeObserver$1 f242186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LocalPush$titleChangeObserver$1 f242187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LocalPush$tokenChangeObserver$1 f242188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LocalPush$doFavoriteObserver$1 f242189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LocalPush$doPinObserver$1 f242190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LocalPush$doExploreFavoriteObserver$1 f242191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LocalPush$doDeleteObserver$1 f242192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LocalPush$doMoveObserver$1 f242193i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LocalPush$doReloadObserver$1 f242194j;

    public static final class a {
    }

    public interface b {
        void onDoExploreFavorite(com.bytedance.ee.bear.wikiv2.wikitreev2.b r100);

        void onDoFavorite(com.bytedance.ee.bear.wikiv2.wikitreev2.b r100);

        void onDoPin(d r100);

        void onDoReload(e r100);

        void onFocusChange(f r100);

        void onLocalDelete(com.bytedance.ee.bear.wikiv2.wikitreev2.a r100);

        void onLocalMove(c r100);

        void onTitleChange(g r100);

        void onTokenChange(h r100);
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
    public LocalPush(b r100) {
        Intrinsics.checkNotNullParameter(r100, "pushHandler");
        this.f242185a = r100;
        this.f242186b = new LocalPush$focusChangeObserver$1(this);
        this.f242187c = new LocalPush$titleChangeObserver$1(this);
        this.f242188d = new LocalPush$tokenChangeObserver$1(this);
        this.f242189e = new LocalPush$doFavoriteObserver$1(this);
        this.f242190f = new LocalPush$doPinObserver$1(this);
        this.f242191g = new LocalPush$doExploreFavoriteObserver$1(this);
        this.f242192h = new LocalPush$doDeleteObserver$1(this);
        this.f242193i = new LocalPush$doMoveObserver$1(this);
        this.f242194j = new LocalPush$doReloadObserver$1(this);
    }
}
