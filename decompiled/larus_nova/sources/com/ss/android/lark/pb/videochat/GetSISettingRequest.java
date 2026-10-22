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
public final class GetSISettingRequest extends Message<GetSISettingRequest, Builder> {
    public static final ProtoAdapter<GetSISettingRequest> ADAPTER = null;
    public static final String DEFAULT_BREAKOUT_ROOM_ID = "";
    public static final String DEFAULT_MEETING_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MMEETING_ID = null;
    private static final long serialVersionUID = 0;
    public final String mbreakout_room_id;
    public final String mmeeting_id;

    public static final class Builder extends Message.Builder<GetSISettingRequest, Builder> {
        public String mbreakout_room_id;
        public String mmeeting_id;

        @Override // com.squareup.wire.Message.Builder
        public GetSISettingRequest build() {
            return new GetSISettingRequest(this.mmeeting_id, this.mbreakout_room_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder breakout_room_id(String r100) {
            this.mbreakout_room_id = r100;
            return this;
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSISettingRequest extends ProtoAdapter<GetSISettingRequest> {
        public ProtoAdapter_GetSISettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSISettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSISettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmeeting_id = "";
            r101.mbreakout_room_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mbreakout_room_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetSISettingRequest r100) {
            String r101 = r100.mmeeting_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mbreakout_room_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSISettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSISettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSISettingRequest r101) throws IOException {
            String r102 = r101.mmeeting_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mbreakout_room_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSISettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSISettingRequest();
        FIELD_OPTIONS_MMEETING_ID = new FieldOptions.Builder().FieldInfo("split,type=meeting").build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeeting_id = this.mmeeting_id;
        r100.mbreakout_room_id = this.mbreakout_room_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSISettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSISettingRequest(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetSISettingRequest(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mmeeting_id = r100;
        this.mbreakout_room_id = r101;
    }
}
