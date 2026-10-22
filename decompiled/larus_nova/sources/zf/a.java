package zf;

import cf.o;
import cf.p;
import com.bytedance.android.ec.common.api.IPageStateService;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f571590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f571591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f571592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f571593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f571594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f571595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f571596g;

    /* JADX INFO: renamed from: zf.a$a, reason: collision with other inner class name */
    public static final class C8449a {
    }

    static {
    }

    @Override // cf.p
    public final void onCreate() {
        o r100 = this.f571591b;
        if (r100 == null) goto L6;
        r100.onCreate();
        return;
    }

    @Override // cf.p
    public final void onDestroy() {
        o r100 = this.f571591b;
        if (r100 == null) goto L6;
        r100.onDestroy();
    L6:
        if (this.f571593d == true) goto L11;
        this.f571593d = true;
        o r101 = this.f571591b;
        if (r101 == null) goto L12;
        r101.g();
        return;
    L12:
        return;
    }

    @Override // cf.p
    public final void onPause() {
        o r100 = this.f571591b;
        if (r100 == null) goto L6;
        r100.onPause();
        return;
    }

    @Override // cf.p
    public final void onResume() {
        o r100 = this.f571591b;
        if (r100 == null) goto L6;
        r100.onResume();
    L6:
        if (this.f571592c == true) goto L11;
        this.f571592c = true;
        o r101 = this.f571591b;
        if (r101 == null) goto L12;
        r101.f();
        return;
    L12:
        return;
    }

    @Override // cf.p
    public final void onStart() {
        o r100 = this.f571591b;
        if (r100 == null) goto L6;
        r100.onStart();
        return;
    }

    @Override // cf.p
    public final void onStop() {
        o r100 = this.f571591b;
        if (r100 == null) goto L6;
        r100.onStop();
        return;
    }

    @Override // cf.p
    public final void a(boolean r100) {
        o r101 = this.f571591b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // cf.p
    public final void b(int r100) {
        o r101 = this.f571591b;
        if (r101 == null) goto L6;
        r101.e();
        return;
    }

    public a(String r100, String r101) {
        this.f571590a = MapsKt.mapOf(TuplesKt.to("page_state_listener_extra", r101));
        if (r100 == null) goto L7;
        int r102 = ECSdk.f48106a;
        IPageStateService r103 = (IPageStateService) ECSdk.a(IPageStateService.class);
        if (r103 == null) goto L7;
        o r104 = r103.getPageStateListener(r100);
    L8:
        this.f571591b = r104;
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // cf.p
    public final void d(int r100, int r101, float r102) {
        Integer r103 = this.f571596g;
        if (r103 != null) goto L6;
    L7:
        o r104 = this.f571591b;
        if (r104 == null) goto L10;
        r104.d(r100, r101, r102);
    L10:
        this.f571596g = Integer.valueOf(r100);
        if (r102 != 0.0f) goto L20;
        if (this.f571592c == false) goto L20;
        if (this.f571594e == true) goto L20;
        this.f571594e = true;
        o r105 = this.f571591b;
        if (r105 == null) goto L29;
        r105.c();
        return;
    L29:
        return;
    L20:
        if (r102 == (-1.0f)) goto L22;
        return;
    L22:
        if (this.f571593d == true) goto L24;
        return;
    L24:
        if (this.f571595f == true) goto L33;
        this.f571595f = true;
        o r106 = this.f571591b;
        if (r106 == null) goto L34;
        r106.b();
        return;
    L34:
        return;
    L33:
        return;
    L6:
        if (r103.intValue() == r100) goto L10;
        goto L7
    }
}
