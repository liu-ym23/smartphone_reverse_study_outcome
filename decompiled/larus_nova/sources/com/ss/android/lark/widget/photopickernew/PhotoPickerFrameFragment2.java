package com.ss.android.lark.widget.photopickernew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.s;
import com.ss.android.lark.widget.photopickerimpl.PhotoPickerInit;
import com.ss.android.lark.widget.photopickerimpl.model.c;
import com.ss.android.lark.widget.photopickerimpl.view.grid.GridComponent;
import com.ss.android.lark.widget.photopickerimpl.view.large.a;
import com.ss.android.lark.widget.photopickernew.grid.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ldc.b;
import rdc.e;
import rdc.f;
import rdc.h;
import rdc.i;
import rdc.j;
import rdc.k;
import rdc.l;
import rdc.m;
import rdc.p;
import rdc.q;
import rdc.r;
import rdc.t;
import sdc.d;

/* JADX INFO: loaded from: classes38.dex */
public class PhotoPickerFrameFragment2 extends BaseFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f447874h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<t> f447875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PhotoPickerInit<t> f447876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f447877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a<t> f447878g;

    public PhotoPickerFrameFragment2() {
        this.f447875d = new ArrayList();
        this.f447878g = null;
    }

    public final void X90() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L5;
        finish();
        r100.overridePendingTransition(R.anim.activity_nothing, R.anim.activity_close_to_bottom);
    L5:
        PhotoPickerInit<t> r101 = this.f447876e;
        if (r101 == null) goto L17;
        mdc.a r102 = r101.f447735f;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        r102 = null;
    L10:
        Iterator r103 = r102.f513432a.f518844b.iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        ((odc.a) r103.next()).d();
        goto L12
    L14:
        r102.f513433b.onDestroy();
        return;
    }

    public static /* synthetic */ Context S90(PhotoPickerFrameFragment2 r100) {
        return r100.mContext;
    }

    public static /* synthetic */ Context T90(PhotoPickerFrameFragment2 r100) {
        return r100.mContext;
    }

    public static /* synthetic */ String U90(PhotoPickerFrameFragment2 r100) {
        return r100.PARENT_TAG;
    }

    public static /* synthetic */ Context V90(PhotoPickerFrameFragment2 r100) {
        return r100.mContext;
    }

    public static Photo Y90(t r110) {
        Integer r100 = r110.f447736a;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L7:
        return new Photo(r101, r110.f447737b, r110.f447738c, r110.f447743h, r110.f447740e, r110.f447741f, r110.f447742g);
    L5:
        r101 = 0;
        goto L7
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        super.onViewCreated(r210, r211);
        FrameLayout r100 = (FrameLayout) r210;
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L48;
        rdc.s r102 = new rdc.s(this.f447877f);
        boolean r103 = false;
        if (((ArrayList) this.f447875d).isEmpty() == true) goto L10;
        if (((t) ListProtector.get(this.f447875d, 0)).a() == false) goto L10;
    L11:
        r103 = true;
    L12:
        r102.f537383e = r103;
        Iterator r104 = ((ArrayList) this.f447875d).iterator();
    L14:
        if (r104.hasNext() == false) goto L16;
        r102.c((t) r104.next(), true);
        goto L14
    L16:
        c r110 = new c(r101, this.f447877f, new h(r102));
        PhotoPickerInit<t> r111 = new PhotoPickerInit();
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        r111.f447731b = r100;
        Intrinsics.checkNotNullParameter(r101, "activity");
        r111.f447730a = r101;
        i r105 = new i(this);
        Intrinsics.checkNotNullParameter(r105, "dependency");
        r111.f447732c = r105;
        Intrinsics.checkNotNullParameter(this.f447877f, "params");
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r111.f447733d = r110;
        this.f447876e = r111;
        j r112 = new j(this, r102, r110);
        k r113 = new k(this, r102);
        l r114 = new l(this, r102);
        p r106 = new p(this, r101, r112, new m(this, r102), r102);
        g r107 = new g(r101, new q(this, r102, r110));
        s r108 = this.f447877f;
        if (r108.f447558c == 1) goto L19;
    L21:
        com.ss.android.lark.widget.photopickernew.grid.a r109 = new com.ss.android.lark.widget.photopickernew.grid.a(r108.f447573r, new e(this, r102), r113, r114);
    L22:
        r r115 = new r(r106, r107, r109, r102);
        Intrinsics.checkNotNullParameter(r115, "component");
        r111.f447734e.add(r115);
        if (this.f447877f.f447570o == false) goto L25;
        FragmentManager r116 = r101.getSupportFragmentManager();
        PhotoPickerInit<t> r117 = this.f447876e;
        a<t> r118 = new a(r116, new f(this), new d(this.mContext, this.f447877f, r112), new sdc.a(this.mContext, this.f447877f.f447573r, new rdc.g(this, r102, r110), r112, r113, r114));
        this.f447878g = r118;
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "component");
        r117.f447734e.add(r118);
    L25:
        PhotoPickerInit<t> r119 = this.f447876e;
        if (r119.f447730a == null) goto L46;
        FrameLayout r120 = r119.f447731b;
        if (r120 == null) goto L44;
        b r121 = r119.f447732c;
        if (r121 == null) goto L42;
        com.ss.android.lark.widget.photopickerimpl.model.b<DATA> r122 = r119.f447733d;
        if (r122 == 0) goto L40;
        if (r119.f447734e.isEmpty() == true) goto L37;
        r119.f447735f = new mdc.a(new ndc.b(r120, r119.f447734e, r121), r122);
        return;
    L37:
        new ArrayList();
        Intrinsics.checkNotNull(null);
        Intrinsics.checkNotNull(null);
        Intrinsics.checkNotNull(null);
        new GridComponent(null, null, null);
        throw null;
    L40:
        throw new IllegalArgumentException("PhotoDataFactory must not be null");
    L42:
        throw new IllegalArgumentException("mDependency must not be null");
    L44:
        throw new IllegalArgumentException("container must not be null");
    L46:
        throw new IllegalArgumentException("Activity must not be null");
    L19:
        if (r108.f447562g == true) goto L21;
        r109 = null;
    L10:
        if (this.f447877f.f447560e == false) goto L12;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        if (r100 != 2) goto L5;
    L11:
        if (r102 != null) goto L13;
        return;
    L13:
        PhotoPickerInit<t> r103 = this.f447876e;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "data");
        mdc.a r104 = r103.f447735f;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        r104 = null;
    L16:
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "data");
        ndc.b<DATA> r105 = r104.f513432a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "data");
        Iterator r106 = r105.f518844b.iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        ((odc.a) r106.next()).a(r100, r101, r102);
        goto L18
    L20:
        r104.f513433b.d(r102);
        return;
    L5:
        if (r101 == 20001) goto L11;
        if (r100 != 2000) goto L23;
        if (r102 == null) goto L24;
        Intent r107 = new Intent();
        r107.putExtras(r102.getExtras());
        setResult(-1, r107);
        X90();
        return;
    L24:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Bundle r103 = getArguments();
        if (r103 != null) goto L5;
        boolean r104 = false;
    L15:
        if (r104 == true) goto L19;
        X90();
        return null;
    L19:
        return r100.inflate(R.layout.__picker_activity_take_pic, r101, false);
    L5:
        this.f447877f = s.a(r103);
        ArrayList r105 = (ArrayList) r103.getSerializable("ORIGINAL_PHOTOS");
        if (r105 == null) goto L14;
        Iterator r106 = r105.iterator();
    L9:
        if (r106.hasNext() == false) goto L14;
        Photo r107 = (Photo) r106.next();
        if (r107 == null) goto L9;
        List<t> r108 = this.f447875d;
        t r109 = new t();
        r109.f447736a = Integer.valueOf(r107.getId());
        r109.f447737b = r107.getPath();
        r109.f447738c = r107.getMimeType();
        r109.f447743h = (int) r107.getDuration();
        r109.f447740e = r107.getWidth();
        r109.f447741f = r107.getHeight();
        r109.f447742g = r107.getSize();
        ((ArrayList) r108).add(r109);
    L14:
        r104 = true;
        goto L15
    }

    public static void W90(PhotoPickerFrameFragment2 r100, rdc.s r101, boolean r102, boolean r103) {
        r100.getClass();
        r101.f537382d = r102;
        if (r103 == false) goto L11;
        LinkedList r104 = new LinkedList();
        Iterator r105 = ((ArrayList) r101.a()).iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        r104.add(Y90((t) r105.next()));
        goto L6
    L8:
        com.ss.android.lark.widget.photopicker.f.d r106 = com.ss.android.lark.widget.photopicker.f.a();
        boolean r107 = r100.f447877f.f447580y;
        r106.y();
        return;
    }

    public final boolean Z90(boolean r210, List<t> r211, Boolean r212, Boolean r213, String r214, boolean r215) {
        if (r211 != null) goto L5;
        List<t> r100 = new ArrayList();
    L6:
        ArrayList<String> r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator<t> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        t r104 = r103.next();
        Photo r110 = new Photo(r104.f447736a.intValue(), r104.f447737b, r104.f447738c, r104.f447743h, r104.f447740e, r104.f447741f, r104.f447742g);
        r101.add(r110.getPath());
        r102.add(r110);
        r103 = r103;
        goto L8
    L10:
        boolean r105 = r213.booleanValue();
        if (r210 == false) goto L27;
        com.ss.android.lark.widget.photopicker.i r111 = new com.ss.android.lark.widget.photopicker.i(new ArrayList(r102), new ArrayList(r101), Boolean.TRUE.equals(r212), r105, r214);
        ConcurrentHashMap<String, com.ss.android.lark.widget.photopicker.g> r106 = com.ss.android.lark.widget.photopicker.h.f447538a;
        String r107 = this.f447877f.f447581z;
        Intrinsics.checkNotNullParameter(r111, "request");
        if (r107 != null) goto L16;
    L19:
        boolean r108 = true;
    L20:
        if (r108 == true) goto L27;
        com.ss.android.lark.widget.photopicker.g r109 = com.ss.android.lark.widget.photopicker.h.f447538a.get(r107);
        if (r109 == null) goto L27;
        if (r109.onIntercept() != true) goto L27;
        boolean r112 = true;
    L29:
        if (r112 == false) goto L32;
        Log.i("PhotoPickerFrameFragment2", "photo selection intercepted in photo picker, photoCount = " + r100.size());
        return false;
    L32:
        Intent r113 = new Intent();
        r113.putExtra("KEY_SELECTED_MEDIA", new ArrayList(r102));
        r113.putStringArrayListExtra("SELECTED_PHOTOS", r101);
        r113.putExtra("KEEP_ORIGIN_PHOTO", r212);
        r113.putExtra("KEY_HAS_VIDEO", r105);
        r113.putExtra("KEY_FOR_SEND", r210);
        r113.putExtra("KEY_IS_INSERT_TO_INPUT", r215);
        r113.putExtra("choose_image_source", r214);
        setResult(-1, r113);
        Log.i("PhotoPickerFrameFragment2", "finish photo selection in photo picker, photoCount = " + r100.size());
        return true;
    L16:
        if (StringsKt.isBlank(r107) == true) goto L19;
        r108 = false;
    L27:
        r112 = false;
        goto L29
    L5:
        r100 = r211;
        goto L6
    }
}
