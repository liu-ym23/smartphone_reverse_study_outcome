package com.larus.office.card.doc.download;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361408a = 0;

    static {
    }

    public i() {
    }

    public static /* synthetic */ void b(Fragment r100, String r101, int r110, String r111, Map r112) {
        a(r100, r101, r110, "message_card", "chat", r111, null, r112);
    }

    public static void a(Fragment r110, String r111, int r112, String r113, String r114, String r115, String r116, Map r117) {
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r111, "resourceId");
        Intrinsics.checkNotNullParameter(r113, "showFrom");
        OfficeCardDocDownloadServiceDelegate.f361398b.a(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
