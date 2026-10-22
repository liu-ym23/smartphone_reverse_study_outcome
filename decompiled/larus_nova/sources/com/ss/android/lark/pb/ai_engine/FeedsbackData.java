package com.ss.android.lark.pb.ai_engine;

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
public final class FeedsbackData extends Message<FeedsbackData, Builder> {
    public static final ProtoAdapter<FeedsbackData> ADAPTER = null;
    public static final String DEFAULT_EXTRA = "";
    public static final Boolean DEFAULT_LIKE = null;
    private static final long serialVersionUID = 0;
    public final String mextra;
    public final Boolean mlike;
    public final List<String> mreason_id;

    public static final class Builder extends Message.Builder<FeedsbackData, Builder> {
        public String mextra;
        public Boolean mlike;
        public List<String> mreason_id;

        @Override // com.squareup.wire.Message.Builder
        public FeedsbackData build() {
            return new FeedsbackData(this.mlike, this.mreason_id, this.mextra, super.buildUnknownFields());
        }

        public Builder() {
            this.mreason_id = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extra(String r100) {
            this.mextra = r100;
            return this;
        }

        public Builder like(Boolean r100) {
            this.mlike = r100;
            return this;
        }

        public Builder reason_id(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mreason_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedsbackData extends ProtoAdapter<FeedsbackData> {
        public ProtoAdapter_FeedsbackData() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedsbackData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedsbackData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mlike = Boolean.FALSE;
            r101.mextra = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mlike = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mreason_id.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mextra = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FeedsbackData r100) {
            Boolean r101 = r100.mlike;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            int r105 = r103 + r104.asRepeated().encodedSizeWithTag(2, r100.mreason_id);
            String r106 = r100.mextra;
            if (r106 == null) goto L10;
            r102 = r104.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedsbackData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedsbackData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedsbackData r101) throws IOException {
            Boolean r102 = r101.mlike;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.asRepeated().encodeWithTag(r100, 2, r101.mreason_id);
            String r104 = r101.mextra;
            if (r104 == null) goto L8;
            r103.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedsbackData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedsbackData();
        DEFAULT_LIKE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlike = this.mlike;
        r100.mreason_id = Internal.copyOf("mreason_id", this.mreason_id);
        r100.mextra = this.mextra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedsbackData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedsbackData(Boolean r100, List<String> r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FeedsbackData(Boolean r100, List<String> r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mlike = r100;
        this.mreason_id = Internal.immutableCopyOf("mreason_id", r101);
        this.mextra = r102;
    }
}
