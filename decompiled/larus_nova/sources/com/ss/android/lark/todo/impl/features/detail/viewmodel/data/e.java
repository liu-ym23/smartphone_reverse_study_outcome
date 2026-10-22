package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.todo.v1.TodoUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f443853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TodoUser> f443854b;

    public final String toString() {
        return "MemberFieldValue(enableMulti=" + this.f443853a + ", users=" + this.f443854b + ')';
    }

    public final int hashCode() {
        if (this.f443853a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        List<TodoUser> r102 = this.f443854b;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L11;
        r103.add(((TodoUser) r104.next()).user_id);
        goto L8
    L11:
        return r101 + r103.hashCode();
    L5:
        r100 = 1237;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f443853a == r101.f443853a) goto L11;
        return false;
    L11:
        List<TodoUser> r102 = this.f443854b;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        r103.add(((TodoUser) r104.next()).user_id);
        goto L13
    L15:
        List<TodoUser> r105 = r101.f443854b;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L17:
        if (r107.hasNext() == false) goto L20;
        r106.add(((TodoUser) r107.next()).user_id);
        goto L17
    L20:
        if (Intrinsics.areEqual(r103, r106) == true) goto L22;
        return false;
    L22:
        return true;
    }

    public e(boolean r100, List<TodoUser> r101) {
        Intrinsics.checkNotNullParameter(r101, "users");
        this.f443853a = r100;
        this.f443854b = r101;
    }
}
