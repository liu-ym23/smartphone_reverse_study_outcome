package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TeamSetting extends com.squareup.wire.Message<TeamSetting, Builder> {
    public static final ProtoAdapter<TeamSetting> ADAPTER = null;
    public static final AddMemberPermission.Type DEFAULT_ADD_MEMBER_PERMISSION = null;
    public static final AddPrivateTeamChatPermission.Type DEFAULT_ADD_PRIVATE_TEAM_CHAT_PERMISSION = null;
    public static final AddTeamChatPermission.Type DEFAULT_ADD_TEAM_CHAT_PERMISSION = null;
    public static final BindTeamChatPermission.Type DEFAULT_BIND_TEAM_CHAT_PERMISSION = null;
    public static final CreateTeamChatPermission.Type DEFAULT_CREATE_TEAM_CHAT_PERMISSION = null;
    private static final long serialVersionUID = 0;
    public final AddMemberPermission.Type add_member_permission;
    public final AddPrivateTeamChatPermission.Type add_private_team_chat_permission;
    public final AddTeamChatPermission.Type add_team_chat_permission;
    public final BindTeamChatPermission.Type bind_team_chat_permission;
    public final CreateTeamChatPermission.Type create_team_chat_permission;

    public static final class AddMemberPermission extends com.squareup.wire.Message<AddMemberPermission, Builder> {
        public static final ProtoAdapter<AddMemberPermission> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AddMemberPermission, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AddMemberPermission build() {
                return new AddMemberPermission(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_AddMemberPermission extends ProtoAdapter<AddMemberPermission> {
            public ProtoAdapter_AddMemberPermission() {
                super(FieldEncoding.LENGTH_DELIMITED, AddMemberPermission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AddMemberPermission decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AddMemberPermission r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AddMemberPermission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AddMemberPermission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AddMemberPermission r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddMemberPermission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type ALL_MEMBERS = null;
            public static final Type ONLY_OWNER = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r100 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Type r101 = new Type("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Type r102 = new Type("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r102;
                $VALUES = new Type[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_OWNER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AddMemberPermission();
        }

        public AddMemberPermission() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AddMemberPermission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AddMemberPermission(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class AddPrivateTeamChatPermission extends com.squareup.wire.Message<AddPrivateTeamChatPermission, Builder> {
        public static final ProtoAdapter<AddPrivateTeamChatPermission> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AddPrivateTeamChatPermission, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AddPrivateTeamChatPermission build() {
                return new AddPrivateTeamChatPermission(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_AddPrivateTeamChatPermission extends ProtoAdapter<AddPrivateTeamChatPermission> {
            public ProtoAdapter_AddPrivateTeamChatPermission() {
                super(FieldEncoding.LENGTH_DELIMITED, AddPrivateTeamChatPermission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AddPrivateTeamChatPermission decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AddPrivateTeamChatPermission r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AddPrivateTeamChatPermission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AddPrivateTeamChatPermission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AddPrivateTeamChatPermission r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddPrivateTeamChatPermission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type ALL_MEMBERS = null;
            public static final Type ONLY_MANAGER = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r100 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Type r101 = new Type("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Type r102 = new Type("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                $VALUES = new Type[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AddPrivateTeamChatPermission();
        }

        public AddPrivateTeamChatPermission() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AddPrivateTeamChatPermission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AddPrivateTeamChatPermission(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class AddTeamChatPermission extends com.squareup.wire.Message<AddTeamChatPermission, Builder> {
        public static final ProtoAdapter<AddTeamChatPermission> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AddTeamChatPermission, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public AddTeamChatPermission build() {
                return new AddTeamChatPermission(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_AddTeamChatPermission extends ProtoAdapter<AddTeamChatPermission> {
            public ProtoAdapter_AddTeamChatPermission() {
                super(FieldEncoding.LENGTH_DELIMITED, AddTeamChatPermission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AddTeamChatPermission decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AddTeamChatPermission r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AddTeamChatPermission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AddTeamChatPermission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AddTeamChatPermission r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddTeamChatPermission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type ALL_MEMBERS = null;
            public static final Type ONLY_MANAGER = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r100 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Type r101 = new Type("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Type r102 = new Type("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r102;
                $VALUES = new Type[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AddTeamChatPermission();
        }

        public AddTeamChatPermission() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AddTeamChatPermission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AddTeamChatPermission(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class BindTeamChatPermission extends com.squareup.wire.Message<BindTeamChatPermission, Builder> {
        public static final ProtoAdapter<BindTeamChatPermission> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<BindTeamChatPermission, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public BindTeamChatPermission build() {
                return new BindTeamChatPermission(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_BindTeamChatPermission extends ProtoAdapter<BindTeamChatPermission> {
            public ProtoAdapter_BindTeamChatPermission() {
                super(FieldEncoding.LENGTH_DELIMITED, BindTeamChatPermission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BindTeamChatPermission decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(BindTeamChatPermission r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BindTeamChatPermission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BindTeamChatPermission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BindTeamChatPermission r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BindTeamChatPermission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type BIND_TEAM_CHAT_PERMISSION_ALL_MEMBERS = null;
            public static final Type BIND_TEAM_CHAT_PERMISSION_ONLY_OWNER = null;
            public static final Type BIND_TEAM_CHAT_PERMISSION_UNKNOWN = null;
            private final int value;

            static {
                Type r100 = new Type("BIND_TEAM_CHAT_PERMISSION_UNKNOWN", 0, 0);
                BIND_TEAM_CHAT_PERMISSION_UNKNOWN = r100;
                Type r101 = new Type("BIND_TEAM_CHAT_PERMISSION_ALL_MEMBERS", 1, 1);
                BIND_TEAM_CHAT_PERMISSION_ALL_MEMBERS = r101;
                Type r102 = new Type("BIND_TEAM_CHAT_PERMISSION_ONLY_OWNER", 2, 2);
                BIND_TEAM_CHAT_PERMISSION_ONLY_OWNER = r102;
                $VALUES = new Type[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return BIND_TEAM_CHAT_PERMISSION_ONLY_OWNER;
            L12:
                return BIND_TEAM_CHAT_PERMISSION_ALL_MEMBERS;
            L14:
                return BIND_TEAM_CHAT_PERMISSION_UNKNOWN;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BindTeamChatPermission();
        }

        public BindTeamChatPermission() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BindTeamChatPermission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public BindTeamChatPermission(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<TeamSetting, Builder> {
        public AddMemberPermission.Type add_member_permission;
        public AddPrivateTeamChatPermission.Type add_private_team_chat_permission;
        public AddTeamChatPermission.Type add_team_chat_permission;
        public BindTeamChatPermission.Type bind_team_chat_permission;
        public CreateTeamChatPermission.Type create_team_chat_permission;

        @Override // com.squareup.wire.Message.Builder
        public TeamSetting build() {
            return new TeamSetting(this.add_member_permission, this.create_team_chat_permission, this.bind_team_chat_permission, this.add_team_chat_permission, this.add_private_team_chat_permission, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder add_member_permission(AddMemberPermission.Type r100) {
            this.add_member_permission = r100;
            return this;
        }

        public Builder add_private_team_chat_permission(AddPrivateTeamChatPermission.Type r100) {
            this.add_private_team_chat_permission = r100;
            return this;
        }

        public Builder add_team_chat_permission(AddTeamChatPermission.Type r100) {
            this.add_team_chat_permission = r100;
            return this;
        }

        public Builder bind_team_chat_permission(BindTeamChatPermission.Type r100) {
            this.bind_team_chat_permission = r100;
            return this;
        }

        public Builder create_team_chat_permission(CreateTeamChatPermission.Type r100) {
            this.create_team_chat_permission = r100;
            return this;
        }
    }

    public static final class CreateTeamChatPermission extends com.squareup.wire.Message<CreateTeamChatPermission, Builder> {
        public static final ProtoAdapter<CreateTeamChatPermission> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CreateTeamChatPermission, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public CreateTeamChatPermission build() {
                return new CreateTeamChatPermission(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_CreateTeamChatPermission extends ProtoAdapter<CreateTeamChatPermission> {
            public ProtoAdapter_CreateTeamChatPermission() {
                super(FieldEncoding.LENGTH_DELIMITED, CreateTeamChatPermission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CreateTeamChatPermission decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CreateTeamChatPermission r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CreateTeamChatPermission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CreateTeamChatPermission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CreateTeamChatPermission r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateTeamChatPermission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type ALL_MEMBERS = null;
            public static final Type ONLY_OWNER = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r100 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Type r101 = new Type("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r101;
                Type r102 = new Type("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r102;
                $VALUES = new Type[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ONLY_OWNER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CreateTeamChatPermission();
        }

        public CreateTeamChatPermission() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CreateTeamChatPermission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CreateTeamChatPermission(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ProtoAdapter_TeamSetting extends ProtoAdapter<TeamSetting> {
        public ProtoAdapter_TeamSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, TeamSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TeamSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.add_member_permission = AddMemberPermission.Type.UNKNOWN;
            r101.create_team_chat_permission = CreateTeamChatPermission.Type.UNKNOWN;
            r101.bind_team_chat_permission = BindTeamChatPermission.Type.BIND_TEAM_CHAT_PERMISSION_UNKNOWN;
            r101.add_team_chat_permission = AddTeamChatPermission.Type.UNKNOWN;
            r101.add_private_team_chat_permission = AddPrivateTeamChatPermission.Type.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L36;
            if (r103 != 1) goto L8;
            r101.add_member_permission = AddMemberPermission.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
        L34:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.create_team_chat_permission = CreateTeamChatPermission.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
        L30:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.bind_team_chat_permission = BindTeamChatPermission.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.add_team_chat_permission = AddTeamChatPermission.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.add_private_team_chat_permission = AddPrivateTeamChatPermission.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L36:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TeamSetting r100) {
            AddMemberPermission.Type r101 = r100.add_member_permission;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = AddMemberPermission.Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            CreateTeamChatPermission.Type r104 = r100.create_team_chat_permission;
            if (r104 == null) goto L9;
            int r105 = CreateTeamChatPermission.Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            BindTeamChatPermission.Type r107 = r100.bind_team_chat_permission;
            if (r107 == null) goto L13;
            int r108 = BindTeamChatPermission.Type.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            AddTeamChatPermission.Type r110 = r100.add_team_chat_permission;
            if (r110 == null) goto L17;
            int r111 = AddTeamChatPermission.Type.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            AddPrivateTeamChatPermission.Type r113 = r100.add_private_team_chat_permission;
            if (r113 == null) goto L22;
            r102 = AddPrivateTeamChatPermission.Type.ADAPTER.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ TeamSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TeamSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TeamSetting r101) throws IOException {
            AddMemberPermission.Type r102 = r101.add_member_permission;
            if (r102 == null) goto L5;
            AddMemberPermission.Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            CreateTeamChatPermission.Type r103 = r101.create_team_chat_permission;
            if (r103 == null) goto L8;
            CreateTeamChatPermission.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            BindTeamChatPermission.Type r104 = r101.bind_team_chat_permission;
            if (r104 == null) goto L11;
            BindTeamChatPermission.Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            AddTeamChatPermission.Type r105 = r101.add_team_chat_permission;
            if (r105 == null) goto L14;
            AddTeamChatPermission.Type.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            AddPrivateTeamChatPermission.Type r106 = r101.add_private_team_chat_permission;
            if (r106 == null) goto L17;
            AddPrivateTeamChatPermission.Type.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TeamSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TeamSetting();
        DEFAULT_ADD_MEMBER_PERMISSION = AddMemberPermission.Type.UNKNOWN;
        DEFAULT_CREATE_TEAM_CHAT_PERMISSION = CreateTeamChatPermission.Type.UNKNOWN;
        DEFAULT_BIND_TEAM_CHAT_PERMISSION = BindTeamChatPermission.Type.BIND_TEAM_CHAT_PERMISSION_UNKNOWN;
        DEFAULT_ADD_TEAM_CHAT_PERMISSION = AddTeamChatPermission.Type.UNKNOWN;
        DEFAULT_ADD_PRIVATE_TEAM_CHAT_PERMISSION = AddPrivateTeamChatPermission.Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.add_member_permission = this.add_member_permission;
        r100.create_team_chat_permission = this.create_team_chat_permission;
        r100.bind_team_chat_permission = this.bind_team_chat_permission;
        r100.add_team_chat_permission = this.add_team_chat_permission;
        r100.add_private_team_chat_permission = this.add_private_team_chat_permission;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TeamSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TeamSetting(AddMemberPermission.Type r100, CreateTeamChatPermission.Type r101, BindTeamChatPermission.Type r110, AddTeamChatPermission.Type r111, AddPrivateTeamChatPermission.Type r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TeamSetting(AddMemberPermission.Type r100, CreateTeamChatPermission.Type r101, BindTeamChatPermission.Type r102, AddTeamChatPermission.Type r103, AddPrivateTeamChatPermission.Type r104, ByteString r105) {
        super(ADAPTER, r105);
        this.add_member_permission = r100;
        this.create_team_chat_permission = r101;
        this.bind_team_chat_permission = r102;
        this.add_team_chat_permission = r103;
        this.add_private_team_chat_permission = r104;
    }
}
