package ex3;

import android.text.TextUtils;
import com.bytedance.applog.monitor.v3.StageEventType;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f474709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f474711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StageEventType f474712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f474713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f474714f;

    public final void a(i r100) {
        if (TextUtils.equals(this.f474710b, r100.f474710b) == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f474713e) == false) goto L11;
        if (TextUtils.isEmpty(r100.f474713e) == true) goto L11;
        this.f474713e = r100.f474713e;
    L11:
        if (this.f474714f >= 0) goto L16;
        int r101 = r100.f474714f;
        if (r101 < 0) goto L16;
        this.f474714f = r101;
    L16:
        if (TextUtils.isEmpty(this.f474709a) == false) goto L21;
        if (TextUtils.isEmpty(r100.f474709a) == true) goto L21;
        this.f474709a = r100.f474709a;
    L21:
        if (this.f474711c > 0) goto L26;
        long r102 = r100.f474711c;
        if (r102 <= 0) goto L26;
        this.f474711c = r102;
    L26:
        if (this.f474712d != null) goto L31;
        StageEventType r103 = r100.f474712d;
        if (r103 == null) goto L32;
        this.f474712d = r103;
        return;
    L32:
        return;
    }

    public i(String r100, String r110, long r111, StageEventType r112) {
        this(null, -1, r100, r110, r111, r112);
    }

    public i(String r100, int r101, String r102, String r103, long r104, StageEventType r105) {
        this.f474713e = r100;
        this.f474714f = r101;
        this.f474709a = r102;
        this.f474710b = r103;
        this.f474711c = r104;
        this.f474712d = r105;
    }
}
