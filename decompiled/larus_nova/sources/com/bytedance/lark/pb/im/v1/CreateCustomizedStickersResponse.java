package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CreateCustomizedStickersResponse extends Message<CreateCustomizedStickersResponse, Builder> {
    public static final ProtoAdapter<CreateCustomizedStickersResponse> ADAPTER = null;
    public static final ProtoAdapter_CreateCustomizedStickersResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<DuplicateSticker> dup_stickers;
    public final List<String> failed_paths;

    public static final class Builder extends Message.Builder<CreateCustomizedStickersResponse, Builder> implements d<CreateCustomizedStickersResponse> {
        public List<DuplicateSticker> dup_stickers;
        public List<String> failed_paths;

        @Override // com.squareup.wire.Message.Builder
        public CreateCustomizedStickersResponse build() {
            return new CreateCustomizedStickersResponse(this.failed_paths, this.dup_stickers, super.buildUnknownFields());
        }

        public Builder() {
            this.failed_paths = Internal.newMutableList();
            this.dup_stickers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder dup_stickers(List<DuplicateSticker> r100) {
            Internal.checkElementsNotNull(r100);
            this.dup_stickers = r100;
            return this;
        }

        public Builder failed_paths(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.failed_paths = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateCustomizedStickersResponse extends ProtoAdapter<CreateCustomizedStickersResponse> implements c<CreateCustomizedStickersResponse> {
        public ProtoAdapter_CreateCustomizedStickersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateCustomizedStickersResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateCustomizedStickersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.failed_paths.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.dup_stickers.add(DuplicateSticker.ADAPTER.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CreateCustomizedStickersResponse r100) {
            return (ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.failed_paths) + DuplicateSticker.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.dup_stickers)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateCustomizedStickersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateCustomizedStickersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateCustomizedStickersResponse r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.failed_paths);
            DuplicateSticker.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.dup_stickers);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateCustomizedStickersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateCustomizedStickersResponse r100 = new ProtoAdapter_CreateCustomizedStickersResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.failed_paths = Internal.copyOf("failed_paths", this.failed_paths);
        r100.dup_stickers = Internal.copyOf("dup_stickers", this.dup_stickers);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateCustomizedStickersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateCustomizedStickersResponse(List<String> r100, List<DuplicateSticker> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CreateCustomizedStickersResponse(List<String> r100, List<DuplicateSticker> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.failed_paths = Internal.immutableCopyOf("failed_paths", r100);
        this.dup_stickers = Internal.immutableCopyOf("dup_stickers", r101);
    }
}
