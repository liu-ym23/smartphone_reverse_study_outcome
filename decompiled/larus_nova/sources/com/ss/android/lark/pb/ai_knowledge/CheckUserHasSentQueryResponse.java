package com.ss.android.lark.pb.ai_knowledge;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CheckUserHasSentQueryResponse extends Message<CheckUserHasSentQueryResponse, Builder> {
    public static final ProtoAdapter<CheckUserHasSentQueryResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_SENT = null;
    private static final long serialVersionUID = 0;
    public final Boolean mhas_sent;

    public static final class Builder extends Message.Builder<CheckUserHasSentQueryResponse, Builder> {
        public Boolean mhas_sent;

        @Override // com.squareup.wire.Message.Builder
        public CheckUserHasSentQueryResponse build() {
            return new CheckUserHasSentQueryResponse(this.mhas_sent, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_sent(Boolean r100) {
            this.mhas_sent = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckUserHasSentQueryResponse extends ProtoAdapter<CheckUserHasSentQueryResponse> {
        public ProtoAdapter_CheckUserHasSentQueryResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckUserHasSentQueryResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CheckUserHasSentQueryResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mhas_sent = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mhas_sent = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(CheckUserHasSentQueryResponse r100) {
            Boolean r101 = r100.mhas_sent;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CheckUserHasSentQueryResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CheckUserHasSentQueryResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CheckUserHasSentQueryResponse r101) throws IOException {
            Boolean r102 = r101.mhas_sent;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckUserHasSentQueryResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckUserHasSentQueryResponse();
        DEFAULT_HAS_SENT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mhas_sent = this.mhas_sent;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CheckUserHasSentQueryResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CheckUserHasSentQueryResponse(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public CheckUserHasSentQueryResponse(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mhas_sent = r100;
    }
}
