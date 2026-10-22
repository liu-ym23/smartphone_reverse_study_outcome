package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.n0;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVEventType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "unknown", "sessionStarted", "sessionFinished", "queryBegin", "queryUpdate", "queryEnd", "replyBegin", "replyUpdate", "replyEnd", "commandSignalDownlink", "fileDownlink", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OMNIAVEventType extends Enum<OMNIAVEventType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OMNIAVEventType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("30001")
    public static final OMNIAVEventType commandSignalDownlink = null;

    @SerialName("40001")
    public static final OMNIAVEventType fileDownlink = null;

    @SerialName("20003")
    public static final OMNIAVEventType queryBegin = null;

    @SerialName("20005")
    public static final OMNIAVEventType queryEnd = null;

    @SerialName("20004")
    public static final OMNIAVEventType queryUpdate = null;

    @SerialName("20006")
    public static final OMNIAVEventType replyBegin = null;

    @SerialName("20008")
    public static final OMNIAVEventType replyEnd = null;

    @SerialName("20007")
    public static final OMNIAVEventType replyUpdate = null;

    @SerialName("20002")
    public static final OMNIAVEventType sessionFinished = null;

    @SerialName("20001")
    public static final OMNIAVEventType sessionStarted = null;

    @SerialName("0")
    public static final OMNIAVEventType unknown = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVEventType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OMNIAVEventType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OMNIAVEventType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OMNIAVEventType> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OMNIAVEventType findByValue(int r100) {
            if (r100 == 0) goto L20;
            if (r100 == 30001) goto L31;
            if (r100 == 40001) goto L30;
            switch(r100) {
                case 20001: goto L29;
                case 20002: goto L28;
                case 20003: goto L27;
                case 20004: goto L26;
                case 20005: goto L25;
                case 20006: goto L24;
                case 20007: goto L23;
                case 20008: goto L22;
                default: goto L8;
            };
        L8:
            d1.f348206b.b("enum", "OMNIAVEventType unknown value: " + r100);
            return OMNIAVEventType.unknown;
        L22:
            return OMNIAVEventType.replyEnd;
        L23:
            return OMNIAVEventType.replyUpdate;
        L24:
            return OMNIAVEventType.replyBegin;
        L25:
            return OMNIAVEventType.queryEnd;
        L26:
            return OMNIAVEventType.queryUpdate;
        L27:
            return OMNIAVEventType.queryBegin;
        L28:
            return OMNIAVEventType.sessionFinished;
        L29:
            return OMNIAVEventType.sessionStarted;
        L30:
            return OMNIAVEventType.fileDownlink;
        L31:
            return OMNIAVEventType.commandSignalDownlink;
        L20:
            return OMNIAVEventType.unknown;
        }
    }

    private static final /* synthetic */ OMNIAVEventType[] $values() {
        return new OMNIAVEventType[]{unknown, sessionStarted, sessionFinished, queryBegin, queryUpdate, queryEnd, replyBegin, replyUpdate, replyEnd, commandSignalDownlink, fileDownlink};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OMNIAVEventType findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OMNIAVEventType> getEntries() {
        return $ENTRIES;
    }

    static {
        unknown = new OMNIAVEventType("unknown", 0, 0);
        sessionStarted = new OMNIAVEventType("sessionStarted", 1, 20001);
        sessionFinished = new OMNIAVEventType("sessionFinished", 2, 20002);
        queryBegin = new OMNIAVEventType("queryBegin", 3, 20003);
        queryUpdate = new OMNIAVEventType("queryUpdate", 4, 20004);
        queryEnd = new OMNIAVEventType("queryEnd", 5, 20005);
        replyBegin = new OMNIAVEventType("replyBegin", 6, 20006);
        replyUpdate = new OMNIAVEventType("replyUpdate", 7, 20007);
        replyEnd = new OMNIAVEventType("replyEnd", 8, 20008);
        commandSignalDownlink = new OMNIAVEventType("commandSignalDownlink", 9, 30001);
        fileDownlink = new OMNIAVEventType("fileDownlink", 10, 40001);
        OMNIAVEventType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new n0());
    }

    public static OMNIAVEventType[] values() {
        return (OMNIAVEventType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OMNIAVEventType", values(), new String[]{"0", "20001", "20002", "20003", "20004", "20005", "20006", "20007", "20008", "30001", "40001"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OMNIAVEventType valueOf(String r100) {
        return (OMNIAVEventType) a.a(OMNIAVEventType.class, r100);
    }

    private OMNIAVEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
