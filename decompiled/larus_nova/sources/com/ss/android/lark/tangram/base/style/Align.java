package com.ss.android.lark.tangram.base.style;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/tangram/base/style/Align;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "TOP", "MIDDLE", "BOTTOM", "STRETCH", "BASELINE", "Companion", "tangram-component_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Align extends Enum<Align> implements Serializable {
    public static final Align BASELINE = null;
    public static final Align BOTTOM = null;
    public static final a Companion = null;
    public static final Align MIDDLE = null;
    public static final Align STRETCH = null;
    public static final Align TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Align[] f441154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441155b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Align a(int r100) {
            if (r100 == 0) goto L17;
            if (r100 == 1) goto L22;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L19;
            return Align.MIDDLE;
        L19:
            return Align.BASELINE;
        L20:
            return Align.STRETCH;
        L21:
            return Align.BOTTOM;
        L22:
            return Align.MIDDLE;
        L17:
            return Align.TOP;
        }
    }

    public static EnumEntries getEntries() {
        return f441155b;
    }

    static {
        Align r100 = new Align("TOP", 0, 0);
        TOP = r100;
        Align r101 = new Align("MIDDLE", 1, 1);
        MIDDLE = r101;
        Align r102 = new Align("BOTTOM", 2, 2);
        BOTTOM = r102;
        Align r103 = new Align("STRETCH", 3, 3);
        STRETCH = r103;
        Align r104 = new Align("BASELINE", 4, 4);
        BASELINE = r104;
        Align[] r105 = {r100, r101, r102, r103, r104};
        f441154a = r105;
        f441155b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static Align[] values() {
        return (Align[]) f441154a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Align valueOf(String r100) {
        return (Align) r27.a.a(Align.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public Align(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
