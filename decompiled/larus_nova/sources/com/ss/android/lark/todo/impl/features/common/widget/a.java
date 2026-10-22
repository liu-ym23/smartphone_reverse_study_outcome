package com.ss.android.lark.todo.impl.features.common.widget;

import android.content.Context;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskUDAvatarList f442515a;

    public a(TaskUDAvatarList r100) {
        this.f442515a = r100;
    }

    public final void a() {
        this.f442515a.removeAllViews();
        TaskUDAvatarList.a<?> r100 = this.f442515a.getAdapter();
        if (r100 == null) goto L5;
        int r101 = r100.getCount();
    L6:
        int r102 = Math.min(r101, this.f442515a.getMaxCount());
        int r103 = 0;
    L7:
        TaskUDAvatar r104 = null;
        if (r103 >= r102) goto L15;
        TaskUDAvatarList r105 = this.f442515a;
        TaskUDAvatarList.a<?> r106 = r105.getAdapter();
        if (r106 == null) goto L14;
        Context r107 = this.f442515a.getContext();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r106.getItem(r103) == null) goto L14;
        TaskUDAvatar r108 = new TaskUDAvatar(r107);
        r108.setAvatarSize(r106.f442505b);
        r106.a(r108, r103);
        r104 = r108;
    L14:
        TaskUDAvatarList.a(r105, r104);
        r103 = r103 + 1;
        goto L7
    L15:
        TaskUDAvatarList.a<?> r109 = this.f442515a.getAdapter();
        if (r109 == null) goto L18;
        int r110 = r109.getCount();
    L20:
        if (r110 != (this.f442515a.getMaxCount() + 1)) goto L27;
        TaskUDAvatarList r111 = this.f442515a;
        TaskUDAvatarList.a<?> r112 = r111.getAdapter();
        if (r112 == null) goto L26;
        Context r113 = this.f442515a.getContext();
        int r114 = this.f442515a.getMaxCount();
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r112.getItem(r114) == null) goto L26;
        TaskUDAvatar r115 = new TaskUDAvatar(r113);
        r115.setAvatarSize(r112.f442505b);
        r112.a(r115, r114);
        r104 = r115;
    L26:
        TaskUDAvatarList.a(r111, r104);
        return;
    L27:
        TaskUDAvatarList.a<?> r116 = this.f442515a.getAdapter();
        if (r116 == null) goto L30;
        int r117 = r116.getCount();
    L32:
        if (r117 <= (this.f442515a.getMaxCount() + 1)) goto L51;
        TaskUDAvatarList r118 = this.f442515a;
        TaskUDAvatarList.a<?> r119 = r118.getAdapter();
        if (r119 == null) goto L44;
        Context r120 = this.f442515a.getContext();
        Intrinsics.checkNotNullParameter(r120, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<? extends Object> r121 = r119.f442504a;
        if (r121 == null) goto L38;
        int r122 = r121.size();
    L39:
        int r123 = r122 - r119.f442507d;
        TaskUDTextAvatar r124 = new TaskUDTextAvatar(r120);
        r124.setBorderStyle(0);
        if (r123 <= 99) goto L42;
        String r125 = "99+";
    L43:
        r124.setAvatarText(r125);
        r124.setAvatarSize(r119.f442505b);
        r124.setAvatarTextSize(r119.f442506c);
        r124.setTextColor(Integer.valueOf(UDColorUtils.getColor(r120, R.color.text_caption)));
        r124.setAvatarBgColor(UDColorUtils.getColor(r120, R.color.ud_N300));
        r124.setBorderColor(UDColorUtils.getColor(r120, R.color.bg_body));
        r119.b(r124);
        r104 = r124;
        goto L44
    L42:
        r125 = Marker.ANY_NON_NULL_MARKER + r123;
        goto L43
    L38:
        r122 = 0;
    L44:
        TaskUDAvatarList.a(r118, r104);
        return;
    L51:
        return;
    L30:
        r117 = 0;
        goto L32
    L18:
        r110 = 0;
        goto L20
    L5:
        r101 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
