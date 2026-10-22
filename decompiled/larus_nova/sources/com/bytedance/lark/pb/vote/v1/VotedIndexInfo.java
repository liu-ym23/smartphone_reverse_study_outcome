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
public final class VotedIndexInfo extends Message<VotedIndexInfo, Builder> {
    public static final ProtoAdapter<VotedIndexInfo> ADAPTER = null;
    public static final Long DEFAULT_COUNT = null;
    public static final Long DEFAULT_INDEX = null;
    private static final long serialVersionUID = 0;
    public final Long count;
    public final Long index;
    public final List<Long> users;

    public static final class Builder extends Message.Builder<VotedIndexInfo, Builder> {
        public Long count;
        public Long index;
        public List<Long> users;

        @Override // com.squareup.wire.Message.Builder
        public VotedIndexInfo build() {
            return new VotedIndexInfo(this.index, this.count, this.users, super.buildUnknownFields());
        }

        public Builder() {
            this.users = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Long r100) {
            this.count = r100;
            return this;
        }

        public Builder index(Long r100) {
            this.index = r100;
            return this;
        }

        public Builder users(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.users = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_VotedIndexInfo extends ProtoAdapter<VotedIndexInfo> {
        public ProtoAdapter_VotedIndexInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, VotedIndexInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VotedIndexInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.index = 0L;
            r101.count = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.index = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.count = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.users.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(VotedIndexInfo r100) {
            Long r101 = r100.index;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.count;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(3, r100.users)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ VotedIndexInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VotedIndexInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VotedIndexInfo r101) throws IOException {
            Long r102 = r101.index;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 3, r101.users);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VotedIndexInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_VotedIndexInfo();
        DEFAULT_INDEX = 0L;
        DEFAULT_COUNT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.index = this.index;
        r100.count = this.count;
        r100.users = Internal.copyOf("users", this.users);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VotedIndexInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public VotedIndexInfo(Long r100, Long r101, List<Long> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public VotedIndexInfo(Long r100, Long r101, List<Long> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.index = r100;
        this.count = r101;
        this.users = Internal.immutableCopyOf("users", r102);
    }
}
