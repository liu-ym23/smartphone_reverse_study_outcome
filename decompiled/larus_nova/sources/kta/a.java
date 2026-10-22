package kta;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends c<IDidAidlInterface> {

    /* JADX INFO: renamed from: kta.a$a, reason: collision with other inner class name */
    public class C6608a implements w.b<IDidAidlInterface, String> {
        public C6608a() {
        }

        @Override // kta.w.b
        public final String a(IDidAidlInterface r100) throws Exception {
            IDidAidlInterface r101 = r100;
            if (r101 != null) goto L6;
            return null;
        L6:
            return r101.getOAID();
        }

        @Override // kta.w.b
        public final IDidAidlInterface b(IBinder r100) {
            return IDidAidlInterface.Stub.asInterface(r100);
        }
    }

    public a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // kta.c
    public final w.b<IDidAidlInterface, String> c() {
        return new C6608a();
    }

    @Override // kta.c
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setAction("com.asus.msa.action.ACCESS_DID");
        r101.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return r101;
    }
}
