package o15;

import ay4.b;
import com.bytedance.ee.bear.document.forecast.OperationRecord;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {

    /* JADX INFO: renamed from: o15.a$a, reason: collision with other inner class name */
    public static final class C0265a {
    }

    static {
    }

    public a() {
    }

    public static void a(OperationRecord r3) {
        Intrinsics.checkNotNullParameter(r3, "record");
        String r4 = new GsonBuilder().create().toJson(r3);     // Catch: Exception -> L5
        b.d("document", 6).putString("operation_record", r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("RecordPersistence", "serialize failed", e, false);
    }
}
