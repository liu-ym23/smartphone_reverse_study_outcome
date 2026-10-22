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
public final class RecallMessageRequest extends Message<RecallMessageRequest, Builder> {
    public static final ProtoAdapter<RecallMessageRequest> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final ProtoAdapter_RecallMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253651id;

    public static final class Builder extends Message.Builder<RecallMessageRequest, Builder> implements d<RecallMessageRequest> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253652id;

        @Override // com.squareup.wire.Message.Builder
        public RecallMessageRequest build() {
            String r100 = this.f253652id;
            if (r100 == null) goto L7;
            return new RecallMessageRequest(this.f253652id, super.buildUnknownFields());
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
            this.f253652id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecallMessageRequest extends ProtoAdapter<RecallMessageRequest> implements c<RecallMessageRequest> {
        public ProtoAdapter_RecallMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, RecallMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RecallMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253652id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.f253652id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(RecallMessageRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253651id) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecallMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecallMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecallMessageRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253651id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecallMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_RecallMessageRequest r100 = new ProtoAdapter_RecallMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253652id = this.f253651id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecallMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecallMessageRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public RecallMessageRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.f253651id = r100;
    }
}
