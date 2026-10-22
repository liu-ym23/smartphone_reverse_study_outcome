package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TranslateUrlPreviewContext extends com.squareup.wire.Message<TranslateUrlPreviewContext, Builder> {
    public static final ProtoAdapter<TranslateUrlPreviewContext> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SDK_PREVIEW = null;
    public static final String DEFAULT_PREVIEW_ID = "";
    public static final String DEFAULT_TAG = "";
    public static final String DEFAULT_TARGET_LANGUAGE = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final Boolean is_sdk_preview;
    public final String preview_id;
    public final String tag;
    public final String target_language;
    public final String title;

    public static final class Builder extends com.squareup.wire.Message.Builder<TranslateUrlPreviewContext, Builder> {
        public Boolean is_sdk_preview;
        public String preview_id;
        public String tag;
        public String target_language;
        public String title;

        @Override // com.squareup.wire.Message.Builder
        public TranslateUrlPreviewContext build() {
            String r100 = this.preview_id;
            if (r100 == null) goto L7;
            return new TranslateUrlPreviewContext(this.preview_id, this.title, this.tag, this.target_language, this.is_sdk_preview, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "preview_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_sdk_preview(Boolean r100) {
            this.is_sdk_preview = r100;
            return this;
        }

        public Builder preview_id(String r100) {
            this.preview_id = r100;
            return this;
        }

        public Builder tag(String r100) {
            this.tag = r100;
            return this;
        }

        public Builder target_language(String r100) {
            this.target_language = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateUrlPreviewContext extends ProtoAdapter<TranslateUrlPreviewContext> {
        public ProtoAdapter_TranslateUrlPreviewContext() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateUrlPreviewContext.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateUrlPreviewContext decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.preview_id = "";
            r101.title = "";
            r101.tag = "";
            r101.target_language = "";
            r101.is_sdk_preview = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.preview_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.target_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.is_sdk_preview = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(TranslateUrlPreviewContext r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.preview_id);
            String r103 = r100.title;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.tag;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.target_language;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_sdk_preview;
            if (r113 == null) goto L18;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L18:
            return (r112 + r104) + r100.unknownFields().size();
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateUrlPreviewContext decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateUrlPreviewContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateUrlPreviewContext r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.preview_id);
            String r103 = r101.title;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.tag;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.target_language;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            Boolean r106 = r101.is_sdk_preview;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateUrlPreviewContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TranslateUrlPreviewContext();
        DEFAULT_IS_SDK_PREVIEW = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_id = this.preview_id;
        r100.title = this.title;
        r100.tag = this.tag;
        r100.target_language = this.target_language;
        r100.is_sdk_preview = this.is_sdk_preview;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateUrlPreviewContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateUrlPreviewContext(String r100, String r101, String r110, String r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TranslateUrlPreviewContext(String r100, String r101, String r102, String r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.preview_id = r100;
        this.title = r101;
        this.tag = r102;
        this.target_language = r103;
        this.is_sdk_preview = r104;
    }
}
