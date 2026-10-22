package com.bytedance.ee.bear.drive.view.preview.excel;

import android.util.Base64;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ExcelCacheHelper {
    public final List<String> a;

    public final void a() {
        if (hu5.a.d(this.a) == true) goto L6;
        ArrayList r0 = (ArrayList) this.a;
        final String[] r1 = (String[]) r0.toArray(new String[0]);
        Flowable.just("").subscribeOn(fo5.d.b()).doOnNext(new c(r1)).subscribe(new d(), new e());
        return;
    }

    public ExcelCacheHelper() {
        this.a = new ArrayList();
    }

    public static String c(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("key", r2);
        r0.put("value", r3);
        return Base64.encodeToString(r0.toJSONString().getBytes(), 2);
    }

    public final Flowable<DriveFilePath> b(String r16, final t r17, final DriveFilePath r18, final String r19, final String r110, final String r20, final String r21, final String r22, final String r23, final DrivePriority.DownloadPriority r24, a95.a r26) {
        final String r3 = UriProtector.parse(r16).buildUpon().appendQueryParameter("sub_id", r21).build().toString();
        r18.cacheName(du5.d.a(r19 + r110 + r20 + r21));
        final String r2 = z75.b.a(r18, r26.b);
        return Flowable.create(new AnonymousClass1(this, r2, r3, r20, r23, r22, r24, r19, r110, r21, r18, r17), BackpressureStrategy.BUFFER);
    }
}
