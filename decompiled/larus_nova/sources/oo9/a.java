package oo9;

import com.larus.office.plugins.inputv2.component.sheet.SheetChatComponentV2;
import dw8.r;
import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class a implements r, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetChatComponentV2 f524658a;

    public a(SheetChatComponentV2 r100) {
        this.f524658a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof r) == true) goto L5;
        return false;
    L5:
        if ((r100 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.f524658a, SheetChatComponentV2.class, "handleAbilityState", "handleAbilityState(Lcom/larus/business/floatchat/api/AIChatAbilityHostState;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // dw8.r
    public final void a(dw8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        SheetChatComponentV2 r101 = this.f524658a;
        int r102 = SheetChatComponentV2.B;
        r101.getClass();
        if (r100.f470327b == false) goto L6;
        r101.U2("ability_ready", null);
        return;
    }
}
