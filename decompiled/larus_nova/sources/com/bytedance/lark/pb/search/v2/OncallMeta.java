package com.bytedance.lark.pb.search.v2;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
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
public final class OncallMeta extends Message<OncallMeta, Builder> {
    public static final ProtoAdapter<OncallMeta> ADAPTER = null;
    public static final String DEFAULT_FAQ_IDENTITY = "";
    public static final String DEFAULT_FAQ_TITLE = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_OFFICIAL = null;
    private static final long serialVersionUID = 0;
    public final String faq_identity;
    public final String faq_title;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253725id;
    public final Boolean is_official;
    public final List<Integer> tags;

    public static final class Builder extends Message.Builder<OncallMeta, Builder> {
        public String faq_identity;
        public String faq_title;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253726id;
        public Boolean is_official;
        public List<Integer> tags;

        @Override // com.squareup.wire.Message.Builder
        public OncallMeta build() {
            String r100 = this.f253726id;
            if (r100 == null) goto L7;
            return new OncallMeta(this.f253726id, this.tags, this.faq_identity, this.faq_title, this.is_official, super.buildUnknownFields());
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

        public Builder faq_identity(String r100) {
            this.faq_identity = r100;
            return this;
        }

        public Builder faq_title(String r100) {
            this.faq_title = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253726id = r100;
            return this;
        }

        public Builder is_official(Boolean r100) {
            this.is_official = r100;
            return this;
        }

        public Builder tags(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OncallMeta extends ProtoAdapter<OncallMeta> {
        public ProtoAdapter_OncallMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, OncallMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OncallMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253726id = "";
            r101.faq_identity = "";
            r101.faq_title = "";
            r101.is_official = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.f253726id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.tags.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            if (r103 != 4) goto L12;
            r101.faq_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 5) goto L14;
            r101.is_official = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r103 != 6) goto L15;
            r101.faq_identity = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(OncallMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253725id) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(2, r100.tags);
            String r103 = r100.faq_identity;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(6, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.faq_title;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_official;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OncallMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OncallMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OncallMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253725id);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 2, r101.tags);
            String r103 = r101.faq_identity;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 6, r103);
        L5:
            String r104 = r101.faq_title;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Boolean r105 = r101.is_official;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OncallMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OncallMeta();
        DEFAULT_IS_OFFICIAL = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253726id = this.f253725id;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.faq_identity = this.faq_identity;
        r100.faq_title = this.faq_title;
        r100.is_official = this.is_official;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OncallMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OncallMeta(String r100, List<Integer> r101, String r110, String r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public OncallMeta(String r100, List<Integer> r101, String r102, String r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.f253725id = r100;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r101);
        this.faq_identity = r102;
        this.faq_title = r103;
        this.is_official = r104;
    }
}
