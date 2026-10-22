package com.ss.android.lark.pb.feed;

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
public final class AppFeedCardButtonCallbackResponse extends Message<AppFeedCardButtonCallbackResponse, Builder> {
    public static final ProtoAdapter<AppFeedCardButtonCallbackResponse> ADAPTER = null;
    public static final String DEFAULT_TOAST = "";
    private static final long serialVersionUID = 0;
    public final StatusCode mstatus;
    public final String mtoast;

    public static final class Builder extends Message.Builder<AppFeedCardButtonCallbackResponse, Builder> {
        public StatusCode mstatus;
        public String mtoast;

        @Override // com.squareup.wire.Message.Builder
        public AppFeedCardButtonCallbackResponse build() {
            StatusCode r100 = this.mstatus;
            if (r100 == null) goto L7;
            return new AppFeedCardButtonCallbackResponse(this.mstatus, this.mtoast, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mstatus"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder status(StatusCode r100) {
            this.mstatus = r100;
            return this;
        }

        public Builder toast(String r100) {
            this.mtoast = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AppFeedCardButtonCallbackResponse extends ProtoAdapter<AppFeedCardButtonCallbackResponse> {
        public ProtoAdapter_AppFeedCardButtonCallbackResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, AppFeedCardButtonCallbackResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppFeedCardButtonCallbackResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtoast = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mstatus = StatusCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mtoast = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AppFeedCardButtonCallbackResponse r100) {
            int r101 = StatusCode.ADAPTER.encodedSizeWithTag(1, r100.mstatus);
            String r102 = r100.mtoast;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AppFeedCardButtonCallbackResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppFeedCardButtonCallbackResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppFeedCardButtonCallbackResponse r101) throws IOException {
            StatusCode.ADAPTER.encodeWithTag(r100, 1, r101.mstatus);
            String r102 = r101.mtoast;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppFeedCardButtonCallbackResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum StatusCode extends Enum<StatusCode> implements WireEnum {
        private static final /* synthetic */ StatusCode[] $VALUES = null;
        public static final ProtoAdapter<StatusCode> ADAPTER = null;
        public static final StatusCode FAIL = null;
        public static final StatusCode SUCCESS = null;
        private final int value;

        static {
            StatusCode r100 = new StatusCode("SUCCESS", 0, 0);
            SUCCESS = r100;
            StatusCode r101 = new StatusCode("FAIL", 1, 1);
            FAIL = r101;
            $VALUES = new StatusCode[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(StatusCode.class);
        }

        public static StatusCode[] values() {
            return (StatusCode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static StatusCode fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return FAIL;
        L10:
            return SUCCESS;
        }

        public static StatusCode valueOf(String r100) {
            return (StatusCode) a.a(StatusCode.class, r100);
        }

        private StatusCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppFeedCardButtonCallbackResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstatus = this.mstatus;
        r100.mtoast = this.mtoast;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppFeedCardButtonCallbackResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppFeedCardButtonCallbackResponse(StatusCode r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public AppFeedCardButtonCallbackResponse(StatusCode r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mstatus = r100;
        this.mtoast = r101;
    }
}
