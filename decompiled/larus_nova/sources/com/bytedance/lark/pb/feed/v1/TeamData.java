package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TeamData extends Message<TeamData, Builder> {
    public static final ProtoAdapter<TeamData> ADAPTER = null;
    public static final Integer DEFAULT_MUTE_BADGE = null;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_ORDER_WEIGHT = null;
    public static final Long DEFAULT_TEAM_ITEM_ID = null;
    public static final Integer DEFAULT_UNMUTE_BADGE = null;
    private static final long serialVersionUID = 0;
    public final Integer mute_badge;
    public final String name;
    public final Long order_weight;
    public final Long team_item_id;
    public final Integer unmute_badge;

    public static final class Builder extends Message.Builder<TeamData, Builder> {
        public Integer mute_badge;
        public String name;
        public Long order_weight;
        public Long team_item_id;
        public Integer unmute_badge;

        @Override // com.squareup.wire.Message.Builder
        public TeamData build() {
            return new TeamData(this.team_item_id, this.name, this.unmute_badge, this.mute_badge, this.order_weight, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder mute_badge(Integer r100) {
            this.mute_badge = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder order_weight(Long r100) {
            this.order_weight = r100;
            return this;
        }

        public Builder team_item_id(Long r100) {
            this.team_item_id = r100;
            return this;
        }

        public Builder unmute_badge(Integer r100) {
            this.unmute_badge = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TeamData extends ProtoAdapter<TeamData> {
        public ProtoAdapter_TeamData() {
            super(FieldEncoding.LENGTH_DELIMITED, TeamData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TeamData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.team_item_id = 0L;
            r101.name = "";
            r101.unmute_badge = 0;
            r101.mute_badge = 0;
            r101.order_weight = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.team_item_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.unmute_badge = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mute_badge = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.order_weight = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TeamData r100) {
            Long r101 = r100.team_item_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.unmute_badge;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.mute_badge;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.order_weight;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ TeamData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TeamData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TeamData r101) throws IOException {
            Long r102 = r101.team_item_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.unmute_badge;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.mute_badge;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.order_weight;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TeamData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TeamData();
        DEFAULT_TEAM_ITEM_ID = 0L;
        DEFAULT_UNMUTE_BADGE = 0;
        DEFAULT_MUTE_BADGE = 0;
        DEFAULT_ORDER_WEIGHT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.team_item_id = this.team_item_id;
        r100.name = this.name;
        r100.unmute_badge = this.unmute_badge;
        r100.mute_badge = this.mute_badge;
        r100.order_weight = this.order_weight;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TeamData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TeamData(Long r100, String r101, Integer r110, Integer r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TeamData(Long r100, String r101, Integer r102, Integer r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.team_item_id = r100;
        this.name = r101;
        this.unmute_badge = r102;
        this.mute_badge = r103;
        this.order_weight = r104;
    }
}
