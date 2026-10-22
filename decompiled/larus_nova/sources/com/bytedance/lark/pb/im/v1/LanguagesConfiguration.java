package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.DisplayRule;
import com.heytap.mcssdk.constant.b;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class LanguagesConfiguration extends Message<LanguagesConfiguration, Builder> {
    public static final ProtoAdapter<LanguagesConfiguration> ADAPTER = null;
    public static final DisplayRule DEFAULT_RULE = null;
    private static final long serialVersionUID = 0;
    public final DisplayRule rule;

    public static final class Builder extends Message.Builder<LanguagesConfiguration, Builder> {
        public DisplayRule rule;

        @Override // com.squareup.wire.Message.Builder
        public LanguagesConfiguration build() {
            DisplayRule r100 = this.rule;
            if (r100 == null) goto L7;
            return new LanguagesConfiguration(this.rule, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, b.f276366p});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder rule(DisplayRule r100) {
            this.rule = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LanguagesConfiguration extends ProtoAdapter<LanguagesConfiguration> {
        public ProtoAdapter_LanguagesConfiguration() {
            super(FieldEncoding.LENGTH_DELIMITED, LanguagesConfiguration.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LanguagesConfiguration decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.rule = DisplayRule.ONLY_TRANSLATION;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.rule = DisplayRule.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LanguagesConfiguration r100) {
            return DisplayRule.ADAPTER.encodedSizeWithTag(1, r100.rule) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LanguagesConfiguration decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LanguagesConfiguration r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LanguagesConfiguration r101) throws IOException {
            DisplayRule.ADAPTER.encodeWithTag(r100, 1, r101.rule);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LanguagesConfiguration r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LanguagesConfiguration();
        DEFAULT_RULE = DisplayRule.ONLY_TRANSLATION;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rule = this.rule;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LanguagesConfiguration.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LanguagesConfiguration(DisplayRule r100) {
        this(r100, ByteString.EMPTY);
    }

    public LanguagesConfiguration(DisplayRule r100, ByteString r101) {
        super(ADAPTER, r101);
        this.rule = r100;
    }
}
