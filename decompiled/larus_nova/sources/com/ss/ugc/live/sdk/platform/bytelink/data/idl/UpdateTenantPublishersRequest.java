package com.ss.ugc.live.sdk.platform.bytelink.data.idl;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class UpdateTenantPublishersRequest extends AndroidMessage<UpdateTenantPublishersRequest, Builder> {
    public static final ProtoAdapter<UpdateTenantPublishersRequest> ADAPTER = null;
    public static final Parcelable.Creator<UpdateTenantPublishersRequest> CREATOR = null;
    public static final String DEFAULT_TRIGGER_TENANT_ID = "";
    public static final Long DEFAULT_TRIGGER_TIME_MS = null;
    public static final String DEFAULT_UPDATE_BY_OPERATION = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String trigger_tenant_id;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.TenantPublishers#ADAPTER", tag = 1)
    public final TenantPublishers trigger_tenant_publishers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long trigger_time_ms;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String update_by_operation;

    public static final class Builder extends Message.Builder<UpdateTenantPublishersRequest, Builder> {
        public String trigger_tenant_id;
        public TenantPublishers trigger_tenant_publishers;
        public Long trigger_time_ms;
        public String update_by_operation;

        @Override // com.squareup.wire.Message.Builder
        public UpdateTenantPublishersRequest build() {
            return new UpdateTenantPublishersRequest(this.trigger_tenant_publishers, this.trigger_time_ms, this.trigger_tenant_id, this.update_by_operation, super.buildUnknownFields());
        }

        public Builder() {
            this.trigger_time_ms = 0L;
            this.trigger_tenant_id = "";
            this.update_by_operation = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder trigger_tenant_id(String r100) {
            this.trigger_tenant_id = r100;
            return this;
        }

        public Builder trigger_tenant_publishers(TenantPublishers r100) {
            this.trigger_tenant_publishers = r100;
            return this;
        }

        public Builder trigger_time_ms(Long r100) {
            this.trigger_time_ms = r100;
            return this;
        }

        public Builder update_by_operation(String r100) {
            this.update_by_operation = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTenantPublishersRequest extends ProtoAdapter<UpdateTenantPublishersRequest> {
        public ProtoAdapter_UpdateTenantPublishersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTenantPublishersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateTenantPublishersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.trigger_tenant_publishers(TenantPublishers.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.trigger_time_ms(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.trigger_tenant_id(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.update_by_operation(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(UpdateTenantPublishersRequest r100) {
            int r101 = TenantPublishers.ADAPTER.encodedSizeWithTag(1, r100.trigger_tenant_publishers) + ProtoAdapter.INT64.encodedSizeWithTag(2, r100.trigger_time_ms);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return ((r101 + r102.encodedSizeWithTag(3, r100.trigger_tenant_id)) + r102.encodedSizeWithTag(4, r100.update_by_operation)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public UpdateTenantPublishersRequest redact2(UpdateTenantPublishersRequest r100) {
            Builder r101 = r100.newBuilder();
            TenantPublishers r102 = r101.trigger_tenant_publishers;
            if (r102 == null) goto L5;
            r101.trigger_tenant_publishers = TenantPublishers.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateTenantPublishersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateTenantPublishersRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateTenantPublishersRequest redact(UpdateTenantPublishersRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateTenantPublishersRequest r101) throws IOException {
            TenantPublishers.ADAPTER.encodeWithTag(r100, 1, r101.trigger_tenant_publishers);
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r101.trigger_time_ms);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 3, r101.trigger_tenant_id);
            r102.encodeWithTag(r100, 4, r101.update_by_operation);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateTenantPublishersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateTenantPublishersRequest r100 = new ProtoAdapter_UpdateTenantPublishersRequest();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_TRIGGER_TIME_MS = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L21;
        int r101 = unknownFields().hashCode() * 37;
        TenantPublishers r102 = this.trigger_tenant_publishers;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Long r106 = this.trigger_time_ms;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.trigger_tenant_id;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        String r112 = this.update_by_operation;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        int r113 = r111 + r103;
        this.hashCode = r113;
        return r113;
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L21:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.trigger_tenant_publishers = this.trigger_tenant_publishers;
        r100.trigger_time_ms = this.trigger_time_ms;
        r100.trigger_tenant_id = this.trigger_tenant_id;
        r100.update_by_operation = this.update_by_operation;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.trigger_tenant_publishers == null) goto L6;
        r100.append(", trigger_tenant_publishers=");
        r100.append(this.trigger_tenant_publishers);
    L6:
        if (this.trigger_time_ms == null) goto L9;
        r100.append(", trigger_time_ms=");
        r100.append(this.trigger_time_ms);
    L9:
        if (this.trigger_tenant_id == null) goto L12;
        r100.append(", trigger_tenant_id=");
        r100.append(this.trigger_tenant_id);
    L12:
        if (this.update_by_operation == null) goto L14;
        r100.append(", update_by_operation=");
        r100.append(this.update_by_operation);
    L14:
        StringBuilder r101 = r100.replace(0, 2, "UpdateTenantPublishersRequest{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateTenantPublishersRequest) == true) goto L8;
        return false;
    L8:
        UpdateTenantPublishersRequest r101 = (UpdateTenantPublishersRequest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.trigger_tenant_publishers, r101.trigger_tenant_publishers) == false) goto L19;
        if (Internal.equals(this.trigger_time_ms, r101.trigger_time_ms) == false) goto L19;
        if (Internal.equals(this.trigger_tenant_id, r101.trigger_tenant_id) == false) goto L19;
        if (Internal.equals(this.update_by_operation, r101.update_by_operation) == false) goto L19;
        return true;
    }

    public UpdateTenantPublishersRequest(TenantPublishers r100, Long r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UpdateTenantPublishersRequest(TenantPublishers r100, Long r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.trigger_tenant_publishers = r100;
        this.trigger_time_ms = r101;
        this.trigger_tenant_id = r102;
        this.update_by_operation = r103;
    }
}
