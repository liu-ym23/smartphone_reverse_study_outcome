package com.bytedance.android.shopping.store.hybridproduct.dto;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/dto/Position;", "", "", "direction", "I", "getDirection", "()I", "Companion", "a", "LEFT", "RIGHT", "TOP", "BOTTOM", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Position extends Enum<Position> {
    public static final Position BOTTOM = null;
    public static final a Companion = null;
    public static final Position LEFT = null;
    public static final Position RIGHT = null;
    public static final Position TOP = null;
    public static final /* synthetic */ Position[] a = null;
    private final int direction;

    public static final class a {
        public a() {
        }
    }

    static {
        Position r2 = new Position("LEFT", 0, 1);
        LEFT = r2;
        Position r3 = new Position("RIGHT", 1, 2);
        RIGHT = r3;
        Position r4 = new Position("TOP", 2, 3);
        TOP = r4;
        Position r5 = new Position("BOTTOM", 3, 4);
        BOTTOM = r5;
        a = new Position[]{r2, r3, r4, r5};
        Companion = new a();
    }

    public static Position valueOf(String r1) {
        return (Position) r27.a.a(Position.class, r1);
    }

    public static Position[] values() {
        return (Position[]) a.clone();
    }

    public final int getDirection() {
        return this.direction;
    }

    public Position(String r1, int r2, int r3) {
        super(r1, r2);
        this.direction = r3;
    }
}
