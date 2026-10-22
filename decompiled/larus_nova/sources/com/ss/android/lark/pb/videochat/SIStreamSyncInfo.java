package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class SIStreamSyncInfo extends Message<SIStreamSyncInfo, Builder> {
    public static final ProtoAdapter<SIStreamSyncInfo> ADAPTER = null;
    public static final Boolean DEFAULT_CHANGE_TO_ORIGIN = null;
    public static final Boolean DEFAULT_IS_SCREEN = null;
    public static final Long DEFAULT_SEQ_ID = null;
    public static final Long DEFAULT_SI_DID = null;
    public static final String DEFAULT_SOURCE_LANGUAGE = "";
    private static final long serialVersionUID = 0;
    public final Boolean mchange_to_origin;
    public final ChangeToOriginReason mchange_to_origin_reason;
    public final Boolean mis_screen;
    public final List<SegmentIndex> msegments;
    public final Long mseq_id;
    public final Long msi_did;
    public final String msource_language;

    public static final class Builder extends Message.Builder<SIStreamSyncInfo, Builder> {
        public Boolean mchange_to_origin;
        public ChangeToOriginReason mchange_to_origin_reason;
        public Boolean mis_screen;
        public List<SegmentIndex> msegments;
        public Long mseq_id;
        public Long msi_did;
        public String msource_language;

        @Override // com.squareup.wire.Message.Builder
        public SIStreamSyncInfo build() {
            return new SIStreamSyncInfo(this.mseq_id, this.msi_did, this.mis_screen, this.msource_language, this.msegments, this.mchange_to_origin, this.mchange_to_origin_reason, super.buildUnknownFields());
        }

        public Builder() {
            this.msegments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder change_to_origin(Boolean r100) {
            this.mchange_to_origin = r100;
            return this;
        }

        public Builder change_to_origin_reason(ChangeToOriginReason r100) {
            this.mchange_to_origin_reason = r100;
            return this;
        }

        public Builder is_screen(Boolean r100) {
            this.mis_screen = r100;
            return this;
        }

        public Builder segments(List<SegmentIndex> r100) {
            Internal.checkElementsNotNull(r100);
            this.msegments = r100;
            return this;
        }

        public Builder seq_id(Long r100) {
            this.mseq_id = r100;
            return this;
        }

        public Builder si_did(Long r100) {
            this.msi_did = r100;
            return this;
        }

        public Builder source_language(String r100) {
            this.msource_language = r100;
            return this;
        }
    }

    public static final enum ChangeToOriginReason extends Enum<ChangeToOriginReason> implements WireEnum {
        private static final /* synthetic */ ChangeToOriginReason[] $VALUES = null;
        public static final ProtoAdapter<ChangeToOriginReason> ADAPTER = null;
        public static final ChangeToOriginReason SAME_LAN = null;
        public static final ChangeToOriginReason SOURCE_LAN_NOT_SUPPORT = null;
        public static final ChangeToOriginReason UNKNOWN = null;
        private final int value;

        static {
            ChangeToOriginReason r100 = new ChangeToOriginReason("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChangeToOriginReason r101 = new ChangeToOriginReason("SAME_LAN", 1, 1);
            SAME_LAN = r101;
            ChangeToOriginReason r102 = new ChangeToOriginReason("SOURCE_LAN_NOT_SUPPORT", 2, 2);
            SOURCE_LAN_NOT_SUPPORT = r102;
            $VALUES = new ChangeToOriginReason[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChangeToOriginReason.class);
        }

        public static ChangeToOriginReason[] values() {
            return (ChangeToOriginReason[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ChangeToOriginReason fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return SOURCE_LAN_NOT_SUPPORT;
        L12:
            return SAME_LAN;
        L14:
            return UNKNOWN;
        }

        public static ChangeToOriginReason valueOf(String r100) {
            return (ChangeToOriginReason) a.a(ChangeToOriginReason.class, r100);
        }

        private ChangeToOriginReason(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_SIStreamSyncInfo extends ProtoAdapter<SIStreamSyncInfo> {
        public ProtoAdapter_SIStreamSyncInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SIStreamSyncInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SIStreamSyncInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mseq_id = 0L;
            r101.msi_did = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.mis_screen = r102;
            r101.msource_language = "";
            r101.mchange_to_origin = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L30;
            if (r104 != 1) goto L8;
            r101.mseq_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.msi_did = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r104 != 4) goto L12;
            r101.mis_screen = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 5) goto L14;
            r101.msource_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r104 != 7) goto L16;
            r101.msegments.add(SegmentIndex.ADAPTER.decode(r100));
            goto L3
        L16:
            if (r104 != 8) goto L18;
            r101.mchange_to_origin = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            if (r104 != 9) goto L19;
            r101.mchange_to_origin_reason = ChangeToOriginReason.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L19:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SIStreamSyncInfo r100) {
            Long r101 = r100.mseq_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.msi_did;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mis_screen;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.msource_language;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(5, r110);
        L18:
            int r112 = (r109 + r111) + SegmentIndex.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.msegments);
            Boolean r113 = r100.mchange_to_origin;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r113);
        L22:
            int r115 = r112 + r114;
            ChangeToOriginReason r116 = r100.mchange_to_origin_reason;
            if (r116 == null) goto L26;
            r102 = ChangeToOriginReason.ADAPTER.encodedSizeWithTag(9, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SIStreamSyncInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SIStreamSyncInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SIStreamSyncInfo r101) throws IOException {
            Long r102 = r101.mseq_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.msi_did;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mis_screen;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            String r105 = r101.msource_language;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
        L14:
            SegmentIndex.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.msegments);
            Boolean r106 = r101.mchange_to_origin;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r106);
        L17:
            ChangeToOriginReason r107 = r101.mchange_to_origin_reason;
            if (r107 == null) goto L20;
            ChangeToOriginReason.ADAPTER.encodeWithTag(r100, 9, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SIStreamSyncInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SIStreamSyncInfo();
        DEFAULT_SEQ_ID = 0L;
        DEFAULT_SI_DID = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_SCREEN = r100;
        DEFAULT_CHANGE_TO_ORIGIN = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mseq_id = this.mseq_id;
        r100.msi_did = this.msi_did;
        r100.mis_screen = this.mis_screen;
        r100.msource_language = this.msource_language;
        r100.msegments = Internal.copyOf("msegments", this.msegments);
        r100.mchange_to_origin = this.mchange_to_origin;
        r100.mchange_to_origin_reason = this.mchange_to_origin_reason;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SIStreamSyncInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SIStreamSyncInfo(Long r110, Long r111, Boolean r112, String r113, List<SegmentIndex> r114, Boolean r115, ChangeToOriginReason r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public SIStreamSyncInfo(Long r100, Long r101, Boolean r102, String r103, List<SegmentIndex> r104, Boolean r105, ChangeToOriginReason r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mseq_id = r100;
        this.msi_did = r101;
        this.mis_screen = r102;
        this.msource_language = r103;
        this.msegments = Internal.immutableCopyOf("msegments", r104);
        this.mchange_to_origin = r105;
        this.mchange_to_origin_reason = r106;
    }
}
