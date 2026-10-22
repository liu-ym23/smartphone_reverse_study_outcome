package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class PullOnboardInfoRequest extends Message<PullOnboardInfoRequest, Builder> {
    public static final ProtoAdapter<PullOnboardInfoRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final Boolean DEFAULT_NEED_SAMPLE_ANSWER = null;
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final Integer mcount;
    public final Boolean mneed_sample_answer;
    public final OnboardType monboard_type;
    public final Integer mversion;

    public static final class Builder extends Message.Builder<PullOnboardInfoRequest, Builder> {
        public Long mchat_id;
        public Integer mcount;
        public Boolean mneed_sample_answer;
        public OnboardType monboard_type;
        public Integer mversion;

        @Override // com.squareup.wire.Message.Builder
        public PullOnboardInfoRequest build() {
            Long r100 = this.mchat_id;
            if (r100 == null) goto L7;
            return new PullOnboardInfoRequest(this.mchat_id, this.monboard_type, this.mversion, this.mneed_sample_answer, this.mcount, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mchat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder count(Integer r100) {
            this.mcount = r100;
            return this;
        }

        public Builder need_sample_answer(Boolean r100) {
            this.mneed_sample_answer = r100;
            return this;
        }

        public Builder onboard_type(OnboardType r100) {
            this.monboard_type = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.mversion = r100;
            return this;
        }
    }

    public static final enum OnboardType extends Enum<OnboardType> implements WireEnum {
        private static final /* synthetic */ OnboardType[] $VALUES = null;
        public static final ProtoAdapter<OnboardType> ADAPTER = null;
        public static final OnboardType ENTERPRISE_SEARCH = null;
        public static final OnboardType SCENE = null;
        private final int value;

        static {
            OnboardType r100 = new OnboardType("SCENE", 0, 0);
            SCENE = r100;
            OnboardType r101 = new OnboardType("ENTERPRISE_SEARCH", 1, 1);
            ENTERPRISE_SEARCH = r101;
            $VALUES = new OnboardType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(OnboardType.class);
        }

        public static OnboardType[] values() {
            return (OnboardType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static OnboardType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return ENTERPRISE_SEARCH;
        L10:
            return SCENE;
        }

        public static OnboardType valueOf(String r100) {
            return (OnboardType) a.a(OnboardType.class, r100);
        }

        private OnboardType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PullOnboardInfoRequest extends ProtoAdapter<PullOnboardInfoRequest> {
        public ProtoAdapter_PullOnboardInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullOnboardInfoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullOnboardInfoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = 0L;
            r101.mversion = 0;
            r101.mneed_sample_answer = Boolean.FALSE;
            r101.mcount = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.monboard_type = OnboardType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mversion = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mneed_sample_answer = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mcount = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullOnboardInfoRequest r100) {
            int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.mchat_id);
            OnboardType r102 = r100.monboard_type;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = OnboardType.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Integer r106 = r100.mversion;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Boolean r109 = r100.mneed_sample_answer;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            Integer r112 = r100.mcount;
            if (r112 == null) goto L18;
            r103 = ProtoAdapter.INT32.encodedSizeWithTag(5, r112);
        L18:
            return (r111 + r103) + r100.unknownFields().size();
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullOnboardInfoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullOnboardInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullOnboardInfoRequest r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.mchat_id);
            OnboardType r102 = r101.monboard_type;
            if (r102 == null) goto L5;
            OnboardType.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Integer r103 = r101.mversion;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.mneed_sample_answer;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            Integer r105 = r101.mcount;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullOnboardInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullOnboardInfoRequest();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_VERSION = 0;
        DEFAULT_NEED_SAMPLE_ANSWER = Boolean.FALSE;
        DEFAULT_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.monboard_type = this.monboard_type;
        r100.mversion = this.mversion;
        r100.mneed_sample_answer = this.mneed_sample_answer;
        r100.mcount = this.mcount;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullOnboardInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullOnboardInfoRequest(Long r100, OnboardType r101, Integer r110, Boolean r111, Integer r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PullOnboardInfoRequest(Long r100, OnboardType r101, Integer r102, Boolean r103, Integer r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mchat_id = r100;
        this.monboard_type = r101;
        this.mversion = r102;
        this.mneed_sample_answer = r103;
        this.mcount = r104;
    }
}
