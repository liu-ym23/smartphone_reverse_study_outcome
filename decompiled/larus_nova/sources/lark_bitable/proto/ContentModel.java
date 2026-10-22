package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class ContentModel extends Message<ContentModel, Builder> {
    public static final ProtoAdapter<ContentModel> ADAPTER = null;
    public static final Integer DEFAULT_HIDDEN_FIELD_COUNT = null;
    private static final long serialVersionUID = 0;
    public final Integer hidden_field_count;
    public final Map<String, RecordItem> item_list;
    public final List<String> item_sort_list;

    public static final class Builder extends Message.Builder<ContentModel, Builder> {
        public Integer hidden_field_count;
        public Map<String, RecordItem> item_list;
        public List<String> item_sort_list;

        @Override // com.squareup.wire.Message.Builder
        public ContentModel build() {
            Integer r100 = this.hidden_field_count;
            if (r100 == null) goto L7;
            return new ContentModel(this.item_list, this.item_sort_list, this.hidden_field_count, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "hidden_field_count"});
        }

        public Builder() {
            this.item_list = Internal.newMutableMap();
            this.item_sort_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder hidden_field_count(Integer r100) {
            this.hidden_field_count = r100;
            return this;
        }

        public Builder item_list(Map<String, RecordItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.item_list = r100;
            return this;
        }

        public Builder item_sort_list(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.item_sort_list = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContentModel extends ProtoAdapter<ContentModel> {
        private final ProtoAdapter<Map<String, RecordItem>> item_list;

        public ProtoAdapter_ContentModel() {
            super(FieldEncoding.LENGTH_DELIMITED, ContentModel.class);
            this.item_list = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, RecordItem.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ContentModel decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.item_list.putAll(this.item_list.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.item_sort_list.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.hidden_field_count = ProtoAdapter.UINT32.decode(r100);
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
        public int encodedSize2(ContentModel r100) {
            return ((this.item_list.encodedSizeWithTag(1, r100.item_list) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.item_sort_list)) + ProtoAdapter.UINT32.encodedSizeWithTag(3, r100.hidden_field_count)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ContentModel decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContentModel r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContentModel r101) throws IOException {
            this.item_list.encodeWithTag(r100, 1, r101.item_list);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.item_sort_list);
            ProtoAdapter.UINT32.encodeWithTag(r100, 3, r101.hidden_field_count);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContentModel r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContentModel();
        DEFAULT_HIDDEN_FIELD_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.item_list = Internal.copyOf("item_list", this.item_list);
        r100.item_sort_list = Internal.copyOf("item_sort_list", this.item_sort_list);
        r100.hidden_field_count = this.hidden_field_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContentModel.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContentModel(Map<String, RecordItem> r100, List<String> r101, Integer r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ContentModel(Map<String, RecordItem> r100, List<String> r101, Integer r102, ByteString r103) {
        super(ADAPTER, r103);
        this.item_list = Internal.immutableCopyOf("item_list", r100);
        this.item_sort_list = Internal.immutableCopyOf("item_sort_list", r101);
        this.hidden_field_count = r102;
    }
}
