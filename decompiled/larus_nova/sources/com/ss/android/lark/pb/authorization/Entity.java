package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Entity extends Message<Entity, Builder> {
    public static final ProtoAdapter<Entity> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final EntityType mentity_type;
    public final String mid;

    public static final class Builder extends Message.Builder<Entity, Builder> {
        public EntityType mentity_type;
        public String mid;

        @Override // com.squareup.wire.Message.Builder
        public Entity build() {
            String r100 = this.mid;
            if (r100 == null) goto L9;
            if (this.mentity_type == null) goto L9;
            return new Entity(this.mid, this.mentity_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid", this.mentity_type, "mentity_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entity_type(EntityType r100) {
            this.mentity_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Entity extends ProtoAdapter<Entity> {
        public ProtoAdapter_Entity() {
            super(FieldEncoding.LENGTH_DELIMITED, Entity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Entity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mentity_type = EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(Entity r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mid) + EntityType.ADAPTER.encodedSizeWithTag(2, r100.mentity_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Entity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Entity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Entity r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mid);
            EntityType.ADAPTER.encodeWithTag(r100, 2, r101.mentity_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Entity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Entity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mentity_type = this.mentity_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Entity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Entity(String r100, EntityType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Entity(String r100, EntityType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mid = r100;
        this.mentity_type = r101;
    }
}
