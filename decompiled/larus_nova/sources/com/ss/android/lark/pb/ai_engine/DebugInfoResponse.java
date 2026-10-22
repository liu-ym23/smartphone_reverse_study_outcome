package com.ss.android.lark.pb.ai_engine;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DebugInfoResponse extends Message<DebugInfoResponse, Builder> {
    public static final ProtoAdapter<DebugInfoResponse> ADAPTER = null;
    public static final Long DEFAULT_CODE = null;
    public static final String DEFAULT_DEBUG_INFO = "";
    private static final long serialVersionUID = 0;
    public final Long mcode;
    public final String mdebug_info;

    public static final class Builder extends Message.Builder<DebugInfoResponse, Builder> {
        public Long mcode;
        public String mdebug_info;

        @Override // com.squareup.wire.Message.Builder
        public DebugInfoResponse build() {
            return new DebugInfoResponse(this.mcode, this.mdebug_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder code(Long r100) {
            this.mcode = r100;
            return this;
        }

        public Builder debug_info(String r100) {
            this.mdebug_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DebugInfoResponse extends ProtoAdapter<DebugInfoResponse> {
        public ProtoAdapter_DebugInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, DebugInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DebugInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcode = 0L;
            r101.mdebug_info = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mcode = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mdebug_info = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DebugInfoResponse r100) {
            Long r101 = r100.mcode;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mdebug_info;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DebugInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DebugInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DebugInfoResponse r101) throws IOException {
            Long r102 = r101.mcode;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mdebug_info;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DebugInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DebugInfoResponse();
        DEFAULT_CODE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcode = this.mcode;
        r100.mdebug_info = this.mdebug_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DebugInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DebugInfoResponse(Long r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DebugInfoResponse(Long r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mcode = r100;
        this.mdebug_info = r101;
    }
}
