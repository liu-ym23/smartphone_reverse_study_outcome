package ew;

import com.bytedance.android.gamecp.host_api.model.network.NameValuePair;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class p implements yv.b {

    public static final class a implements zv.a<xv.a> {
        public a() {
        }

        @Override // zv.a
        public final void cancel() {
        }

        @Override // zv.a
        public final xv.a execute() {
            return new xv.a();
        }
    }

    public p() {
    }

    @Override // yv.b
    public final String getHostDomain() {
        return "";
    }

    @Override // yv.b
    public final zv.a P1(String r100, List r101) {
        return new a();
    }

    @Override // yv.b
    public final zv.a<xv.a> get(String r100, List<NameValuePair> r101) {
        return new a();
    }

    @Override // yv.b
    public final zv.a<xv.a> post(String r100, List<NameValuePair> r101, String r102, byte[] r103) {
        return new a();
    }

    @Override // yv.b
    public final zv.a<xv.a> uploadFile(int r100, String r101, List<NameValuePair> r102, String r103, byte[] r104, long r105, String r106) {
        return new a();
    }
}
