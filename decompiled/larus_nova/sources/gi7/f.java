package gi7;

import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements jta.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f481467a;

    @Override // jta.g.a
    public final void onRemoteConfigUpdate(boolean r100, boolean r101) {
    }

    public f(Uri r100) {
        this.f481467a = r100;
    }

    @Override // jta.g.a
    public final void onDidLoadLocally(boolean r100) {
        mi7.e.a("SchemaFirstLaunchReporter", "onDidLoadLocally " + r100 + '.');
        if (r100 == false) goto L6;
        AtomicBoolean r101 = g.f481468a;
        g.a(this.f481467a, null);
        return;
    }

    @Override // jta.g.a
    public final void onDeviceRegistrationInfoChanged(String r100, String r101) {
        mi7.e.a("SchemaFirstLaunchReporter", "onDeviceRegistrationInfoChanged " + r100 + '.');
        if (TextUtils.isEmpty(r100) == true) goto L9;
        AtomicBoolean r102 = g.f481468a;
        Uri r103 = this.f481467a;
        if (r100 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        g.a(r103, r100);
        return;
    }
}
