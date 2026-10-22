package com.bytedance.ee.bear.middleground.permission;

import com.bytedance.ee.bear.middleground.permission.permission.doc.BatchDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.PermissionDataV2;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f233828a = null;

    static {
        f233828a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BatchDocUserPermission r101 = (BatchDocUserPermission) r100;
        Iterator r102 = ((ArrayList) ReadPermission.f232833g).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ReadPermission r103 = (ReadPermission) r102.next();
        Intrinsics.checkNotNull(r101);
        ReadPermission.a(r103, r101);
        goto L4
    L6:
        Map<String, PermissionDataV2> r104 = ReadPermission.f232831e;
        ReadPermission.a.a();
    }
}
