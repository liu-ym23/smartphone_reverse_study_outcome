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
public final class UpdateSISettingRequest extends Message<UpdateSISettingRequest, Builder> {
    public static final ProtoAdapter<UpdateSISettingRequest> ADAPTER = null;
    public static final String DEFAULT_BREAKOUT_ROOM_ID = "";
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_RECORD_ID = "";
    public static final String DEFAULT_TARGET_LANG = "";
    public static final Boolean DEFAULT_TURN_ON = null;
    public static final FieldOptions FIELD_OPTIONS_MMEETING_ID = null;
    private static final long serialVersionUID = 0;
    public final SIBizScene mbiz_scene;
    public final String mbreakout_room_id;
    public final DoubaoBizInfo mdoubao_bizinfo;
    public final String mmeeting_id;
    public final String mrecord_id;
    public final String mtarget_lang;
    public final Boolean mturn_on;

    public static final class Builder extends Message.Builder<UpdateSISettingRequest, Builder> {
        public SIBizScene mbiz_scene;
        public String mbreakout_room_id;
        public DoubaoBizInfo mdoubao_bizinfo;
        public String mmeeting_id;
        public String mrecord_id;
        public String mtarget_lang;
        public Boolean mturn_on;

        @Override // com.squareup.wire.Message.Builder
        public UpdateSISettingRequest build() {
            return new UpdateSISettingRequest(this.mmeeting_id, this.mbreakout_room_id, this.mturn_on, this.mtarget_lang, this.mbiz_scene, this.mrecord_id, this.mdoubao_bizinfo, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_scene(SIBizScene r100) {
            this.mbiz_scene = r100;
            return this;
        }

        public Builder breakout_room_id(String r100) {
            this.mbreakout_room_id = r100;
            return this;
        }

        public Builder doubao_bizinfo(DoubaoBizInfo r100) {
            this.mdoubao_bizinfo = r100;
            return this;
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder record_id(String r100) {
            this.mrecord_id = r100;
            return this;
        }

        public Builder target_lang(String r100) {
            this.mtarget_lang = r100;
            return this;
        }

        public Builder turn_on(Boolean r100) {
            this.mturn_on = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateSISettingRequest extends ProtoAdapter<UpdateSISettingRequest> {
        public ProtoAdapter_UpdateSISettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateSISettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateSISettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmeeting_id = "";
            r101.mbreakout_room_id = "";
            r101.mturn_on = Boolean.FALSE;
            r101.mtarget_lang = "";
            r101.mrecord_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L19;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.mbiz_scene = SIBizScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mdoubao_bizinfo = DoubaoBizInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.mrecord_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mtarget_lang = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mturn_on = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.mbreakout_room_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateSISettingRequest r100) {
            String r101 = r100.mmeeting_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mbreakout_room_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mturn_on;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mtarget_lang;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            SIBizScene r113 = r100.mbiz_scene;
            if (r113 == null) goto L21;
            int r114 = SIBizScene.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.mrecord_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            DoubaoBizInfo r119 = r100.mdoubao_bizinfo;
            if (r119 == null) goto L30;
            r102 = DoubaoBizInfo.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateSISettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateSISettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateSISettingRequest r101) throws IOException {
            String r102 = r101.mmeeting_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mbreakout_room_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mturn_on;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mtarget_lang;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            SIBizScene r106 = r101.mbiz_scene;
            if (r106 == null) goto L17;
            SIBizScene.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.mrecord_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            DoubaoBizInfo r108 = r101.mdoubao_bizinfo;
            if (r108 == null) goto L23;
            DoubaoBizInfo.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateSISettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateSISettingRequest();
        FIELD_OPTIONS_MMEETING_ID = new FieldOptions.Builder().FieldInfo("split,type=meeting").build();
        DEFAULT_TURN_ON = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeeting_id = this.mmeeting_id;
        r100.mbreakout_room_id = this.mbreakout_room_id;
        r100.mturn_on = this.mturn_on;
        r100.mtarget_lang = this.mtarget_lang;
        r100.mbiz_scene = this.mbiz_scene;
        r100.mrecord_id = this.mrecord_id;
        r100.mdoubao_bizinfo = this.mdoubao_bizinfo;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateSISettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateSISettingRequest(String r110, String r111, Boolean r112, String r113, SIBizScene r114, String r115, DoubaoBizInfo r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public UpdateSISettingRequest(String r100, String r101, Boolean r102, String r103, SIBizScene r104, String r105, DoubaoBizInfo r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mmeeting_id = r100;
        this.mbreakout_room_id = r101;
        this.mturn_on = r102;
        this.mtarget_lang = r103;
        this.mbiz_scene = r104;
        this.mrecord_id = r105;
        this.mdoubao_bizinfo = r106;
    }
}
