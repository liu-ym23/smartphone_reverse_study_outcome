package wj5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f559996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f559997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f559998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f559999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f560000e;

    public k(a r100, boolean r101, String r102, String r103, int r104) {
        this.f559996a = r100;
        this.f559997b = r101;
        this.f559998c = r102;
        this.f559999d = r103;
        this.f560000e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        tt5.a.h("DocMoreInfoBehavior", "manualOfflineFlow ok. ");
        a r102 = this.f559996a;
        oj5.a r103 = r102.c();
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r103.f523535f = r101.booleanValue();
    L6:
        r102.e(r103);
        a r104 = this.f559996a;
        if (this.f559997b == false) goto L9;
        String r105 = this.f559998c;
    L10:
        Intrinsics.checkNotNull(r105);
        int r106 = this.f560000e;
        Intrinsics.checkNotNull(r101);
        r104.d(r105, r106, r101.booleanValue());
        return;
    L9:
        r105 = this.f559999d;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
