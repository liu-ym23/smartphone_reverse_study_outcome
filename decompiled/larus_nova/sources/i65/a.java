package i65;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f488431a;

    public a(b r100) {
        this.f488431a = r100;
    }

    @Override // bu5.a
    public final void didReceivePush(String r100) {
        tt5.a.h("DriveComponent", "FILE_META_UPDATE: " + du5.b.f(r100));
        b r101 = this.f488431a;
        r101.f488435d.postValue(r101.f488432a);
    }
}
