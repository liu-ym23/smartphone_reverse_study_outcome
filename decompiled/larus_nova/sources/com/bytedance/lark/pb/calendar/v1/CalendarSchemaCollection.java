package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarSchemaCollection extends Message<CalendarSchemaCollection, Builder> {
    public static final ProtoAdapter<CalendarSchemaCollection> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CalendarSchemaCompatibility compatibility;
    public final List<EntitySchema> entity_schemas;

    public static final class Builder extends Message.Builder<CalendarSchemaCollection, Builder> {
        public CalendarSchemaCompatibility compatibility;
        public List<EntitySchema> entity_schemas;

        @Override // com.squareup.wire.Message.Builder
        public CalendarSchemaCollection build() {
            return new CalendarSchemaCollection(this.entity_schemas, this.compatibility, super.buildUnknownFields());
        }

        public Builder() {
            this.entity_schemas = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder compatibility(CalendarSchemaCompatibility r100) {
            this.compatibility = r100;
            return this;
        }

        public Builder entity_schemas(List<EntitySchema> r100) {
            Internal.checkElementsNotNull(r100);
            this.entity_schemas = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarSchemaCollection extends ProtoAdapter<CalendarSchemaCollection> {
        public ProtoAdapter_CalendarSchemaCollection() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarSchemaCollection.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarSchemaCollection decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.entity_schemas.add(EntitySchema.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.compatibility = CalendarSchemaCompatibility.ADAPTER.decode(r100);
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
        public int encodedSize2(CalendarSchemaCollection r100) {
            int r101 = EntitySchema.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.entity_schemas);
            CalendarSchemaCompatibility r102 = r100.compatibility;
            if (r102 == null) goto L5;
            int r103 = CalendarSchemaCompatibility.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CalendarSchemaCollection decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarSchemaCollection r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarSchemaCollection r101) throws IOException {
            EntitySchema.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.entity_schemas);
            CalendarSchemaCompatibility r102 = r101.compatibility;
            if (r102 == null) goto L5;
            CalendarSchemaCompatibility.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarSchemaCollection r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarSchemaCollection();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entity_schemas = Internal.copyOf("entity_schemas", this.entity_schemas);
        r100.compatibility = this.compatibility;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarSchemaCollection.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarSchemaCollection(List<EntitySchema> r100, CalendarSchemaCompatibility r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CalendarSchemaCollection(List<EntitySchema> r100, CalendarSchemaCompatibility r101, ByteString r102) {
        super(ADAPTER, r102);
        this.entity_schemas = Internal.immutableCopyOf("entity_schemas", r100);
        this.compatibility = r101;
    }
}
