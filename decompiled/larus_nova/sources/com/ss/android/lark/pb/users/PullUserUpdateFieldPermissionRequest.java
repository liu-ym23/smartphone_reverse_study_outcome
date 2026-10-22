package com.ss.android.lark.pb.users;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullUserUpdateFieldPermissionRequest extends Message<PullUserUpdateFieldPermissionRequest, Builder> {
    public static final ProtoAdapter<PullUserUpdateFieldPermissionRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<UserUpdatePermission> muser_update_permissions;

    public static final class Builder extends Message.Builder<PullUserUpdateFieldPermissionRequest, Builder> {
        public List<UserUpdatePermission> muser_update_permissions;

        @Override // com.squareup.wire.Message.Builder
        public PullUserUpdateFieldPermissionRequest build() {
            return new PullUserUpdateFieldPermissionRequest(this.muser_update_permissions, super.buildUnknownFields());
        }

        public Builder() {
            this.muser_update_permissions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder user_update_permissions(List<UserUpdatePermission> r100) {
            Internal.checkElementsNotNull(r100);
            this.muser_update_permissions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUserUpdateFieldPermissionRequest extends ProtoAdapter<PullUserUpdateFieldPermissionRequest> {
        public ProtoAdapter_PullUserUpdateFieldPermissionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUserUpdateFieldPermissionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullUserUpdateFieldPermissionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.muser_update_permissions.add(UserUpdatePermission.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(PullUserUpdateFieldPermissionRequest r100) {
            return UserUpdatePermission.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.muser_update_permissions) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullUserUpdateFieldPermissionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullUserUpdateFieldPermissionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullUserUpdateFieldPermissionRequest r101) throws IOException {
            UserUpdatePermission.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.muser_update_permissions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullUserUpdateFieldPermissionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUserUpdateFieldPermissionRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.muser_update_permissions = Internal.copyOf("muser_update_permissions", this.muser_update_permissions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullUserUpdateFieldPermissionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullUserUpdateFieldPermissionRequest(List<UserUpdatePermission> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullUserUpdateFieldPermissionRequest(List<UserUpdatePermission> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.muser_update_permissions = Internal.immutableCopyOf("muser_update_permissions", r100);
    }
}
