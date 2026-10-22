package com.bytedance.lark.pb.openplatform.v1;

import com.amap.api.services.cloud.CloudSearch;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class CommonEnum extends Message<CommonEnum, Builder> {
    public static final ProtoAdapter<CommonEnum> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<CommonEnum, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public CommonEnum build() {
            return new CommonEnum(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final enum LoadStrategy extends Enum<LoadStrategy> implements WireEnum {
        private static final /* synthetic */ LoadStrategy[] $VALUES = null;
        public static final ProtoAdapter<LoadStrategy> ADAPTER = null;
        public static final LoadStrategy Local = null;
        public static final LoadStrategy Net = null;
        private final int value;

        static {
            LoadStrategy r100 = new LoadStrategy(CloudSearch.SearchBound.LOCAL_SHAPE, 0, 1);
            Local = r100;
            LoadStrategy r101 = new LoadStrategy("Net", 1, 2);
            Net = r101;
            $VALUES = new LoadStrategy[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(LoadStrategy.class);
        }

        public static LoadStrategy[] values() {
            return (LoadStrategy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static LoadStrategy fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return Net;
        L11:
            return Local;
        }

        public static LoadStrategy valueOf(String r100) {
            return (LoadStrategy) a.a(LoadStrategy.class, r100);
        }

        private LoadStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum OpenAppFeatureType extends Enum<OpenAppFeatureType> implements WireEnum {
        private static final /* synthetic */ OpenAppFeatureType[] $VALUES = null;
        public static final ProtoAdapter<OpenAppFeatureType> ADAPTER = null;
        public static final OpenAppFeatureType H5 = null;
        public static final OpenAppFeatureType MiniApp = null;
        private final int value;

        static {
            OpenAppFeatureType r100 = new OpenAppFeatureType("MiniApp", 0, 1);
            MiniApp = r100;
            OpenAppFeatureType r101 = new OpenAppFeatureType("H5", 1, 2);
            H5 = r101;
            $VALUES = new OpenAppFeatureType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(OpenAppFeatureType.class);
        }

        public static OpenAppFeatureType[] values() {
            return (OpenAppFeatureType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static OpenAppFeatureType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return H5;
        L11:
            return MiniApp;
        }

        public static OpenAppFeatureType valueOf(String r100) {
            return (OpenAppFeatureType) a.a(OpenAppFeatureType.class, r100);
        }

        private OpenAppFeatureType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_CommonEnum extends ProtoAdapter<CommonEnum> {
        public ProtoAdapter_CommonEnum() {
            super(FieldEncoding.LENGTH_DELIMITED, CommonEnum.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CommonEnum decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CommonEnum r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CommonEnum decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CommonEnum r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CommonEnum r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CommonEnum r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CommonEnum();
    }

    public CommonEnum() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CommonEnum.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CommonEnum(ByteString r100) {
        super(ADAPTER, r100);
    }
}
