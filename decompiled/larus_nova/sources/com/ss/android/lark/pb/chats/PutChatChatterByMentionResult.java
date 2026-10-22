package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PutChatChatterByMentionResult extends Message<PutChatChatterByMentionResult, Builder> {
    public static final ProtoAdapter<PutChatChatterByMentionResult> ADAPTER = null;
    public static final Long DEFAULT_CHATTER_ID = null;
    public static final Boolean DEFAULT_JOIN_RESULT = null;
    private static final long serialVersionUID = 0;
    public final Long mchatter_id;
    public final Boolean mjoin_result;

    public static final class Builder extends Message.Builder<PutChatChatterByMentionResult, Builder> {
        public Long mchatter_id;
        public Boolean mjoin_result;

        @Override // com.squareup.wire.Message.Builder
        public PutChatChatterByMentionResult build() {
            Long r100 = this.mchatter_id;
            if (r100 == null) goto L9;
            if (this.mjoin_result == null) goto L9;
            return new PutChatChatterByMentionResult(this.mchatter_id, this.mjoin_result, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mchatter_id", this.mjoin_result, "mjoin_result"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_id(Long r100) {
            this.mchatter_id = r100;
            return this;
        }

        public Builder join_result(Boolean r100) {
            this.mjoin_result = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutChatChatterByMentionResult extends ProtoAdapter<PutChatChatterByMentionResult> {
        public ProtoAdapter_PutChatChatterByMentionResult() {
            super(FieldEncoding.LENGTH_DELIMITED, PutChatChatterByMentionResult.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutChatChatterByMentionResult decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchatter_id = 0L;
            r101.mjoin_result = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mchatter_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mjoin_result = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(PutChatChatterByMentionResult r100) {
            return (ProtoAdapter.INT64.encodedSizeWithTag(1, r100.mchatter_id) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.mjoin_result)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutChatChatterByMentionResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutChatChatterByMentionResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutChatChatterByMentionResult r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.mchatter_id);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.mjoin_result);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutChatChatterByMentionResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutChatChatterByMentionResult();
        DEFAULT_CHATTER_ID = 0L;
        DEFAULT_JOIN_RESULT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchatter_id = this.mchatter_id;
        r100.mjoin_result = this.mjoin_result;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutChatChatterByMentionResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutChatChatterByMentionResult(Long r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PutChatChatterByMentionResult(Long r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mchatter_id = r100;
        this.mjoin_result = r101;
    }
}
