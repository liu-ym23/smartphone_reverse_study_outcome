package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.h9;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMockOption;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "NO_MOCK", "MOCK_DOU_BAO", "MOCK_DOLA", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniMockOption extends Enum<OmniMockOption> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniMockOption[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("2")
    public static final OmniMockOption MOCK_DOLA = null;

    @SerialName("1")
    public static final OmniMockOption MOCK_DOU_BAO = null;

    @SerialName("0")
    public static final OmniMockOption NO_MOCK = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMockOption$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniMockOption;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniMockOption.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniMockOption> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniMockOption findByValue(int r100) {
            if (r100 == 0) goto L11;
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L13;
            d1.f348206b.b("enum", "OmniMockOption unknown value: " + r100);
            return OmniMockOption.NO_MOCK;
        L13:
            return OmniMockOption.MOCK_DOLA;
        L14:
            return OmniMockOption.MOCK_DOU_BAO;
        L11:
            return OmniMockOption.NO_MOCK;
        }
    }

    private static final /* synthetic */ OmniMockOption[] $values() {
        return new OmniMockOption[]{NO_MOCK, MOCK_DOU_BAO, MOCK_DOLA};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniMockOption findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniMockOption> getEntries() {
        return $ENTRIES;
    }

    static {
        NO_MOCK = new OmniMockOption("NO_MOCK", 0, 0);
        MOCK_DOU_BAO = new OmniMockOption("MOCK_DOU_BAO", 1, 1);
        MOCK_DOLA = new OmniMockOption("MOCK_DOLA", 2, 2);
        OmniMockOption[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new h9());
    }

    public static OmniMockOption[] values() {
        return (OmniMockOption[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniMockOption", values(), new String[]{"0", "1", "2"}, new Annotation[][]{null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniMockOption valueOf(String r100) {
        return (OmniMockOption) a.a(OmniMockOption.class, r100);
    }

    private OmniMockOption(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
