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
public final class CreateSpeakerInfoRequest extends Message<CreateSpeakerInfoRequest, Builder> {
    public static final ProtoAdapter<CreateSpeakerInfoRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_OPERATOR_ID = "";
    private static final long serialVersionUID = 0;
    public final String mmeeting_id;
    public final String mname;
    public final String moperator_id;

    public static final class Builder extends Message.Builder<CreateSpeakerInfoRequest, Builder> {
        public String mmeeting_id;
        public String mname;
        public String moperator_id;

        @Override // com.squareup.wire.Message.Builder
        public CreateSpeakerInfoRequest build() {
            String r100 = this.moperator_id;
            if (r100 == null) goto L9;
            if (this.mmeeting_id == null) goto L9;
            return new CreateSpeakerInfoRequest(this.moperator_id, this.mmeeting_id, this.mname, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "moperator_id", this.mmeeting_id, "mmeeting_id"});
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

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder operator_id(String r100) {
            this.moperator_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateSpeakerInfoRequest extends ProtoAdapter<CreateSpeakerInfoRequest> {
        public ProtoAdapter_CreateSpeakerInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateSpeakerInfoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateSpeakerInfoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.moperator_id = "";
            r101.mmeeting_id = "";
            r101.mname = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.moperator_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mname = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CreateSpeakerInfoRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.moperator_id) + r101.encodedSizeWithTag(2, r100.mmeeting_id);
            String r103 = r100.mname;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateSpeakerInfoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateSpeakerInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateSpeakerInfoRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.moperator_id);
            r102.encodeWithTag(r100, 2, r101.mmeeting_id);
            String r103 = r101.mname;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateSpeakerInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CreateSpeakerInfoRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.moperator_id = this.moperator_id;
        r100.mmeeting_id = this.mmeeting_id;
        r100.mname = this.mname;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateSpeakerInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateSpeakerInfoRequest(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CreateSpeakerInfoRequest(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.moperator_id = r100;
        this.mmeeting_id = r101;
        this.mname = r102;
    }
}
