package mfa;

import androidx.fragment.app.FragmentActivity;
import com.larus.common_ui.dialog.p0;
import com.larus.permission.api.IPermissionX;
import com.obric.assistant.permission.IObricPermissionServiceImpl;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f513673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f513674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IPermissionX.c f513675c;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.f513673a.element = true;
        IPermissionX.f363962a.j(this.f513674b, this.f513675c);
    }

    public f(Ref.BooleanRef r100, FragmentActivity r101, IObricPermissionServiceImpl.d r102) {
        this.f513673a = r100;
        this.f513674b = r101;
        this.f513675c = r102;
    }
}
