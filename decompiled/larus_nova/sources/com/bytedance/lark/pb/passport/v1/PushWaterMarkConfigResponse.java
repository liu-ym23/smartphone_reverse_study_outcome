package com.bytedance.lark.pb.passport.v1;

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
public final class PushWaterMarkConfigResponse extends Message<PushWaterMarkConfigResponse, Builder> {
    public static final ProtoAdapter<PushWaterMarkConfigResponse> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Boolean DEFAULT_HIDDEN_ENABLED = null;
    public static final Boolean DEFAULT_OBVIOUS_ENABLED = null;
    public static final ProtoAdapter_PushWaterMarkConfigResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> clear_style;
    public final String content;
    public final Boolean hidden_enabled;
    public final Map<String, String> hidden_style;
    public final Boolean obvious_enabled;

    public static final class Builder extends Message.Builder<PushWaterMarkConfigResponse, Builder> implements d<PushWaterMarkConfigResponse> {
        public Map<String, String> clear_style;
        public String content;
        public Boolean hidden_enabled;
        public Map<String, String> hidden_style;
        public Boolean obvious_enabled;

        @Override // com.squareup.wire.Message.Builder
        public PushWaterMarkConfigResponse build() {
            return new PushWaterMarkConfigResponse(this.obvious_enabled, this.hidden_enabled, this.content, this.clear_style, this.hidden_style, super.buildUnknownFields());
        }

        public Builder() {
            this.clear_style = Internal.newMutableMap();
            this.hidden_style = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder clear_style(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.clear_style = r100;
            return this;
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder hidden_enabled(Boolean r100) {
            this.hidden_enabled = r100;
            return this;
        }

        public Builder hidden_style(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.hidden_style = r100;
            return this;
        }

        public Builder obvious_enabled(Boolean r100) {
            this.obvious_enabled = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushWaterMarkConfigResponse extends ProtoAdapter<PushWaterMarkConfigResponse> implements c<PushWaterMarkConfigResponse> {
        private final ProtoAdapter<Map<String, String>> clear_style;
        private final ProtoAdapter<Map<String, String>> hidden_style;

        public ProtoAdapter_PushWaterMarkConfigResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PushWaterMarkConfigResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.clear_style = ProtoAdapter.newMapAdapter(r100, r100);
            this.hidden_style = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushWaterMarkConfigResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.obvious_enabled = r102;
            r101.hidden_enabled = r102;
            r101.content = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.obvious_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.hidden_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.clear_style.putAll(this.clear_style.decode(r100));
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.hidden_style.putAll(this.hidden_style.decode(r100));
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushWaterMarkConfigResponse r100) {
            Boolean r101 = r100.obvious_enabled;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.hidden_enabled;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.content;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (((r106 + r102) + this.clear_style.encodedSizeWithTag(4, r100.clear_style)) + this.hidden_style.encodedSizeWithTag(5, r100.hidden_style)) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushWaterMarkConfigResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushWaterMarkConfigResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushWaterMarkConfigResponse r101) throws IOException {
            Boolean r102 = r101.obvious_enabled;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.hidden_enabled;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.content;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            this.clear_style.encodeWithTag(r100, 4, r101.clear_style);
            this.hidden_style.encodeWithTag(r100, 5, r101.hidden_style);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushWaterMarkConfigResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushWaterMarkConfigResponse r100 = new ProtoAdapter_PushWaterMarkConfigResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_OBVIOUS_ENABLED = r101;
        DEFAULT_HIDDEN_ENABLED = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.obvious_enabled = this.obvious_enabled;
        r100.hidden_enabled = this.hidden_enabled;
        r100.content = this.content;
        r100.clear_style = Internal.copyOf("clear_style", this.clear_style);
        r100.hidden_style = Internal.copyOf("hidden_style", this.hidden_style);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushWaterMarkConfigResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushWaterMarkConfigResponse(Boolean r100, Boolean r101, String r110, Map<String, String> r111, Map<String, String> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PushWaterMarkConfigResponse(Boolean r100, Boolean r101, String r102, Map<String, String> r103, Map<String, String> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.obvious_enabled = r100;
        this.hidden_enabled = r101;
        this.content = r102;
        this.clear_style = Internal.immutableCopyOf("clear_style", r103);
        this.hidden_style = Internal.immutableCopyOf("hidden_style", r104);
    }
}
