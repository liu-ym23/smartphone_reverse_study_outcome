package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullDocFeedCardsRequest extends Message<PullDocFeedCardsRequest, Builder> {
    public static final ProtoAdapter<PullDocFeedCardsRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_NEED_AGENT = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_need_agent;

    public static final class Builder extends Message.Builder<PullDocFeedCardsRequest, Builder> {
        public Boolean mis_need_agent;

        @Override // com.squareup.wire.Message.Builder
        public PullDocFeedCardsRequest build() {
            return new PullDocFeedCardsRequest(this.mis_need_agent, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_need_agent(Boolean r100) {
            this.mis_need_agent = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDocFeedCardsRequest extends ProtoAdapter<PullDocFeedCardsRequest> {
        public ProtoAdapter_PullDocFeedCardsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDocFeedCardsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullDocFeedCardsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_need_agent = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mis_need_agent = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(PullDocFeedCardsRequest r100) {
            Boolean r101 = r100.mis_need_agent;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullDocFeedCardsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullDocFeedCardsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullDocFeedCardsRequest r101) throws IOException {
            Boolean r102 = r101.mis_need_agent;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullDocFeedCardsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullDocFeedCardsRequest();
        DEFAULT_IS_NEED_AGENT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_need_agent = this.mis_need_agent;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullDocFeedCardsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullDocFeedCardsRequest(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullDocFeedCardsRequest(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mis_need_agent = r100;
    }
}
