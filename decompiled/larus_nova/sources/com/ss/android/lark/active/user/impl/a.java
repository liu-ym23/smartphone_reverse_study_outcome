package com.ss.android.lark.active.user.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.storage.LarkKVStorage;
import com.suite.lark.component.protocol.Biz;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class a implements nua.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f408621a;

    /* JADX INFO: renamed from: com.ss.android.lark.active.user.impl.a$a, reason: collision with other inner class name */
    public static final class C4741a {
    }

    static {
    }

    @Override // nua.a
    public final List<String> a() {
        List<String> r100 = null;
        Set<String> r101 = LarkKVStorage.f(j6c.a.a(Biz.Core), "biz.cross_tenant.user_select", null).getStringSet("biz.cross_tenant.user_select", null);
        if (r101 == null) goto L5;
        r100 = CollectionsKt.toList(r101);
    L5:
        StringBuilder r102 = new StringBuilder("fetch select save tenant user ids ");
        if (r100 == null) goto L8;
        Object r103 = Integer.valueOf(r100.size());
    L9:
        r102.append(r103);
        Log.i("GlobalActiveUserSelect", r102.toString());
        return r100;
    L8:
        r103 = "null";
        goto L9
    }

    @Inject
    public a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "userListApi");
        this.f408621a = r100;
    }
}
