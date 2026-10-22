package r0c;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.Contexts;
import com.ss.lark.android.encryption.CipherManager;

/* JADX INFO: loaded from: classes37.dex */
public final class k implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f535529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f535530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f535532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f535533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f535534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f535535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f535536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f535537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.ss.android.lark.compose.foundation.toast.g f535538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q0c.a f535539k;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f535540a;

        public final void a() {
            final q0c.b r100 = p0c.a.a();
            if (r100 != null) goto L6;
            return;
        L6:
            if (r100.isCipherStatusOn() == false) goto L9;
            LKUIToast.show(this.f535540a.f535529a, R.string.Lark_Core_SecuritySettingKAToast);
            CipherManager.h();
            return;
        L9:
            k r101 = this.f535540a;
            if (r101.f535537i == false) goto L13;
            e.a(r101.f535529a, "key_result_saved_image", r101.f535531c);
            return;
        L13:
            AuthorizationServiceV2.b r102 = new i(this, r100);
            r100.checkImageDownloadAuthorizationAndShowWarningOnFailed(r101.f535532d, r101.f535533e, r101.f535534f, r101.f535529a, Integer.valueOf(R.string.Lark_Audit_BlockedActionDownloadFullImage), r102);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(k r100) {
            this.f535540a = r100;
        }
    }

    @Override // r0c.d
    public final String a() {
        return UIUtils.getString(this.f535529a, this.f535535g);
    }

    public final void c() {
        com.ss.android.lark.compose.foundation.toast.g r100 = this.f535538j;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f535538j = null;
        return;
    }

    @Override // r0c.d
    public final Runnable getAction() {
        return new a(this);
    }

    @Override // r0c.d
    public final boolean isValid() {
        return this.f535530b;
    }

    public static void b(k r100, boolean r101) {
        r100.getClass();
        Activity r102 = Contexts.requireActivity(r100.f535529a);     // Catch: IllegalArgumentException -> L5
    L7:
        if (r102 == null) goto L12;
        Intent r103 = new Intent();
        r103.putExtra("key_result_saved_image", r101);
        r102.setResult(-1, r103);
        r102.finish();
        return;
    L12:
        return;
    L5:
        e = move-exception;
        Log.e("SavePhotoUrlAction", "mContext not Activity", e);
        r102 = null;
        goto L7
    }

    public k(Context r100, boolean r101, String r102, String r103, String r104, String r105, int r106, boolean r107, boolean r110, q0c.a r111) {
        Lifecycle r108 = null;
        this.f535538j = null;
        this.f535539k = null;
        this.f535529a = r100;
        this.f535530b = r101;
        this.f535531c = r102;
        this.f535532d = r103;
        this.f535533e = r104;
        this.f535534f = r105;
        this.f535539k = r111;
        this.f535535g = r106;
        this.f535536h = r107;
        this.f535537i = r110;
        ComponentCallbacks2 r109 = Contexts.requireActivity(r100);     // Catch: Exception -> L9
        if ((r109 instanceof LifecycleOwner) == false) goto L6;
        r108 = ((LifecycleOwner) r109).getLifecycle();     // Catch: Exception -> L9
    L6:
        if (r108 == null) goto L14;
        r108.addObserver(new h(this, r108));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        Log.e("SavePhotoUrlAction", "onDestroy failed:" + e);
    }
}
