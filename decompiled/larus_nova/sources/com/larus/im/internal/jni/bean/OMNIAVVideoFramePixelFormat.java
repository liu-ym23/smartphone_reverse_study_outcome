package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.r2;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVVideoFramePixelFormat;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PixelFormatUnknown", "PixelFormatI420", "PixelFormatNV12", "PixelFormatNV21", "PixelFormatRGB24", "PixelFormatRGBA", "PixelFormatARGB", "PixelFormatBGRA", "PixelFormatTexture2D", "PixelFormatOesTexture", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OMNIAVVideoFramePixelFormat extends Enum<OMNIAVVideoFramePixelFormat> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OMNIAVVideoFramePixelFormat[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("6")
    public static final OMNIAVVideoFramePixelFormat PixelFormatARGB = null;

    @SerialName("7")
    public static final OMNIAVVideoFramePixelFormat PixelFormatBGRA = null;

    @SerialName("1")
    public static final OMNIAVVideoFramePixelFormat PixelFormatI420 = null;

    @SerialName("2")
    public static final OMNIAVVideoFramePixelFormat PixelFormatNV12 = null;

    @SerialName("3")
    public static final OMNIAVVideoFramePixelFormat PixelFormatNV21 = null;

    @SerialName("36197")
    public static final OMNIAVVideoFramePixelFormat PixelFormatOesTexture = null;

    @SerialName("4")
    public static final OMNIAVVideoFramePixelFormat PixelFormatRGB24 = null;

    @SerialName("5")
    public static final OMNIAVVideoFramePixelFormat PixelFormatRGBA = null;

    @SerialName("3553")
    public static final OMNIAVVideoFramePixelFormat PixelFormatTexture2D = null;

    @SerialName("0")
    public static final OMNIAVVideoFramePixelFormat PixelFormatUnknown = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVVideoFramePixelFormat$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OMNIAVVideoFramePixelFormat;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OMNIAVVideoFramePixelFormat.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OMNIAVVideoFramePixelFormat> serializer() {
            return get$cachedSerializer();
        }

        public final OMNIAVVideoFramePixelFormat findByValue(int r100) {
            if (r100 == 3553) goto L18;
            if (r100 == 36197) goto L28;
            switch(r100) {
                case 0: goto L27;
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                default: goto L7;
            };
        L7:
            d1.f348206b.b("enum", "OMNIAVVideoFramePixelFormat unknown value: " + r100);
            return OMNIAVVideoFramePixelFormat.PixelFormatUnknown;
        L20:
            return OMNIAVVideoFramePixelFormat.PixelFormatBGRA;
        L21:
            return OMNIAVVideoFramePixelFormat.PixelFormatARGB;
        L22:
            return OMNIAVVideoFramePixelFormat.PixelFormatRGBA;
        L23:
            return OMNIAVVideoFramePixelFormat.PixelFormatRGB24;
        L24:
            return OMNIAVVideoFramePixelFormat.PixelFormatNV21;
        L25:
            return OMNIAVVideoFramePixelFormat.PixelFormatNV12;
        L26:
            return OMNIAVVideoFramePixelFormat.PixelFormatI420;
        L27:
            return OMNIAVVideoFramePixelFormat.PixelFormatUnknown;
        L28:
            return OMNIAVVideoFramePixelFormat.PixelFormatOesTexture;
        L18:
            return OMNIAVVideoFramePixelFormat.PixelFormatTexture2D;
        }
    }

    private static final /* synthetic */ OMNIAVVideoFramePixelFormat[] $values() {
        return new OMNIAVVideoFramePixelFormat[]{PixelFormatUnknown, PixelFormatI420, PixelFormatNV12, PixelFormatNV21, PixelFormatRGB24, PixelFormatRGBA, PixelFormatARGB, PixelFormatBGRA, PixelFormatTexture2D, PixelFormatOesTexture};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<OMNIAVVideoFramePixelFormat> getEntries() {
        return $ENTRIES;
    }

    static {
        PixelFormatUnknown = new OMNIAVVideoFramePixelFormat("PixelFormatUnknown", 0, 0);
        PixelFormatI420 = new OMNIAVVideoFramePixelFormat("PixelFormatI420", 1, 1);
        PixelFormatNV12 = new OMNIAVVideoFramePixelFormat("PixelFormatNV12", 2, 2);
        PixelFormatNV21 = new OMNIAVVideoFramePixelFormat("PixelFormatNV21", 3, 3);
        PixelFormatRGB24 = new OMNIAVVideoFramePixelFormat("PixelFormatRGB24", 4, 4);
        PixelFormatRGBA = new OMNIAVVideoFramePixelFormat("PixelFormatRGBA", 5, 5);
        PixelFormatARGB = new OMNIAVVideoFramePixelFormat("PixelFormatARGB", 6, 6);
        PixelFormatBGRA = new OMNIAVVideoFramePixelFormat("PixelFormatBGRA", 7, 7);
        PixelFormatTexture2D = new OMNIAVVideoFramePixelFormat("PixelFormatTexture2D", 8, 3553);
        PixelFormatOesTexture = new OMNIAVVideoFramePixelFormat("PixelFormatOesTexture", 9, 36197);
        OMNIAVVideoFramePixelFormat[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new r2());
    }

    public static OMNIAVVideoFramePixelFormat[] values() {
        return (OMNIAVVideoFramePixelFormat[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OMNIAVVideoFramePixelFormat", values(), new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "3553", "36197"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public final int getValue() {
        return this.value;
    }

    public static OMNIAVVideoFramePixelFormat valueOf(String r100) {
        return (OMNIAVVideoFramePixelFormat) a.a(OMNIAVVideoFramePixelFormat.class, r100);
    }

    private OMNIAVVideoFramePixelFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
