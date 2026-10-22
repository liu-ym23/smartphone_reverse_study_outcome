package com.larus.audio.flow.client.cache;

import com.larus.audio.utils.o0;
import com.larus.audio.utils.q0;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements com.larus.audio.flow.client.cache.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f289735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f289736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BufferedOutputStream f289737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OutputStream f289738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f289739e;

    public static final class a {
    }

    static {
    }

    public final void d() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        BufferedOutputStream r101 = this.f289737c;     // Catch: Throwable -> L10
        if (r101 == null) goto L5;
        r101.close();     // Catch: Throwable -> L10
    L5:
        this.f289737c = null;     // Catch: Throwable -> L10
        OutputStream r102 = this.f289738d;     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        r102.close();     // Catch: Throwable -> L10
    L8:
        this.f289738d = null;     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public c(int r100) {
        this.f289735a = r100;
        this.f289736b = LazyKt.lazy(new b(this));
        this.f289739e = 8192;
    }

    @Override // com.larus.audio.flow.client.cache.a
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        int r102 = c68.b.f22600a;
        c68.b.d("LRUTtsCache", "prepareSave key: ".concat(r100));
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        o0 r104 = (o0) this.f289736b.getValue();     // Catch: Throwable -> L15
        if (r104 == null) goto L12;
        OutputStream r105 = r104.d(r100).b();     // Catch: Throwable -> L15
        this.f289738d = r105;     // Catch: Throwable -> L15
        this.f289737c = new BufferedOutputStream(r105, this.f289739e);     // Catch: Throwable -> L15
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L15
    L17:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L23;
        delete(r100);
        d();
        int r109 = c68.b.f22600a;
        c68.b.c("LRUTtsCache", "prepareSave key: " + r100 + " error: ", r108);
        return;
    L23:
        return;
    L12:
        r106 = null;
    L15:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.audio.flow.client.cache.a
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        o0 r102 = (o0) this.f289736b.getValue();     // Catch: Throwable -> L17
        boolean r103 = false;
        if (r102 == null) goto L16;
        monitor-enter(r102);     // Catch: Throwable -> L17
        r102.b();     // Catch: Throwable -> L13
        o0.p(r100);     // Catch: Throwable -> L13
        o0.d r104 = r102.f290107k.get(r100);     // Catch: Throwable -> L13
        if (r104 == null) goto L11;
        if (r104.f290120c == false) goto L11;
        r103 = true;
        goto L11
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L17
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L22;
        r106 = r107;
    L22:
        return ((Boolean) r106).booleanValue();
    }

    @Override // com.larus.audio.flow.client.cache.a
    public void delete(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        o0 r102 = (o0) this.f289736b.getValue();     // Catch: Throwable -> L16
        if (r102 == null) goto L13;
        r102.d(r100).a();     // Catch: Throwable -> L16
        r102.k(r100);     // Catch: Throwable -> L16
        monitor-enter(r102);     // Catch: Throwable -> L16
        r102.b();     // Catch: Throwable -> L10
        r102.n();     // Catch: Throwable -> L10
        r102.m();     // Catch: Throwable -> L10
        r102.f290106j.flush();     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L16
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L16
    L18:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L25;
        int r106 = c68.b.f22600a;
        c68.b.c("LRUTtsCache", "deleteByKey key: " + r100 + " error: ", r105);
        return;
    L25:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L13:
        r103 = null;
    L16:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    @Override // com.larus.audio.flow.client.cache.a
    public final void a(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        int r102 = c68.b.f22600a;
        c68.b.d("LRUTtsCache", "endSave key: " + r100 + ", success: " + r110);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L28
        if (r110 == false) goto L25;
        o0 r104 = (o0) this.f289736b.getValue();     // Catch: Throwable -> L28
        if (r104 == null) goto L24;
        o0.c r105 = r104.d(r100);     // Catch: Throwable -> L28
        if (r105.f290115c == false) goto L16;
        o0.a(r105.f290116d, r105, false);     // Catch: Throwable -> L28
        r105.f290116d.k(r105.f290113a.f290118a);     // Catch: Throwable -> L28
    L17:
        monitor-enter(r104);     // Catch: Throwable -> L28
        r104.b();     // Catch: Throwable -> L21
        r104.n();     // Catch: Throwable -> L21
        r104.m();     // Catch: Throwable -> L21
        r104.f290106j.flush();     // Catch: Throwable -> L21
        monitor-exit(r104);     // Catch: Throwable -> L28
        goto L24
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L16:
        o0.a(r105.f290116d, r105, true);     // Catch: Throwable -> L28
    L24:
        d();     // Catch: Throwable -> L28
    L26:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L37;
        delete(r100);
        d();
        int r108 = c68.b.f22600a;
        c68.b.c("LRUTtsCache", "endSave key: " + r100 + ", success: " + r110 + " error: ", r107);
        return;
    L37:
        return;
    L25:
        delete(r100);     // Catch: Throwable -> L28
        d();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.audio.flow.client.cache.a
    public final void b(String r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "ttsContent");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L24
        boolean r103 = true;
        int r104 = 0;
        if (r100.length() != 0) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L9;
        return;
    L9:
        if (r101.length == 0) goto L12;
        r103 = false;
    L12:
        if (r103 == true) goto L35;
        int r106 = c68.b.f22600a;     // Catch: Throwable -> L24
        c68.b.d("LRUTtsCache", "save key: " + r100 + ", ttsContent size: " + r101.length);     // Catch: Throwable -> L24
    L16:
        if (r104 >= r101.length) goto L21;
        int r107 = Math.min(this.f289739e, r101.length - r104);     // Catch: Throwable -> L24
        BufferedOutputStream r108 = this.f289737c;     // Catch: Throwable -> L24
        if (r108 == null) goto L20;
        r108.write(r101, r104, r107);     // Catch: Throwable -> L24
    L20:
        r104 = r104 + r107;     // Catch: Throwable -> L24
        goto L16
    L21:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L36;
        delete(r100);
        d();
        int r111 = c68.b.f22600a;
        c68.b.c("LRUTtsCache", "save key: " + r100 + ", ttsContent size: " + r101.length + " error: ", r110);
        return;
    L36:
        return;
    L35:
        return;
    L6:
        r105 = false;
    L24:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    @Override // com.larus.audio.flow.client.cache.a
    public Flow<byte[]> query(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        o0 r102 = (o0) this.f289736b.getValue();     // Catch: Exception -> L12
        if (r102 == null) goto L14;
        o0.e r103 = r102.e(r100);     // Catch: Exception -> L12
        if (r103 == null) goto L14;
        File r104 = r103.f290124b[0];     // Catch: Exception -> L12
        if (r104 == null) goto L14;
        return q0.a(r104, r101);
    L14:
        return null;
    L12:
        e = move-exception;
        int r105 = c68.b.f22600a;
        c68.b.c("LRUTtsCache", "query key: " + r100 + " error: ", e);
        return null;
    }
}
