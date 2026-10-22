package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushLanguagesConfigurationNotice extends Message<PushLanguagesConfigurationNotice, Builder> {
    public static final ProtoAdapter<PushLanguagesConfigurationNotice> ADAPTER = null;
    public static final ProtoAdapter_PushLanguagesConfigurationNotice RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final LanguagesConfiguration global_language_config;
    public final Map<String, LanguagesConfiguration> languages_config;

    public static final class Builder extends Message.Builder<PushLanguagesConfigurationNotice, Builder> implements d<PushLanguagesConfigurationNotice> {
        public LanguagesConfiguration global_language_config;
        public Map<String, LanguagesConfiguration> languages_config;

        @Override // com.squareup.wire.Message.Builder
        public PushLanguagesConfigurationNotice build() {
            return new PushLanguagesConfigurationNotice(this.languages_config, this.global_language_config, super.buildUnknownFields());
        }

        public Builder() {
            this.languages_config = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder global_language_config(LanguagesConfiguration r100) {
            this.global_language_config = r100;
            return this;
        }

        public Builder languages_config(Map<String, LanguagesConfiguration> r100) {
            Internal.checkElementsNotNull(r100);
            this.languages_config = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushLanguagesConfigurationNotice extends ProtoAdapter<PushLanguagesConfigurationNotice> implements c<PushLanguagesConfigurationNotice> {
        private final ProtoAdapter<Map<String, LanguagesConfiguration>> languages_config;

        public ProtoAdapter_PushLanguagesConfigurationNotice() {
            super(FieldEncoding.LENGTH_DELIMITED, PushLanguagesConfigurationNotice.class);
            this.languages_config = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, LanguagesConfiguration.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushLanguagesConfigurationNotice decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.languages_config.putAll(this.languages_config.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.global_language_config = LanguagesConfiguration.ADAPTER.decode(r100);
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
        public int encodedSize2(PushLanguagesConfigurationNotice r100) {
            int r101 = this.languages_config.encodedSizeWithTag(1, r100.languages_config);
            LanguagesConfiguration r102 = r100.global_language_config;
            if (r102 == null) goto L5;
            int r103 = LanguagesConfiguration.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushLanguagesConfigurationNotice decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushLanguagesConfigurationNotice r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushLanguagesConfigurationNotice r101) throws IOException {
            this.languages_config.encodeWithTag(r100, 1, r101.languages_config);
            LanguagesConfiguration r102 = r101.global_language_config;
            if (r102 == null) goto L5;
            LanguagesConfiguration.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushLanguagesConfigurationNotice r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushLanguagesConfigurationNotice r100 = new ProtoAdapter_PushLanguagesConfigurationNotice();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.languages_config = Internal.copyOf("languages_config", this.languages_config);
        r100.global_language_config = this.global_language_config;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushLanguagesConfigurationNotice.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushLanguagesConfigurationNotice(Map<String, LanguagesConfiguration> r100, LanguagesConfiguration r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushLanguagesConfigurationNotice(Map<String, LanguagesConfiguration> r100, LanguagesConfiguration r101, ByteString r102) {
        super(ADAPTER, r102);
        this.languages_config = Internal.immutableCopyOf("languages_config", r100);
        this.global_language_config = r101;
    }
}
