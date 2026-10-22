package com.ss.android.lark.scs.policy.engine.manage.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/scs/policy/engine/manage/model/DeviceOSType;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "UNKNOWN", "WINDOWS", "LINUX", "MAC", "ANDROID", "IOS", "policy-engine-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DeviceOSType extends Enum<DeviceOSType> {
    public static final DeviceOSType ANDROID = null;
    public static final DeviceOSType IOS = null;
    public static final DeviceOSType LINUX = null;
    public static final DeviceOSType MAC = null;
    public static final DeviceOSType UNKNOWN = null;
    public static final DeviceOSType WINDOWS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceOSType[] f439857a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f439858b = null;
    private final int code;

    public static EnumEntries<DeviceOSType> getEntries() {
        return f439858b;
    }

    static {
        DeviceOSType r100 = new DeviceOSType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        DeviceOSType r101 = new DeviceOSType("WINDOWS", 1, 1);
        WINDOWS = r101;
        DeviceOSType r102 = new DeviceOSType("LINUX", 2, 2);
        LINUX = r102;
        DeviceOSType r103 = new DeviceOSType("MAC", 3, 3);
        MAC = r103;
        DeviceOSType r104 = new DeviceOSType("ANDROID", 4, 4);
        ANDROID = r104;
        DeviceOSType r105 = new DeviceOSType("IOS", 5, 5);
        IOS = r105;
        DeviceOSType[] r110 = {r100, r101, r102, r103, r104, r105};
        f439857a = r110;
        f439858b = EnumEntriesKt.enumEntries(r110);
    }

    public static DeviceOSType[] values() {
        return (DeviceOSType[]) f439857a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static DeviceOSType valueOf(String r100) {
        return (DeviceOSType) a.a(DeviceOSType.class, r100);
    }

    public DeviceOSType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
