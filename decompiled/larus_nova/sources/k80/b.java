package k80;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ScopeProvider;
import io.reactivex.CompletableSource;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements ScopeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f502078a;

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ScopeProvider
    public final CompletableSource requestScope() {
        return new a(this.f502078a);
    }

    public b(View r100) {
        this.f502078a = r100;
    }
}
