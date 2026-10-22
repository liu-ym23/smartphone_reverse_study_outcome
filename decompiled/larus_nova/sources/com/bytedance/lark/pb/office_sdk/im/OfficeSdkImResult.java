package com.bytedance.lark.pb.office_sdk.im;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class OfficeSdkImResult extends Message<OfficeSdkImResult, Builder> {
    public static final ProtoAdapter<OfficeSdkImResult> ADAPTER = null;
    public static final ByteString DEFAULT_SUCCESS_PAYLOAD = null;
    private static final long serialVersionUID = 0;
    public final OfficeSdkImError error;
    public final ByteString success_payload;

    public static final class Builder extends Message.Builder<OfficeSdkImResult, Builder> {
        public OfficeSdkImError error;
        public ByteString success_payload;

        @Override // com.squareup.wire.Message.Builder
        public OfficeSdkImResult build() {
            return new OfficeSdkImResult(this.success_payload, this.error, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder error(OfficeSdkImError r100) {
            this.error = r100;
            this.success_payload = null;
            return this;
        }

        public Builder success_payload(ByteString r100) {
            this.success_payload = r100;
            this.error = null;
            return this;
        }
    }

    public static final class ProtoAdapter_OfficeSdkImResult extends ProtoAdapter<OfficeSdkImResult> {
        public ProtoAdapter_OfficeSdkImResult() {
            super(FieldEncoding.LENGTH_DELIMITED, OfficeSdkImResult.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OfficeSdkImResult decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.success_payload(ByteString.EMPTY);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.success_payload(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.error(OfficeSdkImError.ADAPTER.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OfficeSdkImResult r100) {
            ByteString r101 = r100.success_payload;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
        L6:
            OfficeSdkImError r104 = r100.error;
            if (r104 == null) goto L10;
            r102 = OfficeSdkImError.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OfficeSdkImResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OfficeSdkImResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OfficeSdkImResult r101) throws IOException {
            ByteString r102 = r101.success_payload;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
        L5:
            OfficeSdkImError r103 = r101.error;
            if (r103 == null) goto L8;
            OfficeSdkImError.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OfficeSdkImResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OfficeSdkImResult();
        DEFAULT_SUCCESS_PAYLOAD = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.success_payload = this.success_payload;
        r100.error = this.error;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OfficeSdkImResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OfficeSdkImResult(ByteString r100, OfficeSdkImError r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public OfficeSdkImResult(ByteString r100, OfficeSdkImError r101, ByteString r102) {
        super(ADAPTER, r102);
        if (Internal.countNonNull(r100, r101) > 1) goto L7;
        this.success_payload = r100;
        this.error = r101;
        return;
    L7:
        throw new IllegalArgumentException("at most one of success_payload, error may be non-null");
    }
}
