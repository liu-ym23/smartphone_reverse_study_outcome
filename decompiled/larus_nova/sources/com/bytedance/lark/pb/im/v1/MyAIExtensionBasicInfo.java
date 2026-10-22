package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MyAIExtensionBasicInfo extends Message<MyAIExtensionBasicInfo, Builder> {
    public static final ProtoAdapter<MyAIExtensionBasicInfo> ADAPTER = null;
    public static final String DEFAULT_DESC = "";
    public static final String DEFAULT_EDIT_URL = "";
    public static final Long DEFAULT_EXTENSION_STATUS = null;
    public static final MyAIExtensionType DEFAULT_EXTENSION_TYPE = null;
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String desc;
    public final String edit_url;
    public final Long extension_status;
    public final MyAIExtensionType extension_type;
    public final String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253645id;
    public final Map<String, String> locale_2_desc;
    public final Map<String, String> locale_2_name;
    public final String name;

    public static final class Builder extends Message.Builder<MyAIExtensionBasicInfo, Builder> {
        public String desc;
        public String edit_url;
        public Long extension_status;
        public MyAIExtensionType extension_type;
        public String icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253646id;
        public Map<String, String> locale_2_desc;
        public Map<String, String> locale_2_name;
        public String name;

        @Override // com.squareup.wire.Message.Builder
        public MyAIExtensionBasicInfo build() {
            return new MyAIExtensionBasicInfo(this.f253646id, this.name, this.icon, this.desc, this.locale_2_name, this.locale_2_desc, this.extension_type, this.extension_status, this.edit_url, super.buildUnknownFields());
        }

        public Builder() {
            this.locale_2_name = Internal.newMutableMap();
            this.locale_2_desc = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder desc(String r100) {
            this.desc = r100;
            return this;
        }

        public Builder edit_url(String r100) {
            this.edit_url = r100;
            return this;
        }

        public Builder extension_status(Long r100) {
            this.extension_status = r100;
            return this;
        }

        public Builder extension_type(MyAIExtensionType r100) {
            this.extension_type = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.icon = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253646id = r100;
            return this;
        }

        public Builder locale_2_desc(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.locale_2_desc = r100;
            return this;
        }

        public Builder locale_2_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.locale_2_name = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MyAIExtensionBasicInfo extends ProtoAdapter<MyAIExtensionBasicInfo> {
        private final ProtoAdapter<Map<String, String>> locale_2_desc;
        private final ProtoAdapter<Map<String, String>> locale_2_name;

        public ProtoAdapter_MyAIExtensionBasicInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MyAIExtensionBasicInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.locale_2_name = ProtoAdapter.newMapAdapter(r100, r100);
            this.locale_2_desc = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MyAIExtensionBasicInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253646id = "";
            r101.name = "";
            r101.icon = "";
            r101.desc = "";
            r101.extension_type = MyAIExtensionType.ExtensionTypeQA;
            r101.extension_status = 0L;
            r101.edit_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L21;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.extension_type = MyAIExtensionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.edit_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.extension_status = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.locale_2_desc.putAll(this.locale_2_desc.decode(r100));
            goto L3
        L14:
            r101.locale_2_name.putAll(this.locale_2_name.decode(r100));
            goto L3
        L15:
            r101.desc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.f253646id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MyAIExtensionBasicInfo r100) {
            String r101 = r100.f253645id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.icon;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.desc;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = ((r109 + r111) + this.locale_2_name.encodedSizeWithTag(5, r100.locale_2_name)) + this.locale_2_desc.encodedSizeWithTag(6, r100.locale_2_desc);
            MyAIExtensionType r113 = r100.extension_type;
            if (r113 == null) goto L21;
            int r114 = MyAIExtensionType.ADAPTER.encodedSizeWithTag(7, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.extension_status;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(8, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.edit_url;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(9, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ MyAIExtensionBasicInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MyAIExtensionBasicInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MyAIExtensionBasicInfo r101) throws IOException {
            String r102 = r101.f253645id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.icon;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.desc;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            this.locale_2_name.encodeWithTag(r100, 5, r101.locale_2_name);
            this.locale_2_desc.encodeWithTag(r100, 6, r101.locale_2_desc);
            MyAIExtensionType r106 = r101.extension_type;
            if (r106 == null) goto L17;
            MyAIExtensionType.ADAPTER.encodeWithTag(r100, 7, r106);
        L17:
            Long r107 = r101.extension_status;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r107);
        L20:
            String r108 = r101.edit_url;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MyAIExtensionBasicInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MyAIExtensionBasicInfo();
        DEFAULT_EXTENSION_TYPE = MyAIExtensionType.ExtensionTypeQA;
        DEFAULT_EXTENSION_STATUS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253646id = this.f253645id;
        r100.name = this.name;
        r100.icon = this.icon;
        r100.desc = this.desc;
        r100.locale_2_name = Internal.copyOf("locale_2_name", this.locale_2_name);
        r100.locale_2_desc = Internal.copyOf("locale_2_desc", this.locale_2_desc);
        r100.extension_type = this.extension_type;
        r100.extension_status = this.extension_status;
        r100.edit_url = this.edit_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MyAIExtensionBasicInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MyAIExtensionBasicInfo(String r110, String r111, String r112, String r113, Map<String, String> r114, Map<String, String> r115, MyAIExtensionType r116, Long r117, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public MyAIExtensionBasicInfo(String r100, String r101, String r102, String r103, Map<String, String> r104, Map<String, String> r105, MyAIExtensionType r106, Long r107, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.f253645id = r100;
        this.name = r101;
        this.icon = r102;
        this.desc = r103;
        this.locale_2_name = Internal.immutableCopyOf("locale_2_name", r104);
        this.locale_2_desc = Internal.immutableCopyOf("locale_2_desc", r105);
        this.extension_type = r106;
        this.extension_status = r107;
        this.edit_url = r110;
    }
}
