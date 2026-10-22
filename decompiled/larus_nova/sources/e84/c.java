package e84;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.MsaIdInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends b<MsaIdInterface> {

    public class a implements u.b<MsaIdInterface, String> {
        public a() {
        }

        @Override // e84.u.b
        public final String a(MsaIdInterface r100) throws Exception {
            MsaIdInterface r101 = r100;
            if (r101 != null) goto L6;
            return null;
        L6:
            return r101.getOAID();
        }

        @Override // e84.u.b
        public final MsaIdInterface b(IBinder r100) {
            return MsaIdInterface.Stub.asInterface(r100);
        }
    }

    @Override // e84.m
    public final String getName() {
        return "Common";
    }

    public c() {
        super("com.mdid.msa");
    }

    @Override // e84.b
    public final u.b<MsaIdInterface, String> c() {
        return new a();
    }

    @Override // e84.b
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        r101.setAction("com.bun.msa.action.bindto.service");
        r101.putExtra("com.bun.msa.param.pkgname", r100.getPackageName());
        return r101;
    }

    @Override // e84.b, e84.m
    public final m.a getOaid(Context r100) {
        String r101 = r100.getPackageName();
        Intent r102 = new Intent();
        r102.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        r102.setAction("com.bun.msa.action.start.service");
        r102.putExtra("com.bun.msa.param.pkgname", r101);
        r102.putExtra("com.bun.msa.param.runinset", true);     // Catch: Exception -> L5
        r100.startService(r102);     // Catch: Exception -> L5
    L8:
        return super.getOaid(r100);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
