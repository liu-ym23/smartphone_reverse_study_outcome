package qr1;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f534520a;

    public f(i r100) {
        this.f534520a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = Boolean.TRUE;
        if (r101.equals((Boolean) r100) == false) goto L6;
        this.f534520a.d("point_start_request_time", String.valueOf(System.currentTimeMillis()));
        return;
    }
}
