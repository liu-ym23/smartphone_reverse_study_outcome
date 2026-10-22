package kta;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.heytap.openid.IOpenID;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes34.dex */
public final class t implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f506133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f506134b;

    public class a extends pta.e<Boolean> {
        public a() {
        }

        @Override // pta.e
        public final Boolean a(Object[] r100) {
            boolean r101 = false;
            PackageInfo r102 = ((Context) r100[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);     // Catch: Exception -> L15
            if (r102 != null) goto L7;
            return Boolean.FALSE;
        L7:
            if (Build.VERSION.SDK_INT < 28) goto L9;
            long r103 = r102.getLongVersionCode();     // Catch: Exception -> L15
        L11:
            if (r103 < 1) goto L20;
            r101 = true;
        L20:
            return Boolean.valueOf(r101);
        L9:
            r103 = r102.versionCode;     // Catch: Exception -> L15
        L15:
            e = move-exception;
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public class b implements w.b<IOpenID, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f506135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f506136b;

        @Override // kta.w.b
        public final String a(IOpenID r100) throws Exception {
            IOpenID r101 = r100;
            if (r101 == null) goto L37;
            t r102 = this.f506136b;
            Context r103 = this.f506135a;
            r102.getClass();
            PackageInfo r104 = r103.getPackageManager().getPackageInfo(r103.getPackageName(), 64);     // Catch: Exception -> L10
            if (r104 == null) goto L12;
            Signature[] r105 = r104.signatures;     // Catch: Exception -> L10
        L13:
            if (r105 != null) goto L15;
        L26:
            String r106 = null;
        L28:
            if (TextUtils.isEmpty(r106) == false) goto L30;
            return null;
        L30:
            return r101.getSerID(this.f506135a.getPackageName(), r106, "OUID");
        L15:
            if (r105.length <= 0) goto L26;
            int r107 = 0;
            byte[] r108 = r105[0].toByteArray();
            MessageDigest r109 = MessageDigest.getInstance("SHA1");     // Catch: Exception -> L24
            if (r109 == null) goto L26;
            byte[] r110 = r109.digest(r108);     // Catch: Exception -> L24
            StringBuilder r111 = new StringBuilder();     // Catch: Exception -> L24
            int r112 = r110.length;     // Catch: Exception -> L24
        L20:
            if (r107 >= r112) goto L22;
            r111.append(Integer.toHexString((r110[r107] & UByte.MAX_VALUE) | 256).substring(1, 3));     // Catch: Exception -> L24
            r107 = r107 + 1;     // Catch: Exception -> L24
            goto L20
        L22:
            r106 = r111.toString();     // Catch: Exception -> L24
        L24:
            e = move-exception;
            e.printStackTrace();
        L12:
            r105 = null;
        L10:
            e = move-exception;
            e.printStackTrace();
            goto L12
        L37:
            return null;
        }

        @Override // kta.w.b
        public final IOpenID b(IBinder r100) {
            return IOpenID.Stub.asInterface(r100);
        }

        public b(t r100, Context r101) {
            this.f506136b = r100;
            this.f506135a = r101;
        }
    }

    public t(x r100) {
        this.f506134b = new a();
        this.f506133a = r100;
    }

    @Override // kta.o
    public final boolean a(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        o r101 = this.f506133a;
        if (r101 == null) goto L12;
        if (r101.a(r100) == false) goto L12;
        return this.f506133a.a(r100);
    L12:
        return this.f506134b.b(new Object[]{r100}).booleanValue();
    }

    @Override // kta.o
    public final o.a getOaid(Context r100) {
        o r101 = this.f506133a;
        if (r101 != null) goto L5;
    L8:
        Intent r102 = new Intent();
        r102.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r102.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String r103 = (String) new w(r100, r102, new b(this, r100)).a();
        o.a r104 = new o.a();
        r104.f506112a = r103;
        return r104;
    L5:
        if (r101.a(r100) == false) goto L8;
        return this.f506133a.getOaid(r100);
    }
}
