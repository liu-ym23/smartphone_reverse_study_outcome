package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Entity;
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
public final class GetRepliesResponse extends Message<GetRepliesResponse, Builder> {
    public static final ProtoAdapter<GetRepliesResponse> ADAPTER = null;
    public static final String DEFAULT_ROOT_ID = "";
    public static final ProtoAdapter_GetRepliesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> child_ids;
    public final List<String> child_quasi_ids;
    public final Entity entity;
    public final String root_id;

    public static final class Builder extends Message.Builder<GetRepliesResponse, Builder> implements d<GetRepliesResponse> {
        public List<String> child_ids;
        public List<String> child_quasi_ids;
        public Entity entity;
        public String root_id;

        @Override // com.squareup.wire.Message.Builder
        public GetRepliesResponse build() {
            String r100 = this.root_id;
            if (r100 == null) goto L9;
            if (this.entity == null) goto L9;
            return new GetRepliesResponse(this.root_id, this.child_ids, this.entity, this.child_quasi_ids, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "root_id", this.entity, "entity"});
        }

        public Builder() {
            this.child_ids = Internal.newMutableList();
            this.child_quasi_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder child_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.child_ids = r100;
            return this;
        }

        public Builder child_quasi_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.child_quasi_ids = r100;
            return this;
        }

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }

        public Builder root_id(String r100) {
            this.root_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetRepliesResponse extends ProtoAdapter<GetRepliesResponse> implements c<GetRepliesResponse> {
        public ProtoAdapter_GetRepliesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetRepliesResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetRepliesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.root_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.root_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.child_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.entity = Entity.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.child_quasi_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GetRepliesResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.root_id) + r101.asRepeated().encodedSizeWithTag(2, r100.child_ids)) + Entity.ADAPTER.encodedSizeWithTag(3, r100.entity)) + r101.asRepeated().encodedSizeWithTag(4, r100.child_quasi_ids)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetRepliesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetRepliesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetRepliesResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.root_id);
            r102.asRepeated().encodeWithTag(r100, 2, r101.child_ids);
            Entity.ADAPTER.encodeWithTag(r100, 3, r101.entity);
            r102.asRepeated().encodeWithTag(r100, 4, r101.child_quasi_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetRepliesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetRepliesResponse r100 = new ProtoAdapter_GetRepliesResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.root_id = this.root_id;
        r100.child_ids = Internal.copyOf("child_ids", this.child_ids);
        r100.entity = this.entity;
        r100.child_quasi_ids = Internal.copyOf("child_quasi_ids", this.child_quasi_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetRepliesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetRepliesResponse(String r100, List<String> r101, Entity r102, List<String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetRepliesResponse(String r100, List<String> r101, Entity r102, List<String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.root_id = r100;
        this.child_ids = Internal.immutableCopyOf("child_ids", r101);
        this.entity = r102;
        this.child_quasi_ids = Internal.immutableCopyOf("child_quasi_ids", r103);
    }
}
