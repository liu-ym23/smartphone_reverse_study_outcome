package com.bytedance.lark.pb.todo.v1;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AgentTaskContent extends Message<AgentTaskContent, Builder> {
    public static final ProtoAdapter<AgentTaskContent> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TodoAttachment> deliveries;
    public final List<AgentTaskStepInfo> steps;
    public final List<String> text_deliveries;

    public static final class AgentTaskStepInfo extends Message<AgentTaskStepInfo, Builder> {
        public static final ProtoAdapter<AgentTaskStepInfo> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_QUOTE = "";
        public static final Long DEFAULT_TIMESTAMP = null;
        private static final long serialVersionUID = 0;
        public final String content;
        public final AgentInfo operator;
        public final String quote;
        public final Long timestamp;

        public static final class Builder extends Message.Builder<AgentTaskStepInfo, Builder> {
            public String content;
            public AgentInfo operator;
            public String quote;
            public Long timestamp;

            @Override // com.squareup.wire.Message.Builder
            public AgentTaskStepInfo build() {
                AgentInfo r100 = this.operator;
                if (r100 == null) goto L11;
                if (this.timestamp == null) goto L11;
                if (this.content == null) goto L11;
                return new AgentTaskStepInfo(this.operator, this.timestamp, this.quote, this.content, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r100, OnekeyLoginConstants.CU_KEY_OPERATOR, this.timestamp, "timestamp", this.content, "content"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder operator(AgentInfo r100) {
                this.operator = r100;
                return this;
            }

            public Builder quote(String r100) {
                this.quote = r100;
                return this;
            }

            public Builder timestamp(Long r100) {
                this.timestamp = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AgentTaskStepInfo extends ProtoAdapter<AgentTaskStepInfo> {
            public ProtoAdapter_AgentTaskStepInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, AgentTaskStepInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AgentTaskStepInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.timestamp = 0L;
                r101.quote = "";
                r101.content = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.operator = AgentInfo.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.timestamp = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.quote = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.content = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(AgentTaskStepInfo r100) {
                int r101 = AgentInfo.ADAPTER.encodedSizeWithTag(1, r100.operator) + ProtoAdapter.INT64.encodedSizeWithTag(2, r100.timestamp);
                String r102 = r100.quote;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
            L7:
                return ((r101 + r103) + ProtoAdapter.STRING.encodedSizeWithTag(4, r100.content)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AgentTaskStepInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AgentTaskStepInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AgentTaskStepInfo r101) throws IOException {
                AgentInfo.ADAPTER.encodeWithTag(r100, 1, r101.operator);
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r101.timestamp);
                String r102 = r101.quote;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
            L5:
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r101.content);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AgentTaskStepInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AgentTaskStepInfo();
            DEFAULT_TIMESTAMP = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.operator = this.operator;
            r100.timestamp = this.timestamp;
            r100.quote = this.quote;
            r100.content = this.content;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AgentTaskStepInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AgentTaskStepInfo(AgentInfo r100, Long r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public AgentTaskStepInfo(AgentInfo r100, Long r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.operator = r100;
            this.timestamp = r101;
            this.quote = r102;
            this.content = r103;
        }
    }

    public static final class Builder extends Message.Builder<AgentTaskContent, Builder> {
        public List<TodoAttachment> deliveries;
        public List<AgentTaskStepInfo> steps;
        public List<String> text_deliveries;

        @Override // com.squareup.wire.Message.Builder
        public AgentTaskContent build() {
            return new AgentTaskContent(this.deliveries, this.steps, this.text_deliveries, super.buildUnknownFields());
        }

        public Builder() {
            this.deliveries = Internal.newMutableList();
            this.steps = Internal.newMutableList();
            this.text_deliveries = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder deliveries(List<TodoAttachment> r100) {
            Internal.checkElementsNotNull(r100);
            this.deliveries = r100;
            return this;
        }

        public Builder steps(List<AgentTaskStepInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.steps = r100;
            return this;
        }

        public Builder text_deliveries(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.text_deliveries = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AgentTaskContent extends ProtoAdapter<AgentTaskContent> {
        public ProtoAdapter_AgentTaskContent() {
            super(FieldEncoding.LENGTH_DELIMITED, AgentTaskContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AgentTaskContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.deliveries.add(TodoAttachment.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.steps.add(AgentTaskStepInfo.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.text_deliveries.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(AgentTaskContent r100) {
            return ((TodoAttachment.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.deliveries) + AgentTaskStepInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.steps)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r100.text_deliveries)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AgentTaskContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AgentTaskContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AgentTaskContent r101) throws IOException {
            TodoAttachment.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.deliveries);
            AgentTaskStepInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.steps);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 3, r101.text_deliveries);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AgentTaskContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AgentTaskContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.deliveries = Internal.copyOf("deliveries", this.deliveries);
        r100.steps = Internal.copyOf("steps", this.steps);
        r100.text_deliveries = Internal.copyOf("text_deliveries", this.text_deliveries);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AgentTaskContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AgentTaskContent(List<TodoAttachment> r100, List<AgentTaskStepInfo> r101, List<String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public AgentTaskContent(List<TodoAttachment> r100, List<AgentTaskStepInfo> r101, List<String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.deliveries = Internal.immutableCopyOf("deliveries", r100);
        this.steps = Internal.immutableCopyOf("steps", r101);
        this.text_deliveries = Internal.immutableCopyOf("text_deliveries", r102);
    }
}
