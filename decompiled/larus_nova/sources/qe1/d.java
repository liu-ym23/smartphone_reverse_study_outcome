package qe1;

import com.bytedance.android.livesdk.sharedpref.f;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f532619a;

    public d(e r100) {
        this.f532619a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.b.f158131c3;
        Boolean r103 = Boolean.FALSE;
        r102.getClass();
        f.d(r102, r103);
        com.bytedance.android.livesdk.sharedpref.e<Long> r104 = com.bytedance.android.livesdk.sharedpref.b.f158136d3;
        r104.getClass();
        f.d(r104, 2L);
        re1.a r105 = this.f532619a.f532621b;
        if (r105 == null) goto L6;
        r105.a();
        return;
    }
}
