package com.bytedance.ee.bear.share.newshare;

import android.content.res.Configuration;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.share.export.ShareParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f237196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f237197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ShareItemList f237198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<d0> f237199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<e0> f237200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShareParams f237201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.share.export.f f237202g;

    public static final class a {
    }

    static {
    }

    public abstract ShareItemList b();

    public abstract km5.a c();

    public abstract void d();

    public void g(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    public abstract void i();

    public abstract void j();

    public final void e() {
        ShareItemList r100 = this.f237198c;
        if (r100 == null) goto L5;
        ShareItemList.b(r100.f237180a, ShareItemList$release$1.INSTANCE);
    L5:
        i();
    }

    public final b f() {
        b r100 = this.f237196a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("host");
        return null;
    }

    public void h() {
        ShareItemList r100 = this.f237198c;
        if (r100 == null) goto L6;
        ShareItemList.b(r100.f237180a, ShareItemList$onResume$1.INSTANCE);
        return;
    }

    public c0() {
        this.f237199d = new MutableLiveData();
        this.f237200e = new MutableLiveData();
    }

    public final void a(b r100, lm5.a r101, ShareParams r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "uiShareItemFactory");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f237201f = r102;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f237196a = r100;
        this.f237197b = r101;
        r102.getChannelHandlers();
        ShareItemList r103 = b();
        r103.c(this, r102);
        this.f237198c = r103;
        d();
        ShareItemList.b(r103.f237180a, ShareItemList$create$1.INSTANCE);
    }
}
