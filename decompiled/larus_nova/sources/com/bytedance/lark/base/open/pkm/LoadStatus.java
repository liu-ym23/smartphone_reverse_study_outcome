package com.bytedance.lark.base.open.pkm;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/LoadStatus;", "", "(Ljava/lang/String;I)V", "into", "Lopen_pkm/proto/LoadStatus;", "intoInt", "", "Initial", "Downloading", "Finished", "Companion", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum LoadStatus extends Enum<LoadStatus> {
    public static final a Companion = null;
    public static final LoadStatus Downloading = null;
    public static final LoadStatus Finished = null;
    public static final LoadStatus Initial = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadStatus[] f252869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252870b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252871a = null;

        static {
            int[] r100 = new int[LoadStatus.values().length];
            r100[LoadStatus.Initial.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LoadStatus.Downloading.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LoadStatus.Finished.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f252871a = r100;
        }
    }

    public static EnumEntries<LoadStatus> getEntries() {
        return f252870b;
    }

    public static LoadStatus valueOf(String r100) {
        return (LoadStatus) r27.a.a(LoadStatus.class, r100);
    }

    public static LoadStatus[] values() {
        return (LoadStatus[]) f252869a.clone();
    }

    static {
        LoadStatus r100 = new LoadStatus("Initial", 0);
        Initial = r100;
        LoadStatus r101 = new LoadStatus("Downloading", 1);
        Downloading = r101;
        LoadStatus r102 = new LoadStatus("Finished", 2);
        Finished = r102;
        LoadStatus[] r103 = {r100, r101, r102};
        f252869a = r103;
        f252870b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public final open_pkm.proto.LoadStatus into() {
        int r100 = b.f252871a[ordinal()];
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L15;
        if (r100 != 3) goto L10;
        return open_pkm.proto.LoadStatus.VAR_LOAD_STATUS_FINISHED;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return open_pkm.proto.LoadStatus.VAR_LOAD_STATUS_DOWNLOADING;
    L13:
        return open_pkm.proto.LoadStatus.VAR_LOAD_STATUS_INITIAL;
    }

    public final int intoInt() {
        int r100 = b.f252871a[ordinal()];
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
    public static final LoadStatus fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L15;
        if (r100 != 2) goto L10;
        return Finished;
    L10:
        throw new RuntimeException("Unmatched primitive enum value: LoadStatus with ");
    L15:
        return Downloading;
    L13:
        return Initial;
    }

    public LoadStatus(String r100, int r101) {
        super(r100, r101);
    }
}
