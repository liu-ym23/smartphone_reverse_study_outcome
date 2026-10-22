package com.bytedance.creativex.mediaimport.preview.internal.main;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/creativex/mediaimport/preview/internal/main/SelectionListAndPreviewCombiner$State;", "", "<init>", "(Ljava/lang/String;I)V", "PREVIEW_SHOW", "PREVIEW_HIDE", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum SelectionListAndPreviewCombiner$State extends Enum<SelectionListAndPreviewCombiner$State> {
    public static final SelectionListAndPreviewCombiner$State PREVIEW_HIDE = null;
    public static final SelectionListAndPreviewCombiner$State PREVIEW_SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectionListAndPreviewCombiner$State[] f203472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f203473b = null;

    public static EnumEntries<SelectionListAndPreviewCombiner$State> getEntries() {
        return f203473b;
    }

    static {
        SelectionListAndPreviewCombiner$State r100 = new SelectionListAndPreviewCombiner$State("PREVIEW_SHOW", 0);
        PREVIEW_SHOW = r100;
        SelectionListAndPreviewCombiner$State r101 = new SelectionListAndPreviewCombiner$State("PREVIEW_HIDE", 1);
        PREVIEW_HIDE = r101;
        SelectionListAndPreviewCombiner$State[] r102 = {r100, r101};
        f203472a = r102;
        f203473b = EnumEntriesKt.enumEntries(r102);
    }

    public static SelectionListAndPreviewCombiner$State[] values() {
        return (SelectionListAndPreviewCombiner$State[]) f203472a.clone();
    }

    public static SelectionListAndPreviewCombiner$State valueOf(String r100) {
        return (SelectionListAndPreviewCombiner$State) r27.a.a(SelectionListAndPreviewCombiner$State.class, r100);
    }

    public SelectionListAndPreviewCombiner$State(String r100, int r101) {
        super(r100, r101);
    }
}
