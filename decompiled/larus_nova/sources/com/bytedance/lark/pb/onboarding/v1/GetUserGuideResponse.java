package com.bytedance.lark.pb.onboarding.v1;

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
public final class GetUserGuideResponse extends Message<GetUserGuideResponse, Builder> {
    public static final ProtoAdapter<GetUserGuideResponse> ADAPTER = null;
    public static final ProtoAdapter_GetUserGuideResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<UserGuideViewAreaPair> ordered_pairs;

    public static final class Builder extends Message.Builder<GetUserGuideResponse, Builder> implements d<GetUserGuideResponse> {
        public List<UserGuideViewAreaPair> ordered_pairs;

        @Override // com.squareup.wire.Message.Builder
        public GetUserGuideResponse build() {
            return new GetUserGuideResponse(this.ordered_pairs, super.buildUnknownFields());
        }

        public Builder() {
            this.ordered_pairs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ordered_pairs(List<UserGuideViewAreaPair> r100) {
            Internal.checkElementsNotNull(r100);
            this.ordered_pairs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserGuideResponse extends ProtoAdapter<GetUserGuideResponse> implements c<GetUserGuideResponse> {
        public ProtoAdapter_GetUserGuideResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserGuideResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserGuideResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.ordered_pairs.add(UserGuideViewAreaPair.ADAPTER.decode(r100));
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
        public int encodedSize2(GetUserGuideResponse r100) {
            return UserGuideViewAreaPair.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.ordered_pairs) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserGuideResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserGuideResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserGuideResponse r101) throws IOException {
            UserGuideViewAreaPair.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.ordered_pairs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserGuideResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserGuideResponse r100 = new ProtoAdapter_GetUserGuideResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ordered_pairs = Internal.copyOf("ordered_pairs", this.ordered_pairs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserGuideResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserGuideResponse(List<UserGuideViewAreaPair> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetUserGuideResponse(List<UserGuideViewAreaPair> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.ordered_pairs = Internal.immutableCopyOf("ordered_pairs", r100);
    }
}
