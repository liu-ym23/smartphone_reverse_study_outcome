package com.ss.android.lark.pb.section;

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
public final class Modifier extends Message<Modifier, Builder> {
    public static final ProtoAdapter<Modifier> ADAPTER = null;
    public static final Integer DEFAULT_END_INDEX = null;
    public static final Integer DEFAULT_START_INDEX = null;
    private static final long serialVersionUID = 0;
    public final Integer mend_index;
    public final List<ModifierMeta> mmetas;
    public final Integer mstart_index;

    public static final class Builder extends Message.Builder<Modifier, Builder> {
        public Integer mend_index;
        public List<ModifierMeta> mmetas;
        public Integer mstart_index;

        @Override // com.squareup.wire.Message.Builder
        public Modifier build() {
            return new Modifier(this.mstart_index, this.mend_index, this.mmetas, super.buildUnknownFields());
        }

        public Builder() {
            this.mmetas = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder end_index(Integer r100) {
            this.mend_index = r100;
            return this;
        }

        public Builder metas(List<ModifierMeta> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmetas = r100;
            return this;
        }

        public Builder start_index(Integer r100) {
            this.mstart_index = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Modifier extends ProtoAdapter<Modifier> {
        public ProtoAdapter_Modifier() {
            super(FieldEncoding.LENGTH_DELIMITED, Modifier.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Modifier decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mstart_index = 0;
            r101.mend_index = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mstart_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mend_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mmetas.add(ModifierMeta.ADAPTER.decode(r100));
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
        public int encodedSize2(Modifier r100) {
            Integer r101 = r100.mstart_index;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mend_index;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + ModifierMeta.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mmetas)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Modifier decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Modifier r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Modifier r101) throws IOException {
            Integer r102 = r101.mstart_index;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mend_index;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            ModifierMeta.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mmetas);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Modifier r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Modifier();
        DEFAULT_START_INDEX = 0;
        DEFAULT_END_INDEX = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstart_index = this.mstart_index;
        r100.mend_index = this.mend_index;
        r100.mmetas = Internal.copyOf("mmetas", this.mmetas);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Modifier.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Modifier(Integer r100, Integer r101, List<ModifierMeta> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public Modifier(Integer r100, Integer r101, List<ModifierMeta> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mstart_index = r100;
        this.mend_index = r101;
        this.mmetas = Internal.immutableCopyOf("mmetas", r102);
    }
}
