package j83;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ a a;

    public h(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Boolean r2 = (Boolean) r1;
        this.a.g();
    }
}
