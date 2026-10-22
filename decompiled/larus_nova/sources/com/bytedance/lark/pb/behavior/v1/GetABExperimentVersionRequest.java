package com.bytedance.lark.pb.behavior.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetABExperimentVersionRequest extends Message<GetABExperimentVersionRequest, Builder> {
    public static final ProtoAdapter<GetABExperimentVersionRequest> ADAPTER = null;
    public static final Boolean DEFAULT_NEED_ALL_TEA_EVENT_KEY_MAP = null;
    public static final Boolean DEFAULT_NEED_FEATURE_MAP = null;
    public static final ProtoAdapter_GetABExperimentVersionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean need_all_tea_event_key_map;
    public final Boolean need_feature_map;
    public final List<String> tea_event_key_vec;

    public static final class Builder extends Message.Builder<GetABExperimentVersionRequest, Builder> implements d<GetABExperimentVersionRequest> {
        public Boolean need_all_tea_event_key_map;
        public Boolean need_feature_map;
        public List<String> tea_event_key_vec;

        @Override // com.squareup.wire.Message.Builder
        public GetABExperimentVersionRequest build() {
            return new GetABExperimentVersionRequest(this.tea_event_key_vec, this.need_feature_map, this.need_all_tea_event_key_map, super.buildUnknownFields());
        }

        public Builder() {
            this.tea_event_key_vec = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder need_all_tea_event_key_map(Boolean r100) {
            this.need_all_tea_event_key_map = r100;
            return this;
        }

        public Builder need_feature_map(Boolean r100) {
            this.need_feature_map = r100;
            return this;
        }

        public Builder tea_event_key_vec(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.tea_event_key_vec = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetABExperimentVersionRequest extends ProtoAdapter<GetABExperimentVersionRequest> implements c<GetABExperimentVersionRequest> {
        public ProtoAdapter_GetABExperimentVersionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetABExperimentVersionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetABExperimentVersionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.need_feature_map = r102;
            r101.need_all_tea_event_key_map = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.tea_event_key_vec.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.need_feature_map = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.need_all_tea_event_key_map = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetABExperimentVersionRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.tea_event_key_vec);
            Boolean r102 = r100.need_feature_map;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.need_all_tea_event_key_map;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetABExperimentVersionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetABExperimentVersionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetABExperimentVersionRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.tea_event_key_vec);
            Boolean r102 = r101.need_feature_map;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.need_all_tea_event_key_map;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetABExperimentVersionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetABExperimentVersionRequest r100 = new ProtoAdapter_GetABExperimentVersionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_NEED_FEATURE_MAP = r101;
        DEFAULT_NEED_ALL_TEA_EVENT_KEY_MAP = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tea_event_key_vec = Internal.copyOf("tea_event_key_vec", this.tea_event_key_vec);
        r100.need_feature_map = this.need_feature_map;
        r100.need_all_tea_event_key_map = this.need_all_tea_event_key_map;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetABExperimentVersionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetABExperimentVersionRequest(List<String> r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetABExperimentVersionRequest(List<String> r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.tea_event_key_vec = Internal.immutableCopyOf("tea_event_key_vec", r100);
        this.need_feature_map = r101;
        this.need_all_tea_event_key_map = r102;
    }
}
