package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class BrowseFolderRequest extends Message<BrowseFolderRequest, Builder> {
    public static final ProtoAdapter<BrowseFolderRequest> ADAPTER = null;
    public static final DownloadFileScene DEFAULT_SCENE = null;
    public static final ProtoAdapter_BrowseFolderRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DownloadFileOptions options;
    public final DownloadFileScene scene;
    public final SerReq ser_req;

    public static final class Builder extends Message.Builder<BrowseFolderRequest, Builder> implements d<BrowseFolderRequest> {
        public DownloadFileOptions options;
        public DownloadFileScene scene;
        public SerReq ser_req;

        @Override // com.squareup.wire.Message.Builder
        public BrowseFolderRequest build() {
            SerReq r100 = this.ser_req;
            if (r100 == null) goto L7;
            return new BrowseFolderRequest(this.ser_req, this.scene, this.options, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "ser_req"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder options(DownloadFileOptions r100) {
            this.options = r100;
            return this;
        }

        public Builder scene(DownloadFileScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder ser_req(SerReq r100) {
            this.ser_req = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BrowseFolderRequest extends ProtoAdapter<BrowseFolderRequest> implements c<BrowseFolderRequest> {
        public ProtoAdapter_BrowseFolderRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BrowseFolderRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BrowseFolderRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene = DownloadFileScene.CHAT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.ser_req = SerReq.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.scene = DownloadFileScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.options = DownloadFileOptions.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BrowseFolderRequest r100) {
            int r101 = SerReq.ADAPTER.encodedSizeWithTag(1, r100.ser_req);
            DownloadFileScene r102 = r100.scene;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = DownloadFileScene.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            DownloadFileOptions r106 = r100.options;
            if (r106 == null) goto L10;
            r103 = DownloadFileOptions.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BrowseFolderRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BrowseFolderRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BrowseFolderRequest r101) throws IOException {
            SerReq.ADAPTER.encodeWithTag(r100, 1, r101.ser_req);
            DownloadFileScene r102 = r101.scene;
            if (r102 == null) goto L5;
            DownloadFileScene.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            DownloadFileOptions r103 = r101.options;
            if (r103 == null) goto L8;
            DownloadFileOptions.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BrowseFolderRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SerReq extends Message<SerReq, Builder> {
        public static final ProtoAdapter<SerReq> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        public static final Direction DEFAULT_ORDER_DIRECTION = null;
        public static final IndexKey DEFAULT_ORDER_TYPE = null;
        public static final Long DEFAULT_START = null;
        public static final Long DEFAULT_STEP = null;
        private static final long serialVersionUID = 0;
        public final String key;
        public final Direction order_direction;
        public final IndexKey order_type;
        public final Long start;
        public final Long step;

        public static final class Builder extends Message.Builder<SerReq, Builder> {
            public String key;
            public Direction order_direction;
            public IndexKey order_type;
            public Long start;
            public Long step;

            @Override // com.squareup.wire.Message.Builder
            public SerReq build() {
                String r100 = this.key;
                if (r100 == null) goto L11;
                if (this.start == null) goto L11;
                if (this.step == null) goto L11;
                return new SerReq(this.key, this.start, this.step, this.order_type, this.order_direction, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r100, "key", this.start, "start", this.step, "step"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }

            public Builder order_direction(Direction r100) {
                this.order_direction = r100;
                return this;
            }

            public Builder order_type(IndexKey r100) {
                this.order_type = r100;
                return this;
            }

            public Builder start(Long r100) {
                this.start = r100;
                return this;
            }

            public Builder step(Long r100) {
                this.step = r100;
                return this;
            }
        }

        public static final enum Direction extends Enum<Direction> implements WireEnum {
            private static final /* synthetic */ Direction[] $VALUES = null;
            public static final ProtoAdapter<Direction> ADAPTER = null;
            public static final Direction ASC = null;
            public static final Direction DESC = null;
            private final int value;

            static {
                Direction r100 = new Direction("DESC", 0, 1);
                DESC = r100;
                Direction r101 = new Direction("ASC", 1, 2);
                ASC = r101;
                $VALUES = new Direction[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(Direction.class);
            }

            public static Direction[] values() {
                return (Direction[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Direction fromValue(int r100) {
                if (r100 == 1) goto L11;
                if (r100 == 2) goto L9;
                return null;
            L9:
                return ASC;
            L11:
                return DESC;
            }

            public static Direction valueOf(String r100) {
                return (Direction) a.a(Direction.class, r100);
            }

            private Direction(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum IndexKey extends Enum<IndexKey> implements WireEnum {
            private static final /* synthetic */ IndexKey[] $VALUES = null;
            public static final ProtoAdapter<IndexKey> ADAPTER = null;
            public static final IndexKey CREATE_TIME = null;
            public static final IndexKey NAME = null;
            public static final IndexKey SIZE = null;
            private final int value;

            static {
                IndexKey r100 = new IndexKey("CREATE_TIME", 0, 1);
                CREATE_TIME = r100;
                IndexKey r101 = new IndexKey("SIZE", 1, 2);
                SIZE = r101;
                IndexKey r102 = new IndexKey("NAME", 2, 3);
                NAME = r102;
                $VALUES = new IndexKey[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(IndexKey.class);
            }

            public static IndexKey[] values() {
                return (IndexKey[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static IndexKey fromValue(int r100) {
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L13;
                if (r100 == 3) goto L11;
                return null;
            L11:
                return NAME;
            L13:
                return SIZE;
            L15:
                return CREATE_TIME;
            }

            public static IndexKey valueOf(String r100) {
                return (IndexKey) a.a(IndexKey.class, r100);
            }

            private IndexKey(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_SerReq extends ProtoAdapter<SerReq> {
            public ProtoAdapter_SerReq() {
                super(FieldEncoding.LENGTH_DELIMITED, SerReq.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SerReq decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                r101.start = 0L;
                r101.step = 0L;
                r101.order_type = IndexKey.CREATE_TIME;
                r101.order_direction = Direction.DESC;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L27;
                if (r103 != 1) goto L8;
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.start = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.step = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.order_type = IndexKey.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.order_direction = Direction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L27:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SerReq r100) {
                int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.key);
                ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
                int r103 = (r101 + r102.encodedSizeWithTag(2, r100.start)) + r102.encodedSizeWithTag(3, r100.step);
                IndexKey r104 = r100.order_type;
                int r105 = 0;
                if (r104 == null) goto L5;
                int r106 = IndexKey.ADAPTER.encodedSizeWithTag(4, r104);
            L6:
                int r107 = r103 + r106;
                Direction r108 = r100.order_direction;
                if (r108 == null) goto L10;
                r105 = Direction.ADAPTER.encodedSizeWithTag(5, r108);
            L10:
                return (r107 + r105) + r100.unknownFields().size();
            L5:
                r106 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SerReq decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SerReq r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SerReq r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.key);
                ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
                r102.encodeWithTag(r100, 2, r101.start);
                r102.encodeWithTag(r100, 3, r101.step);
                IndexKey r103 = r101.order_type;
                if (r103 == null) goto L5;
                IndexKey.ADAPTER.encodeWithTag(r100, 4, r103);
            L5:
                Direction r104 = r101.order_direction;
                if (r104 == null) goto L8;
                Direction.ADAPTER.encodeWithTag(r100, 5, r104);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SerReq r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SerReq();
            DEFAULT_START = 0L;
            DEFAULT_STEP = 0L;
            DEFAULT_ORDER_TYPE = IndexKey.CREATE_TIME;
            DEFAULT_ORDER_DIRECTION = Direction.DESC;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.start = this.start;
            r100.step = this.step;
            r100.order_type = this.order_type;
            r100.order_direction = this.order_direction;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SerReq.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SerReq(String r100, Long r101, Long r110, IndexKey r111, Direction r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public SerReq(String r100, Long r101, Long r102, IndexKey r103, Direction r104, ByteString r105) {
            super(ADAPTER, r105);
            this.key = r100;
            this.start = r101;
            this.step = r102;
            this.order_type = r103;
            this.order_direction = r104;
        }
    }

    static {
        ProtoAdapter_BrowseFolderRequest r100 = new ProtoAdapter_BrowseFolderRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE = DownloadFileScene.CHAT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ser_req = this.ser_req;
        r100.scene = this.scene;
        r100.options = this.options;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BrowseFolderRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BrowseFolderRequest(SerReq r100, DownloadFileScene r101, DownloadFileOptions r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public BrowseFolderRequest(SerReq r100, DownloadFileScene r101, DownloadFileOptions r102, ByteString r103) {
        super(ADAPTER, r103);
        this.ser_req = r100;
        this.scene = r101;
        this.options = r102;
    }
}
