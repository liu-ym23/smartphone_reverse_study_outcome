package sq5;

import android.app.Activity;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements UDToast.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Activity> f543011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f543012b;

    @Override // com.larksuite.component.universe_design.toast.UDToast.c
    public final void a() {
        this.f543011a.element = null;
        this.f543012b.f543006g = null;
    }

    public d(Ref.ObjectRef<Activity> r100, b r101) {
        this.f543011a = r100;
        this.f543012b = r101;
    }
}
