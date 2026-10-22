package com.ss.android.lark.export.entity;

import com.bytedance.ee.bear.sheet.fab.FabItem;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/export/entity/Orientation;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", FabItem.FabSheetItem.CellType.ROW, "COLUMN", "ROW_REVERSE", "COLUMN_REVERSE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Orientation extends Enum<Orientation> implements Serializable {
    public static final Orientation COLUMN = null;
    public static final Orientation COLUMN_REVERSE = null;
    public static final a Companion = null;
    public static final Orientation ROW = null;
    public static final Orientation ROW_REVERSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Orientation[] f420652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420653b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Orientation a(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L18;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L16;
            return Orientation.ROW;
        L16:
            return Orientation.COLUMN_REVERSE;
        L17:
            return Orientation.ROW_REVERSE;
        L18:
            return Orientation.COLUMN;
        L14:
            return Orientation.ROW;
        }
    }

    public static EnumEntries<Orientation> getEntries() {
        return f420653b;
    }

    static {
        Orientation r100 = new Orientation(FabItem.FabSheetItem.CellType.ROW, 0, 0);
        ROW = r100;
        Orientation r101 = new Orientation("COLUMN", 1, 1);
        COLUMN = r101;
        Orientation r102 = new Orientation("ROW_REVERSE", 2, 2);
        ROW_REVERSE = r102;
        Orientation r103 = new Orientation("COLUMN_REVERSE", 3, 3);
        COLUMN_REVERSE = r103;
        Orientation[] r104 = {r100, r101, r102, r103};
        f420652a = r104;
        f420653b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static Orientation[] values() {
        return (Orientation[]) f420652a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Orientation valueOf(String r100) {
        return (Orientation) r27.a.a(Orientation.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public Orientation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
