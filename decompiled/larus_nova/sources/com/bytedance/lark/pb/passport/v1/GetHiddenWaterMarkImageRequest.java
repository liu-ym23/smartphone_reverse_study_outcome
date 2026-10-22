package com.bytedance.lark.pb.passport.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetHiddenWaterMarkImageRequest extends Message<GetHiddenWaterMarkImageRequest, Builder> {
    public static final ProtoAdapter<GetHiddenWaterMarkImageRequest> ADAPTER = null;
    public static final Integer DEFAULT_ALPHA_FLAG = null;
    public static final Integer DEFAULT_COLOR_RGBA8 = null;
    public static final ImgSizeOption DEFAULT_SIZE_OPTION = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetHiddenWaterMarkImageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer alpha_flag;
    public final Integer color_rgba8;
    public final PointContext point_context;
    public final ImgSizeOption size_option;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetHiddenWaterMarkImageRequest, Builder> implements d<GetHiddenWaterMarkImageRequest> {
        public Integer alpha_flag;
        public Integer color_rgba8;
        public PointContext point_context;
        public ImgSizeOption size_option;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetHiddenWaterMarkImageRequest build() {
            return new GetHiddenWaterMarkImageRequest(this.color_rgba8, this.size_option, this.alpha_flag, this.sync_data_strategy, this.point_context, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder alpha_flag(Integer r100) {
            this.alpha_flag = r100;
            return this;
        }

        public Builder color_rgba8(Integer r100) {
            this.color_rgba8 = r100;
            return this;
        }

        public Builder point_context(PointContext r100) {
            this.point_context = r100;
            return this;
        }

        public Builder size_option(ImgSizeOption r100) {
            this.size_option = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final enum ImgSizeOption extends Enum<ImgSizeOption> implements WireEnum {
        private static final /* synthetic */ ImgSizeOption[] $VALUES = null;
        public static final ProtoAdapter<ImgSizeOption> ADAPTER = null;
        public static final ImgSizeOption ImgSizeOption_SIZE_192_192 = null;
        public static final ImgSizeOption ImgSizeOption_SIZE_288_288 = null;
        public static final ImgSizeOption ImgSizeOption_SIZE_384_384 = null;
        public static final ImgSizeOption ImgSizeOption_SIZE_DEFAULT = null;
        private final int value;

        static {
            ImgSizeOption r100 = new ImgSizeOption("ImgSizeOption_SIZE_DEFAULT", 0, 1);
            ImgSizeOption_SIZE_DEFAULT = r100;
            ImgSizeOption r101 = new ImgSizeOption("ImgSizeOption_SIZE_192_192", 1, 2);
            ImgSizeOption_SIZE_192_192 = r101;
            ImgSizeOption r102 = new ImgSizeOption("ImgSizeOption_SIZE_288_288", 2, 3);
            ImgSizeOption_SIZE_288_288 = r102;
            ImgSizeOption r103 = new ImgSizeOption("ImgSizeOption_SIZE_384_384", 3, 4);
            ImgSizeOption_SIZE_384_384 = r103;
            $VALUES = new ImgSizeOption[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(ImgSizeOption.class);
        }

        public static ImgSizeOption[] values() {
            return (ImgSizeOption[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ImgSizeOption fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return ImgSizeOption_SIZE_384_384;
        L15:
            return ImgSizeOption_SIZE_288_288;
        L17:
            return ImgSizeOption_SIZE_192_192;
        L19:
            return ImgSizeOption_SIZE_DEFAULT;
        }

        public static ImgSizeOption valueOf(String r100) {
            return (ImgSizeOption) a.a(ImgSizeOption.class, r100);
        }

        private ImgSizeOption(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetHiddenWaterMarkImageRequest extends ProtoAdapter<GetHiddenWaterMarkImageRequest> implements c<GetHiddenWaterMarkImageRequest> {
        public ProtoAdapter_GetHiddenWaterMarkImageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetHiddenWaterMarkImageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetHiddenWaterMarkImageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.color_rgba8 = 0;
            r101.size_option = ImgSizeOption.ImgSizeOption_SIZE_DEFAULT;
            r101.alpha_flag = 0;
            r101.sync_data_strategy = SyncDataStrategy.FORCE_SERVER;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.color_rgba8 = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.size_option = ImgSizeOption.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.alpha_flag = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.point_context = PointContext.ADAPTER.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetHiddenWaterMarkImageRequest r100) {
            Integer r101 = r100.color_rgba8;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.UINT32.encodedSizeWithTag(1, r101);
        L6:
            ImgSizeOption r104 = r100.size_option;
            if (r104 == null) goto L9;
            int r105 = ImgSizeOption.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.alpha_flag;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            SyncDataStrategy r110 = r100.sync_data_strategy;
            if (r110 == null) goto L17;
            int r111 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            PointContext r113 = r100.point_context;
            if (r113 == null) goto L22;
            r102 = PointContext.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ GetHiddenWaterMarkImageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetHiddenWaterMarkImageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetHiddenWaterMarkImageRequest r101) throws IOException {
            Integer r102 = r101.color_rgba8;
            if (r102 == null) goto L5;
            ProtoAdapter.UINT32.encodeWithTag(r100, 1, r102);
        L5:
            ImgSizeOption r103 = r101.size_option;
            if (r103 == null) goto L8;
            ImgSizeOption.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.alpha_flag;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            SyncDataStrategy r105 = r101.sync_data_strategy;
            if (r105 == null) goto L14;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            PointContext r106 = r101.point_context;
            if (r106 == null) goto L17;
            PointContext.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetHiddenWaterMarkImageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetHiddenWaterMarkImageRequest r100 = new ProtoAdapter_GetHiddenWaterMarkImageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_COLOR_RGBA8 = 0;
        DEFAULT_SIZE_OPTION = ImgSizeOption.ImgSizeOption_SIZE_DEFAULT;
        DEFAULT_ALPHA_FLAG = 0;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.FORCE_SERVER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.color_rgba8 = this.color_rgba8;
        r100.size_option = this.size_option;
        r100.alpha_flag = this.alpha_flag;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.point_context = this.point_context;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetHiddenWaterMarkImageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetHiddenWaterMarkImageRequest(Integer r100, ImgSizeOption r101, Integer r110, SyncDataStrategy r111, PointContext r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public GetHiddenWaterMarkImageRequest(Integer r100, ImgSizeOption r101, Integer r102, SyncDataStrategy r103, PointContext r104, ByteString r105) {
        super(ADAPTER, r105);
        this.color_rgba8 = r100;
        this.size_option = r101;
        this.alpha_flag = r102;
        this.sync_data_strategy = r103;
        this.point_context = r104;
    }
}
