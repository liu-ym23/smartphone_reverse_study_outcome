package com.ss.android.lark.docs.icon.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/docs/icon/entity/IconShape;", "", "<init>", "(Ljava/lang/String;I)V", "CIRCLE", "SQUARE", "SQUARE_OUTLINE", "docs-icon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IconShape extends Enum<IconShape> {
    public static final IconShape CIRCLE = null;
    public static final IconShape SQUARE = null;
    public static final IconShape SQUARE_OUTLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconShape[] f420496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420497b = null;

    public static EnumEntries<IconShape> getEntries() {
        return f420497b;
    }

    static {
        IconShape r100 = new IconShape("CIRCLE", 0);
        CIRCLE = r100;
        IconShape r101 = new IconShape("SQUARE", 1);
        SQUARE = r101;
        IconShape r102 = new IconShape("SQUARE_OUTLINE", 2);
        SQUARE_OUTLINE = r102;
        IconShape[] r103 = {r100, r101, r102};
        f420496a = r103;
        f420497b = EnumEntriesKt.enumEntries(r103);
    }

    public static IconShape[] values() {
        return (IconShape[]) f420496a.clone();
    }

    public static IconShape valueOf(String r100) {
        return (IconShape) a.a(IconShape.class, r100);
    }

    public IconShape(String r100, int r101) {
        super(r100, r101);
    }
}
