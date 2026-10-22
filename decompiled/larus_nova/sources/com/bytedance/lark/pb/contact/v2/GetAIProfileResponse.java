package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetAIProfileResponse extends Message<GetAIProfileResponse, Builder> {
    public static final ProtoAdapter<GetAIProfileResponse> ADAPTER = null;
    public static final ProtoAdapter_GetAIProfileResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AIProfile ai_info;
    public final List<GetUserProfileResponse.CTA> cta_orders;
    public final List<GetUserProfileResponse.Field> field_orders;

    public static final class Builder extends Message.Builder<GetAIProfileResponse, Builder> implements d<GetAIProfileResponse> {
        public AIProfile ai_info;
        public List<GetUserProfileResponse.CTA> cta_orders;
        public List<GetUserProfileResponse.Field> field_orders;

        @Override // com.squareup.wire.Message.Builder
        public GetAIProfileResponse build() {
            return new GetAIProfileResponse(this.ai_info, this.cta_orders, this.field_orders, super.buildUnknownFields());
        }

        public Builder() {
            this.cta_orders = Internal.newMutableList();
            this.field_orders = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_info(AIProfile r100) {
            this.ai_info = r100;
            return this;
        }

        public Builder cta_orders(List<GetUserProfileResponse.CTA> r100) {
            Internal.checkElementsNotNull(r100);
            this.cta_orders = r100;
            return this;
        }

        public Builder field_orders(List<GetUserProfileResponse.Field> r100) {
            Internal.checkElementsNotNull(r100);
            this.field_orders = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAIProfileResponse extends ProtoAdapter<GetAIProfileResponse> implements c<GetAIProfileResponse> {
        public ProtoAdapter_GetAIProfileResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAIProfileResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAIProfileResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.ai_info = AIProfile.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.cta_orders.add(GetUserProfileResponse.CTA.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.field_orders.add(GetUserProfileResponse.Field.ADAPTER.decode(r100));
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
        public int encodedSize2(GetAIProfileResponse r100) {
            AIProfile r101 = r100.ai_info;
            if (r101 == null) goto L5;
            int r102 = AIProfile.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return ((r102 + GetUserProfileResponse.CTA.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.cta_orders)) + GetUserProfileResponse.Field.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.field_orders)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetAIProfileResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAIProfileResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAIProfileResponse r101) throws IOException {
            AIProfile r102 = r101.ai_info;
            if (r102 == null) goto L5;
            AIProfile.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            GetUserProfileResponse.CTA.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.cta_orders);
            GetUserProfileResponse.Field.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.field_orders);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAIProfileResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetAIProfileResponse r100 = new ProtoAdapter_GetAIProfileResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ai_info = this.ai_info;
        r100.cta_orders = Internal.copyOf("cta_orders", this.cta_orders);
        r100.field_orders = Internal.copyOf("field_orders", this.field_orders);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAIProfileResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAIProfileResponse(AIProfile r100, List<GetUserProfileResponse.CTA> r101, List<GetUserProfileResponse.Field> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetAIProfileResponse(AIProfile r100, List<GetUserProfileResponse.CTA> r101, List<GetUserProfileResponse.Field> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.ai_info = r100;
        this.cta_orders = Internal.immutableCopyOf("cta_orders", r101);
        this.field_orders = Internal.immutableCopyOf("field_orders", r102);
    }
}
