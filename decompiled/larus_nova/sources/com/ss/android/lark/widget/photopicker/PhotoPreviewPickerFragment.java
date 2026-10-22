package com.ss.android.lark.widget.photopicker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.apiplugin.common.OpenPlatform$Requests$OnActivityResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.photo.preview.PhotoPagerFragment;
import com.ss.android.lark.widget.photo.preview.PhotoPagerViewModel;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopickernew.PhotoInsertToInputView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class PhotoPreviewPickerFragment extends BaseFragment implements a {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f447432J = 0;
    public AppCompatCheckBox A;
    public CheckBox B;
    public View C;
    public View D;
    public View E;
    public p F;
    public bdc.c G;
    public PhotoPagerFragment H;
    public int I;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f447433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FragmentActivity f447434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f447435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f447436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f447437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f447438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f447439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f447440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f447441l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f447442m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f447443n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f447444o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f447445p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f447446q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<Photo> f447447r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<Photo> f447448s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList<String> f447449t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<String> f447450u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f447451v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f447452w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f447453x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f447454y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PhotoInsertToInputView f447455z;

    public final boolean U90() {
        Iterator r100 = ((ArrayList) this.f447448s).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((Photo) r100.next()).isVideo() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final void onBackPressed() {
        ArrayList r100 = new ArrayList(((ArrayList) this.f447448s).size());
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) this.f447448s).iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Photo r103 = (Photo) r102.next();
        if (r103 == null) goto L4;
        r100.add(r103.getPath());
        r101.add(r103);
        goto L4
    L9:
        Intent r104 = new Intent();
        r104.putStringArrayListExtra("SELECTED_PHOTOS", new ArrayList(r100));
        r104.putExtra("KEY_SELECTED_MEDIA", r101);
        r104.putExtra("KEEP_ORIGIN_PHOTO", this.f447441l);
        r104.putExtra("is_send_photo", false);
        r104.putExtra("KEY_HAS_VIDEO", U90());
        r104.putStringArrayListExtra("photo_new_old_map", this.f447449t);
        setResult(-1, r104);
        if (this.H.S90() == this.f447437h) goto L12;
        finish();
        this.f447434e.overridePendingTransition(0, 0);
        return;
    L12:
        if (this.f447435f == false) goto L14;
        this.G.a(this.f447434e);
        return;
    L14:
        finish();
    }

    public PhotoPreviewPickerFragment() {
        this.f447443n = 9;
        this.f447444o = 9;
        this.f447445p = false;
        this.f447446q = false;
        this.f447447r = new ArrayList();
        this.f447448s = new ArrayList();
        this.I = 3;
    }

    public final void S90(boolean r100) {
        ArrayList r101 = new ArrayList(this.f447448s);
        if (r101.isEmpty() == false) goto L13;
        PhotoPagerFragment r102 = this.H;
        if (r102 == null) goto L13;
        if (r102.isVisible() == false) goto L13;
        PhotoItem r103 = this.H.T90();
        if (r103 == null) goto L13;
        Photo r104 = r103.getPhoto();
        if (r104 == null) goto L13;
        r101.add(r104);
        ((ArrayList) this.f447448s).addAll(r101);
        String r105 = "preview-unselect";
    L15:
        if (r101.isEmpty() == false) goto L17;
        LKUIToast.show(this.f447434e, getString(R.string.Lark_Legacy_PickerMinCountTips));
        return;
    L17:
        ArrayList<String> r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
        Iterator r108 = r101.iterator();
    L19:
        if (r108.hasNext() == false) goto L24;
        Photo r109 = (Photo) r108.next();
        if (r109 == null) goto L19;
        r106.add(r109.getPath());
        r107.add(r109);
        goto L19
    L24:
        Intent r110 = new Intent();
        r110.putExtra("KEY_SELECTED_MEDIA", r107);
        r110.putStringArrayListExtra("SELECTED_PHOTOS", r106);
        r110.putExtra("KEEP_ORIGIN_PHOTO", this.f447441l);
        r110.putExtra("is_send_photo", true);
        r110.putExtra("is_insert_to_input", r100);
        r110.putExtra("KEY_HAS_VIDEO", U90());
        r110.putExtra("choose_image_source", r105);
        setResult(-1, r110);
        finish();
        return;
    L13:
        r105 = "preview-select";
        goto L15
    }

    public final void T90(Photo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = ((ArrayList) this.f447448s).contains(r100);
        this.A.setOnCheckedChangeListener(null);
        this.A.setChecked(r101);
        String r102 = "";
        if (r101 == false) goto L10;
        int r103 = ((ArrayList) this.f447448s).indexOf(r100);
        AppCompatCheckBox r104 = this.A;
        if (r103 < 0) goto L9;
        r102 = String.valueOf(r103 + 1);
    L9:
        r104.setText(r102);
    L11:
        this.A.setOnCheckedChangeListener(this.F);
        boolean r105 = this.f447442m;
        this.E.setEnabled(r105);
        if (r105 == false) goto L14;
        this.E.setVisibility(0);
        return;
    L14:
        this.E.setVisibility(4);
        return;
    L10:
        this.A.setText("");
        goto L11
    }

    public final void V90(boolean r100) {
        if (r100 == true) goto L4;
        this.B.setChecked(false);
    L4:
        this.B.setEnabled(r100);
        this.C.setEnabled(r100);
    }

    public final void W90(int r100) {
        if (r100 <= 0) goto L8;
        TextView r101 = this.f447453x;
        if (this.f447438i == false) goto L6;
        int r102 = R.string.Lark_Legacy_PickerSendWithCount;
    L7:
        r101.setText(UIHelper.mustacheFormat(r102, "count", Integer.toString(r100)));
    L14:
        if (this.f447444o == (-1)) goto L29;
        View r103 = this.f447452w;
        boolean r104 = true;
        if (this.f447443n > 0) goto L18;
    L20:
        boolean r105 = false;
    L21:
        r103.setEnabled(r105);
        TextView r106 = this.f447453x;
        if (this.f447443n > 0) goto L24;
    L26:
        r104 = false;
    L27:
        r106.setEnabled(r104);
        return;
    L24:
        if (this.f447436g <= 0) goto L26;
    L18:
        if (this.f447436g <= 0) goto L20;
        r105 = true;
        goto L21
    L29:
        return;
    L6:
        r102 = R.string.Lark_Legacy_PickerConfirmWithCount;
        goto L7
    L8:
        TextView r107 = this.f447453x;
        if (this.f447438i == false) goto L11;
        int r108 = R.string.Lark_Legacy_PickerSend;
    L12:
        r107.setText(r108);
        goto L14
    L11:
        r108 = R.string.Lark_Legacy_PickerConfirm;
        goto L12
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        super.onViewCreated(r110, r111);
        Bundle r112 = getArguments();
        boolean r100 = true;
        if (r112 != null) goto L5;
        boolean r113 = false;
    L41:
        if (r113 == true) goto L44;
        finish();
        return;
    L44:
        int r114 = jdc.c.f498781a;
        Statistics.sendEvent("public_pic_preview_view");
        View r115 = this.f447433d.findViewById(R.id.btn_back);
        this.f447451v = r115;
        r115.setOnClickListener(new m(this));
        this.f447453x = (TextView) this.f447433d.findViewById(R.id.btn_photo_send);
        this.f447452w = this.f447433d.findViewById(R.id.layout_photo_send);
        this.f447454y = this.f447433d.findViewById(R.id.layout_photo_insert_message);
        this.f447455z = (PhotoInsertToInputView) this.f447433d.findViewById(R.id.layout_photo_insert_message_new);
        View r116 = this.f447454y;
        if (this.f447439j == true) goto L47;
    L49:
        boolean r101 = false;
    L50:
        UIUtils.display(r116, r101);
        View r117 = this.f447433d;
        int r102 = R.id.photo_bottom_container;
        View r118 = r117.findViewById(R.id.photo_bottom_container);
        View r103 = this.f447433d.findViewById(R.id.container);
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r103.getLayoutParams();
        if (this.f447440k == false) goto L53;
        r102 = R.id.photo_bottom_content_anchor;
    L53:
        r104.addRule(2, r102);
        r103.setLayoutParams(r104);
        if (this.f447440k == false) goto L56;
        float r105 = UIUtils.dp2px(this.mContext, 1.0f);
    L57:
        r118.setElevation(r105);
        PhotoInsertToInputView r119 = this.f447455z;
        if (this.f447440k == true) goto L60;
    L62:
        boolean r106 = false;
    L63:
        r119.a(r106, false);
        this.f447454y.setOnClickListener(new k(this));
        this.f447455z.setOnInsertClickListener(new l(this));
        this.E = this.f447433d.findViewById(R.id.origin_zone);
        this.B = (CheckBox) this.f447433d.findViewById(R.id.cb_original_photo);
        this.C = this.f447433d.findViewById(R.id.original_label);
        this.f447452w.setOnClickListener(new n(this));
        W90(this.f447436g);
        View r120 = this.f447433d.findViewById(R.id.tv_edit_photo);
        this.D = r120;
        r120.setOnClickListener(new o(this));
        AppCompatCheckBox r121 = (AppCompatCheckBox) this.f447433d.findViewById(R.id.cb_select_photo);
        this.A = r121;
        p r107 = new p(this);
        this.F = r107;
        r121.setOnCheckedChangeListener(r107);
        int r122 = ((ArrayList) this.f447447r).size();
        int r108 = this.f447437h;
        if (r122 <= r108) goto L66;
        Photo r123 = (Photo) ListProtector.get(this.f447447r, r108);
    L67:
        T90(r123);
        this.B.setChecked(this.f447441l);
        this.B.setOnCheckedChangeListener(new q(this));
        ArrayList<PhotoItem> r124 = PhotoItem.getPhotoItemsByPhotos(this.f447447r);
        if (this.H != null) goto L74;
        PhotoPagerFragment r109 = PhotoPagerFragment.U90(r124, this.f447437h, false);
        this.H = r109;
        Intrinsics.checkNotNullParameter(this, "baseFragment");
        r109.f446525d = this;
        FragmentTransaction r125 = getChildFragmentManager().beginTransaction();
        PhotoPagerFragment r126 = this.H;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r125, r126, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.photoPagerFragment) == true) goto L73;
        r125 = r125.replace(R.id.photoPagerFragment, r126);
    L73:
        r125.commitAllowingStateLoss();
    L74:
        PhotoPagerFragment r127 = this.H;
        r r128 = new r(this, r124);
        r127.getClass();
        Intrinsics.checkNotNullParameter(r128, "listener");
        r127.f446535n = r128;
        boolean r129 = !r124.isEmpty();
        if (r129 == false) goto L83;
        PhotoItem r130 = (PhotoItem) ListProtector.get(r124, this.f447437h);
        if (r130 == null) goto L83;
        if (r130.isVideo() == false) goto L83;
        f.d r131 = f.a();
        r130.getCurrentUrl();
        if (r131.i() == true) goto L83;
        r129 = false;
    L83:
        UIUtils.display(this.D, r129);
        if (this.f447435f == false) goto L86;
        Intent r132 = new Intent();
        r132.putExtras(getArguments());
        bdc.a r133 = new bdc.a(r132);
        r133.f18713e = this.f447434e;
        r133.f18710b = this.f447433d;
        this.G = r133.a(r111);
    L86:
        this.f447450u = new ArrayList();
        this.f447449t = new ArrayList();
        if (this.f447444o != (-1)) goto L89;
        return;
    L89:
        if (this.f447443n > 0) goto L92;
        r100 = false;
    L92:
        V90(r100);
        return;
    L66:
        this.f447437h = 0;
        r123 = null;
        goto L67
    L60:
        if (this.f447436g <= 0) goto L62;
        r106 = true;
        goto L63
    L56:
        r105 = 0.0f;
        goto L57
    L47:
        if (this.f447440k == true) goto L49;
        r101 = true;
        goto L50
    L5:
        this.f447435f = r112.getBoolean("is_use_transition_anim", true);
        this.f447437h = r112.getInt("current_item", 0);
        r112.getBoolean("show_delete", true);
        this.f447438i = r112.getBoolean("IS_SEND", true);
        boolean r134 = r112.getBoolean("INSERT_TO_INPUT_ENABLED", false);
        this.f447439j = r134;
        if (r134 == true) goto L8;
    L10:
        boolean r135 = false;
    L11:
        this.f447440k = r135;
        this.I = r112.getInt("MEDIA_TYPE", 3);
        r112.getBoolean("enable_pre_upload", false);
        String r136 = r112.getString("key_photos_preview_picker");
        kdc.b r137 = kdc.b.a.f502995a;
        Context r138 = this.mContext;
        List r139 = (List) r137.f502994a.remove(r136);
        if (r139 != null) goto L33;
        PolarisFileWrapper r140 = new PolarisFileWrapper(r138.getExternalCacheDir(), OpenPlatform$Requests$OnActivityResult.INTENT_DATA + File.separator + r136 + Global.SUFFIX_DATA_FILE);
        int r141 = kdc.a.f502993a;
        String r142 = r140.getAbsolutePath();
        Intrinsics.checkNotNullParameter(r142, "filePath");
        if (TextUtils.isEmpty(r142) == false) goto L16;
        ArrayList r143 = new ArrayList(0);
    L31:
        if (r140.delete() == true) goto L37;
        Log.w("PhotoTransmitHelper", "cannot remove file: " + r140.getAbsolutePath());
    L37:
        ((ArrayList) this.f447447r).addAll(r143);
        ArrayList r144 = (ArrayList) r112.getSerializable("SELECTED_ITEMS");
        if (r144 == null) goto L40;
        ((ArrayList) this.f447448s).addAll(r144);
        this.f447436g = ((ArrayList) this.f447448s).size();
    L40:
        this.f447441l = r112.getBoolean("keep_origin", false);
        this.f447442m = r112.getBoolean("SHOW_ORIGIN", true);
        this.f447443n = r112.getInt("MAX_COUNT", 9);
        this.f447444o = r112.getInt("TOTAL_MAX_COUNT", -1);
        this.f447445p = r112.getBoolean("TOTAL_HAS_VIDEO", false);
        this.f447446q = r112.getBoolean("SINGLE_VIDEO", false);
        r113 = true;
        goto L41
    L16:
        PolarisFileWrapper r145 = new PolarisFileWrapper(r142);
        if (r145.exists() == true) goto L96;
        r143 = new ArrayList(0);
        goto L31
    L96:
        PolarisFileInputStreamWrapper r146 = new PolarisFileInputStreamWrapper(r145);     // Catch: Exception -> L28
        int r147 = r146.available();     // Catch: Throwable -> L23
        byte[] r148 = new byte[r147];     // Catch: Throwable -> L23
        r146.read(r148);     // Catch: Throwable -> L23
        Parcel r149 = Parcel.obtain();     // Catch: Throwable -> L23
        r149.unmarshall(r148, 0, r147);     // Catch: Throwable -> L23
        r149.setDataPosition(0);     // Catch: Throwable -> L23
        ArrayList r150 = new ArrayList(r149.readInt());     // Catch: Throwable -> L23
        r149.readTypedList(r150, Photo.CREATOR);     // Catch: Throwable -> L23
        r149.recycle();     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r146, null);     // Catch: Exception -> L28
        r143 = r150;
        goto L31
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r146, th);     // Catch: Exception -> L28
        throw th;     // Catch: Exception -> L28
    L28:
        e = move-exception;
        Log.e("PhotoLocalMediaParcelableUtils", e.getMessage());
        r143 = new ArrayList(0);
        goto L31
    L33:
        r143 = new ArrayList();
        int r151 = 0;
    L35:
        if (r151 >= r139.size()) goto L37;
        r143.add(new Photo((Photo) ListProtector.get(r139, r151)));
        r151 = r151 + 1;
        goto L35
    L8:
        if (r112.getBoolean("INSERT_TO_INPUT_NEW_INTERACTION_ENABLED", false) == false) goto L10;
        r135 = true;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 != 1) goto L7;
        if (r101 != (-1)) goto L7;
    L9:
        if (r102 != null) goto L11;
    L23:
        Log.e("PhotoPreviewPickerFragment", "data is null");
        return;
    L11:
        if (CollectionUtils.isEmpty(this.f447447r) == true) goto L23;
        String r103 = r102.getStringExtra("key_result_path_decrypt");
        if (r103 != null) goto L16;
        r103 = r102.getStringExtra("key_result_path");
    L16:
        ((ArrayList) this.f447450u).add(r103);
        Log.i("PhotoPreviewPickerFragment", "onActivityResult resultImage = " + r103);
        Photo r104 = (Photo) ListProtector.get(this.f447447r, this.H.S90());
        this.f447449t.add(r104.getPath());
        this.f447449t.add(r103);
        Photo r105 = new Photo(r104);
        r105.setPath(r103);
        int r106 = r102.getIntExtra("key_editor_width", r104.getWidth());
        int r107 = r102.getIntExtra("key_editor_height", r104.getHeight());
        r105.setWidth(r106);
        r105.setHeight(r107);
        r105.setDuration(r102.getLongExtra("key_result_duration", r104.getDuration()));
        ListProtector.set(this.f447447r, this.H.S90(), r105);
        if (((ArrayList) this.f447448s).contains(r104) == false) goto L19;
        ListProtector.set(this.f447448s, ((ArrayList) this.f447448s).indexOf(r104), r105);
    L19:
        PhotoPagerFragment r108 = this.H;
        PhotoItem r109 = PhotoItem.getPhotoItemByPhoto(r104);
        PhotoItem r110 = PhotoItem.getPhotoItemByPhoto(r105);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "originItem");
        Intrinsics.checkNotNullParameter(r110, "updateItem");
        PhotoPagerViewModel r111 = r108.f446532k;
        if (r111 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r111 = null;
    L22:
        r111.updateItem(r109, r110);
        return;
    L7:
        if (r101 == 20001) goto L9;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.f447433d = r100.inflate(R.layout.__picker_activity_photo_preview_picker, r101, false);
        this.f447434e = getActivity();
        return this.f447433d;
    }
}
