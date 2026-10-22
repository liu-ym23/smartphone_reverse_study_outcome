package tg5;

import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements UDCheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f545873a;

    public e(b r100) {
        this.f545873a = r100;
    }

    @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
    public final void a(UDCheckBox r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        this.f545873a.D0(r101);
        p.a r102 = this.f545873a.f545854d;
        if (r102 == null) goto L6;
        r102.N(r101);
        return;
    }
}
