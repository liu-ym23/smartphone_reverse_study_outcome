package com.obric.assistant.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/ability/ObricSpecialInputCloseMethod;", "", "<init>", "(Ljava/lang/String;I)V", "X_CLOSE_BUTTON", "ARROW_CLOSE_BUTTON", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricSpecialInputCloseMethod extends Enum<ObricSpecialInputCloseMethod> {
    public static final ObricSpecialInputCloseMethod ARROW_CLOSE_BUTTON = null;
    public static final ObricSpecialInputCloseMethod X_CLOSE_BUTTON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricSpecialInputCloseMethod[] f385211a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385212b = null;

    public static EnumEntries<ObricSpecialInputCloseMethod> getEntries() {
        return f385212b;
    }

    static {
        ObricSpecialInputCloseMethod r100 = new ObricSpecialInputCloseMethod("X_CLOSE_BUTTON", 0);
        X_CLOSE_BUTTON = r100;
        ObricSpecialInputCloseMethod r101 = new ObricSpecialInputCloseMethod("ARROW_CLOSE_BUTTON", 1);
        ARROW_CLOSE_BUTTON = r101;
        ObricSpecialInputCloseMethod[] r102 = {r100, r101};
        f385211a = r102;
        f385212b = EnumEntriesKt.enumEntries(r102);
    }

    public static ObricSpecialInputCloseMethod[] values() {
        return (ObricSpecialInputCloseMethod[]) f385211a.clone();
    }

    public static ObricSpecialInputCloseMethod valueOf(String r100) {
        return (ObricSpecialInputCloseMethod) a.a(ObricSpecialInputCloseMethod.class, r100);
    }

    public ObricSpecialInputCloseMethod(String r100, int r101) {
        super(r100, r101);
    }
}
