package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import com.tencent.connect.common.Constants;
import de9.ka;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniRoleType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "ROLE_TYPE_UNKNOWN", "NORMAL_USER", "CREATOR", "ADMIN", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniRoleType extends Enum<OmniRoleType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniRoleType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("11")
    public static final OmniRoleType ADMIN = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final OmniRoleType CREATOR = null;
    public static final Companion Companion = null;

    @SerialName("1")
    public static final OmniRoleType NORMAL_USER = null;

    @SerialName("0")
    public static final OmniRoleType ROLE_TYPE_UNKNOWN = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniRoleType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniRoleType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniRoleType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniRoleType> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniRoleType findByValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L18;
            if (r100 == 10) goto L17;
            if (r100 == 11) goto L16;
            d1.f348206b.b("enum", "OmniRoleType unknown value: " + r100);
            return OmniRoleType.ROLE_TYPE_UNKNOWN;
        L16:
            return OmniRoleType.ADMIN;
        L17:
            return OmniRoleType.CREATOR;
        L18:
            return OmniRoleType.NORMAL_USER;
        L14:
            return OmniRoleType.ROLE_TYPE_UNKNOWN;
        }
    }

    private static final /* synthetic */ OmniRoleType[] $values() {
        return new OmniRoleType[]{ROLE_TYPE_UNKNOWN, NORMAL_USER, CREATOR, ADMIN};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniRoleType findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniRoleType> getEntries() {
        return $ENTRIES;
    }

    static {
        ROLE_TYPE_UNKNOWN = new OmniRoleType("ROLE_TYPE_UNKNOWN", 0, 0);
        NORMAL_USER = new OmniRoleType("NORMAL_USER", 1, 1);
        CREATOR = new OmniRoleType("CREATOR", 2, 10);
        ADMIN = new OmniRoleType("ADMIN", 3, 11);
        OmniRoleType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ka());
    }

    public static OmniRoleType[] values() {
        return (OmniRoleType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniRoleType", values(), new String[]{"0", "1", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "11"}, new Annotation[][]{null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniRoleType valueOf(String r100) {
        return (OmniRoleType) a.a(OmniRoleType.class, r100);
    }

    private OmniRoleType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
