package mx;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import io.reactivex.disposables.Disposable;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes45.dex */
public class l extends mx.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f516147o = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f516148l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f516149m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f516150n;

    public static final class a {
        public static void a(l r100, SwitchSettingViewHolder r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "holder");
            r100.f516148l = r102;
            if (r101.f58552d.isChecked() == r102) goto L6;
            r101.f58552d.f(false, true);
            return;
        }

        public static void b(MultiTypeAdapter r100, l r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "adapter");
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            int r103 = CollectionsKt.indexOf(r100.f513437a, r101);
            r101.f516148l = r102;
            int r104 = r100.f513437a.size();
            if (r103 < 0) goto L9;
            if (r104 <= r103) goto L8;
            r100.notifyItemChanged(r103);
            return;
        L8:
            return;
        }
    }

    static {
    }

    public boolean b(boolean r100) {
        return false;
    }

    public void d() {
    }

    public View.OnClickListener f() {
        return null;
    }

    public void e() {
        if (this.f516150n == false) goto L5;
        d();
    L5:
        this.f516150n = false;
    }

    public void c(SwitchSettingViewHolder r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f516148l = r101;
    }

    public l(String r110, String r111, boolean r112, boolean r113, boolean r114, String r115, int r116) {
        if ((r116 & 2) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r116 & 4) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r116 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r116 & 16) == 0) goto L17;
        boolean r103 = true;
    L19:
        if ((r116 & 32) == 0) goto L21;
        String r104 = "";
    L22:
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r100, "description");
        Intrinsics.checkNotNullParameter(r104, "disableToast");
        super(r110, r100, r101, r102, r103, r104, 192);
        this.f516148l = r101;
        this.f516150n = true;
        return;
    L21:
        r104 = r115;
        goto L22
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
