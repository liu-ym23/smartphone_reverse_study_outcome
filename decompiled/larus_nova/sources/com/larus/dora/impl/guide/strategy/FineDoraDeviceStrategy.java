package com.larus.dora.impl.guide.strategy;

import android.bluetooth.BluetoothDevice;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes27.dex */
public final class FineDoraDeviceStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothDevice f335985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f335986b;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/guide/strategy/FineDoraDeviceStrategy$CheckBindStatusResponse;", "", "bindingStatus", "", "<init>", "(Ljava/lang/Boolean;)V", "getBindingStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/larus/dora/impl/guide/strategy/FineDoraDeviceStrategy$CheckBindStatusResponse;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("binding_status")
        private final Boolean bindingStatus;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.bindingStatus, ((a) r100).bindingStatus) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Boolean r100 = this.bindingStatus;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "CheckBindStatusResponse(bindingStatus=" + this.bindingStatus + ')';
        }

        public a() {
            this.bindingStatus = null;
        }

        public final Boolean a() {
            return this.bindingStatus;
        }
    }

    public static final class b {
    }

    static {
    }

    public final Object a(Continuation<? super Boolean> r100) {
        if ((r100 instanceof FineDoraDeviceStrategy$isConditionMet$1) == false) goto L7;
        FineDoraDeviceStrategy$isConditionMet$1 r101 = (FineDoraDeviceStrategy$isConditionMet$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L17;
        if (r105 != 1) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L13
    L22:
        Object r106 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r103).booleanValue()));     // Catch: Throwable -> L13
    L25:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L29;
        g49.d.c("FineDoraDeviceStrategy", "isConditionMet() SPP check failed: " + r107.getMessage(), r107);
        r106 = Boxing.boxBoolean(false);
    L29:
        boolean r108 = ((Boolean) r106).booleanValue();
        g49.d.d("FineDoraDeviceStrategy", "isConditionMet() SPP available=" + r108);
        return Boxing.boxBoolean(r108);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        g49.d.d("FineDoraDeviceStrategy", "isConditionMet() start vendor=" + this.f335986b + " device=" + this.f335985a);
        if (this.f335986b != 4096) goto L31;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L13
        CoroutineDispatcher r110 = Dispatchers.getIO();     // Catch: Throwable -> L13
        FineDoraDeviceStrategy$isConditionMet$isSppAvailable$1$1 r111 = new FineDoraDeviceStrategy$isConditionMet$isSppAvailable$1$1(this, null);     // Catch: Throwable -> L13
        r101.label = 1;     // Catch: Throwable -> L13
        r103 = BuildersKt.withContext(r110, r111, r101);     // Catch: Throwable -> L13
        if (r103 != r104) goto L22;
        return r104;
    L31:
        g49.d.d("FineDoraDeviceStrategy", "isConditionMet() unsupported vendor: " + this.f335986b);
        return Boxing.boxBoolean(false);
    L13:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new FineDoraDeviceStrategy$isConditionMet$1(this, r100);
        goto L8
    }

    public FineDoraDeviceStrategy(BluetoothDevice r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "device");
        this.f335985a = r100;
        this.f335986b = r101;
    }
}
