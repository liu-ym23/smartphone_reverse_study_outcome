package com.bytedance.lark.pb.openplatform.v1;

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
public final class CommonGadgetPushRequest extends Message<CommonGadgetPushRequest, Builder> {
    public static final ProtoAdapter<CommonGadgetPushRequest> ADAPTER = null;
    public static final String DEFAULT_BIZ = "";
    public static final String DEFAULT_DATA = "";
    public static final Boolean DEFAULT_IS_ONLINE = null;
    public static final String DEFAULT_TIMESTAMP = "";
    public static final ProtoAdapter_CommonGadgetPushRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String biz;
    public final String data;
    public final Boolean is_online;
    public final String timestamp;

    public static final class Builder extends Message.Builder<CommonGadgetPushRequest, Builder> implements d<CommonGadgetPushRequest> {
        public String biz;
        public String data;
        public Boolean is_online;
        public String timestamp;

        @Override // com.squareup.wire.Message.Builder
        public CommonGadgetPushRequest build() {
            Boolean r100 = this.is_online;
            if (r100 == null) goto L9;
            if (this.biz == null) goto L9;
            return new CommonGadgetPushRequest(this.is_online, this.biz, this.timestamp, this.data, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_online", this.biz, "biz"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz(String r100) {
            this.biz = r100;
            return this;
        }

        public Builder data(String r100) {
            this.data = r100;
            return this;
        }

        public Builder is_online(Boolean r100) {
            this.is_online = r100;
            return this;
        }

        public Builder timestamp(String r100) {
            this.timestamp = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CommonGadgetPushRequest extends ProtoAdapter<CommonGadgetPushRequest> implements c<CommonGadgetPushRequest> {
        public ProtoAdapter_CommonGadgetPushRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CommonGadgetPushRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CommonGadgetPushRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_online = Boolean.FALSE;
            r101.biz = "";
            r101.timestamp = "";
            r101.data = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.is_online = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.biz = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.timestamp = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.data = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CommonGadgetPushRequest r100) {
            int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.is_online);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.biz);
            String r104 = r100.timestamp;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            String r108 = r100.data;
            if (r108 == null) goto L10;
            r105 = r102.encodedSizeWithTag(4, r108);
        L10:
            return (r107 + r105) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CommonGadgetPushRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CommonGadgetPushRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CommonGadgetPushRequest r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.is_online);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.biz);
            String r103 = r101.timestamp;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.data;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CommonGadgetPushRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CommonGadgetPushRequest r100 = new ProtoAdapter_CommonGadgetPushRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_ONLINE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_online = this.is_online;
        r100.biz = this.biz;
        r100.timestamp = this.timestamp;
        r100.data = this.data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CommonGadgetPushRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CommonGadgetPushRequest(Boolean r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public CommonGadgetPushRequest(Boolean r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.is_online = r100;
        this.biz = r101;
        this.timestamp = r102;
        this.data = r103;
    }
}
