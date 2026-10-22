package com.bytedance.lark.pb.todo.v1;

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

/* JADX INFO: loaded from: classes20.dex */
public final class GetServerTaskRefAndSectionsResponse extends Message<GetServerTaskRefAndSectionsResponse, Builder> {
    public static final ProtoAdapter<GetServerTaskRefAndSectionsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetServerTaskRefAndSectionsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, TaskSectionsAndRefsResult> results;

    public static final class Builder extends Message.Builder<GetServerTaskRefAndSectionsResponse, Builder> implements d<GetServerTaskRefAndSectionsResponse> {
        public Map<String, TaskSectionsAndRefsResult> results;

        @Override // com.squareup.wire.Message.Builder
        public GetServerTaskRefAndSectionsResponse build() {
            return new GetServerTaskRefAndSectionsResponse(this.results, super.buildUnknownFields());
        }

        public Builder() {
            this.results = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder results(Map<String, TaskSectionsAndRefsResult> r100) {
            Internal.checkElementsNotNull(r100);
            this.results = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetServerTaskRefAndSectionsResponse extends ProtoAdapter<GetServerTaskRefAndSectionsResponse> implements c<GetServerTaskRefAndSectionsResponse> {
        private final ProtoAdapter<Map<String, TaskSectionsAndRefsResult>> results;

        public ProtoAdapter_GetServerTaskRefAndSectionsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetServerTaskRefAndSectionsResponse.class);
            this.results = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, TaskSectionsAndRefsResult.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetServerTaskRefAndSectionsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.results.putAll(this.results.decode(r100));
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
        public int encodedSize2(GetServerTaskRefAndSectionsResponse r100) {
            return this.results.encodedSizeWithTag(1, r100.results) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetServerTaskRefAndSectionsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetServerTaskRefAndSectionsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetServerTaskRefAndSectionsResponse r101) throws IOException {
            this.results.encodeWithTag(r100, 1, r101.results);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetServerTaskRefAndSectionsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class TaskSectionsAndRefsResult extends Message<TaskSectionsAndRefsResult, Builder> {
        public static final ProtoAdapter<TaskSectionsAndRefsResult> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final TaskContainerRef ref;
        public final List<TaskSection> sections;

        public static final class Builder extends Message.Builder<TaskSectionsAndRefsResult, Builder> {
            public TaskContainerRef ref;
            public List<TaskSection> sections;

            @Override // com.squareup.wire.Message.Builder
            public TaskSectionsAndRefsResult build() {
                return new TaskSectionsAndRefsResult(this.ref, this.sections, super.buildUnknownFields());
            }

            public Builder() {
                this.sections = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
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

        public static final class ProtoAdapter_TaskSectionsAndRefsResult extends ProtoAdapter<TaskSectionsAndRefsResult> {
            public ProtoAdapter_TaskSectionsAndRefsResult() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskSectionsAndRefsResult.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TaskSectionsAndRefsResult decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.ref = TaskContainerRef.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.sections.add(TaskSection.ADAPTER.decode(r100));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TaskSectionsAndRefsResult r100) {
                TaskContainerRef r101 = r100.ref;
                if (r101 == null) goto L5;
                int r102 = TaskContainerRef.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + TaskSection.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.sections)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TaskSectionsAndRefsResult decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TaskSectionsAndRefsResult r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TaskSectionsAndRefsResult r101) throws IOException {
                TaskContainerRef r102 = r101.ref;
                if (r102 == null) goto L5;
                TaskContainerRef.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                TaskSection.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.sections);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskSectionsAndRefsResult r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskSectionsAndRefsResult();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.ref = this.ref;
            r100.sections = Internal.copyOf("sections", this.sections);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TaskSectionsAndRefsResult.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TaskSectionsAndRefsResult(TaskContainerRef r100, List<TaskSection> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TaskSectionsAndRefsResult(TaskContainerRef r100, List<TaskSection> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.ref = r100;
            this.sections = Internal.immutableCopyOf("sections", r101);
        }
    }

    static {
        ProtoAdapter_GetServerTaskRefAndSectionsResponse r100 = new ProtoAdapter_GetServerTaskRefAndSectionsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.results = Internal.copyOf("results", this.results);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetServerTaskRefAndSectionsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetServerTaskRefAndSectionsResponse(Map<String, TaskSectionsAndRefsResult> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetServerTaskRefAndSectionsResponse(Map<String, TaskSectionsAndRefsResult> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.results = Internal.immutableCopyOf("results", r100);
    }
}
