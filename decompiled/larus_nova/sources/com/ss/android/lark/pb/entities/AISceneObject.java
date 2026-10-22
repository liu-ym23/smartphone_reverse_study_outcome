package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AISceneObject extends com.squareup.wire.Message<AISceneObject, Builder> {
    public static final ProtoAdapter<AISceneObject> ADAPTER = null;
    public static final String DEFAULT_OBJECT_ID = "";
    public static final String DEFAULT_OBJECT_TYPE = "";
    private static final long serialVersionUID = 0;
    public final String mobject_id;
    public final String mobject_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<AISceneObject, Builder> {
        public String mobject_id;
        public String mobject_type;

        @Override // com.squareup.wire.Message.Builder
        public AISceneObject build() {
            return new AISceneObject(this.mobject_id, this.mobject_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder object_id(String r100) {
            this.mobject_id = r100;
            return this;
        }

        public Builder object_type(String r100) {
            this.mobject_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AISceneObject extends ProtoAdapter<AISceneObject> {
        public ProtoAdapter_AISceneObject() {
            super(FieldEncoding.LENGTH_DELIMITED, AISceneObject.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AISceneObject decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mobject_id = "";
            r101.mobject_type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mobject_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mobject_type = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AISceneObject r100) {
            String r101 = r100.mobject_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mobject_type;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AISceneObject decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AISceneObject r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AISceneObject r101) throws IOException {
            String r102 = r101.mobject_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mobject_type;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AISceneObject r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AISceneObject();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mobject_id = this.mobject_id;
        r100.mobject_type = this.mobject_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AISceneObject.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AISceneObject(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public AISceneObject(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mobject_id = r100;
        this.mobject_type = r101;
    }
}
