package com.ss.android.lark.pb.edu;

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
public final class EduJoinChatPreCheckResponse extends Message<EduJoinChatPreCheckResponse, Builder> {
    public static final ProtoAdapter<EduJoinChatPreCheckResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Boolean> muser_ids;

    public static final class Builder extends Message.Builder<EduJoinChatPreCheckResponse, Builder> {
        public Map<String, Boolean> muser_ids;

        @Override // com.squareup.wire.Message.Builder
        public EduJoinChatPreCheckResponse build() {
            return new EduJoinChatPreCheckResponse(this.muser_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.muser_ids = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder user_ids(Map<String, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.muser_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EduJoinChatPreCheckResponse extends ProtoAdapter<EduJoinChatPreCheckResponse> {
        private final ProtoAdapter<Map<String, Boolean>> muser_ids;

        public ProtoAdapter_EduJoinChatPreCheckResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, EduJoinChatPreCheckResponse.class);
            this.muser_ids = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EduJoinChatPreCheckResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.muser_ids.putAll(this.muser_ids.decode(r100));
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
        public int encodedSize2(EduJoinChatPreCheckResponse r100) {
            return this.muser_ids.encodedSizeWithTag(1, r100.muser_ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EduJoinChatPreCheckResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EduJoinChatPreCheckResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EduJoinChatPreCheckResponse r101) throws IOException {
            this.muser_ids.encodeWithTag(r100, 1, r101.muser_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EduJoinChatPreCheckResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EduJoinChatPreCheckResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EduJoinChatPreCheckResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EduJoinChatPreCheckResponse(Map<String, Boolean> r100) {
        this(r100, ByteString.EMPTY);
    }

    public EduJoinChatPreCheckResponse(Map<String, Boolean> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.muser_ids = Internal.immutableCopyOf("muser_ids", r100);
    }
}
