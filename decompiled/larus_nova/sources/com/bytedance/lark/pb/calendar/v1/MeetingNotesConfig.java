package com.bytedance.lark.pb.calendar.v1;

import com.obric.miniapp.alarm.AccountType;
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
public final class MeetingNotesConfig extends Message<MeetingNotesConfig, Builder> {
    public static final ProtoAdapter<MeetingNotesConfig> ADAPTER = null;
    public static final CreateNotesPermission DEFAULT_CREATE_NOTES_PERMISSION = null;
    private static final long serialVersionUID = 0;
    public final CreateNotesPermission create_notes_permission;

    public static final class Builder extends Message.Builder<MeetingNotesConfig, Builder> {
        public CreateNotesPermission create_notes_permission;

        @Override // com.squareup.wire.Message.Builder
        public MeetingNotesConfig build() {
            return new MeetingNotesConfig(this.create_notes_permission, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder create_notes_permission(CreateNotesPermission r100) {
            this.create_notes_permission = r100;
            return this;
        }
    }

    public static final enum CreateNotesPermission extends Enum<CreateNotesPermission> implements WireEnum {
        private static final /* synthetic */ CreateNotesPermission[] $VALUES = null;
        public static final ProtoAdapter<CreateNotesPermission> ADAPTER = null;
        public static final CreateNotesPermission ALL = null;
        public static final CreateNotesPermission ORGANIZER = null;
        public static final CreateNotesPermission UNKNOWN = null;
        private final int value;

        static {
            CreateNotesPermission r100 = new CreateNotesPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            CreateNotesPermission r101 = new CreateNotesPermission("ORGANIZER", 1, 1);
            ORGANIZER = r101;
            CreateNotesPermission r102 = new CreateNotesPermission(AccountType.ALL, 2, 2);
            ALL = r102;
            $VALUES = new CreateNotesPermission[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(CreateNotesPermission.class);
        }

        public static CreateNotesPermission[] values() {
            return (CreateNotesPermission[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CreateNotesPermission fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return ALL;
        L12:
            return ORGANIZER;
        L14:
            return UNKNOWN;
        }

        public static CreateNotesPermission valueOf(String r100) {
            return (CreateNotesPermission) a.a(CreateNotesPermission.class, r100);
        }

        private CreateNotesPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_MeetingNotesConfig extends ProtoAdapter<MeetingNotesConfig> {
        public ProtoAdapter_MeetingNotesConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingNotesConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingNotesConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.create_notes_permission = CreateNotesPermission.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.create_notes_permission = CreateNotesPermission.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MeetingNotesConfig r100) {
            CreateNotesPermission r101 = r100.create_notes_permission;
            if (r101 == null) goto L5;
            int r102 = CreateNotesPermission.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MeetingNotesConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingNotesConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingNotesConfig r101) throws IOException {
            CreateNotesPermission r102 = r101.create_notes_permission;
            if (r102 == null) goto L5;
            CreateNotesPermission.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingNotesConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingNotesConfig();
        DEFAULT_CREATE_NOTES_PERMISSION = CreateNotesPermission.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.create_notes_permission = this.create_notes_permission;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingNotesConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingNotesConfig(CreateNotesPermission r100) {
        this(r100, ByteString.EMPTY);
    }

    public MeetingNotesConfig(CreateNotesPermission r100, ByteString r101) {
        super(ADAPTER, r101);
        this.create_notes_permission = r100;
    }
}
