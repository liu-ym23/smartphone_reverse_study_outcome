package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class COTInfo extends com.squareup.wire.Message<COTInfo, Builder> {
    public static final ProtoAdapter<COTInfo> ADAPTER = null;
    public static final Boolean DEFAULT_COT_HIDDEN_AFTER_DONE = null;
    public static final Long DEFAULT_COT_ID = null;
    public static final Boolean DEFAULT_VIOLATED = null;
    private static final long serialVersionUID = 0;
    public final Boolean mcot_hidden_after_done;
    public final Long mcot_id;
    public final COTStatus mcot_status;
    public final Boolean mviolated;

    public static final class Builder extends com.squareup.wire.Message.Builder<COTInfo, Builder> {
        public Boolean mcot_hidden_after_done;
        public Long mcot_id;
        public COTStatus mcot_status;
        public Boolean mviolated;

        @Override // com.squareup.wire.Message.Builder
        public COTInfo build() {
            return new COTInfo(this.mcot_id, this.mcot_status, this.mviolated, this.mcot_hidden_after_done, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cot_hidden_after_done(Boolean r100) {
            this.mcot_hidden_after_done = r100;
            return this;
        }

        public Builder cot_id(Long r100) {
            this.mcot_id = r100;
            return this;
        }

        public Builder cot_status(COTStatus r100) {
            this.mcot_status = r100;
            return this;
        }

        public Builder violated(Boolean r100) {
            this.mviolated = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_COTInfo extends ProtoAdapter<COTInfo> {
        public ProtoAdapter_COTInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, COTInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public COTInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcot_id = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.mviolated = r102;
            r101.mcot_hidden_after_done = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.mcot_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mcot_status = COTStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.mviolated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.mcot_hidden_after_done = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(COTInfo r100) {
            Long r101 = r100.mcot_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            COTStatus r104 = r100.mcot_status;
            if (r104 == null) goto L9;
            int r105 = COTStatus.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mviolated;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mcot_hidden_after_done;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ COTInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(COTInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, COTInfo r101) throws IOException {
            Long r102 = r101.mcot_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            COTStatus r103 = r101.mcot_status;
            if (r103 == null) goto L8;
            COTStatus.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mviolated;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.mcot_hidden_after_done;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, COTInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_COTInfo();
        DEFAULT_COT_ID = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_VIOLATED = r100;
        DEFAULT_COT_HIDDEN_AFTER_DONE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcot_id = this.mcot_id;
        r100.mcot_status = this.mcot_status;
        r100.mviolated = this.mviolated;
        r100.mcot_hidden_after_done = this.mcot_hidden_after_done;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return COTInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public COTInfo(Long r100, COTStatus r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public COTInfo(Long r100, COTStatus r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mcot_id = r100;
        this.mcot_status = r101;
        this.mviolated = r102;
        this.mcot_hidden_after_done = r103;
    }
}
