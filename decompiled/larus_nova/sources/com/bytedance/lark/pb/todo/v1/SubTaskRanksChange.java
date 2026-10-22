package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SubTaskRanksChange extends Message<SubTaskRanksChange, Builder> {
    public static final ProtoAdapter<SubTaskRanksChange> ADAPTER = null;
    public static final String DEFAULT_GUID = "";
    private static final long serialVersionUID = 0;
    public final String guid;
    public final Map<String, String> sub_task_ranks;

    public static final class Builder extends Message.Builder<SubTaskRanksChange, Builder> {
        public String guid;
        public Map<String, String> sub_task_ranks;

        @Override // com.squareup.wire.Message.Builder
        public SubTaskRanksChange build() {
            return new SubTaskRanksChange(this.guid, this.sub_task_ranks, super.buildUnknownFields());
        }

        public Builder() {
            this.sub_task_ranks = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder sub_task_ranks(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.sub_task_ranks = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubTaskRanksChange extends ProtoAdapter<SubTaskRanksChange> {
        private final ProtoAdapter<Map<String, String>> sub_task_ranks;

        public ProtoAdapter_SubTaskRanksChange() {
            super(FieldEncoding.LENGTH_DELIMITED, SubTaskRanksChange.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.sub_task_ranks = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubTaskRanksChange decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.sub_task_ranks.putAll(this.sub_task_ranks.decode(r100));
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
        public int encodedSize2(SubTaskRanksChange r100) {
            String r101 = r100.guid;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + this.sub_task_ranks.encodedSizeWithTag(2, r100.sub_task_ranks)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubTaskRanksChange decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubTaskRanksChange r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubTaskRanksChange r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            this.sub_task_ranks.encodeWithTag(r100, 2, r101.sub_task_ranks);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubTaskRanksChange r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubTaskRanksChange();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.sub_task_ranks = Internal.copyOf("sub_task_ranks", this.sub_task_ranks);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubTaskRanksChange.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubTaskRanksChange(String r100, Map<String, String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SubTaskRanksChange(String r100, Map<String, String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.guid = r100;
        this.sub_task_ranks = Internal.immutableCopyOf("sub_task_ranks", r101);
    }
}
