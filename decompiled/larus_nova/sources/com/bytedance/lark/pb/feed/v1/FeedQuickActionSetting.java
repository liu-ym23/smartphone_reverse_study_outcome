package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedQuickActionSetting extends Message<FeedQuickActionSetting, Builder> {
    public static final ProtoAdapter<FeedQuickActionSetting> ADAPTER = null;
    public static final FeedQuickActionType DEFAULT_QUICK_ACTION = null;
    public static final Boolean DEFAULT_QUICK_ACTION_ON = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final FeedQuickActionType quick_action;
    public final Boolean quick_action_on;
    public final Long update_time_ms;

    public static final class Builder extends Message.Builder<FeedQuickActionSetting, Builder> {
        public FeedQuickActionType quick_action;
        public Boolean quick_action_on;
        public Long update_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public FeedQuickActionSetting build() {
            return new FeedQuickActionSetting(this.quick_action, this.quick_action_on, this.update_time_ms, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder quick_action(FeedQuickActionType r100) {
            this.quick_action = r100;
            return this;
        }

        public Builder quick_action_on(Boolean r100) {
            this.quick_action_on = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.update_time_ms = r100;
            return this;
        }
    }

    public static final enum FeedQuickActionType extends Enum<FeedQuickActionType> implements WireEnum {
        private static final /* synthetic */ FeedQuickActionType[] $VALUES = null;
        public static final ProtoAdapter<FeedQuickActionType> ADAPTER = null;
        public static final FeedQuickActionType DONE = null;
        public static final FeedQuickActionType FEED_GROUP = null;
        public static final FeedQuickActionType FLAG = null;
        public static final FeedQuickActionType MARK_OR_CLEAR_UNREAD = null;
        public static final FeedQuickActionType MUTE = null;
        public static final FeedQuickActionType SHORTCUT = null;
        public static final FeedQuickActionType UNKNOWN_ACTION_TYPE = null;
        private final int value;

        static {
            FeedQuickActionType r100 = new FeedQuickActionType("UNKNOWN_ACTION_TYPE", 0, 0);
            UNKNOWN_ACTION_TYPE = r100;
            FeedQuickActionType r101 = new FeedQuickActionType("SHORTCUT", 1, 1);
            SHORTCUT = r101;
            FeedQuickActionType r102 = new FeedQuickActionType("FLAG", 2, 2);
            FLAG = r102;
            FeedQuickActionType r103 = new FeedQuickActionType("FEED_GROUP", 3, 3);
            FEED_GROUP = r103;
            FeedQuickActionType r104 = new FeedQuickActionType("MUTE", 4, 4);
            MUTE = r104;
            FeedQuickActionType r105 = new FeedQuickActionType("DONE", 5, 5);
            DONE = r105;
            FeedQuickActionType r110 = new FeedQuickActionType("MARK_OR_CLEAR_UNREAD", 6, 6);
            MARK_OR_CLEAR_UNREAD = r110;
            $VALUES = new FeedQuickActionType[]{r100, r101, r102, r103, r104, r105, r110};
            ADAPTER = ProtoAdapter.newEnumAdapter(FeedQuickActionType.class);
        }

        public static FeedQuickActionType[] values() {
            return (FeedQuickActionType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FeedQuickActionType fromValue(int r100) {
            switch(r100) {
                case 0: goto L18;
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
            return MARK_OR_CLEAR_UNREAD;
        L8:
            return DONE;
        L10:
            return MUTE;
        L12:
            return FEED_GROUP;
        L14:
            return FLAG;
        L16:
            return SHORTCUT;
        L18:
            return UNKNOWN_ACTION_TYPE;
        }

        public static FeedQuickActionType valueOf(String r100) {
            return (FeedQuickActionType) a.a(FeedQuickActionType.class, r100);
        }

        private FeedQuickActionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_FeedQuickActionSetting extends ProtoAdapter<FeedQuickActionSetting> {
        public ProtoAdapter_FeedQuickActionSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedQuickActionSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedQuickActionSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.quick_action = FeedQuickActionType.UNKNOWN_ACTION_TYPE;
            r101.quick_action_on = Boolean.FALSE;
            r101.update_time_ms = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.quick_action = FeedQuickActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.quick_action_on = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 10) goto L11;
            r101.update_time_ms = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(FeedQuickActionSetting r100) {
            FeedQuickActionType r101 = r100.quick_action;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FeedQuickActionType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.quick_action_on;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.update_time_ms;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(10, r107);
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
        public /* bridge */ /* synthetic */ FeedQuickActionSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedQuickActionSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedQuickActionSetting r101) throws IOException {
            FeedQuickActionType r102 = r101.quick_action;
            if (r102 == null) goto L5;
            FeedQuickActionType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.quick_action_on;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.update_time_ms;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedQuickActionSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedQuickActionSetting();
        DEFAULT_QUICK_ACTION = FeedQuickActionType.UNKNOWN_ACTION_TYPE;
        DEFAULT_QUICK_ACTION_ON = Boolean.FALSE;
        DEFAULT_UPDATE_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.quick_action = this.quick_action;
        r100.quick_action_on = this.quick_action_on;
        r100.update_time_ms = this.update_time_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedQuickActionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedQuickActionSetting(FeedQuickActionType r100, Boolean r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FeedQuickActionSetting(FeedQuickActionType r100, Boolean r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.quick_action = r100;
        this.quick_action_on = r101;
        this.update_time_ms = r102;
    }
}
