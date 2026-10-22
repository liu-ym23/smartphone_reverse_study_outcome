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
public final class VoteRequest extends Message<VoteRequest, Builder> {
    public static final ProtoAdapter<VoteRequest> ADAPTER = null;
    public static final String DEFAULT_SCOPE_ID = "";
    public static final VoteScopeType DEFAULT_SCOPE_TYPE = null;
    public static final Long DEFAULT_VOTE_ID = null;
    public static final ProtoAdapter_VoteRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Long> indexes;
    public final String scope_id;
    public final VoteScopeType scope_type;
    public final Long vote_id;

    public static final class Builder extends Message.Builder<VoteRequest, Builder> implements d<VoteRequest> {
        public List<Long> indexes;
        public String scope_id;
        public VoteScopeType scope_type;
        public Long vote_id;

        @Override // com.squareup.wire.Message.Builder
        public VoteRequest build() {
            return new VoteRequest(this.vote_id, this.indexes, this.scope_type, this.scope_id, super.buildUnknownFields());
        }

        public Builder() {
            this.indexes = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder indexes(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.indexes = r100;
            return this;
        }

        public Builder scope_id(String r100) {
            this.scope_id = r100;
            return this;
        }

        public Builder scope_type(VoteScopeType r100) {
            this.scope_type = r100;
            return this;
        }

        public Builder vote_id(Long r100) {
            this.vote_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_VoteRequest extends ProtoAdapter<VoteRequest> implements c<VoteRequest> {
        public ProtoAdapter_VoteRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, VoteRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VoteRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.vote_id = 0L;
            r101.scope_type = VoteScopeType.UNKNOWN_SCOPE;
            r101.scope_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.vote_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.indexes.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.scope_type = VoteScopeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.scope_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(VoteRequest r100) {
            Long r101 = r100.vote_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(2, r100.indexes);
            VoteScopeType r105 = r100.scope_type;
            if (r105 == null) goto L9;
            int r106 = VoteScopeType.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            String r108 = r100.scope_id;
            if (r108 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r108);
        L14:
            return (r107 + r102) + r100.unknownFields().size();
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ VoteRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VoteRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VoteRequest r101) throws IOException {
            Long r102 = r101.vote_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 2, r101.indexes);
            VoteScopeType r103 = r101.scope_type;
            if (r103 == null) goto L8;
            VoteScopeType.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.scope_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VoteRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_VoteRequest r100 = new ProtoAdapter_VoteRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_VOTE_ID = 0L;
        DEFAULT_SCOPE_TYPE = VoteScopeType.UNKNOWN_SCOPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.vote_id = this.vote_id;
        r100.indexes = Internal.copyOf("indexes", this.indexes);
        r100.scope_type = this.scope_type;
        r100.scope_id = this.scope_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VoteRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public VoteRequest(Long r100, List<Long> r101, VoteScopeType r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public VoteRequest(Long r100, List<Long> r101, VoteScopeType r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.vote_id = r100;
        this.indexes = Internal.immutableCopyOf("indexes", r101);
        this.scope_type = r102;
        this.scope_id = r103;
    }
}
