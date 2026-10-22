package ls7;

import android.content.Context;
import com.dtf.face.network.APICallback;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f510543d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f510544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f510545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f510546c;

    public static a f() {
        if (f510543d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f510543d != null) goto L9;
        f510543d = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f510543d;
    }

    public a() {
        this.f510546c = true;
    }

    @Override // ls7.b
    public final boolean a(Map<String, Object> r100, APICallback<Map<String, Object>> r101) {
        b r102 = this.f510544a;
        if (r102 == null) goto L8;
        if (r102.a(r100, r101) == false) goto L8;
        return true;
    L8:
        if (this.f510546c == false) goto L10;
        b r103 = null;
    L11:
        if (r103 != null) goto L13;
        return false;
    L13:
        if (r103.a(r100, r101) == false) goto L17;
        return true;
    L17:
        return false;
    L10:
        r103 = this.f510545b;
        goto L11
    }

    @Override // ls7.b
    public final void b(Context r100, Map<String, Object> r101) {
        b r102 = this.f510544a;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
    L6:
        if (this.f510546c == true) goto L13;
        b r103 = this.f510545b;
        if (r103 == null) goto L12;
        r103.b(r100, r101);
        return;
    L12:
        return;
    }

    @Override // ls7.b
    public final boolean c(Map<String, Object> r100, APICallback<Map<String, Object>> r101) {
        if (this.f510546c == false) goto L5;
        b r102 = null;
    L6:
        if (r102 != null) goto L8;
    L11:
        b r103 = this.f510544a;
        if (r103 == null) goto L16;
        r103.c(r100, r101);
        return false;
    L16:
        return false;
    L8:
        if (r102.c(r100, r101) == false) goto L11;
        return true;
    L5:
        r102 = this.f510545b;
        goto L6
    }

    @Override // ls7.b
    public final boolean d(Map<String, Object> r100, APICallback<Map<String, Object>> r101) {
        b r102 = this.f510544a;
        if (r102 == null) goto L8;
        if (r102.d(r100, r101) == false) goto L8;
        return true;
    L8:
        if (this.f510546c == false) goto L10;
        b r103 = null;
    L11:
        if (r103 != null) goto L13;
        return false;
    L13:
        if (r103.d(r100, r101) == false) goto L17;
        return true;
    L17:
        return false;
    L10:
        r103 = this.f510545b;
        goto L11
    }

    @Override // ls7.b
    public final boolean e(Map<String, Object> r100, APICallback<Map<String, Object>> r101) {
        b r102 = this.f510544a;
        if (r102 == null) goto L8;
        if (r102.e(r100, r101) == false) goto L8;
        return true;
    L8:
        if (this.f510546c == false) goto L10;
        b r103 = null;
    L11:
        if (r103 != null) goto L13;
        return false;
    L13:
        if (r103.e(r100, r101) == false) goto L17;
        return true;
    L17:
        return false;
    L10:
        r103 = this.f510545b;
        goto L11
    }
}
