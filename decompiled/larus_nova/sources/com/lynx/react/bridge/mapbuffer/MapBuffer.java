package com.lynx.react.bridge.mapbuffer;

/* JADX INFO: loaded from: classes32.dex */
public interface MapBuffer extends Iterable<a> {

    public static final enum DataType extends Enum<DataType> {
        public static final DataType ARRAY = null;
        public static final DataType BOOL = null;
        public static final DataType DOUBLE = null;
        public static final DataType INT = null;
        public static final DataType LONG = null;
        public static final DataType NULL = null;
        public static final DataType STRING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataType[] f381448a = null;

        static {
            DataType r100 = new DataType("NULL", 0);
            NULL = r100;
            DataType r101 = new DataType("BOOL", 1);
            BOOL = r101;
            DataType r102 = new DataType("INT", 2);
            INT = r102;
            DataType r103 = new DataType("LONG", 3);
            LONG = r103;
            DataType r104 = new DataType("DOUBLE", 4);
            DOUBLE = r104;
            DataType r105 = new DataType("STRING", 5);
            STRING = r105;
            DataType r110 = new DataType("ARRAY", 6);
            ARRAY = r110;
            f381448a = new DataType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static DataType[] values() {
            return (DataType[]) f381448a.clone();
        }

        public static DataType valueOf(String r100) {
            return (DataType) r27.a.a(DataType.class, r100);
        }

        public DataType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a extends com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a {
        @Override // com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a
        double b();

        @Override // com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a
        long c();

        boolean e();

        ReadableMapBuffer f();

        int getKey();

        DataType getType();
    }

    ReadableMapBuffer b(int r100);

    boolean contains(int r100);

    int count();

    boolean getBoolean(int r100);

    double getDouble(int r100);

    int getInt(int r100);

    long getLong(int r100);

    String getString(int r100);

    DataType getType(int r100);
}
