package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYCepMode;", "", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "Independent", "Dependent", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum PTYCepMode extends Enum<PTYCepMode> implements ReflectionCall {
    private static final /* synthetic */ PTYCepMode[] $VALUES = null;
    public static final PTYCepMode Dependent = null;
    public static final PTYCepMode Independent = null;
    private final int code;

    private static final /* synthetic */ PTYCepMode[] $values() {
        return new PTYCepMode[]{Independent, Dependent};
    }

    public static PTYCepMode valueOf(String r100) {
        return (PTYCepMode) r27.a.a(PTYCepMode.class, r100);
    }

    public static PTYCepMode[] values() {
        return (PTYCepMode[]) $VALUES.clone();
    }

    static {
        Independent = new PTYCepMode("Independent", 0, 0);
        Dependent = new PTYCepMode("Dependent", 1, 1);
        $VALUES = $values();
    }

    public final int getCode() {
        return this.code;
    }

    private PTYCepMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
