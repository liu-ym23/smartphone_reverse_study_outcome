package kt1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.IDiagnoseDataManager;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements IDiagnoseDataManager {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile c f506003i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f506004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f506005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f506006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<JSONObject> f506007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList<JSONObject> f506008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<JSONObject> f506009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedList<JSONObject> f506010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedList<JSONObject> f506011h;

    public static c b() {
        if (f506003i != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f506003i != null) goto L9;
        f506003i = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f506003i;
    }

    public c() {
        this.f506004a = false;
        this.f506005b = false;
        this.f506006c = 300000;
        this.f506007d = new LinkedList();
        this.f506008e = new LinkedList();
        this.f506009f = new LinkedList();
        this.f506010g = new LinkedList();
        this.f506011h = new LinkedList();
    }

    @Override // com.bytedance.android.livesdkapi.service.IDiagnoseDataManager
    public final boolean isInit() {
        return this.f506004a;
    }

    @Override // com.bytedance.android.livesdkapi.service.IDiagnoseDataManager
    public final void addDiagnoseData(JSONObject r100) {
        int r101 = JSONObjectProtectorUtils.getInt(r100, IDiagnoseDataManager.TYPE_DATA_DIAGNOSE_KEY);     // Catch: Exception -> L43
        if (r101 != 0) goto L5;
        LinkedList<JSONObject> r102 = this.f506007d;     // Catch: Exception -> L43
        monitor-enter(r102);     // Catch: Exception -> L43
        c(this.f506007d, r100);     // Catch: Throwable -> L40
        monitor-exit(r102);     // Catch: Throwable -> L40
    L59:
        return;
    L40:
        th = move-exception;
        throw th;     // Catch: Exception -> L43
    L5:
        if (r101 != 1) goto L7;
        LinkedList<JSONObject> r103 = this.f506009f;     // Catch: Exception -> L43
        monitor-enter(r103);     // Catch: Exception -> L43
        c(this.f506009f, r100);     // Catch: Throwable -> L32
        monitor-exit(r103);     // Catch: Throwable -> L32
    L58:
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Exception -> L43
    L7:
        if (r101 != 2) goto L9;
        LinkedList<JSONObject> r104 = this.f506010g;     // Catch: Exception -> L43
        monitor-enter(r104);     // Catch: Exception -> L43
        c(this.f506010g, r100);     // Catch: Throwable -> L24
        monitor-exit(r104);     // Catch: Throwable -> L24
    L57:
        return;
    L24:
        th = move-exception;
        throw th;     // Catch: Exception -> L43
    L9:
        if (r101 != 3) goto L55;
        LinkedList<JSONObject> r105 = this.f506011h;     // Catch: Exception -> L43
        monitor-enter(r105);     // Catch: Exception -> L43
        c(this.f506011h, r100);     // Catch: Throwable -> L16
        monitor-exit(r105);     // Catch: Throwable -> L16
    L56:
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L43
    L55:
        return;
    L43:
        e = move-exception;
        ALogger.e("DiagnoseIDiagnoseDataManager", e);
    }

    public final void c(LinkedList<JSONObject> r110, JSONObject r111) {
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L15
        r111.put("addTime", r100);     // Catch: Exception -> L15
        boolean r101 = false;
    L5:
        if (r110.isEmpty() == true) goto L13;
        if (r101 == true) goto L13;
        JSONObject r102 = r110.peek();     // Catch: Exception -> L15
        if (r102 == null) goto L12;
        if ((r100 - r102.optLong("addTime")) <= this.f506006c) goto L12;
        r110.poll();     // Catch: Exception -> L15
    L12:
        r101 = true;
    L13:
        r110.add(r111);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        ALogger.e("DiagnoseIDiagnoseDataManager", e);
    }
}
