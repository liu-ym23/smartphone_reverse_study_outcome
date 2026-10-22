package com.ss.android.lark.officesdk.di.core.deps;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/di/core/deps/JsEngineKind;", "", "<init>", "(Ljava/lang/String;I)V", "QUICKJS", "V8", "di-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum JsEngineKind extends Enum<JsEngineKind> {
    public static final JsEngineKind QUICKJS = null;
    public static final JsEngineKind V8 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JsEngineKind[] f433178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433179b = null;

    public static EnumEntries<JsEngineKind> getEntries() {
        return f433179b;
    }

    static {
        JsEngineKind r100 = new JsEngineKind("QUICKJS", 0);
        QUICKJS = r100;
        JsEngineKind r101 = new JsEngineKind("V8", 1);
        V8 = r101;
        JsEngineKind[] r102 = {r100, r101};
        f433178a = r102;
        f433179b = EnumEntriesKt.enumEntries(r102);
    }

    public static JsEngineKind[] values() {
        return (JsEngineKind[]) f433178a.clone();
    }

    public static JsEngineKind valueOf(String r100) {
        return (JsEngineKind) a.a(JsEngineKind.class, r100);
    }

    public JsEngineKind(String r100, int r101) {
        super(r100, r101);
    }
}
