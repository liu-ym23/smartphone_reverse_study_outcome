package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f264164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f264165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Switch f264166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EditText f264167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ EditText f264168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Context f264169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<AlertDialog> f264170g;

    public o(EditText r100, EditText r101, Switch r102, EditText r103, EditText r104, Context r105, Ref.ObjectRef<AlertDialog> r106) {
        this.f264164a = r100;
        this.f264165b = r101;
        this.f264166c = r102;
        this.f264167d = r103;
        this.f264168e = r104;
        this.f264169f = r105;
        this.f264170g = r106;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r210) {
        String r100 = this.f264164a.getText().toString();
        String r101 = this.f264165b.getText().toString();
        boolean r102 = this.f264166c.isChecked();
        String r103 = this.f264167d.getText().toString();
        String r104 = this.f264168e.getText().toString();
        int r105 = p.f264171a;
        Uri r106 = UriProtector.parse(r101);     // Catch: Exception -> L72
        if (r106.getScheme() == null) goto L8;
        if (r106.getAuthority() == null) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L11;
    L17:
        int r108 = p.f264171a;
        SharedPreferences.Editor r109 = this.f264169f.getSharedPreferences("ShotComparePrefs", 0).edit();
        r109.putString("saved_node_tag", r100);
        r109.putString("saved_uri", r101);
        r109.putBoolean("enable_saved_data", r102);
        r109.apply();
        Context r110 = this.f264169f;
        List r111 = StringsKt.split$default(r103, new String[]{","}, false, 0, 6, null);
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r113 = r111.iterator();
    L19:
        if (r113.hasNext() == false) goto L25;
        String r114 = (String) r113.next();
        if (r114 == null) goto L24;
        r112.add(StringsKt.trim(r114).toString());
        goto L19
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L25:
        ArrayList r115 = new ArrayList();
        Iterator r116 = r112.iterator();
    L27:
        if (r116.hasNext() == false) goto L34;
        Object r117 = r116.next();
        if (((String) r117).length() <= 0) goto L31;
        boolean r118 = true;
    L32:
        if (r118 == false) goto L27;
        r115.add(r117);
        goto L27
    L31:
        r118 = false;
        goto L32
    L34:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, PromotionProductPrivilegesStruct.TAGS);
        SharedPreferences.Editor r119 = r110.getSharedPreferences("ShotComparePrefs", 0).edit();
        r119.putString("compare_node_tags_1", CollectionsKt.joinToString$default(r115, ",", null, null, 0, null, null, 62, null));
        r119.apply();
        int r120 = p.f264171a;
        Context r121 = this.f264169f;
        List r122 = StringsKt.split$default(r104, new String[]{","}, false, 0, 6, null);
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
        Iterator r124 = r122.iterator();
    L36:
        if (r124.hasNext() == false) goto L42;
        String r125 = (String) r124.next();
        if (r125 == null) goto L41;
        r123.add(StringsKt.trim(r125).toString());
        goto L36
    L41:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L42:
        ArrayList r126 = new ArrayList();
        Iterator r127 = r123.iterator();
    L44:
        if (r127.hasNext() == false) goto L51;
        Object r128 = r127.next();
        if (((String) r128).length() <= 0) goto L48;
        boolean r129 = true;
    L49:
        if (r129 == false) goto L44;
        r126.add(r128);
        goto L44
    L48:
        r129 = false;
        goto L49
    L51:
        Intrinsics.checkNotNullParameter(r121, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r126, PromotionProductPrivilegesStruct.TAGS);
        SharedPreferences.Editor r130 = r121.getSharedPreferences("ShotComparePrefs", 0).edit();
        r130.putString("compare_node_tags_2", CollectionsKt.joinToString$default(r126, ",", null, null, 0, null, null, 62, null));
        r130.apply();
        Toast.makeText(this.f264169f, "NodeTag、URI 和开关状态已保存", 0).show();
        AlertDialog r131 = this.f264170g.element;
        if (r131 == null) goto L92;
        Handler r132 = DialogLancet.resolveDialogHandler(r131);
        if (r132 != null) goto L56;
    L58:
        DialogLancet.beforeDialogDismiss(r131);
        r131.dismiss();     // Catch: Throwable -> L61 Exception -> L63
    L68:
        DialogLancet.afterDialogDismiss(r131);
        return;
    L63:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L61
        Throwable r133 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L61
        if (r133 == null) goto L68;
        com.bytedance.crash.d.d(r133, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r131);
        throw th;
    L56:
        if (Looper.myLooper() == r132.getLooper()) goto L58;
        r132.post(DialogLancet.createDismissRunnable(r131));
        return;
    L92:
        return;
    L11:
        if (r101.length() != 0) goto L13;
        boolean r134 = true;
    L14:
        if (r134 == true) goto L17;
        Toast.makeText(this.f264169f, "无效的URI格式", 0).show();
        return;
    L13:
        r134 = false;
    L8:
        r107 = false;
        goto L9
    }
}
