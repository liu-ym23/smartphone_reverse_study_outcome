package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.jni.bean.OmniArchiveStatus;
import com.larus.im.internal.jni.bean.OmniConversationSortType;
import com.larus.im.internal.jni.bean.OmniPinStatus;
import com.larus.im.internal.jni.bean.OmniSelectConversationGroupRequest;
import com.larus.im.internal.jni.bean.OmniSelectProjectConversationListRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class ImSdkSideBarProjectImService implements v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImSdkSideBarProjectImService f345306a = null;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OmniConversationSortType f345307a;

        public a(OmniConversationSortType r100) {
            this.f345307a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(p.b((wc9.e) r100, this.f345307a)), Long.valueOf(p.b((wc9.e) r101, this.f345307a)));
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f345308a;

        public b(a r100) {
            this.f345308a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f345308a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(((wc9.e) r100).f559198a, ((wc9.e) r101).f559198a);
        }
    }

    public static final class c implements IIMCallback<wc9.s> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<wc9.s> f345309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f345310b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !y0.a();
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            int r101 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
            com.larus.home.impl.main.side_bar.feed.arch.t.a("project_conversation_query_fail", "project=" + com.larus.home.impl.main.side_bar.feed.arch.t.d(this.f345310b) + " code=" + r100.getCode());
            if (this.f345309a.isActive() == false) goto L6;
            this.f345309a.resumeWith(Result.m9449constructorimpl(null));
            return;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(wc9.s r100) {
            wc9.s r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            if (this.f345309a.isActive() == false) goto L6;
            this.f345309a.resumeWith(Result.m9449constructorimpl(r101));
            return;
        }

        public c(kotlinx.coroutines.j r100, String r101) {
            this.f345309a = r100;
            this.f345310b = r101;
        }
    }

    static {
        f345306a = new ImSdkSideBarProjectImService();
    }

    public ImSdkSideBarProjectImService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.v0
    public final Object a(String r210, long r211, String r212, int r213, OmniConversationSortType r310, Continuation<? super t0> r311) {
        if ((r311 instanceof ImSdkSideBarProjectImService$getConversationListByProjectId$1) == false) goto L7;
        ImSdkSideBarProjectImService$getConversationListByProjectId$1 r100 = (ImSdkSideBarProjectImService$getConversationListByProjectId$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r100.J$0;
        OmniConversationSortType r106 = (OmniConversationSortType) r100.L$2;
        String r107 = (String) r100.L$1;
        String r108 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L20:
        wc9.s r109 = (wc9.s) r102;
        if (r109 == null) goto L23;
        List<wc9.l> r110 = r109.f559261a;
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L26:
        if (r112.hasNext() == false) goto L30;
        wc9.e r113 = ((wc9.l) r112.next()).f559248a;
        if (r113 == null) goto L26;
        r111.add(r113);
        goto L26
    L30:
        wc9.e r114 = (wc9.e) CollectionsKt.minWithOrNull(r111, new b(new a(r106)));
        List<wc9.l> r115 = r109.f559261a;
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r115.iterator();
    L31:
        Object r118 = null;
        if (r117.hasNext() == false) goto L54;
        wc9.l r119 = (wc9.l) r117.next();
        wc9.e r120 = r119.f559248a;
        if (r120 == null) goto L52;
        String r121 = r120.f559198a;
        if (r121 == null) goto L52;
        if (r121.length() <= 0) goto L40;
        boolean r122 = true;
    L41:
        if (r122 == true) goto L44;
        r121 = null;
    L44:
        if (r121 == null) goto L52;
        List<Message> r123 = r119.f559249b;
        if (r123 == null) goto L52;
        Message r124 = (Message) CollectionsKt.firstOrNull(r123);
        if (r124 == null) goto L52;
        r118 = TuplesKt.to(r121, r124);
        goto L52
    L40:
        r122 = false;
    L52:
        if (r118 == null) goto L31;
        r116.add(r118);
        goto L31
    L54:
        Map r125 = MapsKt.toMap(r116);
        boolean r126 = r109.f559263c;
        if (r114 == null) goto L57;
        r105 = p.b(r114, r106);
    L57:
        if (r114 == null) goto L59;
        r118 = r114.f559198a;
    L59:
        if (r118 != null) goto L62;
        r118 = "";
    L62:
        return new t0(r111, r125, r126, r105, r118);
    L23:
        return new t0(CollectionsKt.emptyList(), MapsKt.emptyMap(), false, r105, "");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        r100.L$0 = r210;
        r100.L$1 = r212;
        r100.L$2 = r310;
        r100.J$0 = r211;
        r100.I$0 = r213;
        r100.label = 1;
        kotlinx.coroutines.j r127 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r127.C();
        com.larus.im.d.d().selectProjectConversationList(new OmniSelectProjectConversationListRequest(r210, new OmniSelectConversationGroupRequest(OmniPinStatus.PinStatus_UNPIN, OmniArchiveStatus.ArchiveStatus_NO_BELONG_ARCHIVE, true, r211, r212, r310, RangesKt.coerceAtLeast(r213, 1))), new c(r127, r210));
        r102 = r127.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L17:
        if (r102 != r103) goto L19;
        return r103;
    L19:
        r105 = r211;
        r106 = r310;
    L7:
        r100 = new ImSdkSideBarProjectImService$getConversationListByProjectId$1(this, r311);
        goto L8
    }
}
