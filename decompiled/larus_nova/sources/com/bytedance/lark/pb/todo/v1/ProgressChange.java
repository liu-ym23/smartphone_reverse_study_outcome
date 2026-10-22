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
public final class ProgressChange extends Message<ProgressChange, Builder> {
    public static final ProtoAdapter<ProgressChange> ADAPTER = null;
    public static final String DEFAULT_GUID = "";
    private static final long serialVersionUID = 0;
    public final String guid;
    public final Map<String, Long> guid_to_position;
    public final Progress progress;

    public static final class Builder extends Message.Builder<ProgressChange, Builder> {
        public String guid;
        public Map<String, Long> guid_to_position;
        public Progress progress;

        @Override // com.squareup.wire.Message.Builder
        public ProgressChange build() {
            return new ProgressChange(this.guid, this.progress, this.guid_to_position, super.buildUnknownFields());
        }

        public Builder() {
            this.guid_to_position = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder guid_to_position(Map<String, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.guid_to_position = r100;
            return this;
        }

        public Builder progress(Progress r100) {
            this.progress = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ProgressChange extends ProtoAdapter<ProgressChange> {
        private final ProtoAdapter<Map<String, Long>> guid_to_position;

        public ProtoAdapter_ProgressChange() {
            super(FieldEncoding.LENGTH_DELIMITED, ProgressChange.class);
            this.guid_to_position = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.INT64);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ProgressChange decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.progress = Progress.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.guid_to_position.putAll(this.guid_to_position.decode(r100));
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
        public int encodedSize2(ProgressChange r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Progress r104 = r100.progress;
            if (r104 == null) goto L10;
            r102 = Progress.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + this.guid_to_position.encodedSizeWithTag(3, r100.guid_to_position)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ProgressChange decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ProgressChange r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ProgressChange r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Progress r103 = r101.progress;
            if (r103 == null) goto L8;
            Progress.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            this.guid_to_position.encodeWithTag(r100, 3, r101.guid_to_position);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ProgressChange r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ProgressChange();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.progress = this.progress;
        r100.guid_to_position = Internal.copyOf("guid_to_position", this.guid_to_position);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ProgressChange.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ProgressChange(String r100, Progress r101, Map<String, Long> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ProgressChange(String r100, Progress r101, Map<String, Long> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.guid = r100;
        this.progress = r101;
        this.guid_to_position = Internal.immutableCopyOf("guid_to_position", r102);
    }
}
