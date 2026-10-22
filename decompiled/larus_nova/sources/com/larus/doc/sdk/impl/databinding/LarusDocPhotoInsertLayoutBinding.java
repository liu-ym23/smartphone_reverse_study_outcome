package com.larus.doc.sdk.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDocPhotoInsertLayoutBinding implements ViewBinding {
    public final LinearLayout docBottomMenuContainer;
    public final LinearLayout docBottomMenuItemCamera;
    public final LinearLayout docBottomMenuItemPhoto;
    public final LinearLayout docBottomPhotoSelectContainer;
    public final View docPhotoPickTopBorder;
    public final ImageView layoutMenuItemIconCamera;
    public final AppCompatTextView layoutMenuItemName;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LarusDocPhotoInsertLayoutBinding bind(View r110) {
        int r100 = R.id.doc_bottom_menu_container;
        LinearLayout r101 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.doc_bottom_menu_container);
        if (r101 == null) goto L17;
        r100 = R.id.doc_bottom_menu_item_camera;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.doc_bottom_menu_item_camera);
        if (r102 == null) goto L17;
        r100 = R.id.doc_bottom_menu_item_photo;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r110, R.id.doc_bottom_menu_item_photo);
        if (r103 == null) goto L17;
        LinearLayout r104 = (LinearLayout) r110;
        r100 = R.id.doc_photo_pick_top_border;
        View r105 = ViewBindings.findChildViewById(r110, R.id.doc_photo_pick_top_border);
        if (r105 == null) goto L17;
        r100 = R.id.layout_menu_item_icon_camera;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r110, R.id.layout_menu_item_icon_camera);
        if (r106 == null) goto L17;
        r100 = R.id.layout_menu_item_name;
        AppCompatTextView r111 = (AppCompatTextView) ViewBindings.findChildViewById(r110, R.id.layout_menu_item_name);
        if (r111 == null) goto L17;
        return new LarusDocPhotoInsertLayoutBinding(r104, r101, r102, r103, r104, r105, r106, r111);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public static LarusDocPhotoInsertLayoutBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static LarusDocPhotoInsertLayoutBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.larus_doc_photo_insert_layout, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private LarusDocPhotoInsertLayoutBinding(LinearLayout r100, LinearLayout r101, LinearLayout r102, LinearLayout r103, LinearLayout r104, View r105, ImageView r106, AppCompatTextView r107) {
        this.rootView = r100;
        this.docBottomMenuContainer = r101;
        this.docBottomMenuItemCamera = r102;
        this.docBottomMenuItemPhoto = r103;
        this.docBottomPhotoSelectContainer = r104;
        this.docPhotoPickTopBorder = r105;
        this.layoutMenuItemIconCamera = r106;
        this.layoutMenuItemName = r107;
    }
}
