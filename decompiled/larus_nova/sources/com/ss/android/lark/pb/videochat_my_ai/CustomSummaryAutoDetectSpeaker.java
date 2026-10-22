package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CustomSummaryAutoDetectSpeaker extends Message<CustomSummaryAutoDetectSpeaker, Builder> {
    public static final ProtoAdapter<CustomSummaryAutoDetectSpeaker> ADAPTER = null;
    public static final String DEFAULT_SUBTITLE_CONTENT = "";
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final MeetingAISSDInfo.SSDType mspeaker_type;
    public final String msubtitle_content;
    public final Long muser_id;

    public static final class Builder extends Message.Builder<CustomSummaryAutoDetectSpeaker, Builder> {
        public MeetingAISSDInfo.SSDType mspeaker_type;
        public String msubtitle_content;
        public Long muser_id;

        @Override // com.squareup.wire.Message.Builder
        public CustomSummaryAutoDetectSpeaker build() {
            return new CustomSummaryAutoDetectSpeaker(this.muser_id, this.mspeaker_type, this.msubtitle_content, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder speaker_type(MeetingAISSDInfo.SSDType r100) {
            this.mspeaker_type = r100;
            return this;
        }

        public Builder subtitle_content(String r100) {
            this.msubtitle_content = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.muser_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryAutoDetectSpeaker extends ProtoAdapter<CustomSummaryAutoDetectSpeaker> {
        public ProtoAdapter_CustomSummaryAutoDetectSpeaker() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryAutoDetectSpeaker.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomSummaryAutoDetectSpeaker decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.muser_id = 0L;
            r101.msubtitle_content = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.muser_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mspeaker_type = MeetingAISSDInfo.SSDType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.msubtitle_content = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CustomSummaryAutoDetectSpeaker r100) {
            Long r101 = r100.muser_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            MeetingAISSDInfo.SSDType r104 = r100.mspeaker_type;
            if (r104 == null) goto L9;
            int r105 = MeetingAISSDInfo.SSDType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.msubtitle_content;
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
        public /* bridge */ /* synthetic */ CustomSummaryAutoDetectSpeaker decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomSummaryAutoDetectSpeaker r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomSummaryAutoDetectSpeaker r101) throws IOException {
            Long r102 = r101.muser_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            MeetingAISSDInfo.SSDType r103 = r101.mspeaker_type;
            if (r103 == null) goto L8;
            MeetingAISSDInfo.SSDType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.msubtitle_content;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomSummaryAutoDetectSpeaker r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryAutoDetectSpeaker();
        DEFAULT_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.muser_id = this.muser_id;
        r100.mspeaker_type = this.mspeaker_type;
        r100.msubtitle_content = this.msubtitle_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomSummaryAutoDetectSpeaker.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomSummaryAutoDetectSpeaker(Long r100, MeetingAISSDInfo.SSDType r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CustomSummaryAutoDetectSpeaker(Long r100, MeetingAISSDInfo.SSDType r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.muser_id = r100;
        this.mspeaker_type = r101;
        this.msubtitle_content = r102;
    }
}
