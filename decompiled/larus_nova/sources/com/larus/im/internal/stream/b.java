package com.larus.im.internal.stream;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f350138a = null;

    static {
        f350138a = new b();
    }

    public b() {
    }

    public final void a(nf9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        StreamDispatcher r101 = StreamDispatcher.f350097a;
        Intrinsics.checkNotNullParameter(r100, "observer");
        StreamDispatcher.f350099c.add(r100);
    }

    public final Integer c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        StreamChannel.f350095a.getClass();
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Typewriter.a r101 = Typewriter.f350104t;
        Typewriter r102 = Typewriter.a.a(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r102.f350112b);
    }

    public final void b(String r100, nf9.c r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "observer");
        StreamDispatcher r102 = StreamDispatcher.f350097a;
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "observer");
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L13;
        vt7.a<String, vt7.b<nf9.c>> r104 = StreamDispatcher.f350098b;
        vt7.b<nf9.c> r105 = r104.get(r100);
        if (r105 != null) goto L11;
        r105 = new vt7.b();
    L11:
        r105.add(r101);
        r104.put(r100, r105);
        return;
    L13:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final Integer d(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        StreamChannel.f350095a.getClass();
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Typewriter.a r102 = Typewriter.f350104t;
        Typewriter r103 = Typewriter.a.a(r100);
        if (r103 == null) goto L10;
        if (r101 != 0) goto L10;
        int r104 = r103.f350113c;
        if (r104 == r103.f350114d) goto L10;
        return Integer.valueOf(r104);
    L10:
        return null;
    }

    public final void e(String r100, nf9.c r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "observer");
        StreamDispatcher r102 = StreamDispatcher.f350097a;
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "observer");
        vt7.b<nf9.c> r103 = StreamDispatcher.f350098b.get(r100);
        if (r103 == null) goto L6;
        r103.remove(r101);
        return;
    }
}
