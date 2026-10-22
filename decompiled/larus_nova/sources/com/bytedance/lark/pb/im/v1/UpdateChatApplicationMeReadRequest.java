package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateChatApplicationMeReadRequest extends Message<UpdateChatApplicationMeReadRequest, Builder> {
    public static final ProtoAdapter<UpdateChatApplicationMeReadRequest> ADAPTER = null;
    public static final Boolean DEFAULT_READ_ALL_APPLICATIONS = null;
    public static final ProtoAdapter_UpdateChatApplicationMeReadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> application_ids;
    public final Boolean read_all_applications;

    public static final class Builder extends Message.Builder<UpdateChatApplicationMeReadRequest, Builder> implements d<UpdateChatApplicationMeReadRequest> {
        public List<String> application_ids;
        public Boolean read_all_applications;

        @Override // com.squareup.wire.Message.Builder
        public UpdateChatApplicationMeReadRequest build() {
            return new UpdateChatApplicationMeReadRequest(this.application_ids, this.read_all_applications, super.buildUnknownFields());
        }

        public Builder() {
            this.application_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder application_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.application_ids = r100;
            return this;
        }

        public Builder read_all_applications(Boolean r100) {
            this.read_all_applications = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateChatApplicationMeReadRequest extends ProtoAdapter<UpdateChatApplicationMeReadRequest> implements c<UpdateChatApplicationMeReadRequest> {
        public ProtoAdapter_UpdateChatApplicationMeReadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateChatApplicationMeReadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateChatApplicationMeReadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.read_all_applications = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.application_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.read_all_applications = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(UpdateChatApplicationMeReadRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.application_ids);
            Boolean r102 = r100.read_all_applications;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateChatApplicationMeReadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateChatApplicationMeReadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateChatApplicationMeReadRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.application_ids);
            Boolean r102 = r101.read_all_applications;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateChatApplicationMeReadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateChatApplicationMeReadRequest r100 = new ProtoAdapter_UpdateChatApplicationMeReadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_READ_ALL_APPLICATIONS = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.application_ids = Internal.copyOf("application_ids", this.application_ids);
        r100.read_all_applications = this.read_all_applications;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateChatApplicationMeReadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateChatApplicationMeReadRequest(List<String> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UpdateChatApplicationMeReadRequest(List<String> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.application_ids = Internal.immutableCopyOf("application_ids", r100);
        this.read_all_applications = r101;
    }
}
