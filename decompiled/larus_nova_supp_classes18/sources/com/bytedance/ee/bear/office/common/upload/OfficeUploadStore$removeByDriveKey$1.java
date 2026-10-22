package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeUploadStore$removeByDriveKey$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $driveKey;

    public OfficeUploadStore$removeByDriveKey$1(String r1) {
        this.$driveKey = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m334invoke() {
        int r0 = f0.a;
        List r1 = CollectionsKt.toList(OfficeUploadStore.c.values());
        String r2 = this.$driveKey;
        Intrinsics.checkNotNullParameter(r1, "current");
        Intrinsics.checkNotNullParameter(r2, "driveKey");
        ArrayList r3 = new ArrayList();
        Iterator r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((h0) r5).b, r2) == true) goto L4;
        r3.add(r5);
        goto L4
    L8:
        OfficeUploadStore.c.clear();
        Iterator r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        h0 r7 = (h0) r6.next();
        OfficeUploadStore.c.put(r7.a, r7);
        goto L10
    L12:
        Handler r8 = OfficeUploadStore.a;
        OfficeUploadStore.a();
        OfficeUploadStore.d();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m334invoke();
        return Unit.INSTANCE;
    }
}
