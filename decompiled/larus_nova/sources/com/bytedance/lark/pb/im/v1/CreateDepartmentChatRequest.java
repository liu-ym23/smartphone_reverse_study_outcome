package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.AvatarMeta;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CreateDepartmentChatRequest extends Message<CreateDepartmentChatRequest, Builder> {
    public static final ProtoAdapter<CreateDepartmentChatRequest> ADAPTER = null;
    public static final String DEFAULT_DEPARTMENT_ID = "";
    public static final String DEFAULT_GROUP_DESC = "";
    public static final String DEFAULT_ICON_KEY = "";
    public static final ProtoAdapter_CreateDepartmentChatRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AvatarMeta avatar_meta;
    public final List<String> chatter_ids;
    public final String department_id;
    public final String group_desc;
    public final String icon_key;

    public static final class Builder extends Message.Builder<CreateDepartmentChatRequest, Builder> implements d<CreateDepartmentChatRequest> {
        public AvatarMeta avatar_meta;
        public List<String> chatter_ids;
        public String department_id;
        public String group_desc;
        public String icon_key;

        @Override // com.squareup.wire.Message.Builder
        public CreateDepartmentChatRequest build() {
            String r100 = this.department_id;
            if (r100 == null) goto L7;
            return new CreateDepartmentChatRequest(this.department_id, this.chatter_ids, this.group_desc, this.icon_key, this.avatar_meta, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "department_id"});
        }

        public Builder() {
            this.chatter_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_meta(AvatarMeta r100) {
            this.avatar_meta = r100;
            return this;
        }

        public Builder chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_ids = r100;
            return this;
        }

        public Builder department_id(String r100) {
            this.department_id = r100;
            return this;
        }

        public Builder group_desc(String r100) {
            this.group_desc = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.icon_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateDepartmentChatRequest extends ProtoAdapter<CreateDepartmentChatRequest> implements c<CreateDepartmentChatRequest> {
        public ProtoAdapter_CreateDepartmentChatRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateDepartmentChatRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateDepartmentChatRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.department_id = "";
            r101.group_desc = "";
            r101.icon_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.department_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.group_desc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.avatar_meta = AvatarMeta.ADAPTER.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CreateDepartmentChatRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.department_id) + r101.asRepeated().encodedSizeWithTag(2, r100.chatter_ids);
            String r103 = r100.group_desc;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.icon_key;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            AvatarMeta r110 = r100.avatar_meta;
            if (r110 == null) goto L14;
            r104 = AvatarMeta.ADAPTER.encodedSizeWithTag(5, r110);
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
        public /* bridge */ /* synthetic */ CreateDepartmentChatRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateDepartmentChatRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateDepartmentChatRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.department_id);
            r102.asRepeated().encodeWithTag(r100, 2, r101.chatter_ids);
            String r103 = r101.group_desc;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.icon_key;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            AvatarMeta r105 = r101.avatar_meta;
            if (r105 == null) goto L11;
            AvatarMeta.ADAPTER.encodeWithTag(r100, 5, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateDepartmentChatRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateDepartmentChatRequest r100 = new ProtoAdapter_CreateDepartmentChatRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.department_id = this.department_id;
        r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r100.group_desc = this.group_desc;
        r100.icon_key = this.icon_key;
        r100.avatar_meta = this.avatar_meta;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateDepartmentChatRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateDepartmentChatRequest(String r100, List<String> r101, String r110, String r111, AvatarMeta r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public CreateDepartmentChatRequest(String r100, List<String> r101, String r102, String r103, AvatarMeta r104, ByteString r105) {
        super(ADAPTER, r105);
        this.department_id = r100;
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r101);
        this.group_desc = r102;
        this.icon_key = r103;
        this.avatar_meta = r104;
    }
}
