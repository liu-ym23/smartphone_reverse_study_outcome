package com.larus.home.impl.sdk;

import com.collection.profile.api.CollectServiceDelegate;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.SaveCollectionResponse;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j1 f346191a = null;

    static {
        f346191a = new j1();
    }

    public j1() {
    }

    public final boolean e() {
        return CollectServiceDelegate.f273530b.a();
    }

    public final com.larus.platform.api.y0 f() {
        return CollectServiceDelegate.f273530b.b();
    }

    public final com.larus.platform.api.y0 g() {
        return CollectServiceDelegate.f273530b.h();
    }

    public final void h() {
        CollectServiceDelegate.f273530b.j();
    }

    public final Object a(String r100, Continuation<? super com.larus.network.http.a<CancelCollectionResponse>> r101) {
        return CollectServiceDelegate.f273530b.e(r100, r101);
    }

    public final Object b(List<Message> r100, Continuation<? super Boolean> r101) {
        return CollectServiceDelegate.f273530b.i(r100, r101);
    }

    public final Object c(Message r100, int r101, Continuation<? super com.larus.network.http.a<CancelCollectionResponse>> r102) {
        return CollectServiceDelegate.f273530b.g(r100, r101, r102);
    }

    public final Object d(int r100, List<Message> r101, Continuation<? super com.larus.network.http.a<SaveCollectionResponse>> r102) {
        return CollectServiceDelegate.f273530b.f(r100, r101, r102);
    }
}
