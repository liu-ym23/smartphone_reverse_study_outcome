package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.hb;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniTagPosition;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "OmniTagPosition_UNKNOWN", "OmniTagPosition_TITLE_TAG", "OmniTagPosition_AVATAR_TAG", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniTagPosition extends Enum<OmniTagPosition> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniTagPosition[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("2")
    public static final OmniTagPosition OmniTagPosition_AVATAR_TAG = null;

    @SerialName("1")
    public static final OmniTagPosition OmniTagPosition_TITLE_TAG = null;

    @SerialName("0")
    public static final OmniTagPosition OmniTagPosition_UNKNOWN = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniTagPosition$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniTagPosition;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniTagPosition.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniTagPosition> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniTagPosition findByValue(int r100) {
            if (r100 == 0) goto L11;
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L13;
            d1.f348206b.b("enum", "OmniTagPosition unknown value: " + r100);
            return OmniTagPosition.OmniTagPosition_UNKNOWN;
        L13:
            return OmniTagPosition.OmniTagPosition_AVATAR_TAG;
        L14:
            return OmniTagPosition.OmniTagPosition_TITLE_TAG;
        L11:
            return OmniTagPosition.OmniTagPosition_UNKNOWN;
        }
    }

    private static final /* synthetic */ OmniTagPosition[] $values() {
        return new OmniTagPosition[]{OmniTagPosition_UNKNOWN, OmniTagPosition_TITLE_TAG, OmniTagPosition_AVATAR_TAG};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniTagPosition findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniTagPosition> getEntries() {
        return $ENTRIES;
    }

    static {
        OmniTagPosition_UNKNOWN = new OmniTagPosition("OmniTagPosition_UNKNOWN", 0, 0);
        OmniTagPosition_TITLE_TAG = new OmniTagPosition("OmniTagPosition_TITLE_TAG", 1, 1);
        OmniTagPosition_AVATAR_TAG = new OmniTagPosition("OmniTagPosition_AVATAR_TAG", 2, 2);
        OmniTagPosition[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new hb());
    }

    public static OmniTagPosition[] values() {
        return (OmniTagPosition[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniTagPosition", values(), new String[]{"0", "1", "2"}, new Annotation[][]{null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniTagPosition valueOf(String r100) {
        return (OmniTagPosition) a.a(OmniTagPosition.class, r100);
    }

    private OmniTagPosition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
