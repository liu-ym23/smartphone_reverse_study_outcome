package n4a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;

/* JADX INFO: loaded from: classes32.dex */
public final class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s2 f517576a;

    public o3(Context r100) {
        this.f517576a = null;
        this.f517576a = new s2(r100.getApplicationContext());
    }

    public final IBinder a(Intent r100) {
        s2 r101 = this.f517576a;
        r101.getClass();
        String r102 = r100.getStringExtra(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        if (TextUtils.isEmpty(r102) == true) goto L10;
        Context r103 = r101.f517687h;
        int r104 = com.loc.i.f380094a;
        if (TextUtils.isEmpty(r102) == true) goto L10;
        v4.f517834d = r102;
        if (r103 == null) goto L10;
        k1.f517430d.b(new v4.a(r103, r102));
    L10:
        v4.f517832b = r100.getStringExtra("b");
        String r105 = r100.getStringExtra("d");
        if (TextUtils.isEmpty(r105) == true) goto L13;
        x4.f517927d = r105;
    L13:
        s2 r106 = this.f517576a;
        r106.getClass();
        if ("true".equals(r100.getStringExtra("as")) == false) goto L19;
        s2.a r107 = r106.f517686g;
        if (r107 == null) goto L19;
        r107.sendEmptyMessageDelayed(9, 100);
    L19:
        return new Messenger(this.f517576a.f517686g).getBinder();
    }
}
