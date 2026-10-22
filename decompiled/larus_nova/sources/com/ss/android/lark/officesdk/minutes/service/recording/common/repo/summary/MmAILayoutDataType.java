package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmAILayoutDataType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "AI_LAYOUT_FISH_BONE", "AI_LAYOUT_TOPIC", "AI_LAYOUT_SUBTITLE_EFFECT", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAILayoutDataType extends Enum<MmAILayoutDataType> {
    public static final MmAILayoutDataType AI_LAYOUT_FISH_BONE = null;
    public static final MmAILayoutDataType AI_LAYOUT_SUBTITLE_EFFECT = null;
    public static final MmAILayoutDataType AI_LAYOUT_TOPIC = null;
    public static final a Companion = null;
    public static final MmAILayoutDataType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAILayoutDataType[] f435306a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435307b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static MmAILayoutDataType a(int r100) {
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L15;
            if (r100 == 3) goto L14;
            return MmAILayoutDataType.UNKNOWN;
        L14:
            return MmAILayoutDataType.AI_LAYOUT_SUBTITLE_EFFECT;
        L15:
            return MmAILayoutDataType.AI_LAYOUT_TOPIC;
        L12:
            return MmAILayoutDataType.AI_LAYOUT_FISH_BONE;
        }
    }

    @JvmStatic
    public static final MmAILayoutDataType forNumber(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<MmAILayoutDataType> getEntries() {
        return f435307b;
    }

    static {
        MmAILayoutDataType r100 = new MmAILayoutDataType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        MmAILayoutDataType r101 = new MmAILayoutDataType("AI_LAYOUT_FISH_BONE", 1, 1);
        AI_LAYOUT_FISH_BONE = r101;
        MmAILayoutDataType r102 = new MmAILayoutDataType("AI_LAYOUT_TOPIC", 2, 2);
        AI_LAYOUT_TOPIC = r102;
        MmAILayoutDataType r103 = new MmAILayoutDataType("AI_LAYOUT_SUBTITLE_EFFECT", 3, 3);
        AI_LAYOUT_SUBTITLE_EFFECT = r103;
        MmAILayoutDataType[] r104 = {r100, r101, r102, r103};
        f435306a = r104;
        f435307b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static MmAILayoutDataType[] values() {
        return (MmAILayoutDataType[]) f435306a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final MmAILayoutDataType valueOf(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static MmAILayoutDataType valueOf(String r100) {
        return (MmAILayoutDataType) r27.a.a(MmAILayoutDataType.class, r100);
    }

    public MmAILayoutDataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
