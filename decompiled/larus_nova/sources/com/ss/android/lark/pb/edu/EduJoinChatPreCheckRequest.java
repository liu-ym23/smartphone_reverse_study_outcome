package com.ss.android.lark.pb.edu;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class EduJoinChatPreCheckRequest extends Message<EduJoinChatPreCheckRequest, Builder> {
    public static final ProtoAdapter<EduJoinChatPreCheckRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final List<String> muser_ids;

    public static final class Builder extends Message.Builder<EduJoinChatPreCheckRequest, Builder> {
        public String mchat_id;
        public List<String> muser_ids;

        @Override // com.squareup.wire.Message.Builder
        public EduJoinChatPreCheckRequest build() {
            String r100 = this.mchat_id;
            if (r100 == null) goto L7;
            return new EduJoinChatPreCheckRequest(this.mchat_id, this.muser_ids, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mchat_id"});
        }

        public Builder() {
            this.muser_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder user_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.muser_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EduJoinChatPreCheckRequest extends ProtoAdapter<EduJoinChatPreCheckRequest> {
        public ProtoAdapter_EduJoinChatPreCheckRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, EduJoinChatPreCheckRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EduJoinChatPreCheckRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.muser_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(EduJoinChatPreCheckRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.mchat_id) + r101.asRepeated().encodedSizeWithTag(2, r100.muser_ids)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EduJoinChatPreCheckRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EduJoinChatPreCheckRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EduJoinChatPreCheckRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mchat_id);
            r102.asRepeated().encodeWithTag(r100, 2, r101.muser_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EduJoinChatPreCheckRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EduJoinChatPreCheckRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EduJoinChatPreCheckRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EduJoinChatPreCheckRequest(String r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public EduJoinChatPreCheckRequest(String r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mchat_id = r100;
        this.muser_ids = Internal.immutableCopyOf("muser_ids", r101);
    }
}
