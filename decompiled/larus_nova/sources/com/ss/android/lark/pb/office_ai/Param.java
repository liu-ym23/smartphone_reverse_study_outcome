package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Param extends Message<Param, Builder> {
    public static final ProtoAdapter<Param> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_ = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_OPTIONAL = null;
    public static final String DEFAULT_NAME = "";
    public static final Boolean DEFAULT_NEED_CONFIRM = null;
    public static final String DEFAULT_PLACE_HOLDER = "";
    private static final long serialVersionUID = 0;
    public final String mdefault_;
    public final String mdescription;
    public final String mdisplay_name;
    public final String mid;
    public final Boolean mis_optional;
    public final String mname;
    public final Boolean mneed_confirm;
    public final String mplace_holder;

    public static final class Builder extends Message.Builder<Param, Builder> {
        public String mdefault_;
        public String mdescription;
        public String mdisplay_name;
        public String mid;
        public Boolean mis_optional;
        public String mname;
        public Boolean mneed_confirm;
        public String mplace_holder;

        @Override // com.squareup.wire.Message.Builder
        public Param build() {
            return new Param(this.mid, this.mname, this.mis_optional, this.mdefault_, this.mneed_confirm, this.mdescription, this.mplace_holder, this.mdisplay_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder default_(String r100) {
            this.mdefault_ = r100;
            return this;
        }

        public Builder description(String r100) {
            this.mdescription = r100;
            return this;
        }

        public Builder display_name(String r100) {
            this.mdisplay_name = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder is_optional(Boolean r100) {
            this.mis_optional = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder need_confirm(Boolean r100) {
            this.mneed_confirm = r100;
            return this;
        }

        public Builder place_holder(String r100) {
            this.mplace_holder = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Param extends ProtoAdapter<Param> {
        public ProtoAdapter_Param() {
            super(FieldEncoding.LENGTH_DELIMITED, Param.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Param decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mname = "";
            Boolean r102 = Boolean.FALSE;
            r101.mis_optional = r102;
            r101.mdefault_ = "";
            r101.mneed_confirm = r102;
            r101.mdescription = "";
            r101.mplace_holder = "";
            r101.mdisplay_name = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            switch(r104) {
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
            r101.mdisplay_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mplace_holder = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mdescription = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mneed_confirm = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.mdefault_ = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mis_optional = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Param r100) {
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
            Boolean r107 = r100.mis_optional;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mdefault_;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.mneed_confirm;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.mdescription;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mplace_holder;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mdisplay_name;
            if (r122 == null) goto L34;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
        L29:
            r120 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ Param decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Param r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Param r101) throws IOException {
            String r102 = r101.mid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mname;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mis_optional;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mdefault_;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.mneed_confirm;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.mdescription;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.mplace_holder;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.mdisplay_name;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Param r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Param();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_OPTIONAL = r100;
        DEFAULT_NEED_CONFIRM = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mname = this.mname;
        r100.mis_optional = this.mis_optional;
        r100.mdefault_ = this.mdefault_;
        r100.mneed_confirm = this.mneed_confirm;
        r100.mdescription = this.mdescription;
        r100.mplace_holder = this.mplace_holder;
        r100.mdisplay_name = this.mdisplay_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Param.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Param(String r110, String r111, Boolean r112, String r113, Boolean r114, String r115, String r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public Param(String r100, String r101, Boolean r102, String r103, Boolean r104, String r105, String r106, String r107, ByteString r110) {
        super(ADAPTER, r110);
        this.mid = r100;
        this.mname = r101;
        this.mis_optional = r102;
        this.mdefault_ = r103;
        this.mneed_confirm = r104;
        this.mdescription = r105;
        this.mplace_holder = r106;
        this.mdisplay_name = r107;
    }
}
