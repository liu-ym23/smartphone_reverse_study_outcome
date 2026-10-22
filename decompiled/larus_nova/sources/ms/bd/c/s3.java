package ms.bd.c;

import java.util.function.Consumer;
import org.json.JSONException;

/* JADX INFO: loaded from: classes5.dex */
public final class s3 implements Consumer {
    public s3() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        v3.f515407e.put(String.valueOf(r101), System.currentTimeMillis());     // Catch: JSONException -> L5
        return;
    }
}
