package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatterCustomStatus extends com.squareup.wire.Message<ChatterCustomStatus, Builder> {
    public static final ProtoAdapter<ChatterCustomStatus> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final String DEFAULT_ICON_KEY = "";
    public static final Boolean DEFAULT_IS_NOT_DISTURB_MODE = null;
    public static final Long DEFAULT_STATUS_ID = null;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final EffectiveInterval meffective_interval;
    public final String mfs_unit;
    public final Map<String, String> mi18n_title;
    public final String micon_key;
    public final Boolean mis_not_disturb_mode;
    public final Long mstatus_id;
    public final TagInfo mtag_info;
    public final TimeFormat mtime_format;
    public final String mtitle;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatterCustomStatus, Builder> {
        public EffectiveInterval meffective_interval;
        public String mfs_unit;
        public Map<String, String> mi18n_title;
        public String micon_key;
        public Boolean mis_not_disturb_mode;
        public Long mstatus_id;
        public TagInfo mtag_info;
        public TimeFormat mtime_format;
        public String mtitle;

        @Override // com.squareup.wire.Message.Builder
        public ChatterCustomStatus build() {
            return new ChatterCustomStatus(this.mtitle, this.mi18n_title, this.micon_key, this.mfs_unit, this.meffective_interval, this.mis_not_disturb_mode, this.mtag_info, this.mtime_format, this.mstatus_id, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_title = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder effective_interval(EffectiveInterval r100) {
            this.meffective_interval = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.mfs_unit = r100;
            return this;
        }

        public Builder i18n_title(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_title = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.micon_key = r100;
            return this;
        }

        public Builder is_not_disturb_mode(Boolean r100) {
            this.mis_not_disturb_mode = r100;
            return this;
        }

        public Builder status_id(Long r100) {
            this.mstatus_id = r100;
            return this;
        }

        public Builder tag_info(TagInfo r100) {
            this.mtag_info = r100;
            return this;
        }

        public Builder time_format(TimeFormat r100) {
            this.mtime_format = r100;
            return this;
        }

        public Builder title(String r100) {
            this.mtitle = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatterCustomStatus extends ProtoAdapter<ChatterCustomStatus> {
        private final ProtoAdapter<Map<String, String>> mi18n_title;

        public ProtoAdapter_ChatterCustomStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatterCustomStatus.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_title = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatterCustomStatus decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtitle = "";
            r101.micon_key = "";
            r101.mfs_unit = "";
            r101.mis_not_disturb_mode = Boolean.FALSE;
            r101.mstatus_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.mstatus_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.mtime_format = TimeFormat.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.mtag_info = TagInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.mis_not_disturb_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.meffective_interval = EffectiveInterval.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.micon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mi18n_title.putAll(this.mi18n_title.decode(r100));
            goto L3
        L15:
            r101.mtitle = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatterCustomStatus r100) {
            String r101 = r100.mtitle;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + this.mi18n_title.encodedSizeWithTag(2, r100.mi18n_title);
            String r105 = r100.micon_key;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.STRING.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            String r108 = r100.mfs_unit;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.STRING.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            EffectiveInterval r111 = r100.meffective_interval;
            if (r111 == null) goto L17;
            int r112 = EffectiveInterval.ADAPTER.encodedSizeWithTag(5, r111);
        L18:
            int r113 = r110 + r112;
            Boolean r114 = r100.mis_not_disturb_mode;
            if (r114 == null) goto L21;
            int r115 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r114);
        L22:
            int r116 = r113 + r115;
            TagInfo r117 = r100.mtag_info;
            if (r117 == null) goto L25;
            int r118 = TagInfo.ADAPTER.encodedSizeWithTag(7, r117);
        L26:
            int r119 = r116 + r118;
            TimeFormat r120 = r100.mtime_format;
            if (r120 == null) goto L29;
            int r121 = TimeFormat.ADAPTER.encodedSizeWithTag(8, r120);
        L30:
            int r122 = r119 + r121;
            Long r123 = r100.mstatus_id;
            if (r123 == null) goto L34;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(9, r123);
        L34:
            return (r122 + r102) + r100.unknownFields().size();
        L29:
            r121 = 0;
            goto L30
        L25:
            r118 = 0;
            goto L26
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ ChatterCustomStatus decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatterCustomStatus r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatterCustomStatus r101) throws IOException {
            String r102 = r101.mtitle;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            this.mi18n_title.encodeWithTag(r100, 2, r101.mi18n_title);
            String r103 = r101.micon_key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.mfs_unit;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            EffectiveInterval r105 = r101.meffective_interval;
            if (r105 == null) goto L14;
            EffectiveInterval.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.mis_not_disturb_mode;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L17:
            TagInfo r107 = r101.mtag_info;
            if (r107 == null) goto L20;
            TagInfo.ADAPTER.encodeWithTag(r100, 7, r107);
        L20:
            TimeFormat r108 = r101.mtime_format;
            if (r108 == null) goto L23;
            TimeFormat.ADAPTER.encodeWithTag(r100, 8, r108);
        L23:
            Long r109 = r101.mstatus_id;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatterCustomStatus r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatterCustomStatus();
        DEFAULT_IS_NOT_DISTURB_MODE = Boolean.FALSE;
        DEFAULT_STATUS_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtitle = this.mtitle;
        r100.mi18n_title = Internal.copyOf("mi18n_title", this.mi18n_title);
        r100.micon_key = this.micon_key;
        r100.mfs_unit = this.mfs_unit;
        r100.meffective_interval = this.meffective_interval;
        r100.mis_not_disturb_mode = this.mis_not_disturb_mode;
        r100.mtag_info = this.mtag_info;
        r100.mtime_format = this.mtime_format;
        r100.mstatus_id = this.mstatus_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatterCustomStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatterCustomStatus(String r110, Map<String, String> r111, String r112, String r113, EffectiveInterval r114, Boolean r115, TagInfo r116, TimeFormat r117, Long r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public ChatterCustomStatus(String r100, Map<String, String> r101, String r102, String r103, EffectiveInterval r104, Boolean r105, TagInfo r106, TimeFormat r107, Long r110, ByteString r111) {
        super(ADAPTER, r111);
        this.mtitle = r100;
        this.mi18n_title = Internal.immutableCopyOf("mi18n_title", r101);
        this.micon_key = r102;
        this.mfs_unit = r103;
        this.meffective_interval = r104;
        this.mis_not_disturb_mode = r105;
        this.mtag_info = r106;
        this.mtime_format = r107;
        this.mstatus_id = r110;
    }
}
