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
public final class GetBotsResponse extends Message<GetBotsResponse, Builder> {
    public static final ProtoAdapter<GetBotsResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final ProtoAdapter_GetBotsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Chatter> bots;
    public final Boolean has_more;

    public static final class Builder extends Message.Builder<GetBotsResponse, Builder> implements d<GetBotsResponse> {
        public List<Chatter> bots;
        public Boolean has_more;

        @Override // com.squareup.wire.Message.Builder
        public GetBotsResponse build() {
            return new GetBotsResponse(this.has_more, this.bots, super.buildUnknownFields());
        }

        public Builder() {
            this.bots = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bots(List<Chatter> r100) {
            Internal.checkElementsNotNull(r100);
            this.bots = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetBotsResponse extends ProtoAdapter<GetBotsResponse> implements c<GetBotsResponse> {
        public ProtoAdapter_GetBotsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetBotsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetBotsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.bots.add(Chatter.ADAPTER.decode(r100));
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
        public int encodedSize2(GetBotsResponse r100) {
            Boolean r101 = r100.has_more;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + Chatter.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.bots)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetBotsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetBotsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetBotsResponse r101) throws IOException {
            Boolean r102 = r101.has_more;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Chatter.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.bots);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetBotsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetBotsResponse r100 = new ProtoAdapter_GetBotsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.has_more = this.has_more;
        r100.bots = Internal.copyOf("bots", this.bots);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetBotsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetBotsResponse(Boolean r100, List<Chatter> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetBotsResponse(Boolean r100, List<Chatter> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.has_more = r100;
        this.bots = Internal.immutableCopyOf("bots", r101);
    }
}
