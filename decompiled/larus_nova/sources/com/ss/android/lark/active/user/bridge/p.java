package com.ss.android.lark.active.user.bridge;

import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.internal.v;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p<Param, Resp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r<Param, Resp> f408577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.j f408578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.j f408579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IUserListService f408580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final mua.a f408581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.i f408582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v f408583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.b f408584h;

    public final b<Resp> c() {
        final String r100 = this.f408577a.f408586a;
        return (b) Observable.create(new UserScopeBridgeCallImpl$findUserComponent$1(this, r100)).map(new k(this)).onErrorReturn(l.f408573a).doOnSubscribe(new m(this)).doOnNext(n.f408575a).doOnError(o.f408576a).blockingFirst();
    }

    public static final String a(p r100, UserSession r101) {
        r100.getClass();
        return "userId=" + r101.f438138b + ", sessionKey=" + r101.f438137a;
    }

    public static final UserSession b(p r100, String r101) {
        List<f0c.b> r102 = r100.f408578b.a();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L3:
        String r105 = null;
        if (r104.hasNext() == false) goto L13;
        Object r106 = r104.next();
        f0c.g r107 = ((f0c.b) r106).a();
        if (r107 == null) goto L11;
        UserSession r108 = r107.f475034b;
        if (r108 == null) goto L11;
        r105 = r108.f438138b;
    L11:
        if (Intrinsics.areEqual(r105, r101) == false) goto L3;
        r103.add(r106);
        goto L3
    L13:
        Iterator r109 = r103.iterator();
    L15:
        if (r109.hasNext() == false) goto L22;
        Object r110 = r109.next();
        if (((f0c.b) r110).f475024b.f475035a != UserState.ONLINE) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == false) goto L15;
    L23:
        f0c.b r112 = (f0c.b) r110;
        if (r112 != null) goto L26;
        r112 = (f0c.b) CollectionsKt.firstOrNull(r103);
    L26:
        if (r112 == null) goto L41;
        f0c.g r113 = r112.a();
        if (r113 != null) goto L30;
        return null;
    L30:
        return r113.f475034b;
    L41:
        return null;
    L19:
        r111 = false;
        goto L20
    L22:
        r110 = null;
        goto L23
    }

    public p(r<Param, Resp> r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.api.j r102, IUserListService r103, mua.a r104, com.ss.android.lark.passportc.api.i r105, v r106, com.ss.android.lark.passportc.internal.b r107) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "globalPassportService");
        Intrinsics.checkNotNullParameter(r103, "userService");
        Intrinsics.checkNotNullParameter(r104, "multiSwitch");
        Intrinsics.checkNotNullParameter(r105, "multiUserFG");
        Intrinsics.checkNotNullParameter(r106, "accessor");
        Intrinsics.checkNotNullParameter(r107, "backgroundAccessor");
        this.f408577a = r100;
        this.f408578b = r101;
        this.f408579c = r102;
        this.f408580d = r103;
        this.f408581e = r104;
        this.f408582f = r105;
        this.f408583g = r106;
        this.f408584h = r107;
    }
}
