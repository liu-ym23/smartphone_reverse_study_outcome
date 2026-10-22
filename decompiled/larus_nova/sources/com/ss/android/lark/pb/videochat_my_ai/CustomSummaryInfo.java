package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CustomSummaryInfo extends Message<CustomSummaryInfo, Builder> {
    public static final ProtoAdapter<CustomSummaryInfo> ADAPTER = null;
    public static final String DEFAULT_ANALYZE_LINK_URL = "";
    public static final Boolean DEFAULT_IS_OPEN = null;
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String manalyze_link_url;
    public final List<CustomSummaryAutoDetectSpeaker> mauto_detect_speaker;
    public final Boolean mis_open;
    public final CustomSummaryMinutesMeetingInfo mminutes_meeting_info;
    public final List<CustomSummaryItem> msummary_items;
    public final Integer mversion;

    public static final class Builder extends Message.Builder<CustomSummaryInfo, Builder> {
        public String manalyze_link_url;
        public List<CustomSummaryAutoDetectSpeaker> mauto_detect_speaker;
        public Boolean mis_open;
        public CustomSummaryMinutesMeetingInfo mminutes_meeting_info;
        public List<CustomSummaryItem> msummary_items;
        public Integer mversion;

        @Override // com.squareup.wire.Message.Builder
        public CustomSummaryInfo build() {
            return new CustomSummaryInfo(this.mis_open, this.msummary_items, this.mversion, this.manalyze_link_url, this.mminutes_meeting_info, this.mauto_detect_speaker, super.buildUnknownFields());
        }

        public Builder() {
            this.msummary_items = Internal.newMutableList();
            this.mauto_detect_speaker = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder analyze_link_url(String r100) {
            this.manalyze_link_url = r100;
            return this;
        }

        public Builder auto_detect_speaker(List<CustomSummaryAutoDetectSpeaker> r100) {
            Internal.checkElementsNotNull(r100);
            this.mauto_detect_speaker = r100;
            return this;
        }

        public Builder is_open(Boolean r100) {
            this.mis_open = r100;
            return this;
        }

        public Builder minutes_meeting_info(CustomSummaryMinutesMeetingInfo r100) {
            this.mminutes_meeting_info = r100;
            return this;
        }

        public Builder summary_items(List<CustomSummaryItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.msummary_items = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.mversion = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryInfo extends ProtoAdapter<CustomSummaryInfo> {
        public ProtoAdapter_CustomSummaryInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomSummaryInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_open = Boolean.FALSE;
            r101.mversion = 0;
            r101.manalyze_link_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.mauto_detect_speaker.add(CustomSummaryAutoDetectSpeaker.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.mminutes_meeting_info = CustomSummaryMinutesMeetingInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.manalyze_link_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mversion = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.msummary_items.add(CustomSummaryItem.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.mis_open = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CustomSummaryInfo r100) {
            Boolean r101 = r100.mis_open;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + CustomSummaryItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.msummary_items);
            Integer r105 = r100.mversion;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.INT32.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            String r108 = r100.manalyze_link_url;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.STRING.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            CustomSummaryMinutesMeetingInfo r111 = r100.mminutes_meeting_info;
            if (r111 == null) goto L18;
            r102 = CustomSummaryMinutesMeetingInfo.ADAPTER.encodedSizeWithTag(5, r111);
        L18:
            return ((r110 + r102) + CustomSummaryAutoDetectSpeaker.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.mauto_detect_speaker)) + r100.unknownFields().size();
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomSummaryInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomSummaryInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomSummaryInfo r101) throws IOException {
            Boolean r102 = r101.mis_open;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            CustomSummaryItem.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.msummary_items);
            Integer r103 = r101.mversion;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.manalyze_link_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            CustomSummaryMinutesMeetingInfo r105 = r101.mminutes_meeting_info;
            if (r105 == null) goto L14;
            CustomSummaryMinutesMeetingInfo.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            CustomSummaryAutoDetectSpeaker.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.mauto_detect_speaker);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomSummaryInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryInfo();
        DEFAULT_IS_OPEN = Boolean.FALSE;
        DEFAULT_VERSION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_open = this.mis_open;
        r100.msummary_items = Internal.copyOf("msummary_items", this.msummary_items);
        r100.mversion = this.mversion;
        r100.manalyze_link_url = this.manalyze_link_url;
        r100.mminutes_meeting_info = this.mminutes_meeting_info;
        r100.mauto_detect_speaker = Internal.copyOf("mauto_detect_speaker", this.mauto_detect_speaker);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomSummaryInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomSummaryInfo(Boolean r100, List<CustomSummaryItem> r110, Integer r111, String r112, CustomSummaryMinutesMeetingInfo r113, List<CustomSummaryAutoDetectSpeaker> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public CustomSummaryInfo(Boolean r100, List<CustomSummaryItem> r101, Integer r102, String r103, CustomSummaryMinutesMeetingInfo r104, List<CustomSummaryAutoDetectSpeaker> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mis_open = r100;
        this.msummary_items = Internal.immutableCopyOf("msummary_items", r101);
        this.mversion = r102;
        this.manalyze_link_url = r103;
        this.mminutes_meeting_info = r104;
        this.mauto_detect_speaker = Internal.immutableCopyOf("mauto_detect_speaker", r105);
    }
}
