package gu6;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends ym6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f482789b = null;

    static {
        f482789b = new a();
    }

    @Override // ym6.a, gu6.b
    public final JSONObject a() {
        TTCJPayUtils r100 = TTCJPayUtils.Companion.getInstance();
        b.f482790a.getClass();
        return r100.getCJPayInfo(b.a.f482792b);
    }

    @Override // ym6.a, gu6.b
    public final String b() {
        return TTCJPayUtils.Companion.getInstance().getSDKVersion();
    }

    public a() {
    }
}
