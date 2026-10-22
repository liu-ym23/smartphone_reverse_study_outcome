package com.larus.media.focus;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class CardContextState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f359027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TriggerReason f359028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f359029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OScrollStateHelper.ScrollDirection f359030d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/media/focus/CardContextState$TriggerReason;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, "SCROLL", "LIFECYCLE", "DATA_CHANGE", "DETACH", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TriggerReason extends Enum<TriggerReason> {
        public static final TriggerReason DATA_CHANGE = null;
        public static final TriggerReason DETACH = null;
        public static final TriggerReason INIT = null;
        public static final TriggerReason LIFECYCLE = null;
        public static final TriggerReason SCROLL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TriggerReason[] f359031a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f359032b = null;

        public static EnumEntries<TriggerReason> getEntries() {
            return f359032b;
        }

        static {
            TriggerReason r100 = new TriggerReason(ErrorCode.INIT, 0);
            INIT = r100;
            TriggerReason r101 = new TriggerReason("SCROLL", 1);
            SCROLL = r101;
            TriggerReason r102 = new TriggerReason("LIFECYCLE", 2);
            LIFECYCLE = r102;
            TriggerReason r103 = new TriggerReason("DATA_CHANGE", 3);
            DATA_CHANGE = r103;
            TriggerReason r104 = new TriggerReason("DETACH", 4);
            DETACH = r104;
            TriggerReason[] r105 = {r100, r101, r102, r103, r104};
            f359031a = r105;
            f359032b = EnumEntriesKt.enumEntries(r105);
        }

        public static TriggerReason[] values() {
            return (TriggerReason[]) f359031a.clone();
        }

        public static TriggerReason valueOf(String r100) {
            return (TriggerReason) r27.a.a(TriggerReason.class, r100);
        }

        public TriggerReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CardContextState) == true) goto L8;
        return false;
    L8:
        CardContextState r101 = (CardContextState) r100;
        if (this.f359027a == r101.f359027a) goto L12;
        return false;
    L12:
        if (this.f359028b == r101.f359028b) goto L15;
        return false;
    L15:
        if (this.f359029c == r101.f359029c) goto L18;
        return false;
    L18:
        if (this.f359030d == r101.f359030d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f359027a * 31) + this.f359028b.hashCode()) * 31) + this.f359029c) * 31) + this.f359030d.hashCode();
    }

    public final String toString() {
        return "CardContextState(scrollState=" + this.f359027a + ", reason=" + this.f359028b + ", orientation=" + this.f359029c + ", scrollingDirection=" + this.f359030d + ')';
    }

    public CardContextState(int r100, TriggerReason r101, int r102, OScrollStateHelper.ScrollDirection r103) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r103, "scrollingDirection");
        this.f359027a = r100;
        this.f359028b = r101;
        this.f359029c = r102;
        this.f359030d = r103;
    }
}
