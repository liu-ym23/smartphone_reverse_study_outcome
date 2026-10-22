package com.larus.chat.gallery.api.datasource;

import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.b0;
import com.larus.gallery.api.k;
import com.larus.im.bean.message.Message;
import com.larus.utils.m0;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
public abstract class BaseChatDataSource<T> implements IGalleryDataSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f324134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f324135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f324136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f324137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f324138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Message f324139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f324140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.chat.gallery.api.datasource.a f324141h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean b() {
        return false;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object c(Continuation<? super b0<? extends List<? extends T>>> r100) {
        return n(this, r100);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object f(T r100, Continuation<? super T> r101) {
        return r100;
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean h() {
        return true;
    }

    public abstract int l();

    public abstract List<Message> m();

    public abstract Object o(Message r100, Continuation<? super List<? extends T>> r101);

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final int k() {
        return this.f324140g;
    }

    public BaseChatDataSource(List<String> r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "messageTypeList");
        this.f324134a = r100;
        this.f324135b = r101;
        this.f324136c = getClass().getSimpleName();
        this.f324137d = true;
        this.f324138e = true;
        this.f324139f = r101;
        int r102 = m0.f375450a;
        this.f324140g = m0.b(AppHost.f326268a.getApplication().getApplicationContext()) / i5.A();
        this.f324141h = new com.larus.chat.gallery.api.datasource.a(r100, r101);
    }

    public static /* synthetic */ <T> Object n(BaseChatDataSource<T> r100, Continuation<? super b0<? extends List<? extends T>>> r101) {
        if ((r101 instanceof BaseChatDataSource$loadInitial$1) == false) goto L7;
        BaseChatDataSource$loadInitial$1 r102 = (BaseChatDataSource$loadInitial$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        List r107 = (List) r104;
        if (r107 != null) goto L21;
        r107 = CollectionsKt.emptyList();
    L21:
        return new b0.b(r107, true, true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Message r108 = r100.f324135b;
        r102.label = 1;
        r104 = r100.o(r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new BaseChatDataSource$loadInitial$1(r100, r101);
        goto L8
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object d(T r100, Continuation<? super b0<? extends List<? extends T>>> r101) {
        return CoroutineScopeKt.coroutineScope(new BaseChatDataSource$loadMore$2(this, null), r101);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object e(List<? extends T> r100, Continuation<? super List<? extends Pair<? extends T, k>>> r101) {
        return IGalleryDataSource.DefaultImpls.c(this, r100, r101);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final Object g(T r100, Continuation<? super b0<? extends List<? extends T>>> r101) {
        return CoroutineScopeKt.coroutineScope(new BaseChatDataSource$loadPrevious$2(this, null), r101);
    }

    @Override // com.larus.gallery.api.IGalleryDataSource
    public final boolean j(T r100, T r101) {
        return Intrinsics.areEqual(r100, r101);
    }
}
