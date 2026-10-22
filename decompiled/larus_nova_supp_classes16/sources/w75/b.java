package w75;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b {
    public final String a;
    public volatile String b;
    public final long c;
    public final List<Integer> d;
    public volatile int e;
    public final String f;
    public final boolean g;
    public final String h;
    public final SparseArray<PreviewMeta> i;
    public final String j;
    public volatile String k;
    public volatile int l;

    public abstract String a();

    public final String toString() {
        return "AbsMeta{, size=" + this.c + ", availablePreviewType=" + this.d + ", previewStatus=" + this.e + ", mimeType='" + this.f + "', webOffice=" + this.g + ", ext='" + this.k + "'}";
    }

    public b(String r3, String r4, long r5, int[] r7, int r8, String r9, boolean r10, String r11, SparseArray<PreviewMeta> r12) {
        String r0 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        int r6 = 0;
        if (r7 != null) goto L8;
    L13:
        ArrayList r13 = new ArrayList(0);
    L14:
        this.d = Collections.unmodifiableList(r13);
        this.e = r8;
        this.f = r9;
        this.g = r10;
        String r14 = com.bytedance.ee.util.io.a.c(r4);
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        this.k = r14;
        this.h = r11;
        this.i = r12;
        if (r12 == null) goto L28;
        PreviewMeta r16 = r12.get(21);
        if (r16 == null) goto L28;
        String r17 = r16.getExtra();
        if (TextUtils.isEmpty(r17) == true) goto L28;
        r0 = new JSONObject(r17).optString("mime_type");     // Catch: JSONException -> L27
    L27:
        tt5.a.d("PreviewMetaParser", "parseMimeTypeFromSparseArray error");
    L28:
        this.j = r0;
        return;
    L8:
        if (r7.length == 0) goto L13;
        r13 = new ArrayList(r7.length);
        int r18 = r7.length;
    L11:
        if (r6 >= r18) goto L14;
        r13.add(Integer.valueOf(r7[r6]));
        r6 = r6 + 1;
        goto L11
    }
}
