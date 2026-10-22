package com.bytedance.lark.pb.search.sections.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SectionHeader extends Message<SectionHeader, Builder> {
    public static final ProtoAdapter<SectionHeader> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_URL = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final String avatar_url;
    public final String title;
    public final List<Modifier> title_modifiers;

    public static final class Builder extends Message.Builder<SectionHeader, Builder> {
        public String avatar_key;
        public String avatar_url;
        public String title;
        public List<Modifier> title_modifiers;

        @Override // com.squareup.wire.Message.Builder
        public SectionHeader build() {
            return new SectionHeader(this.title, this.avatar_key, this.avatar_url, this.title_modifiers, super.buildUnknownFields());
        }

        public Builder() {
            this.title_modifiers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_url(String r100) {
            this.avatar_url = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder title_modifiers(List<Modifier> r100) {
            Internal.checkElementsNotNull(r100);
            this.title_modifiers = r100;
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
            r101.title = "";
            r101.avatar_key = "";
            r101.avatar_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.avatar_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.title_modifiers.add(Modifier.ADAPTER.decode(r100));
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
        public int encodedSize2(SectionHeader r100) {
            String r101 = r100.title;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.avatar_key;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.avatar_url;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return ((r106 + r102) + Modifier.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.title_modifiers)) + r100.unknownFields().size();
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
            String r102 = r101.title;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.avatar_key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.avatar_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Modifier.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.title_modifiers);
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
        r100.title = this.title;
        r100.avatar_key = this.avatar_key;
        r100.avatar_url = this.avatar_url;
        r100.title_modifiers = Internal.copyOf("title_modifiers", this.title_modifiers);
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

    public SectionHeader(String r100, String r101, String r102, List<Modifier> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SectionHeader(String r100, String r101, String r102, List<Modifier> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.title = r100;
        this.avatar_key = r101;
        this.avatar_url = r102;
        this.title_modifiers = Internal.immutableCopyOf("title_modifiers", r103);
    }
}
