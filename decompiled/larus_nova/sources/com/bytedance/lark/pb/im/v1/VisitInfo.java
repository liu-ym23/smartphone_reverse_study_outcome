package com.bytedance.lark.pb.im.v1;

import com.larus.network.http.ServiceType;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class VisitInfo extends Message<VisitInfo, Builder> {
    public static final ProtoAdapter<VisitInfo> ADAPTER = null;
    public static final String DEFAULT_ENTITY_ID = "";
    public static final Long DEFAULT_INNER_MSG_ID = null;
    public static final DownloadScene DEFAULT_SCENE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String entity_id;
    public final Map<String, String> ext;
    public final Long inner_msg_id;
    public final DownloadScene scene_type;

    public static final class Builder extends Message.Builder<VisitInfo, Builder> {
        public String entity_id;
        public Map<String, String> ext;
        public Long inner_msg_id;
        public DownloadScene scene_type;

        @Override // com.squareup.wire.Message.Builder
        public VisitInfo build() {
            return new VisitInfo(this.scene_type, this.entity_id, this.inner_msg_id, this.ext, super.buildUnknownFields());
        }

        public Builder() {
            this.ext = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entity_id(String r100) {
            this.entity_id = r100;
            return this;
        }

        public Builder ext(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.ext = r100;
            return this;
        }

        public Builder inner_msg_id(Long r100) {
            this.inner_msg_id = r100;
            return this;
        }

        public Builder scene_type(DownloadScene r100) {
            this.scene_type = r100;
            return this;
        }
    }

    public static final enum DownloadScene extends Enum<DownloadScene> implements WireEnum {
        private static final /* synthetic */ DownloadScene[] $VALUES = null;
        public static final ProtoAdapter<DownloadScene> ADAPTER = null;
        public static final DownloadScene CHAT = null;
        public static final DownloadScene FAVORITE = null;
        public static final DownloadScene ImFeedAudio = null;
        public static final DownloadScene Mark = null;
        public static final DownloadScene Message = null;
        public static final DownloadScene MessageLink = null;
        public static final DownloadScene Moments = null;
        public static final DownloadScene TODO = null;
        public static final DownloadScene UNKNOWN = null;
        private final int value;

        static {
            DownloadScene r100 = new DownloadScene("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            DownloadScene r101 = new DownloadScene("CHAT", 1, 1);
            CHAT = r101;
            DownloadScene r102 = new DownloadScene("FAVORITE", 2, 2);
            FAVORITE = r102;
            DownloadScene r103 = new DownloadScene(AlarmSessionType.TODO, 3, 3);
            TODO = r103;
            DownloadScene r104 = new DownloadScene("Moments", 4, 4);
            Moments = r104;
            DownloadScene r105 = new DownloadScene("Mark", 5, 5);
            Mark = r105;
            DownloadScene r110 = new DownloadScene(ServiceType.IM, 6, 6);
            Message = r110;
            DownloadScene r111 = new DownloadScene("ImFeedAudio", 7, 7);
            ImFeedAudio = r111;
            DownloadScene r112 = new DownloadScene("MessageLink", 8, 8);
            MessageLink = r112;
            $VALUES = new DownloadScene[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
            ADAPTER = ProtoAdapter.newEnumAdapter(DownloadScene.class);
        }

        public static DownloadScene[] values() {
            return (DownloadScene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DownloadScene fromValue(int r100) {
            switch(r100) {
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                case 8: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MessageLink;
        L8:
            return ImFeedAudio;
        L10:
            return Message;
        L12:
            return Mark;
        L14:
            return Moments;
        L16:
            return TODO;
        L18:
            return FAVORITE;
        L20:
            return CHAT;
        L22:
            return UNKNOWN;
        }

        public static DownloadScene valueOf(String r100) {
            return (DownloadScene) a.a(DownloadScene.class, r100);
        }

        private DownloadScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_VisitInfo extends ProtoAdapter<VisitInfo> {
        private final ProtoAdapter<Map<String, String>> ext;

        public ProtoAdapter_VisitInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, VisitInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.ext = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VisitInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene_type = DownloadScene.UNKNOWN;
            r101.entity_id = "";
            r101.inner_msg_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.scene_type = DownloadScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.entity_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.inner_msg_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 5) goto L13;
            r101.ext.putAll(this.ext.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(VisitInfo r100) {
            DownloadScene r101 = r100.scene_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DownloadScene.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.entity_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.inner_msg_id;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            return ((r106 + r102) + this.ext.encodedSizeWithTag(5, r100.ext)) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ VisitInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VisitInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VisitInfo r101) throws IOException {
            DownloadScene r102 = r101.scene_type;
            if (r102 == null) goto L5;
            DownloadScene.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.entity_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.inner_msg_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            this.ext.encodeWithTag(r100, 5, r101.ext);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VisitInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_VisitInfo();
        DEFAULT_SCENE_TYPE = DownloadScene.UNKNOWN;
        DEFAULT_INNER_MSG_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scene_type = this.scene_type;
        r100.entity_id = this.entity_id;
        r100.inner_msg_id = this.inner_msg_id;
        r100.ext = Internal.copyOf("ext", this.ext);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VisitInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public VisitInfo(DownloadScene r100, String r101, Long r102, Map<String, String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public VisitInfo(DownloadScene r100, String r101, Long r102, Map<String, String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.scene_type = r100;
        this.entity_id = r101;
        this.inner_msg_id = r102;
        this.ext = Internal.immutableCopyOf("ext", r103);
    }
}
