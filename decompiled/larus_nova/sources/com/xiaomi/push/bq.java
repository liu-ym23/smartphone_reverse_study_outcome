package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class bq extends bv.b<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f463207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f280a;

    @Override // com.xiaomi.push.bv.a
    /* JADX INFO: renamed from: a */
    public Object mo8861a() {
        return Long.valueOf(this.f463207a);
    }

    public static bq a(String r110) {
        ArrayList r100 = new ArrayList();
        r100.add("count(*)");
        return new bq(r110, r100, null, null, null, null, null, 0, "job to get count of all message");
    }

    @Override // com.xiaomi.push.bv.b
    public void a(Context r100, List<Long> r101) {
        if (r100 == null) goto L8;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() <= 0) goto L10;
        this.f463207a = ((Long) ListProtector.get(r101, 0)).longValue();
        return;
    L10:
        return;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.bv.b
    public Long a(Context r100, Cursor r101) {
        return Long.valueOf(r101.getLong(0));
    }

    @Override // com.xiaomi.push.bv.b
    public /* bridge */ /* synthetic */ Long a(Context r100, Cursor r101) {
        return a(r100, r101);
    }

    public bq(String r100, List<String> r101, String r102, String[] r103, String r104, String r105, String r106, int r107, String r108) {
        super(r100, r101, r102, r103, r104, r105, r106, r107);
        this.f463207a = 0;
        this.f280a = r108;
    }
}
