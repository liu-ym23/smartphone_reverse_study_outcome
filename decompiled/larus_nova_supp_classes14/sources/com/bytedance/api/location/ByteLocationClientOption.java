package com.bytedance.api.location;

import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ByteLocationClientOption {
    public long a;
    public final LocationOption b;
    public volatile int c;
    public int d;
    public LocationMode e;
    public long f;
    public long g;
    public String h;
    public LocationExtraBean i;
    public String j;
    public int k;
    public boolean l;
    public boolean m;
    public Object n;
    public long o;
    public LocationTraceLogger p;
    public String q;
    public BDLocationExtraDataServer r;

    public static final enum LocationMode extends Enum<LocationMode> {
        public static final LocationMode Battery_Saving = null;
        public static final LocationMode Device_Sensors = null;
        public static final LocationMode Hight_Accuracy = null;
        public static final /* synthetic */ LocationMode[] a = null;

        static {
            LocationMode r0 = new LocationMode("Battery_Saving", 0);
            Battery_Saving = r0;
            LocationMode r1 = new LocationMode("Device_Sensors", 1);
            Device_Sensors = r1;
            LocationMode r3 = new LocationMode("Hight_Accuracy", 2);
            Hight_Accuracy = r3;
            a = new LocationMode[]{r0, r1, r3};
        }

        public static LocationMode[] values() {
            return (LocationMode[]) a.clone();
        }

        public static LocationMode valueOf(String r1) {
            return (LocationMode) a.a(LocationMode.class, r1);
        }

        public LocationMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final String a() {
        int r0 = this.c;
        if (r0 != 0) goto L5;
        return "init";
    L5:
        if (r0 != 1) goto L7;
        return "requesting_network";
    L7:
        if (r0 != 2) goto L9;
        return "requesting_gps";
    L9:
        if (r0 != 3) goto L11;
        return "requesting_both";
    L11:
        if (r0 != 5) goto L13;
        return "cancel";
    L13:
        if (r0 != 6) goto L15;
        return "end";
    L15:
        return String.valueOf(this.c);
    }

    public ByteLocationClientOption(LocationOption r3) {
        this.c = 0;
        this.d = 0;
        this.e = LocationMode.Battery_Saving;
        this.f = DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS;
        this.k = 1;
        this.l = true;
        this.b = r3;
    }
}
