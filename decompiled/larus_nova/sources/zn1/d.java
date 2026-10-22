package zn1;

import io.reactivex.functions.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f572910a = null;

    static {
        f572910a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        JSONObject r101 = new JSONObject();
        r101.put("type", "refresh");
        r101.put("data", (String) r100);
        return r101;
    }
}
