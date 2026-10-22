package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.TranslateInfo;
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
public final class GetMessageTranslateInfosResponse extends Message<GetMessageTranslateInfosResponse, Builder> {
    public static final ProtoAdapter<GetMessageTranslateInfosResponse> ADAPTER = null;
    public static final ProtoAdapter_GetMessageTranslateInfosResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TranslateInfo> message_translate_infos;
    public final TranslateInfo origin_message;

    public static final class Builder extends Message.Builder<GetMessageTranslateInfosResponse, Builder> implements d<GetMessageTranslateInfosResponse> {
        public List<TranslateInfo> message_translate_infos;
        public TranslateInfo origin_message;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageTranslateInfosResponse build() {
            return new GetMessageTranslateInfosResponse(this.message_translate_infos, this.origin_message, super.buildUnknownFields());
        }

        public Builder() {
            this.message_translate_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_translate_infos(List<TranslateInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_translate_infos = r100;
            return this;
        }

        public Builder origin_message(TranslateInfo r100) {
            this.origin_message = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMessageTranslateInfosResponse extends ProtoAdapter<GetMessageTranslateInfosResponse> implements c<GetMessageTranslateInfosResponse> {
        public ProtoAdapter_GetMessageTranslateInfosResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageTranslateInfosResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessageTranslateInfosResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.message_translate_infos.add(TranslateInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.origin_message = TranslateInfo.ADAPTER.decode(r100);
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
        public int encodedSize2(GetMessageTranslateInfosResponse r100) {
            ProtoAdapter<TranslateInfo> r101 = TranslateInfo.ADAPTER;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.message_translate_infos);
            TranslateInfo r103 = r100.origin_message;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(2, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMessageTranslateInfosResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageTranslateInfosResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageTranslateInfosResponse r101) throws IOException {
            ProtoAdapter<TranslateInfo> r102 = TranslateInfo.ADAPTER;
            r102.asRepeated().encodeWithTag(r100, 1, r101.message_translate_infos);
            TranslateInfo r103 = r101.origin_message;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageTranslateInfosResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMessageTranslateInfosResponse r100 = new ProtoAdapter_GetMessageTranslateInfosResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_translate_infos = Internal.copyOf("message_translate_infos", this.message_translate_infos);
        r100.origin_message = this.origin_message;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageTranslateInfosResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageTranslateInfosResponse(List<TranslateInfo> r100, TranslateInfo r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetMessageTranslateInfosResponse(List<TranslateInfo> r100, TranslateInfo r101, ByteString r102) {
        super(ADAPTER, r102);
        this.message_translate_infos = Internal.immutableCopyOf("message_translate_infos", r100);
        this.origin_message = r101;
    }
}
