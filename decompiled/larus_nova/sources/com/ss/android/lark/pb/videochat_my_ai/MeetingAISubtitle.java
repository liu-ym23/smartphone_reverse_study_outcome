package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.vc_common.ByteviewUser;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MeetingAISubtitle extends Message<MeetingAISubtitle, Builder> {
    public static final ProtoAdapter<MeetingAISubtitle> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_LANG = "";
    public static final Long DEFAULT_SENTENCE_ID = null;
    public static final Long DEFAULT_START_MS = null;
    public static final Long DEFAULT_STOP_MS = null;
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final String mlang;
    public final Long msentence_id;
    public final MeetingAISSDInfo mssd_info;
    public final Long mstart_ms;
    public final Long mstop_ms;
    public final ByteviewUser muser;

    public static final class Builder extends Message.Builder<MeetingAISubtitle, Builder> {
        public String mcontent;
        public String mlang;
        public Long msentence_id;
        public MeetingAISSDInfo mssd_info;
        public Long mstart_ms;
        public Long mstop_ms;
        public ByteviewUser muser;

        @Override // com.squareup.wire.Message.Builder
        public MeetingAISubtitle build() {
            return new MeetingAISubtitle(this.msentence_id, this.mcontent, this.mlang, this.mstart_ms, this.mstop_ms, this.muser, this.mssd_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.mcontent = r100;
            return this;
        }

        public Builder lang(String r100) {
            this.mlang = r100;
            return this;
        }

        public Builder sentence_id(Long r100) {
            this.msentence_id = r100;
            return this;
        }

        public Builder ssd_info(MeetingAISSDInfo r100) {
            this.mssd_info = r100;
            return this;
        }

        public Builder start_ms(Long r100) {
            this.mstart_ms = r100;
            return this;
        }

        public Builder stop_ms(Long r100) {
            this.mstop_ms = r100;
            return this;
        }

        public Builder user(ByteviewUser r100) {
            this.muser = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAISubtitle extends ProtoAdapter<MeetingAISubtitle> {
        public ProtoAdapter_MeetingAISubtitle() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAISubtitle.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingAISubtitle decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msentence_id = 0L;
            r101.mcontent = "";
            r101.mlang = "";
            r101.mstart_ms = 0L;
            r101.mstop_ms = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.mssd_info = MeetingAISSDInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.muser = ByteviewUser.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.mstop_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.mstart_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.mlang = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mcontent = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.msentence_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MeetingAISubtitle r100) {
            Long r101 = r100.msentence_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mcontent;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mlang;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.mstart_ms;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.mstop_ms;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ByteviewUser r116 = r100.muser;
            if (r116 == null) goto L25;
            int r117 = ByteviewUser.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            MeetingAISSDInfo r119 = r100.mssd_info;
            if (r119 == null) goto L30;
            r102 = MeetingAISSDInfo.ADAPTER.encodedSizeWithTag(7, r119);
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
        public /* bridge */ /* synthetic */ MeetingAISubtitle decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingAISubtitle r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingAISubtitle r101) throws IOException {
            Long r102 = r101.msentence_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mcontent;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mlang;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.mstart_ms;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.mstop_ms;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            ByteviewUser r107 = r101.muser;
            if (r107 == null) goto L20;
            ByteviewUser.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            MeetingAISSDInfo r108 = r101.mssd_info;
            if (r108 == null) goto L23;
            MeetingAISSDInfo.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingAISubtitle r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAISubtitle();
        DEFAULT_SENTENCE_ID = 0L;
        DEFAULT_START_MS = 0L;
        DEFAULT_STOP_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msentence_id = this.msentence_id;
        r100.mcontent = this.mcontent;
        r100.mlang = this.mlang;
        r100.mstart_ms = this.mstart_ms;
        r100.mstop_ms = this.mstop_ms;
        r100.muser = this.muser;
        r100.mssd_info = this.mssd_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingAISubtitle.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingAISubtitle(Long r110, String r111, String r112, Long r113, Long r114, ByteviewUser r115, MeetingAISSDInfo r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public MeetingAISubtitle(Long r100, String r101, String r102, Long r103, Long r104, ByteviewUser r105, MeetingAISSDInfo r106, ByteString r107) {
        super(ADAPTER, r107);
        this.msentence_id = r100;
        this.mcontent = r101;
        this.mlang = r102;
        this.mstart_ms = r103;
        this.mstop_ms = r104;
        this.muser = r105;
        this.mssd_info = r106;
    }
}
