package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ObjectEntity extends Message<ObjectEntity, Builder> {
    public static final ProtoAdapter<ObjectEntity> ADAPTER = null;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    public final ObjectDetail mDetail;
    public final EntityType mType;
    public final String mValue;

    public static final class Builder extends Message.Builder<ObjectEntity, Builder> {
        public ObjectDetail mDetail;
        public EntityType mType;
        public String mValue;

        @Override // com.squareup.wire.Message.Builder
        public ObjectEntity build() {
            EntityType r100 = this.mType;
            if (r100 == null) goto L9;
            if (this.mValue == null) goto L9;
            return new ObjectEntity(this.mType, this.mValue, this.mDetail, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mType", this.mValue, "mValue"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder Detail(ObjectDetail r100) {
            this.mDetail = r100;
            return this;
        }

        public Builder Type(EntityType r100) {
            this.mType = r100;
            return this;
        }

        public Builder Value(String r100) {
            this.mValue = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ObjectEntity extends ProtoAdapter<ObjectEntity> {
        public ProtoAdapter_ObjectEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, ObjectEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ObjectEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mValue = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mType = EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mValue = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mDetail = ObjectDetail.ADAPTER.decode(r100);
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
        public int encodedSize2(ObjectEntity r100) {
            int r101 = EntityType.ADAPTER.encodedSizeWithTag(1, r100.mType) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.mValue);
            ObjectDetail r102 = r100.mDetail;
            if (r102 == null) goto L5;
            int r103 = ObjectDetail.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ObjectEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ObjectEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ObjectEntity r101) throws IOException {
            EntityType.ADAPTER.encodeWithTag(r100, 1, r101.mType);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.mValue);
            ObjectDetail r102 = r101.mDetail;
            if (r102 == null) goto L5;
            ObjectDetail.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ObjectEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ObjectEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mType = this.mType;
        r100.mValue = this.mValue;
        r100.mDetail = this.mDetail;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ObjectEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ObjectEntity(EntityType r100, String r101, ObjectDetail r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ObjectEntity(EntityType r100, String r101, ObjectDetail r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mType = r100;
        this.mValue = r101;
        this.mDetail = r102;
    }
}
