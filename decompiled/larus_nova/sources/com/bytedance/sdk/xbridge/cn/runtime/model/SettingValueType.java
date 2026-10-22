package com.bytedance.sdk.xbridge.cn.runtime.model;

import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/model/SettingValueType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "STRING", "BOOL", "NUMBER", "OBJECT", "ARRAY", "INT32", "LONG", "FLOAT", "DOUBLE", "UNSUPPORTED", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SettingValueType extends Enum<SettingValueType> {
    public static final SettingValueType ARRAY = null;
    public static final SettingValueType BOOL = null;
    public static final a Companion = null;
    public static final SettingValueType DOUBLE = null;
    public static final SettingValueType FLOAT = null;
    public static final SettingValueType INT32 = null;
    public static final SettingValueType LONG = null;
    public static final SettingValueType NUMBER = null;
    public static final SettingValueType OBJECT = null;
    public static final SettingValueType STRING = null;
    public static final SettingValueType UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SettingValueType[] f270139a = null;
    private final String type;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static SettingValueType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return SettingValueType.valueOf(r100.toUpperCase(Locale.getDefault()));
        L6:
            return SettingValueType.UNSUPPORTED;
        }
    }

    @JvmStatic
    public static final SettingValueType getValueByType(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static SettingValueType valueOf(String r100) {
        return (SettingValueType) r27.a.a(SettingValueType.class, r100);
    }

    public static SettingValueType[] values() {
        return (SettingValueType[]) f270139a.clone();
    }

    static {
        SettingValueType r100 = new SettingValueType("STRING", 0, "string");
        STRING = r100;
        SettingValueType r101 = new SettingValueType("BOOL", 1, "bool");
        BOOL = r101;
        SettingValueType r102 = new SettingValueType("NUMBER", 2, "number");
        NUMBER = r102;
        SettingValueType r103 = new SettingValueType("OBJECT", 3, "object");
        OBJECT = r103;
        SettingValueType r104 = new SettingValueType("ARRAY", 4, "array");
        ARRAY = r104;
        SettingValueType r105 = new SettingValueType("INT32", 5, "int32");
        INT32 = r105;
        SettingValueType r110 = new SettingValueType("LONG", 6, "long");
        LONG = r110;
        SettingValueType r111 = new SettingValueType("FLOAT", 7, "float");
        FLOAT = r111;
        SettingValueType r112 = new SettingValueType("DOUBLE", 8, ItemStyle.ITEM_STYLE_DOUBLE);
        DOUBLE = r112;
        SettingValueType r113 = new SettingValueType("UNSUPPORTED", 9, null, 1, null);
        UNSUPPORTED = r113;
        f270139a = new SettingValueType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        Companion = new a();
    }

    public final String getType() {
        return this.type;
    }

    public SettingValueType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }

    public /* synthetic */ SettingValueType(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
