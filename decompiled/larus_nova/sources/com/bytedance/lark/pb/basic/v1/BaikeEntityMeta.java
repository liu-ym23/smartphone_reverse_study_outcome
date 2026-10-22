package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class BaikeEntityMeta extends com.squareup.wire.Message<BaikeEntityMeta, Builder> {
    public static final ProtoAdapter<BaikeEntityMeta> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_ALLOW_ALL = null;
    private static final long serialVersionUID = 0;
    public final Map<String, TypedIDs> allowed_typed_ids;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253441id;
    public final Boolean is_allow_all;
    public final Map<String, String> platform_disable_option;

    public static final class Builder extends com.squareup.wire.Message.Builder<BaikeEntityMeta, Builder> {
        public Map<String, TypedIDs> allowed_typed_ids;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253442id;
        public Boolean is_allow_all;
        public Map<String, String> platform_disable_option;

        @Override // com.squareup.wire.Message.Builder
        public BaikeEntityMeta build() {
            String r100 = this.f253442id;
            if (r100 == null) goto L7;
            return new BaikeEntityMeta(this.f253442id, this.is_allow_all, this.allowed_typed_ids, this.platform_disable_option, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.allowed_typed_ids = Internal.newMutableMap();
            this.platform_disable_option = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder allowed_typed_ids(Map<String, TypedIDs> r100) {
            Internal.checkElementsNotNull(r100);
            this.allowed_typed_ids = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253442id = r100;
            return this;
        }

        public Builder is_allow_all(Boolean r100) {
            this.is_allow_all = r100;
            return this;
        }

        public Builder platform_disable_option(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.platform_disable_option = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BaikeEntityMeta extends ProtoAdapter<BaikeEntityMeta> {
        private final ProtoAdapter<Map<String, TypedIDs>> allowed_typed_ids;
        private final ProtoAdapter<Map<String, String>> platform_disable_option;

        public ProtoAdapter_BaikeEntityMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, BaikeEntityMeta.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.allowed_typed_ids = ProtoAdapter.newMapAdapter(r100, TypedIDs.ADAPTER);
            this.platform_disable_option = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BaikeEntityMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253442id = "";
            r101.is_allow_all = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.f253442id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.is_allow_all = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.allowed_typed_ids.putAll(this.allowed_typed_ids.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.platform_disable_option.putAll(this.platform_disable_option.decode(r100));
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
        public int encodedSize2(BaikeEntityMeta r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253441id);
            Boolean r102 = r100.is_allow_all;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (((r101 + r103) + this.allowed_typed_ids.encodedSizeWithTag(3, r100.allowed_typed_ids)) + this.platform_disable_option.encodedSizeWithTag(4, r100.platform_disable_option)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BaikeEntityMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BaikeEntityMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BaikeEntityMeta r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253441id);
            Boolean r102 = r101.is_allow_all;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            this.allowed_typed_ids.encodeWithTag(r100, 3, r101.allowed_typed_ids);
            this.platform_disable_option.encodeWithTag(r100, 4, r101.platform_disable_option);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BaikeEntityMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class TypedIDs extends com.squareup.wire.Message<TypedIDs, Builder> {
        public static final ProtoAdapter<TypedIDs> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> ids;

        public static final class Builder extends com.squareup.wire.Message.Builder<TypedIDs, Builder> {
            public List<String> ids;

            @Override // com.squareup.wire.Message.Builder
            public TypedIDs build() {
                return new TypedIDs(this.ids, super.buildUnknownFields());
            }

            public Builder() {
                this.ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TypedIDs extends ProtoAdapter<TypedIDs> {
            public ProtoAdapter_TypedIDs() {
                super(FieldEncoding.LENGTH_DELIMITED, TypedIDs.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TypedIDs decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TypedIDs r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TypedIDs decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TypedIDs r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TypedIDs r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TypedIDs r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TypedIDs();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.ids = Internal.copyOf("ids", this.ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TypedIDs.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TypedIDs(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public TypedIDs(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.ids = Internal.immutableCopyOf("ids", r100);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BaikeEntityMeta();
        DEFAULT_IS_ALLOW_ALL = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253442id = this.f253441id;
        r100.is_allow_all = this.is_allow_all;
        r100.allowed_typed_ids = Internal.copyOf("allowed_typed_ids", this.allowed_typed_ids);
        r100.platform_disable_option = Internal.copyOf("platform_disable_option", this.platform_disable_option);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BaikeEntityMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public BaikeEntityMeta(String r100, Boolean r101, Map<String, TypedIDs> r102, Map<String, String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public BaikeEntityMeta(String r100, Boolean r101, Map<String, TypedIDs> r102, Map<String, String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.f253441id = r100;
        this.is_allow_all = r101;
        this.allowed_typed_ids = Internal.immutableCopyOf("allowed_typed_ids", r102);
        this.platform_disable_option = Internal.immutableCopyOf("platform_disable_option", r103);
    }
}
