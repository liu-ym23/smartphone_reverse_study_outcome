package com.ss.android.lark.maintab.export.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/maintab/export/model/EdgeExpandType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "AUTO", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EdgeExpandType extends Enum<EdgeExpandType> {
    public static final EdgeExpandType AUTO = null;
    public static final EdgeExpandType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EdgeExpandType[] f431618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431619b = null;

    public static EnumEntries<EdgeExpandType> getEntries() {
        return f431619b;
    }

    static {
        EdgeExpandType r100 = new EdgeExpandType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        EdgeExpandType r101 = new EdgeExpandType("AUTO", 1);
        AUTO = r101;
        EdgeExpandType[] r102 = {r100, r101};
        f431618a = r102;
        f431619b = EnumEntriesKt.enumEntries(r102);
    }

    public static EdgeExpandType[] values() {
        return (EdgeExpandType[]) f431618a.clone();
    }

    public static EdgeExpandType valueOf(String r100) {
        return (EdgeExpandType) a.a(EdgeExpandType.class, r100);
    }

    public EdgeExpandType(String r100, int r101) {
        super(r100, r101);
    }
}
