package com.ss.android.ainote.model;

import com.android.ttcjpaysdk.bdpay.counter.outer.preload.DyOuterPayPreloadManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ainote/model/AINoteContentState;", "", "<init>", "(Ljava/lang/String;I)V", "NEED", "NO_NEED", "FINISH", "REVERTED", DyOuterPayPreloadManager.VIEW_TAG, "EDITING", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteContentState extends Enum<AINoteContentState> {
    public static final AINoteContentState EDITING = null;
    public static final AINoteContentState FINISH = null;
    public static final AINoteContentState NEED = null;
    public static final AINoteContentState NO_NEED = null;
    public static final AINoteContentState REVERTED = null;
    public static final AINoteContentState USE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteContentState[] f407134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f407135b = null;

    public static EnumEntries<AINoteContentState> getEntries() {
        return f407135b;
    }

    static {
        AINoteContentState r100 = new AINoteContentState("NEED", 0);
        NEED = r100;
        AINoteContentState r101 = new AINoteContentState("NO_NEED", 1);
        NO_NEED = r101;
        AINoteContentState r102 = new AINoteContentState("FINISH", 2);
        FINISH = r102;
        AINoteContentState r103 = new AINoteContentState("REVERTED", 3);
        REVERTED = r103;
        AINoteContentState r104 = new AINoteContentState(DyOuterPayPreloadManager.VIEW_TAG, 4);
        USE = r104;
        AINoteContentState r105 = new AINoteContentState("EDITING", 5);
        EDITING = r105;
        AINoteContentState[] r110 = {r100, r101, r102, r103, r104, r105};
        f407134a = r110;
        f407135b = EnumEntriesKt.enumEntries(r110);
    }

    public static AINoteContentState[] values() {
        return (AINoteContentState[]) f407134a.clone();
    }

    public static AINoteContentState valueOf(String r100) {
        return (AINoteContentState) a.a(AINoteContentState.class, r100);
    }

    public AINoteContentState(String r100, int r101) {
        super(r100, r101);
    }
}
