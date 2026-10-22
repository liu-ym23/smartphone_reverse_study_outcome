package w74;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<String, String>> f558524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558525c;

    public final String toString() {
        return "DeviceResponse{\n body=" + this.f558525c + "\n headers=" + this.f558524b + "\n code=200\n url='" + this.f558523a + "'}";
    }

    public e(String r100, List r101, String r102) {
        this.f558523a = r100;
        if (r101 != null) goto L5;
        this.f558524b = new ArrayList();
    L6:
        this.f558525c = r102;
        return;
    L5:
        this.f558524b = Collections.unmodifiableList(new ArrayList(r101));
        goto L6
    }
}
