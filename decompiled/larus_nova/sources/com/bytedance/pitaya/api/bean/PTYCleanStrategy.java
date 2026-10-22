package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "Normal", "Moderate", "Low", "Critical", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum PTYCleanStrategy extends Enum<PTYCleanStrategy> implements ReflectionCall {
    private static final /* synthetic */ PTYCleanStrategy[] $VALUES = null;
    public static final PTYCleanStrategy Critical = null;
    public static final PTYCleanStrategy Low = null;
    public static final PTYCleanStrategy Moderate = null;
    public static final PTYCleanStrategy Normal = null;
    private final int code;

    private static final /* synthetic */ PTYCleanStrategy[] $values() {
        return new PTYCleanStrategy[]{Normal, Moderate, Low, Critical};
    }

    public static PTYCleanStrategy valueOf(String r100) {
        return (PTYCleanStrategy) r27.a.a(PTYCleanStrategy.class, r100);
    }

    public static PTYCleanStrategy[] values() {
        return (PTYCleanStrategy[]) $VALUES.clone();
    }

    static {
        Normal = new PTYCleanStrategy("Normal", 0, 0);
        Moderate = new PTYCleanStrategy("Moderate", 1, 1);
        Low = new PTYCleanStrategy("Low", 2, 2);
        Critical = new PTYCleanStrategy("Critical", 3, 3);
        $VALUES = $values();
    }

    public final int getCode() {
        return this.code;
    }

    private PTYCleanStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
