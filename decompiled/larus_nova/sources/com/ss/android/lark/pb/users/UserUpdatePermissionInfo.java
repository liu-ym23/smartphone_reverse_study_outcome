package com.ss.android.lark.pb.users;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class UserUpdatePermissionInfo extends Message<UserUpdatePermissionInfo, Builder> {
    public static final ProtoAdapter<UserUpdatePermissionInfo> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE = null;
    private static final long serialVersionUID = 0;
    public final I18nVal mdeny_description;
    public final Boolean menable;
    public final UserUpdatePermission muser_update_permission;

    public static final class Builder extends Message.Builder<UserUpdatePermissionInfo, Builder> {
        public I18nVal mdeny_description;
        public Boolean menable;
        public UserUpdatePermission muser_update_permission;

        @Override // com.squareup.wire.Message.Builder
        public UserUpdatePermissionInfo build() {
            UserUpdatePermission r100 = this.muser_update_permission;
            if (r100 == null) goto L9;
            if (this.menable == null) goto L9;
            return new UserUpdatePermissionInfo(this.muser_update_permission, this.menable, this.mdeny_description, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "muser_update_permission", this.menable, "menable"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder deny_description(I18nVal r100) {
            this.mdeny_description = r100;
            return this;
        }

        public Builder enable(Boolean r100) {
            this.menable = r100;
            return this;
        }

        public Builder user_update_permission(UserUpdatePermission r100) {
            this.muser_update_permission = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserUpdatePermissionInfo extends ProtoAdapter<UserUpdatePermissionInfo> {
        public ProtoAdapter_UserUpdatePermissionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UserUpdatePermissionInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserUpdatePermissionInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.menable = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.muser_update_permission = UserUpdatePermission.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.menable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mdeny_description = I18nVal.ADAPTER.decode(r100);
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
        public int encodedSize2(UserUpdatePermissionInfo r100) {
            int r101 = UserUpdatePermission.ADAPTER.encodedSizeWithTag(1, r100.muser_update_permission) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.menable);
            I18nVal r102 = r100.mdeny_description;
            if (r102 == null) goto L5;
            int r103 = I18nVal.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserUpdatePermissionInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserUpdatePermissionInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserUpdatePermissionInfo r101) throws IOException {
            UserUpdatePermission.ADAPTER.encodeWithTag(r100, 1, r101.muser_update_permission);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.menable);
            I18nVal r102 = r101.mdeny_description;
            if (r102 == null) goto L5;
            I18nVal.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserUpdatePermissionInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserUpdatePermissionInfo();
        DEFAULT_ENABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.muser_update_permission = this.muser_update_permission;
        r100.menable = this.menable;
        r100.mdeny_description = this.mdeny_description;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserUpdatePermissionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserUpdatePermissionInfo(UserUpdatePermission r100, Boolean r101, I18nVal r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UserUpdatePermissionInfo(UserUpdatePermission r100, Boolean r101, I18nVal r102, ByteString r103) {
        super(ADAPTER, r103);
        this.muser_update_permission = r100;
        this.menable = r101;
        this.mdeny_description = r102;
    }
}
