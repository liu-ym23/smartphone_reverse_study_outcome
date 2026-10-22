package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SystemGuideContent extends com.squareup.wire.Message<SystemGuideContent, Builder> {
    public static final ProtoAdapter<SystemGuideContent> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ImageSetPassThrough dm_image;
    public final List<SystemGuideCTAItem> items;
    public final ImageSetPassThrough lm_image;
    public final I18nText sub_title;
    public final I18nText title;

    public static final class Builder extends com.squareup.wire.Message.Builder<SystemGuideContent, Builder> {
        public ImageSetPassThrough dm_image;
        public List<SystemGuideCTAItem> items;
        public ImageSetPassThrough lm_image;
        public I18nText sub_title;
        public I18nText title;

        @Override // com.squareup.wire.Message.Builder
        public SystemGuideContent build() {
            return new SystemGuideContent(this.title, this.sub_title, this.lm_image, this.dm_image, this.items, super.buildUnknownFields());
        }

        public Builder() {
            this.items = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder dm_image(ImageSetPassThrough r100) {
            this.dm_image = r100;
            return this;
        }

        public Builder items(List<SystemGuideCTAItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.items = r100;
            return this;
        }

        public Builder lm_image(ImageSetPassThrough r100) {
            this.lm_image = r100;
            return this;
        }

        public Builder sub_title(I18nText r100) {
            this.sub_title = r100;
            return this;
        }

        public Builder title(I18nText r100) {
            this.title = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SystemGuideContent extends ProtoAdapter<SystemGuideContent> {
        public ProtoAdapter_SystemGuideContent() {
            super(FieldEncoding.LENGTH_DELIMITED, SystemGuideContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SystemGuideContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.title = I18nText.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.sub_title = I18nText.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.lm_image = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.dm_image = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.items.add(SystemGuideCTAItem.ADAPTER.decode(r100));
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
        public int encodedSize2(SystemGuideContent r100) {
            I18nText r101 = r100.title;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = I18nText.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            I18nText r104 = r100.sub_title;
            if (r104 == null) goto L9;
            int r105 = I18nText.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ImageSetPassThrough r107 = r100.lm_image;
            if (r107 == null) goto L13;
            int r108 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ImageSetPassThrough r110 = r100.dm_image;
            if (r110 == null) goto L18;
            r102 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return ((r109 + r102) + SystemGuideCTAItem.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.items)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SystemGuideContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SystemGuideContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SystemGuideContent r101) throws IOException {
            I18nText r102 = r101.title;
            if (r102 == null) goto L5;
            I18nText.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            I18nText r103 = r101.sub_title;
            if (r103 == null) goto L8;
            I18nText.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ImageSetPassThrough r104 = r101.lm_image;
            if (r104 == null) goto L11;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ImageSetPassThrough r105 = r101.dm_image;
            if (r105 == null) goto L14;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            SystemGuideCTAItem.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.items);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SystemGuideContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SystemGuideContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.title = this.title;
        r100.sub_title = this.sub_title;
        r100.lm_image = this.lm_image;
        r100.dm_image = this.dm_image;
        r100.items = Internal.copyOf("items", this.items);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SystemGuideContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SystemGuideContent(I18nText r100, I18nText r101, ImageSetPassThrough r110, ImageSetPassThrough r111, List<SystemGuideCTAItem> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SystemGuideContent(I18nText r100, I18nText r101, ImageSetPassThrough r102, ImageSetPassThrough r103, List<SystemGuideCTAItem> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.title = r100;
        this.sub_title = r101;
        this.lm_image = r102;
        this.dm_image = r103;
        this.items = Internal.immutableCopyOf("items", r104);
    }
}
