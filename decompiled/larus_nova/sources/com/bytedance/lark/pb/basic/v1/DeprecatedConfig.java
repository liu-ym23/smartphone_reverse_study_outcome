package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DeprecatedConfig extends com.squareup.wire.Message<DeprecatedConfig, Builder> {
    public static final ProtoAdapter<DeprecatedConfig> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE_VERBOSE_DBG_INFO = null;
    public static final Boolean DEFAULT_USE_DEPRECATED_PUSH_MSG = null;
    public static final Boolean DEFAULT_USE_DEPRECATED_USER_LST = null;
    private static final long serialVersionUID = 0;
    public final Boolean enable_verbose_dbg_info;
    public final Boolean use_deprecated_push_msg;
    public final Boolean use_deprecated_user_lst;

    public static final class Builder extends com.squareup.wire.Message.Builder<DeprecatedConfig, Builder> {
        public Boolean enable_verbose_dbg_info;
        public Boolean use_deprecated_push_msg;
        public Boolean use_deprecated_user_lst;

        @Override // com.squareup.wire.Message.Builder
        public DeprecatedConfig build() {
            return new DeprecatedConfig(this.use_deprecated_push_msg, this.use_deprecated_user_lst, this.enable_verbose_dbg_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder enable_verbose_dbg_info(Boolean r100) {
            this.enable_verbose_dbg_info = r100;
            return this;
        }

        public Builder use_deprecated_push_msg(Boolean r100) {
            this.use_deprecated_push_msg = r100;
            return this;
        }

        public Builder use_deprecated_user_lst(Boolean r100) {
            this.use_deprecated_user_lst = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeprecatedConfig extends ProtoAdapter<DeprecatedConfig> {
        public ProtoAdapter_DeprecatedConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, DeprecatedConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeprecatedConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.TRUE;
            r101.use_deprecated_push_msg = r102;
            r101.use_deprecated_user_lst = r102;
            r101.enable_verbose_dbg_info = Boolean.FALSE;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.use_deprecated_push_msg = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 3) goto L10;
            r101.use_deprecated_user_lst = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 4) goto L11;
            r101.enable_verbose_dbg_info = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DeprecatedConfig r100) {
            Boolean r101 = r100.use_deprecated_push_msg;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.use_deprecated_user_lst;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.enable_verbose_dbg_info;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeprecatedConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeprecatedConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeprecatedConfig r101) throws IOException {
            Boolean r102 = r101.use_deprecated_push_msg;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.use_deprecated_user_lst;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.enable_verbose_dbg_info;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeprecatedConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeprecatedConfig();
        Boolean r100 = Boolean.TRUE;
        DEFAULT_USE_DEPRECATED_PUSH_MSG = r100;
        DEFAULT_USE_DEPRECATED_USER_LST = r100;
        DEFAULT_ENABLE_VERBOSE_DBG_INFO = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.use_deprecated_push_msg = this.use_deprecated_push_msg;
        r100.use_deprecated_user_lst = this.use_deprecated_user_lst;
        r100.enable_verbose_dbg_info = this.enable_verbose_dbg_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeprecatedConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeprecatedConfig(Boolean r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DeprecatedConfig(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.use_deprecated_push_msg = r100;
        this.use_deprecated_user_lst = r101;
        this.enable_verbose_dbg_info = r102;
    }
}
