package kl4;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.dorax.kmp.registry.DeviceConnectionState;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f503852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DeviceConnectionState f503853b;

    public b() {
        this.f503852a = new ArrayList();
        this.f503853b = DeviceConnectionState.DISCONNECTED;
        IDoraLinkCallback r100 = new a(this);
        ak4.a.d().registerDoraLinkCallback(r100);
    }

    @Override // kl4.h
    public final DeviceConnectionState getConnectionState() {
        DoraDevice r100 = ak4.a.d().current();
        if (r100 == null) goto L5;
        int r101 = ak4.a.d().getDoraLinkState(r100);
    L7:
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        return DeviceConnectionState.DISCONNECTED;
    L15:
        return DeviceConnectionState.CONNECTED;
    L13:
        return DeviceConnectionState.CONNECTING;
    L5:
        r101 = 0;
        goto L7
    }
}
