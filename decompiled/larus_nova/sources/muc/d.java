package muc;

import juc.n;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
public interface d {
    void encodeBooleanElement(luc.f r100, int r101, boolean r102);

    void encodeByteElement(luc.f r100, int r101, byte r102);

    void encodeCharElement(luc.f r100, int r101, char r102);

    void encodeDoubleElement(luc.f r100, int r101, double r102);

    void encodeFloatElement(luc.f r100, int r101, float r102);

    f encodeInlineElement(luc.f r100, int r101);

    void encodeIntElement(luc.f r100, int r101, int r102);

    void encodeLongElement(luc.f r100, int r101, long r102);

    @ExperimentalSerializationApi
    <T> void encodeNullableSerializableElement(luc.f r100, int r101, n<? super T> r102, T r103);

    <T> void encodeSerializableElement(luc.f r100, int r101, n<? super T> r102, T r103);

    void encodeShortElement(luc.f r100, int r101, short r102);

    void encodeStringElement(luc.f r100, int r101, String r102);

    void endStructure(luc.f r100);

    @ExperimentalSerializationApi
    boolean shouldEncodeElementDefault(luc.f r100, int r101);
}
