package com.bytedance.ee.bear.share.newshare;

import android.content.res.Configuration;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.share.export.ShareParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class c0 {
    public b a;
    public f0 b;
    public ShareItemList c;
    public final MutableLiveData<d0> d;
    public final MutableLiveData<e0> e;
    public ShareParams f;
    public com.bytedance.ee.bear.share.export.f g;

    public static final class a {
    }

    static {
    }

    public abstract ShareItemList b();

    public abstract km5.a c();

    public abstract void d();

    public void g(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    public abstract void i();

    public abstract void j();

    public final void e() {
        ShareItemList r0 = this.c;
        if (r0 == null) goto L5;
        ShareItemList.b(r0.a, ShareItemList$release$1.INSTANCE);
    L5:
        i();
    }

    public final b f() {
        b r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("host");
        return null;
    }

    public void h() {
        ShareItemList r0 = this.c;
        if (r0 == null) goto L6;
        ShareItemList.b(r0.a, ShareItemList$onResume$1.INSTANCE);
        return;
    }

    public c0() {
        this.d = new MutableLiveData();
        this.e = new MutableLiveData();
    }

    public final void a(b r2, lm5.a r3, ShareParams r4) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiShareItemFactory");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.f = r4;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
        this.b = r3;
        r4.getChannelHandlers();
        ShareItemList r5 = b();
        r5.c(this, r4);
        this.c = r5;
        d();
        ShareItemList.b(r5.a, ShareItemList$create$1.INSTANCE);
    }
}
