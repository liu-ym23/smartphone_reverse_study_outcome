package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class UDIcon extends com.squareup.wire.Message<UDIcon, Builder> {
    public static final ProtoAdapter<UDIcon> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_UNICODE = "";
    private static final long serialVersionUID = 0;
    public final ThemeColor mcolor;
    public final String mkey;
    public final String municode;

    public static final class Builder extends com.squareup.wire.Message.Builder<UDIcon, Builder> {
        public ThemeColor mcolor;
        public String mkey;
        public String municode;

        @Override // com.squareup.wire.Message.Builder
        public UDIcon build() {
            return new UDIcon(this.mkey, this.mcolor, this.municode, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder color(ThemeColor r100) {
            this.mcolor = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder unicode(String r100) {
            this.municode = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UDIcon extends ProtoAdapter<UDIcon> {
        public ProtoAdapter_UDIcon() {
            super(FieldEncoding.LENGTH_DELIMITED, UDIcon.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UDIcon decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mkey = "";
            r101.municode = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mcolor = ThemeColor.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.municode = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UDIcon r100) {
            String r101 = r100.mkey;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ThemeColor r104 = r100.mcolor;
            if (r104 == null) goto L9;
            int r105 = ThemeColor.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.municode;
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
        public /* bridge */ /* synthetic */ UDIcon decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UDIcon r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UDIcon r101) throws IOException {
            String r102 = r101.mkey;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ThemeColor r103 = r101.mcolor;
            if (r103 == null) goto L8;
            ThemeColor.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.municode;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UDIcon r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UDIcon();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkey = this.mkey;
        r100.mcolor = this.mcolor;
        r100.municode = this.municode;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UDIcon.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public UDIcon(String r100, ThemeColor r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UDIcon(String r100, ThemeColor r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mkey = r100;
        this.mcolor = r101;
        this.municode = r102;
    }
}
