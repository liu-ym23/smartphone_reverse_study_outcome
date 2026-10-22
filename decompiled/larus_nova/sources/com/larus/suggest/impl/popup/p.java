package com.larus.suggest.impl.popup;

import com.larus.bmhome.chat.bean.PopWindowCandidateConf;
import com.larus.bmhome.chat.bean.PopWindowMedia;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.x1;

/* JADX INFO: loaded from: classes31.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PopWindowCandidateConf f369890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f369891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f369892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f369893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f369894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f369895f;

    public static final class a {
    }

    static {
    }

    public final String a() {
        List<PopWindowMedia> r100 = this.f369890a.getMediaList();
        if (r100 == null) goto L18;
        PopWindowMedia r101 = (PopWindowMedia) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L19;
        Integer r102 = r101.getMediaType();
        if (r102 != null) goto L10;
    L13:
        if (r102 != null) goto L16;
        return "";
    L16:
        if (r102.intValue() != 2) goto L21;
        String r103 = "video";
    L20:
        return r103;
    L21:
        return "";
    L10:
        if (r102.intValue() != 1) goto L13;
        r103 = "pic";
        goto L20
    L19:
        return "";
    L18:
        return "";
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickType");
        JSONObject r101 = new JSONObject();
        r101.put("current_page", this.f369891b);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, a());
        r101.put("group_id", this.f369892c);
        r101.put("activity_id", this.f369893d);
        r101.put("name", this.f369890a.getName());
        r101.put("click_type", r100);
        com.larus.platform.service.o.f365780a.reportEvent("pop_click", r101);
        if (Intrinsics.areEqual(r100, DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON) == false) goto L14;
        String r102 = this.f369894e;
        if (r102 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r102, "ug_free_subs_download_pc") == true) goto L10;
        r102 = null;
    L10:
        String r103 = r102;
        if (r103 == null) goto L16;
        x1.e(r103, "popup_window", null, null, this.f369895f, null, 108);
        return;
    L16:
        return;
    }

    public p(PopWindowCandidateConf r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "windowConfig");
        this.f369890a = r100;
        this.f369891b = r101;
        this.f369892c = r102;
        this.f369893d = r103;
        this.f369894e = r104;
        this.f369895f = r105;
    }
}
