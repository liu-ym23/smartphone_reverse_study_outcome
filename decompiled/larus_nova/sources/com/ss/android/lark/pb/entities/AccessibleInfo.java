package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class AccessibleInfo extends com.squareup.wire.Message<AccessibleInfo, Builder> {
    public static final ProtoAdapter<AccessibleInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_ACCESSIBLE = null;
    private static final long serialVersionUID = 0;
    public final InaccessibleCode minaccessible_code;
    public final Boolean mis_accessible;

    public static final class Builder extends com.squareup.wire.Message.Builder<AccessibleInfo, Builder> {
        public InaccessibleCode minaccessible_code;
        public Boolean mis_accessible;

        @Override // com.squareup.wire.Message.Builder
        public AccessibleInfo build() {
            return new AccessibleInfo(this.mis_accessible, this.minaccessible_code, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder inaccessible_code(InaccessibleCode r100) {
            this.minaccessible_code = r100;
            return this;
        }

        public Builder is_accessible(Boolean r100) {
            this.mis_accessible = r100;
            return this;
        }
    }

    public static final enum InaccessibleCode extends Enum<InaccessibleCode> implements WireEnum {
        private static final /* synthetic */ InaccessibleCode[] $VALUES = null;
        public static final ProtoAdapter<InaccessibleCode> ADAPTER = null;
        public static final InaccessibleCode CROSS_TENANT = null;
        public static final InaccessibleCode DEFAULT = null;
        public static final InaccessibleCode EMPTY_NAME = null;
        public static final InaccessibleCode EMPTY_PHONE = null;
        public static final InaccessibleCode EXECUTIVES = null;
        public static final InaccessibleCode NOT_FRIEND = null;
        private final int value;

        static {
            InaccessibleCode r100 = new InaccessibleCode("DEFAULT", 0, 0);
            DEFAULT = r100;
            InaccessibleCode r101 = new InaccessibleCode("EXECUTIVES", 1, 1);
            EXECUTIVES = r101;
            InaccessibleCode r102 = new InaccessibleCode("EMPTY_NAME", 2, 2);
            EMPTY_NAME = r102;
            InaccessibleCode r103 = new InaccessibleCode("EMPTY_PHONE", 3, 3);
            EMPTY_PHONE = r103;
            InaccessibleCode r104 = new InaccessibleCode("CROSS_TENANT", 4, 4);
            CROSS_TENANT = r104;
            InaccessibleCode r105 = new InaccessibleCode("NOT_FRIEND", 5, 5);
            NOT_FRIEND = r105;
            $VALUES = new InaccessibleCode[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(InaccessibleCode.class);
        }

        public static InaccessibleCode[] values() {
            return (InaccessibleCode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static InaccessibleCode fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return NOT_FRIEND;
        L18:
            return CROSS_TENANT;
        L20:
            return EMPTY_PHONE;
        L22:
            return EMPTY_NAME;
        L24:
            return EXECUTIVES;
        L26:
            return DEFAULT;
        }

        public static InaccessibleCode valueOf(String r100) {
            return (InaccessibleCode) a.a(InaccessibleCode.class, r100);
        }

        private InaccessibleCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_AccessibleInfo extends ProtoAdapter<AccessibleInfo> {
        public ProtoAdapter_AccessibleInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, AccessibleInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AccessibleInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_accessible = Boolean.TRUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mis_accessible = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.minaccessible_code = InaccessibleCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(AccessibleInfo r100) {
            Boolean r101 = r100.mis_accessible;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            InaccessibleCode r104 = r100.minaccessible_code;
            if (r104 == null) goto L10;
            r102 = InaccessibleCode.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AccessibleInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AccessibleInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AccessibleInfo r101) throws IOException {
            Boolean r102 = r101.mis_accessible;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            InaccessibleCode r103 = r101.minaccessible_code;
            if (r103 == null) goto L8;
            InaccessibleCode.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AccessibleInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AccessibleInfo();
        DEFAULT_IS_ACCESSIBLE = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_accessible = this.mis_accessible;
        r100.minaccessible_code = this.minaccessible_code;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AccessibleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AccessibleInfo(Boolean r100, InaccessibleCode r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public AccessibleInfo(Boolean r100, InaccessibleCode r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mis_accessible = r100;
        this.minaccessible_code = r101;
    }
}
