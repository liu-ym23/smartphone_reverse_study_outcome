package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class DownloadResourceByUrlRequest extends Message<DownloadResourceByUrlRequest, Builder> {
    public static final ProtoAdapter<DownloadResourceByUrlRequest> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final Boolean DEFAULT_NEED_PROGRESS = null;
    public static final String DEFAULT_PATH = "";
    public static final Boolean DEFAULT_SHOULD_ADD_SECURITY_PROPERTY = null;
    public static final Boolean DEFAULT_SHOULD_LIMIT_SPEED = null;
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_DownloadResourceByUrlRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> headers;
    public final String key;
    public final Boolean need_progress;
    public final String path;
    public final Boolean should_add_security_property;
    public final Boolean should_limit_speed;
    public final String url;

    public static final class Builder extends Message.Builder<DownloadResourceByUrlRequest, Builder> implements d<DownloadResourceByUrlRequest> {
        public Map<String, String> headers;
        public String key;
        public Boolean need_progress;
        public String path;
        public Boolean should_add_security_property;
        public Boolean should_limit_speed;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public DownloadResourceByUrlRequest build() {
            return new DownloadResourceByUrlRequest(this.key, this.path, this.url, this.headers, this.need_progress, this.should_limit_speed, this.should_add_security_property, super.buildUnknownFields());
        }

        public Builder() {
            this.headers = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder headers(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.headers = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder need_progress(Boolean r100) {
            this.need_progress = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder should_add_security_property(Boolean r100) {
            this.should_add_security_property = r100;
            return this;
        }

        public Builder should_limit_speed(Boolean r100) {
            this.should_limit_speed = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DownloadResourceByUrlRequest extends ProtoAdapter<DownloadResourceByUrlRequest> implements c<DownloadResourceByUrlRequest> {
        private final ProtoAdapter<Map<String, String>> headers;

        public ProtoAdapter_DownloadResourceByUrlRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DownloadResourceByUrlRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.headers = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DownloadResourceByUrlRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.path = "";
            r101.url = "";
            Boolean r102 = Boolean.TRUE;
            r101.need_progress = r102;
            r101.should_limit_speed = Boolean.FALSE;
            r101.should_add_security_property = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L14;
            switch(r104) {
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
            r101.should_add_security_property = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.should_limit_speed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.need_progress = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.headers.putAll(this.headers.decode(r100));
            goto L3
        L11:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DownloadResourceByUrlRequest r100) {
            String r101 = r100.key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.path;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.url;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + this.headers.encodedSizeWithTag(4, r100.headers);
            Boolean r110 = r100.need_progress;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.should_limit_speed;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.should_add_security_property;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r116);
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
        public /* bridge */ /* synthetic */ DownloadResourceByUrlRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DownloadResourceByUrlRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DownloadResourceByUrlRequest r101) throws IOException {
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.path;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            this.headers.encodeWithTag(r100, 4, r101.headers);
            Boolean r105 = r101.need_progress;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.should_limit_speed;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L17:
            Boolean r107 = r101.should_add_security_property;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DownloadResourceByUrlRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DownloadResourceByUrlRequest r100 = new ProtoAdapter_DownloadResourceByUrlRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.TRUE;
        DEFAULT_NEED_PROGRESS = r101;
        DEFAULT_SHOULD_LIMIT_SPEED = Boolean.FALSE;
        DEFAULT_SHOULD_ADD_SECURITY_PROPERTY = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.path = this.path;
        r100.url = this.url;
        r100.headers = Internal.copyOf("headers", this.headers);
        r100.need_progress = this.need_progress;
        r100.should_limit_speed = this.should_limit_speed;
        r100.should_add_security_property = this.should_add_security_property;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DownloadResourceByUrlRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DownloadResourceByUrlRequest(String r110, String r111, String r112, Map<String, String> r113, Boolean r114, Boolean r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public DownloadResourceByUrlRequest(String r100, String r101, String r102, Map<String, String> r103, Boolean r104, Boolean r105, Boolean r106, ByteString r107) {
        super(ADAPTER, r107);
        this.key = r100;
        this.path = r101;
        this.url = r102;
        this.headers = Internal.immutableCopyOf("headers", r103);
        this.need_progress = r104;
        this.should_limit_speed = r105;
        this.should_add_security_property = r106;
    }
}
