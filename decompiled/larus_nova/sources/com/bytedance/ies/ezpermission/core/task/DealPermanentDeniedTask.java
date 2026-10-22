package com.bytedance.ies.ezpermission.core.task;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.ies.ezpermission.EzPermission;
import com.bytedance.ies.ezpermission.core.e;
import com.bytedance.ies.ezpermission.core.j;
import com.bytedance.ies.ezpermission.core.result.ResultWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class DealPermanentDeniedTask extends BasePermissionTask {
    public DealPermanentDeniedTask(com.bytedance.ies.ezpermission.core.d r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionContext");
        super(r100);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [T, java.util.ArrayList, java.util.Collection] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.ies.ezpermission.core.task.BasePermissionTask
    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof DealPermanentDeniedTask$run$1) == false) goto L7;
        DealPermanentDeniedTask$run$1 r100 = (DealPermanentDeniedTask$run$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        ResultKt.throwOnFailure(r102);
    L142:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Ref.ObjectRef r105 = (Ref.ObjectRef) r100.L$3;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r106 = (List) r100.L$2;
        c r107 = (c) r100.L$1;
        DealPermanentDeniedTask r108 = (DealPermanentDeniedTask) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L121:
        Ref.ObjectRef r111 = r105;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r112 = r106;
        c r113 = r107;
        final DealPermanentDeniedTask r114 = r108;
    L122:
        List<com.bytedance.ies.ezpermission.core.permissions.a> r109 = r113.f248589a;
        List r115 = (List) r111.element;
        ArrayList r116 = new ArrayList();
        Iterator r117 = r115.iterator();
    L124:
        if (r117.hasNext() == false) goto L128;
        Object r118 = r117.next();
        if (Boxing.boxBoolean(((com.bytedance.ies.ezpermission.core.permissions.a) r118).c(r114.f248588b.getContext())).booleanValue() == false) goto L124;
        r116.add(r118);
        goto L124
    L128:
        r109.addAll(r116);
        Iterator<T> r119 = r112.iterator();
    L130:
        if (r119.hasNext() == false) goto L132;
        CollectionsKt.removeAll((List) r119.next(), new DealPermanentDeniedTask$run$$inlined$forEach$lambda$1(r114));
        goto L130
    L132:
        CollectionsKt.removeAll(r112, DealPermanentDeniedTask$run$7.INSTANCE);
    L137:
        Object r120 = null;
    L138:
        r100.L$0 = r120;
        r100.L$1 = r120;
        r100.L$2 = r120;
        r100.L$3 = r120;
        r100.L$4 = r120;
        r100.L$5 = r120;
        r100.label = 4;
        if (r114.a(r100) != r103) goto L142;
        return r103;
    L18:
        Ref.ObjectRef r121 = (Ref.ObjectRef) r100.L$4;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r122 = (List) r100.L$3;
        c r123 = (c) r100.L$2;
        Ref.ObjectRef r124 = (Ref.ObjectRef) r100.L$1;
        DealPermanentDeniedTask r125 = (DealPermanentDeniedTask) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L60:
        boolean r126 = ((Boolean) r102).booleanValue();
        r111 = r121;
        r113 = r123;
    L61:
        r114 = r125;
        r112 = r122;
        if (r126 == false) goto L135;
        n46.a.f517060b.getClass();
        Intrinsics.checkNotNullParameter("Start open setting page", "msg");
        Context r127 = r114.f248588b.getContext();
        Intrinsics.checkNotNullParameter(r127, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r128 = (ArrayList) n46.a.f517059a;
        if (r128.isEmpty() == false) goto L67;
        String r129 = r127.getPackageName();
        Intent r130 = new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionManagerActivity"));
        r130.putExtra("pkg_name", r129);
        r130.putExtra("app_name", r127.getResources().getString(r127.getApplicationInfo().labelRes));
        r130.putExtra("class_name", n46.a.class.getName());
        r128.add(r130);
        Intent r131 = new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionAppAllPermissionActivity"));
        r131.putExtra("packageName", r129);
        r128.add(r131);
        Intent r132 = new Intent().setComponent(new ComponentName(RomUtils.PACKAGE_INSTALLER_GOOGLE, "com.android.packageinstaller.permission.ui.ManagePermissionsActivity"));
        r132.putExtra("android.intent.extra.PACKAGE_NAME", r129);
        r128.add(r132);
    L67:
        String r133 = Build.MANUFACTURER;
        if (r133 == null) goto L134;
        String r134 = r133.toLowerCase();
        if (TextUtils.equals(r134, AppConstants.CHANNEL_OPPO) == false) goto L91;
        if (Build.VERSION.SDK_INT > 23) goto L91;
        Iterator r135 = r128.iterator();
    L75:
        if (r135.hasNext() == false) goto L99;
        Intent r136 = (Intent) r135.next();
        if (r127 == null) goto L87;
        if (r136 == null) goto L87;
        ResolveInfo r137 = r127.getPackageManager().resolveActivity(r136, 1);     // Catch: Exception -> L144
        if (r137 == null) goto L87;
        ActivityInfo r138 = r137.activityInfo;     // Catch: Exception -> L144
        if (r138 == null) goto L87;
        boolean r139 = r138.exported;     // Catch: Exception -> L144
    L88:
        if (r139 == false) goto L75;
        r136.addFlags(268435456);
        Intent r140 = r136;
    L100:
        if (r140 == null) goto L112;
        if (r127 != null) goto L147;
    L109:
        boolean r141 = false;
    L110:
        if (r141 == true) goto L112;
        r140 = null;
        goto L112
    L147:
        ResolveInfo r142 = r127.getPackageManager().resolveActivity(r140, 1);     // Catch: Exception -> L143
        if (r142 == null) goto L109;
        ActivityInfo r143 = r142.activityInfo;     // Catch: Exception -> L143
        if (r143 == null) goto L109;
        r141 = r143.exported;     // Catch: Exception -> L143
    L112:
        if (r140 == null) goto L114;
        Object r144 = null;
    L115:
        ResultWrapper r145 = r114.f248588b.c();
        if (r145 == null) goto L122;
        DealPermanentDeniedTask$run$4 r146 = DealPermanentDeniedTask$run$4.INSTANCE;
        r100.L$0 = r114;
        r100.L$1 = r113;
        r100.L$2 = r112;
        r100.L$3 = r111;
        r100.L$4 = r144;
        r100.L$5 = r144;
        r100.label = 3;
        if (r145.b(r140, null, null, r146, r100) != r103) goto L120;
        return r103;
    L120:
        r105 = r111;
        r106 = r112;
        r107 = r113;
        r108 = r114;
        goto L121
    L114:
        n46.a.f517060b.getClass();
        Intrinsics.checkNotNullParameter(r127, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r147 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r144 = null;
        r147.setData(Uri.fromParts("package", r127.getPackageName(), null));
        r140 = r147;
    L87:
        r139 = false;
    L99:
        r140 = null;
    L91:
        if (TextUtils.equals(r134, RomUtils.BRAND_HUAWEI) == true) goto L99;
        if (TextUtils.equals(r134, DimLocationCheckUtil.XIAOMI) == false) goto L97;
        r140 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        r140.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
        r140.putExtra("extra_pkgname", r127.getPackageName());
        goto L100
    L97:
        if (TextUtils.equals(r134, "meizu") == false) goto L99;
        r140 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        r140.addCategory("android.intent.category.DEFAULT");
        r140.putExtra("packageName", r127.getPackageName());
        goto L100
    L134:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L135:
        r120 = null;
        goto L138
    L19:
        r121 = (Ref.ObjectRef) r100.L$5;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r148 = (List) r100.L$4;
        r113 = (c) r100.L$3;
        Ref.ObjectRef r149 = (Ref.ObjectRef) r100.L$2;
        Ref.ObjectRef r150 = (Ref.ObjectRef) r100.L$1;
        DealPermanentDeniedTask r151 = (DealPermanentDeniedTask) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L45:
        r126 = ((Boolean) r102).booleanValue();
        r122 = r148;
        r125 = r151;
    L47:
        if (r126 == false) goto L49;
    L62:
        r111 = r121;
        goto L61
    L49:
        if (((j) r149.element) == null) goto L62;
        r100.L$0 = r125;
        r100.L$1 = r149;
        r100.L$2 = r113;
        r100.L$3 = r122;
        r100.L$4 = r121;
        r100.L$5 = null;
        r100.label = 2;
        SafeContinuation r152 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        j r153 = (j) r149.element;
        List r154 = (List) r121.element;
        ArrayList r155 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r154, 10));
        Iterator r156 = r154.iterator();
    L52:
        if (r156.hasNext() == false) goto L54;
        r155.add(((com.bytedance.ies.ezpermission.core.permissions.a) r156.next()).d());
        goto L52
    L54:
        r153.a(r155, r152);
        r102 = r152.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L57;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L57:
        if (r102 != r103) goto L59;
        return r103;
    L59:
        r123 = r113;
        goto L60
    L20:
        ResultKt.throwOnFailure(r102);
        e r157 = this.f248588b.b();
        Ref.ObjectRef r158 = new Ref.ObjectRef();
        EzPermission.INSTANCE.getGlobalConfig();
        r158.element = null;
        r149 = new Ref.ObjectRef();
        r149.element = r157.f248578j;
        r113 = this.f248588b.g();
        r148 = r113.f248590b;
        if (((j) r158.element) == null) goto L23;
    L24:
        Ref.ObjectRef r159 = new Ref.ObjectRef();
        List r160 = CollectionsKt.flatten(r148);
        ?? r161 = new ArrayList();
        Iterator r162 = r160.iterator();
    L26:
        if (r162.hasNext() == false) goto L31;
        Object r163 = r162.next();
        if (Boxing.boxBoolean(((com.bytedance.ies.ezpermission.core.permissions.a) r163).a(this.f248588b.getActivity())).booleanValue() == false) goto L26;
        r161.add(r163);
        goto L26
    L31:
        r159.element = r161;
        if ((!r161.isEmpty()) == false) goto L136;
        n46.a r164 = n46.a.f517060b;
        String r165 = "On permission denied:" + ((List) r159.element);
        r164.getClass();
        n46.a.c(r165);
        if (((j) r158.element) == null) goto L46;
        r100.L$0 = this;
        r100.L$1 = r158;
        r100.L$2 = r149;
        r100.L$3 = r113;
        r100.L$4 = r148;
        r100.L$5 = r159;
        r100.label = 1;
        SafeContinuation r166 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        j r167 = (j) r158.element;
        List r168 = (List) r159.element;
        ArrayList r169 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r168, 10));
        Iterator r170 = r168.iterator();
    L37:
        if (r170.hasNext() == false) goto L39;
        r169.add(((com.bytedance.ies.ezpermission.core.permissions.a) r170.next()).d());
        goto L37
    L39:
        r167.a(r169, r166);
        Object r171 = r166.getOrThrow();
        if (r171 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L42;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L42:
        if (r171 != r103) goto L44;
        return r103;
    L44:
        r151 = this;
        r121 = r159;
        r102 = r171;
        goto L45
    L46:
        r121 = r159;
        r122 = r148;
        r126 = false;
        r125 = this;
    L136:
        r114 = this;
        goto L137
    L23:
        if (((j) r149.element) == null) goto L136;
    L7:
        r100 = new DealPermanentDeniedTask$run$1(this, r110);
        goto L8
    }
}
