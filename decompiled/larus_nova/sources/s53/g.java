package s53;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f540718a;

    public g(e r100) {
        this.f540718a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        e r101 = this.f540718a;
        r101.f540715i = (Map) r100;
        r101.d0();
    }
}
