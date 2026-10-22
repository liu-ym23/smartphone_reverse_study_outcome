package gc7;

import android.database.Cursor;
import com.bytedance.sdk.account.platform.api.IAccountSettingsService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jc7.b f480855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f480856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f480857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f480858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d.c f480859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b f480860f;

    public final void a() {
        jc7.b r100 = this.f480855a;
        int r101 = 0;
        if (r100.b() == true) goto L5;
        int r102 = -1;
    L33:
        JSONObject r103 = ((IAccountSettingsService) AuthorizeFramework.getService(IAccountSettingsService.class)).getLoginInfoConfig();
        int r104 = 30;
        if (r103 == null) goto L36;
        r104 = r103.optInt("max_cache", 30);
    L36:
        if (r104 >= 0) goto L39;
        r104 = 0;
    L39:
        if (r102 <= r104) goto L44;
        int r105 = r102 - r104;
    L41:
        if (r101 >= r105) goto L43;
        this.f480855a.c();
        r101 = r101 + 1;
        goto L41
    L43:
        r102 = r104;
    L44:
        jc7.b r106 = this.f480855a;
        int r107 = this.f480856b;
        String r108 = this.f480857c;
        long r109 = this.f480858d;
        if (r106.d(3, null, Integer.valueOf(r107), r108, Long.valueOf(r109)) == null) goto L50;
        if (this.f480855a.update(this.f480860f.f480861c) == true) goto L72;
        d.c r110 = this.f480859e;
        r110.f480875a = -1;
        r110.f480876b = "数据更新失败或者没有此数据";
        return;
    L72:
        return;
    L50:
        if (r102 != r104) goto L55;
        this.f480855a.c();
        if (this.f480855a.insert(this.f480860f.f480861c) == true) goto L74;
        d.c r111 = this.f480859e;
        r111.f480875a = -2;
        r111.f480876b = "数据插入失败";
        return;
    L74:
        return;
    L55:
        if (this.f480855a.insert(this.f480860f.f480861c) == true) goto L76;
        d.c r112 = this.f480859e;
        r112.f480875a = -2;
        r112.f480876b = "数据插入失败";
        return;
    L76:
        return;
    L5:
        Cursor r113 = null;
        Cursor r114 = r100.f498143b.rawQuery("select count(*) from login_info", null);     // Catch: Throwable -> L25 Exception -> L27
        if (r114 != null) goto L63;
        r113 = r114;
        r102 = 0;
    L23:
        if (r113 == null) goto L33;
        r113.close();
        goto L33
    L63:
        r114.moveToFirst();     // Catch: Throwable -> L17 Exception -> L19
        if (r114.getCount() <= 0) goto L12;
        r102 = r114.getInt(0);     // Catch: Throwable -> L17 Exception -> L19
    L65:
        r114.close();     // Catch: Exception -> L15 Throwable -> L17
    L15:
        e = move-exception;
        int r115 = r102;
        Exception e100 = e;
    L21:
        int r116 = r115;
        r113 = r114;
        int r117 = r116;
    L66:
        e100.printStackTrace();     // Catch: Throwable -> L58
        if (r113 == null) goto L32;
        r113.close();
    L32:
        r102 = r117;
    L58:
        Throwable th10 = th;
    L59:
        th = th10;
    L60:
        if (r113 == null) goto L62;
        r113.close();
    L62:
        throw th;
    L12:
        r102 = 0;
    L17:
        th10 = th;
        r113 = r114;
    L19:
        e100 = e;
        r115 = 0;
        goto L21
    L27:
        e = move-exception;
        e100 = e;
        r117 = 0;
    L25:
        th = th;
        goto L60
    }

    public a(b r100, jc7.b r101, int r102, String r103, long r104, d.c r105) {
        this.f480860f = r100;
        this.f480855a = r101;
        this.f480856b = r102;
        this.f480857c = r103;
        this.f480858d = r104;
        this.f480859e = r105;
    }
}
