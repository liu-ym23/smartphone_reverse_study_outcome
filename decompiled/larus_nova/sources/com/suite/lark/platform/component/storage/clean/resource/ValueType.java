package com.suite.lark.platform.component.storage.clean.resource;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/resource/ValueType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "INT", "LONG", "BOOLEAN", "STRING_SET", "FLOAT", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ValueType extends Enum<ValueType> {
    public static final ValueType BOOLEAN = null;
    public static final ValueType FLOAT = null;
    public static final ValueType INT = null;
    public static final ValueType LONG = null;
    public static final ValueType STRING = null;
    public static final ValueType STRING_SET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ValueType[] f460621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f460622b = null;

    public static EnumEntries<ValueType> getEntries() {
        return f460622b;
    }

    static {
        ValueType r100 = new ValueType("STRING", 0);
        STRING = r100;
        ValueType r101 = new ValueType("INT", 1);
        INT = r101;
        ValueType r102 = new ValueType("LONG", 2);
        LONG = r102;
        ValueType r103 = new ValueType("BOOLEAN", 3);
        BOOLEAN = r103;
        ValueType r104 = new ValueType("STRING_SET", 4);
        STRING_SET = r104;
        ValueType r105 = new ValueType("FLOAT", 5);
        FLOAT = r105;
        ValueType[] r110 = {r100, r101, r102, r103, r104, r105};
        f460621a = r110;
        f460622b = EnumEntriesKt.enumEntries(r110);
    }

    public static ValueType[] values() {
        return (ValueType[]) f460621a.clone();
    }

    public static ValueType valueOf(String r100) {
        return (ValueType) a.a(ValueType.class, r100);
    }

    public ValueType(String r100, int r101) {
        super(r100, r101);
    }
}
