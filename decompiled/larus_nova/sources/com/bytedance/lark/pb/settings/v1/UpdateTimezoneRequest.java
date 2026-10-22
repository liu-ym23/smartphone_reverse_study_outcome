package com.bytedance.lark.pb.settings.v1;

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
public final class UpdateTimezoneRequest extends Message<UpdateTimezoneRequest, Builder> {
    public static final ProtoAdapter<UpdateTimezoneRequest> ADAPTER = null;
    public static final String DEFAULT_TIMEZONE = "";
    public static final ProtoAdapter_UpdateTimezoneRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String timezone;

    public static final class Builder extends Message.Builder<UpdateTimezoneRequest, Builder> implements d<UpdateTimezoneRequest> {
        public String timezone;

        @Override // com.squareup.wire.Message.Builder
        public UpdateTimezoneRequest build() {
            String r100 = this.timezone;
            if (r100 == null) goto L7;
            return new UpdateTimezoneRequest(this.timezone, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "timezone"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder timezone(String r100) {
            this.timezone = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTimezoneRequest extends ProtoAdapter<UpdateTimezoneRequest> implements c<UpdateTimezoneRequest> {
        public ProtoAdapter_UpdateTimezoneRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTimezoneRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateTimezoneRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.timezone = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.timezone = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UpdateTimezoneRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.timezone) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateTimezoneRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateTimezoneRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateTimezoneRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.timezone);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateTimezoneRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateTimezoneRequest r100 = new ProtoAdapter_UpdateTimezoneRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.timezone = this.timezone;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateTimezoneRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateTimezoneRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public UpdateTimezoneRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.timezone = r100;
    }
}
