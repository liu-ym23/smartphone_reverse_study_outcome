package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SimpleAgentTodo extends Message<SimpleAgentTodo, Builder> {
    public static final ProtoAdapter<SimpleAgentTodo> ADAPTER = null;
    public static final String DEFAULT_GUID = "";
    public static final String DEFAULT_SUMMARY = "";
    public static final String DEFAULT_TASK_PROGRESS = "";
    private static final long serialVersionUID = 0;
    public final String guid;
    public final String summary;
    public final String task_progress;

    public static final class Builder extends Message.Builder<SimpleAgentTodo, Builder> {
        public String guid;
        public String summary;
        public String task_progress;

        @Override // com.squareup.wire.Message.Builder
        public SimpleAgentTodo build() {
            return new SimpleAgentTodo(this.guid, this.summary, this.task_progress, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder summary(String r100) {
            this.summary = r100;
            return this;
        }

        public Builder task_progress(String r100) {
            this.task_progress = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SimpleAgentTodo extends ProtoAdapter<SimpleAgentTodo> {
        public ProtoAdapter_SimpleAgentTodo() {
            super(FieldEncoding.LENGTH_DELIMITED, SimpleAgentTodo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SimpleAgentTodo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.summary = "";
            r101.task_progress = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.summary = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.task_progress = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SimpleAgentTodo r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.summary;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.task_progress;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SimpleAgentTodo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SimpleAgentTodo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SimpleAgentTodo r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.summary;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.task_progress;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SimpleAgentTodo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SimpleAgentTodo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.summary = this.summary;
        r100.task_progress = this.task_progress;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SimpleAgentTodo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SimpleAgentTodo(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SimpleAgentTodo(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.guid = r100;
        this.summary = r101;
        this.task_progress = r102;
    }
}
