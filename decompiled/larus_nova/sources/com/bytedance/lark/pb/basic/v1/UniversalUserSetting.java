package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UniversalUserSetting extends com.squareup.wire.Message<UniversalUserSetting, Builder> {
    public static final ProtoAdapter<UniversalUserSetting> ADAPTER = null;
    public static final Boolean DEFAULT_BOOL_VALUE = null;
    public static final Long DEFAULT_INT_VALUE = null;
    public static final Boolean DEFAULT_IS_DEFAULT = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_STR_VALUE = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final Boolean bool_value;
    public final Long int_value;
    public final Boolean is_default;
    public final String key;
    public final String str_value;
    public final Long update_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<UniversalUserSetting, Builder> {
        public Boolean bool_value;
        public Long int_value;
        public Boolean is_default;
        public String key;
        public String str_value;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public UniversalUserSetting build() {
            String r100 = this.key;
            if (r100 == null) goto L7;
            return new UniversalUserSetting(this.key, this.is_default, this.update_time, this.int_value, this.str_value, this.bool_value, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "key"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder bool_value(Boolean r100) {
            this.bool_value = r100;
            this.int_value = null;
            this.str_value = null;
            return this;
        }

        public Builder int_value(Long r100) {
            this.int_value = r100;
            this.str_value = null;
            this.bool_value = null;
            return this;
        }

        public Builder is_default(Boolean r100) {
            this.is_default = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder str_value(String r100) {
            this.str_value = r100;
            this.int_value = null;
            this.bool_value = null;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UniversalUserSetting extends ProtoAdapter<UniversalUserSetting> {
        public ProtoAdapter_UniversalUserSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalUserSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalUserSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_default = r102;
            r101.update_time = 0L;
            r101.int_value(0L);
            r101.str_value("");
            r101.bool_value(r102);
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L24;
            if (r104 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.is_default = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.int_value(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.str_value(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            if (r104 != 5) goto L16;
            r101.bool_value(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L16:
            if (r104 != 21) goto L17;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UniversalUserSetting r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.key);
            Boolean r103 = r100.is_default;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.update_time;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(21, r107);
        L10:
            int r109 = r106 + r108;
            Long r110 = r100.int_value;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(3, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.str_value;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(4, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.bool_value;
            if (r116 == null) goto L22;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UniversalUserSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalUserSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalUserSetting r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key);
            Boolean r103 = r101.is_default;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L5:
            Long r104 = r101.update_time;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 21, r104);
        L8:
            Long r105 = r101.int_value;
            if (r105 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r105);
        L11:
            String r106 = r101.str_value;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 4, r106);
        L14:
            Boolean r107 = r101.bool_value;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalUserSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UniversalUserSetting();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_DEFAULT = r100;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_INT_VALUE = 0L;
        DEFAULT_BOOL_VALUE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.is_default = this.is_default;
        r100.update_time = this.update_time;
        r100.int_value = this.int_value;
        r100.str_value = this.str_value;
        r100.bool_value = this.bool_value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UniversalUserSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalUserSetting(String r100, Boolean r110, Long r111, Long r112, String r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public UniversalUserSetting(String r100, Boolean r101, Long r102, Long r103, String r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        if (Internal.countNonNull(r103, r104, r105) > 1) goto L7;
        this.key = r100;
        this.is_default = r101;
        this.update_time = r102;
        this.int_value = r103;
        this.str_value = r104;
        this.bool_value = r105;
        return;
    L7:
        throw new IllegalArgumentException("at most one of int_value, str_value, bool_value may be non-null");
    }
}
