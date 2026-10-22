package com.ss.android.lark.photoeditor.impl.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.dialog.CommonLoadingDialog;
import com.ss.android.photoeditor.util.PhotoMemoryUtils;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class r implements com.ss.android.lark.photoeditor.impl.ui.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f438610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f438611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f438612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f438613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<RectF> f438614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.ss.android.lark.photoeditor.impl.ui.b.a f438615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f438616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommonLoadingDialog f438617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f438618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ofc.b f438619j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q0c.b.a f438620k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ujb.f f438621l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f438622m;

    public class a implements jkc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f438623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f438624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r f438625c;

        @Override // jkc.b
        public final void a(final PolarisFileWrapper r100) {
            Log.i("PhotoEditorView", "[cipher] file decrypt success, original path = " + this.f438623a.getAbsolutePath() + ", new path = " + r100.getAbsolutePath());
            final r r101 = this.f438625c;
            final View r102 = this.f438624b;
            r101.getClass();
            r101.f438622m = PhotoMemoryUtils.a();
            UICallbackExecutor.post(new q(r101, r100, r102));
        }

        @Override // jkc.b
        public final void b(DecryptException r100) {
            Log.e("PhotoEditorView", "[cipher] file decrypt failed, original path = " + this.f438623a.getAbsolutePath());
            r r101 = this.f438625c;
            r101.getClass();
            UICallbackExecutor.post(new p(r101));
        }

        public a(r r100, VFSFile r101, View r102) {
            this.f438625c = r100;
            this.f438623a = r101;
            this.f438624b = r102;
        }
    }

    public interface b {
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void A2() {
        CommonLoadingDialog r100 = this.f438617h;
        if (r100 == null) goto L6;
        r100.show(this.f438610a);
        return;
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void K3() {
        CommonLoadingDialog r100 = this.f438617h;
        if (r100 == null) goto L6;
        r100.dismiss();
        return;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f438617h = new CommonLoadingDialog();
        FrameLayout r100 = (FrameLayout) this.f438611b.findViewById(R.id.photoeditor_container);
        this.f438618i = r100;
        StatusBarUtil.setTranslucentForImageView((Activity) this.f438610a, 178, new View[]{r100});
        View r101 = this.f438611b.findViewById(R.id.photoeditor_container);
        VFSFiles.f444819b.getClass();
        VFSFile r102 = VFSFiles.b(true).i(this.f438613d);
        a r103 = new a(this, r102, r101);
        int r104 = CipherManager.f456788a;
        Intrinsics.checkNotNullParameter(r102, "file");
        Intrinsics.checkNotNullParameter(r102, "file");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.lark.android.encryption.a(r102, true, r103));
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        ofc.b r100 = this.f438619j;
        if (r100 == null) goto L5;
        r100.a();
        this.f438619j = null;
    L5:
        ujb.f r101 = this.f438621l;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.d() == false) goto L12;
        this.f438621l.close();
        return;
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final boolean onBackPressed() {
        b r100 = this.f438616g;
        if (r100 == null) goto L7;
        ((PhotoEditorFragment.a) r100).f438570a.finish();
        return true;
    L7:
        return true;
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void y() {
        UICallbackExecutor.post(new p(this));
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f438615f = (com.ss.android.lark.photoeditor.impl.ui.b.a) r100;
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void showToast(String r100) {
        LKUIToast.show(this.f438610a, r100);
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void z(int r100) {
        LKUIToast.show(this.f438610a, R.string.Lark_Legacy_Success);
    }

    public r(FragmentActivity r100, View r101, String r102, String r103, PhotoEditorFragment.a r104) {
        this.f438622m = -1;
        this.f438610a = r100;
        this.f438611b = r101;
        this.f438612c = r102;
        this.f438613d = r103;
        this.f438616g = r104;
        this.f438620k = p0c.a.a().getGuideDependency();
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void v2(String r110, boolean r111, boolean r112, String r113, String r114, String r210, q0c.a r211) {
        boolean r115 = "from_screenshot_forward_preview".equals(this.f438612c);
        ArrayList r116 = new ArrayList();
        r116.add(new r0c.c(this.f438610a, r112, r110, r115));
        r116.add(new r0c.b(this.f438610a, r115, r110));
        if (r115 == false) goto L5;
        int r100 = R.string.Lark_Legacy_Save;
    L6:
        r116.add(new r0c.k(this.f438610a, r111, r110, r113, r114, r210, r100, r115, r115, r211));
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = r116.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        r0c.d r103 = (r0c.d) r102.next();
        if (r103.isValid() == false) goto L8;
        r101.put(r103.a(), r103);
        goto L8
    L12:
        String[] r104 = (String[]) r101.keySet().toArray(new String[0]);
        com.larksuite.component.ui.dialog.i r105 = new com.larksuite.component.ui.dialog.i(this.f438610a);
        r105.n(r104);
        r105.f284126f = new t(r104, r101);
        r105.f284127g.itemTextColor(R.color.edit_menu_item_text_highlight_selector_photo);
        r105.b(R.id.lkui_dialog_btn_cancel, UIUtils.getString(this.f438610a, R.string.Lark_Legacy_Cancel), null);
        r105.i();
        return;
    L5:
        r100 = R.string.Lark_Legacy_SaveImage;
        goto L6
    }
}
