package y00;

import android.content.DialogInterface;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.verify.VerifyErrorExtra;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import v80.g;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f565562a;

    public c(g r100) {
        this.f565562a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        VerifyErrorExtra.a r104 = VerifyErrorExtra.Companion;     // Catch: Throwable -> L8
        this.f565562a.getClass();     // Catch: Throwable -> L8
        r104.getClass();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter("", "jsonString");     // Catch: Throwable -> L8
        VerifyErrorExtra r105 = (VerifyErrorExtra) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), "", VerifyErrorExtra.class);     // Catch: Throwable -> L8
        Boolean r106 = Boolean.TRUE;     // Catch: Throwable -> L8
        r105.setLiveAgreement(r106);     // Catch: Throwable -> L8
        r105.setLiveAnswer(r106);     // Catch: Throwable -> L8
        Map<String, String> r107 = r105.toMap();     // Catch: Throwable -> L8
        if ((r107 instanceof HashMap) == true) goto L6;
        r107 = null;
    L6:
        Object r108 = Result.m9449constructorimpl((HashMap) r107);     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r108) == true) goto L15;
        r102 = r108;
    L15:
        if (((HashMap) r102) != null) goto L17;
        new HashMap();
    L17:
        this.f565562a.getClass();
        return;
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
