package g63;

import android.text.TextUtils;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f480148b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f480149a;

    public static final class a {
        public static b a() {
            b r100 = new b();
            b.a(r100, com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
            b.a(r100, "page_name", com.bytedance.android.ec.core.event.a.VALUE_SELECTED_COMMENT_PAGE);
            return r100;
        }
    }

    static {
    }

    public b() {
        this.f480149a = new HashMap();
    }

    public static void a(b r100, String r101, String r102) {
        HashMap<String, String> r103 = r100.f480149a;
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L8:
        r102 = "";
    L9:
        r103.put(r101, r102);
        return;
    L5:
        if (TextUtils.equals("null", r102) == true) goto L8;
        Intrinsics.checkNotNull(r102);
        goto L9
    }
}
