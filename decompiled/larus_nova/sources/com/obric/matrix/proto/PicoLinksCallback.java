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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class PicoLinksCallback extends Message<PicoLinksCallback, Builder> {
    public static final ProtoAdapter<PicoLinksCallback> ADAPTER = null;
    public static final Integer DEFAULT_CALLBACKID = null;
    private static final long serialVersionUID = 0;

    @SerializedName("callbackData")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> callbackData;

    @SerializedName("callbackId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer callbackId;

    public static final class Builder extends Message.Builder<PicoLinksCallback, Builder> {
        public Map<String, String> callbackData;
        public Integer callbackId;

        @Override // com.squareup.wire.Message.Builder
        public PicoLinksCallback build() {
            return new PicoLinksCallback(this.callbackId, this.callbackData, super.buildUnknownFields());
        }

        public Builder() {
            this.callbackId = 0;
            this.callbackData = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder callbackData(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.callbackData = r100;
            return this;
        }

        public Builder callbackId(Integer r100) {
            this.callbackId = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PicoLinksCallback extends ProtoAdapter<PicoLinksCallback> {
        private final ProtoAdapter<Map<String, String>> callbackData;

        public ProtoAdapter_PicoLinksCallback() {
            super(FieldEncoding.LENGTH_DELIMITED, PicoLinksCallback.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.callbackData = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PicoLinksCallback decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.callbackId(ProtoAdapter.INT32.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.callbackData.putAll(this.callbackData.decode(r100));
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
        public int encodedSize2(PicoLinksCallback r100) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r100.callbackId) + this.callbackData.encodedSizeWithTag(2, r100.callbackData)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public PicoLinksCallback redact2(PicoLinksCallback r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PicoLinksCallback decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PicoLinksCallback r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PicoLinksCallback redact(PicoLinksCallback r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PicoLinksCallback r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.callbackId);
            this.callbackData.encodeWithTag(r100, 2, r101.callbackData);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PicoLinksCallback r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PicoLinksCallback();
        DEFAULT_CALLBACKID = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L10;
        int r101 = unknownFields().hashCode() * 37;
        Integer r102 = this.callbackId;
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        int r104 = ((r101 + r103) * 37) + this.callbackData.hashCode();
        this.hashCode = r104;
        return r104;
    L7:
        r103 = 0;
        goto L8
    L10:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.callbackId = this.callbackId;
        r100.callbackData = Internal.copyOf("callbackData", this.callbackData);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.callbackId == null) goto L5;
        r100.append(", callbackId=");
        r100.append(this.callbackId);
    L5:
        Map<String, String> r101 = this.callbackData;
        if (r101 != null) goto L8;
    L10:
        StringBuilder r102 = r100.replace(0, 2, "PicoLinksCallback{");
        r102.append('}');
        return r102.toString();
    L8:
        if (r101.isEmpty() == true) goto L10;
        r100.append(", callbackData=");
        r100.append(this.callbackData);
        goto L10
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof PicoLinksCallback) == true) goto L8;
        return false;
    L8:
        PicoLinksCallback r101 = (PicoLinksCallback) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.callbackId, r101.callbackId) == false) goto L15;
        if (this.callbackData.equals(r101.callbackData) == false) goto L15;
        return true;
    }

    public PicoLinksCallback(Integer r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PicoLinksCallback(Integer r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.callbackId = r100;
        this.callbackData = Internal.immutableCopyOf("callbackData", r101);
    }
}
