package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SegmentIndex extends Message<SegmentIndex, Builder> {
    public static final ProtoAdapter<SegmentIndex> ADAPTER = null;
    public static final Long DEFAULT_SEGMENT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long msegment_id;
    public final List<Long> msource_indexs;
    public final List<Long> mtarget_indexs;

    public static final class Builder extends Message.Builder<SegmentIndex, Builder> {
        public Long msegment_id;
        public List<Long> msource_indexs;
        public List<Long> mtarget_indexs;

        @Override // com.squareup.wire.Message.Builder
        public SegmentIndex build() {
            return new SegmentIndex(this.msegment_id, this.msource_indexs, this.mtarget_indexs, super.buildUnknownFields());
        }

        public Builder() {
            this.msource_indexs = Internal.newMutableList();
            this.mtarget_indexs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder segment_id(Long r100) {
            this.msegment_id = r100;
            return this;
        }

        public Builder source_indexs(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.msource_indexs = r100;
            return this;
        }

        public Builder target_indexs(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtarget_indexs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SegmentIndex extends ProtoAdapter<SegmentIndex> {
        public ProtoAdapter_SegmentIndex() {
            super(FieldEncoding.LENGTH_DELIMITED, SegmentIndex.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SegmentIndex decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msegment_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.msegment_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.msource_indexs.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mtarget_indexs.add(ProtoAdapter.INT64.decode(r100));
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
        public int encodedSize2(SegmentIndex r100) {
            Long r101 = r100.msegment_id;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            return ((r102 + r103.asRepeated().encodedSizeWithTag(2, r100.msource_indexs)) + r103.asRepeated().encodedSizeWithTag(3, r100.mtarget_indexs)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SegmentIndex decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SegmentIndex r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SegmentIndex r101) throws IOException {
            Long r102 = r101.msegment_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            r103.asRepeated().encodeWithTag(r100, 2, r101.msource_indexs);
            r103.asRepeated().encodeWithTag(r100, 3, r101.mtarget_indexs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SegmentIndex r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SegmentIndex();
        DEFAULT_SEGMENT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msegment_id = this.msegment_id;
        r100.msource_indexs = Internal.copyOf("msource_indexs", this.msource_indexs);
        r100.mtarget_indexs = Internal.copyOf("mtarget_indexs", this.mtarget_indexs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SegmentIndex.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SegmentIndex(Long r100, List<Long> r101, List<Long> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SegmentIndex(Long r100, List<Long> r101, List<Long> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.msegment_id = r100;
        this.msource_indexs = Internal.immutableCopyOf("msource_indexs", r101);
        this.mtarget_indexs = Internal.immutableCopyOf("mtarget_indexs", r102);
    }
}
