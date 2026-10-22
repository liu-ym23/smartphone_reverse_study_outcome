package com.ss.android.lark.chat.preview.entity.component;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/Direction;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "LTR", "RTL", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Direction extends Enum<Direction> implements Serializable {
    public static final a Companion = null;
    public static final Direction LTR = null;
    public static final Direction RTL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Direction[] f416245a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f416246b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Direction a(int r100) {
            if (r100 == 0) goto L8;
            if (r100 == 1) goto L10;
            return Direction.LTR;
        L10:
            return Direction.RTL;
        L8:
            return Direction.LTR;
        }
    }

    public static EnumEntries<Direction> getEntries() {
        return f416246b;
    }

    static {
        Direction r100 = new Direction("LTR", 0, 0);
        LTR = r100;
        Direction r101 = new Direction("RTL", 1, 1);
        RTL = r101;
        Direction[] r102 = {r100, r101};
        f416245a = r102;
        f416246b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static Direction[] values() {
        return (Direction[]) f416245a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Direction valueOf(String r100) {
        return (Direction) r27.a.a(Direction.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public Direction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
