package s0a;

import com.larus.im.internal.delegate.c0;
import com.larus.platform.api.creation.UserCreation;
import gd9.v;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements j0a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f540032a;

    /* JADX INFO: renamed from: s0a.a$a, reason: collision with other inner class name */
    public static final class C7553a {
    }

    static {
    }

    public a(v r100) {
        Intrinsics.checkNotNullParameter(r100, "networkDepend");
        this.f540032a = r100;
    }

    @Override // j0a.b
    public final Object a(String r110, boolean r111) {
        c r100 = new c(CollectionsKt.listOf(r110), r111);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L29
        gd9.e r113 = this.f540032a.h().d("/creativity/community/creation/mget", r100, null, null, null);     // Catch: Throwable -> L29
        if (r113.c() == true) goto L6;
        c0.f348199b.i("CreationDetailRepositoryKmp", "fetchCreationDetail http failed, status=" + r113.f480966b);     // Catch: Throwable -> L29
        Object r114 = j0a.a.b.f496837a;     // Catch: Throwable -> L29
    L27:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L29
    L31:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L38;
        c0.f348199b.e("CreationDetailRepositoryKmp", "fetchCreationDetail exception: " + r116);
        return j0a.a.b.f496837a;
    L38:
        return r115;
    L6:
        String r117 = r113.f480968d;     // Catch: Throwable -> L29
        if (r117 != null) goto L9;
    L12:
        boolean r118 = true;
    L13:
        if (r118 == false) goto L15;
        r114 = j0a.a.b.f496837a;     // Catch: Throwable -> L29
        goto L27
    L15:
        e r119 = (e) xt7.d.f565073b.c(e.Companion.serializer(), r117);     // Catch: Throwable -> L29
        if (r119.f540042a == 0) goto L18;
        c0.f348199b.i("CreationDetailRepositoryKmp", "fetchCreationDetail biz failed, code=" + r119.f540042a);     // Catch: Throwable -> L29
        r114 = j0a.a.b.f496837a;     // Catch: Throwable -> L29
        goto L27
    L18:
        g r120 = r119.f540044c;     // Catch: Throwable -> L29
        if (r120 == null) goto L23;
        List<UserCreation> r121 = r120.f540048a;     // Catch: Throwable -> L29
        if (r121 == null) goto L23;
        UserCreation r122 = (UserCreation) CollectionsKt.firstOrNull(r121);     // Catch: Throwable -> L29
    L24:
        if (r122 != null) goto L26;
        r114 = j0a.a.C6380a.f496836a;     // Catch: Throwable -> L29
        goto L27
    L26:
        r114 = new j0a.a.c(r122);     // Catch: Throwable -> L29
    L23:
        r122 = null;
        goto L24
    L9:
        if (r117.length() == 0) goto L12;
        r118 = false;
    L29:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    @Override // j0a.b
    public final Object b(String r110, boolean r111) {
        boolean r100 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return Boxing.boxBoolean(false);
    L13:
        if (r111 == false) goto L15;
        int r112 = 1;
    L16:
        d r102 = new d(r110, r112);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L37
        gd9.e r114 = this.f540032a.h().d("/creativity/community/creation/like_action", r102, null, null, null);     // Catch: Throwable -> L37
        if (r114.c() == true) goto L20;
        c0.f348199b.i("CreationDetailRepositoryKmp", "likeAction http failed, status=" + r114.f480966b);     // Catch: Throwable -> L37
    L28:
        r100 = false;
    L35:
        Object r115 = Result.m9449constructorimpl(Boxing.boxBoolean(r100));     // Catch: Throwable -> L37
    L39:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r115);
        if (r103 == null) goto L46;
        c0.f348199b.e("CreationDetailRepositoryKmp", "likeAction exception: " + r103);
        return Boxing.boxBoolean(false);
    L46:
        return r115;
    L20:
        String r116 = r114.f480968d;     // Catch: Throwable -> L37
        if (r116 != null) goto L23;
    L26:
        boolean r104 = true;
    L27:
        if (r104 == true) goto L28;
        h r117 = (h) xt7.d.f565073b.c(h.Companion.serializer(), r116);     // Catch: Throwable -> L37
        if (r117.f540051a == 0) goto L33;
        r100 = false;
    L33:
        if (r100 == true) goto L35;
        c0.f348199b.i("CreationDetailRepositoryKmp", "likeAction biz failed, code=" + r117.f540051a);     // Catch: Throwable -> L37
        goto L35
    L23:
        if (r116.length() == 0) goto L26;
        r104 = false;
    L37:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L15:
        r112 = 2;
        goto L16
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
