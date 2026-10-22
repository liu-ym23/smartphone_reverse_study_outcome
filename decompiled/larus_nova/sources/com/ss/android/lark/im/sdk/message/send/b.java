package com.ss.android.lark.im.sdk.message.send;

import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.im.sdk.service.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements jkb.d<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC5035b f425973a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.message.send.b$b, reason: collision with other inner class name */
    public interface InterfaceC5035b {
        long a();
    }

    static {
    }

    @Override // jkb.d
    public final String getName() {
        return "CheckFileSizeStep";
    }

    public b() {
        com.ss.android.lark.im.sdk.message.send.a r100 = com.ss.android.lark.im.sdk.message.send.a.f425972a;
        Intrinsics.checkNotNullParameter(r100, "maxSizeProvider");
        this.f425973a = r100;
    }

    @Override // jkb.d
    public final void a(jkb.b r110, jkb.c r111) {
        k r112 = (k) r110;
        Intrinsics.checkNotNullParameter(r112, "pipelineContext");
        Intrinsics.checkNotNullParameter(r111, "pipelineControl");
        MessageParams<?, ?> r100 = r112.f425987a;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.biz.im.api.FileMessageParams");
        com.ss.android.lark.biz.im.api.l r101 = (com.ss.android.lark.biz.im.api.l) r100;
        o r113 = r112.f425988b;
        long r102 = this.f425973a.a();
        boolean r103 = r113 instanceof n6b.a;
        if (r103 == false) goto L5;
        ((n6b.a) r113).b(r101.E);
    L5:
        long r104 = r101.E;
        if (r104 > r102) goto L8;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L14;
        if (r103 == false) goto L13;
        ((n6b.a) r113).n(r104, r102);
    L13:
        com.ss.android.lark.im.sdk.a.a("CheckFileSizeStep", "!fileSizeCheckPass");
        r111.b(new jkb.e("File size check failed, limit is " + r102 + ", but actual size is " + r101.E, 500600, true));
        return;
    L14:
        com.ss.android.lark.im.sdk.a.b("CheckFileSizeStep", "File size check pass");
        r113.i();
        r111.a();
        return;
    L8:
        r105 = false;
        goto L10
    }
}
