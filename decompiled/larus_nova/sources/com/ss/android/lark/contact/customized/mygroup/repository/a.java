package com.ss.android.lark.contact.customized.mygroup.repository;

import com.bytedance.lark.pb.im.v1.GetMyGroupChatsRequest;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final GetMyGroupChatsRequest.Type f419290e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f419291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f419292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f419293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Chat> f419294d;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.mygroup.repository.a$a, reason: collision with other inner class name */
    public static final class C4937a {
    }

    static {
        f419290e = GetMyGroupChatsRequest.Type.ALL;
    }

    public a() {
        this.f419291a = true;
        this.f419294d = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.ss.android.lark.contact.customized.mygroup.repository.OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1] */
    public final void a(final UIGetDataCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.f419292b == false) goto L5;
        return;
    L5:
        this.f419292b = true;
        ContactBaseModuleDependency.f418857b.getClass();
        ContactBaseModuleDependency.a().f(this.f419293c, f419290e, new OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1(this, r100));
    }

    public final void b(List<? extends Chat> r100) {
        if (this.f419293c != 0) goto L6;
        ((ArrayList) this.f419294d).clear();
        ArrayList r101 = (ArrayList) this.f419294d;
        r101.addAll(r100);
        return;
    L6:
        HashSet r102 = new HashSet(r100.size());
        Iterator<T> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.add(((Chat) r103.next()).getId());
        goto L8
    L10:
        Iterator r104 = ((ArrayList) this.f419294d).iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        if (r102.contains(((Chat) r104.next()).getId()) == false) goto L12;
        r104.remove();
        goto L12
    L16:
        ArrayList r105 = (ArrayList) this.f419294d;
        r105.addAll(r100);
    }
}
