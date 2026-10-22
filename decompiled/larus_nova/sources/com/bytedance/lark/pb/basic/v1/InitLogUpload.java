package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class InitLogUpload extends com.squareup.wire.Message<InitLogUpload, Builder> {
    public static final ProtoAdapter<InitLogUpload> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE_STREAM_UPLOAD = null;
    public static final String DEFAULT_LOG_PATH = "";
    private static final long serialVersionUID = 0;
    public final Boolean enable_stream_upload;
    public final List<LogPathWithType> extra_log_path;
    public final String log_path;

    public static final class Builder extends com.squareup.wire.Message.Builder<InitLogUpload, Builder> {
        public Boolean enable_stream_upload;
        public List<LogPathWithType> extra_log_path;
        public String log_path;

        @Override // com.squareup.wire.Message.Builder
        public InitLogUpload build() {
            return new InitLogUpload(this.log_path, this.extra_log_path, this.enable_stream_upload, super.buildUnknownFields());
        }

        public Builder() {
            this.extra_log_path = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder enable_stream_upload(Boolean r100) {
            this.enable_stream_upload = r100;
            return this;
        }

        public Builder extra_log_path(List<LogPathWithType> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra_log_path = r100;
            return this;
        }

        public Builder log_path(String r100) {
            this.log_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_InitLogUpload extends ProtoAdapter<InitLogUpload> {
        public ProtoAdapter_InitLogUpload() {
            super(FieldEncoding.LENGTH_DELIMITED, InitLogUpload.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InitLogUpload decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.log_path = "";
            r101.enable_stream_upload = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.log_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.extra_log_path.add(LogPathWithType.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.enable_stream_upload = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(InitLogUpload r100) {
            String r101 = r100.log_path;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + LogPathWithType.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.extra_log_path);
            Boolean r105 = r100.enable_stream_upload;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ InitLogUpload decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InitLogUpload r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InitLogUpload r101) throws IOException {
            String r102 = r101.log_path;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            LogPathWithType.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.extra_log_path);
            Boolean r103 = r101.enable_stream_upload;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InitLogUpload r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_InitLogUpload();
        DEFAULT_ENABLE_STREAM_UPLOAD = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.log_path = this.log_path;
        r100.extra_log_path = Internal.copyOf("extra_log_path", this.extra_log_path);
        r100.enable_stream_upload = this.enable_stream_upload;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InitLogUpload.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public InitLogUpload(String r100, List<LogPathWithType> r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public InitLogUpload(String r100, List<LogPathWithType> r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.log_path = r100;
        this.extra_log_path = Internal.immutableCopyOf("extra_log_path", r101);
        this.enable_stream_upload = r102;
    }
}
