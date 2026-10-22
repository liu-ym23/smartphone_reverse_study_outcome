package ct1;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f465310a;

    public c(b r100) {
        this.f465310a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        b r102 = this.f465310a;
        r102.f465303f = r101.booleanValue();
        if (r101.booleanValue() == false) goto L8;
        b.CountDownTimerC5582b r103 = this.f465310a.f465300c;
        if (r103 == null) goto L7;
        r103.cancel();
    L7:
        this.f465310a.f465301d = 2;
        return;
    L8:
        b r104 = this.f465310a;
        r104.a(r104.f465299b);
    }
}
