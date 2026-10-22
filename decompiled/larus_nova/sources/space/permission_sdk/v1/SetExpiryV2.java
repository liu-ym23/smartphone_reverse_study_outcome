package space.permission_sdk.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class SetExpiryV2 extends Message<SetExpiryV2, Builder> {
    public static final ProtoAdapter<SetExpiryV2> ADAPTER = null;
    public static final Boolean DEFAULT_EXPIRABLE = null;
    public static final FieldOptions FIELD_OPTIONS_EXPIRABLE = null;
    public static final FieldOptions FIELD_OPTIONS_VAL_REQ = null;
    private static final long serialVersionUID = 0;
    public final Boolean expirable;
    public final PermissionValidateRequest val_req;

    public static final class Builder extends Message.Builder<SetExpiryV2, Builder> {
        public Boolean expirable;
        public PermissionValidateRequest val_req;

        @Override // com.squareup.wire.Message.Builder
        public SetExpiryV2 build() {
            PermissionValidateRequest r100 = this.val_req;
            if (r100 == null) goto L9;
            if (this.expirable == null) goto L9;
            return new SetExpiryV2(this.val_req, this.expirable, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "val_req", this.expirable, "expirable"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder expirable(Boolean r100) {
            this.expirable = r100;
            return this;
        }

        public Builder val_req(PermissionValidateRequest r100) {
            this.val_req = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetExpiryV2 extends ProtoAdapter<SetExpiryV2> {
        public ProtoAdapter_SetExpiryV2() {
            super(FieldEncoding.LENGTH_DELIMITED, SetExpiryV2.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public SetExpiryV2 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.expirable = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.val_req = PermissionValidateRequest.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.expirable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetExpiryV2 r100) {
            return (PermissionValidateRequest.ADAPTER.encodedSizeWithTag(1, r100.val_req) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.expirable)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetExpiryV2 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetExpiryV2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetExpiryV2 r101) throws IOException {
            PermissionValidateRequest.ADAPTER.encodeWithTag(r100, 1, r101.val_req);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.expirable);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetExpiryV2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SetExpiryV2();
        FIELD_OPTIONS_VAL_REQ = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_EXPIRABLE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_EXPIRABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.val_req = this.val_req;
        r100.expirable = this.expirable;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetExpiryV2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetExpiryV2(PermissionValidateRequest r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SetExpiryV2(PermissionValidateRequest r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.val_req = r100;
        this.expirable = r101;
    }
}
