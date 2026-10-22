package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

/* JADX INFO: loaded from: classes23.dex */
final class Shorts$ShortConverter extends Converter<String, Short> implements Serializable {
    static final Shorts$ShortConverter INSTANCE = null;
    private static final long serialVersionUID = 1;

    public String toString() {
        return "Shorts.stringConverter()";
    }

    static {
        INSTANCE = new Shorts$ShortConverter();
    }

    private Shorts$ShortConverter() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Converter
    public /* bridge */ /* synthetic */ String doBackward(Short r100) {
        return doBackward2(r100);
    }

    @Override // com.google.common.base.Converter
    public /* bridge */ /* synthetic */ Short doForward(String r100) {
        return doForward2(r100);
    }

    /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
    public String doBackward2(Short r100) {
        return r100.toString();
    }

    /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
    public Short doForward2(String r100) {
        return Short.decode(r100);
    }
}
