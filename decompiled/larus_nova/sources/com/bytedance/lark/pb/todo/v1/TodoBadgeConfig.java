package com.bytedance.lark.pb.todo.v1;

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
public final class TodoBadgeConfig extends Message<TodoBadgeConfig, Builder> {
    public static final ProtoAdapter<TodoBadgeConfig> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE = null;
    public static final BadgeType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Boolean enable;
    public final BadgeType type;

    public static final enum BadgeType extends Enum<BadgeType> implements WireEnum {
        private static final /* synthetic */ BadgeType[] $VALUES = null;
        public static final ProtoAdapter<BadgeType> ADAPTER = null;
        public static final BadgeType OVERDUE = null;
        public static final BadgeType OVERDUE_AND_TODAY = null;
        public static final BadgeType OWNED_BY_ME_UNFINISHED = null;
        private final int value;

        static {
            BadgeType r100 = new BadgeType("OVERDUE", 0, 0);
            OVERDUE = r100;
            BadgeType r101 = new BadgeType("OVERDUE_AND_TODAY", 1, 1);
            OVERDUE_AND_TODAY = r101;
            BadgeType r102 = new BadgeType("OWNED_BY_ME_UNFINISHED", 2, 2);
            OWNED_BY_ME_UNFINISHED = r102;
            $VALUES = new BadgeType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(BadgeType.class);
        }

        public static BadgeType[] values() {
            return (BadgeType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static BadgeType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return OWNED_BY_ME_UNFINISHED;
        L12:
            return OVERDUE_AND_TODAY;
        L14:
            return OVERDUE;
        }

        public static BadgeType valueOf(String r100) {
            return (BadgeType) a.a(BadgeType.class, r100);
        }

        private BadgeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<TodoBadgeConfig, Builder> {
        public Boolean enable;
        public BadgeType type;

        @Override // com.squareup.wire.Message.Builder
        public TodoBadgeConfig build() {
            return new TodoBadgeConfig(this.enable, this.type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enable(Boolean r100) {
            this.enable = r100;
            return this;
        }

        public Builder type(BadgeType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoBadgeConfig extends ProtoAdapter<TodoBadgeConfig> {
        public ProtoAdapter_TodoBadgeConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoBadgeConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoBadgeConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.enable = Boolean.FALSE;
            r101.type = BadgeType.OVERDUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.enable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.type = BadgeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoBadgeConfig r100) {
            Boolean r101 = r100.enable;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            BadgeType r104 = r100.type;
            if (r104 == null) goto L10;
            r102 = BadgeType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoBadgeConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoBadgeConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoBadgeConfig r101) throws IOException {
            Boolean r102 = r101.enable;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            BadgeType r103 = r101.type;
            if (r103 == null) goto L8;
            BadgeType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoBadgeConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoBadgeConfig();
        DEFAULT_ENABLE = Boolean.FALSE;
        DEFAULT_TYPE = BadgeType.OVERDUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.enable = this.enable;
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoBadgeConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoBadgeConfig(Boolean r100, BadgeType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TodoBadgeConfig(Boolean r100, BadgeType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.enable = r100;
        this.type = r101;
    }
}
