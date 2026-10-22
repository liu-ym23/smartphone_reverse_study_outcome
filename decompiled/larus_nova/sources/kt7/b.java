package kt7;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f506066a = null;

    public static final class a implements BluetoothProfile.ServiceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f506067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BluetoothDevice[] f506068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BluetoothAdapter f506069c;

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceDisconnected(int r100) {
            this.f506067a.countDown();
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int r100, BluetoothProfile r101) {
            Intrinsics.checkNotNullParameter(r101, "proxy");
            BluetoothDevice[] r102 = this.f506068b;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
            BluetoothDevice r104 = null;
            if ((r101 instanceof BluetoothHeadset) == false) goto L6;
            BluetoothHeadset r105 = (BluetoothHeadset) r101;     // Catch: Throwable -> L15
        L7:
            if (r105 == null) goto L13;
            List<BluetoothDevice> r106 = r105.getConnectedDevices();     // Catch: Throwable -> L15
            if (r106 == null) goto L12;
            r104 = (BluetoothDevice) CollectionsKt.firstOrNull(r106);     // Catch: Throwable -> L15
        L12:
            r102[0] = r104;     // Catch: Throwable -> L15
        L13:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L24:
            this.f506069c.closeProfileProxy(r100, r101);     // Catch: Throwable -> L20
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        L22:
            this.f506067a.countDown();
            return;
        L20:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L22
        L6:
            r105 = null;
        L15:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L24
        }

        public a(CountDownLatch r100, BluetoothDevice[] r101, BluetoothAdapter r102) {
            this.f506067a = r100;
            this.f506068b = r101;
            this.f506069c = r102;
        }
    }

    static {
        f506066a = new b();
    }

    public b() {
    }

    public static String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        BluetoothDevice r101 = b(r100);
        if (r101 == null) goto L11;
        String r102 = r101.getName();
        if (r102 == null) goto L11;
        String r103 = StringsKt.trim(r102).toString();
        if (r103 == null) goto L11;
        if ((!StringsKt.isBlank(r103)) == false) goto L11;
        return r103;
    L11:
        return null;
    }

    public static BluetoothDevice b(Context r100) {
        BluetoothAdapter r101 = BluetoothAdapter.getDefaultAdapter();
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.isEnabled() == true) goto L8;
        return null;
    L8:
        CountDownLatch r102 = new CountDownLatch(1);
        BluetoothDevice[] r103 = new BluetoothDevice[1];
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r101.getProfileProxy(r100.getApplicationContext(), new a(r102, r103, r101), 1)));     // Catch: Throwable -> L11
    L13:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L17;
        r105 = r106;
    L17:
        if (((Boolean) r105).booleanValue() == true) goto L25;
        return null;
    L25:
        Result.m9449constructorimpl(Boolean.valueOf(r102.await(500, TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L21
    L24:
        return r103[0];
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static String c(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        BluetoothDevice r111 = b(r110);
        if (r111 == null) goto L19;
        String r112 = r111.getAddress();
        if (r112 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r112)) == true) goto L10;
        r112 = null;
    L10:
        if (r112 != null) goto L12;
        return null;
    L12:
        if (StringsKt.isBlank(r112) == true) goto L22;
        byte[] r100 = MessageDigest.getInstance("SHA-256").digest(r112.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r100);     // Catch: Exception -> L16
        return ArraysKt.joinToString$default(r100, "", null, null, 0, null, new kt7.a(), 30, null);
    L23:
        return null;
    L22:
        return null;
    L19:
        return null;
    }
}
