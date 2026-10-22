package com.ss.android.lark.pb.videochat_my_ai;

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
public final class CustomSummaryAction extends Message<CustomSummaryAction, Builder> {
    public static final ProtoAdapter<CustomSummaryAction> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CustomType mcustom_type;
    public final List<CustomSubType> mneed_tabs;

    public static final class Builder extends Message.Builder<CustomSummaryAction, Builder> {
        public CustomType mcustom_type;
        public List<CustomSubType> mneed_tabs;

        @Override // com.squareup.wire.Message.Builder
        public CustomSummaryAction build() {
            return new CustomSummaryAction(this.mcustom_type, this.mneed_tabs, super.buildUnknownFields());
        }

        public Builder() {
            this.mneed_tabs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder custom_type(CustomType r100) {
            this.mcustom_type = r100;
            return this;
        }

        public Builder need_tabs(List<CustomSubType> r100) {
            Internal.checkElementsNotNull(r100);
            this.mneed_tabs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryAction extends ProtoAdapter<CustomSummaryAction> {
        public ProtoAdapter_CustomSummaryAction() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryAction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomSummaryAction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mcustom_type = CustomType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mneed_tabs.add(CustomSubType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CustomSummaryAction r100) {
            CustomType r101 = r100.mcustom_type;
            if (r101 == null) goto L5;
            int r102 = CustomType.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + CustomSubType.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mneed_tabs)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomSummaryAction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomSummaryAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomSummaryAction r101) throws IOException {
            CustomType r102 = r101.mcustom_type;
            if (r102 == null) goto L5;
            CustomType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            CustomSubType.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mneed_tabs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomSummaryAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryAction();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcustom_type = this.mcustom_type;
        r100.mneed_tabs = Internal.copyOf("mneed_tabs", this.mneed_tabs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomSummaryAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomSummaryAction(CustomType r100, List<CustomSubType> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CustomSummaryAction(CustomType r100, List<CustomSubType> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mcustom_type = r100;
        this.mneed_tabs = Internal.immutableCopyOf("mneed_tabs", r101);
    }
}
