package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.o2;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVVideoFrameBufferType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RawMemory", "CvPixelBuffer", "GlTexture", "GLTextureOES", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OMNIAVVideoFrameBufferType extends Enum<OMNIAVVideoFrameBufferType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OMNIAVVideoFrameBufferType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("1")
    public static final OMNIAVVideoFrameBufferType CvPixelBuffer = null;

    @SerialName("3")
    public static final OMNIAVVideoFrameBufferType GLTextureOES = null;

    @SerialName("2")
    public static final OMNIAVVideoFrameBufferType GlTexture = null;

    @SerialName("0")
    public static final OMNIAVVideoFrameBufferType RawMemory = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVVideoFrameBufferType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OMNIAVVideoFrameBufferType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OMNIAVVideoFrameBufferType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OMNIAVVideoFrameBufferType> serializer() {
            return get$cachedSerializer();
        }

        public final OMNIAVVideoFrameBufferType findByValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L18;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L16;
            d1.f348206b.b("enum", "OMNIAVVideoFrameBufferType unknown value: " + r100);
            return OMNIAVVideoFrameBufferType.RawMemory;
        L16:
            return OMNIAVVideoFrameBufferType.GLTextureOES;
        L17:
            return OMNIAVVideoFrameBufferType.GlTexture;
        L18:
            return OMNIAVVideoFrameBufferType.CvPixelBuffer;
        L14:
            return OMNIAVVideoFrameBufferType.RawMemory;
        }
    }

    private static final /* synthetic */ OMNIAVVideoFrameBufferType[] $values() {
        return new OMNIAVVideoFrameBufferType[]{RawMemory, CvPixelBuffer, GlTexture, GLTextureOES};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<OMNIAVVideoFrameBufferType> getEntries() {
        return $ENTRIES;
    }

    static {
        RawMemory = new OMNIAVVideoFrameBufferType("RawMemory", 0, 0);
        CvPixelBuffer = new OMNIAVVideoFrameBufferType("CvPixelBuffer", 1, 1);
        GlTexture = new OMNIAVVideoFrameBufferType("GlTexture", 2, 2);
        GLTextureOES = new OMNIAVVideoFrameBufferType("GLTextureOES", 3, 3);
        OMNIAVVideoFrameBufferType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new o2());
    }

    public static OMNIAVVideoFrameBufferType[] values() {
        return (OMNIAVVideoFrameBufferType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OMNIAVVideoFrameBufferType", values(), new String[]{"0", "1", "2", "3"}, new Annotation[][]{null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public final int getValue() {
        return this.value;
    }

    public static OMNIAVVideoFrameBufferType valueOf(String r100) {
        return (OMNIAVVideoFrameBufferType) a.a(OMNIAVVideoFrameBufferType.class, r100);
    }

    private OMNIAVVideoFrameBufferType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
