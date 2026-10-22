package ed5;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public boolean a;
    public final LinkedHashSet<String> b;
    public final ArrayList<Document> c;
    public final ArrayList<Document> d;

    public a() {
        this.a = false;
        this.b = new LinkedHashSet();
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    public static String a(Document r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r2.d) == true) goto L10;
        return r2.d;
    L10:
        if (TextUtils.isEmpty(r2.c) == false) goto L12;
        return "";
    L12:
        return r2.c;
    }
}
