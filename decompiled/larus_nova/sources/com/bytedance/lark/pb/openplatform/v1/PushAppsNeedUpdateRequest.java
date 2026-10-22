package com.bytedance.lark.pb.openplatform.v1;

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
public final class PushAppsNeedUpdateRequest extends Message<PushAppsNeedUpdateRequest, Builder> {
    public static final ProtoAdapter<PushAppsNeedUpdateRequest> ADAPTER = null;
    public static final String DEFAULT_TIMESTAMP = "";
    public static final ProtoAdapter_PushAppsNeedUpdateRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String timestamp;

    public static final class Builder extends Message.Builder<PushAppsNeedUpdateRequest, Builder> implements d<PushAppsNeedUpdateRequest> {
        public String timestamp;

        @Override // com.squareup.wire.Message.Builder
        public PushAppsNeedUpdateRequest build() {
            return new PushAppsNeedUpdateRequest(this.timestamp, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder timestamp(String r100) {
            this.timestamp = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushAppsNeedUpdateRequest extends ProtoAdapter<PushAppsNeedUpdateRequest> implements c<PushAppsNeedUpdateRequest> {
        public ProtoAdapter_PushAppsNeedUpdateRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushAppsNeedUpdateRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushAppsNeedUpdateRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.timestamp = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.timestamp = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PushAppsNeedUpdateRequest r100) {
            String r101 = r100.timestamp;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushAppsNeedUpdateRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushAppsNeedUpdateRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushAppsNeedUpdateRequest r101) throws IOException {
            String r102 = r101.timestamp;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushAppsNeedUpdateRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushAppsNeedUpdateRequest r100 = new ProtoAdapter_PushAppsNeedUpdateRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.timestamp = this.timestamp;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushAppsNeedUpdateRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushAppsNeedUpdateRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushAppsNeedUpdateRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.timestamp = r100;
    }
}
