package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class IconConfig extends Message<IconConfig, Builder> {
    public static final ProtoAdapter<IconConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final IconInfo mdisplay_icon;
    public final IconInfo mlink_icon;

    public static final class Builder extends Message.Builder<IconConfig, Builder> {
        public IconInfo mdisplay_icon;
        public IconInfo mlink_icon;

        @Override // com.squareup.wire.Message.Builder
        public IconConfig build() {
            return new IconConfig(this.mdisplay_icon, this.mlink_icon, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder display_icon(IconInfo r100) {
            this.mdisplay_icon = r100;
            return this;
        }

        public Builder link_icon(IconInfo r100) {
            this.mlink_icon = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_IconConfig extends ProtoAdapter<IconConfig> {
        public ProtoAdapter_IconConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, IconConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public IconConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mdisplay_icon = IconInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mlink_icon = IconInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(IconConfig r100) {
            IconInfo r101 = r100.mdisplay_icon;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = IconInfo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            IconInfo r104 = r100.mlink_icon;
            if (r104 == null) goto L10;
            r102 = IconInfo.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ IconConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(IconConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, IconConfig r101) throws IOException {
            IconInfo r102 = r101.mdisplay_icon;
            if (r102 == null) goto L5;
            IconInfo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            IconInfo r103 = r101.mlink_icon;
            if (r103 == null) goto L8;
            IconInfo.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IconConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IconConfig();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdisplay_icon = this.mdisplay_icon;
        r100.mlink_icon = this.mlink_icon;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return IconConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public IconConfig(IconInfo r100, IconInfo r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public IconConfig(IconInfo r100, IconInfo r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mdisplay_icon = r100;
        this.mlink_icon = r101;
    }
}
