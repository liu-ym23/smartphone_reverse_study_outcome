package com.bytedance.lark.pb.security.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class ExpressionEvalRequest extends Message<ExpressionEvalRequest, Builder> {
    public static final ProtoAdapter<ExpressionEvalRequest> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE_CACHE = null;
    public static final String DEFAULT_EXPRESSION = "";
    public static final ProtoAdapter_ExpressionEvalRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean enable_cache;
    public final String expression;
    public final Map<String, ExprValue> paramters;

    public static final class Builder extends Message.Builder<ExpressionEvalRequest, Builder> implements b<ExpressionEvalRequest> {
        public Boolean enable_cache;
        public String expression;
        public Map<String, ExprValue> paramters;

        @Override // com.squareup.wire.Message.Builder
        public ExpressionEvalRequest build() {
            String r100 = this.expression;
            if (r100 == null) goto L9;
            if (this.enable_cache == null) goto L9;
            return new ExpressionEvalRequest(this.expression, this.paramters, this.enable_cache, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "expression", this.enable_cache, "enable_cache"});
        }

        public Builder() {
            this.paramters = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enable_cache(Boolean r100) {
            this.enable_cache = r100;
            return this;
        }

        public Builder expression(String r100) {
            this.expression = r100;
            return this;
        }

        public Builder paramters(Map<String, ExprValue> r100) {
            Internal.checkElementsNotNull(r100);
            this.paramters = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExpressionEvalRequest extends ProtoAdapter<ExpressionEvalRequest> implements a<ExpressionEvalRequest> {
        private final ProtoAdapter<Map<String, ExprValue>> paramters;

        public ProtoAdapter_ExpressionEvalRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ExpressionEvalRequest.class);
            this.paramters = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ExprValue.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExpressionEvalRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.expression = "";
            r101.enable_cache = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.expression = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.paramters.putAll(this.paramters.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.enable_cache = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(ExpressionEvalRequest r100) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.expression) + this.paramters.encodedSizeWithTag(2, r100.paramters)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.enable_cache)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ExpressionEvalRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExpressionEvalRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExpressionEvalRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.expression);
            this.paramters.encodeWithTag(r100, 2, r101.paramters);
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.enable_cache);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExpressionEvalRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ExpressionEvalRequest r100 = new ProtoAdapter_ExpressionEvalRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ENABLE_CACHE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.expression = this.expression;
        r100.paramters = Internal.copyOf("paramters", this.paramters);
        r100.enable_cache = this.enable_cache;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExpressionEvalRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExpressionEvalRequest(String r100, Map<String, ExprValue> r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ExpressionEvalRequest(String r100, Map<String, ExprValue> r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.expression = r100;
        this.paramters = Internal.immutableCopyOf("paramters", r101);
        this.enable_cache = r102;
    }
}
