package com.larus.dora.impl.device.settings.gesture;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/LastSwitchSide;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LEFT", "BUTTON", "RIGHT", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LastSwitchSide extends Enum<LastSwitchSide> {
    public static final LastSwitchSide BUTTON = null;
    public static final a Companion = null;
    public static final LastSwitchSide LEFT = null;
    public static final LastSwitchSide RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, LastSwitchSide> f334423a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ LastSwitchSide[] f334424b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334425c = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<LastSwitchSide> getEntries() {
        return f334425c;
    }

    static {
        LastSwitchSide r100 = new LastSwitchSide("LEFT", 0, 0);
        LEFT = r100;
        LastSwitchSide r101 = new LastSwitchSide("BUTTON", 1, 1);
        BUTTON = r101;
        LastSwitchSide r102 = new LastSwitchSide("RIGHT", 2, 2);
        RIGHT = r102;
        LastSwitchSide[] r103 = {r100, r101, r102};
        f334424b = r103;
        f334425c = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
        EnumEntries<LastSwitchSide> r104 = getEntries();
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
        Iterator<LastSwitchSide> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        LastSwitchSide r107 = r106.next();
        r105.put(Integer.valueOf(r107.value), r107);
        goto L4
    L6:
        f334423a = r105;
    }

    public static LastSwitchSide[] values() {
        return (LastSwitchSide[]) f334424b.clone();
    }

    public static final /* synthetic */ Map access$getValues$cp() {
        return f334423a;
    }

    public final int getValue() {
        return this.value;
    }

    public static LastSwitchSide valueOf(String r100) {
        return (LastSwitchSide) r27.a.a(LastSwitchSide.class, r100);
    }

    public LastSwitchSide(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
