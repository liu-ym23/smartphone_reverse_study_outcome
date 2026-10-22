package com.ss.android.lark.widget.table.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;", "Ljava/io/Serializable;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "HORIZONTAL_ALIGN_UNKNOWN", "HORIZONTAL_ALIGN_LEFT", "HORIZONTAL_ALIGN_CENTER", "HORIZONTAL_ALIGN_RIGHT", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HorizontalAlign extends Enum<HorizontalAlign> implements Serializable {
    public static final a Companion = null;
    public static final HorizontalAlign HORIZONTAL_ALIGN_CENTER = null;
    public static final HorizontalAlign HORIZONTAL_ALIGN_LEFT = null;
    public static final HorizontalAlign HORIZONTAL_ALIGN_RIGHT = null;
    public static final HorizontalAlign HORIZONTAL_ALIGN_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HorizontalAlign[] f448895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f448896b = null;
    private final int number;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static HorizontalAlign a(int r100) {
            HorizontalAlign[] r101 = HorizontalAlign.values();
            if (r100 >= 0) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L11;
            return r101[r100];
        L11:
            return HorizontalAlign.HORIZONTAL_ALIGN_UNKNOWN;
        L5:
            if (r100 >= r101.length) goto L7;
            r102 = true;
            goto L8
        }
    }

    @JvmStatic
    public static final HorizontalAlign fromValue(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<HorizontalAlign> getEntries() {
        return f448896b;
    }

    static {
        HorizontalAlign r100 = new HorizontalAlign("HORIZONTAL_ALIGN_UNKNOWN", 0, 0);
        HORIZONTAL_ALIGN_UNKNOWN = r100;
        HorizontalAlign r101 = new HorizontalAlign("HORIZONTAL_ALIGN_LEFT", 1, 1);
        HORIZONTAL_ALIGN_LEFT = r101;
        HorizontalAlign r102 = new HorizontalAlign("HORIZONTAL_ALIGN_CENTER", 2, 2);
        HORIZONTAL_ALIGN_CENTER = r102;
        HorizontalAlign r103 = new HorizontalAlign("HORIZONTAL_ALIGN_RIGHT", 3, 3);
        HORIZONTAL_ALIGN_RIGHT = r103;
        HorizontalAlign[] r104 = {r100, r101, r102, r103};
        f448895a = r104;
        f448896b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static HorizontalAlign[] values() {
        return (HorizontalAlign[]) f448895a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static HorizontalAlign valueOf(String r100) {
        return (HorizontalAlign) r27.a.a(HorizontalAlign.class, r100);
    }

    public HorizontalAlign(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
