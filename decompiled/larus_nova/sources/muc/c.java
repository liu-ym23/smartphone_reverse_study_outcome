package muc;

import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
public interface c {
    boolean decodeBooleanElement(luc.f r100, int r101);

    byte decodeByteElement(luc.f r100, int r101);

    char decodeCharElement(luc.f r100, int r101);

    int decodeCollectionSize(luc.f r100);

    double decodeDoubleElement(luc.f r100, int r101);

    int decodeElementIndex(luc.f r100);

    float decodeFloatElement(luc.f r100, int r101);

    e decodeInlineElement(luc.f r100, int r101);

    int decodeIntElement(luc.f r100, int r101);

    long decodeLongElement(luc.f r100, int r101);

    @ExperimentalSerializationApi
    <T> T decodeNullableSerializableElement(luc.f r100, int r101, juc.c<? extends T> r102, T r103);

    @ExperimentalSerializationApi
    boolean decodeSequentially();

    <T> T decodeSerializableElement(luc.f r100, int r101, juc.c<? extends T> r102, T r103);

    short decodeShortElement(luc.f r100, int r101);

    String decodeStringElement(luc.f r100, int r101);

    void endStructure(luc.f r100);

    kotlinx.serialization.modules.d getSerializersModule();
}
