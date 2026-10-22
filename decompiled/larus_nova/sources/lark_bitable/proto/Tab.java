package lark_bitable.proto;

import com.bytedance.android.ec.core.event.a;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class Tab extends Message<Tab, Builder> {
    public static final ProtoAdapter<Tab> ADAPTER = null;
    public static final String DEFAULT_TAB_NAME = "";
    public static final TabType DEFAULT_TAB_TYPE = null;
    private static final long serialVersionUID = 0;
    public final TabContent tab_content;
    public final String tab_name;
    public final TabType tab_type;

    public static final class Builder extends Message.Builder<Tab, Builder> {
        public TabContent tab_content;
        public String tab_name;
        public TabType tab_type;

        @Override // com.squareup.wire.Message.Builder
        public Tab build() {
            String r100 = this.tab_name;
            if (r100 == null) goto L11;
            if (this.tab_type == null) goto L11;
            if (this.tab_content == null) goto L11;
            return new Tab(this.tab_name, this.tab_type, this.tab_content, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, a.KEY_TAB_NAME, this.tab_type, "tab_type", this.tab_content, "tab_content"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder tab_content(TabContent r100) {
            this.tab_content = r100;
            return this;
        }

        public Builder tab_name(String r100) {
            this.tab_name = r100;
            return this;
        }

        public Builder tab_type(TabType r100) {
            this.tab_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Tab extends ProtoAdapter<Tab> {
        public ProtoAdapter_Tab() {
            super(FieldEncoding.LENGTH_DELIMITED, Tab.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public Tab decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.tab_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.tab_type = TabType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.tab_content = TabContent.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Tab r100) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.tab_name) + TabType.ADAPTER.encodedSizeWithTag(2, r100.tab_type)) + TabContent.ADAPTER.encodedSizeWithTag(3, r100.tab_content)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Tab decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Tab r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Tab r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.tab_name);
            TabType.ADAPTER.encodeWithTag(r100, 2, r101.tab_type);
            TabContent.ADAPTER.encodeWithTag(r100, 3, r101.tab_content);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Tab r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Tab();
        DEFAULT_TAB_TYPE = TabType.VAR_TAB_TYPE_MAIN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tab_name = this.tab_name;
        r100.tab_type = this.tab_type;
        r100.tab_content = this.tab_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Tab.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Tab(String r100, TabType r101, TabContent r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public Tab(String r100, TabType r101, TabContent r102, ByteString r103) {
        super(ADAPTER, r103);
        this.tab_name = r100;
        this.tab_type = r101;
        this.tab_content = r102;
    }
}
