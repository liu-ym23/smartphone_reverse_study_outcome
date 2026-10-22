package com.larus.perfdegrade.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
public final class PerfDegradeScrollEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PerfDegradeType f363954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f363955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f363956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScrollState f363957d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/perfdegrade/api/model/PerfDegradeScrollEvent$ScrollState;", "", "<init>", "(Ljava/lang/String;I)V", "DRAGGING", "SETTLING", "IDLE", "DETACH", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScrollState extends Enum<ScrollState> {
        public static final ScrollState DETACH = null;
        public static final ScrollState DRAGGING = null;
        public static final ScrollState IDLE = null;
        public static final ScrollState SETTLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollState[] f363958a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f363959b = null;

        public static EnumEntries<ScrollState> getEntries() {
            return f363959b;
        }

        static {
            ScrollState r100 = new ScrollState("DRAGGING", 0);
            DRAGGING = r100;
            ScrollState r101 = new ScrollState("SETTLING", 1);
            SETTLING = r101;
            ScrollState r102 = new ScrollState("IDLE", 2);
            IDLE = r102;
            ScrollState r103 = new ScrollState("DETACH", 3);
            DETACH = r103;
            ScrollState[] r104 = {r100, r101, r102, r103};
            f363958a = r104;
            f363959b = EnumEntriesKt.enumEntries(r104);
        }

        public static ScrollState[] values() {
            return (ScrollState[]) f363958a.clone();
        }

        public static ScrollState valueOf(String r100) {
            return (ScrollState) a.a(ScrollState.class, r100);
        }

        public ScrollState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PerfDegradeScrollEvent) == true) goto L8;
        return false;
    L8:
        PerfDegradeScrollEvent r101 = (PerfDegradeScrollEvent) r100;
        if (this.f363954a == r101.f363954a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f363955b, r101.f363955b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f363956c, r101.f363956c) == true) goto L18;
        return false;
    L18:
        if (this.f363957d == r101.f363957d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f363954a.hashCode() * 31) + this.f363955b.hashCode()) * 31) + this.f363956c.hashCode()) * 31) + this.f363957d.hashCode();
    }

    public final String toString() {
        return "PerfDegradeScrollEvent(type=" + this.f363954a + ", scene=" + this.f363955b + ", targetId=" + this.f363956c + ", state=" + this.f363957d + ')';
    }

    public final PerfDegradeType getType() {
        return this.f363954a;
    }

    public PerfDegradeScrollEvent(PerfDegradeType r100, String r101, String r102, ScrollState r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "targetId");
        Intrinsics.checkNotNullParameter(r103, "state");
        this.f363954a = r100;
        this.f363955b = r101;
        this.f363956c = r102;
        this.f363957d = r103;
    }
}
