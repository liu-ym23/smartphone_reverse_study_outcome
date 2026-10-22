package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetPinReadStatusResponse extends Message<GetPinReadStatusResponse, Builder> {
    public static final ProtoAdapter<GetPinReadStatusResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_UNREAD_PIN = null;
    public static final ProtoAdapter_GetPinReadStatusResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean has_unread_pin;

    public static final class Builder extends Message.Builder<GetPinReadStatusResponse, Builder> implements d<GetPinReadStatusResponse> {
        public Boolean has_unread_pin;

        @Override // com.squareup.wire.Message.Builder
        public GetPinReadStatusResponse build() {
            Boolean r100 = this.has_unread_pin;
            if (r100 == null) goto L7;
            return new GetPinReadStatusResponse(this.has_unread_pin, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "has_unread_pin"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_unread_pin(Boolean r100) {
            this.has_unread_pin = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPinReadStatusResponse extends ProtoAdapter<GetPinReadStatusResponse> implements c<GetPinReadStatusResponse> {
        public ProtoAdapter_GetPinReadStatusResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPinReadStatusResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPinReadStatusResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_unread_pin = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.has_unread_pin = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetPinReadStatusResponse r100) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.has_unread_pin) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPinReadStatusResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPinReadStatusResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPinReadStatusResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.has_unread_pin);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPinReadStatusResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPinReadStatusResponse r100 = new ProtoAdapter_GetPinReadStatusResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_UNREAD_PIN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.has_unread_pin = this.has_unread_pin;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPinReadStatusResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPinReadStatusResponse(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetPinReadStatusResponse(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.has_unread_pin = r100;
    }
}
