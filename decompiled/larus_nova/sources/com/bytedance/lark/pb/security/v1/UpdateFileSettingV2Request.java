package com.bytedance.lark.pb.security.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateFileSettingV2Request extends Message<UpdateFileSettingV2Request, Builder> {
    public static final ProtoAdapter<UpdateFileSettingV2Request> ADAPTER = null;
    public static final Boolean DEFAULT_DOWNGRADE = null;
    public static final ProtoAdapter_UpdateFileSettingV2Request RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean downgrade;

    public static final class Builder extends Message.Builder<UpdateFileSettingV2Request, Builder> implements d<UpdateFileSettingV2Request> {
        public Boolean downgrade;

        @Override // com.squareup.wire.Message.Builder
        public UpdateFileSettingV2Request build() {
            return new UpdateFileSettingV2Request(this.downgrade, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder downgrade(Boolean r100) {
            this.downgrade = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateFileSettingV2Request extends ProtoAdapter<UpdateFileSettingV2Request> implements c<UpdateFileSettingV2Request> {
        public ProtoAdapter_UpdateFileSettingV2Request() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateFileSettingV2Request.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateFileSettingV2Request decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.downgrade = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.downgrade = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(UpdateFileSettingV2Request r100) {
            Boolean r101 = r100.downgrade;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateFileSettingV2Request decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateFileSettingV2Request r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateFileSettingV2Request r101) throws IOException {
            Boolean r102 = r101.downgrade;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateFileSettingV2Request r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateFileSettingV2Request r100 = new ProtoAdapter_UpdateFileSettingV2Request();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DOWNGRADE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.downgrade = this.downgrade;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateFileSettingV2Request.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateFileSettingV2Request(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public UpdateFileSettingV2Request(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.downgrade = r100;
    }
}
