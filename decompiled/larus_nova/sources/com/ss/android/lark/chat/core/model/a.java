package com.ss.android.lark.chat.core.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import f5b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import x4b.a;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a<T extends f5b.b, PageData extends x4b.a<T>> extends PageLoader<c, PageData> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f414766b = 30;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.core.model.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C4847a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f414767a = null;

        static {
            int[] r100 = new int[MessageFetchScene.values().length];
            f414767a = r100;
            r100[MessageFetchScene.FIRST_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f414767a[MessageFetchScene.SPECIFIED_POSITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f414767a[MessageFetchScene.PREVIOUS_PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f414767a[MessageFetchScene.NEXT_PAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public abstract String b();

    public abstract int c(T r100);

    public abstract String d();

    public abstract x4b.a f(MessageFetchScene r100, int r101, int r102, int r103, int r104, ChannelDataFetcherStrategy r105, String r106);

    public a(Executor r100) {
        super(r100);
        if (DevicePerfManager.b.f432386a.f432372e.f20370h == false) goto L6;
        f414766b = 10;
        return;
    }

    public final void e(MessageFetchScene r110, int r210, int r211, ChannelDataFetcherStrategy r212, PageLoader.a<PageData> r213) {
        long r111 = System.currentTimeMillis();
        String r100 = com.ss.android.lark.sdk.a.a();
        int r101 = C4847a.f414767a[r110.ordinal()];
        if (r101 != 1) goto L5;
    L7:
        int r102 = 5;
    L8:
        Log.i(d(), "load: fetchScene = [" + r110 + "], position = [" + r210 + "], pageSize = [" + r211 + "], strategy = [" + r212 + "]");
        x4b.a r103 = f(r110, r210, r211, r102, f414766b, r212, r100);
        long r104 = System.currentTimeMillis() - r111;
        StringBuilder r105 = new StringBuilder("load success, total cost = [");
        StringBuilder r106 = new StringBuilder();
        r106.append(r104);
        r106.append("ms], channelId = [");
        r105.append(r106.toString());
        r105.append(b());
        r105.append("], type = [");
        r105.append(r110.getDesc());
        r105.append("], start position = [");
        r105.append(r210);
        if (r103 != null) goto L11;
    L14:
        r105.append("], ");
        if (r103 != null) goto L17;
        String r107 = "page data is null";
    L18:
        r105.append(r107);
    L19:
        Log.i(d(), r105.toString());
        if (r213 == null) goto L25;
        if (r103 == null) goto L23;
        r213.a(r103);
        return;
    L23:
        r213.onError(new Throwable("load data failed :" + r110.getDesc() + " " + r210 + " " + r211));
        return;
    L25:
        return;
    L17:
        r107 = "data list is empty";
        goto L18
    L11:
        if (CollectionUtils.isEmpty(r103.f562457a) == true) goto L14;
        int r108 = c((f5b.b) ListProtector.get(r103.f562457a, 0));
        List<T> r109 = r103.f562457a;
        int r112 = c((f5b.b) ListProtector.get(r109, ((ArrayList) r109).size() - 1));
        r105.append("], start = [");
        r105.append(r108);
        r105.append("], end = [");
        r105.append(r112);
        r105.append("], size = [");
        r105.append(((ArrayList) r103.f562457a).size());
        r105.append("]");
        goto L19
    L5:
        if (r101 == 2) goto L7;
        r102 = 0;
        goto L8
    }
}
