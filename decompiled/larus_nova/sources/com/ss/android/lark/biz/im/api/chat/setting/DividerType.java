package com.ss.android.lark.biz.im.api.chat.setting;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/biz/im/api/chat/setting/DividerType;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "FULL_WIDTH", "MARGIN_START", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DividerType extends Enum<DividerType> {
    public static final DividerType FULL_WIDTH = null;
    public static final DividerType HIDDEN = null;
    public static final DividerType MARGIN_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DividerType[] f410069a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410070b = null;

    public static EnumEntries<DividerType> getEntries() {
        return f410070b;
    }

    static {
        DividerType r100 = new DividerType("HIDDEN", 0);
        HIDDEN = r100;
        DividerType r101 = new DividerType("FULL_WIDTH", 1);
        FULL_WIDTH = r101;
        DividerType r102 = new DividerType("MARGIN_START", 2);
        MARGIN_START = r102;
        DividerType[] r103 = {r100, r101, r102};
        f410069a = r103;
        f410070b = EnumEntriesKt.enumEntries(r103);
    }

    public static DividerType[] values() {
        return (DividerType[]) f410069a.clone();
    }

    public static DividerType valueOf(String r100) {
        return (DividerType) a.a(DividerType.class, r100);
    }

    public DividerType(String r100, int r101) {
        super(r100, r101);
    }
}
