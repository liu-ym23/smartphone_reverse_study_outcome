package com.larksuite.component.ui.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes24.dex */
public class LKUISearchView extends LinearLayout implements TextWatcher {
    public final TextView A;
    public final ImageView B;
    public final RelativeLayout C;
    public View.OnFocusChangeListener D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f284280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f284284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f284285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f284286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f284287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f284288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f284289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f284290k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f284291l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f284292m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f284293n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f284294o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f284295p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f284296q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f284297r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f284298s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f284299t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f284300u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SearchIconGravity f284301v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final LKUIClearEditText f284302w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final TextView f284303x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ImageView f284304y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ImageView f284305z;

    public static final enum SearchIconGravity extends Enum<SearchIconGravity> {
        public static final SearchIconGravity CENTER = null;
        public static final SearchIconGravity LEFT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SearchIconGravity[] f284306a = null;

        static {
            SearchIconGravity r100 = new SearchIconGravity("LEFT", 0);
            LEFT = r100;
            SearchIconGravity r101 = new SearchIconGravity("CENTER", 1);
            CENTER = r101;
            f284306a = new SearchIconGravity[]{r100, r101};
        }

        public static SearchIconGravity[] values() {
            return (SearchIconGravity[]) f284306a.clone();
        }

        public int toGravity() {
            if (c.f284309a[ordinal()] == 2) goto L6;
            return GravityCompat.START;
        L6:
            return 17;
        }

        public static SearchIconGravity valueOf(String r100) {
            return (SearchIconGravity) r27.a.a(SearchIconGravity.class, r100);
        }

        public SearchIconGravity(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUISearchView f284307a;

        public a(LKUISearchView r100) {
            this.f284307a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            LKUISearchView r111 = this.f284307a;
            r111.f284302w.setText(r111.f284289j);
            r111.f284303x.setVisibility(8);
            r111.f284302w.setVisibility(0);
            r111.f284302w.requestFocus();
            if (r111.f284286g == false) goto L5;
            r111.A.setVisibility(0);
        L5:
            TranslateAnimation r100 = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            r100.setDuration(200);
            r111.A.startAnimation(r100);
            r111.postDelayed(new e08.b(r111), 50);
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUISearchView f284308a;

        public b(LKUISearchView r100) {
            this.f284308a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f284308a.a();
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284309a = null;

        static {
            int[] r100 = new int[SearchIconGravity.values().length];
            f284309a = r100;
            r100[SearchIconGravity.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f284309a[SearchIconGravity.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public final void a() {
        this.f284289j = "";
        this.f284302w.setText("");
        this.f284302w.setVisibility(8);
        this.f284303x.setVisibility(0);
        this.A.setVisibility(8);
        this.f284302w.clearFocus();
        TranslateAnimation r100 = new TranslateAnimation(1, 0.0f, 1, 1.5f, 1, 0.0f, 1, 0.0f);
        r100.setDuration(200);
        this.A.startAnimation(r100);
        postDelayed(new e08.c(this), 50);
    }

    public ImageView getBackImageView() {
        return this.B;
    }

    public TextView getCancelView() {
        return this.A;
    }

    public LKUIClearEditText getEditView() {
        return this.f284302w;
    }

    public TextView getHintView() {
        return this.f284303x;
    }

    public RelativeLayout getInputLayout() {
        return this.C;
    }

    public ImageView getLeftImageView() {
        return this.f284304y;
    }

    public ImageView getRightImageView() {
        return this.f284305z;
    }

    public CharSequence getSearchText() {
        return this.f284289j;
    }

    public LKUISearchView(Context r100) {
        this(r100, null);
    }

    public static void b(View r100) {
        InputMethodManager r101 = (InputMethodManager) r100.getContext().getSystemService("input_method");
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isActive() == false) goto L9;
        r101.hideSoftInputFromWindow(r100.getApplicationWindowToken(), 0);
        return;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        this.f284289j = r100;
    }

    public void setCancelEnabled(boolean r100) {
        this.f284286g = r100;
        if (r100 == true) goto L6;
        this.A.setVisibility(8);
        return;
    }

    public void setCancelTextColor(int r100) {
        this.f284282c = r100;
        this.A.setTextColor(r100);
    }

    public void setCancelTextSize(float r100) {
        this.f284284e = r100;
        this.A.setTextSize(r100);
    }

    public void setClearDrawable(Drawable r100) {
        this.f284302w.setClearDrawable(r100);
    }

    public void setClearDrawableResId(int r100) {
        this.f284290k = r100;
        this.f284302w.setClearDrawable(r100);
    }

    public void setClearEnabled(boolean r100) {
        this.f284291l = r100;
        this.f284302w.setClearIconVisible(r100);
    }

    public void setEditTextCursorColor(int r100) {
        this.f284283d = r100;
        this.f284302w.setCursorColor(r100);
    }

    public void setFocusChangeListener(View.OnFocusChangeListener r100) {
        this.D = r100;
    }

    public void setHintTextColor(int r100) {
        this.f284280a = r100;
        this.f284303x.setTextColor(r100);
        this.f284302w.setHintTextColor(r100);
        invalidate();
    }

    public void setInputLayoutBackGroundColor(int r100) {
        RelativeLayout r101 = this.C;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getBackground() == null) goto L17;
        Drawable r102 = this.C.getBackground();
        r102.mutate();
        if ((r102 instanceof GradientDrawable) == false) goto L10;
        ((GradientDrawable) r102).setColor(r100);
        return;
    L10:
        if ((r102 instanceof ShapeDrawable) == false) goto L13;
        ((ShapeDrawable) r102).getPaint().setColor(r100);
        return;
    L13:
        if ((r102 instanceof ColorDrawable) == false) goto L20;
        ((ColorDrawable) r102).setColor(r100);
        return;
    L20:
        return;
    }

    public void setLeftDrawable(Drawable r100) {
        this.f284304y.setImageDrawable(r100);
    }

    public void setLeftDrawableResId(int r100) {
        this.f284292m = r100;
        this.f284304y.setImageResource(r100);
    }

    public void setRightDrawable(Drawable r100) {
        this.f284305z.setImageDrawable(r100);
    }

    public void setRightDrawableEnabled(boolean r100) {
        this.f284296q = r100;
        ImageView r101 = this.f284305z;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setRightDrawableResId(int r100) {
        this.f284295p = r100;
        this.f284305z.setImageResource(r100);
    }

    public void setTextSize(float r100) {
        this.f284285f = r100;
        this.f284303x.setTextSize(r100);
        this.f284302w.setTextSize(r100);
    }

    public LKUISearchView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LKUISearchView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f284286g = true;
        int r100 = 0;
        this.f284287h = false;
        this.f284290k = R.drawable.lkui_navigation_search_clear;
        this.f284291l = true;
        this.f284292m = R.drawable.lkui_navigation_search;
        this.f284295p = R.drawable.lkui_navigation_search;
        this.f284296q = false;
        this.f284299t = R.drawable.lkui_navigation_searchview_bg;
        SearchIconGravity r101 = SearchIconGravity.LEFT;
        this.f284301v = r101;
        LinearLayout.inflate(r110, R.layout.lkui_navigation_search_layout, this);
        LKUIClearEditText r102 = (LKUIClearEditText) findViewById(R.id.input_view);
        this.f284302w = r102;
        ImageView r103 = (ImageView) findViewById(R.id.drawable_left);
        this.f284304y = r103;
        ImageView r113 = (ImageView) findViewById(R.id.drawable_right);
        this.f284305z = r113;
        RelativeLayout r114 = (RelativeLayout) findViewById(R.id.input_layout);
        this.C = r114;
        TextView r115 = (TextView) findViewById(R.id.hint_text);
        this.f284303x = r115;
        TextView r116 = (TextView) findViewById(R.id.cancel);
        this.A = r116;
        ImageView r117 = (ImageView) findViewById(R.id.search_titlebar_left);
        this.B = r117;
        r102.setSingleLine(true);
        r102.setInputType(1);
        if (r111 == null) goto L24;
        TypedArray r104 = getContext().obtainStyledAttributes(r111, new int[]{R.attr.search_back_enabled, R.attr.search_cancel_enabled, R.attr.search_cancel_text, R.attr.search_cancel_textColor, R.attr.search_cancel_textSize, R.attr.search_clear_drawable, R.attr.search_clear_enabled, R.attr.search_edit_text_cursorColor, R.attr.search_hint_text, R.attr.search_hint_textColor, R.attr.search_input_background, R.attr.search_input_background_color, R.attr.search_left_drawable, R.attr.search_left_drawable_height, R.attr.search_left_drawable_width, R.attr.search_right_drawable, R.attr.search_right_drawable_enabled, R.attr.search_right_drawable_height, R.attr.search_right_drawable_width, R.attr.search_search_icon_gravity, R.attr.search_textColor, R.attr.search_textSize});
        this.f284280a = r104.getColor(9, ContextCompat.getColor(getContext(), R.color.text_placeholder));
        this.f284285f = r104.getDimension(21, j08.b.e(getContext(), 14.0f));
        this.f284281b = r104.getColor(20, ContextCompat.getColor(getContext(), R.color.text_title));
        this.f284287h = r104.getBoolean(0, false);
        this.f284286g = r104.getBoolean(1, true);
        this.f284282c = r104.getColor(3, ContextCompat.getColor(getContext(), R.color.primary_fill_default));
        r104.getString(2);
        this.f284284e = r104.getDimension(4, j08.b.e(getContext(), 14.0f));
        this.f284283d = r104.getColor(7, ContextCompat.getColor(getContext(), R.color.primary_fill_default));
        this.f284292m = r104.getResourceId(12, R.drawable.lkui_navigation_search);
        if (AppCompatResources.getDrawable(getContext(), this.f284292m) == null) goto L7;
        float r105 = AppCompatResources.getDrawable(getContext(), this.f284292m).getIntrinsicWidth();
    L8:
        this.f284293n = (int) r104.getDimension(14, r105);
        if (AppCompatResources.getDrawable(getContext(), this.f284292m) == null) goto L11;
        float r106 = AppCompatResources.getDrawable(getContext(), this.f284292m).getIntrinsicHeight();
    L12:
        this.f284294o = (int) r104.getDimension(13, r106);
        this.f284295p = r104.getResourceId(15, R.drawable.lkui_navigation_search);
        if (AppCompatResources.getDrawable(getContext(), this.f284295p) == null) goto L15;
        float r107 = AppCompatResources.getDrawable(getContext(), this.f284295p).getIntrinsicWidth();
    L16:
        this.f284297r = (int) r104.getDimension(18, r107);
        if (AppCompatResources.getDrawable(getContext(), this.f284295p) == null) goto L19;
        float r108 = AppCompatResources.getDrawable(getContext(), this.f284295p).getIntrinsicHeight();
    L20:
        this.f284298s = (int) r104.getDimension(17, r108);
        this.f284296q = r104.getBoolean(16, false);
        this.f284290k = r104.getResourceId(5, R.drawable.lkui_navigation_search_clear);
        this.f284291l = r104.getBoolean(6, true);
        this.f284300u = r104.getColor(11, ContextCompat.getColor(getContext(), R.color.bg_filler));
        this.f284299t = r104.getResourceId(10, R.drawable.lkui_navigation_searchview_bg);
        String r109 = r104.getString(8);
        this.f284288i = r109;
        if (r109 != null) goto L23;
        this.f284288i = getResources().getString(R.string.Lark_Legacy_Search);
        getResources().getString(R.string.Lark_Legacy_Cancel);
    L23:
        this.f284301v = SearchIconGravity.values()[r104.getInt(19, r101.ordinal())];
        r104.recycle();
    L41:
        r115.setTextSize(0, a08.b.a(this.f284285f, getContext()));
        r115.setTextColor(this.f284280a);
        r102.setHintTextColor(this.f284280a);
        r102.setTextSize(0, a08.b.a(this.f284285f, getContext()));
        r102.setTextColor(this.f284281b);
        r102.setCursorColor(this.f284283d);
        r116.setTextColor(this.f284282c);
        r116.setTextSize(0, a08.b.a(this.f284284e, getContext()));
        if (this.f284286g == true) goto L44;
        r116.setVisibility(8);
    L44:
        r103.setImageResource(this.f284292m);
        ViewGroup.LayoutParams r118 = r103.getLayoutParams();
        r118.width = this.f284293n;
        r118.height = this.f284294o;
        r103.setLayoutParams(r118);
        ViewGroup.LayoutParams r119 = r113.getLayoutParams();
        r119.width = this.f284297r;
        r119.height = this.f284298s;
        r113.setLayoutParams(r119);
        r113.setImageResource(this.f284295p);
        if (this.f284296q == false) goto L47;
        int r120 = 0;
    L48:
        r113.setVisibility(r120);
        r102.setClearDrawable(this.f284290k);
        r102.setClearEnable(this.f284291l);
        r115.setText(this.f284288i);
        r102.setHint(this.f284288i);
        r114.setGravity(this.f284301v.toGravity());
        r114.setBackgroundResource(this.f284299t);
        setInputLayoutBackGroundColor(this.f284300u);
        if (this.f284287h == true) goto L52;
        r100 = 8;
    L52:
        r117.setVisibility(r100);
        if (this.f284287h == false) goto L55;
        r117.setOnClickListener(new e08.a(this));
    L55:
        ((ViewGroup) findViewById(R.id.root)).getLayoutTransition().setDuration(200);
        r114.setOnClickListener(new a(this));
        r116.setOnClickListener(new b(this));
        r102.addTextChangedListener(this);
        return;
    L47:
        r120 = 8;
        goto L48
    L19:
        r108 = j08.b.a(getContext(), 16.0f);
        goto L20
    L15:
        r107 = j08.b.a(getContext(), 16.0f);
        goto L16
    L11:
        r106 = j08.b.a(getContext(), 16.0f);
        goto L12
    L7:
        r105 = j08.b.a(getContext(), 16.0f);
        goto L8
    L24:
        this.f284280a = ContextCompat.getColor(getContext(), R.color.lkui_N100);
        this.f284285f = j08.b.e(getContext(), 14.0f);
        this.f284281b = ContextCompat.getColor(getContext(), R.color.lkui_N900);
        this.f284284e = j08.b.e(getContext(), 14.0f);
        this.f284282c = ContextCompat.getColor(getContext(), R.color.lkui_B500);
        this.f284283d = ContextCompat.getColor(getContext(), R.color.lkui_B500);
        this.f284288i = getResources().getString(R.string.Lark_Legacy_Search);
        this.f284300u = ContextCompat.getColor(getContext(), R.color.lkui_N100);
        if (AppCompatResources.getDrawable(getContext(), this.f284292m) == null) goto L27;
        int r121 = AppCompatResources.getDrawable(getContext(), this.f284292m).getIntrinsicWidth();
    L28:
        this.f284293n = r121;
        if (AppCompatResources.getDrawable(getContext(), this.f284292m) == null) goto L31;
        int r122 = AppCompatResources.getDrawable(getContext(), this.f284292m).getIntrinsicHeight();
    L32:
        this.f284294o = r122;
        if (AppCompatResources.getDrawable(getContext(), this.f284295p) == null) goto L35;
        int r123 = AppCompatResources.getDrawable(getContext(), this.f284295p).getIntrinsicHeight();
    L36:
        this.f284298s = r123;
        if (AppCompatResources.getDrawable(getContext(), this.f284295p) == null) goto L39;
        int r124 = AppCompatResources.getDrawable(getContext(), this.f284295p).getIntrinsicWidth();
    L40:
        this.f284297r = r124;
        goto L41
    L39:
        r124 = (int) j08.b.a(getContext(), 16.0f);
        goto L40
    L35:
        r123 = (int) j08.b.a(getContext(), 16.0f);
        goto L36
    L31:
        r122 = (int) j08.b.a(getContext(), 16.0f);
        goto L32
    L27:
        r121 = (int) j08.b.a(getContext(), 16.0f);
        goto L28
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        this.f284289j = r100;
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (this.f284291l == false) goto L10;
        if (this.f284305z.getVisibility() != 0) goto L10;
        this.f284305z.setVisibility(8);
        return;
    L10:
        if (TextUtils.isEmpty(r100) == true) goto L12;
        return;
    L12:
        if (this.f284296q == false) goto L17;
        this.f284305z.setVisibility(0);
        return;
    }
}
