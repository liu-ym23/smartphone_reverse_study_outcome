package pwb;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.qrcode.api.IQRCodeResultHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKUserScope
public final class a implements owb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<IQRCodeResultHandler> f530857a = null;

    /* JADX INFO: renamed from: pwb.a$a, reason: collision with other inner class name */
    public static final class C7249a {
    }

    @Inject
    public a() {
    }

    static {
        ArrayList r100 = new ArrayList();
        r100.add(new qwb.a());
        f530857a = r100;
    }

    @Override // owb.a
    public final boolean L(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Iterator r103 = ((ArrayList) f530857a).iterator();     // Catch: Throwable -> L12
    L5:
        if (r103.hasNext() == false) goto L10;
        if (((IQRCodeResultHandler) r103.next()).a(r100, r101) == false) goto L5;
        return true;
    L10:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L24;
        Log.e("OpenFeishuQRCodeHandlerImpl", "handleFeishuQrCode throw exception", r105);
        return false;
    L24:
        return false;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
