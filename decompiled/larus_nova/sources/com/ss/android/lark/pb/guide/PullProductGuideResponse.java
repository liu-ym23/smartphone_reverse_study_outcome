package com.ss.android.lark.pb.guide;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullProductGuideResponse extends Message<PullProductGuideResponse, Builder> {
    public static final ProtoAdapter<PullProductGuideResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Boolean> mguides;

    public static final class Builder extends Message.Builder<PullProductGuideResponse, Builder> {
        public Map<String, Boolean> mguides;

        @Override // com.squareup.wire.Message.Builder
        public PullProductGuideResponse build() {
            return new PullProductGuideResponse(this.mguides, super.buildUnknownFields());
        }

        public Builder() {
            this.mguides = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder guides(Map<String, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.mguides = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullProductGuideResponse extends ProtoAdapter<PullProductGuideResponse> {
        private final ProtoAdapter<Map<String, Boolean>> mguides;

        public ProtoAdapter_PullProductGuideResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullProductGuideResponse.class);
            this.mguides = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullProductGuideResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 2) goto L7;
            r101.mguides.putAll(this.mguides.decode(r100));
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
        public int encodedSize2(PullProductGuideResponse r100) {
            return this.mguides.encodedSizeWithTag(2, r100.mguides) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullProductGuideResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullProductGuideResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullProductGuideResponse r101) throws IOException {
            this.mguides.encodeWithTag(r100, 2, r101.mguides);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullProductGuideResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullProductGuideResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mguides = Internal.copyOf("mguides", this.mguides);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullProductGuideResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullProductGuideResponse(Map<String, Boolean> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullProductGuideResponse(Map<String, Boolean> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mguides = Internal.immutableCopyOf("mguides", r100);
    }
}
