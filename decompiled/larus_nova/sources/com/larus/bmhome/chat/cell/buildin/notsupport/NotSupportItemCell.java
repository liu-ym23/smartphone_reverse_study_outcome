package com.larus.bmhome.chat.cell.buildin.notsupport;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.holder.helper.w0;
import com.larus.bmhome.chat.layout.item.s3;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.ss.android.lark.utils.statistics.PerfLog;
import ei9.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import s1a.d;
import v19.i5;
import va8.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001aH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/cell/buildin/notsupport/NotSupportItemCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/cell/buildin/notsupport/NotSupportItemCellState;", "<init>", "()V", "chatParam", "Lcom/larus/bmhome/data/ChatParamCoreData;", "getChatParam", "()Lcom/larus/bmhome/data/ChatParamCoreData;", "chatParam$delegate", "Lkotlin/Lazy;", "chatArgumentData", "Lcom/larus/bmhome/data/ChatArgumentCoreData;", "getChatArgumentData", "()Lcom/larus/bmhome/data/ChatArgumentCoreData;", "chatArgumentData$delegate", "chatUtilAbility", "Lcom/larus/bmhome/ability/IChatUtilsAbility;", "getChatUtilAbility", "()Lcom/larus/bmhome/ability/IChatUtilsAbility;", "chatUtilAbility$delegate", "onCreateBoxView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "", "boxType", "onBindView", "", "view", "state", "position", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotSupportItemCell extends BaseMessageListCell<zc8.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f297622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f297623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f297624g;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Function0<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f297625a;

        public a(AttachReceiver r100) {
            this.f297625a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.y] */
        @Override // kotlin.jvm.functions.Function0
        public final y invoke() {
            AttachReceiver r100 = this.f297625a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r100).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class b implements Function0<fp8.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f297626a;

        public b(AttachReceiver r100) {
            this.f297626a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [fp8.b, t1a.c] */
        @Override // kotlin.jvm.functions.Function0
        public final fp8.b invoke() {
            AttachReceiver r100 = this.f297626a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r100).g(Reflection.getOrCreateKotlinClass(fp8.b.class));
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class c implements Function0<fp8.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f297627a;

        public c(AttachReceiver r100) {
            this.f297627a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [fp8.a, t1a.c] */
        @Override // kotlin.jvm.functions.Function0
        public final fp8.a invoke() {
            AttachReceiver r100 = this.f297627a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r100).g(Reflection.getOrCreateKotlinClass(fp8.a.class));
        }
    }

    public NotSupportItemCell() {
        this.f297622e = LazyKt.lazy(new b(this));
        this.f297623f = LazyKt.lazy(new c(this));
        this.f297624g = LazyKt.lazy(new a(this));
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        s3 r103 = new s3(r100);
        fp8.a r104 = (fp8.a) this.f297623f.getValue();
        if (r104 == null) goto L5;
        Integer r105 = r104.f478294a;
    L6:
        r103.setImmerseBgColor(r105);
        fp8.b r106 = (fp8.b) this.f297622e.getValue();
        if (r106 == null) goto L11;
        boolean r107 = true;
        if (r106.f478296a != true) goto L11;
    L12:
        r103.setUseSubscribedColor(r107);
        r103.setBoxType(r102);
        return r103;
    L11:
        r107 = false;
        goto L12
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, f r101, int r110) {
        zc8.a r102 = (zc8.a) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "state");
        Message r103 = r102.f563233a;
        w0 r104 = null;
        if ((r100 instanceof s3) == false) goto L5;
        s3 r111 = (s3) r100;
    L6:
        if (r111 == null) goto L26;
        AppCompatTextView r105 = r111.getTextView();
        if (r105 != null) goto L11;
        return;
    L11:
        if (r103.getMessageStatusLocal() != 22) goto L13;
        r105.setText("...");
    L14:
        float r106 = i5.t();
        fp8.a r112 = (fp8.a) this.f297623f.getValue();
        if (r112 == null) goto L17;
        Integer r113 = r112.f478294a;
    L18:
        if (r113 == null) goto L20;
        boolean r107 = true;
    L21:
        we8.a.b(r105, r106, r107, null, null, 12);
        y r114 = (y) this.f297624g.getValue();
        if (r114 == null) goto L24;
        r104 = r114.rn(r103, this);
    L24:
        r100.setOnLongClickListener(r104);
        return;
    L20:
        r107 = false;
        goto L21
    L17:
        r113 = null;
        goto L18
    L13:
        r105.setText(R.string.larus_chat_unsupported_message_type);
        goto L14
    L26:
        return;
    L5:
        r111 = null;
        goto L6
    }
}
