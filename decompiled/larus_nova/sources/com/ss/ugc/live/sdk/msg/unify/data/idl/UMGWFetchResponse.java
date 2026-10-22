package com.ss.ugc.live.sdk.msg.unify.data.idl;

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
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class UMGWFetchResponse extends AndroidMessage<UMGWFetchResponse, Builder> {
    public static final ProtoAdapter<UMGWFetchResponse> ADAPTER = null;
    public static final Parcelable.Creator<UMGWFetchResponse> CREATOR = null;
    public static final String DEFAULT_UMGW_GLOBAL_EXT = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWDownlinkPacket#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<UMGWDownlinkPacket> business_data;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWConnectionInfo#ADAPTER", tag = 2)
    public final UMGWConnectionInfo connection_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String umgw_global_ext;

    public static final class Builder extends Message.Builder<UMGWFetchResponse, Builder> {
        public List<UMGWDownlinkPacket> business_data;
        public UMGWConnectionInfo connection_info;
        public String umgw_global_ext;

        @Override // com.squareup.wire.Message.Builder
        public UMGWFetchResponse build() {
            return new UMGWFetchResponse(this.business_data, this.connection_info, this.umgw_global_ext, super.buildUnknownFields());
        }

        public Builder() {
            this.umgw_global_ext = "";
            this.business_data = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder business_data(List<UMGWDownlinkPacket> r100) {
            Internal.checkElementsNotNull(r100);
            this.business_data = r100;
            return this;
        }

        public Builder connection_info(UMGWConnectionInfo r100) {
            this.connection_info = r100;
            return this;
        }

        public Builder umgw_global_ext(String r100) {
            this.umgw_global_ext = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWFetchResponse extends ProtoAdapter<UMGWFetchResponse> {
        public ProtoAdapter_UMGWFetchResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWFetchResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UMGWFetchResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.business_data.add(UMGWDownlinkPacket.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.connection_info(UMGWConnectionInfo.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.umgw_global_ext(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UMGWFetchResponse r100) {
            return ((UMGWDownlinkPacket.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.business_data) + UMGWConnectionInfo.ADAPTER.encodedSizeWithTag(2, r100.connection_info)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.umgw_global_ext)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public UMGWFetchResponse redact2(UMGWFetchResponse r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.business_data, UMGWDownlinkPacket.ADAPTER);
            UMGWConnectionInfo r102 = r101.connection_info;
            if (r102 == null) goto L5;
            r101.connection_info = UMGWConnectionInfo.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWFetchResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UMGWFetchResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWFetchResponse redact(UMGWFetchResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UMGWFetchResponse r101) throws IOException {
            UMGWDownlinkPacket.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.business_data);
            UMGWConnectionInfo.ADAPTER.encodeWithTag(r100, 2, r101.connection_info);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.umgw_global_ext);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UMGWFetchResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UMGWFetchResponse r100 = new ProtoAdapter_UMGWFetchResponse();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L13;
        int r101 = ((unknownFields().hashCode() * 37) + this.business_data.hashCode()) * 37;
        UMGWConnectionInfo r102 = this.connection_info;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.umgw_global_ext;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        int r107 = r105 + r103;
        this.hashCode = r107;
        return r107;
    L7:
        r104 = 0;
        goto L8
    L13:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.business_data = Internal.copyOf("business_data", this.business_data);
        r100.connection_info = this.connection_info;
        r100.umgw_global_ext = this.umgw_global_ext;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        List<UMGWDownlinkPacket> r101 = this.business_data;
        if (r101 == null) goto L8;
        if (r101.isEmpty() == true) goto L8;
        r100.append(", business_data=");
        r100.append(this.business_data);
    L8:
        if (this.connection_info == null) goto L11;
        r100.append(", connection_info=");
        r100.append(this.connection_info);
    L11:
        if (this.umgw_global_ext == null) goto L13;
        r100.append(", umgw_global_ext=");
        r100.append(this.umgw_global_ext);
    L13:
        StringBuilder r102 = r100.replace(0, 2, "UMGWFetchResponse{");
        r102.append('}');
        return r102.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof UMGWFetchResponse) == true) goto L8;
        return false;
    L8:
        UMGWFetchResponse r101 = (UMGWFetchResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (this.business_data.equals(r101.business_data) == false) goto L17;
        if (Internal.equals(this.connection_info, r101.connection_info) == false) goto L17;
        if (Internal.equals(this.umgw_global_ext, r101.umgw_global_ext) == false) goto L17;
        return true;
    }

    public UMGWFetchResponse(List<UMGWDownlinkPacket> r100, UMGWConnectionInfo r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UMGWFetchResponse(List<UMGWDownlinkPacket> r100, UMGWConnectionInfo r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.business_data = Internal.immutableCopyOf("business_data", r100);
        this.connection_info = r101;
        this.umgw_global_ext = r102;
    }
}
