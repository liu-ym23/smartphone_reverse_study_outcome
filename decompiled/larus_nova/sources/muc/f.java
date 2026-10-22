package muc;

import juc.n;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
public interface f {

    public static final class a {
        @ExperimentalSerializationApi
        public static <T> void a(f r100, n<? super T> r101, T r102) {
            Intrinsics.checkNotNullParameter(r101, "serializer");
            if (r101.getDescriptor().a() == false) goto L6;
            r100.encodeSerializableValue(r101, r102);
            return;
        L6:
            if (r102 != null) goto L8;
            r100.encodeNull();
            return;
        L8:
            r100.encodeNotNullMark();
            r100.encodeSerializableValue(r101, r102);
        }
    }

    d beginCollection(luc.f r100, int r101);

    d beginStructure(luc.f r100);

    void encodeBoolean(boolean r100);

    void encodeByte(byte r100);

    void encodeChar(char r100);

    void encodeDouble(double r100);

    void encodeEnum(luc.f r100, int r101);

    void encodeFloat(float r100);

    f encodeInline(luc.f r100);

    void encodeInt(int r100);

    void encodeLong(long r100);

    @ExperimentalSerializationApi
    void encodeNotNullMark();

    @ExperimentalSerializationApi
    void encodeNull();

    <T> void encodeSerializableValue(n<? super T> r100, T r101);

    void encodeShort(short r100);

    void encodeString(String r100);

    kotlinx.serialization.modules.d getSerializersModule();
}
