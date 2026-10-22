package com.bytedance.lark.pb.security.v1;

import annotation.OptionsExt;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.protobuf.MessageOptions;
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
public final class GetDeviceApplySwitchResponse extends Message<GetDeviceApplySwitchResponse, Builder> {
    public static final ProtoAdapter<GetDeviceApplySwitchResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_ENABLE = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_GetDeviceApplySwitchResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_enable;

    public static final class Builder extends Message.Builder<GetDeviceApplySwitchResponse, Builder> implements d<GetDeviceApplySwitchResponse> {
        public Boolean is_enable;

        @Override // com.squareup.wire.Message.Builder
        public GetDeviceApplySwitchResponse build() {
            Boolean r100 = this.is_enable;
            if (r100 == null) goto L7;
            return new GetDeviceApplySwitchResponse(this.is_enable, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, MapMonitorConst.IS_ENABLE});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_enable(Boolean r100) {
            this.is_enable = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDeviceApplySwitchResponse extends ProtoAdapter<GetDeviceApplySwitchResponse> implements c<GetDeviceApplySwitchResponse> {
        public ProtoAdapter_GetDeviceApplySwitchResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDeviceApplySwitchResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDeviceApplySwitchResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_enable = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.is_enable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetDeviceApplySwitchResponse r100) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.is_enable) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDeviceApplySwitchResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDeviceApplySwitchResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDeviceApplySwitchResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.is_enable);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDeviceApplySwitchResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDeviceApplySwitchResponse r100 = new ProtoAdapter_GetDeviceApplySwitchResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
        DEFAULT_IS_ENABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_enable = this.is_enable;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDeviceApplySwitchResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDeviceApplySwitchResponse(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetDeviceApplySwitchResponse(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.is_enable = r100;
    }
}
