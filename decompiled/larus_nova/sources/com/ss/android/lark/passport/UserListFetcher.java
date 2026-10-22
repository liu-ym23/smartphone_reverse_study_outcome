package com.ss.android.lark.passport;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class UserListFetcher implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f437676c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f437677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f437678b;

    public static final class a {
    }

    static {
        f437676c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    @Override // com.ss.android.lark.passport.b
    public final Function0<Unit> register() {
        Log.i("UserListFetcher", "current user id is " + this.f437677a);
        final Disposable r100 = t.g(this.f437678b.i(Command.PUSH_CHATTERS, Entity.ADAPTER), new UserListFetcher$register$dis$1(this), UserListFetcher$register$dis$2.INSTANCE);
        return new AnonymousClass1(r100);
    }

    @Inject
    public UserListFetcher(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userRustClient");
        this.f437677a = r100;
        this.f437678b = r101;
    }
}
