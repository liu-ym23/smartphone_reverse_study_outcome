package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public class bp extends br {
    private void a(long r100) {
        String[] r101 = this.f295a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length <= 0) goto L10;
        r101[0] = String.valueOf(r100);
        return;
    }

    @Override // com.xiaomi.push.bv.a
    public void a(Context r110, Object r111) {
        if ((r111 instanceof Long) == false) goto L9;
        long r100 = ((Long) r111).longValue();
        long r101 = bz.a(m8862a());
        long r102 = bn.f277a;
        if (r101 <= r102) goto L7;
        long r103 = (long) ((((r101 - r102) * 1.2d) / r102) * r100);
        a(r103);
        bm.a(r110).a("begin delete " + r103 + "noUpload messages , because db size is " + r101 + "B");
        super.a(r110, r111);
        return;
    L7:
        com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
        return;
    }

    public static bp a(Context r100, String r101, int r102) {
        com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
        String r103 = bv.a(r100).m8860a(r101);
        if (TextUtils.isEmpty(r103) == false) goto L6;
        return null;
    L6:
        StringBuilder r104 = new StringBuilder("rowDataId in (select ");
        r104.append("rowDataId from " + r103);
        r104.append(" order by createTimeStamp asc limit ?)");
        return new bp(r101, r104.toString(), new String[]{String.valueOf(r102)}, "a job build to delete history message");
    }

    public bp(String r100, String r101, String[] r102, String r103) {
        super(r100, r101, r102, r103);
    }
}
