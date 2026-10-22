package com.ss.android.lark.widget.popwindow;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.framework.ui.BasePopupWindow;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: classes38.dex */
public final class EmojiPreviewPopWindow extends BasePopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f447977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f447978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f447979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f447980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f447981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f447982g;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
        public static final int CENTER = 1;
        public static final int LEFT = 0;
        public static final int RIGHT = 2;
    }

    public interface a {
        void a(Context r100, int r101, int r102, String r103, ImageView r104, String r105);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f447983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f447984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f447985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f447986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f447987e;

        public b(View r100, String r101) {
            this.f447983a = r100;
            this.f447984b = r101;
        }
    }

    public EmojiPreviewPopWindow(Context r100) {
        super(r100);
        this.f447977b = r100;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.kb_emoji_layout_preview, null);
        this.f447978c = r101;
        this.f447979d = r101.findViewById(R.id.preview_bg_ll);
        ImageView r102 = (ImageView) this.f447978c.findViewById(R.id.preview_iv_normal);
        GifImageView r103 = (GifImageView) this.f447978c.findViewById(R.id.preview_iv);
        Log.i("EmojiPreviewPopWindow", "remove gifImageView enable = true");
        this.f447980e = r102;
        r103.setVisibility(8);
        r102.setVisibility(0);
        this.f447981f = (TextView) this.f447978c.findViewById(R.id.content_tv);
        setContentView(this.f447978c);
        setWidth(-2);
        setHeight(-2);
        this.f447978c.setFocusable(true);
        this.f447978c.setFocusableInTouchMode(true);
        setInputMethodMode(1);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        DesktopUtil.a(this.f447977b);
    }

    public final void b(b r110) {
        View r100 = r110.f447983a;
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = r110.f447987e;
        if (TextUtils.isEmpty(r101) == false) goto L8;
        this.f447981f.setVisibility(8);
    L9:
        int r102 = r110.f447986d;
        if (r102 != 0) goto L12;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
        this.f447979d.setBackgroundResource(R.drawable.left_emoji_preview_bg);
        this.f447978c.setPadding(this.f447977b.getResources().getDimensionPixelSize(R.dimen.dp_7), 0, 0, 0);
    L22:
        this.f447979d.setBackgroundTintList(ColorStateList.valueOf(this.f447977b.getResources().getColor(R.color.bg_float)));
        String r111 = r110.f447984b;
        String r112 = r110.f447985c;
        int[] r104 = new int[2];
        DesktopUtil.a(this.f447977b);
        r100.getLocationOnScreen(r104);
        DesktopUtil.a(this.f447977b);
        DesktopUtil.a(this.f447977b);
        a r105 = this.f447982g;
        Context r113 = this.f447977b;
        r105.a(r113, UIUtils.dp2px(r113, 110), UIUtils.dp2px(this.f447977b, 110), r111, this.f447980e, r112);
        this.f447978c.measure(0, 0);
        DesktopUtil.a(this.f447977b);
        int r106 = (r104[0] + (r100.getWidth() / 2)) - (this.f447978c.getMeasuredWidth() / 2);
        int r114 = (r104[1] - this.f447978c.getMeasuredHeight()) + UIUtils.dp2px(this.f447977b, 4.0f);
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L26;
        return;
    L26:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L28;
        showAtLocation(r100, 0, r106, r114);
        return;
    L28:
        OverlaySource r115 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r100, r115, 0, r106, r114) == true) goto L35;
        showAtLocation(r100, 0, r106, r114);
        PopupWindowLancet.trackAfterShow(this, r115, r100);
        return;
    L35:
        return;
    L16:
        if (r102 != 2) goto L18;
        boolean r107 = true;
    L19:
        if (r107 == false) goto L21;
        this.f447979d.setBackgroundResource(R.drawable.right_emoji_preview_bg);
        this.f447978c.setPadding(0, 0, this.f447977b.getResources().getDimensionPixelSize(R.dimen.dp_7), 0);
        goto L22
    L21:
        this.f447979d.setBackgroundResource(R.drawable.center_emoji_preview_bg);
        this.f447978c.setPadding(0, 0, 0, 0);
        goto L22
    L18:
        r107 = false;
        goto L19
    L12:
        r103 = false;
        goto L14
    L8:
        this.f447981f.setVisibility(0);
        this.f447981f.setText(r101);
        goto L9
    }
}
