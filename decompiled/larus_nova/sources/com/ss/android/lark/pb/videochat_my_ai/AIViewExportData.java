package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class AIViewExportData extends Message<AIViewExportData, Builder> {
    public static final ProtoAdapter<AIViewExportData> ADAPTER = null;
    public static final String DEFAULT_EXPORT_TASK_ID = "";
    public static final String DEFAULT_EXPORT_URL = "";
    private static final long serialVersionUID = 0;
    public final ExportStatus mexport_status;
    public final String mexport_task_id;
    public final String mexport_url;

    public static final class Builder extends Message.Builder<AIViewExportData, Builder> {
        public ExportStatus mexport_status;
        public String mexport_task_id;
        public String mexport_url;

        @Override // com.squareup.wire.Message.Builder
        public AIViewExportData build() {
            return new AIViewExportData(this.mexport_task_id, this.mexport_url, this.mexport_status, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder export_status(ExportStatus r100) {
            this.mexport_status = r100;
            return this;
        }

        public Builder export_task_id(String r100) {
            this.mexport_task_id = r100;
            return this;
        }

        public Builder export_url(String r100) {
            this.mexport_url = r100;
            return this;
        }
    }

    public static final enum ExportStatus extends Enum<ExportStatus> implements WireEnum {
        private static final /* synthetic */ ExportStatus[] $VALUES = null;
        public static final ProtoAdapter<ExportStatus> ADAPTER = null;
        public static final ExportStatus FAIL = null;
        public static final ExportStatus SUCCESS = null;
        public static final ExportStatus UNKNOWN = null;
        private final int value;

        static {
            ExportStatus r100 = new ExportStatus("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ExportStatus r101 = new ExportStatus("SUCCESS", 1, 1);
            SUCCESS = r101;
            ExportStatus r102 = new ExportStatus("FAIL", 2, 2);
            FAIL = r102;
            $VALUES = new ExportStatus[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ExportStatus.class);
        }

        public static ExportStatus[] values() {
            return (ExportStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ExportStatus fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return FAIL;
        L12:
            return SUCCESS;
        L14:
            return UNKNOWN;
        }

        public static ExportStatus valueOf(String r100) {
            return (ExportStatus) a.a(ExportStatus.class, r100);
        }

        private ExportStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_AIViewExportData extends ProtoAdapter<AIViewExportData> {
        public ProtoAdapter_AIViewExportData() {
            super(FieldEncoding.LENGTH_DELIMITED, AIViewExportData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AIViewExportData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mexport_task_id = "";
            r101.mexport_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mexport_task_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mexport_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mexport_status = ExportStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AIViewExportData r100) {
            String r101 = r100.mexport_task_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mexport_url;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ExportStatus r107 = r100.mexport_status;
            if (r107 == null) goto L14;
            r102 = ExportStatus.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ AIViewExportData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AIViewExportData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AIViewExportData r101) throws IOException {
            String r102 = r101.mexport_task_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mexport_url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ExportStatus r104 = r101.mexport_status;
            if (r104 == null) goto L11;
            ExportStatus.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AIViewExportData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIViewExportData();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mexport_task_id = this.mexport_task_id;
        r100.mexport_url = this.mexport_url;
        r100.mexport_status = this.mexport_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AIViewExportData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AIViewExportData(String r100, String r101, ExportStatus r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public AIViewExportData(String r100, String r101, ExportStatus r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mexport_task_id = r100;
        this.mexport_url = r101;
        this.mexport_status = r102;
    }
}
