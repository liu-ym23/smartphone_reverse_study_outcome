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
public final class GetMessageLanguageRequest extends Message<GetMessageLanguageRequest, Builder> {
    public static final ProtoAdapter<GetMessageLanguageRequest> ADAPTER = null;
    public static final ProtoAdapter_GetMessageLanguageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> message_ids;

    public static final class Builder extends Message.Builder<GetMessageLanguageRequest, Builder> implements d<GetMessageLanguageRequest> {
        public List<String> message_ids;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageLanguageRequest build() {
            return new GetMessageLanguageRequest(this.message_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.message_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMessageLanguageRequest extends ProtoAdapter<GetMessageLanguageRequest> implements c<GetMessageLanguageRequest> {
        public ProtoAdapter_GetMessageLanguageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageLanguageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessageLanguageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.message_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GetMessageLanguageRequest r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.message_ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMessageLanguageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageLanguageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageLanguageRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.message_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageLanguageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMessageLanguageRequest r100 = new ProtoAdapter_GetMessageLanguageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageLanguageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageLanguageRequest(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetMessageLanguageRequest(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.message_ids = Internal.immutableCopyOf("message_ids", r100);
    }
}
