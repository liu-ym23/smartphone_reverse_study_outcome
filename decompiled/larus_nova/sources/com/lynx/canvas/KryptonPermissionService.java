package com.lynx.canvas;

import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public abstract class KryptonPermissionService extends KryptonService {

    public static final enum PermissionType extends Enum<PermissionType> {
        private static final /* synthetic */ PermissionType[] $VALUES = null;
        public static final PermissionType CAMERA = null;
        public static final PermissionType RECORD_AUDIO = null;

        static {
            PermissionType r100 = new PermissionType("CAMERA", 0);
            CAMERA = r100;
            PermissionType r101 = new PermissionType("RECORD_AUDIO", 1);
            RECORD_AUDIO = r101;
            $VALUES = new PermissionType[]{r100, r101};
        }

        public static PermissionType[] values() {
            return (PermissionType[]) $VALUES.clone();
        }

        public static PermissionType valueOf(String r100) {
            return (PermissionType) a.a(PermissionType.class, r100);
        }

        private PermissionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface Responder {
        void onResponse(boolean r100);
    }

    public abstract boolean requestGranted(List<PermissionType> r100);

    public abstract void requestPermission(List<PermissionType> r100, Responder r101);

    public KryptonPermissionService() {
    }
}
