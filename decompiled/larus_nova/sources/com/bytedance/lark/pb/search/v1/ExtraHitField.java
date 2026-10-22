package com.bytedance.lark.pb.search.v1;

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
public final class ExtraHitField extends Message<ExtraHitField, Builder> {
    public static final ProtoAdapter<ExtraHitField> ADAPTER = null;
    public static final String DEFAULT_FIELD_NAME = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String field_name;
    public final String title;
    public final List<String> title_hit_terms;

    public static final class Builder extends Message.Builder<ExtraHitField, Builder> {
        public String field_name;
        public String title;
        public List<String> title_hit_terms;

        @Override // com.squareup.wire.Message.Builder
        public ExtraHitField build() {
            return new ExtraHitField(this.field_name, this.title, this.title_hit_terms, super.buildUnknownFields());
        }

        public Builder() {
            this.title_hit_terms = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder field_name(String r100) {
            this.field_name = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder title_hit_terms(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.title_hit_terms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtraHitField extends ProtoAdapter<ExtraHitField> {
        public ProtoAdapter_ExtraHitField() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtraHitField.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExtraHitField decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.field_name = "";
            r101.title = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.field_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.title_hit_terms.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(ExtraHitField r100) {
            String r101 = r100.field_name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.title;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r100.title_hit_terms)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ExtraHitField decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExtraHitField r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExtraHitField r101) throws IOException {
            String r102 = r101.field_name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.title;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 3, r101.title_hit_terms);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtraHitField r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtraHitField();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.field_name = this.field_name;
        r100.title = this.title;
        r100.title_hit_terms = Internal.copyOf("title_hit_terms", this.title_hit_terms);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExtraHitField.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExtraHitField(String r100, String r101, List<String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ExtraHitField(String r100, String r101, List<String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.field_name = r100;
        this.title = r101;
        this.title_hit_terms = Internal.immutableCopyOf("title_hit_terms", r102);
    }
}
