package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
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
public final class CheckPutChatChatterRequest extends Message<CheckPutChatChatterRequest, Builder> {
    public static final ProtoAdapter<CheckPutChatChatterRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final List<Long> mchatter_ids;
    public final AddChatChatterSource msource;

    public static final class Builder extends Message.Builder<CheckPutChatChatterRequest, Builder> {
        public Long mchat_id;
        public List<Long> mchatter_ids;
        public AddChatChatterSource msource;

        @Override // com.squareup.wire.Message.Builder
        public CheckPutChatChatterRequest build() {
            Long r100 = this.mchat_id;
            if (r100 == null) goto L7;
            return new CheckPutChatChatterRequest(this.mchat_id, this.mchatter_ids, this.msource, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mchat_id"});
        }

        public Builder() {
            this.mchatter_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder chatter_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mchatter_ids = r100;
            return this;
        }

        public Builder source(AddChatChatterSource r100) {
            this.msource = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckPutChatChatterRequest extends ProtoAdapter<CheckPutChatChatterRequest> {
        public ProtoAdapter_CheckPutChatChatterRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckPutChatChatterRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CheckPutChatChatterRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mchatter_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.msource = AddChatChatterSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CheckPutChatChatterRequest r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = r101.encodedSizeWithTag(1, r100.mchat_id) + r101.asRepeated().encodedSizeWithTag(2, r100.mchatter_ids);
            AddChatChatterSource r103 = r100.msource;
            if (r103 == null) goto L5;
            int r104 = AddChatChatterSource.ADAPTER.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CheckPutChatChatterRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CheckPutChatChatterRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CheckPutChatChatterRequest r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.mchat_id);
            r102.asRepeated().encodeWithTag(r100, 2, r101.mchatter_ids);
            AddChatChatterSource r103 = r101.msource;
            if (r103 == null) goto L5;
            AddChatChatterSource.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckPutChatChatterRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckPutChatChatterRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.mchatter_ids = Internal.copyOf("mchatter_ids", this.mchatter_ids);
        r100.msource = this.msource;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CheckPutChatChatterRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CheckPutChatChatterRequest(Long r100, List<Long> r101, AddChatChatterSource r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CheckPutChatChatterRequest(Long r100, List<Long> r101, AddChatChatterSource r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mchat_id = r100;
        this.mchatter_ids = Internal.immutableCopyOf("mchatter_ids", r101);
        this.msource = r102;
    }
}
