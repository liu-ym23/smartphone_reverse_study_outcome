package com.ss.android.lark.export.entity;

import com.alibaba.gaiax.model.GXAnimation;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/export/entity/Justify;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", GXAnimation.STATE_START, "CENTER", GXAnimation.STATE_END, "SPACE_BETWEEN", "SPACE_AROUND", "SPACE_EVENLY", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Justify extends Enum<Justify> implements Serializable {
    public static final Justify CENTER = null;
    public static final a Companion = null;
    public static final Justify END = null;
    public static final Justify SPACE_AROUND = null;
    public static final Justify SPACE_BETWEEN = null;
    public static final Justify SPACE_EVENLY = null;
    public static final Justify START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Justify[] f420650a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420651b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Justify a(int r100) {
            if (r100 == 0) goto L20;
            if (r100 == 1) goto L26;
            if (r100 == 2) goto L25;
            if (r100 == 3) goto L24;
            if (r100 == 4) goto L23;
            if (r100 == 5) goto L22;
            return Justify.START;
        L22:
            return Justify.SPACE_EVENLY;
        L23:
            return Justify.SPACE_AROUND;
        L24:
            return Justify.SPACE_BETWEEN;
        L25:
            return Justify.END;
        L26:
            return Justify.CENTER;
        L20:
            return Justify.START;
        }
    }

    public static EnumEntries<Justify> getEntries() {
        return f420651b;
    }

    static {
        Justify r100 = new Justify(GXAnimation.STATE_START, 0, 0);
        START = r100;
        Justify r101 = new Justify("CENTER", 1, 1);
        CENTER = r101;
        Justify r102 = new Justify(GXAnimation.STATE_END, 2, 2);
        END = r102;
        Justify r103 = new Justify("SPACE_BETWEEN", 3, 3);
        SPACE_BETWEEN = r103;
        Justify r104 = new Justify("SPACE_AROUND", 4, 4);
        SPACE_AROUND = r104;
        Justify r105 = new Justify("SPACE_EVENLY", 5, 5);
        SPACE_EVENLY = r105;
        Justify[] r110 = {r100, r101, r102, r103, r104, r105};
        f420650a = r110;
        f420651b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static Justify[] values() {
        return (Justify[]) f420650a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Justify valueOf(String r100) {
        return (Justify) r27.a.a(Justify.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public Justify(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
