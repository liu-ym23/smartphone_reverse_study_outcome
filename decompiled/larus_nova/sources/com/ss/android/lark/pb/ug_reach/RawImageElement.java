package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class RawImageElement extends Message<RawImageElement, Builder> {
    public static final ProtoAdapter<RawImageElement> ADAPTER = null;
    public static final ByteString DEFAULT_RAW_DATA = null;
    public static final ByteString DEFAULT_SECRETS = null;
    private static final long serialVersionUID = 0;
    public final ByteString mraw_data;
    public final ByteString msecrets;

    public static final class Builder extends Message.Builder<RawImageElement, Builder> {
        public ByteString mraw_data;
        public ByteString msecrets;

        @Override // com.squareup.wire.Message.Builder
        public RawImageElement build() {
            return new RawImageElement(this.mraw_data, this.msecrets, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder raw_data(ByteString r100) {
            this.mraw_data = r100;
            return this;
        }

        public Builder secrets(ByteString r100) {
            this.msecrets = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RawImageElement extends ProtoAdapter<RawImageElement> {
        public ProtoAdapter_RawImageElement() {
            super(FieldEncoding.LENGTH_DELIMITED, RawImageElement.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RawImageElement decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            ByteString r102 = ByteString.EMPTY;
            r101.mraw_data = r102;
            r101.msecrets = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L12;
            if (r104 != 1) goto L8;
            r101.mraw_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L9;
            r101.msecrets = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RawImageElement r100) {
            ByteString r101 = r100.mraw_data;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
        L6:
            ByteString r104 = r100.msecrets;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RawImageElement decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RawImageElement r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RawImageElement r101) throws IOException {
            ByteString r102 = r101.mraw_data;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101.msecrets;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RawImageElement r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RawImageElement();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_RAW_DATA = r100;
        DEFAULT_SECRETS = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mraw_data = this.mraw_data;
        r100.msecrets = this.msecrets;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RawImageElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RawImageElement(ByteString r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public RawImageElement(ByteString r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mraw_data = r100;
        this.msecrets = r101;
    }
}
