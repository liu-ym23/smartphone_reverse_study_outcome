package kta;

import android.os.IBinder;
import android.util.Pair;
import com.bytedance.bdinstall.oaid.uodis.OpenDeviceIdentifierService;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements w.b<OpenDeviceIdentifierService, Pair<String, Boolean>> {
    public h() {
    }

    @Override // kta.w.b
    public final Pair<String, Boolean> a(OpenDeviceIdentifierService r100) throws Exception {
        OpenDeviceIdentifierService r101 = r100;
        if (r101 != null) goto L6;
        return null;
    L6:
        return new Pair(r101.getOaid(), Boolean.valueOf(r101.isOaidTrackLimited()));
    }

    @Override // kta.w.b
    public final OpenDeviceIdentifierService b(IBinder r100) {
        return OpenDeviceIdentifierService.Stub.asInterface(r100);
    }
}
