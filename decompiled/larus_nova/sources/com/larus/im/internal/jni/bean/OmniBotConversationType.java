package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.c4;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotConversationType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "BOT_TYPE_UNKNOWN", "COCO", "BOT", "COCO_SUB", "AWEME_BOT", "SERVICE_BOT", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniBotConversationType extends Enum<OmniBotConversationType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniBotConversationType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("4")
    public static final OmniBotConversationType AWEME_BOT = null;

    @SerialName("2")
    public static final OmniBotConversationType BOT = null;

    @SerialName("0")
    public static final OmniBotConversationType BOT_TYPE_UNKNOWN = null;

    @SerialName("1")
    public static final OmniBotConversationType COCO = null;

    @SerialName("3")
    public static final OmniBotConversationType COCO_SUB = null;
    public static final Companion Companion = null;

    @SerialName("6")
    public static final OmniBotConversationType SERVICE_BOT = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotConversationType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniBotConversationType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniBotConversationType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniBotConversationType> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniBotConversationType findByValue(int r100) {
            if (r100 == 0) goto L20;
            if (r100 == 1) goto L26;
            if (r100 == 2) goto L25;
            if (r100 == 3) goto L24;
            if (r100 == 4) goto L23;
            if (r100 == 6) goto L22;
            d1.f348206b.b("enum", "OmniBotConversationType unknown value: " + r100);
            return OmniBotConversationType.BOT_TYPE_UNKNOWN;
        L22:
            return OmniBotConversationType.SERVICE_BOT;
        L23:
            return OmniBotConversationType.AWEME_BOT;
        L24:
            return OmniBotConversationType.COCO_SUB;
        L25:
            return OmniBotConversationType.BOT;
        L26:
            return OmniBotConversationType.COCO;
        L20:
            return OmniBotConversationType.BOT_TYPE_UNKNOWN;
        }
    }

    private static final /* synthetic */ OmniBotConversationType[] $values() {
        return new OmniBotConversationType[]{BOT_TYPE_UNKNOWN, COCO, BOT, COCO_SUB, AWEME_BOT, SERVICE_BOT};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniBotConversationType findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniBotConversationType> getEntries() {
        return $ENTRIES;
    }

    static {
        BOT_TYPE_UNKNOWN = new OmniBotConversationType("BOT_TYPE_UNKNOWN", 0, 0);
        COCO = new OmniBotConversationType("COCO", 1, 1);
        BOT = new OmniBotConversationType("BOT", 2, 2);
        COCO_SUB = new OmniBotConversationType("COCO_SUB", 3, 3);
        AWEME_BOT = new OmniBotConversationType("AWEME_BOT", 4, 4);
        SERVICE_BOT = new OmniBotConversationType("SERVICE_BOT", 5, 6);
        OmniBotConversationType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new c4());
    }

    public static OmniBotConversationType[] values() {
        return (OmniBotConversationType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniBotConversationType", values(), new String[]{"0", "1", "2", "3", "4", "6"}, new Annotation[][]{null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniBotConversationType valueOf(String r100) {
        return (OmniBotConversationType) a.a(OmniBotConversationType.class, r100);
    }

    private OmniBotConversationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
