package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
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
public final class GetWebSocketStatusResponse extends com.squareup.wire.Message<GetWebSocketStatusResponse, Builder> {
    public static final ProtoAdapter<GetWebSocketStatusResponse> ADAPTER = null;
    public static final Status DEFAULT_STATUS = null;
    public static final ProtoAdapter_GetWebSocketStatusResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Status status;

    public static final class Builder extends com.squareup.wire.Message.Builder<GetWebSocketStatusResponse, Builder> implements d<GetWebSocketStatusResponse> {
        public Status status;

        @Override // com.squareup.wire.Message.Builder
        public GetWebSocketStatusResponse build() {
            Status r100 = this.status;
            if (r100 == null) goto L7;
            return new GetWebSocketStatusResponse(this.status, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "status"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetWebSocketStatusResponse extends ProtoAdapter<GetWebSocketStatusResponse> implements c<GetWebSocketStatusResponse> {
        public ProtoAdapter_GetWebSocketStatusResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetWebSocketStatusResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetWebSocketStatusResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = Status.OPENING;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetWebSocketStatusResponse r100) {
            return Status.ADAPTER.encodedSizeWithTag(1, r100.status) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetWebSocketStatusResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetWebSocketStatusResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetWebSocketStatusResponse r101) throws IOException {
            Status.ADAPTER.encodeWithTag(r100, 1, r101.status);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetWebSocketStatusResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status CLOSE = null;
        public static final Status CLOSED_FOR_LONG_TIME = null;
        public static final Status OPENING = null;
        public static final Status SUCCESS = null;
        private final int value;

        static {
            Status r100 = new Status("OPENING", 0, 1);
            OPENING = r100;
            Status r101 = new Status("SUCCESS", 1, 2);
            SUCCESS = r101;
            Status r102 = new Status("CLOSE", 2, 3);
            CLOSE = r102;
            Status r103 = new Status("CLOSED_FOR_LONG_TIME", 3, 4);
            CLOSED_FOR_LONG_TIME = r103;
            $VALUES = new Status[]{r100, r101, r102, r103};
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
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return CLOSED_FOR_LONG_TIME;
        L15:
            return CLOSE;
        L17:
            return SUCCESS;
        L19:
            return OPENING;
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
        ProtoAdapter_GetWebSocketStatusResponse r100 = new ProtoAdapter_GetWebSocketStatusResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS = Status.OPENING;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status = this.status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetWebSocketStatusResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetWebSocketStatusResponse(Status r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetWebSocketStatusResponse(Status r100, ByteString r101) {
        super(ADAPTER, r101);
        this.status = r100;
    }
}
