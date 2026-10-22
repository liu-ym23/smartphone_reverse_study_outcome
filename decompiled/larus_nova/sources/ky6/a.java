package ky6;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.locallife.poi.media.ui.PoiMediaActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import xu6.d;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends fo6.a {

    /* JADX INFO: renamed from: ky6.a$a, reason: collision with other inner class name */
    public static final class C6632a {
    }

    static {
    }

    public a(d r100) {
        super(r100);
    }

    @Override // fo6.d
    public final boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (TextUtils.equals(AppletNaviType.POI, r100.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals("/open/media", r100.getPath()) == false) goto L7;
        return true;
    }

    @Override // fo6.a, fo6.d
    public final void b(Context r100, Uri r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "intent");
        super.b(r100, r101, r102);
        r102.setClass(r100, PoiMediaActivity.class);
        r100.startActivity(r102);
    }
}
