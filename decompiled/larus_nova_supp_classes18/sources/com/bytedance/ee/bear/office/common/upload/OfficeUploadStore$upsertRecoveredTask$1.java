package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeUploadStore$upsertRecoveredTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h0 $task;

    public OfficeUploadStore$upsertRecoveredTask$1(h0 r1) {
        this.$task = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m342invoke() {
        LinkedHashMap<String, h0> r0 = OfficeUploadStore.c;
        int r1 = r0.size();
        int r2 = f0.a;
        List r3 = f0.d(CollectionsKt.toList(r0.values()), this.$task);
        StringBuilder r4 = new StringBuilder("office_upload_recovery_trace upsert_recovered keyHash=");
        String r5 = this.$task.b;
        if (r5 == null) goto L5;
        Integer r6 = Integer.valueOf(r5.hashCode());
    L6:
        r4.append(r6);
        r4.append(" before=");
        r4.append(r1);
        r4.append(" after=");
        r4.append(r3.size());
        r4.append(" nameLen=");
        r4.append(this.$task.e.length());
        r4.append(" total=");
        r4.append(this.$task.g);
        r4.append(" beforeItems=");
        r4.append(OfficeUploadStore.b(r0.values()));
        r4.append(" afterItems=");
        r4.append(OfficeUploadStore.b(r3));
        tt5.a.h("OfficeUploadStore", r4.toString());
        r0.clear();
        Iterator r7 = r3.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        h0 r8 = (h0) r7.next();
        OfficeUploadStore.c.put(r8.a, r8);
        goto L8
    L10:
        Handler r9 = OfficeUploadStore.a;
        OfficeUploadStore.a();
        OfficeUploadStore.d();
        return;
    L5:
        r6 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m342invoke();
        return Unit.INSTANCE;
    }
}
