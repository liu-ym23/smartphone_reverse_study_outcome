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
public final class PutLanguagesConfigurationRequest extends Message<PutLanguagesConfigurationRequest, Builder> {
    public static final ProtoAdapter<PutLanguagesConfigurationRequest> ADAPTER = null;
    public static final ProtoAdapter_PutLanguagesConfigurationRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final LanguagesConfiguration global_conf;
    public final Map<String, LanguagesConfiguration> languages_conf;

    public static final class Builder extends Message.Builder<PutLanguagesConfigurationRequest, Builder> implements d<PutLanguagesConfigurationRequest> {
        public LanguagesConfiguration global_conf;
        public Map<String, LanguagesConfiguration> languages_conf;

        @Override // com.squareup.wire.Message.Builder
        public PutLanguagesConfigurationRequest build() {
            return new PutLanguagesConfigurationRequest(this.languages_conf, this.global_conf, super.buildUnknownFields());
        }

        public Builder() {
            this.languages_conf = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder global_conf(LanguagesConfiguration r100) {
            this.global_conf = r100;
            return this;
        }

        public Builder languages_conf(Map<String, LanguagesConfiguration> r100) {
            Internal.checkElementsNotNull(r100);
            this.languages_conf = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutLanguagesConfigurationRequest extends ProtoAdapter<PutLanguagesConfigurationRequest> implements c<PutLanguagesConfigurationRequest> {
        private final ProtoAdapter<Map<String, LanguagesConfiguration>> languages_conf;

        public ProtoAdapter_PutLanguagesConfigurationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutLanguagesConfigurationRequest.class);
            this.languages_conf = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, LanguagesConfiguration.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutLanguagesConfigurationRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.languages_conf.putAll(this.languages_conf.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.global_conf = LanguagesConfiguration.ADAPTER.decode(r100);
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
        public int encodedSize2(PutLanguagesConfigurationRequest r100) {
            int r101 = this.languages_conf.encodedSizeWithTag(1, r100.languages_conf);
            LanguagesConfiguration r102 = r100.global_conf;
            if (r102 == null) goto L5;
            int r103 = LanguagesConfiguration.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutLanguagesConfigurationRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutLanguagesConfigurationRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutLanguagesConfigurationRequest r101) throws IOException {
            this.languages_conf.encodeWithTag(r100, 1, r101.languages_conf);
            LanguagesConfiguration r102 = r101.global_conf;
            if (r102 == null) goto L5;
            LanguagesConfiguration.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutLanguagesConfigurationRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PutLanguagesConfigurationRequest r100 = new ProtoAdapter_PutLanguagesConfigurationRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.languages_conf = Internal.copyOf("languages_conf", this.languages_conf);
        r100.global_conf = this.global_conf;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutLanguagesConfigurationRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutLanguagesConfigurationRequest(Map<String, LanguagesConfiguration> r100, LanguagesConfiguration r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PutLanguagesConfigurationRequest(Map<String, LanguagesConfiguration> r100, LanguagesConfiguration r101, ByteString r102) {
        super(ADAPTER, r102);
        this.languages_conf = Internal.immutableCopyOf("languages_conf", r100);
        this.global_conf = r101;
    }
}
