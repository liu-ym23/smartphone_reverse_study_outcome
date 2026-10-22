package com.ss.android.ttvecamera.cameracapabilitycollector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraCapabilityCollector {
    public static final Map<Integer, Capability> sCapabilityMetadataMap = null;
    private List<CapabilityDescription> mCapabilityList;
    private boolean mIsInited;
    private ITECameraCapabilityUploadStrategy mStrategy;

    public static final enum Capability extends Enum<Capability> {
        private static final /* synthetic */ Capability[] $VALUES = null;
        public static final Capability DEPTH_OUTPUT = null;
        public static final Capability FPS_RANGE = null;
        public static final Capability FRONT_BACK_MULTICAM_COMBOS = null;
        public static final Capability HIGH_SPEED_VIDEO_FPS_RANGE = null;
        public static final Capability LOGICAL_MULTI_CAMERA = null;
        public static final Capability MANUAL_3A = null;
        public static final Capability PICTURE_SIZE = null;
        public static final Capability PREVIEW_SIZE = null;
        public static final Capability SUPPORT_APERTURES = null;
        public static final Capability SUPPORT_EXTENSIONS = null;

        private static /* synthetic */ Capability[] $values() {
            return new Capability[]{DEPTH_OUTPUT, PREVIEW_SIZE, PICTURE_SIZE, FPS_RANGE, MANUAL_3A, HIGH_SPEED_VIDEO_FPS_RANGE, SUPPORT_APERTURES, LOGICAL_MULTI_CAMERA, SUPPORT_EXTENSIONS, FRONT_BACK_MULTICAM_COMBOS};
        }

        static {
            DEPTH_OUTPUT = new Capability("DEPTH_OUTPUT", 0);
            PREVIEW_SIZE = new Capability("PREVIEW_SIZE", 1);
            PICTURE_SIZE = new Capability("PICTURE_SIZE", 2);
            FPS_RANGE = new Capability("FPS_RANGE", 3);
            MANUAL_3A = new Capability("MANUAL_3A", 4);
            HIGH_SPEED_VIDEO_FPS_RANGE = new Capability("HIGH_SPEED_VIDEO_FPS_RANGE", 5);
            SUPPORT_APERTURES = new Capability("SUPPORT_APERTURES", 6);
            LOGICAL_MULTI_CAMERA = new Capability("LOGICAL_MULTI_CAMERA", 7);
            SUPPORT_EXTENSIONS = new Capability("SUPPORT_EXTENSIONS", 8);
            FRONT_BACK_MULTICAM_COMBOS = new Capability("FRONT_BACK_MULTICAM_COMBOS", 9);
            $VALUES = $values();
        }

        public static Capability[] values() {
            return (Capability[]) $VALUES.clone();
        }

        public static Capability valueOf(String r100) {
            return (Capability) a.a(Capability.class, r100);
        }

        private Capability(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class CapabilityDescription {
        public DataType dataType;
        public Capability identity;
        public Object value;

        public CapabilityDescription(Capability r100, DataType r101, Object r102) {
            this.identity = r100;
            this.dataType = r101;
            this.value = r102;
        }
    }

    public static final enum DataType extends Enum<DataType> {
        private static final /* synthetic */ DataType[] $VALUES = null;
        public static final DataType BOOLEAN = null;
        public static final DataType FLOAT = null;
        public static final DataType INTEGER = null;
        public static final DataType LONG = null;
        public static final DataType STRING = null;
        public static final DataType UNKNOWN = null;

        private static /* synthetic */ DataType[] $values() {
            return new DataType[]{UNKNOWN, BOOLEAN, INTEGER, LONG, FLOAT, STRING};
        }

        static {
            UNKNOWN = new DataType("UNKNOWN", 0);
            BOOLEAN = new DataType("BOOLEAN", 1);
            INTEGER = new DataType("INTEGER", 2);
            LONG = new DataType("LONG", 3);
            FLOAT = new DataType("FLOAT", 4);
            STRING = new DataType("STRING", 5);
            $VALUES = $values();
        }

        public static DataType[] values() {
            return (DataType[]) $VALUES.clone();
        }

        public static DataType valueOf(String r100) {
            return (DataType) a.a(DataType.class, r100);
        }

        private DataType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface ITECameraCapabilityUploadStrategy {
        DataType getDataType(Capability r100);

        void upload(List<CapabilityDescription> r100);
    }

    static {
        HashMap r100 = new HashMap();
        sCapabilityMetadataMap = r100;
        r100.put(8, Capability.DEPTH_OUTPUT);
        r100.put(1, Capability.MANUAL_3A);
        r100.put(11, Capability.LOGICAL_MULTI_CAMERA);
    }

    public void upload() {
        this.mStrategy.upload(this.mCapabilityList);
        this.mCapabilityList.clear();
    }

    public TECameraCapabilityCollector() {
        this.mIsInited = false;
    }

    public void addCapability(CapabilityDescription r100) {
        List<CapabilityDescription> r101 = this.mCapabilityList;
        if (r101 == null) goto L6;
        r101.add(r100);
        return;
    }

    public DataType getDataType(Capability r100) {
        return this.mStrategy.getDataType(r100);
    }

    public void init(ITECameraCapabilityUploadStrategy r100) {
        if (this.mIsInited == false) goto L5;
        return;
    L5:
        if (this.mCapabilityList != null) goto L8;
        this.mCapabilityList = new ArrayList();
    L8:
        if (this.mStrategy != null) goto L10;
        this.mStrategy = r100;
    L10:
        this.mIsInited = true;
    }
}
