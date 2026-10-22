package wg4;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f559557a;

    public b() {
    }

    public b(String r100) {
        this.f559557a = r100;
    }

    @Override // wg4.d
    public final List<String> a(String r210, long r211) {
        ArrayList r100 = new ArrayList();
        if (TextUtils.isEmpty(r210) == false) goto L65;
        return r100;
    L65:
        File[] r101 = new PolarisFileWrapper(r210).listFiles();     // Catch: Exception -> L62
        if (r101 != null) goto L9;
        return r100;
    L9:
        if (this.f559557a != null) goto L12;
        this.f559557a = com.bytedance.crash.util.b.c();     // Catch: Exception -> L62
    L12:
        if (this.f559557a.contains(":") == true) goto L14;
        boolean r102 = true;
    L16:
        if (this.f559557a.contains(":") == false) goto L18;
        String r103 = this.f559557a.replace(":", "-");     // Catch: Exception -> L62
    L19:
        int r104 = r101.length;     // Catch: Exception -> L62
        File r110 = null;
        File r111 = null;
        int r112 = 0;
        long r113 = 0;
        long r114 = 0;
    L20:
        if (r112 >= r104) goto L53;
        File r115 = r101[r112];     // Catch: Exception -> L62
        String r105 = r115.getName();     // Catch: Exception -> L62
        if (r105.endsWith(".hot") == false) goto L52;
        if (r102 == true) goto L26;
    L27:
        if (r102 == true) goto L32;
        if (r115.getName().contains("-") == false) goto L52;
    L32:
        if (r105.contains(r103) == false) goto L52;
        String[] r106 = r105.split("_");     // Catch: Exception -> L62
        if (r106.length < 4) goto L38;
        long r107 = CastLongProtector.parseLong(r106[3]);     // Catch: Exception -> L62
    L42:
        if (r211 <= 0) goto L47;
        if (r107 > r211) goto L52;
    L47:
        if (r114 >= r107) goto L50;
        r110 = r111;
        r113 = r114;
        r111 = r115;
        r114 = r107;
        goto L52
    L50:
        if (r113 >= r107) goto L52;
        r113 = r107;
        r110 = r115;
        goto L52
    L38:
        if (r106.length <= 1) goto L40;
        r107 = CastLongProtector.parseLong(r106[0]);     // Catch: Exception -> L62
        goto L42
    L40:
        r107 = -1;
        goto L42
    L26:
        if (r115.getName().contains("-") == false) goto L27;
    L52:
        r112 = r112 + 1;     // Catch: Exception -> L62
        goto L20
    L53:
        if (r110 != null) goto L55;
    L57:
        if (r111 != null) goto L59;
    L64:
        return r100;
    L59:
        if (r111.length() <= 0) goto L64;
        r100.add(r111.getAbsolutePath());     // Catch: Exception -> L62
        goto L64
    L55:
        if (r110.length() <= 0) goto L57;
        r100.add(r110.getAbsolutePath());     // Catch: Exception -> L62
        goto L57
    L18:
        r103 = this.f559557a;     // Catch: Exception -> L62
        goto L19
    L14:
        r102 = false;
    L62:
        e = move-exception;
        ch4.c.c(e);
        goto L64
    }
}
