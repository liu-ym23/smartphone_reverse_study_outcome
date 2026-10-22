package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.b6;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniConversationReviewStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "REVIEW_STATUS_UNKNOWN", "REVIEW_STATUS_PENDING", "REVIEW_STATUS_APPROVED", "REVIEW_STATUS_REJECTED", "REVIEW_STATUS_BAN", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniConversationReviewStatus extends Enum<OmniConversationReviewStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniConversationReviewStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("2")
    public static final OmniConversationReviewStatus REVIEW_STATUS_APPROVED = null;

    @SerialName("4")
    public static final OmniConversationReviewStatus REVIEW_STATUS_BAN = null;

    @SerialName("1")
    public static final OmniConversationReviewStatus REVIEW_STATUS_PENDING = null;

    @SerialName("3")
    public static final OmniConversationReviewStatus REVIEW_STATUS_REJECTED = null;

    @SerialName("0")
    public static final OmniConversationReviewStatus REVIEW_STATUS_UNKNOWN = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniConversationReviewStatus$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniConversationReviewStatus;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniConversationReviewStatus.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniConversationReviewStatus> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniConversationReviewStatus findByValue(int r100) {
            if (r100 == 0) goto L17;
            if (r100 == 1) goto L22;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L19;
            d1.f348206b.b("enum", "OmniConversationReviewStatus unknown value: " + r100);
            return OmniConversationReviewStatus.REVIEW_STATUS_UNKNOWN;
        L19:
            return OmniConversationReviewStatus.REVIEW_STATUS_BAN;
        L20:
            return OmniConversationReviewStatus.REVIEW_STATUS_REJECTED;
        L21:
            return OmniConversationReviewStatus.REVIEW_STATUS_APPROVED;
        L22:
            return OmniConversationReviewStatus.REVIEW_STATUS_PENDING;
        L17:
            return OmniConversationReviewStatus.REVIEW_STATUS_UNKNOWN;
        }
    }

    private static final /* synthetic */ OmniConversationReviewStatus[] $values() {
        return new OmniConversationReviewStatus[]{REVIEW_STATUS_UNKNOWN, REVIEW_STATUS_PENDING, REVIEW_STATUS_APPROVED, REVIEW_STATUS_REJECTED, REVIEW_STATUS_BAN};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniConversationReviewStatus findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniConversationReviewStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        REVIEW_STATUS_UNKNOWN = new OmniConversationReviewStatus("REVIEW_STATUS_UNKNOWN", 0, 0);
        REVIEW_STATUS_PENDING = new OmniConversationReviewStatus("REVIEW_STATUS_PENDING", 1, 1);
        REVIEW_STATUS_APPROVED = new OmniConversationReviewStatus("REVIEW_STATUS_APPROVED", 2, 2);
        REVIEW_STATUS_REJECTED = new OmniConversationReviewStatus("REVIEW_STATUS_REJECTED", 3, 3);
        REVIEW_STATUS_BAN = new OmniConversationReviewStatus("REVIEW_STATUS_BAN", 4, 4);
        OmniConversationReviewStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new b6());
    }

    public static OmniConversationReviewStatus[] values() {
        return (OmniConversationReviewStatus[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniConversationReviewStatus", values(), new String[]{"0", "1", "2", "3", "4"}, new Annotation[][]{null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniConversationReviewStatus valueOf(String r100) {
        return (OmniConversationReviewStatus) a.a(OmniConversationReviewStatus.class, r100);
    }

    private OmniConversationReviewStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
