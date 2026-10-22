package com.ss.android.lark.photoeditor.impl.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes37.dex */
public class PhotoEditorFragment extends BaseFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f438556q = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f438557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FragmentActivity f438558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f438559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f438560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f438561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f438562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f438563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f438564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f438565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f438566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o f438567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f438568o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f438569p;

    public class a implements r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoEditorFragment f438570a;

        public a(PhotoEditorFragment r100) {
            this.f438570a = r100;
        }
    }

    public class b implements o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoEditorFragment f438571a;

        public b(PhotoEditorFragment r100) {
            this.f438571a = r100;
        }

        public final void a(String r100, Pair<Integer, Integer> r101, ArrayList<pfc.f.a> r102) {
            PhotoEditorFragment r103 = this.f438571a;
            int r104 = PhotoEditorFragment.f438556q;
            o r105 = r103.f438567n;
            if (r105 == null) goto L5;
            r105.destroy();
            r103.f438567n = null;
        L5:
            Intent r106 = new Intent();
            r106.putExtra("key_result_path", r100);
            if (r102 == null) goto L8;
            r106.putParcelableArrayListExtra("key_edit_action_list", s0c.a.a(r102));
        L8:
            r106.putExtra("key_editor_width", (Serializable) r101.first);
            r106.putExtra("key_editor_height", (Serializable) r101.second);
            this.f438571a.setResult(-1, r106);
            this.f438571a.finish();
        }

        public final void b(String r100, String r101, Pair<Integer, Integer> r102, ArrayList<pfc.f.a> r103) {
            PhotoEditorFragment r104 = this.f438571a;
            int r105 = PhotoEditorFragment.f438556q;
            o r106 = r104.f438567n;
            if (r106 == null) goto L5;
            r106.destroy();
            r104.f438567n = null;
        L5:
            Intent r107 = new Intent();
            r107.putExtra("key_result_path", r100);
            r107.putExtra("key_result_path_decrypt", r101);
            if (r103 == null) goto L8;
            r107.putParcelableArrayListExtra("key_edit_action_list", s0c.a.a(r103));
        L8:
            r107.putExtra("key_editor_width", (Serializable) r102.first);
            r107.putExtra("key_editor_height", (Serializable) r102.second);
            this.f438571a.setResult(-1, r107);
            this.f438571a.finish();
        }
    }

    public PhotoEditorFragment() {
        this.f438568o = new a(this);
        this.f438569p = new b(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        o r100 = this.f438567n;
        if (r100 == null) goto L6;
        r100.destroy();
        this.f438567n = null;
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r210) {
        super.onViewCreated(r110, r210);
        Bundle r100 = getArguments();
        if (r100 == null) goto L13;
        String r101 = r100.getString("key_image_url");
        if (TextUtils.isEmpty(r101) == true) goto L13;
        String r102 = r100.getString("key_result_path");
        String r103 = r100.getString("key_from", "");
        boolean r104 = r100.getBoolean("key_show_save_btn", false);
        boolean r105 = r100.getBoolean("key_show_forward_btn", false);
        String r106 = r100.getString("key_file_key", "");
        this.f438565l = r100.getString("chat_id");
        this.f438566m = r100.getString(MusicAppletPage.KEY_MESSAGE_ID);
        Log.i("PhotoEditor", "imageUrl = " + r101);
        Log.i("PhotoEditor", " saveResultPath = " + r102);
        if (TextUtils.isEmpty(r101) == true) goto L13;
        if (TextUtils.isEmpty(r102) == true) goto L13;
        this.f438559f = r101;
        this.f438560g = r102;
        this.f438561h = r103;
        this.f438562i = r104;
        this.f438563j = r105;
        this.f438564k = r106;
        boolean r107 = true;
    L15:
        if (r107 == true) goto L18;
        finish();
        return;
    L18:
        KeyEventDispatcher.Component r108 = getActivity();
        if ((r108 instanceof q0c.a) == false) goto L21;
        q0c.a r109 = (q0c.a) r108;
    L22:
        o r111 = new o(this.f438559f, this.f438560g, this.f438561h, this.f438562i, this.f438563j, this.f438564k, this.f438565l, this.f438566m, this.f438558e, this.f438557d, this.f438568o, this.f438569p, r109);
        this.f438567n = r111;
        ((r) r111.getView()).f438614e = getArguments().getParcelableArrayList("key_preset_mask_rects");
        this.f438567n.create();
        com.ss.android.lark.insets.f r112 = WindowInsetsUtils.b(this);
        r112.c(false);
        r112.o(true);
        r112.i(UIUtils.getColor(this.mContext, R.color.lkui_N900));
        return;
    L21:
        r109 = null;
    L13:
        r107 = false;
        goto L15
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if ("from_screenshot_forward_preview".equals(this.f438561h) == false) goto L8;
        if (r100 != 16) goto L8;
        if (r101 != (-1)) goto L8;
        Intent r103 = new Intent();
        r103.putExtra("key_result_forwarded_image", true);
        setResult(-1, r103);
    L8:
        o r104 = this.f438567n;
        if (r104 == null) goto L14;
        r104.getClass();
        if (r100 != 16) goto L15;
        UICallbackExecutor.execute(new n(r104, r101));
        return;
    L15:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.f438557d = r100.inflate(R.layout.activity_photo_editor, r101, false);
        this.f438558e = getActivity();
        return this.f438557d;
    }
}
