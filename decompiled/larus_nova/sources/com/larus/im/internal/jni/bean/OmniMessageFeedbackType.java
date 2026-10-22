package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.r8;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageFeedbackType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "OmniMessageFeedbackType_DEFAULT", "OmniMessageFeedbackType_LIKE", "OmniMessageFeedbackType_DISLIKE", "OmniMessageFeedbackType_BETTER", "OmniMessageFeedbackType_ALMOST", "OmniMessageFeedbackType_BOTH_BAD", "OmniMessageFeedbackType_FORM", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniMessageFeedbackType extends Enum<OmniMessageFeedbackType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniMessageFeedbackType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("4")
    public static final OmniMessageFeedbackType OmniMessageFeedbackType_ALMOST = null;

    @SerialName("3")
    public static final OmniMessageFeedbackType OmniMessageFeedbackType_BETTER = null;

    @SerialName("5")
    public static final OmniMessageFeedbackType OmniMessageFeedbackType_BOTH_BAD = null;

    @SerialName("0")
    public static final OmniMessageFeedbackType OmniMessageFeedbackType_DEFAULT = null;

    @SerialName("2")
    public static final OmniMessageFeedbackType OmniMessageFeedbackType_DISLIKE = null;

    @SerialName("6")
    public static final OmniMessageFeedbackType OmniMessageFeedbackType_FORM = null;

    @SerialName("1")
    public static final OmniMessageFeedbackType OmniMessageFeedbackType_LIKE = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageFeedbackType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniMessageFeedbackType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniMessageFeedbackType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniMessageFeedbackType> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniMessageFeedbackType findByValue(int r100) {
            switch(r100) {
                case 0: goto L11;
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                default: goto L3;
            };
        L3:
            d1.f348206b.b("enum", "OmniMessageFeedbackType unknown value: " + r100);
            return OmniMessageFeedbackType.OmniMessageFeedbackType_DEFAULT;
        L13:
            return OmniMessageFeedbackType.OmniMessageFeedbackType_FORM;
        L14:
            return OmniMessageFeedbackType.OmniMessageFeedbackType_BOTH_BAD;
        L15:
            return OmniMessageFeedbackType.OmniMessageFeedbackType_ALMOST;
        L16:
            return OmniMessageFeedbackType.OmniMessageFeedbackType_BETTER;
        L17:
            return OmniMessageFeedbackType.OmniMessageFeedbackType_DISLIKE;
        L18:
            return OmniMessageFeedbackType.OmniMessageFeedbackType_LIKE;
        L11:
            return OmniMessageFeedbackType.OmniMessageFeedbackType_DEFAULT;
        }
    }

    private static final /* synthetic */ OmniMessageFeedbackType[] $values() {
        return new OmniMessageFeedbackType[]{OmniMessageFeedbackType_DEFAULT, OmniMessageFeedbackType_LIKE, OmniMessageFeedbackType_DISLIKE, OmniMessageFeedbackType_BETTER, OmniMessageFeedbackType_ALMOST, OmniMessageFeedbackType_BOTH_BAD, OmniMessageFeedbackType_FORM};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniMessageFeedbackType findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniMessageFeedbackType> getEntries() {
        return $ENTRIES;
    }

    static {
        OmniMessageFeedbackType_DEFAULT = new OmniMessageFeedbackType("OmniMessageFeedbackType_DEFAULT", 0, 0);
        OmniMessageFeedbackType_LIKE = new OmniMessageFeedbackType("OmniMessageFeedbackType_LIKE", 1, 1);
        OmniMessageFeedbackType_DISLIKE = new OmniMessageFeedbackType("OmniMessageFeedbackType_DISLIKE", 2, 2);
        OmniMessageFeedbackType_BETTER = new OmniMessageFeedbackType("OmniMessageFeedbackType_BETTER", 3, 3);
        OmniMessageFeedbackType_ALMOST = new OmniMessageFeedbackType("OmniMessageFeedbackType_ALMOST", 4, 4);
        OmniMessageFeedbackType_BOTH_BAD = new OmniMessageFeedbackType("OmniMessageFeedbackType_BOTH_BAD", 5, 5);
        OmniMessageFeedbackType_FORM = new OmniMessageFeedbackType("OmniMessageFeedbackType_FORM", 6, 6);
        OmniMessageFeedbackType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new r8());
    }

    public static OmniMessageFeedbackType[] values() {
        return (OmniMessageFeedbackType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniMessageFeedbackType", values(), new String[]{"0", "1", "2", "3", "4", "5", "6"}, new Annotation[][]{null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniMessageFeedbackType valueOf(String r100) {
        return (OmniMessageFeedbackType) a.a(OmniMessageFeedbackType.class, r100);
    }

    private OmniMessageFeedbackType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
