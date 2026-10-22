package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.LanguageType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetPagingActivityRecordsRequest extends Message<GetPagingActivityRecordsRequest, Builder> {
    public static final ProtoAdapter<GetPagingActivityRecordsRequest> ADAPTER = null;
    public static final LanguageType DEFAULT_LANGUAGE_TYPE = null;
    public static final SceneType DEFAULT_SCENE_TYPE = null;
    public static final String DEFAULT_TARGET_GUID = "";
    public static final ProtoAdapter_GetPagingActivityRecordsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final LanguageType language_type;
    public final PageParam param;
    public final SceneType scene_type;
    public final String target_guid;

    public static final class Builder extends Message.Builder<GetPagingActivityRecordsRequest, Builder> implements d<GetPagingActivityRecordsRequest> {
        public LanguageType language_type;
        public PageParam param;
        public SceneType scene_type;
        public String target_guid;

        @Override // com.squareup.wire.Message.Builder
        public GetPagingActivityRecordsRequest build() {
            return new GetPagingActivityRecordsRequest(this.scene_type, this.target_guid, this.param, this.language_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder language_type(LanguageType r100) {
            this.language_type = r100;
            return this;
        }

        public Builder param(PageParam r100) {
            this.param = r100;
            return this;
        }

        public Builder scene_type(SceneType r100) {
            this.scene_type = r100;
            return this;
        }

        public Builder target_guid(String r100) {
            this.target_guid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPagingActivityRecordsRequest extends ProtoAdapter<GetPagingActivityRecordsRequest> implements c<GetPagingActivityRecordsRequest> {
        public ProtoAdapter_GetPagingActivityRecordsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPagingActivityRecordsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPagingActivityRecordsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene_type = SceneType.UNKNOWN;
            r101.target_guid = "";
            r101.language_type = LanguageType.UNKNOWN_LANGUAGE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.scene_type = SceneType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.target_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.param = PageParam.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.language_type = LanguageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetPagingActivityRecordsRequest r100) {
            SceneType r101 = r100.scene_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SceneType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.target_guid;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            PageParam r107 = r100.param;
            if (r107 == null) goto L13;
            int r108 = PageParam.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            LanguageType r110 = r100.language_type;
            if (r110 == null) goto L18;
            r102 = LanguageType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ GetPagingActivityRecordsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPagingActivityRecordsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPagingActivityRecordsRequest r101) throws IOException {
            SceneType r102 = r101.scene_type;
            if (r102 == null) goto L5;
            SceneType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.target_guid;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            PageParam r104 = r101.param;
            if (r104 == null) goto L11;
            PageParam.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            LanguageType r105 = r101.language_type;
            if (r105 == null) goto L14;
            LanguageType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPagingActivityRecordsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SceneType extends Enum<SceneType> implements WireEnum {
        private static final /* synthetic */ SceneType[] $VALUES = null;
        public static final ProtoAdapter<SceneType> ADAPTER = null;
        public static final SceneType TASK = null;
        public static final SceneType TASK_LIST = null;
        public static final SceneType UNKNOWN = null;
        public static final SceneType USER = null;
        private final int value;

        static {
            SceneType r100 = new SceneType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            SceneType r101 = new SceneType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            SceneType r102 = new SceneType("TASK_LIST", 2, 2);
            TASK_LIST = r102;
            SceneType r103 = new SceneType("TASK", 3, 3);
            TASK = r103;
            $VALUES = new SceneType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(SceneType.class);
        }

        public static SceneType[] values() {
            return (SceneType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SceneType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return TASK;
        L14:
            return TASK_LIST;
        L16:
            return USER;
        L18:
            return UNKNOWN;
        }

        public static SceneType valueOf(String r100) {
            return (SceneType) a.a(SceneType.class, r100);
        }

        private SceneType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetPagingActivityRecordsRequest r100 = new ProtoAdapter_GetPagingActivityRecordsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE_TYPE = SceneType.UNKNOWN;
        DEFAULT_LANGUAGE_TYPE = LanguageType.UNKNOWN_LANGUAGE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scene_type = this.scene_type;
        r100.target_guid = this.target_guid;
        r100.param = this.param;
        r100.language_type = this.language_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPagingActivityRecordsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPagingActivityRecordsRequest(SceneType r100, String r101, PageParam r102, LanguageType r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetPagingActivityRecordsRequest(SceneType r100, String r101, PageParam r102, LanguageType r103, ByteString r104) {
        super(ADAPTER, r104);
        this.scene_type = r100;
        this.target_guid = r101;
        this.param = r102;
        this.language_type = r103;
    }
}
