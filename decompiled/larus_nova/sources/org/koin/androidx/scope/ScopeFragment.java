package org.koin.androidx.scope;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.koin.core.scope.Scope;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lorg/koin/androidx/scope/ScopeFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/koin/core/scope/a;", "koin-androidx-scope_release"}, k = 1, mv = {1, 4, 0})
public abstract class ScopeFragment extends Fragment implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f526118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f526119e;

    public ScopeFragment() {
        super(0);
        this.f526119e = true;
        this.f526118d = LazyKt.lazy(new ScopeFragment$scope$2(this));
    }

    @Override // org.koin.core.scope.a
    public final Scope getScope() {
        return (Scope) this.f526118d.getValue();
    }

    @Override // org.koin.core.component.a
    public final org.koin.core.a Pw() {
        return a.C7098a.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        getScope().b();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        if (this.f526119e == false) goto L6;
        a.C7098a.a(this).f526124c.a("Open Fragment Scope: " + getScope());
        return;
    }
}
