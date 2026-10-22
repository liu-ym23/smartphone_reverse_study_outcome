package com.larus.im.internal.jni.bean;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.larus.im.internal.delegate.d1;
import de9.b4;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotAddToGroupStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", ErrorCode.INIT, "USING", "DELETED", "BAN", "NOT_RECOMMEND", "SELF_VISIBLE", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniBotAddToGroupStatus extends Enum<OmniBotAddToGroupStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniBotAddToGroupStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("3")
    public static final OmniBotAddToGroupStatus BAN = null;
    public static final Companion Companion = null;

    @SerialName("2")
    public static final OmniBotAddToGroupStatus DELETED = null;

    @SerialName("0")
    public static final OmniBotAddToGroupStatus INIT = null;

    @SerialName("4")
    public static final OmniBotAddToGroupStatus NOT_RECOMMEND = null;

    @SerialName("5")
    public static final OmniBotAddToGroupStatus SELF_VISIBLE = null;

    @SerialName("1")
    public static final OmniBotAddToGroupStatus USING = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotAddToGroupStatus$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniBotAddToGroupStatus;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniBotAddToGroupStatus.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniBotAddToGroupStatus> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniBotAddToGroupStatus findByValue(int r100) {
            if (r100 == 0) goto L20;
            if (r100 == 1) goto L26;
            if (r100 == 2) goto L25;
            if (r100 == 3) goto L24;
            if (r100 == 4) goto L23;
            if (r100 == 5) goto L22;
            d1.f348206b.b("enum", "OmniBotAddToGroupStatus unknown value: " + r100);
            return OmniBotAddToGroupStatus.INIT;
        L22:
            return OmniBotAddToGroupStatus.SELF_VISIBLE;
        L23:
            return OmniBotAddToGroupStatus.NOT_RECOMMEND;
        L24:
            return OmniBotAddToGroupStatus.BAN;
        L25:
            return OmniBotAddToGroupStatus.DELETED;
        L26:
            return OmniBotAddToGroupStatus.USING;
        L20:
            return OmniBotAddToGroupStatus.INIT;
        }
    }

    private static final /* synthetic */ OmniBotAddToGroupStatus[] $values() {
        return new OmniBotAddToGroupStatus[]{INIT, USING, DELETED, BAN, NOT_RECOMMEND, SELF_VISIBLE};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniBotAddToGroupStatus findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniBotAddToGroupStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        INIT = new OmniBotAddToGroupStatus(ErrorCode.INIT, 0, 0);
        USING = new OmniBotAddToGroupStatus("USING", 1, 1);
        DELETED = new OmniBotAddToGroupStatus("DELETED", 2, 2);
        BAN = new OmniBotAddToGroupStatus("BAN", 3, 3);
        NOT_RECOMMEND = new OmniBotAddToGroupStatus("NOT_RECOMMEND", 4, 4);
        SELF_VISIBLE = new OmniBotAddToGroupStatus("SELF_VISIBLE", 5, 5);
        OmniBotAddToGroupStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new b4());
    }

    public static OmniBotAddToGroupStatus[] values() {
        return (OmniBotAddToGroupStatus[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniBotAddToGroupStatus", values(), new String[]{"0", "1", "2", "3", "4", "5"}, new Annotation[][]{null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniBotAddToGroupStatus valueOf(String r100) {
        return (OmniBotAddToGroupStatus) a.a(OmniBotAddToGroupStatus.class, r100);
    }

    private OmniBotAddToGroupStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
