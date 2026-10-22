package com.ss.android.lark.pb.section;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Image;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SectionHeader extends Message<SectionHeader, Builder> {
    public static final ProtoAdapter<SectionHeader> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_URL = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final Image mavatar;
    public final String mavatar_key;
    public final String mavatar_url;
    public final String mtitle;
    public final List<Modifier> mtitle_modifiers;

    public static final class Builder extends Message.Builder<SectionHeader, Builder> {
        public Image mavatar;
        public String mavatar_key;
        public String mavatar_url;
        public String mtitle;
        public List<Modifier> mtitle_modifiers;

        @Override // com.squareup.wire.Message.Builder
        public SectionHeader build() {
            return new SectionHeader(this.mtitle, this.mavatar_key, this.mavatar_url, this.mavatar, this.mtitle_modifiers, super.buildUnknownFields());
        }

        public Builder() {
            this.mtitle_modifiers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar(Image r100) {
            this.mavatar = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.mavatar_key = r100;
            return this;
        }

        public Builder avatar_url(String r100) {
            this.mavatar_url = r100;
            return this;
        }

        public Builder title(String r100) {
            this.mtitle = r100;
            return this;
        }

        public Builder title_modifiers(List<Modifier> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtitle_modifiers = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SectionHeader extends ProtoAdapter<SectionHeader> {
        public ProtoAdapter_SectionHeader() {
            super(FieldEncoding.LENGTH_DELIMITED, SectionHeader.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SectionHeader decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtitle = "";
            r101.mavatar_key = "";
            r101.mavatar_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mtitle = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mavatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mavatar_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mavatar = Image.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mtitle_modifiers.add(Modifier.ADAPTER.decode(r100));
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
        public int encodedSize2(SectionHeader r100) {
            String r101 = r100.mtitle;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mavatar_key;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mavatar_url;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Image r110 = r100.mavatar;
            if (r110 == null) goto L18;
            r102 = Image.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return ((r109 + r102) + Modifier.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.mtitle_modifiers)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SectionHeader decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SectionHeader r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SectionHeader r101) throws IOException {
            String r102 = r101.mtitle;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mavatar_key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mavatar_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Image r105 = r101.mavatar;
            if (r105 == null) goto L14;
            Image.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Modifier.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.mtitle_modifiers);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SectionHeader r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SectionHeader();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtitle = this.mtitle;
        r100.mavatar_key = this.mavatar_key;
        r100.mavatar_url = this.mavatar_url;
        r100.mavatar = this.mavatar;
        r100.mtitle_modifiers = Internal.copyOf("mtitle_modifiers", this.mtitle_modifiers);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SectionHeader.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SectionHeader(String r100, String r101, String r110, Image r111, List<Modifier> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SectionHeader(String r100, String r101, String r102, Image r103, List<Modifier> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mtitle = r100;
        this.mavatar_key = r101;
        this.mavatar_url = r102;
        this.mavatar = r103;
        this.mtitle_modifiers = Internal.immutableCopyOf("mtitle_modifiers", r104);
    }
}
