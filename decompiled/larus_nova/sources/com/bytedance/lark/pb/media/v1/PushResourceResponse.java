package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushResourceResponse extends Message<PushResourceResponse, Builder> {
    public static final ProtoAdapter<PushResourceResponse> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final Status DEFAULT_STATUS = null;
    public static final ProtoAdapter_PushResourceResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String key;
    public final Resource resource;
    public final Status status;

    public static final class Builder extends Message.Builder<PushResourceResponse, Builder> implements d<PushResourceResponse> {
        public String key;
        public Resource resource;
        public Status status;

        @Override // com.squareup.wire.Message.Builder
        public PushResourceResponse build() {
            String r100 = this.key;
            if (r100 == null) goto L9;
            if (this.status == null) goto L9;
            return new PushResourceResponse(this.key, this.status, this.resource, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.status, "status"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder resource(Resource r100) {
            this.resource = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushResourceResponse extends ProtoAdapter<PushResourceResponse> implements c<PushResourceResponse> {
        public ProtoAdapter_PushResourceResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PushResourceResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushResourceResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.status = Status.SUCCESS;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.resource = Resource.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushResourceResponse r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.key) + Status.ADAPTER.encodedSizeWithTag(2, r100.status);
            Resource r102 = r100.resource;
            if (r102 == null) goto L5;
            int r103 = Resource.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushResourceResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushResourceResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushResourceResponse r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.key);
            Status.ADAPTER.encodeWithTag(r100, 2, r101.status);
            Resource r102 = r101.resource;
            if (r102 == null) goto L5;
            Resource.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushResourceResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status FAIL = null;
        public static final Status SUCCESS = null;
        private final int value;

        static {
            Status r100 = new Status("SUCCESS", 0, 1);
            SUCCESS = r100;
            Status r101 = new Status("FAIL", 1, 2);
            FAIL = r101;
            $VALUES = new Status[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return FAIL;
        L11:
            return SUCCESS;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_PushResourceResponse r100 = new ProtoAdapter_PushResourceResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS = Status.SUCCESS;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.status = this.status;
        r100.resource = this.resource;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushResourceResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushResourceResponse(String r100, Status r101, Resource r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushResourceResponse(String r100, Status r101, Resource r102, ByteString r103) {
        super(ADAPTER, r103);
        this.key = r100;
        this.status = r101;
        this.resource = r102;
    }
}
