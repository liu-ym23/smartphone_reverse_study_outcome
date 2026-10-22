package com.ss.android.lark.widget.richtext.media;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.e;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.mark.MarkView;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.f;

/* JADX INFO: loaded from: classes38.dex */
public class RichTextVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LKUIRoundedImageView f448328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f448329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MarkView f448330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f448331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f448332e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Image f448333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f448334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f448335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f448336d;

        public a(Image r100, String r101, String r102, long r103) {
            this.f448333a = r100;
            this.f448334b = r101;
            this.f448335c = r102;
            this.f448336d = r103;
        }
    }

    private int getMinImageWidth() {
        return UIHelper.dp2px(120.0f);
    }

    private int getMaxImageHeight() {
        return getMaxImageWidth();
    }

    private int getMaxImageWidth() {
        return (int) (((double) UIHelper.getWindowWidth(getContext())) * 0.6d);
    }

    private int getMinImageHeight() {
        return getMinImageWidth();
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_rich_text_media_view, this, true);
        View r100 = findViewById(R.id.media_content);
        this.f448331d = r100;
        this.f448328a = (LKUIRoundedImageView) r100.findViewById(R.id.media_cover);
        this.f448329b = (ImageView) this.f448331d.findViewById(R.id.media_media_play);
        this.f448330c = (MarkView) this.f448331d.findViewById(R.id.media_duration);
        this.f448332e = this.f448331d.findViewById(R.id.media_cover_foreground);
    }

    public RichTextVideoView(Context r100) {
        super(r100);
        b();
    }

    public final int[] a(Image r100) {
        if (r100 == null) goto L6;
        return ImageUtils.g(r100.getWidth(), r100.getHeight(), getMaxImageWidth(), getMaxImageHeight(), getMinImageWidth(), getMinImageHeight());
    L6:
        return new int[]{getMaxImageWidth(), getMaxImageHeight()};
    }

    public void setInfo(a r110) {
        Image r100 = r110.f448333a;
        int[] r101 = a(r100);
        Context r102 = getContext();
        int r103 = 0;
        int r104 = r101[0];
        int r105 = r101[1];
        int r106 = (int) this.f448328a.getCornerRadius();
        GradientDrawable r107 = new GradientDrawable();
        r107.setShape(0);
        r107.setCornerRadius(r106);
        r107.setColor(UIUtils.getColor(r102, R.color.lkui_N100));
        r107.setSize(r104, r105);
        Context r108 = getContext();
        int r109 = r101[0];
        int r111 = r101[1];
        int r112 = (int) this.f448328a.getCornerRadius();
        GradientDrawable r113 = new GradientDrawable();
        r113.setShape(0);
        r113.setCornerRadius(r112);
        r113.setColor(UIUtils.getColor(r108, R.color.lkui_N200));
        r113.setSize(r109, r111);
        String r114 = "";
        if (r100 != null) goto L5;
        String r115 = "";
    L7:
        if (TextUtils.isEmpty(r115) == true) goto L15;
        f r116 = f.a();
        int r117 = r101[0];
        int r118 = r101[1];
        LKUIRoundedImageView r119 = this.f448328a;
        r116.getClass();
        if (r100 != null) goto L11;
    L24:
        this.f448330c.setText(e.f((int) r110.f448336d));
        boolean r120 = !TextUtils.isEmpty(r110.f448335c);
        ImageView r121 = this.f448329b;
        if (r120 == false) goto L27;
        int r122 = 0;
    L28:
        r121.setVisibility(r122);
        View r123 = this.f448332e;
        if (r120 == false) goto L31;
        r103 = 8;
    L31:
        r123.setVisibility(r103);
        return;
    L27:
        r122 = 8;
        goto L28
    L11:
        if (TextUtils.isEmpty(r100.getKey()) == true) goto L24;
        ImageLoader.with(r119.getContext()).load(new EncryptImage(r100.getKey(), r100.getFsUnit(), r100.getCrypto())).centerCrop().dontAnimate(false).override(r117, r118).placeholder(r107).error(r113).into(r119);
        goto L24
    L15:
        if (TextUtils.isEmpty(r110.f448334b) == true) goto L18;
        r114 = r110.f448334b;
    L21:
        if (TextUtils.isEmpty(r114) == true) goto L23;
        ImageLoader.with(getContext()).load(r110.f448334b).placeholder(r107).error(r113).into(this.f448328a);
        goto L24
    L23:
        this.f448328a.setImageDrawable(r107);
        goto L24
    L18:
        if (TextUtils.isEmpty(r110.f448335c) == true) goto L21;
        r114 = r110.f448335c;
        goto L21
    L5:
        r115 = r100.getKey();
        goto L7
    }

    public RichTextVideoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        b();
    }

    public RichTextVideoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        b();
    }
}
