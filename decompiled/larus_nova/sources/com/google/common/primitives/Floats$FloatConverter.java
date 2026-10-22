package com.google.common.primitives;

import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.google.common.base.Converter;
import java.io.Serializable;

/* JADX INFO: loaded from: classes23.dex */
final class Floats$FloatConverter extends Converter<String, Float> implements Serializable {
    static final Floats$FloatConverter INSTANCE = null;
    private static final long serialVersionUID = 1;

    public String toString() {
        return "Floats.stringConverter()";
    }

    static {
        INSTANCE = new Floats$FloatConverter();
    }

    private Floats$FloatConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Converter
    public /* bridge */ /* synthetic */ String doBackward(Float r100) {
        return doBackward2(r100);
    }

    @Override // com.google.common.base.Converter
    public /* bridge */ /* synthetic */ Float doForward(String r100) {
        return doForward2(r100);
    }

    /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
    public String doBackward2(Float r100) {
        return r100.toString();
    }

    /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
    public Float doForward2(String r100) {
        return CastFloatProtector.valueOf(r100);
    }
}
