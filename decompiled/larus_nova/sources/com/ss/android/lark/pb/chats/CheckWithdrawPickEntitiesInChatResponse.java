package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CheckWithdrawPickEntitiesInChatResponse extends Message<CheckWithdrawPickEntitiesInChatResponse, Builder> {
    public static final ProtoAdapter<CheckWithdrawPickEntitiesInChatResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Boolean> mallow_withdraw;

    public static final class Builder extends Message.Builder<CheckWithdrawPickEntitiesInChatResponse, Builder> {
        public Map<String, Boolean> mallow_withdraw;

        @Override // com.squareup.wire.Message.Builder
        public CheckWithdrawPickEntitiesInChatResponse build() {
            return new CheckWithdrawPickEntitiesInChatResponse(this.mallow_withdraw, super.buildUnknownFields());
        }

        public Builder() {
            this.mallow_withdraw = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder allow_withdraw(Map<String, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.mallow_withdraw = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckWithdrawPickEntitiesInChatResponse extends ProtoAdapter<CheckWithdrawPickEntitiesInChatResponse> {
        private final ProtoAdapter<Map<String, Boolean>> mallow_withdraw;

        public ProtoAdapter_CheckWithdrawPickEntitiesInChatResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckWithdrawPickEntitiesInChatResponse.class);
            this.mallow_withdraw = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CheckWithdrawPickEntitiesInChatResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mallow_withdraw.putAll(this.mallow_withdraw.decode(r100));
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
        public int encodedSize2(CheckWithdrawPickEntitiesInChatResponse r100) {
            return this.mallow_withdraw.encodedSizeWithTag(1, r100.mallow_withdraw) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CheckWithdrawPickEntitiesInChatResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CheckWithdrawPickEntitiesInChatResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CheckWithdrawPickEntitiesInChatResponse r101) throws IOException {
            this.mallow_withdraw.encodeWithTag(r100, 1, r101.mallow_withdraw);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckWithdrawPickEntitiesInChatResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckWithdrawPickEntitiesInChatResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mallow_withdraw = Internal.copyOf("mallow_withdraw", this.mallow_withdraw);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CheckWithdrawPickEntitiesInChatResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CheckWithdrawPickEntitiesInChatResponse(Map<String, Boolean> r100) {
        this(r100, ByteString.EMPTY);
    }

    public CheckWithdrawPickEntitiesInChatResponse(Map<String, Boolean> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mallow_withdraw = Internal.immutableCopyOf("mallow_withdraw", r100);
    }
}
