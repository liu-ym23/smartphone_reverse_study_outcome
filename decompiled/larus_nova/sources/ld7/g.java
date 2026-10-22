package ld7;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, JSONArray> f508739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, JSONObject> f508740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f508741c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f508739a, r101.f508739a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508740b, r101.f508740b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508741c, r101.f508741c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Map<String, JSONArray> r100 = this.f508739a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, JSONObject> r104 = this.f508740b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f508741c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConfigWithSwitchLazy(contentJson=" + this.f508739a + ", contentV2Json=" + this.f508740b + ", settingsJson=" + this.f508741c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Map<String, ? extends JSONArray> r100, Map<String, ? extends JSONObject> r101, JSONObject r102) {
        this.f508739a = r100;
        this.f508740b = r101;
        this.f508741c = r102;
    }
}
