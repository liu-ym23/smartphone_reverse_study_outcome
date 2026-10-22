package com.ss.android.lark.widget.photo.preview.ocr.menu;

import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.common_selection.SelectionGranularity;
import com.larksuite.common_selection.SelectionInitiationMode;
import com.larksuite.common_selection.TriggerMode;
import com.larksuite.common_selection.i;
import com.larksuite.common_selection.n;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.widget.photo.preview.ocr.SelectionMenu;
import com.ss.android.lark.widget.photo.preview.utils.PhotoPagerFgUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f447104e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f447105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SelectionMenu f447106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f447107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f447108d;

    public static final class a {
        public static View a(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        public static b b(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            b r101 = null;
            if (PhotoPagerFgUtils.c() == true) goto L5;
            return null;
        L5:
            Object r102 = a(r100.getWindow()).getTag(R.id.photo_picker_photo_live_text_manager);
            if ((r102 instanceof b) == false) goto L8;
            r101 = (b) r102;
        L8:
            if (r101 == null) goto L10;
            return r101;
        L10:
            b r103 = new b(r100);
            a(r100.getWindow()).setTag(R.id.photo_picker_photo_live_text_manager, r103);
            return r103;
        }
    }

    static {
    }

    public b(FragmentActivity r100) {
        n r101 = new n(SelectionGranularity.WORD, SelectionInitiationMode.SELECT_ON_CONTENT);
        i.a r102 = new i.a();
        TriggerMode r103 = TriggerMode.LongPress;
        Intrinsics.checkNotNullParameter(r103, "triggerMode");
        Intrinsics.checkNotNullParameter(r101, "option");
        r102.f282897i.put(r103, r101);
        ly7.a r104 = new ly7.a();
        Intrinsics.checkNotNullParameter(r104, "factory");
        r102.f282889a = r104;
        r102.f282893e = true;
        i r105 = new i(r102);
        this.f447105a = r105;
        this.f447106b = new SelectionMenu(r100);
        this.f447107c = PhotoPagerLiveTextCoordinator$actionOnSelectionEnd$1.INSTANCE;
        this.f447108d = PhotoPagerLiveTextCoordinator$actionOnSelectionStart$1.INSTANCE;
        r105.f282887t = new com.ss.android.lark.widget.photo.preview.ocr.menu.a(this);
    }
}
