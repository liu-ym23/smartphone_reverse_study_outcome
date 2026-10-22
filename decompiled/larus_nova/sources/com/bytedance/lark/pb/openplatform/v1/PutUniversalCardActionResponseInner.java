package com.bytedance.lark.pb.openplatform.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class PutUniversalCardActionResponseInner extends Message<PutUniversalCardActionResponseInner, Builder> {
    public static final ProtoAdapter<PutUniversalCardActionResponseInner> ADAPTER = null;
    public static final String DEFAULT_APP_CLI_ID = "";
    public static final FieldOptions FIELD_OPTIONS_APP_CLI_ID = null;
    public static final FieldOptions FIELD_OPTIONS_TOAST = null;
    public static final FieldOptions FIELD_OPTIONS_URL = null;
    private static final long serialVersionUID = 0;
    public final String app_cli_id;
    public final Toast toast;
    public final URL url;

    public static final class Builder extends Message.Builder<PutUniversalCardActionResponseInner, Builder> {
        public String app_cli_id;
        public Toast toast;
        public URL url;

        @Override // com.squareup.wire.Message.Builder
        public PutUniversalCardActionResponseInner build() {
            return new PutUniversalCardActionResponseInner(this.toast, this.url, this.app_cli_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_cli_id(String r100) {
            this.app_cli_id = r100;
            return this;
        }

        public Builder toast(Toast r100) {
            this.toast = r100;
            return this;
        }

        public Builder url(URL r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutUniversalCardActionResponseInner extends ProtoAdapter<PutUniversalCardActionResponseInner> {
        public ProtoAdapter_PutUniversalCardActionResponseInner() {
            super(FieldEncoding.LENGTH_DELIMITED, PutUniversalCardActionResponseInner.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutUniversalCardActionResponseInner decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_cli_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 2) goto L8;
            r101.toast = Toast.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 3) goto L10;
            r101.url = URL.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 4) goto L11;
            r101.app_cli_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PutUniversalCardActionResponseInner r100) {
            Toast r101 = r100.toast;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Toast.ADAPTER.encodedSizeWithTag(2, r101);
        L6:
            URL r104 = r100.url;
            if (r104 == null) goto L9;
            int r105 = URL.ADAPTER.encodedSizeWithTag(3, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.app_cli_id;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutUniversalCardActionResponseInner decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutUniversalCardActionResponseInner r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutUniversalCardActionResponseInner r101) throws IOException {
            Toast r102 = r101.toast;
            if (r102 == null) goto L5;
            Toast.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            URL r103 = r101.url;
            if (r103 == null) goto L8;
            URL.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.app_cli_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutUniversalCardActionResponseInner r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Toast extends Message<Toast, Builder> {
        public static final ProtoAdapter<Toast> ADAPTER = null;
        public static final Type DEFAULT_CODE = null;
        public static final String DEFAULT_CONTENT = "";
        public static final Integer DEFAULT_ERROR_CODE = null;
        public static final FieldOptions FIELD_OPTIONS_CODE = null;
        public static final FieldOptions FIELD_OPTIONS_CONTENT = null;
        public static final FieldOptions FIELD_OPTIONS_ERROR_CODE = null;
        private static final long serialVersionUID = 0;
        public final Type code;
        public final String content;
        public final Integer error_code;

        public static final class Builder extends Message.Builder<Toast, Builder> {
            public Type code;
            public String content;
            public Integer error_code;

            @Override // com.squareup.wire.Message.Builder
            public Toast build() {
                return new Toast(this.code, this.content, this.error_code, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder code(Type r100) {
                this.code = r100;
                return this;
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder error_code(Integer r100) {
                this.error_code = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Toast extends ProtoAdapter<Toast> {
            public ProtoAdapter_Toast() {
                super(FieldEncoding.LENGTH_DELIMITED, Toast.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Toast decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.code = Type.info;
                r101.content = "";
                r101.error_code = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.code = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.error_code = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(Toast r100) {
                Type r101 = r100.code;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.content;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.error_code;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Toast decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Toast r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Toast r101) throws IOException {
                Type r102 = r101.code;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.content;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.error_code;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Toast r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type error = null;
            public static final Type info = null;
            public static final Type success = null;
            public static final Type warning = null;
            private final int value;

            static {
                Type r100 = new Type("info", 0, 1);
                info = r100;
                Type r101 = new Type("success", 1, 2);
                success = r101;
                Type r102 = new Type("error", 2, 3);
                error = r102;
                Type r103 = new Type("warning", 3, 4);
                warning = r103;
                $VALUES = new Type[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 1) goto L19;
                if (r100 == 2) goto L17;
                if (r100 == 3) goto L15;
                if (r100 == 4) goto L13;
                return null;
            L13:
                return warning;
            L15:
                return error;
            L17:
                return success;
            L19:
                return info;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Toast();
            FIELD_OPTIONS_CODE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_CONTENT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_ERROR_CODE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_CODE = Type.info;
            DEFAULT_ERROR_CODE = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.code = this.code;
            r100.content = this.content;
            r100.error_code = this.error_code;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Toast.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Toast(Type r100, String r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Toast(Type r100, String r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.code = r100;
            this.content = r101;
            this.error_code = r102;
        }
    }

    public static final class URL extends Message<URL, Builder> {
        public static final ProtoAdapter<URL> ADAPTER = null;
        public static final String DEFAULT_ANDROID_URL = "";
        public static final String DEFAULT_IOS_URL = "";
        public static final String DEFAULT_PC_URL = "";
        public static final String DEFAULT_URL = "";
        public static final FieldOptions FIELD_OPTIONS_ANDROID_URL = null;
        public static final FieldOptions FIELD_OPTIONS_IOS_URL = null;
        public static final FieldOptions FIELD_OPTIONS_PC_URL = null;
        public static final FieldOptions FIELD_OPTIONS_URL = null;
        private static final long serialVersionUID = 0;
        public final String android_url;
        public final String ios_url;
        public final String pc_url;
        public final String url;

        public static final class Builder extends Message.Builder<URL, Builder> {
            public String android_url;
            public String ios_url;
            public String pc_url;
            public String url;

            @Override // com.squareup.wire.Message.Builder
            public URL build() {
                return new URL(this.url, this.ios_url, this.android_url, this.pc_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder android_url(String r100) {
                this.android_url = r100;
                return this;
            }

            public Builder ios_url(String r100) {
                this.ios_url = r100;
                return this;
            }

            public Builder pc_url(String r100) {
                this.pc_url = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_URL extends ProtoAdapter<URL> {
            public ProtoAdapter_URL() {
                super(FieldEncoding.LENGTH_DELIMITED, URL.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public URL decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.url = "";
                r101.ios_url = "";
                r101.android_url = "";
                r101.pc_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.ios_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.android_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.pc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(URL r100) {
                String r101 = r100.url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.ios_url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.android_url;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.pc_url;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ URL decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(URL r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, URL r101) throws IOException {
                String r102 = r101.url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.ios_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.android_url;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.pc_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URL r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_URL();
            FIELD_OPTIONS_URL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_IOS_URL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_ANDROID_URL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_PC_URL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.url = this.url;
            r100.ios_url = this.ios_url;
            r100.android_url = this.android_url;
            r100.pc_url = this.pc_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return URL.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public URL(String r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public URL(String r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.url = r100;
            this.ios_url = r101;
            this.android_url = r102;
            this.pc_url = r103;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutUniversalCardActionResponseInner();
        FIELD_OPTIONS_TOAST = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_URL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_APP_CLI_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.toast = this.toast;
        r100.url = this.url;
        r100.app_cli_id = this.app_cli_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutUniversalCardActionResponseInner.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutUniversalCardActionResponseInner(Toast r100, URL r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PutUniversalCardActionResponseInner(Toast r100, URL r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.toast = r100;
        this.url = r101;
        this.app_cli_id = r102;
    }
}
