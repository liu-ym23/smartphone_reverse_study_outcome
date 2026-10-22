package md5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.ownertype.OwnerType;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements NetService.c<OwnerType> {
    public final int a;
    public final String b;

    public static final class a {
    }

    static {
    }

    public final int getType() {
        return this.a;
    }

    public final Result parse(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L25;
        JSONObject r4 = new JSONObject(r3).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Throwable -> L20
        if (r4 == null) goto L14;
        JSONObject r5 = r4.optJSONObject(this.b);     // Catch: Throwable -> L20
    L15:
        if (r5 == null) goto L17;
        int r6 = r5.optInt("owner_type");     // Catch: Throwable -> L20
    L18:
        return new OwnerType(r6);
    L17:
        r6 = 0;
        goto L18
    L14:
        r5 = null;
    L20:
        th = move-exception;
        tt5.a.f("OwnerTypeParser", th, false);
        return new OwnerType(0);
    L25:
        return new OwnerType(0);
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public f(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "objToken");
        this.a = r2;
        this.b = r3;
    }
}
