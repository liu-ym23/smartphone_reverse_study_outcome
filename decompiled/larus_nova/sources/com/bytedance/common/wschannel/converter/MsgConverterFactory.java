package com.bytedance.common.wschannel.converter;

/* JADX INFO: loaded from: classes3.dex */
public class MsgConverterFactory {
    private static MsgConverter DEFAULT;
    private static MsgConverter sConverter;

    static {
        WireConverter r100 = new WireConverter();
        DEFAULT = r100;
        sConverter = r100;
    }

    public static MsgConverter getConverter() {
        return sConverter;
    }
}
