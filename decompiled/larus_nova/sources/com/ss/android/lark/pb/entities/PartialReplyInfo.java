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
public final class PartialReplyInfo extends com.squareup.wire.Message<PartialReplyInfo, Builder> {
    public static final ProtoAdapter<PartialReplyInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final RichText mcontent;
    public final PartialContentRelativePosition mposition;

    public static final class Builder extends com.squareup.wire.Message.Builder<PartialReplyInfo, Builder> {
        public RichText mcontent;
        public PartialContentRelativePosition mposition;

        @Override // com.squareup.wire.Message.Builder
        public PartialReplyInfo build() {
            return new PartialReplyInfo(this.mcontent, this.mposition, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder content(RichText r100) {
            this.mcontent = r100;
            return this;
        }

        public Builder position(PartialContentRelativePosition r100) {
            this.mposition = r100;
            return this;
        }
    }

    public static final enum PartialContentRelativePosition extends Enum<PartialContentRelativePosition> implements WireEnum {
        private static final /* synthetic */ PartialContentRelativePosition[] $VALUES = null;
        public static final ProtoAdapter<PartialContentRelativePosition> ADAPTER = null;
        public static final PartialContentRelativePosition HEAD = null;
        public static final PartialContentRelativePosition MIDDLE = null;
        public static final PartialContentRelativePosition TAIL = null;
        public static final PartialContentRelativePosition UNKNOWN = null;
        private final int value;

        static {
            PartialContentRelativePosition r100 = new PartialContentRelativePosition("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            PartialContentRelativePosition r101 = new PartialContentRelativePosition("HEAD", 1, 1);
            HEAD = r101;
            PartialContentRelativePosition r102 = new PartialContentRelativePosition("MIDDLE", 2, 2);
            MIDDLE = r102;
            PartialContentRelativePosition r103 = new PartialContentRelativePosition("TAIL", 3, 3);
            TAIL = r103;
            $VALUES = new PartialContentRelativePosition[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(PartialContentRelativePosition.class);
        }

        public static PartialContentRelativePosition[] values() {
            return (PartialContentRelativePosition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PartialContentRelativePosition fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return TAIL;
        L14:
            return MIDDLE;
        L16:
            return HEAD;
        L18:
            return UNKNOWN;
        }

        public static PartialContentRelativePosition valueOf(String r100) {
            return (PartialContentRelativePosition) a.a(PartialContentRelativePosition.class, r100);
        }

        private PartialContentRelativePosition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PartialReplyInfo extends ProtoAdapter<PartialReplyInfo> {
        public ProtoAdapter_PartialReplyInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PartialReplyInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PartialReplyInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mcontent = RichText.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mposition = PartialContentRelativePosition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(PartialReplyInfo r100) {
            RichText r101 = r100.mcontent;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = RichText.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            PartialContentRelativePosition r104 = r100.mposition;
            if (r104 == null) goto L10;
            r102 = PartialContentRelativePosition.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PartialReplyInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PartialReplyInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PartialReplyInfo r101) throws IOException {
            RichText r102 = r101.mcontent;
            if (r102 == null) goto L5;
            RichText.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            PartialContentRelativePosition r103 = r101.mposition;
            if (r103 == null) goto L8;
            PartialContentRelativePosition.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PartialReplyInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PartialReplyInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcontent = this.mcontent;
        r100.mposition = this.mposition;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PartialReplyInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PartialReplyInfo(RichText r100, PartialContentRelativePosition r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PartialReplyInfo(RichText r100, PartialContentRelativePosition r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mcontent = r100;
        this.mposition = r101;
    }
}
