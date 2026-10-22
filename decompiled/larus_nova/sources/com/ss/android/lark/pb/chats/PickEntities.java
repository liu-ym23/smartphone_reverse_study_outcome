package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PickEntities extends Message<PickEntities, Builder> {
    public static final ProtoAdapter<PickEntities> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> mpick_ids;
    public final PickType mpick_type;

    public static final class Builder extends Message.Builder<PickEntities, Builder> {
        public List<String> mpick_ids;
        public PickType mpick_type;

        @Override // com.squareup.wire.Message.Builder
        public PickEntities build() {
            PickType r100 = this.mpick_type;
            if (r100 == null) goto L7;
            return new PickEntities(this.mpick_type, this.mpick_ids, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mpick_type"});
        }

        public Builder() {
            this.mpick_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder pick_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpick_ids = r100;
            return this;
        }

        public Builder pick_type(PickType r100) {
            this.mpick_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PickEntities extends ProtoAdapter<PickEntities> {
        public ProtoAdapter_PickEntities() {
            super(FieldEncoding.LENGTH_DELIMITED, PickEntities.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PickEntities decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mpick_type = PickType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mpick_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(PickEntities r100) {
            return (PickType.ADAPTER.encodedSizeWithTag(1, r100.mpick_type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.mpick_ids)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PickEntities decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PickEntities r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PickEntities r101) throws IOException {
            PickType.ADAPTER.encodeWithTag(r100, 1, r101.mpick_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.mpick_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PickEntities r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PickEntities();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mpick_type = this.mpick_type;
        r100.mpick_ids = Internal.copyOf("mpick_ids", this.mpick_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PickEntities.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PickEntities(PickType r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PickEntities(PickType r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mpick_type = r100;
        this.mpick_ids = Internal.immutableCopyOf("mpick_ids", r101);
    }
}
