package com.bytedance.lark.pb.calendar.v1;

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
public final class WorkHourSetting extends Message<WorkHourSetting, Builder> {
    public static final ProtoAdapter<WorkHourSetting> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE_WORK_HOUR = null;
    public static final Boolean DEFAULT_IS_FIRST_SET = null;
    private static final long serialVersionUID = 0;
    public final Boolean enable_work_hour;
    public final Boolean is_first_set;
    public final Map<String, WorkHourItem> work_hour_items;

    public static final class Builder extends Message.Builder<WorkHourSetting, Builder> {
        public Boolean enable_work_hour;
        public Boolean is_first_set;
        public Map<String, WorkHourItem> work_hour_items;

        @Override // com.squareup.wire.Message.Builder
        public WorkHourSetting build() {
            return new WorkHourSetting(this.enable_work_hour, this.work_hour_items, this.is_first_set, super.buildUnknownFields());
        }

        public Builder() {
            this.work_hour_items = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enable_work_hour(Boolean r100) {
            this.enable_work_hour = r100;
            return this;
        }

        public Builder is_first_set(Boolean r100) {
            this.is_first_set = r100;
            return this;
        }

        public Builder work_hour_items(Map<String, WorkHourItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.work_hour_items = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WorkHourSetting extends ProtoAdapter<WorkHourSetting> {
        private final ProtoAdapter<Map<String, WorkHourItem>> work_hour_items;

        public ProtoAdapter_WorkHourSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, WorkHourSetting.class);
            this.work_hour_items = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, WorkHourItem.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WorkHourSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.enable_work_hour = Boolean.FALSE;
            r101.is_first_set = Boolean.TRUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.enable_work_hour = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.work_hour_items.putAll(this.work_hour_items.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_first_set = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(WorkHourSetting r100) {
            Boolean r101 = r100.enable_work_hour;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + this.work_hour_items.encodedSizeWithTag(2, r100.work_hour_items);
            Boolean r105 = r100.is_first_set;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WorkHourSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WorkHourSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WorkHourSetting r101) throws IOException {
            Boolean r102 = r101.enable_work_hour;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            this.work_hour_items.encodeWithTag(r100, 2, r101.work_hour_items);
            Boolean r103 = r101.is_first_set;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WorkHourSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WorkHourSetting();
        DEFAULT_ENABLE_WORK_HOUR = Boolean.FALSE;
        DEFAULT_IS_FIRST_SET = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.enable_work_hour = this.enable_work_hour;
        r100.work_hour_items = Internal.copyOf("work_hour_items", this.work_hour_items);
        r100.is_first_set = this.is_first_set;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WorkHourSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WorkHourSetting(Boolean r100, Map<String, WorkHourItem> r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public WorkHourSetting(Boolean r100, Map<String, WorkHourItem> r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.enable_work_hour = r100;
        this.work_hour_items = Internal.immutableCopyOf("work_hour_items", r101);
        this.is_first_set = r102;
    }
}
