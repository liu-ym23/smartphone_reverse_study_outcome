package com.bytedance.lark.pb.search.v2;

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
public final class NavigationAppPopup extends Message<NavigationAppPopup, Builder> {
    public static final ProtoAdapter<NavigationAppPopup> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_APP_KEY = "";
    private static final long serialVersionUID = 0;
    public final String app_id;
    public final String app_key;
    public final List<SearchActionFilter> default_filter;

    public static final class Builder extends Message.Builder<NavigationAppPopup, Builder> {
        public String app_id;
        public String app_key;
        public List<SearchActionFilter> default_filter;

        @Override // com.squareup.wire.Message.Builder
        public NavigationAppPopup build() {
            return new NavigationAppPopup(this.app_id, this.app_key, this.default_filter, super.buildUnknownFields());
        }

        public Builder() {
            this.default_filter = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder app_key(String r100) {
            this.app_key = r100;
            return this;
        }

        public Builder default_filter(List<SearchActionFilter> r100) {
            Internal.checkElementsNotNull(r100);
            this.default_filter = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_NavigationAppPopup extends ProtoAdapter<NavigationAppPopup> {
        public ProtoAdapter_NavigationAppPopup() {
            super(FieldEncoding.LENGTH_DELIMITED, NavigationAppPopup.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NavigationAppPopup decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_id = "";
            r101.app_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.app_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.default_filter.add(SearchActionFilter.ADAPTER.decode(r100));
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
        public int encodedSize2(NavigationAppPopup r100) {
            String r101 = r100.app_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.app_key;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + SearchActionFilter.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.default_filter)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NavigationAppPopup decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NavigationAppPopup r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NavigationAppPopup r101) throws IOException {
            String r102 = r101.app_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.app_key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            SearchActionFilter.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.default_filter);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NavigationAppPopup r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NavigationAppPopup();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.app_key = this.app_key;
        r100.default_filter = Internal.copyOf("default_filter", this.default_filter);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NavigationAppPopup.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NavigationAppPopup(String r100, String r101, List<SearchActionFilter> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public NavigationAppPopup(String r100, String r101, List<SearchActionFilter> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.app_id = r100;
        this.app_key = r101;
        this.default_filter = Internal.immutableCopyOf("default_filter", r102);
    }
}
