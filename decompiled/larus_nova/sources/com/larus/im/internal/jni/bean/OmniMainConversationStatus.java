package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.a8;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMainConversationStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "MainConversationStatus_EXCLUDE", "MainConversationStatus_INCLUDE", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniMainConversationStatus extends Enum<OmniMainConversationStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniMainConversationStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("0")
    public static final OmniMainConversationStatus MainConversationStatus_EXCLUDE = null;

    @SerialName("1")
    public static final OmniMainConversationStatus MainConversationStatus_INCLUDE = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMainConversationStatus$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniMainConversationStatus;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniMainConversationStatus.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniMainConversationStatus> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniMainConversationStatus findByValue(int r100) {
            if (r100 == 0) goto L8;
            if (r100 == 1) goto L10;
            d1.f348206b.b("enum", "OmniMainConversationStatus unknown value: " + r100);
            return OmniMainConversationStatus.MainConversationStatus_EXCLUDE;
        L10:
            return OmniMainConversationStatus.MainConversationStatus_INCLUDE;
        L8:
            return OmniMainConversationStatus.MainConversationStatus_EXCLUDE;
        }
    }

    private static final /* synthetic */ OmniMainConversationStatus[] $values() {
        return new OmniMainConversationStatus[]{MainConversationStatus_EXCLUDE, MainConversationStatus_INCLUDE};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniMainConversationStatus findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniMainConversationStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        MainConversationStatus_EXCLUDE = new OmniMainConversationStatus("MainConversationStatus_EXCLUDE", 0, 0);
        MainConversationStatus_INCLUDE = new OmniMainConversationStatus("MainConversationStatus_INCLUDE", 1, 1);
        OmniMainConversationStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new a8());
    }

    public static OmniMainConversationStatus[] values() {
        return (OmniMainConversationStatus[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniMainConversationStatus", values(), new String[]{"0", "1"}, new Annotation[][]{null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniMainConversationStatus valueOf(String r100) {
        return (OmniMainConversationStatus) a.a(OmniMainConversationStatus.class, r100);
    }

    private OmniMainConversationStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
