package qc4;

import com.bytedance.bpea.basics.Cert;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f532466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f532467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f532468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f532469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Cert f532470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f532471f;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("CertContext(cert=");
        r100.append(this.f532470e);
        r100.append(", entryToken=");
        r100.append(this.f532469d);
        r100.append(", api_id=");
        r100.append(this.f532466a);
        r100.append(", entryDataTypes=");
        String[] r101 = this.f532468c;
        if (r101 == null) goto L5;
        String r102 = Arrays.toString(r101);
    L6:
        r100.append(r102);
        r100.append(", entryCategory=");
        r100.append(this.f532467b);
        r100.append(", entryExtraInfo=");
        r100.append(this.f532471f);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public c(Cert r100, String r101, String[] r102, Integer r103) {
        this.f532466a = -1;
        this.f532471f = new LinkedHashMap();
        this.f532470e = r100;
        this.f532469d = r101;
        this.f532468c = r102;
        this.f532467b = r103;
    }

    public c(Cert r100, String r101, int r102, String[] r103, Integer r104) {
        this.f532466a = -1;
        this.f532471f = new LinkedHashMap();
        this.f532470e = r100;
        this.f532469d = r101;
        this.f532466a = r102;
        this.f532468c = r103;
        this.f532467b = r104;
    }

    public c(Cert r100, String r101, String[] r102, Integer r103, int r104) {
        this.f532466a = -1;
        this.f532471f = new LinkedHashMap();
        this.f532470e = r100;
        this.f532469d = r101;
        this.f532466a = r104;
        this.f532468c = r102;
        this.f532467b = r103;
    }
}
