package qr1;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f534517a;

    public c(i r100) {
        this.f534517a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = Boolean.TRUE;
        if (r101.equals((Boolean) r100) == false) goto L6;
        this.f534517a.c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "playing state ready"));
        return;
    }
}
