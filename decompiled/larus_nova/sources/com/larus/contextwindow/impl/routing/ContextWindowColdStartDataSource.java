package com.larus.contextwindow.impl.routing;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.ContextWindowMode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: classes27.dex */
public final class ContextWindowColdStartDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f330403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<IConversationRepoService> f330404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<IChatRepoService> f330405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<IActionBarService> f330406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<String, List<String>> f330407e;

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.routing.ContextWindowColdStartDataSource$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
        public AnonymousClass1(Object r100) {
            super(0, r100, y29.b.class, "isEnabled", "isEnabled()Z", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            ((y29.b) this.receiver).getClass();
            return Boolean.valueOf(y29.b.a());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.routing.ContextWindowColdStartDataSource$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<String, List<? extends String>> {
        public AnonymousClass5(Object r100) {
            super(1, r100, vc8.d.class, MonitorConstants.CONNECT_TYPE_GET, "get(Ljava/lang/String;)Ljava/util/List;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<String> invoke2(String r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            ((vc8.d) this.receiver).getClass();
            return vc8.d.a(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ List<? extends String> invoke(String r100) {
            return invoke2(r100);
        }
    }

    public static final class a {
    }

    static {
    }

    public ContextWindowColdStartDataSource() {
        this(null);
    }

    public ContextWindowColdStartDataSource(Object r100) {
        AnonymousClass1 r101 = new AnonymousClass1(y29.b.f565722a);
        Function0<IConversationRepoService> r102 = new com.larus.contextwindow.impl.routing.a();
        Function0<IChatRepoService> r103 = new b();
        Function0<IActionBarService> r104 = new c();
        AnonymousClass5 r105 = new AnonymousClass5(vc8.d.f554129a);
        Intrinsics.checkNotNullParameter(r101, "featureEnabled");
        Intrinsics.checkNotNullParameter(r102, "conversationService");
        Intrinsics.checkNotNullParameter(r103, "chatService");
        Intrinsics.checkNotNullParameter(r104, "actionBarService");
        Intrinsics.checkNotNullParameter(r105, "cachedBotIds");
        this.f330403a = r101;
        this.f330404b = r102;
        this.f330405c = r103;
        this.f330406d = r104;
        this.f330407e = r105;
    }

    public final Object a(ContextWindowEntryRequest r210, Continuation<? super v29.a> r211) {
        ContextWindowEntryRequest r100 = r210;
        if ((r211 instanceof ContextWindowColdStartDataSource$load$1) == false) goto L7;
        ContextWindowColdStartDataSource$load$1 r101 = (ContextWindowColdStartDataSource$load$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        ReplyOption r111 = null;
        if (r104 == 0) goto L22;
        if (r104 == 1) goto L19;
        if (r104 != 2) goto L18;
        r100 = (ContextWindowEntryRequest) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
    L49:
        List r105 = (List) r103;     // Catch: Throwable -> L15
    L51:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L15
    L55:
        if (Result.m9455isFailureimpl(r106) == false) goto L57;
        r106 = null;
    L57:
        List r107 = (List) r106;
        if (r107 != null) goto L60;
        r107 = CollectionsKt.emptyList();
    L60:
        List r108 = CollectionsKt.take(r107, 300);
        String r109 = r100.f330237c;
        if (r109 != null) goto L111;
        List<String> r112 = this.f330407e.invoke(r100.f330235a);
        if (r112 == null) goto L65;
        r109 = (String) CollectionsKt.firstOrNull(r112);
        goto L111
    L65:
        r109 = null;
    L111:
        IActionBarService r113 = this.f330406d.invoke();     // Catch: Throwable -> L72
        if (r113 == null) goto L69;
        List<z0> r114 = r113.f(r109);     // Catch: Throwable -> L72
    L70:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L72
    L75:
        if (Result.m9455isFailureimpl(r115) == false) goto L77;
        r115 = null;
    L77:
        List r116 = (List) r115;
        if (r116 != null) goto L80;
        r116 = CollectionsKt.emptyList();
    L80:
        List r117 = r116;
        Object r118 = Result.m9449constructorimpl(IConvReplyModeRecordHelper.f312153a.b(r100.f330235a));     // Catch: Throwable -> L83
    L86:
        if (Result.m9455isFailureimpl(r118) == false) goto L88;
        r118 = null;
    L88:
        ReplyOption r119 = (ReplyOption) r118;
        if (r119 != null) goto L103;
        Iterator r120 = r117.iterator();
    L92:
        if (r120.hasNext() == false) goto L96;
        Object r121 = r120.next();
        if (Intrinsics.areEqual(((z0) r121).f295606b, "coco_deep_thinking") == false) goto L92;
    L97:
        z0 r122 = (z0) r121;
        if (r122 == null) goto L102;
        p0 r123 = r122.f295619o;
        if (r123 == null) goto L102;
        r111 = r123.a();
    L102:
        ReplyOption r124 = r111;
    L104:
        int r125 = com.larus.contextwindow.impl.data.a.f330317a;
        return com.larus.contextwindow.impl.data.a.a(true, r100.f330239e, r100.f330235a, r100.f330236b, r108, r124, r117);
    L96:
        r121 = null;
        goto L97
    L103:
        r124 = r119;
    L83:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L86
    L69:
        r114 = null;
    L72:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L75
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r100 = (ContextWindowEntryRequest) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L35
    L31:
        e r128 = (e) r103;     // Catch: Throwable -> L35
    L33:
        Object r129 = Result.m9449constructorimpl(r128);     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r129) == false) goto L41;
        r129 = null;
    L41:
        if (((e) r129) == null) goto L43;
        IChatRepoService r130 = this.f330405c.invoke();     // Catch: Throwable -> L15
        if (r130 == null) goto L50;
        String r131 = r100.f330235a;     // Catch: Throwable -> L15
        r101.L$0 = r100;     // Catch: Throwable -> L15
        r101.label = 2;     // Catch: Throwable -> L15
        r103 = r130.o1(r131, 300, r101);     // Catch: Throwable -> L15
        if (r103 != r110) goto L49;
        return r110;
    L50:
        r105 = null;
        goto L51
    L43:
        return new v29.a(true, "", r100.f330236b, r100.f330239e, ContextWindowMode.SUPPORTED, null, CollectionsKt.emptyList());
    L22:
        ResultKt.throwOnFailure(r103);
        if (this.f330403a.invoke().booleanValue() == false) goto L25;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L35
        IConversationRepoService r133 = this.f330404b.invoke();     // Catch: Throwable -> L35
        if (r133 == null) goto L32;
        String r134 = r100.f330235a;     // Catch: Throwable -> L35
        r101.L$0 = r100;     // Catch: Throwable -> L35
        r101.label = 1;     // Catch: Throwable -> L35
        r103 = IConversationRepoService.a.c(r133, r134, true, null, r101, 4);     // Catch: Throwable -> L35
        if (r103 != r110) goto L31;
        return r110;
    L32:
        r128 = null;
        goto L33
    L25:
        return new v29.a(false, r100.f330235a, r100.f330236b, r100.f330239e, ContextWindowMode.SUPPORTED, null, CollectionsKt.emptyList());
    L35:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L15:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new ContextWindowColdStartDataSource$load$1(this, r211);
        goto L8
    }
}
