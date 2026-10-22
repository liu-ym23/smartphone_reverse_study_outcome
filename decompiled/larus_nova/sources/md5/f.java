package md5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.ownertype.OwnerType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements NetService.c<OwnerType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f513284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f513285b;

    public static final class a {
    }

    static {
    }

    public final int getType() {
        return this.f513284a;
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L25;
        JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: Throwable -> L20
        if (r102 == null) goto L14;
        JSONObject r103 = r102.optJSONObject(this.f513285b);     // Catch: Throwable -> L20
    L15:
        if (r103 == null) goto L17;
        int r104 = r103.optInt("owner_type");     // Catch: Throwable -> L20
    L18:
        return new OwnerType(r104);
    L17:
        r104 = 0;
        goto L18
    L14:
        r103 = null;
    L20:
        th = move-exception;
        tt5.a.f("OwnerTypeParser", th, false);
        return new OwnerType(0);
    L25:
        return new OwnerType(0);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public f(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "objToken");
        this.f513284a = r100;
        this.f513285b = r101;
    }
}
