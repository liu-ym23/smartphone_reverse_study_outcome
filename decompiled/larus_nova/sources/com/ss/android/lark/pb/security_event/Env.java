package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Env extends Message<Env, Builder> {
    public static final ProtoAdapter<Env> ADAPTER = null;
    public static final String DEFAULT_DID = "";
    public static final String DEFAULT_IP = "";
    public static final String DEFAULT_LOCATION = "";
    public static final String DEFAULT_UA = "";
    private static final long serialVersionUID = 0;
    public final ClientType mClient;
    public final String mDID;
    public final FlagType mFlag;
    public final String mIP;
    public final String mLocation;
    public final String mUA;

    public static final class Builder extends Message.Builder<Env, Builder> {
        public ClientType mClient;
        public String mDID;
        public FlagType mFlag;
        public String mIP;
        public String mLocation;
        public String mUA;

        @Override // com.squareup.wire.Message.Builder
        public Env build() {
            return new Env(this.mClient, this.mDID, this.mLocation, this.mUA, this.mIP, this.mFlag, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder Client(ClientType r100) {
            this.mClient = r100;
            return this;
        }

        public Builder DID(String r100) {
            this.mDID = r100;
            return this;
        }

        public Builder Flag(FlagType r100) {
            this.mFlag = r100;
            return this;
        }

        public Builder IP(String r100) {
            this.mIP = r100;
            return this;
        }

        public Builder Location(String r100) {
            this.mLocation = r100;
            return this;
        }

        public Builder UA(String r100) {
            this.mUA = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Env extends ProtoAdapter<Env> {
        public ProtoAdapter_Env() {
            super(FieldEncoding.LENGTH_DELIMITED, Env.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Env decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mDID = "";
            r101.mLocation = "";
            r101.mUA = "";
            r101.mIP = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L21;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L23;
                default: goto L6;
            };
        L21:
            r101.mClient = ClientType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.mFlag = FlagType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.mIP = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mUA = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mLocation = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mDID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Env r100) {
            ClientType r101 = r100.mClient;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ClientType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mDID;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mLocation;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mUA;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mIP;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            FlagType r116 = r100.mFlag;
            if (r116 == null) goto L26;
            r102 = FlagType.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Env decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Env r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Env r101) throws IOException {
            ClientType r102 = r101.mClient;
            if (r102 == null) goto L5;
            ClientType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mDID;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mLocation;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mUA;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mIP;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            FlagType r107 = r101.mFlag;
            if (r107 == null) goto L20;
            FlagType.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Env r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Env();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mClient = this.mClient;
        r100.mDID = this.mDID;
        r100.mLocation = this.mLocation;
        r100.mUA = this.mUA;
        r100.mIP = this.mIP;
        r100.mFlag = this.mFlag;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Env.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Env(ClientType r100, String r110, String r111, String r112, String r113, FlagType r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public Env(ClientType r100, String r101, String r102, String r103, String r104, FlagType r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mClient = r100;
        this.mDID = r101;
        this.mLocation = r102;
        this.mUA = r103;
        this.mIP = r104;
        this.mFlag = r105;
    }
}
