package lc4;

import android.text.TextUtils;
import com.bytedance.bmf_mods_lite_api.exception.BmfException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f508414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f508415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f508416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f508417d;

    /* JADX INFO: renamed from: lc4.a$a, reason: collision with other inner class name */
    public static class C6674a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f508418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f508419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f508420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f508421d;

        public final a a() throws BmfException {
            if (((HashMap) this.f508418a).containsKey("host") == false) goto L25;
            if (((HashMap) this.f508418a).containsKey("accessKey") == false) goto L25;
            if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f508418a).get("host")) == true) goto L25;
            if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f508418a).get("accessKey")) == true) goto L25;
            int[] r100 = this.f508420c;
            if (r100 == null) goto L23;
            if (r100.length == 0) goto L23;
            String r101 = this.f508419b;
            if (r101 == null) goto L21;
            if (r101.isEmpty() == true) goto L21;
            a r102 = new a(this.f508418a);
            r102.f508415b = this.f508419b;
            r102.f508416c = this.f508420c;
            r102.f508417d = this.f508421d;
            return r102;
        L21:
            throw new BmfException(-100020, "modelNamePrefix is null");
        L23:
            throw new BmfException(-100020, "groupIds is null");
        L25:
            throw new BmfException(-100020, "host or accessKey is null");
        }

        public C6674a() {
            this.f508418a = new HashMap();
            this.f508419b = "";
            this.f508421d = 1;
        }
    }

    public final String toString() {
        return "{ modelNamePrefix: " + this.f508415b + ", groupIds: " + Arrays.toString(this.f508416c) + ", downsample: " + this.f508417d + ", host: " + this.f508414a.get("host") + ", accessKey: " + this.f508414a.get("accessKey") + ", deviceId: " + this.f508414a.get("deviceId") + ", appVersion: " + this.f508414a.get("appVersion") + ", appID: " + this.f508414a.get(com.heytap.mcssdk.constant.b.f276371u) + ", platformSdkVersion: " + this.f508414a.get("platformSdkVersion") + " }";
    }

    public a(Map r100) {
        this.f508415b = "";
        this.f508417d = 1;
        this.f508414a = r100;
    }
}
