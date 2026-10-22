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
public final class MentionContent extends com.squareup.wire.Message<MentionContent, Builder> {
    public static final ProtoAdapter<MentionContent> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_CONTENT = "";
    private static final long serialVersionUID = 0;
    public final String default_content;
    public final Map<String, String> i18n_content;
    public final MentionContentStyle style;

    public static final class Builder extends com.squareup.wire.Message.Builder<MentionContent, Builder> {
        public String default_content;
        public Map<String, String> i18n_content;
        public MentionContentStyle style;

        @Override // com.squareup.wire.Message.Builder
        public MentionContent build() {
            String r100 = this.default_content;
            if (r100 == null) goto L9;
            if (this.style == null) goto L9;
            return new MentionContent(this.default_content, this.i18n_content, this.style, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "default_content", this.style, "style"});
        }

        public Builder() {
            this.i18n_content = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder default_content(String r100) {
            this.default_content = r100;
            return this;
        }

        public Builder i18n_content(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_content = r100;
            return this;
        }

        public Builder style(MentionContentStyle r100) {
            this.style = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MentionContent extends ProtoAdapter<MentionContent> {
        private final ProtoAdapter<Map<String, String>> i18n_content;

        public ProtoAdapter_MentionContent() {
            super(FieldEncoding.LENGTH_DELIMITED, MentionContent.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.i18n_content = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MentionContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.default_content = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.default_content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.i18n_content.putAll(this.i18n_content.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.style = MentionContentStyle.ADAPTER.decode(r100);
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
        public int encodedSize2(MentionContent r100) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.default_content) + this.i18n_content.encodedSizeWithTag(2, r100.i18n_content)) + MentionContentStyle.ADAPTER.encodedSizeWithTag(3, r100.style)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MentionContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MentionContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MentionContent r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.default_content);
            this.i18n_content.encodeWithTag(r100, 2, r101.i18n_content);
            MentionContentStyle.ADAPTER.encodeWithTag(r100, 3, r101.style);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MentionContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MentionContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.default_content = this.default_content;
        r100.i18n_content = Internal.copyOf("i18n_content", this.i18n_content);
        r100.style = this.style;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MentionContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MentionContent(String r100, Map<String, String> r101, MentionContentStyle r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MentionContent(String r100, Map<String, String> r101, MentionContentStyle r102, ByteString r103) {
        super(ADAPTER, r103);
        this.default_content = r100;
        this.i18n_content = Internal.immutableCopyOf("i18n_content", r101);
        this.style = r102;
    }
}
