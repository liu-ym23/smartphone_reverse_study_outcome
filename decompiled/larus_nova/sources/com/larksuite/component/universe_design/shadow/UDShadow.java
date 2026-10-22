package com.larksuite.component.universe_design.shadow;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes24.dex */
@Deprecated(message = "请使用 UDShadowLayout", replaceWith = @ReplaceWith(expression = "UDShadowLayout", imports = {}))
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001b\b\u0087\u0081\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/larksuite/component/universe_design/shadow/UDShadow;", "", "value", "", "alpha", "", "size", "offsetX", "offsetY", "<init>", "(Ljava/lang/String;IIFIII)V", "getValue", "()I", "getAlpha", "()F", "getSize", "getOffsetX", "getOffsetY", UserProfileEvent.POSITION_NONE, "S_UP", "S_DOWN", "S_LEFT", "S_RIGHT", "M_UP", "M_DOWN", "M_LEFT", "M_RIGHT", "L_UP", "L_DOWN", "L_LEFT", "L_RIGHT", "Companion", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDShadow extends Enum<UDShadow> {
    public static final a Companion = null;
    public static final UDShadow L_DOWN = null;
    public static final UDShadow L_LEFT = null;
    public static final UDShadow L_RIGHT = null;
    public static final UDShadow L_UP = null;
    public static final UDShadow M_DOWN = null;
    public static final UDShadow M_LEFT = null;
    public static final UDShadow M_RIGHT = null;
    public static final UDShadow M_UP = null;
    public static final UDShadow NONE = null;
    public static final UDShadow S_DOWN = null;
    public static final UDShadow S_LEFT = null;
    public static final UDShadow S_RIGHT = null;
    public static final UDShadow S_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDShadow[] f285221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285222b = null;
    private final float alpha;
    private final int offsetX;
    private final int offsetY;
    private final int size;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<UDShadow> getEntries() {
        return f285222b;
    }

    static {
        UDShadow r100 = new UDShadow(UserProfileEvent.POSITION_NONE, 0, 0, 0.0f, 0, 0, 0);
        NONE = r100;
        UDShadow r101 = new UDShadow("S_UP", 1, 1, 0.12f, 4, 0, -2);
        S_UP = r101;
        UDShadow r102 = new UDShadow("S_DOWN", 2, 2, 0.12f, 4, 0, 2);
        S_DOWN = r102;
        UDShadow r103 = new UDShadow("S_LEFT", 3, 3, 0.12f, 4, -2, 0);
        S_LEFT = r103;
        UDShadow r104 = new UDShadow("S_RIGHT", 4, 4, 0.12f, 4, 2, 0);
        S_RIGHT = r104;
        UDShadow r105 = new UDShadow("M_UP", 5, 5, 0.1f, 8, 0, -4);
        M_UP = r105;
        UDShadow r106 = new UDShadow("M_DOWN", 6, 6, 0.1f, 8, 0, 4);
        M_DOWN = r106;
        UDShadow r107 = new UDShadow("M_LEFT", 7, 7, 0.1f, 8, -4, 0);
        M_LEFT = r107;
        UDShadow r108 = new UDShadow("M_RIGHT", 8, 8, 0.1f, 8, -4, 0);
        M_RIGHT = r108;
        UDShadow r109 = new UDShadow("L_UP", 9, 9, 0.08f, 24, 0, -6);
        L_UP = r109;
        UDShadow r110 = new UDShadow("L_DOWN", 10, 10, 0.08f, 24, 0, 6);
        L_DOWN = r110;
        UDShadow r111 = new UDShadow("L_LEFT", 11, 11, 0.08f, 24, -6, 0);
        L_LEFT = r111;
        UDShadow r210 = new UDShadow("L_RIGHT", 12, 12, 0.08f, 24, 6, 0);
        L_RIGHT = r210;
        UDShadow[] r112 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r210};
        f285221a = r112;
        f285222b = EnumEntriesKt.enumEntries(r112);
        Companion = new a();
    }

    public static UDShadow[] values() {
        return (UDShadow[]) f285221a.clone();
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final int getOffsetX() {
        return this.offsetX;
    }

    public final int getOffsetY() {
        return this.offsetY;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final UDShadow of(int r100) {
        Companion.getClass();
        switch(r100) {
            case 0: goto L19;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("no shadow for value " + r100);
    L20:
        return L_RIGHT;
    L21:
        return L_LEFT;
    L22:
        return L_DOWN;
    L23:
        return L_UP;
    L24:
        return M_RIGHT;
    L25:
        return M_LEFT;
    L26:
        return M_DOWN;
    L27:
        return M_UP;
    L28:
        return S_RIGHT;
    L29:
        return S_LEFT;
    L30:
        return S_DOWN;
    L31:
        return S_UP;
    L19:
        return NONE;
    }

    public static UDShadow valueOf(String r100) {
        return (UDShadow) r27.a.a(UDShadow.class, r100);
    }

    public UDShadow(String r100, int r101, int r102, float r103, int r104, int r105, int r106) {
        super(r100, r101);
        this.value = r102;
        this.alpha = r103;
        this.size = r104;
        this.offsetX = r105;
        this.offsetY = r106;
    }
}
