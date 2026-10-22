package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.android.file.picker.lib.FilePickerParams;
import com.bytedance.keva.KevaImpl;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.LarkUriUtil;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes15.dex */
public final class OpenSystemPickerHandler extends OnSingleClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f206129e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f206130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<tm4.b, Unit> f206131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FilePickerParams f206132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BaseFragment f206133d;

    public static final class a {
    }

    static {
        f206129e = CollectionsKt.listOf(new String[]{"app_webview", "databases", "shared_prefs", KevaImpl.PrivateConstants.FILES_DIR_NAME});
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        Intent r101 = new Intent("android.intent.action.OPEN_DOCUMENT");     // Catch: ActivityNotFoundException -> L17
        r101.setType("*/*");     // Catch: ActivityNotFoundException -> L17
        Set<String> r102 = this.f206132c.f205967l;     // Catch: ActivityNotFoundException -> L17
        if (r102 == null) goto L7;
        String[] r103 = (String[]) r102.toArray(new String[0]);     // Catch: ActivityNotFoundException -> L17
        if (r103 == null) goto L7;
    L8:
        r101.putExtra("android.intent.extra.MIME_TYPES", r103);     // Catch: ActivityNotFoundException -> L17
        r101.addCategory("android.intent.category.OPENABLE");     // Catch: ActivityNotFoundException -> L17
        r101.putExtra("android.intent.extra.LOCAL_ONLY", true);     // Catch: ActivityNotFoundException -> L17
        if (this.f206132c.f205958c <= 1) goto L11;
        r101.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);     // Catch: ActivityNotFoundException -> L17
    L11:
        r101.addFlags(64);     // Catch: ActivityNotFoundException -> L17
        r101.addFlags(1);     // Catch: ActivityNotFoundException -> L17
        BaseFragment r104 = this.f206133d;     // Catch: ActivityNotFoundException -> L17
        if (r104 == null) goto L14;
        r104.startActivityForResult(r101, 102);     // Catch: ActivityNotFoundException -> L17
    L15:
        int r105 = qm4.a.f533872a;     // Catch: ActivityNotFoundException -> L17
        Statistics.sendEvent("click_attach_icon_phonestorage");     // Catch: ActivityNotFoundException -> L17
        return;
    L14:
        this.f206130a.startActivityForResult(r101, 102);     // Catch: ActivityNotFoundException -> L17
    L7:
        r103 = new String[]{"*/*"};     // Catch: ActivityNotFoundException -> L17
    L17:
        e = move-exception;
        Log.w("FilePickerV2", "start system file manager failed" + e.getMessage());
        UDToast.show(this.f206130a, R.string.Lark_Groups_Failed);
    }

    public final void b(int r100, Intent r101) {
        if ((-1) != r100) goto L5;
        int r102 = qm4.a.f533872a;
        Statistics.sendEvent("click_attach_icon_phonestorage_send");
    L6:
        LifecycleOwnerKt.getLifecycleScope(this.f206130a).launchWhenResumed(new OpenSystemPickerHandler$onActivityResult$1(this, r100, r101, null));
        return;
    L5:
        int r103 = qm4.a.f533872a;
        Statistics.sendEvent("click_attach_icon_phonestorage_cancel");
        goto L6
    }

    public final Object c(Uri r100, Intent r110, Continuation<? super tm4.a> r111) {
        if ((r111 instanceof OpenSystemPickerHandler$toFileItem$1) == false) goto L7;
        OpenSystemPickerHandler$toFileItem$1 r101 = (OpenSystemPickerHandler$toFileItem$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        r110 = (Intent) r101.L$1;
        r100 = (Uri) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L32
    L21:
        if (((Boolean) r112).booleanValue() == false) goto L24;
        Log.w("OpenSystemPickerHandler", "invalid uri path:" + r100.getPath());     // Catch: Exception -> L32
        return null;
    L24:
        ContentResolver r113 = LarkContext.getApplication().getContentResolver();     // Catch: Exception -> L32
        r113.takePersistableUriPermission(r100, r110.getFlags() & 3);     // Catch: Exception -> L28
    L30:
        Intrinsics.checkNotNull(r113);     // Catch: Exception -> L32
        return new tm4.a(r100, LarkUriUtil.j(r113, r100));
    L28:
        e = move-exception;
        Log.e("FilePickerV2", "take permission failed, uri:" + r100.getPath() + ' ', e);     // Catch: Exception -> L32
        goto L30
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
        r101.L$0 = r100;     // Catch: Exception -> L32
        r101.L$1 = r110;     // Catch: Exception -> L32
        r101.label = 1;     // Catch: Exception -> L32
        r112 = BuildersKt.withContext(Dispatchers.getIO(), new OpenSystemPickerHandler$shouldBlockUri$2(r100, null), r101);     // Catch: Exception -> L32
        if (r112 != r103) goto L21;
        return r103;
    L32:
        e = move-exception;
        Log.e("FilePickerV2", "uri to file item failed", e);
        return null;
    L7:
        r101 = new OpenSystemPickerHandler$toFileItem$1(this, r111);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005c -> B:29:0x0091). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0062 -> B:29:0x0091). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0077 -> B:24:0x0081). Please report as a decompilation issue!!! */
    public final Object d(ClipData r110, Intent r111, Continuation<? super tm4.b> r112) {
        if ((r112 instanceof OpenSystemPickerHandler$toPickerResult$2) == false) goto L7;
        OpenSystemPickerHandler$toPickerResult$2 r100 = (OpenSystemPickerHandler$toPickerResult$2) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r114 = r100.I$1;
        int r115 = r100.I$0;
        ArrayList r104 = (ArrayList) r100.L$2;
        Intent r105 = (Intent) r100.L$1;
        ClipData r106 = (ClipData) r100.L$0;
        ResultKt.throwOnFailure(r113);
        OpenSystemPickerHandler r107 = this;
    L24:
        tm4.a r116 = (tm4.a) r113;
        if (r116 == null) goto L28;
        r104.add(r116);
    L28:
        int r117 = r115;
        ClipData r118 = r106;
        OpenSystemPickerHandler r108 = r107;
        Object r109 = r102;
        OpenSystemPickerHandler$toPickerResult$2 r119 = r100;
        Intent r120 = r105;
        ArrayList r121 = r104;
        Object r122 = r109;
    L29:
        r114 = r114 + 1;
    L15:
        if (r114 >= r117) goto L30;
        ClipData.Item r123 = r118.getItemAt(r114);
        if (r123 == null) goto L29;
        Uri r124 = r123.getUri();
        if (r124 == null) goto L29;
        r119.L$0 = r118;
        r119.L$1 = r120;
        r119.L$2 = r121;
        r119.I$0 = r117;
        r119.I$1 = r114;
        r119.label = 1;
        Object r125 = r108.c(r124, r120, r119);
        if (r125 != r122) goto L23;
        return r122;
    L23:
        OpenSystemPickerHandler r126 = r108;
        r106 = r118;
        r115 = r117;
        r113 = r125;
        r107 = r126;
        ArrayList r127 = r121;
        r105 = r120;
        r100 = r119;
        r102 = r122;
        r104 = r127;
        goto L24
    L30:
        ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator r129 = r121.iterator();
    L32:
        if (r129.hasNext() == false) goto L35;
        r128.add(Boxing.boxLong(((tm4.a) r129.next()).f546773b));
        goto L32
    L35:
        return new tm4.b(r121, CollectionsKt.sumOfLong(r128));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        r117 = r110.getItemCount();
        r108 = this;
        r121 = new ArrayList();
        r122 = r102;
        r119 = r100;
        r120 = r111;
        r118 = r110;
        r114 = 0;
    L7:
        r100 = new OpenSystemPickerHandler$toPickerResult$2(this, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OpenSystemPickerHandler(FragmentActivity r100, Function1<? super tm4.b, Unit> r101, FilePickerParams r102, BaseFragment r103) {
        Intrinsics.checkNotNullParameter(r100, "mActivity");
        Intrinsics.checkNotNullParameter(r101, "mResultHandler");
        Intrinsics.checkNotNullParameter(r102, "mParams");
        this.f206130a = r100;
        this.f206131b = r101;
        this.f206132c = r102;
        this.f206133d = r103;
    }

    public static final Object a(OpenSystemPickerHandler r100, int r101, Intent r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof OpenSystemPickerHandler$toPickerResult$1) == false) goto L7;
        OpenSystemPickerHandler$toPickerResult$1 r104 = (OpenSystemPickerHandler$toPickerResult$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 == 1) goto L15;
        if (r108 != 2) goto L14;
        ResultKt.throwOnFailure(r106);
    L38:
        return r106;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r106);
    L25:
        tm4.a r109 = (tm4.a) r106;
        if (r109 == null) goto L36;
        return new tm4.b(CollectionsKt.listOf(r109), r109.f546773b);
    L36:
        return null;
    L16:
        ResultKt.throwOnFailure(r106);
        if ((-1) != r101) goto L36;
        if (r102 == null) goto L36;
        Uri r110 = r102.getData();
        if (r110 == null) goto L29;
        r104.label = 1;
        r106 = r100.c(r110, r102, r104);
        if (r106 != r107) goto L25;
        return r107;
    L29:
        ClipData r111 = r102.getClipData();
        if (r111 == null) goto L36;
        r104.label = 2;
        r106 = r100.d(r111, r102, r104);
        if (r106 != r107) goto L38;
        return r107;
    L7:
        r104 = new OpenSystemPickerHandler$toPickerResult$1(r100, r103);
        goto L8
    }
}
