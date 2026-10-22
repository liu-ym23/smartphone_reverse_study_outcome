package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.t1;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVSessionMediaType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "PURE_RTC", "PURE_BIZ", "PURE_AV", "MIX_SPEECH_AND_BIZ", "PURE_OMNI", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OMNIAVSessionMediaType extends Enum<OMNIAVSessionMediaType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OMNIAVSessionMediaType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("3")
    public static final OMNIAVSessionMediaType MIX_SPEECH_AND_BIZ = null;

    @SerialName("2")
    public static final OMNIAVSessionMediaType PURE_AV = null;

    @SerialName("1")
    public static final OMNIAVSessionMediaType PURE_BIZ = null;

    @SerialName("4")
    public static final OMNIAVSessionMediaType PURE_OMNI = null;

    @SerialName("0")
    public static final OMNIAVSessionMediaType PURE_RTC = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVSessionMediaType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionMediaType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OMNIAVSessionMediaType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OMNIAVSessionMediaType> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OMNIAVSessionMediaType findByValue(int r100) {
            if (r100 == 0) goto L17;
            if (r100 == 1) goto L22;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L19;
            d1.f348206b.b("enum", "OMNIAVSessionMediaType unknown value: " + r100);
            return OMNIAVSessionMediaType.PURE_RTC;
        L19:
            return OMNIAVSessionMediaType.PURE_OMNI;
        L20:
            return OMNIAVSessionMediaType.MIX_SPEECH_AND_BIZ;
        L21:
            return OMNIAVSessionMediaType.PURE_AV;
        L22:
            return OMNIAVSessionMediaType.PURE_BIZ;
        L17:
            return OMNIAVSessionMediaType.PURE_RTC;
        }
    }

    private static final /* synthetic */ OMNIAVSessionMediaType[] $values() {
        return new OMNIAVSessionMediaType[]{PURE_RTC, PURE_BIZ, PURE_AV, MIX_SPEECH_AND_BIZ, PURE_OMNI};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OMNIAVSessionMediaType findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OMNIAVSessionMediaType> getEntries() {
        return $ENTRIES;
    }

    static {
        PURE_RTC = new OMNIAVSessionMediaType("PURE_RTC", 0, 0);
        PURE_BIZ = new OMNIAVSessionMediaType("PURE_BIZ", 1, 1);
        PURE_AV = new OMNIAVSessionMediaType("PURE_AV", 2, 2);
        MIX_SPEECH_AND_BIZ = new OMNIAVSessionMediaType("MIX_SPEECH_AND_BIZ", 3, 3);
        PURE_OMNI = new OMNIAVSessionMediaType("PURE_OMNI", 4, 4);
        OMNIAVSessionMediaType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new t1());
    }

    public static OMNIAVSessionMediaType[] values() {
        return (OMNIAVSessionMediaType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OMNIAVSessionMediaType", values(), new String[]{"0", "1", "2", "3", "4"}, new Annotation[][]{null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OMNIAVSessionMediaType valueOf(String r100) {
        return (OMNIAVSessionMediaType) a.a(OMNIAVSessionMediaType.class, r100);
    }

    private OMNIAVSessionMediaType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
