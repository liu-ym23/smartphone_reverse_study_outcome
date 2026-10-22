package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class BotCheckStatus extends com.squareup.wire.Message<BotCheckStatus, Builder> {
    public static final ProtoAdapter<BotCheckStatus> ADAPTER = null;
    public static final Long DEFAULT_BOT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mbot_id;
    public final BotUsageStatus mstatus;
    public final BotTipsContent mtips;

    public static final enum BotUsageStatus extends Enum<BotUsageStatus> implements WireEnum {
        private static final /* synthetic */ BotUsageStatus[] $VALUES = null;
        public static final ProtoAdapter<BotUsageStatus> ADAPTER = null;
        public static final BotUsageStatus BOT_DEVELOPER_FORBIDDEN = null;
        public static final BotUsageStatus BOT_OFFLINE = null;
        public static final BotUsageStatus BOT_PLATFORM_FORBIDDEN = null;
        public static final BotUsageStatus BOT_TENANT_FORBIDDEN = null;
        public static final BotUsageStatus BOT_USABLE = null;
        public static final BotUsageStatus BOT_USER_UNVISIBLE = null;
        private final int value;

        static {
            BotUsageStatus r100 = new BotUsageStatus("BOT_USABLE", 0, 1);
            BOT_USABLE = r100;
            BotUsageStatus r101 = new BotUsageStatus("BOT_TENANT_FORBIDDEN", 1, 2);
            BOT_TENANT_FORBIDDEN = r101;
            BotUsageStatus r102 = new BotUsageStatus("BOT_PLATFORM_FORBIDDEN", 2, 3);
            BOT_PLATFORM_FORBIDDEN = r102;
            BotUsageStatus r103 = new BotUsageStatus("BOT_DEVELOPER_FORBIDDEN", 3, 4);
            BOT_DEVELOPER_FORBIDDEN = r103;
            BotUsageStatus r104 = new BotUsageStatus("BOT_OFFLINE", 4, 5);
            BOT_OFFLINE = r104;
            BotUsageStatus r110 = new BotUsageStatus("BOT_USER_UNVISIBLE", 5, 6);
            BOT_USER_UNVISIBLE = r110;
            $VALUES = new BotUsageStatus[]{r100, r101, r102, r103, r104, r110};
            ADAPTER = ProtoAdapter.newEnumAdapter(BotUsageStatus.class);
        }

        public static BotUsageStatus[] values() {
            return (BotUsageStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static BotUsageStatus fromValue(int r100) {
            switch(r100) {
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return BOT_USER_UNVISIBLE;
        L8:
            return BOT_OFFLINE;
        L10:
            return BOT_DEVELOPER_FORBIDDEN;
        L12:
            return BOT_PLATFORM_FORBIDDEN;
        L14:
            return BOT_TENANT_FORBIDDEN;
        L16:
            return BOT_USABLE;
        }

        public static BotUsageStatus valueOf(String r100) {
            return (BotUsageStatus) a.a(BotUsageStatus.class, r100);
        }

        private BotUsageStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<BotCheckStatus, Builder> {
        public Long mbot_id;
        public BotUsageStatus mstatus;
        public BotTipsContent mtips;

        @Override // com.squareup.wire.Message.Builder
        public BotCheckStatus build() {
            return new BotCheckStatus(this.mbot_id, this.mstatus, this.mtips, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder bot_id(Long r100) {
            this.mbot_id = r100;
            return this;
        }

        public Builder status(BotUsageStatus r100) {
            this.mstatus = r100;
            return this;
        }

        public Builder tips(BotTipsContent r100) {
            this.mtips = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BotCheckStatus extends ProtoAdapter<BotCheckStatus> {
        public ProtoAdapter_BotCheckStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, BotCheckStatus.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BotCheckStatus decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mbot_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mbot_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mstatus = BotUsageStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mtips = BotTipsContent.ADAPTER.decode(r100);
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
        public int encodedSize2(BotCheckStatus r100) {
            Long r101 = r100.mbot_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            BotUsageStatus r104 = r100.mstatus;
            if (r104 == null) goto L9;
            int r105 = BotUsageStatus.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            BotTipsContent r107 = r100.mtips;
            if (r107 == null) goto L14;
            r102 = BotTipsContent.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ BotCheckStatus decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BotCheckStatus r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BotCheckStatus r101) throws IOException {
            Long r102 = r101.mbot_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            BotUsageStatus r103 = r101.mstatus;
            if (r103 == null) goto L8;
            BotUsageStatus.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            BotTipsContent r104 = r101.mtips;
            if (r104 == null) goto L11;
            BotTipsContent.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BotCheckStatus r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotCheckStatus();
        DEFAULT_BOT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mbot_id = this.mbot_id;
        r100.mstatus = this.mstatus;
        r100.mtips = this.mtips;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BotCheckStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public BotCheckStatus(Long r100, BotUsageStatus r101, BotTipsContent r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public BotCheckStatus(Long r100, BotUsageStatus r101, BotTipsContent r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mbot_id = r100;
        this.mstatus = r101;
        this.mtips = r102;
    }
}
