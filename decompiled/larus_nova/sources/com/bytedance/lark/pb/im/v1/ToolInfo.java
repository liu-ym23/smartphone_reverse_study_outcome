package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ToolInfo extends Message<ToolInfo, Builder> {
    public static final ProtoAdapter<ToolInfo> ADAPTER = null;
    public static final String DEFAULT_DESC = "";
    public static final String DEFAULT_DETAIL = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String desc;
    public final String detail;
    public final String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253659id;
    public final String name;

    public static final class Builder extends Message.Builder<ToolInfo, Builder> {
        public String desc;
        public String detail;
        public String icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253660id;
        public String name;

        @Override // com.squareup.wire.Message.Builder
        public ToolInfo build() {
            return new ToolInfo(this.f253660id, this.name, this.icon, this.desc, this.detail, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder desc(String r100) {
            this.desc = r100;
            return this;
        }

        public Builder detail(String r100) {
            this.detail = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.icon = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253660id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ToolInfo extends ProtoAdapter<ToolInfo> {
        public ProtoAdapter_ToolInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ToolInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ToolInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253660id = "";
            r101.name = "";
            r101.icon = "";
            r101.desc = "";
            r101.detail = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.f253660id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.desc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.detail = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ToolInfo r100) {
            String r101 = r100.f253659id;
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
            int r112 = r109 + r111;
            String r113 = r100.detail;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ ToolInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ToolInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ToolInfo r101) throws IOException {
            String r102 = r101.f253659id;
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
            String r106 = r101.detail;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
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
        r100.f253660id = this.f253659id;
        r100.name = this.name;
        r100.icon = this.icon;
        r100.desc = this.desc;
        r100.detail = this.detail;
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

    public ToolInfo(String r100, String r101, String r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ToolInfo(String r100, String r101, String r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.f253659id = r100;
        this.name = r101;
        this.icon = r102;
        this.desc = r103;
        this.detail = r104;
    }
}
