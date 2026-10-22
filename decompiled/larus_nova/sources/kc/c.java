package kc;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.crash.dumper.Scraps;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f502365c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ? extends BcmParams> f502366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ? extends BcmParams> f502367b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f502366a, r101.f502366a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f502367b, r101.f502367b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Map<String, ? extends BcmParams> r100 = this.f502366a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, ? extends BcmParams> r104 = this.f502367b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L24
        Map<String, ? extends BcmParams> r102 = this.f502366a;     // Catch: Throwable -> L22
        if (r102 == null) goto L11;
        Iterator<Map.Entry<String, ? extends BcmParams>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, ? extends BcmParams> r104 = r103.next();     // Catch: Throwable -> L22
        r101.put(r104.getKey(), r104.getValue().toJSONObject());     // Catch: Throwable -> L22
    L11:
        r100.put("page", r101);     // Catch: Throwable -> L24
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L24
        Map<String, ? extends BcmParams> r106 = this.f502367b;     // Catch: Throwable -> L23
        if (r106 == null) goto L19;
        Iterator<Map.Entry<String, ? extends BcmParams>> r107 = r106.entrySet().iterator();     // Catch: Throwable -> L23
    L16:
        if (r107.hasNext() == false) goto L19;
        Map.Entry<String, ? extends BcmParams> r108 = r107.next();     // Catch: Throwable -> L23
        r105.put(r108.getKey(), r108.getValue().toJSONObject());     // Catch: Throwable -> L23
    L19:
        r100.put(Scraps.INNER_UNIT, r105);     // Catch: Throwable -> L24
    L21:
        return r100.toString();
    }

    public c(Map<String, ? extends BcmParams> r100, Map<String, ? extends BcmParams> r101) {
        this.f502366a = r100;
        this.f502367b = r101;
    }
}
