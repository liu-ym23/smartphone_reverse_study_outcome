package com.ss.android.lark.guide.ui.config;

import android.graphics.Rect;
import android.util.Size;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final class MaskConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f425791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f425792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShapeType f425793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f425794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Size f425795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f425796f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/guide/ui/config/MaskConfig$ShapeType;", "", "<init>", "(Ljava/lang/String;I)V", "RECTANGLE", "CIRCLE", "SQUARE", "guide-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ShapeType extends Enum<ShapeType> {
        public static final ShapeType CIRCLE = null;
        public static final ShapeType RECTANGLE = null;
        public static final ShapeType SQUARE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShapeType[] f425797a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f425798b = null;

        public static EnumEntries<ShapeType> getEntries() {
            return f425798b;
        }

        static {
            ShapeType r100 = new ShapeType("RECTANGLE", 0);
            RECTANGLE = r100;
            ShapeType r101 = new ShapeType("CIRCLE", 1);
            CIRCLE = r101;
            ShapeType r102 = new ShapeType("SQUARE", 2);
            SQUARE = r102;
            ShapeType[] r103 = {r100, r101, r102};
            f425797a = r103;
            f425798b = EnumEntriesKt.enumEntries(r103);
        }

        public static ShapeType[] values() {
            return (ShapeType[]) f425797a.clone();
        }

        public static ShapeType valueOf(String r100) {
            return (ShapeType) a.a(ShapeType.class, r100);
        }

        public ShapeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public MaskConfig(ShapeType r100, Rect r101, Size r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        int r104 = 0;
    L7:
        if ((r103 & 4) == 0) goto L10;
        r100 = ShapeType.RECTANGLE;
    L10:
        if ((r103 & 8) == 0) goto L13;
        r101 = null;
    L13:
        if ((r103 & 16) == 0) goto L15;
        r102 = null;
    L15:
        Intrinsics.checkNotNullParameter(r100, "shapeType");
        this.f425791a = r104;
        this.f425792b = 0.0f;
        this.f425793c = r100;
        this.f425794d = r101;
        this.f425795e = r102;
        this.f425796f = 0;
        return;
    L5:
        r104 = 76;
        goto L7
    }
}
