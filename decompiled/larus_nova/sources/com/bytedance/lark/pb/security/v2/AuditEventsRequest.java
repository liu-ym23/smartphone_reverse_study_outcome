package com.bytedance.lark.pb.security.v2;

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
public final class AuditEventsRequest extends Message<AuditEventsRequest, Builder> {
    public static final ProtoAdapter<AuditEventsRequest> ADAPTER = null;
    public static final ByteString DEFAULT_DATA = null;
    public static final ProtoAdapter_AuditEventsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteString data;

    public static final class Builder extends Message.Builder<AuditEventsRequest, Builder> implements d<AuditEventsRequest> {
        public ByteString data;

        @Override // com.squareup.wire.Message.Builder
        public AuditEventsRequest build() {
            ByteString r100 = this.data;
            if (r100 == null) goto L7;
            return new AuditEventsRequest(this.data, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "data"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data(ByteString r100) {
            this.data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AuditEventsRequest extends ProtoAdapter<AuditEventsRequest> implements c<AuditEventsRequest> {
        public ProtoAdapter_AuditEventsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, AuditEventsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AuditEventsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.data = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.data = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(AuditEventsRequest r100) {
            return ProtoAdapter.BYTES.encodedSizeWithTag(1, r100.data) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AuditEventsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AuditEventsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AuditEventsRequest r101) throws IOException {
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r101.data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AuditEventsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_AuditEventsRequest r100 = new ProtoAdapter_AuditEventsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.data = this.data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AuditEventsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AuditEventsRequest(ByteString r100) {
        this(r100, ByteString.EMPTY);
    }

    public AuditEventsRequest(ByteString r100, ByteString r101) {
        super(ADAPTER, r101);
        this.data = r100;
    }
}
