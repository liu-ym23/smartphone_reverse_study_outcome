package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003,-.B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010*\u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0018\u0010\u001aR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010&\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR\u0013\u0010(\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000b¨\u0006/"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttachment;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttachment$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttachment$Builder;Lokio/ByteString;)V", "file_token", "", "getFile_token", "()Ljava/lang/String;", "file_size", "getFile_size", "name", "getName", "type", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttachment$Type;", "getType", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttachment$Type;", "local_path", "getLocal_path", "uploader_user_id", "getUploader_user_id", "is_deleted", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "position", "", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "expire_time", "", "getExpire_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "google_drive_link", "getGoogle_drive_link", "url_link", "getUrl_link", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarEventAttachment extends Message<CalendarEventAttachment, a> {
    public static final ProtoAdapter<CalendarEventAttachment> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long expire_time;
    private final String file_size;
    private final String file_token;
    private final String google_drive_link;
    private final Boolean is_deleted;
    private final String local_path;
    private final String name;
    private final Integer position;
    private final Type type;
    private final String uploader_user_id;
    private final String url_link;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttachment$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "LOCAL", "LARGE_ATTACHMENT", "GOOGLE_DRIVE", "URL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type GOOGLE_DRIVE = null;
        public static final Type LARGE_ATTACHMENT = null;
        public static final Type LOCAL = null;
        public static final Type UNKNOWN = null;
        public static final Type URL = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 3) goto L21;
                if (r1 == 4) goto L20;
                if (r1 == 5) goto L19;
                return null;
            L19:
                return Type.URL;
            L20:
                return Type.GOOGLE_DRIVE;
            L21:
                return Type.LARGE_ATTACHMENT;
            L22:
                return Type.LOCAL;
            L17:
                return Type.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("LOCAL", 1, 1);
            LOCAL = r1;
            Type r3 = new Type("LARGE_ATTACHMENT", 2, 3);
            LARGE_ATTACHMENT = r3;
            Type r5 = new Type("GOOGLE_DRIVE", 3, 4);
            GOOGLE_DRIVE = r5;
            Type r8 = new Type("URL", 4, 5);
            URL = r8;
            Type[] r10 = {r0, r1, r3, r5, r8};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<CalendarEventAttachment, a> {
        public String d;
        public String e;
        public String f;
        public Type g;
        public String h;
        public String i;
        public Boolean j;
        public Integer k;
        public Long l;
        public String m;
        public String n;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarEventAttachment(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarEventAttachment> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarEventAttachment c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L22;
            switch(r4) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L23;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L23:
            r1.g = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L7:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.n = r10.i();
            goto L3
        L8:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.m = r10.i();
            goto L3
        L9:
            r1.l = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L10:
            r1.k = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L11:
            r1.j = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.i = r10.i();
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.h = r10.i();
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.f = r10.i();
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L20:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L6:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L22:
            return new CalendarEventAttachment(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarEventAttachment r6) {
            CalendarEventAttachment r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((((((((((r0 + r1.l(1, r7.getFile_token())) + r1.l(2, r7.getFile_size())) + r1.l(3, r7.getName())) + Type.ADAPTER.l(4, r7.getType())) + r1.l(5, r7.getLocal_path())) + r1.l(6, r7.getUploader_user_id())) + ProtoAdapter.g.l(7, r7.is_deleted())) + ProtoAdapter.h.l(8, r7.getPosition())) + ProtoAdapter.k.l(9, r7.getExpire_time())) + r1.l(10, r7.getGoogle_drive_link())) + r1.l(11, r7.getUrl_link());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, CalendarEventAttachment r6) {
            CalendarEventAttachment r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getFile_token());
            r0.i(r5, 2, r7.getFile_size());
            r0.i(r5, 3, r7.getName());
            Type.ADAPTER.i(r5, 4, r7.getType());
            r0.i(r5, 5, r7.getLocal_path());
            r0.i(r5, 6, r7.getUploader_user_id());
            ProtoAdapter.g.i(r5, 7, r7.is_deleted());
            ProtoAdapter.h.i(r5, 8, r7.getPosition());
            ProtoAdapter.k.i(r5, 9, r7.getExpire_time());
            r0.i(r5, 10, r7.getGoogle_drive_link());
            r0.i(r5, 11, r7.getUrl_link());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, CalendarEventAttachment r6) {
            CalendarEventAttachment r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 11, r7.getUrl_link());
            r0.j(r5, 10, r7.getGoogle_drive_link());
            ProtoAdapter.k.j(r5, 9, r7.getExpire_time());
            ProtoAdapter.h.j(r5, 8, r7.getPosition());
            ProtoAdapter.g.j(r5, 7, r7.is_deleted());
            r0.j(r5, 6, r7.getUploader_user_id());
            r0.j(r5, 5, r7.getLocal_path());
            Type.ADAPTER.j(r5, 4, r7.getType());
            r0.j(r5, 3, r7.getName());
            r0.j(r5, 2, r7.getFile_size());
            r0.j(r5, 1, r7.getFile_token());
        }

        public b(FieldEncoding r7, KClass<CalendarEventAttachment> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventAttachment", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarEventAttachment(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEventAttachment.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.file_token;
        r0.e = this.file_size;
        r0.f = this.name;
        r0.g = this.type;
        r0.h = this.local_path;
        r0.i = this.uploader_user_id;
        r0.j = this.is_deleted;
        r0.k = this.position;
        r0.l = this.expire_time;
        r0.m = this.google_drive_link;
        r0.n = this.url_link;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarEventAttachment.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getExpire_time() {
        return this.expire_time;
    }

    public final String getFile_size() {
        return this.file_size;
    }

    public final String getFile_token() {
        return this.file_token;
    }

    public final String getGoogle_drive_link() {
        return this.google_drive_link;
    }

    public final String getLocal_path() {
        return this.local_path;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final Type getType() {
        return this.type;
    }

    public final String getUploader_user_id() {
        return this.uploader_user_id;
    }

    public final String getUrl_link() {
        return this.url_link;
    }

    public final Boolean is_deleted() {
        return this.is_deleted;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarEventAttachment(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.file_token = r2.d;
        this.file_size = r2.e;
        this.name = r2.f;
        this.type = r2.g;
        this.local_path = r2.h;
        this.uploader_user_id = r2.i;
        this.is_deleted = r2.j;
        this.position = r2.k;
        this.expire_time = r2.l;
        this.google_drive_link = r2.m;
        this.url_link = r2.n;
    }

    public /* synthetic */ CalendarEventAttachment(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
