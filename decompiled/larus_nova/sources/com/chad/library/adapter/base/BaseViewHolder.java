package com.chad.library.adapter.base;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private BaseQuickAdapter adapter;
    private Object associatedObject;
    private final LinkedHashSet<Integer> childClickViewIds;
    public View convertView;
    private final LinkedHashSet<Integer> itemChildLongClickViewIds;
    private final HashSet<Integer> nestViews;
    private final SparseArray<View> views;

    public Object getAssociatedObject() {
        return this.associatedObject;
    }

    public HashSet<Integer> getChildClickViewIds() {
        return this.childClickViewIds;
    }

    public View getConvertView() {
        return this.convertView;
    }

    public HashSet<Integer> getItemChildLongClickViewIds() {
        return this.itemChildLongClickViewIds;
    }

    public Set<Integer> getNestViews() {
        return this.nestViews;
    }

    public BaseViewHolder(View r100) {
        super(r100);
        this.views = new SparseArray();
        this.childClickViewIds = new LinkedHashSet();
        this.itemChildLongClickViewIds = new LinkedHashSet();
        this.nestViews = new HashSet();
        this.convertView = r100;
    }

    public static /* synthetic */ BaseQuickAdapter access$000(BaseViewHolder r100) {
        return r100.adapter;
    }

    public BaseViewHolder addOnClickListener(int... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        int r103 = r100[r102];
        this.childClickViewIds.add(Integer.valueOf(r103));
        View r104 = getView(r103);
        if (r104 == null) goto L10;
        if (r104.isClickable() == true) goto L9;
        r104.setClickable(true);
    L9:
        r104.setOnClickListener(new AnonymousClass1(this));
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        return this;
    }

    public BaseViewHolder addOnLongClickListener(int... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        int r103 = r100[r102];
        this.itemChildLongClickViewIds.add(Integer.valueOf(r103));
        View r104 = getView(r103);
        if (r104 == null) goto L10;
        if (r104.isLongClickable() == true) goto L9;
        r104.setLongClickable(true);
    L9:
        r104.setOnLongClickListener(new AnonymousClass2(this));
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        return this;
    }

    public <T extends View> T getView(int r100) {
        T r101 = (T) this.views.get(r100);
        if (r101 != null) goto L6;
        T r102 = (T) this.itemView.findViewById(r100);
        this.views.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public BaseViewHolder linkify(int r100) {
        Linkify.addLinks((TextView) getView(r100), 15);
        return this;
    }

    public BaseViewHolder setAdapter(BaseQuickAdapter r100) {
        this.adapter = r100;
        return this;
    }

    public void setAssociatedObject(Object r100) {
        this.associatedObject = r100;
    }

    public BaseViewHolder setNestView(int... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        int r103 = r100[r102];
        this.nestViews.add(Integer.valueOf(r103));
        r102 = r102 + 1;
        goto L3
    L5:
        addOnClickListener(r100);
        addOnLongClickListener(r100);
        return this;
    }

    public BaseViewHolder setAdapter(int r100, Adapter r101) {
        ((AdapterView) getView(r100)).setAdapter(r101);
        return this;
    }

    public BaseViewHolder setAlpha(int r100, float r101) {
        getView(r100).setAlpha(r101);
        return this;
    }

    public BaseViewHolder setBackgroundColor(int r100, int r101) {
        getView(r100).setBackgroundColor(r101);
        return this;
    }

    public BaseViewHolder setBackgroundRes(int r100, int r101) {
        getView(r100).setBackgroundResource(r101);
        return this;
    }

    public BaseViewHolder setChecked(int r100, boolean r101) {
        KeyEvent.Callback r102 = getView(r100);
        if ((r102 instanceof Checkable) == false) goto L5;
        ((Checkable) r102).setChecked(r101);
    L5:
        return this;
    }

    public BaseViewHolder setEnabled(int r100, boolean r101) {
        getView(r100).setEnabled(r101);
        return this;
    }

    public BaseViewHolder setGone(int r100, boolean r101) {
        View r102 = getView(r100);
        if (r101 == false) goto L5;
        int r103 = 0;
    L6:
        r102.setVisibility(r103);
        return this;
    L5:
        r103 = 8;
        goto L6
    }

    public BaseViewHolder setImageBitmap(int r100, Bitmap r101) {
        ((ImageView) getView(r100)).setImageBitmap(r101);
        return this;
    }

    public BaseViewHolder setImageDrawable(int r100, Drawable r101) {
        ((ImageView) getView(r100)).setImageDrawable(r101);
        return this;
    }

    public BaseViewHolder setImageResource(int r100, int r101) {
        ((ImageView) getView(r100)).setImageResource(r101);
        return this;
    }

    public BaseViewHolder setMax(int r100, int r101) {
        ((ProgressBar) getView(r100)).setMax(r101);
        return this;
    }

    public BaseViewHolder setOnCheckedChangeListener(int r100, CompoundButton.OnCheckedChangeListener r101) {
        ((CompoundButton) getView(r100)).setOnCheckedChangeListener(r101);
        return this;
    }

    public BaseViewHolder setOnClickListener(int r100, View.OnClickListener r101) {
        getView(r100).setOnClickListener(r101);
        return this;
    }

    public BaseViewHolder setOnItemClickListener(int r100, AdapterView.OnItemClickListener r101) {
        ((AdapterView) getView(r100)).setOnItemClickListener(r101);
        return this;
    }

    public BaseViewHolder setOnItemLongClickListener(int r100, AdapterView.OnItemLongClickListener r101) {
        ((AdapterView) getView(r100)).setOnItemLongClickListener(r101);
        return this;
    }

    public BaseViewHolder setOnItemSelectedClickListener(int r100, AdapterView.OnItemSelectedListener r101) {
        ((AdapterView) getView(r100)).setOnItemSelectedListener(r101);
        return this;
    }

    public BaseViewHolder setOnLongClickListener(int r100, View.OnLongClickListener r101) {
        getView(r100).setOnLongClickListener(r101);
        return this;
    }

    public BaseViewHolder setOnTouchListener(int r100, View.OnTouchListener r101) {
        getView(r100).setOnTouchListener(r101);
        return this;
    }

    public BaseViewHolder setProgress(int r100, int r101) {
        ((ProgressBar) getView(r100)).setProgress(r101);
        return this;
    }

    public BaseViewHolder setRating(int r100, float r101) {
        ((RatingBar) getView(r100)).setRating(r101);
        return this;
    }

    public BaseViewHolder setTag(int r100, Object r101) {
        getView(r100).setTag(r101);
        return this;
    }

    public BaseViewHolder setText(int r100, int r101) {
        ((TextView) getView(r100)).setText(r101);
        return this;
    }

    public BaseViewHolder setTextColor(int r100, int r101) {
        ((TextView) getView(r100)).setTextColor(r101);
        return this;
    }

    public BaseViewHolder setTypeface(Typeface r100, int... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        TextView r104 = (TextView) getView(r101[r103]);
        r104.setTypeface(r100);
        r104.setPaintFlags(r104.getPaintFlags() | 128);
        r103 = r103 + 1;
        goto L3
    L5:
        return this;
    }

    public BaseViewHolder setVisible(int r100, boolean r101) {
        View r102 = getView(r100);
        if (r101 == false) goto L5;
        int r103 = 0;
    L6:
        r102.setVisibility(r103);
        return this;
    L5:
        r103 = 4;
        goto L6
    }

    public BaseViewHolder setText(int r100, CharSequence r101) {
        ((TextView) getView(r100)).setText(r101);
        return this;
    }

    public BaseViewHolder setTypeface(int r100, Typeface r101) {
        TextView r102 = (TextView) getView(r100);
        r102.setTypeface(r101);
        r102.setPaintFlags(r102.getPaintFlags() | 128);
        return this;
    }

    public BaseViewHolder setProgress(int r100, int r101, int r102) {
        ProgressBar r103 = (ProgressBar) getView(r100);
        r103.setMax(r102);
        r103.setProgress(r101);
        return this;
    }

    public BaseViewHolder setRating(int r100, float r101, int r102) {
        RatingBar r103 = (RatingBar) getView(r100);
        r103.setMax(r102);
        r103.setRating(r101);
        return this;
    }

    public BaseViewHolder setTag(int r100, int r101, Object r102) {
        getView(r100).setTag(r101, r102);
        return this;
    }
}
