package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import com.tencent.connect.common.Constants;
import de9.ac;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniUpdateMessageLocalOption;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "OmniUpdateMessageLocalOption_UNKNOW", "OmniUpdateMessageLocalOption_CONTENT", "OmniUpdateMessageLocalOption_LOCAL_STATUS", "OmniUpdateMessageLocalOption_LOCAL_MESSAGE_STATUS", "OmniUpdateMessageLocalOption_REPLACE_BIZ_EXT", "OmniUpdateMessageLocalOption_REPLACE_EXT", "OmniUpdateMessageLocalOption_MERGE_BIZ_EXT", "OmniUpdateMessageLocalOption_MERGE_EXT", "OmniUpdateMessageLocalOption_CREATE_TIME", "OmniUpdateMessageLocalOption_NEED_GLOBAL_NOTIFY", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniUpdateMessageLocalOption extends Enum<OmniUpdateMessageLocalOption> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniUpdateMessageLocalOption[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("1")
    public static final OmniUpdateMessageLocalOption OmniUpdateMessageLocalOption_CONTENT = null;

    @SerialName("8")
    public static final OmniUpdateMessageLocalOption OmniUpdateMessageLocalOption_CREATE_TIME = null;

    @SerialName("3")
    public static final OmniUpdateMessageLocalOption OmniUpdateMessageLocalOption_LOCAL_MESSAGE_STATUS = null;

    @SerialName("2")
    public static final OmniUpdateMessageLocalOption OmniUpdateMessageLocalOption_LOCAL_STATUS = null;

    @SerialName("6")
    public static final OmniUpdateMessageLocalOption OmniUpdateMessageLocalOption_MERGE_BIZ_EXT = null;

    @SerialName("7")
    public static final OmniUpdateMessageLocalOption OmniUpdateMessageLocalOption_MERGE_EXT = null;

    @SerialName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final OmniUpdateMessageLocalOption OmniUpdateMessageLocalOption_NEED_GLOBAL_NOTIFY = null;

    @SerialName("4")
    public static final OmniUpdateMessageLocalOption OmniUpdateMessageLocalOption_REPLACE_BIZ_EXT = null;

    @SerialName("5")
    public static final OmniUpdateMessageLocalOption OmniUpdateMessageLocalOption_REPLACE_EXT = null;

    @SerialName("0")
    public static final OmniUpdateMessageLocalOption OmniUpdateMessageLocalOption_UNKNOW = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniUpdateMessageLocalOption$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniUpdateMessageLocalOption;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniUpdateMessageLocalOption.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniUpdateMessageLocalOption> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniUpdateMessageLocalOption findByValue(int r100) {
            switch(r100) {
                case 0: goto L14;
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                default: goto L3;
            };
        L3:
            d1.f348206b.b("enum", "OmniUpdateMessageLocalOption unknown value: " + r100);
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_UNKNOW;
        L16:
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_NEED_GLOBAL_NOTIFY;
        L17:
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_CREATE_TIME;
        L18:
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_MERGE_EXT;
        L19:
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_MERGE_BIZ_EXT;
        L20:
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_REPLACE_EXT;
        L21:
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_REPLACE_BIZ_EXT;
        L22:
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_LOCAL_MESSAGE_STATUS;
        L23:
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_LOCAL_STATUS;
        L24:
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_CONTENT;
        L14:
            return OmniUpdateMessageLocalOption.OmniUpdateMessageLocalOption_UNKNOW;
        }
    }

    private static final /* synthetic */ OmniUpdateMessageLocalOption[] $values() {
        return new OmniUpdateMessageLocalOption[]{OmniUpdateMessageLocalOption_UNKNOW, OmniUpdateMessageLocalOption_CONTENT, OmniUpdateMessageLocalOption_LOCAL_STATUS, OmniUpdateMessageLocalOption_LOCAL_MESSAGE_STATUS, OmniUpdateMessageLocalOption_REPLACE_BIZ_EXT, OmniUpdateMessageLocalOption_REPLACE_EXT, OmniUpdateMessageLocalOption_MERGE_BIZ_EXT, OmniUpdateMessageLocalOption_MERGE_EXT, OmniUpdateMessageLocalOption_CREATE_TIME, OmniUpdateMessageLocalOption_NEED_GLOBAL_NOTIFY};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniUpdateMessageLocalOption findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniUpdateMessageLocalOption> getEntries() {
        return $ENTRIES;
    }

    static {
        OmniUpdateMessageLocalOption_UNKNOW = new OmniUpdateMessageLocalOption("OmniUpdateMessageLocalOption_UNKNOW", 0, 0);
        OmniUpdateMessageLocalOption_CONTENT = new OmniUpdateMessageLocalOption("OmniUpdateMessageLocalOption_CONTENT", 1, 1);
        OmniUpdateMessageLocalOption_LOCAL_STATUS = new OmniUpdateMessageLocalOption("OmniUpdateMessageLocalOption_LOCAL_STATUS", 2, 2);
        OmniUpdateMessageLocalOption_LOCAL_MESSAGE_STATUS = new OmniUpdateMessageLocalOption("OmniUpdateMessageLocalOption_LOCAL_MESSAGE_STATUS", 3, 3);
        OmniUpdateMessageLocalOption_REPLACE_BIZ_EXT = new OmniUpdateMessageLocalOption("OmniUpdateMessageLocalOption_REPLACE_BIZ_EXT", 4, 4);
        OmniUpdateMessageLocalOption_REPLACE_EXT = new OmniUpdateMessageLocalOption("OmniUpdateMessageLocalOption_REPLACE_EXT", 5, 5);
        OmniUpdateMessageLocalOption_MERGE_BIZ_EXT = new OmniUpdateMessageLocalOption("OmniUpdateMessageLocalOption_MERGE_BIZ_EXT", 6, 6);
        OmniUpdateMessageLocalOption_MERGE_EXT = new OmniUpdateMessageLocalOption("OmniUpdateMessageLocalOption_MERGE_EXT", 7, 7);
        OmniUpdateMessageLocalOption_CREATE_TIME = new OmniUpdateMessageLocalOption("OmniUpdateMessageLocalOption_CREATE_TIME", 8, 8);
        OmniUpdateMessageLocalOption_NEED_GLOBAL_NOTIFY = new OmniUpdateMessageLocalOption("OmniUpdateMessageLocalOption_NEED_GLOBAL_NOTIFY", 9, 9);
        OmniUpdateMessageLocalOption[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ac());
    }

    public static OmniUpdateMessageLocalOption[] values() {
        return (OmniUpdateMessageLocalOption[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniUpdateMessageLocalOption", values(), new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", Constants.VIA_SHARE_TYPE_MINI_PROGRAM}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniUpdateMessageLocalOption valueOf(String r100) {
        return (OmniUpdateMessageLocalOption) a.a(OmniUpdateMessageLocalOption.class, r100);
    }

    private OmniUpdateMessageLocalOption(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
