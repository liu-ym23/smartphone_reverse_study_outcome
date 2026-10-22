package com.obric.matrix.proto;

import com.alipay.sdk.m.p.e;
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
public final class SubscribeWsMsgByCallBackRequest extends Message<SubscribeWsMsgByCallBackRequest, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgByCallBackRequest> ADAPTER = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final Integer DEFAULT_OPT = null;
    public static final String DEFAULT_PACKAGENAME = "";
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @SerializedName(e.f25671s)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer method;

    @SerializedName("opt")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer opt;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String packageName;

    @SerializedName("service")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer service;

    public static final class Builder extends Message.Builder<SubscribeWsMsgByCallBackRequest, Builder> {
        public Integer method;
        public Integer opt;
        public String packageName;
        public Integer service;

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsMsgByCallBackRequest build() {
            return new SubscribeWsMsgByCallBackRequest(this.service, this.method, this.packageName, this.opt, super.buildUnknownFields());
        }

        public Builder() {
            this.service = 0;
            this.method = 0;
            this.packageName = "";
            this.opt = 0;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder method(Integer r100) {
            this.method = r100;
            return this;
        }

        public Builder opt(Integer r100) {
            this.opt = r100;
            return this;
        }

        public Builder packageName(String r100) {
            this.packageName = r100;
            return this;
        }

        public Builder service(Integer r100) {
            this.service = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgByCallBackRequest extends ProtoAdapter<SubscribeWsMsgByCallBackRequest> {
        public ProtoAdapter_SubscribeWsMsgByCallBackRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByCallBackRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsMsgByCallBackRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.service(ProtoAdapter.INT32.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.method(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.packageName(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.opt(ProtoAdapter.INT32.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsMsgByCallBackRequest r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            return (((r101.encodedSizeWithTag(1, r100.service) + r101.encodedSizeWithTag(2, r100.method)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.packageName)) + r101.encodedSizeWithTag(4, r100.opt)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsMsgByCallBackRequest redact2(SubscribeWsMsgByCallBackRequest r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByCallBackRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgByCallBackRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByCallBackRequest redact(SubscribeWsMsgByCallBackRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubscribeWsMsgByCallBackRequest r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.service);
            r102.encodeWithTag(r100, 2, r101.method);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.packageName);
            r102.encodeWithTag(r100, 4, r101.opt);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubscribeWsMsgByCallBackRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgByCallBackRequest();
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_OPT = 0;
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
        String r109 = this.packageName;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Integer r112 = this.opt;
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
        r100.packageName = this.packageName;
        r100.opt = this.opt;
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
        if (this.packageName == null) goto L12;
        r100.append(", packageName=");
        r100.append(this.packageName);
    L12:
        if (this.opt == null) goto L14;
        r100.append(", opt=");
        r100.append(this.opt);
    L14:
        StringBuilder r101 = r100.replace(0, 2, "SubscribeWsMsgByCallBackRequest{");
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
        if ((r100 instanceof SubscribeWsMsgByCallBackRequest) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByCallBackRequest r101 = (SubscribeWsMsgByCallBackRequest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.service, r101.service) == false) goto L19;
        if (Internal.equals(this.method, r101.method) == false) goto L19;
        if (Internal.equals(this.packageName, r101.packageName) == false) goto L19;
        if (Internal.equals(this.opt, r101.opt) == false) goto L19;
        return true;
    }

    public SubscribeWsMsgByCallBackRequest(Integer r100, Integer r101, String r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SubscribeWsMsgByCallBackRequest(Integer r100, Integer r101, String r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.service = r100;
        this.method = r101;
        this.packageName = r102;
        this.opt = r103;
    }
}
