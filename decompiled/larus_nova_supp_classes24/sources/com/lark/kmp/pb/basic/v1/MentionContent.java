package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MentionContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MentionContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MentionContent$Builder;Lokio/ByteString;)V", "default_content", "", "getDefault_content", "()Ljava/lang/String;", "i18n_content", "", "getI18n_content", "()Ljava/util/Map;", "style", "Lcom/lark/kmp/pb/basic/v1/MentionContentStyle;", "getStyle", "()Lcom/lark/kmp/pb/basic/v1/MentionContentStyle;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MentionContent extends com.lark.wire.Message<MentionContent, a> {
    public static final ProtoAdapter<MentionContent> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final String default_content;
    private final Map<String, String> i18n_content;
    private final MentionContentStyle style;

    public static final class a extends com.lark.wire.Message.a<MentionContent, a> {
        public String d;
        public Map<String, String> e;
        public MentionContentStyle f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MentionContent(this, c(), null);
        }

        public a() {
            this.e = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ MentionContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(MentionContent.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new MentionContent$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.default_content;
        r0.e = this.i18n_content;
        r0.f = this.style;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MentionContent.class).getSimpleName() + '@' + hashCode();
    }

    public final String getDefault_content() {
        return this.default_content;
    }

    public final Map<String, String> getI18n_content() {
        return this.i18n_content;
    }

    public final MentionContentStyle getStyle() {
        return this.style;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MentionContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.default_content = r4;
        this.i18n_content = com.lark.wire.internal.a.d("i18n_content", r2.e);
        MentionContentStyle r5 = r2.f;
        Intrinsics.checkNotNull(r5);
        this.style = r5;
    }

    public /* synthetic */ MentionContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
