package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Ref extends com.squareup.wire.Message<Ref, Builder> {
    public static final ProtoAdapter<Ref> ADAPTER = null;
    public static final String DEFAULT_MATCHED_WORD = "";
    private static final long serialVersionUID = 0;
    public final BaikeEntityMeta baike_entity_meta;
    public final CalendarEntityMeta calendar_entity_meta;
    public final String matched_word;
    public final Map<String, String> platform_disable_option;
    public final Span span;

    public static final class Builder extends com.squareup.wire.Message.Builder<Ref, Builder> {
        public BaikeEntityMeta baike_entity_meta;
        public CalendarEntityMeta calendar_entity_meta;
        public String matched_word;
        public Map<String, String> platform_disable_option;
        public Span span;

        @Override // com.squareup.wire.Message.Builder
        public Ref build() {
            Span r100 = this.span;
            if (r100 == null) goto L7;
            return new Ref(this.span, this.matched_word, this.platform_disable_option, this.baike_entity_meta, this.calendar_entity_meta, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "span"});
        }

        public Builder() {
            this.platform_disable_option = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder baike_entity_meta(BaikeEntityMeta r100) {
            this.baike_entity_meta = r100;
            return this;
        }

        public Builder calendar_entity_meta(CalendarEntityMeta r100) {
            this.calendar_entity_meta = r100;
            return this;
        }

        public Builder matched_word(String r100) {
            this.matched_word = r100;
            return this;
        }

        public Builder platform_disable_option(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.platform_disable_option = r100;
            return this;
        }

        public Builder span(Span r100) {
            this.span = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Ref extends ProtoAdapter<Ref> {
        private final ProtoAdapter<Map<String, String>> platform_disable_option;

        public ProtoAdapter_Ref() {
            super(FieldEncoding.LENGTH_DELIMITED, Ref.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.platform_disable_option = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Ref decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.matched_word = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.span = Span.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.matched_word = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.platform_disable_option.putAll(this.platform_disable_option.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.baike_entity_meta = BaikeEntityMeta.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.calendar_entity_meta = CalendarEntityMeta.ADAPTER.decode(r100);
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
        public int encodedSize2(Ref r100) {
            int r101 = Span.ADAPTER.encodedSizeWithTag(1, r100.span);
            String r102 = r100.matched_word;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = (r101 + r104) + this.platform_disable_option.encodedSizeWithTag(3, r100.platform_disable_option);
            BaikeEntityMeta r106 = r100.baike_entity_meta;
            if (r106 == null) goto L9;
            int r107 = BaikeEntityMeta.ADAPTER.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            CalendarEntityMeta r109 = r100.calendar_entity_meta;
            if (r109 == null) goto L14;
            r103 = CalendarEntityMeta.ADAPTER.encodedSizeWithTag(5, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Ref decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Ref r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Ref r101) throws IOException {
            Span.ADAPTER.encodeWithTag(r100, 1, r101.span);
            String r102 = r101.matched_word;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            this.platform_disable_option.encodeWithTag(r100, 3, r101.platform_disable_option);
            BaikeEntityMeta r103 = r101.baike_entity_meta;
            if (r103 == null) goto L8;
            BaikeEntityMeta.ADAPTER.encodeWithTag(r100, 4, r103);
        L8:
            CalendarEntityMeta r104 = r101.calendar_entity_meta;
            if (r104 == null) goto L11;
            CalendarEntityMeta.ADAPTER.encodeWithTag(r100, 5, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Ref r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Ref();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.span = this.span;
        r100.matched_word = this.matched_word;
        r100.platform_disable_option = Internal.copyOf("platform_disable_option", this.platform_disable_option);
        r100.baike_entity_meta = this.baike_entity_meta;
        r100.calendar_entity_meta = this.calendar_entity_meta;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Ref.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Ref(Span r100, String r101, Map<String, String> r110, BaikeEntityMeta r111, CalendarEntityMeta r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public Ref(Span r100, String r101, Map<String, String> r102, BaikeEntityMeta r103, CalendarEntityMeta r104, ByteString r105) {
        super(ADAPTER, r105);
        this.span = r100;
        this.matched_word = r101;
        this.platform_disable_option = Internal.immutableCopyOf("platform_disable_option", r102);
        this.baike_entity_meta = r103;
        this.calendar_entity_meta = r104;
    }
}
