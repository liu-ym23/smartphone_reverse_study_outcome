package hp5;

import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements UDCheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f486436a;

    public b(e r100) {
        this.f486436a = r100;
    }

    @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
    public final void a(UDCheckBox r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        e r102 = this.f486436a;
        if (r102.f486442d == false) goto L11;
        UDButton r103 = r102.f486444f;
        if (r103 == null) goto L8;
        r103.setClickable(r101);
    L8:
        UDButton r104 = r102.f486444f;
        if (r104 == null) goto L11;
        r104.setEnabled(r101);
    L11:
        UDCheckBox.c r105 = this.f486436a.f486445g;
        if (r105 == null) goto L15;
        r105.a(r100, r101);
        return;
    }
}
