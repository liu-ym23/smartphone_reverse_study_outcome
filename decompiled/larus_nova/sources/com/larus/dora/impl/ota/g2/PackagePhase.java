package com.larus.dora.impl.ota.g2;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/ota/g2/PackagePhase;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "PARTIAL", "READY", "UNCONFIRMED", "ABANDONED", "CLEANING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PackagePhase extends Enum<PackagePhase> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PackagePhase[] $VALUES = null;
    public static final PackagePhase ABANDONED = null;
    public static final PackagePhase CLEANING = null;
    public static final PackagePhase NONE = null;
    public static final PackagePhase PARTIAL = null;
    public static final PackagePhase READY = null;
    public static final PackagePhase UNCONFIRMED = null;

    public static EnumEntries<PackagePhase> getEntries() {
        return $ENTRIES;
    }

    static {
        PackagePhase r100 = new PackagePhase(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        PackagePhase r101 = new PackagePhase("PARTIAL", 1);
        PARTIAL = r101;
        PackagePhase r102 = new PackagePhase("READY", 2);
        READY = r102;
        PackagePhase r103 = new PackagePhase("UNCONFIRMED", 3);
        UNCONFIRMED = r103;
        PackagePhase r104 = new PackagePhase("ABANDONED", 4);
        ABANDONED = r104;
        PackagePhase r105 = new PackagePhase("CLEANING", 5);
        CLEANING = r105;
        PackagePhase[] r110 = {r100, r101, r102, r103, r104, r105};
        $VALUES = r110;
        $ENTRIES = EnumEntriesKt.enumEntries(r110);
    }

    public static PackagePhase[] values() {
        return (PackagePhase[]) $VALUES.clone();
    }

    public static PackagePhase valueOf(String r100) {
        return (PackagePhase) r27.a.a(PackagePhase.class, r100);
    }

    public PackagePhase(String r100, int r101) {
        super(r100, r101);
    }
}
