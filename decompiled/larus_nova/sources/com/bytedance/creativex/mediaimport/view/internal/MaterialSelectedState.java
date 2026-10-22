package com.bytedance.creativex.mediaimport.view.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0000j\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/MaterialSelectedState;", "", "<init>", "(Ljava/lang/String;I)V", "SELECTED", "NON_SELECTED", "isSelected", "", "toggle", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MaterialSelectedState extends Enum<MaterialSelectedState> {
    public static final MaterialSelectedState NON_SELECTED = null;
    public static final MaterialSelectedState SELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MaterialSelectedState[] f203681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f203682b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f203683a = null;

        static {
            int[] r100 = new int[MaterialSelectedState.values().length];
            r100[MaterialSelectedState.SELECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MaterialSelectedState.NON_SELECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f203683a = r100;
        }
    }

    public static EnumEntries<MaterialSelectedState> getEntries() {
        return f203682b;
    }

    static {
        MaterialSelectedState r100 = new MaterialSelectedState("SELECTED", 0);
        SELECTED = r100;
        MaterialSelectedState r101 = new MaterialSelectedState("NON_SELECTED", 1);
        NON_SELECTED = r101;
        MaterialSelectedState[] r102 = {r100, r101};
        f203681a = r102;
        f203682b = EnumEntriesKt.enumEntries(r102);
    }

    public static MaterialSelectedState[] values() {
        return (MaterialSelectedState[]) f203681a.clone();
    }

    public final boolean isSelected() {
        if (this != SELECTED) goto L5;
        return true;
    L5:
        return false;
    }

    public final MaterialSelectedState toggle() {
        int r100 = a.f203683a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return SELECTED;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return NON_SELECTED;
    }

    public static MaterialSelectedState valueOf(String r100) {
        return (MaterialSelectedState) r27.a.a(MaterialSelectedState.class, r100);
    }

    public MaterialSelectedState(String r100, int r101) {
        super(r100, r101);
    }
}
