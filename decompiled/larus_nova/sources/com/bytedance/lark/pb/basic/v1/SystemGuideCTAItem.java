package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SystemGuideCTAItem extends com.squareup.wire.Message<SystemGuideCTAItem, Builder> {
    public static final ProtoAdapter<SystemGuideCTAItem> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final SystemMessageItemAction action;
    public final ImageSetPassThrough dm_icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253565id;
    public final ImageSetPassThrough lm_icon;
    public final I18nText text;

    public static final class Builder extends com.squareup.wire.Message.Builder<SystemGuideCTAItem, Builder> {
        public SystemMessageItemAction action;
        public ImageSetPassThrough dm_icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253566id;
        public ImageSetPassThrough lm_icon;
        public I18nText text;

        @Override // com.squareup.wire.Message.Builder
        public SystemGuideCTAItem build() {
            return new SystemGuideCTAItem(this.f253566id, this.lm_icon, this.dm_icon, this.text, this.action, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action(SystemMessageItemAction r100) {
            this.action = r100;
            return this;
        }

        public Builder dm_icon(ImageSetPassThrough r100) {
            this.dm_icon = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253566id = r100;
            return this;
        }

        public Builder lm_icon(ImageSetPassThrough r100) {
            this.lm_icon = r100;
            return this;
        }

        public Builder text(I18nText r100) {
            this.text = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SystemGuideCTAItem extends ProtoAdapter<SystemGuideCTAItem> {
        public ProtoAdapter_SystemGuideCTAItem() {
            super(FieldEncoding.LENGTH_DELIMITED, SystemGuideCTAItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SystemGuideCTAItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253566id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.f253566id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.lm_icon = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.dm_icon = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.text = I18nText.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.action = SystemMessageItemAction.ADAPTER.decode(r100);
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
        public int encodedSize2(SystemGuideCTAItem r100) {
            String r101 = r100.f253565id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ImageSetPassThrough r104 = r100.lm_icon;
            if (r104 == null) goto L9;
            int r105 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ImageSetPassThrough r107 = r100.dm_icon;
            if (r107 == null) goto L13;
            int r108 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            I18nText r110 = r100.text;
            if (r110 == null) goto L17;
            int r111 = I18nText.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            SystemMessageItemAction r113 = r100.action;
            if (r113 == null) goto L22;
            r102 = SystemMessageItemAction.ADAPTER.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ SystemGuideCTAItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SystemGuideCTAItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SystemGuideCTAItem r101) throws IOException {
            String r102 = r101.f253565id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ImageSetPassThrough r103 = r101.lm_icon;
            if (r103 == null) goto L8;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ImageSetPassThrough r104 = r101.dm_icon;
            if (r104 == null) goto L11;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            I18nText r105 = r101.text;
            if (r105 == null) goto L14;
            I18nText.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            SystemMessageItemAction r106 = r101.action;
            if (r106 == null) goto L17;
            SystemMessageItemAction.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SystemGuideCTAItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SystemGuideCTAItem();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253566id = this.f253565id;
        r100.lm_icon = this.lm_icon;
        r100.dm_icon = this.dm_icon;
        r100.text = this.text;
        r100.action = this.action;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SystemGuideCTAItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SystemGuideCTAItem(String r100, ImageSetPassThrough r101, ImageSetPassThrough r110, I18nText r111, SystemMessageItemAction r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SystemGuideCTAItem(String r100, ImageSetPassThrough r101, ImageSetPassThrough r102, I18nText r103, SystemMessageItemAction r104, ByteString r105) {
        super(ADAPTER, r105);
        this.f253565id = r100;
        this.lm_icon = r101;
        this.dm_icon = r102;
        this.text = r103;
        this.action = r104;
    }
}
