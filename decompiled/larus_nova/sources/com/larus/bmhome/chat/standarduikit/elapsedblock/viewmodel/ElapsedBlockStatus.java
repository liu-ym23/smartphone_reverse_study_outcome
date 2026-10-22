package com.larus.bmhome.chat.standarduikit.elapsedblock.viewmodel;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/elapsedblock/viewmodel/ElapsedBlockStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Folded", "Expanded", "trackValue", "", "getTrackValue", "()Ljava/lang/String;", "toContainerStatus", "Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ElapsedBlockStatus extends Enum<ElapsedBlockStatus> {
    public static final ElapsedBlockStatus Expanded = null;
    public static final ElapsedBlockStatus Folded = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ElapsedBlockStatus[] f309047a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f309048b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309049a = null;

        static {
            int[] r100 = new int[ElapsedBlockStatus.values().length];
            r100[ElapsedBlockStatus.Folded.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ElapsedBlockStatus.Expanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f309049a = r100;
        }
    }

    public static EnumEntries<ElapsedBlockStatus> getEntries() {
        return f309048b;
    }

    static {
        ElapsedBlockStatus r100 = new ElapsedBlockStatus("Folded", 0);
        Folded = r100;
        ElapsedBlockStatus r101 = new ElapsedBlockStatus("Expanded", 1);
        Expanded = r101;
        ElapsedBlockStatus[] r102 = {r100, r101};
        f309047a = r102;
        f309048b = EnumEntriesKt.enumEntries(r102);
    }

    public static ElapsedBlockStatus[] values() {
        return (ElapsedBlockStatus[]) f309047a.clone();
    }

    public final String getTrackValue() {
        int r100 = a.f309049a[ordinal()];
        if (r100 != 1) goto L5;
        return "folded";
    L5:
        if (r100 != 2) goto L8;
        return "expanded";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final DeepThinkFoldStatus toContainerStatus() {
        int r100 = a.f309049a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return DeepThinkFoldStatus.CompleteExpand;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return DeepThinkFoldStatus.CompleteFold;
    }

    public static ElapsedBlockStatus valueOf(String r100) {
        return (ElapsedBlockStatus) r27.a.a(ElapsedBlockStatus.class, r100);
    }

    public ElapsedBlockStatus(String r100, int r101) {
        super(r100, r101);
    }
}
