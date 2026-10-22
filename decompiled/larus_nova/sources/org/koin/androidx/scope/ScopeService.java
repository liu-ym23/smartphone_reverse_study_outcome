package org.koin.androidx.scope;

import android.app.Service;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.koin.core.scope.Scope;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lorg/koin/androidx/scope/ScopeService;", "Landroid/app/Service;", "Lorg/koin/core/scope/a;", "koin-androidx-scope_release"}, k = 1, mv = {1, 4, 0})
public abstract class ScopeService extends Service implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f526120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f526121b;

    @Override // org.koin.core.scope.a
    public final Scope getScope() {
        return (Scope) this.f526120a.getValue();
    }

    public ScopeService() {
        this.f526121b = true;
        this.f526120a = LazyKt.lazy(new ScopeService$scope$2(this));
    }

    @Override // org.koin.core.component.a
    public final org.koin.core.a Pw() {
        return a.C7098a.a(this);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        if (this.f526121b == false) goto L6;
        a.C7098a.a(this).f526124c.a("Open Service Scope: " + getScope());
        return;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        a.C7098a.a(this).f526124c.a("Close service scope: " + getScope());
        getScope().b();
    }
}
