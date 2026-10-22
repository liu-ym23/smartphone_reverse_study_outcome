package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ShellApi extends Message<ShellApi, Builder> {
    public static final ProtoAdapter<ShellApi> ADAPTER = null;
    public static final String DEFAULT_PARAMS = "";
    public static final ShellApiType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String params;
    public final ShellApiType type;

    public static final class Builder extends Message.Builder<ShellApi, Builder> {
        public String params;
        public ShellApiType type;

        @Override // com.squareup.wire.Message.Builder
        public ShellApi build() {
            return new ShellApi(this.type, this.params, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder params(String r100) {
            this.params = r100;
            return this;
        }

        public Builder type(ShellApiType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ShellApi extends ProtoAdapter<ShellApi> {
        public ProtoAdapter_ShellApi() {
            super(FieldEncoding.LENGTH_DELIMITED, ShellApi.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ShellApi decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = ShellApiType.OpenWindow;
            r101.params = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.type = ShellApiType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.params = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ShellApi r100) {
            ShellApiType r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ShellApiType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.params;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ShellApi decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ShellApi r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ShellApi r101) throws IOException {
            ShellApiType r102 = r101.type;
            if (r102 == null) goto L5;
            ShellApiType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.params;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShellApi r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ShellApi();
        DEFAULT_TYPE = ShellApiType.OpenWindow;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.params = this.params;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ShellApi.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ShellApi(ShellApiType r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ShellApi(ShellApiType r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.type = r100;
        this.params = r101;
    }
}
