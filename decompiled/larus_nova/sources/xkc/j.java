package xkc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f564426b;

    public final String toString() {
        String r100 = "\"" + this.f564425a + "\":[";
        if (this.f564426b == null) goto L12;
        int r101 = 0;
    L6:
        if (r101 >= ((ArrayList) this.f564426b).size()) goto L12;
        r100 = r100 + "\"" + ((String) ListProtector.get(this.f564426b, r101)) + "\"";
        if (r101 == (((ArrayList) this.f564426b).size() - 1)) goto L10;
        r100 = r100 + ",";
    L10:
        r101 = r101 + 1;
    L12:
        return r100 + "]";
    }

    public j(String r100, List r101) {
        ArrayList r102 = new ArrayList();
        this.f564426b = r102;
        this.f564425a = r100;
        if (r101 == null) goto L6;
        r102.addAll(r101);
        return;
    }
}
