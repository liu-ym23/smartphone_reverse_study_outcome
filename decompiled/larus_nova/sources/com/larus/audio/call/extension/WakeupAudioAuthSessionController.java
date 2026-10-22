package com.larus.audio.call.extension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;
import r68.b;

/* JADX INFO: loaded from: classes24.dex */
public final class WakeupAudioAuthSessionController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f289115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f289116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f289117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f289118d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/extension/WakeupAudioAuthSessionController$QueryEndAction;", "", "<init>", "(Ljava/lang/String;I)V", "END_SESSION", "RESET_FOR_NEXT_QUERY", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum QueryEndAction extends Enum<QueryEndAction> {
        public static final QueryEndAction END_SESSION = null;
        public static final QueryEndAction RESET_FOR_NEXT_QUERY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ QueryEndAction[] f289119a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f289120b = null;

        public static EnumEntries<QueryEndAction> getEntries() {
            return f289120b;
        }

        static {
            QueryEndAction r100 = new QueryEndAction("END_SESSION", 0);
            END_SESSION = r100;
            QueryEndAction r101 = new QueryEndAction("RESET_FOR_NEXT_QUERY", 1);
            RESET_FOR_NEXT_QUERY = r101;
            QueryEndAction[] r102 = {r100, r101};
            f289119a = r102;
            f289120b = EnumEntriesKt.enumEntries(r102);
        }

        public static QueryEndAction[] values() {
            return (QueryEndAction[]) f289119a.clone();
        }

        public static QueryEndAction valueOf(String r100) {
            return (QueryEndAction) a.a(QueryEndAction.class, r100);
        }

        public QueryEndAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final void a() {
        Object r100 = this.f289118d;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f289116b == true) goto L7;
    L13:
        monitor-exit(r100);
        return;
    L7:
        if (this.f289115a == true) goto L13;
        this.f289116b = false;     // Catch: Throwable -> L15
        this.f289115a = true;     // Catch: Throwable -> L15
        String r101 = this.f289117c;     // Catch: Throwable -> L15
        monitor-exit(r100);
        b.f536357a.a(r101);
    }

    public WakeupAudioAuthSessionController() {
        this.f289118d = new Object();
    }

    public final void b(boolean r100, long r101, boolean r102) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (r101 == 0) goto L17;
        boolean r103 = b.f536357a.c(r101, r102);
        Object r104 = this.f289118d;
        monitor-enter(r104);
        this.f289116b = r103;     // Catch: Throwable -> L11
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r104);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
