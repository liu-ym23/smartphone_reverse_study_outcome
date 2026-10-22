package com.ss.android.lark.biz.im.api.extension.message.system;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/message/system/SystemMessageActionType;", "", "<init>", "(Ljava/lang/String;I)V", "CONTENT_ACTION", "EXTRA_ACTION", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SystemMessageActionType extends Enum<SystemMessageActionType> {
    public static final SystemMessageActionType CONTENT_ACTION = null;
    public static final SystemMessageActionType EXTRA_ACTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SystemMessageActionType[] f410210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410211b = null;

    public static EnumEntries<SystemMessageActionType> getEntries() {
        return f410211b;
    }

    static {
        SystemMessageActionType r100 = new SystemMessageActionType("CONTENT_ACTION", 0);
        CONTENT_ACTION = r100;
        SystemMessageActionType r101 = new SystemMessageActionType("EXTRA_ACTION", 1);
        EXTRA_ACTION = r101;
        SystemMessageActionType[] r102 = {r100, r101};
        f410210a = r102;
        f410211b = EnumEntriesKt.enumEntries(r102);
    }

    public static SystemMessageActionType[] values() {
        return (SystemMessageActionType[]) f410210a.clone();
    }

    public static SystemMessageActionType valueOf(String r100) {
        return (SystemMessageActionType) r27.a.a(SystemMessageActionType.class, r100);
    }

    public SystemMessageActionType(String r100, int r101) {
        super(r100, r101);
    }
}
