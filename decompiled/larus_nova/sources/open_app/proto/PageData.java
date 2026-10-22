package open_app.proto;

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
public final class PageData extends Message<PageData, Builder> {
    public static final ProtoAdapter<PageData> ADAPTER = null;
    public static final String DEFAULT_HELP_URL = "";
    public static final Integer DEFAULT_MAX_COMMON_ITEMS = null;
    private static final long serialVersionUID = 0;
    public final List<AppInfo> available;
    public final List<AppInfo> external;
    public final String help_url;
    public final Integer max_common_items;

    public static final class Builder extends Message.Builder<PageData, Builder> {
        public List<AppInfo> available;
        public List<AppInfo> external;
        public String help_url;
        public Integer max_common_items;

        @Override // com.squareup.wire.Message.Builder
        public PageData build() {
            Integer r100 = this.max_common_items;
            if (r100 == null) goto L7;
            return new PageData(this.external, this.available, this.help_url, this.max_common_items, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "max_common_items"});
        }

        public Builder() {
            this.external = Internal.newMutableList();
            this.available = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder available(List<AppInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.available = r100;
            return this;
        }

        public Builder external(List<AppInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.external = r100;
            return this;
        }

        public Builder help_url(String r100) {
            this.help_url = r100;
            return this;
        }

        public Builder max_common_items(Integer r100) {
            this.max_common_items = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PageData extends ProtoAdapter<PageData> {
        public ProtoAdapter_PageData() {
            super(FieldEncoding.LENGTH_DELIMITED, PageData.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PageData decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.external.add(AppInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.available.add(AppInfo.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.help_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.max_common_items = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(PageData r100) {
            ProtoAdapter<AppInfo> r101 = AppInfo.ADAPTER;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.external) + r101.asRepeated().encodedSizeWithTag(2, r100.available);
            String r103 = r100.help_url;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(3, r103);
        L7:
            return ((r102 + r104) + ProtoAdapter.INT32.encodedSizeWithTag(4, r100.max_common_items)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PageData decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PageData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PageData r101) throws IOException {
            ProtoAdapter<AppInfo> r102 = AppInfo.ADAPTER;
            r102.asRepeated().encodeWithTag(r100, 1, r101.external);
            r102.asRepeated().encodeWithTag(r100, 2, r101.available);
            String r103 = r101.help_url;
            if (r103 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L5:
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r101.max_common_items);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PageData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PageData();
        DEFAULT_MAX_COMMON_ITEMS = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.external = Internal.copyOf("external", this.external);
        r100.available = Internal.copyOf("available", this.available);
        r100.help_url = this.help_url;
        r100.max_common_items = this.max_common_items;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PageData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PageData(List<AppInfo> r100, List<AppInfo> r101, String r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PageData(List<AppInfo> r100, List<AppInfo> r101, String r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.external = Internal.immutableCopyOf("external", r100);
        this.available = Internal.immutableCopyOf("available", r101);
        this.help_url = r102;
        this.max_common_items = r103;
    }
}
