package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ResourceCleanScene extends com.squareup.wire.Message<ResourceCleanScene, Builder> {
    public static final ProtoAdapter<ResourceCleanScene> ADAPTER = null;
    public static final Enum DEFAULT_CLEAN_RESOURCE_SCENE = null;
    private static final long serialVersionUID = 0;
    public final Enum clean_resource_scene;

    public static final class Builder extends com.squareup.wire.Message.Builder<ResourceCleanScene, Builder> {
        public Enum clean_resource_scene;

        @Override // com.squareup.wire.Message.Builder
        public ResourceCleanScene build() {
            return new ResourceCleanScene(this.clean_resource_scene, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder clean_resource_scene(Enum r100) {
            this.clean_resource_scene = r100;
            return this;
        }
    }

    public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
        private static final /* synthetic */ Enum[] $VALUES = null;
        public static final ProtoAdapter<Enum> ADAPTER = null;
        public static final Enum CSAM_DELETE = null;
        public static final Enum UNIFIED_STORAGE_REGULARLY_DELETE = null;
        public static final Enum UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = null;
        public static final Enum UNKNOWN_RESOURCE_CLEAN_SCENE = null;
        private final int value;

        static {
            Enum r100 = new Enum("UNKNOWN_RESOURCE_CLEAN_SCENE", 0, 0);
            UNKNOWN_RESOURCE_CLEAN_SCENE = r100;
            Enum r101 = new Enum("UNIFIED_STORAGE_REGULARLY_DELETE", 1, 1);
            UNIFIED_STORAGE_REGULARLY_DELETE = r101;
            Enum r102 = new Enum("CSAM_DELETE", 2, 2);
            CSAM_DELETE = r102;
            Enum r103 = new Enum("UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER", 3, 3);
            UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = r103;
            $VALUES = new Enum[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
        }

        public static Enum[] values() {
            return (Enum[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Enum fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER;
        L14:
            return CSAM_DELETE;
        L16:
            return UNIFIED_STORAGE_REGULARLY_DELETE;
        L18:
            return UNKNOWN_RESOURCE_CLEAN_SCENE;
        }

        public static Enum valueOf(String r100) {
            return (Enum) a.a(Enum.class, r100);
        }

        private Enum(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ResourceCleanScene extends ProtoAdapter<ResourceCleanScene> {
        public ProtoAdapter_ResourceCleanScene() {
            super(FieldEncoding.LENGTH_DELIMITED, ResourceCleanScene.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResourceCleanScene decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.clean_resource_scene = Enum.UNKNOWN_RESOURCE_CLEAN_SCENE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.clean_resource_scene = Enum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResourceCleanScene r100) {
            Enum r101 = r100.clean_resource_scene;
            if (r101 == null) goto L5;
            int r102 = Enum.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResourceCleanScene decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResourceCleanScene r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ResourceCleanScene r101) throws IOException {
            Enum r102 = r101.clean_resource_scene;
            if (r102 == null) goto L5;
            Enum.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceCleanScene r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResourceCleanScene();
        DEFAULT_CLEAN_RESOURCE_SCENE = Enum.UNKNOWN_RESOURCE_CLEAN_SCENE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.clean_resource_scene = this.clean_resource_scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ResourceCleanScene.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ResourceCleanScene(Enum r100) {
        this(r100, ByteString.EMPTY);
    }

    public ResourceCleanScene(Enum r100, ByteString r101) {
        super(ADAPTER, r101);
        this.clean_resource_scene = r100;
    }
}
