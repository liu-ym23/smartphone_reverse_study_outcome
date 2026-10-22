package com.larus.im.internal.trace.manager.definition;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0015"}, d2 = {"Lcom/larus/im/internal/trace/manager/definition/AVSessionState;", "", "<init>", "(Ljava/lang/String;I)V", "Start", "Connected", "QueryBegin", "QueryUpdate", "QueryEnd", "ReplyBegin", "ReplyUpdate", "ReplyEnd", "Timeout", "allowedNextStates", "", "nextTimeoutState", "isInterruptible", "", "reportLogTrace", "", "Companion", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AVSessionState extends Enum<AVSessionState> {
    public static final a Companion = null;
    public static final AVSessionState Connected = null;
    public static final AVSessionState QueryBegin = null;
    public static final AVSessionState QueryEnd = null;
    public static final AVSessionState QueryUpdate = null;
    public static final AVSessionState ReplyBegin = null;
    public static final AVSessionState ReplyEnd = null;
    public static final AVSessionState ReplyUpdate = null;
    public static final AVSessionState Start = null;
    public static final AVSessionState Timeout = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AVSessionState[] f350149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350150b = null;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.im.internal.trace.manager.definition.AVSessionState$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4376a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f350151a = null;

            static {
                int[] r100 = new int[AVSessionState.values().length];
                r100[AVSessionState.Connected.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r100[AVSessionState.QueryBegin.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r100[AVSessionState.QueryUpdate.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[AVSessionState.QueryEnd.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r100[AVSessionState.ReplyBegin.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r100[AVSessionState.ReplyUpdate.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r100[AVSessionState.ReplyEnd.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                f350151a = r100;
            }
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f350152a = null;

        static {
            int[] r100 = new int[AVSessionState.values().length];
            r100[AVSessionState.Start.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[AVSessionState.Connected.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[AVSessionState.QueryBegin.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[AVSessionState.QueryUpdate.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[AVSessionState.QueryEnd.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[AVSessionState.ReplyBegin.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[AVSessionState.ReplyUpdate.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[AVSessionState.ReplyEnd.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[AVSessionState.Timeout.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f350152a = r100;
        }
    }

    public static EnumEntries<AVSessionState> getEntries() {
        return f350150b;
    }

    public final boolean isInterruptible() {
        return CollectionsKt.listOf(new AVSessionState[]{QueryBegin, QueryUpdate, QueryEnd, ReplyBegin, ReplyUpdate}).contains(this);
    }

    public final void reportLogTrace() {
    }

    static {
        AVSessionState r100 = new AVSessionState("Start", 0);
        Start = r100;
        AVSessionState r101 = new AVSessionState("Connected", 1);
        Connected = r101;
        AVSessionState r102 = new AVSessionState("QueryBegin", 2);
        QueryBegin = r102;
        AVSessionState r103 = new AVSessionState("QueryUpdate", 3);
        QueryUpdate = r103;
        AVSessionState r104 = new AVSessionState("QueryEnd", 4);
        QueryEnd = r104;
        AVSessionState r105 = new AVSessionState("ReplyBegin", 5);
        ReplyBegin = r105;
        AVSessionState r110 = new AVSessionState("ReplyUpdate", 6);
        ReplyUpdate = r110;
        AVSessionState r111 = new AVSessionState("ReplyEnd", 7);
        ReplyEnd = r111;
        AVSessionState r112 = new AVSessionState("Timeout", 8);
        Timeout = r112;
        AVSessionState[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f350149a = r113;
        f350150b = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
    }

    public static AVSessionState[] values() {
        return (AVSessionState[]) f350149a.clone();
    }

    public final List<AVSessionState> allowedNextStates() {
        switch(b.f350152a[ordinal()]) {
            case 1: goto L15;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L16:
        return CollectionsKt.listOf(QueryBegin);
    L17:
        return CollectionsKt.listOf(QueryBegin);
    L18:
        return CollectionsKt.listOf(new AVSessionState[]{ReplyUpdate, ReplyEnd});
    L19:
        return CollectionsKt.listOf(ReplyUpdate);
    L20:
        return CollectionsKt.listOf(ReplyBegin);
    L21:
        return CollectionsKt.listOf(new AVSessionState[]{QueryUpdate, QueryEnd});
    L22:
        return CollectionsKt.listOf(QueryUpdate);
    L23:
        return CollectionsKt.listOf(QueryBegin);
    L15:
        return CollectionsKt.listOf(Connected);
    }

    public final AVSessionState nextTimeoutState() {
        switch(b.f350152a[ordinal()]) {
            case 2: goto L11;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L13;
            default: goto L4;
        };
    L4:
        return null;
    L13:
        return QueryBegin;
    L14:
        return ReplyEnd;
    L15:
        return ReplyBegin;
    L16:
        return QueryEnd;
    L17:
        return QueryUpdate;
    L11:
        return QueryBegin;
    }

    public static AVSessionState valueOf(String r100) {
        return (AVSessionState) r27.a.a(AVSessionState.class, r100);
    }

    public AVSessionState(String r100, int r101) {
        super(r100, r101);
    }
}
