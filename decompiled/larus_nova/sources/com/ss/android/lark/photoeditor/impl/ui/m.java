package com.ss.android.lark.photoeditor.impl.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes37.dex */
public final class m implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f438590a;

    public class a implements com.ss.android.lark.photoeditor.impl.ui.a.InterfaceC5241a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f438591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f438592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m f438593c;

        public a(m r100, Bitmap r101, ArrayList r102) {
            this.f438593c = r100;
            this.f438591a = r101;
            this.f438592b = r102;
        }
    }

    public m(o r100) {
        this.f438590a = r100;
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b.a
    public final void F6(String r100, Bitmap r110) {
        if ("from_screenshot_forward_preview".equals(this.f438590a.f438598c) == false) goto L6;
        b r101 = this.f438590a.getView();
        o r111 = this.f438590a;
        r101.v2(r100, r111.f438599d, r111.f438600e, r111.f438602g, r111.f438603h, r111.f438604i, r111.f438605j);
        return;
    L6:
        o.a r102 = this.f438590a.f438601f;
        PhotoEditorFragment.b r103 = (PhotoEditorFragment.b) r102;
        r103.b(r100, r100, new Pair(Integer.valueOf(r110.getWidth()), Integer.valueOf(r110.getHeight())), null);
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b.a
    public final void L7(final Bitmap r100, final ArrayList<pfc.f.a> r101) {
        Log.i("PhotoEditorPresenter", "resultPath:" + this.f438590a.f438597b);
        if (TextUtils.isEmpty(this.f438590a.f438597b) == true) goto L31;
        Activity r102 = this.f438590a.f438596a;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.isFinishing() == false) goto L9;
        return;
    L9:
        if (this.f438590a.f438596a.isDestroyed() == true) goto L34;
        o r103 = this.f438590a;
        Activity r104 = r103.f438596a;
        String r105 = r103.f438597b;
        String r106 = r104.getCacheDir().getAbsolutePath();     // Catch: Exception -> L21
        String r107 = r104.getFilesDir().getAbsolutePath();     // Catch: Exception -> L21
        String r108 = r104.getExternalCacheDir().getAbsolutePath();     // Catch: Exception -> L21
        String r109 = r104.getExternalFilesDir(null).getAbsolutePath();     // Catch: Exception -> L21
        if (r105.contains(r106) == false) goto L15;
    L20:
        boolean r110 = true;
    L24:
        if (r110 == false) goto L27;
        b(r100, r101);
        return;
    L27:
        StoragePermissionUtils.f(this.f438590a.f438596a, new i(this, r100, r101), 16, new Token("LARK-PSDA-android_photo_editor_request_permission"), new String[0]);
        return;
    L15:
        if (r105.contains(r107) == true) goto L20;
        if (r105.contains(r108) == true) goto L20;
        if (r105.contains(r109) == true) goto L20;
    L23:
        r110 = false;
    L21:
        e = move-exception;
        Log.e("PhotoEditorUtil", "isLarkDataPath:" + e);
        goto L23
    L34:
        return;
    }

    public final void b(Bitmap r100, ArrayList<pfc.f.a> r101) {
        Log.i("PhotoEditorPresenter", "performSave");
        this.f438590a.getView().A2();
        this.f438590a.getModel().m1(r100, this.f438590a.f438597b, new a(this, r100, r101));
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b.a
    public final void n0(Bitmap r100, vfc.d r101) {
        this.f438590a.getModel().n0(r100, r101);
    }
}
