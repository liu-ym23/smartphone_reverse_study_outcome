package lw9;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.t0;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements jn7.l {
    public m() {
    }

    @Override // jn7.l
    public final void a() {
    }

    @Override // jn7.l
    public final void b() {
    }

    @Override // jn7.l
    public final void c() {
    }

    @Override // jn7.l
    public final void d() {
    }

    @Override // jn7.l
    public final void f() {
    }

    @Override // jn7.l
    public final void g() {
    }

    @Override // jn7.l
    public final void i() {
    }

    @Override // jn7.l
    public final void j() {
    }

    @Override // jn7.l
    public final void l() {
    }

    public static Pair n(int r100) {
        if (r100 == R.string.share_sdk_video_save_failed) goto L25;
        if (r100 == R.string.share_sdk_pic_save_failed) goto L25;
        if (r100 == R.string.share_sdk_had_saved_to_album) goto L23;
        if (r100 == R.string.share_sdk_pic_had_saved_to_album) goto L23;
        if (r100 != R.string.share_sdk_clip_sucess) goto L17;
        return new Pair(Boolean.TRUE, Integer.valueOf(R.string.larus_text_copied_tip));
    L17:
        if (r100 != R.string.share_sdk_clip_failed) goto L21;
        return new Pair(Boolean.FALSE, Integer.valueOf(R.string.larus_cici_share_msg_share_error_msg));
    L21:
        return new Pair(null, Integer.valueOf(r100));
    L23:
        return new Pair(Boolean.TRUE, Integer.valueOf(R.string.larus_save_success));
    L25:
        return new Pair(Boolean.FALSE, Integer.valueOf(R.string.larus_save_failed));
    }

    @Override // jn7.l
    public final l k(Activity r100) {
        return new l(r100, new Ref.ObjectRef());
    }

    public static String m(ShareContent r100, String r101) {
        if (r100 == null) goto L7;
        kn7.a r102 = r100.getExtraParams();
        if (r102 == null) goto L7;
        Object r103 = r102.f504253g;
    L9:
        if ((r103 instanceof JSONObject) == false) goto L11;
        JSONObject r104 = (JSONObject) r103;
    L12:
        if (r104 == null) goto L22;
        String r105 = r104.optString(r101);
        if (r105 != null) goto L16;
        return null;
    L16:
        if (r105.length() <= 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == true) goto L21;
        return null;
    L21:
        return r105;
    L18:
        r106 = false;
        goto L19
    L22:
        return null;
    L11:
        r104 = null;
    L7:
        r103 = null;
        goto L9
    }

    @Override // jn7.l
    public final void h(Context r100, int r101) {
        if (r100 != null) goto L7;
        AppHost.Companion r102 = AppHost.f326268a;
        Activity r103 = r102.a().getCurrentActivity();
        if (r103 == null) goto L6;
        r100 = r103;
        goto L7
    L6:
        r100 = r102.getApplication();
    L7:
        s r104 = s.f544207a;
        int r105 = ((Number) n(r101).getSecond()).intValue();
        r104.getClass();
        t0.e(new t19.i(r100, r105, R.drawable.share_sdk_close_popup_textpage, false));
    }

    @Override // jn7.l
    public final void e(Context r100, ShareContent r101, int r102) {
        if (r100 != null) goto L7;
        AppHost.Companion r103 = AppHost.f326268a;
        Activity r104 = r103.a().getCurrentActivity();
        if (r104 == null) goto L6;
        r100 = r104;
        goto L7
    L6:
        r100 = r103.getApplication();
    L7:
        Pair r105 = n(r102);
        Boolean r106 = (Boolean) r105.component1();
        int r107 = ((Number) r105.component2()).intValue();
        if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L14;
        String r108 = m(r101, "share_success_toast_text");
        if (r108 == null) goto L12;
        s.f544207a.getClass();
        s.p(r100, r108);
        return;
    L12:
        s.f544207a.getClass();
        s.o(r100, r107, false);
        return;
    L14:
        if (Intrinsics.areEqual(r106, Boolean.FALSE) == false) goto L19;
        String r109 = m(r101, "share_error_toast_text");
        if (r109 == null) goto L18;
        s.f544207a.getClass();
        s.c(r100, r109);
        return;
    L18:
        s.f544207a.getClass();
        s.b(r100, r107, false);
        return;
    L19:
        s.f544207a.g(r100, r102, false);
    }
}
