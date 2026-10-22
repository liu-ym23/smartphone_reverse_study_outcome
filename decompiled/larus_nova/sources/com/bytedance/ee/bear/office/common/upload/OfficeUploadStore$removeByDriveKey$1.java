package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeUploadStore$removeByDriveKey$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $driveKey;

    public OfficeUploadStore$removeByDriveKey$1(String r100) {
        this.$driveKey = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = f0.f235362a;
        List r101 = CollectionsKt.toList(OfficeUploadStore.f235312c.values());
        String r102 = this.$driveKey;
        Intrinsics.checkNotNullParameter(r101, "current");
        Intrinsics.checkNotNullParameter(r102, "driveKey");
        ArrayList r103 = new ArrayList();
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((h0) r105).f235374b, r102) == true) goto L4;
        r103.add(r105);
        goto L4
    L8:
        OfficeUploadStore.f235312c.clear();
        Iterator r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        h0 r107 = (h0) r106.next();
        OfficeUploadStore.f235312c.put(r107.f235373a, r107);
        goto L10
    L12:
        Handler r108 = OfficeUploadStore.f235310a;
        OfficeUploadStore.a();
        OfficeUploadStore.d();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
