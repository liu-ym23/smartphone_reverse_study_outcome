package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.w6;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniFetchCmdChainScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "COLD_LAUNCH", "FRONTIER_DISCONNECT", "FRONTIER_RECOVER", "ACCOUNT_SWITCH", "VERSION_CHANGE", "GET_MAIN_CONVERSATION", "ON_DATABASE_CORRUPTED", "REFORM", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniFetchCmdChainScene extends Enum<OmniFetchCmdChainScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniFetchCmdChainScene[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("3")
    public static final OmniFetchCmdChainScene ACCOUNT_SWITCH = null;

    @SerialName("0")
    public static final OmniFetchCmdChainScene COLD_LAUNCH = null;
    public static final Companion Companion = null;

    @SerialName("1")
    public static final OmniFetchCmdChainScene FRONTIER_DISCONNECT = null;

    @SerialName("2")
    public static final OmniFetchCmdChainScene FRONTIER_RECOVER = null;

    @SerialName("5")
    public static final OmniFetchCmdChainScene GET_MAIN_CONVERSATION = null;

    @SerialName("6")
    public static final OmniFetchCmdChainScene ON_DATABASE_CORRUPTED = null;

    @SerialName("7")
    public static final OmniFetchCmdChainScene REFORM = null;

    @SerialName("4")
    public static final OmniFetchCmdChainScene VERSION_CHANGE = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniFetchCmdChainScene$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniFetchCmdChainScene;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniFetchCmdChainScene.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniFetchCmdChainScene> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniFetchCmdChainScene findByValue(int r100) {
            switch(r100) {
                case 0: goto L12;
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                default: goto L3;
            };
        L3:
            d1.f348206b.b("enum", "OmniFetchCmdChainScene unknown value: " + r100);
            return OmniFetchCmdChainScene.COLD_LAUNCH;
        L14:
            return OmniFetchCmdChainScene.REFORM;
        L15:
            return OmniFetchCmdChainScene.ON_DATABASE_CORRUPTED;
        L16:
            return OmniFetchCmdChainScene.GET_MAIN_CONVERSATION;
        L17:
            return OmniFetchCmdChainScene.VERSION_CHANGE;
        L18:
            return OmniFetchCmdChainScene.ACCOUNT_SWITCH;
        L19:
            return OmniFetchCmdChainScene.FRONTIER_RECOVER;
        L20:
            return OmniFetchCmdChainScene.FRONTIER_DISCONNECT;
        L12:
            return OmniFetchCmdChainScene.COLD_LAUNCH;
        }
    }

    private static final /* synthetic */ OmniFetchCmdChainScene[] $values() {
        return new OmniFetchCmdChainScene[]{COLD_LAUNCH, FRONTIER_DISCONNECT, FRONTIER_RECOVER, ACCOUNT_SWITCH, VERSION_CHANGE, GET_MAIN_CONVERSATION, ON_DATABASE_CORRUPTED, REFORM};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniFetchCmdChainScene findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniFetchCmdChainScene> getEntries() {
        return $ENTRIES;
    }

    static {
        COLD_LAUNCH = new OmniFetchCmdChainScene("COLD_LAUNCH", 0, 0);
        FRONTIER_DISCONNECT = new OmniFetchCmdChainScene("FRONTIER_DISCONNECT", 1, 1);
        FRONTIER_RECOVER = new OmniFetchCmdChainScene("FRONTIER_RECOVER", 2, 2);
        ACCOUNT_SWITCH = new OmniFetchCmdChainScene("ACCOUNT_SWITCH", 3, 3);
        VERSION_CHANGE = new OmniFetchCmdChainScene("VERSION_CHANGE", 4, 4);
        GET_MAIN_CONVERSATION = new OmniFetchCmdChainScene("GET_MAIN_CONVERSATION", 5, 5);
        ON_DATABASE_CORRUPTED = new OmniFetchCmdChainScene("ON_DATABASE_CORRUPTED", 6, 6);
        REFORM = new OmniFetchCmdChainScene("REFORM", 7, 7);
        OmniFetchCmdChainScene[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new w6());
    }

    public static OmniFetchCmdChainScene[] values() {
        return (OmniFetchCmdChainScene[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniFetchCmdChainScene", values(), new String[]{"0", "1", "2", "3", "4", "5", "6", "7"}, new Annotation[][]{null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniFetchCmdChainScene valueOf(String r100) {
        return (OmniFetchCmdChainScene) a.a(OmniFetchCmdChainScene.class, r100);
    }

    private OmniFetchCmdChainScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
