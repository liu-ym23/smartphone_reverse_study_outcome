package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class GetSpeakerInfoListRequest extends Message<GetSpeakerInfoListRequest, Builder> {
    public static final ProtoAdapter<GetSpeakerInfoListRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_OPERATOR_ID = "";
    public static final String DEFAULT_QUERY_CONDITION = "";
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mmeeting_id;
    public final String moperator_id;
    public final String mquery_condition;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<GetSpeakerInfoListRequest, Builder> {
        public String mmeeting_id;
        public String moperator_id;
        public String mquery_condition;
        public String mtenant_id;

        @Override // com.squareup.wire.Message.Builder
        public GetSpeakerInfoListRequest build() {
            String r100 = this.moperator_id;
            if (r100 == null) goto L11;
            if (this.mtenant_id == null) goto L11;
            if (this.mmeeting_id == null) goto L11;
            return new GetSpeakerInfoListRequest(this.moperator_id, this.mtenant_id, this.mmeeting_id, this.mquery_condition, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "moperator_id", this.mtenant_id, "mtenant_id", this.mmeeting_id, "mmeeting_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder operator_id(String r100) {
            this.moperator_id = r100;
            return this;
        }

        public Builder query_condition(String r100) {
            this.mquery_condition = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.mtenant_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeakerInfoListRequest extends ProtoAdapter<GetSpeakerInfoListRequest> {
        public ProtoAdapter_GetSpeakerInfoListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeakerInfoListRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSpeakerInfoListRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.moperator_id = "";
            r101.mtenant_id = "";
            r101.mmeeting_id = "";
            r101.mquery_condition = "";
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
            r101.mquery_condition = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetSpeakerInfoListRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.moperator_id) + r101.encodedSizeWithTag(2, r100.mtenant_id)) + r101.encodedSizeWithTag(3, r100.mmeeting_id);
            String r103 = r100.mquery_condition;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(4, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSpeakerInfoListRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSpeakerInfoListRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSpeakerInfoListRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.moperator_id);
            r102.encodeWithTag(r100, 2, r101.mtenant_id);
            r102.encodeWithTag(r100, 3, r101.mmeeting_id);
            String r103 = r101.mquery_condition;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSpeakerInfoListRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeakerInfoListRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.moperator_id = this.moperator_id;
        r100.mtenant_id = this.mtenant_id;
        r100.mmeeting_id = this.mmeeting_id;
        r100.mquery_condition = this.mquery_condition;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSpeakerInfoListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSpeakerInfoListRequest(String r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetSpeakerInfoListRequest(String r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.moperator_id = r100;
        this.mtenant_id = r101;
        this.mmeeting_id = r102;
        this.mquery_condition = r103;
    }
}
