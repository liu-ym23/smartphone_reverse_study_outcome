package com.bytedance.lark.pb.space.drive.v1;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DriveRustConfig extends Message<DriveRustConfig, Builder> {
    public static final ProtoAdapter<DriveRustConfig> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE_MULTI_TASK = null;
    public static final Integer DEFAULT_EXCEED_TIME = null;
    public static final Integer DEFAULT_MAX_DOWNLOAD_PART_SIZE = null;
    public static final Integer DEFAULT_MAX_THREAD_SIZE = null;
    public static final Boolean DEFAULT_MERGE_UPLOAD = null;
    public static final Boolean DEFAULT_NEW_CDN_DOMAIN_SELECT = null;
    public static final Boolean DEFAULT_NOT_SET_FILE_SIZE = null;
    public static final Boolean DEFAULT_PAUSE_BACKGROUND = null;
    public static final Integer DEFAULT_SMALL_UPLOAD_FILE_SIZE = null;
    public static final Boolean DEFAULT_SMART_CLEAR_DB = null;
    public static final Boolean DEFAULT_UPLOAD_OPTIMIZE = null;
    public static final Boolean DEFAULT_USE_RANGE_IN_PART = null;
    public static final Boolean DEFAULT_WEAK_OPTIMIZE = null;
    private static final long serialVersionUID = 0;
    public final Boolean enable_multi_task;
    public final Integer exceed_time;
    public final Map<String, String> extra;
    public final Map<String, String> headers;
    public final Integer max_download_part_size;
    public final Integer max_thread_size;
    public final Boolean merge_upload;
    public final Boolean new_cdn_domain_select;
    public final Boolean not_set_file_size;
    public final Boolean pause_background;
    public final Integer small_upload_file_size;
    public final Boolean smart_clear_db;
    public final Boolean upload_optimize;
    public final Boolean use_range_in_part;
    public final Boolean weak_optimize;

    public static final class Builder extends Message.Builder<DriveRustConfig, Builder> {
        public Boolean enable_multi_task;
        public Integer exceed_time;
        public Map<String, String> extra;
        public Map<String, String> headers;
        public Integer max_download_part_size;
        public Integer max_thread_size;
        public Boolean merge_upload;
        public Boolean new_cdn_domain_select;
        public Boolean not_set_file_size;
        public Boolean pause_background;
        public Integer small_upload_file_size;
        public Boolean smart_clear_db;
        public Boolean upload_optimize;
        public Boolean use_range_in_part;
        public Boolean weak_optimize;

        @Override // com.squareup.wire.Message.Builder
        public DriveRustConfig build() {
            return new DriveRustConfig(this.enable_multi_task, this.use_range_in_part, this.weak_optimize, this.new_cdn_domain_select, this.smart_clear_db, this.merge_upload, this.max_thread_size, this.max_download_part_size, this.pause_background, this.headers, this.not_set_file_size, this.exceed_time, this.small_upload_file_size, this.upload_optimize, this.extra, super.buildUnknownFields());
        }

        public Builder() {
            this.headers = Internal.newMutableMap();
            this.extra = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enable_multi_task(Boolean r100) {
            this.enable_multi_task = r100;
            return this;
        }

        public Builder exceed_time(Integer r100) {
            this.exceed_time = r100;
            return this;
        }

        public Builder extra(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra = r100;
            return this;
        }

        public Builder headers(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder max_download_part_size(Integer r100) {
            this.max_download_part_size = r100;
            return this;
        }

        public Builder max_thread_size(Integer r100) {
            this.max_thread_size = r100;
            return this;
        }

        public Builder merge_upload(Boolean r100) {
            this.merge_upload = r100;
            return this;
        }

        public Builder new_cdn_domain_select(Boolean r100) {
            this.new_cdn_domain_select = r100;
            return this;
        }

        public Builder not_set_file_size(Boolean r100) {
            this.not_set_file_size = r100;
            return this;
        }

        public Builder pause_background(Boolean r100) {
            this.pause_background = r100;
            return this;
        }

        public Builder small_upload_file_size(Integer r100) {
            this.small_upload_file_size = r100;
            return this;
        }

        public Builder smart_clear_db(Boolean r100) {
            this.smart_clear_db = r100;
            return this;
        }

        public Builder upload_optimize(Boolean r100) {
            this.upload_optimize = r100;
            return this;
        }

        public Builder use_range_in_part(Boolean r100) {
            this.use_range_in_part = r100;
            return this;
        }

        public Builder weak_optimize(Boolean r100) {
            this.weak_optimize = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DriveRustConfig extends ProtoAdapter<DriveRustConfig> {
        private final ProtoAdapter<Map<String, String>> extra;
        private final ProtoAdapter<Map<String, String>> headers;

        public ProtoAdapter_DriveRustConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, DriveRustConfig.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.headers = ProtoAdapter.newMapAdapter(r100, r100);
            this.extra = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DriveRustConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.enable_multi_task = r102;
            r101.use_range_in_part = r102;
            r101.weak_optimize = r102;
            r101.new_cdn_domain_select = r102;
            r101.smart_clear_db = r102;
            r101.merge_upload = r102;
            r101.max_thread_size = 3;
            r101.max_download_part_size = 1048576;
            r101.pause_background = r102;
            r101.not_set_file_size = r102;
            r101.exceed_time = Integer.valueOf(RemoteMessageConst.MAX_TTL);
            r101.small_upload_file_size = 20971520;
            r101.upload_optimize = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L22;
            switch(r104) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L7:
            r101.extra.putAll(this.extra.decode(r100));
            goto L3
        L8:
            r101.upload_optimize = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.small_upload_file_size = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.exceed_time = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.not_set_file_size = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.headers.putAll(this.headers.decode(r100));
            goto L3
        L13:
            r101.pause_background = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.max_download_part_size = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.max_thread_size = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.merge_upload = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.smart_clear_db = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.new_cdn_domain_select = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.weak_optimize = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L20:
            r101.use_range_in_part = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.enable_multi_task = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DriveRustConfig r100) {
            Boolean r101 = r100.enable_multi_task;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.use_range_in_part;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.weak_optimize;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.new_cdn_domain_select;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.smart_clear_db;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.merge_upload;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Integer r119 = r100.max_thread_size;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Integer r122 = r100.max_download_part_size;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.pause_background;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            int r127 = (r124 + r126) + this.headers.encodedSizeWithTag(10, r100.headers);
            Boolean r128 = r100.not_set_file_size;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r128);
        L42:
            int r130 = r127 + r129;
            Integer r131 = r100.exceed_time;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.INT32.encodedSizeWithTag(12, r131);
        L46:
            int r133 = r130 + r132;
            Integer r134 = r100.small_upload_file_size;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.INT32.encodedSizeWithTag(13, r134);
        L50:
            int r136 = r133 + r135;
            Boolean r137 = r100.upload_optimize;
            if (r137 == null) goto L54;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r137);
        L54:
            return ((r136 + r102) + this.extra.encodedSizeWithTag(15, r100.extra)) + r100.unknownFields().size();
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ DriveRustConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DriveRustConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DriveRustConfig r101) throws IOException {
            Boolean r102 = r101.enable_multi_task;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.use_range_in_part;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.weak_optimize;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.new_cdn_domain_select;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.smart_clear_db;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.merge_upload;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            Integer r108 = r101.max_thread_size;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L23:
            Integer r109 = r101.max_download_part_size;
            if (r109 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.pause_background;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            this.headers.encodeWithTag(r100, 10, r101.headers);
            Boolean r111 = r101.not_set_file_size;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r111);
        L32:
            Integer r112 = r101.exceed_time;
            if (r112 == null) goto L35;
            ProtoAdapter.INT32.encodeWithTag(r100, 12, r112);
        L35:
            Integer r113 = r101.small_upload_file_size;
            if (r113 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r100, 13, r113);
        L38:
            Boolean r114 = r101.upload_optimize;
            if (r114 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r114);
        L41:
            this.extra.encodeWithTag(r100, 15, r101.extra);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DriveRustConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DriveRustConfig();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_ENABLE_MULTI_TASK = r100;
        DEFAULT_USE_RANGE_IN_PART = r100;
        DEFAULT_WEAK_OPTIMIZE = r100;
        DEFAULT_NEW_CDN_DOMAIN_SELECT = r100;
        DEFAULT_SMART_CLEAR_DB = r100;
        DEFAULT_MERGE_UPLOAD = r100;
        DEFAULT_MAX_THREAD_SIZE = 3;
        DEFAULT_MAX_DOWNLOAD_PART_SIZE = 1048576;
        DEFAULT_PAUSE_BACKGROUND = r100;
        DEFAULT_NOT_SET_FILE_SIZE = r100;
        DEFAULT_EXCEED_TIME = Integer.valueOf(RemoteMessageConst.MAX_TTL);
        DEFAULT_SMALL_UPLOAD_FILE_SIZE = 20971520;
        DEFAULT_UPLOAD_OPTIMIZE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.enable_multi_task = this.enable_multi_task;
        r100.use_range_in_part = this.use_range_in_part;
        r100.weak_optimize = this.weak_optimize;
        r100.new_cdn_domain_select = this.new_cdn_domain_select;
        r100.smart_clear_db = this.smart_clear_db;
        r100.merge_upload = this.merge_upload;
        r100.max_thread_size = this.max_thread_size;
        r100.max_download_part_size = this.max_download_part_size;
        r100.pause_background = this.pause_background;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.not_set_file_size = this.not_set_file_size;
        r100.exceed_time = this.exceed_time;
        r100.small_upload_file_size = this.small_upload_file_size;
        r100.upload_optimize = this.upload_optimize;
        r100.extra = Internal.copyOf("extra", this.extra);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DriveRustConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DriveRustConfig(Boolean r110, Boolean r111, Boolean r210, Boolean r211, Boolean r212, Boolean r213, Integer r214, Integer r215, Boolean r216, Map<String, String> r217, Boolean r218, Integer r219, Integer r310, Boolean r311, Map<String, String> r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public DriveRustConfig(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, Integer r110, Integer r111, Boolean r112, Map<String, String> r113, Boolean r114, Integer r115, Integer r116, Boolean r117, Map<String, String> r118, ByteString r119) {
        super(ADAPTER, r119);
        this.enable_multi_task = r100;
        this.use_range_in_part = r101;
        this.weak_optimize = r102;
        this.new_cdn_domain_select = r103;
        this.smart_clear_db = r104;
        this.merge_upload = r105;
        this.max_thread_size = r110;
        this.max_download_part_size = r111;
        this.pause_background = r112;
        this.headers = Internal.immutableCopyOf("headers", r113);
        this.not_set_file_size = r114;
        this.exceed_time = r115;
        this.small_upload_file_size = r116;
        this.upload_optimize = r117;
        this.extra = Internal.immutableCopyOf("extra", r118);
    }
}
