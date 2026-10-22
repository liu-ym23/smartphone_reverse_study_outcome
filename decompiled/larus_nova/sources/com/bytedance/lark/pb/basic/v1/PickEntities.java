package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class PickEntities extends com.squareup.wire.Message<PickEntities, Builder> {
    public static final ProtoAdapter<PickEntities> ADAPTER = null;
    public static final PickType DEFAULT_PICK_TYPE = null;
    private static final long serialVersionUID = 0;
    public final List<String> pick_ids;
    public final PickType pick_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<PickEntities, Builder> {
        public List<String> pick_ids;
        public PickType pick_type;

        @Override // com.squareup.wire.Message.Builder
        public PickEntities build() {
            PickType r100 = this.pick_type;
            if (r100 == null) goto L7;
            return new PickEntities(this.pick_type, this.pick_ids, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "pick_type"});
        }

        public Builder() {
            this.pick_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder pick_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.pick_ids = r100;
            return this;
        }

        public Builder pick_type(PickType r100) {
            this.pick_type = r100;
            return this;
        }
    }

    public static final enum PickType extends Enum<PickType> implements WireEnum {
        private static final /* synthetic */ PickType[] $VALUES = null;
        public static final ProtoAdapter<PickType> ADAPTER = null;
        public static final PickType CHAT = null;
        public static final PickType DEPT = null;
        public static final PickType UNKNOWN = null;
        public static final PickType USER = null;
        private final int value;

        static {
            PickType r100 = new PickType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            PickType r101 = new PickType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            PickType r102 = new PickType("CHAT", 2, 2);
            CHAT = r102;
            PickType r103 = new PickType("DEPT", 3, 3);
            DEPT = r103;
            $VALUES = new PickType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(PickType.class);
        }

        public static PickType[] values() {
            return (PickType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PickType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return DEPT;
        L14:
            return CHAT;
        L16:
            return USER;
        L18:
            return UNKNOWN;
        }

        public static PickType valueOf(String r100) {
            return (PickType) a.a(PickType.class, r100);
        }

        private PickType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
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
            r101.pick_type = PickType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.pick_type = PickType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.pick_ids.add(ProtoAdapter.STRING.decode(r100));
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
            return (PickType.ADAPTER.encodedSizeWithTag(1, r100.pick_type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.pick_ids)) + r100.unknownFields().size();
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
            PickType.ADAPTER.encodeWithTag(r100, 1, r101.pick_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.pick_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PickEntities r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PickEntities();
        DEFAULT_PICK_TYPE = PickType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pick_type = this.pick_type;
        r100.pick_ids = Internal.copyOf("pick_ids", this.pick_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PickEntities.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PickEntities(PickType r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PickEntities(PickType r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.pick_type = r100;
        this.pick_ids = Internal.immutableCopyOf("pick_ids", r101);
    }
}
