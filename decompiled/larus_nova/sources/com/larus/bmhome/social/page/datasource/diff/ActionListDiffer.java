package com.larus.bmhome.social.page.datasource.diff;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class ActionListDiffer<DATA> extends b<DATA, com.larus.bmhome.social.page.datasource.event.c<DATA>> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f314000g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<com.larus.bmhome.social.page.datasource.event.c<DATA>, Unit> f314001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends DATA> f314002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f314003f;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.b
    public final List<DATA> c() {
        return com.larus.utils.h.d(this.f314002e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(List<? extends DATA> r100) {
        List<? extends DATA> r101 = this.f314002e;
        this.f314002e = r100;
        if (Intrinsics.areEqual(r100, r101) == true) goto L6;
        d(r100);
        return;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.b
    public final /* bridge */ /* synthetic */ Object b(com.larus.bmhome.social.page.datasource.event.a r100, Continuation r101) {
        return e((com.larus.bmhome.social.page.datasource.event.c) r100, r101);
    }

    public final Object e(com.larus.bmhome.social.page.datasource.event.c<DATA> r110, Continuation<? super Unit> r210) {
        com.larus.bmhome.social.page.datasource.event.c<DATA> r100 = r110;
        if ((r210 instanceof ActionListDiffer$collectEvent$1) == false) goto L7;
        ActionListDiffer$collectEvent$1 r101 = (ActionListDiffer$collectEvent$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (com.larus.bmhome.social.page.datasource.event.c) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L43:
        this.f314003f = r100.f314034b;
        this.f314001d.invoke(r100);
        if (r100.f314036d.length() <= 0) goto L46;
        boolean r111 = true;
    L47:
        if (r111 == false) goto L54;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("refreshTrace end=applied rt=");
        r107.append(r100.f314036d);
        r107.append(" version=");
        r107.append(r100.f314034b);
        r107.append(" size=");
        r107.append(r100.f314033a.size());
        r107.append(" cost=");
        long r108 = com.larus.bmhome.social.page.datasource.event.d.b(r100.f314036d);
        if (r108 < 0) goto L51;
        long r109 = System.currentTimeMillis() - r108;
    L52:
        r107.append(r109);
        r106.w("MsgRefreshFlow_ActionListDiffer", r107.toString());
        goto L54
    L51:
        r109 = -1;
    L54:
        return Unit.INSTANCE;
    L46:
        r111 = false;
        goto L47
    L16:
        ResultKt.throwOnFailure(r103);
        long r112 = this.f314003f;
        long r113 = r100.f314034b;
        if (1 <= r113) goto L19;
    L21:
        boolean r114 = false;
    L22:
        if (r114 == false) goto L36;
        if (r100.f314036d.length() <= 0) goto L26;
        boolean r115 = true;
    L27:
        if (r115 == false) goto L34;
        FLogger r116 = FLogger.f375446a;
        StringBuilder r117 = new StringBuilder("refreshTrace end=dropped rt=");
        r117.append(r100.f314036d);
        r117.append(" version=");
        r117.append(r100.f314034b);
        r117.append(" handledVersion=");
        r117.append(this.f314003f);
        r117.append(" cost=");
        long r118 = com.larus.bmhome.social.page.datasource.event.d.b(r100.f314036d);
        if (r118 < 0) goto L31;
        long r119 = System.currentTimeMillis() - r118;
    L32:
        r117.append(r119);
        r116.w("MsgRefreshFlow_ActionListDiffer", r117.toString());
        goto L34
    L31:
        r119 = -1;
    L34:
        return Unit.INSTANCE;
    L26:
        r115 = false;
        goto L27
    L36:
        if ((r113 - r112) == 1) goto L40;
        r101.L$0 = r100;
        r101.label = 1;
        if (g(r100, r101) != r104) goto L43;
        return r104;
    L40:
        r101.L$0 = r100;
        r101.label = 2;
        if (f(r100, r101) != r104) goto L43;
        return r104;
    L19:
        if (r113 >= r112) goto L21;
        r114 = true;
    L7:
        r101 = new ActionListDiffer$collectEvent$1(this, r210);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00e3 -> B:20:0x0066). Please report as a decompilation issue!!! */
    public final Object f(com.larus.bmhome.social.page.datasource.event.c<DATA> r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ActionListDiffer$handleAction$1) == false) goto L7;
        ActionListDiffer$handleAction$1 r100 = (ActionListDiffer$handleAction$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        ActionListDiffer<DATA> r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L17;
        if (r105 == 3) goto L17;
        if (r105 != 4) goto L16;
        Iterator r106 = (Iterator) r100.L$1;
        com.larus.bmhome.social.page.datasource.event.c<DATA> r107 = (com.larus.bmhome.social.page.datasource.event.c) r100.L$0;
        ResultKt.throwOnFailure(r103);
        com.larus.bmhome.social.page.datasource.event.c<DATA> r108 = r107;
    L19:
        ActionListDiffer r109 = r102;
    L21:
        if (r106.hasNext() == false) goto L53;
        com.larus.bmhome.social.page.datasource.event.b r112 = (com.larus.bmhome.social.page.datasource.event.b) r106.next();
        if ((r112 instanceof com.larus.bmhome.social.page.datasource.event.b.a) == true) goto L24;
        if ((r112 instanceof com.larus.bmhome.social.page.datasource.event.b.c) == true) goto L34;
        if ((r112 instanceof com.larus.bmhome.social.page.datasource.event.b.C4102b) == true) goto L41;
        if ((r112 instanceof com.larus.bmhome.social.page.datasource.event.b.d) == false) goto L21;
        r100.L$0 = r108;
        r100.L$1 = r106;
        r100.label = 4;
        if (r109.g(r108, r100) != r104) goto L21;
        return r104;
    L41:
        int r113 = r108.f314033a.size();
        com.larus.bmhome.social.page.datasource.event.b.C4102b r114 = (com.larus.bmhome.social.page.datasource.event.b.C4102b) r112;
        r114.getClass();
        if ((r113 + 0) == r109.f314002e.size()) goto L46;
        FLogger r115 = FLogger.f375446a;
        StringBuilder r116 = new StringBuilder("convert REMOVED to REFRESH rt=");
        r116.append(r108.f314036d);
        r116.append(", because newData(");
        r116.append(r108.f314033a.size());
        r116.append(") + delta(0) != dataSource(");
        r114.getClass();
        r116.append(r109.f314002e.size());
        r116.append(')');
        r115.i("MsgRefreshFlow_ActionListDiffer", r116.toString());
        r100.L$0 = r108;
        r100.L$1 = r106;
        r100.label = 3;
        if (r109.g(r108, r100) != r104) goto L21;
        return r104;
    L46:
        r109.h(r108.f314033a);
        ListUpdateCallback r117 = r109.f314016b;
        r114.getClass();
        r114.getClass();
        r117.onRemoved(0, 0);
        goto L21
    L34:
        if (r108.f314033a.size() == r109.f314002e.size()) goto L38;
        FLogger.f375446a.i("MsgRefreshFlow_ActionListDiffer", "convert UPDATE to REFRESH rt=" + r108.f314036d + ", because newData(" + r108.f314033a.size() + ") != dataSource(" + r109.f314002e.size() + ')');
        r100.L$0 = r108;
        r100.L$1 = r106;
        r100.label = 2;
        if (r109.g(r108, r100) != r104) goto L21;
        return r104;
    L38:
        r109.h(r108.f314033a);
        ListUpdateCallback r118 = r109.f314016b;
        com.larus.bmhome.social.page.datasource.event.b.c r119 = (com.larus.bmhome.social.page.datasource.event.b.c) r112;
        r119.getClass();
        r119.getClass();
        r118.onChanged(0, 0, null);
        goto L21
    L24:
        int r120 = r108.f314033a.size();
        com.larus.bmhome.social.page.datasource.event.b.a r121 = (com.larus.bmhome.social.page.datasource.event.b.a) r112;
        r121.getClass();
        if ((r120 - 0) == r109.f314002e.size()) goto L29;
        FLogger r122 = FLogger.f375446a;
        StringBuilder r123 = new StringBuilder("convert INSERTED to REFRESH rt=");
        r123.append(r108.f314036d);
        r123.append(", because newData(");
        r123.append(r108.f314033a.size());
        r123.append(") - delta(0) != dataSource(");
        r121.getClass();
        r123.append(r109.f314002e.size());
        r123.append(')');
        r122.i("MsgRefreshFlow_ActionListDiffer", r123.toString());
        r100.L$0 = r108;
        r100.L$1 = r106;
        r100.label = 1;
        if (r109.g(r108, r100) != r104) goto L21;
        return r104;
    L29:
        r109.h(r108.f314033a);
        ListUpdateCallback r124 = r109.f314016b;
        r121.getClass();
        r121.getClass();
        r124.onInserted(0, 0);
        goto L21
    L53:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r106 = (Iterator) r100.L$1;
        com.larus.bmhome.social.page.datasource.event.c<DATA> r125 = (com.larus.bmhome.social.page.datasource.event.c) r100.L$0;
        ResultKt.throwOnFailure(r103);
        r108 = r125;
        r109 = r102;
        goto L21
    L18:
        ResultKt.throwOnFailure(r103);
        r108 = r110;
        r106 = r108.f314035c.iterator();
    L7:
        r102 = this;
        r100 = new ActionListDiffer$handleAction$1(r102, r111);
        goto L8
    }

    public final Object g(com.larus.bmhome.social.page.datasource.event.c<DATA> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ActionListDiffer$refresh$1) == false) goto L7;
        ActionListDiffer$refresh$1 r102 = (ActionListDiffer$refresh$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (com.larus.bmhome.social.page.datasource.event.c) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        h(r100.f314033a);
        ((DiffUtil.DiffResult) r104).dispatchUpdatesTo(this.f314016b);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        FLogger.f375446a.i("MsgRefreshFlow_ActionListDiffer", "differ refresh rt=" + r100.f314036d + " version=" + r100.f314034b + " old=" + this.f314002e.size() + " new=" + r100.f314033a.size());
        CoroutineDispatcher r107 = Dispatchers.getIO();
        ActionListDiffer$refresh$result$1 r108 = new ActionListDiffer$refresh$result$1(this, r100, null);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = BuildersKt.withContext(r107, r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new ActionListDiffer$refresh$1(this, r101);
        goto L8
    }

    public ActionListDiffer(com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterListUpdateCallback r100, DiffUtil.ItemCallback r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "updateCallback");
        Intrinsics.checkNotNullParameter(r101, "diffCallback");
        Intrinsics.checkNotNullParameter(r102, "onEventApplied");
        super(r101, r100);
        this.f314001d = r102;
        this.f314002e = CollectionsKt.emptyList();
    }
}
