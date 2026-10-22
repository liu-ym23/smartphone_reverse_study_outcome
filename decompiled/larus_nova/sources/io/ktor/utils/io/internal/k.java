package io.ktor.utils.io.internal;

import io.ktor.utils.io.q;
import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes41.dex */
public final class k implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f492102b = null;

    static {
        f492102b = new k();
    }

    public k() {
    }

    @Override // io.ktor.utils.io.p
    public final ByteBuffer b(int r100, int r101) {
        return null;
    }

    @Override // io.ktor.utils.io.p
    public final void a(int r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        throw new IllegalStateException("Unable to mark " + r100 + " bytes consumed for already terminated channel");
    }

    @Override // io.ktor.utils.io.q
    public final Object f(int r100, Continuation<? super Boolean> r101) {
        boolean r102 = true;
        if (r100 < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L17;
        if (r100 <= 4088) goto L11;
        r102 = false;
    L11:
        if (r102 == false) goto L15;
        return Boxing.boxBoolean(false);
    L15:
        throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + r100).toString());
    L17:
        throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + r100).toString());
    L5:
        r103 = false;
        goto L6
    }
}
