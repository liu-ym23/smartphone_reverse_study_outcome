package com.bytedance.ee.bear.middleground.comment.share;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ SharePermissionViewModel a;
    public final /* synthetic */ List<String> b;
    public final /* synthetic */ Function1<Map<String, SharePermissionViewModel.b>, Unit> c;
    public final /* synthetic */ Map<String, SharePermissionViewModel.b> d;

    /* JADX WARN: Multi-variable type inference failed */
    public a(SharePermissionViewModel r1, List<String> r2, Function1<? super Map<String, SharePermissionViewModel.b>, Unit> r3, Map<String, SharePermissionViewModel.b> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r8) {
        HashMap r9 = (HashMap) r8;
        Map<String, IDocUserPermission> r0 = this.a.f;
        Intrinsics.checkNotNull(r9);
        r0.putAll(r9);
        List<String> r1 = this.b;
        Map<String, SharePermissionViewModel.b> r2 = this.d;
        SharePermissionViewModel r3 = this.a;
        Iterator<T> r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L15;
        String r5 = (String) r4.next();
        IDocUserPermission r6 = (IDocUserPermission) r9.get(r5);
        if (r6 == null) goto L4;
        r3.getClass();
        if (r6.canRead() == false) goto L10;
    L13:
        boolean r7 = true;
    L14:
        r2.put(r5, new SharePermissionViewModel.b(r7, r3.e()));
        goto L4
    L10:
        if (r6.canPerceive() == true) goto L13;
        r7 = false;
        goto L14
    L15:
        this.c.invoke(this.d);
    }
}
