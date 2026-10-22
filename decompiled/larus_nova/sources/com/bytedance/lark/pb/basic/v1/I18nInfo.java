package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class I18nInfo extends com.squareup.wire.Message<I18nInfo, Builder> {
    public static final ProtoAdapter<I18nInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, LocaleInfo> locale_info;

    public static final class Builder extends com.squareup.wire.Message.Builder<I18nInfo, Builder> {
        public Map<String, LocaleInfo> locale_info;

        @Override // com.squareup.wire.Message.Builder
        public I18nInfo build() {
            return new I18nInfo(this.locale_info, super.buildUnknownFields());
        }

        public Builder() {
            this.locale_info = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder locale_info(Map<String, LocaleInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.locale_info = r100;
            return this;
        }
    }

    public static final class LocaleInfo extends com.squareup.wire.Message<LocaleInfo, Builder> {
        public static final ProtoAdapter<LocaleInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> content_languages;

        public static final class Builder extends com.squareup.wire.Message.Builder<LocaleInfo, Builder> {
            public List<String> content_languages;

            @Override // com.squareup.wire.Message.Builder
            public LocaleInfo build() {
                return new LocaleInfo(this.content_languages, super.buildUnknownFields());
            }

            public Builder() {
                this.content_languages = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content_languages(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.content_languages = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LocaleInfo extends ProtoAdapter<LocaleInfo> {
            public ProtoAdapter_LocaleInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, LocaleInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LocaleInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.content_languages.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(LocaleInfo r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.content_languages) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LocaleInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LocaleInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LocaleInfo r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.content_languages);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LocaleInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LocaleInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content_languages = Internal.copyOf("content_languages", this.content_languages);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LocaleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LocaleInfo(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public LocaleInfo(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.content_languages = Internal.immutableCopyOf("content_languages", r100);
        }
    }

    public static final class ProtoAdapter_I18nInfo extends ProtoAdapter<I18nInfo> {
        private final ProtoAdapter<Map<String, LocaleInfo>> locale_info;

        public ProtoAdapter_I18nInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, I18nInfo.class);
            this.locale_info = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, LocaleInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public I18nInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 112) goto L7;
            r101.locale_info.putAll(this.locale_info.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(I18nInfo r100) {
            return this.locale_info.encodedSizeWithTag(112, r100.locale_info) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ I18nInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(I18nInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, I18nInfo r101) throws IOException {
            this.locale_info.encodeWithTag(r100, 112, r101.locale_info);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18nInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_I18nInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.locale_info = Internal.copyOf("locale_info", this.locale_info);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return I18nInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public I18nInfo(Map<String, LocaleInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public I18nInfo(Map<String, LocaleInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.locale_info = Internal.immutableCopyOf("locale_info", r100);
    }
}
