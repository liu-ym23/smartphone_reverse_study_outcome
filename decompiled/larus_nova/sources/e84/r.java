package e84;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IOpenID;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import kotlin.UByte;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f471341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f471342b;

    public class a extends i84.r<Boolean> {
        public a() {
        }

        @Override // i84.r
        public final Boolean a(Object[] r100) {
            boolean r101 = false;
            PackageInfo r102 = ((Context) r100[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);     // Catch: Exception -> L15
            if (r102 != null) goto L7;
            return Boolean.FALSE;
        L7:
            if (Build.VERSION.SDK_INT < 28) goto L9;
            long r103 = r102.getLongVersionCode();     // Catch: Exception -> L15
        L11:
            if (r103 < 1) goto L19;
            r101 = true;
        L19:
            return Boolean.valueOf(r101);
        L9:
            r103 = r102.versionCode;     // Catch: Exception -> L15
            goto L11
        L16:
            return Boolean.FALSE;
        }
    }

    public class b implements u.b<IOpenID, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f471343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f471344b;

        @Override // e84.u.b
        public final String a(IOpenID r100) throws Exception {
            IOpenID r101 = r100;
            if (r101 == null) goto L37;
            r r102 = this.f471344b;
            Context r103 = this.f471343a;
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
            return r101.getSerID(this.f471343a.getPackageName(), r106, "OUID");
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

        @Override // e84.u.b
        public final IOpenID b(IBinder r100) {
            return IOpenID.Stub.asInterface(r100);
        }

        public b(r r100, Context r101) {
            this.f471344b = r100;
            this.f471343a = r101;
        }
    }

    @Override // e84.m
    public final String getName() {
        if (this.f471341a != null) goto L5;
        return "OnePlus/Oppo";
    L5:
        if (this.f471342b.b(new Object[0]).booleanValue() == false) goto L7;
        return "OnePlus/Oppo";
    L7:
        return this.f471341a.getName();
    }

    public r(v r100) {
        this.f471342b = new a();
        this.f471341a = r100;
    }

    @Override // e84.m
    public final boolean a(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Boolean r101 = this.f471342b.b(new Object[]{r100});
        if (this.f471341a == null) goto L12;
        if (r101.booleanValue() == true) goto L12;
        return this.f471341a.a(r100);
    L12:
        return r101.booleanValue();
    }

    @Override // e84.m
    public final m.a getOaid(Context r100) {
        if (this.f471341a != null) goto L5;
    L8:
        Intent r101 = new Intent();
        r101.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r101.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        b r102 = new b(this, r100);
        CountDownLatch r103 = new CountDownLatch(1);
        String r104 = null;
        u.a r105 = new u.a(r103, r102);     // Catch: Throwable -> L19
        if (r100.bindService(r101, r105, 1) == false) goto L24;
        r103.await();     // Catch: Throwable -> L19
        r104 = r102.a(r105.f471351c);     // Catch: Throwable -> L17
        r100.unbindService(r105);     // Catch: Throwable -> L15
    L35:
    L17:
        th = th;
    L33:
        th.printStackTrace();     // Catch: Throwable -> L26
        if (r105 == null) goto L24;
        r100.unbindService(r105);     // Catch: Throwable -> L15
    L26:
        th = move-exception;
        if (r105 != null) goto L38;
    L32:
        throw th;
    L38:
        r100.unbindService(r105);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
    L24:
        m.a r106 = new m.a();
        r106.f471323a = r104;
        return r106;
    L15:
        th = move-exception;
        th.printStackTrace();
    L19:
        th = th;
        r105 = null;
        goto L33
    L5:
        if (this.f471342b.b(new Object[0]).booleanValue() == true) goto L8;
        return this.f471341a.getOaid(r100);
    }
}
