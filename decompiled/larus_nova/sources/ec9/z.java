package ec9;

import android.os.Process;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.home.impl.privacy.PrivacyAgreeActivity;

/* JADX INFO: loaded from: classes29.dex */
public final class z implements com.larus.common_ui.dialog.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivacyAgreeActivity f472156a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        PrivacyAgreeActivity r100 = this.f472156a;
        String r101 = r100.f346004a;
        b0.f472129a.getClass();
        b0.c(r100, false);
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r102 = ISecPrivacyService.a.a();
        if (r102 == null) goto L5;
        r102.b(r100);
    L5:
        Process.killProcess(Process.myPid());
    }

    public z(PrivacyAgreeActivity r100) {
        this.f472156a = r100;
    }
}
