package com.ss.android.lark.pb.chatters;

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

/* JADX INFO: loaded from: classes37.dex */
public final class PutResetUserAvatarResultRequest extends Message<PutResetUserAvatarResultRequest, Builder> {
    public static final ProtoAdapter<PutResetUserAvatarResultRequest> ADAPTER = null;
    public static final String DEFAULT_RESET_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final String mreset_token;
    public final Status mstatus;

    public static final class Builder extends Message.Builder<PutResetUserAvatarResultRequest, Builder> {
        public String mreset_token;
        public Status mstatus;

        @Override // com.squareup.wire.Message.Builder
        public PutResetUserAvatarResultRequest build() {
            String r100 = this.mreset_token;
            if (r100 == null) goto L9;
            if (this.mstatus == null) goto L9;
            return new PutResetUserAvatarResultRequest(this.mreset_token, this.mstatus, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mreset_token", this.mstatus, "mstatus"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder reset_token(String r100) {
            this.mreset_token = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.mstatus = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutResetUserAvatarResultRequest extends ProtoAdapter<PutResetUserAvatarResultRequest> {
        public ProtoAdapter_PutResetUserAvatarResultRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutResetUserAvatarResultRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutResetUserAvatarResultRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mreset_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mreset_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mstatus = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PutResetUserAvatarResultRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mreset_token) + Status.ADAPTER.encodedSizeWithTag(2, r100.mstatus)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutResetUserAvatarResultRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutResetUserAvatarResultRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutResetUserAvatarResultRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mreset_token);
            Status.ADAPTER.encodeWithTag(r100, 2, r101.mstatus);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutResetUserAvatarResultRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ABORT = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status RESET = null;
        private final int value;

        static {
            Status r100 = new Status("RESET", 0, 1);
            RESET = r100;
            Status r101 = new Status("ABORT", 1, 2);
            ABORT = r101;
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
            return ABORT;
        L11:
            return RESET;
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
        ADAPTER = new ProtoAdapter_PutResetUserAvatarResultRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mreset_token = this.mreset_token;
        r100.mstatus = this.mstatus;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutResetUserAvatarResultRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutResetUserAvatarResultRequest(String r100, Status r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PutResetUserAvatarResultRequest(String r100, Status r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mreset_token = r100;
        this.mstatus = r101;
    }
}
