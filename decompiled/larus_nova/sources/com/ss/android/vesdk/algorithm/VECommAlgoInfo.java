package com.ss.android.vesdk.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class VECommAlgoInfo {
    public String infoName;
    public int infoType;
    public String jsonString;
    public HashMap<String, VECommAlgoInfo> mapCommUnion;
    public ArrayList<ArrayList<VEAlgoCommUnion>> matCommUnion;
    public VEAlgoCommUnion unionValue1;
    public VEAlgoCommUnion unionValue2;
    public ArrayList<VEAlgoCommUnion> vecCommUnion;

    public static final enum VECommonAlgoInfoType extends Enum<VECommonAlgoInfoType> {
        private static final /* synthetic */ VECommonAlgoInfoType[] $VALUES = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_BOOL = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_COMBINE = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_DOUBLE = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_CPU_BUFFER_FP16 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_CPU_BUFFER_FP32 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT16 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT32 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT8 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT16 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT32 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT8 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_CVPIXELBUFFER = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_GL_TEXTURE = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_FRAME_METAL_TEXTURE = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_INT = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_JSON_PATH = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_JSON_STRING = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_JSON_STRING_VECTOR = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_MAP_NEST_INFO = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_MAT3X3F = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_MAT4X4F = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_MAT_VEC2 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_MAT_VEC3 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_MAT_VEC3X3F = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_MAT_VEC4 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_MAT_VEC4X4F = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_MAT_VEC4_QUAT = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_NONE = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_STRING = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC2F = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC3F = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC4F = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC4F_COLOR = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC4F_QUAT = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC4F_RECT = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC_DOUBLE = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC_FLOAT = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC_INT16 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC_INT32 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC_INT64 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC_INT8 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC_NEST_INFO = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC_UINT16 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC_UINT32 = null;
        public static final VECommonAlgoInfoType COMM_INFO_TYPE_VEC_UINT8 = null;

        private static /* synthetic */ VECommonAlgoInfoType[] $values() {
            return new VECommonAlgoInfoType[]{COMM_INFO_TYPE_NONE, COMM_INFO_TYPE_BOOL, COMM_INFO_TYPE_INT, COMM_INFO_TYPE_DOUBLE, COMM_INFO_TYPE_STRING, COMM_INFO_TYPE_COMBINE, COMM_INFO_TYPE_VEC2F, COMM_INFO_TYPE_VEC3F, COMM_INFO_TYPE_VEC4F, COMM_INFO_TYPE_VEC4F_QUAT, COMM_INFO_TYPE_VEC4F_COLOR, COMM_INFO_TYPE_VEC4F_RECT, COMM_INFO_TYPE_MAT3X3F, COMM_INFO_TYPE_MAT4X4F, COMM_INFO_TYPE_VEC_INT8, COMM_INFO_TYPE_VEC_INT16, COMM_INFO_TYPE_VEC_INT32, COMM_INFO_TYPE_VEC_INT64, COMM_INFO_TYPE_VEC_UINT8, COMM_INFO_TYPE_VEC_UINT16, COMM_INFO_TYPE_VEC_UINT32, COMM_INFO_TYPE_VEC_FLOAT, COMM_INFO_TYPE_VEC_DOUBLE, COMM_INFO_TYPE_MAT_VEC2, COMM_INFO_TYPE_MAT_VEC3, COMM_INFO_TYPE_MAT_VEC4, COMM_INFO_TYPE_MAT_VEC4_QUAT, COMM_INFO_TYPE_MAT_VEC3X3F, COMM_INFO_TYPE_MAT_VEC4X4F, COMM_INFO_TYPE_JSON_STRING_VECTOR, COMM_INFO_TYPE_VEC_NEST_INFO, COMM_INFO_TYPE_MAP_NEST_INFO, COMM_INFO_TYPE_FRAME_GL_TEXTURE, COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT8, COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT8, COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT16, COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT16, COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT32, COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT32, COMM_INFO_TYPE_FRAME_CPU_BUFFER_FP16, COMM_INFO_TYPE_FRAME_CPU_BUFFER_FP32, COMM_INFO_TYPE_FRAME_CVPIXELBUFFER, COMM_INFO_TYPE_FRAME_METAL_TEXTURE, COMM_INFO_TYPE_JSON_PATH, COMM_INFO_TYPE_JSON_STRING};
        }

        static {
            COMM_INFO_TYPE_NONE = new VECommonAlgoInfoType("COMM_INFO_TYPE_NONE", 0);
            COMM_INFO_TYPE_BOOL = new VECommonAlgoInfoType("COMM_INFO_TYPE_BOOL", 1);
            COMM_INFO_TYPE_INT = new VECommonAlgoInfoType("COMM_INFO_TYPE_INT", 2);
            COMM_INFO_TYPE_DOUBLE = new VECommonAlgoInfoType("COMM_INFO_TYPE_DOUBLE", 3);
            COMM_INFO_TYPE_STRING = new VECommonAlgoInfoType("COMM_INFO_TYPE_STRING", 4);
            COMM_INFO_TYPE_COMBINE = new VECommonAlgoInfoType("COMM_INFO_TYPE_COMBINE", 5);
            COMM_INFO_TYPE_VEC2F = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC2F", 6);
            COMM_INFO_TYPE_VEC3F = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC3F", 7);
            COMM_INFO_TYPE_VEC4F = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC4F", 8);
            COMM_INFO_TYPE_VEC4F_QUAT = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC4F_QUAT", 9);
            COMM_INFO_TYPE_VEC4F_COLOR = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC4F_COLOR", 10);
            COMM_INFO_TYPE_VEC4F_RECT = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC4F_RECT", 11);
            COMM_INFO_TYPE_MAT3X3F = new VECommonAlgoInfoType("COMM_INFO_TYPE_MAT3X3F", 12);
            COMM_INFO_TYPE_MAT4X4F = new VECommonAlgoInfoType("COMM_INFO_TYPE_MAT4X4F", 13);
            COMM_INFO_TYPE_VEC_INT8 = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC_INT8", 14);
            COMM_INFO_TYPE_VEC_INT16 = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC_INT16", 15);
            COMM_INFO_TYPE_VEC_INT32 = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC_INT32", 16);
            COMM_INFO_TYPE_VEC_INT64 = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC_INT64", 17);
            COMM_INFO_TYPE_VEC_UINT8 = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC_UINT8", 18);
            COMM_INFO_TYPE_VEC_UINT16 = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC_UINT16", 19);
            COMM_INFO_TYPE_VEC_UINT32 = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC_UINT32", 20);
            COMM_INFO_TYPE_VEC_FLOAT = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC_FLOAT", 21);
            COMM_INFO_TYPE_VEC_DOUBLE = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC_DOUBLE", 22);
            COMM_INFO_TYPE_MAT_VEC2 = new VECommonAlgoInfoType("COMM_INFO_TYPE_MAT_VEC2", 23);
            COMM_INFO_TYPE_MAT_VEC3 = new VECommonAlgoInfoType("COMM_INFO_TYPE_MAT_VEC3", 24);
            COMM_INFO_TYPE_MAT_VEC4 = new VECommonAlgoInfoType("COMM_INFO_TYPE_MAT_VEC4", 25);
            COMM_INFO_TYPE_MAT_VEC4_QUAT = new VECommonAlgoInfoType("COMM_INFO_TYPE_MAT_VEC4_QUAT", 26);
            COMM_INFO_TYPE_MAT_VEC3X3F = new VECommonAlgoInfoType("COMM_INFO_TYPE_MAT_VEC3X3F", 27);
            COMM_INFO_TYPE_MAT_VEC4X4F = new VECommonAlgoInfoType("COMM_INFO_TYPE_MAT_VEC4X4F", 28);
            COMM_INFO_TYPE_JSON_STRING_VECTOR = new VECommonAlgoInfoType("COMM_INFO_TYPE_JSON_STRING_VECTOR", 29);
            COMM_INFO_TYPE_VEC_NEST_INFO = new VECommonAlgoInfoType("COMM_INFO_TYPE_VEC_NEST_INFO", 30);
            COMM_INFO_TYPE_MAP_NEST_INFO = new VECommonAlgoInfoType("COMM_INFO_TYPE_MAP_NEST_INFO", 31);
            COMM_INFO_TYPE_FRAME_GL_TEXTURE = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_GL_TEXTURE", 32);
            COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT8 = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT8", 33);
            COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT8 = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT8", 34);
            COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT16 = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT16", 35);
            COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT16 = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT16", 36);
            COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT32 = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_CPU_BUFFER_INT32", 37);
            COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT32 = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_CPU_BUFFER_UINT32", 38);
            COMM_INFO_TYPE_FRAME_CPU_BUFFER_FP16 = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_CPU_BUFFER_FP16", 39);
            COMM_INFO_TYPE_FRAME_CPU_BUFFER_FP32 = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_CPU_BUFFER_FP32", 40);
            COMM_INFO_TYPE_FRAME_CVPIXELBUFFER = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_CVPIXELBUFFER", 41);
            COMM_INFO_TYPE_FRAME_METAL_TEXTURE = new VECommonAlgoInfoType("COMM_INFO_TYPE_FRAME_METAL_TEXTURE", 42);
            COMM_INFO_TYPE_JSON_PATH = new VECommonAlgoInfoType("COMM_INFO_TYPE_JSON_PATH", 43);
            COMM_INFO_TYPE_JSON_STRING = new VECommonAlgoInfoType("COMM_INFO_TYPE_JSON_STRING", 44);
            $VALUES = $values();
        }

        public static VECommonAlgoInfoType[] values() {
            return (VECommonAlgoInfoType[]) $VALUES.clone();
        }

        public static VECommonAlgoInfoType valueOf(String r100) {
            return (VECommonAlgoInfoType) a.a(VECommonAlgoInfoType.class, r100);
        }

        private VECommonAlgoInfoType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public VECommAlgoInfo() {
        this.infoType = VECommonAlgoInfoType.COMM_INFO_TYPE_NONE.ordinal();
    }
}
