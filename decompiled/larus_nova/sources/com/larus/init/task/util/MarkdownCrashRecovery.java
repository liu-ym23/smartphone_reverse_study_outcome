package com.larus.init.task.util;

import com.larus.bmhome.chat.interceptor.IMessageRenderInterceptor;
import com.larus.bootprotector.IBootProtectorBizCallback;
import com.larus.bootprotector.entity.LastException;
import com.larus.settings.provider.bootprotector.CrashPortrait;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pt9.g;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/larus/init/task/util/MarkdownCrashRecovery;", "Lcom/larus/bootprotector/IBootProtectorBizCallback;", "<init>", "()V", "markdownRenderCrashConfig", "Lcom/larus/settings/opt/launch/MarkdownRenderCrashConfig;", "getMarkdownRenderCrashConfig", "()Lcom/larus/settings/opt/launch/MarkdownRenderCrashConfig;", "markdownRenderCrashConfig$delegate", "Lkotlin/Lazy;", "getBizTag", "", "getMinRequiredCrashCount", "", "getObservedCrashPortrait", "", "Lcom/larus/settings/provider/bootprotector/CrashPortrait;", "onAppCrash", "", "currentCrashCount", "matchedPortrait", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "Lcom/larus/bootprotector/entity/LastException;", "onAppRestartAfterCrash", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownCrashRecovery implements IBootProtectorBizCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f351460b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f351461a;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final void c(int r100, CrashPortrait r101, LastException r102) {
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final String getBizTag() {
        return "MarkdownCrashRecovery";
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final List<CrashPortrait> b() {
        ArrayList r100 = new ArrayList();
        HashMap<String, String> r101 = ((g) this.f351461a.getValue()).c();
        if (r101 == null) goto L7;
        boolean r102 = true;
        if ((!r101.isEmpty()) != true) goto L7;
    L8:
        if (r102 == false) goto L15;
        HashMap<String, String> r103 = ((g) this.f351461a.getValue()).c();
        if (r103 == null) goto L15;
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        Map.Entry<String, String> r105 = r104.next();
        CrashPortrait r110 = new CrashPortrait("java", null, r105.getKey(), r105.getValue(), null, null, null, null, null, null, null, null, 4082, null);
        CrashPortrait r106 = new CrashPortrait("anr", null, r105.getKey(), r105.getValue(), null, null, null, null, null, null, null, null, 4082, null);
        r100.add(r110);
        r100.add(r106);
    L15:
        return r100;
    L7:
        r102 = false;
        goto L8
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final int d() {
        Integer r100 = ((g) this.f351461a.getValue()).a();
        if (r100 != null) goto L7;
        return 1;
    L7:
        return r100.intValue();
    }

    public MarkdownCrashRecovery() {
        this.f351461a = LazyKt.lazy(new kg9.g());
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final void a(LastException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final void e(LastException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
    }

    @Override // com.larus.bootprotector.IBootProtectorBizCallback
    public final void f(int r100, CrashPortrait r101, LastException r102) {
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        nu8.a.e("MarkdownCrashRecovery", "onAppCrash! \ncurrentCrashCount = " + r100 + ", \nmatchedPortrait = " + r101 + ", \nlastException = " + r102);
        IMessageRenderInterceptor r103 = IMessageRenderInterceptor.f303337a;
        String r104 = "";
        if (r101 == null) goto L6;
        String r105 = r101.getClazzName();
        if (r105 == null) goto L6;
    L7:
        if (r101 == null) goto L12;
        String r106 = r101.getMethodName();
        if (r106 == null) goto L12;
        r104 = r106;
    L12:
        r103.b(r105, r104, r102.getCrashType().toString());
        return;
    L6:
        r105 = "";
        goto L7
    }
}
