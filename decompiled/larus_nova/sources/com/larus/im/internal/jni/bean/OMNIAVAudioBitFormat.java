package com.larus.im.internal.jni.bean;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.im.internal.delegate.d1;
import com.tencent.connect.common.Constants;
import de9.v;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVAudioBitFormat;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "PCM_FORMAT_UNKNOWN", "PCM_FORMAT_INT16", "PCM_FORMAT_INT24", "PCM_FORMAT_INT32", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OMNIAVAudioBitFormat extends Enum<OMNIAVAudioBitFormat> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OMNIAVAudioBitFormat[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName(Constants.VIA_REPORT_TYPE_START_WAP)
    public static final OMNIAVAudioBitFormat PCM_FORMAT_INT16 = null;

    @SerialName("24")
    public static final OMNIAVAudioBitFormat PCM_FORMAT_INT24 = null;

    @SerialName(BDLocationException.ERROR_CONNECT_GOOGLE_FAIL)
    public static final OMNIAVAudioBitFormat PCM_FORMAT_INT32 = null;

    @SerialName("0")
    public static final OMNIAVAudioBitFormat PCM_FORMAT_UNKNOWN = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVAudioBitFormat$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OMNIAVAudioBitFormat;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OMNIAVAudioBitFormat.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OMNIAVAudioBitFormat> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OMNIAVAudioBitFormat findByValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 16) goto L18;
            if (r100 == 24) goto L17;
            if (r100 == 32) goto L16;
            d1.f348206b.b("enum", "OMNIAVAudioBitFormat unknown value: " + r100);
            return OMNIAVAudioBitFormat.PCM_FORMAT_UNKNOWN;
        L16:
            return OMNIAVAudioBitFormat.PCM_FORMAT_INT32;
        L17:
            return OMNIAVAudioBitFormat.PCM_FORMAT_INT24;
        L18:
            return OMNIAVAudioBitFormat.PCM_FORMAT_INT16;
        L14:
            return OMNIAVAudioBitFormat.PCM_FORMAT_UNKNOWN;
        }
    }

    private static final /* synthetic */ OMNIAVAudioBitFormat[] $values() {
        return new OMNIAVAudioBitFormat[]{PCM_FORMAT_UNKNOWN, PCM_FORMAT_INT16, PCM_FORMAT_INT24, PCM_FORMAT_INT32};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OMNIAVAudioBitFormat findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OMNIAVAudioBitFormat> getEntries() {
        return $ENTRIES;
    }

    static {
        PCM_FORMAT_UNKNOWN = new OMNIAVAudioBitFormat("PCM_FORMAT_UNKNOWN", 0, 0);
        PCM_FORMAT_INT16 = new OMNIAVAudioBitFormat("PCM_FORMAT_INT16", 1, 16);
        PCM_FORMAT_INT24 = new OMNIAVAudioBitFormat("PCM_FORMAT_INT24", 2, 24);
        PCM_FORMAT_INT32 = new OMNIAVAudioBitFormat("PCM_FORMAT_INT32", 3, 32);
        OMNIAVAudioBitFormat[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new v());
    }

    public static OMNIAVAudioBitFormat[] values() {
        return (OMNIAVAudioBitFormat[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OMNIAVAudioBitFormat", values(), new String[]{"0", Constants.VIA_REPORT_TYPE_START_WAP, "24", BDLocationException.ERROR_CONNECT_GOOGLE_FAIL}, new Annotation[][]{null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OMNIAVAudioBitFormat valueOf(String r100) {
        return (OMNIAVAudioBitFormat) a.a(OMNIAVAudioBitFormat.class, r100);
    }

    private OMNIAVAudioBitFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
