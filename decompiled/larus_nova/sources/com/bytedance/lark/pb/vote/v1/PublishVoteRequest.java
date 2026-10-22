package com.bytedance.lark.pb.vote.v1;

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
public final class PublishVoteRequest extends Message<PublishVoteRequest, Builder> {
    public static final ProtoAdapter<PublishVoteRequest> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final Boolean DEFAULT_IS_PUBLIC = null;
    public static final Long DEFAULT_MAX_PICK_NUM = null;
    public static final Long DEFAULT_MIN_PICK_NUM = null;
    public static final String DEFAULT_SCOPE_ID = "";
    public static final String DEFAULT_TOPIC = "";
    public static final VoteScopeContainerType DEFAULT_VOTE_SCENE = null;
    public static final ProtoAdapter_PublishVoteRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String cid;
    public final Boolean is_public;
    public final Long max_pick_num;
    public final Long min_pick_num;
    public final List<VoteOption> options;
    public final String scope_id;
    public final String topic;
    public final VoteScopeContainerType vote_scene;

    public static final class Builder extends Message.Builder<PublishVoteRequest, Builder> implements d<PublishVoteRequest> {
        public String cid;
        public Boolean is_public;
        public Long max_pick_num;
        public Long min_pick_num;
        public List<VoteOption> options;
        public String scope_id;
        public String topic;
        public VoteScopeContainerType vote_scene;

        @Override // com.squareup.wire.Message.Builder
        public PublishVoteRequest build() {
            return new PublishVoteRequest(this.cid, this.scope_id, this.vote_scene, this.topic, this.min_pick_num, this.max_pick_num, this.is_public, this.options, super.buildUnknownFields());
        }

        public Builder() {
            this.options = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder is_public(Boolean r100) {
            this.is_public = r100;
            return this;
        }

        public Builder max_pick_num(Long r100) {
            this.max_pick_num = r100;
            return this;
        }

        public Builder min_pick_num(Long r100) {
            this.min_pick_num = r100;
            return this;
        }

        public Builder options(List<VoteOption> r100) {
            Internal.checkElementsNotNull(r100);
            this.options = r100;
            return this;
        }

        public Builder scope_id(String r100) {
            this.scope_id = r100;
            return this;
        }

        public Builder topic(String r100) {
            this.topic = r100;
            return this;
        }

        public Builder vote_scene(VoteScopeContainerType r100) {
            this.vote_scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PublishVoteRequest extends ProtoAdapter<PublishVoteRequest> implements c<PublishVoteRequest> {
        public ProtoAdapter_PublishVoteRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PublishVoteRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PublishVoteRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cid = "";
            r101.scope_id = "";
            r101.vote_scene = VoteScopeContainerType.UNKNOWN_SCOPE_CONTAINER;
            r101.topic = "";
            r101.min_pick_num = 0L;
            r101.max_pick_num = 0L;
            r101.is_public = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L20;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.vote_scene = VoteScopeContainerType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.options.add(VoteOption.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.is_public = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.max_pick_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.min_pick_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.topic = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.scope_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PublishVoteRequest r100) {
            String r101 = r100.cid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.scope_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            VoteScopeContainerType r107 = r100.vote_scene;
            if (r107 == null) goto L13;
            int r108 = VoteScopeContainerType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.topic;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.min_pick_num;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.max_pick_num;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_public;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            return ((r118 + r102) + VoteOption.ADAPTER.asRepeated().encodedSizeWithTag(8, r100.options)) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PublishVoteRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PublishVoteRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PublishVoteRequest r101) throws IOException {
            String r102 = r101.cid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.scope_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            VoteScopeContainerType r104 = r101.vote_scene;
            if (r104 == null) goto L11;
            VoteScopeContainerType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.topic;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.min_pick_num;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.max_pick_num;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.is_public;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            VoteOption.ADAPTER.asRepeated().encodeWithTag(r100, 8, r101.options);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PublishVoteRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PublishVoteRequest r100 = new ProtoAdapter_PublishVoteRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_VOTE_SCENE = VoteScopeContainerType.UNKNOWN_SCOPE_CONTAINER;
        DEFAULT_MIN_PICK_NUM = 0L;
        DEFAULT_MAX_PICK_NUM = 0L;
        DEFAULT_IS_PUBLIC = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cid = this.cid;
        r100.scope_id = this.scope_id;
        r100.vote_scene = this.vote_scene;
        r100.topic = this.topic;
        r100.min_pick_num = this.min_pick_num;
        r100.max_pick_num = this.max_pick_num;
        r100.is_public = this.is_public;
        r100.options = Internal.copyOf("options", this.options);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PublishVoteRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PublishVoteRequest(String r110, String r111, VoteScopeContainerType r112, String r113, Long r114, Long r115, Boolean r116, List<VoteOption> r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public PublishVoteRequest(String r100, String r101, VoteScopeContainerType r102, String r103, Long r104, Long r105, Boolean r106, List<VoteOption> r107, ByteString r110) {
        super(ADAPTER, r110);
        this.cid = r100;
        this.scope_id = r101;
        this.vote_scene = r102;
        this.topic = r103;
        this.min_pick_num = r104;
        this.max_pick_num = r105;
        this.is_public = r106;
        this.options = Internal.immutableCopyOf("options", r107);
    }
}
