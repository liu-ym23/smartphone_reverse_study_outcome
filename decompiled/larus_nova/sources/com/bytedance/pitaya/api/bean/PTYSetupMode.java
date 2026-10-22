package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYSetupMode;", "", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "None", "Pre", "Lite", "Normal", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum PTYSetupMode extends Enum<PTYSetupMode> implements ReflectionCall {
    private static final /* synthetic */ PTYSetupMode[] $VALUES = null;
    public static final PTYSetupMode Lite = null;
    public static final PTYSetupMode None = null;
    public static final PTYSetupMode Normal = null;
    public static final PTYSetupMode Pre = null;
    private final int code;

    private static final /* synthetic */ PTYSetupMode[] $values() {
        return new PTYSetupMode[]{None, Pre, Lite, Normal};
    }

    public static PTYSetupMode valueOf(String r100) {
        return (PTYSetupMode) r27.a.a(PTYSetupMode.class, r100);
    }

    public static PTYSetupMode[] values() {
        return (PTYSetupMode[]) $VALUES.clone();
    }

    static {
        None = new PTYSetupMode("None", 0, 0);
        Pre = new PTYSetupMode("Pre", 1, 1);
        Lite = new PTYSetupMode("Lite", 2, 2);
        Normal = new PTYSetupMode("Normal", 3, 3);
        $VALUES = $values();
    }

    public final int getCode() {
        return this.code;
    }

    private PTYSetupMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
