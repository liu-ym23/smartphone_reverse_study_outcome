package lt4;

import com.bytedance.ee.bear.bitable.uikit.Action;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import gv4.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements UDCheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gv4.a f510671a;

    public a(e r100) {
        this.f510671a = r100;
    }

    @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
    public final void a(UDCheckBox r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        gv4.a r102 = this.f510671a;
        if (r102 == null) goto L6;
        r102.a(new Action(null, null, 3, null));
        return;
    }
}
