package q48;

import android.text.TextUtils;
import com.larus.apm.impl.NpthImpl;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NpthImpl f531705a;

    public /* synthetic */ r(NpthImpl r100) {
        this.f531705a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NpthImpl r100 = this.f531705a;
        int r101 = NpthImpl.f286962c;
        FLogger r102 = FLogger.f375446a;
        r102.i("NpthImpl", "trySaveDeviceIdToKeva start");
        IApplog.Companion r103 = IApplog.f287053a;
        String r104 = r103.getDeviceId();
        if (TextUtils.isEmpty(r104) == false) goto L5;
    L9:
        r102.i("NpthImpl", "trySaveDeviceIdToKeva addGetAppLogIdListener");
        r103.j(new com.larus.apm.impl.a(r100));
        return;
    L5:
        if (Intrinsics.areEqual("0", r104) == true) goto L9;
        if (Intrinsics.areEqual(r100.e(), r104) == true) goto L11;
        r102.i("NpthImpl", "trySaveDeviceIdToKeva store latest_did");
        r100.f286963b.storeString("latest_did", r104);
        return;
    }
}
