package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.a7;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniFetchMessageListScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "OmniFetchMessageListScene_FILLHOLE", "OmniFetchMessageListScene_FRONTIER_TIMEOUT", "OmniFetchMessageListScene_REGEN", "OmniFetchMessageListScene_MESSAGE_NOTIFY", "OmniFetchMessageListScene_RECOVER", "OmniFetchMessageListScene_DOUYIN", "OmniFetchMessageListScene_ENTER_CONVERSATION", "OmniFetchMessageListScene_RECENT_CHAIN_FILL_HOLE", "OmniFetchMessageListScene_FILL_STREAMING_MESSAGE", "OmniFetchMessageListScene_UNKNOWN", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniFetchMessageListScene extends Enum<OmniFetchMessageListScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniFetchMessageListScene[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("5")
    public static final OmniFetchMessageListScene OmniFetchMessageListScene_DOUYIN = null;

    @SerialName("6")
    public static final OmniFetchMessageListScene OmniFetchMessageListScene_ENTER_CONVERSATION = null;

    @SerialName("0")
    public static final OmniFetchMessageListScene OmniFetchMessageListScene_FILLHOLE = null;

    @SerialName("8")
    public static final OmniFetchMessageListScene OmniFetchMessageListScene_FILL_STREAMING_MESSAGE = null;

    @SerialName("1")
    public static final OmniFetchMessageListScene OmniFetchMessageListScene_FRONTIER_TIMEOUT = null;

    @SerialName("3")
    public static final OmniFetchMessageListScene OmniFetchMessageListScene_MESSAGE_NOTIFY = null;

    @SerialName("7")
    public static final OmniFetchMessageListScene OmniFetchMessageListScene_RECENT_CHAIN_FILL_HOLE = null;

    @SerialName("4")
    public static final OmniFetchMessageListScene OmniFetchMessageListScene_RECOVER = null;

    @SerialName("2")
    public static final OmniFetchMessageListScene OmniFetchMessageListScene_REGEN = null;

    @SerialName("999")
    public static final OmniFetchMessageListScene OmniFetchMessageListScene_UNKNOWN = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniFetchMessageListScene$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniFetchMessageListScene;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniFetchMessageListScene.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniFetchMessageListScene> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniFetchMessageListScene findByValue(int r100) {
            if (r100 == 999) goto L16;
            switch(r100) {
                case 0: goto L26;
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                default: goto L5;
            };
        L5:
            d1.f348206b.b("enum", "OmniFetchMessageListScene unknown value: " + r100);
            return OmniFetchMessageListScene.OmniFetchMessageListScene_FILLHOLE;
        L18:
            return OmniFetchMessageListScene.OmniFetchMessageListScene_FILL_STREAMING_MESSAGE;
        L19:
            return OmniFetchMessageListScene.OmniFetchMessageListScene_RECENT_CHAIN_FILL_HOLE;
        L20:
            return OmniFetchMessageListScene.OmniFetchMessageListScene_ENTER_CONVERSATION;
        L21:
            return OmniFetchMessageListScene.OmniFetchMessageListScene_DOUYIN;
        L22:
            return OmniFetchMessageListScene.OmniFetchMessageListScene_RECOVER;
        L23:
            return OmniFetchMessageListScene.OmniFetchMessageListScene_MESSAGE_NOTIFY;
        L24:
            return OmniFetchMessageListScene.OmniFetchMessageListScene_REGEN;
        L25:
            return OmniFetchMessageListScene.OmniFetchMessageListScene_FRONTIER_TIMEOUT;
        L26:
            return OmniFetchMessageListScene.OmniFetchMessageListScene_FILLHOLE;
        L16:
            return OmniFetchMessageListScene.OmniFetchMessageListScene_UNKNOWN;
        }
    }

    private static final /* synthetic */ OmniFetchMessageListScene[] $values() {
        return new OmniFetchMessageListScene[]{OmniFetchMessageListScene_FILLHOLE, OmniFetchMessageListScene_FRONTIER_TIMEOUT, OmniFetchMessageListScene_REGEN, OmniFetchMessageListScene_MESSAGE_NOTIFY, OmniFetchMessageListScene_RECOVER, OmniFetchMessageListScene_DOUYIN, OmniFetchMessageListScene_ENTER_CONVERSATION, OmniFetchMessageListScene_RECENT_CHAIN_FILL_HOLE, OmniFetchMessageListScene_FILL_STREAMING_MESSAGE, OmniFetchMessageListScene_UNKNOWN};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniFetchMessageListScene findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniFetchMessageListScene> getEntries() {
        return $ENTRIES;
    }

    static {
        OmniFetchMessageListScene_FILLHOLE = new OmniFetchMessageListScene("OmniFetchMessageListScene_FILLHOLE", 0, 0);
        OmniFetchMessageListScene_FRONTIER_TIMEOUT = new OmniFetchMessageListScene("OmniFetchMessageListScene_FRONTIER_TIMEOUT", 1, 1);
        OmniFetchMessageListScene_REGEN = new OmniFetchMessageListScene("OmniFetchMessageListScene_REGEN", 2, 2);
        OmniFetchMessageListScene_MESSAGE_NOTIFY = new OmniFetchMessageListScene("OmniFetchMessageListScene_MESSAGE_NOTIFY", 3, 3);
        OmniFetchMessageListScene_RECOVER = new OmniFetchMessageListScene("OmniFetchMessageListScene_RECOVER", 4, 4);
        OmniFetchMessageListScene_DOUYIN = new OmniFetchMessageListScene("OmniFetchMessageListScene_DOUYIN", 5, 5);
        OmniFetchMessageListScene_ENTER_CONVERSATION = new OmniFetchMessageListScene("OmniFetchMessageListScene_ENTER_CONVERSATION", 6, 6);
        OmniFetchMessageListScene_RECENT_CHAIN_FILL_HOLE = new OmniFetchMessageListScene("OmniFetchMessageListScene_RECENT_CHAIN_FILL_HOLE", 7, 7);
        OmniFetchMessageListScene_FILL_STREAMING_MESSAGE = new OmniFetchMessageListScene("OmniFetchMessageListScene_FILL_STREAMING_MESSAGE", 8, 8);
        OmniFetchMessageListScene_UNKNOWN = new OmniFetchMessageListScene("OmniFetchMessageListScene_UNKNOWN", 9, 999);
        OmniFetchMessageListScene[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new a7());
    }

    public static OmniFetchMessageListScene[] values() {
        return (OmniFetchMessageListScene[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniFetchMessageListScene", values(), new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "999"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniFetchMessageListScene valueOf(String r100) {
        return (OmniFetchMessageListScene) a.a(OmniFetchMessageListScene.class, r100);
    }

    private OmniFetchMessageListScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
