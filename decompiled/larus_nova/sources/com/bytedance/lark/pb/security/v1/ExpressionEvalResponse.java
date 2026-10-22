package com.bytedance.lark.pb.security.v1;

import com.bytedance.android.ec.core.event.a;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class ExpressionEvalResponse extends Message<ExpressionEvalResponse, Builder> {
    public static final ProtoAdapter<ExpressionEvalResponse> ADAPTER = null;
    public static final Long DEFAULT_EXEC_COST = null;
    public static final Boolean DEFAULT_HIT_CACHE = null;
    public static final Long DEFAULT_PARSE_COST = null;
    public static final ProtoAdapter_ExpressionEvalResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long exec_cost;
    public final Boolean hit_cache;
    public final Long parse_cost;
    public final ExprValue result;

    public static final class Builder extends Message.Builder<ExpressionEvalResponse, Builder> implements b<ExpressionEvalResponse> {
        public Long exec_cost;
        public Boolean hit_cache;
        public Long parse_cost;
        public ExprValue result;

        @Override // com.squareup.wire.Message.Builder
        public ExpressionEvalResponse build() {
            ExprValue r100 = this.result;
            if (r100 == null) goto L13;
            if (this.hit_cache == null) goto L13;
            if (this.exec_cost == null) goto L13;
            if (this.parse_cost == null) goto L13;
            return new ExpressionEvalResponse(this.result, this.hit_cache, this.exec_cost, this.parse_cost, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "result", this.hit_cache, a.KEY_HIT_CACHE, this.exec_cost, "exec_cost", this.parse_cost, "parse_cost"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder exec_cost(Long r100) {
            this.exec_cost = r100;
            return this;
        }

        public Builder hit_cache(Boolean r100) {
            this.hit_cache = r100;
            return this;
        }

        public Builder parse_cost(Long r100) {
            this.parse_cost = r100;
            return this;
        }

        public Builder result(ExprValue r100) {
            this.result = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExpressionEvalResponse extends ProtoAdapter<ExpressionEvalResponse> implements we6.a<ExpressionEvalResponse> {
        public ProtoAdapter_ExpressionEvalResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ExpressionEvalResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExpressionEvalResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.hit_cache = Boolean.FALSE;
            r101.exec_cost = 0L;
            r101.parse_cost = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.result = ExprValue.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.hit_cache = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.exec_cost = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.parse_cost = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ExpressionEvalResponse r100) {
            int r101 = ExprValue.ADAPTER.encodedSizeWithTag(1, r100.result) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.hit_cache);
            ProtoAdapter<Long> r102 = ProtoAdapter.UINT64;
            return ((r101 + r102.encodedSizeWithTag(3, r100.exec_cost)) + r102.encodedSizeWithTag(4, r100.parse_cost)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ExpressionEvalResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExpressionEvalResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExpressionEvalResponse r101) throws IOException {
            ExprValue.ADAPTER.encodeWithTag(r100, 1, r101.result);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.hit_cache);
            ProtoAdapter<Long> r102 = ProtoAdapter.UINT64;
            r102.encodeWithTag(r100, 3, r101.exec_cost);
            r102.encodeWithTag(r100, 4, r101.parse_cost);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExpressionEvalResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ExpressionEvalResponse r100 = new ProtoAdapter_ExpressionEvalResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HIT_CACHE = Boolean.FALSE;
        DEFAULT_EXEC_COST = 0L;
        DEFAULT_PARSE_COST = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.result = this.result;
        r100.hit_cache = this.hit_cache;
        r100.exec_cost = this.exec_cost;
        r100.parse_cost = this.parse_cost;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExpressionEvalResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExpressionEvalResponse(ExprValue r100, Boolean r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ExpressionEvalResponse(ExprValue r100, Boolean r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.result = r100;
        this.hit_cache = r101;
        this.exec_cost = r102;
        this.parse_cost = r103;
    }
}
