package sbb;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f541278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f541279b;

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "domainConfigParser");
        this.f541278a = "BaseDocUrlParser";
        this.f541279b = r100;
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        b r101 = this.f541279b;     // Catch: Exception -> L11
        if (r101 == null) goto L17;
        Matcher r102 = r101.f541281b.matcher(r100);     // Catch: Exception -> L11
        if (r102.find() == true) goto L8;
        return null;
    L8:
        if (r102.end() <= r102.start()) goto L19;
        return r100.substring(r102.start() + 1, r102.end());
    L19:
        return null;
    L17:
        return null;
    L11:
        e = move-exception;
        Log.e(this.f541278a, e);
        return null;
    }

    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        b r101 = this.f541279b;
        if (r101 == null) goto L20;
        Matcher r102 = r101.f541280a.matcher(r100);
        if (r102.find() == true) goto L7;
        return null;
    L7:
        if (r102.end() <= r102.start()) goto L26;
        Intrinsics.checkNotNull(r102);
        String r103 = r100.substring(r102.start() + 1, r102.end() - 1);
        e r104 = e.f541294e;
        String r105 = r104.getType();
        if (TextUtils.isEmpty(r103) == false) goto L11;
        Log.i(this.f541278a, "getProductTypeName()....originType is empty");
        return r105;
    L11:
        b r106 = this.f541279b;
        if (r106 == null) goto L23;
        String r107 = r106.f541282c.get(r103);
        if (r107 != null) goto L17;
        r107 = r104.getType();
    L17:
        if (TextUtils.isEmpty(r107) == false) goto L24;
        Log.i(this.f541278a, "getProductTypeName()...originType = " + r103);
        return r104.getType();
    L24:
        return r107;
    L23:
        return r105;
    L26:
        return null;
    L20:
        return null;
    }
}
