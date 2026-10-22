package com.ss.android.lark.widget.table.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/widget/table/entity/VerticalAlign;", "Ljava/io/Serializable;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "VERTICAL_ALIGN_UNKNOWN", "VERTICAL_ALIGN_TOP", "VERTICAL_ALIGN_CENTER", "VERTICAL_ALIGN_BOTTOM", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VerticalAlign extends Enum<VerticalAlign> implements Serializable {
    public static final a Companion = null;
    public static final VerticalAlign VERTICAL_ALIGN_BOTTOM = null;
    public static final VerticalAlign VERTICAL_ALIGN_CENTER = null;
    public static final VerticalAlign VERTICAL_ALIGN_TOP = null;
    public static final VerticalAlign VERTICAL_ALIGN_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VerticalAlign[] f448898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f448899b = null;
    private final int number;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static VerticalAlign a(int r100) {
            VerticalAlign[] r101 = VerticalAlign.values();
            if (r100 >= 0) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L11;
            return r101[r100];
        L11:
            return VerticalAlign.VERTICAL_ALIGN_UNKNOWN;
        L5:
            if (r100 >= r101.length) goto L7;
            r102 = true;
            goto L8
        }
    }

    @JvmStatic
    public static final VerticalAlign fromValue(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<VerticalAlign> getEntries() {
        return f448899b;
    }

    static {
        VerticalAlign r100 = new VerticalAlign("VERTICAL_ALIGN_UNKNOWN", 0, 0);
        VERTICAL_ALIGN_UNKNOWN = r100;
        VerticalAlign r101 = new VerticalAlign("VERTICAL_ALIGN_TOP", 1, 1);
        VERTICAL_ALIGN_TOP = r101;
        VerticalAlign r102 = new VerticalAlign("VERTICAL_ALIGN_CENTER", 2, 2);
        VERTICAL_ALIGN_CENTER = r102;
        VerticalAlign r103 = new VerticalAlign("VERTICAL_ALIGN_BOTTOM", 3, 3);
        VERTICAL_ALIGN_BOTTOM = r103;
        VerticalAlign[] r104 = {r100, r101, r102, r103};
        f448898a = r104;
        f448899b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static VerticalAlign[] values() {
        return (VerticalAlign[]) f448898a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static VerticalAlign valueOf(String r100) {
        return (VerticalAlign) r27.a.a(VerticalAlign.class, r100);
    }

    public VerticalAlign(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
