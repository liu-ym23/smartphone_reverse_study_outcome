package v8c;

import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements UDCheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f553759a;

    public d(Ref.BooleanRef r100) {
        this.f553759a = r100;
    }

    @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
    public final void a(UDCheckBox r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        this.f553759a.element = r101;
    }
}
