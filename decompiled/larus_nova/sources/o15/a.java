package o15;

import ay4.b;
import com.bytedance.ee.bear.document.forecast.OperationRecord;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: o15.a$a, reason: collision with other inner class name */
    public static final class C7003a {
    }

    static {
    }

    public a() {
    }

    public static void a(OperationRecord r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        String r101 = new GsonBuilder().create().toJson(r100);     // Catch: Exception -> L5
        b.d("document", 6).putString("operation_record", r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("RecordPersistence", "serialize failed", e, false);
    }
}
