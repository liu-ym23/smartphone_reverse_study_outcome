package dp8;

import android.os.Build;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import zd9.h;

/* JADX INFO: loaded from: classes26.dex */
public final class e {
    public static final CreationMsgContentData a(String r100) {
        Object r101 = null;
        if (r100 == null) goto L19;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        h.f571481a.getClass();     // Catch: Throwable -> L6
        Object r103 = Result.m9449constructorimpl((CreationMsgContentData) h.f571482b.fromJson(r100, CreationMsgContentData.class));     // Catch: Throwable -> L6
    L8:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L12;
        FLogger.f375446a.e("CreationDataConverter", "convertToCreationContentData failed", r104);
    L12:
        if (Result.m9455isFailureimpl(r103) == true) goto L16;
        r101 = r103;
    L16:
        return (CreationMsgContentData) r101;
    L6:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    L19:
        return null;
    }

    public static final String b(Image r100) {
        if (z2.f365865a.imageGenerateHeicConfig().f486776a == false) goto L19;
        if (r100 == null) goto L6;
        String r101 = r100.f364792b;
    L8:
        if (o0.d(r101) == false) goto L19;
        if (Build.VERSION.SDK_INT <= 26) goto L19;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("use urlV2 is ");
        if (r100 == null) goto L14;
        String r104 = r100.f364792b;
    L15:
        r103.append(r104);
        r102.d("data converter", r103.toString());
        if (r100 != null) goto L18;
        return null;
    L18:
        return r100.f364792b;
    L14:
        r104 = null;
        goto L15
    L6:
        r101 = null;
    L19:
        if (r100 != null) goto L21;
        return null;
    L21:
        return r100.f364791a;
    }

    public static final CreationMsgContentData c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Pair<String, CreationMsgContentData> r101 = b.f469614a;
        return b.a(r100.getContent(), new c());
    }
}
