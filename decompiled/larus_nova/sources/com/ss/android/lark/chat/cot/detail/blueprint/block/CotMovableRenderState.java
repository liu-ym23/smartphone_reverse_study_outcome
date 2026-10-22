package com.ss.android.lark.chat.cot.detail.blueprint.block;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
public final class CotMovableRenderState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f414872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Pair<String, Float> f414873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Status f414874c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/blueprint/block/CotMovableRenderState$Status;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PENDING", "SUCCESS", "FAILURE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status FAILURE = null;
        public static final Status IDLE = null;
        public static final Status PENDING = null;
        public static final Status SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f414875a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f414876b = null;

        public static EnumEntries<Status> getEntries() {
            return f414876b;
        }

        static {
            Status r100 = new Status("IDLE", 0);
            IDLE = r100;
            Status r101 = new Status("PENDING", 1);
            PENDING = r101;
            Status r102 = new Status("SUCCESS", 2);
            SUCCESS = r102;
            Status r103 = new Status("FAILURE", 3);
            FAILURE = r103;
            Status[] r104 = {r100, r101, r102, r103};
            f414875a = r104;
            f414876b = EnumEntriesKt.enumEntries(r104);
        }

        public static Status[] values() {
            return (Status[]) f414875a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f414877a = null;

        static {
            int[] r100 = new int[Status.values().length];
            r100[Status.PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Status.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Status.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Status.FAILURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f414877a = r100;
        }
    }

    public CotMovableRenderState() {
        this.f414872a = new AtomicLong();
        this.f414874c = Status.IDLE;
    }

    public final boolean a(long r100, boolean r101) {
        if (r100 == this.f414872a.get()) goto L6;
        return false;
    L6:
        if (r101 == false) goto L8;
        Status r102 = Status.SUCCESS;
    L9:
        this.f414874c = r102;
        return true;
    L8:
        r102 = Status.FAILURE;
        goto L9
    }
}
