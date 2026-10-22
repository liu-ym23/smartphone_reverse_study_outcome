package y35;

import com.bytedance.ee.bear.contract.net.DefaultResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T, R> implements Function {
    public static final b<T, R> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r4) {
        DefaultResponse r5 = (DefaultResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        String r6 = new JSONObject(new JSONObject(new JSONObject((String) r5.data).optString("data")).optString("parent_doc_info")).optString("token");     // Catch: Throwable -> L7
        if (r6 != null) goto L11;
        return "";
    L11:
        return r6;
    L7:
        tt5.a.d("SyncBlockResolver", "parse json error");
        return "";
    }
}
