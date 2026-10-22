package o07;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f521639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f521640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f521641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, List<String>> f521642d;

    public d() {
    }

    public final String toString() {
        return "UrlResponse{statusCode=" + this.f521639a + ", originalData=" + Arrays.toString(this.f521640b) + ", errorMsg='" + this.f521641c + "', headers=" + this.f521642d + '}';
    }
}
