package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SystemGuideContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/SystemGuideContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/SystemGuideContent$Builder;Lokio/ByteString;)V", "title", "Lcom/lark/kmp/pb/basic/v1/I18nText;", "getTitle", "()Lcom/lark/kmp/pb/basic/v1/I18nText;", "sub_title", "getSub_title", "lm_image", "Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "getLm_image", "()Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "dm_image", "getDm_image", "items", "", "Lcom/lark/kmp/pb/basic/v1/SystemGuideCTAItem;", "getItems", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SystemGuideContent extends com.lark.wire.Message<SystemGuideContent, a> {
    public static final ProtoAdapter<SystemGuideContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ImageSetPassThrough dm_image;
    private final List<SystemGuideCTAItem> items;
    private final ImageSetPassThrough lm_image;
    private final I18nText sub_title;
    private final I18nText title;

    public static final class a extends com.lark.wire.Message.a<SystemGuideContent, a> {
        public I18nText d;
        public I18nText e;
        public ImageSetPassThrough f;
        public ImageSetPassThrough g;
        public List<SystemGuideCTAItem> h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new SystemGuideContent(this, c(), null);
        }

        public a() {
            this.h = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<SystemGuideContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final SystemGuideContent c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L21;
            if (r4 != 1) goto L8;
            r0.d = I18nText.ADAPTER.c(r7);
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r0.e = I18nText.ADAPTER.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r0.f = ImageSetPassThrough.ADAPTER.c(r7);
            goto L3
        L12:
            if (r4 != 4) goto L14;
            r0.g = ImageSetPassThrough.ADAPTER.c(r7);
            goto L3
        L14:
            if (r4 != 5) goto L15;
            r1.add(SystemGuideCTAItem.ADAPTER.c(r7));
            goto L3
        L15:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L21:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "items");
            com.lark.wire.internal.a.a(r1);
            r0.h = r1;
            return new SystemGuideContent(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(SystemGuideContent r5) {
            SystemGuideContent r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            ProtoAdapter<I18nText> r1 = I18nText.ADAPTER;
            int r2 = (r0 + r1.l(1, r6.getTitle())) + r1.l(2, r6.getSub_title());
            ProtoAdapter<ImageSetPassThrough> r3 = ImageSetPassThrough.ADAPTER;
            return ((r2 + r3.l(3, r6.getLm_image())) + r3.l(4, r6.getDm_image())) + SystemGuideCTAItem.ADAPTER.a().l(5, r6.getItems());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, SystemGuideContent r5) {
            SystemGuideContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter<I18nText> r0 = I18nText.ADAPTER;
            r0.i(r4, 1, r6.getTitle());
            r0.i(r4, 2, r6.getSub_title());
            ProtoAdapter<ImageSetPassThrough> r1 = ImageSetPassThrough.ADAPTER;
            r1.i(r4, 3, r6.getLm_image());
            r1.i(r4, 4, r6.getDm_image());
            SystemGuideCTAItem.ADAPTER.a().i(r4, 5, r6.getItems());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, SystemGuideContent r5) {
            SystemGuideContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            SystemGuideCTAItem.ADAPTER.a().j(r4, 5, r6.getItems());
            ProtoAdapter<ImageSetPassThrough> r0 = ImageSetPassThrough.ADAPTER;
            r0.j(r4, 4, r6.getDm_image());
            r0.j(r4, 3, r6.getLm_image());
            ProtoAdapter<I18nText> r1 = I18nText.ADAPTER;
            r1.j(r4, 2, r6.getSub_title());
            r1.j(r4, 1, r6.getTitle());
        }

        public b(FieldEncoding r7, KClass<SystemGuideContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.SystemGuideContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ SystemGuideContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SystemGuideContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.title;
        r0.e = this.sub_title;
        r0.f = this.lm_image;
        r0.g = this.dm_image;
        r0.h = this.items;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(SystemGuideContent.class).getSimpleName() + '@' + hashCode();
    }

    public final ImageSetPassThrough getDm_image() {
        return this.dm_image;
    }

    public final List<SystemGuideCTAItem> getItems() {
        return this.items;
    }

    public final ImageSetPassThrough getLm_image() {
        return this.lm_image;
    }

    public final I18nText getSub_title() {
        return this.sub_title;
    }

    public final I18nText getTitle() {
        return this.title;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public SystemGuideContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.title = r2.d;
        this.sub_title = r2.e;
        this.lm_image = r2.f;
        this.dm_image = r2.g;
        this.items = com.lark.wire.internal.a.c("items", r2.h);
    }

    public /* synthetic */ SystemGuideContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
