package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedSlideActionSetting extends Message<FeedSlideActionSetting, Builder> {
    public static final ProtoAdapter<FeedSlideActionSetting> ADAPTER = null;
    public static final Boolean DEFAULT_LEFT_SLIDE_ACTION_ON = null;
    public static final Boolean DEFAULT_RIGHT_SLIDE_ACTION_ON = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final List<FeedSlideActionType> left_slide_action;
    public final Boolean left_slide_action_on;
    public final List<FeedSlideActionType> right_slide_action;
    public final Boolean right_slide_action_on;
    public final Long update_time_ms;

    public static final class Builder extends Message.Builder<FeedSlideActionSetting, Builder> {
        public List<FeedSlideActionType> left_slide_action;
        public Boolean left_slide_action_on;
        public List<FeedSlideActionType> right_slide_action;
        public Boolean right_slide_action_on;
        public Long update_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public FeedSlideActionSetting build() {
            return new FeedSlideActionSetting(this.left_slide_action, this.right_slide_action, this.left_slide_action_on, this.right_slide_action_on, this.update_time_ms, super.buildUnknownFields());
        }

        public Builder() {
            this.left_slide_action = Internal.newMutableList();
            this.right_slide_action = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder left_slide_action(List<FeedSlideActionType> r100) {
            Internal.checkElementsNotNull(r100);
            this.left_slide_action = r100;
            return this;
        }

        public Builder left_slide_action_on(Boolean r100) {
            this.left_slide_action_on = r100;
            return this;
        }

        public Builder right_slide_action(List<FeedSlideActionType> r100) {
            Internal.checkElementsNotNull(r100);
            this.right_slide_action = r100;
            return this;
        }

        public Builder right_slide_action_on(Boolean r100) {
            this.right_slide_action_on = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.update_time_ms = r100;
            return this;
        }
    }

    public static final enum FeedSlideActionType extends Enum<FeedSlideActionType> implements WireEnum {
        private static final /* synthetic */ FeedSlideActionType[] $VALUES = null;
        public static final ProtoAdapter<FeedSlideActionType> ADAPTER = null;
        public static final FeedSlideActionType DONE = null;
        public static final FeedSlideActionType FEED_GROUP = null;
        public static final FeedSlideActionType FLAG = null;
        public static final FeedSlideActionType MARK_OR_CLEAR_UNREAD = null;
        public static final FeedSlideActionType MUTE = null;
        public static final FeedSlideActionType SHORTCUT = null;
        public static final FeedSlideActionType UNKNOWN_ACTION_TYPE = null;
        private final int value;

        static {
            FeedSlideActionType r100 = new FeedSlideActionType("UNKNOWN_ACTION_TYPE", 0, 0);
            UNKNOWN_ACTION_TYPE = r100;
            FeedSlideActionType r101 = new FeedSlideActionType("SHORTCUT", 1, 1);
            SHORTCUT = r101;
            FeedSlideActionType r102 = new FeedSlideActionType("FLAG", 2, 2);
            FLAG = r102;
            FeedSlideActionType r103 = new FeedSlideActionType("FEED_GROUP", 3, 3);
            FEED_GROUP = r103;
            FeedSlideActionType r104 = new FeedSlideActionType("MUTE", 4, 4);
            MUTE = r104;
            FeedSlideActionType r105 = new FeedSlideActionType("DONE", 5, 5);
            DONE = r105;
            FeedSlideActionType r110 = new FeedSlideActionType("MARK_OR_CLEAR_UNREAD", 6, 6);
            MARK_OR_CLEAR_UNREAD = r110;
            $VALUES = new FeedSlideActionType[]{r100, r101, r102, r103, r104, r105, r110};
            ADAPTER = ProtoAdapter.newEnumAdapter(FeedSlideActionType.class);
        }

        public static FeedSlideActionType[] values() {
            return (FeedSlideActionType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FeedSlideActionType fromValue(int r100) {
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

        public static FeedSlideActionType valueOf(String r100) {
            return (FeedSlideActionType) a.a(FeedSlideActionType.class, r100);
        }

        private FeedSlideActionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_FeedSlideActionSetting extends ProtoAdapter<FeedSlideActionSetting> {
        public ProtoAdapter_FeedSlideActionSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedSlideActionSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedSlideActionSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.left_slide_action_on = r102;
            r101.right_slide_action_on = r102;
            r101.update_time_ms = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L27;
            if (r104 != 1) goto L8;
            r101.left_slide_action.add(FeedSlideActionType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.right_slide_action.add(FeedSlideActionType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.left_slide_action_on = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.right_slide_action_on = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r104 != 10) goto L15;
            r101.update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FeedSlideActionSetting r100) {
            ProtoAdapter<FeedSlideActionType> r101 = FeedSlideActionType.ADAPTER;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.left_slide_action) + r101.asRepeated().encodedSizeWithTag(2, r100.right_slide_action);
            Boolean r103 = r100.left_slide_action_on;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.right_slide_action_on;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Long r110 = r100.update_time_ms;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.INT64.encodedSizeWithTag(10, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedSlideActionSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedSlideActionSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedSlideActionSetting r101) throws IOException {
            ProtoAdapter<FeedSlideActionType> r102 = FeedSlideActionType.ADAPTER;
            r102.asRepeated().encodeWithTag(r100, 1, r101.left_slide_action);
            r102.asRepeated().encodeWithTag(r100, 2, r101.right_slide_action);
            Boolean r103 = r101.left_slide_action_on;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L5:
            Boolean r104 = r101.right_slide_action_on;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L8:
            Long r105 = r101.update_time_ms;
            if (r105 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedSlideActionSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedSlideActionSetting();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_LEFT_SLIDE_ACTION_ON = r100;
        DEFAULT_RIGHT_SLIDE_ACTION_ON = r100;
        DEFAULT_UPDATE_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.left_slide_action = Internal.copyOf("left_slide_action", this.left_slide_action);
        r100.right_slide_action = Internal.copyOf("right_slide_action", this.right_slide_action);
        r100.left_slide_action_on = this.left_slide_action_on;
        r100.right_slide_action_on = this.right_slide_action_on;
        r100.update_time_ms = this.update_time_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedSlideActionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedSlideActionSetting(List<FeedSlideActionType> r100, List<FeedSlideActionType> r101, Boolean r110, Boolean r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FeedSlideActionSetting(List<FeedSlideActionType> r100, List<FeedSlideActionType> r101, Boolean r102, Boolean r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.left_slide_action = Internal.immutableCopyOf("left_slide_action", r100);
        this.right_slide_action = Internal.immutableCopyOf("right_slide_action", r101);
        this.left_slide_action_on = r102;
        this.right_slide_action_on = r103;
        this.update_time_ms = r104;
    }
}
