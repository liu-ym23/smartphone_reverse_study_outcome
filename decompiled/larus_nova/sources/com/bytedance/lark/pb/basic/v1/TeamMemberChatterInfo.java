package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TeamMemberChatterInfo extends com.squareup.wire.Message<TeamMemberChatterInfo, Builder> {
    public static final ProtoAdapter<TeamMemberChatterInfo> ADAPTER = null;
    public static final Long DEFAULT_CHATTER_ID = null;
    private static final long serialVersionUID = 0;
    public final Chatter chatter;
    public final Long chatter_id;
    public final TeamMemberMeta meta;

    public static final class Builder extends com.squareup.wire.Message.Builder<TeamMemberChatterInfo, Builder> {
        public Chatter chatter;
        public Long chatter_id;
        public TeamMemberMeta meta;

        @Override // com.squareup.wire.Message.Builder
        public TeamMemberChatterInfo build() {
            return new TeamMemberChatterInfo(this.chatter_id, this.meta, this.chatter, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder chatter(Chatter r100) {
            this.chatter = r100;
            return this;
        }

        public Builder chatter_id(Long r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder meta(TeamMemberMeta r100) {
            this.meta = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TeamMemberChatterInfo extends ProtoAdapter<TeamMemberChatterInfo> {
        public ProtoAdapter_TeamMemberChatterInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TeamMemberChatterInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TeamMemberChatterInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chatter_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chatter_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.meta = TeamMemberMeta.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.chatter = Chatter.ADAPTER.decode(r100);
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
        public int encodedSize2(TeamMemberChatterInfo r100) {
            Long r101 = r100.chatter_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            TeamMemberMeta r104 = r100.meta;
            if (r104 == null) goto L9;
            int r105 = TeamMemberMeta.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Chatter r107 = r100.chatter;
            if (r107 == null) goto L14;
            r102 = Chatter.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TeamMemberChatterInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TeamMemberChatterInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TeamMemberChatterInfo r101) throws IOException {
            Long r102 = r101.chatter_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            TeamMemberMeta r103 = r101.meta;
            if (r103 == null) goto L8;
            TeamMemberMeta.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Chatter r104 = r101.chatter;
            if (r104 == null) goto L11;
            Chatter.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TeamMemberChatterInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TeamMemberChatterInfo();
        DEFAULT_CHATTER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatter_id = this.chatter_id;
        r100.meta = this.meta;
        r100.chatter = this.chatter;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TeamMemberChatterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TeamMemberChatterInfo(Long r100, TeamMemberMeta r101, Chatter r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TeamMemberChatterInfo(Long r100, TeamMemberMeta r101, Chatter r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chatter_id = r100;
        this.meta = r101;
        this.chatter = r102;
    }
}
