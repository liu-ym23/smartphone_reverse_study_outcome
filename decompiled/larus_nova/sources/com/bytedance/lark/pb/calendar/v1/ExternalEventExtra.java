package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ExternalEventExtra extends Message<ExternalEventExtra, Builder> {
    public static final ProtoAdapter<ExternalEventExtra> ADAPTER = null;
    public static final Boolean DEFAULT_DIRECTLY_SYNC_FROM_LARK = null;
    public static final Boolean DEFAULT_IS_ONE_WAY_SYNC = null;
    private static final long serialVersionUID = 0;
    public final Boolean directly_sync_from_lark;
    public final Boolean is_one_way_sync;

    public static final class Builder extends Message.Builder<ExternalEventExtra, Builder> {
        public Boolean directly_sync_from_lark;
        public Boolean is_one_way_sync;

        @Override // com.squareup.wire.Message.Builder
        public ExternalEventExtra build() {
            return new ExternalEventExtra(this.directly_sync_from_lark, this.is_one_way_sync, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder directly_sync_from_lark(Boolean r100) {
            this.directly_sync_from_lark = r100;
            return this;
        }

        public Builder is_one_way_sync(Boolean r100) {
            this.is_one_way_sync = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExternalEventExtra extends ProtoAdapter<ExternalEventExtra> {
        public ProtoAdapter_ExternalEventExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, ExternalEventExtra.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExternalEventExtra decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.directly_sync_from_lark = r102;
            r101.is_one_way_sync = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L12;
            if (r104 != 1) goto L8;
            r101.directly_sync_from_lark = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L9;
            r101.is_one_way_sync = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ExternalEventExtra r100) {
            Boolean r101 = r100.directly_sync_from_lark;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_one_way_sync;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ExternalEventExtra decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExternalEventExtra r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExternalEventExtra r101) throws IOException {
            Boolean r102 = r101.directly_sync_from_lark;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_one_way_sync;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExternalEventExtra r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExternalEventExtra();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_DIRECTLY_SYNC_FROM_LARK = r100;
        DEFAULT_IS_ONE_WAY_SYNC = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.directly_sync_from_lark = this.directly_sync_from_lark;
        r100.is_one_way_sync = this.is_one_way_sync;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExternalEventExtra.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExternalEventExtra(Boolean r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ExternalEventExtra(Boolean r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.directly_sync_from_lark = r100;
        this.is_one_way_sync = r101;
    }
}
