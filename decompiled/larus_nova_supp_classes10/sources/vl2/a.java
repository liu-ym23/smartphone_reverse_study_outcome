package vl2;

import android.text.TextUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a {
    public String a;
    public int b;
    public final List<String> c;

    public final boolean a() {
        b r0 = (b) this;
        if (CollectionUtils.isEmpty(r0.c) == true) goto L5;
        Random r1 = new Random();
        List<String> r2 = r0.c;
        String r3 = (String) ListProtector.get(r2, r1.nextInt(((ArrayList) r2).size()));
    L7:
        if (TextUtils.isEmpty(r3) == false) goto L9;
        return false;
    L9:
        return new PolarisFileWrapper(r3).exists();
    L5:
        r3 = "";
        goto L7
    }

    public a(String r2, String r3) {
        this.b = 0;
        this.c = new ArrayList();
        this.a = r2 + r3 + ".zip";
    }
}
