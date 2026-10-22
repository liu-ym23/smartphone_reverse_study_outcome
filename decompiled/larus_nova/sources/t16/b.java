package t16;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f544154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f544155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f544156c;

    public b(JSONObject r100, c r101, e r102) {
        Intrinsics.checkNotNullParameter(r102, "signature");
        this.f544154a = r101;
        this.f544155b = r102;
        this.f544156c = new HashMap();
        if (r100 == null) goto L5;
        Iterator<String> r103 = r100.keys();
    L6:
        if (r103 == null) goto L10;
        boolean r104 = true;
        if (r103.hasNext() != true) goto L10;
    L11:
        if (r104 == false) goto L13;
        String r105 = r103.next();
        String r106 = r100.optString(r105);
        this.f544156c.put(r105, r106);
        goto L6
    L13:
        return;
    L10:
        r104 = false;
        goto L11
    L5:
        r103 = null;
        goto L6
    }
}
