package xk3;

import com.bytedance.android.ec.sdk.helper.q;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"xk3/b$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<HashMap<String, String>> {
        public a() {
        }
    }

    public static HashMap a() {
        int r100 = pi3.a.f529323a;     // Catch: Exception -> L6
        HashMap r101 = (HashMap) new Gson().fromJson(q.f48131a.getString("jump_2_third_permission_date_map", ""), new a().getType());     // Catch: Exception -> L6
        if (r101 != null) goto L10;
        return new HashMap();
    L10:
        return r101;
    L7:
        return new HashMap();
    }

    static {
    }
}
