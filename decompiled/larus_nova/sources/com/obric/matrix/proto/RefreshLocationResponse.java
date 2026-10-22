package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class RefreshLocationResponse extends Message<RefreshLocationResponse, Builder> {
    public static final ProtoAdapter<RefreshLocationResponse> ADAPTER = null;
    public static final Integer DEFAULT_RESULTCODE = null;
    public static final Integer DEFAULT_RESULTMSG = null;
    private static final long serialVersionUID = 0;

    @SerializedName("resultCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer resultCode;

    @SerializedName("resultMsg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer resultMsg;

    public static final class Builder extends Message.Builder<RefreshLocationResponse, Builder> {
        public Integer resultCode;
        public Integer resultMsg;

        @Override // com.squareup.wire.Message.Builder
        public RefreshLocationResponse build() {
            return new RefreshLocationResponse(this.resultCode, this.resultMsg, super.buildUnknownFields());
        }

        public Builder() {
            this.resultCode = 0;
            this.resultMsg = 0;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder resultCode(Integer r100) {
            this.resultCode = r100;
            return this;
        }

        public Builder resultMsg(Integer r100) {
            this.resultMsg = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RefreshLocationResponse extends ProtoAdapter<RefreshLocationResponse> {
        public ProtoAdapter_RefreshLocationResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshLocationResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RefreshLocationResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.resultCode(ProtoAdapter.INT32.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.resultMsg(ProtoAdapter.INT32.decode(r100));
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
        public int encodedSize2(RefreshLocationResponse r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            return (r101.encodedSizeWithTag(1, r100.resultCode) + r101.encodedSizeWithTag(2, r100.resultMsg)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public RefreshLocationResponse redact2(RefreshLocationResponse r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RefreshLocationResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationResponse redact(RefreshLocationResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RefreshLocationResponse r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.resultCode);
            r102.encodeWithTag(r100, 2, r101.resultMsg);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RefreshLocationResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RefreshLocationResponse();
        DEFAULT_RESULTCODE = 0;
        DEFAULT_RESULTMSG = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L13;
        int r101 = unknownFields().hashCode() * 37;
        Integer r102 = this.resultCode;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Integer r106 = this.resultMsg;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        int r107 = r105 + r103;
        this.hashCode = r107;
        return r107;
    L7:
        r104 = 0;
        goto L8
    L13:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.resultCode = this.resultCode;
        r100.resultMsg = this.resultMsg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.resultCode == null) goto L6;
        r100.append(", resultCode=");
        r100.append(this.resultCode);
    L6:
        if (this.resultMsg == null) goto L8;
        r100.append(", resultMsg=");
        r100.append(this.resultMsg);
    L8:
        StringBuilder r101 = r100.replace(0, 2, "RefreshLocationResponse{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof RefreshLocationResponse) == true) goto L8;
        return false;
    L8:
        RefreshLocationResponse r101 = (RefreshLocationResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.resultCode, r101.resultCode) == false) goto L15;
        if (Internal.equals(this.resultMsg, r101.resultMsg) == false) goto L15;
        return true;
    }

    public RefreshLocationResponse(Integer r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public RefreshLocationResponse(Integer r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.resultCode = r100;
        this.resultMsg = r101;
    }
}
