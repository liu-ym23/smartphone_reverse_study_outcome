package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.jb;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniTagType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "OmniTagType_UNKNOWN", "OmniTagType_KEY_SELECTED", "OmniTagType_ENTERPRISE", "OmniTagType_OFFICIAL", "OmniTagType_CALL_DIRECT", "OmniTagType_ABILITY", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniTagType extends Enum<OmniTagType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniTagType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("5")
    public static final OmniTagType OmniTagType_ABILITY = null;

    @SerialName("4")
    public static final OmniTagType OmniTagType_CALL_DIRECT = null;

    @SerialName("2")
    public static final OmniTagType OmniTagType_ENTERPRISE = null;

    @SerialName("1")
    public static final OmniTagType OmniTagType_KEY_SELECTED = null;

    @SerialName("3")
    public static final OmniTagType OmniTagType_OFFICIAL = null;

    @SerialName("0")
    public static final OmniTagType OmniTagType_UNKNOWN = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniTagType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniTagType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniTagType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniTagType> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniTagType findByValue(int r100) {
            if (r100 == 0) goto L20;
            if (r100 == 1) goto L26;
            if (r100 == 2) goto L25;
            if (r100 == 3) goto L24;
            if (r100 == 4) goto L23;
            if (r100 == 5) goto L22;
            d1.f348206b.b("enum", "OmniTagType unknown value: " + r100);
            return OmniTagType.OmniTagType_UNKNOWN;
        L22:
            return OmniTagType.OmniTagType_ABILITY;
        L23:
            return OmniTagType.OmniTagType_CALL_DIRECT;
        L24:
            return OmniTagType.OmniTagType_OFFICIAL;
        L25:
            return OmniTagType.OmniTagType_ENTERPRISE;
        L26:
            return OmniTagType.OmniTagType_KEY_SELECTED;
        L20:
            return OmniTagType.OmniTagType_UNKNOWN;
        }
    }

    private static final /* synthetic */ OmniTagType[] $values() {
        return new OmniTagType[]{OmniTagType_UNKNOWN, OmniTagType_KEY_SELECTED, OmniTagType_ENTERPRISE, OmniTagType_OFFICIAL, OmniTagType_CALL_DIRECT, OmniTagType_ABILITY};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniTagType findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniTagType> getEntries() {
        return $ENTRIES;
    }

    static {
        OmniTagType_UNKNOWN = new OmniTagType("OmniTagType_UNKNOWN", 0, 0);
        OmniTagType_KEY_SELECTED = new OmniTagType("OmniTagType_KEY_SELECTED", 1, 1);
        OmniTagType_ENTERPRISE = new OmniTagType("OmniTagType_ENTERPRISE", 2, 2);
        OmniTagType_OFFICIAL = new OmniTagType("OmniTagType_OFFICIAL", 3, 3);
        OmniTagType_CALL_DIRECT = new OmniTagType("OmniTagType_CALL_DIRECT", 4, 4);
        OmniTagType_ABILITY = new OmniTagType("OmniTagType_ABILITY", 5, 5);
        OmniTagType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new jb());
    }

    public static OmniTagType[] values() {
        return (OmniTagType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniTagType", values(), new String[]{"0", "1", "2", "3", "4", "5"}, new Annotation[][]{null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniTagType valueOf(String r100) {
        return (OmniTagType) a.a(OmniTagType.class, r100);
    }

    private OmniTagType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
