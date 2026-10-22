package com.ss.android.lark.biz.officesdk.im.file;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/file/OpenFeishuFileSecurityBlockReason;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "NO_PERMISSION", "DLP_DETECTING", "DLP_SENSITIVE", "FILE_STRATEGY", "RISK_FILE", "RESOURCE_CLEANED", "ERROR", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenFeishuFileSecurityBlockReason extends Enum<OpenFeishuFileSecurityBlockReason> {
    public static final OpenFeishuFileSecurityBlockReason DLP_DETECTING = null;
    public static final OpenFeishuFileSecurityBlockReason DLP_SENSITIVE = null;
    public static final OpenFeishuFileSecurityBlockReason ERROR = null;
    public static final OpenFeishuFileSecurityBlockReason FILE_STRATEGY = null;
    public static final OpenFeishuFileSecurityBlockReason NO_PERMISSION = null;
    public static final OpenFeishuFileSecurityBlockReason RESOURCE_CLEANED = null;
    public static final OpenFeishuFileSecurityBlockReason RISK_FILE = null;
    public static final OpenFeishuFileSecurityBlockReason UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenFeishuFileSecurityBlockReason[] f410591a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410592b = null;

    public static EnumEntries<OpenFeishuFileSecurityBlockReason> getEntries() {
        return f410592b;
    }

    static {
        OpenFeishuFileSecurityBlockReason r100 = new OpenFeishuFileSecurityBlockReason("UNKNOWN", 0);
        UNKNOWN = r100;
        OpenFeishuFileSecurityBlockReason r101 = new OpenFeishuFileSecurityBlockReason("NO_PERMISSION", 1);
        NO_PERMISSION = r101;
        OpenFeishuFileSecurityBlockReason r102 = new OpenFeishuFileSecurityBlockReason("DLP_DETECTING", 2);
        DLP_DETECTING = r102;
        OpenFeishuFileSecurityBlockReason r103 = new OpenFeishuFileSecurityBlockReason("DLP_SENSITIVE", 3);
        DLP_SENSITIVE = r103;
        OpenFeishuFileSecurityBlockReason r104 = new OpenFeishuFileSecurityBlockReason("FILE_STRATEGY", 4);
        FILE_STRATEGY = r104;
        OpenFeishuFileSecurityBlockReason r105 = new OpenFeishuFileSecurityBlockReason("RISK_FILE", 5);
        RISK_FILE = r105;
        OpenFeishuFileSecurityBlockReason r110 = new OpenFeishuFileSecurityBlockReason("RESOURCE_CLEANED", 6);
        RESOURCE_CLEANED = r110;
        OpenFeishuFileSecurityBlockReason r111 = new OpenFeishuFileSecurityBlockReason("ERROR", 7);
        ERROR = r111;
        OpenFeishuFileSecurityBlockReason[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f410591a = r112;
        f410592b = EnumEntriesKt.enumEntries(r112);
    }

    public static OpenFeishuFileSecurityBlockReason[] values() {
        return (OpenFeishuFileSecurityBlockReason[]) f410591a.clone();
    }

    public static OpenFeishuFileSecurityBlockReason valueOf(String r100) {
        return (OpenFeishuFileSecurityBlockReason) a.a(OpenFeishuFileSecurityBlockReason.class, r100);
    }

    public OpenFeishuFileSecurityBlockReason(String r100, int r101) {
        super(r100, r101);
    }
}
