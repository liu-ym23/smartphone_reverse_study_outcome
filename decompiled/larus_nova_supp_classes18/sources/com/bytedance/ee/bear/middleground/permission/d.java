package com.bytedance.ee.bear.middleground.permission;

import com.bytedance.ee.bear.middleground.permission.permission.doc.BatchDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.PermissionDataV2;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r3) {
        BatchDocUserPermission r4 = (BatchDocUserPermission) r3;
        Iterator r0 = ((ArrayList) ReadPermission.g).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ReadPermission r1 = (ReadPermission) r0.next();
        Intrinsics.checkNotNull(r4);
        ReadPermission.a(r1, r4);
        goto L4
    L6:
        Map<String, PermissionDataV2> r5 = ReadPermission.e;
        ReadPermission.a.a();
    }
}
