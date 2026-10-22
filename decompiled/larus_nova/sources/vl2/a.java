package vl2;

import android.text.TextUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f555633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f555634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f555635c;

    public final boolean a() {
        b r100 = (b) this;
        if (CollectionUtils.isEmpty(r100.f555635c) == true) goto L5;
        Random r101 = new Random();
        List<String> r102 = r100.f555635c;
        String r103 = (String) ListProtector.get(r102, r101.nextInt(((ArrayList) r102).size()));
    L7:
        if (TextUtils.isEmpty(r103) == false) goto L9;
        return false;
    L9:
        return new PolarisFileWrapper(r103).exists();
    L5:
        r103 = "";
        goto L7
    }

    public a(String r100, String r101) {
        this.f555634b = 0;
        this.f555635c = new ArrayList();
        this.f555633a = r100 + r101 + ".zip";
    }
}
