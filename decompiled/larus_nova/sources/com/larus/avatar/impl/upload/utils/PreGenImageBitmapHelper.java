package com.larus.avatar.impl.upload.utils;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.utils.logger.FLogger;
import ey9.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes23.dex */
public final class PreGenImageBitmapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreGenImageBitmapHelper f291320a = null;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/avatar/impl/upload/utils/PreGenImageBitmapHelper$parseCreationBtnReplayInfo$1$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/CreationBtnReplayInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<wj8.b> {
        public a() {
        }
    }

    static {
        f291320a = new PreGenImageBitmapHelper();
    }

    public PreGenImageBitmapHelper() {
    }

    public static wj8.b b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        Object r102 = null;
        if (r101 == false) goto L24;
        return null;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Object r104 = Result.m9449constructorimpl((wj8.b) new Gson().fromJson(r100, new a().getType()));     // Catch: Throwable -> L13
    L15:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L19;
        FLogger.f375446a.e("PreGenImageBitmapHelper", "parseCreationBtnReplayInfo error: " + r105.getMessage());
    L19:
        if (Result.m9455isFailureimpl(r104) == true) goto L23;
        r102 = r104;
    L23:
        return (wj8.b) r102;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public static k c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        Object r102 = null;
        if (r101 == false) goto L24;
        return null;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Object r104 = Result.m9449constructorimpl((k) new Gson().fromJson(r100, k.class));     // Catch: Throwable -> L13
    L15:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L19;
        FLogger.f375446a.e("PreGenImageBitmapHelper", "parsePreGenImage error: " + r105.getMessage());
    L19:
        if (Result.m9455isFailureimpl(r104) == true) goto L23;
        r102 = r104;
    L23:
        return (k) r102;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r100, Continuation<? super Bitmap> r101) {
        if ((r101 instanceof PreGenImageBitmapHelper$fetchBitmap$1) == false) goto L7;
        PreGenImageBitmapHelper$fetchBitmap$1 r102 = (PreGenImageBitmapHelper$fetchBitmap$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        Ref.ObjectRef r107 = (Ref.ObjectRef) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L18:
        Bitmap r108 = (Bitmap) r104;
        if (r108 != null) goto L21;
        return null;
    L21:
        CloseableReference r109 = (CloseableReference) r107.element;
        if (r109 == null) goto L24;
        r109.close();
    L24:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        CoroutineDispatcher r111 = Dispatchers.getIO();
        PreGenImageBitmapHelper$fetchBitmap$bitmap$1 r112 = new PreGenImageBitmapHelper$fetchBitmap$bitmap$1(r100, r110, null);
        r102.L$0 = r110;
        r102.label = 1;
        Object r113 = BuildersKt.withContext(r111, r112, r102);
        if (r113 != r105) goto L17;
        return r105;
    L17:
        r104 = r113;
        r107 = r110;
    L7:
        r102 = new PreGenImageBitmapHelper$fetchBitmap$1(this, r101);
        goto L8
    }
}
