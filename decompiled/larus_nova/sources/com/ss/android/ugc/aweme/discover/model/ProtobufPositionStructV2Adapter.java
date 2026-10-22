package com.ss.android.ugc.aweme.discover.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/ProtobufPositionStructV2Adapter;", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/ss/android/ugc/aweme/discover/model/Position;", "()V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProtobufPositionStructV2Adapter extends ProtoAdapter<Position> {
    /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
    public Position redact2(Position r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return r100;
    }

    public ProtobufPositionStructV2Adapter() {
        super(FieldEncoding.LENGTH_DELIMITED, Position.class);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.wire.ProtoAdapter
    public Position decode(ProtoReader r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        Position r101 = new Position();
        long r102 = r100.beginMessage();
    L3:
        int r103 = r100.nextTag();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.begin = ProtoAdapter.INT32.decode(r100).intValue();
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.end = ProtoAdapter.INT32.decode(r100).intValue();
        goto L3
    L9:
        r100.skip();
        goto L3
    L12:
        r100.endMessage(r102);
        return r101;
    }

    /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
    public int encodedSize2(Position r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
        return r101.encodedSizeWithTag(1, Integer.valueOf(r100.begin)) + r101.encodedSizeWithTag(2, Integer.valueOf(r100.end));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Position redact(Position r100) {
        return redact2(r100);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Position decode(ProtoReader r100) {
        return decode(r100);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Position r100) {
        return encodedSize2(r100);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ProtoWriter r100, Position r101) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r101, "value");
        ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
        r102.encodeWithTag(r100, 1, Integer.valueOf(r101.begin));
        r102.encodeWithTag(r100, 2, Integer.valueOf(r101.end));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Position r101) {
        encode2(r100, r101);
    }
}
