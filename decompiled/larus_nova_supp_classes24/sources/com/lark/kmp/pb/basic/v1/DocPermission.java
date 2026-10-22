package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.s;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001d\u0018\u0000 ?2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003>?@B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010<\u001a\u00020\u0002H\u0016J\b\u0010=\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0015\u0010(\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b)\u0010\u0018R\u0015\u0010*\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b+\u0010&R\u0015\u0010,\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b-\u0010\u0018R\u0015\u0010.\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b/\u0010\u001fR\u0015\u00100\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b1\u0010&R\u0013\u00102\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000bR\u0013\u00104\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000bR\u0015\u00106\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b7\u0010\u0018R\u0015\u00108\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b9\u0010\u001fR\u0013\u0010:\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000b¨\u0006A"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocPermission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/DocPermission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/DocPermission$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "message_id", "getMessage_id", "channel_id", "getChannel_id", "optional_permissions", "", "Lcom/lark/kmp/pb/basic/v1/DocPermission$Permission;", "getOptional_permissions", "()Ljava/util/List;", "selected_permission_index", "", "getSelected_permission_index", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "share_text", "getShare_text", "should_render", "", "getShould_render", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "title", "getTitle", "expires", "", "getExpires", "()Ljava/lang/Long;", "Ljava/lang/Long;", "user_perm", "getUser_perm", "authed_by_user_id", "getAuthed_by_user_id", "authed_perm", "getAuthed_perm", "message_existed", "getMessage_existed", "share_status", "getShare_status", "thumbnail_detail", "getThumbnail_detail", "doc_url", "getDoc_url", "receiver_perm", "getReceiver_perm", "sender_is_external", "getSender_is_external", "extra", "getExtra", "newBuilder", "toString", "Builder", "Companion", "Permission", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DocPermission extends com.lark.wire.Message<DocPermission, a> {
    public static final ProtoAdapter<DocPermission> ADAPTER = null;
    public static final c Companion = null;
    public static final int DEFAULT_AUTHED_PERM = -1;
    public static final long DEFAULT_SHARE_STATUS = 0;
    public static final boolean DEFAULT_SHOULD_RENDER = false;
    public static final int DEFAULT_USER_PERM = -1;
    private static final long serialVersionUID = 0;
    private final Long authed_by_user_id;
    private final Integer authed_perm;
    private final String channel_id;
    private final String doc_url;
    private final Long expires;
    private final String extra;
    private final String key;
    private final Boolean message_existed;
    private final String message_id;
    private final List<Permission> optional_permissions;
    private final Integer receiver_perm;
    private final Integer selected_permission_index;
    private final Boolean sender_is_external;
    private final Long share_status;
    private final String share_text;
    private final Boolean should_render;
    private final String thumbnail_detail;
    private final String title;
    private final Integer user_perm;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocPermission$Permission;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/DocPermission$Permission$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/DocPermission$Permission$Builder;Lokio/ByteString;)V", "code", "", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "name", "", "getName", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Permission extends com.lark.wire.Message<Permission, a> {
        public static final ProtoAdapter<Permission> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer code;
        private final String name;

        public static final class a extends com.lark.wire.Message.a<Permission, a> {
            public Integer d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Permission(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Permission> {
            @Override // com.lark.wire.ProtoAdapter
            public final Permission c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                r1.d = (Integer) ProtoAdapter.h.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L9:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                return new Permission(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Permission r5) {
                Permission r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.h.l(1, r6.getCode())) + ProtoAdapter.q.l(2, r6.getName());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Permission r5) {
                Permission r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.h.i(r4, 1, r6.getCode());
                ProtoAdapter.q.i(r4, 2, r6.getName());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Permission r5) {
                Permission r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.q.j(r4, 2, r6.getName());
                ProtoAdapter.h.j(r4, 1, r6.getCode());
            }

            public b(FieldEncoding r7, KClass<Permission> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.DocPermission.Permission", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Permission(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Permission.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.code;
            r0.e = this.name;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Permission.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getCode() {
            return this.code;
        }

        public final String getName() {
            return this.name;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Permission(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.code = r2.d;
            this.name = r2.e;
        }

        public /* synthetic */ Permission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<DocPermission, a> {
        public String d;
        public String e;
        public String f;
        public List<Permission> g;
        public Integer h;
        public String i;
        public Boolean j;
        public String k;
        public Long l;
        public Integer m;
        public Long n;
        public Integer o;
        public Boolean p;
        public Long q;
        public String r;
        public String s;
        public Integer t;
        public Boolean u;
        public String v;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new DocPermission(this, c(), null);
        }

        public a() {
            this.g = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<DocPermission> {
        @Override // com.lark.wire.ProtoAdapter
        public final DocPermission c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r8.c();
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L26;
            switch(r5) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L12;
                case 15: goto L11;
                case 16: goto L10;
                case 17: goto L9;
                case 18: goto L8;
                case 19: goto L7;
                default: goto L6;
            };
        L7:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.v = r8.i();
            goto L3
        L8:
            r1.u = (Boolean) ProtoAdapter.g.c(r8);
            goto L3
        L9:
            r1.t = (Integer) ProtoAdapter.h.c(r8);
            goto L3
        L10:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.s = r8.i();
            goto L3
        L11:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.r = r8.i();
            goto L3
        L12:
            r1.q = (Long) ProtoAdapter.k.c(r8);
            goto L3
        L13:
            r1.p = (Boolean) ProtoAdapter.g.c(r8);
            goto L3
        L14:
            r1.o = (Integer) ProtoAdapter.h.c(r8);
            goto L3
        L15:
            r1.n = (Long) ProtoAdapter.k.c(r8);
            goto L3
        L16:
            r1.m = (Integer) ProtoAdapter.h.c(r8);
            goto L3
        L17:
            r1.l = (Long) ProtoAdapter.k.c(r8);
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.k = r8.i();
            goto L3
        L19:
            r1.j = (Boolean) ProtoAdapter.g.c(r8);
            goto L3
        L20:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.i = r8.i();
            goto L3
        L21:
            r1.h = (Integer) ProtoAdapter.h.c(r8);
            goto L3
        L22:
            r2.add(Permission.ADAPTER.c(r8));
            goto L3
        L23:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.f = r8.i();
            goto L3
        L24:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.e = r8.i();
            goto L3
        L25:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.d = r8.i();
            goto L3
        L6:
            r8.j(r5);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L26:
            ByteString r9 = r8.d(r3);
            Intrinsics.checkNotNullParameter(r2, "optional_permissions");
            com.lark.wire.internal.a.a(r2);
            r1.g = r2;
            return new DocPermission(r1, r9, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(DocPermission r8) {
            DocPermission r9 = r8;
            Intrinsics.checkNotNullParameter(r9, "value");
            int r0 = r9.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (((r0 + r1.l(1, r9.getKey())) + r1.l(2, r9.getMessage_id())) + r1.l(3, r9.getChannel_id())) + Permission.ADAPTER.a().l(4, r9.getOptional_permissions());
            s r3 = ProtoAdapter.h;
            int r4 = (r2 + r3.l(5, r9.getSelected_permission_index())) + r1.l(6, r9.getShare_text());
            l r5 = ProtoAdapter.g;
            int r6 = (r4 + r5.l(7, r9.getShould_render())) + r1.l(8, r9.getTitle());
            t r7 = ProtoAdapter.k;
            return ((((((((((r6 + r7.l(9, r9.getExpires())) + r3.l(10, r9.getUser_perm())) + r7.l(11, r9.getAuthed_by_user_id())) + r3.l(12, r9.getAuthed_perm())) + r5.l(13, r9.getMessage_existed())) + r7.l(14, r9.getShare_status())) + r1.l(15, r9.getThumbnail_detail())) + r1.l(16, r9.getDoc_url())) + r3.l(17, r9.getReceiver_perm())) + r5.l(18, r9.getSender_is_external())) + r1.l(19, r9.getExtra());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r7, DocPermission r8) {
            DocPermission r9 = r8;
            Intrinsics.checkNotNullParameter(r7, "writer");
            Intrinsics.checkNotNullParameter(r9, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r7, 1, r9.getKey());
            r0.i(r7, 2, r9.getMessage_id());
            r0.i(r7, 3, r9.getChannel_id());
            Permission.ADAPTER.a().i(r7, 4, r9.getOptional_permissions());
            s r1 = ProtoAdapter.h;
            r1.i(r7, 5, r9.getSelected_permission_index());
            r0.i(r7, 6, r9.getShare_text());
            l r2 = ProtoAdapter.g;
            r2.i(r7, 7, r9.getShould_render());
            r0.i(r7, 8, r9.getTitle());
            t r3 = ProtoAdapter.k;
            r3.i(r7, 9, r9.getExpires());
            r1.i(r7, 10, r9.getUser_perm());
            r3.i(r7, 11, r9.getAuthed_by_user_id());
            r1.i(r7, 12, r9.getAuthed_perm());
            r2.i(r7, 13, r9.getMessage_existed());
            r3.i(r7, 14, r9.getShare_status());
            r0.i(r7, 15, r9.getThumbnail_detail());
            r0.i(r7, 16, r9.getDoc_url());
            r1.i(r7, 17, r9.getReceiver_perm());
            r2.i(r7, 18, r9.getSender_is_external());
            r0.i(r7, 19, r9.getExtra());
            r7.a(r9.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r7, DocPermission r8) {
            DocPermission r9 = r8;
            Intrinsics.checkNotNullParameter(r7, "writer");
            Intrinsics.checkNotNullParameter(r9, "value");
            r7.d(r9.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r7, 19, r9.getExtra());
            l r1 = ProtoAdapter.g;
            r1.j(r7, 18, r9.getSender_is_external());
            s r2 = ProtoAdapter.h;
            r2.j(r7, 17, r9.getReceiver_perm());
            r0.j(r7, 16, r9.getDoc_url());
            r0.j(r7, 15, r9.getThumbnail_detail());
            t r3 = ProtoAdapter.k;
            r3.j(r7, 14, r9.getShare_status());
            r1.j(r7, 13, r9.getMessage_existed());
            r2.j(r7, 12, r9.getAuthed_perm());
            r3.j(r7, 11, r9.getAuthed_by_user_id());
            r2.j(r7, 10, r9.getUser_perm());
            r3.j(r7, 9, r9.getExpires());
            r0.j(r7, 8, r9.getTitle());
            r1.j(r7, 7, r9.getShould_render());
            r0.j(r7, 6, r9.getShare_text());
            r2.j(r7, 5, r9.getSelected_permission_index());
            Permission.ADAPTER.a().j(r7, 4, r9.getOptional_permissions());
            r0.j(r7, 3, r9.getChannel_id());
            r0.j(r7, 2, r9.getMessage_id());
            r0.j(r7, 1, r9.getKey());
        }

        public b(FieldEncoding r7, KClass<DocPermission> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.DocPermission", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ DocPermission(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DocPermission.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.key;
        r0.e = this.message_id;
        r0.f = this.channel_id;
        r0.g = this.optional_permissions;
        r0.h = this.selected_permission_index;
        r0.i = this.share_text;
        r0.j = this.should_render;
        r0.k = this.title;
        r0.l = this.expires;
        r0.m = this.user_perm;
        r0.n = this.authed_by_user_id;
        r0.o = this.authed_perm;
        r0.p = this.message_existed;
        r0.q = this.share_status;
        r0.r = this.thumbnail_detail;
        r0.s = this.doc_url;
        r0.t = this.receiver_perm;
        r0.u = this.sender_is_external;
        r0.v = this.extra;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(DocPermission.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getAuthed_by_user_id() {
        return this.authed_by_user_id;
    }

    public final Integer getAuthed_perm() {
        return this.authed_perm;
    }

    public final String getChannel_id() {
        return this.channel_id;
    }

    public final String getDoc_url() {
        return this.doc_url;
    }

    public final Long getExpires() {
        return this.expires;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getKey() {
        return this.key;
    }

    public final Boolean getMessage_existed() {
        return this.message_existed;
    }

    public final String getMessage_id() {
        return this.message_id;
    }

    public final List<Permission> getOptional_permissions() {
        return this.optional_permissions;
    }

    public final Integer getReceiver_perm() {
        return this.receiver_perm;
    }

    public final Integer getSelected_permission_index() {
        return this.selected_permission_index;
    }

    public final Boolean getSender_is_external() {
        return this.sender_is_external;
    }

    public final Long getShare_status() {
        return this.share_status;
    }

    public final String getShare_text() {
        return this.share_text;
    }

    public final Boolean getShould_render() {
        return this.should_render;
    }

    public final String getThumbnail_detail() {
        return this.thumbnail_detail;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getUser_perm() {
        return this.user_perm;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public DocPermission(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.key = r2.d;
        this.message_id = r2.e;
        this.channel_id = r2.f;
        this.optional_permissions = com.lark.wire.internal.a.c("optional_permissions", r2.g);
        this.selected_permission_index = r2.h;
        this.share_text = r2.i;
        this.should_render = r2.j;
        this.title = r2.k;
        this.expires = r2.l;
        this.user_perm = r2.m;
        this.authed_by_user_id = r2.n;
        this.authed_perm = r2.o;
        this.message_existed = r2.p;
        this.share_status = r2.q;
        this.thumbnail_detail = r2.r;
        this.doc_url = r2.s;
        this.receiver_perm = r2.t;
        this.sender_is_external = r2.u;
        this.extra = r2.v;
    }

    public /* synthetic */ DocPermission(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
