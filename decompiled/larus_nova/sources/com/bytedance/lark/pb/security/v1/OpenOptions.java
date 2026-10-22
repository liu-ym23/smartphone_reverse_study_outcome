package com.bytedance.lark.pb.security.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class OpenOptions extends Message<OpenOptions, Builder> {
    public static final ProtoAdapter<OpenOptions> ADAPTER = null;
    public static final Boolean DEFAULT_APPEND = null;
    public static final Boolean DEFAULT_CREATE = null;
    public static final Boolean DEFAULT_CREATE_NEW = null;
    public static final Long DEFAULT_FD = null;
    public static final Boolean DEFAULT_LOAD_ONLY = null;
    public static final Boolean DEFAULT_READ = null;
    public static final Boolean DEFAULT_SELFHELP_MODE = null;
    public static final Boolean DEFAULT_TRUNCATE = null;
    public static final Boolean DEFAULT_WRITE = null;
    private static final long serialVersionUID = 0;
    public final Boolean append;
    public final Boolean create;
    public final Boolean create_new;

    /* JADX INFO: renamed from: fd, reason: collision with root package name */
    public final Long f253763fd;
    public final Boolean load_only;
    public final Boolean read;
    public final Boolean selfhelp_mode;
    public final Boolean truncate;
    public final Boolean write;

    public static final class Builder extends Message.Builder<OpenOptions, Builder> {
        public Boolean append;
        public Boolean create;
        public Boolean create_new;

        /* JADX INFO: renamed from: fd, reason: collision with root package name */
        public Long f253764fd;
        public Boolean load_only;
        public Boolean read;
        public Boolean selfhelp_mode;
        public Boolean truncate;
        public Boolean write;

        @Override // com.squareup.wire.Message.Builder
        public OpenOptions build() {
            return new OpenOptions(this.read, this.write, this.create, this.create_new, this.append, this.truncate, this.f253764fd, this.load_only, this.selfhelp_mode, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder append(Boolean r100) {
            this.append = r100;
            return this;
        }

        public Builder create(Boolean r100) {
            this.create = r100;
            return this;
        }

        public Builder create_new(Boolean r100) {
            this.create_new = r100;
            return this;
        }

        public Builder fd(Long r100) {
            this.f253764fd = r100;
            return this;
        }

        public Builder load_only(Boolean r100) {
            this.load_only = r100;
            return this;
        }

        public Builder read(Boolean r100) {
            this.read = r100;
            return this;
        }

        public Builder selfhelp_mode(Boolean r100) {
            this.selfhelp_mode = r100;
            return this;
        }

        public Builder truncate(Boolean r100) {
            this.truncate = r100;
            return this;
        }

        public Builder write(Boolean r100) {
            this.write = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OpenOptions extends ProtoAdapter<OpenOptions> {
        public ProtoAdapter_OpenOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpenOptions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.read = r102;
            r101.write = r102;
            r101.create = r102;
            r101.create_new = r102;
            r101.append = r102;
            r101.truncate = r102;
            r101.f253764fd = 0L;
            r101.load_only = r102;
            r101.selfhelp_mode = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L16;
            switch(r104) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.selfhelp_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.load_only = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.f253764fd = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.truncate = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.append = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.create_new = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.create = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.write = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.read = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OpenOptions r100) {
            Boolean r101 = r100.read;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.write;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.create;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.create_new;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.append;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.truncate;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.f253763fd;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.load_only;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.selfhelp_mode;
            if (r125 == null) goto L38;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ OpenOptions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenOptions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenOptions r101) throws IOException {
            Boolean r102 = r101.read;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.write;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.create;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.create_new;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.append;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.truncate;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.f253763fd;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.load_only;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.selfhelp_mode;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenOptions();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_READ = r100;
        DEFAULT_WRITE = r100;
        DEFAULT_CREATE = r100;
        DEFAULT_CREATE_NEW = r100;
        DEFAULT_APPEND = r100;
        DEFAULT_TRUNCATE = r100;
        DEFAULT_FD = 0L;
        DEFAULT_LOAD_ONLY = r100;
        DEFAULT_SELFHELP_MODE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.read = this.read;
        r100.write = this.write;
        r100.create = this.create;
        r100.create_new = this.create_new;
        r100.append = this.append;
        r100.truncate = this.truncate;
        r100.f253764fd = this.f253763fd;
        r100.load_only = this.load_only;
        r100.selfhelp_mode = this.selfhelp_mode;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenOptions(Boolean r110, Boolean r111, Boolean r112, Boolean r113, Boolean r114, Boolean r115, Long r116, Boolean r117, Boolean r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public OpenOptions(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, Long r106, Boolean r107, Boolean r110, ByteString r111) {
        super(ADAPTER, r111);
        this.read = r100;
        this.write = r101;
        this.create = r102;
        this.create_new = r103;
        this.append = r104;
        this.truncate = r105;
        this.f253763fd = r106;
        this.load_only = r107;
        this.selfhelp_mode = r110;
    }
}
