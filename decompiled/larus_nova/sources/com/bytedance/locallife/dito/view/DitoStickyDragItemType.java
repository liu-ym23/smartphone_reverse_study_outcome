package com.bytedance.locallife.dito.view;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/dito/view/DitoStickyDragItemType;", "", "", "code", "I", "getCode", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DitoStickyDragItemTypeIllegal", "DitoStickyDragItemTypeAll", "DitoStickyDragItemTypeStart", "DitoStickyDragItemTypeEnd", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum DitoStickyDragItemType extends Enum<DitoStickyDragItemType> {
    public static final a Companion = null;
    public static final DitoStickyDragItemType DitoStickyDragItemTypeAll = null;
    public static final DitoStickyDragItemType DitoStickyDragItemTypeEnd = null;
    public static final DitoStickyDragItemType DitoStickyDragItemTypeIllegal = null;
    public static final DitoStickyDragItemType DitoStickyDragItemTypeStart = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DitoStickyDragItemType[] f258733a = null;
    private final int code;

    public static final class a {
        public a() {
        }
    }

    public static DitoStickyDragItemType valueOf(String r100) {
        return (DitoStickyDragItemType) r27.a.a(DitoStickyDragItemType.class, r100);
    }

    public static DitoStickyDragItemType[] values() {
        return (DitoStickyDragItemType[]) f258733a.clone();
    }

    static {
        DitoStickyDragItemType r100 = new DitoStickyDragItemType("DitoStickyDragItemTypeIllegal", 0, -1);
        DitoStickyDragItemTypeIllegal = r100;
        DitoStickyDragItemType r101 = new DitoStickyDragItemType("DitoStickyDragItemTypeAll", 1, 0);
        DitoStickyDragItemTypeAll = r101;
        DitoStickyDragItemType r102 = new DitoStickyDragItemType("DitoStickyDragItemTypeStart", 2, 1);
        DitoStickyDragItemTypeStart = r102;
        DitoStickyDragItemType r103 = new DitoStickyDragItemType("DitoStickyDragItemTypeEnd", 3, 2);
        DitoStickyDragItemTypeEnd = r103;
        f258733a = new DitoStickyDragItemType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public final int getCode() {
        return this.code;
    }

    public DitoStickyDragItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }

    public /* synthetic */ DitoStickyDragItemType(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = -1;
    L5:
        this(r100, r101, r102);
    }
}
