package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.d6;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniConversationStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "CONV_STATUS_UNKNOWN", "AVAILABLE", "CONV_STATUS_DELETED", "DISSOLVED_CAN_RECOVER", "DISSOLVED_CAN_NOT_RECOVER", "DISABLED", "HIDDEN", "ARCHIVE", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniConversationStatus extends Enum<OmniConversationStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniConversationStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("8")
    public static final OmniConversationStatus ARCHIVE = null;

    @SerialName("1")
    public static final OmniConversationStatus AVAILABLE = null;

    @SerialName("2")
    public static final OmniConversationStatus CONV_STATUS_DELETED = null;

    @SerialName("0")
    public static final OmniConversationStatus CONV_STATUS_UNKNOWN = null;
    public static final Companion Companion = null;

    @SerialName("5")
    public static final OmniConversationStatus DISABLED = null;

    @SerialName("4")
    public static final OmniConversationStatus DISSOLVED_CAN_NOT_RECOVER = null;

    @SerialName("3")
    public static final OmniConversationStatus DISSOLVED_CAN_RECOVER = null;

    @SerialName("6")
    public static final OmniConversationStatus HIDDEN = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniConversationStatus$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniConversationStatus;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniConversationStatus.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniConversationStatus> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniConversationStatus findByValue(int r100) {
            switch(r100) {
                case 0: goto L12;
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L3;
                case 8: goto L14;
                default: goto L3;
            };
        L3:
            d1.f348206b.b("enum", "OmniConversationStatus unknown value: " + r100);
            return OmniConversationStatus.CONV_STATUS_UNKNOWN;
        L14:
            return OmniConversationStatus.ARCHIVE;
        L15:
            return OmniConversationStatus.HIDDEN;
        L16:
            return OmniConversationStatus.DISABLED;
        L17:
            return OmniConversationStatus.DISSOLVED_CAN_NOT_RECOVER;
        L18:
            return OmniConversationStatus.DISSOLVED_CAN_RECOVER;
        L19:
            return OmniConversationStatus.CONV_STATUS_DELETED;
        L20:
            return OmniConversationStatus.AVAILABLE;
        L12:
            return OmniConversationStatus.CONV_STATUS_UNKNOWN;
        }
    }

    private static final /* synthetic */ OmniConversationStatus[] $values() {
        return new OmniConversationStatus[]{CONV_STATUS_UNKNOWN, AVAILABLE, CONV_STATUS_DELETED, DISSOLVED_CAN_RECOVER, DISSOLVED_CAN_NOT_RECOVER, DISABLED, HIDDEN, ARCHIVE};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniConversationStatus findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniConversationStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        CONV_STATUS_UNKNOWN = new OmniConversationStatus("CONV_STATUS_UNKNOWN", 0, 0);
        AVAILABLE = new OmniConversationStatus("AVAILABLE", 1, 1);
        CONV_STATUS_DELETED = new OmniConversationStatus("CONV_STATUS_DELETED", 2, 2);
        DISSOLVED_CAN_RECOVER = new OmniConversationStatus("DISSOLVED_CAN_RECOVER", 3, 3);
        DISSOLVED_CAN_NOT_RECOVER = new OmniConversationStatus("DISSOLVED_CAN_NOT_RECOVER", 4, 4);
        DISABLED = new OmniConversationStatus("DISABLED", 5, 5);
        HIDDEN = new OmniConversationStatus("HIDDEN", 6, 6);
        ARCHIVE = new OmniConversationStatus("ARCHIVE", 7, 8);
        OmniConversationStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new d6());
    }

    public static OmniConversationStatus[] values() {
        return (OmniConversationStatus[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniConversationStatus", values(), new String[]{"0", "1", "2", "3", "4", "5", "6", "8"}, new Annotation[][]{null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniConversationStatus valueOf(String r100) {
        return (OmniConversationStatus) a.a(OmniConversationStatus.class, r100);
    }

    private OmniConversationStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
