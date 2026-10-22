package com.bytedance.mt.protector;

import com.google.gson.JsonElement;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class ThrowableDisposer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThrowableDisposer f265662b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f265663a;

    /* JADX INFO: loaded from: classes21.dex */
    public static final enum DataType extends Enum<DataType> {
        public static final DataType BOOLEAN_RESULT_TYPE = null;
        public static final DataType BYTE_RESULT_TYPE = null;
        public static final DataType DOUBLE_RESULT_TYPE = null;
        public static final DataType FLOAT_RESULT_TYPE = null;
        public static final DataType INT_RESULT_TYPE = null;
        public static final DataType JSON_ELEMENT_RESULT_TYPE = null;
        public static final DataType LONG_RESULT_TYPE = null;
        public static final DataType NULL_RESULT_TYPE = null;
        public static final DataType SHORT_RESULT_TYPE = null;
        public static final DataType STRING_RESULT_TYPE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataType[] f265664a = null;
        private String text;
        private int type;

        static {
            DataType r100 = new DataType("NULL_RESULT_TYPE", 0, "null", 0);
            NULL_RESULT_TYPE = r100;
            DataType r101 = new DataType("STRING_RESULT_TYPE", 1, "string", 1);
            STRING_RESULT_TYPE = r101;
            DataType r102 = new DataType("INT_RESULT_TYPE", 2, "int", 2);
            INT_RESULT_TYPE = r102;
            DataType r103 = new DataType("LONG_RESULT_TYPE", 3, "long", 3);
            LONG_RESULT_TYPE = r103;
            DataType r104 = new DataType("FLOAT_RESULT_TYPE", 4, "float", 4);
            FLOAT_RESULT_TYPE = r104;
            DataType r105 = new DataType("JSON_ELEMENT_RESULT_TYPE", 5, "jsonElement", 5);
            JSON_ELEMENT_RESULT_TYPE = r105;
            DataType r110 = new DataType("BOOLEAN_RESULT_TYPE", 6, "boolean", 6);
            BOOLEAN_RESULT_TYPE = r110;
            DataType r111 = new DataType("BYTE_RESULT_TYPE", 7, "byte", 7);
            BYTE_RESULT_TYPE = r111;
            DataType r112 = new DataType("SHORT_RESULT_TYPE", 8, "short", 8);
            SHORT_RESULT_TYPE = r112;
            DataType r113 = new DataType("DOUBLE_RESULT_TYPE", 9, ItemStyle.ITEM_STYLE_DOUBLE, 9);
            DOUBLE_RESULT_TYPE = r113;
            f265664a = new DataType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public static DataType[] values() {
            return (DataType[]) f265664a.clone();
        }

        public static int getType(String r100) {
            DataType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            DataType r104 = r101[r103];
            if (r100.equals(r104.text) == true) goto L7;
            r103 = r103 + 1;
            goto L3
        L7:
            return r104.type;
        L9:
            return 0;
        }

        public static DataType valueOf(String r100) {
            return (DataType) r27.a.a(DataType.class, r100);
        }

        public DataType(String r100, int r101, String r102, int r103) {
            super(r100, r101);
            this.text = r102;
            this.type = r103;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String[] f265665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f265666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f265667c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JsonElement f265668d;

        public a() {
        }

        public final String toString() {
            return "ConfItem{stackFeatures=" + Arrays.toString(this.f265665a) + ", protectorType='" + this.f265666b + "', returnType='" + this.f265667c + "', returnValue='" + this.f265668d + "'}";
        }
    }

    static {
        f265662b = new ThrowableDisposer();
    }

    public ThrowableDisposer() {
        this.f265663a = new CopyOnWriteArrayList();
    }

    public final f a(ProtectorType r110, Throwable r111) {
        if (r110 == null) goto L71;
        if (r111 == null) goto L71;
        if (((CopyOnWriteArrayList) this.f265663a).size() == 0) goto L71;
        Iterator r100 = ((CopyOnWriteArrayList) this.f265663a).iterator();
    L10:
        if (r100.hasNext() == false) goto L71;
        a r101 = (a) r100.next();
        r101.getClass();
        boolean r102 = false;
        if (r110.getName().equals(r101.f265666b) == false) goto L28;
        StackTraceElement[] r103 = r111.getStackTrace();
        int r104 = -1;
        int r105 = 0;
    L16:
        if (r104 >= r103.length) goto L26;
        if (r105 >= r101.f265665a.length) goto L26;
        if (r104 != (-1)) goto L21;
        String r106 = r111.toString().trim();
    L22:
        r104 = r104 + 1;
        if (r106.contains(r101.f265665a[r105].trim()) == false) goto L16;
        r105 = r105 + 1;
        goto L16
    L21:
        r106 = r103[r104].toString().trim();
    L26:
        if (r105 != r101.f265665a.length) goto L28;
        r102 = true;
    L28:
        if (r102 == false) goto L10;
        if (r101.f265668d == null) goto L10;
        if ("string".equals(r101.f265667c) == true) goto L33;
        if ("byte".equals(r101.f265667c) == true) goto L37;
        if ("short".equals(r101.f265667c) == true) goto L41;
        if ("int".equals(r101.f265667c) == true) goto L45;
        if ("long".equals(r101.f265667c) == true) goto L49;
        if ("float".equals(r101.f265667c) == true) goto L53;
        if (ItemStyle.ITEM_STYLE_DOUBLE.equals(r101.f265667c) == true) goto L57;
        if ("boolean".equals(r101.f265667c) == true) goto L61;
        if ("jsonElement".equals(r101.f265667c) == true) goto L65;
        if ("null".equals(r101.f265667c) == false) goto L10;
        DataType.getType(r101.f265667c);
        return new f(null);
    L65:
        DataType.getType(r101.f265667c);
        return new f(r101.f265668d);
    L61:
        DataType.getType(r101.f265667c);
        return new f(Boolean.valueOf(r101.f265668d.getAsBoolean()));
    L57:
        DataType.getType(r101.f265667c);
        return new f(Double.valueOf(r101.f265668d.getAsDouble()));
    L53:
        DataType.getType(r101.f265667c);
        return new f(Float.valueOf(r101.f265668d.getAsFloat()));
    L49:
        DataType.getType(r101.f265667c);
        return new f(Long.valueOf(r101.f265668d.getAsLong()));
    L45:
        DataType.getType(r101.f265667c);
        return new f(Integer.valueOf(r101.f265668d.getAsInt()));
    L41:
        DataType.getType(r101.f265667c);
        return new f(Short.valueOf(r101.f265668d.getAsShort()));
    L37:
        DataType.getType(r101.f265667c);
        return new f(Byte.valueOf(r101.f265668d.getAsByte()));
    L33:
        DataType.getType(r101.f265667c);
        return new f(r101.f265668d.getAsString());
    L71:
        return null;
    }
}
