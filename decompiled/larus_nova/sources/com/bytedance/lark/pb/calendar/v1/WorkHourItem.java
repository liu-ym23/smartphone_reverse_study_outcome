package com.bytedance.lark.pb.calendar.v1;

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
public final class WorkHourItem extends Message<WorkHourItem, Builder> {
    public static final ProtoAdapter<WorkHourItem> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<WorkHourSpan> spans;

    public static final class Builder extends Message.Builder<WorkHourItem, Builder> {
        public List<WorkHourSpan> spans;

        @Override // com.squareup.wire.Message.Builder
        public WorkHourItem build() {
            return new WorkHourItem(this.spans, super.buildUnknownFields());
        }

        public Builder() {
            this.spans = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder spans(List<WorkHourSpan> r100) {
            Internal.checkElementsNotNull(r100);
            this.spans = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WorkHourItem extends ProtoAdapter<WorkHourItem> {
        public ProtoAdapter_WorkHourItem() {
            super(FieldEncoding.LENGTH_DELIMITED, WorkHourItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WorkHourItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.spans.add(WorkHourSpan.ADAPTER.decode(r100));
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
        public int encodedSize2(WorkHourItem r100) {
            return WorkHourSpan.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.spans) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WorkHourItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WorkHourItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WorkHourItem r101) throws IOException {
            WorkHourSpan.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.spans);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WorkHourItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WorkHourItem();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.spans = Internal.copyOf("spans", this.spans);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WorkHourItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WorkHourItem(List<WorkHourSpan> r100) {
        this(r100, ByteString.EMPTY);
    }

    public WorkHourItem(List<WorkHourSpan> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.spans = Internal.immutableCopyOf("spans", r100);
    }
}
