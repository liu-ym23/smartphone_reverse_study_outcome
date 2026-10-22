package com.ss.android.lark.pb.meeting_object;

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
public final class FeatureUpgradeInfo extends Message<FeatureUpgradeInfo, Builder> {
    public static final ProtoAdapter<FeatureUpgradeInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<FeatureUpgradeType> mupgrade_type;

    public static final class Builder extends Message.Builder<FeatureUpgradeInfo, Builder> {
        public List<FeatureUpgradeType> mupgrade_type;

        @Override // com.squareup.wire.Message.Builder
        public FeatureUpgradeInfo build() {
            return new FeatureUpgradeInfo(this.mupgrade_type, super.buildUnknownFields());
        }

        public Builder() {
            this.mupgrade_type = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder upgrade_type(List<FeatureUpgradeType> r100) {
            Internal.checkElementsNotNull(r100);
            this.mupgrade_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeatureUpgradeInfo extends ProtoAdapter<FeatureUpgradeInfo> {
        public ProtoAdapter_FeatureUpgradeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, FeatureUpgradeInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeatureUpgradeInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.mupgrade_type.add(FeatureUpgradeType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FeatureUpgradeInfo r100) {
            return FeatureUpgradeType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mupgrade_type) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeatureUpgradeInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeatureUpgradeInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeatureUpgradeInfo r101) throws IOException {
            FeatureUpgradeType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mupgrade_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeatureUpgradeInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeatureUpgradeInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mupgrade_type = Internal.copyOf("mupgrade_type", this.mupgrade_type);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeatureUpgradeInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeatureUpgradeInfo(List<FeatureUpgradeType> r100) {
        this(r100, ByteString.EMPTY);
    }

    public FeatureUpgradeInfo(List<FeatureUpgradeType> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mupgrade_type = Internal.immutableCopyOf("mupgrade_type", r100);
    }
}
