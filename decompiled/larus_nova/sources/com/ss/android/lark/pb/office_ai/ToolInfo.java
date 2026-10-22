package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ToolInfo extends Message<ToolInfo, Builder> {
    public static final ProtoAdapter<ToolInfo> ADAPTER = null;
    public static final String DEFAULT_DESC = "";
    public static final String DEFAULT_DETAIL = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mdesc;
    public final String mdetail;
    public final String micon;
    public final String mid;
    public final Map<String, String> mlocale_2_desc;
    public final Map<String, String> mlocale_2_detail;
    public final Map<String, String> mlocale_2_name;
    public final String mname;

    public static final class Builder extends Message.Builder<ToolInfo, Builder> {
        public String mdesc;
        public String mdetail;
        public String micon;
        public String mid;
        public Map<String, String> mlocale_2_desc;
        public Map<String, String> mlocale_2_detail;
        public Map<String, String> mlocale_2_name;
        public String mname;

        @Override // com.squareup.wire.Message.Builder
        public ToolInfo build() {
            return new ToolInfo(this.mid, this.mname, this.micon, this.mdesc, this.mdetail, this.mlocale_2_name, this.mlocale_2_desc, this.mlocale_2_detail, super.buildUnknownFields());
        }

        public Builder() {
            this.mlocale_2_name = Internal.newMutableMap();
            this.mlocale_2_desc = Internal.newMutableMap();
            this.mlocale_2_detail = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder desc(String r100) {
            this.mdesc = r100;
            return this;
        }

        public Builder detail(String r100) {
            this.mdetail = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.micon = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder locale_2_desc(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mlocale_2_desc = r100;
            return this;
        }

        public Builder locale_2_detail(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mlocale_2_detail = r100;
            return this;
        }

        public Builder locale_2_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mlocale_2_name = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ToolInfo extends ProtoAdapter<ToolInfo> {
        private final ProtoAdapter<Map<String, String>> mlocale_2_desc;
        private final ProtoAdapter<Map<String, String>> mlocale_2_detail;
        private final ProtoAdapter<Map<String, String>> mlocale_2_name;

        public ProtoAdapter_ToolInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ToolInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mlocale_2_name = ProtoAdapter.newMapAdapter(r100, r100);
            this.mlocale_2_desc = ProtoAdapter.newMapAdapter(r100, r100);
            this.mlocale_2_detail = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ToolInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mname = "";
            r101.micon = "";
            r101.mdesc = "";
            r101.mdetail = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            switch(r103) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.mlocale_2_detail.putAll(this.mlocale_2_detail.decode(r100));
            goto L3
        L8:
            r101.mlocale_2_desc.putAll(this.mlocale_2_desc.decode(r100));
            goto L3
        L9:
            r101.mlocale_2_name.putAll(this.mlocale_2_name.decode(r100));
            goto L3
        L10:
            r101.mdetail = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mdesc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.micon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ToolInfo r100) {
            String r101 = r100.mid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mname;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.micon;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mdesc;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mdetail;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return ((((r112 + r102) + this.mlocale_2_name.encodedSizeWithTag(6, r100.mlocale_2_name)) + this.mlocale_2_desc.encodedSizeWithTag(7, r100.mlocale_2_desc)) + this.mlocale_2_detail.encodedSizeWithTag(8, r100.mlocale_2_detail)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ToolInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ToolInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ToolInfo r101) throws IOException {
            String r102 = r101.mid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mname;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.micon;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mdesc;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mdetail;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            this.mlocale_2_name.encodeWithTag(r100, 6, r101.mlocale_2_name);
            this.mlocale_2_desc.encodeWithTag(r100, 7, r101.mlocale_2_desc);
            this.mlocale_2_detail.encodeWithTag(r100, 8, r101.mlocale_2_detail);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ToolInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ToolInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mname = this.mname;
        r100.micon = this.micon;
        r100.mdesc = this.mdesc;
        r100.mdetail = this.mdetail;
        r100.mlocale_2_name = Internal.copyOf("mlocale_2_name", this.mlocale_2_name);
        r100.mlocale_2_desc = Internal.copyOf("mlocale_2_desc", this.mlocale_2_desc);
        r100.mlocale_2_detail = Internal.copyOf("mlocale_2_detail", this.mlocale_2_detail);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ToolInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ToolInfo(String r110, String r111, String r112, String r113, String r114, Map<String, String> r115, Map<String, String> r116, Map<String, String> r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public ToolInfo(String r100, String r101, String r102, String r103, String r104, Map<String, String> r105, Map<String, String> r106, Map<String, String> r107, ByteString r110) {
        super(ADAPTER, r110);
        this.mid = r100;
        this.mname = r101;
        this.micon = r102;
        this.mdesc = r103;
        this.mdetail = r104;
        this.mlocale_2_name = Internal.immutableCopyOf("mlocale_2_name", r105);
        this.mlocale_2_desc = Internal.immutableCopyOf("mlocale_2_desc", r106);
        this.mlocale_2_detail = Internal.immutableCopyOf("mlocale_2_detail", r107);
    }
}
