package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatOptionInfo extends com.squareup.wire.Message<ChatOptionInfo, Builder> {
    public static final ProtoAdapter<ChatOptionInfo> ADAPTER = null;
    public static final Boolean DEFAULT_ANNOUNCE = null;
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final Boolean announce;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253453id;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatOptionInfo, Builder> {
        public Boolean announce;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253454id;

        @Override // com.squareup.wire.Message.Builder
        public ChatOptionInfo build() {
            String r100 = this.f253454id;
            if (r100 == null) goto L7;
            return new ChatOptionInfo(this.f253454id, this.announce, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder announce(Boolean r100) {
            this.announce = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253454id = r100;
            return this;
        }
    }

    public static final class Config extends com.squareup.wire.Message<Config, Builder> {
        public static final ProtoAdapter<Config> ADAPTER = null;
        public static final Boolean DEFAULT_ANNOUNCE = null;
        public static final String DEFAULT_ID = "";
        private static final long serialVersionUID = 0;
        public final Boolean announce;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253455id;

        public static final class Builder extends com.squareup.wire.Message.Builder<Config, Builder> {
            public Boolean announce;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253456id;

            @Override // com.squareup.wire.Message.Builder
            public Config build() {
                String r100 = this.f253456id;
                if (r100 == null) goto L7;
                return new Config(this.f253456id, this.announce, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "id"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder announce(Boolean r100) {
                this.announce = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253456id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Config extends ProtoAdapter<Config> {
            public ProtoAdapter_Config() {
                super(FieldEncoding.LENGTH_DELIMITED, Config.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Config decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253456id = "";
                r101.announce = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.f253456id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.announce = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(Config r100) {
                int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253455id);
                Boolean r102 = r100.announce;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Config decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Config r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Config r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253455id);
                Boolean r102 = r101.announce;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Config r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Config();
            DEFAULT_ANNOUNCE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253456id = this.f253455id;
            r100.announce = this.announce;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Config.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Config(String r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Config(String r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.f253455id = r100;
            this.announce = r101;
        }
    }

    public static final class ProtoAdapter_ChatOptionInfo extends ProtoAdapter<ChatOptionInfo> {
        public ProtoAdapter_ChatOptionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatOptionInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatOptionInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253454id = "";
            r101.announce = Boolean.TRUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.f253454id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.announce = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(ChatOptionInfo r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253453id);
            Boolean r102 = r100.announce;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatOptionInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatOptionInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatOptionInfo r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253453id);
            Boolean r102 = r101.announce;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatOptionInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatOptionInfo();
        DEFAULT_ANNOUNCE = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253454id = this.f253453id;
        r100.announce = this.announce;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatOptionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatOptionInfo(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ChatOptionInfo(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f253453id = r100;
        this.announce = r101;
    }
}
