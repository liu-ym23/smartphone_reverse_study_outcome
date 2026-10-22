package com.larus.navigation.api.kmp;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001d"}, d2 = {"Lcom/larus/navigation/api/kmp/KmpInstructionActionType;", "", "code", "", "description", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDescription", "()Ljava/lang/String;", "UNKNOWN", "UTURN", "SHARP_RIGHT", "RIGHT", "SLIGHT_RIGHT", "STRAIGHT", "SLIGHT_LEFT", "LEFT", "SHARP_LEFT", "ARRIVE_VIA", "ARRIVE", "MOVE", "ARRIVED", "isDirection", "", "()Z", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KmpInstructionActionType extends Enum<KmpInstructionActionType> {
    public static final KmpInstructionActionType ARRIVE = null;
    public static final KmpInstructionActionType ARRIVED = null;
    public static final KmpInstructionActionType ARRIVE_VIA = null;
    public static final a Companion = null;
    public static final KmpInstructionActionType LEFT = null;
    public static final KmpInstructionActionType MOVE = null;
    public static final KmpInstructionActionType RIGHT = null;
    public static final KmpInstructionActionType SHARP_LEFT = null;
    public static final KmpInstructionActionType SHARP_RIGHT = null;
    public static final KmpInstructionActionType SLIGHT_LEFT = null;
    public static final KmpInstructionActionType SLIGHT_RIGHT = null;
    public static final KmpInstructionActionType STRAIGHT = null;
    public static final KmpInstructionActionType UNKNOWN = null;
    public static final KmpInstructionActionType UTURN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<KmpInstructionActionType> f359664a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, KmpInstructionActionType> f359665b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ KmpInstructionActionType[] f359666c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359667d = null;
    private final int code;
    private final String description;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<KmpInstructionActionType> getEntries() {
        return f359667d;
    }

    static {
        KmpInstructionActionType r100 = new KmpInstructionActionType("UNKNOWN", 0, 0, PlayerResolution.NAME.UNKNOWN);
        UNKNOWN = r100;
        KmpInstructionActionType r101 = new KmpInstructionActionType("UTURN", 1, 1, "掉头");
        UTURN = r101;
        KmpInstructionActionType r102 = new KmpInstructionActionType("SHARP_RIGHT", 2, 2, "向右后方直行");
        SHARP_RIGHT = r102;
        KmpInstructionActionType r103 = new KmpInstructionActionType("RIGHT", 3, 3, "右转");
        RIGHT = r103;
        KmpInstructionActionType r104 = new KmpInstructionActionType("SLIGHT_RIGHT", 4, 4, "向右前方直行");
        SLIGHT_RIGHT = r104;
        KmpInstructionActionType r105 = new KmpInstructionActionType("STRAIGHT", 5, 5, "直行");
        STRAIGHT = r105;
        KmpInstructionActionType r110 = new KmpInstructionActionType("SLIGHT_LEFT", 6, 6, "向左前方直行");
        SLIGHT_LEFT = r110;
        KmpInstructionActionType r111 = new KmpInstructionActionType("LEFT", 7, 7, "左转");
        LEFT = r111;
        KmpInstructionActionType r112 = new KmpInstructionActionType("SHARP_LEFT", 8, 8, "向左后方直行");
        SHARP_LEFT = r112;
        KmpInstructionActionType r113 = new KmpInstructionActionType("ARRIVE_VIA", 9, 9, "到达途经点");
        ARRIVE_VIA = r113;
        KmpInstructionActionType r106 = new KmpInstructionActionType("ARRIVE", 10, 100, "到达目的地");
        ARRIVE = r106;
        KmpInstructionActionType r107 = new KmpInstructionActionType("MOVE", 11, 101, "请到路线起点");
        MOVE = r107;
        KmpInstructionActionType r108 = new KmpInstructionActionType("ARRIVED", 12, 102, "目的地在您附近,导航结束");
        ARRIVED = r108;
        KmpInstructionActionType[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108};
        f359666c = r109;
        f359667d = EnumEntriesKt.enumEntries(r109);
        Companion = new a();
        f359664a = SetsKt.setOf(new KmpInstructionActionType[]{r101, r102, r103, r104, r105, r110, r111, r112});
        EnumEntries<KmpInstructionActionType> r114 = getEntries();
        LinkedHashMap r115 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r114, 10)), 16));
        Iterator<KmpInstructionActionType> r116 = r114.iterator();
    L4:
        if (r116.hasNext() == false) goto L6;
        KmpInstructionActionType r117 = r116.next();
        r115.put(Integer.valueOf(r117.code), r117);
        goto L4
    L6:
        f359665b = r115;
    }

    public static KmpInstructionActionType[] values() {
        return (KmpInstructionActionType[]) f359666c.clone();
    }

    public final boolean isDirection() {
        return f359664a.contains(this);
    }

    public static final /* synthetic */ Map access$getCODE_TO_ENTRY$cp() {
        return f359665b;
    }

    public static final /* synthetic */ Set access$getDIRECTIONS$cp() {
        return f359664a;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    public static KmpInstructionActionType valueOf(String r100) {
        return (KmpInstructionActionType) r27.a.a(KmpInstructionActionType.class, r100);
    }

    public KmpInstructionActionType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.description = r103;
    }
}
