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

/* JADX INFO: loaded from: classes20.dex */
public final class VotedInfo extends Message<VotedInfo, Builder> {
    public static final ProtoAdapter<VotedInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_VOTED = null;
    public static final Long DEFAULT_VERSION = null;
    public static final Long DEFAULT_VOTED_NUMBER = null;
    public static final Long DEFAULT_VOTER_NUMBER = null;
    public static final Long DEFAULT_VOTE_ID = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_voted;
    public final Long version;
    public final Long vote_id;
    public final List<VotedIndexInfo> voted_index_info;
    public final List<Long> voted_indexes;
    public final Long voted_number;
    public final Long voter_number;

    public static final class Builder extends Message.Builder<VotedInfo, Builder> {
        public Boolean is_voted;
        public Long version;
        public Long vote_id;
        public List<VotedIndexInfo> voted_index_info;
        public List<Long> voted_indexes;
        public Long voted_number;
        public Long voter_number;

        @Override // com.squareup.wire.Message.Builder
        public VotedInfo build() {
            return new VotedInfo(this.vote_id, this.is_voted, this.voted_indexes, this.voted_index_info, this.version, this.voter_number, this.voted_number, super.buildUnknownFields());
        }

        public Builder() {
            this.voted_indexes = Internal.newMutableList();
            this.voted_index_info = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_voted(Boolean r100) {
            this.is_voted = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }

        public Builder vote_id(Long r100) {
            this.vote_id = r100;
            return this;
        }

        public Builder voted_index_info(List<VotedIndexInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.voted_index_info = r100;
            return this;
        }

        public Builder voted_indexes(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.voted_indexes = r100;
            return this;
        }

        public Builder voted_number(Long r100) {
            this.voted_number = r100;
            return this;
        }

        public Builder voter_number(Long r100) {
            this.voter_number = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_VotedInfo extends ProtoAdapter<VotedInfo> {
        public ProtoAdapter_VotedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, VotedInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VotedInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.vote_id = 0L;
            r101.is_voted = Boolean.FALSE;
            r101.version = 0L;
            r101.voter_number = 0L;
            r101.voted_number = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.voted_number = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.voter_number = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.voted_index_info.add(VotedIndexInfo.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.voted_indexes.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            r101.is_voted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.vote_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(VotedInfo r100) {
            Long r101 = r100.vote_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_voted;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ProtoAdapter<Long> r107 = ProtoAdapter.INT64;
            int r108 = (r106 + r107.asRepeated().encodedSizeWithTag(3, r100.voted_indexes)) + VotedIndexInfo.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.voted_index_info);
            Long r109 = r100.version;
            if (r109 == null) goto L13;
            int r110 = r107.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            Long r112 = r100.voter_number;
            if (r112 == null) goto L17;
            int r113 = r107.encodedSizeWithTag(6, r112);
        L18:
            int r114 = r111 + r113;
            Long r115 = r100.voted_number;
            if (r115 == null) goto L22;
            r102 = r107.encodedSizeWithTag(7, r115);
        L22:
            return (r114 + r102) + r100.unknownFields().size();
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ VotedInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VotedInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VotedInfo r101) throws IOException {
            Long r102 = r101.vote_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_voted;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
            r104.asRepeated().encodeWithTag(r100, 3, r101.voted_indexes);
            VotedIndexInfo.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.voted_index_info);
            Long r105 = r101.version;
            if (r105 == null) goto L11;
            r104.encodeWithTag(r100, 5, r105);
        L11:
            Long r106 = r101.voter_number;
            if (r106 == null) goto L14;
            r104.encodeWithTag(r100, 6, r106);
        L14:
            Long r107 = r101.voted_number;
            if (r107 == null) goto L17;
            r104.encodeWithTag(r100, 7, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VotedInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_VotedInfo();
        DEFAULT_VOTE_ID = 0L;
        DEFAULT_IS_VOTED = Boolean.FALSE;
        DEFAULT_VERSION = 0L;
        DEFAULT_VOTER_NUMBER = 0L;
        DEFAULT_VOTED_NUMBER = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.vote_id = this.vote_id;
        r100.is_voted = this.is_voted;
        r100.voted_indexes = Internal.copyOf("voted_indexes", this.voted_indexes);
        r100.voted_index_info = Internal.copyOf("voted_index_info", this.voted_index_info);
        r100.version = this.version;
        r100.voter_number = this.voter_number;
        r100.voted_number = this.voted_number;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VotedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public VotedInfo(Long r110, Boolean r111, List<Long> r112, List<VotedIndexInfo> r113, Long r114, Long r115, Long r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public VotedInfo(Long r100, Boolean r101, List<Long> r102, List<VotedIndexInfo> r103, Long r104, Long r105, Long r106, ByteString r107) {
        super(ADAPTER, r107);
        this.vote_id = r100;
        this.is_voted = r101;
        this.voted_indexes = Internal.immutableCopyOf("voted_indexes", r102);
        this.voted_index_info = Internal.immutableCopyOf("voted_index_info", r103);
        this.version = r104;
        this.voter_number = r105;
        this.voted_number = r106;
    }
}
