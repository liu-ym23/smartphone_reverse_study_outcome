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
public final class UMGWFetchRequest extends AndroidMessage<UMGWFetchRequest, Builder> {
    public static final ProtoAdapter<UMGWFetchRequest> ADAPTER = null;
    public static final Parcelable.Creator<UMGWFetchRequest> CREATOR = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWEventData#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<UMGWEventData> event_data;

    public static final class Builder extends Message.Builder<UMGWFetchRequest, Builder> {
        public List<UMGWEventData> event_data;

        @Override // com.squareup.wire.Message.Builder
        public UMGWFetchRequest build() {
            return new UMGWFetchRequest(this.event_data, super.buildUnknownFields());
        }

        public Builder() {
            this.event_data = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder event_data(List<UMGWEventData> r100) {
            Internal.checkElementsNotNull(r100);
            this.event_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWFetchRequest extends ProtoAdapter<UMGWFetchRequest> {
        public ProtoAdapter_UMGWFetchRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWFetchRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UMGWFetchRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.event_data.add(UMGWEventData.ADAPTER.decode(r100));
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
        public int encodedSize2(UMGWFetchRequest r100) {
            return UMGWEventData.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.event_data) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public UMGWFetchRequest redact2(UMGWFetchRequest r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.event_data, UMGWEventData.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWFetchRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UMGWFetchRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UMGWFetchRequest redact(UMGWFetchRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UMGWFetchRequest r101) throws IOException {
            UMGWEventData.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.event_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UMGWFetchRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UMGWFetchRequest r100 = new ProtoAdapter_UMGWFetchRequest();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this.event_data.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.event_data = Internal.copyOf("event_data", this.event_data);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        List<UMGWEventData> r101 = this.event_data;
        if (r101 != null) goto L5;
    L7:
        StringBuilder r102 = r100.replace(0, 2, "UMGWFetchRequest{");
        r102.append('}');
        return r102.toString();
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.append(", event_data=");
        r100.append(this.event_data);
        goto L7
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UMGWFetchRequest(List<UMGWEventData> r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof UMGWFetchRequest) == true) goto L8;
        return false;
    L8:
        UMGWFetchRequest r101 = (UMGWFetchRequest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.event_data.equals(r101.event_data) == false) goto L13;
        return true;
    }

    public UMGWFetchRequest(List<UMGWEventData> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.event_data = Internal.immutableCopyOf("event_data", r100);
    }
}
