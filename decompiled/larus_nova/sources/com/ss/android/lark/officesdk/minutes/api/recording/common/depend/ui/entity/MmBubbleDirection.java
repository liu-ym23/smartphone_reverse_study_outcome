package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmBubbleDirection;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "TOP", "RIGHT", "BOTTOM", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmBubbleDirection extends Enum<MmBubbleDirection> {
    public static final MmBubbleDirection BOTTOM = null;
    public static final MmBubbleDirection LEFT = null;
    public static final MmBubbleDirection RIGHT = null;
    public static final MmBubbleDirection TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmBubbleDirection[] f433555a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433556b = null;

    public static EnumEntries<MmBubbleDirection> getEntries() {
        return f433556b;
    }

    static {
        MmBubbleDirection r100 = new MmBubbleDirection("LEFT", 0);
        LEFT = r100;
        MmBubbleDirection r101 = new MmBubbleDirection("TOP", 1);
        TOP = r101;
        MmBubbleDirection r102 = new MmBubbleDirection("RIGHT", 2);
        RIGHT = r102;
        MmBubbleDirection r103 = new MmBubbleDirection("BOTTOM", 3);
        BOTTOM = r103;
        MmBubbleDirection[] r104 = {r100, r101, r102, r103};
        f433555a = r104;
        f433556b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmBubbleDirection[] values() {
        return (MmBubbleDirection[]) f433555a.clone();
    }

    public static MmBubbleDirection valueOf(String r100) {
        return (MmBubbleDirection) a.a(MmBubbleDirection.class, r100);
    }

    public MmBubbleDirection(String r100, int r101) {
        super(r100, r101);
    }
}
