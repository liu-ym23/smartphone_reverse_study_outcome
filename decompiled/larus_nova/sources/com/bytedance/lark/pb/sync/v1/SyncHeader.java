package com.bytedance.lark.pb.sync.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SyncHeader extends Message<SyncHeader, Builder> {
    public static final ProtoAdapter<SyncHeader> ADAPTER = null;
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final String app_name;
    public final String token;

    public static final class Builder extends Message.Builder<SyncHeader, Builder> {
        public String app_name;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public SyncHeader build() {
            String r100 = this.app_name;
            if (r100 == null) goto L7;
            return new SyncHeader(this.app_name, this.token, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "app_name"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_name(String r100) {
            this.app_name = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SyncHeader extends ProtoAdapter<SyncHeader> {
        public ProtoAdapter_SyncHeader() {
            super(FieldEncoding.LENGTH_DELIMITED, SyncHeader.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SyncHeader decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_name = "";
            r101.token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.app_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.token = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SyncHeader r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.app_name);
            String r103 = r100.token;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(2, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SyncHeader decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SyncHeader r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SyncHeader r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.app_name);
            String r103 = r101.token;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SyncHeader r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SyncHeader();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_name = this.app_name;
        r100.token = this.token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SyncHeader.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SyncHeader(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SyncHeader(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.app_name = r100;
        this.token = r101;
    }
}
