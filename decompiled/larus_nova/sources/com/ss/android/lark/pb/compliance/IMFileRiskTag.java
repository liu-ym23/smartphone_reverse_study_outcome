package com.ss.android.lark.pb.compliance;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class IMFileRiskTag extends Message<IMFileRiskTag, Builder> {
    public static final ProtoAdapter<IMFileRiskTag> ADAPTER = null;
    public static final Boolean DEFAULT_IS_RISK_FILE = null;
    public static final Boolean DEFAULT_IS_RISK_TAG_EXIST = null;
    public static final String DEFAULT_OBJECT_ID = "";
    public static final Boolean DEFAULT_RESTRICT_OPERATION = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_risk_file;
    public final Boolean mis_risk_tag_exist;
    public final String mobject_id;
    public final Boolean mrestrict_operation;

    public static final class Builder extends Message.Builder<IMFileRiskTag, Builder> {
        public Boolean mis_risk_file;
        public Boolean mis_risk_tag_exist;
        public String mobject_id;
        public Boolean mrestrict_operation;

        @Override // com.squareup.wire.Message.Builder
        public IMFileRiskTag build() {
            return new IMFileRiskTag(this.mobject_id, this.mis_risk_tag_exist, this.mis_risk_file, this.mrestrict_operation, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_risk_file(Boolean r100) {
            this.mis_risk_file = r100;
            return this;
        }

        public Builder is_risk_tag_exist(Boolean r100) {
            this.mis_risk_tag_exist = r100;
            return this;
        }

        public Builder object_id(String r100) {
            this.mobject_id = r100;
            return this;
        }

        public Builder restrict_operation(Boolean r100) {
            this.mrestrict_operation = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_IMFileRiskTag extends ProtoAdapter<IMFileRiskTag> {
        public ProtoAdapter_IMFileRiskTag() {
            super(FieldEncoding.LENGTH_DELIMITED, IMFileRiskTag.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public IMFileRiskTag decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mobject_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.mis_risk_tag_exist = r102;
            r101.mis_risk_file = r102;
            r101.mrestrict_operation = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.mobject_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mis_risk_tag_exist = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.mis_risk_file = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.mrestrict_operation = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(IMFileRiskTag r100) {
            String r101 = r100.mobject_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mis_risk_tag_exist;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mis_risk_file;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mrestrict_operation;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ IMFileRiskTag decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(IMFileRiskTag r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, IMFileRiskTag r101) throws IOException {
            String r102 = r101.mobject_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mis_risk_tag_exist;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mis_risk_file;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.mrestrict_operation;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IMFileRiskTag r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IMFileRiskTag();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_RISK_TAG_EXIST = r100;
        DEFAULT_IS_RISK_FILE = r100;
        DEFAULT_RESTRICT_OPERATION = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mobject_id = this.mobject_id;
        r100.mis_risk_tag_exist = this.mis_risk_tag_exist;
        r100.mis_risk_file = this.mis_risk_file;
        r100.mrestrict_operation = this.mrestrict_operation;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return IMFileRiskTag.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public IMFileRiskTag(String r100, Boolean r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public IMFileRiskTag(String r100, Boolean r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mobject_id = r100;
        this.mis_risk_tag_exist = r101;
        this.mis_risk_file = r102;
        this.mrestrict_operation = r103;
    }
}
