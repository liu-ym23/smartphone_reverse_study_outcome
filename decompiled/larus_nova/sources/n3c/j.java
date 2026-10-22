package n3c;

import com.google.gson.JsonObject;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<JSONObject, Unit> f517025a;

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super JSONObject, Unit> r100) {
        this.f517025a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JsonObject r101 = (JsonObject) ((com.ss.android.lark.security.compliance.infra.network.h) r100).f440448d;
        if (r101 == null) goto L6;
        Function1<JSONObject, Unit> r102 = this.f517025a;
        ScsLogger.d("Network", "doRealRequestNonblocking, return callback");
        r102.invoke(new JSONObject(r101.toString()));
        return;
    }
}
