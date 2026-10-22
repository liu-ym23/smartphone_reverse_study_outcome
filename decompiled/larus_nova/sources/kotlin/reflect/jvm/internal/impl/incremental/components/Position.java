package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class Position implements Serializable {
    public static final Companion Companion = null;
    private static final Position NO_POSITION = null;
    private final int column;
    private final int line;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Position getNO_POSITION() {
            return Position.access$getNO_POSITION$cp();
        }
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Position) == true) goto L8;
        return false;
    L8:
        Position r101 = (Position) r100;
        if (this.line == r101.line) goto L12;
        return false;
    L12:
        if (this.column == r101.column) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        return "Position(line=" + this.line + ", column=" + this.column + ')';
    }

    static {
        Companion = new Companion(null);
        NO_POSITION = new Position(-1, -1);
    }

    public static final /* synthetic */ Position access$getNO_POSITION$cp() {
        return NO_POSITION;
    }

    public Position(int r100, int r101) {
        this.line = r100;
        this.column = r101;
    }
}
