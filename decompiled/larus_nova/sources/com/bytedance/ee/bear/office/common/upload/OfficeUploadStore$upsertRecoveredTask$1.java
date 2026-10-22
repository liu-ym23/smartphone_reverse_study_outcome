package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeUploadStore$upsertRecoveredTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h0 $task;

    public OfficeUploadStore$upsertRecoveredTask$1(h0 r100) {
        this.$task = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LinkedHashMap<String, h0> r100 = OfficeUploadStore.f235312c;
        int r101 = r100.size();
        int r102 = f0.f235362a;
        List r103 = f0.d(CollectionsKt.toList(r100.values()), this.$task);
        StringBuilder r104 = new StringBuilder("office_upload_recovery_trace upsert_recovered keyHash=");
        String r105 = this.$task.f235374b;
        if (r105 == null) goto L5;
        Integer r106 = Integer.valueOf(r105.hashCode());
    L6:
        r104.append(r106);
        r104.append(" before=");
        r104.append(r101);
        r104.append(" after=");
        r104.append(r103.size());
        r104.append(" nameLen=");
        r104.append(this.$task.f235377e.length());
        r104.append(" total=");
        r104.append(this.$task.f235379g);
        r104.append(" beforeItems=");
        r104.append(OfficeUploadStore.b(r100.values()));
        r104.append(" afterItems=");
        r104.append(OfficeUploadStore.b(r103));
        tt5.a.h("OfficeUploadStore", r104.toString());
        r100.clear();
        Iterator r107 = r103.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        h0 r108 = (h0) r107.next();
        OfficeUploadStore.f235312c.put(r108.f235373a, r108);
        goto L8
    L10:
        Handler r109 = OfficeUploadStore.f235310a;
        OfficeUploadStore.a();
        OfficeUploadStore.d();
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
