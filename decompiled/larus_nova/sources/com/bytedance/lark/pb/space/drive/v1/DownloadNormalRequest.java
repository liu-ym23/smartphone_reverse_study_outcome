package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class DownloadNormalRequest extends Message<DownloadNormalRequest, Builder> {
    public static final ProtoAdapter<DownloadNormalRequest> ADAPTER = null;
    public static final DownloadRequest.ApiType DEFAULT_API_TYPE = null;
    public static final String DEFAULT_DATA_VERSION = "";
    public static final String DEFAULT_EXTRA = "";
    public static final String DEFAULT_FILE_SIZE = "";
    public static final String DEFAULT_FILE_TOKEN = "";
    public static final String DEFAULT_LOCAL_PATH = "";
    public static final Integer DEFAULT_PRIORITY = null;
    public static final Boolean DEFAULT_RELATIVE_PATH = null;
    public static final String DEFAULT_REMOTE_URL = "";
    public static final Boolean DEFAULT_REVERSE_ORDER = null;
    public static final Boolean DEFAULT_WITH_SLICE = null;
    public static final ProtoAdapter_DownloadNormalRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DownloadRequest.ApiType api_type;
    public final String data_version;
    public final List<DownloadRange> download_ranges;
    public final String extra;
    public final String file_size;
    public final String file_token;
    public final String local_path;
    public final Integer priority;
    public final Boolean relative_path;
    public final String remote_url;
    public final Boolean reverse_order;
    public final Map<String, String> tea_params;
    public final Boolean with_slice;

    public static final class Builder extends Message.Builder<DownloadNormalRequest, Builder> implements d<DownloadNormalRequest> {
        public DownloadRequest.ApiType api_type;
        public String data_version;
        public List<DownloadRange> download_ranges;
        public String extra;
        public String file_size;
        public String file_token;
        public String local_path;
        public Integer priority;
        public Boolean relative_path;
        public String remote_url;
        public Boolean reverse_order;
        public Map<String, String> tea_params;
        public Boolean with_slice;

        @Override // com.squareup.wire.Message.Builder
        public DownloadNormalRequest build() {
            String r100 = this.local_path;
            if (r100 == null) goto L9;
            if (this.remote_url == null) goto L9;
            return new DownloadNormalRequest(this.local_path, this.remote_url, this.priority, this.data_version, this.relative_path, this.with_slice, this.file_size, this.reverse_order, this.tea_params, this.extra, this.api_type, this.file_token, this.download_ranges, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "local_path", this.remote_url, "remote_url"});
        }

        public Builder() {
            this.tea_params = Internal.newMutableMap();
            this.download_ranges = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder api_type(DownloadRequest.ApiType r100) {
            this.api_type = r100;
            return this;
        }

        public Builder data_version(String r100) {
            this.data_version = r100;
            return this;
        }

        public Builder download_ranges(List<DownloadRange> r100) {
            Internal.checkElementsNotNull(r100);
            this.download_ranges = r100;
            return this;
        }

        public Builder extra(String r100) {
            this.extra = r100;
            return this;
        }

        public Builder file_size(String r100) {
            this.file_size = r100;
            return this;
        }

        public Builder file_token(String r100) {
            this.file_token = r100;
            return this;
        }

        public Builder local_path(String r100) {
            this.local_path = r100;
            return this;
        }

        public Builder priority(Integer r100) {
            this.priority = r100;
            return this;
        }

        public Builder relative_path(Boolean r100) {
            this.relative_path = r100;
            return this;
        }

        public Builder remote_url(String r100) {
            this.remote_url = r100;
            return this;
        }

        public Builder reverse_order(Boolean r100) {
            this.reverse_order = r100;
            return this;
        }

        public Builder tea_params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.tea_params = r100;
            return this;
        }

        public Builder with_slice(Boolean r100) {
            this.with_slice = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DownloadNormalRequest extends ProtoAdapter<DownloadNormalRequest> implements c<DownloadNormalRequest> {
        private final ProtoAdapter<Map<String, String>> tea_params;

        public ProtoAdapter_DownloadNormalRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DownloadNormalRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.tea_params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DownloadNormalRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.local_path = "";
            r101.remote_url = "";
            r101.priority = 0;
            r101.data_version = "";
            Boolean r102 = Boolean.FALSE;
            r101.relative_path = r102;
            r101.with_slice = r102;
            r101.file_size = "";
            r101.reverse_order = Boolean.TRUE;
            r101.extra = "";
            r101.api_type = DownloadRequest.ApiType.DRIVE;
            r101.file_token = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L23;
            switch(r104) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L25;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L25:
            r101.api_type = DownloadRequest.ApiType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.download_ranges.add(DownloadRange.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.file_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.extra = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.tea_params.putAll(this.tea_params.decode(r100));
            goto L3
        L15:
            r101.reverse_order = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.file_size = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.with_slice = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.relative_path = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.data_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.priority = ProtoAdapter.INT32.decode(r100);
            goto L3
        L21:
            r101.remote_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.local_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DownloadNormalRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.local_path) + r101.encodedSizeWithTag(2, r100.remote_url);
            Integer r103 = r100.priority;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.data_version;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.relative_path;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.with_slice;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.file_size;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            Boolean r119 = r100.reverse_order;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r119);
        L26:
            int r121 = (r118 + r120) + this.tea_params.encodedSizeWithTag(9, r100.tea_params);
            String r122 = r100.extra;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(10, r122);
        L30:
            int r124 = r121 + r123;
            DownloadRequest.ApiType r125 = r100.api_type;
            if (r125 == null) goto L33;
            int r126 = DownloadRequest.ApiType.ADAPTER.encodedSizeWithTag(11, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.file_token;
            if (r128 == null) goto L38;
            r104 = r101.encodedSizeWithTag(12, r128);
        L38:
            return ((r127 + r104) + DownloadRange.ADAPTER.asRepeated().encodedSizeWithTag(13, r100.download_ranges)) + r100.unknownFields().size();
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DownloadNormalRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DownloadNormalRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DownloadNormalRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.local_path);
            r102.encodeWithTag(r100, 2, r101.remote_url);
            Integer r103 = r101.priority;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.data_version;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Boolean r105 = r101.relative_path;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L11:
            Boolean r106 = r101.with_slice;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.file_size;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 7, r107);
        L17:
            Boolean r108 = r101.reverse_order;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
        L20:
            this.tea_params.encodeWithTag(r100, 9, r101.tea_params);
            String r109 = r101.extra;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 10, r109);
        L23:
            DownloadRequest.ApiType r110 = r101.api_type;
            if (r110 == null) goto L26;
            DownloadRequest.ApiType.ADAPTER.encodeWithTag(r100, 11, r110);
        L26:
            String r111 = r101.file_token;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 12, r111);
        L29:
            DownloadRange.ADAPTER.asRepeated().encodeWithTag(r100, 13, r101.download_ranges);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DownloadNormalRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DownloadNormalRequest r100 = new ProtoAdapter_DownloadNormalRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_PRIORITY = 0;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_RELATIVE_PATH = r101;
        DEFAULT_WITH_SLICE = r101;
        DEFAULT_REVERSE_ORDER = Boolean.TRUE;
        DEFAULT_API_TYPE = DownloadRequest.ApiType.DRIVE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.local_path = this.local_path;
        r100.remote_url = this.remote_url;
        r100.priority = this.priority;
        r100.data_version = this.data_version;
        r100.relative_path = this.relative_path;
        r100.with_slice = this.with_slice;
        r100.file_size = this.file_size;
        r100.reverse_order = this.reverse_order;
        r100.tea_params = Internal.copyOf("tea_params", this.tea_params);
        r100.extra = this.extra;
        r100.api_type = this.api_type;
        r100.file_token = this.file_token;
        r100.download_ranges = Internal.copyOf("download_ranges", this.download_ranges);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DownloadNormalRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DownloadNormalRequest(String r110, String r111, Integer r112, String r113, Boolean r210, Boolean r211, String r212, Boolean r213, Map<String, String> r214, String r215, DownloadRequest.ApiType r216, String r217, List<DownloadRange> r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public DownloadNormalRequest(String r100, String r101, Integer r102, String r103, Boolean r104, Boolean r105, String r106, Boolean r107, Map<String, String> r110, String r111, DownloadRequest.ApiType r112, String r113, List<DownloadRange> r114, ByteString r115) {
        super(ADAPTER, r115);
        this.local_path = r100;
        this.remote_url = r101;
        this.priority = r102;
        this.data_version = r103;
        this.relative_path = r104;
        this.with_slice = r105;
        this.file_size = r106;
        this.reverse_order = r107;
        this.tea_params = Internal.immutableCopyOf("tea_params", r110);
        this.extra = r111;
        this.api_type = r112;
        this.file_token = r113;
        this.download_ranges = Internal.immutableCopyOf("download_ranges", r114);
    }
}
