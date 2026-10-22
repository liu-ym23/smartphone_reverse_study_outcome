package com.ss.android.lark.biz.im.api.chat.setting;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/im/api/chat/setting/ContainerHeightType;", "", "<init>", "(Ljava/lang/String;I)V", "FIXED_HEIGHT", "WRAP_HEIGHT", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContainerHeightType extends Enum<ContainerHeightType> {
    public static final ContainerHeightType FIXED_HEIGHT = null;
    public static final ContainerHeightType WRAP_HEIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerHeightType[] f410067a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410068b = null;

    public static EnumEntries<ContainerHeightType> getEntries() {
        return f410068b;
    }

    static {
        ContainerHeightType r100 = new ContainerHeightType("FIXED_HEIGHT", 0);
        FIXED_HEIGHT = r100;
        ContainerHeightType r101 = new ContainerHeightType("WRAP_HEIGHT", 1);
        WRAP_HEIGHT = r101;
        ContainerHeightType[] r102 = {r100, r101};
        f410067a = r102;
        f410068b = EnumEntriesKt.enumEntries(r102);
    }

    public static ContainerHeightType[] values() {
        return (ContainerHeightType[]) f410067a.clone();
    }

    public static ContainerHeightType valueOf(String r100) {
        return (ContainerHeightType) a.a(ContainerHeightType.class, r100);
    }

    public ContainerHeightType(String r100, int r101) {
        super(r100, r101);
    }
}
