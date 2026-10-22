package io.ktor.websocket;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/websocket/FrameType;", "", "", "controlFrame", "Z", "getControlFrame", "()Z", "", "opcode", "I", "getOpcode", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, CardAdapter.TEXT, "BINARY", "CLOSE", "PING", "PONG", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public final enum FrameType extends Enum<FrameType> {
    public static final FrameType BINARY = null;
    public static final FrameType CLOSE = null;
    public static final a Companion = null;
    public static final FrameType PING = null;
    public static final FrameType PONG = null;
    public static final FrameType TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f492157a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FrameType[] f492158b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ FrameType[] f492159c = null;
    private final boolean controlFrame;
    private final int opcode;

    public static final class a {
        public a() {
        }
    }

    public static FrameType valueOf(String r100) {
        return (FrameType) r27.a.a(FrameType.class, r100);
    }

    public static FrameType[] values() {
        return (FrameType[]) f492159c.clone();
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    static {
        FrameType r100 = new FrameType(CardAdapter.TEXT, 0, false, 1);
        TEXT = r100;
        FrameType r101 = new FrameType("BINARY", 1, false, 2);
        BINARY = r101;
        FrameType r102 = new FrameType("CLOSE", 2, true, 8);
        CLOSE = r102;
        FrameType r103 = new FrameType("PING", 3, true, 9);
        PING = r103;
        FrameType r104 = new FrameType("PONG", 4, true, 10);
        PONG = r104;
        f492159c = new FrameType[]{r100, r101, r102, r103, r104};
        Companion = new a();
        FrameType[] r105 = values();
        if (r105.length != 0) goto L5;
        boolean r106 = true;
    L7:
        if (r106 == false) goto L9;
        FrameType r107 = null;
    L18:
        Intrinsics.checkNotNull(r107);
        int r108 = r107.opcode;
        f492157a = r108;
        int r109 = r108 + 1;
        FrameType[] r110 = new FrameType[r109];
        int r111 = 0;
    L19:
        if (r111 >= r109) goto L34;
        FrameType[] r112 = values();
        int r113 = r112.length;
        FrameType r114 = null;
        int r115 = 0;
        boolean r116 = false;
    L21:
        if (r115 >= r113) goto L31;
        FrameType r117 = r112[r115];
        if (r117.opcode != r111) goto L25;
        boolean r118 = true;
    L26:
        if (r118 == false) goto L30;
        if (r116 == true) goto L32;
        r114 = r117;
        r116 = true;
    L32:
        r114 = null;
    L33:
        r110[r111] = r114;
        r111 = r111 + 1;
    L30:
        r115 = r115 + 1;
        goto L21
    L25:
        r118 = false;
        goto L26
    L31:
        if (r116 == true) goto L33;
    L34:
        f492158b = r110;
        return;
    L9:
        r107 = r105[0];
        int r119 = ArraysKt.getLastIndex(r105);
        if (r119 == 0) goto L18;
        int r120 = r107.opcode;
        ?? r121 = new IntRange(1, r119).iterator2();
    L14:
        if (r121.hasNext() == false) goto L18;
        FrameType r122 = r105[r121.nextInt()];
        int r123 = r122.opcode;
        if (r120 >= r123) goto L14;
        r107 = r122;
        r120 = r123;
        goto L14
    L5:
        r106 = false;
        goto L7
    }

    public static final /* synthetic */ FrameType[] access$getByOpcodeArray$cp() {
        return f492158b;
    }

    public static final /* synthetic */ int access$getMaxOpcode$cp() {
        return f492157a;
    }

    public final boolean getControlFrame() {
        return this.controlFrame;
    }

    public final int getOpcode() {
        return this.opcode;
    }

    public FrameType(String r100, int r101, boolean r102, int r103) {
        super(r100, r101);
        this.controlFrame = r102;
        this.opcode = r103;
    }
}
