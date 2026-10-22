package com.ss.android.lark.pb.entities;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class MediaContent extends com.squareup.wire.Message<MediaContent, Builder> {
    public static final ProtoAdapter<MediaContent> ADAPTER = null;
    public static final Integer DEFAULT_DURATION = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Boolean DEFAULT_IS_ORIGINAL = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_SCENE_ID = null;
    public static final Long DEFAULT_SIZE = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ResourceCleanScene> mclean_resource_key_scene;
    public final List<String> mclean_resource_keys;
    public final Integer mduration;
    public final String mfs_unit;
    public final ImageSet mimage;
    public final Boolean mis_destroyed;
    public final Boolean mis_original;
    public final String mkey;
    public final String mmime;
    public final String mname;
    public final List<String> mrisk_object_keys;
    public final Long mscene_id;
    public final Long msize;
    public final Source msource;

    public static final class Builder extends com.squareup.wire.Message.Builder<MediaContent, Builder> {
        public Map<String, ResourceCleanScene> mclean_resource_key_scene;
        public List<String> mclean_resource_keys;
        public Integer mduration;
        public String mfs_unit;
        public ImageSet mimage;
        public Boolean mis_destroyed;
        public Boolean mis_original;
        public String mkey;
        public String mmime;
        public String mname;
        public List<String> mrisk_object_keys;
        public Long mscene_id;
        public Long msize;
        public Source msource;

        @Override // com.squareup.wire.Message.Builder
        public MediaContent build() {
            return new MediaContent(this.mkey, this.mname, this.msize, this.mmime, this.msource, this.mimage, this.mduration, this.mfs_unit, this.mis_original, this.mrisk_object_keys, this.mclean_resource_keys, this.mis_destroyed, this.mclean_resource_key_scene, this.mscene_id, super.buildUnknownFields());
        }

        public Builder() {
            this.mrisk_object_keys = Internal.newMutableList();
            this.mclean_resource_keys = Internal.newMutableList();
            this.mclean_resource_key_scene = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder clean_resource_key_scene(Map<String, ResourceCleanScene> r100) {
            Internal.checkElementsNotNull(r100);
            this.mclean_resource_key_scene = r100;
            return this;
        }

        public Builder clean_resource_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mclean_resource_keys = r100;
            return this;
        }

        public Builder duration(Integer r100) {
            this.mduration = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.mfs_unit = r100;
            return this;
        }

        public Builder image(ImageSet r100) {
            this.mimage = r100;
            return this;
        }

        public Builder is_destroyed(Boolean r100) {
            this.mis_destroyed = r100;
            return this;
        }

        public Builder is_original(Boolean r100) {
            this.mis_original = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder mime(String r100) {
            this.mmime = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder risk_object_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mrisk_object_keys = r100;
            return this;
        }

        public Builder scene_id(Long r100) {
            this.mscene_id = r100;
            return this;
        }

        public Builder size(Long r100) {
            this.msize = r100;
            return this;
        }

        public Builder source(Source r100) {
            this.msource = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MediaContent extends ProtoAdapter<MediaContent> {
        private final ProtoAdapter<Map<String, ResourceCleanScene>> mclean_resource_key_scene;

        public ProtoAdapter_MediaContent() {
            super(FieldEncoding.LENGTH_DELIMITED, MediaContent.class);
            this.mclean_resource_key_scene = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ResourceCleanScene.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MediaContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mkey = "";
            r101.mname = "";
            r101.msize = 0L;
            r101.mmime = "";
            r101.mduration = 0;
            r101.mfs_unit = "";
            Boolean r102 = Boolean.FALSE;
            r101.mis_original = r102;
            r101.mis_destroyed = r102;
            r101.mscene_id = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L24;
            switch(r104) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L26;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L26:
            r101.msource = Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mscene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.mclean_resource_key_scene.putAll(this.mclean_resource_key_scene.decode(r100));
            goto L3
        L9:
            r101.mis_destroyed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.mclean_resource_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.mrisk_object_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.mis_original = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mduration = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.mimage = ImageSet.ADAPTER.decode(r100);
            goto L3
        L20:
            r101.mmime = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.msize = ProtoAdapter.INT64.decode(r100);
            goto L3
        L22:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MediaContent r100) {
            String r101 = r100.mkey;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mname;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.msize;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mmime;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Source r113 = r100.msource;
            if (r113 == null) goto L21;
            int r114 = Source.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ImageSet r116 = r100.mimage;
            if (r116 == null) goto L25;
            int r117 = ImageSet.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Integer r119 = r100.mduration;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mfs_unit;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.mis_original;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            ProtoAdapter<String> r128 = ProtoAdapter.STRING;
            int r129 = (r127 + r128.asRepeated().encodedSizeWithTag(10, r100.mrisk_object_keys)) + r128.asRepeated().encodedSizeWithTag(11, r100.mclean_resource_keys);
            Boolean r130 = r100.mis_destroyed;
            if (r130 == null) goto L41;
            int r131 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r130);
        L42:
            int r132 = (r129 + r131) + this.mclean_resource_key_scene.encodedSizeWithTag(13, r100.mclean_resource_key_scene);
            Long r133 = r100.mscene_id;
            if (r133 == null) goto L46;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(14, r133);
        L46:
            return (r132 + r102) + r100.unknownFields().size();
        L41:
            r131 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MediaContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MediaContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MediaContent r101) throws IOException {
            String r102 = r101.mkey;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mname;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.msize;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mmime;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Source r106 = r101.msource;
            if (r106 == null) goto L17;
            Source.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            ImageSet r107 = r101.mimage;
            if (r107 == null) goto L20;
            ImageSet.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Integer r108 = r101.mduration;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.mfs_unit;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.mis_original;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            ProtoAdapter<String> r111 = ProtoAdapter.STRING;
            r111.asRepeated().encodeWithTag(r100, 10, r101.mrisk_object_keys);
            r111.asRepeated().encodeWithTag(r100, 11, r101.mclean_resource_keys);
            Boolean r112 = r101.mis_destroyed;
            if (r112 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r112);
        L32:
            this.mclean_resource_key_scene.encodeWithTag(r100, 13, r101.mclean_resource_key_scene);
            Long r113 = r101.mscene_id;
            if (r113 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r100, 14, r113);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MediaContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Source extends Enum<Source> implements WireEnum {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source LARK = null;
        public static final Source UNKNOWN = null;
        private final int value;

        static {
            Source r100 = new Source("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Source r101 = new Source(AccountType.LARK, 1, 1);
            LARK = r101;
            $VALUES = new Source[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Source.class);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Source fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return LARK;
        L10:
            return UNKNOWN;
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        private Source(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MediaContent();
        DEFAULT_SIZE = 0L;
        DEFAULT_DURATION = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_ORIGINAL = r100;
        DEFAULT_IS_DESTROYED = r100;
        DEFAULT_SCENE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkey = this.mkey;
        r100.mname = this.mname;
        r100.msize = this.msize;
        r100.mmime = this.mmime;
        r100.msource = this.msource;
        r100.mimage = this.mimage;
        r100.mduration = this.mduration;
        r100.mfs_unit = this.mfs_unit;
        r100.mis_original = this.mis_original;
        r100.mrisk_object_keys = Internal.copyOf("mrisk_object_keys", this.mrisk_object_keys);
        r100.mclean_resource_keys = Internal.copyOf("mclean_resource_keys", this.mclean_resource_keys);
        r100.mis_destroyed = this.mis_destroyed;
        r100.mclean_resource_key_scene = Internal.copyOf("mclean_resource_key_scene", this.mclean_resource_key_scene);
        r100.mscene_id = this.mscene_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MediaContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MediaContent(String r110, String r111, Long r112, String r210, Source r211, ImageSet r212, Integer r213, String r214, Boolean r215, List<String> r216, List<String> r217, Boolean r218, Map<String, ResourceCleanScene> r219, Long r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public MediaContent(String r100, String r101, Long r102, String r103, Source r104, ImageSet r105, Integer r110, String r111, Boolean r112, List<String> r113, List<String> r114, Boolean r115, Map<String, ResourceCleanScene> r116, Long r117, ByteString r118) {
        super(ADAPTER, r118);
        this.mkey = r100;
        this.mname = r101;
        this.msize = r102;
        this.mmime = r103;
        this.msource = r104;
        this.mimage = r105;
        this.mduration = r110;
        this.mfs_unit = r111;
        this.mis_original = r112;
        this.mrisk_object_keys = Internal.immutableCopyOf("mrisk_object_keys", r113);
        this.mclean_resource_keys = Internal.immutableCopyOf("mclean_resource_keys", r114);
        this.mis_destroyed = r115;
        this.mclean_resource_key_scene = Internal.immutableCopyOf("mclean_resource_key_scene", r116);
        this.mscene_id = r117;
    }
}
