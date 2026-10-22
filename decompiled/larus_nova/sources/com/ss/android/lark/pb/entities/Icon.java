package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Icon extends com.squareup.wire.Message<Icon, Builder> {
    public static final ProtoAdapter<Icon> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final String DEFAULT_KEY = "";
    private static final long serialVersionUID = 0;
    public final String mKey;
    public final String mfs_unit;
    public final IconType mtype;

    public static final class Builder extends com.squareup.wire.Message.Builder<Icon, Builder> {
        public String mKey;
        public String mfs_unit;
        public IconType mtype;

        @Override // com.squareup.wire.Message.Builder
        public Icon build() {
            return new Icon(this.mtype, this.mKey, this.mfs_unit, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder Key(String r100) {
            this.mKey = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.mfs_unit = r100;
            return this;
        }

        public Builder type(IconType r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Icon extends ProtoAdapter<Icon> {
        public ProtoAdapter_Icon() {
            super(FieldEncoding.LENGTH_DELIMITED, Icon.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Icon decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mKey = "";
            r101.mfs_unit = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mtype = IconType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mKey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Icon r100) {
            IconType r101 = r100.mtype;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = IconType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mKey;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mfs_unit;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ Icon decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Icon r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Icon r101) throws IOException {
            IconType r102 = r101.mtype;
            if (r102 == null) goto L5;
            IconType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mKey;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mfs_unit;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Icon r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Icon();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtype = this.mtype;
        r100.mKey = this.mKey;
        r100.mfs_unit = this.mfs_unit;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Icon.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Icon(IconType r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public Icon(IconType r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mtype = r100;
        this.mKey = r101;
        this.mfs_unit = r102;
    }
}
