package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/AppTipsContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/AppTipsContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/AppTipsContent$Builder;Lokio/ByteString;)V", "i18n_title", "", "getI18n_title", "()Ljava/lang/String;", "i18n_msg", "getI18n_msg", "actions", "", "Lcom/lark/kmp/pb/basic/v1/ActionInfo;", "getActions", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AppTipsContent extends com.lark.wire.Message<AppTipsContent, a> {
    public static final ProtoAdapter<AppTipsContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<ActionInfo> actions;
    private final String i18n_msg;
    private final String i18n_title;

    public static final class a extends com.lark.wire.Message.a<AppTipsContent, a> {
        public String d;
        public String e;
        public List<ActionInfo> f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new AppTipsContent(this, c(), null);
        }

        public a() {
            this.f = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<AppTipsContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final AppTipsContent c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r8.c();
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L15;
            if (r5 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.d = r8.i();
            goto L3
        L8:
            if (r5 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.e = r8.i();
            goto L3
        L10:
            if (r5 != 3) goto L11;
            r2.add(ActionInfo.ADAPTER.c(r8));
            goto L3
        L11:
            r8.j(r5);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L15:
            ByteString r9 = r8.d(r3);
            Intrinsics.checkNotNullParameter(r2, "actions");
            com.lark.wire.internal.a.a(r2);
            r1.f = r2;
            return new AppTipsContent(r1, r9, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(AppTipsContent r5) {
            AppTipsContent r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((r0 + r1.l(1, r6.getI18n_title())) + r1.l(2, r6.getI18n_msg())) + ActionInfo.ADAPTER.a().l(3, r6.getActions());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, AppTipsContent r5) {
            AppTipsContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getI18n_title());
            r0.i(r4, 2, r6.getI18n_msg());
            ActionInfo.ADAPTER.a().i(r4, 3, r6.getActions());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, AppTipsContent r5) {
            AppTipsContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ActionInfo.ADAPTER.a().j(r4, 3, r6.getActions());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 2, r6.getI18n_msg());
            r0.j(r4, 1, r6.getI18n_title());
        }

        public b(FieldEncoding r7, KClass<AppTipsContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.AppTipsContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ AppTipsContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AppTipsContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.i18n_title;
        r0.e = this.i18n_msg;
        r0.f = this.actions;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(AppTipsContent.class).getSimpleName() + '@' + hashCode();
    }

    public final List<ActionInfo> getActions() {
        return this.actions;
    }

    public final String getI18n_msg() {
        return this.i18n_msg;
    }

    public final String getI18n_title() {
        return this.i18n_title;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public AppTipsContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.i18n_title = r2.d;
        this.i18n_msg = r2.e;
        this.actions = com.lark.wire.internal.a.c("actions", r2.f);
    }

    public /* synthetic */ AppTipsContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
