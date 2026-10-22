package com.bytedance.applet.model.menu;

import android.app.Activity;
import android.view.View;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.m;
import com.bytedance.applet.aibridge.menu.WidgetMenuItem;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.model.menu.MenuConfigImplKt$menuConfigImpl$1$1", f = "MenuConfigImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MenuConfigImplKt$menuConfigImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<String, String, Unit> $callback;
    final /* synthetic */ List<WidgetMenuItem> $menuItems;
    final /* synthetic */ String $menuStyle;
    final /* synthetic */ com.bytedance.applet.aibridge.menu.b $offset;
    final /* synthetic */ JSONObject $traceInfo;
    final /* synthetic */ WidgetContainer $widgetContainer;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MenuConfigImplKt$menuConfigImpl$1$1(WidgetContainer r1, com.bytedance.applet.aibridge.menu.b r2, List<WidgetMenuItem> r3, String r4, JSONObject r5, Function2<? super String, ? super String, Unit> r6, Continuation<? super MenuConfigImplKt$menuConfigImpl$1$1> r7) {
        this.$widgetContainer = r1;
        this.$offset = r2;
        this.$menuItems = r3;
        this.$menuStyle = r4;
        this.$traceInfo = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new MenuConfigImplKt$menuConfigImpl$1$1(this.$widgetContainer, this.$offset, this.$menuItems, this.$menuStyle, this.$traceInfo, this.$callback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L51;
        ResultKt.throwOnFailure(r13);
        cf8.c r0 = ILegacyChatUiServiceDelegate.b.H8();
        String r14 = null;
        if (r0 == null) goto L37;
        Activity r1 = this.$widgetContainer.getActivity();
        View r2 = this.$widgetContainer.realView();
        String r3 = this.$widgetContainer.l();
        m r4 = this.$widgetContainer.g;
        if (r4 == null) goto L11;
        Map r5 = r4.i;
        if (r5 == null) goto L11;
        Object r6 = r5.get("createTime");
    L13:
        if ((r6 instanceof Number) == false) goto L15;
        Number r7 = (Number) r6;
    L16:
        if (r7 == null) goto L18;
        Long r8 = Boxing.boxLong(r7.longValue());
    L19:
        com.bytedance.applet.aibridge.menu.b r9 = this.$offset;
        float r10 = 0.0f;
        if (r9 == null) goto L22;
        float r11 = c7.c(Boxing.boxInt(r9.a()));
    L23:
        com.bytedance.applet.aibridge.menu.b r12 = this.$offset;
        if (r12 == null) goto L26;
        r10 = c7.c(Boxing.boxInt(r12.b()));
    L26:
        List<WidgetMenuItem> r15 = this.$menuItems;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
        int r18 = 0;
    L28:
        if (r17.hasNext() == false) goto L33;
        Object r19 = r17.next();
        int r110 = r18 + 1;
        if (r18 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        r16.add(com.bytedance.applet.aibridge.menu.a.b((WidgetMenuItem) r19));
        r18 = r110;
        goto L28
    L33:
        List r20 = CollectionsKt.listOf(r16);
        String r21 = this.$menuStyle;
        if (r21 != null) goto L36;
        r21 = "normal";
    L36:
        Pair r22 = r0.d(r1, r2, r3, r8, r11, r10, r20, r21);
    L38:
        JSONObject r23 = this.$traceInfo;
        if (r23 != null) goto L41;
        r23 = new JSONObject();
    L41:
        MenuConfigImplKt.a = r23;
        Function2<String, String, Unit> r24 = this.$callback;
        if (r22 == null) goto L45;
        String r25 = (String) r22.getFirst();
        if (r25 == null) goto L45;
    L46:
        if (r22 == null) goto L48;
        r14 = (String) r22.getSecond();
    L48:
        r24.invoke(r25, r14);
        return Unit.INSTANCE;
    L45:
        r25 = "";
        goto L46
    L22:
        r11 = 0.0f;
        goto L23
    L18:
        r8 = null;
        goto L19
    L15:
        r7 = null;
    L11:
        r6 = null;
        goto L13
    L37:
        r22 = null;
        goto L38
    L51:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
