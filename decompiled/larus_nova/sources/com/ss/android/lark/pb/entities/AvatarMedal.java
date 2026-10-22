package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AvatarMedal extends com.squareup.wire.Message<AvatarMedal, Builder> {
    public static final ProtoAdapter<AvatarMedal> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final String DEFAULT_KEY = "";
    public static final Boolean DEFAULT_SHOW_SWITCH = null;
    private static final long serialVersionUID = 0;
    public final String mfs_unit;
    public final I18nVal mi18n_name;
    public final String mkey;
    public final Boolean mshow_switch;

    public static final class Builder extends com.squareup.wire.Message.Builder<AvatarMedal, Builder> {
        public String mfs_unit;
        public I18nVal mi18n_name;
        public String mkey;
        public Boolean mshow_switch;

        @Override // com.squareup.wire.Message.Builder
        public AvatarMedal build() {
            return new AvatarMedal(this.mkey, this.mfs_unit, this.mi18n_name, this.mshow_switch, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder fs_unit(String r100) {
            this.mfs_unit = r100;
            return this;
        }

        public Builder i18n_name(I18nVal r100) {
            this.mi18n_name = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder show_switch(Boolean r100) {
            this.mshow_switch = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AvatarMedal extends ProtoAdapter<AvatarMedal> {
        public ProtoAdapter_AvatarMedal() {
            super(FieldEncoding.LENGTH_DELIMITED, AvatarMedal.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AvatarMedal decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mkey = "";
            r101.mfs_unit = "";
            r101.mshow_switch = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mi18n_name = I18nVal.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mshow_switch = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(AvatarMedal r100) {
            String r101 = r100.mkey;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mfs_unit;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            I18nVal r107 = r100.mi18n_name;
            if (r107 == null) goto L13;
            int r108 = I18nVal.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mshow_switch;
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
        public /* bridge */ /* synthetic */ AvatarMedal decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AvatarMedal r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AvatarMedal r101) throws IOException {
            String r102 = r101.mkey;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mfs_unit;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            I18nVal r104 = r101.mi18n_name;
            if (r104 == null) goto L11;
            I18nVal.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.mshow_switch;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AvatarMedal r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AvatarMedal();
        DEFAULT_SHOW_SWITCH = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkey = this.mkey;
        r100.mfs_unit = this.mfs_unit;
        r100.mi18n_name = this.mi18n_name;
        r100.mshow_switch = this.mshow_switch;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AvatarMedal.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AvatarMedal(String r100, String r101, I18nVal r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AvatarMedal(String r100, String r101, I18nVal r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mkey = r100;
        this.mfs_unit = r101;
        this.mi18n_name = r102;
        this.mshow_switch = r103;
    }
}
