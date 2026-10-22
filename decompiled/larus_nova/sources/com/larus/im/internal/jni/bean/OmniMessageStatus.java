package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import com.tencent.connect.common.Constants;
import de9.f9;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "MessageStatus_AVAILABLE", "MessageStatus_INVISIBLE", "MessageStatus_NOT_EXIST", "MessageStatus_DELETED", "MessageStatus_EDITED", "MessageStatus_BEFOREEDIT", "MessageStatus_REGEN_ROOT", "MessageStatus_UNSELECTED", "MessageStatus_REGENATED", "MessageStatus_NotCompliant", "MessageStatus_PLACE_HOLD", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniMessageStatus extends Enum<OmniMessageStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniMessageStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("0")
    public static final OmniMessageStatus MessageStatus_AVAILABLE = null;

    @SerialName("7")
    public static final OmniMessageStatus MessageStatus_BEFOREEDIT = null;

    @SerialName("5")
    public static final OmniMessageStatus MessageStatus_DELETED = null;

    @SerialName("6")
    public static final OmniMessageStatus MessageStatus_EDITED = null;

    @SerialName("1")
    public static final OmniMessageStatus MessageStatus_INVISIBLE = null;

    @SerialName("3")
    public static final OmniMessageStatus MessageStatus_NOT_EXIST = null;

    @SerialName("11")
    public static final OmniMessageStatus MessageStatus_NotCompliant = null;

    @SerialName(Constants.VIA_ACT_TYPE_NINETEEN)
    public static final OmniMessageStatus MessageStatus_PLACE_HOLD = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final OmniMessageStatus MessageStatus_REGENATED = null;

    @SerialName("8")
    public static final OmniMessageStatus MessageStatus_REGEN_ROOT = null;

    @SerialName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final OmniMessageStatus MessageStatus_UNSELECTED = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageStatus$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniMessageStatus;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniMessageStatus.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniMessageStatus> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniMessageStatus findByValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L33;
            if (r100 == 3) goto L32;
            if (r100 == 19) goto L31;
            switch(r100) {
                case 5: goto L30;
                case 6: goto L29;
                case 7: goto L28;
                case 8: goto L27;
                case 9: goto L26;
                case 10: goto L25;
                case 11: goto L24;
                default: goto L10;
            };
        L10:
            d1.f348206b.b("enum", "OmniMessageStatus unknown value: " + r100);
            return OmniMessageStatus.MessageStatus_AVAILABLE;
        L24:
            return OmniMessageStatus.MessageStatus_NotCompliant;
        L25:
            return OmniMessageStatus.MessageStatus_REGENATED;
        L26:
            return OmniMessageStatus.MessageStatus_UNSELECTED;
        L27:
            return OmniMessageStatus.MessageStatus_REGEN_ROOT;
        L28:
            return OmniMessageStatus.MessageStatus_BEFOREEDIT;
        L29:
            return OmniMessageStatus.MessageStatus_EDITED;
        L30:
            return OmniMessageStatus.MessageStatus_DELETED;
        L31:
            return OmniMessageStatus.MessageStatus_PLACE_HOLD;
        L32:
            return OmniMessageStatus.MessageStatus_NOT_EXIST;
        L33:
            return OmniMessageStatus.MessageStatus_INVISIBLE;
        L22:
            return OmniMessageStatus.MessageStatus_AVAILABLE;
        }
    }

    private static final /* synthetic */ OmniMessageStatus[] $values() {
        return new OmniMessageStatus[]{MessageStatus_AVAILABLE, MessageStatus_INVISIBLE, MessageStatus_NOT_EXIST, MessageStatus_DELETED, MessageStatus_EDITED, MessageStatus_BEFOREEDIT, MessageStatus_REGEN_ROOT, MessageStatus_UNSELECTED, MessageStatus_REGENATED, MessageStatus_NotCompliant, MessageStatus_PLACE_HOLD};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniMessageStatus findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniMessageStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        MessageStatus_AVAILABLE = new OmniMessageStatus("MessageStatus_AVAILABLE", 0, 0);
        MessageStatus_INVISIBLE = new OmniMessageStatus("MessageStatus_INVISIBLE", 1, 1);
        MessageStatus_NOT_EXIST = new OmniMessageStatus("MessageStatus_NOT_EXIST", 2, 3);
        MessageStatus_DELETED = new OmniMessageStatus("MessageStatus_DELETED", 3, 5);
        MessageStatus_EDITED = new OmniMessageStatus("MessageStatus_EDITED", 4, 6);
        MessageStatus_BEFOREEDIT = new OmniMessageStatus("MessageStatus_BEFOREEDIT", 5, 7);
        MessageStatus_REGEN_ROOT = new OmniMessageStatus("MessageStatus_REGEN_ROOT", 6, 8);
        MessageStatus_UNSELECTED = new OmniMessageStatus("MessageStatus_UNSELECTED", 7, 9);
        MessageStatus_REGENATED = new OmniMessageStatus("MessageStatus_REGENATED", 8, 10);
        MessageStatus_NotCompliant = new OmniMessageStatus("MessageStatus_NotCompliant", 9, 11);
        MessageStatus_PLACE_HOLD = new OmniMessageStatus("MessageStatus_PLACE_HOLD", 10, 19);
        OmniMessageStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new f9());
    }

    public static OmniMessageStatus[] values() {
        return (OmniMessageStatus[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniMessageStatus", values(), new String[]{"0", "1", "3", "5", "6", "7", "8", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "11", Constants.VIA_ACT_TYPE_NINETEEN}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniMessageStatus valueOf(String r100) {
        return (OmniMessageStatus) a.a(OmniMessageStatus.class, r100);
    }

    private OmniMessageStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
