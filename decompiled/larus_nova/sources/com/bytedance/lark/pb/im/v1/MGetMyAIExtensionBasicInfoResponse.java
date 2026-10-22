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
public final class MGetMyAIExtensionBasicInfoResponse extends Message<MGetMyAIExtensionBasicInfoResponse, Builder> {
    public static final ProtoAdapter<MGetMyAIExtensionBasicInfoResponse> ADAPTER = null;
    public static final ProtoAdapter_MGetMyAIExtensionBasicInfoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<MyAIExtensionBasicInfo> extension_list;

    public static final class Builder extends Message.Builder<MGetMyAIExtensionBasicInfoResponse, Builder> implements d<MGetMyAIExtensionBasicInfoResponse> {
        public List<MyAIExtensionBasicInfo> extension_list;

        @Override // com.squareup.wire.Message.Builder
        public MGetMyAIExtensionBasicInfoResponse build() {
            return new MGetMyAIExtensionBasicInfoResponse(this.extension_list, super.buildUnknownFields());
        }

        public Builder() {
            this.extension_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extension_list(List<MyAIExtensionBasicInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.extension_list = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetMyAIExtensionBasicInfoResponse extends ProtoAdapter<MGetMyAIExtensionBasicInfoResponse> implements c<MGetMyAIExtensionBasicInfoResponse> {
        public ProtoAdapter_MGetMyAIExtensionBasicInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetMyAIExtensionBasicInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetMyAIExtensionBasicInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.extension_list.add(MyAIExtensionBasicInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(MGetMyAIExtensionBasicInfoResponse r100) {
            return MyAIExtensionBasicInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.extension_list) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetMyAIExtensionBasicInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetMyAIExtensionBasicInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetMyAIExtensionBasicInfoResponse r101) throws IOException {
            MyAIExtensionBasicInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.extension_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetMyAIExtensionBasicInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetMyAIExtensionBasicInfoResponse r100 = new ProtoAdapter_MGetMyAIExtensionBasicInfoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.extension_list = Internal.copyOf("extension_list", this.extension_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetMyAIExtensionBasicInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetMyAIExtensionBasicInfoResponse(List<MyAIExtensionBasicInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MGetMyAIExtensionBasicInfoResponse(List<MyAIExtensionBasicInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.extension_list = Internal.immutableCopyOf("extension_list", r100);
    }
}
