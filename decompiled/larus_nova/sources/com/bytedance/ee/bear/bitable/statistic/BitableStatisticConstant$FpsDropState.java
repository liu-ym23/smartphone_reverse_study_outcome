package com.bytedance.ee.bear.bitable.statistic;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticConstant$FpsDropState;", "", "title", "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getMax", "()I", UserProfileEvent.POSITION_NONE, "LITTLE", EffectConstants.NORMAL, "MIDDLE", "SERIOUS", "BAD", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableStatisticConstant$FpsDropState extends Enum<BitableStatisticConstant$FpsDropState> {
    public static final BitableStatisticConstant$FpsDropState BAD = null;
    public static final a Companion = null;
    public static final BitableStatisticConstant$FpsDropState LITTLE = null;
    public static final BitableStatisticConstant$FpsDropState MIDDLE = null;
    public static final BitableStatisticConstant$FpsDropState NONE = null;
    public static final BitableStatisticConstant$FpsDropState NORMAL = null;
    public static final BitableStatisticConstant$FpsDropState SERIOUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableStatisticConstant$FpsDropState[] f215590a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215591b = null;
    private final int max;
    private final String title;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static BitableStatisticConstant$FpsDropState a(int r100) {
            BitableStatisticConstant$FpsDropState r101 = BitableStatisticConstant$FpsDropState.NONE;
            if (r100 > r101.getMax()) goto L5;
            return r101;
        L5:
            BitableStatisticConstant$FpsDropState r102 = BitableStatisticConstant$FpsDropState.LITTLE;
            if (r100 > r102.getMax()) goto L8;
            return r102;
        L8:
            BitableStatisticConstant$FpsDropState r103 = BitableStatisticConstant$FpsDropState.NORMAL;
            if (r100 > r103.getMax()) goto L11;
            return r103;
        L11:
            BitableStatisticConstant$FpsDropState r104 = BitableStatisticConstant$FpsDropState.MIDDLE;
            if (r100 > r104.getMax()) goto L14;
            return r104;
        L14:
            BitableStatisticConstant$FpsDropState r105 = BitableStatisticConstant$FpsDropState.SERIOUS;
            if (r100 > r105.getMax()) goto L18;
            return r105;
        L18:
            return BitableStatisticConstant$FpsDropState.BAD;
        }
    }

    @JvmStatic
    public static final BitableStatisticConstant$FpsDropState cal(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<BitableStatisticConstant$FpsDropState> getEntries() {
        return f215591b;
    }

    static {
        BitableStatisticConstant$FpsDropState r100 = new BitableStatisticConstant$FpsDropState(UserProfileEvent.POSITION_NONE, 0, "none", 0);
        NONE = r100;
        BitableStatisticConstant$FpsDropState r101 = new BitableStatisticConstant$FpsDropState("LITTLE", 1, "little", 2);
        LITTLE = r101;
        BitableStatisticConstant$FpsDropState r102 = new BitableStatisticConstant$FpsDropState(EffectConstants.NORMAL, 2, "normal", 6);
        NORMAL = r102;
        BitableStatisticConstant$FpsDropState r103 = new BitableStatisticConstant$FpsDropState("MIDDLE", 3, "middle", 13);
        MIDDLE = r103;
        BitableStatisticConstant$FpsDropState r104 = new BitableStatisticConstant$FpsDropState("SERIOUS", 4, "serious", 25);
        SERIOUS = r104;
        BitableStatisticConstant$FpsDropState r110 = new BitableStatisticConstant$FpsDropState("BAD", 5, SRStrategy.KEY_BITRATE_AFTER_DOWNGRADE, Integer.MAX_VALUE);
        BAD = r110;
        BitableStatisticConstant$FpsDropState[] r105 = {r100, r101, r102, r103, r104, r110};
        f215590a = r105;
        f215591b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static BitableStatisticConstant$FpsDropState[] values() {
        return (BitableStatisticConstant$FpsDropState[]) f215590a.clone();
    }

    public final int getMax() {
        return this.max;
    }

    public final String getTitle() {
        return this.title;
    }

    public static BitableStatisticConstant$FpsDropState valueOf(String r100) {
        return (BitableStatisticConstant$FpsDropState) r27.a.a(BitableStatisticConstant$FpsDropState.class, r100);
    }

    public BitableStatisticConstant$FpsDropState(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.title = r102;
        this.max = r103;
    }
}
