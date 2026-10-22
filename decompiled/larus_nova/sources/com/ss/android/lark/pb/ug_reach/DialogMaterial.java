package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DialogMaterial extends Message<DialogMaterial, Builder> {
    public static final ProtoAdapter<DialogMaterial> ADAPTER = null;
    public static final String DEFAULT_DATA = "";
    public static final String DEFAULT_DIALOG_NAME = "";
    public static final String DEFAULT_LAYOUT_NAME = "";
    private static final long serialVersionUID = 0;
    public final MaterialBase mbase;
    public final String mdata;
    public final String mdialog_name;
    public final String mlayout_name;

    public static final class Builder extends Message.Builder<DialogMaterial, Builder> {
        public MaterialBase mbase;
        public String mdata;
        public String mdialog_name;
        public String mlayout_name;

        @Override // com.squareup.wire.Message.Builder
        public DialogMaterial build() {
            return new DialogMaterial(this.mdialog_name, this.mlayout_name, this.mdata, this.mbase, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder base(MaterialBase r100) {
            this.mbase = r100;
            return this;
        }

        public Builder data(String r100) {
            this.mdata = r100;
            return this;
        }

        public Builder dialog_name(String r100) {
            this.mdialog_name = r100;
            return this;
        }

        public Builder layout_name(String r100) {
            this.mlayout_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DialogMaterial extends ProtoAdapter<DialogMaterial> {
        public ProtoAdapter_DialogMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, DialogMaterial.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DialogMaterial decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mdialog_name = "";
            r101.mlayout_name = "";
            r101.mdata = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mdialog_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mlayout_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mdata = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mbase = MaterialBase.ADAPTER.decode(r100);
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
        public int encodedSize2(DialogMaterial r100) {
            String r101 = r100.mdialog_name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mlayout_name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mdata;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            MaterialBase r110 = r100.mbase;
            if (r110 == null) goto L18;
            r102 = MaterialBase.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ DialogMaterial decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DialogMaterial r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DialogMaterial r101) throws IOException {
            String r102 = r101.mdialog_name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mlayout_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mdata;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            MaterialBase r105 = r101.mbase;
            if (r105 == null) goto L14;
            MaterialBase.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DialogMaterial r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DialogMaterial();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdialog_name = this.mdialog_name;
        r100.mlayout_name = this.mlayout_name;
        r100.mdata = this.mdata;
        r100.mbase = this.mbase;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DialogMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DialogMaterial(String r100, String r101, String r102, MaterialBase r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public DialogMaterial(String r100, String r101, String r102, MaterialBase r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mdialog_name = r100;
        this.mlayout_name = r101;
        this.mdata = r102;
        this.mbase = r103;
    }
}
