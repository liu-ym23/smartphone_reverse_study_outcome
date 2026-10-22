package org.koin.androidx.scope;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import org.koin.core.scope.Scope;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lorg/koin/androidx/scope/ScopeHandlerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "setScope", "(Lorg/koin/core/scope/Scope;)V", "onCleared", "", "koin-androidx-scope_release"}, k = 1, mv = {1, 1, 18})
public final class ScopeHandlerViewModel extends ViewModel {
    private Scope scope;

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Scope r100 = this.scope;
        if (r100 == null) goto L5;
        r100.f526153j.a("Closing scope " + this.scope);
        r100.b();
    L5:
        this.scope = null;
    }

    public ScopeHandlerViewModel() {
    }

    public final Scope getScope() {
        return this.scope;
    }

    public final void setScope(Scope r100) {
        this.scope = r100;
    }
}
