package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
public interface ISdkPerfDegradeService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/api/ISdkPerfDegradeService$ScrollState;", "", "<init>", "(Ljava/lang/String;I)V", "DRAGGING", "SETTLING", "IDLE", "DETACH", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScrollState extends Enum<ScrollState> {
        public static final ScrollState DETACH = null;
        public static final ScrollState DRAGGING = null;
        public static final ScrollState IDLE = null;
        public static final ScrollState SETTLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollState[] f364785a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f364786b = null;

        public static EnumEntries<ScrollState> getEntries() {
            return f364786b;
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
            f364785a = r104;
            f364786b = EnumEntriesKt.enumEntries(r104);
        }

        public static ScrollState[] values() {
            return (ScrollState[]) f364785a.clone();
        }

        public static ScrollState valueOf(String r100) {
            return (ScrollState) r27.a.a(ScrollState.class, r100);
        }

        public ScrollState(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a(String r100, String r101, ScrollState r102);

    boolean b(String r100);
}
