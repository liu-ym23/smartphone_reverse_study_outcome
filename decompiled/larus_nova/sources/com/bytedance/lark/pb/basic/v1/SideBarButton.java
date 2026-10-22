package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SideBarButton extends com.squareup.wire.Message<SideBarButton, Builder> {
    public static final ProtoAdapter<SideBarButton> ADAPTER = null;
    public static final String DEFAULT_I18N_NAME = "";
    public static final String DEFAULT_ICON_KEY = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String i18n_name;
    public final String icon_key;
    public final String url;

    public static final class Builder extends com.squareup.wire.Message.Builder<SideBarButton, Builder> {
        public String i18n_name;
        public String icon_key;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public SideBarButton build() {
            String r100 = this.i18n_name;
            if (r100 == null) goto L11;
            if (this.icon_key == null) goto L11;
            if (this.url == null) goto L11;
            return new SideBarButton(this.i18n_name, this.icon_key, this.url, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "i18n_name", this.icon_key, "icon_key", this.url, "url"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder i18n_name(String r100) {
            this.i18n_name = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.icon_key = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SideBarButton extends ProtoAdapter<SideBarButton> {
        public ProtoAdapter_SideBarButton() {
            super(FieldEncoding.LENGTH_DELIMITED, SideBarButton.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SideBarButton decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.i18n_name = "";
            r101.icon_key = "";
            r101.url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.i18n_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.url = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SideBarButton r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.i18n_name) + r101.encodedSizeWithTag(2, r100.icon_key)) + r101.encodedSizeWithTag(3, r100.url)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SideBarButton decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SideBarButton r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SideBarButton r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.i18n_name);
            r102.encodeWithTag(r100, 2, r101.icon_key);
            r102.encodeWithTag(r100, 3, r101.url);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SideBarButton r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SideBarButton();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.i18n_name = this.i18n_name;
        r100.icon_key = this.icon_key;
        r100.url = this.url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SideBarButton.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SideBarButton(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SideBarButton(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.i18n_name = r100;
        this.icon_key = r101;
        this.url = r102;
    }
}
