package py8;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanFilter;
import android.companion.AssociationRequest;
import android.companion.BluetoothDeviceFilter;
import android.companion.BluetoothLeDeviceFilter;
import android.companion.CompanionDeviceManager;
import android.companion.DeviceFilter;
import android.os.ParcelUuid;
import com.larus.cdm.DeviceHandler;
import com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1;
import com.larus.cdm.impl.FlowCompanionDeviceManagerDelegate;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompanionDeviceManager f531043a;

    @Override // py8.b
    public void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceAddress");
    }

    @Override // py8.b
    public void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceAddress");
    }

    @Override // py8.b
    public List<String> e() {
        return this.f531043a.getAssociations();
    }

    public d(CompanionDeviceManager r100) {
        Intrinsics.checkNotNullParameter(r100, "companionDeviceManager");
        this.f531043a = r100;
    }

    @Override // py8.b
    public void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        this.f531043a.disassociate(r100);
    }

    @Override // py8.b
    public boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        List<String> r101 = this.f531043a.getAssociations();
        FLogger.f375446a.d("flow_cdm", "[hasAssociated] " + r101);
        Iterator<T> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (StringsKt.equals(r100, (String) r103, true) == false) goto L4;
    L10:
        return o0.d((String) r103);
    L8:
        r103 = null;
        goto L10
    }

    @Override // py8.b
    public final void c(String r100, FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        Intrinsics.checkNotNullParameter(r101, "callback");
        FlowCompanionDeviceManagerDelegate.f323894a.getClass();     // Catch: Exception -> L39
        oy8.a r102 = FlowCompanionDeviceManagerDelegate.f323899f;     // Catch: Exception -> L39
        if (r102 == null) goto L6;
        int r103 = r102.getProductId();     // Catch: Exception -> L39
    L7:
        DeviceHandler.Device r104 = DeviceHandler.a(r103);     // Catch: Exception -> L39
        boolean r105 = false;
        if (r104.getScanUUID().length() <= 0) goto L10;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L28;
        if (DeviceHandler.a(r103) != DeviceHandler.Device.H_FREE_CLIP) goto L16;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == true) goto L28;
        DeviceFilter<?> r108 = new BluetoothLeDeviceFilter.Builder().setScanFilter(new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(r104.getScanUUID())).build()).build();     // Catch: IllegalArgumentException -> L25 Exception -> L39
    L35:
        if (r108 == null) goto L37;
        this.f531043a.associate(new AssociationRequest.Builder().addDeviceFilter(r108).setSingleDevice(true).build(), new c(r101), null);     // Catch: Exception -> L39
        return;
    L37:
        r101.a("Invalid device params: UUID or MAC address is illegal/empty");     // Catch: Exception -> L39
        return;
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L39
    L34:
        r108 = null;
        goto L35
    L16:
        if (DeviceHandler.a(r103) == DeviceHandler.Device.H_FREE_PRO) goto L21;
        if (DeviceHandler.a(r103) == DeviceHandler.Device.H_FREE_BUDS_PRO) goto L21;
        r107 = false;
    L28:
        if (r100.length() <= 0) goto L30;
        r105 = true;
    L30:
        if (r105 == false) goto L34;
        if (BluetoothAdapter.checkBluetoothAddress(r100) == false) goto L34;
        r108 = new BluetoothDeviceFilter.Builder().setAddress(r100).build();     // Catch: Exception -> L39
        goto L35
    L10:
        r106 = false;
        goto L12
    L6:
        r103 = -1;
    L39:
        e = move-exception;
        e.printStackTrace();
        r101.a("Association init failed: " + e.getMessage());
    }
}
