package com.larus.office.base.plugins.toolbar.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes29.dex */
public class RectColorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f360934a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RectColorType {
        public static final String TYPE_BACKGROUND = "background";
        public static final String TYPE_CLEAR = "clear";
        public static final String TYPE_TEXT = "text";
    }

    public RectColorView(Context r100) {
        this(r100, null);
    }

    public RectColorView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public RectColorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_rect_color_view, this);
        this.f360934a = (FrameLayout) findViewById(R.id.rect_layout);
        ImageView r103 = (ImageView) findViewById(R.id.text);
    }
}
