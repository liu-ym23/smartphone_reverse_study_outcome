package com.bytedance.lark.pb.contact.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PrivateDescriptionItem extends Message<PrivateDescriptionItem, Builder> {
    public static final ProtoAdapter<PrivateDescriptionItem> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_DESCRIPTION_ID = null;
    public static final Boolean DEFAULT_IS_DELETED = null;
    private static final long serialVersionUID = 0;
    public final String content;
    public final Long description_id;
    public final Boolean is_deleted;
    public final List<UserPermissionObject> visible_objects;

    public static final class Builder extends Message.Builder<PrivateDescriptionItem, Builder> {
        public String content;
        public Long description_id;
        public Boolean is_deleted;
        public List<UserPermissionObject> visible_objects;

        @Override // com.squareup.wire.Message.Builder
        public PrivateDescriptionItem build() {
            return new PrivateDescriptionItem(this.description_id, this.content, this.visible_objects, this.is_deleted, super.buildUnknownFields());
        }

        public Builder() {
            this.visible_objects = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder description_id(Long r100) {
            this.description_id = r100;
            return this;
        }

        public Builder is_deleted(Boolean r100) {
            this.is_deleted = r100;
            return this;
        }

        public Builder visible_objects(List<UserPermissionObject> r100) {
            Internal.checkElementsNotNull(r100);
            this.visible_objects = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PrivateDescriptionItem extends ProtoAdapter<PrivateDescriptionItem> {
        public ProtoAdapter_PrivateDescriptionItem() {
            super(FieldEncoding.LENGTH_DELIMITED, PrivateDescriptionItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PrivateDescriptionItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.description_id = 0L;
            r101.content = "";
            r101.is_deleted = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.description_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.visible_objects.add(UserPermissionObject.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 6) goto L13;
            r101.is_deleted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PrivateDescriptionItem r100) {
            Long r101 = r100.description_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.content;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + UserPermissionObject.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.visible_objects);
            Boolean r107 = r100.is_deleted;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r107);
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
        public /* bridge */ /* synthetic */ PrivateDescriptionItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PrivateDescriptionItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PrivateDescriptionItem r101) throws IOException {
            Long r102 = r101.description_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.content;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            UserPermissionObject.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.visible_objects);
            Boolean r104 = r101.is_deleted;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PrivateDescriptionItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PrivateDescriptionItem();
        DEFAULT_DESCRIPTION_ID = 0L;
        DEFAULT_IS_DELETED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.description_id = this.description_id;
        r100.content = this.content;
        r100.visible_objects = Internal.copyOf("visible_objects", this.visible_objects);
        r100.is_deleted = this.is_deleted;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PrivateDescriptionItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PrivateDescriptionItem(Long r100, String r101, List<UserPermissionObject> r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PrivateDescriptionItem(Long r100, String r101, List<UserPermissionObject> r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.description_id = r100;
        this.content = r101;
        this.visible_objects = Internal.immutableCopyOf("visible_objects", r102);
        this.is_deleted = r103;
    }
}
