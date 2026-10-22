package io.ktor.client.content;

import io.ktor.http.b;
import io.ktor.http.content.c;
import io.ktor.http.n;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.k;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends c.AbstractC6311c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f491638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f491639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<Long, Long, Continuation<? super Unit>, Object> f491640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ByteReadChannel f491641d;

    @Override // io.ktor.http.content.c
    public final Long a() {
        return this.f491638a.a();
    }

    @Override // io.ktor.http.content.c
    public final b b() {
        return this.f491638a.b();
    }

    @Override // io.ktor.http.content.c
    public final n c() {
        return this.f491638a.c();
    }

    @Override // io.ktor.http.content.c.AbstractC6311c
    public final ByteReadChannel d() {
        return io.ktor.client.utils.a.a(this.f491641d, this.f491639b, a(), this.f491640c);
    }

    public a(c r100, Job r101, Function3 r102) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "callContext");
        Intrinsics.checkNotNullParameter(r102, "listener");
        this.f491638a = r100;
        this.f491639b = r101;
        this.f491640c = r102;
        if ((r100 instanceof c.a) == false) goto L6;
        io.ktor.utils.io.b r103 = io.ktor.utils.io.c.a(((c.a) r100).d());
    L14:
        this.f491641d = r103;
        return;
    L6:
        if ((r100 instanceof c.b) == false) goto L9;
        ByteReadChannel.f492010a.getClass();
        r103 = ByteReadChannel.Companion.f492012b.getValue();
        goto L14
    L9:
        if ((r100 instanceof c.AbstractC6311c) == false) goto L12;
        r103 = ((c.AbstractC6311c) r100).d();
        goto L14
    L12:
        if ((r100 instanceof c.d) == false) goto L17;
        r103 = k.a(GlobalScope.INSTANCE, r101, true, new ObservableContent$content$1(this, null)).f492055b;
        goto L14
    L17:
        throw new NoWhenBranchMatchedException();
    }
}
