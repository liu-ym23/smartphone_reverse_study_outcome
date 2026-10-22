package lda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.obric.assistant.cocreationreview.s3;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.obric.assistant.cocreationreview.g f508809b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lda.a f508810a;

    public static final class a {
    }

    static {
        f508809b = new com.obric.assistant.cocreationreview.g("cocreation_omni_data.db", "omni.database.observe");
    }

    public i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        lda.a r101 = new lda.a(r100.getApplicationContext());
        this.f508810a = r101;
        long r102 = System.currentTimeMillis() - 172800000;
        int r103 = r101.getWritableDatabase().delete("omni_data", "created_at < ?", new String[]{String.valueOf(r102)});
        int r104 = s3.f387719a;
        s3.b("omni.database", "deleteExpired reason=store_init, cutoff=" + r102 + ", deleted=" + r103);
        if (r103 <= 0) goto L6;
        f508809b.a("omni_records_expired:" + r103);
        return;
    }

    public final void a(List<b0> r110) {
        Intrinsics.checkNotNullParameter(r110, "records");
        if (r110.isEmpty() == false) goto L5;
        return;
    L5:
        SQLiteDatabase r100 = this.f508810a.getWritableDatabase();
        r100.beginTransaction();
        Iterator<T> r101 = r110.iterator();     // Catch: Throwable -> L14
    L9:
        if (r101.hasNext() == false) goto L11;
        b0 r102 = (b0) r101.next();     // Catch: Throwable -> L14
        String r103 = CollectionsKt.joinToString$default(r102.f508796i, null, "[", "]", 0, null, new f(), 25, null);     // Catch: Throwable -> L14
        int r104 = s3.f387719a;     // Catch: Throwable -> L14
        s3.b("omni.database", "upsert row recordId=" + r102.f508788a + ", taskId=" + r102.f508790c + ", createdAt=" + r102.f508791d + ", status=" + r102.f508794g.getRaw() + ", taskTriggerType=" + r102.f508795h.getRaw() + ", stepCount=" + r102.f508796i.size() + ", time=" + r102.f508797j + ", query=" + com.obric.assistant.cocreationreview.modules.omni.a.c(r102.f508792e, 96) + ", answer=" + com.obric.assistant.cocreationreview.modules.omni.a.c(r102.f508793f, 96) + ", steps=" + r103);     // Catch: Throwable -> L14
        r100.insertWithOnConflict("omni_data", null, com.obric.assistant.cocreationreview.modules.omni.a.a(r102), 5);     // Catch: Throwable -> L14
        goto L9
    L11:
        r100.setTransactionSuccessful();     // Catch: Throwable -> L14
        r100.endTransaction();
        int r105 = s3.f387719a;
        s3.b("omni.database", "upsert count=" + r110.size() + ", ids=" + CollectionsKt.joinToString$default(r110, null, null, null, 0, null, new g(), 31, null));
        com.obric.assistant.cocreationreview.g r106 = f508809b;
        StringBuilder r107 = new StringBuilder("omni_records_upsert:");
        r107.append(r110.size());
        r106.a(r107.toString());
        return;
    L14:
        th = move-exception;
        r100.endTransaction();
        throw th;
    }
}
