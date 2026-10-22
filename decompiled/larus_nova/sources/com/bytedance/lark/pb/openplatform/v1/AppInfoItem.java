package com.bytedance.lark.pb.openplatform.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AppInfoItem extends Message<AppInfoItem, Builder> {
    public static final ProtoAdapter<AppInfoItem> ADAPTER = null;
    public static final Long DEFAULT_APP_ID = null;
    public static final String DEFAULT_AVATAR_URL = "";
    public static final Boolean DEFAULT_IS_AGENT = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final Long app_id;
    public final String avatar_url;
    public final Boolean is_agent;
    public final String name;

    public static final class Builder extends Message.Builder<AppInfoItem, Builder> {
        public Long app_id;
        public String avatar_url;
        public Boolean is_agent;
        public String name;

        @Override // com.squareup.wire.Message.Builder
        public AppInfoItem build() {
            Long r100 = this.app_id;
            if (r100 == null) goto L9;
            if (this.name == null) goto L9;
            return new AppInfoItem(this.app_id, this.name, this.is_agent, this.avatar_url, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "app_id", this.name, "name"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(Long r100) {
            this.app_id = r100;
            return this;
        }

        public Builder avatar_url(String r100) {
            this.avatar_url = r100;
            return this;
        }

        public Builder is_agent(Boolean r100) {
            this.is_agent = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AppInfoItem extends ProtoAdapter<AppInfoItem> {
        public ProtoAdapter_AppInfoItem() {
            super(FieldEncoding.LENGTH_DELIMITED, AppInfoItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppInfoItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_id = 0L;
            r101.name = "";
            r101.is_agent = Boolean.FALSE;
            r101.avatar_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.app_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.is_agent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.avatar_url = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AppInfoItem r100) {
            int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.app_id);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.name);
            Boolean r104 = r100.is_agent;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            String r108 = r100.avatar_url;
            if (r108 == null) goto L10;
            r105 = r102.encodedSizeWithTag(4, r108);
        L10:
            return (r107 + r105) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AppInfoItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppInfoItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppInfoItem r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.app_id);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.name);
            Boolean r103 = r101.is_agent;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.avatar_url;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppInfoItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppInfoItem();
        DEFAULT_APP_ID = 0L;
        DEFAULT_IS_AGENT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.name = this.name;
        r100.is_agent = this.is_agent;
        r100.avatar_url = this.avatar_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppInfoItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppInfoItem(Long r100, String r101, Boolean r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AppInfoItem(Long r100, String r101, Boolean r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.app_id = r100;
        this.name = r101;
        this.is_agent = r102;
        this.avatar_url = r103;
    }
}
