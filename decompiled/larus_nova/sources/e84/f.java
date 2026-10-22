package e84;

import android.os.IBinder;
import android.util.Pair;
import com.bytedance.bdinstall.oaid.uodis.OpenDeviceIdentifierService;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements u.b<OpenDeviceIdentifierService, Pair<String, Boolean>> {
    public f() {
    }

    @Override // e84.u.b
    public final Pair<String, Boolean> a(OpenDeviceIdentifierService r100) throws Exception {
        OpenDeviceIdentifierService r101 = r100;
        if (r101 != null) goto L6;
        return null;
    L6:
        return new Pair(r101.getOaid(), Boolean.valueOf(r101.isOaidTrackLimited()));
    }

    @Override // e84.u.b
    public final OpenDeviceIdentifierService b(IBinder r100) {
        return OpenDeviceIdentifierService.Stub.asInterface(r100);
    }
}
