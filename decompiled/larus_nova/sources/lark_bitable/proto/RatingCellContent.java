package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class RatingCellContent extends Message<RatingCellContent, Builder> {
    public static final ProtoAdapter<RatingCellContent> ADAPTER = null;
    public static final Long DEFAULT_MAX_NUM = null;
    public static final Long DEFAULT_MIN_NUM = null;
    public static final String DEFAULT_RATING_ICON = "";
    public static final Long DEFAULT_RATING_NUM = null;
    private static final long serialVersionUID = 0;
    public final Long max_num;
    public final Long min_num;
    public final String rating_icon;
    public final Long rating_num;

    public static final class Builder extends Message.Builder<RatingCellContent, Builder> {
        public Long max_num;
        public Long min_num;
        public String rating_icon;
        public Long rating_num;

        @Override // com.squareup.wire.Message.Builder
        public RatingCellContent build() {
            String r100 = this.rating_icon;
            if (r100 == null) goto L13;
            if (this.rating_num == null) goto L13;
            if (this.max_num == null) goto L13;
            if (this.min_num == null) goto L13;
            return new RatingCellContent(this.rating_icon, this.rating_num, this.max_num, this.min_num, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "rating_icon", this.rating_num, "rating_num", this.max_num, "max_num", this.min_num, "min_num"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder max_num(Long r100) {
            this.max_num = r100;
            return this;
        }

        public Builder min_num(Long r100) {
            this.min_num = r100;
            return this;
        }

        public Builder rating_icon(String r100) {
            this.rating_icon = r100;
            return this;
        }

        public Builder rating_num(Long r100) {
            this.rating_num = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RatingCellContent extends ProtoAdapter<RatingCellContent> {
        public ProtoAdapter_RatingCellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, RatingCellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public RatingCellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.rating_icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.rating_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.max_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.min_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RatingCellContent r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.rating_icon);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            return (((r101 + r102.encodedSizeWithTag(2, r100.rating_num)) + r102.encodedSizeWithTag(3, r100.max_num)) + r102.encodedSizeWithTag(4, r100.min_num)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RatingCellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RatingCellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RatingCellContent r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.rating_icon);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 2, r101.rating_num);
            r102.encodeWithTag(r100, 3, r101.max_num);
            r102.encodeWithTag(r100, 4, r101.min_num);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RatingCellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RatingCellContent();
        DEFAULT_RATING_NUM = 0L;
        DEFAULT_MAX_NUM = 0L;
        DEFAULT_MIN_NUM = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rating_icon = this.rating_icon;
        r100.rating_num = this.rating_num;
        r100.max_num = this.max_num;
        r100.min_num = this.min_num;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RatingCellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RatingCellContent(String r100, Long r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public RatingCellContent(String r100, Long r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.rating_icon = r100;
        this.rating_num = r101;
        this.max_num = r102;
        this.min_num = r103;
    }
}
