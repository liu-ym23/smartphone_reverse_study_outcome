package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DisplayConfig extends Message<DisplayConfig, Builder> {
    public static final ProtoAdapter<DisplayConfig> ADAPTER = null;
    public static final Integer DEFAULT_RANK_IN_CATEGORY = null;
    public static final Integer DEFAULT_SAMPLE_CATEGORY_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Integer mrank_in_category;
    public final Integer msample_category_type;

    public static final class Builder extends Message.Builder<DisplayConfig, Builder> {
        public Integer mrank_in_category;
        public Integer msample_category_type;

        @Override // com.squareup.wire.Message.Builder
        public DisplayConfig build() {
            return new DisplayConfig(this.msample_category_type, this.mrank_in_category, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder rank_in_category(Integer r100) {
            this.mrank_in_category = r100;
            return this;
        }

        public Builder sample_category_type(Integer r100) {
            this.msample_category_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DisplayConfig extends ProtoAdapter<DisplayConfig> {
        public ProtoAdapter_DisplayConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, DisplayConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DisplayConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msample_category_type = 0;
            r101.mrank_in_category = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.msample_category_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mrank_in_category = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DisplayConfig r100) {
            Integer r101 = r100.msample_category_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mrank_in_category;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DisplayConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DisplayConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DisplayConfig r101) throws IOException {
            Integer r102 = r101.msample_category_type;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mrank_in_category;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DisplayConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DisplayConfig();
        DEFAULT_SAMPLE_CATEGORY_TYPE = 0;
        DEFAULT_RANK_IN_CATEGORY = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msample_category_type = this.msample_category_type;
        r100.mrank_in_category = this.mrank_in_category;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DisplayConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DisplayConfig(Integer r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DisplayConfig(Integer r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.msample_category_type = r100;
        this.mrank_in_category = r101;
    }
}
