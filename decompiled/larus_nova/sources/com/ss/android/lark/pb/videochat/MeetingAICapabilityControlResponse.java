package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MeetingAICapabilityControlResponse extends Message<MeetingAICapabilityControlResponse, Builder> {
    public static final ProtoAdapter<MeetingAICapabilityControlResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MeetingAIQuickActions mmeeting_ai_quick_action;

    public static final class Builder extends Message.Builder<MeetingAICapabilityControlResponse, Builder> {
        public MeetingAIQuickActions mmeeting_ai_quick_action;

        @Override // com.squareup.wire.Message.Builder
        public MeetingAICapabilityControlResponse build() {
            return new MeetingAICapabilityControlResponse(this.mmeeting_ai_quick_action, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder meeting_ai_quick_action(MeetingAIQuickActions r100) {
            this.mmeeting_ai_quick_action = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAICapabilityControlResponse extends ProtoAdapter<MeetingAICapabilityControlResponse> {
        public ProtoAdapter_MeetingAICapabilityControlResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAICapabilityControlResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingAICapabilityControlResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mmeeting_ai_quick_action = MeetingAIQuickActions.ADAPTER.decode(r100);
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
        public int encodedSize2(MeetingAICapabilityControlResponse r100) {
            MeetingAIQuickActions r101 = r100.mmeeting_ai_quick_action;
            if (r101 == null) goto L5;
            int r102 = MeetingAIQuickActions.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MeetingAICapabilityControlResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingAICapabilityControlResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingAICapabilityControlResponse r101) throws IOException {
            MeetingAIQuickActions r102 = r101.mmeeting_ai_quick_action;
            if (r102 == null) goto L5;
            MeetingAIQuickActions.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingAICapabilityControlResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAICapabilityControlResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeeting_ai_quick_action = this.mmeeting_ai_quick_action;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingAICapabilityControlResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingAICapabilityControlResponse(MeetingAIQuickActions r100) {
        this(r100, ByteString.EMPTY);
    }

    public MeetingAICapabilityControlResponse(MeetingAIQuickActions r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mmeeting_ai_quick_action = r100;
    }
}
