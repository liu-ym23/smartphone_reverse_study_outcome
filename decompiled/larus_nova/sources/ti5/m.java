package ti5;

import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements UDCheckBox.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransferApplyFragment f546130a;

    public m(TransferApplyFragment r100) {
        this.f546130a = r100;
    }

    @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
    public final void a(UDCheckBox r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        this.f546130a.f234290l = r101;
    }
}
