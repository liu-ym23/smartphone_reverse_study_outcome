package ga8;

import com.larus.avlink.simulInterpret.settings.TimbreCloneFragment;
import com.larus.common_ui.dialog.u;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimbreCloneFragment f480589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f480590b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        TimbreCloneFragment r100 = this.f480589a;
        boolean r101 = !this.f480590b;
        int r102 = TimbreCloneFragment.f294676i;
        r100.U90(r101);
    }

    public g(TimbreCloneFragment r100, boolean r101) {
        this.f480589a = r100;
        this.f480590b = r101;
    }
}
