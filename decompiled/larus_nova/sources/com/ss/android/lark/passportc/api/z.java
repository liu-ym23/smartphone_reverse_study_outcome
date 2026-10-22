package com.ss.android.lark.passportc.api;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes37.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<User> f438120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f438121b;

    public z() {
        throw null;
    }

    public abstract String a();

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(a());
        r100.append(", expectedBackgroundUserList=");
        List<User> r101 = this.f438120a;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((User) r103.next()).userId);
        goto L4
    L6:
        r100.append(r102);
        r100.append(",updateBackground = ");
        r100.append(this.f438121b);
        return r100.toString();
    }

    public /* synthetic */ z(List r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100, false);
    }

    public z(List r100, boolean r101) {
        this.f438120a = r100;
        this.f438121b = r101;
    }
}
