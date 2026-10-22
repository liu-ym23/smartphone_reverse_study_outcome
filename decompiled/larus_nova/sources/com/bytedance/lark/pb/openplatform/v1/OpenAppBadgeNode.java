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
public final class OpenAppBadgeNode extends Message<OpenAppBadgeNode, Builder> {
    public static final ProtoAdapter<OpenAppBadgeNode> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final Integer DEFAULT_BADGE_NUM = null;
    public static final String DEFAULT_EXTRA = "";
    public static final CommonEnum.OpenAppFeatureType DEFAULT_FEATURE = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_NEED_SHOW = null;
    public static final String DEFAULT_UPDATE_TIME = "";
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    public final String app_id;
    public final Integer badge_num;
    public final String extra;
    public final CommonEnum.OpenAppFeatureType feature;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253673id;
    public final Boolean need_show;
    public final String update_time;
    public final String version;

    public static final class Builder extends Message.Builder<OpenAppBadgeNode, Builder> {
        public String app_id;
        public Integer badge_num;
        public String extra;
        public CommonEnum.OpenAppFeatureType feature;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253674id;
        public Boolean need_show;
        public String update_time;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public OpenAppBadgeNode build() {
            String r100 = this.f253674id;
            if (r100 == null) goto L15;
            if (this.app_id == null) goto L15;
            if (this.feature == null) goto L15;
            if (this.badge_num == null) goto L15;
            if (this.version == null) goto L15;
            return new OpenAppBadgeNode(this.f253674id, this.app_id, this.feature, this.need_show, this.update_time, this.badge_num, this.extra, this.version, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.app_id, "app_id", this.feature, "feature", this.badge_num, "badge_num", this.version, "version"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder badge_num(Integer r100) {
            this.badge_num = r100;
            return this;
        }

        public Builder extra(String r100) {
            this.extra = r100;
            return this;
        }

        public Builder feature(CommonEnum.OpenAppFeatureType r100) {
            this.feature = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253674id = r100;
            return this;
        }

        public Builder need_show(Boolean r100) {
            this.need_show = r100;
            return this;
        }

        public Builder update_time(String r100) {
            this.update_time = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OpenAppBadgeNode extends ProtoAdapter<OpenAppBadgeNode> {
        public ProtoAdapter_OpenAppBadgeNode() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenAppBadgeNode.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpenAppBadgeNode decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253674id = "";
            r101.app_id = "";
            r101.feature = CommonEnum.OpenAppFeatureType.MiniApp;
            r101.need_show = Boolean.FALSE;
            r101.update_time = "";
            r101.badge_num = 0;
            r101.extra = "";
            r101.version = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L20;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.feature = CommonEnum.OpenAppFeatureType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.extra = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.badge_num = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.update_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.need_show = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.f253674id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OpenAppBadgeNode r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.f253673id) + r101.encodedSizeWithTag(2, r100.app_id)) + CommonEnum.OpenAppFeatureType.ADAPTER.encodedSizeWithTag(3, r100.feature);
            Boolean r103 = r100.need_show;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.update_time;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(5, r107);
        L10:
            int r109 = (r106 + r108) + ProtoAdapter.INT32.encodedSizeWithTag(6, r100.badge_num);
            String r110 = r100.extra;
            if (r110 == null) goto L14;
            r104 = r101.encodedSizeWithTag(7, r110);
        L14:
            return ((r109 + r104) + r101.encodedSizeWithTag(8, r100.version)) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OpenAppBadgeNode decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenAppBadgeNode r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenAppBadgeNode r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253673id);
            r102.encodeWithTag(r100, 2, r101.app_id);
            CommonEnum.OpenAppFeatureType.ADAPTER.encodeWithTag(r100, 3, r101.feature);
            Boolean r103 = r101.need_show;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L5:
            String r104 = r101.update_time;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r101.badge_num);
            String r105 = r101.extra;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 7, r105);
        L11:
            r102.encodeWithTag(r100, 8, r101.version);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenAppBadgeNode r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenAppBadgeNode();
        DEFAULT_FEATURE = CommonEnum.OpenAppFeatureType.MiniApp;
        DEFAULT_NEED_SHOW = Boolean.FALSE;
        DEFAULT_BADGE_NUM = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253674id = this.f253673id;
        r100.app_id = this.app_id;
        r100.feature = this.feature;
        r100.need_show = this.need_show;
        r100.update_time = this.update_time;
        r100.badge_num = this.badge_num;
        r100.extra = this.extra;
        r100.version = this.version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenAppBadgeNode.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenAppBadgeNode(String r110, String r111, CommonEnum.OpenAppFeatureType r112, Boolean r113, String r114, Integer r115, String r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public OpenAppBadgeNode(String r100, String r101, CommonEnum.OpenAppFeatureType r102, Boolean r103, String r104, Integer r105, String r106, String r107, ByteString r110) {
        super(ADAPTER, r110);
        this.f253673id = r100;
        this.app_id = r101;
        this.feature = r102;
        this.need_show = r103;
        this.update_time = r104;
        this.badge_num = r105;
        this.extra = r106;
        this.version = r107;
    }
}
