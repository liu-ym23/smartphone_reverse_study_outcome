package com.bytedance.ee.bear.wikiv2.selector;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.framework.mvp.BaseModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t extends BaseModel implements iq5.n {
    public final SelectorConfig a;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ t a;

        public a(t r1) {
            this.a = r1;
        }

        public final Object apply(Object r6) {
            RecentOperationResult r7 = (RecentOperationResult) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            this.a.getClass();
            if (AppInfoUtils.f().booleanValue() == false) goto L15;
            ArrayList<RecentOperationResult.a> r0 = ((RecentOperationResult.Data) ((Result) r7).data).getRecentList();
            if (r0 == null) goto L15;
            RecentOperationResult.Data r1 = (RecentOperationResult.Data) ((Result) r7).data;
            ArrayList r2 = new ArrayList();
            Iterator<T> r3 = r0.iterator();
        L10:
            if (r3.hasNext() == false) goto L14;
            T r4 = r3.next();
            if ((!(((RecentOperationResult.a) r4) instanceof RecentOperationResult.WikiInfo)) == false) goto L10;
            r2.add(r4);
            goto L10
        L14:
            r1.setRecentList(new ArrayList(r2));
        L15:
            return r7;
        }
    }

    @Override // iq5.n
    public final Flowable<RecentOperationResult> F0() {
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r1 = new NetService.f("/space/api/bff/workspace/recent_operation");
        r1.b("filter", this.a.f.getFilter());
        r1.b("action", this.a.a.getAction());
        ((NetService.e) r1).c = 2;
        return r0.Vc(new s()).a(r1).map(new a(this));
    }

    @Override // iq5.n
    public final Flowable<DocumentListInfo> P6() {
        qc5.a.j();
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r1 = new NetService.f("/space/api/explorer/v2/recent/folder_path/");
        ((NetService.e) r1).c = 2;
        return r0.Vc(new iq5.s()).a(r1);
    }

    public t(SelectorConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "selectorConfig");
        this.a = r2;
    }
}
