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
public final class PushLanguagesConfigurationNoticeV2 extends Message<PushLanguagesConfigurationNoticeV2, Builder> {
    public static final ProtoAdapter<PushLanguagesConfigurationNoticeV2> ADAPTER = null;
    public static final ProtoAdapter_PushLanguagesConfigurationNoticeV2 RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, LanguagesConfiguration> src_languages_conf;

    public static final class Builder extends Message.Builder<PushLanguagesConfigurationNoticeV2, Builder> implements d<PushLanguagesConfigurationNoticeV2> {
        public Map<String, LanguagesConfiguration> src_languages_conf;

        @Override // com.squareup.wire.Message.Builder
        public PushLanguagesConfigurationNoticeV2 build() {
            return new PushLanguagesConfigurationNoticeV2(this.src_languages_conf, super.buildUnknownFields());
        }

        public Builder() {
            this.src_languages_conf = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder src_languages_conf(Map<String, LanguagesConfiguration> r100) {
            Internal.checkElementsNotNull(r100);
            this.src_languages_conf = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushLanguagesConfigurationNoticeV2 extends ProtoAdapter<PushLanguagesConfigurationNoticeV2> implements c<PushLanguagesConfigurationNoticeV2> {
        private final ProtoAdapter<Map<String, LanguagesConfiguration>> src_languages_conf;

        public ProtoAdapter_PushLanguagesConfigurationNoticeV2() {
            super(FieldEncoding.LENGTH_DELIMITED, PushLanguagesConfigurationNoticeV2.class);
            this.src_languages_conf = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, LanguagesConfiguration.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushLanguagesConfigurationNoticeV2 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.src_languages_conf.putAll(this.src_languages_conf.decode(r100));
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
        public int encodedSize2(PushLanguagesConfigurationNoticeV2 r100) {
            return this.src_languages_conf.encodedSizeWithTag(1, r100.src_languages_conf) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushLanguagesConfigurationNoticeV2 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushLanguagesConfigurationNoticeV2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushLanguagesConfigurationNoticeV2 r101) throws IOException {
            this.src_languages_conf.encodeWithTag(r100, 1, r101.src_languages_conf);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushLanguagesConfigurationNoticeV2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushLanguagesConfigurationNoticeV2 r100 = new ProtoAdapter_PushLanguagesConfigurationNoticeV2();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.src_languages_conf = Internal.copyOf("src_languages_conf", this.src_languages_conf);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushLanguagesConfigurationNoticeV2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushLanguagesConfigurationNoticeV2(Map<String, LanguagesConfiguration> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushLanguagesConfigurationNoticeV2(Map<String, LanguagesConfiguration> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.src_languages_conf = Internal.immutableCopyOf("src_languages_conf", r100);
    }
}
