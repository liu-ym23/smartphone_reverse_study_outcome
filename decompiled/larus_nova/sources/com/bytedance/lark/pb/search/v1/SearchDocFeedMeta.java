package com.bytedance.lark.pb.search.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.lark.pb.basic.v1.DocFeed;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchDocFeedMeta extends Message<SearchDocFeedMeta, Builder> {
    public static final ProtoAdapter<SearchDocFeedMeta> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_DELAYED = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Integer DEFAULT_NEW_MESSAGE_COUNT = null;
    public static final DocFeed.Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253691id;
    public final Boolean is_cross_tenant;
    public final Boolean is_delayed;
    public final Boolean is_remind;
    public final Integer new_message_count;
    public final List<Tag> tags;
    public final DocFeed.Type type;

    public static final class Builder extends Message.Builder<SearchDocFeedMeta, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253692id;
        public Boolean is_cross_tenant;
        public Boolean is_delayed;
        public Boolean is_remind;
        public Integer new_message_count;
        public List<Tag> tags;
        public DocFeed.Type type;

        @Override // com.squareup.wire.Message.Builder
        public SearchDocFeedMeta build() {
            String r100 = this.f253692id;
            if (r100 == null) goto L7;
            return new SearchDocFeedMeta(this.f253692id, this.new_message_count, this.is_remind, this.type, this.is_delayed, this.is_cross_tenant, this.tags, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253692id = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
            return this;
        }

        public Builder is_delayed(Boolean r100) {
            this.is_delayed = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }

        public Builder new_message_count(Integer r100) {
            this.new_message_count = r100;
            return this;
        }

        public Builder tags(List<Tag> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
            return this;
        }

        public Builder type(DocFeed.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchDocFeedMeta extends ProtoAdapter<SearchDocFeedMeta> {
        public ProtoAdapter_SearchDocFeedMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchDocFeedMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchDocFeedMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253692id = "";
            r101.new_message_count = 0;
            r101.is_remind = Boolean.TRUE;
            r101.type = DocFeed.Type.DOC;
            Boolean r102 = Boolean.FALSE;
            r101.is_delayed = r102;
            r101.is_cross_tenant = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L20;
            switch(r104) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L24;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L22;
                default: goto L6;
            };
        L22:
            r101.tags.add(Tag.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L24:
            r101.type = DocFeed.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.is_delayed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.new_message_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L19:
            r101.f253692id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchDocFeedMeta r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253691id);
            Integer r102 = r100.new_message_count;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.is_remind;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            DocFeed.Type r109 = r100.type;
            if (r109 == null) goto L13;
            int r110 = DocFeed.Type.ADAPTER.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            Boolean r112 = r100.is_delayed;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            Boolean r115 = r100.is_cross_tenant;
            if (r115 == null) goto L22;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r115);
        L22:
            return ((r114 + r103) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.tags)) + r100.unknownFields().size();
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchDocFeedMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchDocFeedMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchDocFeedMeta r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253691id);
            Integer r102 = r101.new_message_count;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.is_remind;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            DocFeed.Type r104 = r101.type;
            if (r104 == null) goto L11;
            DocFeed.Type.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            Boolean r105 = r101.is_delayed;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.is_cross_tenant;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L17:
            Tag.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.tags);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchDocFeedMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchDocFeedMeta();
        DEFAULT_NEW_MESSAGE_COUNT = 0;
        DEFAULT_IS_REMIND = Boolean.TRUE;
        DEFAULT_TYPE = DocFeed.Type.DOC;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_DELAYED = r100;
        DEFAULT_IS_CROSS_TENANT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253692id = this.f253691id;
        r100.new_message_count = this.new_message_count;
        r100.is_remind = this.is_remind;
        r100.type = this.type;
        r100.is_delayed = this.is_delayed;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchDocFeedMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchDocFeedMeta(String r110, Integer r111, Boolean r112, DocFeed.Type r113, Boolean r114, Boolean r115, List<Tag> r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public SearchDocFeedMeta(String r100, Integer r101, Boolean r102, DocFeed.Type r103, Boolean r104, Boolean r105, List<Tag> r106, ByteString r107) {
        super(ADAPTER, r107);
        this.f253691id = r100;
        this.new_message_count = r101;
        this.is_remind = r102;
        this.type = r103;
        this.is_delayed = r104;
        this.is_cross_tenant = r105;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r106);
    }
}
