package g15;

import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.document.export.e f479588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f479589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f479590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.document.export.e.b f479591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int[] f479592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f479593f;

    public /* synthetic */ k(com.bytedance.ee.bear.document.export.e r100, Map r101, String r102, com.bytedance.ee.bear.document.export.e.b r103, int[] r104, int r105) {
        this.f479588a = r100;
        this.f479589b = r101;
        this.f479590c = r102;
        this.f479591d = r103;
        this.f479592e = r104;
        this.f479593f = r105;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.ee.bear.document.export.e r100 = this.f479588a;
        Map<String, com.bytedance.ee.bear.document.export.e.b> r101 = this.f479589b;
        String r102 = this.f479590c;
        com.bytedance.ee.bear.document.export.e.b r103 = this.f479591d;
        int[] r104 = this.f479592e;
        int r105 = this.f479593f;
        r100.getClass();
        r101.put(r102, r103);
        int r106 = r104[0] + 1;
        r104[0] = r106;
        if (r106 < r105) goto L7;
        r100.v(r101);
        return;
    }
}
