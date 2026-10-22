package com.ss.android.lark.team.entity;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/team/entity/PickEntities$PickType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "CHAT", "DEPT", "Companion", "team-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PickEntities$PickType extends Enum<PickEntities$PickType> {
    public static final PickEntities$PickType CHAT = null;
    public static final a Companion = null;
    public static final PickEntities$PickType DEPT = null;
    public static final PickEntities$PickType UNKNOWN = null;
    public static final PickEntities$PickType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PickEntities$PickType[] f441170a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441171b = null;
    private final int value;

    public static EnumEntries<PickEntities$PickType> getEntries() {
        return f441171b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.team.entity.PickEntities$PickType$a] */
    static {
        PickEntities$PickType r100 = new PickEntities$PickType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        PickEntities$PickType r101 = new PickEntities$PickType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
        USER = r101;
        PickEntities$PickType r102 = new PickEntities$PickType("CHAT", 2, 2);
        CHAT = r102;
        PickEntities$PickType r103 = new PickEntities$PickType("DEPT", 3, 3);
        DEPT = r103;
        PickEntities$PickType[] r104 = {r100, r101, r102, r103};
        f441170a = r104;
        f441171b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static PickEntities$PickType[] values() {
        return (PickEntities$PickType[]) f441170a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PickEntities$PickType valueOf(String r100) {
        return (PickEntities$PickType) r27.a.a(PickEntities$PickType.class, r100);
    }

    public PickEntities$PickType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
