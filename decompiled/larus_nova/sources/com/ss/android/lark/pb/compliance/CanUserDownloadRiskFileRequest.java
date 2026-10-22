package com.ss.android.lark.pb.compliance;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class CanUserDownloadRiskFileRequest extends Message<CanUserDownloadRiskFileRequest, Builder> {
    public static final ProtoAdapter<CanUserDownloadRiskFileRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FileOperateUsage mop_usage;
    public final SourceTerminal msource_terminal;

    public static final class Builder extends Message.Builder<CanUserDownloadRiskFileRequest, Builder> {
        public FileOperateUsage mop_usage;
        public SourceTerminal msource_terminal;

        @Override // com.squareup.wire.Message.Builder
        public CanUserDownloadRiskFileRequest build() {
            FileOperateUsage r100 = this.mop_usage;
            if (r100 == null) goto L9;
            if (this.msource_terminal == null) goto L9;
            return new CanUserDownloadRiskFileRequest(this.mop_usage, this.msource_terminal, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mop_usage", this.msource_terminal, "msource_terminal"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder op_usage(FileOperateUsage r100) {
            this.mop_usage = r100;
            return this;
        }

        public Builder source_terminal(SourceTerminal r100) {
            this.msource_terminal = r100;
            return this;
        }
    }

    public static final enum FileOperateUsage extends Enum<FileOperateUsage> implements WireEnum {
        private static final /* synthetic */ FileOperateUsage[] $VALUES = null;
        public static final ProtoAdapter<FileOperateUsage> ADAPTER = null;
        public static final FileOperateUsage Download = null;
        public static final FileOperateUsage Preview = null;
        public static final FileOperateUsage TransCode = null;
        public static final FileOperateUsage Unspecified = null;
        private final int value;

        static {
            FileOperateUsage r100 = new FileOperateUsage("Unspecified", 0, 0);
            Unspecified = r100;
            FileOperateUsage r101 = new FileOperateUsage("Download", 1, 1);
            Download = r101;
            FileOperateUsage r102 = new FileOperateUsage("Preview", 2, 2);
            Preview = r102;
            FileOperateUsage r103 = new FileOperateUsage("TransCode", 3, 3);
            TransCode = r103;
            $VALUES = new FileOperateUsage[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(FileOperateUsage.class);
        }

        public static FileOperateUsage[] values() {
            return (FileOperateUsage[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FileOperateUsage fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return TransCode;
        L14:
            return Preview;
        L16:
            return Download;
        L18:
            return Unspecified;
        }

        public static FileOperateUsage valueOf(String r100) {
            return (FileOperateUsage) a.a(FileOperateUsage.class, r100);
        }

        private FileOperateUsage(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_CanUserDownloadRiskFileRequest extends ProtoAdapter<CanUserDownloadRiskFileRequest> {
        public ProtoAdapter_CanUserDownloadRiskFileRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CanUserDownloadRiskFileRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CanUserDownloadRiskFileRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mop_usage = FileOperateUsage.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.msource_terminal = SourceTerminal.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CanUserDownloadRiskFileRequest r100) {
            return (FileOperateUsage.ADAPTER.encodedSizeWithTag(1, r100.mop_usage) + SourceTerminal.ADAPTER.encodedSizeWithTag(2, r100.msource_terminal)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CanUserDownloadRiskFileRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CanUserDownloadRiskFileRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CanUserDownloadRiskFileRequest r101) throws IOException {
            FileOperateUsage.ADAPTER.encodeWithTag(r100, 1, r101.mop_usage);
            SourceTerminal.ADAPTER.encodeWithTag(r100, 2, r101.msource_terminal);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CanUserDownloadRiskFileRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SourceTerminal extends Enum<SourceTerminal> implements WireEnum {
        private static final /* synthetic */ SourceTerminal[] $VALUES = null;
        public static final ProtoAdapter<SourceTerminal> ADAPTER = null;
        public static final SourceTerminal Browser = null;
        public static final SourceTerminal Mobile = null;
        public static final SourceTerminal PC = null;
        public static final SourceTerminal Unknown = null;
        private final int value;

        static {
            SourceTerminal r100 = new SourceTerminal("Unknown", 0, 0);
            Unknown = r100;
            SourceTerminal r101 = new SourceTerminal("Browser", 1, 1);
            Browser = r101;
            SourceTerminal r102 = new SourceTerminal("PC", 2, 2);
            PC = r102;
            SourceTerminal r103 = new SourceTerminal("Mobile", 3, 3);
            Mobile = r103;
            $VALUES = new SourceTerminal[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(SourceTerminal.class);
        }

        public static SourceTerminal[] values() {
            return (SourceTerminal[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SourceTerminal fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return Mobile;
        L14:
            return PC;
        L16:
            return Browser;
        L18:
            return Unknown;
        }

        public static SourceTerminal valueOf(String r100) {
            return (SourceTerminal) a.a(SourceTerminal.class, r100);
        }

        private SourceTerminal(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CanUserDownloadRiskFileRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mop_usage = this.mop_usage;
        r100.msource_terminal = this.msource_terminal;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CanUserDownloadRiskFileRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CanUserDownloadRiskFileRequest(FileOperateUsage r100, SourceTerminal r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CanUserDownloadRiskFileRequest(FileOperateUsage r100, SourceTerminal r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mop_usage = r100;
        this.msource_terminal = r101;
    }
}
