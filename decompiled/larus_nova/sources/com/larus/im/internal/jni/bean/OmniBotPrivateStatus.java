package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.q4;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotPrivateStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "Unknown", "Public", "Private", "Unlisted", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniBotPrivateStatus extends Enum<OmniBotPrivateStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniBotPrivateStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("2")
    public static final OmniBotPrivateStatus Private = null;

    @SerialName("1")
    public static final OmniBotPrivateStatus Public = null;

    @SerialName("0")
    public static final OmniBotPrivateStatus Unknown = null;

    @SerialName("3")
    public static final OmniBotPrivateStatus Unlisted = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotPrivateStatus$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniBotPrivateStatus;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniBotPrivateStatus.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniBotPrivateStatus> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniBotPrivateStatus findByValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L18;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L16;
            d1.f348206b.b("enum", "OmniBotPrivateStatus unknown value: " + r100);
            return OmniBotPrivateStatus.Unknown;
        L16:
            return OmniBotPrivateStatus.Unlisted;
        L17:
            return OmniBotPrivateStatus.Private;
        L18:
            return OmniBotPrivateStatus.Public;
        L14:
            return OmniBotPrivateStatus.Unknown;
        }
    }

    private static final /* synthetic */ OmniBotPrivateStatus[] $values() {
        return new OmniBotPrivateStatus[]{Unknown, Public, Private, Unlisted};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniBotPrivateStatus findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniBotPrivateStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new OmniBotPrivateStatus("Unknown", 0, 0);
        Public = new OmniBotPrivateStatus("Public", 1, 1);
        Private = new OmniBotPrivateStatus("Private", 2, 2);
        Unlisted = new OmniBotPrivateStatus("Unlisted", 3, 3);
        OmniBotPrivateStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new q4());
    }

    public static OmniBotPrivateStatus[] values() {
        return (OmniBotPrivateStatus[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniBotPrivateStatus", values(), new String[]{"0", "1", "2", "3"}, new Annotation[][]{null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniBotPrivateStatus valueOf(String r100) {
        return (OmniBotPrivateStatus) a.a(OmniBotPrivateStatus.class, r100);
    }

    private OmniBotPrivateStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
