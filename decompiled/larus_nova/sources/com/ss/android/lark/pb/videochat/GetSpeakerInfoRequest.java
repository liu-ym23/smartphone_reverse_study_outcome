package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class GetSpeakerInfoRequest extends Message<GetSpeakerInfoRequest, Builder> {
    public static final ProtoAdapter<GetSpeakerInfoRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_OPERATOR_ID = "";
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final List<String> mcluster_id_list;
    public final String mmeeting_id;
    public final String moperator_id;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<GetSpeakerInfoRequest, Builder> {
        public List<String> mcluster_id_list;
        public String mmeeting_id;
        public String moperator_id;
        public String mtenant_id;

        @Override // com.squareup.wire.Message.Builder
        public GetSpeakerInfoRequest build() {
            String r100 = this.moperator_id;
            if (r100 == null) goto L11;
            if (this.mtenant_id == null) goto L11;
            if (this.mmeeting_id == null) goto L11;
            return new GetSpeakerInfoRequest(this.moperator_id, this.mtenant_id, this.mmeeting_id, this.mcluster_id_list, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "moperator_id", this.mtenant_id, "mtenant_id", this.mmeeting_id, "mmeeting_id"});
        }

        public Builder() {
            this.mcluster_id_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cluster_id_list(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mcluster_id_list = r100;
            return this;
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder operator_id(String r100) {
            this.moperator_id = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.mtenant_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeakerInfoRequest extends ProtoAdapter<GetSpeakerInfoRequest> {
        public ProtoAdapter_GetSpeakerInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeakerInfoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSpeakerInfoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.moperator_id = "";
            r101.mtenant_id = "";
            r101.mmeeting_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.moperator_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mcluster_id_list.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GetSpeakerInfoRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.moperator_id) + r101.encodedSizeWithTag(2, r100.mtenant_id)) + r101.encodedSizeWithTag(3, r100.mmeeting_id)) + r101.asRepeated().encodedSizeWithTag(4, r100.mcluster_id_list)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSpeakerInfoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSpeakerInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSpeakerInfoRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.moperator_id);
            r102.encodeWithTag(r100, 2, r101.mtenant_id);
            r102.encodeWithTag(r100, 3, r101.mmeeting_id);
            r102.asRepeated().encodeWithTag(r100, 4, r101.mcluster_id_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSpeakerInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeakerInfoRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.moperator_id = this.moperator_id;
        r100.mtenant_id = this.mtenant_id;
        r100.mmeeting_id = this.mmeeting_id;
        r100.mcluster_id_list = Internal.copyOf("mcluster_id_list", this.mcluster_id_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSpeakerInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSpeakerInfoRequest(String r100, String r101, String r102, List<String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetSpeakerInfoRequest(String r100, String r101, String r102, List<String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.moperator_id = r100;
        this.mtenant_id = r101;
        this.mmeeting_id = r102;
        this.mcluster_id_list = Internal.immutableCopyOf("mcluster_id_list", r103);
    }
}
