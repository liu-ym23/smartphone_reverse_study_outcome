package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYNativeService;", "", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "(Ljava/lang/String;I)V", "Normal", "Porn", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum PTYNativeService extends Enum<PTYNativeService> implements ReflectionCall {
    private static final /* synthetic */ PTYNativeService[] $VALUES = null;
    public static final PTYNativeService Normal = null;
    public static final PTYNativeService Porn = null;

    private static final /* synthetic */ PTYNativeService[] $values() {
        return new PTYNativeService[]{Normal, Porn};
    }

    public static PTYNativeService valueOf(String r100) {
        return (PTYNativeService) r27.a.a(PTYNativeService.class, r100);
    }

    public static PTYNativeService[] values() {
        return (PTYNativeService[]) $VALUES.clone();
    }

    static {
        Normal = new PTYNativeService("Normal", 0);
        Porn = new PTYNativeService("Porn", 1);
        $VALUES = $values();
    }

    private PTYNativeService(String r100, int r101) {
        super(r100, r101);
    }
}
