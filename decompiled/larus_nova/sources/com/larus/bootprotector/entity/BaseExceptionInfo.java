package com.larus.bootprotector.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0016\u0018\u00002\u00020\u0001:\u0001 B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/bootprotector/entity/BaseExceptionInfo;", "", "type", "Lcom/larus/bootprotector/entity/BaseExceptionInfo$Type;", "appVersion", "", "updateVersion", "", "osVersion", "processName", "threadName", "<init>", "(Lcom/larus/bootprotector/entity/BaseExceptionInfo$Type;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "crashType", "getCrashType", "()Lcom/larus/bootprotector/entity/BaseExceptionInfo$Type;", "setCrashType", "(Lcom/larus/bootprotector/entity/BaseExceptionInfo$Type;)V", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "getUpdateVersion", "()I", "setUpdateVersion", "(I)V", "getOsVersion", "setOsVersion", "getProcessName", "setProcessName", "getThreadName", "setThreadName", "Type", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseExceptionInfo {
    private String appVersion;
    private Type crashType;
    private int osVersion;
    private String processName;
    private String threadName;
    private int updateVersion;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/larus/bootprotector/entity/BaseExceptionInfo$Type;", "", "name", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "JAVA", "NATIVE", "ANR", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type ANR = null;
        public static final Type JAVA = null;
        public static final Type NATIVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f317631a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f317632b = null;

        public static EnumEntries<Type> getEntries() {
            return f317632b;
        }

        static {
            Type r100 = new Type("JAVA", 0);
            JAVA = r100;
            Type r101 = new Type("NATIVE", 1);
            NATIVE = r101;
            Type r102 = new Type("ANR", 2);
            ANR = r102;
            Type[] r103 = {r100, r101, r102};
            f317631a = r103;
            f317632b = EnumEntriesKt.enumEntries(r103);
        }

        public static Type[] values() {
            return (Type[]) f317631a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return name();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final Type getCrashType() {
        return this.crashType;
    }

    public final int getOsVersion() {
        return this.osVersion;
    }

    public final String getProcessName() {
        return this.processName;
    }

    public final String getThreadName() {
        return this.threadName;
    }

    public final int getUpdateVersion() {
        return this.updateVersion;
    }

    public final void setAppVersion(String r100) {
        this.appVersion = r100;
    }

    public final void setCrashType(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.crashType = r100;
    }

    public final void setOsVersion(int r100) {
        this.osVersion = r100;
    }

    public final void setProcessName(String r100) {
        this.processName = r100;
    }

    public final void setThreadName(String r100) {
        this.threadName = r100;
    }

    public final void setUpdateVersion(int r100) {
        this.updateVersion = r100;
    }

    public BaseExceptionInfo(Type r100, String r101, int r102, int r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Type r106 = Type.JAVA;
        this.crashType = r100;
        this.appVersion = r101;
        this.updateVersion = r102;
        this.osVersion = r103;
        this.processName = r104;
        this.threadName = r105;
    }
}
