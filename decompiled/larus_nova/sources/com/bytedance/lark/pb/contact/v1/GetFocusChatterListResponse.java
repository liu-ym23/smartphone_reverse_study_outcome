package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.Chatter;
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
public final class GetFocusChatterListResponse extends Message<GetFocusChatterListResponse, Builder> {
    public static final ProtoAdapter<GetFocusChatterListResponse> ADAPTER = null;
    public static final ProtoAdapter_GetFocusChatterListResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Chatter> chatters;

    public static final class Builder extends Message.Builder<GetFocusChatterListResponse, Builder> implements d<GetFocusChatterListResponse> {
        public List<Chatter> chatters;

        @Override // com.squareup.wire.Message.Builder
        public GetFocusChatterListResponse build() {
            return new GetFocusChatterListResponse(this.chatters, super.buildUnknownFields());
        }

        public Builder() {
            this.chatters = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatters(List<Chatter> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatters = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetFocusChatterListResponse extends ProtoAdapter<GetFocusChatterListResponse> implements c<GetFocusChatterListResponse> {
        public ProtoAdapter_GetFocusChatterListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetFocusChatterListResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetFocusChatterListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.chatters.add(Chatter.ADAPTER.decode(r100));
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
        public int encodedSize2(GetFocusChatterListResponse r100) {
            return Chatter.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.chatters) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetFocusChatterListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetFocusChatterListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetFocusChatterListResponse r101) throws IOException {
            Chatter.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.chatters);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetFocusChatterListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetFocusChatterListResponse r100 = new ProtoAdapter_GetFocusChatterListResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatters = Internal.copyOf("chatters", this.chatters);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetFocusChatterListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetFocusChatterListResponse(List<Chatter> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetFocusChatterListResponse(List<Chatter> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.chatters = Internal.immutableCopyOf("chatters", r100);
    }
}
