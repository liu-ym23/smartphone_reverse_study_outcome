package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
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
public final class BatchHardLinkResourcesV2Response extends Message<BatchHardLinkResourcesV2Response, Builder> {
    public static final ProtoAdapter<BatchHardLinkResourcesV2Response> ADAPTER = null;
    public static final ProtoAdapter_BatchHardLinkResourcesV2Response RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<OldToNewEntity> old_new_keys;

    public static final class Builder extends Message.Builder<BatchHardLinkResourcesV2Response, Builder> implements d<BatchHardLinkResourcesV2Response> {
        public List<OldToNewEntity> old_new_keys;

        @Override // com.squareup.wire.Message.Builder
        public BatchHardLinkResourcesV2Response build() {
            return new BatchHardLinkResourcesV2Response(this.old_new_keys, super.buildUnknownFields());
        }

        public Builder() {
            this.old_new_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder old_new_keys(List<OldToNewEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.old_new_keys = r100;
            return this;
        }
    }

    public static final class OldToNewEntity extends Message<OldToNewEntity, Builder> {
        public static final ProtoAdapter<OldToNewEntity> ADAPTER = null;
        public static final Integer DEFAULT_ERR_CODE = null;
        public static final String DEFAULT_ERR_MSG = "";
        public static final String DEFAULT_OLD_TOKEN = "";
        private static final long serialVersionUID = 0;
        public final Integer err_code;
        public final String err_msg;
        public final ImageSetPassThrough new_image;
        public final Video new_video;
        public final String old_token;

        public static final class Builder extends Message.Builder<OldToNewEntity, Builder> {
            public Integer err_code;
            public String err_msg;
            public ImageSetPassThrough new_image;
            public Video new_video;
            public String old_token;

            @Override // com.squareup.wire.Message.Builder
            public OldToNewEntity build() {
                String r100 = this.old_token;
                if (r100 == null) goto L7;
                return new OldToNewEntity(this.old_token, this.new_image, this.new_video, this.err_code, this.err_msg, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "old_token"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder err_code(Integer r100) {
                this.err_code = r100;
                return this;
            }

            public Builder err_msg(String r100) {
                this.err_msg = r100;
                return this;
            }

            public Builder new_image(ImageSetPassThrough r100) {
                this.new_image = r100;
                return this;
            }

            public Builder new_video(Video r100) {
                this.new_video = r100;
                return this;
            }

            public Builder old_token(String r100) {
                this.old_token = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OldToNewEntity extends ProtoAdapter<OldToNewEntity> {
            public ProtoAdapter_OldToNewEntity() {
                super(FieldEncoding.LENGTH_DELIMITED, OldToNewEntity.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OldToNewEntity decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.old_token = "";
                r101.err_code = 0;
                r101.err_msg = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.old_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.new_image = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.new_video = Video.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r103 != 7) goto L14;
                r101.err_code = ProtoAdapter.INT32.decode(r100);
                goto L3
            L14:
                if (r103 != 8) goto L15;
                r101.err_msg = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(OldToNewEntity r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.old_token);
                ImageSetPassThrough r103 = r100.new_image;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                Video r107 = r100.new_video;
                if (r107 == null) goto L9;
                int r108 = Video.ADAPTER.encodedSizeWithTag(3, r107);
            L10:
                int r109 = r106 + r108;
                Integer r110 = r100.err_code;
                if (r110 == null) goto L13;
                int r111 = ProtoAdapter.INT32.encodedSizeWithTag(7, r110);
            L14:
                int r112 = r109 + r111;
                String r113 = r100.err_msg;
                if (r113 == null) goto L18;
                r104 = r101.encodedSizeWithTag(8, r113);
            L18:
                return (r112 + r104) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ OldToNewEntity decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OldToNewEntity r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OldToNewEntity r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.old_token);
                ImageSetPassThrough r103 = r101.new_image;
                if (r103 == null) goto L5;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 2, r103);
            L5:
                Video r104 = r101.new_video;
                if (r104 == null) goto L8;
                Video.ADAPTER.encodeWithTag(r100, 3, r104);
            L8:
                Integer r105 = r101.err_code;
                if (r105 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 7, r105);
            L11:
                String r106 = r101.err_msg;
                if (r106 == null) goto L14;
                r102.encodeWithTag(r100, 8, r106);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OldToNewEntity r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OldToNewEntity();
            DEFAULT_ERR_CODE = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.old_token = this.old_token;
            r100.new_image = this.new_image;
            r100.new_video = this.new_video;
            r100.err_code = this.err_code;
            r100.err_msg = this.err_msg;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OldToNewEntity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OldToNewEntity(String r100, ImageSetPassThrough r101, Video r110, Integer r111, String r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public OldToNewEntity(String r100, ImageSetPassThrough r101, Video r102, Integer r103, String r104, ByteString r105) {
            super(ADAPTER, r105);
            this.old_token = r100;
            this.new_image = r101;
            this.new_video = r102;
            this.err_code = r103;
            this.err_msg = r104;
        }
    }

    public static final class ProtoAdapter_BatchHardLinkResourcesV2Response extends ProtoAdapter<BatchHardLinkResourcesV2Response> implements c<BatchHardLinkResourcesV2Response> {
        public ProtoAdapter_BatchHardLinkResourcesV2Response() {
            super(FieldEncoding.LENGTH_DELIMITED, BatchHardLinkResourcesV2Response.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BatchHardLinkResourcesV2Response decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.old_new_keys.add(OldToNewEntity.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BatchHardLinkResourcesV2Response r100) {
            return OldToNewEntity.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.old_new_keys) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BatchHardLinkResourcesV2Response decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BatchHardLinkResourcesV2Response r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BatchHardLinkResourcesV2Response r101) throws IOException {
            OldToNewEntity.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.old_new_keys);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BatchHardLinkResourcesV2Response r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Video extends Message<Video, Builder> {
        public static final ProtoAdapter<Video> ADAPTER = null;
        public static final Long DEFAULT_DURATION = null;
        public static final String DEFAULT_FILE_KEY = "";
        private static final long serialVersionUID = 0;
        public final ImageSetPassThrough cover_image;
        public final Long duration;
        public final String file_key;

        public static final class Builder extends Message.Builder<Video, Builder> {
            public ImageSetPassThrough cover_image;
            public Long duration;
            public String file_key;

            @Override // com.squareup.wire.Message.Builder
            public Video build() {
                String r100 = this.file_key;
                if (r100 == null) goto L7;
                return new Video(this.file_key, this.cover_image, this.duration, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "file_key"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder cover_image(ImageSetPassThrough r100) {
                this.cover_image = r100;
                return this;
            }

            public Builder duration(Long r100) {
                this.duration = r100;
                return this;
            }

            public Builder file_key(String r100) {
                this.file_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Video extends ProtoAdapter<Video> {
            public ProtoAdapter_Video() {
                super(FieldEncoding.LENGTH_DELIMITED, Video.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Video decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.file_key = "";
                r101.duration = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.file_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.cover_image = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.duration = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(Video r100) {
                int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.file_key);
                ImageSetPassThrough r102 = r100.cover_image;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                Long r106 = r100.duration;
                if (r106 == null) goto L10;
                r103 = ProtoAdapter.INT64.encodedSizeWithTag(3, r106);
            L10:
                return (r105 + r103) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Video decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Video r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Video r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.file_key);
                ImageSetPassThrough r102 = r101.cover_image;
                if (r102 == null) goto L5;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 2, r102);
            L5:
                Long r103 = r101.duration;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Video r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Video();
            DEFAULT_DURATION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.file_key = this.file_key;
            r100.cover_image = this.cover_image;
            r100.duration = this.duration;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Video.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Video(String r100, ImageSetPassThrough r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Video(String r100, ImageSetPassThrough r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.file_key = r100;
            this.cover_image = r101;
            this.duration = r102;
        }
    }

    static {
        ProtoAdapter_BatchHardLinkResourcesV2Response r100 = new ProtoAdapter_BatchHardLinkResourcesV2Response();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.old_new_keys = Internal.copyOf("old_new_keys", this.old_new_keys);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BatchHardLinkResourcesV2Response.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BatchHardLinkResourcesV2Response(List<OldToNewEntity> r100) {
        this(r100, ByteString.EMPTY);
    }

    public BatchHardLinkResourcesV2Response(List<OldToNewEntity> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.old_new_keys = Internal.immutableCopyOf("old_new_keys", r100);
    }
}
