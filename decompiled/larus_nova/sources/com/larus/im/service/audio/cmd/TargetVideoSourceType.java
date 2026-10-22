package com.larus.im.service.audio.cmd;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/service/audio/cmd/TargetVideoSourceType;", "", "<init>", "(Ljava/lang/String;I)V", "VIDEO_SOURCE_DEFAULT", "VIDEO_SOURCE_CAMERA", "VIDEO_SOURCE_SCREEN", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TargetVideoSourceType extends Enum<TargetVideoSourceType> {
    public static final TargetVideoSourceType VIDEO_SOURCE_CAMERA = null;
    public static final TargetVideoSourceType VIDEO_SOURCE_DEFAULT = null;
    public static final TargetVideoSourceType VIDEO_SOURCE_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TargetVideoSourceType[] f350725a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350726b = null;

    public static EnumEntries<TargetVideoSourceType> getEntries() {
        return f350726b;
    }

    static {
        TargetVideoSourceType r100 = new TargetVideoSourceType("VIDEO_SOURCE_DEFAULT", 0);
        VIDEO_SOURCE_DEFAULT = r100;
        TargetVideoSourceType r101 = new TargetVideoSourceType("VIDEO_SOURCE_CAMERA", 1);
        VIDEO_SOURCE_CAMERA = r101;
        TargetVideoSourceType r102 = new TargetVideoSourceType("VIDEO_SOURCE_SCREEN", 2);
        VIDEO_SOURCE_SCREEN = r102;
        TargetVideoSourceType[] r103 = {r100, r101, r102};
        f350725a = r103;
        f350726b = EnumEntriesKt.enumEntries(r103);
    }

    public static TargetVideoSourceType[] values() {
        return (TargetVideoSourceType[]) f350725a.clone();
    }

    public static TargetVideoSourceType valueOf(String r100) {
        return (TargetVideoSourceType) a.a(TargetVideoSourceType.class, r100);
    }

    public TargetVideoSourceType(String r100, int r101) {
        super(r100, r101);
    }
}
