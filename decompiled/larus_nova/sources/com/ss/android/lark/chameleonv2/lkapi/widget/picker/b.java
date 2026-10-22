package com.ss.android.lark.chameleonv2.lkapi.widget.picker;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$CameraDevice;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$MediaPickerShowOptions;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.widget.photopicker.s;
import itb.e;
import itb.g;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends AbsChameleonHandler<IWidget$MediaPickerShowOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Callback f411519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f411520b;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f411520b = LKAPIModules.Widget.ShowMediaPicker.getValue();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.f411520b;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(IWidget$MediaPickerShowOptions r110, Callback r210) {
        final IWidget$MediaPickerShowOptions r100 = r110;
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        Intrinsics.checkNotNullParameter(r210, "callback");
        this.f411519a = r210;
        e r101 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        boolean r102 = false;
        if (r101 == null) goto L61;
        IChameleonHandlerContext r103 = getContext();
        FragmentActivity r104 = null;
        if (r103 == null) goto L10;
        Fragment r105 = r103.getFragment();
        if (r105 == null) goto L10;
        FragmentActivity r106 = r105.getActivity();
    L12:
        if ((r106 instanceof FragmentActivity) == false) goto L14;
        r104 = r106;
    L14:
        if (r104 == null) goto L61;
        ArrayList<String> r107 = r100.getSourceType();
        if (r107 != null) goto L19;
    L26:
        boolean r108 = false;
    L27:
        ArrayList<String> r109 = r100.getMediaType();
        if (r109 == null) goto L30;
        boolean r111 = r109.contains("image");
    L31:
        if (r109 == null) goto L33;
        boolean r112 = r109.contains("video");
    L34:
        ArrayList<String> r113 = r100.getSizeType();
        if (r113 != null) goto L37;
        boolean r114 = false;
    L44:
        int r115 = r100.getMaxSelectedCount();
        Integer r116 = r100.getMaxDuration();
        if (r116 == null) goto L47;
        int r117 = r116.intValue() * 1000;
    L48:
        Boolean r118 = r100.isSaveToAlbum();
        if (r118 == null) goto L51;
        boolean r119 = r118.booleanValue();
    L53:
        if (r100.getCameraDevice() != IWidget$CameraDevice.Front) goto L55;
        boolean r120 = true;
    L56:
        g r121 = new g(r115, r111, r112, r117, r119, r114, r120);
        c r122 = new c(this);
        if (r108 == false) goto L59;
        boolean r123 = r101.M0(r104, r121, r122);
    L60:
        r102 = r123;
        goto L61
    L59:
        r123 = r101.f0(r104, r121, r122);
        goto L60
    L55:
        r120 = false;
        goto L56
    L51:
        r119 = false;
        goto L53
    L47:
        r117 = 60000;
        goto L48
    L37:
        if (r113.contains("original") == true) goto L39;
    L41:
        boolean r124 = false;
    L42:
        r114 = r124;
        goto L44
    L39:
        if (r113.contains("compressed") == true) goto L41;
        r124 = true;
        goto L42
    L33:
        r112 = false;
        goto L34
    L30:
        r111 = true;
        goto L31
    L19:
        if (r107.contains("camera") == true) goto L21;
    L23:
        boolean r125 = false;
    L24:
        if (r125 != true) goto L26;
        r108 = true;
        goto L27
    L21:
        if (r107.contains("album") == true) goto L23;
        r125 = true;
    L10:
        r106 = null;
    L61:
        if (r102 == true) goto L77;
        int r126 = s.C;
        com.ss.android.lark.widget.photopicker.e r127 = new com.ss.android.lark.widget.photopicker.e(s.b.a(new ShowMediaPickerHandler$handle$picker$1(r100)));
        IChameleonHandlerContext r128 = getContext();
        if (r128 == null) goto L73;
        Context r129 = r128.getCmlContext();
        if (r129 == null) goto L73;
        IChameleonHandlerContext r130 = getContext();
        if (r130 == null) goto L72;
        Fragment r131 = r130.getFragment();
        if (r131 == null) goto L72;
        r127.b(r129, r131, 97);
        return;
    L72:
        r210.error(new LKAPIError(-1, "fragment is null"));
        return;
    L73:
        r210.error(new LKAPIError(-1, "appContext is null"));
        return;
    }
}
