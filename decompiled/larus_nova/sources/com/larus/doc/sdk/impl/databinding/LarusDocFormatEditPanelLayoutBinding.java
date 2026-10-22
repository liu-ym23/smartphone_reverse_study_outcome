package com.larus.doc.sdk.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDocFormatEditPanelLayoutBinding implements ViewBinding {
    public final ImageView formatAlignCenter;
    public final ImageView formatAlignLeft;
    public final ImageView formatAlignRight;
    public final ImageView formatBlockquote;
    public final ImageView formatBold;
    public final ImageView formatCheckbox;
    public final TextView formatH1;
    public final TextView formatH2;
    public final TextView formatH3;
    public final ImageView formatIndentLeft;
    public final ImageView formatIndentRight;
    public final ImageView formatItalic;
    public final ImageView formatOrderedList;
    public final TextView formatPlaintext;
    public final ImageView formatStrikethrough;
    public final ImageView formatUnderline;
    public final ImageView formatUnorderedList;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LarusDocFormatEditPanelLayoutBinding bind(View r210) {
        int r100 = R.id.format_align_center;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_align_center);
        if (r101 == null) goto L39;
        r100 = R.id.format_align_left;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_align_left);
        if (r102 == null) goto L39;
        r100 = R.id.format_align_right;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_align_right);
        if (r103 == null) goto L39;
        r100 = R.id.format_blockquote;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_blockquote);
        if (r104 == null) goto L39;
        r100 = R.id.format_bold;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_bold);
        if (r105 == null) goto L39;
        r100 = R.id.format_checkbox;
        ImageView r110 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_checkbox);
        if (r110 == null) goto L39;
        r100 = R.id.format_h1;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r210, R.id.format_h1);
        if (r111 == null) goto L39;
        r100 = R.id.format_h2;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r210, R.id.format_h2);
        if (r112 == null) goto L39;
        r100 = R.id.format_h3;
        TextView r113 = (TextView) ViewBindings.findChildViewById(r210, R.id.format_h3);
        if (r113 == null) goto L39;
        r100 = R.id.format_indent_left;
        ImageView r114 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_indent_left);
        if (r114 == null) goto L39;
        r100 = R.id.format_indent_right;
        ImageView r115 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_indent_right);
        if (r115 == null) goto L39;
        r100 = R.id.format_italic;
        ImageView r116 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_italic);
        if (r116 == null) goto L39;
        r100 = R.id.format_ordered_list;
        ImageView r117 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_ordered_list);
        if (r117 == null) goto L39;
        r100 = R.id.format_plaintext;
        TextView r118 = (TextView) ViewBindings.findChildViewById(r210, R.id.format_plaintext);
        if (r118 == null) goto L39;
        r100 = R.id.format_strikethrough;
        ImageView r119 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_strikethrough);
        if (r119 == null) goto L39;
        r100 = R.id.format_underline;
        ImageView r211 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_underline);
        if (r211 == null) goto L39;
        r100 = R.id.format_unordered_list;
        ImageView r212 = (ImageView) ViewBindings.findChildViewById(r210, R.id.format_unordered_list);
        if (r212 == null) goto L39;
        return new LarusDocFormatEditPanelLayoutBinding((LinearLayout) r210, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r212);
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r210.getResources().getResourceName(r100)));
    }

    public static LarusDocFormatEditPanelLayoutBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static LarusDocFormatEditPanelLayoutBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.larus_doc_format_edit_panel_layout, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private LarusDocFormatEditPanelLayoutBinding(LinearLayout r100, ImageView r101, ImageView r102, ImageView r103, ImageView r104, ImageView r105, ImageView r106, TextView r110, TextView r111, TextView r112, ImageView r113, ImageView r114, ImageView r115, ImageView r116, TextView r117, ImageView r118, ImageView r119, ImageView r210) {
        this.rootView = r100;
        this.formatAlignCenter = r101;
        this.formatAlignLeft = r102;
        this.formatAlignRight = r103;
        this.formatBlockquote = r104;
        this.formatBold = r105;
        this.formatCheckbox = r106;
        this.formatH1 = r110;
        this.formatH2 = r111;
        this.formatH3 = r112;
        this.formatIndentLeft = r113;
        this.formatIndentRight = r114;
        this.formatItalic = r115;
        this.formatOrderedList = r116;
        this.formatPlaintext = r117;
        this.formatStrikethrough = r118;
        this.formatUnderline = r119;
        this.formatUnorderedList = r210;
    }
}
