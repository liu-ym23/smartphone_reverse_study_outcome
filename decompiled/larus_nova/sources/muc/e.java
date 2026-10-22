package muc;

import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
public interface e {
    c beginStructure(luc.f r100);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(luc.f r100);

    float decodeFloat();

    e decodeInline(luc.f r100);

    int decodeInt();

    long decodeLong();

    @ExperimentalSerializationApi
    boolean decodeNotNullMark();

    @ExperimentalSerializationApi
    Void decodeNull();

    <T> T decodeSerializableValue(juc.c<? extends T> r100);

    short decodeShort();

    String decodeString();

    kotlinx.serialization.modules.d getSerializersModule();
}
