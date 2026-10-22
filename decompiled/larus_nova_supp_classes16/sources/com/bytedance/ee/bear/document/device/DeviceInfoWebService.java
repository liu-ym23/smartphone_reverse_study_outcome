package com.bytedance.ee.bear.document.device;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appcontext.applifecycle.q;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DeviceInfoWebService extends vv4.a {
    public boolean a;
    public final b b;

    public static class FoldStatesChangedParam implements NonProguard {
        private DeviceType deviceType;
        private boolean isFold;

        public static final enum DeviceType extends Enum<DeviceType> {
            public static final /* synthetic */ DeviceType[] a = null;
            public static final DeviceType android = null;
            public static final DeviceType androidPad = null;

            static {
                DeviceType r0 = new DeviceType("androidPad", 0);
                androidPad = r0;
                DeviceType r1 = new DeviceType("android", 1);
                android = r1;
                a = new DeviceType[]{r0, r1};
            }

            public static DeviceType[] values() {
                return (DeviceType[]) a.clone();
            }

            public static DeviceType valueOf(String r1) {
                return (DeviceType) r27.a.a(DeviceType.class, r1);
            }

            public DeviceType(String r1, int r2) {
                super(r1, r2);
            }
        }

        public DeviceType getDeviceType() {
            return this.deviceType;
        }

        public boolean isFold() {
            return this.isFold;
        }

        public static /* synthetic */ DeviceType access$000(FoldStatesChangedParam r0) {
            return r0.deviceType;
        }

        public static /* synthetic */ boolean access$100(FoldStatesChangedParam r0) {
            return r0.isFold;
        }

        public void setDeviceType(DeviceType r1) {
            this.deviceType = r1;
        }

        public void setFold(boolean r1) {
            this.isFold = r1;
        }

        public FoldStatesChangedParam(DeviceType r2, boolean r3) {
            DeviceType r0 = DeviceType.androidPad;
            this.deviceType = r2;
            this.isFold = r3;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.document.device.b] */
    public DeviceInfoWebService() {
        this.a = false;
        this.b = new b(this);
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        bindBridgeHandlerAutoUnbind("biz.device.getInfo", new a(getContext()));
        this.a = ku5.c.k(getContext());
        Object r3 = q.c;
        q.a.a.a(this.b);
    }

    @Override // vv4.a, vv4.m
    public final void onDetachFromWeb(k r2) {
        super.onDetachFromWeb(r2);
        Object r3 = q.c;
        q.a.a.b(this.b);
    }
}
