package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class RecallGroupMessageRequest extends Message<RecallGroupMessageRequest, Builder> {
    public static final ProtoAdapter<RecallGroupMessageRequest> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final ProtoAdapter_RecallGroupMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253649id;

    public static final class Builder extends Message.Builder<RecallGroupMessageRequest, Builder> implements d<RecallGroupMessageRequest> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253650id;

        @Override // com.squareup.wire.Message.Builder
        public RecallGroupMessageRequest build() {
            String r100 = this.f253650id;
            if (r100 == null) goto L7;
            return new RecallGroupMessageRequest(this.f253650id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253650id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecallGroupMessageRequest extends ProtoAdapter<RecallGroupMessageRequest> implements c<RecallGroupMessageRequest> {
        public ProtoAdapter_RecallGroupMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, RecallGroupMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RecallGroupMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253650id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.f253650id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(RecallGroupMessageRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253649id) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecallGroupMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecallGroupMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecallGroupMessageRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253649id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecallGroupMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_RecallGroupMessageRequest r100 = new ProtoAdapter_RecallGroupMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253650id = this.f253649id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecallGroupMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecallGroupMessageRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public RecallGroupMessageRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.f253649id = r100;
    }
}
