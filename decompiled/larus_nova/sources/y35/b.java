package y35;

import com.bytedance.ee.bear.contract.net.DefaultResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f565855a = null;

    static {
        f565855a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        DefaultResponse r101 = (DefaultResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        String r102 = new JSONObject(new JSONObject(new JSONObject((String) r101.data).optString("data")).optString("parent_doc_info")).optString("token");     // Catch: Throwable -> L7
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        tt5.a.d("SyncBlockResolver", "parse json error");
        return "";
    }
}
