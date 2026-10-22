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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ImageTranslationAbility;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ImageTranslationAbility$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ImageTranslationAbility$Builder;Lokio/ByteString;)V", "can_translate", "", "getCan_translate", "()Z", "src_language", "", "", "getSrc_language", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ImageTranslationAbility extends com.lark.wire.Message<ImageTranslationAbility, a> {
    public static final ProtoAdapter<ImageTranslationAbility> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final boolean can_translate;
    private final List<String> src_language;

    public static final class a extends com.lark.wire.Message.a<ImageTranslationAbility, a> {
        public Boolean d;
        public List<String> e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ImageTranslationAbility(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<ImageTranslationAbility> {
        @Override // com.lark.wire.ProtoAdapter
        public final ImageTranslationAbility c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r8.c();
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L12;
            if (r5 != 1) goto L8;
            r1.d = Boolean.valueOf(((Boolean) ProtoAdapter.g.c(r8)).booleanValue());
            goto L3
        L8:
            if (r5 != 2) goto L9;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r2.add(r8.i());
            goto L3
        L9:
            r8.j(r5);
            goto L3
        L12:
            ByteString r9 = r8.d(r3);
            Intrinsics.checkNotNullParameter(r2, "src_language");
            com.lark.wire.internal.a.a(r2);
            r1.e = r2;
            return new ImageTranslationAbility(r1, r9, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ImageTranslationAbility r5) {
            ImageTranslationAbility r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.g.l(1, Boolean.valueOf(r6.getCan_translate()))) + ProtoAdapter.q.a().l(2, r6.getSrc_language());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ImageTranslationAbility r5) {
            ImageTranslationAbility r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.g.i(r4, 1, Boolean.valueOf(r6.getCan_translate()));
            ProtoAdapter.q.a().i(r4, 2, r6.getSrc_language());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ImageTranslationAbility r5) {
            ImageTranslationAbility r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.q.a().j(r4, 2, r6.getSrc_language());
            ProtoAdapter.g.j(r4, 1, Boolean.valueOf(r6.getCan_translate()));
        }

        public b(FieldEncoding r7, KClass<ImageTranslationAbility> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ImageTranslationAbility", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ImageTranslationAbility(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageTranslationAbility.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = Boolean.valueOf(this.can_translate);
        r0.e = this.src_language;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ImageTranslationAbility.class).getSimpleName() + '@' + hashCode();
    }

    public final boolean getCan_translate() {
        return this.can_translate;
    }

    public final List<String> getSrc_language() {
        return this.src_language;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ImageTranslationAbility(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Boolean r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.can_translate = r4.booleanValue();
        this.src_language = com.lark.wire.internal.a.c("src_language", r2.e);
    }

    public /* synthetic */ ImageTranslationAbility(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
