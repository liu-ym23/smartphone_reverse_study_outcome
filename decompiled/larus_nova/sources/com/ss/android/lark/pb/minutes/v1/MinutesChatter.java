package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MinutesChatter extends Message<MinutesChatter, Builder> {
    public static final ProtoAdapter<MinutesChatter> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String avatar_key;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f438536id;
    public final String name;

    public static final class Builder extends Message.Builder<MinutesChatter, Builder> {
        public String avatar_key;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f438537id;
        public String name;

        @Override // com.squareup.wire.Message.Builder
        public MinutesChatter build() {
            String r100 = this.f438537id;
            if (r100 == null) goto L7;
            return new MinutesChatter(this.f438537id, this.name, this.avatar_key, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f438537id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesChatter extends ProtoAdapter<MinutesChatter> {
        public ProtoAdapter_MinutesChatter() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesChatter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MinutesChatter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f438537id = "";
            r101.name = "";
            r101.avatar_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f438537id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(MinutesChatter r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f438536id);
            String r103 = r100.name;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.avatar_key;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MinutesChatter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MinutesChatter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MinutesChatter r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f438536id);
            String r103 = r101.name;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.avatar_key;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MinutesChatter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MinutesChatter();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f438537id = this.f438536id;
        r100.name = this.name;
        r100.avatar_key = this.avatar_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MinutesChatter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MinutesChatter(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MinutesChatter(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f438536id = r100;
        this.name = r101;
        this.avatar_key = r102;
    }
}
