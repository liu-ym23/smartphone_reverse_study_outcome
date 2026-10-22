package l87;

import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.AppProvider;
import j77.i;
import v67.u;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAccountService f508066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f508067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f508068c;

    public final void a() {
        IAccountService r100 = this.f508066a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f508067b == null) goto L20;
        String r101 = r100.getSecUid();
        String r102 = this.f508068c.f508058c;
        if (r102 != null) goto L9;
    L12:
        this.f508068c.f508058c = r101;
        String r103 = ((LocalSettings) i.a(AppProvider.getApp(), LocalSettings.class)).q0();
        f.g("UidSync", "repeat start,last_sec_uid=" + r103);
        f.g("UidSync", "repeat start,cur secUid=" + r101);
        if (TextUtils.equals("init_sec_uid", r103) == false) goto L15;
        f.g("UidSync", "last sec_uid is INIT_SEC_UID,do nothing");
        return;
    L15:
        if (TextUtils.equals(r101, r103) == true) goto L21;
        f.g("UidSync", "find curUid update,force update token " + r101);
        ThreadPlus.submitRunnable(new i87.c(this.f508067b, "passport_refresh"));
        return;
    L21:
        return;
    L9:
        if (TextUtils.equals(r101, r102) == false) goto L12;
        f.g("UidSync", "sdk has sync curUid,do nothing");
        return;
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

    public c(a r100, IAccountService r101, u r102) {
        this.f508068c = r100;
        this.f508066a = r101;
        this.f508067b = r102;
    }
}
