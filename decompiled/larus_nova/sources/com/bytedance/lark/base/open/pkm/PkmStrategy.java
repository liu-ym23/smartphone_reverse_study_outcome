package com.bytedance.lark.base.open.pkm;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/PkmStrategy;", "", "(Ljava/lang/String;I)V", "into", "Lopen_pkm/proto/PkmStrategy;", "intoInt", "", "TryRemoteAndUpdateAsync", "ForceRemote", "UseLocal", "Companion", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum PkmStrategy extends Enum<PkmStrategy> {
    public static final a Companion = null;
    public static final PkmStrategy ForceRemote = null;
    public static final PkmStrategy TryRemoteAndUpdateAsync = null;
    public static final PkmStrategy UseLocal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PkmStrategy[] f252887a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252888b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252889a = null;

        static {
            int[] r100 = new int[PkmStrategy.values().length];
            r100[PkmStrategy.TryRemoteAndUpdateAsync.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PkmStrategy.ForceRemote.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PkmStrategy.UseLocal.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f252889a = r100;
        }
    }

    public static EnumEntries<PkmStrategy> getEntries() {
        return f252888b;
    }

    public static PkmStrategy valueOf(String r100) {
        return (PkmStrategy) r27.a.a(PkmStrategy.class, r100);
    }

    public static PkmStrategy[] values() {
        return (PkmStrategy[]) f252887a.clone();
    }

    static {
        PkmStrategy r100 = new PkmStrategy("TryRemoteAndUpdateAsync", 0);
        TryRemoteAndUpdateAsync = r100;
        PkmStrategy r101 = new PkmStrategy("ForceRemote", 1);
        ForceRemote = r101;
        PkmStrategy r102 = new PkmStrategy("UseLocal", 2);
        UseLocal = r102;
        PkmStrategy[] r103 = {r100, r101, r102};
        f252887a = r103;
        f252888b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public final open_pkm.proto.PkmStrategy into() {
        int r100 = b.f252889a[ordinal()];
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L15;
        if (r100 != 3) goto L10;
        return open_pkm.proto.PkmStrategy.VAR_PKM_STRATEGY_USE_LOCAL;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return open_pkm.proto.PkmStrategy.VAR_PKM_STRATEGY_FORCE_REMOTE;
    L13:
        return open_pkm.proto.PkmStrategy.VAR_PKM_STRATEGY_TRY_REMOTE_AND_UPDATE_ASYNC;
    }

    public final int intoInt() {
        int r100 = b.f252889a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L7;
        return 1;
    L7:
        if (r100 != 3) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final PkmStrategy fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L15;
        if (r100 != 2) goto L10;
        return UseLocal;
    L10:
        throw new RuntimeException("Unmatched primitive enum value: PkmStrategy with ");
    L15:
        return ForceRemote;
    L13:
        return TryRemoteAndUpdateAsync;
    }

    public PkmStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
