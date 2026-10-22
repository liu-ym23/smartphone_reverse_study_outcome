package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class URL extends com.squareup.wire.Message<URL, Builder> {
    public static final ProtoAdapter<URL> ADAPTER = null;
    public static final String DEFAULT_ANDROID = "";
    public static final String DEFAULT_IOS = "";
    public static final String DEFAULT_PC = "";
    public static final String DEFAULT_URL = "";
    public static final String DEFAULT_WEB = "";
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: android, reason: collision with root package name */
    public final String f253581android;
    public final String ios;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    public final String f253582pc;
    public final String url;

    /* JADX INFO: renamed from: web, reason: collision with root package name */
    public final String f253583web;

    public static final class Builder extends com.squareup.wire.Message.Builder<URL, Builder> {

        /* JADX INFO: renamed from: android, reason: collision with root package name */
        public String f253584android;
        public String ios;

        /* JADX INFO: renamed from: pc, reason: collision with root package name */
        public String f253585pc;
        public String url;

        /* JADX INFO: renamed from: web, reason: collision with root package name */
        public String f253586web;

        @Override // com.squareup.wire.Message.Builder
        public URL build() {
            return new URL(this.url, this.ios, this.f253584android, this.f253585pc, this.f253586web, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder android(String r100) {
            this.f253584android = r100;
            return this;
        }

        public Builder ios(String r100) {
            this.ios = r100;
            return this;
        }

        public Builder pc(String r100) {
            this.f253585pc = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }

        public Builder web(String r100) {
            this.f253586web = r100;
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
            r101.ios = "";
            r101.f253584android = "";
            r101.f253585pc = "";
            r101.f253586web = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.ios = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.f253584android = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.f253585pc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.f253586web = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(URL r100) {
            String r101 = r100.url;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.ios;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.f253581android;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.f253582pc;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.f253583web;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
            String r103 = r101.ios;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.f253581android;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.f253582pc;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.f253583web;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URL r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_URL();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.ios = this.ios;
        r100.f253584android = this.f253581android;
        r100.f253585pc = this.f253582pc;
        r100.f253586web = this.f253583web;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return URL.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public URL(String r100, String r101, String r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public URL(String r100, String r101, String r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.url = r100;
        this.ios = r101;
        this.f253581android = r102;
        this.f253582pc = r103;
        this.f253583web = r104;
    }
}
