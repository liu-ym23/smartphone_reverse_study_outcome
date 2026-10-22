package com.ss.ugc.live.sdk.msg.unify.data.idl;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class UMGWEventData extends AndroidMessage<UMGWEventData, Builder> {
    public static final ProtoAdapter<UMGWEventData> ADAPTER = null;
    public static final Parcelable.Creator<UMGWEventData> CREATOR = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Integer DEFAULT_SERVICE = null;
    public static final Long DEFAULT_TOKEN = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer method;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWCustomData#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<UMGWCustomData> params;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer service;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long token;

    public static final class Builder extends Message.Builder<UMGWEventData, Builder> {
        public Integer method;
        public List<UMGWCustomData> params;
        public ByteString payload;
        public Integer service;
        public Long token;

        @Override // com.squareup.wire.Message.Builder
        public UMGWEventData build() {
            return new UMGWEventData(this.service, this.method, this.token, this.params, this.payload, super.buildUnknownFields());
        }

        public Builder() {
            this.service = 0;
            this.method = 0;
            this.token = 0L;
            this.payload = ByteString.EMPTY;
            this.params = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder method(Integer r100) {
            this.method = r100;
            return this;
        }

        public Builder params(List<UMGWCustomData> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder service(Integer r100) {
            this.service = r100;
            return this;
        }

        public Builder token(Long r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWEventData extends ProtoAdapter<UMGWEventData> {
        public ProtoAdapter_UMGWEventData() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWEventData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UMGWEventData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.service(ProtoAdapter.INT32.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.method(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.token(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.params.add(UMGWCustomData.ADAPTER.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.payload(ProtoAdapter.BYTES.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UMGWEventData r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            return ((((r101.encodedSizeWithTag(1, r100.service) + r101.encodedSizeWithTag(2, r100.method)) + ProtoAdapter.INT64.encodedSizeWithTag(3, r100.token)) + UMGWCustomData.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.params)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r100.payload)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public UMGWEventData redact2(UMGWEventData r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.params, UMGWCustomData.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWEventData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UMGWEventData r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWEventData redact(UMGWEventData r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UMGWEventData r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.service);
            r102.encodeWithTag(r100, 2, r101.method);
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r101.token);
            UMGWCustomData.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.params);
            ProtoAdapter.BYTES.encodeWithTag(r100, 5, r101.payload);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UMGWEventData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UMGWEventData r100 = new ProtoAdapter_UMGWEventData();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_TOKEN = 0L;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L21;
        int r101 = unknownFields().hashCode() * 37;
        Integer r102 = this.service;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Integer r106 = this.method;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Long r109 = this.token;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (((r108 + r110) * 37) + this.params.hashCode()) * 37;
        ByteString r112 = this.payload;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        int r113 = r111 + r103;
        this.hashCode = r113;
        return r113;
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L21:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.service = this.service;
        r100.method = this.method;
        r100.token = this.token;
        r100.params = Internal.copyOf("params", this.params);
        r100.payload = this.payload;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.service == null) goto L6;
        r100.append(", service=");
        r100.append(this.service);
    L6:
        if (this.method == null) goto L9;
        r100.append(", method=");
        r100.append(this.method);
    L9:
        if (this.token == null) goto L11;
        r100.append(", token=");
        r100.append(this.token);
    L11:
        List<UMGWCustomData> r101 = this.params;
        if (r101 != null) goto L14;
    L16:
        StringBuilder r102 = r100.replace(0, 2, "UMGWEventData{");
        r102.append('}');
        return r102.toString();
    L14:
        if (r101.isEmpty() == true) goto L16;
        r100.append(", params=");
        r100.append(this.params);
        goto L16
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof UMGWEventData) == true) goto L8;
        return false;
    L8:
        UMGWEventData r101 = (UMGWEventData) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (Internal.equals(this.service, r101.service) == false) goto L21;
        if (Internal.equals(this.method, r101.method) == false) goto L21;
        if (Internal.equals(this.token, r101.token) == false) goto L21;
        if (this.params.equals(r101.params) == false) goto L21;
        if (Internal.equals(this.payload, r101.payload) == false) goto L21;
        return true;
    }

    public UMGWEventData(Integer r100, Integer r101, Long r110, List<UMGWCustomData> r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UMGWEventData(Integer r100, Integer r101, Long r102, List<UMGWCustomData> r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.service = r100;
        this.method = r101;
        this.token = r102;
        this.params = Internal.immutableCopyOf("params", r103);
        this.payload = r104;
    }
}
