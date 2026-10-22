package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ShareObject extends Message<ShareObject, Builder> {
    public static final ProtoAdapter<ShareObject> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FileManagerObject file_manager_object;

    public static final class Builder extends Message.Builder<ShareObject, Builder> {
        public FileManagerObject file_manager_object;

        @Override // com.squareup.wire.Message.Builder
        public ShareObject build() {
            return new ShareObject(this.file_manager_object, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_manager_object(FileManagerObject r100) {
            this.file_manager_object = r100;
            return this;
        }
    }

    public static final class FileManagerObject extends Message<FileManagerObject, Builder> {
        public static final ProtoAdapter<FileManagerObject> ADAPTER = null;
        public static final String DEFAULT_FILE_KEY = "";
        public static final String DEFAULT_ORIGIN_MESSAGE_ID = "";
        private static final long serialVersionUID = 0;
        public final String file_key;
        public final String origin_message_id;

        public static final class Builder extends Message.Builder<FileManagerObject, Builder> {
            public String file_key;
            public String origin_message_id;

            @Override // com.squareup.wire.Message.Builder
            public FileManagerObject build() {
                String r100 = this.file_key;
                if (r100 == null) goto L7;
                return new FileManagerObject(this.file_key, this.origin_message_id, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "file_key"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder file_key(String r100) {
                this.file_key = r100;
                return this;
            }

            public Builder origin_message_id(String r100) {
                this.origin_message_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FileManagerObject extends ProtoAdapter<FileManagerObject> {
            public ProtoAdapter_FileManagerObject() {
                super(FieldEncoding.LENGTH_DELIMITED, FileManagerObject.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FileManagerObject decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.file_key = "";
                r101.origin_message_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.file_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.origin_message_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(FileManagerObject r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.file_key);
                String r103 = r100.origin_message_id;
                if (r103 == null) goto L5;
                int r104 = r101.encodedSizeWithTag(2, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FileManagerObject decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FileManagerObject r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FileManagerObject r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.file_key);
                String r103 = r101.origin_message_id;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileManagerObject r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FileManagerObject();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.file_key = this.file_key;
            r100.origin_message_id = this.origin_message_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FileManagerObject.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public FileManagerObject(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public FileManagerObject(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.file_key = r100;
            this.origin_message_id = r101;
        }
    }

    public static final class ProtoAdapter_ShareObject extends ProtoAdapter<ShareObject> {
        public ProtoAdapter_ShareObject() {
            super(FieldEncoding.LENGTH_DELIMITED, ShareObject.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ShareObject decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.file_manager_object(FileManagerObject.ADAPTER.decode(r100));
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
        public int encodedSize2(ShareObject r100) {
            FileManagerObject r101 = r100.file_manager_object;
            if (r101 == null) goto L5;
            int r102 = FileManagerObject.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ShareObject decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ShareObject r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ShareObject r101) throws IOException {
            FileManagerObject r102 = r101.file_manager_object;
            if (r102 == null) goto L5;
            FileManagerObject.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareObject r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ShareObject();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_manager_object = this.file_manager_object;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ShareObject.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ShareObject(FileManagerObject r100) {
        this(r100, ByteString.EMPTY);
    }

    public ShareObject(FileManagerObject r100, ByteString r101) {
        super(ADAPTER, r101);
        this.file_manager_object = r100;
    }
}
