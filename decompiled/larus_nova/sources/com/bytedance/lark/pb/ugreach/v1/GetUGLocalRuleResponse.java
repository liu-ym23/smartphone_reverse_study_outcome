package com.bytedance.lark.pb.ugreach.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUGLocalRuleResponse extends Message<GetUGLocalRuleResponse, Builder> {
    public static final ProtoAdapter<GetUGLocalRuleResponse> ADAPTER = null;
    public static final ProtoAdapter_GetUGLocalRuleResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final LocalRule local_rule;

    public static final class Builder extends Message.Builder<GetUGLocalRuleResponse, Builder> implements d<GetUGLocalRuleResponse> {
        public LocalRule local_rule;

        @Override // com.squareup.wire.Message.Builder
        public GetUGLocalRuleResponse build() {
            return new GetUGLocalRuleResponse(this.local_rule, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder local_rule(LocalRule r100) {
            this.local_rule = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUGLocalRuleResponse extends ProtoAdapter<GetUGLocalRuleResponse> implements c<GetUGLocalRuleResponse> {
        public ProtoAdapter_GetUGLocalRuleResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUGLocalRuleResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUGLocalRuleResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.local_rule = LocalRule.ADAPTER.decode(r100);
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
        public int encodedSize2(GetUGLocalRuleResponse r100) {
            LocalRule r101 = r100.local_rule;
            if (r101 == null) goto L5;
            int r102 = LocalRule.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUGLocalRuleResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUGLocalRuleResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUGLocalRuleResponse r101) throws IOException {
            LocalRule r102 = r101.local_rule;
            if (r102 == null) goto L5;
            LocalRule.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUGLocalRuleResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUGLocalRuleResponse r100 = new ProtoAdapter_GetUGLocalRuleResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.local_rule = this.local_rule;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUGLocalRuleResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUGLocalRuleResponse(LocalRule r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetUGLocalRuleResponse(LocalRule r100, ByteString r101) {
        super(ADAPTER, r101);
        this.local_rule = r100;
    }
}
