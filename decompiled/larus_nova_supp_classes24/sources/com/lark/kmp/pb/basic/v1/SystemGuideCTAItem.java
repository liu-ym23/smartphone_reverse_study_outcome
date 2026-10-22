package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SystemGuideCTAItem;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/SystemGuideCTAItem$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/SystemGuideCTAItem$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "lm_icon", "Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "getLm_icon", "()Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "dm_icon", "getDm_icon", "text", "Lcom/lark/kmp/pb/basic/v1/I18nText;", "getText", "()Lcom/lark/kmp/pb/basic/v1/I18nText;", "action", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction;", "getAction", "()Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SystemGuideCTAItem extends com.lark.wire.Message<SystemGuideCTAItem, a> {
    public static final ProtoAdapter<SystemGuideCTAItem> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final SystemMessageItemAction action;
    private final ImageSetPassThrough dm_icon;
    private final String id;
    private final ImageSetPassThrough lm_icon;
    private final I18nText text;

    public static final class a extends com.lark.wire.Message.a<SystemGuideCTAItem, a> {
        public String d;
        public ImageSetPassThrough e;
        public ImageSetPassThrough f;
        public I18nText g;
        public SystemMessageItemAction h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new SystemGuideCTAItem(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<SystemGuideCTAItem> {
        @Override // com.lark.wire.ProtoAdapter
        public final SystemGuideCTAItem c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L22;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = ImageSetPassThrough.ADAPTER.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = ImageSetPassThrough.ADAPTER.c(r7);
            goto L3
        L12:
            if (r4 != 4) goto L14;
            r1.g = I18nText.ADAPTER.c(r7);
            goto L3
        L14:
            if (r4 != 5) goto L15;
            r1.h = SystemMessageItemAction.ADAPTER.c(r7);
            goto L3
        L15:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L22:
            return new SystemGuideCTAItem(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(SystemGuideCTAItem r5) {
            SystemGuideCTAItem r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getId());
            ProtoAdapter<ImageSetPassThrough> r1 = ImageSetPassThrough.ADAPTER;
            return (((r0 + r1.l(2, r6.getLm_icon())) + r1.l(3, r6.getDm_icon())) + I18nText.ADAPTER.l(4, r6.getText())) + SystemMessageItemAction.ADAPTER.l(5, r6.getAction());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, SystemGuideCTAItem r5) {
            SystemGuideCTAItem r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getId());
            ProtoAdapter<ImageSetPassThrough> r0 = ImageSetPassThrough.ADAPTER;
            r0.i(r4, 2, r6.getLm_icon());
            r0.i(r4, 3, r6.getDm_icon());
            I18nText.ADAPTER.i(r4, 4, r6.getText());
            SystemMessageItemAction.ADAPTER.i(r4, 5, r6.getAction());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, SystemGuideCTAItem r5) {
            SystemGuideCTAItem r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            SystemMessageItemAction.ADAPTER.j(r4, 5, r6.getAction());
            I18nText.ADAPTER.j(r4, 4, r6.getText());
            ProtoAdapter<ImageSetPassThrough> r0 = ImageSetPassThrough.ADAPTER;
            r0.j(r4, 3, r6.getDm_icon());
            r0.j(r4, 2, r6.getLm_icon());
            ProtoAdapter.q.j(r4, 1, r6.getId());
        }

        public b(FieldEncoding r7, KClass<SystemGuideCTAItem> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.SystemGuideCTAItem", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ SystemGuideCTAItem(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SystemGuideCTAItem.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.lm_icon;
        r0.f = this.dm_icon;
        r0.g = this.text;
        r0.h = this.action;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(SystemGuideCTAItem.class).getSimpleName() + '@' + hashCode();
    }

    public final SystemMessageItemAction getAction() {
        return this.action;
    }

    public final ImageSetPassThrough getDm_icon() {
        return this.dm_icon;
    }

    public final String getId() {
        return this.id;
    }

    public final ImageSetPassThrough getLm_icon() {
        return this.lm_icon;
    }

    public final I18nText getText() {
        return this.text;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public SystemGuideCTAItem(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.id = r2.d;
        this.lm_icon = r2.e;
        this.dm_icon = r2.f;
        this.text = r2.g;
        this.action = r2.h;
    }

    public /* synthetic */ SystemGuideCTAItem(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
