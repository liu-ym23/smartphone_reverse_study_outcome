package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Chat;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatInfo extends Message<ChatInfo, Builder> {
    public static final ProtoAdapter<ChatInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_MEMBER = null;
    private static final long serialVersionUID = 0;
    public final Chat mchat;
    public final Boolean mis_member;
    public final UserPermission muser_perm;

    public static final class Builder extends Message.Builder<ChatInfo, Builder> {
        public Chat mchat;
        public Boolean mis_member;
        public UserPermission muser_perm;

        @Override // com.squareup.wire.Message.Builder
        public ChatInfo build() {
            UserPermission r100 = this.muser_perm;
            if (r100 == null) goto L7;
            return new ChatInfo(this.muser_perm, this.mchat, this.mis_member, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "muser_perm"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat(Chat r100) {
            this.mchat = r100;
            return this;
        }

        public Builder is_member(Boolean r100) {
            this.mis_member = r100;
            return this;
        }

        public Builder user_perm(UserPermission r100) {
            this.muser_perm = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatInfo extends ProtoAdapter<ChatInfo> {
        public ProtoAdapter_ChatInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_member = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.muser_perm = UserPermission.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mchat = Chat.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mis_member = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(ChatInfo r100) {
            int r101 = UserPermission.ADAPTER.encodedSizeWithTag(1, r100.muser_perm);
            Chat r102 = r100.mchat;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = Chat.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.mis_member;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatInfo r101) throws IOException {
            UserPermission.ADAPTER.encodeWithTag(r100, 1, r101.muser_perm);
            Chat r102 = r101.mchat;
            if (r102 == null) goto L5;
            Chat.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.mis_member;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum UserPermission extends Enum<UserPermission> implements WireEnum {
        private static final /* synthetic */ UserPermission[] $VALUES = null;
        public static final ProtoAdapter<UserPermission> ADAPTER = null;
        public static final UserPermission INVISIBLE = null;
        public static final UserPermission UNKNOWN = null;
        public static final UserPermission VISIBLE_AND_CREATE = null;
        public static final UserPermission VISIBLE_NOT_CREATE = null;
        private final int value;

        static {
            UserPermission r100 = new UserPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            UserPermission r101 = new UserPermission("VISIBLE_AND_CREATE", 1, 1);
            VISIBLE_AND_CREATE = r101;
            UserPermission r102 = new UserPermission("VISIBLE_NOT_CREATE", 2, 2);
            VISIBLE_NOT_CREATE = r102;
            UserPermission r103 = new UserPermission("INVISIBLE", 3, 3);
            INVISIBLE = r103;
            $VALUES = new UserPermission[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(UserPermission.class);
        }

        public static UserPermission[] values() {
            return (UserPermission[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static UserPermission fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return INVISIBLE;
        L14:
            return VISIBLE_NOT_CREATE;
        L16:
            return VISIBLE_AND_CREATE;
        L18:
            return UNKNOWN;
        }

        public static UserPermission valueOf(String r100) {
            return (UserPermission) a.a(UserPermission.class, r100);
        }

        private UserPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatInfo();
        DEFAULT_IS_MEMBER = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.muser_perm = this.muser_perm;
        r100.mchat = this.mchat;
        r100.mis_member = this.mis_member;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatInfo(UserPermission r100, Chat r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ChatInfo(UserPermission r100, Chat r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.muser_perm = r100;
        this.mchat = r101;
        this.mis_member = r102;
    }
}
