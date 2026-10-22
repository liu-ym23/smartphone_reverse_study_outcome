package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001b\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DraftAttachment;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/DraftAttachment$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/DraftAttachment$Builder;Lokio/ByteString;)V", "file", "Lcom/lark/kmp/pb/basic/v1/File;", "getFile", "()Lcom/lark/kmp/pb/basic/v1/File;", "status", "Lcom/lark/kmp/pb/basic/v1/DraftAttachment$UploadStatus;", "getStatus", "()Lcom/lark/kmp/pb/basic/v1/DraftAttachment$UploadStatus;", "progress", "", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "error_reason", "", "getError_reason", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "UploadStatus", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DraftAttachment extends com.lark.wire.Message<DraftAttachment, a> {
    public static final ProtoAdapter<DraftAttachment> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String error_reason;
    private final File file;
    private final Integer progress;
    private final UploadStatus status;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DraftAttachment$UploadStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "UPLOADING", "COMPLETE", "FAILED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum UploadStatus extends Enum<UploadStatus> implements o0 {
        public static final ProtoAdapter<UploadStatus> ADAPTER = null;
        public static final UploadStatus COMPLETE = null;
        public static final b Companion = null;
        public static final UploadStatus FAILED = null;
        public static final UploadStatus UNKNOWN = null;
        public static final UploadStatus UPLOADING = null;
        public static final /* synthetic */ UploadStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<UploadStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                UploadStatus.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return UploadStatus.FAILED;
            L18:
                return UploadStatus.COMPLETE;
            L19:
                return UploadStatus.UPLOADING;
            L15:
                return UploadStatus.UNKNOWN;
            }

            public a(KClass<UploadStatus> r1, Syntax r2, UploadStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<UploadStatus> getEntries() {
            return b;
        }

        static {
            UploadStatus r0 = new UploadStatus("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            UploadStatus r1 = new UploadStatus("UPLOADING", 1, 1);
            UPLOADING = r1;
            UploadStatus r3 = new UploadStatus("COMPLETE", 2, 2);
            COMPLETE = r3;
            UploadStatus r5 = new UploadStatus("FAILED", 3, 3);
            FAILED = r5;
            UploadStatus[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(UploadStatus.class), Syntax.PROTO_2, r0);
        }

        public static UploadStatus[] values() {
            return (UploadStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final UploadStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return FAILED;
        L18:
            return COMPLETE;
        L19:
            return UPLOADING;
        L15:
            return UNKNOWN;
        }

        public static UploadStatus valueOf(String r1) {
            return (UploadStatus) r27.a.a(UploadStatus.class, r1);
        }

        public UploadStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<DraftAttachment, a> {
        public File d;
        public UploadStatus e;
        public Integer f;
        public String g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new DraftAttachment(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<DraftAttachment> {
        @Override // com.lark.wire.ProtoAdapter
        public final DraftAttachment c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L22;
            if (r4 != 1) goto L8;
            r1.d = File.ADAPTER.c(r10);
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = UploadStatus.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L12:
            if (r4 != 4) goto L13;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.g = r10.i();
            goto L3
        L13:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L22:
            return new DraftAttachment(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(DraftAttachment r5) {
            DraftAttachment r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (((r6.unknownFields().size() + File.ADAPTER.l(1, r6.getFile())) + UploadStatus.ADAPTER.l(2, r6.getStatus())) + ProtoAdapter.h.l(3, r6.getProgress())) + ProtoAdapter.q.l(4, r6.getError_reason());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, DraftAttachment r5) {
            DraftAttachment r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            File.ADAPTER.i(r4, 1, r6.getFile());
            UploadStatus.ADAPTER.i(r4, 2, r6.getStatus());
            ProtoAdapter.h.i(r4, 3, r6.getProgress());
            ProtoAdapter.q.i(r4, 4, r6.getError_reason());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, DraftAttachment r5) {
            DraftAttachment r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.q.j(r4, 4, r6.getError_reason());
            ProtoAdapter.h.j(r4, 3, r6.getProgress());
            UploadStatus.ADAPTER.j(r4, 2, r6.getStatus());
            File.ADAPTER.j(r4, 1, r6.getFile());
        }

        public b(FieldEncoding r7, KClass<DraftAttachment> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.DraftAttachment", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ DraftAttachment(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DraftAttachment.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.file;
        r0.e = this.status;
        r0.f = this.progress;
        r0.g = this.error_reason;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(DraftAttachment.class).getSimpleName() + '@' + hashCode();
    }

    public final String getError_reason() {
        return this.error_reason;
    }

    public final File getFile() {
        return this.file;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final UploadStatus getStatus() {
        return this.status;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public DraftAttachment(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.file = r2.d;
        this.status = r2.e;
        this.progress = r2.f;
        this.error_reason = r2.g;
    }

    public /* synthetic */ DraftAttachment(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
