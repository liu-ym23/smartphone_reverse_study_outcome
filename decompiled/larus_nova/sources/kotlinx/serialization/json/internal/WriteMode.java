package kotlinx.serialization.json.internal;

import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\f\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkotlinx/serialization/json/internal/WriteMode;", "", GearStrategyConsts.EV_SELECT_BEGIN, "", "end", "<init>", "(Ljava/lang/String;ICC)V", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WriteMode extends Enum<WriteMode> {
    public static final WriteMode LIST = null;
    public static final WriteMode MAP = null;
    public static final WriteMode OBJ = null;
    public static final WriteMode POLY_OBJ = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WriteMode[] f505374a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f505375b = null;
    public final char begin;
    public final char end;

    public static EnumEntries<WriteMode> getEntries() {
        return f505375b;
    }

    static {
        WriteMode r100 = new WriteMode("OBJ", 0, '{', '}');
        OBJ = r100;
        WriteMode r101 = new WriteMode("LIST", 1, '[', ']');
        LIST = r101;
        WriteMode r102 = new WriteMode("MAP", 2, '{', '}');
        MAP = r102;
        WriteMode r103 = new WriteMode("POLY_OBJ", 3, '[', ']');
        POLY_OBJ = r103;
        WriteMode[] r104 = {r100, r101, r102, r103};
        f505374a = r104;
        f505375b = EnumEntriesKt.enumEntries(r104);
    }

    public static WriteMode[] values() {
        return (WriteMode[]) f505374a.clone();
    }

    public static WriteMode valueOf(String r100) {
        return (WriteMode) r27.a.a(WriteMode.class, r100);
    }

    public WriteMode(String r100, int r101, char r102, char r103) {
        super(r100, r101);
        this.begin = r102;
        this.end = r103;
    }
}
