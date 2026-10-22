package em5;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a<T> extends cpc.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f473086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<T> f473087f;

    @Override // cpc.a
    public boolean a() {
        if (this.f473087f.size() >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // cpc.a
    public int b() {
        return this.f473087f.size();
    }

    @Override // cpc.a
    public final void c() {
        this.f473087f.clear();
        d(this.f473086e);
        ((ArrayList) this.f464755c).clear();
    }

    public final void e(ArrayList<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedItems");
        this.f473087f = r100;
        if (r100.isEmpty() == false) goto L6;
        c();
        return;
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "defaultStr");
        super(r100);
        this.f473086e = r101;
        this.f473087f = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f464754b = r101;
        this.f464756d = true;
    }
}
