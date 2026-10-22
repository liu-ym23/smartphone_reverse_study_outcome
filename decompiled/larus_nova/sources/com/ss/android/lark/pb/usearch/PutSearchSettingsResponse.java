package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class PutSearchSettingsResponse extends Message<PutSearchSettingsResponse, Builder> {
    public static final ProtoAdapter<PutSearchSettingsResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Status mstatus;

    public static final class Builder extends Message.Builder<PutSearchSettingsResponse, Builder> {
        public Status mstatus;

        @Override // com.squareup.wire.Message.Builder
        public PutSearchSettingsResponse build() {
            return new PutSearchSettingsResponse(this.mstatus, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder status(Status r100) {
            this.mstatus = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutSearchSettingsResponse extends ProtoAdapter<PutSearchSettingsResponse> {
        public ProtoAdapter_PutSearchSettingsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutSearchSettingsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutSearchSettingsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.mstatus = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(PutSearchSettingsResponse r100) {
            Status r101 = r100.mstatus;
            if (r101 == null) goto L5;
            int r102 = Status.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutSearchSettingsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutSearchSettingsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutSearchSettingsResponse r101) throws IOException {
            Status r102 = r101.mstatus;
            if (r102 == null) goto L5;
            Status.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutSearchSettingsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status DEFAULT = null;
        public static final Status FAIL = null;
        public static final Status SUCCESS = null;
        private final int value;

        static {
            Status r100 = new Status("DEFAULT", 0, 0);
            DEFAULT = r100;
            Status r101 = new Status("SUCCESS", 1, 1);
            SUCCESS = r101;
            Status r102 = new Status("FAIL", 2, 2);
            FAIL = r102;
            $VALUES = new Status[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return FAIL;
        L12:
            return SUCCESS;
        L14:
            return DEFAULT;
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
        ADAPTER = new ProtoAdapter_PutSearchSettingsResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstatus = this.mstatus;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutSearchSettingsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutSearchSettingsResponse(Status r100) {
        this(r100, ByteString.EMPTY);
    }

    public PutSearchSettingsResponse(Status r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mstatus = r100;
    }
}
