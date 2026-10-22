package ed5;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f472208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<String> f472209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Document> f472210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Document> f472211d;

    public a() {
        this.f472208a = false;
        this.f472209b = new LinkedHashSet();
        this.f472210c = new ArrayList();
        this.f472211d = new ArrayList();
    }

    public static String a(Document r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r100.f227873d) == true) goto L10;
        return r100.f227873d;
    L10:
        if (TextUtils.isEmpty(r100.f227872c) == false) goto L12;
        return "";
    L12:
        return r100.f227872c;
    }
}
