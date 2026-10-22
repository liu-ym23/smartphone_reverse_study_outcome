package com.larksuite.common_selection.selectionhandle;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/common_selection/selectionhandle/SelectionHandleType;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, GXAnimation.STATE_END, "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SelectionHandleType extends Enum<SelectionHandleType> {
    public static final SelectionHandleType END = null;
    public static final SelectionHandleType START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectionHandleType[] f282926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f282927b = null;

    public static EnumEntries<SelectionHandleType> getEntries() {
        return f282927b;
    }

    static {
        SelectionHandleType r100 = new SelectionHandleType(GXAnimation.STATE_START, 0);
        START = r100;
        SelectionHandleType r101 = new SelectionHandleType(GXAnimation.STATE_END, 1);
        END = r101;
        SelectionHandleType[] r102 = {r100, r101};
        f282926a = r102;
        f282927b = EnumEntriesKt.enumEntries(r102);
    }

    public static SelectionHandleType[] values() {
        return (SelectionHandleType[]) f282926a.clone();
    }

    public static SelectionHandleType valueOf(String r100) {
        return (SelectionHandleType) a.a(SelectionHandleType.class, r100);
    }

    public SelectionHandleType(String r100, int r101) {
        super(r100, r101);
    }
}
