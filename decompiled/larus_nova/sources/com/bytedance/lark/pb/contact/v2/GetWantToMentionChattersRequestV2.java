package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.Chat;
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
public final class GetWantToMentionChattersRequestV2 extends Message<GetWantToMentionChattersRequestV2, Builder> {
    public static final ProtoAdapter<GetWantToMentionChattersRequestV2> ADAPTER = null;
    public static final Integer DEFAULT_IM_MENTION_COUNT = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_GetWantToMentionChattersRequestV2 RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer im_mention_count;
    public final SyncDataStrategy strategy;
    public final List<ForwardTargetInfo> target_infos;

    public static final class Builder extends Message.Builder<GetWantToMentionChattersRequestV2, Builder> implements d<GetWantToMentionChattersRequestV2> {
        public Integer im_mention_count;
        public SyncDataStrategy strategy;
        public List<ForwardTargetInfo> target_infos;

        @Override // com.squareup.wire.Message.Builder
        public GetWantToMentionChattersRequestV2 build() {
            return new GetWantToMentionChattersRequestV2(this.target_infos, this.strategy, this.im_mention_count, super.buildUnknownFields());
        }

        public Builder() {
            this.target_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder im_mention_count(Integer r100) {
            this.im_mention_count = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }

        public Builder target_infos(List<ForwardTargetInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.target_infos = r100;
            return this;
        }
    }

    public static final class ForwardTargetInfo extends Message<ForwardTargetInfo, Builder> {
        public static final ProtoAdapter<ForwardTargetInfo> ADAPTER = null;
        public static final Chat.Type DEFAULT_CHAT_TYPE = null;
        public static final String DEFAULT_TARGET_ID = "";
        private static final long serialVersionUID = 0;
        public final Chat.Type chat_type;
        public final String target_id;

        public static final class Builder extends Message.Builder<ForwardTargetInfo, Builder> {
            public Chat.Type chat_type;
            public String target_id;

            @Override // com.squareup.wire.Message.Builder
            public ForwardTargetInfo build() {
                return new ForwardTargetInfo(this.chat_type, this.target_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_type(Chat.Type r100) {
                this.chat_type = r100;
                return this;
            }

            public Builder target_id(String r100) {
                this.target_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ForwardTargetInfo extends ProtoAdapter<ForwardTargetInfo> {
            public ProtoAdapter_ForwardTargetInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ForwardTargetInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ForwardTargetInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chat_type = Chat.Type.P2P;
                r101.target_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.chat_type = Chat.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.target_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ForwardTargetInfo r100) {
                Chat.Type r101 = r100.chat_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Chat.Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.target_id;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ForwardTargetInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ForwardTargetInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ForwardTargetInfo r101) throws IOException {
                Chat.Type r102 = r101.chat_type;
                if (r102 == null) goto L5;
                Chat.Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.target_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ForwardTargetInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ForwardTargetInfo();
            DEFAULT_CHAT_TYPE = Chat.Type.P2P;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chat_type = this.chat_type;
            r100.target_id = this.target_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ForwardTargetInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ForwardTargetInfo(Chat.Type r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ForwardTargetInfo(Chat.Type r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.chat_type = r100;
            this.target_id = r101;
        }
    }

    public static final class ProtoAdapter_GetWantToMentionChattersRequestV2 extends ProtoAdapter<GetWantToMentionChattersRequestV2> implements c<GetWantToMentionChattersRequestV2> {
        public ProtoAdapter_GetWantToMentionChattersRequestV2() {
            super(FieldEncoding.LENGTH_DELIMITED, GetWantToMentionChattersRequestV2.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetWantToMentionChattersRequestV2 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.strategy = SyncDataStrategy.LOCAL;
            r101.im_mention_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.target_infos.add(ForwardTargetInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.im_mention_count = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(GetWantToMentionChattersRequestV2 r100) {
            int r101 = ForwardTargetInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.target_infos);
            SyncDataStrategy r102 = r100.strategy;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Integer r106 = r100.im_mention_count;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.INT32.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetWantToMentionChattersRequestV2 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetWantToMentionChattersRequestV2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetWantToMentionChattersRequestV2 r101) throws IOException {
            ForwardTargetInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.target_infos);
            SyncDataStrategy r102 = r101.strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Integer r103 = r101.im_mention_count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetWantToMentionChattersRequestV2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetWantToMentionChattersRequestV2 r100 = new ProtoAdapter_GetWantToMentionChattersRequestV2();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STRATEGY = SyncDataStrategy.LOCAL;
        DEFAULT_IM_MENTION_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.target_infos = Internal.copyOf("target_infos", this.target_infos);
        r100.strategy = this.strategy;
        r100.im_mention_count = this.im_mention_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetWantToMentionChattersRequestV2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetWantToMentionChattersRequestV2(List<ForwardTargetInfo> r100, SyncDataStrategy r101, Integer r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetWantToMentionChattersRequestV2(List<ForwardTargetInfo> r100, SyncDataStrategy r101, Integer r102, ByteString r103) {
        super(ADAPTER, r103);
        this.target_infos = Internal.immutableCopyOf("target_infos", r100);
        this.strategy = r101;
        this.im_mention_count = r102;
    }
}
