package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetMyAIChatterResponse extends Message<GetMyAIChatterResponse, Builder> {
    public static final ProtoAdapter<GetMyAIChatterResponse> ADAPTER = null;
    public static final ProtoAdapter_GetMyAIChatterResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Chatter my_ai;

    public static final class Builder extends Message.Builder<GetMyAIChatterResponse, Builder> implements d<GetMyAIChatterResponse> {
        public Chatter my_ai;

        @Override // com.squareup.wire.Message.Builder
        public GetMyAIChatterResponse build() {
            return new GetMyAIChatterResponse(this.my_ai, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder my_ai(Chatter r100) {
            this.my_ai = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMyAIChatterResponse extends ProtoAdapter<GetMyAIChatterResponse> implements c<GetMyAIChatterResponse> {
        public ProtoAdapter_GetMyAIChatterResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMyAIChatterResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMyAIChatterResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.my_ai = Chatter.ADAPTER.decode(r100);
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
        public int encodedSize2(GetMyAIChatterResponse r100) {
            Chatter r101 = r100.my_ai;
            if (r101 == null) goto L5;
            int r102 = Chatter.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMyAIChatterResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMyAIChatterResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMyAIChatterResponse r101) throws IOException {
            Chatter r102 = r101.my_ai;
            if (r102 == null) goto L5;
            Chatter.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMyAIChatterResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMyAIChatterResponse r100 = new ProtoAdapter_GetMyAIChatterResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.my_ai = this.my_ai;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMyAIChatterResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMyAIChatterResponse(Chatter r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetMyAIChatterResponse(Chatter r100, ByteString r101) {
        super(ADAPTER, r101);
        this.my_ai = r100;
    }
}
