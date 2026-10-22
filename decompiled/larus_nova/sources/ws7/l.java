package ws7;

import com.dtf.face.network.APICallback;

/* JADX INFO: loaded from: classes22.dex */
public final class l implements APICallback<String> {
    public l() {
    }

    @Override // com.dtf.face.network.APICallback
    public final void onSuccess(String r100) {
        o.a("FACE");
    }

    @Override // com.dtf.face.network.APICallback
    public final void onError(String r100, String r101, String r102) {
        o.b("FACE", r100, r101, r102);
    }
}
