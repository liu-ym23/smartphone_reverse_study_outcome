package mz4;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DocViewModel f516530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ee.bear.contract.d f516531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f516532c;

    public w() {
    }

    public final Map<String, String> b() {
        HashMap r100 = new HashMap();
        BearUrl r101 = this.f516530a.getBearUrl();
        String r102 = "ERR";
        if (r101 != null) goto L6;
    L7:
        String r103 = "ERR";
    L9:
        r100.put("file_id", r103);
        BearUrl r104 = this.f516530a.getBearUrl();
        if (r104 != null) goto L13;
    L16:
        r100.put("file_type", r102);
        r100.put("is_owner", String.valueOf(this.f516530a.isOwner()));
        return r100;
    L13:
        if (TextUtils.isEmpty(r104.f222560a) == true) goto L16;
        r102 = r104.f222560a;
        goto L16
    L6:
        if (TextUtils.isEmpty(r101.f222561b) == true) goto L7;
        r103 = du5.b.g(r101.f222561b);
        goto L9
    }

    public final Map<String, String> a(boolean r100) {
        HashMap r101 = new HashMap();
        BearUrl r102 = this.f516530a.getBearUrl();
        String r103 = "ERR";
        if (r102 != null) goto L6;
    L7:
        String r104 = "ERR";
    L9:
        r101.put("file_id", r104);
        BearUrl r105 = this.f516530a.getBearUrl();
        if (r105 != null) goto L13;
    L16:
        r101.put("file_type", r103);
        r101.put("is_owner", String.valueOf(this.f516530a.isOwner()));
        if (r100 == false) goto L19;
        String r106 = "nav_catalog";
    L20:
        r101.put("source", r106);
        return r101;
    L19:
        r106 = "more";
        goto L20
    L13:
        if (TextUtils.isEmpty(r105.f222560a) == true) goto L16;
        r103 = r105.f222560a;
        goto L16
    L6:
        if (TextUtils.isEmpty(r102.f222561b) == true) goto L7;
        r104 = du5.b.g(r102.f222561b);
        goto L9
    }

    public final void c(boolean r100) {
        this.f516532c = r100;
        if (this.f516530a != null) goto L5;
    L9:
        tt5.a.k("StructureAnalytic", "reportOpenFixedStructure bad state");
        return;
    L5:
        if (this.f516531b == null) goto L9;
        tt5.a.b("StructureAnalytic", "reportOpenFixedStructure:" + r100);
        this.f516531b.v("show_outline_catalog", a(r100));
    }
}
