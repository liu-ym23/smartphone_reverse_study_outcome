package xka;

import android.database.Cursor;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class i implements vka.b<JsonArray> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f564307f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ala.e f564308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f564309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f564310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f564311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f564312e;

    public static final class a {
        public static i a(ala.e r110, JsonObject r111) {
            Intrinsics.checkNotNullParameter(r110, "token");
            Intrinsics.checkNotNullParameter(r111, "json");
            JsonElement r100 = r111.get("projection");
            if (r100 == null) goto L11;
            JsonArray r101 = r100.getAsJsonArray();
            if (r101 == null) goto L11;
            ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator<JsonElement> r103 = r101.iterator();
        L8:
            if (r103.hasNext() == false) goto L10;
            r102.add(r103.next().getAsString());
            goto L8
        L10:
            String[] r104 = (String[]) r102.toArray(new String[0]);
        L12:
            JsonElement r105 = r111.get("selection");
            if (r105 == null) goto L15;
            String r106 = r105.getAsString();
        L16:
            JsonElement r107 = r111.get("selectionArgs");
            if (r107 == null) goto L25;
            JsonArray r108 = r107.getAsJsonArray();
            if (r108 == null) goto L25;
            ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
            Iterator<JsonElement> r112 = r108.iterator();
        L22:
            if (r112.hasNext() == false) goto L24;
            r109.add(r112.next().getAsString());
            goto L22
        L24:
            String[] r113 = (String[]) r109.toArray(new String[0]);
        L26:
            JsonElement r114 = r111.get("sortOrder");
            if (r114 == null) goto L29;
            String r115 = r114.getAsString();
        L30:
            if (r104 != null) goto L35;
            if (r106 != null) goto L35;
            if (r113 != null) goto L35;
            if (r115 != null) goto L35;
            return null;
        L35:
            return new i(r110, r104, r106, r113, r115);
        L29:
            r115 = null;
        L25:
            r113 = null;
            goto L26
        L15:
            r106 = null;
        L11:
            r104 = null;
            goto L12
        }
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Cursor r101 = r100.query(this.f564308a, this.f564309b, this.f564310c, this.f564311d, this.f564312e);
        JsonArray r102 = vka.n.b(r101, false);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r101, null);
        return r102;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }

    public /* synthetic */ i(ala.e r100) {
        this(r100, null, null, null, null);
    }

    public i(ala.e r100, String[] r101, String r102, String[] r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this.f564308a = r100;
        this.f564309b = r101;
        this.f564310c = r102;
        this.f564311d = r103;
        this.f564312e = r104;
    }
}
