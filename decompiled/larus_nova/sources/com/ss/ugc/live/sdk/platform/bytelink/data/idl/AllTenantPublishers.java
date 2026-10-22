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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class AllTenantPublishers extends AndroidMessage<AllTenantPublishers, Builder> {
    public static final ProtoAdapter<AllTenantPublishers> ADAPTER = null;
    public static final Parcelable.Creator<AllTenantPublishers> CREATOR = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.TenantPublishers#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, TenantPublishers> tenant_publishers_map;

    public static final class Builder extends Message.Builder<AllTenantPublishers, Builder> {
        public Map<String, TenantPublishers> tenant_publishers_map;

        @Override // com.squareup.wire.Message.Builder
        public AllTenantPublishers build() {
            return new AllTenantPublishers(this.tenant_publishers_map, super.buildUnknownFields());
        }

        public Builder() {
            this.tenant_publishers_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder tenant_publishers_map(Map<String, TenantPublishers> r100) {
            Internal.checkElementsNotNull(r100);
            this.tenant_publishers_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AllTenantPublishers extends ProtoAdapter<AllTenantPublishers> {
        private final ProtoAdapter<Map<String, TenantPublishers>> tenant_publishers_map;

        public ProtoAdapter_AllTenantPublishers() {
            super(FieldEncoding.LENGTH_DELIMITED, AllTenantPublishers.class);
            this.tenant_publishers_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, TenantPublishers.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AllTenantPublishers decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.tenant_publishers_map.putAll(this.tenant_publishers_map.decode(r100));
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
        public int encodedSize2(AllTenantPublishers r100) {
            return this.tenant_publishers_map.encodedSizeWithTag(1, r100.tenant_publishers_map) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public AllTenantPublishers redact2(AllTenantPublishers r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.tenant_publishers_map, TenantPublishers.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AllTenantPublishers decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AllTenantPublishers r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AllTenantPublishers redact(AllTenantPublishers r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AllTenantPublishers r101) throws IOException {
            this.tenant_publishers_map.encodeWithTag(r100, 1, r101.tenant_publishers_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AllTenantPublishers r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_AllTenantPublishers r100 = new ProtoAdapter_AllTenantPublishers();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this.tenant_publishers_map.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tenant_publishers_map = Internal.copyOf("tenant_publishers_map", this.tenant_publishers_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        Map<String, TenantPublishers> r101 = this.tenant_publishers_map;
        if (r101 != null) goto L5;
    L7:
        StringBuilder r102 = r100.replace(0, 2, "AllTenantPublishers{");
        r102.append('}');
        return r102.toString();
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.append(", tenant_publishers_map=");
        r100.append(this.tenant_publishers_map);
        goto L7
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AllTenantPublishers(Map<String, TenantPublishers> r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AllTenantPublishers) == true) goto L8;
        return false;
    L8:
        AllTenantPublishers r101 = (AllTenantPublishers) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.tenant_publishers_map.equals(r101.tenant_publishers_map) == false) goto L13;
        return true;
    }

    public AllTenantPublishers(Map<String, TenantPublishers> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.tenant_publishers_map = Internal.immutableCopyOf("tenant_publishers_map", r100);
    }
}
