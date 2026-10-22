package vkc;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.URLEncoder;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f555559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f555560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f555561c;

    public a(c r100) {
        this.f555559a = r100.f555562a;
        this.f555560b = r100.f555563b;
        this.f555561c = r100.f555564c;
    }

    public static String a(String r100, List<Pair<String, String>> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        StringBuilder r102 = new StringBuilder(r100);
        if (r100.indexOf(63) < 0) goto L8;
        r102.append("&");
    L11:
        int r103 = 0;
    L13:
        if (r103 >= r101.size()) goto L23;
        if (r103 <= 0) goto L16;
        r102.append("&");
    L16:
        Pair r104 = (Pair) ListProtector.get(r101, r103);
        r102.append((String) r104.first);
        r102.append(com.alipay.sdk.m.n.a.f25612h);
        r102.append(URLEncoder.encode((String) r104.second, "UTF-8"));
        r103 = r103 + 1;
    L19:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L23:
        return r102.toString();
    L8:
        if (r101.size() <= 0) goto L11;
        r102.append("?");
        goto L11
    }
}
