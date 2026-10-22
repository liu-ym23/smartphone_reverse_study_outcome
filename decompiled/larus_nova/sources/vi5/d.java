package vi5;

import android.content.Context;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f555343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f555344b;

    public final Context getContext() {
        return this.f555343a;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f555343a = r100;
        this.f555344b = new ArrayList(4);
    }

    public final void a(View.OnClickListener r110) {
        Intrinsics.checkNotNullParameter(r110, "clickListener");
        int r100 = b.f555335a;
        String r101 = this.f555343a.getString(R.string.Doc_Facade_Delete);
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r110, "clickListener");
        c r102 = new c(r101, R.color.function_danger_fill_default, "", false, true, true, r110);
        this.f555344b.add(r102);
    }

    public static void d(d r100, boolean r110, boolean r111, View.OnClickListener r112) {
        Intrinsics.checkNotNullParameter(r112, "clickListener");
        int r101 = b.f555335a;
        String r102 = r100.f555343a.getString(R.string.Doc_Share_Readable);
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r112, "clickListener");
        c r103 = new c(r102, R.color.text_title, "", r110, r111, false, r112);
        r100.f555344b.add(r103);
    }

    public final void b(boolean r110, boolean r111, View.OnClickListener r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r112, "clickListener");
        if (r113 == true) goto L5;
        return;
    L5:
        int r114 = b.f555335a;
        String r100 = this.f555343a.getString(R.string.Doc_Share_Editable);
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r112, "clickListener");
        c r115 = new c(r100, R.color.text_title, "", r110, r111, false, r112);
        this.f555344b.add(r115);
    }

    public final void c(boolean r110, boolean r111, boolean r112, boolean r113, View.OnClickListener r114) {
        Intrinsics.checkNotNullParameter(r114, "clickListener");
        if (r110 == true) goto L5;
        return;
    L5:
        if (r113 == false) goto L7;
        int r115 = R.string.CreationMobile_Wiki_Permission_FullAccessPermission_Tooltip;
    L8:
        int r116 = b.f555335a;
        String r100 = this.f555343a.getString(R.string.CreationMobile_Wiki_Permission_FullAccess_Options);
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        String r101 = this.f555343a.getString(r115);
        Intrinsics.checkNotNullParameter(r101, "tips");
        Intrinsics.checkNotNullParameter(r114, "clickListener");
        c r117 = new c(r100, R.color.text_title, r101, r112, r111, false, r114);
        this.f555344b.add(r117);
        return;
    L7:
        r115 = R.string.CreationMobile_ECM_AllPermissionDesc;
        goto L8
    }
}
