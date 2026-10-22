package com.bytedance.ee.bear.drive.test.item;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.c1;
import h85.j1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p extends za5.b {
    public final /* synthetic */ q a;

    public p(q r1) {
        this.a = r1;
    }

    @Override // za5.b, za5.a
    public final void a(List<String> r9, boolean r10) {
        j1 r11 = new j1();     // Catch: Exception -> L22
        ArrayList<? extends BaseOpenEntity> r0 = new ArrayList();     // Catch: Exception -> L22
        int r2 = 0;
    L4:
        if (r2 >= ((ArrayList) r9).size()) goto L20;
        String r3 = c1.c(this.a.a, UriProtector.parse((String) ListProtector.get(r9, 0)));     // Catch: Exception -> L22
        String[] r4 = com.bytedance.ee.util.io.a.a;     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r3) == false) goto L9;
        tt5.a.k("FilePropsUtil", "FilePropsUtil.java.getFileNameByFilePath: filePath is empty");     // Catch: Exception -> L22
    L18:
        String r5 = "";
    L19:
        r0.add(new LocalOpenEntity(r5, "", null, r3));     // Catch: Exception -> L22
        r2 = r2 + 1;     // Catch: Exception -> L22
        goto L4
    L9:
        int r6 = r3.lastIndexOf("/");     // Catch: Exception -> L22
        if (r6 != (-1)) goto L25;
        tt5.a.k("FilePropsUtil", "FilePropsUtil.java.getFileNameByFilePath: slash index is invalid");     // Catch: Exception -> L22
        r5 = r3;
        goto L19
    L25:
        r5 = r3.substring(r6 + 1);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        tt5.a.e("FilePropsUtil", "getFileNameByFilePath: ", e, false);     // Catch: Exception -> L22
        goto L18
    L20:
        r11.h(this.a.a, r0, 0);     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        tt5.a.d("localFileTestItem", "onSelectFileList: " + e);
    }
}
