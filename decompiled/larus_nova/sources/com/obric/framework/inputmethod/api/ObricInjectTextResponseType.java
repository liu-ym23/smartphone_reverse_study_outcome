package com.obric.framework.inputmethod.api;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/framework/inputmethod/api/ObricInjectTextResponseType;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "ABNORMAL", "SECURE", "UNKNOWN", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricInjectTextResponseType extends Enum<ObricInjectTextResponseType> {
    public static final ObricInjectTextResponseType ABNORMAL = null;
    public static final ObricInjectTextResponseType NORMAL = null;
    public static final ObricInjectTextResponseType SECURE = null;
    public static final ObricInjectTextResponseType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricInjectTextResponseType[] f396884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f396885b = null;

    public static EnumEntries<ObricInjectTextResponseType> getEntries() {
        return f396885b;
    }

    static {
        ObricInjectTextResponseType r100 = new ObricInjectTextResponseType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ObricInjectTextResponseType r101 = new ObricInjectTextResponseType("ABNORMAL", 1);
        ABNORMAL = r101;
        ObricInjectTextResponseType r102 = new ObricInjectTextResponseType("SECURE", 2);
        SECURE = r102;
        ObricInjectTextResponseType r103 = new ObricInjectTextResponseType("UNKNOWN", 3);
        UNKNOWN = r103;
        ObricInjectTextResponseType[] r104 = {r100, r101, r102, r103};
        f396884a = r104;
        f396885b = EnumEntriesKt.enumEntries(r104);
    }

    public static ObricInjectTextResponseType[] values() {
        return (ObricInjectTextResponseType[]) f396884a.clone();
    }

    public static ObricInjectTextResponseType valueOf(String r100) {
        return (ObricInjectTextResponseType) r27.a.a(ObricInjectTextResponseType.class, r100);
    }

    public ObricInjectTextResponseType(String r100, int r101) {
        super(r100, r101);
    }
}
