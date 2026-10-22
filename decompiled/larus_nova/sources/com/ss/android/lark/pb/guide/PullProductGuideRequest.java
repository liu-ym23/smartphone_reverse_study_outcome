package com.ss.android.lark.pb.guide;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullProductGuideRequest extends Message<PullProductGuideRequest, Builder> {
    public static final ProtoAdapter<PullProductGuideRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final GuideScene mscene;

    public static final class Builder extends Message.Builder<PullProductGuideRequest, Builder> {
        public GuideScene mscene;

        @Override // com.squareup.wire.Message.Builder
        public PullProductGuideRequest build() {
            return new PullProductGuideRequest(this.mscene, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scene(GuideScene r100) {
            this.mscene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullProductGuideRequest extends ProtoAdapter<PullProductGuideRequest> {
        public ProtoAdapter_PullProductGuideRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullProductGuideRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullProductGuideRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.mscene = GuideScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(PullProductGuideRequest r100) {
            GuideScene r101 = r100.mscene;
            if (r101 == null) goto L5;
            int r102 = GuideScene.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullProductGuideRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullProductGuideRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullProductGuideRequest r101) throws IOException {
            GuideScene r102 = r101.mscene;
            if (r102 == null) goto L5;
            GuideScene.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullProductGuideRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullProductGuideRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mscene = this.mscene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullProductGuideRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullProductGuideRequest(GuideScene r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullProductGuideRequest(GuideScene r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mscene = r100;
    }
}
