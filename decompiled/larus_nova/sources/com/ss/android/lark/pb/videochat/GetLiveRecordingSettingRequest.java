package com.ss.android.lark.pb.videochat;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class GetLiveRecordingSettingRequest extends Message<GetLiveRecordingSettingRequest, Builder> {
    public static final ProtoAdapter<GetLiveRecordingSettingRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_USER_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MMEETING_ID = null;
    private static final long serialVersionUID = 0;
    public final Action maction;
    public final String mmeeting_id;
    public final String muser_id;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action GET_CAN_RECORDING_MARK = null;
        public static final Action GET_CURRENT_SETTING = null;
        public static final Action GET_SPEAKER_INFO_EDIT_WAITING_TIME = null;
        public static final Action GET_SUPPORT_SPOKEN_LANGUAGE = null;
        public static final Action GET_SUPPORT_TRANSLATION_LANGUAGE = null;
        public static final Action UNKNOWN = null;
        private final int value;

        static {
            Action r100 = new Action("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Action r101 = new Action("GET_CURRENT_SETTING", 1, 1);
            GET_CURRENT_SETTING = r101;
            Action r102 = new Action("GET_SUPPORT_SPOKEN_LANGUAGE", 2, 2);
            GET_SUPPORT_SPOKEN_LANGUAGE = r102;
            Action r103 = new Action("GET_SUPPORT_TRANSLATION_LANGUAGE", 3, 3);
            GET_SUPPORT_TRANSLATION_LANGUAGE = r103;
            Action r104 = new Action("GET_SPEAKER_INFO_EDIT_WAITING_TIME", 4, 4);
            GET_SPEAKER_INFO_EDIT_WAITING_TIME = r104;
            Action r105 = new Action("GET_CAN_RECORDING_MARK", 5, 5);
            GET_CAN_RECORDING_MARK = r105;
            $VALUES = new Action[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Action fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return GET_CAN_RECORDING_MARK;
        L18:
            return GET_SPEAKER_INFO_EDIT_WAITING_TIME;
        L20:
            return GET_SUPPORT_TRANSLATION_LANGUAGE;
        L22:
            return GET_SUPPORT_SPOKEN_LANGUAGE;
        L24:
            return GET_CURRENT_SETTING;
        L26:
            return UNKNOWN;
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        private Action(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<GetLiveRecordingSettingRequest, Builder> {
        public Action maction;
        public String mmeeting_id;
        public String muser_id;

        @Override // com.squareup.wire.Message.Builder
        public GetLiveRecordingSettingRequest build() {
            return new GetLiveRecordingSettingRequest(this.mmeeting_id, this.maction, this.muser_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(Action r100) {
            this.maction = r100;
            return this;
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.muser_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetLiveRecordingSettingRequest extends ProtoAdapter<GetLiveRecordingSettingRequest> {
        public ProtoAdapter_GetLiveRecordingSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLiveRecordingSettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetLiveRecordingSettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmeeting_id = "";
            r101.muser_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.maction = Action.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.muser_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetLiveRecordingSettingRequest r100) {
            String r101 = r100.mmeeting_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Action r104 = r100.maction;
            if (r104 == null) goto L9;
            int r105 = Action.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.muser_id;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLiveRecordingSettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetLiveRecordingSettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetLiveRecordingSettingRequest r101) throws IOException {
            String r102 = r101.mmeeting_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Action r103 = r101.maction;
            if (r103 == null) goto L8;
            Action.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.muser_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetLiveRecordingSettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetLiveRecordingSettingRequest();
        FIELD_OPTIONS_MMEETING_ID = new FieldOptions.Builder().FieldInfo("split,type=meeting").build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeeting_id = this.mmeeting_id;
        r100.maction = this.maction;
        r100.muser_id = this.muser_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetLiveRecordingSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetLiveRecordingSettingRequest(String r100, Action r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetLiveRecordingSettingRequest(String r100, Action r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mmeeting_id = r100;
        this.maction = r101;
        this.muser_id = r102;
    }
}
