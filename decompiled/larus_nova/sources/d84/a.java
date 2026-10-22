package d84;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f467396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f467397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f467398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f467399d;

    public final String toString() {
        return "DeviceResponse{\n body=" + this.f467399d + "\n headers=" + this.f467398c + "\n code=" + this.f467397b + "\n url='" + this.f467396a + "'}";
    }

    public a(String r100, int r101, List<Pair<String, String>> r102, String r103) {
        this.f467396a = r100;
        this.f467397b = r101;
        if (r102 != null) goto L5;
        this.f467398c = new ArrayList();
    L6:
        this.f467399d = r103;
        return;
    L5:
        this.f467398c = Collections.unmodifiableList(new ArrayList(r102));
        goto L6
    }
}
