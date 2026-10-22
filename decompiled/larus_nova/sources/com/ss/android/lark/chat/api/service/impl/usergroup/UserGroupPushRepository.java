package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.im.v1.PushUserGroupEntitiesRequest;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.chat.service.impl.y0;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class UserGroupPushRepository implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f411673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f411674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f411675c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.api.service.impl.usergroup.b
    public final void b() {
        Disposable r100 = this.f411675c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Inject
    public UserGroupPushRepository(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f411673a = r100;
        this.f411674b = r101;
    }

    @Override // com.ss.android.lark.chat.api.service.impl.usergroup.b
    public final void a(final Function1<? super PushUserGroupEntitiesRequest, Unit> r100, final Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f411675c = y0.a("PreviewPushRepositoryV2", this.f411673a, new UserGroupPushRepository$subscribe$1(this, r100, r101));
    }
}
