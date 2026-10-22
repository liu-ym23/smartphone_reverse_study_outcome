package com.bytedance.ee.bear.drive.test.item;

import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.log.Log;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T, R> implements Function {
    public final /* synthetic */ DriveUploadTestItem a;

    public k(DriveUploadTestItem r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        Boolean r6 = (Boolean) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        if (r6.booleanValue() == false) goto L18;
        AuthCodeRequester r7 = new AuthCodeRequester();
        HashMap r0 = new HashMap();
        DriveUploadTestItem r1 = this.a;
        AppCompatEditText r2 = r1.e;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("edtCode");
        r2 = null;
    L8:
        r0.put("shareToken", String.valueOf(r2.getText()));
        r0.put("mountPoint", "bitable_file");
        String r3 = r1.i;
        if (r3 == null) goto L11;
        r0.put("fileName", FileUtils.x(r1.j, r3));
        r0.put("size", String.valueOf(ay4.d.a().i(r3).length()));
    L11:
        Intrinsics.checkNotNullParameter(r0, "params");
        Log.i("getAuthCode", "AuthCodeRequester");
        NetService.f r4 = new NetService.f("/api/bitable/external/share/uploadCode");
        Iterator r8 = r0.entrySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L15;
        Map.Entry r9 = (Map.Entry) r8.next();
        r4.b((String) r9.getKey(), (String) r9.getValue());
        goto L13
    L15:
        r4.c = 2;
        return r7.a.a(r4).map(a.a);
    L18:
        return Flowable.just(new AuthCodeRequester.AuthCodeResult());
    }
}
