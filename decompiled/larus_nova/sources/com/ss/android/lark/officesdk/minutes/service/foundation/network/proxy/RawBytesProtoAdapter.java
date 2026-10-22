package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/RawBytesProtoAdapter;", "Lcom/squareup/wire/ProtoAdapter;", "", "<init>", "()V", "encodedSize", "", "value", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "redact", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class RawBytesProtoAdapter extends ProtoAdapter<byte[]> {
    public static final RawBytesProtoAdapter INSTANCE = null;

    static {
        INSTANCE = new RawBytesProtoAdapter();
    }

    @Override // com.squareup.wire.ProtoAdapter
    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public byte[] decode2(ProtoReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return new byte[0];
    }

    /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
    public byte[] redact2(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return r100;
    }

    private RawBytesProtoAdapter() {
        super(FieldEncoding.LENGTH_DELIMITED, byte[].class);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ byte[] decode(ProtoReader r100) {
        return decode2(r100);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(byte[] r100) {
        return encodedSize2(r100);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ byte[] redact(byte[] r100) {
        return redact2(r100);
    }

    /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
    public int encodedSize2(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return r100.length;
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ProtoWriter r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r101, "value");
        ByteString.a r102 = ByteString.Companion;
        byte[] r103 = Arrays.copyOf(r101, r101.length);
        r102.getClass();
        r100.writeBytes(ByteString.a.c(r103));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, byte[] r101) {
        encode2(r100, r101);
    }
}
