package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/json/DecodeSequenceMode;", "", "<init>", "(Ljava/lang/String;I)V", "WHITESPACE_SEPARATED", "ARRAY_WRAPPED", "AUTO_DETECT", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
public final enum DecodeSequenceMode extends Enum<DecodeSequenceMode> {
    public static final DecodeSequenceMode ARRAY_WRAPPED = null;
    public static final DecodeSequenceMode AUTO_DETECT = null;
    public static final DecodeSequenceMode WHITESPACE_SEPARATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodeSequenceMode[] f505370a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f505371b = null;

    public static EnumEntries<DecodeSequenceMode> getEntries() {
        return f505371b;
    }

    static {
        DecodeSequenceMode r100 = new DecodeSequenceMode("WHITESPACE_SEPARATED", 0);
        WHITESPACE_SEPARATED = r100;
        DecodeSequenceMode r101 = new DecodeSequenceMode("ARRAY_WRAPPED", 1);
        ARRAY_WRAPPED = r101;
        DecodeSequenceMode r102 = new DecodeSequenceMode("AUTO_DETECT", 2);
        AUTO_DETECT = r102;
        DecodeSequenceMode[] r103 = {r100, r101, r102};
        f505370a = r103;
        f505371b = EnumEntriesKt.enumEntries(r103);
    }

    public static DecodeSequenceMode[] values() {
        return (DecodeSequenceMode[]) f505370a.clone();
    }

    public static DecodeSequenceMode valueOf(String r100) {
        return (DecodeSequenceMode) a.a(DecodeSequenceMode.class, r100);
    }

    public DecodeSequenceMode(String r100, int r101) {
        super(r100, r101);
    }
}
