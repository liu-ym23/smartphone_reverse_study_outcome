package e84;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.IDidAidlInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends b<IDidAidlInterface> {

    /* JADX INFO: renamed from: e84.a$a, reason: collision with other inner class name */
    public class C5755a implements u.b<IDidAidlInterface, String> {
        public C5755a() {
        }

        @Override // e84.u.b
        public final String a(IDidAidlInterface r100) throws Exception {
            IDidAidlInterface r101 = r100;
            if (r101 != null) goto L6;
            return null;
        L6:
            return r101.getOAID();
        }

        @Override // e84.u.b
        public final IDidAidlInterface b(IBinder r100) {
            return IDidAidlInterface.Stub.asInterface(r100);
        }
    }

    @Override // e84.m
    public final String getName() {
        return "ASUS";
    }

    public a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // e84.b
    public final u.b<IDidAidlInterface, String> c() {
        return new C5755a();
    }

    @Override // e84.b
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setAction("com.asus.msa.action.ACCESS_DID");
        r101.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return r101;
    }
}
