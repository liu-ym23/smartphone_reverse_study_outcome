package com.bytedance.ee.bear.drive.test.item;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.c1;
import h85.j1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class p extends za5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f224691a;

    public p(q r100) {
        this.f224691a = r100;
    }

    @Override // za5.b, za5.a
    public final void a(List<String> r100, boolean r110) {
        j1 r111 = new j1();     // Catch: Exception -> L22
        ArrayList<? extends BaseOpenEntity> r101 = new ArrayList();     // Catch: Exception -> L22
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) r100).size()) goto L20;
        String r103 = c1.c(this.f224691a.f224692a, UriProtector.parse((String) ListProtector.get(r100, 0)));     // Catch: Exception -> L22
        String[] r104 = com.bytedance.ee.util.io.a.f243143a;     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r103) == false) goto L9;
        tt5.a.k("FilePropsUtil", "FilePropsUtil.java.getFileNameByFilePath: filePath is empty");     // Catch: Exception -> L22
    L18:
        String r105 = "";
    L19:
        r101.add(new LocalOpenEntity(r105, "", null, r103));     // Catch: Exception -> L22
        r102 = r102 + 1;     // Catch: Exception -> L22
        goto L4
    L9:
        int r106 = r103.lastIndexOf(HTTP.URL_DEFAULT);     // Catch: Exception -> L22
        if (r106 != (-1)) goto L25;
        tt5.a.k("FilePropsUtil", "FilePropsUtil.java.getFileNameByFilePath: slash index is invalid");     // Catch: Exception -> L22
        r105 = r103;
        goto L19
    L25:
        r105 = r103.substring(r106 + 1);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        tt5.a.e("FilePropsUtil", "getFileNameByFilePath: ", e, false);     // Catch: Exception -> L22
        goto L18
    L20:
        r111.h(this.f224691a.f224692a, r101, 0);     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        tt5.a.d("localFileTestItem", "onSelectFileList: " + e);
    }
}
