package com.bytedance.bdnavigationsdk.network.route;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/bdnavigationsdk/network/route/PoiType;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "AwemeLife", "S5", "Doubao", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final enum PoiType extends Enum<PoiType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PoiType[] $VALUES = null;
    private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;

    @SerialName("1")
    public static final PoiType AwemeLife = null;
    public static final a Companion = null;

    @SerialName("3")
    public static final PoiType Doubao = null;

    @SerialName("2")
    public static final PoiType S5 = null;
    private final int code;

    public static final class a {
        public a() {
        }

        public final juc.d<PoiType> serializer() {
            return (juc.d) PoiType.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<PoiType> getEntries() {
        return $ENTRIES;
    }

    static {
        PoiType r100 = new PoiType("AwemeLife", 0, 1);
        AwemeLife = r100;
        PoiType r101 = new PoiType("S5", 1, 2);
        S5 = r101;
        PoiType r102 = new PoiType("Doubao", 2, 3);
        Doubao = r102;
        PoiType[] r103 = {r100, r101, r102};
        $VALUES = r103;
        $ENTRIES = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new c());
    }

    public static PoiType[] values() {
        return (PoiType[]) $VALUES.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public final int getCode() {
        return this.code;
    }

    public static PoiType valueOf(String r100) {
        return (PoiType) r27.a.a(PoiType.class, r100);
    }

    public PoiType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
