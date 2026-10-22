package pbb;

import com.ss.android.lark.larkicon.IconScene;
import io.reactivex.functions.Consumer;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ obb.a f528447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ obb.b f528448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f528449c;

    public a(obb.a r100, obb.b r101, long r102) {
        this.f528447a = r100;
        this.f528448b = r101;
        this.f528449c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        DecimalFormat r102 = vpb.f.f556745a;
        obb.a r103 = this.f528447a;
        if (r103 == null) goto L5;
        IconScene r104 = r103.f522634e;
    L6:
        IconScene r105 = r104;
        Integer r106 = this.f528448b.f522640d;
        if (r106 == null) goto L9;
        int r107 = r106.intValue();
    L10:
        vpb.f.a("fetch_icon_info", r105, r107, false, System.nanoTime() - this.f528449c, r101.getMessage());
        return;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
