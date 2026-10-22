package d2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.LruCache;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, JSONObject> f466498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f466499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f466500c;

    public class a extends LruCache<String, byte[]> {
        public a() {
            super(1048576);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, byte[] r101) {
            return r101.length;
        }
    }

    public d(Context r100) {
        this.f466498a = new LruCache(100);
        this.f466499b = new a();
        this.f466500c = new b(r100);
    }

    public final void a(String r100, JSONObject r101) {
        if (r100 == null) goto L10;
        this.f466498a.put(r100, r101);
        this.f466499b.put(r100, r101.toString().getBytes(StandardCharsets.UTF_8));
        SQLiteDatabase r102 = this.f466500c.getWritableDatabase();
        r102.execSQL("INSERT OR REPLACE INTO policies (app_id, content, version) VALUES (?, ?, ?)", new Object[]{r100, r101.toString(), Long.valueOf(r101.optLong("version", System.currentTimeMillis()))});     // Catch: Exception -> L6
        return;
    L7:
        return;
    }
}
