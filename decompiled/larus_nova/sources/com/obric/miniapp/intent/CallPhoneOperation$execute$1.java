package com.obric.miniapp.intent;

import android.telephony.TelephonyManager;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CallPhoneOperation$execute$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public CallPhoneOperation$execute$1(Object r100) {
        super(0, r100, a.class, "isSimAbsent", "isSimAbsent()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        a r100 = (a) this.receiver;
        a r101 = a.f397688a;
        r100.getClass();
        Object r102 = AppHost.f326268a.getApplication().getSystemService("phone");
        if ((r102 instanceof TelephonyManager) == false) goto L5;
        TelephonyManager r103 = (TelephonyManager) r102;
    L6:
        if (r103 == null) goto L10;
        boolean r104 = true;
        if (r103.getSimState() != 1) goto L10;
    L12:
        return Boolean.valueOf(r104);
    L10:
        r104 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
