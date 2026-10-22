package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Uploading extends Message<Uploading, Builder> {
    public static final ProtoAdapter<Uploading> ADAPTER = null;
    public static final Integer DEFAULT_PROGRESS = null;
    private static final long serialVersionUID = 0;
    public final Integer progress;

    public static final class Builder extends Message.Builder<Uploading, Builder> {
        public Integer progress;

        @Override // com.squareup.wire.Message.Builder
        public Uploading build() {
            return new Uploading(this.progress, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder progress(Integer r100) {
            this.progress = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Uploading extends ProtoAdapter<Uploading> {
        public ProtoAdapter_Uploading() {
            super(FieldEncoding.LENGTH_DELIMITED, Uploading.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Uploading decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.progress = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.progress = ProtoAdapter.INT32.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Uploading r100) {
            Integer r101 = r100.progress;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Uploading decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Uploading r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Uploading r101) throws IOException {
            Integer r102 = r101.progress;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Uploading r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Uploading();
        DEFAULT_PROGRESS = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.progress = this.progress;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Uploading.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Uploading(Integer r100) {
        this(r100, ByteString.EMPTY);
    }

    public Uploading(Integer r100, ByteString r101) {
        super(ADAPTER, r101);
        this.progress = r100;
    }
}
