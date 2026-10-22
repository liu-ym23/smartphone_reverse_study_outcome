package com.suite.lark.emm.impl.clipboard.utils;

import android.R;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import coc.e;
import coc.f;
import com.baidu.platform.comapi.map.MapController;
import com.larus.platform.api.creation.TplType;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
public final class TextViewMenuUtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f460460a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f460461b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f460462c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f460463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Integer f460464e;

    public static final class a extends ActionMode.Callback2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMode.Callback f460465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f460466b;

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            this.f460465a.onDestroyActionMode(r100);
        }

        public a(ActionMode.Callback r100, boolean r101) {
            this.f460465a = r100;
            this.f460466b = r101;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            return this.f460465a.onActionItemClicked(r100, r101);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            return this.f460465a.onCreateActionMode(r100, r101);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            this.f460465a.onPrepareActionMode(r100, r101);
            if (this.f460466b == false) goto L5;
            TextViewMenuUtilsKt.b(r101, 1);
        L8:
            return true;
        L5:
            if (r101 == null) goto L8;
            TextViewMenuUtilsKt.c(r101, 1);
            goto L8
        }

        @Override // android.view.ActionMode.Callback2
        public final void onGetContentRect(ActionMode r100, View r101, Rect r102) {
            ActionMode.Callback r103 = this.f460465a;
            if ((r103 instanceof ActionMode.Callback2) == false) goto L5;
            ((ActionMode.Callback2) r103).onGetContentRect(r100, r101, r102);
            return;
        L5:
            super.onGetContentRect(r100, r101, r102);
        }
    }

    public static final class b implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMode.Callback f460467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f460468b;

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            this.f460467a.onDestroyActionMode(r100);
        }

        public b(ActionMode.Callback r100, boolean r101) {
            this.f460467a = r100;
            this.f460468b = r101;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            return this.f460467a.onActionItemClicked(r100, r101);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            return this.f460467a.onCreateActionMode(r100, r101);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            this.f460467a.onPrepareActionMode(r100, r101);
            if (this.f460468b == false) goto L5;
            TextViewMenuUtilsKt.b(r101, 1);
        L8:
            return true;
        L5:
            if (r101 == null) goto L8;
            TextViewMenuUtilsKt.c(r101, 1);
            goto L8
        }
    }

    static {
        f460460a = LazyKt.lazy(TextViewMenuUtilsKt$controlledCustomSelectionActionModeCallback$2.INSTANCE);
        f460461b = LazyKt.lazy(TextViewMenuUtilsKt$isXiaomi$2.INSTANCE);
        f460462c = LazyKt.lazy(TextViewMenuUtilsKt$isHuawei$2.INSTANCE);
    }

    public static final boolean f() {
        return ((Boolean) f460461b.getValue()).booleanValue();
    }

    public static final void a(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        e r101 = f.f24672a;
        coc.c r102 = r101.f24669b;
        if (f() == true) goto L5;
        return;
    L5:
        if (com.suite.lark.emm.impl.clipboard.utils.a.a() == true) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L12;
        r102.c();
        return;
    L12:
        return;
    L7:
        r101.f24669b.b();
        r103 = false;
        goto L8
    }

    public static final boolean e(Intent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.getAction();
        if (y0.a(r101, "android.intent.action.SEARCH") == false) goto L8;
    L42:
        boolean r102 = true;
    L43:
        Uri r103 = r100.getData();
        if (r103 == null) goto L48;
        String r104 = r103.getHost();
        if (r104 == null) goto L48;
        boolean r105 = StringsKt.contains$default(r104, "www.iciba.com", false, 2, null);
    L49:
        if (r102 == true) goto L52;
        if (r105 == true) goto L52;
        f.f24672a.f24669b.c();
        return false;
    L52:
        return true;
    L48:
        r105 = false;
        goto L49
    L8:
        if (y0.a(r101, "android.intent.action.WEB_SEARCH") == true) goto L42;
        if (y0.a(r100.getAction(), "android.intent.action.CHOOSER") == false) goto L38;
        Bundle r106 = r100.getExtras();
        if (r106 == null) goto L38;
        String r107 = r106.getString("android.intent.extra.TITLE");
        if (r107 == null) goto L38;
        if (y0.a(r107, "Share") == false) goto L20;
    L21:
        Intent r108 = (Intent) r106.getParcelable("android.intent.extra.INTENT");
        if (r108 == null) goto L38;
        if (y0.a(r108.getAction(), "android.intent.action.SEND") == false) goto L38;
        Bundle r109 = r108.getExtras();
        if (r109 == null) goto L38;
        if (r109.containsKey("key_intent_chooser_internal") == false) goto L33;
        r106.remove("key_intent_chooser_internal");
        goto L38
    L33:
        if (r109.containsKey("android.intent.extra.STREAM") == true) goto L38;
        if (y0.d(r109.getString("android.intent.extra.TEXT")) == true) goto L38;
        boolean r110 = true;
    L39:
        if (r110 == true) goto L42;
        r102 = false;
        goto L43
    L20:
        if (y0.a(r107, "分享") == true) goto L21;
    L38:
        r110 = false;
        goto L39
    }

    public static final boolean g(MenuItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        int r101 = r100.getItemId();
        CharSequence r102 = r100.getTitle();
        int r103 = r100.getGroupId();
        if (r101 != 16908319) goto L5;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        return false;
    L15:
        if (com.suite.lark.emm.design.edittext.b.f460433a.contains(Integer.valueOf(r103)) == false) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r102, UIHelper.getString(R.string.copy)) == false) goto L19;
    L26:
        boolean r105 = true;
    L27:
        if (r105 == true) goto L32;
        return true;
    L32:
        return false;
    L19:
        if (Intrinsics.areEqual(r102, UIHelper.getString(R.string.cut)) == true) goto L26;
        if (Intrinsics.areEqual(r102, UIHelper.getString(R.string.selectAll)) == true) goto L26;
        if (Intrinsics.areEqual(r102, UIHelper.getString(R.string.paste)) == true) goto L26;
        r105 = false;
        goto L27
    L5:
        if (r101 == 16908322) goto L12;
        if (r101 == 16908321) goto L12;
        if (r101 == 16908320) goto L12;
        r104 = false;
        goto L13
    }

    public static final void b(Menu r100, int r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (com.suite.lark.emm.impl.clipboard.utils.a.a() == true) goto L7;
        return;
    L7:
        f.f24672a.f24669b.b();
        c(r100, r101);
    }

    public static final void c(Menu r100, int r101) {
        if (f460463d == null) goto L13;
        if (Intrinsics.areEqual(r100.toString(), f460463d) == false) goto L13;
        int r102 = r100.size();
        Integer r103 = f460464e;
        if (r103 == null) goto L13;
        if (r102 != r103.intValue()) goto L13;
        return;
    L13:
        if (r100.size() > 0) goto L15;
        return;
    L15:
        int r104 = r100.size() - 1;
    L16:
        if ((-1) >= r104) goto L21;
        MenuItem r105 = r100.getItem(r104);
        int r106 = r105.getItemId();
        Intrinsics.checkNotNull(r105);
        if (g(r105) == false) goto L20;
        r100.removeItem(r106);
    L20:
        r104 = r104 - 1;
        goto L16
    L21:
        f460463d = r100.toString();
        f460464e = Integer.valueOf(r100.size());
        if (r100.size() != 0) goto L28;
        f.f24672a.f24668a.a(MapsKt.mapOf(TuplesKt.to("scene", Integer.valueOf(r101))), null, null, 0);
        return;
    }

    public static final ActionMode.Callback d(ActionMode.Callback r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "original");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return new a(r100, r101);
    L7:
        return new b(r100, r101);
    }
}
