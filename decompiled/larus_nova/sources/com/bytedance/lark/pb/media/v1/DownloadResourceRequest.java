package com.bytedance.lark.pb.media.v1;

import com.google.protobuf.MessageOptions;
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
public final class DownloadResourceRequest extends Message<DownloadResourceRequest, Builder> {
    public static final ProtoAdapter<DownloadResourceRequest> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final Boolean DEFAULT_NEED_PROGRESS = null;
    public static final String DEFAULT_PATH = "";
    public static final Boolean DEFAULT_SHOULD_ADD_SECURITY_PROPERTY = null;
    public static final Boolean DEFAULT_SHOULD_LIMIT_SPEED = null;
    public static final String DEFAULT_URL = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_DownloadResourceRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> headers;
    public final String key;
    public final Boolean need_progress;
    public final String path;
    public final Boolean should_add_security_property;
    public final Boolean should_limit_speed;
    public final String url;

    public static final class Builder extends Message.Builder<DownloadResourceRequest, Builder> implements d<DownloadResourceRequest> {
        public Map<String, String> headers;
        public String key;
        public Boolean need_progress;
        public String path;
        public Boolean should_add_security_property;
        public Boolean should_limit_speed;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public DownloadResourceRequest build() {
            String r100 = this.key;
            if (r100 == null) goto L11;
            if (this.path == null) goto L11;
            if (this.url == null) goto L11;
            return new DownloadResourceRequest(this.key, this.path, this.url, this.headers, this.need_progress, this.should_limit_speed, this.should_add_security_property, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.path, "path", this.url, "url"});
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

    public static final class ProtoAdapter_DownloadResourceRequest extends ProtoAdapter<DownloadResourceRequest> implements c<DownloadResourceRequest> {
        private final ProtoAdapter<Map<String, String>> headers;

        public ProtoAdapter_DownloadResourceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DownloadResourceRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.headers = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DownloadResourceRequest decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(DownloadResourceRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.key) + r101.encodedSizeWithTag(2, r100.path)) + r101.encodedSizeWithTag(3, r100.url)) + this.headers.encodedSizeWithTag(4, r100.headers);
            Boolean r103 = r100.need_progress;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.should_limit_speed;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.should_add_security_property;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DownloadResourceRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DownloadResourceRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DownloadResourceRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key);
            r102.encodeWithTag(r100, 2, r101.path);
            r102.encodeWithTag(r100, 3, r101.url);
            this.headers.encodeWithTag(r100, 4, r101.headers);
            Boolean r103 = r101.need_progress;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r103);
        L5:
            Boolean r104 = r101.should_limit_speed;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r104);
        L8:
            Boolean r105 = r101.should_add_security_property;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DownloadResourceRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DownloadResourceRequest r100 = new ProtoAdapter_DownloadResourceRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MessageOptions.Builder r101 = new MessageOptions.Builder();
        Boolean r102 = Boolean.TRUE;
        MESSAGE_OPTIONS = r101.deprecated(r102).build();
        DEFAULT_NEED_PROGRESS = r102;
        DEFAULT_SHOULD_LIMIT_SPEED = Boolean.FALSE;
        DEFAULT_SHOULD_ADD_SECURITY_PROPERTY = r102;
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
        return DownloadResourceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DownloadResourceRequest(String r110, String r111, String r112, Map<String, String> r113, Boolean r114, Boolean r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public DownloadResourceRequest(String r100, String r101, String r102, Map<String, String> r103, Boolean r104, Boolean r105, Boolean r106, ByteString r107) {
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
