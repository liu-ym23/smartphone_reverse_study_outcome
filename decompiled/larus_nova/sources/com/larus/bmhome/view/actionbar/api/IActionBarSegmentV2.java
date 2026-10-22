package com.larus.bmhome.view.actionbar.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import ss8.e;

/* JADX INFO: loaded from: classes26.dex */
public interface IActionBarSegmentV2 extends e {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/view/actionbar/api/IActionBarSegmentV2$Position;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_DEFAULT", "AFTER_DEFAULT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Position extends Enum<Position> {
        public static final Position AFTER_DEFAULT = null;
        public static final Position BEFORE_DEFAULT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Position[] f315661a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f315662b = null;

        public static EnumEntries<Position> getEntries() {
            return f315662b;
        }

        static {
            Position r100 = new Position("BEFORE_DEFAULT", 0);
            BEFORE_DEFAULT = r100;
            Position r101 = new Position("AFTER_DEFAULT", 1);
            AFTER_DEFAULT = r101;
            Position[] r102 = {r100, r101};
            f315661a = r102;
            f315662b = EnumEntriesKt.enumEntries(r102);
        }

        public static Position[] values() {
            return (Position[]) f315661a.clone();
        }

        public static Position valueOf(String r100) {
            return (Position) r27.a.a(Position.class, r100);
        }

        public Position(String r100, int r101) {
            super(r100, r101);
        }
    }

    String c();

    Position getPosition();

    int getPriority();

    boolean isEnabled();
}
