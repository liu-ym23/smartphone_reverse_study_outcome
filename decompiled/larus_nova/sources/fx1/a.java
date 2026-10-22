package fx1;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f479095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Observer f479096b;

    public a(MutableLiveData r100, b r101) {
        this.f479095a = r100;
        this.f479096b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        MutableLiveData r100 = this.f479095a;
        if (r100 == null) goto L6;
        r100.removeObserver(this.f479096b);
        return;
    }
}
