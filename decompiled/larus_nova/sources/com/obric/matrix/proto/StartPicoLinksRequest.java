package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.larus.media.MediaScene;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
public final class StartPicoLinksRequest extends Message<StartPicoLinksRequest, Builder> {
    public static final ProtoAdapter<StartPicoLinksRequest> ADAPTER = null;
    public static final String DEFAULT_REFERRER = "";
    public static final SCENE DEFAULT_SCENE = null;
    public static final String DEFAULT_TARGETURL = "";
    private static final long serialVersionUID = 0;

    @SerializedName("referrer")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String referrer;

    @SerializedName("scene")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest$SCENE#ADAPTER", tag = 1)
    public final SCENE scene;

    @SerializedName("targetUrl")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String targetUrl;

    public static final class Builder extends Message.Builder<StartPicoLinksRequest, Builder> {
        public String referrer;
        public SCENE scene;
        public String targetUrl;

        @Override // com.squareup.wire.Message.Builder
        public StartPicoLinksRequest build() {
            return new StartPicoLinksRequest(this.scene, this.referrer, this.targetUrl, super.buildUnknownFields());
        }

        public Builder() {
            this.scene = SCENE.BROWSER;
            this.referrer = "";
            this.targetUrl = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder referrer(String r100) {
            this.referrer = r100;
            return this;
        }

        public Builder scene(SCENE r100) {
            this.scene = r100;
            return this;
        }

        public Builder targetUrl(String r100) {
            this.targetUrl = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_StartPicoLinksRequest extends ProtoAdapter<StartPicoLinksRequest> {
        public ProtoAdapter_StartPicoLinksRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StartPicoLinksRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.scene(SCENE.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.referrer(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.targetUrl(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(StartPicoLinksRequest r100) {
            int r101 = SCENE.ADAPTER.encodedSizeWithTag(1, r100.scene);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return ((r101 + r102.encodedSizeWithTag(2, r100.referrer)) + r102.encodedSizeWithTag(3, r100.targetUrl)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public StartPicoLinksRequest redact2(StartPicoLinksRequest r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StartPicoLinksRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksRequest redact(StartPicoLinksRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, StartPicoLinksRequest r101) throws IOException {
            SCENE.ADAPTER.encodeWithTag(r100, 1, r101.scene);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.referrer);
            r102.encodeWithTag(r100, 3, r101.targetUrl);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StartPicoLinksRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SCENE extends Enum<SCENE> implements WireEnum {
        private static final /* synthetic */ SCENE[] $VALUES = null;
        public static final ProtoAdapter<SCENE> ADAPTER = null;
        public static final SCENE BROWSER = null;
        public static final SCENE NATIVE_APP = null;
        public static final SCENE SYSTEM = null;
        public static final SCENE WEB_VIEW = null;
        private final int value;

        public static final class ProtoAdapter_SCENE extends EnumAdapter<SCENE> {
            public ProtoAdapter_SCENE() {
                super(SCENE.class);
            }

            @Override // com.squareup.wire.EnumAdapter
            public SCENE fromValue(int r100) {
                return SCENE.fromValue(r100);
            }

            @Override // com.squareup.wire.EnumAdapter
            public /* bridge */ /* synthetic */ WireEnum fromValue(int r100) {
                return fromValue(r100);
            }
        }

        static {
            SCENE r100 = new SCENE("BROWSER", 0, 0);
            BROWSER = r100;
            SCENE r101 = new SCENE("WEB_VIEW", 1, 1);
            WEB_VIEW = r101;
            SCENE r102 = new SCENE("NATIVE_APP", 2, 2);
            NATIVE_APP = r102;
            SCENE r103 = new SCENE(MediaScene.SYSTEM, 3, 3);
            SYSTEM = r103;
            $VALUES = new SCENE[]{r100, r101, r102, r103};
            ADAPTER = new ProtoAdapter_SCENE();
        }

        public static SCENE[] values() {
            return (SCENE[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }

        public static SCENE fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return SYSTEM;
        L14:
            return NATIVE_APP;
        L16:
            return WEB_VIEW;
        L18:
            return BROWSER;
        }

        public static SCENE valueOf(String r100) {
            return (SCENE) a.a(SCENE.class, r100);
        }

        private SCENE(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StartPicoLinksRequest();
        DEFAULT_SCENE = SCENE.BROWSER;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L17;
        int r101 = unknownFields().hashCode() * 37;
        SCENE r102 = this.scene;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.referrer;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.targetUrl;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        int r110 = r108 + r103;
        this.hashCode = r110;
        return r110;
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L17:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scene = this.scene;
        r100.referrer = this.referrer;
        r100.targetUrl = this.targetUrl;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.scene == null) goto L6;
        r100.append(", scene=");
        r100.append(this.scene);
    L6:
        if (this.referrer == null) goto L9;
        r100.append(", referrer=");
        r100.append(this.referrer);
    L9:
        if (this.targetUrl == null) goto L11;
        r100.append(", targetUrl=");
        r100.append(this.targetUrl);
    L11:
        StringBuilder r101 = r100.replace(0, 2, "StartPicoLinksRequest{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof StartPicoLinksRequest) == true) goto L8;
        return false;
    L8:
        StartPicoLinksRequest r101 = (StartPicoLinksRequest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (Internal.equals(this.scene, r101.scene) == false) goto L17;
        if (Internal.equals(this.referrer, r101.referrer) == false) goto L17;
        if (Internal.equals(this.targetUrl, r101.targetUrl) == false) goto L17;
        return true;
    }

    public StartPicoLinksRequest(SCENE r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public StartPicoLinksRequest(SCENE r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.scene = r100;
        this.referrer = r101;
        this.targetUrl = r102;
    }
}
