package com.bytedance.bdnavigationsdk.navigation;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/bdnavigationsdk/navigation/NavigationTurn$DirectionModifier;", "", "<init>", "(Ljava/lang/String;I)V", "UTurn", "SharpRight", "Right", "SlightRight", "Straight", "SlightLeft", "Left", "SharpLeft", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final enum NavigationTurn$DirectionModifier extends Enum<NavigationTurn$DirectionModifier> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NavigationTurn$DirectionModifier[] $VALUES = null;
    private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;
    public static final NavigationTurn$DirectionModifier Left = null;
    public static final NavigationTurn$DirectionModifier Right = null;
    public static final NavigationTurn$DirectionModifier SharpLeft = null;
    public static final NavigationTurn$DirectionModifier SharpRight = null;
    public static final NavigationTurn$DirectionModifier SlightLeft = null;
    public static final NavigationTurn$DirectionModifier SlightRight = null;
    public static final NavigationTurn$DirectionModifier Straight = null;
    public static final NavigationTurn$DirectionModifier UTurn = null;

    public static EnumEntries<NavigationTurn$DirectionModifier> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.bdnavigationsdk.navigation.NavigationTurn$DirectionModifier$a] */
    static {
        NavigationTurn$DirectionModifier r0 = new NavigationTurn$DirectionModifier("UTurn", 0);
        UTurn = r0;
        NavigationTurn$DirectionModifier r1 = new NavigationTurn$DirectionModifier("SharpRight", 1);
        SharpRight = r1;
        NavigationTurn$DirectionModifier r3 = new NavigationTurn$DirectionModifier("Right", 2);
        Right = r3;
        NavigationTurn$DirectionModifier r5 = new NavigationTurn$DirectionModifier("SlightRight", 3);
        SlightRight = r5;
        NavigationTurn$DirectionModifier r7 = new NavigationTurn$DirectionModifier("Straight", 4);
        Straight = r7;
        NavigationTurn$DirectionModifier r9 = new NavigationTurn$DirectionModifier("SlightLeft", 5);
        SlightLeft = r9;
        NavigationTurn$DirectionModifier r11 = new NavigationTurn$DirectionModifier("Left", 6);
        Left = r11;
        NavigationTurn$DirectionModifier r13 = new NavigationTurn$DirectionModifier("SharpLeft", 7);
        SharpLeft = r13;
        NavigationTurn$DirectionModifier[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        $VALUES = r15;
        $ENTRIES = EnumEntriesKt.enumEntries(r15);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new o());
    }

    public static NavigationTurn$DirectionModifier[] values() {
        return (NavigationTurn$DirectionModifier[]) $VALUES.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static NavigationTurn$DirectionModifier valueOf(String r1) {
        return (NavigationTurn$DirectionModifier) r27.a.a(NavigationTurn$DirectionModifier.class, r1);
    }

    public NavigationTurn$DirectionModifier(String r1, int r2) {
        super(r1, r2);
    }
}
