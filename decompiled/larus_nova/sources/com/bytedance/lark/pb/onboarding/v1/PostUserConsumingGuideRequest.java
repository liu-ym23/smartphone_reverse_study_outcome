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
public final class PostUserConsumingGuideRequest extends Message<PostUserConsumingGuideRequest, Builder> {
    public static final ProtoAdapter<PostUserConsumingGuideRequest> ADAPTER = null;
    public static final ProtoAdapter_PostUserConsumingGuideRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> keys;

    public static final class Builder extends Message.Builder<PostUserConsumingGuideRequest, Builder> implements d<PostUserConsumingGuideRequest> {
        public List<String> keys;

        @Override // com.squareup.wire.Message.Builder
        public PostUserConsumingGuideRequest build() {
            return new PostUserConsumingGuideRequest(this.keys, super.buildUnknownFields());
        }

        public Builder() {
            this.keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.keys = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PostUserConsumingGuideRequest extends ProtoAdapter<PostUserConsumingGuideRequest> implements c<PostUserConsumingGuideRequest> {
        public ProtoAdapter_PostUserConsumingGuideRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PostUserConsumingGuideRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PostUserConsumingGuideRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.keys.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(PostUserConsumingGuideRequest r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.keys) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PostUserConsumingGuideRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PostUserConsumingGuideRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PostUserConsumingGuideRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.keys);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PostUserConsumingGuideRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PostUserConsumingGuideRequest r100 = new ProtoAdapter_PostUserConsumingGuideRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.keys = Internal.copyOf("keys", this.keys);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PostUserConsumingGuideRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PostUserConsumingGuideRequest(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PostUserConsumingGuideRequest(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.keys = Internal.immutableCopyOf("keys", r100);
    }
}
