package to1;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f546895a = null;

    static {
        f546895a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Gson r101 = GsonHelper.getDefault();
        return GsonProtectorUtils.toJson(r101, (JsonObject) r100);
    }
}
