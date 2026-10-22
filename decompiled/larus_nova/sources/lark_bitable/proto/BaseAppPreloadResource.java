package lark_bitable.proto;

import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class BaseAppPreloadResource extends Message<BaseAppPreloadResource, Builder> {
    public static final ProtoAdapter<BaseAppPreloadResource> ADAPTER = null;
    public static final Integer DEFAULT_API_CODE = null;
    public static final Long DEFAULT_CACHE_ELAPSED_TIME = null;
    public static final String DEFAULT_ERROR_MSG = "";
    public static final String DEFAULT_PAYLOAD = "";
    public static final Long DEFAULT_REQUEST_START = null;
    public static final Integer DEFAULT_SCHEMA_VERSION = null;
    public static final String DEFAULT_SOURCE = "";
    public static final String DEFAULT_XTT_LOG_ID = "";
    private static final long serialVersionUID = 0;
    public final Integer api_code;
    public final Long cache_elapsed_time;
    public final String error_msg;
    public final String payload;
    public final Long request_start;
    public final Integer schema_version;
    public final String source;
    public final String xtt_log_id;

    public static final class Builder extends Message.Builder<BaseAppPreloadResource, Builder> {
        public Integer api_code;
        public Long cache_elapsed_time;
        public String error_msg;
        public String payload;
        public Long request_start;
        public Integer schema_version;
        public String source;
        public String xtt_log_id;

        @Override // com.squareup.wire.Message.Builder
        public BaseAppPreloadResource build() {
            String r100 = this.payload;
            if (r100 == null) goto L21;
            if (this.source == null) goto L21;
            if (this.cache_elapsed_time == null) goto L21;
            if (this.request_start == null) goto L21;
            if (this.api_code == null) goto L21;
            if (this.error_msg == null) goto L21;
            if (this.xtt_log_id == null) goto L21;
            if (this.schema_version == null) goto L21;
            return new BaseAppPreloadResource(this.payload, this.source, this.cache_elapsed_time, this.request_start, this.api_code, this.error_msg, this.xtt_log_id, this.schema_version, super.buildUnknownFields());
        L21:
            throw Internal.missingRequiredFields(new Object[]{r100, WsConstants.KEY_PAYLOAD, this.source, "source", this.cache_elapsed_time, "cache_elapsed_time", this.request_start, "request_start", this.api_code, "api_code", this.error_msg, "error_msg", this.xtt_log_id, "xtt_log_id", this.schema_version, "schema_version"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder api_code(Integer r100) {
            this.api_code = r100;
            return this;
        }

        public Builder cache_elapsed_time(Long r100) {
            this.cache_elapsed_time = r100;
            return this;
        }

        public Builder error_msg(String r100) {
            this.error_msg = r100;
            return this;
        }

        public Builder payload(String r100) {
            this.payload = r100;
            return this;
        }

        public Builder request_start(Long r100) {
            this.request_start = r100;
            return this;
        }

        public Builder schema_version(Integer r100) {
            this.schema_version = r100;
            return this;
        }

        public Builder source(String r100) {
            this.source = r100;
            return this;
        }

        public Builder xtt_log_id(String r100) {
            this.xtt_log_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BaseAppPreloadResource extends ProtoAdapter<BaseAppPreloadResource> {
        public ProtoAdapter_BaseAppPreloadResource() {
            super(FieldEncoding.LENGTH_DELIMITED, BaseAppPreloadResource.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public BaseAppPreloadResource decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            switch(r103) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.schema_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.xtt_log_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.error_msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.api_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.request_start = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.cache_elapsed_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.source = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.payload = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BaseAppPreloadResource r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.payload) + r101.encodedSizeWithTag(2, r100.source);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            int r104 = (r102 + r103.encodedSizeWithTag(3, r100.cache_elapsed_time)) + r103.encodedSizeWithTag(4, r100.request_start);
            ProtoAdapter<Integer> r105 = ProtoAdapter.INT32;
            return ((((r104 + r105.encodedSizeWithTag(5, r100.api_code)) + r101.encodedSizeWithTag(6, r100.error_msg)) + r101.encodedSizeWithTag(7, r100.xtt_log_id)) + r105.encodedSizeWithTag(8, r100.schema_version)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BaseAppPreloadResource decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BaseAppPreloadResource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BaseAppPreloadResource r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.payload);
            r102.encodeWithTag(r100, 2, r101.source);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            r103.encodeWithTag(r100, 3, r101.cache_elapsed_time);
            r103.encodeWithTag(r100, 4, r101.request_start);
            ProtoAdapter<Integer> r104 = ProtoAdapter.INT32;
            r104.encodeWithTag(r100, 5, r101.api_code);
            r102.encodeWithTag(r100, 6, r101.error_msg);
            r102.encodeWithTag(r100, 7, r101.xtt_log_id);
            r104.encodeWithTag(r100, 8, r101.schema_version);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BaseAppPreloadResource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BaseAppPreloadResource();
        DEFAULT_CACHE_ELAPSED_TIME = 0L;
        DEFAULT_REQUEST_START = 0L;
        DEFAULT_API_CODE = 0;
        DEFAULT_SCHEMA_VERSION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.payload = this.payload;
        r100.source = this.source;
        r100.cache_elapsed_time = this.cache_elapsed_time;
        r100.request_start = this.request_start;
        r100.api_code = this.api_code;
        r100.error_msg = this.error_msg;
        r100.xtt_log_id = this.xtt_log_id;
        r100.schema_version = this.schema_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BaseAppPreloadResource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BaseAppPreloadResource(String r110, String r111, Long r112, Long r113, Integer r114, String r115, String r116, Integer r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public BaseAppPreloadResource(String r100, String r101, Long r102, Long r103, Integer r104, String r105, String r106, Integer r107, ByteString r110) {
        super(ADAPTER, r110);
        this.payload = r100;
        this.source = r101;
        this.cache_elapsed_time = r102;
        this.request_start = r103;
        this.api_code = r104;
        this.error_msg = r105;
        this.xtt_log_id = r106;
        this.schema_version = r107;
    }
}
