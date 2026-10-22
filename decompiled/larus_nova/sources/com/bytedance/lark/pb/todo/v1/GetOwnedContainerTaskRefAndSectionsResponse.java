package com.bytedance.lark.pb.todo.v1;

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
public final class GetOwnedContainerTaskRefAndSectionsResponse extends Message<GetOwnedContainerTaskRefAndSectionsResponse, Builder> {
    public static final ProtoAdapter<GetOwnedContainerTaskRefAndSectionsResponse> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_GUID = "";
    public static final ProtoAdapter_GetOwnedContainerTaskRefAndSectionsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String container_guid;
    public final TaskContainerRef ref;
    public final List<TaskSection> sections;

    public static final class Builder extends Message.Builder<GetOwnedContainerTaskRefAndSectionsResponse, Builder> implements d<GetOwnedContainerTaskRefAndSectionsResponse> {
        public String container_guid;
        public TaskContainerRef ref;
        public List<TaskSection> sections;

        @Override // com.squareup.wire.Message.Builder
        public GetOwnedContainerTaskRefAndSectionsResponse build() {
            return new GetOwnedContainerTaskRefAndSectionsResponse(this.ref, this.container_guid, this.sections, super.buildUnknownFields());
        }

        public Builder() {
            this.sections = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_guid(String r100) {
            this.container_guid = r100;
            return this;
        }

        public Builder ref(TaskContainerRef r100) {
            this.ref = r100;
            return this;
        }

        public Builder sections(List<TaskSection> r100) {
            Internal.checkElementsNotNull(r100);
            this.sections = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetOwnedContainerTaskRefAndSectionsResponse extends ProtoAdapter<GetOwnedContainerTaskRefAndSectionsResponse> implements c<GetOwnedContainerTaskRefAndSectionsResponse> {
        public ProtoAdapter_GetOwnedContainerTaskRefAndSectionsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetOwnedContainerTaskRefAndSectionsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetOwnedContainerTaskRefAndSectionsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.ref = TaskContainerRef.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.container_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.sections.add(TaskSection.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetOwnedContainerTaskRefAndSectionsResponse r100) {
            TaskContainerRef r101 = r100.ref;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskContainerRef.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.container_guid;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + TaskSection.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.sections)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetOwnedContainerTaskRefAndSectionsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetOwnedContainerTaskRefAndSectionsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetOwnedContainerTaskRefAndSectionsResponse r101) throws IOException {
            TaskContainerRef r102 = r101.ref;
            if (r102 == null) goto L5;
            TaskContainerRef.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.container_guid;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            TaskSection.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.sections);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetOwnedContainerTaskRefAndSectionsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetOwnedContainerTaskRefAndSectionsResponse r100 = new ProtoAdapter_GetOwnedContainerTaskRefAndSectionsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ref = this.ref;
        r100.container_guid = this.container_guid;
        r100.sections = Internal.copyOf("sections", this.sections);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetOwnedContainerTaskRefAndSectionsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetOwnedContainerTaskRefAndSectionsResponse(TaskContainerRef r100, String r101, List<TaskSection> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetOwnedContainerTaskRefAndSectionsResponse(TaskContainerRef r100, String r101, List<TaskSection> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.ref = r100;
        this.container_guid = r101;
        this.sections = Internal.immutableCopyOf("sections", r102);
    }
}
