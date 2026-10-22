package com.bytedance.lark.pb.basic.v1;

import com.obric.miniapp.alarm.AccountType;
import com.optimize.statistics.FrescoMonitorConst;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class LogPathWithType extends com.squareup.wire.Message<LogPathWithType, Builder> {
    public static final ProtoAdapter<LogPathWithType> ADAPTER = null;
    public static final LogOrigin DEFAULT_LOG_ORIGIN = null;
    public static final String DEFAULT_LOG_PATH = "";
    public static final LogType DEFAULT_LOG_TYPE = null;
    private static final long serialVersionUID = 0;
    public final LogOrigin log_origin;
    public final String log_path;
    public final LogType log_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<LogPathWithType, Builder> {
        public LogOrigin log_origin;
        public String log_path;
        public LogType log_type;

        @Override // com.squareup.wire.Message.Builder
        public LogPathWithType build() {
            String r100 = this.log_path;
            if (r100 == null) goto L9;
            if (this.log_type == null) goto L9;
            return new LogPathWithType(this.log_path, this.log_type, this.log_origin, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "log_path", this.log_type, FrescoMonitorConst.LOG_TYPE});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder log_origin(LogOrigin r100) {
            this.log_origin = r100;
            return this;
        }

        public Builder log_path(String r100) {
            this.log_path = r100;
            return this;
        }

        public Builder log_type(LogType r100) {
            this.log_type = r100;
            return this;
        }
    }

    public static final enum LogOrigin extends Enum<LogOrigin> implements WireEnum {
        private static final /* synthetic */ LogOrigin[] $VALUES = null;
        public static final ProtoAdapter<LogOrigin> ADAPTER = null;
        public static final LogOrigin DOCS = null;
        public static final LogOrigin MAIN = null;
        public static final LogOrigin MINIAPP = null;
        private final int value;

        static {
            LogOrigin r100 = new LogOrigin(AccountType.MAIN, 0, 1);
            MAIN = r100;
            LogOrigin r101 = new LogOrigin("DOCS", 1, 2);
            DOCS = r101;
            LogOrigin r102 = new LogOrigin("MINIAPP", 2, 3);
            MINIAPP = r102;
            $VALUES = new LogOrigin[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(LogOrigin.class);
        }

        public static LogOrigin[] values() {
            return (LogOrigin[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static LogOrigin fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return MINIAPP;
        L13:
            return DOCS;
        L15:
            return MAIN;
        }

        public static LogOrigin valueOf(String r100) {
            return (LogOrigin) a.a(LogOrigin.class, r100);
        }

        private LogOrigin(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum LogType extends Enum<LogType> implements WireEnum {
        private static final /* synthetic */ LogType[] $VALUES = null;
        public static final ProtoAdapter<LogType> ADAPTER = null;
        public static final LogType METRIC = null;
        public static final LogType XLOG = null;
        private final int value;

        static {
            LogType r100 = new LogType("XLOG", 0, 1);
            XLOG = r100;
            LogType r101 = new LogType("METRIC", 1, 2);
            METRIC = r101;
            $VALUES = new LogType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(LogType.class);
        }

        public static LogType[] values() {
            return (LogType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static LogType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return METRIC;
        L11:
            return XLOG;
        }

        public static LogType valueOf(String r100) {
            return (LogType) a.a(LogType.class, r100);
        }

        private LogType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_LogPathWithType extends ProtoAdapter<LogPathWithType> {
        public ProtoAdapter_LogPathWithType() {
            super(FieldEncoding.LENGTH_DELIMITED, LogPathWithType.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LogPathWithType decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.log_path = "";
            r101.log_type = LogType.XLOG;
            r101.log_origin = LogOrigin.MAIN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.log_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.log_type = LogType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.log_origin = LogOrigin.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LogPathWithType r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.log_path) + LogType.ADAPTER.encodedSizeWithTag(2, r100.log_type);
            LogOrigin r102 = r100.log_origin;
            if (r102 == null) goto L5;
            int r103 = LogOrigin.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LogPathWithType decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LogPathWithType r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LogPathWithType r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.log_path);
            LogType.ADAPTER.encodeWithTag(r100, 2, r101.log_type);
            LogOrigin r102 = r101.log_origin;
            if (r102 == null) goto L5;
            LogOrigin.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LogPathWithType r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LogPathWithType();
        DEFAULT_LOG_TYPE = LogType.XLOG;
        DEFAULT_LOG_ORIGIN = LogOrigin.MAIN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.log_path = this.log_path;
        r100.log_type = this.log_type;
        r100.log_origin = this.log_origin;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LogPathWithType.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public LogPathWithType(String r100, LogType r101, LogOrigin r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public LogPathWithType(String r100, LogType r101, LogOrigin r102, ByteString r103) {
        super(ADAPTER, r103);
        this.log_path = r100;
        this.log_type = r101;
        this.log_origin = r102;
    }
}
