package com.bytedance.lark.pb.im.v1;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class ShareAsMessageResponse extends Message<ShareAsMessageResponse, Builder> {
    public static final ProtoAdapter<ShareAsMessageResponse> ADAPTER = null;
    public static final ProtoAdapter_ShareAsMessageResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FilePermCheckBlockInfo file_perm_check;
    public final List<RespInfo> resp_info;

    public static final class Builder extends Message.Builder<ShareAsMessageResponse, Builder> implements d<ShareAsMessageResponse> {
        public FilePermCheckBlockInfo file_perm_check;
        public List<RespInfo> resp_info;

        @Override // com.squareup.wire.Message.Builder
        public ShareAsMessageResponse build() {
            return new ShareAsMessageResponse(this.resp_info, this.file_perm_check, super.buildUnknownFields());
        }

        public Builder() {
            this.resp_info = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_perm_check(FilePermCheckBlockInfo r100) {
            this.file_perm_check = r100;
            return this;
        }

        public Builder resp_info(List<RespInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.resp_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ShareAsMessageResponse extends ProtoAdapter<ShareAsMessageResponse> implements c<ShareAsMessageResponse> {
        public ProtoAdapter_ShareAsMessageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ShareAsMessageResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ShareAsMessageResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.resp_info.add(RespInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.file_perm_check = FilePermCheckBlockInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ShareAsMessageResponse r100) {
            int r101 = RespInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.resp_info);
            FilePermCheckBlockInfo r102 = r100.file_perm_check;
            if (r102 == null) goto L5;
            int r103 = FilePermCheckBlockInfo.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ShareAsMessageResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ShareAsMessageResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ShareAsMessageResponse r101) throws IOException {
            RespInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.resp_info);
            FilePermCheckBlockInfo r102 = r101.file_perm_check;
            if (r102 == null) goto L5;
            FilePermCheckBlockInfo.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareAsMessageResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class RespInfo extends Message<RespInfo, Builder> {
        public static final ProtoAdapter<RespInfo> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_THREAD_ID = "";
        private static final long serialVersionUID = 0;
        public final String message_id;
        public final ShareTarget share_target;
        public final String thread_id;

        public static final class Builder extends Message.Builder<RespInfo, Builder> {
            public String message_id;
            public ShareTarget share_target;
            public String thread_id;

            @Override // com.squareup.wire.Message.Builder
            public RespInfo build() {
                ShareTarget r100 = this.share_target;
                if (r100 == null) goto L9;
                if (this.message_id == null) goto L9;
                return new RespInfo(this.share_target, this.message_id, this.thread_id, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "share_target", this.message_id, MusicAppletPage.KEY_MESSAGE_ID});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder message_id(String r100) {
                this.message_id = r100;
                return this;
            }

            public Builder share_target(ShareTarget r100) {
                this.share_target = r100;
                return this;
            }

            public Builder thread_id(String r100) {
                this.thread_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_RespInfo extends ProtoAdapter<RespInfo> {
            public ProtoAdapter_RespInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, RespInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RespInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.message_id = "";
                r101.thread_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.share_target = ShareTarget.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.message_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.thread_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(RespInfo r100) {
                int r101 = ShareTarget.ADAPTER.encodedSizeWithTag(1, r100.share_target);
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                int r103 = r101 + r102.encodedSizeWithTag(2, r100.message_id);
                String r104 = r100.thread_id;
                if (r104 == null) goto L5;
                int r105 = r102.encodedSizeWithTag(3, r104);
            L7:
                return (r103 + r105) + r100.unknownFields().size();
            L5:
                r105 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ RespInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RespInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RespInfo r101) throws IOException {
                ShareTarget.ADAPTER.encodeWithTag(r100, 1, r101.share_target);
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 2, r101.message_id);
                String r103 = r101.thread_id;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 3, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RespInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RespInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.share_target = this.share_target;
            r100.message_id = this.message_id;
            r100.thread_id = this.thread_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RespInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public RespInfo(ShareTarget r100, String r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public RespInfo(ShareTarget r100, String r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.share_target = r100;
            this.message_id = r101;
            this.thread_id = r102;
        }
    }

    static {
        ProtoAdapter_ShareAsMessageResponse r100 = new ProtoAdapter_ShareAsMessageResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.resp_info = Internal.copyOf("resp_info", this.resp_info);
        r100.file_perm_check = this.file_perm_check;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ShareAsMessageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ShareAsMessageResponse(List<RespInfo> r100, FilePermCheckBlockInfo r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ShareAsMessageResponse(List<RespInfo> r100, FilePermCheckBlockInfo r101, ByteString r102) {
        super(ADAPTER, r102);
        this.resp_info = Internal.immutableCopyOf("resp_info", r100);
        this.file_perm_check = r101;
    }
}
