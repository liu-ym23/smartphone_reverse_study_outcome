package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TeamEntity extends com.squareup.wire.Message<TeamEntity, Builder> {
    public static final ProtoAdapter<TeamEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeedBadge badge;
    public final Team team;

    public static final class Builder extends com.squareup.wire.Message.Builder<TeamEntity, Builder> {
        public FeedBadge badge;
        public Team team;

        @Override // com.squareup.wire.Message.Builder
        public TeamEntity build() {
            return new TeamEntity(this.team, this.badge, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder badge(FeedBadge r100) {
            this.badge = r100;
            return this;
        }

        public Builder team(Team r100) {
            this.team = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TeamEntity extends ProtoAdapter<TeamEntity> {
        public ProtoAdapter_TeamEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TeamEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TeamEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.team = Team.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.badge = FeedBadge.ADAPTER.decode(r100);
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
        public int encodedSize2(TeamEntity r100) {
            Team r101 = r100.team;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Team.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            FeedBadge r104 = r100.badge;
            if (r104 == null) goto L10;
            r102 = FeedBadge.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TeamEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TeamEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TeamEntity r101) throws IOException {
            Team r102 = r101.team;
            if (r102 == null) goto L5;
            Team.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            FeedBadge r103 = r101.badge;
            if (r103 == null) goto L8;
            FeedBadge.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TeamEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TeamEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.team = this.team;
        r100.badge = this.badge;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TeamEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TeamEntity(Team r100, FeedBadge r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TeamEntity(Team r100, FeedBadge r101, ByteString r102) {
        super(ADAPTER, r102);
        this.team = r100;
        this.badge = r101;
    }
}
