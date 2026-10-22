package com.larus.bmhome.chat.standarduikit.botreferencetext.blockadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.manager.l0;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.standarduikit.botreferencetext.view.BotReferenceTextView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ReferenceBlock;
import com.larus.im.bean.message.block.ReferenceText;
import com.larus.mainbot.impl.databinding.LarusLayoutBotReplyHeaderBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import jc8.d;
import jc8.e;
import kc8.i;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class BotReferenceTextBlockHolder extends jc8.b<a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kc8.b f308911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zi8.c f308912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f308913f;

    @Override // jc8.b
    public final String c() {
        return "BotReferenceTextBlockHolder";
    }

    public BotReferenceTextBlockHolder() {
        this.f308913f = LazyKt.lazy(new b(this));
    }

    @Override // jc8.b
    public final d f(jc8.a r100) {
        a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, "blockModel");
        return e.d(r101);
    }

    @Override // jc8.b
    public final void g(jc8.a r100) {
        final a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, "blockModel");
        kc8.b r102 = (kc8.b) jc8.c.a(this, kc8.b.class);
        this.f308911d = r102;
        BotModel r103 = null;
        if (r102 == null) goto L5;
        i r104 = r102.f502442r;
    L6:
        if (r102 == null) goto L12;
        y r105 = r102.f502425a;
        if (r105 == null) goto L12;
        Function0<BotModel> r106 = r105.f502631l;
        if (r106 == null) goto L12;
        r103 = r106.invoke();
    L12:
        if (r103 != null) goto L17;
        if (r104 == null) goto L19;
        Function1<Function1<? super BotModel, Unit>, Unit> r107 = r104.f502495a;
        if (r107 == null) goto L20;
        r107.invoke(new c(this, r101));
        return;
    L20:
        return;
    L19:
        return;
    L17:
        k(r101, r103);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // jc8.b
    public final View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        zi8.c r101 = new zi8.c(r100.getContext());
        this.f308912e = r101;
        return (BotReferenceTextView) r101.f572266a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.chat.standarduikit.botreferencetext.blockadapter.BotReferenceTextBlockHolder] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.larus.im.bean.message.Message] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final void k(a r110, BotModel r111) {
        BlockContent r100 = r110.f498145a.getContent();
        ?? r101 = 0;
        Object r102 = null;
        r101 = 0;
        r101 = 0;
        r101 = 0;
        if (r100 == null) goto L9;
        ReferenceBlock r103 = r100.getReferenceBlock();
        if (r103 == null) goto L9;
        ReferenceText r104 = r103.getText();
        if (r104 == null) goto L9;
        String r105 = r104.getMessageId();
    L10:
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        kc8.b r107 = this.f308911d;
        if (r107 == null) goto L25;
        y r108 = r107.f502425a;
        if (r108 == null) goto L25;
        q0 r109 = r108.f502643x;
        if (r109 == null) goto L25;
        List<Message> r112 = r109.getCurrentList();
        if (r112 == null) goto L25;
        Iterator r113 = r112.iterator();
    L20:
        if (r113.hasNext() == false) goto L24;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((Message) r114).getMessageId(), r105) == false) goto L20;
        r102 = r114;
    L24:
        r101 = (Message) r102;
    L25:
        r106.element = r101;
        Message r115 = (Message) r101;
        l(r110, r111, r101);
        if (r106.element != null) goto L40;
        kc8.b r116 = this.f308911d;
        if (r116 == null) goto L41;
        y r117 = r116.f502425a;
        if (r117 == null) goto L42;
        Fragment r118 = r117.f502620a;
        if (r118 == null) goto L43;
        LifecycleCoroutineScope r119 = LifecycleOwnerKt.getLifecycleScope(r118);
        if (r119 == null) goto L44;
        BuildersKt.launch$default(r119, Dispatchers.getIO(), null, new BotReferenceTextBlockHolder$nextChainToHandleRefMsg$1(r106, this, r105, r110, r111, null), 2, null);
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L9:
        r105 = null;
        goto L10
    }

    public static final Object j(BotReferenceTextBlockHolder r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof BotReferenceTextBlockHolder$getRepoMessage$1) == false) goto L7;
        BotReferenceTextBlockHolder$getRepoMessage$1 r103 = (BotReferenceTextBlockHolder$getRepoMessage$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L25
    L21:
        return (Message) r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        if (r101 == null) goto L24;
        IChatRepoService r108 = zh8.a.f572196a;     // Catch: Exception -> L25
        r103.label = 1;     // Catch: Exception -> L25
        r105 = r108.E1(r101, r103);     // Catch: Exception -> L25
        if (r105 != r106) goto L21;
        return r106;
    L24:
        return null;
    L7:
        r103 = new BotReferenceTextBlockHolder$getRepoMessage$1(r100, r102);
        goto L8
    }

    public final void l(a r110, BotModel r111, Message r112) {
        int r100 = l0.f306756a;
        if (l0.a(r111.getBotType()) == false) goto L5;
    L7:
        BlockContent r113 = r110.f498145a.getContent();
        String r101 = null;
        if (r113 == null) goto L10;
        ReferenceBlock r114 = r113.getReferenceBlock();
    L11:
        bj8.a r102 = new bj8.a(r114, r111, r112);
        zi8.c r115 = this.f308912e;
        if (r115 == null) goto L84;
        bj8.b r116 = (bj8.b) this.f308913f.getValue();
        Intrinsics.checkNotNullParameter(r102, "vmData");
        bj8.d r103 = (bj8.d) r115.f572267b.getValue();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "vmData");
        r103.f19251a = r102;
        r103.f19252b = r116;
        bj8.d r117 = (bj8.d) r115.f572267b.getValue();
        bj8.a r118 = r117.f19251a;
        if (r118 == null) goto L16;
        ReferenceBlock r104 = r118.f19247a;
    L17:
        if (r118 == null) goto L19;
        Message r119 = r118.f19249c;
    L21:
        if (com.larus.bmhome.chat.bean.d.U(r119) == false) goto L29;
        if (r104 == null) goto L26;
        ReferenceText r120 = r104.getText();
        if (r120 == null) goto L26;
        String r121 = r120.getText();
    L27:
        if (r121 != null) goto L30;
        r121 = "";
    L30:
        String r122 = CollectionsKt.joinToString$default(StringsKt.lines(r121), " ", null, null, 0, null, null, 62, null);
        int r105 = 0;
        if (r122.length() <= 0) goto L33;
        boolean r106 = true;
    L34:
        bj8.b r123 = r117.f19252b;
        if (r123 == null) goto L37;
        boolean r124 = r123.p();
    L38:
        if (r104 == null) goto L43;
        ReferenceText r107 = r104.getText();
        if (r107 == null) goto L43;
        r101 = r107.getIconKey();
    L43:
        if (Intrinsics.areEqual(r101, "task") == false) goto L45;
        r105 = R.drawable.larus_icon_mouse_use_in;
    L45:
        aj8.a r108 = new aj8.a(r106, r122, r124, r105);
        ((bj8.d) r115.f572267b.getValue()).getClass();
        aj8.b r125 = new aj8.b();
        BotReferenceTextView r126 = (BotReferenceTextView) r115.f572266a.getValue();
        r126.getClass();
        Intrinsics.checkNotNullParameter(r108, "input");
        Intrinsics.checkNotNullParameter(r125, BdpAppEventConstant.PARAMS_OUTPUT);
        if (r108.f3944a == false) goto L82;
        LarusLayoutBotReplyHeaderBinding r127 = r126.f308919a;
        if (r127 == null) goto L53;
        TextView r128 = r127.f358704c;
        if (r128 == null) goto L53;
        r128.setText(r108.f3945b);
    L53:
        if (r108.f3946c == false) goto L64;
        LarusLayoutBotReplyHeaderBinding r129 = r126.f308919a;
        if (r129 == null) goto L59;
        TextView r130 = r129.f358704c;
        if (r130 == null) goto L59;
        r130.setTextColor(ve8.d.a(R.color.static_white_transparent_4, AppHost.f326268a.getApplication()));
    L59:
        LarusLayoutBotReplyHeaderBinding r131 = r126.f308919a;
        if (r131 == null) goto L74;
        ImageView r132 = r131.f358703b;
        if (r132 == null) goto L74;
        r132.setImageResource(R.drawable.larus_ic_reply_rect_immerse_new);
    L74:
        int r133 = r108.f3947d;
        if (r133 == 0) goto L81;
        LarusLayoutBotReplyHeaderBinding r134 = r126.f308919a;
        if (r134 == null) goto L81;
        ImageView r135 = r134.f358703b;
        if (r135 == null) goto L81;
        r135.setImageResource(r133);
    L81:
        e1.x(r126);
        return;
    L64:
        LarusLayoutBotReplyHeaderBinding r136 = r126.f308919a;
        if (r136 == null) goto L69;
        TextView r137 = r136.f358704c;
        if (r137 == null) goto L69;
        r137.setTextColor(v19.c.a(R.attr.larus_neutral_70, r126.getContext(), R.color.larus_neutral_70));
    L69:
        LarusLayoutBotReplyHeaderBinding r138 = r126.f308919a;
        if (r138 == null) goto L74;
        ImageView r139 = r138.f358703b;
        if (r139 == null) goto L74;
        r139.setImageResource(R.drawable.larus_ic_reply_rect_new_in);
        goto L74
    L82:
        e1.o(r126);
        return;
    L37:
        r124 = false;
        goto L38
    L33:
        r106 = false;
    L26:
        r121 = null;
        goto L27
    L29:
        r121 = AppHost.f326268a.getApplication().getString(R.string.larus_quote_message_deleted);
        goto L30
    L19:
        r119 = null;
        goto L21
    L16:
        r104 = null;
        goto L17
    L84:
        return;
    L10:
        r114 = null;
        goto L11
    L5:
        if (ce8.a.b(r111) == true) goto L7;
    }
}
