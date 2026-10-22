package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MaterialBase extends Message<MaterialBase, Builder> {
    public static final ProtoAdapter<MaterialBase> ADAPTER = null;
    public static final String DEFAULT_AB_VERSION = "";
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_KEY = "";
    public static final Long DEFAULT_TASK_ID = null;
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String mab_version;
    public final ConsumeType mconsume_type;
    public final Long mid;
    public final String mkey;
    public final Long mtask_id;
    public final Integer mversion;

    public static final class Builder extends Message.Builder<MaterialBase, Builder> {
        public String mab_version;
        public ConsumeType mconsume_type;
        public Long mid;
        public String mkey;
        public Long mtask_id;
        public Integer mversion;

        @Override // com.squareup.wire.Message.Builder
        public MaterialBase build() {
            return new MaterialBase(this.mkey, this.mid, this.mversion, this.mab_version, this.mtask_id, this.mconsume_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ab_version(String r100) {
            this.mab_version = r100;
            return this;
        }

        public Builder consume_type(ConsumeType r100) {
            this.mconsume_type = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.mid = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder task_id(Long r100) {
            this.mtask_id = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.mversion = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MaterialBase extends ProtoAdapter<MaterialBase> {
        public ProtoAdapter_MaterialBase() {
            super(FieldEncoding.LENGTH_DELIMITED, MaterialBase.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MaterialBase decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mkey = "";
            r101.mid = 0L;
            r101.mversion = 0;
            r101.mab_version = "";
            r101.mtask_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L18;
                default: goto L6;
            };
        L18:
            r101.mconsume_type = ConsumeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.mtask_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.mab_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mversion = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.mid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MaterialBase r100) {
            String r101 = r100.mkey;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mid;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.mversion;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mab_version;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.mtask_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ConsumeType r116 = r100.mconsume_type;
            if (r116 == null) goto L26;
            r102 = ConsumeType.ADAPTER.encodedSizeWithTag(6, r116);
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
        public /* bridge */ /* synthetic */ MaterialBase decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MaterialBase r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MaterialBase r101) throws IOException {
            String r102 = r101.mkey;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mid;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.mversion;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mab_version;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.mtask_id;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            ConsumeType r107 = r101.mconsume_type;
            if (r107 == null) goto L20;
            ConsumeType.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MaterialBase r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MaterialBase();
        DEFAULT_ID = 0L;
        DEFAULT_VERSION = 0;
        DEFAULT_TASK_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkey = this.mkey;
        r100.mid = this.mid;
        r100.mversion = this.mversion;
        r100.mab_version = this.mab_version;
        r100.mtask_id = this.mtask_id;
        r100.mconsume_type = this.mconsume_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MaterialBase.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MaterialBase(String r100, Long r110, Integer r111, String r112, Long r113, ConsumeType r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public MaterialBase(String r100, Long r101, Integer r102, String r103, Long r104, ConsumeType r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mkey = r100;
        this.mid = r101;
        this.mversion = r102;
        this.mab_version = r103;
        this.mtask_id = r104;
        this.mconsume_type = r105;
    }
}
