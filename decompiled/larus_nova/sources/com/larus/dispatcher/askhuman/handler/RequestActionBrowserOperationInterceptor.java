package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.browsertakeover.api.BrowserTakeoverOpenResult;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes27.dex */
public final class RequestActionBrowserOperationInterceptor implements IQuickReplyClickInterceptor {

    public static final class CompletionDelegate implements hv8.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f330879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Function1<com.larus.bmhome.taskskill.service.k, Unit>> f330880b;

        public CompletionDelegate(String r100, Function1<? super com.larus.bmhome.taskskill.service.k, Unit> r101) {
            this.f330879a = r100;
            if (r101 == null) goto L5;
            WeakReference<Function1<com.larus.bmhome.taskskill.service.k, Unit>> r102 = new WeakReference(r101);
        L6:
            this.f330880b = r102;
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // hv8.d
        public final Object a(hv8.a r100, Continuation<? super Boolean> r110) {
            if ((r110 instanceof RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1) == false) goto L7;
            RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1 r101 = (RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1) r110;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r111 = r101.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r101.label;
            if (r104 == 0) goto L18;
            if (r104 == 1) goto L17;
            if (r104 == 2) goto L16;
            if (r104 != 3) goto L15;
            boolean r105 = r101.Z$0;
            ResultKt.throwOnFailure(r111);
        L36:
            return Boxing.boxBoolean(r105);
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            r100 = (hv8.a) r101.L$0;
            ResultKt.throwOnFailure(r111);
        L30:
            boolean r112 = ((Boolean) r111).booleanValue();
        L24:
            boolean r106 = r112;
            hv8.a r113 = r100;
            r105 = r106;
            if (r105 == false) goto L36;
            MainCoroutineDispatcher r107 = Dispatchers.getMain();
            RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$2 r108 = new RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$2(this, r113, null);
            r101.L$0 = null;
            r101.Z$0 = r105;
            r101.label = 3;
            if (BuildersKt.withContext(r107, r108, r101) != r103) goto L36;
            return r103;
        L17:
            r100 = (hv8.a) r101.L$0;
            ResultKt.throwOnFailure(r111);
        L23:
            r112 = ((Boolean) r111).booleanValue();
            goto L24
        L18:
            ResultKt.throwOnFailure(r111);
            hv8.c r114 = r100.f487351g;
            if ((r114 instanceof hv8.c.a) == false) goto L26;
            r101.L$0 = r100;
            r101.label = 1;
            r111 = BuildersKt.withContext(Dispatchers.getIO(), new RequestActionBrowserOperationInterceptor$CompletionDelegate$completeCloud$2(r100, null), r101);
            if (r111 != r103) goto L23;
            return r103;
        L26:
            if ((r114 instanceof hv8.c.b) == false) goto L38;
            r101.L$0 = r100;
            r101.label = 2;
            r111 = b(r100, (hv8.c.b) r114, r101);
            if (r111 != r103) goto L30;
            return r103;
        L38:
            throw new NoWhenBranchMatchedException();
        L7:
            r101 = new RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1(this, r110);
            goto L8
        }

        public final Object b(hv8.a r100, hv8.c.b r101, Continuation<? super Boolean> r102) {
            if ((r102 instanceof RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1) == false) goto L7;
            RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1 r103 = (RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1) r102;
            int r104 = r103.label;
            if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
            r103.label = r104 - Integer.MIN_VALUE;
        L8:
            Object r105 = r103.result;
            Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r107 = r103.label;
            if (r107 == 0) goto L14;
            if (r107 != 1) goto L13;
            ResultKt.throwOnFailure(r105);
        L17:
            Boolean r108 = (Boolean) r105;
            if (r108 == null) goto L20;
            boolean r109 = r108.booleanValue();
        L22:
            return Boxing.boxBoolean(r109);
        L20:
            r109 = false;
            goto L22
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r105);
            RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$2 r110 = new RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$2(r101, this, r100, null);
            r103.label = 1;
            r105 = TimeoutKt.c(65000, r110, r103);
            if (r105 != r106) goto L17;
            return r106;
        L7:
            r103 = new RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1(this, r102);
            goto L8
        }
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final String c() {
        return "interaction.request_action";
    }

    public RequestActionBrowserOperationInterceptor() {
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean e(k r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptorContext");
        Integer r101 = r100.f330888b.getActionType();
        int r102 = ActionType.CUA_REQUEST_ACTION_BROWSER_OPERATION.getValue();
        if (r101 != null) goto L6;
    L8:
        return false;
    L6:
        if (r101.intValue() != r102) goto L8;
        return true;
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void f(String r100) {
        IQuickReplyClickInterceptor.DefaultImpls.a(r100);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p g(o r310) {
        Intrinsics.checkNotNullParameter(r310, "interceptorContext");
        BrowserTakeoverEntryMonitor r100 = r310.f330919p;
        FragmentActivity r101 = r310.f330906c;
        if (r101 == null) goto L225;
        if (r101.isDestroyed() == false) goto L7;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L225;
        t r103 = r310.f330907d;
        String r104 = r103.f330922a;
        if (r104 != null) goto L19;
    L26:
        String r110 = null;
    L27:
        if (r110 == null) goto L217;
        if (StringsKt.isBlank(r310.f330910g) == true) goto L217;
        f r105 = r103.f330927f;
        if (r105 != null) goto L34;
    L36:
        boolean r106 = false;
    L37:
        if (r106 == false) goto L47;
        String r107 = r105.f330885b;
        if (r107 != null) goto L41;
    L44:
        boolean r108 = true;
    L45:
        if (r108 == true) goto L47;
        hv8.c r109 = new hv8.c.a(r105.f330885b, r105.f330886c);
    L76:
        String r111 = r310.f330905b.f20307a;
        String r112 = r310.f330910g;
        String r113 = r310.f330911h;
        int r114 = r310.f330912i;
        String r115 = r103.f330923b;
        if (r100 == null) goto L80;
        String r116 = r100.f330871b;
        if (r116 == null) goto L80;
    L81:
        String r210 = r116;
        if (r100 == null) goto L84;
        RequestActionBrowserOperationInterceptor$handleClick$request$1$1 r211 = new RequestActionBrowserOperationInterceptor$handleClick$request$1$1(r100);
    L85:
        hv8.a r117 = new hv8.a(r111, r112, r113, r114, r110, r115, r109, r210, r211);
        CompletionDelegate r118 = new CompletionDelegate(r310.f330909f, r310.f330914k);
        if ((r109 instanceof hv8.c.b) == false) goto L200;
        hv8.c.b r119 = (hv8.c.b) r109;
        String r120 = r119.f487357b;
        if (r120 == null) goto L232;
        Integer r121 = StringsKt.toIntOrNull(r120);
        if (r121 != null) goto L92;
    L97:
        boolean r122 = false;
    L98:
        if (r122 == true) goto L232;
        return h(r310, BrowserTakeoverEntryMonitor.Reason.INVALID_APP_ID);
    L92:
        if (r121.intValue() <= 0) goto L94;
        boolean r123 = true;
    L95:
        if (r123 != true) goto L97;
        r122 = true;
        goto L98
    L94:
        r123 = false;
    L232:
        GetAllDevicesRepo r124 = GetAllDevicesRepo.f330842a;     // Catch: Exception -> L197
        AllDeviceResponse r125 = GetAllDevicesRepo.d();     // Catch: Exception -> L197
        if (r125 == null) goto L104;
        List<PcDevice> r126 = r125.getDevices();
    L105:
        if (r126 != null) goto L107;
        r126 = CollectionsKt.emptyList();
    L107:
        List r127 = CollectionsKt.filterNotNull(r126);
        ArrayList r128 = new ArrayList();
        Iterator r129 = r127.iterator();
    L109:
        if (r129.hasNext() == false) goto L120;
        Object r130 = r129.next();
        PcDevice r131 = (PcDevice) r130;
        if (Intrinsics.areEqual(r131.getDeviceId(), r119.f487356a) == true) goto L113;
    L117:
        boolean r132 = false;
    L118:
        if (r132 == false) goto L109;
        r128.add(r130);
        goto L109
    L113:
        if (r119.f487357b != null) goto L115;
    L116:
        r132 = true;
        goto L118
    L115:
        if (Intrinsics.areEqual(r131.b(), r119.f487357b) == false) goto L117;
    L120:
        PcDevice r133 = (PcDevice) CollectionsKt.singleOrNull(r128);
        if (r133 == null) goto L123;
        boolean r134 = Intrinsics.areEqual(r133.r(), Boolean.TRUE);
    L124:
        if (r134 == false) goto L137;
        Boolean r135 = r133.c();
        Boolean r136 = Boolean.TRUE;
        if (Intrinsics.areEqual(r135, r136) == false) goto L137;
        if (Intrinsics.areEqual(r133.g(), r136) == false) goto L137;
        List<Integer> r137 = r133.q();
        if (r137 != null) goto L132;
    L134:
        boolean r138 = false;
    L135:
        if (r138 == false) goto L137;
        boolean r139 = true;
    L138:
        String r140 = r119.f487357b;
        if (r140 != null) goto L143;
        if (r133 == null) goto L142;
        r140 = r133.b();
        goto L143
    L142:
        r140 = null;
    L143:
        if (r139 == false) goto L170;
        if (r140 == null) goto L153;
        Integer r141 = StringsKt.toIntOrNull(r140);
        if (r141 == null) goto L153;
        if (r141.intValue() <= 0) goto L150;
        boolean r142 = true;
    L151:
        if (r142 != true) goto L153;
        boolean r143 = true;
    L154:
        if (r143 == false) goto L170;
        boolean r144 = hv8.b.a(r101, new hv8.a(r117.f487345a, r117.f487346b, r117.f487347c, r117.f487348d, r117.f487349e, r117.f487350f, new hv8.c.b(r119.f487356a, r140, r119.f487358c), r117.f487352h, r117.f487353i), r118);
        if (r144 == false) goto L159;
        if (r100 != null) goto L162;
    L165:
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r145 = r310.f330914k;
        if (r145 == null) goto L169;
        r145.invoke(com.larus.bmhome.taskskill.service.k.a.f314452a);
    L169:
        return new p(r144, false);
    L162:
        if (r100.f330873d != BrowserTakeoverOpenResult.REUSED) goto L164;
        r100.b("reused", BrowserTakeoverEntryMonitor.Reason.ALREADY_OPEN);
        goto L165
    L164:
        r100.b("opened", BrowserTakeoverEntryMonitor.Reason.NONE);
        goto L165
    L159:
        return h(r310, null);
    L150:
        r142 = false;
    L153:
        r143 = false;
    L170:
        if (r125 != null) goto L173;
        BrowserTakeoverEntryMonitor.Reason r146 = BrowserTakeoverEntryMonitor.Reason.DEVICE_CACHE_MISSING;
    L196:
        return h(r310, r146);
    L173:
        if (r128.size() <= 1) goto L175;
        r146 = BrowserTakeoverEntryMonitor.Reason.DEVICE_AMBIGUOUS;
        goto L196
    L175:
        if (r133 != null) goto L177;
        r146 = BrowserTakeoverEntryMonitor.Reason.DEVICE_NOT_FOUND;
        goto L196
    L177:
        Boolean r147 = r133.r();
        Boolean r148 = Boolean.TRUE;
        if (Intrinsics.areEqual(r147, r148) == true) goto L181;
        r146 = BrowserTakeoverEntryMonitor.Reason.DEVICE_OFFLINE;
        goto L196
    L181:
        if (Intrinsics.areEqual(r133.c(), r148) == true) goto L184;
        r146 = BrowserTakeoverEntryMonitor.Reason.NOT_AUTHORIZED;
        goto L196
    L184:
        if (Intrinsics.areEqual(r133.g(), r148) == true) goto L186;
        r146 = BrowserTakeoverEntryMonitor.Reason.CONTROL_DISABLED;
        goto L196
    L186:
        List<Integer> r149 = r133.q();
        if (r149 != null) goto L189;
    L191:
        boolean r150 = false;
    L192:
        if (r150 == true) goto L194;
        r146 = BrowserTakeoverEntryMonitor.Reason.CAPABILITY_MISSING;
        goto L196
    L194:
        r146 = BrowserTakeoverEntryMonitor.Reason.INVALID_APP_ID;
        goto L196
    L189:
        if (r149.contains(Integer.valueOf(DispatchCommand.RTC_START_ROOM_REQUEST.value)) != true) goto L191;
        r150 = true;
        goto L192
    L132:
        if (r137.contains(Integer.valueOf(DispatchCommand.RTC_START_ROOM_REQUEST.value)) != true) goto L134;
        r138 = true;
    L137:
        r139 = false;
        goto L138
    L123:
        r134 = false;
        goto L124
    L104:
        r126 = null;
    L197:
        e = move-exception;
        IQuickReplyClickInterceptor.DefaultImpls.a("[browserTakeover] device cache read failed, type=".concat(e.getClass().getSimpleName()));
        return h(r310, BrowserTakeoverEntryMonitor.Reason.DEVICE_CACHE_ERROR);
    L200:
        boolean r151 = hv8.b.a(r101, r117, r118);
        if (r151 == false) goto L203;
        if (r100 != null) goto L206;
    L209:
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r152 = r310.f330914k;
        if (r152 == null) goto L213;
        r152.invoke(com.larus.bmhome.taskskill.service.k.a.f314452a);
    L213:
        return new p(r151, false);
    L206:
        if (r100.f330873d != BrowserTakeoverOpenResult.REUSED) goto L208;
        r100.b("reused", BrowserTakeoverEntryMonitor.Reason.ALREADY_OPEN);
        goto L209
    L208:
        r100.b("opened", BrowserTakeoverEntryMonitor.Reason.NONE);
        goto L209
    L203:
        return h(r310, null);
    L84:
        r211 = null;
    L80:
        r116 = UUID.randomUUID().toString();
        goto L81
    L41:
        if (StringsKt.isBlank(r107) == true) goto L44;
        r108 = false;
    L47:
        if (r105 != null) goto L49;
    L51:
        boolean r153 = false;
    L52:
        if (r153 == true) goto L215;
        if (r310.f330905b.a() == false) goto L215;
        String r154 = r310.f330908e;
        if (r154 != null) goto L58;
    L60:
        r154 = null;
    L61:
        if (r154 == null) goto L63;
        bs8.a r155 = r310.f330905b.f20308b;
        if (r155 == null) goto L71;
        String r156 = r155.f20302g;
        if (r156 == null) goto L71;
        if ((!StringsKt.isBlank(r156)) == false) goto L71;
    L72:
        if (r105 == null) goto L74;
        String r157 = r105.f330886c;
    L75:
        r109 = new hv8.c.b(r154, r156, r157);
        goto L76
    L74:
        r157 = null;
    L71:
        r156 = null;
        goto L72
    L63:
        return h(r310, BrowserTakeoverEntryMonitor.Reason.DEVICE_ID_MISSING);
    L58:
        if ((!StringsKt.isBlank(r154)) == false) goto L60;
    L215:
        return h(r310, BrowserTakeoverEntryMonitor.Reason.TARGET_UNAVAILABLE);
    L49:
        if (r105.f330884a != true) goto L51;
        r153 = true;
        goto L52
    L34:
        if (r105.f330884a != true) goto L36;
        r106 = true;
    L217:
        if (r100 == null) goto L219;
        BrowserTakeoverEntryMonitor.Reason r158 = BrowserTakeoverEntryMonitor.Reason.INVALID_REQUEST;
        Intrinsics.checkNotNullParameter(r158, "reason");
        r100.b("fail", r158);
    L219:
        t19.s.f544207a.getClass();
        t19.s.s(r101, R.string.larus_toast_fail_retry);
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r159 = r310.f330914k;
        if (r159 == null) goto L223;
        r159.invoke(new com.larus.bmhome.taskskill.service.k.b("invalid_browser_request"));
    L223:
        return new p(false, false);
    L19:
        if ((!StringsKt.isBlank(r104)) == true) goto L21;
    L23:
        boolean r160 = false;
    L24:
        if (r160 == false) goto L26;
        r110 = r104;
        goto L27
    L21:
        if (Intrinsics.areEqual(r104, "null") == true) goto L23;
        r160 = true;
        goto L24
    L7:
        if (r101.isFinishing() == true) goto L13;
        if (r101.getSupportFragmentManager().isStateSaved() == true) goto L13;
        if (r101.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L13;
        r102 = true;
    L225:
        if (r100 == null) goto L227;
        BrowserTakeoverEntryMonitor.Reason r161 = BrowserTakeoverEntryMonitor.Reason.ACTIVITY_UNAVAILABLE;
        Intrinsics.checkNotNullParameter(r161, "reason");
        r100.b("fail", r161);
    L227:
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r162 = r310.f330914k;
        if (r162 == null) goto L231;
        r162.invoke(new com.larus.bmhome.taskskill.service.k.b("activity_unavailable"));
    L231:
        return new p(false, false);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void a(o r100, Function1<? super Continuation<? super dm9.a<Unit>>, ? extends Object> r101) {
        IQuickReplyClickInterceptor.DefaultImpls.e(r100, r101);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p b(o r100, boolean r101) {
        return IQuickReplyClickInterceptor.DefaultImpls.b(r100, r101);
    }

    public final p h(o r100, BrowserTakeoverEntryMonitor.Reason r101) {
        boolean r102 = IQuickReplyClickInterceptor.DefaultImpls.d(this, r100.f330906c, r100.f330911h, r100.f330913j, r100.f330916m, r100.f330917n, r100.f330918o);
        BrowserTakeoverEntryMonitor r103 = r100.f330919p;
        if (r103 == null) goto L21;
        if (r101 != null) goto L19;
        BrowserTakeoverOpenResult r104 = r103.f330873d;
        if (r104 != null) goto L8;
        int r105 = -1;
    L9:
        switch(r105) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L10:
        BrowserTakeoverEntryMonitor.Reason r106 = BrowserTakeoverEntryMonitor.Reason.OPEN_REJECTED;
    L18:
        r103.a(r102, r106);
        goto L21
    L11:
        r106 = BrowserTakeoverEntryMonitor.Reason.SERVICE_UNAVAILABLE;
        goto L18
    L12:
        r106 = BrowserTakeoverEntryMonitor.Reason.PAGE_OPEN_FAILED;
        goto L18
    L13:
        r106 = BrowserTakeoverEntryMonitor.Reason.SESSION_BUSY;
        goto L18
    L14:
        r106 = BrowserTakeoverEntryMonitor.Reason.INVALID_REQUEST;
        goto L18
    L15:
        r106 = BrowserTakeoverEntryMonitor.Reason.TARGET_DISABLED;
        goto L18
    L16:
        r106 = BrowserTakeoverEntryMonitor.Reason.EXPERIMENT_DISABLED;
        goto L18
    L17:
        r106 = BrowserTakeoverEntryMonitor.Reason.ACTIVITY_UNAVAILABLE;
        goto L18
    L8:
        r105 = BrowserTakeoverEntryMonitor.b.f330876a[r104.ordinal()];
        goto L9
    L19:
        r103.a(r102, r101);
    L21:
        return IQuickReplyClickInterceptor.DefaultImpls.b(r100, r102);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean d(FragmentActivity r100, String r101, Integer r102, String r103, String r104, String r105) {
        return IQuickReplyClickInterceptor.DefaultImpls.d(this, r100, r101, r102, r103, r104, r105);
    }
}
