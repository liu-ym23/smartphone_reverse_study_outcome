package com.ss.android.lark.scs.policy.engine.manage.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/scs/policy/engine/manage/model/DeviceTerminalType;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "UNKNOWN", "PC", "WEB", "ANDROID", "IOS", "policy-engine-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DeviceTerminalType extends Enum<DeviceTerminalType> {
    public static final DeviceTerminalType ANDROID = null;
    public static final DeviceTerminalType IOS = null;
    public static final DeviceTerminalType PC = null;
    public static final DeviceTerminalType UNKNOWN = null;
    public static final DeviceTerminalType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceTerminalType[] f439859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f439860b = null;
    private final int code;

    public static EnumEntries<DeviceTerminalType> getEntries() {
        return f439860b;
    }

    static {
        DeviceTerminalType r100 = new DeviceTerminalType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        DeviceTerminalType r101 = new DeviceTerminalType("PC", 1, 1);
        PC = r101;
        DeviceTerminalType r102 = new DeviceTerminalType("WEB", 2, 2);
        WEB = r102;
        DeviceTerminalType r103 = new DeviceTerminalType("ANDROID", 3, 3);
        ANDROID = r103;
        DeviceTerminalType r104 = new DeviceTerminalType("IOS", 4, 4);
        IOS = r104;
        DeviceTerminalType[] r105 = {r100, r101, r102, r103, r104};
        f439859a = r105;
        f439860b = EnumEntriesKt.enumEntries(r105);
    }

    public static DeviceTerminalType[] values() {
        return (DeviceTerminalType[]) f439859a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static DeviceTerminalType valueOf(String r100) {
        return (DeviceTerminalType) a.a(DeviceTerminalType.class, r100);
    }

    public DeviceTerminalType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
