package com.obric.sva.sdk.ahm;

import android.os.Binder;
import com.obric.sva.sdk.utils.LogUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import vendor.bytedance.hardware.ahm.IAHMCallbackIDL;
import yna.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/sva/sdk/ahm/AhmCallback;", "Lvendor/bytedance/hardware/ahm/IAHMCallbackIDL$Stub;", "<init>", "()V", "setVendorStability", "", "submitBuffer", "buffer", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AhmCallback extends IAHMCallbackIDL.Stub {
    public static /* synthetic */ void a(AhmCallback r100, byte[] r101) {
        submitBuffer$lambda$5(r100, r101);
    }

    public final void setVendorStability() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Method r101 = Binder.class.getDeclaredMethod("markVintfStability", new Class[0]);     // Catch: Throwable -> L5
        r101.setAccessible(true);     // Catch: Throwable -> L5
        r101.invoke(this, new Object[0]);     // Catch: Throwable -> L5
        LogUtils.i(AhmClient.TAG, "markVintfStability finish", new Object[0]);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        LogUtils.i(AhmClient.TAG, "stability error: " + r103.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public AhmCallback() {
        setVendorStability();
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMCallbackIDL
    public void submitBuffer(final byte[] r100) {
        if (r100 != null) goto L5;
        LogUtils.i(AhmClient.TAG, "buffer is null", new Object[0]);
        return;
    L5:
        AhmSlardarLogger.INSTANCE.getSingleExecutor$libs_mainlandRelease().execute(new a(this, r100));
    }

    private static final void submitBuffer$lambda$5(AhmCallback r100, byte[] r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        LogUtils.i(AhmClient.TAG, "buffer.size>>>>:" + r101.length, new Object[0]);     // Catch: Throwable -> L9
        String r103 = MediaMetricsItemParser.extractJsonData(r101);     // Catch: Throwable -> L9
        LogUtils.i(AhmClient.TAG, "buffer.data>>>>: " + r103, new Object[0]);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        AhmSlardarLogger r104 = AhmSlardarLogger.INSTANCE;     // Catch: Throwable -> L9
        r104.monitorEventForTeaAndSlardar(r103);     // Catch: Throwable -> L9
        r104.monitorEventForFaultTree(r103);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L17;
        LogUtils.e(AhmClient.TAG, "Error processing buffer: " + r106.getMessage(), new Object[0]);
        return;
    L17:
        return;
    L6:
        LogUtils.w(AhmClient.TAG, "Failed to extract valid payload from buffer", new Object[0]);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
