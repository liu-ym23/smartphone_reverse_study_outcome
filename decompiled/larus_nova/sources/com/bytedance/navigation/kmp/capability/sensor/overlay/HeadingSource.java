package com.bytedance.navigation.kmp.capability.sensor.overlay;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/navigation/kmp/capability/sensor/overlay/HeadingSource;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ROTV_BOOTSTRAP", "ESKF", "ROTV_DEGRADED", "label", "", "bdnavigation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum HeadingSource extends Enum<HeadingSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ HeadingSource[] $VALUES = null;
    public static final HeadingSource ESKF = null;
    public static final HeadingSource IDLE = null;
    public static final HeadingSource ROTV_BOOTSTRAP = null;
    public static final HeadingSource ROTV_DEGRADED = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f265827a = null;

        static {
            int[] r100 = new int[HeadingSource.values().length];
            r100[HeadingSource.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[HeadingSource.ROTV_BOOTSTRAP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[HeadingSource.ESKF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[HeadingSource.ROTV_DEGRADED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f265827a = r100;
        }
    }

    public static EnumEntries<HeadingSource> getEntries() {
        return $ENTRIES;
    }

    static {
        HeadingSource r100 = new HeadingSource("IDLE", 0);
        IDLE = r100;
        HeadingSource r101 = new HeadingSource("ROTV_BOOTSTRAP", 1);
        ROTV_BOOTSTRAP = r101;
        HeadingSource r102 = new HeadingSource("ESKF", 2);
        ESKF = r102;
        HeadingSource r103 = new HeadingSource("ROTV_DEGRADED", 3);
        ROTV_DEGRADED = r103;
        HeadingSource[] r104 = {r100, r101, r102, r103};
        $VALUES = r104;
        $ENTRIES = EnumEntriesKt.enumEntries(r104);
    }

    public static HeadingSource[] values() {
        return (HeadingSource[]) $VALUES.clone();
    }

    public final String label() {
        int r100 = a.f265827a[ordinal()];
        if (r100 != 1) goto L5;
        return "朝向: --";
    L5:
        if (r100 != 2) goto L7;
        return "朝向: RotV(引导)";
    L7:
        if (r100 != 3) goto L9;
        return "朝向: ESKF";
    L9:
        if (r100 != 4) goto L12;
        return "朝向: RotV(降级)";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static HeadingSource valueOf(String r100) {
        return (HeadingSource) r27.a.a(HeadingSource.class, r100);
    }

    public HeadingSource(String r100, int r101) {
        super(r100, r101);
    }
}
