package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class HomepageListData extends Message<HomepageListData, Builder> {
    public static final ProtoAdapter<HomepageListData> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final String DEFAULT_LAST_LABEL = "";
    public static final String DEFAULT_SPACE_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final List<HomepageDocData> doc_data_list;
    public final Boolean has_more;
    public final String last_label;
    public final List<HomepageDocument> raw_data_list;
    public final String space_token;

    public static final class Builder extends Message.Builder<HomepageListData, Builder> {
        public List<HomepageDocData> doc_data_list;
        public Boolean has_more;
        public String last_label;
        public List<HomepageDocument> raw_data_list;
        public String space_token;

        @Override // com.squareup.wire.Message.Builder
        public HomepageListData build() {
            String r100 = this.last_label;
            if (r100 == null) goto L11;
            if (this.has_more == null) goto L11;
            if (this.space_token == null) goto L11;
            return new HomepageListData(this.last_label, this.has_more, this.space_token, this.doc_data_list, this.raw_data_list, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "last_label", this.has_more, "has_more", this.space_token, "space_token"});
        }

        public Builder() {
            this.doc_data_list = Internal.newMutableList();
            this.raw_data_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder doc_data_list(List<HomepageDocData> r100) {
            Internal.checkElementsNotNull(r100);
            this.doc_data_list = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder last_label(String r100) {
            this.last_label = r100;
            return this;
        }

        public Builder raw_data_list(List<HomepageDocument> r100) {
            Internal.checkElementsNotNull(r100);
            this.raw_data_list = r100;
            return this;
        }

        public Builder space_token(String r100) {
            this.space_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HomepageListData extends ProtoAdapter<HomepageListData> {
        public ProtoAdapter_HomepageListData() {
            super(FieldEncoding.LENGTH_DELIMITED, HomepageListData.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public HomepageListData decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.last_label = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.space_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.doc_data_list.add(HomepageDocData.ADAPTER.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.raw_data_list.add(HomepageDocument.ADAPTER.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(HomepageListData r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((((r101.encodedSizeWithTag(1, r100.last_label) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.has_more)) + r101.encodedSizeWithTag(3, r100.space_token)) + HomepageDocData.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.doc_data_list)) + HomepageDocument.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.raw_data_list)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HomepageListData decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HomepageListData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HomepageListData r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.last_label);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.has_more);
            r102.encodeWithTag(r100, 3, r101.space_token);
            HomepageDocData.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.doc_data_list);
            HomepageDocument.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.raw_data_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HomepageListData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HomepageListData();
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.last_label = this.last_label;
        r100.has_more = this.has_more;
        r100.space_token = this.space_token;
        r100.doc_data_list = Internal.copyOf("doc_data_list", this.doc_data_list);
        r100.raw_data_list = Internal.copyOf("raw_data_list", this.raw_data_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HomepageListData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HomepageListData(String r100, Boolean r101, String r110, List<HomepageDocData> r111, List<HomepageDocument> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public HomepageListData(String r100, Boolean r101, String r102, List<HomepageDocData> r103, List<HomepageDocument> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.last_label = r100;
        this.has_more = r101;
        this.space_token = r102;
        this.doc_data_list = Internal.immutableCopyOf("doc_data_list", r103);
        this.raw_data_list = Internal.immutableCopyOf("raw_data_list", r104);
    }
}
