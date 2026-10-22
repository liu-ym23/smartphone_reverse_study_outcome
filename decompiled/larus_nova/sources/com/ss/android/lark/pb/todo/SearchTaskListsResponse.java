package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.todo_entities.ContainerMetaData;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SearchTaskListsResponse extends Message<SearchTaskListsResponse, Builder> {
    public static final ProtoAdapter<SearchTaskListsResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ContainerMetaData> mmeta_data;

    public static final class Builder extends Message.Builder<SearchTaskListsResponse, Builder> {
        public List<ContainerMetaData> mmeta_data;

        @Override // com.squareup.wire.Message.Builder
        public SearchTaskListsResponse build() {
            return new SearchTaskListsResponse(this.mmeta_data, super.buildUnknownFields());
        }

        public Builder() {
            this.mmeta_data = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder meta_data(List<ContainerMetaData> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmeta_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchTaskListsResponse extends ProtoAdapter<SearchTaskListsResponse> {
        public ProtoAdapter_SearchTaskListsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchTaskListsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchTaskListsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mmeta_data.add(ContainerMetaData.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchTaskListsResponse r100) {
            return ContainerMetaData.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mmeta_data) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchTaskListsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchTaskListsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchTaskListsResponse r101) throws IOException {
            ContainerMetaData.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mmeta_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchTaskListsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchTaskListsResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeta_data = Internal.copyOf("mmeta_data", this.mmeta_data);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchTaskListsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchTaskListsResponse(List<ContainerMetaData> r100) {
        this(r100, ByteString.EMPTY);
    }

    public SearchTaskListsResponse(List<ContainerMetaData> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mmeta_data = Internal.immutableCopyOf("mmeta_data", r100);
    }
}
