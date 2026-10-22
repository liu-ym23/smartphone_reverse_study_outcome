package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class RenderRouterEntity extends com.squareup.wire.Message<RenderRouterEntity, Builder> {
    public static final ProtoAdapter<RenderRouterEntity> ADAPTER = null;
    public static final String DEFAULT_ROOT_ID = "";
    public static final String DEFAULT_WIDTH_MODE = "";
    private static final long serialVersionUID = 0;
    public final Map<String, CardComponent> elements;
    public final Map<String, EngineEntity> engine_entities;
    public final String root_id;
    public final String width_mode;

    public static final class Builder extends com.squareup.wire.Message.Builder<RenderRouterEntity, Builder> {
        public Map<String, CardComponent> elements;
        public Map<String, EngineEntity> engine_entities;
        public String root_id;
        public String width_mode;

        @Override // com.squareup.wire.Message.Builder
        public RenderRouterEntity build() {
            return new RenderRouterEntity(this.root_id, this.elements, this.engine_entities, this.width_mode, super.buildUnknownFields());
        }

        public Builder() {
            this.elements = Internal.newMutableMap();
            this.engine_entities = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder elements(Map<String, CardComponent> r100) {
            Internal.checkElementsNotNull(r100);
            this.elements = r100;
            return this;
        }

        public Builder engine_entities(Map<String, EngineEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.engine_entities = r100;
            return this;
        }

        public Builder root_id(String r100) {
            this.root_id = r100;
            return this;
        }

        public Builder width_mode(String r100) {
            this.width_mode = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RenderRouterEntity extends ProtoAdapter<RenderRouterEntity> {
        private final ProtoAdapter<Map<String, CardComponent>> elements;
        private final ProtoAdapter<Map<String, EngineEntity>> engine_entities;

        public ProtoAdapter_RenderRouterEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, RenderRouterEntity.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.elements = ProtoAdapter.newMapAdapter(r100, CardComponent.ADAPTER);
            this.engine_entities = ProtoAdapter.newMapAdapter(r100, EngineEntity.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RenderRouterEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.root_id = "";
            r101.width_mode = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.root_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.elements.putAll(this.elements.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.engine_entities.putAll(this.engine_entities.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.width_mode = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(RenderRouterEntity r100) {
            String r101 = r100.root_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = (r103 + this.elements.encodedSizeWithTag(2, r100.elements)) + this.engine_entities.encodedSizeWithTag(3, r100.engine_entities);
            String r105 = r100.width_mode;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RenderRouterEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RenderRouterEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RenderRouterEntity r101) throws IOException {
            String r102 = r101.root_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            this.elements.encodeWithTag(r100, 2, r101.elements);
            this.engine_entities.encodeWithTag(r100, 3, r101.engine_entities);
            String r103 = r101.width_mode;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RenderRouterEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RenderRouterEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.root_id = this.root_id;
        r100.elements = Internal.copyOf(SlcElement.KEY_ELEMENTS, this.elements);
        r100.engine_entities = Internal.copyOf("engine_entities", this.engine_entities);
        r100.width_mode = this.width_mode;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RenderRouterEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public RenderRouterEntity(String r100, Map<String, CardComponent> r101, Map<String, EngineEntity> r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public RenderRouterEntity(String r100, Map<String, CardComponent> r101, Map<String, EngineEntity> r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.root_id = r100;
        this.elements = Internal.immutableCopyOf(SlcElement.KEY_ELEMENTS, r101);
        this.engine_entities = Internal.immutableCopyOf("engine_entities", r102);
        this.width_mode = r103;
    }
}
