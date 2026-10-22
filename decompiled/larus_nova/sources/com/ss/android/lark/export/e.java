package com.ss.android.lark.export;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UnifiedHeaderInfo;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420647a = 0;

    public interface a {
        void a(Drawable r100);
    }

    static {
    }

    public e() {
    }

    public static Drawable b(Context r100, UDIcon r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = r101.getUnicode();
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L25;
        int r104 = edb.a.f472252a;
        int r105 = edb.a.a(r101.getKey());
        if (r105 == 0) goto L30;
        Bitmap r106 = p.c(r100, r105);
        if (r106 != null) goto L18;
        r106 = p.c(r100, R.drawable.ud_icon_link_copy_outlined);
    L18:
        BitmapDrawable r107 = new BitmapDrawable(r106);
        ThemeColor r108 = r101.getThemeColor();
        if (r108 == null) goto L24;
        int r109 = com.ss.android.lark.export.entity.preview.a.a(r108, UIHelper.getContext(), null);
        if (r109 == 0) goto L24;
        r107.mutate();
        r107.setTint(r109);
    L24:
        return r107;
    L30:
        return null;
    L25:
        Integer[] r110 = sbb.d.f541292a;
        String r111 = r101.getUnicode();
        if (r111 != null) goto L29;
        r111 = "";
    L29:
        return new BitmapDrawable(sbb.d.a(r111));
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    }

    public static void a(Context r110, UrlInlinePreviewEntity r111, a r112, Drawable r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, BrowserDependency.UrlClickType.INLINE);
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (r111.getUseColorIcon() == true) goto L5;
        String r100 = r111.getNetIconKey();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UrlInlineIconLoaderUtil$loadInlineIconKey$1(r110, r100, r113, r112, null), 3, null);
        return;
    L5:
        UnifiedHeaderInfo r101 = r111.getHeaderInfo();
        if (r101 == null) goto L8;
        ColorIcon r102 = r101.getIcon();
    L9:
        ColorIcon r103 = r102;
        if (r103 == null) goto L12;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UrlInlineIconLoaderUtil$loadColorIcon$1(r110, r103, r113, r112, null), 3, null);
        return;
    L12:
        String r104 = r111.getNetIconKey();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UrlInlineIconLoaderUtil$loadInlineIconKey$1(r110, r104, r113, r112, null), 3, null);
        return;
    L8:
        r102 = null;
        goto L9
    }
}
