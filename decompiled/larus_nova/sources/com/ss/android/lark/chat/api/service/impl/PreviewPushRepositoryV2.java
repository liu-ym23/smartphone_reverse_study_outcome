package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.im.v1.PushMessagePreviewsRequest;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class PreviewPushRepositoryV2 implements a2b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f411552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f411553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f411554c;

    public static final class a {
    }

    static {
    }

    @Override // a2b.d
    public final void a() {
        Disposable r100 = this.f411554c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Inject
    public PreviewPushRepositoryV2(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f411552a = r100;
        this.f411553b = r101;
    }

    @Override // a2b.d
    public final void b(final Function1<? super PushMessagePreviewsRequest, Unit> r100, final Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f411554c = com.ss.android.lark.chat.service.impl.y0.a("PreviewPushRepositoryV2", this.f411552a, new PreviewPushRepositoryV2$subscribeMessagePreviewPush$1(this, r100, r101));
    }
}
