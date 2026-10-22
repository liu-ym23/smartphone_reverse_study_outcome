package security.v2;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class SubjectFactorResponse extends Message<SubjectFactorResponse, Builder> {
    public static final ProtoAdapter<SubjectFactorResponse> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_SubjectFactorResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, FactorVal> common_factors_map;
    public final List<UserDeptIdPath> user_dept_id_paths;
    public final List<String> user_dept_ids_with_parent;
    public final List<String> user_group_ids;

    public static final class Builder extends Message.Builder<SubjectFactorResponse, Builder> implements d<SubjectFactorResponse> {
        public Map<String, FactorVal> common_factors_map;
        public List<UserDeptIdPath> user_dept_id_paths;
        public List<String> user_dept_ids_with_parent;
        public List<String> user_group_ids;

        @Override // com.squareup.wire.Message.Builder
        public SubjectFactorResponse build() {
            return new SubjectFactorResponse(this.user_group_ids, this.user_dept_id_paths, this.user_dept_ids_with_parent, this.common_factors_map, super.buildUnknownFields());
        }

        public Builder() {
            this.user_group_ids = Internal.newMutableList();
            this.user_dept_id_paths = Internal.newMutableList();
            this.user_dept_ids_with_parent = Internal.newMutableList();
            this.common_factors_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder common_factors_map(Map<String, FactorVal> r100) {
            Internal.checkElementsNotNull(r100);
            this.common_factors_map = r100;
            return this;
        }

        public Builder user_dept_id_paths(List<UserDeptIdPath> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_dept_id_paths = r100;
            return this;
        }

        public Builder user_dept_ids_with_parent(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_dept_ids_with_parent = r100;
            return this;
        }

        public Builder user_group_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_group_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubjectFactorResponse extends ProtoAdapter<SubjectFactorResponse> implements c<SubjectFactorResponse> {
        private final ProtoAdapter<Map<String, FactorVal>> common_factors_map;

        public ProtoAdapter_SubjectFactorResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubjectFactorResponse.class);
            this.common_factors_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, FactorVal.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public SubjectFactorResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.user_group_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.user_dept_id_paths.add(UserDeptIdPath.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.user_dept_ids_with_parent.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.common_factors_map.putAll(this.common_factors_map.decode(r100));
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
        public int encodedSize2(SubjectFactorResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.asRepeated().encodedSizeWithTag(1, r100.user_group_ids) + UserDeptIdPath.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.user_dept_id_paths)) + r101.asRepeated().encodedSizeWithTag(3, r100.user_dept_ids_with_parent)) + this.common_factors_map.encodedSizeWithTag(4, r100.common_factors_map)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubjectFactorResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubjectFactorResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubjectFactorResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.user_group_ids);
            UserDeptIdPath.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.user_dept_id_paths);
            r102.asRepeated().encodeWithTag(r100, 3, r101.user_dept_ids_with_parent);
            this.common_factors_map.encodeWithTag(r100, 4, r101.common_factors_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubjectFactorResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SubjectFactorResponse r100 = new ProtoAdapter_SubjectFactorResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_group_ids = Internal.copyOf("user_group_ids", this.user_group_ids);
        r100.user_dept_id_paths = Internal.copyOf("user_dept_id_paths", this.user_dept_id_paths);
        r100.user_dept_ids_with_parent = Internal.copyOf("user_dept_ids_with_parent", this.user_dept_ids_with_parent);
        r100.common_factors_map = Internal.copyOf("common_factors_map", this.common_factors_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubjectFactorResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubjectFactorResponse(List<String> r100, List<UserDeptIdPath> r101, List<String> r102, Map<String, FactorVal> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SubjectFactorResponse(List<String> r100, List<UserDeptIdPath> r101, List<String> r102, Map<String, FactorVal> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.user_group_ids = Internal.immutableCopyOf("user_group_ids", r100);
        this.user_dept_id_paths = Internal.immutableCopyOf("user_dept_id_paths", r101);
        this.user_dept_ids_with_parent = Internal.immutableCopyOf("user_dept_ids_with_parent", r102);
        this.common_factors_map = Internal.immutableCopyOf("common_factors_map", r103);
    }
}
