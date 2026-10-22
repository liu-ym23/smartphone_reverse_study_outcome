package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
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
public final class GetChatChattersByIdsRequest extends Message<GetChatChattersByIdsRequest, Builder> {
    public static final ProtoAdapter<GetChatChattersByIdsRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Boolean DEFAULT_IGNORE_LOCAL = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_GetChatChattersByIdsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final List<String> chatter_ids;
    public final Boolean ignore_local;
    public final SyncDataStrategy strategy;

    public static final class Builder extends Message.Builder<GetChatChattersByIdsRequest, Builder> implements d<GetChatChattersByIdsRequest> {
        public String chat_id;
        public List<String> chatter_ids;
        public Boolean ignore_local;
        public SyncDataStrategy strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetChatChattersByIdsRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new GetChatChattersByIdsRequest(this.chat_id, this.chatter_ids, this.ignore_local, this.strategy, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
            this.chatter_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_ids = r100;
            return this;
        }

        public Builder ignore_local(Boolean r100) {
            this.ignore_local = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatChattersByIdsRequest extends ProtoAdapter<GetChatChattersByIdsRequest> implements c<GetChatChattersByIdsRequest> {
        public ProtoAdapter_GetChatChattersByIdsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatChattersByIdsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatChattersByIdsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.ignore_local = Boolean.FALSE;
            r101.strategy = SyncDataStrategy.TRY_LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.ignore_local = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetChatChattersByIdsRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.chat_id) + r101.asRepeated().encodedSizeWithTag(2, r100.chatter_ids);
            Boolean r103 = r100.ignore_local;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            SyncDataStrategy r107 = r100.strategy;
            if (r107 == null) goto L10;
            r104 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(4, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatChattersByIdsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatChattersByIdsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatChattersByIdsRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chat_id);
            r102.asRepeated().encodeWithTag(r100, 2, r101.chatter_ids);
            Boolean r103 = r101.ignore_local;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L5:
            SyncDataStrategy r104 = r101.strategy;
            if (r104 == null) goto L8;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatChattersByIdsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatChattersByIdsRequest r100 = new ProtoAdapter_GetChatChattersByIdsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IGNORE_LOCAL = Boolean.FALSE;
        DEFAULT_STRATEGY = SyncDataStrategy.TRY_LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r100.ignore_local = this.ignore_local;
        r100.strategy = this.strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatChattersByIdsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatChattersByIdsRequest(String r100, List<String> r101, Boolean r102, SyncDataStrategy r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetChatChattersByIdsRequest(String r100, List<String> r101, Boolean r102, SyncDataStrategy r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_id = r100;
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r101);
        this.ignore_local = r102;
        this.strategy = r103;
    }
}
