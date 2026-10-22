package tk7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckydog.api.model.SchemaAckType;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f546562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f546563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f546564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SchemaAckType f546565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f546566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f546567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f546568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f546569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f546570i;

    public g() {
        this.f546565d = SchemaAckType.UNKNOWN;
    }

    public static boolean a(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogSchemaBean", "isLuckyDogUnionSchema() on call; schema = " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L15;
    L14:
        return false;
    L15:
        Uri r101 = UriProtector.parse(r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L14;
        if ("luckydog".equals(r101.getHost()) == false) goto L17;
        if ("/union".equals(r101.getPath()) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogSchemaBean", th.getMessage());
        goto L14
    }
}
