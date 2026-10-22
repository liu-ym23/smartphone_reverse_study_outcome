package i65;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements bu5.a {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void didReceivePush(String r3) {
        tt5.a.h("DriveComponent", "FILE_META_UPDATE: " + du5.b.f(r3));
        b r4 = this.a;
        r4.d.postValue(r4.a);
    }
}
