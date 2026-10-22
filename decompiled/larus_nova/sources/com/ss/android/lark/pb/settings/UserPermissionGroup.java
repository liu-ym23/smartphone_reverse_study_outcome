package com.ss.android.lark.pb.settings;

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
public final class UserPermissionGroup extends Message<UserPermissionGroup, Builder> {
    public static final ProtoAdapter<UserPermissionGroup> ADAPTER = null;
    public static final Long DEFAULT_GROUP_ID = null;
    public static final String DEFAULT_GROUP_NAME = "";
    private static final long serialVersionUID = 0;
    public final Long mgroup_id;
    public final String mgroup_name;
    public final List<UserPermissionObject> mobjects;

    public static final class Builder extends Message.Builder<UserPermissionGroup, Builder> {
        public Long mgroup_id;
        public String mgroup_name;
        public List<UserPermissionObject> mobjects;

        @Override // com.squareup.wire.Message.Builder
        public UserPermissionGroup build() {
            return new UserPermissionGroup(this.mgroup_id, this.mgroup_name, this.mobjects, super.buildUnknownFields());
        }

        public Builder() {
            this.mobjects = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder group_id(Long r100) {
            this.mgroup_id = r100;
            return this;
        }

        public Builder group_name(String r100) {
            this.mgroup_name = r100;
            return this;
        }

        public Builder objects(List<UserPermissionObject> r100) {
            Internal.checkElementsNotNull(r100);
            this.mobjects = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserPermissionGroup extends ProtoAdapter<UserPermissionGroup> {
        public ProtoAdapter_UserPermissionGroup() {
            super(FieldEncoding.LENGTH_DELIMITED, UserPermissionGroup.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserPermissionGroup decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mgroup_id = 0L;
            r101.mgroup_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mgroup_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mgroup_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mobjects.add(UserPermissionObject.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserPermissionGroup r100) {
            Long r101 = r100.mgroup_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mgroup_name;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + UserPermissionObject.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mobjects)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserPermissionGroup decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserPermissionGroup r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserPermissionGroup r101) throws IOException {
            Long r102 = r101.mgroup_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mgroup_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            UserPermissionObject.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mobjects);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserPermissionGroup r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserPermissionGroup();
        DEFAULT_GROUP_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mgroup_id = this.mgroup_id;
        r100.mgroup_name = this.mgroup_name;
        r100.mobjects = Internal.copyOf("mobjects", this.mobjects);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserPermissionGroup.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserPermissionGroup(Long r100, String r101, List<UserPermissionObject> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UserPermissionGroup(Long r100, String r101, List<UserPermissionObject> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mgroup_id = r100;
        this.mgroup_name = r101;
        this.mobjects = Internal.immutableCopyOf("mobjects", r102);
    }
}
