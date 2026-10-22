package w75;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f558558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f558559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f558560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f558561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f558562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f558563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f558564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SparseArray<PreviewMeta> f558565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f558566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile String f558567k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile int f558568l;

    public abstract String a();

    public final String toString() {
        return "AbsMeta{, size=" + this.f558559c + ", availablePreviewType=" + this.f558560d + ", previewStatus=" + this.f558561e + ", mimeType='" + this.f558562f + "', webOffice=" + this.f558563g + ", ext='" + this.f558567k + "'}";
    }

    public b(String r100, String r101, long r102, int[] r103, int r104, String r105, boolean r110, String r111, SparseArray<PreviewMeta> r112) {
        String r106 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.f558557a = r100;
        this.f558558b = r101;
        this.f558559c = r102;
        int r107 = 0;
        if (r103 != null) goto L8;
    L13:
        ArrayList r108 = new ArrayList(0);
    L14:
        this.f558560d = Collections.unmodifiableList(r108);
        this.f558561e = r104;
        this.f558562f = r105;
        this.f558563g = r110;
        String r109 = com.bytedance.ee.util.io.a.c(r101);
        if (r109 != null) goto L17;
        r109 = "";
    L17:
        this.f558567k = r109;
        this.f558564h = r111;
        this.f558565i = r112;
        if (r112 == null) goto L28;
        PreviewMeta r113 = r112.get(21);
        if (r113 == null) goto L28;
        String r114 = r113.getExtra();
        if (TextUtils.isEmpty(r114) == true) goto L28;
        r106 = new JSONObject(r114).optString("mime_type");     // Catch: JSONException -> L27
    L27:
        tt5.a.d("PreviewMetaParser", "parseMimeTypeFromSparseArray error");
    L28:
        this.f558566j = r106;
        return;
    L8:
        if (r103.length == 0) goto L13;
        r108 = new ArrayList(r103.length);
        int r115 = r103.length;
    L11:
        if (r107 >= r115) goto L14;
        r108.add(Integer.valueOf(r103[r107]));
        r107 = r107 + 1;
        goto L11
    }
}
