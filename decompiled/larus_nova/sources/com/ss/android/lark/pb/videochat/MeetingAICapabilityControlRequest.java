package com.ss.android.lark.pb.videochat;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MeetingAICapabilityControlRequest extends Message<MeetingAICapabilityControlRequest, Builder> {
    public static final ProtoAdapter<MeetingAICapabilityControlRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MMEETING_ID = null;
    private static final long serialVersionUID = 0;
    public final AICapabilityPermData mai_capability_perm_data;
    public final String mmeeting_id;

    public static final class Builder extends Message.Builder<MeetingAICapabilityControlRequest, Builder> {
        public AICapabilityPermData mai_capability_perm_data;
        public String mmeeting_id;

        @Override // com.squareup.wire.Message.Builder
        public MeetingAICapabilityControlRequest build() {
            return new MeetingAICapabilityControlRequest(this.mmeeting_id, this.mai_capability_perm_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_capability_perm_data(AICapabilityPermData r100) {
            this.mai_capability_perm_data = r100;
            return this;
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAICapabilityControlRequest extends ProtoAdapter<MeetingAICapabilityControlRequest> {
        public ProtoAdapter_MeetingAICapabilityControlRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAICapabilityControlRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingAICapabilityControlRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmeeting_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mai_capability_perm_data = AICapabilityPermData.ADAPTER.decode(r100);
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
        public int encodedSize2(MeetingAICapabilityControlRequest r100) {
            String r101 = r100.mmeeting_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            AICapabilityPermData r104 = r100.mai_capability_perm_data;
            if (r104 == null) goto L10;
            r102 = AICapabilityPermData.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MeetingAICapabilityControlRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingAICapabilityControlRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingAICapabilityControlRequest r101) throws IOException {
            String r102 = r101.mmeeting_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            AICapabilityPermData r103 = r101.mai_capability_perm_data;
            if (r103 == null) goto L8;
            AICapabilityPermData.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingAICapabilityControlRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAICapabilityControlRequest();
        FIELD_OPTIONS_MMEETING_ID = new FieldOptions.Builder().FieldInfo("split,type=meeting").build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeeting_id = this.mmeeting_id;
        r100.mai_capability_perm_data = this.mai_capability_perm_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingAICapabilityControlRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingAICapabilityControlRequest(String r100, AICapabilityPermData r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MeetingAICapabilityControlRequest(String r100, AICapabilityPermData r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mmeeting_id = r100;
        this.mai_capability_perm_data = r101;
    }
}
