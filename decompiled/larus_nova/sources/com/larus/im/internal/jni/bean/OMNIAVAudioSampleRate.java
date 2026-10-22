package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.b0;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVAudioSampleRate;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "RATE_UNKNOWN", "RATE_16000", "RATE_24000", "RATE_32000", "RATE_48000", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OMNIAVAudioSampleRate extends Enum<OMNIAVAudioSampleRate> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OMNIAVAudioSampleRate[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("16000")
    public static final OMNIAVAudioSampleRate RATE_16000 = null;

    @SerialName("24000")
    public static final OMNIAVAudioSampleRate RATE_24000 = null;

    @SerialName("32000")
    public static final OMNIAVAudioSampleRate RATE_32000 = null;

    @SerialName("48000")
    public static final OMNIAVAudioSampleRate RATE_48000 = null;

    @SerialName("0")
    public static final OMNIAVAudioSampleRate RATE_UNKNOWN = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVAudioSampleRate$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OMNIAVAudioSampleRate;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OMNIAVAudioSampleRate.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OMNIAVAudioSampleRate> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OMNIAVAudioSampleRate findByValue(int r100) {
            if (r100 == 0) goto L17;
            if (r100 == 16000) goto L22;
            if (r100 == 24000) goto L21;
            if (r100 == 32000) goto L20;
            if (r100 == 48000) goto L19;
            d1.f348206b.b("enum", "OMNIAVAudioSampleRate unknown value: " + r100);
            return OMNIAVAudioSampleRate.RATE_UNKNOWN;
        L19:
            return OMNIAVAudioSampleRate.RATE_48000;
        L20:
            return OMNIAVAudioSampleRate.RATE_32000;
        L21:
            return OMNIAVAudioSampleRate.RATE_24000;
        L22:
            return OMNIAVAudioSampleRate.RATE_16000;
        L17:
            return OMNIAVAudioSampleRate.RATE_UNKNOWN;
        }
    }

    private static final /* synthetic */ OMNIAVAudioSampleRate[] $values() {
        return new OMNIAVAudioSampleRate[]{RATE_UNKNOWN, RATE_16000, RATE_24000, RATE_32000, RATE_48000};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OMNIAVAudioSampleRate findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OMNIAVAudioSampleRate> getEntries() {
        return $ENTRIES;
    }

    static {
        RATE_UNKNOWN = new OMNIAVAudioSampleRate("RATE_UNKNOWN", 0, 0);
        RATE_16000 = new OMNIAVAudioSampleRate("RATE_16000", 1, 16000);
        RATE_24000 = new OMNIAVAudioSampleRate("RATE_24000", 2, 24000);
        RATE_32000 = new OMNIAVAudioSampleRate("RATE_32000", 3, 32000);
        RATE_48000 = new OMNIAVAudioSampleRate("RATE_48000", 4, 48000);
        OMNIAVAudioSampleRate[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new b0());
    }

    public static OMNIAVAudioSampleRate[] values() {
        return (OMNIAVAudioSampleRate[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OMNIAVAudioSampleRate", values(), new String[]{"0", "16000", "24000", "32000", "48000"}, new Annotation[][]{null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OMNIAVAudioSampleRate valueOf(String r100) {
        return (OMNIAVAudioSampleRate) a.a(OMNIAVAudioSampleRate.class, r100);
    }

    private OMNIAVAudioSampleRate(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
