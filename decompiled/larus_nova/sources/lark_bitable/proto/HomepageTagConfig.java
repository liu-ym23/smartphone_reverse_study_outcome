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
public final class HomepageTagConfig extends Message<HomepageTagConfig, Builder> {
    public static final ProtoAdapter<HomepageTagConfig> ADAPTER = null;
    public static final Boolean DEFAULT_SHOW_EXTERNAL = null;
    public static final Boolean DEFAULT_SHOW_FILE_RISK_TAG = null;
    public static final Boolean DEFAULT_SHOW_TEMPLATE = null;
    private static final long serialVersionUID = 0;
    public final Boolean show_external;
    public final Boolean show_file_risk_tag;
    public final Boolean show_template;

    public static final class Builder extends Message.Builder<HomepageTagConfig, Builder> {
        public Boolean show_external;
        public Boolean show_file_risk_tag;
        public Boolean show_template;

        @Override // com.squareup.wire.Message.Builder
        public HomepageTagConfig build() {
            Boolean r100 = this.show_template;
            if (r100 == null) goto L11;
            if (this.show_external == null) goto L11;
            if (this.show_file_risk_tag == null) goto L11;
            return new HomepageTagConfig(this.show_template, this.show_external, this.show_file_risk_tag, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "show_template", this.show_external, "show_external", this.show_file_risk_tag, "show_file_risk_tag"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder show_external(Boolean r100) {
            this.show_external = r100;
            return this;
        }

        public Builder show_file_risk_tag(Boolean r100) {
            this.show_file_risk_tag = r100;
            return this;
        }

        public Builder show_template(Boolean r100) {
            this.show_template = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HomepageTagConfig extends ProtoAdapter<HomepageTagConfig> {
        public ProtoAdapter_HomepageTagConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, HomepageTagConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public HomepageTagConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.show_template = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.show_external = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.show_file_risk_tag = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(HomepageTagConfig r100) {
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            return ((r101.encodedSizeWithTag(1, r100.show_template) + r101.encodedSizeWithTag(2, r100.show_external)) + r101.encodedSizeWithTag(3, r100.show_file_risk_tag)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HomepageTagConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HomepageTagConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HomepageTagConfig r101) throws IOException {
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 1, r101.show_template);
            r102.encodeWithTag(r100, 2, r101.show_external);
            r102.encodeWithTag(r100, 3, r101.show_file_risk_tag);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HomepageTagConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HomepageTagConfig();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SHOW_TEMPLATE = r100;
        DEFAULT_SHOW_EXTERNAL = r100;
        DEFAULT_SHOW_FILE_RISK_TAG = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.show_template = this.show_template;
        r100.show_external = this.show_external;
        r100.show_file_risk_tag = this.show_file_risk_tag;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HomepageTagConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HomepageTagConfig(Boolean r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public HomepageTagConfig(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.show_template = r100;
        this.show_external = r101;
        this.show_file_risk_tag = r102;
    }
}
