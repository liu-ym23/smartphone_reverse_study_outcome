package go1;

/* JADX INFO: loaded from: classes8.dex */
public final class x1<T> implements h80.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.widgetdescriptor.e0 f481893a;

    public x1(com.bytedance.android.livesdk.widgetdescriptor.e0 r100) {
        this.f481893a = r100;
    }

    @Override // h80.d
    public final Object get() {
        jo1.h r100 = ho1.a.g(this.f481893a);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.ok();
    }
}
