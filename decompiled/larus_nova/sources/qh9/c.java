package qh9;

import com.larus.home.impl.sdk.x1;
import com.larus.platform.api.e3;
import com.larus.platform.api.q4;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f533010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f533011b;

    public /* synthetic */ c(boolean r100, String r101) {
        this.f533010a = r100;
        this.f533011b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = this.f533010a;
        String r101 = this.f533011b;
        LarkSocialExp r102 = LarkSocialExp.f365340a;
        r102.getClass();
        boolean r103 = LarkSocialExp.f();
        boolean r104 = r102.c();
        FLogger.f375446a.i("LarkSocialSettingsListener", "apply desired state requested=" + r100 + " current=" + r103 + " shouldInitialize=" + r104 + " source=" + r101);
        e3 r105 = d.a();
        if (r105 == null) goto L5;
        ((x1) r105).k(r104);
    L5:
        if (r104 == true) goto L7;
        return;
    L7:
        if (d.a() == null) goto L17;
        q4 r106 = kc9.f.a();
        boolean r107 = true;
        if (r106.f365247a == false) goto L11;
    L14:
        boolean r108 = true;
    L15:
        if (r108 != true) goto L17;
    L18:
        if (r107 == true) goto L24;
        e3 r109 = d.a();
        if (r109 == null) goto L25;
        ((x1) r109).d(false, "SettingUpdate");
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if (r106.f365248b == true) goto L14;
        r108 = false;
    L17:
        r107 = false;
        goto L18
    }
}
