package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DocPermission extends com.squareup.wire.Message<DocPermission, Builder> {
    public static final ProtoAdapter<DocPermission> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SET = null;
    public static final Integer DEFAULT_PERM_CODE = null;
    public static final String DEFAULT_PERM_NAME = "";
    private static final long serialVersionUID = 0;
    public final Boolean mis_set;
    public final Integer mperm_code;
    public final String mperm_name;

    public static final class Builder extends com.squareup.wire.Message.Builder<DocPermission, Builder> {
        public Boolean mis_set;
        public Integer mperm_code;
        public String mperm_name;

        @Override // com.squareup.wire.Message.Builder
        public DocPermission build() {
            return new DocPermission(this.mperm_code, this.mperm_name, this.mis_set, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_set(Boolean r100) {
            this.mis_set = r100;
            return this;
        }

        public Builder perm_code(Integer r100) {
            this.mperm_code = r100;
            return this;
        }

        public Builder perm_name(String r100) {
            this.mperm_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DocPermission extends ProtoAdapter<DocPermission> {
        public ProtoAdapter_DocPermission() {
            super(FieldEncoding.LENGTH_DELIMITED, DocPermission.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocPermission decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mperm_code = 0;
            r101.mperm_name = "";
            r101.mis_set = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mperm_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mperm_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mis_set = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(DocPermission r100) {
            Integer r101 = r100.mperm_code;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mperm_name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mis_set;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ DocPermission decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocPermission r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocPermission r101) throws IOException {
            Integer r102 = r101.mperm_code;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mperm_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mis_set;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocPermission r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocPermission();
        DEFAULT_PERM_CODE = 0;
        DEFAULT_IS_SET = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mperm_code = this.mperm_code;
        r100.mperm_name = this.mperm_name;
        r100.mis_set = this.mis_set;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocPermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocPermission(Integer r100, String r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DocPermission(Integer r100, String r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mperm_code = r100;
        this.mperm_name = r101;
        this.mis_set = r102;
    }
}
