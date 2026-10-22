package com.bytedance.ee.bear.document.device;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appcontext.applifecycle.q;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class DeviceInfoWebService extends vv4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f219503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f219504b;

    public static class FoldStatesChangedParam implements NonProguard {
        private DeviceType deviceType;
        private boolean isFold;

        public static final enum DeviceType extends Enum<DeviceType> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ DeviceType[] f219505a = null;

            /* JADX INFO: renamed from: android, reason: collision with root package name */
            public static final DeviceType f219506android = null;
            public static final DeviceType androidPad = null;

            static {
                DeviceType r100 = new DeviceType("androidPad", 0);
                androidPad = r100;
                DeviceType r101 = new DeviceType("android", 1);
                f219506android = r101;
                f219505a = new DeviceType[]{r100, r101};
            }

            public static DeviceType[] values() {
                return (DeviceType[]) f219505a.clone();
            }

            public static DeviceType valueOf(String r100) {
                return (DeviceType) r27.a.a(DeviceType.class, r100);
            }

            public DeviceType(String r100, int r101) {
                super(r100, r101);
            }
        }

        public DeviceType getDeviceType() {
            return this.deviceType;
        }

        public boolean isFold() {
            return this.isFold;
        }

        public static /* synthetic */ DeviceType access$000(FoldStatesChangedParam r100) {
            return r100.deviceType;
        }

        public static /* synthetic */ boolean access$100(FoldStatesChangedParam r100) {
            return r100.isFold;
        }

        public void setDeviceType(DeviceType r100) {
            this.deviceType = r100;
        }

        public void setFold(boolean r100) {
            this.isFold = r100;
        }

        public FoldStatesChangedParam(DeviceType r100, boolean r101) {
            DeviceType r102 = DeviceType.androidPad;
            this.deviceType = r100;
            this.isFold = r101;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.document.device.b] */
    public DeviceInfoWebService() {
        this.f219503a = false;
        this.f219504b = new b(this);
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind("biz.device.getInfo", new a(getContext()));
        this.f219503a = ku5.c.k(getContext());
        Object r101 = q.f408854c;
        q.a.f408857a.a(this.f219504b);
    }

    @Override // vv4.a, vv4.m
    public final void onDetachFromWeb(k r100) {
        super.onDetachFromWeb(r100);
        Object r101 = q.f408854c;
        q.a.f408857a.b(this.f219504b);
    }
}
