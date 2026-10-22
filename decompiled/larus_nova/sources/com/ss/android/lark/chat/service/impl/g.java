package com.ss.android.lark.chat.service.impl;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class g implements m6b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f416476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f416477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f416478c;

    public static final class a {
    }

    static {
    }

    @Override // m6b.b
    public final void b() {
        Disposable r100 = this.f416478c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Inject
    public g(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f416476a = r100;
        this.f416477b = r101;
    }

    @Override // m6b.b
    public final void a(final d r100, final b r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f416478c = y0.a("AudioTextPushRepositoryV2", this.f416476a, new AudioTextPushRepositoryV2$subscribeAudioMessageRecognitionResultPush$1(this, r100, r101));
    }
}
