package ix5;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import okhttp3.Headers;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f496359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<String> f496360b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet<String> f496361c = null;

    static {
        f496360b = new CopyOnWriteArraySet();
        f496361c = new CopyOnWriteArraySet();
    }

    public static Set<String> a(List<String> r100) {
        CopyOnWriteArraySet<String> r101 = f496360b;
        if (r101.isEmpty() == false) goto L5;
    L21:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L21;
        HashSet r102 = new HashSet();
        Iterator<String> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L19;
        String r104 = r103.next();
        Iterator<String> r105 = r100.iterator();
    L12:
        if (r105.hasNext() == false) goto L9;
        String r106 = r105.next();
        if (r106 == null) goto L12;
        if (r106.contains(r104 + ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L12;
        r102.add(r104);
        goto L12
    L19:
        if (r102.size() <= 0) goto L21;
        return r102;
    }

    public static Set<String> b(Headers r100) {
        CopyOnWriteArraySet<String> r101 = f496361c;
        if (r101.isEmpty() == true) goto L23;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.size() == 0) goto L26;
        HashSet r102 = new HashSet();
        Iterator<String> r103 = r101.iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();
        if (r100.get(r104) == null) goto L10;
        r102.add(r104);
        goto L10
    L15:
        if (r102.size() > 0) goto L17;
        return null;
    L17:
        return r102;
    L26:
        return null;
    L23:
        return null;
    }

    public static void c(JSONArray r100, CopyOnWriteArraySet<String> r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L19;
        int r102 = 0;
    L14:
        if (r102 >= r100.length()) goto L21;
        String r103 = JSONArrayProtectorUtils.getString(r100, r102);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r103) == true) goto L11;
        r101.add(r103);     // Catch: JSONException -> L13
    L11:
        r102 = r102 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
