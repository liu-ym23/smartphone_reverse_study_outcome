package com.bytedance.lark.pb.im.v1;

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
public final class PreResendMessageRequest extends Message<PreResendMessageRequest, Builder> {
    public static final ProtoAdapter<PreResendMessageRequest> ADAPTER = null;
    public static final ProtoAdapter_PreResendMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> upload_ids;

    public static final class Builder extends Message.Builder<PreResendMessageRequest, Builder> implements d<PreResendMessageRequest> {
        public List<String> upload_ids;

        @Override // com.squareup.wire.Message.Builder
        public PreResendMessageRequest build() {
            return new PreResendMessageRequest(this.upload_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.upload_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder upload_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.upload_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PreResendMessageRequest extends ProtoAdapter<PreResendMessageRequest> implements c<PreResendMessageRequest> {
        public ProtoAdapter_PreResendMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PreResendMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PreResendMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.upload_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(PreResendMessageRequest r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.upload_ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PreResendMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PreResendMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PreResendMessageRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.upload_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreResendMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PreResendMessageRequest r100 = new ProtoAdapter_PreResendMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.upload_ids = Internal.copyOf("upload_ids", this.upload_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PreResendMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PreResendMessageRequest(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PreResendMessageRequest(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.upload_ids = Internal.immutableCopyOf("upload_ids", r100);
    }
}
