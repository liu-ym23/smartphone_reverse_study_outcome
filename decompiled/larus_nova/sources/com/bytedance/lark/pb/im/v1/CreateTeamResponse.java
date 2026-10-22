package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Item;
import com.bytedance.lark.pb.basic.v1.Team;
import com.bytedance.lark.pb.basic.v1.TeamEntity;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CreateTeamResponse extends Message<CreateTeamResponse, Builder> {
    public static final ProtoAdapter<CreateTeamResponse> ADAPTER = null;
    public static final ProtoAdapter_CreateTeamResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Item item;
    public final Team team;
    public final TeamEntity team_entity;

    public static final class Builder extends Message.Builder<CreateTeamResponse, Builder> implements d<CreateTeamResponse> {
        public Item item;
        public Team team;
        public TeamEntity team_entity;

        @Override // com.squareup.wire.Message.Builder
        public CreateTeamResponse build() {
            return new CreateTeamResponse(this.team, this.item, this.team_entity, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder item(Item r100) {
            this.item = r100;
            return this;
        }

        public Builder team(Team r100) {
            this.team = r100;
            return this;
        }

        public Builder team_entity(TeamEntity r100) {
            this.team_entity = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateTeamResponse extends ProtoAdapter<CreateTeamResponse> implements c<CreateTeamResponse> {
        public ProtoAdapter_CreateTeamResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateTeamResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateTeamResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.team = Team.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.item = Item.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.team_entity = TeamEntity.ADAPTER.decode(r100);
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
        public int encodedSize2(CreateTeamResponse r100) {
            Team r101 = r100.team;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Team.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Item r104 = r100.item;
            if (r104 == null) goto L9;
            int r105 = Item.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TeamEntity r107 = r100.team_entity;
            if (r107 == null) goto L14;
            r102 = TeamEntity.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ CreateTeamResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateTeamResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateTeamResponse r101) throws IOException {
            Team r102 = r101.team;
            if (r102 == null) goto L5;
            Team.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Item r103 = r101.item;
            if (r103 == null) goto L8;
            Item.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TeamEntity r104 = r101.team_entity;
            if (r104 == null) goto L11;
            TeamEntity.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateTeamResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateTeamResponse r100 = new ProtoAdapter_CreateTeamResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.team = this.team;
        r100.item = this.item;
        r100.team_entity = this.team_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateTeamResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateTeamResponse(Team r100, Item r101, TeamEntity r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CreateTeamResponse(Team r100, Item r101, TeamEntity r102, ByteString r103) {
        super(ADAPTER, r103);
        this.team = r100;
        this.item = r101;
        this.team_entity = r102;
    }
}
