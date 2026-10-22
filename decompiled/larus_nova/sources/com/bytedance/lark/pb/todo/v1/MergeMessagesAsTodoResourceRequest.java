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
public final class MergeMessagesAsTodoResourceRequest extends Message<MergeMessagesAsTodoResourceRequest, Builder> {
    public static final ProtoAdapter<MergeMessagesAsTodoResourceRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Boolean DEFAULT_SHOULD_MERGE = null;
    public static final ProtoAdapter_MergeMessagesAsTodoResourceRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final List<String> msg_ids;
    public final Boolean should_merge;

    public static final class Builder extends Message.Builder<MergeMessagesAsTodoResourceRequest, Builder> implements d<MergeMessagesAsTodoResourceRequest> {
        public String chat_id;
        public List<String> msg_ids;
        public Boolean should_merge;

        @Override // com.squareup.wire.Message.Builder
        public MergeMessagesAsTodoResourceRequest build() {
            return new MergeMessagesAsTodoResourceRequest(this.msg_ids, this.chat_id, this.should_merge, super.buildUnknownFields());
        }

        public Builder() {
            this.msg_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder msg_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.msg_ids = r100;
            return this;
        }

        public Builder should_merge(Boolean r100) {
            this.should_merge = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MergeMessagesAsTodoResourceRequest extends ProtoAdapter<MergeMessagesAsTodoResourceRequest> implements c<MergeMessagesAsTodoResourceRequest> {
        public ProtoAdapter_MergeMessagesAsTodoResourceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MergeMessagesAsTodoResourceRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MergeMessagesAsTodoResourceRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.should_merge = Boolean.TRUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.msg_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.should_merge = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(MergeMessagesAsTodoResourceRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.msg_ids);
            String r103 = r100.chat_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.should_merge;
            if (r107 == null) goto L10;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MergeMessagesAsTodoResourceRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MergeMessagesAsTodoResourceRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MergeMessagesAsTodoResourceRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.msg_ids);
            String r103 = r101.chat_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Boolean r104 = r101.should_merge;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MergeMessagesAsTodoResourceRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MergeMessagesAsTodoResourceRequest r100 = new ProtoAdapter_MergeMessagesAsTodoResourceRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SHOULD_MERGE = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msg_ids = Internal.copyOf("msg_ids", this.msg_ids);
        r100.chat_id = this.chat_id;
        r100.should_merge = this.should_merge;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MergeMessagesAsTodoResourceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MergeMessagesAsTodoResourceRequest(List<String> r100, String r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MergeMessagesAsTodoResourceRequest(List<String> r100, String r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.msg_ids = Internal.immutableCopyOf("msg_ids", r100);
        this.chat_id = r101;
        this.should_merge = r102;
    }
}
